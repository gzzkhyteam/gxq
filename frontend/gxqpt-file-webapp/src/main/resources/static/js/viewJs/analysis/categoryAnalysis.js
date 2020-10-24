$(function () {
    //echarts柱状图
    function barEchart(id, title, xData, yData, unit) {
        var moduleNumAnalyse = echarts.init(document.getElementById(id));
        var option = {
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
                formatter: '{b}<br/>{a}: {c0}'+unit
            },
            legend:{
                data:["图片","文档","视频","音频","其它",],
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
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"图片",
                data: yData.imgNum,
                barWidth:15,
                type: 'bar',
            },{
                name:"文档",
                data: yData.docNum,
                barWidth:15,
                type: 'bar',
            },{
                name:"视频",
                data: yData.videoNum,
                barWidth:15,
                type: 'bar',
            },{
                name:"音频",
                data: yData.audioNum,
                barWidth:15,
                type: 'bar',
            },{
                name:"其它",
                data: yData.otherNum,
                barWidth:15,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取个人各类型文件数量发展情况数据
    function topFun(startTime,endTime){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/file/getFileDataTypeDev",
            datatype: 'json',
            data:{startTime:startTime,endTime:endTime},
            success: function (rows) {
                var xData = [], imgNum = [], docNum = [], videoNum = [], audioNum = [], otherNum = [];
                if (rows.data) {
                    var rowsArray = dealElement(rows.data,0);
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            val.fileDevDataTypeNum = dealElement(val.fileDevDataTypeNum,0);
                            xData.push(val.fyearMonth);
                            imgNum.push(val.fileDevDataTypeNum.imgNum);
                            docNum.push(val.fileDevDataTypeNum.docNum);
                            videoNum.push(val.fileDevDataTypeNum.videoNum);
                            audioNum.push(val.fileDevDataTypeNum.audioNum);
                            otherNum.push(val.fileDevDataTypeNum.otherNum);
                        });
                    };
                };
                var yData = {
                    imgNum:imgNum,
                    docNum:docNum,
                    videoNum:videoNum,
                    audioNum:audioNum,
                    otherNum:otherNum,
                };
                barEchart("top","个人各类型文件数量发展情况",xData, yData,"(个)");
            }
        });
    }

    // 获取个人各类型文件大小发展情况数据
    function bottomFun(startTime,endTime){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/dataapi/file/sizeAnalysis",
            datatype: 'json',
            data:{startDate:startTime,endDate:endTime},
            success: function (rows) {
                var xData = [], imageFileList = [], docFileList = [], videoFileList = [], audioFileList = [], otherFileList = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        xData = rowsArray.yearMonthArray;
                        imageFileList = sizeEdit(rowsArray.imageFileList);
                        docFileList = sizeEdit(rowsArray.docFileList);
                        videoFileList = sizeEdit(rowsArray.videoFileList);
                        audioFileList = sizeEdit(rowsArray.audioFileList);
                        otherFileList = sizeEdit(rowsArray.otherFileList);
                    };
                };
                var yData = {
                    imgNum:imageFileList,
                    docNum:docFileList,
                    videoNum:videoFileList,
                    audioNum:audioFileList,
                    otherNum:otherFileList,
                };
                barEchart("bottom","个人各类型文件大小发展情况",xData, yData,"(MB)");
            }
        });
    }

    $(".search-button").click(function(){
       var stateTime = $("#stateTime").val();
       var endTime = $("#endTime").val();
       var errorInfo = [];
       if(!stateTime){
           errorInfo.push("起始月份");
       };
       if(!endTime){
           errorInfo.push("终止月份");
       };
       if(errorInfo.length>0){
           parent.layer.msg(errorInfo.join(",")+"不能为空！", {time: 1500});
           return false;
       };
       var stateYear = new Date(stateTime).getFullYear();
       var endYear = new Date(endTime).getFullYear();
       var stateMonth = new Date(stateTime).getMonth()+1;
       var endMonth = new Date(endTime).getMonth()+1;
       if(endYear-stateYear>=2){
           parent.layer.msg("最多只能查看12个月份的数据！", {time: 2000});
           return false;
       }else if(endYear-stateYear==1){
            var num = 12-stateMonth+1+endMonth;
            if(num>12){
                parent.layer.msg("最多只能查看12个月份的数据！", {time: 2000});
                return false;
            }
       }
        init(stateTime,endTime);
    });

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

    function init(stateTime,endTime){
        topFun(stateTime,endTime);//获取个人各类型文件数量发展情况
        bottomFun(stateTime,endTime);//获取个人各类型文件大小发展情况
    }
    init("","");
});