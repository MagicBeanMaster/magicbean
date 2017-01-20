function loadOnePic(defaultWidth,defaultHeight){
			var $list = $('#fileList'),
			 $btn = $('#ctlBtn'),
			 state = 'pending',
		    // 优化retina, 在retina下这个值是2
		    ratio = window.devicePixelRatio || 1,
		    // 缩略图大小
		    thumbnailWidth = defaultWidth,
		    thumbnailHeight = defaultHeight,
		    // Web Uploader实例
		    uploader;
			// 初始化Web Uploader
			uploader = WebUploader.create({
				auto:true,
			    // swf文件路径
			    swf: _resourcepath+'js/plugins/webuploader/Uploader.swf',
			    // 文件接收服务端。
			    server: _picturepath+'uploadfiles.php?appid=0',
			    // 选择文件的按钮。可选。
			    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
			    pick: '#filePicker',
			    uploadAccept:'json',
			    fileNumLimit:1,
			    fileSizeLimit:1024*20,
			    // 只允许选择文件，可选。
			    accept: {
			        title: 'Images',
			        extensions: 'gif,jpg,jpeg,bmp,png',
			        mimeTypes: 'image/*'
			    },
			    compress:{
			        width: 24,
			        height: 24
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
		    	if(arr!='' && arr!='undefined' && arr!=null){
		    		for(var j=0;j<arr.length;j++){
			    		$("#pic").val(arr[j]);
			    	}
		    	}else{
		    		alert('上传失败');
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
			uploader.on( 'error', function( handler ) {
		    	if(handler=="Q_EXCEED_SIZE_LIMIT"){
		    		alert("请上传小于20KB的文件");
				}
		    });
			
		}