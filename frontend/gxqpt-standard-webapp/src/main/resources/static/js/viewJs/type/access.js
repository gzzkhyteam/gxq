$(function () {
	// 基于准备好的dom，初始化echarts实例
    var chart1 = echarts.init(document.getElementById('chart1'));
    // 基于准备好的dom，初始化echarts实例
    var chart2 = echarts.init(document.getElementById('chart2'));
    // 基于准备好的dom，初始化echarts实例
    var chart3 = echarts.init(document.getElementById('chart3'));
    // 基于准备好的dom，初始化echarts实例
    var chart4 = echarts.init(document.getElementById('chart4'));

    // 获取id,用户拉取数据
    var id = getQueryString('id');
    // 获取文档名称
    var name = getQueryString('name');
    var colors = ['#487EC1', '#48B9C1', '#A27DE2', '#32C0D6', '#70C44B'];
    // 获取url里面的指定参数
    function getQueryString(query) {
        var reg = new RegExp("(^|&)"+ query +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  decodeURIComponent(r[2]); return null;
    }

	function drawChart1(xData, yData) {
		var option = {
			color: colors,
			title: {
				text: name + '下载数量top10',
				bottom: 0,
				left: 'center',
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
				boundaryGap: [0, 0.01],
                minInterval:1,
				name: '次数'
			},
			yAxis: {
				type: 'category',
				name: '标准名称',
				data: yData
			},
			series: [{
				type: 'bar',
				barWidth: '15px',
				data: xData
			}]
		};
		chart1.setOption(option);
	}

	function drawChart2(xData, yData) {
		var option = {
			color: colors,
		    title: {
		        text: name + '数量分析',
		        bottom: 0,
				left: 'center',
				textStyle: {
					color: '#333'
				}
		    },
		    legend: {
		    	show: false
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
		        type: 'category',
		        data: xData,
		        name: '时间'
		    },
		    yAxis: {
		        type: 'value',
		        name: '次数'
		    },
		    series: [{
	            type:'line',
	            data: yData
	        }]
		};
		chart2.setOption(option);
	}

	function drawChart3(xData, yData) {
		var option = {
			color: colors,
		    title: {
		        text: name + '下载趋势',
		        bottom: 0,
				left: 'center',
				textStyle: {
					color: '#333'
				}
		    },
		    legend: {
		    	show: false
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
		        type: 'category',
		        data: xData,
		        name: '时间'
		    },
		    yAxis: {
		        type: 'value',
                minInterval:1,
		        name: '次数'
		    },
		    series: [{
	            type:'line',
	            data: yData
	        }]
		};
		chart3.setOption(option);
	}

	function drawChart4(xData, yData) {
		var option = {
			color: colors,
		    title: {
		        text: name + '上传单位top10',
		        bottom: 0,
				left: 'center',
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
				boundaryGap: [0, 0.01],
                minInterval:1,
				name: '次数'
			},
			yAxis: {
				type: 'category',
				name: '单位名称',
				data: yData
			},
			series: [{
				type: 'bar',
                barWidth: '15px',
				data: xData
			}]
		};
		chart4.setOption(option);
	}

	function getChart1() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/standard/chaild/download/top10',
            data: {
            	typeId: id
            },
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.count);
	                	yData.push(app.name);
	                }
	                drawChart1(xData, yData);
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
            url: _GATE_URL + '/api/standard/chaild/type/count',
            data: {
            	typeId: id
            },
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.year + '-' + app.month);
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
            url: _GATE_URL + '/api/standard/chaild/download/trend',
            data: {
            	typeId: id
            },
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.year + '-' + app.month);
	                	yData.push(app.count);
	                }
	                drawChart3(xData, yData);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	function getChart4() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/standard/chaild/uploadCompany/top10',
            data: {
            	typeId: id
            },
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.count);
	                	yData.push(app.name);
	                }
	                drawChart4(xData, yData);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 下载数量top10
	getChart1();
	// 数量分析
	getChart2();
	// 下载趋势
	getChart3();
	// 上传单位top10
	getChart4();
});
