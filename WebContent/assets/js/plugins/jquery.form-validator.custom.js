/*
 * Validate email
 */
$.formUtils.addValidator({
    name: 'email',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(value);
    },
    errorMessage: '邮箱地址格式错误'
});

/*
 * Validate mobile
 */
$.formUtils.addValidator({
    name: 'mobile',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^0?(13|15|18)[0-9]{9}$/).test(value);
    },
    errorMessage: '手机号码格式错误'
});

/*
 * Validate telephone
 */
$.formUtils.addValidator({
    name: 'telephone',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/).test(value);
    },
    errorMessage: '电话号码格式错误'
});

/*
 * Validate idcard
 */
$.formUtils.addValidator({
    name: 'idcard',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^[1-9]([0-9]{14}|[0-9]{17})$/).test(value);
    },
    errorMessage: '身份证号格式错误'
});

/*
 * Validate bankcard
 */
$.formUtils.addValidator({
    name: 'bankcard',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^(\d{16}|\d{19})$/).test(value);
    },
    errorMessage: '银行卡号格式错误'
});

/*
 * Validate money
 */
$.formUtils.addValidator({
    name: 'money',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^(-)?(([1-9]{1}\d*)|([0]{1}))(\.(\d){2})?$/).test(value);
    },
    errorMessage: '金额格式错误'
});

/*
 * Validate longitudelatitude
 */
$.formUtils.addValidator({
    name: 'longitudelatitude',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^[+-]?\d*.\d{6},[+-]?\d*.\d{6}$/).test(value);
    },
    errorMessage: '经纬度格式错误'
});

/*
 * Validate url
 */
$.formUtils.addValidator({
    name: 'url',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^http[s]?:\/\/([\w-]+\.)+[\w-]+([\w-./?%&=]*)?$/).test(value);
    },
    errorMessage: 'URL格式错误'
});

/*
 * Validate number
 */
$.formUtils.addValidator({
    name: 'number',
    validatorFunction: function(val, $el, conf, language, $form) {
        if (val !== '') {
            var allowing = $el.valAttr('allowing') || '',
                decimalSeparator = $el.valAttr('decimal-separator') || conf.decimalSeparator,
                allowsRange = false,
                begin, end,
                steps = $el.valAttr('step') || '',
                allowsSteps = false;

            if (allowing.indexOf('number') == -1)
                allowing += ',number';

            if (allowing.indexOf('negative') == -1 && val.indexOf('-') === 0) {
                this.errorMessage = '不能为负数';
                return false;
            }

            if (allowing.indexOf('range') > -1) {
                begin = parseFloat(allowing.substring(allowing.indexOf("[") + 1, allowing.indexOf(";")));
                end = parseFloat(allowing.substring(allowing.indexOf(";") + 1, allowing.indexOf("]")));
                allowsRange = true;
            }

            if (steps != "")
                allowsSteps = true;

            if (decimalSeparator == ',') {
                if (val.indexOf('.') > -1) {
                    return false;
                }
                // Fix for checking range with floats using ,
                val = val.replace(',', '.');
            }

            if (allowing.indexOf('float') > -1) {

                if (!((/^[+-]?\d+\.\d*$/).test(val))) {
                    this.errorMessage = '请输入浮点数';
                    return false;
                }

                if (allowsRange) {
                    if (val < begin) {
                        this.errorMessage = '不能小于 ' + begin;
                        return false;
                    }
                    if (val > end) {
                        this.errorMessage = '不能大于 ' + end;
                        return false;
                    }
                }

                return true;

            }

            if (allowing.indexOf('number') > -1) {

                if (val.replace(/[0-9-]/g, '') !== '') {
                    this.errorMessage = '请输入整数';
                    return false;
                }

                if (allowsRange) {
                    if (val < begin) {
                        this.errorMessage = '不能小于 ' + begin;
                        return false;
                    }
                    if (val > end) {
                        this.errorMessage = '不能大于 ' + end;
                        return false;
                    }
                }

                return true;

            }
        }
        this.errorMessage = '请输入数字';
        return false;
    },
    errorMessage: '请输入数字'
});

/*
 * Validate length
 */
$.formUtils.addValidator({
    name: 'length',
    validatorFunction: function(val, $el, conf, lang) {
        var lengthAllowed = $el.valAttr('length'),
            type = $el.attr('type');

        if (lengthAllowed == undefined) {
            alert('Please add attribute "data-validation-length" to ' + $el[0].nodeName + ' named ' + $el.attr('name'));
            return true;
        }

        // check if length is above min, below max or within range.
        var len = type == 'file' && $el.get(0).files !== undefined ? $el.get(0).files.length : val.length,
            lengthCheckResults = $.formUtils.numericRangeCheck(len, lengthAllowed),
            checkResult;

        switch (lengthCheckResults[0]) { // outside of allowed range
            case "out":
                this.errorMessage = '只能' + lengthAllowed + '个字符';
                checkResult = false;
                break;
                // too short
            case "min":
                this.errorMessage = '不能小于' + lengthCheckResults[1] + '个字符';
                checkResult = false;
                break;
                // too long
            case "max":
                this.errorMessage = '不能大于' + lengthCheckResults[1] + '个字符';
                checkResult = false;
                break;
                // ok
            default:
                checkResult = true;
        }

        return checkResult;
    },
    errorMessage: '',
    errorMessageKey: ''
});

/*
 * Validate date
 */
$.formUtils.addValidator({
    name: 'date',
    validatorFunction: function(date, $el, conf) {
        var dateFormat = $el.valAttr('format') || conf.dateFormat || 'yyyy-mm-dd';
        return $.formUtils.parseDate(date, dateFormat) !== false;
    },
    errorMessage: '日期格式错误'
});

/*
 * Validate letter
 */
$.formUtils.addValidator({
    name: 'letter',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^[A-Za-z]+$/).test(value);
    },
    errorMessage: '请输入英文字符'
});

/*
 * Validate chinese
 */
$.formUtils.addValidator({
    name: 'chinese',
    validatorFunction: function(value, $el, config, language, $form) {
        return (/^[\u4e00-\u9fa5]+$/).test(value);
    },
    errorMessage: '请输入中文'
});

/*
 * Validate alpha numeric
 */
$.formUtils.addValidator({
    name: 'alphanumeric',
    validatorFunction: function(val, $el, conf, language) {
        var patternStart = '^([a-zA-Z0-9',
            patternEnd = ']+)$',
            additionalChars = $el.valAttr('allowing'),
            pattern = '';

        if (additionalChars) {
            pattern = patternStart + additionalChars + patternEnd;
            var extra = additionalChars.replace(/\\/g, '');
            if (extra.indexOf(' ') > -1) {
                extra = extra.replace(' ', '');
                extra += language.andSpaces || $.formUtils.LANG.andSpaces;
            }
            this.errorMessage = '只能包含字母数字' + '和' + extra;
        } else {
            pattern = patternStart + patternEnd;
            this.errorMessage = '只能包含字母数字';
        }

        return new RegExp(pattern).test(val);
    },
    errorMessage: '只能包含字母数字'
});

/*
 * Validate group of checkboxes, validate qty required is checked
 * written by Steve Wasiura : http://stevewasiura.waztech.com
 * element attrs
 *    data-validation="checkbox_group"
 *    data-validation-qty="1-2"  // min 1 max 2
 *    data-validation-error-msg="chose min 1, max of 2 checkboxes"
 */
$.formUtils.addValidator({
    name: 'checkbox_group',
    validatorFunction: function(val, $el, conf, lang, $form) {
        // preset return var
        var isValid = true,
            // get name of element. since it is a checkbox group, all checkboxes will have same name
            elname = $el.attr('name'),
            // get checkboxes and count the checked ones
            $checkBoxes = $("input[type=checkbox][name^='" + elname + "']", $form),
            checkedCount = $checkBoxes.filter(':checked').length,
            // get el attr that specs qty required / allowed
            qtyAllowed = $el.valAttr('qty');

        if (qtyAllowed == undefined) {
            var elementType = $el.get(0).nodeName;
            alert('Attribute "data-validation-qty" is missing from ' + elementType + ' named ' + $el.attr('name'));
        }

        // call Utility function to check if count is above min, below max, within range etc.
        var qtyCheckResults = $.formUtils.numericRangeCheck(checkedCount, qtyAllowed);

        // results will be array, [0]=result str, [1]=qty int
        switch (qtyCheckResults[0]) {
            // outside allowed range
            case "out":
                this.errorMessage = '只能选择' + qtyAllowed + '个';
                isValid = false;
                break;
                // below min qty
            case "min":
                this.errorMessage = '至少选择' + qtyCheckResults[1] + '个';
                isValid = false;
                break;
                // above max qty
            case "max":
                this.errorMessage = '至多选择' + qtyCheckResults[1] + '个';
                isValid = false;
                break;
                // ok
            default:
                isValid = true;
        }

        if (!isValid) {
            var _triggerOnBlur = function() {
                $checkBoxes.unbind('click', _triggerOnBlur);
                $checkBoxes.filter('*[data-validation]').validateInputOnBlur(lang, conf, false, 'blur');
            };
            $checkBoxes.bind('click', _triggerOnBlur);
        }

        return isValid;
    }

});

/*
 * Validate against regexp
 */
$.formUtils.addValidator({
    name: 'custom',
    validatorFunction: function(val, $el, conf) {
        var regexp = new RegExp($el.valAttr('regexp'));
        return regexp.test(val);
    },
    errorMessage: '自定义验证错误'
});

/*
 * Validate required
 */
$.formUtils.addValidator({
    name: 'required',
    validatorFunction: function(val, $el, config, language, $form) {
        switch ($el.attr('type')) {
            case 'checkbox':
                return $el.is(':checked');
            case 'radio':
                return $form.find('input[name="' + $el.attr('name') + '"]').filter(':checked').length > 0;
            default:
                return $.trim(val) !== '';
        }
    },
    errorMessage: '这是必填（必选）项'
});
