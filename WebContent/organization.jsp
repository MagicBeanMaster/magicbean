<%@page import="com.base.constant.Constant"%>
<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>金鼎海居</title>
<%@include file="/state/common/headMain.jsp"%>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content ">
<!-- 客户信息详情 -->
<div class="page-content">
	<!--  content -->
	<h3 class="page-title">组织结构</h3>
	<button class="btn green" onclick="showAddPlan()">新增</button><button class="btn red">删除</button>
	 <div class="portlet green-meadow box" style="max-width:500px;">
        <div class="portlet-title">
            <div class="caption">
                <i class="fa fa-cogs"></i>基本配置
            </div>
        </div>
        <div class="portlet-body">
            <div id="tree_2" class="tree-demo"></div>
        </div>

    </div>

	
	<!-- content end -->
</div>
<!-- 添加 弹出框-->
	<div id="addPane" class="modal-warp">
		<div class="modal2">
			<div class="title">添加<label></label><span class="glyphicon glyphicon-remove modalCancel"></span></div>
			<div class="content">
				<form class="form-horizontal" action="">
					<div class="form-group">
						<label class="control-label col-md-3">名称：</label>
						<div class="col-md-6">
							<input type="text" name="" class="form-control" />
						</div>
					</div>
					<div class="form-group form-button">
						<div class="col-md-9 text-right">
							<button type="submit" class="btn green">保存</button>
							<a class="btn default modalCancel">取消</a>
						</div>
					</div>
				</form>
				
				
			</div>
		</div>
	</div>
	<!-- 添加 弹出框  end-->
<script type="text/javascript">
	function showAddPlan(){
		$("#addPane").show();
	}
	$(function(){
		//弹出框 hide
		$(".modalCancel").on("click",function(){
			$(".modal-warp").hide();
		});
		
	});
	
</script>


<script type="text/javascript">
var UITree = function () {
    var data = ["12"];
    var handleSample2 = function () {
        $('#tree_2').jstree({
            'plugins': ["wholerow", "types"],
            'core': {
                "themes": {
                    "responsive": false
                },
                'data' : [
                    { "id" : "1", "parent" : "#", "text" : "金鼎网络有限公司" },
                    { "id" : "2", "parent" : "1", "text" : "开发部" },
                    { "id" : "3", "parent" : "1", "text" : "销售部" },
                    { "id" : "4", "parent" : "1", "text" : "人事部" }
                ]
            },
            "types": {
                "default": {
                    "icon": "fa fa-folder icon-state-warning icon-lg"
                },
                "file": {
                    "icon": "fa fa-file icon-state-warning icon-lg"
                }
            }
        })
         .on("changed.jstree", function (e, data) {
        	 console.log(data);
             var i, j, r = [];
             for(i = 0, j = data.selected.length; i < j; i++) {
                 r.push(data.instance.get_node(data.selected[i]));
             }
             console.log(r);
             
             alert(r[0].id+"--"+r[0].text);
         });
    };

    return {
        //main function to initiate the module
        init: function () {
            handleSample2();
        }

    };


}();

UITree.init();  //初始化
</script>
<script src="<%=basePath%>state/lib/js/jstree.min.js"></script>
</body>
</html>