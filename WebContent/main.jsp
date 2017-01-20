<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>金鼎海居</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="<%=Constant.RESROURSEPATH %>images/favicon.ico">
    <link href="<%=Constant.RESROURSEPATH %>css/plugins/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=Constant.RESROURSEPATH %>css/common.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:set value="ACXS" var="t"></c:set>

	<div class="welcome_logo">
		<img class="logo" src="<%=Constant.RESROURSEPATH %>images/logo_lg.png" />
	</div>
</body>
</html>
