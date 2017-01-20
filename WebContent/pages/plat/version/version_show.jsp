<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="/WEB-INF/pager.tld" prefix="page"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>金鼎海居</title>
<%@include file="/state/common/headMain.jsp"%>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content">
<div class="page-content container-fluid">
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<h3 class="page-title">版本信息</h3>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-6">
		<form action="<%=basePath%>plat/version/showlist.php" method="post" id="testForm">
			<div id="sample_editable_1_filter" class="dataTables_filter search-key">
				<input type="search" name="keys" class="form-control input-inline" placeholder="搜索" value="${keys }"> 
				<input type="submit" value="开始搜索" class="btn blue"/>
			</div>
		</form>
	</div>
	<div class="col-xs-12 col-sm-12  col-md-12">
		<div class="portlet box">
			<div class="portlet-body">
				<c:if test="${empty list }"> 
                    <div class="page-warning">
						<img src="<%=Constant.RESROURSEPATH%>images/warning.png" />
						<p>暂无数据</p>
					</div>
                    </c:if>
                      <c:if test="${not empty list }">
                     <table class="table table-hover footable breakpoint">
			      <thead>
			        <tr>
			          <th data-class="expand"><span>序列</span></th>
			          <th><span>更新内容</span></th>
			          <th><span>关联内容</span></th>
			          <th data-hide="phone,tablet">创建日期</th>
			          <th data-hide="phone">修改日期</th>
			        </tr>
			      </thead>
			    <tbody>
			      <c:forEach var="temp" items="${list }" varStatus="t">
			      	<tr>
			      		<td>${t.count }</td>
			      		<td>${temp.content }</td>
			      		<td>${temp.likecontent }</td>
			      		<td><fmt:formatDate type="both"  pattern="yyyy-MM-dd HH:mm:ss" value="${temp.createtime }"/></td>
			      		<td><fmt:formatDate type="both"  pattern="yyyy-MM-dd HH:mm:ss" value="${temp.updatetime }"/></td>
			      	</tr>
			      </c:forEach>
			    </tbody>    
			    </table>
				<div class="text-right">
					<page:createPager pageSize="${pageSize}"
						totalCount="${totalCount}" curPage="${pageNum}"
						formId="testForm" />
				</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<jsp:include  page="/state/common/footerMain.jsp"/>
</body>
</html>
