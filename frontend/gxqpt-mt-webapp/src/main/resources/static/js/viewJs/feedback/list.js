$(function () {
    // 格式化操作项
    function formatterAct(cellvalue, options, rawObject) {
        var close = rawObject.fbState == 3 ? '&close=true' : '';
        var splitLine = '<span class="oper-separator"></span>';
        var check = '<a class="ui-button" href="'+_cp+'/module/feedbackDeal?id=' + rawObject.id + close + '">\
                        <i class="fa fa-file-text-o"></i>查看</a>';
        var resolve = '<a class="ui-button" href="'+_cp+'/module/feedbackDeal?id=' + rawObject.id + '">\
                        <i class="fa fa-edit"></i>处理</a>';
        var close = '<a class="ui-button close-btn" data-id="' + rawObject.id + '" href="javascript:void(0);"\
                        <i class="fa fa-trash-o"></i>关闭</a>';
        // 未处理
        if (rawObject.fbState == 1) {
            return resolve + splitLine + close;
        }
        // 已处理
        if (rawObject.fbState == 2) {
            return check + splitLine + close;
        }
        return check;
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

    // 关闭
    function doClose(id) {
        ajaxHengyun({
            type: 'POST',
            data: {
                id: id
            },
            url: _GATE_URL + '/api/mt/feedback/closeFeedBack',
            success:function (res) {
                parent.layer.closeAll();
                layer.msg('关闭成功', {time: 1000});

                updateList();
            },
            error: function(err) {
                console.log(err);
            }
        });
    }

    function currentTime(id) {
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

    // 事件绑定
    function bindEvent() {
        /*跳转新增页面*/
        $("body").on("click",".btn-create",function(){
            window.location.href=_cp+"/module/applyCreate";
        });

        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:currentTime("endTime"),onpicked:onBlur("startTime"),dateFmt:'yyyy-MM-dd'});
        }).val(getDefaultStartDate());

        // 结束时间不能小于开始时间
        $('#endTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',minDate:currentTime("startTime"),onpicked:onBlur("endTime"),dateFmt:'yyyy-MM-dd'});
        }).val(getDefaultEndDate());

        // 点击关闭
        $('#list').on('click', '.close-btn', function () {
            var that = this
            window.parent.layer.confirm("您确认关闭吗？",{btn: ['确定','取消']},function(index) {
                doClose($(that).data('id'));
            });
        });

        // 点击查询
        $('.search-button').on('click', function () {
            updateList();
        });
    }

    function initTableList() {
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        //加载表格列表
        $("#list").jqGrid({
            mtype: 'POST',
            postData:{ pageNo:0, pageSize:20, data: {
                // 开始时间
                startCreateTime: startTime ? startTime + ' 00:00:00': '',
                // 结束时间
                endCreateTime: endTime ? endTime + ' 23:59:59' : ''
            }},
            url: _GATE_URL + '/api/mt/feedback/findList',
            contentType: 'application/json',
            dataType: 'json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['紧急程度', '反馈标题', '反馈内容', '反馈人', '登记日期', '处理状态','新消息','关闭人','关闭时间', '操作'],
            colModel: [{
                name: 'fbEmergency',
                width: '80',
                formatter: function (cellvalue) {
                    cellvalue = cellvalue || 0
                    return ['', '普通', '紧急', '非常紧急'][cellvalue]
                }
            }, {
                name: 'fbTitle',
                width: '60',
            }, {
                name: 'fbContent',
                width: '120',
                formatter: function (cellvalue){
                    return cellvalue;
                }
            }, {
                name: 'createUserName',
                width: '60',
            }, {
                name: 'createTime',
            }, {
                name: 'fbState',
                width: '60',
                formatter: function (cellvalue) {
                    cellvalue = cellvalue || 0;
                    return ['--', '未处理', '已处理', '已关闭'][cellvalue]
                }
            }, {
                name: 'msgNotRead',
                width: '60',
                formatter: function (cellvalue, options, rawObject) {
                    if (cellvalue == 0) {
                        return rawObject.msgTotal;
                    } else {
                        return '<span class="emergency">'+cellvalue + '/' + rawObject.msgTotal+'</span>';
                    }
                }
            }, {
                name: 'fbCloseName',
                width: '60',
            }, {
                name: 'fbCloseTime',
                width: '60',
            }, {
                // name: 'act',
                title: false,
                width: '120',
                align: 'center',
                formatter: formatterAct
            }],
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
                }
                var pageSize=$(".ui-pg-selbox").val();
                if(pageNo!=0){
                    updateList(pageNo, pageSize);
                    return false;
                }
            },
            gridComplete:function(){
                var $gridList = $("#list");
                var rowDatas = $gridList.jqGrid("getRowData");
                //处理少一行bug
                var allCountID = $gridList.jqGrid('getDataIDs');
                rowDatas.push($gridList.jqGrid('getRowData', allCountID[allCountID.length-1]));
                $.each(rowDatas, function(idx, obj){
                    // 非常紧急并且状态为未处理
                    if (obj.fbEmergency && obj.fbEmergency.indexOf("紧急") > -1 && obj.fbState == "未处理") {
                        $('#' + allCountID[idx]).addClass('emergency');
                    }
                });
            }
        });
    }

    // 更新列表
    function updateList (pageNo, pageSize) {
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        var postData = {
            data: {
                fbContent: $('input[name=fbContent]').val(),
                // 紧急程度(1普通，2紧急，3非常紧急)
                fbEmergency: '',
                // 处理状态（1未处理，2已处理，3已关闭）
                fbState: $('#fbState').val(),
                // 反馈标题
                fbTitle: "",
                // 开始时间
                startCreateTime: startTime ? startTime + ' 00:00:00': '',
                // 结束时间
                endCreateTime: endTime ? endTime + ' 23:59:59' : ''
            },
            pageNo: pageNo || $(".ui-pg-input").val() || 0,
            pageSize: parseInt(pageSize) || $(".ui-pg-selbox").val() || 20
        }
        $('#list').setGridParam({
            postData: postData
        }, true).trigger('reloadGrid');
    }

    function init() {
        bindEvent();
        initTableList();
    }

    init();
});