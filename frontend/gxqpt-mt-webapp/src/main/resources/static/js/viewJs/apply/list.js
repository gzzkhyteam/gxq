$(function () {
    // 获取当前登录人的按钮权限
    var buttonCodeList = window.parent.getButtonCodeListFromTopWindow().join('|');
    // 新增按钮权限配置
    if (buttonCodeList.indexOf('mt_app_manager_create') > -1) {
        $('.btn-create').removeClass('none');
    }

    // 获取默认开始时间
    function getDefaultStartDate() {
        var dateTime = new Date(Date.now() - (30 * 24 * 60 * 60 * 1000));
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = dateTime.getDate();
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    // 获取默认结束时间
    function getDefaultEndDate() {
        var dateTime = new Date();
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = dateTime.getDate();
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    //时间限制，开始时间不能大于结束时间
    $('#startPublishTime').off('focus').on('focus',function(){
        WdatePicker({lang:'zh-cn',maxDate:CurentTime("endPublishTime"),onpicked:onBlur("startPublishTime"),dateFmt:'yyyy-MM-dd'});
    })/*.val(getDefaultStartDate())*/;
    $('#endPublishTime').off('focus').on('focus',function(){
        WdatePicker({lang:'zh-cn',minDate:CurentTime("startPublishTime"),onpicked:onBlur("endPublishTime"),dateFmt:'yyyy-MM-dd'});
    })/*.val(getDefaultEndDate());*/;
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
        url: _gate_url+'/api/mt/appmanager/find',
        postData:{
            pageNo:1,pageSize:20,
            data: {}
        },
        datatype: "json",
        contentType : 'application/json',
        serializeGridData:function(postData){
            return JSON.stringify(postData);
        },
        colNames: ['应用图标', '应用类型', '审核状态', '应用程序名称', '应用路径', '登记日期','是否显示','排序', '操作'],
        colModel: [{
            name: 'iconPath',
            index: 'iconPath',
            width: '80',
            formatter: formatterIconPath
        }, {
            name: 'appType',
            index: 'appType',
            width: '60',
            formatter: formatterAppType
        }, {
            name: 'state',
            index: 'state',
            width: '60',
            formatter: formatterState
        }, {
            name: 'appName',
            index: 'appName',
            width: '120',
        }, {
            name: 'appPath',
            index: 'appPath'
        }, {
            name: 'createTime',
            index: 'createTime',
            width: '120',
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
            root:"data.list",
            page: "data.pageNum",
            total: "data.pages",
            records: "data.total"
        },
        pager: '#pager',
        height: 'auto',
        onPaging: function (pgButton) {
            var pageNo=$(".ui-pg-input").val();
            pageNo=parseInt(pageNo);
            var total = ($("#sp_1_pager_toppager").text()).replace(/,/g,'');
            total=parseInt(total);
            if(pgButton=="next"){
                if(pageNo>=total){
                    return false;
                }else{
                    pageNo+=1;
                }
            }else if(pgButton=="prev"){
                if(pageNo>1){
                    pageNo-=1;
                }else{
                    return false;
                }
            }else if(pgButton=="last"){
                pageNo=total;
            }else if(pgButton=="first"){
                pageNo=1;
            }else if (pgButton == "records") {
                // 切换分页条数，查询第一页
                pageNo = 1;
            }
            var pageSize=$(".ui-pg-selbox").val();
            if(pageNo!=0){
                reloadPage(pageNo, pageSize);
                return false;
            }
        }
    });
    function formatterIconPath(cellvalue, options, rawObject) {//初始化应用图标
        return '<a href="'+cellvalue+'" target="_blank"><img src="'+cellvalue+'" style="width: 60px; height: 60px;"/>';
    };
    function formatterAppType(cellvalue, options, rawObject) {//初始化应用类型
        if(cellvalue==1){
            return "Android";
        };
        if(cellvalue==2){
            return "H5";
        };
    };
    function formatterState(cellvalue, options, rawObject) {//初始化审核状态
       switch (cellvalue){
           case 1:
               return "暂存";
               break
           case 2:
               return "未审核";
               break
           case  3:
               return "通过";
               break
           case 4:
               return "驳回";
               break
       }
    };
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
        // 分割线
        var separator = '<span class="oper-separator"></span>';
        // 查看
        var detail = '<a class="ui-button" href="'+_cp+'/module/applyView?id='+rawObject.id+'"><i class="fa fa-file-text-o"></i> 查看</a>';
        // 修改
        var edit = '<a class="ui-button" href="'+_cp+'/module/applyEdit?id='+rawObject.id+'"><i class="fa fa-edit"></i> 修改</a>';
        // 功能
        var func = '<a class="ui-button" href="'+_cp+'/module/functionList?id='+rawObject.id+'"><i class="fa fa-file-text-o"></i> 功能</a>';
        // 审核
        var check = '<a class="ui-button" href="javascript:void(0);" onclick="release(\''+rawObject.id+'\')"><i class="fa fa-trash-o"></i> 审核</a>';
        if(rawObject.state==1||rawObject.state==3||rawObject.state==4){
            var arr = [detail];
            if (buttonCodeList.indexOf('mt_app_manager_edit') > -1) {
                arr.push(separator);
                arr.push(edit);
            }
            if (buttonCodeList.indexOf('mt_app_manager_func') > -1) {
                arr.push(separator);
                arr.push(func);
            }
            return arr.join('');
        };
        if(rawObject.state==2){
            var arr = [detail];
            if (buttonCodeList.indexOf('mt_app_manager_edit') > -1) {
                arr.push(separator);
                arr.push(edit);
            }
            if (buttonCodeList.indexOf('mt_app_manager_func') > -1) {
                arr.push(separator);
                arr.push(func);
            }
            if (buttonCodeList.indexOf('mt_app_manager_check') > -1) {
                arr.push(separator);
                arr.push(check);
            }
            return arr.join('');
        };

    }
    /*跳转新增页面*/
    $("body").on("click",".btn-create",function(){
        window.location.href=_cp+"/module/applyCreate";
    });
    //查询
    $(".search-button").click(function () {
        reloadPage();
    });
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
function reloadPage(pageNo, pageSize){
    var verName = $("#verName").val();
    var startCreateTime = $("#startPublishTime").val();
    var endCreateTime = $("#endPublishTime").val();
    if(startCreateTime){
        startCreateTime+=" 00:00:00";
    };
    if(endCreateTime){
        endCreateTime+=" 23:59:59";
    };
    $("#list").setGridParam({
        postData: {
            pageNo: pageNo || 1,
            pageSize: pageSize || 20,
            data: {
                appName:verName,
                startCreateTime:startCreateTime,
                endCreateTime:endCreateTime,
            }
        }
    }).trigger("reloadGrid");
}

