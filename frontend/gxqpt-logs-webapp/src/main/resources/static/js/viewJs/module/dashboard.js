$(function () {
    //仪表盘echarts图表
    function gaugeEcharts(id,title,dataName,dataVal){
        var gaugeEcharts = echarts.init(document.getElementById(id));
        var option = {
            tooltip : {
                formatter: "{b} : {c}"
            },
            grid: {
                top: '10%',
            },
            series: [
                {
                    name: title,
                    type: 'gauge',
                    radius: "100%",
                    max: dataVal > 100 ? dataVal : 100,
                    axisLine:{
                        lineStyle:{
                            width:15
                        }
                    },
                    splitLine:{
                        length:15,
                    },
                    axisLabel:{
                        distance:0,
                        borderColor:"red",
                        fontSize:18
                    },
                    data: [{value: dataVal, name: dataName}]
                }
            ]
        };
        gaugeEcharts.setOption(option);
    }


    // 日志数量echarts图表
    function moduleNumAnalyseEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('moduleNumAnalyse'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '日志数量',
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
                bottom: '20%',
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
                name:"日志数量",
                data: yDataOne,
                barWidth:20,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }
    // 日志类型数量占比echarts图表
    function discardedEchart(data) {
        var moduleNumAnalyse = echarts.init(document.getElementById('discarded'));
        var option = {
            title: {
                text: '日志类型数量占比',
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
                formatter: '{a0}<br/>{b0}: {d0}%'
            },
            grid: {
                left: '3%',
                right: 0,
                bottom: '30%',
                containLabel: true
            },
            series: [{
                name:"日志类型数量占比",
                radius: [0, '60%'],
                data: [
                    {
                        name:"应用系统日志",
                        value:data.app,
                    },{
                        name:"Apache日志",
                        value:data.apache,
                    },{
                        name:"Nginx日志",
                        value:data.nginx,
                    },{
                        name:"Tomcat日志",
                        value:data.tomcate,
                    },
                ],
                type: 'pie',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 日志分类数量echarts图表
    function radarEchart(indicator,data,max) {
        var moduleNumAnalyse = echarts.init(document.getElementById('radar'));
        var indicatorDefault = [
            { name: 'DEBUG日志数量', max: max},
            { name: 'ERROR日志数量', max: max},
            { name: 'INFO日志数量', max: max},
            { name: 'WARN日志数量', max: max},
            { name: 'FAILED日志数量', max: max},
        ];
        var option = {
            title: {
                text: '日志分类数量',
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
                name: '日志分类数量',
                type: 'radar',
                // areaStyle: {normal: {}},
                data : [
                    {
                        value : data,
                        name : '日志分类数量'
                    }
                ]
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 警告次数最多系统TOP10 echarts图表
    function topTwentyEchart(xData, yData) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topTwenty'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '告警次数最多系统top10',
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
                left: '20%',
                right: '4%',
                bottom: '9%',
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
                barWidth: 15,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    //获取仪表盘数据
    function gauge(){
        ajaxHengyun({//查询告警平均处理时间
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnAvgTime",
            datatype: 'json',
            success: function (rows) {
                var count = 0;
                if (rows.data) {
                    var rowsObj = dealElement(rows.data,0);
                    if(rowsObj){
                        if(rowsObj.count!=0){
                            count=((rowsObj.dealTime/rowsObj.count)/(1000*60*60)).toFixed(2);
                        }
                    };
                }
                gaugeEcharts("wanring","告警平均处理时间","告警平均\n处理时间(小时)",count);
            }
        });
        ajaxHengyun({//查询日志warn警告未处理总数
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnNotDealCount",
            datatype: 'json',
            success: function (rows) {
                var warnNotDealCount = 0;
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    warnNotDealCount = value.warnNotDealCount;
                }
                gaugeEcharts("noDeal","未处理警告数","未处理\n警告数(条)",warnNotDealCount);
            }
        });
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findWarnLogCount",
            datatype: 'json',
            success: function (rows) {
                var warnCurrentCount = 0;
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    warnCurrentCount = value.currentCount;
                }
                gaugeEcharts("errorNum","本月告警数量","本月告警\n数量(条)",warnCurrentCount);
            }
        });
    }

	// 获取日志数量数据
    function moduleNumAnalyse(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findLogAvgMonth",
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
                moduleNumAnalyseEchart(xData, count);
            }
        });
	}
	// 获取日志类型数量占比数据
    function discarded(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/logs/findLogTypeRatio",
            datatype: 'json',
            success: function (rows) {
                var data=[0,0,0,0];
                if (rows.data) {
                    var rowsObj = rows.data;
                    if(rowsObj){
                        data = rowsObj;
                    };
                }
                discardedEchart(data);
            }
        });
	}

    // 获取日志分类数量数据radar
    function radar(){
        var data=[];
        var indicator = [];
        var maxVal = 10;
        ajaxHengyun({
            type: "GET",
            async:false,
            url: _GATE_URL+"/api/logs/findLogSortCount",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var rowsObj = dealElement(rows.data,0);
                    if(rowsObj){
                        rowsObj.forEach(function(val,index){
                            data.push(val.count);
                        });
                        maxVal = Math.max.apply(null,data) +10;
                        rowsObj.forEach(function(val,index){
                           var obj = {
                               name: val.level+'日志数量',
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

    // 获取警告次数最多系统TOP10数据
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
                            if(index>=10){
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
        gauge();
        moduleNumAnalyse();
        discarded();
        radar();
        topTwenty();
	}
	init();
});