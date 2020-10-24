$(function () {
    $(".view-framework-head",window.parent.document).css("display","none");
    // 横向柱状图echarts图表
    function barEchart(id,title, xData, yData) {
        var topLeft = echarts.init(document.getElementById(id));
        var option = {
            color:["#4f81bd","#c0504d"],
            title: {
                text: title,
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b0}: {c0}'
            },
            grid: {
                left: '2%',
                right: '4%',
                bottom: '10%',
                containLabel:true,
            },
            xAxis: {
                type: 'value',
                minInterval: 1,
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
                    inside: true,
                    textStyle: {
                        color: '#fff'
                    },
                    interval: 0,
                },
                z:10,
                data: xData
            },
            series: [{
                name:"",
                data: yData,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            }]
        };
        topLeft.setOption(option);
    }
    // 获取微信发送问题TOP10数据
    function topLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/wechat/top10",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            count.push(val.count);
                            xData.push(val.name);
                        });
                    };
                }
                barEchart("topLeft","微信发送问题TOP10",xData, count);
            }
        });
    }

    // 获取微博发送问题TOP10数据
    function topRight(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/blog/top10",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            count.push(val.count);
                            xData.push(val.name);
                        });
                    };
                }
                barEchart("topRight","微博发送问题TOP10",xData, count);
            }
        });
    }

    // 获取移动终端发送问题TOP10数据
    function middleLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/mobile/top10",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            count.push(val.count);
                            xData.push(val.name);
                        });
                    };
                }
                barEchart("middleLeft","移动终端发送问题TOP10",xData, count);
            }
        });
    }

    // 获取公示平台发送问题TOP10据
    function middleRight(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/public/top10",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            count.push(val.count);
                            xData.push(val.name);
                        });
                    };
                }
                barEchart("middleRight","公示平台发送问题TOP10",xData, count);
            }
        });
    }

    // 各渠道类型异常情况分析echarts图表
    function bottomLeftEchart(xData, data) {
        var topLeft = echarts.init(document.getElementById('bottomLeft'));
        var option = {
            title: {
                text: '各渠道类型异常情况分析',
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
            legend:{
                //data:["微信","微博","移动终端","公示平台"],
                bottom: 0,
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '30%',
                containLabel:true,
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
                name:"",
                splitLine:{
                    show:false,
                },
                axisLabel: {
                    formatter: '{value}'
                }
            }],
            series: [{
                name:"微信",
                data: data.wx,
                type: 'line',
            },{
                name:"微博",
                data: data.wb,
                type: 'line',
            },{
                name:"移动终端",
                data: data.ydzd,
                type: 'line',
            }/*,{
                name:"公示平台",
                data: data.gspt,
                type: 'line',
            }*/]
        };
        topLeft.setOption(option);
    }

    // 获取各渠道类型异常情况分析数据
    function bottomLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/send/exception",
            datatype: 'json',
            success: function (rows) {
                var xData = [], data = {
                    wx:[],
                    wb:[],
                    ydzd:[],
                    gspt:[],
                };
                if (rows.data) {
                    var rowsObj = dealElement(rows.data,[]);
                    if(rowsObj.wechat){
                        xData=[];
                        rowsObj.wechat.forEach(function(val,index){
                            data.wx.push(val.count);
                            var dateName = val.year+"年"+val.month+"月";
                            xData.push(dateName);
                        });
                    }
                    if(rowsObj.blog){
                        rowsObj.blog.forEach(function(val,index){
                            data.wb.push(val.count);
                        });
                    }
                    if(rowsObj.mobile){
                        rowsObj.mobile.forEach(function(val,index){
                            data.ydzd.push(val.count);
                        });
                    }
                    if(rowsObj.publicSys){
                        rowsObj.publicSys.forEach(function(val,index){
                            data.gspt.push(val.count);
                        });
                    }

                };
                bottomLeftEchart(xData, data);
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
        topLeft();
        topRight();
        middleLeft();
        //middleRight();
        bottomLeft();
    }
    init();
});