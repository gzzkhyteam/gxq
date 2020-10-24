$(function () {
    $("body").on("click",".btn-back",function(){
        window.location.href=_cp+"/module/applyList";
    });
    //时间限制，开始时间不能大于结束时间
    $('#startTime').off('focus').on('focus',function(){
        WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime"),onpicked:onBlur("startTime"),dateFmt:'yyyy-MM-dd'});
    });
    $('#endTime').off('focus').on('focus',function(){
        WdatePicker({lang:'zh-cn',minDate:CurentTime("startTime"),onpicked:onBlur("endTime"),dateFmt:'yyyy-MM-dd'});
    });
    function CurentTime(id) {
        if(id){
            var time = $("#"+id).val();
            return time;
        }
    };
    function onBlur(id){
        if(id){
          $("#"+id).blur();
        };
    };
    //加载表格列表
    $("#list").jqGrid({
        mtype: 'POST',
        url: _gate_url+'/api/mt/appmanager/findFunctionListByAppId',
        postData:{
            appId:_id
        },
        datatype: "json",
        colNames: ['功能名称', '功能路径', '功能接口', '是否显示', '排序', '操作'],
        colModel: [{
            name: 'appName',
            index: 'appName',
        }, {
            name: 'appPath',
            index: 'appPath',
        }, {
            name: 'showUrl',
            index: 'showUrl',
        }, {
            name: 'isShow',
            index: 'isShow',
            width: '60',
            formatter: formatterIsShow
        }, {
            name: 'appOrder',
            index: 'appOrder',
            width: '60',
        }, {
            name: 'act',
            index: 'act',
            title: false,
            width: '120',
            align: 'center',
            formatter: formatterAct
        }],
        jsonReader : {
            root:"data",
            /*page: "data.pageNum",
            total: "data.pages",
            records: "data.total"*/
        },
        pager: '#pager',
        height: 'auto'
    });
    function formatterIsShow(cellvalue, options, rawObject) {//初始化显示状态
        if(cellvalue==1){
            return "不显示";
        };
        if(cellvalue==2){
            return "显示";
        };
    };
    function formatterAct(cellvalue, options, rawObject) {
        var returnValue = "";
        returnValue += '<a class="ui-button" href="'+_cp+'/module/functionView?id='+rawObject.id+'">';
        returnValue += '<i class="fa fa-file-text-o"></i> 查看</a>';
        returnValue += '<span class="oper-separator"></span>';
        returnValue += '<a class="ui-button" href="'+_cp+'/module/functionEdit?id='+rawObject.id+'">';
        returnValue += '<i class="fa fa-edit"></i> 修改</a>';
        /*returnValue += '<span class="oper-separator"></span>';
        returnValue += '<a class="ui-button" href="'+_cp+'/module/functionList?id='+rawObject.id+'">';
        returnValue += '<i class="fa fa-file-text-o"></i> 功能</a>';*/
        return returnValue;

    }
});
//查询
$(".search-button").click(function () {
    reloadPage();
});
/*跳转新增页面*/
$("body").on("click",".btn-create",function(){
    window.location.href=_cp+"/module/functionCreate?parentId="+_id;
});
/* 审核 */
function release(id){
    parent.layer.open({
        id: 'deal',
        type: 2,
        anim:6,
        title: '审核',
        maxmin: false, //开启最大化最小化按钮
        area: ['80%', '80%'],
        content: _cp+"/module/applyDeal?id="+id,
        btn: ['<span class="glyphicon glyphicon-ok"></span> 确定','<span class="glyphicon glyphicon-remove"></span> 取消'],
        yes: function (index, layero) {
            var html=layero.context;
            var Id=html.getElementById("deal");
            var iframe=$(Id).find("iframe").attr("name");
            var rowData = parent[iframe].save(index);
        }
    });
};
/*重加载页面*/
function reloadPage(){
    var verName = $("#verName").val();
    var startPublishTime = $("#startPublishTime").val();
    var endPublishTime = $("#endPublishTime").val();
    $("#list").setGridParam({
        postData: {pageNo:1,pageSize:20,
            data: {
                verName:verName,
                startPublishTime:startPublishTime,
                endPublishTime:endPublishTime,
            }
        }
    }).trigger("reloadGrid");
}