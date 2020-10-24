$(function(){
    updateIformHeight();
	/**
	 * 为My97DatePicker注册焦点事件
	 */
	if(typeof $('.Wdate')=="object"){
		$('.Wdate').off('focus').on('focus',function(){
			WdatePicker({skin:'twoer', lang:'zh-cn', dateFmt:'yyyy-MM-dd'});
		});
	}
});
function updateIformHeight(){
    if(document.getElementById("container")!=null){
        var height=document.getElementById("container").scrollHeight;
        $("#home", window.parent.document).height(height);
    }
}
function dealElement(obj){
    if ( obj === null || obj === undefined || obj === "" ) return obj;
    for ( var key in obj ){
        if ( obj[key] == null){
           obj[key]="";
        }
    }
    return obj;
}
function getTime(id){
    var starData=$("#"+id).val();
    if(starData!="" && starData!=null && starData!=undefined){
        return starData;
    }else{
        return "";
    }
}

function fmtDate(obj){//时间格式化为YY-MM-DD;
    if(!obj) return "";
    var date =  new Date(obj);
    var y = date.getFullYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
}
function fmtDateTime(obj){//时间格式化为YY-MM-DD HH:MM:SS;
    if(!obj) return "";
    var date =  new Date(obj);
    var y = date.getFullYear();
    var m = "0"+(date.getMonth()+1);
    var d = "0"+date.getDate();
    var h = "0"+date.getHours();
    var minutes = "0"+date.getMinutes();
    var s = "0"+date.getSeconds();
    return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length)+" "+h.substring(h.length-2,h.length)+":"+minutes.substring(minutes.length-2,minutes.length)+":"+s.substring(s.length-2,s.length);
}
function jqPaginator(rows){//分页
    $.jqPaginator('#pagination', {
        totalPages: rows.pages,
        visiblePages: 6,
        currentPage: rows.pageNum,
        first: '<li class="first"><a href="javascript:void(0);" onclick="firstPage('+rows.firstPage+')">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;" onclick="prePage('+rows.prePage+')">前一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);" onclick="nextPage('+rows.nextPage+')">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);" onclick="lastPage('+rows.lastPage+')">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;" onclick="setPageNum({{page}})">{{page}}</a></li>',
        onPageChange: function (num, type) {
            $('#pageNum').text(num);
        }
    });
}
function jqPaginator(rows,pageId){//分页
    $.jqPaginator('#'+pageId, {
        totalPages: rows.pages,
        visiblePages: 6,
        currentPage: rows.pageNum,
        first: '<li class="first"><a href="javascript:void(0);" onclick="firstPage('+rows.firstPage+')">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;" onclick="prePage('+rows.prePage+')">前一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);" onclick="nextPage('+rows.nextPage+')">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);" onclick="lastPage('+rows.lastPage+')">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;" onclick="setPageNum({{page}})">{{page}}</a></li>',
        onPageChange: function (num, type) {
            $('#pageNum').text(num);
        }
    });
}
function firstPage(pageNum){//跳转首页方法
    parm.pageNo=pageNum;
    getList(parm);
}
function lastPage(pageNum){//跳转尾页方法
    parm.pageNo=pageNum;
    getList(parm);
}
function prePage(pageNum){//跳转前一页方法
    parm.pageNo=pageNum;
    getList(parm);
}
function nextPage(pageNum){//跳转下一页方法
    parm.pageNo=pageNum;
    getList(parm);
}
function setPageNum(pageNum){//跳转选中页方法
    parm.pageNo=pageNum;
    getList(parm);
}
