$(function() {
    var chart1 = echarts.init(document.getElementById('chart1'));
    var mainMobile = '';

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
    function getDefaultEndDate(dateTime) {
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

    function drawChart1 (left, right) {
        echarts.util.each(left.children, function (datum, index) {
            index % 2 === 0 && (datum.collapsed = true);
        });

        var option = {
            color: ["#4f81bd","#c0504d"],
            tooltip: {
                trigger: 'item',
                triggerOn: 'mousemove'
            },
            series:[{
                type: 'tree',
                data: [left],
                top: '1%',
                left: '15%',
                bottom: '1%',
                right: '55%',
                symbolSize: 7,
                orient: 'RL',
                label: {
                    position: 'right',
                    verticalAlign: 'middle',
                    align: 'left'
                },
                leaves: {
                    label: {
                        position: 'left',
                        verticalAlign: 'middle',
                        align: 'right'
                    }
                },
                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750,
                initialTreeDepth: 1
            }, {
                type: 'tree',
                data: [right],
                top: '1%',
                left: '55%',
                bottom: '1%',
                right: '15%',
                symbolSize: 7,
                orient: 'LR',
                label: {
                    position: 'left',
                    verticalAlign: 'middle',
                    align: 'right'
                },
                leaves: {
                    label: {
                        position: 'right',
                        verticalAlign: 'middle',
                        align: 'left'
                    }
                },
                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750,
                initialTreeDepth: 1
            }]
        };

        chart1.setOption(option);
    }

    function getChart1 (startTime, endTime) {
        if(!mainMobile){
            drawChart1({
                name: '本人收到',
                children: []
            }, {
                name: '本人发出',
                children: []
            })
            return false;
        }
        ajaxHengyun({               //各应用使用情况分析
            type: "get",
            data: {
                startTime: startTime,
                endTime: endTime,
                mainMobile: mainMobile
            },
            url: _GATE_URL+"/api/sms/analysis/atlas",
            success: function (res) {
                if (res.errcode === 0) {
                    var data = res.data;
                    drawChart1({
                        name: '本人收到',
                        children: res.data.senderList
                    }, {
                        name: '本人发出',
                        children: res.data.reciveTopicList
                    })
                } else {
                    layer.msg(res.errmsg, {time: 1000});
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {}
        });
    }

    function search() {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        startTime = startTime + " 00:00:00";
        endTime = endTime + " 23:59:59";
        getChart1(startTime, endTime);
    }

    function bindEvent() {
        $('#search').on('click', function () {
            search();
        }).trigger('click');
    }

    function getUserInfo () {
        ajaxHengyun({ // 各应用使用情况分析
            type: "get",
            async: false, // 同步请求，因为需要user的手机号才能查询数据
            url: _GATE_URL+"/api/admin/user/get",
            success: function (rows) {
                if (rows.data) {
                    mainMobile = rows.data.phone;
                } else {
                    layer.msg(rows.errmsg, {time: 1000});
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {}
        });
    }

    initDatetimePicker();
    getUserInfo();
    bindEvent();
    search();
    // drawChart1({
    //     name: 'first-left',
    //     children: [{
    //         name: 'second-left'
    //     }]
    // }, {
    //     name: 'first-right',
    //     children: [{
    //         name: 'second-right'
    //     }]
    // })
});
