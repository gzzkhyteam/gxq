$(function () {
	// 基于准备好的dom，初始化echarts实例
    var chart1 = echarts.init(document.getElementById('chart1'));
    var chart2 = echarts.init(document.getElementById('chart2'));
    var chart3 = echarts.init(document.getElementById('chart3'));
    
    var colors = ['#487EC1', '#48B9C1', '#A27DE2', '#32C0D6', '#70C44B'];

    // 模块数量分析echarts图表
    function drawChart1(xData, yData1, yData2) {
        var option = {
            color: ["#4f81bd","#c0504d"],
            title: {
                text: '近一月短信使用情况',
                top: 0,
                left: 'left',
                textStyle: {
                    color: '#333'
                }
            },
            legend: {
            	data: ['成功数', '失败数']
            },
            tooltip:{
                show: true,
                trigger: 'axis',
		    	formatter: function (params) {
		    		var p0 = params[0];
		    		var p1 = params[1];
		    		var labelDot0 = '<span style="display: inline-block; width: 12px; height: 12px; border-radius: 100%; vertical-align: middle; margin-right: 5px; background-color: '+p0.color+'"></span>';
		    		var labelDot1 = '<span style="display: inline-block; width: 12px; height: 12px; border-radius: 100%; vertical-align: middle; margin-right: 5px; background-color: '+p1.color+'"></span>';
		    		var html = [];
		    		if (p0) {
		    			html.push(p0.axisValueLabel+'<br/>'+labelDot0 + '<span style="vertical-align: middle">' + p0.seriesName+': '+p0.value+'条</span>');
		    		}
		    		if (p1) {
		    			html.push('<br/>'+labelDot1 + '<span style="vertical-align: middle">' + p1.seriesName+': '+p1.value+'条</span>');
		    		}
		    		return html.join('');
		    	},
                // formatter: '{b0}<br/>{a0}: {c0}条<br/>{a1}: {c1}条',
				axisPointer: {
					type: 'shadow',
					label: {
						show: true,
						backgroundColor: '#333'
					}
				}
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '9%',
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
                name:"成功数",
                data: yData1,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            },{
                name:"失败数",
                data: yData2,
                type: 'bar',
                stack: 'modular',
                barWidth:20
            }]
        };
        chart1.setOption(option);
    }

	function drawChart2(xData, yData) {
		var option = {
			color: colors,
		    title: {
		        text: '近一年短信使用情况',
		        top: 0,
				left: 'left',
				textStyle: {
					color: '#333'
				}
		    },
		    tooltip: {
		    	show: true,
		    	trigger: 'axis',
		    	formatter: function (params) {
		    		var p = params[0];
		    		var labelDot = '<span style="display: inline-block; width: 12px; height: 12px; border-radius: 100%; vertical-align: middle; margin-right: 5px; background-color: '+p.color+'"></span>'
		    		return p.seriesName+'<br/>'+labelDot + '<span style="vertical-align: middle">' + p.axisValueLabel+': '+p.value+'条</span>'
		    	}
		    },
		    legend: {
		    	show: false
		    },
		    grid: {
		        left: '60px',
		        right: '60px',
		        bottom: '60px',
		        containLabel: false
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: xData,
		        name: '日期'
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [{
	            type:'line',
	            name: '短信使用量',
	            data: yData
	        }]
		};
		chart2.setOption(option);
	}

	function drawChart3(xData, yData) {
		var option = {
			color: colors,
			title: {
				text: '模板使用TOP10',
				top: 0,
				left: 'left',
				textStyle: {
					color: '#333'
				}
			},
		    tooltip: {
		      	trigger: 'axis',
		      	axisPointer: {
		        	type: 'shadow'
		      	}
		    },
            grid: {
                left: '60px',
                right: '60px',
                bottom: '60px',
                containLabel: true
            },
		    xAxis: {
		      	type: 'value',
		      	name: '次数'
		    },
		    yAxis: {
		      	type: 'category',
		      	name: '模块名称',
		      	data: yData,
		      	axisLabel: {
		        	show: true,
		        	color: '#333'
		      	}
		    },
		    series: [{
		      	type: 'bar',
		      	data: xData
		    }]
		};
		chart3.setOption(option);
	}

	function getChart1() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/sms/home/acount/month',
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData1 = [];
            		var yData2 = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.year + '-' + app.month + '-' + app.day);
	                	yData1.push(app.success);
	                	yData2.push(app.fail);
	                }
	                drawChart1(xData, yData1, yData2);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	function getChart2() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/sms/home/acount/year',
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	var date = []
	                	if (app.year || app.year == 0) {
	                		date.push(app.year);
	                	}
	                	if (app.month || app.month == 0) {
	                		date.push(app.month);
	                	}
	                	if (app.day || app.day == 0) {
	                		date.push(app.day);
	                	}

	                	xData.push(date.join('-'));
	                	yData.push(app.count);
	                }
	                drawChart2(xData, yData);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	function getChart3() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/sms/home/template/top10',
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.count);
	                	yData.push(app.name);
	                }
	                drawChart3(xData, yData);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 获取总体信息，上方的card
	function getAllInfo() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/sms/home/smsacount',
            success:function (res) {
            	if (res.data) {
            		$('#sendNum').text(res.data.sendNum);
					$('#draftNum').text(res.data.draftNum);
					$('#modleNum').text(res.data.modleNum);
					$('#accountNum').text(res.data.accountNum);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 近一个月
	getChart1();
	// 近一年
	getChart2();
	// 模板使用TOP10
	getChart3();
	// 获取上方卡片信息
	getAllInfo();
});