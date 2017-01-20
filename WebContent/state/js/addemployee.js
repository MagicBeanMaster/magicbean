var handleValidation = function (){
    
	
	//手机号码 验证
	jQuery.validator.addMethod("isMobile", function(value, element) {
	    var length = value.length;
	    var mobile = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
//	    var mobile = new RegExp("^[0-9]*$");
	    return this.optional(element) || (length <= 11 && mobile.test(value));
	    }, "请正确填写您的手机号码");

	/**
	 * 账号验证
	 */
	jQuery.validator.addMethod("isAccount", function(value, element) {
		var reg = /^([a-zA-Z0-9]+)$/;
		return this.optional(element) || (reg.test(value));
		}, "账号只能包含数字或字母"); 
	/**
	 * 邮箱 验证
	 */
	jQuery.validator.addMethod("isEmail", function(value, element) {
		var length = value.length;
		var reg =  /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
		return this.optional(element) || (reg.test(value));
		}, "请正确填写您的邮箱地址"); 

	
    var form1 = $('#saveEmpFrom');
    var error1 = $('.alert-danger', form1);
    var success1 = $('.alert-success', form1);
    
$('.form-horizontal').validate({
          errorElement: 'span', //default input error message container
          errorClass: 'help-block help-block-error', // default input error message class
          focusInvalid: false, // do not focus the last invalid input
          ignore: "",  // validate all fields including form hidden input
        rules : {
        	name : {
				required : true
			},
			sex : {
				required : true
			},
			job : {
				required : true
			},
			phone : {
				required : true,
				isMobile : true,
				remote  : {
					url:_basePath+"admin/account/checkonly.php",
					type:"post",
					dataType:"json",
					async:true,
					data:{
						phone:function(){return $("#phone").val();},
						id:function(){
							var id = $("#id").val();
							if(id == null || id==""){
								id = 0;
							}
							return id;
						},
					},
					dataFilter:function(data,type){
						data = JSON.parse(data);
						if(data.code == 1){
							return true;
						}else{
							return false;
						}
					}
				}
			},
			account : {
				required : true,
				isAccount : true,
				remote : {
					url:_basePath+"admin/account/checkAccount.php",
					type:"post",
					dataType:"json",
					async:true,
					data:{
						account:function(){return $("#account").val().trim();},
						id:function(){
							var id = $("#id").val();
							if(id == null || id==""){
								id = 0;
							}
							return id;
						},
					},
					dataFilter:function(data,type){
						data = JSON.parse(data);
						if(data.code == 1){
							return true;
						}else{
							return false;
						}
					}
				},
				maxlength : 20
			},
			password : {
				rangelength: [6, 20]
			},
			email : {
				isEmail : true
			}
        },
        messages : {
        	name : {
				required : "员工姓名不能为空"
			},
			sex : {
				required : "性别不能为空"
			},
			job : {
				required : "岗位不能为空"
			},
			phone : {
				required : "联系电话不能为空",
				remote : "联系电话已经被使用过了"
			},
			account : {
				required : "账号不能为空",
				remote : "账号已经被使用过了",
				maxlength: "账号长度需在20位以下"
			},
			password : {
				rangelength: "请输入长度为6-20位的密码",
			},
			email : {
				isEmail : "请输入正确的邮箱地址"
			}
        },
        invalidHandler : function(event, validator) {
            $('.alert-danger', $('.form-horizontal')).show();
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
        
            var phoneLength= $("#phone").val().length;
        	var id =$("#id").val();
			var empcode =$("#empcode").val();
			var name =$("#name").val();
//			var sex =$("#sex").val();
			var sex = $("input[name='sex']:checked").val();
			var age =$("#age").val();
			var job =$("#job").val();
			var phone =$("#phone").val();
			var email =$("#email").val();
			var level =$("#level").val();

			
			var account =$("#account").val();
			var password =$("#password").val();
			if((id==null||id=='')&&(password==null||password=='')){
				 $("#passwordFlag").html('密码不能为空')		
				 return;
		    }
        	
            if(phoneLength<=11){
            	//按钮禁用
//            	 $(".confirmBtn ").button("loading");
  				
            	 ajaxSubmit(_basePath+"admin/account/editOrUpdate.php" ,
            			 {'account':account,'password':password,'id':id,'empcode':empcode,'name':name,'sex':sex,'age':age,'job':job,'phone':phone,'email':email,'level':level},
                        function (data){
	                        var code = data.code;
	                        if(code == 1){
	                        	window.parent.window.AlertFun("保存成功",function(flag){
	                        		window.location.href = _basePath+"admin/account/tolist.php";
	                        	});
	                        }else if(code == -2){
	                        	window.parent.window.AlertFun("验证员工账号",function(flag){});
	                        }else if(code == -66){
	                        	window.parent.window.AlertFun("验证手机号",function(flag){});
	                        }
	                        else{
	                        	window.parent.window.AlertFun("保存失败，请联系管理员",function(flag){});
	                        }
                    });
            	 
            	 
            }else{
                return;
            }
        }
    });
}
    
