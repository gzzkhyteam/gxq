$(function () {
	// 基于准备好的dom，初始化echarts实例
    var app = echarts.init(document.getElementById('app'));
    // 基于准备好的dom，初始化echarts实例
    var info = echarts.init(document.getElementById('info'));
    // 基于准备好的dom，初始化echarts实例
    var download = echarts.init(document.getElementById('download'));

    var colors = ['#487EC1', '#48B9C1', '#A27DE2', '#32C0D6', '#70C44B'];

	function drawChart1(xData, yData) {
		var option = {
			color: colors,
			title: {
				text: '标准上传单位top10',
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
				name: '次数'
			},
			yAxis: {
				type: 'category',
				name: '单位名称',
				data: yData,
		        axisLabel: {
		        	show: true,
		        	rotate: 20
		        }
			},
			series: [{
				type: 'bar',
                barWidth: '15px',
				data: xData
			}]
		};
		app.setOption(option);
	}

	function drawChart2(xData, yData1, yData2) {
		var option = {
			color: colors,
		    title: {
		        text: '类别标准数量top5',
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
		        formatter: '{b}<br>数量：{c0}<br>占比：{c1}%',
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
		        axisLabel: {
		        	show: true,
		        	rotate: 20
		        }
		    },
		    yAxis: [{
		        type: 'value',
		        name: '数量'
		    }, {
		    	type: 'value',
		    	name: '占比(%)',
		    	max: 100
		    }],
		    series: [{
	            type:'bar',
                barWidth: '15px',
	            data: yData1
	        }, {
	            type:'line',
	            data: yData2,
	            yAxisIndex: 1
	        }]
		};
		info.setOption(option);
	}

	function drawChart3(xData, yData) {
		var option = {
			color: colors,
		    title: {
		        text: '标准文档下载top20',
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
		        left: '100px',
		        right: '60px',
		        bottom: '30px',
				top: '10px',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'category',
		        data: xData,
		        name: '文件名',
		        axisLabel: {
		        	show: true,
		        	rotate: 60,
					interval: 0,
					color: '#000'
		        }
		    },
		    yAxis: {
		        type: 'value',
		        name: '数量'
		    },
		    series: [{
	            type:'bar',
                barWidth: '15px',
	            data: yData
	        }]
		};
		download.setOption(option);
	}

	// 标准上传单位top10
	function getChart1() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/standard/home/uploadCompany/top10',
            success:function (res) {
				var xData = [];
				var yData = [];
            	if (res.data) {
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.count);
	                	yData.push(app.name);
	                }
            	}
				drawChart1(xData, yData);
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 类别标准数量top5
	function getChart2() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/standard/home/statType/top5',
            success:function (res) {
				var yData1 = [];
				var yData2 = [];
				var xData = [];
            	if (res.data) {
            		var data = res.data;
            		for (var i = 0; i < data.length; i++) {
            			yData1.push(data[i].count);
						yData2.push(data[i].proportion);
						xData.push(data[i].type);
            		}
            	}
				drawChart2(xData, yData1, yData2);
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
            url: _GATE_URL + '/api/standard/home/statHandle/nums',
            success:function (res) {
            	if (res.data) {
            		$('#monthAddNum').text(res.data.monthAddNum);
					$('#monthOperationNum').text(res.data.monthOperationNum);
					$('#monthUsedNum').text(res.data.monthUsedNum);
					$('#operationNum').text(res.data.operationNum);
					$('#overdueNum').text(res.data.overdueNum);
					$('#standardNum').text(res.data.standardNum);
					$('#standardUsedNum').text(res.data.standardUsedNum);
					$('#monthOverdueNum').text(res.data.monthOverdueNum);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 标准文档下载top20
	function getChart3() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/standard/home/downLoad/top20',
            success:function (res) {
				var xData = [];
				var yData = [];
            	if (res.data) {
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.name.substring(0, 30));
	                	yData.push(app.count);
	                }
            	}
				drawChart3(xData, yData)
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 获取类别分析的表格数据
	function getTypeAna() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/standard/home/statType/analysis',
            success:function (res) {
            	if (res.data) {
            		var html = [];
					var data = res.data;
					for (var i = 0; i < data.length; i++) {
						var count = data[i].count;
						var name = data[i].name;
						if(count!==0){
							name = '<a href="/gxqpt-standard/standard/typeAccess?id='+data[i].id+'&name='+data[i].name+'" target="home">'+data[i].name+'</a>'
						}
						html.push('<tr>\
				                        <td>'+name+'</td>\
				                        <td>'+data[i].count+'</td>\
				                    </tr>');
					}
					$('#typeAna').html(html.join(''));
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 标准上传单位top10
	getChart1();
	// 类别标准数量top5
	getChart2();
	// 获取总体信息，上方的card
	getAllInfo();
	// 标准文档下载top20
	getChart3();
	// 获取类别分析的表格数据
	getTypeAna();
});