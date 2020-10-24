$(function () {
    //不同等级告警数量统计echarts图表
    function leftBoxzxEcharts(xData, oneNum, twoNum, threeNum){
        var moduleNumAnalyse = echarts.init(document.getElementById('left-boxzx'));
        var option = {
            color:["#ed7d31","#a6a4a4","#ffc000","#4472c4","#70ad47"],
            title: {
                text: '不同等级告警数量统计',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            legend:{
                bottom: 0,
                data:["一级告警","二级告警","三级告警"]
            },
            tooltip:{
                show: true,
                formatter: '{b0}<br/>{a0}: {c0}个'
            },
            grid: {
                left: '5%',
                right: '4%',
                bottom: '12%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                axisLabel:{
                    interval: 0,
                    rotate:30
                },
                splitLine:{
                    show:false,
                },
                data: xData
            },
            yAxis: {
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"一级告警",
                data: oneNum,
                type: 'bar',
                barWidth:15
            },{
                name:"二级告警",
                data: twoNum,
                type: 'bar',
                barWidth:15
            },{
                name:"三级告警",
                data: threeNum,
                type: 'bar',
                barWidth:15
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 告警数量分析echarts图表
    function warningEchart(xData, yData) {
        var moduleNumAnalyse = echarts.init(document.getElementById('right-boxzx'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '告警数量统计',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b0}<br/>{a0}: {c0}'
            },
            grid: {
                left: '9%',
                right: '4%',
                bottom: '20%',
            },
            xAxis: {
                type: 'category',
                splitLine:{
                    show:false,
                },
                axisLabel:{
                    interval: 0,
                    rotate:30
                },
                data: xData
            },
            yAxis: [{
                type: 'value',
                splitLine:{
                    show:false,
                },
                axisLabel: {
                    formatter: '{value}'
                }
            }],
            series: [{
                name:"告警数量",
                data: yData,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 告警类型数量占比echarts图表
    function leftdownBoxzxEchart(data,indicator) {
        var moduleNumAnalyse = echarts.init(document.getElementById('leftdown-boxzx'));
        var option = {
            title: {
                text: '告警类型数量占比',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            legend:{
                data:data,
                bottom: 0,
            },
            tooltip:{
                show: true,
                formatter: '{a0}<br/>{b0}: {d0}%'
            },
            grid: {
                left: '3%',
                right: 0,
                bottom: '30%',
                containLabel: true
            },
            series: [{
                name: '告警类型',
                type: 'pie',
                data : indicator
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 日志分类数量echarts图表
    function radarEchart(indicator,data,max) {
        var moduleNumAnalyse = echarts.init(document.getElementById('rightdown-boxzx'));
        var indicatorDefault = [
            { name: '一级告警', max: max},
            { name: '二级告警', max: max},
            { name: '三级告警', max: max},
        ];
        var option = {
            title: {
                text: '告警级别数量占比',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip: {},
            radar: {
                // shape: 'circle',
                name: {
                    textStyle: {
                        color: '#28A4D7',
                        backgroundColor: '#999',
                        borderRadius: 3,
                        padding: [3, 5]
                    }
                },
                indicator: indicator?indicator:indicatorDefault
            },
            series: [{
                name: '告警级别数量占比',
                type: 'radar',
                // areaStyle: {normal: {}},
                data : [
                    {
                        value : data,
                        name : '告警级别数量占比'
                    }
                ]
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    //获取应用系统
    function getSystemList() {
        ajaxHengyun({
            type: "GET",
            async: false,
            dataType: 'json',
            url:  _GATE_URL+"/api/developer/application/findList",
            data:{type:1},
            success: function (rows) {
                if (rows.data) {
                    $('#appId').append('<option value=""></option>');
                    var arr = rows.data;
                    for(var i=0;i<arr.length;i++){
                        var appId = arr[i].appId;
                        var name = arr[i].name;
                        $('#appId').append('<option value='+appId+'>'+name+'</option>');

                    }
                }
            }
        });
    }

    // 获取不同等级告警数量统计数据
    function leftBoxzx(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findLogWarnMonth",
            datatype: 'json',
            success: function (rows) {
                var xData = [], oneNum = [], twoNum = [], threeNum = [];
                var dataSeries = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            if(!val){
                                return false;
                            }
                            var dateName = val[0].year+"年"+val[0].month+"月";
                            xData.push(dateName);
                            val.forEach(function(row,num){
                                switch (row.logType){
                                    case "一级":
                                        oneNum.push(row.count);
                                        break;
                                    case "二级":
                                        twoNum.push(row.count);
                                        break;
                                    case "三级":
                                        threeNum.push(row.count);
                                        break;
                                }
                            })
                        });
                    };
                }
                leftBoxzxEcharts(xData, oneNum, twoNum, threeNum);
            }
        });
    }

    // 获取告警数量分析数据warning
    function warning(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnCount",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            var dateName = val.year+"年"+val.month+"月";
                            xData.push(dateName);
                            if(!val.count){
                                val.count=0;
                            };
                            count.push(val.count);
                        });
                    };
                }
                warningEchart(xData, count);
            }
        });
    }

    //获取告警类型数量占比数据
    function findLogSortCount(){
        var data=[];
        var indicator = [];
        ajaxHengyun({
            type: "GET",
            async:false,
            url: _GATE_URL+"/api/logs/findLogWarnTypeMonth",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var rowsObj = dealElement(rows.data,0);
                    if(rowsObj){
                        maxVal = Math.max.apply(null,data) +10;
                        rowsObj.forEach(function(val,index){
                            var obj = {
                                name: val.logType,
                                value: val.count,
                            };
                            indicator.push(obj);
                            data.push(val.logType);
                        });

                    };
                }
                leftdownBoxzxEchart(data,indicator);
            }
        });
    }

    // 获取告警类型数量占比数据radar
    function radar(){
        var data=[];
        var indicator = [];
        var maxVal = 10;
        ajaxHengyun({
            type: "GET",
            async:false,
            url: _GATE_URL+"/api/logs/findLogWarnLevleCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {debugger;
                    var rowsObj = dealElement(rows.data,0);
                    if(rowsObj){
                        rowsObj.forEach(function(val,index){
                            data.push(val.count);
                        });
                        maxVal = Math.max.apply(null,data) +10;
                        rowsObj.forEach(function(val,index){
                            var obj = {
                                name: val.logType+'告警',
                                max: maxVal,
                            };
                            indicator.push(obj);
                        });

                    };
                }
            }
        });
        radarEchart(indicator,data,maxVal);
    }

    //格式化对象中的值
    function dealElement(obj,val){
        if ( obj === null || obj === undefined || obj === "" ) return obj;
        for ( var key in obj ){
            if ( obj[key] == null){
                obj[key]=val;
            }
        }
        return obj;
    }

    function init(){
        // getSystemList();
        leftBoxzx();
        warning();
        findLogSortCount();
        radar();
    }
    init();
});