var Login = function() {
    var handleLogin = function() {
        $('.login-form').validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
            	account: {
                    required: true
                },
                pwd: {
                    required: true
                }
            },
            messages: {
            	account: {
                    required: "用户名必填"
                },
                pwd: {
                    required: "密码必填"
                }
            },
            invalidHandler: function(event, validator) {
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function(element) {
                $(element)
                    .closest('.form-group').addClass('has-error');
            },

            unhighlight: function (element) {
                $(element)
                    .closest('.form-group').removeClass('has-error');
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.appendTo(element.closest('.form-group'));
            },

            submitHandler: function(form) {
                $.ajax({
                    type: "POST",
                    url: $(form).attr("action"),
                    data:{
                        account:$("#account").val(),
                        pwd:$("#pwd").val()
                    },
                    success: function(data){
                        if(data){
                            location.href = $(form).attr("action");
                        }else{
                            $(".login-form .alert-danger").show().find("span").html("你填写的密码或账号错误");
                        }

                    },
                    error: function (error) {
                        alert("connection error");
                    }
                });
            }
        });
    };
    return {
        init: function() {
            handleLogin();
        }

    };

}();