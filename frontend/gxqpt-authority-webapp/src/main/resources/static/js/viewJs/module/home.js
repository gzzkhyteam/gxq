$(function () {
	// 基于准备好的dom，初始化echarts实例
    var chart1 = echarts.init(document.getElementById('chart1'));
    // 基于准备好的dom，初始化echarts实例
    var chart2 = echarts.init(document.getElementById('chart2'));

    var colors = ['#487EC1', '#48B9C1', '#A27DE2', '#32C0D6', '#70C44B'];

	function drawChart1(xData, yData) {
		var option = {
			color: colors,
			title: {
				text: '近一年系统统一认证接入情况',
		        bottom: 0,
				left: 'center',
				textStyle: {
					color: '#487EC1'
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
				type: 'category',
				boundaryGap: [0, 0.01],
				name: '日期',
				data: xData
			},
			yAxis: {
				type: 'value',
				name: '次数'
			},
			series: [{
				type: 'bar',
				data: yData
			}]
		};
		chart1.setOption(option);
	}

	function drawChart2(xData, yData1, yData2) {
		var option = {
			color: colors,
		    title: {
		        text: '近一年资源-角色完善情况',
		        bottom: 0,
				left: 'center',
				textStyle: {
					color: '#487EC1'
				}
		    },
		    legend: {
		    	data: ['资源', '角色']
		    },
		    tooltip: {
		        trigger: 'axis',
		        formatter: '{b}<br>资源：{c0}<br>角色：{c1}',
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
		        name: '日期'
		    },
		    yAxis: [{
		        type: 'value',
		        name: '数量'
		    }],
		    series: [{
	            type:'line',
	            name: '资源',
	            data: yData1
	        }, {
	            type:'line',
	            name: '角色',
	            data: yData2
	        }]
		};
		chart2.setOption(option);
	}

	// 近一年系统统一认证接入情况
	function getChart1() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/developer/serviceModule/findTyrzJoinLastYear',
            success:function (res) {
            	if (res.data) {
            		var xData = res.data.xAxis;
            		var yData = res.data.data;
	                drawChart1(xData, yData);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 近一年资源-角色完善情况
	function getChart2() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/admin/resource/findResourAndRoleLastYear',
            success:function (res) {
            	if (res.data) {
            		var data = res.data;
            		// 资源
            		var yData1 = data.series[0].data;
            		// 角色
            		var yData2 = data.series[1].data;
            		var xData = data.xAxis;
            		drawChart2(xData, yData1, yData2);
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
            url: _GATE_URL + '/api/admin/gxqpt/org/getOrgStatisticsNum',
            success:function (res) {
            	if (res.data) {
            		$('#orgNum').text(res.data.orgNum);
					$('#dpmNum').text(res.data.dpmNum);
					$('#appNum').text(res.data.appNum);
					$('#empNum').text(res.data.empNum);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 获取常用快捷入口菜单排名
	function getEntries() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/admin/fastEntry/getFastEntryRank',
            data: {
            	resultNum: 20
            },
            success:function (res) {
            	if (res.data) {
            		var html = [];
					var data = res.data;
					for (var i = 0; i < data.length; i++) {
						html.push('<tr>\
										<td>'+(i+1)+'</td>\
				                        <td>'+data[i].appResourceName+'</td>\
				                        <td>'+data[i].appName+'</td>\
				                    </tr>');
					}
					$('#tbody').html(html.join(''));
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 近一年系统统一认证接入情况
	getChart1();
	// 近一年资源-角色完善情况
	getChart2();
	// 获取总体信息，上方的card
	getAllInfo();
	// 获取常用快捷入口菜单排名
	getEntries();
});