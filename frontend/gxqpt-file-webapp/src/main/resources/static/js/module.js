/**
 * 为My97DatePicker注册焦点事件
 */
$('.Wdate').off('focus').on('focus',function(){
	WdatePicker({skin:'twoer', lang:'zh-cn', dateFmt:'yyyy-MM-dd'});
});

/**
 * 初始化页面中的chosen select
 */
$("select.chosen-select").each(function() {//无搜索
	$(this).chosen({
		disable_search:true,
		no_results_text:'没有查询到符合条件的记录'
	});
});
$("select.chosen-select-search").each(function() {//无搜索
	$(this).chosen({
		disable_search:false,
		no_results_text:'没有查询到符合条件的记录'
	});
});

$("select.chosen-select-deselect").each(function() {
	$(this).chosen({
		disable_search:true,
		no_results_text:'没有查询到符合条件的记录',
		allow_single_deselect:true
	});
});

$("select.chosen-select-no-single").each(function() {
	$(this).chosen({
		disable_search:true,
		no_results_text:'没有查询到符合条件的记录',
		disable_search_threshold:10
	});
});
//关闭所有弹窗
function closeLayer(){
	top.layer.closeAll();
}
function setCookie(cname,cvalue,exdays){
    var d = new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires = "expires="+d.toGMTString();
    document.cookie = cname+"="+cvalue+"; "+expires;
}
function getCookie(cname){
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) { return c.substring(name.length,c.length); }
    }
    return "";
}

function fomatFloat(src,pos){
    return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);
}


/* 生成翻页栏 */
function pagerList(pagerInfo){
    if(pagerInfo.total==0){
        return false;
    }
    var html="";
    html+='<ul id="Pager" class="Pager clearfix">';
    if(pagerInfo.isFirstPage){
        html+='<li><i class="fa fa-step-backward iDisabled" title="首页" pageNum="1"></i></li>';
        html+='<li><i class="fa fa-backward iDisabled" title="上一页" pageNum="'+pagerInfo.prePage+'"></i></li>';
	}else{
        html+='<li><i class="fa fa-step-backward" title="首页" pageNum="1" onclick="pager(this)"></i></li>';
        html+='<li><i class="fa fa-backward" title="上一页" pageNum="'+pagerInfo.prePage+'" onclick="pager(this)"></i></li>';
	}
    html+='<li>当前页&nbsp;';
    html+='<select onchange="pargePageNum(this)">';
    if(pagerInfo.pages>0){
        for(var i=1; i<=pagerInfo.pages; i++){
        	if(pagerInfo.pageNum==i){
                html+='<option selected>'+i+'</option>';
			}else{
                html+='<option>'+i+'</option>';
            }
        };
    };
    html+='</select>';
    html+='</li>';
    html+='<li>共&nbsp;<span>'+pagerInfo.pages+'</span>&nbsp;页</li>';
    if(pagerInfo.isLastPage){
        html+='<li><i class="fa fa-forward iDisabled" title="下一页" pageNum="'+pagerInfo.nextPage+'"></i></li>';
        html+='<li><i class="fa fa-step-forward iDisabled" title="尾页" pageNum="'+pagerInfo.pages+'"></i></li>';
    }else{
        html+='<li><i class="fa fa-forward" title="下一页" pageNum="'+pagerInfo.nextPage+'" onclick="pager(this)"></i></li>';
        html+='<li><i class="fa fa-step-forward" title="尾页" pageNum="'+pagerInfo.pages+'" onclick="pager(this)"></i></li>';
    }
    html+='<li>显示&nbsp;';
    html+='<select id="pargePageSize" onchange="pargePageSize(this)">';
    if(pagerInfo.pageSize=="10"){
        html+='<option selected>10</option>';
        html+='<option>20</option>';
        html+='<option>30</option>';
    }
    if(pagerInfo.pageSize=="20"){
        html+='<option>10</option>';
        html+='<option selected>20</option>';
        html+='<option>30</option>';
    }
    if(pagerInfo.pageSize=="30"){
        html+='<option>10</option>';
        html+='<option>20</option>';
        html+='<option selected>30</option>';
    }
    html+='</select>';
    html+='&nbsp;条</li>';
    html+='</ul>';
    $(".pagerDiv").html(html);
};

/* 翻页方法 */
function pager(index){
    var pageNo=$(index).attr("pageNum");
    var pageSize=$("#pargePageSize").val();
    parm.pageNo=pageNo;
    parm.pageSize=pageSize;
    if(typeof getSearchData === "function"){
        getSearchData();
    }
    getList(parm);
};
/* 设置显示条数方法 */
function pargePageSize(index){
    var pageSize=$(index).val();
    parm.pageNo=1;
    parm.pageSize=pageSize;
    if(typeof getSearchData === "function"){
        getSearchData();
    }
    getList(parm);
};
/* 跳转到选中页方法 */
function pargePageNum(index){
    var pageNo=$(index).val();
    var pageSize=$("#pargePageSize").val();
    parm.pageNo=pageNo;
    parm.pageSize= pageSize;
    if(typeof getSearchData === "function"){
        getSearchData();
    }
    getList(parm);
};
$("body").click(function(){
    if(self!=top){
        parent.removeAllRanges();
    }
});
function removeAllRanges(){
    window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
}
function removeRepeatArray(arrayPara){//数组去重，string,number类型
    var newArray = new Array
    for(var i=0 in arrayPara) {
        var items=arrayPara[i];
        if($.inArray(items,newArray)==-1) {
            newArray.push(items);
        }
    };
    return newArray;
}