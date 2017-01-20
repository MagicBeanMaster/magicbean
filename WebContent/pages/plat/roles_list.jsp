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
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<h3 class="page-title">角色列表<a href="<%=basePath%>admin/roles/toedit.php"  class="btn add style-color"><i class="icon-plus icon-font"></i><span>新增</span></a></h3>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<form action="<%=basePath %>admin/roles/tolist.php" method="post" id="testForm">
             <div id="sample_editable_1_filter" class="dataTables_filter search-key">
                 <input type="search" name="keys" class="form-control input-inline" placeholder="输入角色名" value="${keys }">
               	<input type="submit" value="开始搜索" class="btn blue">
             </div>
          </form>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<div class="portlet box">
		      <div class="portlet-body">
		                      <c:if test="${empty listmap }">
		                      	<div class="page-warning">
					<img src="<%=Constant.RESROURSEPATH%>images/warning.png" />
					<p>暂无数据</p>
				</div>
		                      </c:if>
		                      <c:if test="${not empty listmap }">
		                      <table class="table table-hover footable breakpoint">
			      <thead>
			        <tr>
			          <th data-class="expand"><span>序号</span></th>
			          <th ><span>角色名</span></th>
			          <th ><span>描述</span></th>
			          <th ><span>创建时间</span></th>
			          <!-- <th data-hide="default,phone,tablet"><span>接口密匙</span></th> -->
			          <th data-hide="phone"><span>操作</span></th>
			        </tr>
			      </thead>
			    <tbody>
			    	<c:forEach var="t" items="${listmap }" varStatus="status">
			    		<tr>
			    			<td>${startIndex+status.index +1}</td>
			    			<td>${t.rolesname }</td>
			    			<td>${t.remark }</td>
			    			<td>${t.createtime }</td>
			    			<td class="stopOpen">
			    				<a href="javascript:void(0);" onclick="toedit('${t.id}')"><i class="icon-edit icon-font"></i><span>编辑</span></a>
			    				<a href="javascript:void(0);" onclick="show('${t.id}')"><i class="icon-trash icon-font"></i><span>查看</span></a>
			    				<a href="javascript:void(0);" onclick="todel('${t.id}')"><i class="icon-trash icon-font"></i><span>删除</span></a>
			    			</td>
			    		</tr>
			    	</c:forEach>
			    </tbody>
			</table>
                      <div class="text-right">
                      	<page:createPager pageSize="${pageSize}" totalCount="${totalCount}" curPage="${pageNum}" formId="testForm"/>
                      </div>
                      </c:if>
                  </div>
              </div>
	</div>
</div>	

<jsp:include  page="/state/common/footerMain.jsp"/>
<script type="text/javascript">
function toedit(obj){
	window.location.href="<%=basePath %>admin/roles/toedit.php?id="+obj;
}
function show(obj){
	window.location.href="<%=basePath %>admin/roles/toshow.php?id="+obj;
}

function todel(obj){
	ConfirmFun("你确定要删除吗",function(flag){
		if(flag){
			$.ajax({
				url:'<%=basePath%>admin/roles/todel.php',
				type:'post',
				data:{'id':obj},
				dataType: "json", 
				success:function(data){
					if(data.flag==1){
						AlertFun("删除成功",function(){});						
						window.location.href = "<%=basePath %>admin/roles/tolist.php";
					}else{
						AlertFun("删除失败",function(){});
					}
				}
			});
		}
	});
}


</script>	
	
</body>
</html>