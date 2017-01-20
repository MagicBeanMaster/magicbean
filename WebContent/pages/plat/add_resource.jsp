<%@page import="com.base.constant.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>金鼎海居</title>
<%@include file="/state/common/headMain.jsp"%>
<script type="text/javascript">
var _type = '${presource.type}';

</script>
</head>
<body class="page-header-fixed page-quick-sidebar-over-content">
<div class="page-content container-fluid">
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<h3 class="page-title">资源信息</h3>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">	
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><a href="<%=basePath%>plat/resource/tolist.php">资源列表</a><i class="icon-angle-right"></i>编辑</li>
			</ul>
		</div>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12">
		<div class="portlet light bordered">
			<div class="portlet-body form">
				<form action="<%=basePath%>plat/resource/tosave.php"
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
						<input type="hidden" value="${presource.id }" name="id" id="id">
						
						<div class="form-group">
							<label class="control-label col-md-3">资源名<span
								class="required">* </span></label>
							<div class="col-md-4">
								<input type="text" id="menuname" name="menuname" maxlength="15" value="${presource.menuname }"
									class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">资源类型<span
								class="required">* </span></label>
							<div class="col-md-4">
								<select name = "type" class="form-control" onchange="showlist()">
									<c:if test="${not empty restype }">
										<c:forEach var="t" items="${restype }">
											<c:if test="${presource.type == t.key }"><option value="${t.key }" selected="selected">${t.value }</option></c:if>
											<c:if test="${presource.type != t.key }"><option value="${t.key }">${t.value }</option></c:if>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
						<div class="form-group" id="reslist1"  style="display: none">
							<label class="control-label col-md-3">父资源 </label>
							<div class="col-md-4">
								<select name = "parentid1" class="form-control">
									<option value="0">请选择</option>
									<c:if test="${not empty reslist1 }">
										<c:forEach var="t" items="${reslist1 }">
											<c:if test="${presource.parentid==t.id }"><option value="${t.id }" selected="selected">${t.menuname }</option></c:if>
											<c:if test="${presource.parentid != t.id }"><option value="${t.id }">${t.menuname }</option></c:if>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
						
						<div class="form-group" id="reslist2"  style="display: none">
							<label class="control-label col-md-3">父资源 </label>
							<div class="col-md-4">
								<select name = "parentid2" class="form-control">
									<option value="0">请选择</option>
									<c:if test="${not empty reslist2 }">
										<c:forEach var="t" items="${reslist2 }">
											<c:if test="${presource.parentid==t.id }"><option value="${t.id }" selected="selected">${t.menuname }</option></c:if>
											<c:if test="${presource.parentid != t.id }"><option value="${t.id }">${t.menuname }</option></c:if>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3">路径 <span
								class="required">* </span></label>
							<div class="col-md-4">
								<input type="text" name="path" maxlength="100" value="${presource.path }" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">排序 <span
								class="required">* </span></label>
							<div class="col-md-4">
								<c:if test="${not empty presource.ord }"><input type="text" name="order" value="${presource.ord }" class="form-control" /></c:if>
								<c:if test="${empty presource.ord }"><input type="text" name="order" value="0" class="form-control" /></c:if>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3">图标 <!-- <span
								class="required">* </span> --></label>
							<div class="col-md-4">
							<input type="hidden" name="icon" id="pic" value="${presource.icon }">
							<div id="imageDiv" >
								<div id="uploader-demo" class="uploader">
								    <!--用来存放图片item-->
								    <div id="fileList" class="uploader-list">
								   		<c:if test="${not empty presource and not empty presource.icon  }">
											<img src="<%=Constant.PICTUREPATH%>${presource.icon}" id="upload_1_img" width="19" height="19">
										</c:if>
										<c:if test="${empty presource.icon}">
											<img height="19px" src="<%=basePath %>upload/menu/default.png" id="upload_2_img">
										</c:if>
								   </div>
								  <%--  <div id="fileList" class="uploader-list">
								   		<c:if test="${not empty app and not empty app.pic  }">
											<img src="${picturepath }${app.pic}" id="upload_1_img" width="105" height="105">
											<div class="info">${picname }</div>
										</c:if>
										<c:if test="${empty app.pic}">
											<img src="<%=basePath %>upload/default.png" id="upload_2_img" width="105" height="105">
										</c:if>
								   </div> --%>
								   <div id="filePicker" class="select_filePicker">选择图片</div>
								</div>
							</div>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3">备注 </label>
							<div class="col-md-4">
								<textarea rows="4" cols="50" maxlength="25" class="form-control" name="remark">${presource.remark }</textarea>
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
			if(_type==2){
				  $("#reslist1").show();
				  $("#reslist2").hide();
			 }else if(_type==3){
				  $("#reslist2").show();
				  $("#reslist1").hide();
			 }else{
				  $("#reslist2").hide();
				  $("#reslist1").hide();
			 }	
			
			$('.form-horizontal').validate({
				errorElement : 'span',
				errorClass : 'help-block',
				focusInvalid : false,
				rules : {
					menuname : {
						required : true
					},
					path : {
						required : true
					}
			
				},
				messages : {
					menuname : {
						required : "资源名不能为空"
					},
					path : {
						required : "路径不能为空"
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
			
			loadPic();
			
		});
		
		
	   function showlist(){
		  var type= $("select[name='type']").val();
		  if(type==2){
			  $("#reslist1").show();
			  $("#reslist2").hide();
		  }else if(type==3){
			  $("#reslist2").show();
			  $("#reslist1").hide();
		  }else{
			  $("#reslist2").hide();
			  $("#reslist1").hide();
		  }
	       
	    }
		function loadPic(){
			var $list = $('#fileList'),
			 $btn = $('#ctlBtn'),
			 state = 'pending',
		    // 优化retina, 在retina下这个值是2
		    ratio = window.devicePixelRatio || 1,
		    // 缩略图大小
		    thumbnailWidth = 100 * ratio,
		    thumbnailHeight = 100 * ratio,
		    // Web Uploader实例
		    uploader;
			// 初始化Web Uploader
			uploader = WebUploader.create({
				auto:true,
			    // swf文件路径
			    swf: '<%=Constant.RESROURSEPATH%>js/plugins/webuploader/Uploader.swf',
			    // 文件接收服务端。
			    server: '<%=Constant.PICTUREPATH%>uploadfiles.php',
			    // 选择文件的按钮。可选。
			    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
			    pick: '#filePicker',
			    uploadAccept:'json',
			    fileNumLimit:1,
			    fileSizeLimit:1024*50,//限制上传文件的大小
			    // 只允许选择文件，可选。
			    accept: {
			        title: 'Images',
			        extensions: 'gif,jpg,jpeg,bmp,png',
			        mimeTypes: 'image/*'
			    }
			});
			// 当有文件添加进来的时候
		    uploader.on('fileQueued', function( file ) {
		    	$("#fileList").html("");
		        var $li = $('<div id="' + file.id + '" class="file-item thumbnail">' +
		                    '<img>' +
		                    '<div class="info">' + file.name + '</div>' +
		                	'</div>' ),
		                	 /* '<p class="state">等待上传...</p>' ), */
		        $img = $li.find('img');
		        $list.append( $li );
		        // 创建缩略图
		        uploader.makeThumb( file, function( error, src ) {
		            if ( error ) {
		                $img.replaceWith('<span>不能预览</span>');
		                return;
		            }
		            $img.attr( 'src', src );
		        }, thumbnailWidth, thumbnailHeight );
		        $('#type').removeAttr('hidden');
		    });
		    
		    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
		    uploader.on( 'uploadSuccess', function( file,data  ) {
		    	var arr = data.datas;
		    	if(arr=='' || typeof(arr)=='undefined'){
		    		 alert('上传失败');
		    	}else{
			    	for(var j=0;j<arr.length;j++){
			    		$("#pic").val(arr[j]);
			    	}
		    	}
		    });
		    // 文件上传失败，现实上传出错。
		    uploader.on( 'uploadError', function( file ) {
		        alert('上传失败');
		    });
		    
		 	// 先从文件队列中移除之前上传的图片，第一次上传则跳过
			$("#filePicker").on('click', function () {
				if (!WebUploader.Uploader.support()) {
		            var error = "上传控件不支持您的浏览器！请尝试升级flash版本或者使用Chrome引擎的浏览器。<a target='_blank' href='http://se.360.cn'>下载页面</a>";
		            console.log(error);
		            return;
		        }
				var id = $list.find("div").attr("id");
				if (undefined != id) {
					uploader.removeFile(uploader.getFile(id));
				}
		    });
			uploader.on('error', function(handler) {
				if(handler=="Q_EXCEED_SIZE_LIMIT"){
					alert("请上传小于50KB的图片");
				}
			}); 
		    
		} 
		
		
		 jQuery.validator.addMethod("ip", function(value, element) {    
				//      return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);    
				      return this.optional(element) || /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/.test(value);    
				    }, "请填写正确的IP地址。");
		
		
		<%-- function changepic(){
			ajaxFileUpload('upload_file','upload_1_img');
		}
		function ajaxFileUpload(file_id,img_id){
			jQuery.ajaxFileUpload({ 
				url:'<%=basePath%>admin/app/upload.php',
				secureuri : false,
				fileElementId : file_id,
				dataType : 'json',
				success:function(data,status){
					if(data.code == 0){
						$("#upload_1_img").attr("src", _basePath+data.path); 
						$("#upload_2_img").attr("src", _basePath+data.path); 
						$("#pic").attr("value",data.path);
					}
					if(data.code==-1){
						AlertFun('上传的文件为空，请重新上传',function (){});
					}else if(data.code==0){
						alert("上传成功!");
					}else{
						AlertFun('上传图片异常！',function (){});
					}
				}
			});
		} --%>
		
	</script>
</body>
</html>
