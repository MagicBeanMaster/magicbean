<%@page import="com.base.constant.Constant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">        
<link rel="shortcut icon" href="<%=Constant.RESROURSEPATH%>images/favicon.ico">
<!-- font -->
<link href="<%=Constant.RESROURSEPATH%>css/plugins/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/simple-line-icons.min.css" rel="stylesheet" type="text/css"/> 
<!-- base -->
<link href="<%=Constant.RESROURSEPATH%>css/plugins/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/layout.css" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/plugins.css" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/style.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/common.css" rel="stylesheet"/>

