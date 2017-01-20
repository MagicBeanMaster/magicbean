<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="row page-header-title">
		<div class="col-xs-12 col-sm-12 col-md-12">	
			<h3 class="page-title"><span>员工管理 </span>
				<a href="<%=basePath%>admin/account/toedit.php"  class="btn green-btn"><img alt="" src="<%=Constant.RESROURSEPATH%>images/icon/userAdd.png">
					<span>新增员工</span></a>
			</h3>
		</div>
	</div>
	
		<div class="row page-section">
		<!-- 搜索 -->
		<div class="col-xs-12 col-sm-12 col-md-12">
			<form action="<%=basePath%>admin/account/tolist.php" id="searchForm"  method="post" novalidate="novalidate">
				<div class="row search">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<select class="select-inline" name="search">
							<c:forEach var="searchcolumn" items="${searchcolumn }">
								<c:if test="${searchcolumn.value == 1 && role != 0}">
									<option value="${searchcolumn.value }" <c:if test="${search == searchcolumn.value}">selected="selected"</c:if>>${searchcolumn.name}</option>
								</c:if>
								<c:if test="${searchcolumn.value != 1}">
									<option value="${searchcolumn.value }" <c:if test="${search == searchcolumn.value}">selected="selected"</c:if>>${searchcolumn.name}</option>
								</c:if>	
							</c:forEach>
						</select>
						<input type="search"  name="keys" value="${keys}" class="form-control input-inline" placeholder="输入搜索内容">
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6 text-right">
						<input type="submit"  value="开始搜索" class="btn blue">
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
	
	
	
	
	
		<div class="row page-section">
		<!-- 表格 -->
		<div class="col-xs-12 col-sm-12 col-md-12">
			<table class="table table-hover footable breakpoint">
			      <thead>
			        <tr>
			          <th><span>员工姓名</span></th>
			          <th><span>员工账号</span></th>
			          <th data-hide="phone"><span>联系方式</span> </th>
			          <th data-hide="phone"><span>角色</span></th>
			          <th data-hide="phone"><span>状态</span></th>
			          <th data-hide="phone"><span>操作</span></th>
			        </tr>
			      </thead>
			    <tbody>
			    <c:forEach items="${empList}" var="list" varStatus="status">
			    	<tr>
				    		<td>${list.name}</td>
				    		<td>${list.account}</td>
				    		<td>${list.phone}</td>
				    		<td>${list.rolesname}</td>
				    		<td>
				    			<c:if test="${list.status==1}">正常</c:if>
				    			<c:if test="${list.status==0}">离职</c:if>
				    		</td>
				    		<td class="stopOpen">
				    			<c:if test="${list.status==1}">
			    							<a href="#" onclick="editAccount('${list.id}')">
			    							<img alt="" src="<%=Constant.RESROURSEPATH%>images/icon/eyeList.png"><span>编辑</span></a>
			    					<c:if test="${loginid != list.id }">
							    			<a href="<%=basePath%>admin/account/addRoles.php?id=${list.acountid}&empid=${list.id}" ><i class="icon-edit icon-font"></i><span>分配角色</span></a>
							    			<a href="#" onclick="deleteAccount('${list.id}')">
							    			<img alt="" src="<%=Constant.RESROURSEPATH%>images/icon/trash.png"><span>作废</span></a>
			    					</c:if>
			    				</c:if>
			    				
			    				
			    			</td>
			    	</tr>
			    	</c:forEach>
			    </tbody>     
			</table>
			<div class="col-xs-12 col-sm-12 col-md-12 text-right">
				<page:createPager pageSize="${pageSize}"
					totalCount="${totalCount}" curPage="${pageNum}"
					formId="searchForm" ></page:createPager>
			</div>
		</div>
	</div>
	
	
	
	
</div>	

<jsp:include  page="/state/common/footerMain.jsp"/>
<script type="text/javascript">
function editAccount(obj){
	window.location.href="<%=basePath %>admin/account/toedit.php?id="+obj;
}

function deleteAccount(obj){
	ConfirmFun("你确定要作废吗",function(flag){
		if(flag){
			$.ajax({
				url:'<%=basePath%>admin/account/todel.php',
				type:'post',
				data:{'id':obj},
				dataType: "json", 
				success:function(data)
				{
					if(data.flag==-2||data.flag>0){
						window.parent.window.AlertFun("删除成功",function(flag){
							window.location.href = "<%=basePath %>admin/account/tolist.php";
						});
					} else {
						window.parent.window.AlertFun("删除失败",function(flag){});
					}
				}
				});
		}
	});
}


</script>	
	
</body>
</html>