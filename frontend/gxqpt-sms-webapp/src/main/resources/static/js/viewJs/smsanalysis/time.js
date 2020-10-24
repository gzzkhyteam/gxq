$(function() {
    var chart1 = echarts.init(document.getElementById('chart1'));

    // 获取默认开始时间
    // function getDefaultStartDate() {
    //     var dateTime = new Date();
    //     var date = [];
    //     var year = dateTime.getFullYear();
    //     var month = dateTime.getMonth() + 1;
    //     if (month > 6) {
    //         month = month - 6;
    //     } else {
    //         month = month + 6;
    //         year = year - 1;
    //     }
    //     month = month < 10 ? '0' + month : month;
    //     var day = dateTime.getDate();
    //     date.push(year);
    //     date.push(month);
    //     date.push(day);
    //     return date.join('-');
    // }

    // // 获取默认结束时间
    // function getDefaultEndDate(dateTime) {
    //     var dateTime = new Date();
    //     var date = [];
    //     var year = dateTime.getFullYear();
    //     var month = dateTime.getMonth() + 1;
    //     month = month < 10 ? '0' + month : month;
    //     var day = dateTime.getDate();
    //     day = day < 10 ? '0' + day : day;
    //     date.push(year);
    //     date.push(month);
    //     date.push(day);
    //     return date.join('-');
    // }

    // 时间日期选择器初始化
    function initDatetimePicker() {
        //时间限制，开始时间不能大于结束时间
        $('#startTime').off('focus').on('focus', function () {
            WdatePicker({
                lang: 'zh-cn',
                // minDate: minOrMaxTime("endTime"),
                maxDate: CurentTime("endTime"),
                onpicked: onBlur("startTime"),
                dateFmt: 'yyyy-MM-dd',
                isShowClear: false
            });
        });
        // }).val(getDefaultStartDate());
        $('#endTime').off('focus').on('focus', function () {
            WdatePicker({
                lang: 'zh-cn',
                minDate: CurentTime("startTime"),
                // maxDate: minOrMaxTime("startTime"),
                onpicked: onBlur("endTime"),
                dateFmt: 'yyyy-MM-dd',
                isShowClear: false
            });
        });
        // }).val(getDefaultEndDate());

        function CurentTime(id) {
            if (id) {
                var time = $("#" + id).val();
                return time;
            }
        };

        function minOrMaxTime(id) {
            var time = $("#" + id).val().split('-');
            switch (id) {
                case 'endTime':
                    time[0] = Number(time[0]) - 1
                    break;
                case 'startTime':
                    time[0] = time[0] ? Number(time[0]) + 1 : new Date().getFullYear()
                    break;
            }
            return time.join('-');
        };

        function onBlur(id) {
            if (id) {
                $("#" + id).blur();
            }
        }
    }

    function drawChart1 (xData, yData) {
        var option = {
            color: ["#4f81bd","#c0504d"],
            title: {
                text: '短信时间分析图',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#333'
                }
            },
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '60px',
                right: '60px',
                bottom: '60px',
                containLabel: true
            },
            xAxis : {
                axisLabel: {
                    show: true,
                    rotate: 20
                },
                type : 'category',
                data : xData,
                axisTick: {
                    alignWithLabel: true
                }
            },
            yAxis : [{
                type : 'value'
            }],
            series : [{
                name:'短信使用量',
                type:'bar',
                barWidth: '60%',
                data: yData
            }]
        };
        chart1.setOption(option);
    }

    function getChart1 (startTime, endTime) {
        ajaxHengyun({               //各应用使用情况分析
            type: "get",
            url: _GATE_URL+"/api/sms/analysis/timestamp",
            data: {startTime: startTime, endTime: endTime},
            success: function (rows) {
                if (rows.data) {
                    var xData = [];
                    var yData = [];
                    for (var i = 0; i < rows.data.length; i++) {
                        var data = rows.data[i];
                        // 小于30天，以天为刻度
                        if (data.day) {
                            var year = data.year;
                            var month = data.month;
                            var day = data.day;
                            xData.push(year + '年' + month + '月' + day + '日');
                        // 30-90天，以周为刻度
                        } else if (data.week) {
                            xData.push(data.year + '年第' + data.week + '周');
                        // 大于90天，以月为刻度
                        } else {
                            xData.push(data.year + '年' + data.month + '月');
                        }
                        yData.push(data.count);
                    }
                    drawChart1(xData, yData);
                } else {
                    layer.msg(rows.errmsg, {time: 1000});
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                /*弹出jqXHR对象的信息*/
            }
        });
    }

    function search() {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        startTime = startTime ? startTime + " 00:00:00" : '';
        endTime = endTime ? endTime + " 23:59:59" : '';
        getChart1(startTime, endTime);
    }

    function bindEvent() {
        $('#search').on('click', function () {
            search();
        }).trigger('click');
    }
    initDatetimePicker();
    bindEvent()
});
