<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>金鼎海居</title>
<%@include file="/state/common/headMain.jsp"%>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content ">

	<div class="page-content container-fluid">
	
		<div class="row page-header-title">
			<div class="row">
				<c:if test="${empty emp }">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<h3 class="page-title">员工新增</h3>
					</div>
				</c:if>
				<c:if test="${not empty emp }">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<h3 class="page-title">员工编辑</h3>
					</div>
				</c:if>
			</div>
		</div>
		
		<div class="row page-section2">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<div class="portlet">
					<div class="portlet-body form">
						<form id="saveEmpFrom" class="form-horizontal" method="post">
							
							<div class="alert alert-danger display-hide">
								<button class="close" data-close="alert"></button>
								你提交的表单有错误，请检查!
							</div>
							
							<!-- 基本信息 -->
							<div class="box row page-sub-section">
								<div class="box-content clearfix">
									<h4 class="page-title">基本信息</h4>
								</div>
								<div class="box-content">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<input type="hidden" value="${emp.id }" name="id" id="id">
										<div class="form-group">
											<label class="control-label col-md-3">编号</label>
											<div class="col-md-8">
												<input type="text" value="${emp.empcode }" name="empcode" id="empcode" maxlength="16" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3"><span class="required">* </span>姓名</label>
											<div class="col-md-8">
												<input type="text" value="${emp.name }" name="name" id="name" maxlength="16" class="form-control" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3"><span class="required">* </span>性别</label>
											<div class="col-md-8">
												<c:forEach var="s" items="${sexValues }">
													<c:choose>
														<c:when test="${s.id == emp.sex }">
															<label class="radio-inline">
												 				<input type="radio" name="sex" id="sex" checked="checked" value="${s.id }">${s.description }
															</label>
														</c:when>
													<c:otherwise>
														<label class="radio-inline">
											 				<input type="radio" name="sex" id="sex" value="${s.id }">${s.description }
														</label>
													</c:otherwise>
													</c:choose>
												</c:forEach>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">出生日期</label>
											<div class="col-md-8 form-text">
<%-- 												<c:if test="${customer != null }"> --%>
<%-- 													<fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${customer.age  }" /> --%>
<%-- 												</c:if> --%>
<%-- 												<c:if test="${customer ==null || customer.age ==null  }"> --%>
													<div class="date date-picker" data-date-format="yyyy-mm-dd">
														<input type="text" class="form-control" value="<fmt:formatDate value="${emp.age}" pattern="yyyy-MM-dd"/>" name="age" id="age" readonly data-date-format="yyyy-mm-dd">
													</div>
<%-- 												</c:if> --%>
											</div>
										</div>
										
									</div>
									
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<label class="control-label col-md-3"><span class="required">* </span>岗位</label>
											<div class="col-md-8">
												<input type="text" id="job" value="${emp.job }" name="job" id="job" maxlength="16" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3"><span class="required">* </span>联系电话</label>
											<div class="col-md-8">
												<input type="text" id="phone" value="${emp.phone }" name="phone" class="form-control" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">电子邮箱</label>
											<div class="col-md-8">
												<input type="text" id="email" value="${emp.email }" maxlength="32" name="email" class="form-control" />
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3">等级</label>
											<div class="col-md-8">
												<select class="select-inline" name="level" id="level">
													<option value="0" >请选择员工等级</option>
													<c:forEach var="s" items="${levelValues }">
															<option value="${s.value }" <c:if test="${s.value == emp.level }">selected="selected"</c:if>>${s.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										
									</div>
								</div>
							</div>
							<!-- 基本信息 end -->
							
							<!-- 账号信息 -->
							<div class="box row page-sub-section">
								<div class="box-content clearfix">
									<h4 class="page-title">账号信息</h4>
								</div>
								<div class="box-content">
									<div class="col-xs-12 col-sm-6 col-md-6">
<%-- 										<input type="hidden" value="${customer.id }" name="id"> --%>
										<div class="form-group">
											<label class="control-label col-md-3"><span class="required">* </span>登陆账号</label>
											<div class="col-md-8">
												<input type="text" id="account" value="${ptaccount.account }" maxlength="10" name="account" class="form-control" />
											</div>
										</div>
										<div class="form-group">
										
											<label class="control-label col-md-3">登录密码：</label>
											<div class="col-md-8">
												<input type="password" class="form-control" name="password" id="password" />
												<c:if test="${not empty emp }">
													<span class="required reminder">输入框为空,则为原密码不变</span>
												</c:if>
												<span class="required reminder" id="passwordFlag"></span>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 账号信息 end -->
							
							<div class="row">
								<div class="form-actions text-center">
									<button type="submit" class="btn confirmBtn btn-big">保存</button>
									<a href="<%=basePath%>admin/account/tolist.php" class="btn modalCancel cancelBtn btn-big">取消</a>
								</div>
							</div>
								
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/state/common/footerMain.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>state/js/addemployee.js"></script>
	<script type="text/javascript">
		handleValidation();
	</script>
</body>
</html>