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
			<h3 class="page-title">资源管理<a href="<%=basePath%>plat/resource/toedit.php"  class="btn add style-color"><i class="icon-plus icon-font"></i><span>新增</span></a>
			</h3>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-6">	
			<form action="<%=basePath%>plat/resource/tolist.php"
				method="post" id="testForm" >
				<div id="sample_editable_1_filter" class="dataTables_filter search-key">
					<input type="search" name="keys" class="form-control input-inline"
						placeholder="输资源或父资源或路径" value="${keys }">
					<input type="submit" value="开始搜索" class="btn blue">
				</div>
				
			</form>
		</div>
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
	          <th data-class="expand"><span>序列</span></th>
	          <th>资源名称</th>
	          <th>资源类型</th>
	          <th>父资源名</th>
	          <th>路径</th>
	          <th data-hide="default,phone,tablet">备注</th>
	          <th data-hide="phone">操作</th>
	        </tr>
	      </thead>
	    <tbody>
	      <c:forEach var="t" items="${listmap }" varStatus="index">
	      	<tr>
	      		<td>${startIndex+index.index +1}</td>
	      		<td>${t.menuname }</td>
	      		<td>
	      			<c:if test="${not empty restype }">
						<c:forEach var="tt" items="${restype }">
							<c:if test="${tt.key==t.type }">${tt.value }</c:if>
						</c:forEach>
					</c:if>
	      		</td>
	      		<td>${t.parentname }</td>
	      		<td>${t.path }</td>
	      		<td>${t.remark }</td>
	      		<td class="stopOpen">
	      			<a onclick="toedit('${t.id}')"><i class="icon-edit icon-font"></i><span>编辑</span></a>
	      			<a onclick="todel('${t.id}')"><i class="icon-trash icon-font"></i><span>删除</span></a>
	      		</td>
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

<jsp:include  page="/state/common/footerMain.jsp"/>
<script type="text/javascript">
function toedit(obj){
	window.location.href = "<%=basePath%>plat/resource/toedit.php?id="+obj;
}

function todel(obj){	
	ConfirmFun("你确定要删除此功能以及相应的子功能吗？",function(flag){
		if(flag){
			$.ajax({
				url:'<%=basePath%>plat/resource/todel.php',
				type:'post',
				data:{'id':obj},
				dataType: "json", 
				success:function(data){
					if(data.flag==1){
						AlertFun("删除成功！",function(){});
						window.location.href = "<%=basePath %>plat/resource/tolist.php";
					}else{
						AlertFun("删除失败，请重试！",function(){});
					}
				},
				error:function(e){
					AlertFun("删除异常！",function(){});
				}
				
			});
			
		}
	});
}
		
		
function partList(obj){
	window.location.href = "<%=basePath%>admin/resource/partlist.php?parentid="+ obj;
}
function addPart(obj){
	window.location.href = "<%=basePath%>admin/resource/partshow.php?parentid="+ obj;
}

function doupload(type){
	$("#pl").show();
	if(type==1){
		$("#pltitle").text('批量上次功能');
		$("#resoucetype").val(1);
	}else{
		$("#pltitle").text('批量上次子功能');
		$("#resoucetype").val(2);
	}
}
function docancel(){
	$("#pl").hide();
}

function dosub(){
	var appuuid = $("#appuuid").val();
	if(appuuid!='' &&　appuuid.length>0){
		$.ajaxFileUpload({
	          url: '<%=basePath%>admin/resource/uploadFuntion.php', 
	          type: 'post',
	          secureuri: false, //一般设置为false
	          fileElementId: 'file', // 上传文件的id、name属性名
	          dataType: 'json', //返回值类型，一般设置为json、application/json
	          data:{"appuuid":appuuid,"resourcetype":$("#resoucetype").val()},
	          //elementIds: 'appuuid', //传递参数到服务器
	          success: function(data, status){  
	        	  if(data.flag==1){
	            	  alert("上传成功");
	            	  docancel();
	              }else{
	            	  alert("上传失败，请刷新重试");
	              }
	          },
	          error: function(data, status, e){ 
	              alert(e);
	          }
	      });
	}
	  
	
	
}

</script>
</body>
</html>
