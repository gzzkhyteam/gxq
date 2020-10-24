$(function () {
    // error日志数量echarts图表
    function moduleNumAnalyseEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('moduleNumAnalyse'));
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
    // 日志类型数量分析echarts图表
    function discardedEchart(xData, yData, yData1, yData2, yData3) {
        var moduleNumAnalyse = echarts.init(document.getElementById('discarded'));
        var option = {
            title: {
                text: '日志类型数量分析',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            legend:{
                data:["应用系统日志","Apache日志","Nginx日志","Tomcat日志"],
                bottom: 0,
            },
            tooltip:{
                show: true,
                formatter: '{b0}日志数量<br/>{a0}: {c0}'
            },
            grid: {
                left: '9%',
                right: 0,
                bottom: '30%',
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
                name:"应用系统日志",
                data: yData,
                type: 'line',
            },{
                name:"Apache日志",
                data: yData1,
                type: 'line',
            },{
                name:"Nginx日志",
                data: yData2,
                type: 'line',
            },{
                name:"Tomcat日志",
                data: yData3,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 告警数量分析echarts图表
    function warningEchart(xData, yData) {
        var moduleNumAnalyse = echarts.init(document.getElementById('warning'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '告警数量分析',
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

    // TOP20echarts图表
    function topTwentyEchart(xData, yData) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topTwenty'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '告警次数最多系统top20',
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
                left: '36%',
                right: '4%',
                bottom: '10%',
            },
            xAxis: {
                type: 'value',
                splitLine:{
                    show:false,
                },
                axisLabel: {
                    formatter: '{value}'
                }
            },
            yAxis: {
                type: 'category',
                splitLine:{
                    show:false,
                },
                axisLabel:{
                    interval: 0,
                },
                data: xData
            },
            series: [{
                name:"告警数量",
                data: yData,
                barWidth: 20,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    //查询日志error总数及当前error数
    function findErrorLogCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findErrorLogCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#errorCount").html(value.errorCount);
                    $("#currentCount").html(value.currentCount);
                }
            }
        });
    }

    //查询日志warn警告总数及当前warn警告数
    function findWarnLogCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnLogCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#warnCount").html(value.warnCount);
                    $("#warnCurrentCount").html(value.currentCount);
                }
            }
        });
    }

    //查询日志warn警告未处理总数
    function findWarnNotDealCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnNotDealCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#warnNotDealCount").html(value.warnNotDealCount);
                }
            }
        });
    }

    //查询日志warn警告已处理总数及本月处理总数
    function findWarnDealCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnDealCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#warnDealCount").html(value.warnDealCount);
                    $("#currentWarnDealCount").html(value.currentWarnDealCount);
                }
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
	// 获取日志类型数量分析数据
    function discarded(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findLogTypeCount",
            datatype: 'json',
            success: function (rows) {
                var xData = [], apacheCount = [], appCount = [], nginxCount = [], tomcatCount = [];
                if (rows.data) {
                    var rowsArray = rows.data.apache;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            var dateName = val.year+"年"+val.month+"月";
                            xData.push(dateName);
                            if(!val.count){
                                val.count=0;
                            };
                            apacheCount.push(val.count);
                        });
                    };
                    var rowsAppArray = rows.data.app;
                    if(rowsAppArray){
                        rowsAppArray.forEach(function(valApp,indexApp){
                            if(!valApp.count){
                                valApp.count=0;
                            };
                            appCount.push(valApp.count);
                        });
                    };
                    var rowsNginxArray = rows.data.nginx;
                    if(rowsNginxArray){
                        rowsNginxArray.forEach(function(valNginx,indexNginx){
                            if(!valNginx.count){
                                valNginx.count=0;
                            };
                            nginxCount.push(valNginx.count);
                        });
                    };
                    var rowsTomcatArray = rows.data.tomcat;
                    if(rowsTomcatArray){
                        rowsTomcatArray.forEach(function(valTomcat,indexTomcat){
                            if(!valTomcat.count){
                                valTomcat.count=0;
                            };
                            tomcatCount.push(valTomcat.count);
                        });
                    };

                }
                discardedEchart(xData, appCount, apacheCount, nginxCount, tomcatCount);
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

    // 获取TOP20数据
    function topTwenty(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnAppName",
            datatype: 'json',
            success: function (rows) {
                var appName = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            if(index>=20){
                                return false;
                            }
                            if(!val.appName){
                                val.appName="";
                            };
                            appName.push(val.appName);
                            if(!val.count){
                                val.count=0;
                            };
                            count.push(val.count);
                        });
                    };
                }
                topTwentyEchart(appName, count);
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
        findErrorLogCount();
        findWarnLogCount();
        findWarnNotDealCount();
        findWarnDealCount();
        moduleNumAnalyse();
        discarded();
        warning();
        topTwenty();
	}
	init();
});