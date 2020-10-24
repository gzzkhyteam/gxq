$(function () {
    //日志级别数量echarts图表
    function leftBoxzxEcharts(xData, errorNum, debugNum, infoNum, failedNum, warnNum){
        var moduleNumAnalyse = echarts.init(document.getElementById('left-boxzx'));
        var option = {
            color:["#ed7d31","#a6a4a4","#ffc000","#4472c4","#70ad47"],
            title: {
                text: '日志级别数量',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            legend:{
                bottom: 0,
                data:["error日志数量","debug日志数量","info日志数量","failed日志数量","warn日志数量",]
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
                name:"error日志数量",
                data: errorNum,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            },{
                name:"debug日志数量",
                data: debugNum,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            },{
                name:"info日志数量",
                data: infoNum,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            },{
                name:"failed日志数量",
                data: failedNum,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            },{
                name:"warn日志数量",
                data: warnNum,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // error日志数量echarts图表
    function moduleNumAnalyseEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('right-boxzx'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: 'error日志数量',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{a0}<br/>{b0}: {c0}'
            },
            grid: {
                left: '9%',
                right: '4%',
                bottom: '12%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                axisLabel:{
                    interval: 0,
                    rotate:36
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
                name:"error日志数量",
                data: yDataOne,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 日志占比分析echarts图表
    function leftdownBoxzxEchart(data,indicator) {
        var moduleNumAnalyse = echarts.init(document.getElementById('leftdown-boxzx'));
        var option = {
            title: {
                text: '日志占比分析',
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
                name: '日志占比',
                type: 'pie',
                data : indicator
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 日志响应时间分析echarts图表
    function rightdownBoxzxEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('rightdown-boxzx'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '日志响应时间分析',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{a0}<br/>{b0}: {c0}'
            },
            grid: {
                left: '9%',
                right: '4%',
                bottom: '12%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                axisLabel:{
                    interval: 0,
                    rotate:36
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
                name:"日志响应时间",
                data: yDataOne,
                type: 'line',
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

    // 获取日志级别数量数据
    function leftBoxzx(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findLogLevelMonthCount",
            datatype: 'json',
            success: function (rows) {
                var xData = [], errorNum = [], debugNum = [], infoNum = [], failedNum = [], warnNum = [];
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
                                switch (row.level){
                                    case "error":
                                        errorNum.push(row.count);
                                        break;
                                    case "debug":
                                        debugNum.push(row.count);
                                        break;
                                    case "info":
                                        infoNum.push(row.count);
                                        break;
                                    case "failed":
                                        failedNum.push(row.count);
                                        break;
                                    case "warn":
                                        warnNum.push(row.count);
                                        break;
                                }
                            })
                        });
                    };
                }
                leftBoxzxEcharts(xData, errorNum, debugNum, infoNum, failedNum, warnNum);
            }
        });
    }

    // 获取error日志数量数据
    function moduleNumAnalyse(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findErrorLogMonthCount",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data.currentCount;
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
                moduleNumAnalyseEchart(xData, count);
            }
        });
    }

    //获取日志占比分析数据
    function findLogSortCount(){
        var data=[];
        var indicator = [];
        ajaxHengyun({
            type: "GET",
            async:false,
            url: _GATE_URL+"/api/logs/findLogSortCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var rowsObj = dealElement(rows.data,0);
                    if(rowsObj){
                        maxVal = Math.max.apply(null,data) +10;
                        rowsObj.forEach(function(val,index){
                            var obj = {
                                name: val.level+'日志数量',
                                value: val.count,
                            };
                            indicator.push(obj);
                            data.push(val.level+'日志数量');
                        });

                    };
                }
                leftdownBoxzxEchart(data,indicator);
            }
        });
    }

    // 获取日志响应时间分析数据
    function rightdownBoxzx(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findLogRespondMonth",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {debugger;
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            var dateName = val.year+"年"+val.month+"月";
                            xData.push(dateName);
                            if(!val.respondTime){
                                val.respondTime=0;
                            };
                            count.push(val.respondTime);
                        });
                    };
                }
                rightdownBoxzxEchart(xData, count);
            }
        });
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
        getSystemList();
        leftBoxzx();
        moduleNumAnalyse();
        findLogSortCount();
        rightdownBoxzx();
    }
    init();
});