
// 只能输入中文
jQuery.validator.addMethod("isChineseCode", function(value, element) {   
    var reg=/^[\u0391-\uFFE5]+$/;    
    return this.optional(element) || (reg.test(value));
}, "只能输入中文");

//只能输入中英文
jQuery.validator.addMethod("isChEhCode", function(value, element) {   
    var reg=/^[\u0391-\uFFE5a-zA-Z]+$/;    
    return this.optional(element) || (reg.test(value));
}, "只能输入中文或英文");
//只能输入字母
jQuery.validator.addMethod("isEhCode", function(value, element) {   
    var reg=/^[a-zA-Z]+$/;    
    return this.optional(element) || (reg.test(value));
}, "只能输入字母");

//输入正整数
jQuery.validator.addMethod("isIntNumber", function(value, element) { 
	var reg=/^\d*$/; 
    return this.optional(element) ||reg.test(value);       
}, "请输入正整数");


//输入整数或小数
jQuery.validator.addMethod("isNumber", function(value, element) {       
    return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
}, "请输入整数和小数"); 

// 邮政编码验证  
jQuery.validator.addMethod("isZipCode", function(value, element) {   
    var tel = /^[0-9]{6}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的邮政编码");

//url路径
jQuery.validator.addMethod("isUrl", function(value, element) { 
	var reg=/^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
    return this.optional(element) || reg.test(value);       
},"请输入正确的路径");

//path路径
jQuery.validator.addMethod("isPath", function(value, element) { 
	//var reg=/^[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	var reg=/^[A-Za-z0-9\._&\/?=]+$/;
    return this.optional(element) || reg.test(value);       
},"请输入正确的路径");