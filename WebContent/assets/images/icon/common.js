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
	$(".table .stopOpen").on("click",function(e){
		e.stopPropagation();
	});
	$(".table .stopOpen").on("click",function(e){
		e.stopPropagation();
	});
});