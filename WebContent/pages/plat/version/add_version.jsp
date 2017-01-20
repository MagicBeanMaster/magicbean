<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>金鼎海居</title>
<%@include file="/state/common/headMain.jsp"%>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content">
<div class="page-content container-fluid">
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<h3 class="page-title">版本信息</h3>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><a href="<%=basePath%>admin/version/list.php">版本信息</a><i class="icon-angle-right"></i>编辑</li>
			</ul>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">
		<div class="portlet light bordered">
			<div class="portlet-body form">
				<form action="<%=basePath%>admin/version/saveorupdate.php"
					id="form_sample" class="form-horizontal"
					enctype="multipart/form-data" method="post">
					<div class="form-body">
						<div class="alert alert-danger display-hide">
							<button class="close" data-close="alert"></button>
							你提交的表单有错误，请检查!
						</div>
						<div class="alert alert-success display-hide">
							<button class="close" data-close="alert"></button>
							你的表单提交成功!
						</div>
						<input type="hidden" value="${ver.id }" name="id" id="id">
						<div class="form-group">
							<label class="control-label col-md-3">版本 <span
								class="required">* </span></label>
							<div class="col-md-4">
								<textarea rows="5" cols="60" maxlength="2500" name="content" id="content">${ver.content }</textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">更新内容
							<span class="required">* </span></label>
							<div class="col-md-4">
								<textarea rows="5" cols="60" maxlength="1500" name="likecontent" id="likecontent">${ver.likecontent }</textarea>
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
							<a href="javascript:history.go(-1);" class="btn modalCancel cancelBtn">取消</a>
								<button type="submit" class="btn confirmBtn">提交</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</div>
</div>

<jsp:include  page="/state/common/footerMain.jsp"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.form-horizontal').validate({
				errorElement : 'span',
				errorClass : 'help-block',
				focusInvalid : false,
				rules : {
					content:{
						required : true
					},
					
					likecontent:{
						required : true
					},
					
				},
				messages : {
					content:{
						required : "版本不能为空",
					},
					likecontent:{
						required : "更新内容不能为空",
					}
				},
				invalidHandler : function(event, validator) {
					$('.alert-danger', $('.form-horizontal')).show();
				},

				highlight : function(element) {
					$(element).closest('.form-group').addClass('has-error');
				},

				unhighlight : function(element) {
					$(element).closest('.form-group').removeClass('has-error');
				},

				success : function(label) {
					label.closest('.form-group').removeClass('has-error');
					label.remove();
				},
				errorPlacement : function(error, element) {
					error.appendTo(element.closest('.form-group'));
				}
			});
			
		});
		
</script>
</body>
</html>
