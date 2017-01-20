var FormFileUpload = function () {


    return {
        //main function to initiate the module
        init: function () {

             // Initialize the jQuery File Upload widget:
 //           $('#fileupload').fileupload({
//                disableImageResize: false,
//                autoUpload: false,
//                disableImageResize: /Android(?!.*Chrome)|Opera/.test(window.navigator.userAgent),
//                maxFileSize: 5000000,
// 				  acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i
                // Uncomment the following to send cross-domain cookies:
                //xhrFields: {withCredentials: true},                
 //           });
            
            $('#fileupload').fileupload({  
                autoUpload: false,//是否自动上传  
                url: $('#fileupload').attr("action"),//上传地址  
                dataType: 'json',  
                done: function (e, data) {//设置文件上传完毕事件的回调函数  
                    //$.each(data.result.files, function (index, file) {  
                   
                    //alert(data.result);  
                },  
                progressall: function (e, data) {//设置上传进度事件的回调函数  
                    var progress = parseInt(data.loaded / data.total * 5, 10);  
                    $('#progress .bar').css(  
                        'width',  
                        progress + '%'  
                    );  
                }  
            });  

            // Enable iframe cross-domain access via redirect option:
//            $('#fileupload').fileupload(
//                'option',
//                'redirect',
//                window.location.href.replace(
//                    /\/[^\/]*$/,
//                    '/cors/result.html?%s'
//                )
//            );

            // Upload server status check for browsers with CORS support:
//            if ($.support.cors) {
//                $.ajax({
//                    type: 'HEAD'
//                }).fail(function () {
//                    $('<div class="alert alert-danger"/>')
//                        .text('Upload server currently unavailable - ' +
//                                new Date())
//                        .appendTo('#fileupload');
//                });
//            }

            // Load & display existing files:
        /*    $('#fileupload').addClass('fileupload-processing');
            $.ajax({
                // Uncomment the following to send cross-domain cookies:
                //xhrFields: {withCredentials: true},
                url: $('#fileupload').attr("action"),
                dataType: 'json',
                context: $('#fileupload')[0]
            }).always(function () {
                $(this).removeClass('fileupload-processing');
            }).done(function (result) {
            	alert("----");
                $(this).fileupload('option', 'done')
                .call(this, $.Event('done'), {result: result});
            });*/
        }

    };

}();