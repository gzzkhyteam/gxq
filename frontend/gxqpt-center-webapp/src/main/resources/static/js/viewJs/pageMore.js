window.onresize = function(){
    window.location.reload();
};
var height = $("body").height()-250;
var num = Math.floor((height-250)/34);
if(num>10 && num<15){
    num = 10;
}else if(num>15){
    num = 15;
}
$(".infoMain").css("height",height);
var ids=[];
var userId = $("#userId").val();
var parm ={
    pageNo: 1,
    pageSize:num,
    data: {
        conditions:_type,
        userId: userId
    }
};
if(_type){
    $("#infoType li").removeClass("active");
    $("#"+_type).addClass("active");
};
$("#infoType li").click(function(){
    var conditions = $(this).attr("id");
    parm.data.conditions=conditions;
    parm.pageNo=1;
    getList(parm);
    $("#infoType li").removeClass("active");
    $("#"+conditions).addClass("active");
});
$("#infoTotal").click(function(){
    parm.data.conditions="all";
    parm.pageNo=1;
    getList(parm);
    $("#infoType li").removeClass("active");
    $("#all").addClass("active");
});
//全选
$(".setact li.all").click(function(){
    var isCheckedVal = $(this).find("input").prop("checked");
    var tr = $("#systemList tbody tr");
    if(!isCheckedVal){
        $(this).find("input").prop("checked",true);
        tr.each(function(index,value){
            $(value).find("input").prop("checked",true);
            var idVal = $(value).find("input").val();
            ids.push(idVal);
        });
    }else{
        $(this).find("input").removeProp("checked");
        tr.each(function(index,value){
            $(value).find("input").removeProp("checked");
            ids=[];
        });
    }
});
$(".setact li.all input").click(function(){
    var isCheckedVal = $(this).prop("checked");
    if(isCheckedVal){
        $(this).removeProp("checked");
    }else{
        $(this).prop("checked",true);
    };
});
//选择单元行
$('body').on('click',"#systemList tbody tr",function(){
   var idVal = $(this).find("input").val();
   var isChecked = $(this).find("input").prop("checked");
   if(!isChecked){
       $(this).find("input").prop("checked",true);
       ids.push(idVal);
   }else{
       $(this).find("input").removeProp("checked");
       var ret = jQuery.inArray(idVal,ids);
       ids.splice(ret,1);
   }
});
$('body').on('click',"#systemList tbody tr input",function(){
    var isCheckedVal = $(this).prop("checked");
    if(isCheckedVal){
        $(this).removeProp("checked");
    }else{
        $(this).prop("checked",true);
    };
});
$("#removeBtn").click(function(){
    remove();
});
function remove(){//删除
    if(ids.length==0){
        parent.layer.msg("请选择需要删除的信息！",{time:1500});
        return false;
    };
    parent.layer.confirm("您确定要删除选中信息吗？",{
        title:'温馨提示',
        shade: [0.4,'#000'],
        btn: ['确定','取消'] //按钮
    }, function(){
        ajaxHengyun({
            type:"post",
            dataType: 'json',
            url: gateUrl+ '/api/msgs/bbs/msg/deleteById',
            data:{ids:ids},
            success:function(rows){
                if (rows.data){
                    ids=[];
                    parent.layer.msg("删除成功！",{time:1000});
                    getList(parm);
                    getTotalFun();
                    $(".setact li.all input").removeProp("checked");
                }else{
                    parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
                }
            }
        });
    });
};
$("#readMsgs").click(function(){
    readMsgs();
});
function readMsgs(){//标记已读
    if(ids.length==0){
        parent.layer.msg("请选择需要标记为已读的信息！",{time:1500});
        return false;
    };
    ajaxHengyun({
        type:"post",
        dataType: 'json',
        url: gateUrl+ '/api/msgs/bbs/msg/updateMsgsReaded',
        data:{ids:ids},
        success:function(rows){
            if (rows.data){
                ids=[];
                parent.layer.msg("成功标记为已读！",{time:1000});
                getList(parm);
                getTotalFun();
                $(".setact li.all input").removeProp("checked");
            }else{
                parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
            }
        }
    });
};
function readedOnly(ele){//单个标记已读
    var ids = [];
    var idItem = $(ele).attr("data-id");
    ids.push(idItem);
    ajaxHengyun({
        type:"post",
        dataType: 'json',
        url: gateUrl+ '/api/msgs/bbs/msg/updateMsgsReaded',
        data:{ids:ids},
        success:function(rows){
            if (rows.data){
                ids=[];
                parent.layer.msg("成功标记为已读！",{time:1000});
                getList(parm);
                getTotalFun();
                $(".setact li.all input").removeProp("checked");
            }else{
                parent.layer.msg(rows.errmsg+"，请重试！",{time:3000});
            }
        }
    });
};
//获取信息总条数
getTotalFun();
function getTotalFun(){
    var parmDb={
        pageNo: 1,
        pageSize:1,
        data: {
            conditions:"needHandle",
            userId: userId
        }
    };
    getTotal(parmDb);//待办信息
    var parmXx={
        pageNo: 1,
        pageSize:1,
        data: {
            conditions:"message",
            userId: userId
        }
    };
    getTotal(parmXx);//消息信息
    var parmAll={
        pageNo: 1,
        pageSize:1,
        data: {
            conditions:"all",
            userId: userId
        }
    };
    getTotal(parmAll);//消息信息
}
function getTotal(parm) {
    ajaxHengyun({
        type: 'post',
        url: gateUrl+'/api/msgs/bbs/msg/getNotReadMsg',
        contentType: 'application/json',
        data: JSON.stringify(parm),
        success: function (res) {
            if (res.data && res.data.list.length) {
                if(parm.data.conditions=="all"){
                    if(Number(res.data.total)>0){
                        if(res.data.total>99){
                            $("#infoTotal", window.parent.document).text("99+");
                        }else{
                            $("#infoTotal", window.parent.document).text(res.data.total);
                        }
                        $("#infoTotal", window.parent.document).css("display","inline-block");
                    }
                }else{
                    $("#"+parm.data.conditions).find("span").text(res.data.total);
                }
            }
        }
    })
};
//获取信息列表
getList(parm);
function getList(parm) {
    ajaxHengyun({
        type: 'post',
        url: gateUrl+'/api/msgs/bbs/msg/getNotReadMsg',
        contentType: 'application/json',
        data: JSON.stringify(parm),
        success: function (res) {
            if (res.data && res.data.list.length) {
                var str = '';
                var n = (res.data.pageNum-1)*res.data.pageSize;
                $.each(res.data.list, function (index, value) {
                    value.content = value.content.replace(/"([^"]*)"/g ,"“$1”")
                    var actHtml = "";
                    if(value.handlerUrl=="" || value.handlerUrl==null){
                        actHtml= '<td><a data-id='+value.recId+'  href="javascript:" onclick="readedOnly(this)">标记已读</a></td>';
                    }else{
                        actHtml= '<td><a data-id='+value.recId+'  href="javascript:" onclick="readed(this)">查看</a></td>';
                    }
                    n++;
                    str += '<tr>\n' +
                        '<td><input class="inputCheckbox" type="checkbox" name="checkbox" value="'+value.recId+'"/>' + n + '</td>\n' +
                        '<td class="text-left" title="'+value.content+'">' + value.content + '</td>\n' +
                        '<td>' + value.appName  + '</td>\n' +
                        '<td>' + value.detailedTypeDesc + '</td>\n' +
                        '<td>' + value.updateTime + '</td>\n' +
                        actHtml+'\n' +
                        '</tr>';
                })
                $('#systemList tbody').html(str);
                $('#totalPages').html(res.data.pages);
                $('#totalNum').html(res.data.total);
                jqPaginatorById(res.data,"pagination");
                $(".currentPage").css("display","inline-block");
            }else{
                $(".currentPage").css("display","none");
                var str = '';
                str += '<tr>\n' +
                    '<td colspan="6">暂无数据</td>\n' +
                    '</tr>';
                $('#systemList tbody').html(str);
            }
        }
    })
};
function readed(ele){
    var e=arguments.callee.caller.arguments[0] || window.event;
    e.stopPropagation();
    var id=$(ele).attr("data-id");
    ajaxHengyun({
        type: 'get',
        url: gateUrl+'/api/msgs/bbs/msg/flagReadedAndGetUrl',
        data: {recvMsgId:id},
        success: function (res) {
            if (res.errmsg=="ok") {
                var newTab=window.open('${_cp}/admin/index');
                newTab.location.href=res.data;
            }
        }
    })

};
function jqPaginatorById(rows,pageId){//分页
    $.jqPaginator('#pagination', {
        totalPages: rows.pages,
        visiblePages: 6,
        currentPage: rows.pageNum,
        first: '<li class="first"><a href="javascript:void(0);" onclick="firstPage(\'1\')">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);" onclick="prePage(\''+rows.prePage+'\')">前一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);" onclick="nextPage(\''+rows.nextPage+'\')">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);" onclick="lastPage(\''+rows.pages+'\')">尾页</a></li>',
        page: '<li class="page"><a href="javascript:void(0);" onclick="setPageNum(\'{{page}}\')">{{page}}</a></li>',
        onPageChange: function (num, type) {
            $('#pageNum').text(num);
        }
    });
}
function firstPage(pageNum){//跳转首页方法
    ids=[];
    parm.pageNo=pageNum;
    getList(parm);
}
function lastPage(pageNum){//跳转尾页方法
    ids=[];
    parm.pageNo=pageNum;
    getList(parm);
}
function prePage(pageNum){//跳转前一页方法
    ids=[];
    parm.pageNo=pageNum;
    getList(parm);
}
function nextPage(pageNum){//跳转下一页方法
    ids=[];
    parm.pageNo=pageNum;
    getList(parm);
}
function setPageNum(pageNum){//跳转选中页方法
    ids=[];
    parm.pageNo=pageNum;
    getList(parm);
}
