<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
<style type="text/css">
	@media screen{
		.footable .footable-row-detail .footable-row-detail-inner>div{
			width:100%;
		}
	}
</style>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content">
<div class="page-content container-fluid">
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<h3 class="page-title">异常信息列表&nbsp;&nbsp;&nbsp;
		</h3>
		<input type="button" value="清空异常" class="btn blue" onclick="doClear();"/>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<form action="<%=basePath%>admin/error/list.php" method="post" id="testForm">
			<div id="sample_editable_1_filter" class="dataTables_filter search-key">
				<input type="search" name="keys" class="form-control input-inline" placeholder="输入id或错误信息" value="${keys }"> 
				<input type="submit" value="开始搜索" class="btn blue"/>
			</div> 
		</form>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<div class="portlet box">
			<div class="portlet-body">
				<c:if test="${empty errorlists }">
	                       	<div class="page-warning">
							<img src="<%=Constant.RESROURSEPATH%>images/warning.png" />
						<p>暂无数据</p>
					</div>
                </c:if>
                <c:if test="${not empty errorlists }">
                <table class="table table-hover footable breakpoint">
			      <thead>
			        <tr>
			          <th data-class="expand"><span>序列</span></th>
			          <th data-hide="default,phone,tablet">错误信息</th>
			          <th >IP</th>
			          <th >创建时间</th>
			        </tr>
			      </thead>
			    <tbody>
			      <c:forEach var="temp" items="${errorlists }" varStatus="t">
			      	<tr>
			      		<td>${temp.id }</td>
			      		<td><pre style="color:red;">${temp.errormess }</pre></td>
			      		<td>${temp.ip }</td>
			      		<td><fmt:formatDate type="both"  pattern="yyyy-MM-dd HH:mm:ss" value="${temp.createtime  }"/></td>
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
<script type="text/javascript">
function doClear(){
	if(confirm("确定要清空异常?")){
		$.ajax({
			url:"<%=basePath%>admin/error/clearErrorInfo.php",
			type:'post',
			data:{"appuuid":$("#appuuid").val()},
			dataType:'json',
			success:function(datas){
				if(datas.flag==1){
					alert("清空异常成功！");
					window.location.href="<%=basePath%>admin/error/list.php";
				}else{
					alert("清空异常失败！");
				}
			},
			error:function(e){
				alert("清空异常失败！");
			}
		});
	}
}
</script>
</body>
</html>
