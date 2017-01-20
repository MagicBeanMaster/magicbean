$(function(){
	//显示隐藏筛选
	$(".filter_btn").on("click",function(){
		var isOpen = $(this).find("i").hasClass("icon-img-up");
		if(isOpen){
			$(this).find("i").removeClass("icon-img-up");
			$(".filter-data").slideUp("300");
		}else{
			$(this).find("i").addClass("icon-img-up");
			$(".filter-data").slideDown("300");
		}
		
	});
	//筛选选中状态
	$(".filter-data .sub-item span").on("click",function(){
		$(this).parent().parent().find(".sub-item").removeClass("sub-item-selected");
		$(this).parent().addClass("sub-item-selected");
	});
	
	//表格处理
	$(".stopOpen").on("click",function(e){
		e.stopPropagation();
	});
	
});

//alert function
function AlertFun(text,callback,style){
	var width,backgroundTitle,backgroundBtn,alertPane,title;   //宽度，title背景颜色，button背景颜色
	width = 300,backgroundTitle = "#fff",backgroundBtn = "#286ac7",title='系统提示';
	if(style && style.width){width =  style.width; }
	if(style && style.backgroundTitle){backgroundTitle = style.backgroundTitle; }
	if(style && style.backgroundBtn){backgroundBtn = style.backgroundBtn; }
	if(style && style.title){title = style.title; }
	alertPane = $("#alertPane");
	if(alertPane.length){
		alertPane.show().find(".content").html(text);
		alertPane.show().find(".title").html(title);
		alertPane.find(".title").css("background",backgroundTitle);
		alertPane.find(".btn").css("background",backgroundBtn);
		if(style && style.error){alertPane.find('.title').css({'borderBottom':'1px solid #f00'}); 
		}else{
			alertPane.find('.title').css({'borderBottom':'1px solid #e3e8ef'})
		}
		return;
	}
	var temple = '<div id="alertPane" class="alert-warp"><div class="alert" style="width:'+width+'px;">'+
		'<div class="title" style="background:'+backgroundTitle+'">'+title+'</div>'+
		'<p class="content">'+text+'</p>'+
		'<div class="text-right">'+
			'<button id="alertBtn" class="btn btn-info">确定</button>'+
		'</div>'+
	'</div></div>';
	$("body").append(temple);
	if(style && style.error){$('#alertPane').find('.title').css({'borderBottom':'1px solid #f00'}); 
	}else{
		$('#alertPane').find('.title').css({'borderBottom':'1px solid #e3e8ef'})
	}
	
	$("#alertBtn").on("click",function(){
		$("#alertPane").hide().remove();
		callback.call(this,true);
//		flag = true;
	});
	

}



//comfirm function
function ConfirmFun(text,callback,style){
	var width,backgroundTitle,backgroundBtn;  //宽度，title背景颜色，button背景颜色
	if(!style){  //默认
		width = 300,
		backgroundTitle = "#fff",
		backgroundBtn = "#286ac7";
	}else{
		width =  style.width;
		backgroundTitle = style.backgroundTitle;
		backgroundBtn = style.backgroundBtn;
	}
	confirmPane = $("#confirmPane");
	if(confirmPane.length){
		confirmPane.show().find(".content span").html(text);
		confirmPane.find(".title"). css("background",backgroundTitle);
		confirmPane.find(".btn").css("background",backgroundBtn);
		return;
	}
	var temple = '<div id="confirmPane" class="confirm-warp"><div class="confirm" style="width:'+width+'px;">'+
		'<div class="title" style="background:'+backgroundTitle+'">系统提示</div>'+
		'<p class="content"><span>'+text+'</span></p>'+
/*		'<p class="content"><img src="../../state/images/alert.jpg" alt=""><span>'+text+'</span></p>'+
*/		'<div class="text-right">'+
			'<button id="confirmCancel" class="btn btn-cancel">取消</button>'+
			'<button id="confirmSave" class="btn btn-info">确定</button>'+
		'</div>'+
	'</div></div>';

	$("body").append(temple);

	$("#confirmCancel").on("click",function(){
		$("#confirmPane").hide().remove();
		callback.call(this,false);
	});
	$("#confirmSave").on("click",function(){
		$("#confirmPane").hide().remove();
		callback.call(this,true);
	});
}
/* 关闭弹出框 */
$(function(){
	$(".modal-warp .modalCancel").on("click",function(){
		$(this).parents(".modal-warp").hide();
	});
});
