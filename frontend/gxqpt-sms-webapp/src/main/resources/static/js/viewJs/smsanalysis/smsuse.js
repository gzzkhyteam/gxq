$(function() {
    var chart1 = echarts.init(document.getElementById('chart1'));
    var chart2 = echarts.init(document.getElementById('chart2'));

    function drawChart1 (xData, yData) {
        var option = {
            color: ["#4f81bd","#c0504d"],
            title: {
                text: '各应用使用情况分析',
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
            xAxis : [{
                type : 'category',
                data : xData,
                axisTick: {
                    alignWithLabel: true
                }
            }],
            yAxis : [{
                type : 'value'
            }],
            series : [{
                name:'短信',
                type:'bar',
                barWidth: '60%',
                data: yData
            }]
        };
        chart1.setOption(option);
    }

    function drawChart2 (xData, yData) {
        var option = {
            color: ["#4f81bd","#c0504d"],
            title: {
                text: '各服务使用情况分析',
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
            xAxis : [{
                type : 'category',
                data : xData,
                axisTick: {
                    alignWithLabel: true
                }
            }],
            yAxis : [{
                type : 'value'
            }],
            series : [{
                name:'短信',
                type:'bar',
                barWidth: '60%',
                data: yData
            }]
        };
        chart2.setOption(option);
    }

    function getChart1 () {
        ajaxHengyun({               //各应用使用情况分析
            type: "get",
            url: _GATE_URL+"/api/sms/analysis/applications",
            success: function (rows) {
                if (rows.errcode === 0) {
                    if(!rows.data){
                        rows.data = []
                    }
                    var xData = [];
                    var yData = [];
                    for (var i = 0; i < rows.data.length; i++) {
                        xData.push(rows.data[i].name);
                        yData.push(rows.data[i].count);
                    }
                    drawChart1(xData, yData);
                } else {
                    layer.msg("数据加载失败，请稍后重试！", {time: 1000});
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                /*弹出jqXHR对象的信息*/
            }
        });
    }

    function getChart2 () {
        ajaxHengyun({               //各应用使用情况分析
            type: "get",
            url: _GATE_URL+"/api/sms/analysis/services",
            success: function (rows) {
                if (rows.errcode === 0) {
                    if(!rows.data){
                        rows.data = []
                    }
                    var xData = [];
                    var yData = [];
                    for (var i = 0; i < rows.data.length; i++) {
                        xData.push(rows.data[i].name);
                        yData.push(rows.data[i].count);
                    }
                    drawChart2(xData, yData);
                } else {
                    layer.msg("数据加载失败，请稍后重试！", {time: 1000});
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                /*弹出jqXHR对象的信息*/

            }
        });
    }

    getChart1();
    getChart2();
});
