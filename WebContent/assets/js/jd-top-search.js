$(function(){
	var $filter = $(".filter-data");
	//初始化时间控件
	$(".date-picker input,.date-picker").datepicker({
 		autoclose:true,
 		todayHighlight:true,
 		todayBtn:"linked",
 		clearBtn:true
 	});
	//显示隐藏筛选
	$(".filter_btn").on("click",function(){
		var $icon = $(this).find("i");
		var isOpen = $icon.hasClass("icon-img-up");
		if(isOpen){
			$icon.removeClass("icon-img-up");
			$filter.slideUp("300");
		}else{
			$icon.addClass("icon-img-up");
			$filter.slideDown("300");
		}
	});
	//筛选选中状态
	$filter.find(".sub-item span").on("click",function(){
		$(this).parent().parent().find(".sub-item").removeClass("sub-item-selected");
		$(this).parent().addClass("sub-item-selected");
	});
	//清空数据
	$(".filter-clear").on("click",function(){
		$(".date-picker input").val("");
		$(".search input.input-inline").val('');
		$filter.find(".sub-item-selected").removeClass("sub-item-selected");
	});
	
});