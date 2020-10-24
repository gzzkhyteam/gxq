$(function () {
    // 模块数量分析echarts图表
    function moduleNumAnalyseEchart(xData, yDataOne, yDataTwo) {
        var moduleNumAnalyse = echarts.init(document.getElementById('moduleNumAnalyse'));
        var option = {
            color:["#4f81bd","#c0504d"],
            title: {
                text: '模块数量分析',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b0}<br/>{a0}: {c0}个'
            },
            grid: {
                left: '10%',
                right: '4%',
                bottom: '11%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                axisLabel:{
                    interval: 0,
                    rotate:35
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
                name:"历史模块数",
                data: yDataTwo,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            },{
                name:"模块新增数",
                data: yDataOne,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            }]
        };
        moduleNumAnalyse.setOption(option);
    }
    // 废弃模块数echarts图表
    function discardedEchart(xData, yData) {
        var moduleNumAnalyse = echarts.init(document.getElementById('discarded'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '废弃模块数',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b0}: {c0}个'
            },
            grid: {
                left: '10%',
                right: '4%',
                bottom: '11%',
                containLabel: true
            },
            xAxis: {
                type: 'category',
                axisLabel:{
                    interval: 0,
                    rotate:35
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
                name:"废弃模块数",
                data: yData,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // TOP20数据echarts图表
    function topTwentyEchart(xData, yData, yDataTwo) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topTwenty'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '模块下载TOP20',
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
                left: '8%',
                right: '4%',
                bottom: '30%',
                containLabel: true
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
                name:"下载量",
                splitLine:{
                    show:false,
                },
                axisLabel: {
                    formatter: '{value} 次'
                }
            },{
                type: 'value',
                name:"占比",
                splitLine:{
                    show:false,
                },
                axisLabel: {
                    formatter: '{value} %'
                }
            }],
            series: [{
                name:"下载量",
                data: yData,
                type: 'bar',
                barWidth:20
            },{
                yAxisIndex: 1,
                name:"占比",
                max:100,
                data: yDataTwo,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }
	// 获取模块数量分析数据
    function moduleNumAnalyse(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/modular/home/num/analysis",
            datatype: 'json',
            success: function (rows) {
                var xData = [], modularNum = [], monthAddNum = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            var dateName = val.year+"年"+val.month+"月";
                            xData.push(dateName);
                            if(!val.modularNum){
                                val.modularNum=0;
                            };
                            modularNum.push(val.modularNum);
                            if(!val.monthAddNum){
                                val.monthAddNum=0;
                            };
                            monthAddNum.push(val.monthAddNum);
                        });
                    };
                }
                moduleNumAnalyseEchart(xData, monthAddNum, modularNum);
            }
        });
	}
	// 获取废弃模块数数据
    function discarded(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/modular/home/discarded/num",
            datatype: 'json',
            success: function (rows) {
                var xData = [], modularNum = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            var dateName = val.year+"年"+val.month+"月";
                            xData.push(dateName);
                            if(!val.modularNum){
                                val.modularNum=0;
                            };
                            modularNum.push(val.modularNum);
                        });
                    };
                };
                discardedEchart(xData, modularNum);
            }
        });
	}

    // 获取TOP20数据
    function topTwenty(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/modular/home/download/num",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [], ratio = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.name);
                            if(!val.count){
                                val.count=0;
                            };
                            count.push(val.count);
                            if(!val.ratio){
                                val.ratio=0;
                            };
                            ratio.push(val.ratio);
                        });
                    };
                };
                topTwentyEchart(xData, count, ratio);
            }
        });
    }

    //获取模块操作各统计数
    function handleCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/modular/home/handle/count",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#modularNum").html(value.modularNum);
                    $("#monthAddNum").html(value.monthAddNum);
                    $("#overdueNum").html(value.overdueNum);
                    $("#monthOverdueNum").html(value.monthOverdueNum);
                    $("#modularUsedNum").html(value.modularUsedNum);
                    $("#monthUsedNum").html(value.monthUsedNum);
                    $("#modularUsageRate").html(value.modularUsageRate);
                    $("#monthUsageRate").html(value.monthUsageRate);
                }
            }
        });
    }

    //新模块榜
    function ranking() {
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/modular/home/newest/ranking",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var html = "";
                    rows.data=dealElement(rows.data,"");
                    rows.data.forEach(function(val,index){
                        if(index < 20) {
                           html+='<tr>';
                           html+='<td title="'+val.name+'">'+val.name+'</td>';
                           /*html+='<td title="'+val.date+'">'+val.date+'</td>';
                           html+='<td title="'+val.tag+'">'+val.tag+'</td>';*/
                           html+='<td>'+val.downloadNum+'</td>';
                           html+='</tr>';
                        }
                    });
                    $("#rankingTop tbody").html(html);
                }
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
      handleCount();
      moduleNumAnalyse();
      discarded();
      topTwenty();
      ranking();
	}
	init();
});