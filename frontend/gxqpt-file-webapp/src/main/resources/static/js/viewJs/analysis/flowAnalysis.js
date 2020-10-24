$(function () {
    // echarts折线图
    function lineEchart(id, title, xData, yDataOne) {
        var moduleNumAnalyse = echarts.init(document.getElementById(id));
        var option = {
            color:["#4f81bd"],
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
                formatter: '{a0}<br/>{b0}: {c0}M'
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
                name:"文件大小（MB）",
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:title,
                data: yDataOne,
                barWidth:20,
                type: 'line',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取近30天个人文件上传情况分析数据
    function topFun(){
        ajaxHengyun({
            type: "post",
            url: _GATE_URL+"/api/file/fileDU/getFileUp",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = dealElement(rows.data,0);
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.upTime);
                            count.push(val.size);
                        });
                    };
                }
                lineEchart("top","近30天个人文件上传情况分析",xData, sizeEdit(count));
            }
        });
    }

    // 获取近30天个人文件下载情况分析数据
    function bottomFun(){
        ajaxHengyun({
            type: "post",
            url: _GATE_URL+"/api/file/fileDU/getFileDown",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = dealElement(rows.data,0);
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            xData.push(val.upTime);
                            count.push(val.size);
                        });
                    };
                }
                lineEchart("bottom","近30天个人文件下载情况分析",xData, sizeEdit(count));
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
        topFun();//获取近30天个人文件上传情况分析
        bottomFun();//获取近30天个人文件下载情况分析
    }
    init();
});