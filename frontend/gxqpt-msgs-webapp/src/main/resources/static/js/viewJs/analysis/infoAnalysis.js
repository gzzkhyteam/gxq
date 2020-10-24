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
                formatter: '{a0}<br/>{b0}: {c0}'
            },
            grid: {
                left: '2%',
                right: '4%',
                bottom: '5%',
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
                name:"",
                data: yData,
                type: 'bar',
                stack: 'modular',
                barWidth:15
            }]
        };
        topLeft.setOption(option);
    }
    // 获取个人渠道发布商次数TOP10数据
    function topLeft(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/publisher/sendtop10",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            val = dealElement(val,0);
                            xData.push(val.name);
                            count.push(val.count);
                        });
                    };
                }
                barEchart("topLeft","个人渠道发布商次数TOP10",xData, count);
            }
        });
    }

    // 获取高新区发布商使用次数TOP10数据
    function topRight(){
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/gxqpt/sendtop10",
            datatype: 'json',
            success: function (rows) {
                var xData = [], count = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            val = dealElement(val,0);
                            xData.push(val.name);
                            count.push(val.count);
                        });
                    };
                }
                barEchart("topRight","高新区发布商使用次数TOP10",xData, count);
            }
        });

    }

    // 近期发布商活跃情况分析echarts图表
    function bottomLeftEchart(xData, yData) {
        var topLeft = echarts.init(document.getElementById('bottomLeft'));
        var option = {
            title: {
                text: '近期发布商活跃情况分析',
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
                left: '6%',
                right: '4%',
                bottom: '10%',
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
                name:"",
                data: yData,
                type: 'line',
            }]
        };
        topLeft.setOption(option);
    }

    // 获取近期发布商活跃情况分析数据
    function bottomLeft(){
        var appId = $("#appId").val();
        ajaxHengyun({
            type: "GET",
            url: _GATE_URL+"/api/msgs/analysis/active/sendtop10",
            datatype: 'json',
            data:{appId:appId},
            success: function (rows) {
                var xData = [], count = [], ratio = [];
                if (rows.data) {
                    var rowsArray = rows.data;
                    if(rowsArray){
                        rowsArray.forEach(function(val,index){
                            var dateName = val.year+"-"+val.month+"-"+val.day;
                            xData.push(dateName);
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
                bottomLeftEchart(xData, count, ratio);
            }
        });
    }

    $("#appId").change(function(){
        bottomLeft();
    });

    // 获取所有的应用列表
    function getAppList () {
        ajaxHengyun({
            type:'get',
            url: _GATE_URL + '/api/developer/application/findAllList',
            success:function (res) {
                var data = res.data || [];
                var options = [];
                for (var i = 0; i < data.length; i++) {
                    var text = data[i].name;
                    var val = data[i].appId;
                    options.push('<option value='+val+'>'+text+'</option>');
                }
                $('#appId').append(options.join(''));
                initList();
            },
            error: function(err) {
                console.log(err);
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
      bottomLeft();
      getAppList ()
	}
	init();
});