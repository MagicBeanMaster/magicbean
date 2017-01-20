<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/pager.tld" prefix="page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.base.constant.Constant"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<%-- <%@include file="/state/common/headMain.jsp"%> --%>

<head>
  <meta charset="UTF-8">

  <title>客户管理系统更新 </title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<%=Constant.RESROURSEPATH%>css/index-style.css" media="screen" type="text/css" />
  <script src="<%=Constant.RESROURSEPATH%>js/plugins/jquery.min.js"></script>

</head>

<body>
	<!-- Contenedor -->

<div class="con_crm">
	<div class="con_bt">
		<h1>欢迎使用客户管理系统！</h1>
	</div>
	<ul id="accordion" class="accordion">
		<li>
			<c:forEach var="temp" items="${list }" varStatus="t">
			<div class="link">${temp.content }</div>
			<ul class="submenu">
				<li>
					<h4>【基础功能】</h4>
					<p><a href="#">${temp.likecontent }</a></p>
				</li>
			</ul>
			</c:forEach>
		</li>
	</ul>
</div>
  <script src="<%=basePath%>state/js/index.js"></script>

</body>
</html>