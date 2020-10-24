$(function () {
    // 审核状态
    var peopleStatus = {
        close: '已拉黑',
        open: '正常'
    };

    var dataList = [''];
    
    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        if (options.rowId == '1') {
            dataList = [''];
        }
        dataList.push(rawObject);
        var close = '<a class="ui-button act" href="javascript:void(0);" data-idx="' + options.rowId + '"><i class="fa fa-file-text-o"></i> 拉黑</a>';
        var open = '<a class="ui-button act" href="javascript:void(0);" data-idx="' + options.rowId + '"><i class="fa fa-edit"></i> 取消拉黑</a>';
        // 已发布
        if (peopleStatus.close == cellvalue) {
            return open;
        } else {
            return close;
        }
    }

    // 更新列表
    function updateList (pageNo, pageSize) {
        var gxqptDutiesDTO =$("#search-condition").serializeJSON();
        gxqptDutiesDTO.channelId = channelId;
        var postData={
            pageNo:pageNo || $(".ui-pg-input").val() || 0,
            pageSize:pageSize || $(".ui-pg-selbox").val() || 10,
            data: gxqptDutiesDTO
        };
        $('#list').setGridParam({
            postData:postData
        },true).trigger('reloadGrid');
    }

    // 初始化表格
    function initList () {
        var gxqptDutiesDTO =$("#search-condition").serializeJSON();
        gxqptDutiesDTO.channelId = channelId;
        //表格列表初始化
        $("#list").jqGrid({
            mtype: 'POST',
            postData:{
                pageNo:1,
                pageSize:10,
                data: gxqptDutiesDTO
            },
            url: _GATE_URL + '/api/msgs/publisher/msg/list',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['发布商名称', 'APPID', '所在部门', '状态', '操作'],
            colModel: [{
                name: 'name',
                index: 'name'
            }, {
                name: 'appId',
                index: 'appId'
            }, {
                name: 'orgName',
                index: 'orgName'
            }, {
                name: 'status',
                index: 'status'
            }, {
                name: 'status',
                index: 'status',
                title: false,
                width: '100',
                align: 'center',
                formatter: formatterAct
            }],
            rowNum: 10,
            pager: '#pager',
            height: 'auto',
            jsonReader : {
                root: "data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            onPaging: function (pgButton) {
                var pageNo=$(".ui-pg-input").val();
                pageNo=parseInt(pageNo);
                var total=$("#sp_1_pager_toppager").text();
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
                    updateList(pageNo, pageSize);
                    return false;
                }
            }
        });
    }

    // 拉黑或者取消拉黑
    function doAct(idx){debugger;
        var data = dataList[idx];
        // 已拉黑，取消拉黑
        var isOpen = data.status == peopleStatus.close;
        
        parent.layer.confirm("确定"+(isOpen?"取消拉黑":"拉黑")+"吗？",{
            title:'温馨提示',
            shade: [0.4,'#000'],
            btn: ['确定','取消'] //按钮
        }, function(){
            ajaxHengyun({
                type:'POST',
                data: JSON.stringify({
                    appId: data.appId,
                    channelId : channelId ,
                    cancel: isOpen ? 1 : 0
                }),
                contentType: 'application/json',
                url: _GATE_URL + '/api/msgs/publisher/msg/pullblack',
                success:function (res) {
                    parent.layer.closeAll();
                    updateList();
                },
                error: function(err) {
                    parent.layer.closeAll();
                }
            });
        }, function(){
            parent.layer.closeAll();
        });
    }

    // 获取所有的应用列表
    function getAppList () {
        ajaxHengyun({
            type:'get',
            url: _GATE_URL + '/api/developer/application/findAllList',
            success:function (res) {
                var data = res.data || [];
                var options = [];
                for (var i = 0; i < data.length; i++) {
                    var text = data[i].name;
                    var val = data[i].appId;
                    options.push('<option value='+text+'>'+text+'</option>');
                }
                $('#appId').append(options.join(''));
                initList();
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    // 事件绑定
    function bindEvent() {
        // 点击拉黑、取消拉黑
        $("#list").on('click', '.act', function() {
            doAct($(this).data('idx'));
        });

        // 点击查询
        $('#searchBtn').valid({
            form: '#search-condition',
            showAllError: true,
            checkpassed: function () {
                updateList(1, $(".ui-pg-selbox").val() || 10);
            }
        });
    }

    function init() {
        bindEvent();
        getAppList();
    }

    init();
});
