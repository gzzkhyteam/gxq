$(function () {
    // 全部文件发展情况echarts图表
    function moduleNumAnalyseEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('moduleNumAnalyse'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '全部文件发展情况',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b}<br/>{a}: {c0}(个)'
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
                name:"全部文件发展情况",
                data: yDataOne,
                type: 'bar',
                barWidth:16
            }]
        };
        moduleNumAnalyse.setOption(option);
    }
    // 文件类型情况echarts图表
    function discardedEchart(data,rowsObj) {
        var moduleNumAnalyse = echarts.init(document.getElementById('discarded'));
        var option = {
            title: {
                text: '文件类型情况',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            legend:{
                data:["图片","文档","视频","音频","其它"],
                bottom: 0,
            },
            tooltip:{
                show: true,
                formatter: function (params) {
                    var numUnit = "B";
                    if(params.name=="图片"){
                        numUnit = rowsObj.imgSize.split("-").join("");
                    }else if(params.name=="文档"){
                        numUnit = rowsObj.docSize.split("-").join("");
                    }else if(params.name=="视频"){
                        numUnit = rowsObj.videoSize.split("-").join("");
                    }else if(params.name=="音频"){
                        numUnit = rowsObj.audioSize.split("-").join("");
                    }else if(params.name=="其它"){
                        numUnit = rowsObj.otherSize.split("-").join("");
                    }
                    return params.seriesName+"<br/>"+params.name+":"+numUnit+"("+params.percent+"%)";
                }
            },
            grid: {
                left: '3%',
                right: 0,
                bottom: '30%',
                containLabel: true
            },
            series: [{
                name:"文件类型情况",
                data: [
                    {
                        name:"图片",
                        value:data.imgSize,
                    },{
                        name:"文档",
                        value:data.docSize,
                    },{
                        name:"视频",
                        value:data.videoSize,
                    },{
                        name:"音频",
                        value:data.audioSize,
                    },{
                        name:"其它",
                        value:data.otherSize,
                    }
                ],
                type: 'pie',
                radius:[0,'50%']
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 近半年个人分享情况echarts图表
    function warningEchart(xData, yData) {
        var moduleNumAnalyse = echarts.init(document.getElementById('warning'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '近半年个人分享情况',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b0}<br/>{a0}: {c0}(个)'
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
                name:"分享数量",
                data: yData,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }


    //获取模块操作各统计数
    function handleCount(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/file/getMyFileDataView",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var value = dealElement(rows.data,0);
                    $("#fileNum").html(value.fileNum);
                    $("#fileSize").html(value.fileSize.split("-").join(""));
                    $("#imgNum").html(value.imgNum);
                    $("#docNum").html(value.docNum);
                    $("#videoNum").html(value.videoNum);
                    $("#audioNum").html(value.audioNum);
                    $("#otherNum").html(value.otherNum);
                    $("#myShareNum").html(value.myShareNum);
                }
            }
        });
    }

	// 获取全部文件发展情况数据
    function moduleNumAnalyse(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/file/getFileDev",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.fyearMonth);
                            count.push(val.num);
                        });
                    };
                }
                moduleNumAnalyseEchart(xData, count);
            }
        });
	}
	// 获取文件类型情况数据
    function discarded(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/file/getMyFileTypeView",
            datatype: 'json',
            success: function (rows) {
                if (rows.data) {
                    var rowsObj = rows.data;
                    if(rowsObj){
                        data = rowsObj;
                        var dataInfo = {};
                        for(var key in data){
                            if(!data[key]){
                                data[key] = '0-B'
                            }
                            dataInfo[key]=data[key];
                            if(data[key].split("-")[1] =="B"){
                                data[key] = data[key].split("-")[0];
                            }else if(data[key].split("-")[1] =="KB"){
                                data[key] = Number(data[key].split("-")[0])*1024;
                            }else if(data[key].split("-")[1] =="MB"){
                                data[key] = Number(data[key].split("-")[0])*1024*1024;
                            }else if(data[key].split("-")[1] =="GB"){
                                data[key] = Number(data[key].split("-")[0])*1024*1024*1024;
                            }else if(data[key].split("-")[1] =="TB"){
                                data[key] = Number(data[key].split("-")[0])*1024*1024*1024*1024;
                            };
                        }
                        discardedEchart(data,dataInfo);
                    }else{
                        var echartVal = {
                            audioSize:0,
                            docSize:0,
                            imgSize:0,
                            otherSize:0,
                            videoSize:0
                        };
                        var echartData = {
                            audioSize:"0-B",
                            docSize: "0-B",
                            imgSize: "0-B",
                            otherSize: "0-B",
                            videoSize: "0-B"
                        };
                        discardedEchart(echartVal,echartData);
                    };
                }
            }
        });
	}

    // 获取近半年个人分享情况数据
    function warning(){
        ajaxHengyun({
            type: "post",
            url: _GATE_URL+"/api/file/fileDU/getFileShare",
            datatype: 'json',
            data:JSON.stringify({"createTimeEnd": "", "createTimeStart": ""}),
            contentType : 'application/json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.shareTime);
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

    // 获取常用文件排名数据
    function findDown(){
        ajaxHengyun({
            type: "post",
            url: _GATE_URL+"/api/file/fileDU/findDown",
            datatype: 'json',
            success: function (rows) {
                var html="";
                if (rows.data) {
                    var rowsObj = rows.data;
                    if(rowsObj){
                        rowsObj.forEach(function(val,index){
                            var num = index+1;
                            html+=""
                            html+='<tr>';
                            html+='<td>'+num+'</td>';
                            html+='<td>'+val.fileName+'</td>';
                            html+='<td>'+val.userName+'</td>';
                            html+='</tr>';
                        });

                    };
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
        warning();
        findDown();
	}
	init();
});