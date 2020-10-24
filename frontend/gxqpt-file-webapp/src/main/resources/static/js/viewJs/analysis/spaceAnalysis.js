$(function () {
    //仪表盘echarts图表
    function gaugeEcharts(id,title,dataName,dataVal){
        var gaugeEcharts = echarts.init(document.getElementById(id));
        var maxNum = 100;
        if(dataVal > 100){
            maxNum = Number(dataVal) + 10
        }
        var option = {
            tooltip : {
                formatter: "{b} : {c}"
            },
            grid: {
                top: '15%',
            },
            title: {
                text: title,
                top: 0,
                left: 'center',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            series: [
                {
                    name: title,
                    type: 'gauge',
                    radius: "80%",
                    max:maxNum,
                    axisLine:{
                        lineStyle:{
                            width:15
                        }
                    },
                    splitLine:{
                        length:15,
                    },
                    axisLabel:{
                        distance:2,
                        borderColor:"red",
                        fontSize:12
                    },
                    data: [{value: dataVal, name: dataName}]
                }
            ]
        };
        gaugeEcharts.setOption(option);
    }


    // 近一年个人磁盘空间使用发展情况echarts图表
    function topLeftEchart(xData, allFileList, imageFileList, docFileList, videoFileList, audioFileList, otherFileList) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topLeft'));
        var option = {
            title: {
                text: '近一年个人磁盘空间使用发展情况',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#28A4D7',
                    fontSize: 16
                }
            },
            tooltip:{
                show: true,
                formatter: '{b}<br/>{a}: {c0}(MB)'
            },
            legend:{
                data:["全部文件","图片","文档","视频","音频","其它",],
                bottom: 0,
            },
            grid: {
                left: '3%',
                right: '3%',
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
                name: '文件大小(MB)',
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"全部文件",
                data: allFileList,
                barWidth:15,
                type: 'bar',
            },{
                name:"图片",
                data: imageFileList,
                barWidth:15,
                type: 'bar',
            },{
                name:"文档",
                data: docFileList,
                barWidth:15,
                type: 'bar',
            },{
                name:"视频",
                data: videoFileList,
                barWidth:15,
                type: 'bar',
            },{
                name:"音频",
                data: audioFileList,
                barWidth:15,
                type: 'bar',
            },{
                name:"其它",
                data: otherFileList,
                barWidth:15,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取近一年个人磁盘空间使用发展情况数据
    function topLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/dataapi/file/sizeAnalysis",
            datatype: 'json',
            data:{startDate:"",endDate:""},
            success: function (rows) {
                var xData = [], allFileList = [], imageFileList = [], docFileList = [], videoFileList = [], audioFileList = [], otherFileList = [];
                if (rows.data) {
                    var rowsArray = dealElement(rows.data,0);
                    if(rowsArray){
                        xData = rowsArray.yearMonthArray;
                        allFileList = sizeEdit(rowsArray.allFileList);
                        imageFileList = sizeEdit(rowsArray.imageFileList);
                        docFileList = sizeEdit(rowsArray.docFileList);
                        videoFileList = sizeEdit(rowsArray.videoFileList);
                        audioFileList = sizeEdit(rowsArray.audioFileList);
                        otherFileList = sizeEdit(rowsArray.otherFileList);
                    };
                }
                topLeftEchart(xData, allFileList, imageFileList, docFileList, videoFileList, audioFileList, otherFileList);
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
                data:["图片","文档","视频","音频","其它",],
                bottom: 0,
            },
            tooltip:{
                show: true,
                formatter: function (params) {
                    var numUnit = "B";
                    var numVal = 0;
                    if(params.name=="图片"){
                        numUnit = data.image.split("-")[1];
                        numVal = data.image.split("-")[0];
                    }else if(params.name=="文档"){
                        numUnit = data.doc.split("-")[1];
                        numVal = data.doc.split("-")[0];
                    }else if(params.name=="视频"){
                        numUnit = data.video.split("-")[1];
                        numVal = data.video.split("-")[0];
                    }else if(params.name=="音频"){
                        numUnit = data.audio.split("-")[1];
                        numVal = data.audio.split("-")[0];
                    }else if(params.name=="其它"){
                        numUnit = data.other.split("-")[1];
                        numVal = data.other.split("-")[0];

                    }
                    return params.seriesName+"<br/>"+params.name+":"+numVal+numUnit;
                }
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
                    name:"图片",
                    value: data.image?sizeUnitEdit(data.image.split("-")[0],data.image.split("-")[1]):0,
                },{
                    name:"文档",
                    value: data.doc?sizeUnitEdit(data.doc.split("-")[0],data.doc.split("-")[1]):0,
                },{
                    name:"视频",
                    value: data.video?sizeUnitEdit(data.video.split("-")[0],data.video.split("-")[1]):0,
                },{
                    name:"音频",
                    value: data.audio?sizeUnitEdit(data.audio.split("-")[0],data.audio.split("-")[1]):0,
                },{
                    name:"其它",
                    value: data.other?sizeUnitEdit(data.other.split("-")[0],data.other.split("-")[1]):0,
                }],
                type: 'pie',
                // roseType: 'angle',
                radius:[0,'50%']
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取磁盘空间分析数据
    function allFile(){
        ajaxHengyun({//查询磁盘空间分析
            type: "GET",
            url: _GATE_URL+"/api/file/dataapi/file/diskspace",
            datatype: 'json',
            success: function (rows) {
                var count = "";
                var unit  = "";
                var userDiskSpace  = {
                    "image": "0-B",
                    "other": "0-B",
                    "doc": "0-B",
                    "video": "0-B",
                    "audio": "0-B"
                };
                var allDiskSapce  = {
                    "image": "0-B",
                    "other": "0-B",
                    "doc": "0-B",
                    "video": "0-B",
                    "audio": "0-B"
                };
                if (rows.data) {
                    var rowsObj = rows.data;
                    if(rowsObj){
                        count=rowsObj.userAllCount.split("-")[0];
                        unit=rowsObj.userAllCount.split("-")[1];
                        userDiskSpace =rowsObj.userDiskSpace;
                        allDiskSapce =rowsObj.allDiskSapce;
                    };
                }
                gaugeEcharts("allFile","个人空间使用情况","单位("+unit+")",count);
                pieEchart("imageFile","个人空间文件使用情况",userDiskSpace);
                pieEchart("textFile","高新区空间文件使用情况",allDiskSapce);
            }
        });
    }

    //数组数据文件大小单位换算
    function sizeEdit(arrayVal){
        var newArray = [];
        arrayVal.forEach(function(val,index){
            var sizeNum = Number(val);
            if(sizeNum==0){
                newArray.push(0);
            }else if(sizeNum<1024){
                newArray.push(0.1);
            }else if(sizeNum<1024*1024){
                newArray.push(1);
            }else{
                newArray.push((val/(1024*1024)).toFixed(2));
            }
        });
        return newArray;
    }

    //非B单位换算为B单位
    function sizeUnitEdit(numVal, numUnit){
        var newVal = 0;
        switch(numUnit){
            case 'B':
                newVal = numVal
                break;
            case 'KB':
                newVal = numVal * 1024
                break;
            case 'MB':
                newVal = numVal * 1024 * 1024
                break;
            case 'GB':
                newVal = numVal * 1024 * 1024 * 1024
                break;
            case 'TB':
                newVal = numVal * 1024 * 1024 * 1024 * 1024
                break;
        }
        return newVal;
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
        topLeft();//获取近一年个人磁盘空间使用发展情况
        allFile();//获取个人空间使用情况
	}
	init();
});