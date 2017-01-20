$.extend({
    _VagueSearch:function(options){
        var opts={
            wrap:null,
            url:'',
            removeId:'',
            callback:function(){},
            blurCallback:function(){}
        }
        opts = $.extend({}, opts, arguments[0] || {});
        var searchInput=$(opts.wrap).find('.js-search-input'),
            selectIndex=0,
            searchCon=$(opts.wrap).find('.js-search-con'),
            searchConDiv=searchCon.find('div'),
            timer='',
            showDetailDiv=$(opts.wrap).find('.js-show-detail'),
            searchId=$(opts.wrap).find('.search-id');
        searchInput.keydown(function(e){
            if(e.keyCode == 9){
                searchCon.addClass('search-result-hide').removeClass('search-result-show');
                return false;
            }
            if(e.keyCode == 13){
                closeSearchCon();
            }
        }).keyup(function(e){
            getResult(e);
        }).blur(function(e){
            showDetail();
            searchCon.find('div').length>0 && searchInput.val(searchConDiv.eq(selectIndex).attr('title'));
            opts.blurCallback();
         });
        $('body').click(function(){
            closeSearchCon();
        })
        function getResult(e){
           clearTimeout(timer);
           if(13 != e.keyCode && 37 != e.keyCode && 38 != e.keyCode && 39 != e.keyCode && 40 != e.keyCode && 9 != e.keyCode) {
               var searchInputVal=$.trim(searchInput.val());
                   selectIndex=0;
                   timer=setTimeout(function(){
                       $.ajax({
                           type:'post',
                           url:opts.url,
                           data:{search:searchInputVal},
                           dataType:'json',
                           success:function(data){
                               showSearchDate(data.datas,searchCon,searchInput);
                           },
                           error:function(data){
                            alert("error!");
                        }
                    });
                   },100);
             
           }
       }
       function showDetail(){
        searchConDiv=searchCon.find('div');
        showDetailDiv.show();
        if(searchConDiv.length > 0){
            var selectDiv=searchConDiv.eq(selectIndex);
            showDetailDiv.find('.search-name').html( selectDiv.attr('name')==='null' ? '':selectDiv.attr('name'));
            showDetailDiv.find('.search-position').html( selectDiv.attr('position')==='null' ? '':selectDiv.attr('position'));
            showDetailDiv.find('.search-tel').html( selectDiv.attr('tel')==='null' ? '':selectDiv.attr('tel'));
            showDetailDiv.find('.search-sex').html( selectDiv.attr('sex')==='null' ? '':selectDiv.attr('sex'));
            searchId.val(selectDiv.attr('id'));
        }else{
           showDetailDiv.find('.search-name').html('');
           showDetailDiv.find('.search-position').html('');
           showDetailDiv.find('.search-tel').html('');
           showDetailDiv.find('.search-sex').html('');
           searchId.val('0');
       }
       opts.callback();
   }
   function closeSearchCon(){
    searchCon.addClass('search-result-hide').removeClass('search-result-show');
}
function showSearchDate(data,container,searchInput){
    var container=$(container),_html='',n=0;
    for(var i=0;i<data.length;i++){
        if( opts.removeId =='' || ( opts.removeId !='' && data[i].id != parseInt( $(opts.removeId).val())) ){ 
           n++;
           _html+='<div id="'+data[i].id+'" sex="'+ data[i].sexname+'" name="'+data[i].name+'" position="'+ data[i].job +'" tel="'+ data[i].phone +'"  title="'+data[i].name+'" >'+data[i].name +'('+data[i].phone +')</div>';
       }
   }
   container.html(_html);
   $(container).find('div').eq(0).addClass('selected');
   $(container).find('div').hover(function(){ 
       $(this).addClass("selected").siblings().removeClass("selected");
        selectIndex=searchCon.find('div').index($(this)[0]);
   });

   if(n>0){
        container.addClass('search-result-show').removeClass('search-result-hide');       
    }else{
        searchId.val('0');
        container.addClass('search-result-hide').removeClass('search-result-show');
    }


}
},
_CheckAll:function(options){
   var opts={
    btn:null,
    checkboxs:''
}
opts = $.extend({}, opts, arguments[0] || {});
$(opts.btn).click(function(){
    $(this).is(':checked') ?  $(opts.checkboxs).prop('checked',true): $(opts.checkboxs).prop('checked',false);
});
}
});

