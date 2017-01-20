var handleValidation = function ($form, rules, messages, callback){	
   /* var form1 = $form;*/
   /* var error1 = $('.alert-danger', form1);
    var success1 = $('.alert-success', form1);*/
 
    $form.validate({
		errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
		rules : rules,
		messages : messages,
		invalidHandler : function(event, validator) {
			/*$('.alert-danger', $('.form-horizontal')).show();*/
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		success : function(label) {
			label.closest('.form-group').removeClass('has-error');
			label.remove();
		},
		errorPlacement : function(error, element) {
			 if (element.parent(".input-group").size() > 0) {
                 error.insertAfter(element.parent(".input-group"));
             } else if (element.attr("data-error-container")) {
                 error.appendTo(element.attr("data-error-container"));
             } else if (element.parents('.radio-list').size() > 0) {
                 error.appendTo(element.parents('.radio-list').attr("data-error-container"));
             } else if (element.parents('.radio-inline').size() > 0) {
                 error.appendTo(element.parents('.radio-inline').attr("data-error-container"));
             } else if (element.parents('.checkbox-list').size() > 0) {
                 error.appendTo(element.parents('.checkbox-list').attr("data-error-container"));
             } else if (element.parents('.checkbox-inline').size() > 0) {
                 error.appendTo(element.parents('.checkbox-inline').attr("data-error-container"));
             } else {
                 error.insertAfter(element); // for other inputs, just perform default behavior
             }
		},
		submitHandler: function (form) {
			callback(form);
		}
	});
    
    //手机号码 验证
	jQuery.validator.addMethod("phone", function(value, element) {
		var length = value.length;
		var phone = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
		return this.optional(element) || (length == 11 && phone.test(value));
		}, "请正确填写您的手机号码");
	
	//身份证号码验证
	jQuery.validator.addMethod("card", function (value, element) {
        return this.optional(element) || card(value);
    }, "请正确输入您的身份证号码");
	
}

$.extend($.validator.messages, {
	required: "这是必填字段",
	remote: "请修正此字段",
	email: "请输入有效的电子邮件地址",
	url: "请输入有效的网址",
	date: "请输入有效的日期",
	dateISO: "请输入有效的日期 (YYYY-MM-DD)",
	number: "请输入有效的数字",
	digits: "只能输入整数",
	creditcard: "请输入有效的信用卡号码",
	equalTo: "你的输入不相同",
	extension: "请输入有效的后缀",
	maxlength: $.validator.format("最多可以输入 {0} 个字符"),
	minlength: $.validator.format("最少要输入 {0} 个字符"),
	rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
	range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
	max: $.validator.format("请输入不大于 {0} 的数值"),
	min: $.validator.format("请输入不小于 {0} 的数值")
});

	