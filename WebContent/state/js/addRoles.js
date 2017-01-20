var UITree = function () {
    var handleSample2 = function () {
        $('#tree_2').jstree({
            'plugins': ["wholerow", "checkbox", "types","search"],//["themes","html_data","ui"]  
        	/*'plugins': [ "contextmenu", "dnd","search","state", "types", "wholerow","checkbox"],*///["themes","html_data","ui"]  
            'core': {
                "themes" : {
                    "responsive": true
                },
            'data':_datas,
            "types" : {
                "default" : {
                    "icon" : "fa fa-folder icon-state-warning icon-lg"
                },
                "file" : {
                    "icon" : "fa fa-file icon-state-warning icon-lg"
                }
            }
            }
       }).on("changed.jstree", function (event, data) { 
    	   $("#resourceids").val(data.selected);
        }); 
        
		$(function () {
			  $("#tree_2").jstree({
			    "plugins" : [ "search" ]
			  });
			  var to = false;
			  $('#demo_q').keyup(function () {
			    if(to) { clearTimeout(to); }
			    to = setTimeout(function () {
			      var v = $('#demo_q').val();
			      $('#tree_2').jstree(true).search(v);
			    }, 250);
			  });
			});
    }	
    return {
        init: function () {
            handleSample2();
        }

    };

}();