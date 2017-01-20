$(function(){
	$(".footable").footable();  //初始化
	$(".stopOpen").on("click",function(e){
		e.stopPropagation();
	});
	
	//checkbox选择
	var checkMainEle = $(".footable th input[type='checkbox']");
	var checkEles = $(".footable td input[type='checkbox']");
	var checkLen = checkEles.length;
	if(checkLen){
		boxsChoose(checkMainEle, checkEles);
	}
});

function boxsChoose(ele,checkEles){
	ele.on("click",function(){
		if(ele[0].checked){
			checkEles.prop("checked",true);
		}else{
			checkEles.prop("checked",false);
		}
	});
	
	checkEles.on("click",function(){
		var flag = true;
		checkEles.each(function(i,v){
			if(!checkEles[i].checked){
				ele.prop("checked",false);
				flag = false;
				return;
			}
		});
		if(flag){
			ele.prop("checked",true);
		}
	});
}