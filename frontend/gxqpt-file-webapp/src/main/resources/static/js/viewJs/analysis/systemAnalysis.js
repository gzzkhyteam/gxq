$(function () {
    //echarts柱状图
    function barEchart(id, title, xData, yDataOne) {
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
                formatter: '{a0}<br/>{b0}: {c0}(MB)'
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
                name:"(MB)",
                type: 'value',
                splitLine:{
                    show:false,
                },
            },
            series: [{
                name:"",
                data: yDataOne,
                barWidth:20,
                type: 'bar',
            }]
        };
        moduleNumAnalyse.setOption(option);
    }

    // 获取多系统文件分析
    function topFun(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/file/dataapi/file/systemAnalysis",
            datatype: 'json',
            success: function (rows) {
                var jryySystem = [], jryyCount = [], zcptSystem = [], zcptCount = [], zcyySystem = [], zcyyCount = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        jryySystem = rowsArray.jryy.system;
                        jryyCount = rowsArray.jryy.size;
                        zcptSystem = rowsArray.zcpt.system;
                        zcptCount = sizeEdit(rowsArray.zcpt.size);
                        zcyySystem = rowsArray.zcyy.system;
                        zcyyCount = sizeEdit(rowsArray.zcyy.size);
                    };
                }
                barEchart("top","个人多系统文件情况-接入应用",jryySystem, jryyCount);
                barEchart("middle","个人多系统文件情况-支撑平台",zcptSystem, zcptCount);
                barEchart("bottom","个人多系统文件情况-支撑应用",zcyySystem, zcyyCount);
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
        topFun();//获取个人多系统文件情况-接入应用
	}
	init();
});