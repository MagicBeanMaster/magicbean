<%@page import="com.base.constant.Constant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--[if lt IE 9]>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/respond.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/excanvas.min.js"></script>
<![endif]-->


<script src="<%=Constant.RESROURSEPATH%>js/plugins/bootstrap.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/footable.min.js"></script>
<script>
$(function(){
	$(".footable").footable();
	if($(".date-picker").find(".icon-calendar").length){
		$(".date-picker").datepicker({
	 		autoclose:true,
	 		todayHighlight:true,
	 		todayBtn:"linked",
	 		clearBtn:true
	 	});
	}else{
		$(".date-picker input").datepicker({
	 		autoclose:true,
	 		todayHighlight:true,
	 		todayBtn:"linked",
	 		clearBtn:true
	 	});
	}
});
</script>	
<script src="<%=Constant.RESROURSEPATH%>js/plugins/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=Constant.RESROURSEPATH %>js/plugins/bootstrap-datepicker.js"></script>
<script src="<%=Constant.RESROURSEPATH %>js/plugins/bootstrap-datepicker-zn.js"></script>
<script src="<%=Constant.RESROURSEPATH %>js/plugins/bootstrap-datetimepicker.min.js">	</script>
<script src="<%=Constant.RESROURSEPATH %>js/plugins/bootstrap-datetimepicker.zh-CN.js"></script>
 <script src="<%=Constant.RESROURSEPATH %>js/plugins/ajaxfileupload.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/common.js"></script>
<script type="text/javascript">
var _basePath='<%=basePath %>';
</script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/jstree.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/vendor/jquery.ui.widget.js"></script> 
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/vendor/tmpl.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/vendor/load-image.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/vendor/canvas-to-blob.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.blueimp-gallery.min.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.iframe-transport.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.fileupload.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.fileupload-process.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.fileupload-image.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.fileupload-validate.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/uploadfile/jquery.fileupload-ui.js"></script>
<script src="<%=basePath%>state/js/checkidcardno.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/commonAjax.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/webuploader/webuploader.js"></script>
<script src="<%=Constant.RESROURSEPATH%>js/plugins/lightbox/jquery.lightbox.js"></script>

