<%@page import="com.base.constant.Constant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	/* Constant.RESROURSEPATH="http://192.168.0.15:8080/teststatic/assets/"; */
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
<link href="<%=Constant.RESROURSEPATH%>css/plugins/plugins.css" rel="stylesheet" type="text/css"/> 
<link href="<%=Constant.RESROURSEPATH%>css/plugins/style.min.css" rel="stylesheet" type="text/css"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/datepicker.css" rel="stylesheet" type="text/css">
<link href="<%=Constant.RESROURSEPATH%>css/plugins/footable.bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=Constant.RESROURSEPATH%>css/plugins/uploadfile/blueimp-gallery.min.css" rel="stylesheet"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/uploadfile/jquery.fileupload.css" rel="stylesheet"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/uploadfile/jquery.fileupload-ui.css" rel="stylesheet"/>
<link href="<%=Constant.RESROURSEPATH%>css/plugins/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
<link href="<%=Constant.RESROURSEPATH%>js/plugins/lightbox/lightbox.css" rel="stylesheet" type="text/css"  />
<link href="<%=Constant.RESROURSEPATH%>css/common.css" rel="stylesheet"/>
<style>
body{background-color:#f0f1f2;margin:30px 40px !important;}
.page-content{background:none;}
</style>

<script src="<%=Constant.RESROURSEPATH%>js/plugins/jquery.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/location.js"></script>
