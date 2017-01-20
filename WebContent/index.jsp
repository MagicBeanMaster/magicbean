<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>金鼎海居</title>
		<%@include file="/state/common/headMain.jsp"%>
    </head>
    <body class="login" style="margin: 0 auto;text-align: center;background: #d2e9ff;">
        <div class="log-content" style="margin: 0 auto;text-align: center;width: 400px;">
             <form id="loginform" class="login-form" action="<%=basePath%>login/toLogin.php" method="post">
                <h3 class="form-title">
                	<img alt="金鼎海居" src="<%=Constant.RESROURSEPATH%>images/logo1.png"> 
                </h3>
                <div id="mess" class="alert alert-danger display-hide">
                    <button type="button" class="close" data-close="alert"></button>
                    <span id="tip">请填写正确的账号与密码</span>
                </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">用户名</label>
                    <input class="form-control form-control-solid placeholder-no-fix" id="account" type="text" autocomplete="off" placeholder="输入用户名" name="account" value=""/>
                </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">密码</label>
                    <input class="form-control form-control-solid placeholder-no-fix" id="pwd" type="password" autocomplete="off" placeholder="密码" name="pwd" value=""/>
                </div>
                <div class="form-actions">
                    <input type="button" id="btnlogin" class="btn blue" onclick="doLogin()" value="登录" >
                </div>
                <%-- <a href="<%=Constant.basePath%>index/test.php">BC测试消息发送</a> --%>
            </form>
        </div>
    
<jsp:include  page="/state/common/footerMain.jsp"/>
     <script type="text/javascript">
    	if(window.top!==window.self){//存在父页面
    		parent.window.location.href = window.location.href;
    	}
    	
    </script>
    <script type="text/javascript">
      	$(document).ready(function(){
      		delCookie('JSESSIONID');
      		delCookie('sid');
      		$("#account").bind('keydown', function (e) {
      			var key = e.which;
      	        if (key == 13) {
      	        	var p=$("#pwd").val();
      	            e.preventDefault();
      	            if(p=='' || p=='undefined' || p.length<1){
	      	            $("#pwd").focus();
      	            }else{
      	            	doLogin();
      	            }
      	        }
      		});
      		$("#pwd").bind('keydown', function (e) {
      			    var key = e.which;
      	        if (key == 13) {
      	        	var a=$("#account").val();
      	            e.preventDefault();
      	            if(a=='' || a=='undefined' || a.length<1){
      	            	$("#account").focus();
      	            }else{
      	          		doLogin();
      	            }
      	        }
      		});
      		
      	});
        //登录
        function doLogin(){
        	$("#btnlogin").attr("disabled","disabled");
        	var a=$("#account").val();
        	var p=$("#pwd").val();
        	if(a=='' || a=='undefined'){
        		$("#tip").text("请输入账号");
        		$("#mess").show();
        		return;
        	}
        	if(p=='' || p=='undefined'){
        		$("#tip").text("请输入密码");
        		$("#mess").show();
        		return;
        	}
        	$.ajax({
       		   type: "POST",
       		   url: "<%=basePath%>plat/account/tologin.php",
       		   data: $("#loginform").serialize(),
       		   dataType:'json',
       		   success: function(datas){
       				$("#btnlogin").removeAttr("disabled");
	       			if(datas.flag==1){
						window.location.href='<%=basePath%>plat/account/tomain.php';
						<%-- window.location.href='<%=basePath%>main.jsp'; --%>
					}else{
						$("#tip").text("请填写正确的账号与密码");
						$("#mess").show();
					}
       		   },
       		   error:function(e){
       				AlertFun("登录异常",function(){});
       				$("#btnlogin").removeAttr("disabled");
       		   }
       		});
        }
        
    	function delCookie (NameOfCookie){
    	 	// 该函数检查下cookie是否设置，如果设置了则将过期时间调到过去的时间;
    		//剩下就交给操作系统适当时间清理cookie啦
    		document.cookie = NameOfCookie + "=" + "; expires=Thu, 01-Jan-70 00:00:01 GMT";
    		
    	}
    </script>
    </body>
</html>
