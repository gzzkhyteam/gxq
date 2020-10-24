$(function () {
    function getDateRange() {
        // 结束日期
        var date = new Date()
        // 当前日期往前推30天
        // var startDate = new Date(time - 30 * 24 * 60 * 60 * 1000)
        var day = date.getDate();
        return {
            start: date.getFullYear()+'-'+(date.getMonth() + 1)+'-'+'01',
            end: date.getFullYear()+'-'+(date.getMonth() + 1)+'-'+(day > 1 ? day - 1 : ('0' + day))
        }
    }

    // 时间日期选择器初始化
    function initDatetimePicker() {
        var date = getDateRange()
        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus',function(){
            WdatePicker({lang:'zh-cn',maxDate:CurentTime("endTime"),onpicked:onBlur("startTime"),dateFmt:'yyyy-MM-dd',isShowClear: false});
        }).val(date.start);
        $('#endTime').off('focus').on('focus',function(){
            WdatePicker({
                lang:'zh-cn',
                minDate: CurentTime("startTime"),
                maxDate: date.end,
                onpicked:onBlur("endTime"),
                dateFmt:'yyyy-MM-dd',
                isShowClear: false
            });
        }).val(date.end);
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
        }
    }

    // 更新列表
    function updateList (pageNo, pageSize) {
        $('.Validform_info').remove();
        var startTime = $('input[name="startAttDay"]').val();
        startTime = startTime ? startTime + ' 00:00:00' : '2000-01-01 00:00:00';
        var endTime = $('input[name="endAttDay"]').val();
        endTime = endTime ? endTime + ' 23:59:59' : '3000-01-01 00:00:00';
        var postData = {
            data: {
                startAttDay: startTime,
                endAttDay: endTime
            },
            pageNo: pageNo || $(".ui-pg-input").val() || 1,
            pageSize: pageSize || $(".ui-pg-selbox").val() || 20
        }
        $('#list').setGridParam({
            postData:postData
        },true).trigger('reloadGrid');
    }

    // 初始化表格
    function initList () {
        var startTime = $('input[name="startAttDay"]').val();
        startTime = startTime ? startTime + ' 00:00:00' : '2000-01-01 00:00:00';
        var endTime = $('input[name="endAttDay"]').val();
        endTime = endTime ? endTime + ' 23:59:59' : '3000-01-01 00:00:00';
        //表格列表初始化
        $("#list").jqGrid({
            mtype: 'POST',
            postData:{ pageNo:1, pageSize:20, data: {
                startAttDay: startTime,
                endAttDay: endTime
            }},
            url: _GATE_URL + '/api/mt/punchAttendanceStatics/webQueryMyStatics',
            datatype: "json",
            contentType : 'application/json',
            serializeGridData:function(postData){
                return JSON.stringify(postData);
            },
            colNames: ['日期', '星期', '应出勤天', '是否出勤', '旷工（次）', '迟到（分钟）', '早退（分钟）', '出差（小时）', '加班（小时）', '请假（小时）', '外勤（小时）'],
            colModel: [{
                name: 'attDay',
                index: 'attDay',
                width: '160',
            }, {
                name: 'weekDay',
                index: 'weekDay',
                formatter: function (cellvalue, options, rawObject) {
                    if(rawObject.attDay=="合计"){
                        return "--";
                    }else if(rawObject.attDay && rawObject.attDay!="合计"){
                        return ['一', '二', '三', '四', '五', '六', '日', '--'][cellvalue == 0 ? 0 : (cellvalue || 7)];
                    }else{
                        return "--";
                    }
                }
            }, {
                name: 'isWorkDay',
                index: 'isWorkDay',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return raw.needDays
                    }
                    return cellvalue
                }
            }, {
                name: 'isToWork',
                index: 'isToWork',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return raw.allIsToWork
                    }
                    return cellvalue
                }
            }, {
                name: 'minerCount',
                index: 'minerCount',
                formatter: function (cellvalue, options, raw) {
                    return cellvalue ? cellvalue + '次' : '--'
                }
            }, {
                name: 'lateHour',
                index: 'lateHour',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return (raw.lateHourTime || 0) + '次共' + (parseInt(cellvalue * 60) || 0) + '分钟'
                    }
                    return (parseInt(cellvalue * 60) || 0) || '--'
                }
            }, {
                name: 'earlyHour',
                index: 'earlyHour',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return (raw.earlyHourTime || 0) + '次共' + (parseInt(cellvalue * 60) || 0) + '分钟'
                    }
                    return (parseInt(cellvalue * 60) || 0) || '--'
                }
            }, {
                name: 'travelHous',
                index: 'travelHous',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return (raw.travelHousTime || 0) + '次共' + (cellvalue || 0) + '小时'
                    }
                    return cellvalue || '--'
                }
            }, {
                name: 'workHous',
                index: 'workHous',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return (raw.workHousTime || 0) + '次共' + (cellvalue || 0) + '小时'
                    }
                    return cellvalue || '--'
                }
            }, {
                name: 'leaveHous',
                index: 'leaveHous',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return (raw.leaveHousTime || 0) + '次共' + (cellvalue || 0) + '小时'
                    }
                    return cellvalue || '--'
                }
            }, {
                name: 'outHous',
                index: 'outHous',
                formatter: function (cellvalue, options, raw) {
                    if(raw.attDay=="合计"){
                        return (raw.outHousTime || 0) + '次'
                    }
                    return cellvalue || '--'
                }
            }],
            pager: '#pager',
            height: 'auto',
            jsonReader : {
                root: "data.list",
                page: "data.pageNum",
                total: "data.pages",
                records: "data.total"
            },
            footerrow: true,
            loadComplete: function (data) {
                var ids = $('#list').getDataIDs() || [];
                if (ids.join(',').indexOf('null') > 0 || (data.data.list && data.data.list.length == (Number(data.data.pageSize) + 1))) {
                    $('#list').delRowData('null');
                    $("#list").footerData('set', data.data.list[data.data.list.length - 1]);
                    $('.footrow').show();
                } else {
                    $('.footrow').hide();
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

    // 事件绑定
    function bindEvent() {
        // 点击查询
        $('#searchBtn').valid({
            form: '#search-condition',
            showAllError: true,
            checkpassed: function () {
                updateList(1, $(".ui-pg-selbox").val() || 20);
            }
        });
    }

    function init() {
        bindEvent();
        initDatetimePicker();
        initList();
    }

    init();
});
