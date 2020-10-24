$(function () {
    var isSend = getQuery('isSend') != 'false';
    var tableInstance = '';

    // 获取查询参数
    function getQuery (name) {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;  
    }
    // 获取打卡记录列表
    function getList() {
        // 打卡列表
        $("#list").jqGrid({
            mtype: 'POST',
            url: _GATE_URL + '/api/mt/apprApply/findApprApplyPage',
            postData: {
                data: {
                    startCreateTime: getDefaultStartDate() + ' 00:00:00',
                    endCreateTime: getDefaultEndDate() + ' 23:59:59',
                    isFromMe: isSend
                },
                pageNo: 1,
                pageSize: 20
            },
            datatype: "json",
            contentType: 'application/json',
            serializeGridData: function(postData){
                return JSON.stringify(postData);
            },
            fileName: '考勤审批',
            colNames: [ '审批编号', '申请类型', '提交时间', '申请人', '当前环节', '状态', '操作'],
            colModel: [
                {name: 'aprCode', index : 'aprCode', sortable : false,"width":'210'},
                {
                    name: 'aprType',
                    index : 'aprType',
                    sortable : false,
                    width: '210',
                    formatter: function (cellvalue) {
                        var aprTypes = {
                            overtime: '加班',
                            leave: '请假',
                            business: '出差',
                            outside: '外勤',
                            supply: '补签'
                        };
                        return aprTypes[cellvalue];
                    }
                },
                {name: 'createTime', index : 'createTime', sortable : false,"width":'210'},
                {
                    name: 'applyUserName',
                    index: 'applyUserName',
                    sortable: false,
                    width: '100'
                },
                {
                    name: 'curAprUserName',
                    index : 'curAprUserName',
                    sortable : false,
                    width: '210',
                    formatter: function (cellvalue, options, row) {
                        if (row.curState == 2 || row.curState == 3 || row.curState == 5) {
                            return '--';
                        }
                        return cellvalue + '审批';
                    }
                },
                {
                    name: 'curState',
                    index : 'curState',
                    sortable : false,
                    width: '210',
                    formatter: function (cellvalue) {
                        return ['', '审批中', '已驳回', '已结束', '撤销中', '已撤销'][cellvalue]
                    }
                },
                {
                    name: '',
                    sortable : false,
                    width: '210',
                    formatter: function (cellvalue, options, rowObject) {
                        var isSend = $('#send label.active').data('send');
                        var check = '<a href="detail?id=' + rowObject.id + '&isSend='+isSend+'" class="handle">查看</a>'
                        var deal = '<a href="detail?deal=true&id=' + rowObject.id + '&isSend='+isSend+'" class="handle">办理</a>'
                        var spliter = '<span class="spliter">|</span>';
                        // 我发出的，或者我收到的但不是审批中，或者我收到的是审批中但还没轮到我审批
                        if (isSend || rowObject.curState != 1 || rowObject.curAprUserId != $.cookie('_user_id')) {
                            return check;
                        } else {
                            return check + spliter + deal;
                        }
                    }
                }
            ],
            pager: '#pager',
            height: 'auto',
            jsonReader: {
                root:"data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            prmNames: {
                page: "page", // 表示请求页码的参数名称
                rows: "rows" // 表示请求行数的参数名称
            },
            loadComplete: function () {
                // initExport('#list');
                if (!tableInstance) {
                    // exportTable();
                }
                if (isSend) {
                    $("#list").setGridParam().hideCol("applyUserName");
                } else {
                    $("#list").setGridParam().showCol("applyUserName");
                }
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
            }
        });
    }

    // 更新列表
    function updateList (pageNo, pageSize) {
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        isSend = $('#send label.active').data('send');
        var postData = {
            data: {
                // 我发出的
                isFromMe: isSend,
                // 我收到的
                isPassMe: !isSend,
                // 审批类型
                aprType: $('#aprType').val(),
                // 状态
                curState: parseInt($('#curState').val()) || '',
                // 时间-开始
                startCreateTime: startTime ? startTime + ' 00:00:00': '',
                // 时间-结束
                endCreateTime: endTime ? endTime + ' 23:59:59' : ''
            },
            pageNo: Number(pageNo || $(".ui-pg-input").val() || 0),
            pageSize: Number(pageSize || $(".ui-pg-selbox").val() || 20)
        }
        $('#list').setGridParam({
            postData: postData
        }, true).trigger('reloadGrid');
    }

    // 获取默认开始时间
    function getDefaultStartDate() {
        var dateTime = new Date();
        var date = [];
        var year = dateTime.getFullYear();
        var month = dateTime.getMonth() + 1;
        month = month < 10 ? '0' + month : month;
        var day = '01';
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
        day = day < 10 ? '0' + day : day;
        date.push(year);
        date.push(month);
        date.push(day);
        return date.join('-');
    }

    // 时间日期选择器初始化
    function initDatetimePicker() {
        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus', function () {
            WdatePicker({
                lang: 'zh-cn',
                maxDate: CurentTime("endTime"),
                onpicked: onBlur("startTime"),
                dateFmt: 'yyyy-MM-dd',
                isShowClear: false
            });
        }).val(getDefaultStartDate());
        $('#endTime').off('focus').on('focus', function () {
            WdatePicker({
                lang: 'zh-cn',
                minDate: CurentTime("startTime"),
                onpicked: onBlur("endTime"),
                dateFmt: 'yyyy-MM-dd',
                isShowClear: false
            });
        }).val(getDefaultEndDate());

        function CurentTime(id) {
            if (id) {
                var time = $("#" + id).val();
                return time;
            }
        };

        function onBlur(id) {
            if (id) {
                $("#" + id).blur();
            }
        }
    }

    // 事件绑定
    function bindEvent() {
        // 初始化查询按钮
        $("button.search-button").on('click', function () {
            updateList();
        });

        // 切换我收到的-我发出的
        $('#send label').on('click', function () {
            if (!$(this).hasClass('active')) {
                $('#send label').removeClass('active');
                $(this).addClass('active');
                updateList();
            }
        });
    }

    // 定义导出表格
    function exportTable() {
        /* default charset encoding (UTF-8) */
        $.fn.tableExport.charset = "charset=utf-8";
        /* default class to style buttons when not using bootstrap  */
        $.fn.tableExport.defaultButton = "button-default";

        tableInstance = $("#list").tableExport({
            headings: true,
            footers: true,
            formats: ["csv"],
            fileName: "id",
            bootstrap: true,
            position: "bottom",
            ignoreRows: null,
            ignoreCols: null,
            ignoreCSS: ".tableexport-ignore",
            emptyCSS: ".tableexport-empty",
            trimWhitespace: false
        });
    }

    initDatetimePicker();
    bindEvent();
    if (!isSend) {
        $('#send label').removeClass('active');
        $('#send label[data-send="false"]').addClass('active');
    }
    getList();
    // in app.js
    initExport('#list',{
        // 隐藏自定义导出按钮
        exceptSelf: true,
        // 隐藏导出本页按钮
        exceptCurr: true
    });
    // exportTable();
});
