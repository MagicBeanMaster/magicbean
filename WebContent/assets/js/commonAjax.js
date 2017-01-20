/**
 * 简单封装ajax请求
 * 
 * @param url
 *			请求地址
 * @param data
 *			传递参数，如果是form提交，则传递$("#form").serialize()
 * @param callback
 *			回调
 * @param dataType
 * @param async
 */
function ajaxSubmit(url, p_data, _callback, dataType, async) {
	async = async? async:false;
	dataType = dataType?dataType: "json" ;
	$.ajax({
		url : url,
		traditional:true,
		dataType : dataType,
		type : "post",
		data : p_data,
		cache : false,
		async : async,
		beforeSend : function() {
		},
		success : function(res_data) {
			_callback(res_data);
		},
		error:function(XMLHttpRequest){
	    	var status = XMLHttpRequest.status;
	    	if(status == 302){
	    		window.location.href = _basePath+"admin/loginout.php";
	    	}
	    	if(status == 401){
	    		window.location.href = _basePath+'nopermission.jsp';
	    	}
	    	if(status == 404){
	    		window.parent.window.AlertFun("未找到资源，请联系管理员",function(){});
	    	}
	    	if(status == 500){
	    		window.parent.window.AlertFun("系统错误，请联系管理员",function(){});
	    	}
	    }
	});
}