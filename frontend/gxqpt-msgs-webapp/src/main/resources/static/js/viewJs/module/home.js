$(function () {
    $(".view-framework-head",window.parent.document).css("display","none");
    // 个人渠道使用情况echarts图表
    function topLeftEchart(title, xData, yDataOne, yDataTwo) {
        var topLeft = echarts.init(document.getElementById('topLeft'));
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
                formatter: '{b0}<br/>{a0}: {c0}个'
            },
            legend:{
                data:["授权使用数量","自己使用数量"],
                bottom: 0,
            },
            grid: {
                left: '2%',
                right: '4%',
                bottom: '20%',
                containLabel:true,
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
                name:"授权使用数量",
                data: yDataTwo,
                type: 'bar',
                stack: 'modular',
                barWidth:15
            },{
                name:"自己使用数量",
                data: yDataOne,
                type: 'bar',
                stack: 'modular',
                barWidth:15
            }]
        };
        topLeft.setOption(option);
    }
    // 获取个人渠道使用情况数据
    function topLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/channel/used",
            datatype: 'json',
            success: function (rows) {
                var xData = [], personalUsed = [], authorizeUsed = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.channelName);
                            personalUsed.push(val.personalUsed);
                            authorizeUsed .push(val.authorizeUsed );
                        });
                    };
                }
                topLeftEchart("个人渠道使用情况",xData, personalUsed, authorizeUsed);
            }
        });
    }

    // 各类型渠道发送问题TOP10echarts图表
    function topRightEchart(title, xData, yData) {
        var topRight = echarts.init(document.getElementById('topRight'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: title,
                top: 30,
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
                left: '2%',
                right: '4%',
                bottom: '3%',
                containLabel:true,
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
                    inside: true,
                    textStyle: {
                        color: '#fff'
                    },
                    fontSize: 10,
                    interval: 0,
                },
                z: 10,
                data: xData
            },
            series: [{
                name:"",
                data: yData,
                type: 'bar',
                stack: 'modular',
                barWidth:30
            }]
        };
        topRight.setOption(option);
    }
    // 获取各类型渠道发送问题TOP10数据
    function topRight(){
        var type = $(".analyType").val();
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/senderror/top10",
            datatype: 'json',
            data:{type:type},
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.name);
                            if(!val.count){
                                val.count =0;
                            };
                            count.push(val.count);
                        });
                    };
                }
                topRightEchart("各类型渠道发送问题TOP10",xData, count);
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
                formatter: '{b0}<br/>{a0}: {c0}个'
            },
            legend:{
                //data:["微信","微博","移动终端","公示平台"],
                data:["微信","微博","移动终端"],
                bottom: 0,
            },
            grid: {
                left: '6%',
                right: '4%',
                bottom: '30%',
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

    // echarts饼图
    function pieEchart(id,title,data) {
        var moduleNumAnalyse = echarts.init(document.getElementById(id));
        var option = {
            title: {
                text: title,
                top: 0,
                left: 'center',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            legend:{
                //data:["微信","微博","移动终端","公示平台"],
                data:["微信","微博","移动终端"],
                bottom: 0,
            },
            tooltip:{
                show: true,
                formatter: '{a0}<br/>{b0}: {d0}%'
            },
            grid: {
                left: '3%',
                right: 0,
                bottom: '0%',
                containLabel: true
            },
            series: [{
                name:title,
                data: [{
                    name:"微信",
                    value: data.wx,
                },{
                    name:"微博",
                    value: data.wb,
                },{
                    name:"移动终端",
                    value: data.ydzd,
                }/*,{
                    name:"公示平台",
                    value: data.gspt,
                }*/],
                type: 'pie',
                // roseType: 'angle',
                radius:[0,'50%']
            }]
        };
        moduleNumAnalyse.setOption(option);
    };

    //获取个人渠道类型使用占比分析数据
    function centerLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/personal/channeltype",
            datatype: 'json',
            success: function (rows) {
                var data={
                    wx:0,
                    wb:0,
                    ydzd:0,
                    gspt:0,
                };
                if (rows.data) {
                    var rowObj = dealElement(rows.data,0);
                    data.wx=rowObj.wechat;
                    data.wb=rowObj.blog;
                    data.ydzd=rowObj.mobile;
                    data.gspt=rowObj.publicSys;
                };
                pieEchart("centerLeft","个人渠道类型使用占比分析",data)
            }
        });
    };

    //获取高新区渠道类型使用占比分析数据
    function centerRight(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/all/channeltype",
            datatype: 'json',
            success: function (rows) {
                var data={
                    wx:0,
                    wb:0,
                    ydzd:0,
                    gspt:0,
                };
                if (rows.data) {
                    var rowObj = dealElement(rows.data,0);
                    data.wx=rowObj.wechat;
                    data.wb=rowObj.blog;
                    data.ydzd=rowObj.mobile;
                    data.gspt=rowObj.publicSys;
                };
                pieEchart("centerRight","高新区渠道类型使用占比分析",data)
            }
        });
    };

    //获取模块操作各统计数
    function handleCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/handle",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#sendNum ").html(value.sendNum);
                    $("#draftNum").html(value.draftNum);
                    $("#channelNum").html(value.channelNum);
                    $("#publisherNum").html(value.publisherNum);
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

    $(".analyType").change(function(){
        topRight();
    });
    function init(){
      handleCount();
      topLeft();
      topRight();
      bottomLeft();
      centerLeft();
      centerRight();
	}
	init();
});