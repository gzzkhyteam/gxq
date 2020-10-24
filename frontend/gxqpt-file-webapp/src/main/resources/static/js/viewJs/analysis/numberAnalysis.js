$(function () {
    // 个人文件数量发展情况echarts图表
    function topLeftEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topLeft'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '个人文件数量发展情况',
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
                left: '3%',
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
                name: '文件数量(个)',
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"文件数量",
                data: yDataOne,
                barWidth:20,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 个人各类型文件数量发展情况echarts图表
    function topRightEchart(xData, imageFileList, docFileList, videoFileList, audioFileList, otherFileList) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topRight'));
        var option = {
            title: {
                text: '个人各类型文件数量发展情况',
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
            legend:{
                data:["图片","文档","视频","音频","其它",],
                bottom: 0,
            },
            grid: {
                left: '3%',
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
                name: '文件数量(个)',
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"图片",
                data: imageFileList,
                barWidth:10,
                type: 'bar',
            },{
                name:"文档",
                data: docFileList,
                barWidth:10,
                type: 'bar',
            },{
                name:"视频",
                data: videoFileList,
                barWidth:10,
                type: 'bar',
            },{
                name:"音频",
                data: audioFileList,
                barWidth:10,
                type: 'bar',
            },{
                name:"其它",
                data: otherFileList,
                barWidth:10,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取个人文件数量发展情况数据
    function topLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/file/getFileDev",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];//, imageFileList = [], docFileList = [], videoFileList = [], audioFileList = [], otherFileList = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.fyearMonth);
                            count.push(val.num);
                        });
                    };
                }
                topLeftEchart(xData, count);
            }
        });
    }
    // 获取个人各类型文件数量发展情况数据
    function fileTypeFun(startTime,endTime){
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
                topRightEchart(xData, imgNum, docNum, videoNum, audioNum, otherNum);
            }
        });
    }

    // 文件分享数量占比echarts图表
    function pieEchart(id,title,legendVal,data) {
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
                data:legendVal,
                bottom: 0,
            },
            tooltip:{
                show: true,
                formatter: '{a0}<br/>{b0}: {c0}({d0}%)'
            },
            grid: {
                left: '3%',
                right: 0,
                bottom: '0%',
                containLabel: true
            },
            series: [{
                name:title,
                data: data,
                type: 'pie',
                radius:[0,'50%']
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取文件分享数量占比数据
    function allFile(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/file/getFileShareData",
            datatype: 'json',
            success: function (rows) {
                var allShare=[],imageShare=[],docShare=[],videoShare=[],audioShare=[],otherShare=[];
                var legendVal=["已分享","未分享"];
                if (rows.data) {
                    var rowsObj = dealElement(rows.data,0);
                    if(rowsObj){
                        allShare=[
                            {
                                name: "已分享",
                                value: rowsObj.shareNum,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.allNum-rowsObj.shareNum > 0 ? rowsObj.allNum-rowsObj.shareNum : 0,
                            },
                        ];
                        imageShare=[
                            {
                                name: "已分享",
                                value: rowsObj.shareImgNum,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.imgNum-rowsObj.shareImgNum > 0 ? rowsObj.imgNum-rowsObj.shareImgNum : 0,
                            },
                        ];
                        docShare=[
                            {
                                name: "已分享",
                                value: rowsObj.shareDocNum,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.docNum-rowsObj.shareDocNum > 0 ? rowsObj.docNum-rowsObj.shareDocNum : 0,
                            },
                        ];
                        videoShare=[
                            {
                                name: "已分享",
                                value: rowsObj.shareVideoNum,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.videoNum-rowsObj.shareVideoNum > 0 ? rowsObj.videoNum-rowsObj.shareVideoNum : 0,
                            },
                        ];
                        audioShare=[
                            {
                                name: "已分享",
                                value: rowsObj.shareAudioNum,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.audioNum-rowsObj.shareAudioNum > 0 ? rowsObj.audioNum-rowsObj.shareAudioNum : 0,
                            },
                        ];
                        otherShare=[
                            {
                                name: "已分享",
                                value: rowsObj.shareOthNum,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.othNum-rowsObj.shareOthNum > 0 ? rowsObj.othNum-rowsObj.shareOthNum : 0,
                            },
                        ];
                    };
                }
                pieEchart("allFile","全部文件",legendVal,allShare);
                pieEchart("imageFile","图片",legendVal,imageShare);
                pieEchart("textFile","文档",legendVal,docShare);
                pieEchart("videoFile","视频",legendVal,videoShare);
                pieEchart("audioFile","音频",legendVal,audioShare);
                pieEchart("otherFile","其它",legendVal,otherShare);
            }
        });
    }

    //数组数据文件数量单位换算
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

    function init(){
        topLeft();//获取个人文件数量发展情况
        fileTypeFun();//获取个人各类型文件数量发展情况
        allFile();//获取文件分享数量占比情况
    }
    init();
});