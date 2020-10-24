$(function () {
	// 基于准备好的dom，初始化echarts实例
    var app = echarts.init(document.getElementById('app'));
    // 基于准备好的dom，初始化echarts实例
    var info = echarts.init(document.getElementById('info'));
    // 半年的考勤统计
    var attence = null;
    // 数据的单位
    var unitName = {
    	earlyHour: '小时',
		lateHour: '小时',
		leaveHous: '小时',
		minerCounts: '次数',
		normalDays: '天数',
		travelHous: '小时',
		workHous: '小时'
    }

    var colors = ['#487EC1', '#48B9C1', '#A27DE2', '#32C0D6', '#70C44B'];

	function drawAppChart(xData, yData) {
		var option = {
			color: colors,
			title: {
				text: 'APP 升级人数统计',
				bottom: 0,
				left: 'center',
				textStyle: {
					color: '#333'
				}
			},
		    tooltip:{
		        show: true,
		        formatter: '{b0}: {c0}次'
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: xData
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [{
		        data: yData,
		        type: 'line',
        		areaStyle: {}
		    }]
		};
		app.setOption(option);
	}

	function drawInfoChart(type) {
		var option = {
			color: colors,
		    title: {
		        text: '最近半年考勤',
		        bottom: 0,
				left: 'center',
				textStyle: {
					color: '#333'
				}
		    },
		    tooltip: {
		    	show: false
		    },
		    legend: {
		    	show: false
		    },
		    tooltip: {
		        trigger: 'axis'
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
		        data: attence.yearMonths,
		        name: '时间'
		    },
		    yAxis: {
		        type: 'value',
		        name: unitName[type]
		    },
		    series: [{
	            type:'line',
	            stack: '总量',
	            data: attence[type]
	        }]
		};
		info.setOption(option);
	}

	// 查看app每个版本的下载数量
	function getAppDownload() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/mt/index/getAppUpdateInfo',
            success:function (res) {
            	if (res.data) {
            		var xData = [];
            		var yData = [];
            		for (var i = 0; i < res.data.length; i++) {
	                	var app = res.data[i];
	                	xData.push(app.verName);
	                	yData.push(app.updateNum);
	                }
	                drawAppChart(xData, yData);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	// 获取半年的考勤
	function getAttence() {
		ajaxHengyun({
            type: 'GET',
            url: _GATE_URL + '/api/mt/index/queryHalfYearAttence',
            success:function (res) {
            	if (res.data) {
            		attence = res.data;
            		drawInfoChart('normalDays');
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
            url: _GATE_URL + '/api/mt/index/getTotalInfo',
            success:function (res) {
            	if (res.data) {
            		$('#appNum').text(res.data.appNum);
					$('#appLastUpdateNum').text(res.data.appLastUpdateNum);
					$('#applNum').text(res.data.applNum);
					$('#baseApplNum').text(res.data.baseApplNum);
					$('#nowMonthDayNum').text(res.data.nowMonthDayNum);
					$('#nowNormalDayNum').text(res.data.nowNormalDayNum);
					$('#aprNum').text(res.data.aprNum);
					$('#workLogNum').text(res.data.workLogNum);
            	}
            },
            error: function(err) {
                console.log(err);
            }
        });
	}

	function bindEvent() {
		$('input[name="optionsRadiosinline"]').on('change', function () {
			if (attence) {
				drawInfoChart($(this).val());
			}
		});

		// 跳转到考勤
		$('.aprNum').on('click', function () {
			window.location.href = '/gxqpt-mt/fast/workapprove/list?isSend=false'
		});

		// 跳转到日志
		$('.workLogNum').on('click', function () {
			window.location.href = '/gxqpt-mt/module/leaderview'
		});
	}
	bindEvent();
	getAppDownload();
	getAttence();
	getAllInfo();
});