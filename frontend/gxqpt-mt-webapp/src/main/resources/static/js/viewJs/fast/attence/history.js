$(function () {
    // 获取打卡记录列表
    function getList() {
        $("#list").jqGrid({
            mtype: 'POST',
            url: _GATE_URL + '/api/mt/punchClock/findPunchclockPage',
            postData: {
                data: {
                    adceType: null,//考勤类型:1,内勤；2，外勤
                    clockType: null, //打卡类型:1,签到；2，签退
                    startCreateTime: getDefaultStartDate() + ' 00:00:00',
                    endCreateTime: getDefaultEndDate() + ' 23:59:59'
                },
                pageNo: 1,
                pageSize: 20
            },
            datatype: "json",
            contentType: 'application/json',
            serializeGridData: function (postData) {
                return JSON.stringify(postData);
            },
            colNames: ['考勤类型','打卡类型', '打卡时间', '打卡地点', '备注', '操作'],
            colModel: [
                {name: 'adceType', index: 'adceType', hidden:true},
                {name: 'clockType', index: 'clockType', sortable: false, "width": '50',formatter:formatterType},
                {name: 'clockTime', index: 'clockTime', sortable: false, "width": '50'},
                {name: 'location', index: 'location', sortable: false, "width": '80'},
                {name: 'outterReason', index: 'outterReason', sortable: false},
                {
                    name: '',
                    sortable: false,
                    width: '30',
                    formatter: formatterAct
                }
            ],
            pager: '#pager',
            height: 'auto',
            jsonReader: {
                root: "data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            prmNames: {
                page: "page", // 表示请求页码的参数名称
                rows: "rows" // 表示请求行数的参数名称
            },
            onPaging: function (pgButton) {
                var pageNo = $(".ui-pg-input").val();
                pageNo = parseInt(pageNo);
                var total = ($("#sp_1_pager_toppager").text()).replace(/,/g,'');
                total = parseInt(total);
                if (pgButton == "next") {
                    if (pageNo >= total) {
                        return false;
                    } else {
                        pageNo += 1;
                    }
                } else if (pgButton == "prev") {
                    if (pageNo > 1) {
                        pageNo -= 1;
                    } else {
                        return false;
                    }
                } else if (pgButton == "last") {
                    pageNo = total;
                } else if (pgButton == "first") {
                    pageNo = 1;
                }
                var pageSize = $(".ui-pg-selbox").val();
                if (pageNo != 0) {
                    updateList(pageNo, pageSize);
                    return false;
                }
            }
        });
    }

    //初始化打卡类型
    function formatterType(cellvalue, options, rawObject){
        var adceTypeText = "",clockTypeText = "";
        if (rawObject.adceType==1) {
           adceTypeText = "内勤";
        } else if (rawObject.adceType==2) {
           adceTypeText = "外勤";
        }

        if(rawObject.clockType==1){
            clockTypeText = "签到";
        } else if (rawObject.clockType==2){
            clockTypeText = "签退";
        }

        if (adceTypeText && clockTypeText) {
            return adceTypeText + clockTypeText;
        } else {
            return "";
        }
    }

    //初始化操作
    function formatterAct(cellvalue, options, rawObject){
        return '<a href="historyDetail?id='+rawObject.id+'">查看</a>';
    }

    // 更新列表
    function updateList(pageNo, pageSize) {
        var startTime = $('input[name="startTime"]').val();
        var endTime = $('input[name="endTime"]').val();
        var codeType =$("#codeType").val();
        var adceType = null,clockType = null;

        if(codeType){
            adceType = codeType.split("")[0];
            clockType = codeType.split("")[1];
        }

        var postData = {
            data: {
                //考勤类型:1,内勤；2，外勤
                adceType: adceType,
                //打卡类型:1,签到；2，签退
                clockType: clockType,
                // 发布日期-开始
                startCreateTime: startTime ? startTime + ' 00:00:00' : '',
                // 发布日期-结束
                endCreateTime: endTime ? endTime + ' 23:59:59' : ''
            },
            pageNo: pageNo || $(".ui-pg-input").val() || 1,
            pageSize: pageSize || $(".ui-pg-selbox").val() || 20
        }

        $('#list').setGridParam({
            postData: postData
        }).trigger('reloadGrid');
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
        $("button.search-button").on('click', function(){
            updateList(1, 20);
        });
    }

    initDatetimePicker();
    bindEvent();
    getList();
});
