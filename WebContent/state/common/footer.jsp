<%@page import="com.base.constant.Constant"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--[if lt IE 9]>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/respond.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="<%=Constant.RESROURSEPATH%>js/plugins/jquery.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/bootstrap.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/metronic.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/layout.js"></script> 
<script src="<%=Constant.RESROURSEPATH%>js/common.js"></script>

