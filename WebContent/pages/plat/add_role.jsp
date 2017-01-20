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
		<h3 class="page-title">角色列表</h3>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<div class="portlet light bordered">
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><a href="<%=basePath%>admin/roles/tolist.php">角色列表</a> <i
						class="icon-angle-right"></i>编辑</li>
						<c:if test="${roles.id!=null&&roles.id!=0 }">
						序号${roles.id}
						</c:if>
						
				</ul>
			</div>
			<div class="portlet-body form">
				<form action="<%=basePath%>admin/roles/tosave.php" method="post" id="form_sample" class="form-horizontal" ><!-- onsubmit="return doBeforeSub()" -->
					<input type="hidden" name="flag" value="${flag }" />
					<div class="form-body">
						<div class="alert alert-danger display-hide">
							<button class="close" data-close="alert"></button>
							你提交的表单有错误，请检查!
						</div>
						<div class="alert alert-success display-hide">
							<button class="close" data-close="alert"></button>
							你的表单提交成功!
						</div>
						<input type="hidden" id="id" name="id" value="${roles.id }">
						<input type="hidden" id="resourceids" name="resourceids">
						<div class="form-group">
							<label class="control-label col-md-4">角色名称 <span
								class="required">* </span></label>
							<div class="col-md-6  form-text" >
								<%-- <c:if test="${not empty roles.rolesname }"><input type="text" id="rolesname" name="rolesname" value="${roles.rolesname }" class="form-control" readonly="readonly"/></c:if>
								<c:if test="${empty roles.rolesname }"><input type="text" id="rolesname" name="rolesname" value="${roles.rolesname }" class="form-control" /></c:if> --%>
								<c:if test="${flag=='show'}">
									${roles.rolesname }
								</c:if> 
								<c:if test="${flag!='show'}">
									<input type="text" id="rolesname" name="rolesname" maxlength="10" value="${roles.rolesname }" class="form-control" />
								</c:if> 
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4">描述 </label>
							<div class="col-md-6  form-text">
								<c:if test="${flag=='show'}">
									${roles.remark }
								</c:if> 
								<c:if test="${flag!='show'}">
									<input type="text" id="remark" maxlength="25" name="remark"
									value="${roles.remark }" class="form-control" />
								</c:if> 
								
							</div>
						</div>
					</div>
					
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<c:if test="${flag!='show'}">
										<a href="javascript:history.go(-1);" class="btn modalCancel cancelBtn">取消</a>
										<input class="btn confirmBtn" type="submit" value="提交"/>
									</c:if> 
									<c:if test="${flag=='show'}">
										<a href="javascript:history.go(-1);" class="btn modalCancel cancelBtn">返回</a>
									</c:if> 
								</div>
							</div>
						</div>
					
					
				</form>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-sm-6 col-md-6">	
		<div class="portlet green-meadow box">
              <div class="portlet-title">
                  <div class="caption">
                      <i class="icon-cogs"></i>功能列表
                  </div>
              </div>
              <div class="portlet-body">
              	  <input type="text" placeholder="输入要搜索的关键字" id="demo_q" class="form-control" style="margin: 5px 0;">
                  <div id="tree_2" class="tree-demo">
                  </div>
              </div>
          </div>
	</div>
</div>
	
<jsp:include  page="/state/common/footerMain.jsp"/>
<script type="text/javascript">
var _basePath='<%=basePath %>';
var _datas;
	$(document).ready(function() {
		$('.form-horizontal').validate({
		errorElement : 'span',
		errorClass : 'help-block',
		focusInvalid : false,
		rules : {
			rolesname : {
				required : true,
				remote: {
				    url: "<%=basePath%>admin/roles/valRolesname.php",     //后台处理程序
				    type: "post",               //数据发送方式
				    dataType: "json",           //接受数据格式   
				    data: {                     //要传递的数据
				    	rolesname: function() {
				            return $("#rolesname").val();
				        },
				        id:function(){
				        	return $("#id").val();
				        }
				    }
				}
			}
			
		},
		messages : {
			rolesname : {
				required : "角色名不能为空",
				remote:"请重新输入角色"
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
	$.ajax({
	   type: "POST",
	   url:_basePath+"plat/resource/getResourceTree.php",
	   dataType:'json',
	   async:false,
	   data:{"rolesid":'${roles.id }'},
	   success: function(data){
		 	_datas=data;
	   },
	   error:function(e){
		   alert(e);
	   }
	});
	UITree.init();
		
		
	});	
	
	
	
	var UITree = function () {
	    var handleSample2 = function () {
	        $('#tree_2').jstree({
	            'plugins': ["wholerow", "checkbox", "types","search"],//["themes","html_data","ui"]  
// 	        	'plugins': [ "contextmenu", "dnd","search","state", "types", "wholerow","checkbox"],//["themes","html_data","ui"]  
	            'core': {
	                "themes" : {
	                    "responsive": true
	                },
	            'data':{id:"0",text:'全选',children:_datas},//[{id:'1_1',text:'text1'},{id:'1_2',text:'text2'}]
	            "types" : {
	                "default" : {
	                    "icon" : "fa fa-folder icon-state-warning icon-lg"
	                },
	                "file" : {
	                    "icon" : "fa fa-file icon-state-warning icon-lg"
	                }
	            }
	            }
	       }).on("changed.jstree", function (event, data) { 
	    	   $("#resourceids").val(data.selected);
	        }); 
	        
			$(function () {
				  $("#tree_2").jstree({
				    "plugins" : [ "search" ]
				  });
				  var to = false;
				  $('#demo_q').keyup(function () {
				    if(to) { clearTimeout(to); }
				    to = setTimeout(function () {
				      var v = $('#demo_q').val();
				      $('#tree_2').jstree(true).search(v);
				    }, 250);
				  });
				});
	    }	
	    return {
	        init: function () {
	            handleSample2();
	        }

	    };

	}();
	
	
	</script>

</body>
</html>
