var UITree = function () {
    var handleSample2 = function () {
        $('#tree_2').jstree({
            'plugins': ["wholerow", "checkbox", "types"],//["themes","html_data","ui"] 
            'core': {
                "themes" : {
                    "responsive": false
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
            //'path':_basePath+"admin/superAccount/getAppTree.php"
       }).on("changed.jstree", function (event, data) { 
        	var platid=data.node.parent;
        	var roleid=data.node.id;
        	var roles=roleid.split("_");
        	$("#appkey").val(platid);
        	$("#rolesuuid").val(roles[1]);
        });
    }

    return {
        init: function () {
            handleSample2();

        }

    };

}();