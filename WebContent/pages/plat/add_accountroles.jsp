<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>

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
		<h3 class="page-title">分配角色</h3>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><a href="<%=basePath%>admin/account/tolist.php">账号管理</a><i class="icon-angle-right"></i>编辑</li>
			</ul>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="col-xs-12 col-sm-12 col-md-6">
				<div class="box row page-sub-section">
						<div class="box-content clearfix">
								<h4 class="page-title">员工信息</h4>
						</div>
										
										<div class="form-group col-md-12" >
											<label class="control-label col-md-2">编号</label>
											<div class="col-md-4">
												${emp.empcode }
											</div>
										</div>
										<div class="form-group col-md-12">
											<label class="control-label col-md-2">姓名</label>
											<div class="col-md-4">
												${emp.name }
											</div>
										</div>
										
										<div class="form-group col-md-12">
											<label class="control-label col-md-2">联系电话</label>
											<div class="col-md-4">
												${emp.phone }
											</div>
										</div>
										<div class="form-group col-md-12">
											<label class="control-label col-md-2">电子邮箱</label>
											<div class="col-md-4">
											${emp.email }
											</div>
										</div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-12 col-md-6">
		<div class="portlet light bordered">
			<div class="box-content clearfix">
				<h4 class="page-title">角色列表</h4>
			</div>
			<div class="portlet-body form">
				<form action="<%=basePath%>admin/account/tosaveAccountroles.php" class="form-horizontal" id="form_sample" method="post">
					<input type="hidden" name="id" id="id" value="${id }" />
					<div class="form-body">
						<c:if test="${not empty roleslist }">
						<c:forEach var="t" items="${roleslist }">
							<c:if test="${rolesid==t.id }"><input type="radio" name="rolesid" value="${t.id }" checked="checked">${t.rolesname }</c:if>
							<c:if test="${rolesid!=t.id }"><input type="radio" name="rolesid" value="${t.id }">${t.rolesname }</c:if>
							
						</c:forEach>
						</c:if>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-offset-3 col-md-9">
								<a href="javascript:history.go(-1);" class="btn modalCancel cancelBtn">取消</a>
								<a href="javascript:void(0);" onclick="doSub()" class="btn confirmBtn">提交</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		</div>
	</div>
</div>

<jsp:include  page="/state/common/footerMain.jsp"/>
<script type="text/javascript">
	function doSub(){
		
		ajaxSubmit("<%=basePath%>admin/account/tosaveAccountroles.php", $('#form_sample').serialize(), 
				function (data){
				   	if(data>0){
	            		window.parent.window.AlertFun("保存成功",function(){
	             				window.location.href ="<%=basePath%>admin/account/tolist.php";
	             		});
	             	}else{
	             		window.parent.window.AlertFun("保存失败",function(){});
	            	}
			});
		
// 		$("#form_sample").submit();
	}
</script>
</body>
</html>
