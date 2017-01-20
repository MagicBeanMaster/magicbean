<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>澳洲金鼎</title>
<%@include file="/state/common/head.jsp"%>
</head>
<style>
.silder-a{ line-height:25px;}
.silder-a i{}
</style>
<body class="page-header-fixed page-quick-sidebar-over-content " style="overflow:hidden;">
	<div class="page-header -i navbar navbar-fixed-top">
		<div class="page-header-inner">
			<div class="page-logo">
				<a href="#"><img src="<%=Constant.RESROURSEPATH%>images/aozhoulogo_03.png" alt="logo" class="logo-default"/></a>
				<div class="text-right">
					<span class="marginL-15" id="uaccount">用户：${businessUser.account}</span>
					<span class="marginL-15">角色&nbsp;:&nbsp;<span id="uroles">${businessUser.rolesname }</span></span>
					<%-- <c:if test="${flag==1 }">
						<span>用户：${businessUser.account }</span>
						<span>角色：管理员</span>
					</c:if> --%>
					<span  class="exit marginL-15"><a onclick="loginout()">安全退出</a></span>
				</div>
				<div class="menu-toggler sidebar-toggler"></div>
			</div>
			<a href="javascript:void(0);" class="menu-toggler responsive-toggler"
				data-toggle="collapse" data-target=".navbar-collapse"></a>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="page-container">
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar navbar-collapse collapse">
				 <div class="left-nav-title">
					<img src="<%=Constant.RESROURSEPATH%>images/left-nav-title.jpg"   width="51" height="52"/>
					<p style="margin-top:16px;"><span>客户管理系统</span></p>				
				</div>
				<!-- begin menu -->
				<ul class="page-sidebar-menu  " data-keep-expanded="false"
					data-auto-scroll="true" data-slide-speed="200"><!--  -->
					 <c:if test="${flag==1 }">
						<li><a class="silder-a" href="javascript:getPage('<%=basePath%>admin/account/tolist.php');"><i class="icon-user"></i><span class="title">用户列表</span></a></li>
						<li><a class="silder-a" href="javascript:getPage('<%=basePath%>plat/resource/tolist.php');"><i class="icon-columns"></i><span class="title">资源列表</span></a></li>
						<li><a class="silder-a" href="javascript:getPage('<%=basePath%>admin/roles/tolist.php');"><i class="icon-list-alt"></i><span class="title">角色列表</span></a></li>
						<li><a class="silder-a" href="javascript:getPage('<%=basePath%>admin/version/list.php');"><i class="icon-comment-alt"></i><span class="title">版本列表</span></a></li>
						<li><a class="silder-a" href="javascript:getPage('<%=basePath%>admin/error/list.php');"><i class="icon-columns"></i><span class="title">错误列表</span></a></li>
					 </c:if>
				
				
						
						
						<c:forEach var="m" items="${modelList }">
							<li >
							<a href="javascript:void(0)" class="silder-a"> 
							    <c:if test="${not empty m.icon }">
										<img class="silder-icon-img" src="<%=Constant.PICTUREPATH %>${m.icon}" width="24"> 
								</c:if>
								<c:if test="${ empty m.icon }">
										<img class="silder-icon-img" src="" width="24"> 
								</c:if>
								<span class="title">${m.menuname }</span>
							</a>
								<ul class="sub-menu">
									<c:forEach var="t" items="${menuList }">
										<c:if test="${m.id==t.parentid }">
											<li>
											<c:if test="${not empty t.icon }">
												<img src="<%=Constant.PICTUREPATH %>${t.icon}" width="24">
											</c:if>
											<a href="javascript:getPage('<%=basePath%>${t.path }');">${t.menuname }</a>
											</li>
										</c:if>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
				
				
				</ul>
				<!-- END  MENU -->
			</div>
		</div>
		<div class="page-content-wrapper fade-in-up">
			<div class="page-content">
				<!-- content -->
<%-- 				<iframe id="rightpage" src="<%=basePath%>main.jsp" frameborder="0" scrolling="yes" --%>
				<iframe id="rightpage" src="<%=basePath%>plat/login/showlist.php" frameborder="0" scrolling="yes"
					width="100%" height="100%" name="rightpage"></iframe>
					
			</div>
		</div>
	</div>
	

<jsp:include  page="/state/common/footer.jsp"/>	
<script type="text/javascript">
	var rightpage = $("#rightpage");
	rightpage.height($(window).height()-$(".navbar-fixed-top").height()-10);
	$(window).resize(function(){
		rightpage.height($(window).height()-$(".navbar-fixed-top").height()-10);

	});
	$(".page-content").addClass("welcome_bg");
</script> 
	<script type="text/javascript">
	 $(document).ready(function() {
	      Metronic.init();
	      Layout.init();
	    });
		function getPage(url) {
			$("#rightpage").attr("src", url);
		}
		//menu
		$(".sub-menu>li").on("click",function(){
			$(".sub-menu").parent().removeClass("active open");
			$(".sub-menu>li").removeClass("active");
			$(this).addClass("active").parent().parent().addClass("active open ");
		});
		function getPage(url,flagBg) {
			$("#rightpage").attr("src", url);
			if(flagBg){
				$(".page-content").addClass("welcome_bg");
			}else{
				$(".page-content").removeClass("welcome_bg");
			}
			
		}
		
		function loginout(){
		    window.location.href="<%=basePath %>plat/login/loginout.php"
		}
		
		
	</script>
</body>
</html>

