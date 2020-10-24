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

function removeDuplicatedItem(ar) {
    var tmp = {},
        ret = [];
    for (var i = 0, j = ar.length; i < j; i++) {
        if (!tmp[ar[i]]) {
            tmp[ar[i]] = 1;
            ret.push(ar[i]);
        }
    }
    return ret;
};

function dealElement(obj){//格式化返回值
    if ( obj === null || obj === undefined || obj === "") return obj;
    for ( var key in obj ){
        if ( obj[key] == null || obj[key] == 'null'){
            obj[key]="";
        }
    }
    return obj;
}
