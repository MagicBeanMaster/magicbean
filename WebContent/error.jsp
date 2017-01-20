<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
        <link href="<%=Constant.RESROURSEPATH  %>fonts/font.css" rel="stylesheet" type="text/css"/>
        <link href="<%=Constant.RESROURSEPATH  %>css/plugins/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=Constant.RESROURSEPATH  %>css/plugins/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=Constant.RESROURSEPATH  %>css/common.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="page-error">
		<div class="container">
			<div class="row">
				<div class="col-xs-5 col-sm-6 col-md-6 text-right">
					<img src="<%=Constant.RESROURSEPATH %>images/error.png" />
				</div>
				<div class="col-xs-7 col-sm-6 col-md-6 text-left">
					<h3 class="title-500">500</h3>
					<p>请返回上一页重新尝试 <a href="javascript:history.back();" class="back">返回上一页</a></p>
				</div>
			</div>
		</div>

</body>
</html>
