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
<body class="page-header-fixed page-quick-sidebar-over-content">
<h2><a href="<%=basePath %>mytest1/delPic.php?pics=upload/2016/1/18/1/a963cbaa314a4e23b181f2229a1137cc1453103273714.jpg">删除文件</a></h2>
<form action="http://192.168.0.8:8080/Picture/uploadfiles1.php?appid=1"enctype="multipart/form-data"method="post">
上传文件:<input type="file" name="file">
上传文件:<input type="file" name="file">
<input type="submit" value="提交" />
</form>

<br/><br/>


<img src="<%=basePath %>upload/default.png" id="upload_1_img" width="180" height="110">
图片：<input type="file" id="upload_file" name="file" class="form-control" onchange="changepic()"/>

<br/><br/><br/>
<!-- <div id="uploader-demo" class="uploader">
    用来存放图片item
    <div id="fileList" class="uploader-list"></div>
    <div id="filePicker" class="select_filePicker">选择图片</div>
    <button id="ctlBtn" class="btn btn-default">开始上传</button>
    <div id="type" hidden="true"></div>
    <div id="flag"></div>
</div> -->

<!-- 上传图片 -->

<div id="imageDiv" >
<div id="uploader-demo" class="uploader">
    <!--用来存放图片item-->
   <div id="fileList" class="uploader-list"></div>
   <div id="filePicker" class="select_filePicker">选择图片</div>
   <button id="ctlBtn" class="btn btn-default">开始上传</button>
   <div id="type" hidden="true"></div>
    <div id="flag"></div>
</div>
<div id="imageDivContent"></div>
</div>

<form action="<%=basePath %>mytest1/subtest.php" method="post" id="myfrm">
<input type="text" name="id"  value="" />
<input type="text" name="nickname"  />
<input type="text" name="account"  />
<input type="text" name="name"  />
<input type="button" value="提交from表单" onclick="doSub();"/>
</form>


<h1><a href="http://192.168.0.8:8080/Picture/upload/2016/1/23/0/57b4705ba44a402fa0f99000d4dd59411453516965089.docx">下载</a></h1>
<h1><a href="http://192.168.0.8:8080/FileService/upload/temp/2016/2/19/0/aa4467d139f647d893ef641f9d646ad71455874342105.jpg" target="_block">下载</a></h1>
<h1><a href="http://192.168.0.8:8080/FileService/upload/temp/2016/2/19/0/cd42f4436b6e46b9a34c09a05cb26e931455874537957.rar" target="_block">下载</a></h1>
<h1><a href="http://192.168.0.8:8080/FileService/upload/temp/2016/2/19/0/6c2fb14de928450cb9fc4e6a2225714d1455874613820.war" target="_block">下载war</a></h1>
<h1><a href="http://192.168.0.8:8080/FileService/upload/temp/2016/2/19/0/299d3c5e3a1948b8aad2372bd0918a881455874712147.docx" target="_block">下载doc</a></h1>
<h1><a href="http://192.168.0.8:8080/FileService/upload/temp/2016/2/19/0/c10001109d9442549ccc0116cd77c1af1455874796901.xls" target="_block">下载xls</a></h1>
<jsp:include  page="/state/common/footerMain.jsp"/>
<script type="text/javascript">

function doSub(){
	$.ajax({
		url:'<%=basePath %>mytest1/subtest.php',
		type:'post',
		data:$("#myfrm").serialize(),
		dataType:'json',
		success:function(e){
			alert("======"+e);
		},
		error:function(e){
			
		}
	});
	
	
}


$(function () {
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
		    swf: _basePath + '<%=basePath%>js/plugins/webuploader/Uploader.swf',
		    // 文件接收服务端。
		    server: 'http://192.168.0.8:8080/FileService/uploadfiles.php?appid=0',
		    // 选择文件的按钮。可选。
		    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
		    pick: '#filePicker',
		    uploadAccept:'json'
		    //fileNumLimit:1,
		    //fileSizeLimit:1024*20,
		    //fileSizeLimit:1024*20,
		    // 只允许选择文件，可选。
		   /* accept: {
		        title: 'Images',
		        extensions: 'gif,jpg,jpeg,bmp,png',
		        mimeTypes: 'image/*'
		    } */
		    
		});

		// 当有文件添加进来的时候
	    uploader.on('fileQueued', function( file ) {
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
	    
	    //uploader.on('uploadBeforeSend', function(obj, data, headers) {
	    	//	$.extend(headers, { "Origin": "http://441ffdaf086b4bfd811f320798dee9a1.php", "Access-Control-Request-Method": "POST" }); 
	    //}); 
	    
	 	// 文件上传过程中创建进度条实时显示。
	    uploader.on( 'uploadProgress', function( file, percentage ) {
	        var $li = $( '#'+file.id ),
	            $percent = $li.find('.progress span');
	        // 避免重复创建
	        if ( !$percent.length ) {
	            $percent = $('<p class="progress"><span></span></p>')
	                    .appendTo( $li )
	                    .find('span');
	        }
	        $li.find('p.state').text('上传中');
	        $percent.css( 'width', percentage * 100 + '%' );
	    });
	    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
	    uploader.on( 'uploadSuccess', function( file,data  ) {
	    	//alert(data.datas);
	    	alert("==上传文件的名称="+data.realname);
	    	var arr = data.datas;
	    	for(var j=0;j<arr.length;j++){
	    		alert(arr[j]);
	    		$("#mypic").append("<input type='hidden' name='pics' value='"+arr[j]+"' />");
	    	}
	    });
	    
	    uploader.on('error', function(handler) {
			if(handler=="Q_EXCEED_SIZE_LIMIT"){
				alert("大小超过");
			}
		});
	    // 文件上传失败，现实上传出错。
	    uploader.on( 'uploadError', function( file ) {
	        alert('上传失败');
	    });
	    // 完成上传完了，成功或者失败，先删除进度条。
	    uploader.on( 'uploadComplete', function( file ) {
	        $( '#'+file.id ).find('.progress').remove();
	    });
	    //点击开始上传
	    $btn.on( 'click', function() {
	    	//uploader.upload();
	    	
	        
	    });
	    
	    
	    
	    //只上传一张图片
	 /*    uploader.on('uploadBeforeSend', function( block, data, headers) {
		    data.key = new Date().toLocaleTimeString();
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
	    }); */
	   
	
});


</script>



<script type="text/javascript">

function changepic(){
	ajaxFileUpload('upload_file','upload_1_img');
}
function ajaxFileUpload(file_id,img_id){
	jQuery.ajaxFileUpload({ 
		url:'http://192.168.0.8:8080/Picture/uploadfiles.php?appid=1',
		secureuri : false,
		fileElementId : file_id,
		timeout:300000,
		dataType : 'json',
		success:function( d, s ){
			d = $.parseJSON(d);
			alert("ajaxcallback=d.datas=="+d.datas);
			//console.log("ajaxcallback=d.type=="+d.type);
			//console.log("ajaxcallback=s=="+s);
		},
		error:function(e){
			alert("上传图片失败！");
		}
	});
}

function doSucc(obj){
	alert(obj);
}

</script>
</body>
</html>
