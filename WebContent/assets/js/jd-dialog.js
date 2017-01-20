//alert function
function AlertFun(text,callback,width){
	var alertPane;  
	if(!width) width = 300;
	var temple = '<div id="alertPane" class="alert-warp"><div class="alert" style="width:'+width+'px;">'+
		'<div class="title">系统提示</div>'+
		'<p class="content">'+text+'</p>'+
		'<div class="text-right">'+
			'<button id="alertBtn" class="btn confirmBtn">确定</button>'+
		'</div>'+
	'</div></div>';
	$("body").append(temple);
	alertPane = $("#alertPane");  
	$("#alertBtn").on("click",function(){
		alertPane.hide().remove();
		if(callback){
			callback.call(this,true);
		}
	});
	

}
//comfirm function
function ConfirmFun(text,callback,width){
	var confirmPane;
	if(!width) width = 300;
	var temple = '<div id="confirmPane" class="confirm-warp"><div class="confirm" style="width:'+width+'px;">'+
		'<div class="title">系统提示</div>'+
			'<p class="content"><span>'+text+'</span></p>'+
		'<div class="text-right">'+
			'<button id="confirmSave" class="btn confirmBtn">确定</button>'+
			'<button id="confirmCancel" class="btn cancelBtn">取消</button>'+
		'</div>'+
	'</div></div>';

	$("body").append(temple);
	confirmPane = $("#confirmPane")
	$("#confirmCancel").on("click",function(){
		confirmPane.hide().remove();
		callback.call(this,false);
	});
	$("#confirmSave").on("click",function(){
		confirmPane.hide().remove();
		callback.call(this,true);
	});
	
}

$(function(){
	$(".modal-warp .modalCancel").on("click",function(){
		$(this).parents(".modal-warp").hide();
	});
});
