$(function () {
    // 个人文件大小发展情况echarts图表
    function topLeftEchart(xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topLeft'));
        var option = {
            color:["#4f81bd"],
            title: {
                text: '个人文件大小发展情况',
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
                name: '文件大小(MB)',
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"文件大小",
                data: yDataOne,
                barWidth:20,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 个人各类型文件大小发展情况echarts图表
    function topRightEchart(xData, imageFileList, docFileList, videoFileList, audioFileList, otherFileList) {
        var moduleNumAnalyse = echarts.init(document.getElementById('topRight'));
        var option = {
            title: {
                text: '个人各类型文件大小发展情况',
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
                name: '文件大小(MB)',
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

    // 获取个人文件大小发展情况数据
    function topLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/dataapi/file/sizeAnalysis",
            datatype: 'json',
            data:{startDate:"",endDate:""},
            success: function (rows) {
                var xData = [], allFileList = [], imageFileList = [], docFileList = [], videoFileList = [], audioFileList = [], otherFileList = [];
                if (rows.data) {
                    var rowsArray = rows.data;
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
                topLeftEchart(xData, allFileList);
                topRightEchart(xData, imageFileList, docFileList, videoFileList, audioFileList, otherFileList);
            }
        });
    }


    // 文件分享大小占比echarts图表
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
                data: data,
                type: 'pie',
                radius:[0,'50%']
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取文件分享大小占比数据
    function allFile(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/dataapi/file/shareRate",
            datatype: 'json',
            success: function (rows) {
                var allShare=[],imageShare=[],docShare=[],videoShare=[],audioShare=[],otherShare=[];
                var legendVal=["已分享","未分享"];
                if (rows.data) {
                    var rowsObj = rows.data;
                    if(rowsObj){
                        allShare=[
                            {
                                name: "已分享",
                                value: rowsObj.allShare.allDidNot,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.allShare.allNot,
                            },
                        ];
                        imageShare=[
                            {
                                name: "已分享",
                                value: rowsObj.imageShare.imageDidNot,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.imageShare.imageNot,
                            },
                        ];
                        docShare=[
                            {
                                name: "已分享",
                                value: rowsObj.docShare.docDidNot,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.docShare.docNot,
                            },
                        ];
                        videoShare=[
                            {
                                name: "已分享",
                                value: rowsObj.videoShare.videoDidNot,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.videoShare.videoNot,
                            },
                        ];
                        audioShare=[
                            {
                                name: "已分享",
                                value: rowsObj.audioShare.audioDidNot,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.audioShare.audioNot,
                            },
                        ];
                        otherShare=[
                            {
                                name: "已分享",
                                value: rowsObj.otherShare.otherDidNot,
                            },
                            {
                                name: "未分享",
                                value: rowsObj.otherShare.otherNot,
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

    function init(){
        topLeft();//获取个人文件大小发展情况
        allFile();//获取文件分享大小占比情况
	}
	init();
});