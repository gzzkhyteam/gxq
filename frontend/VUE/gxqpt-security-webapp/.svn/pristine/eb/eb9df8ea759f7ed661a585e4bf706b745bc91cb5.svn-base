<!-- 人员预警处理对比分析图 -->
<template>
	<div id="contrastAnalyze"></div>
</template>

<script>
export default {
	data () {
		return {
			echartData: [],
			contrastAnalyze: ''
		}
	},
	methods: {
		initLineBar() {
			// 基于准备好的dom，初始化echarts实例
			if (!this.contrastAnalyze) {
				this.contrastAnalyze = this.$echarts.init(document.getElementById('contrastAnalyze'))
			}
			let dataZoomShow = false
			let dataZoomEnd = 100
			if(this.echartData.typeName.length > 8){
			  dataZoomShow = true
			  dataZoomEnd = Math.floor((8/this.echartData.typeName.length)*100)
			}
			const option = {
				color: ['#FFD85C', '#37A2DA'],
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						type: 'shadow'
					}
				},
				legend: {
					data: this.echartData.legendData,
					top: '20px'
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					top: '15%',
					containLabel: true
				},
				xAxis: {
					inverse: true,
					type: 'value',
					boundaryGap: [0, 0.01],
					axisLine: {
                        show: true,
                        lineStyle: {
                            color: "#A6A6A6",
                            width: 1,
                            type: "solid"
                        }
                    },
                    axisTick: {
                        show: false,
                    },
                    axisLabel: {
                        show: true,
                        textStyle: {
                            color: "#000",
                        }
                    }
				},
				yAxis: {
					position: 'right',
					type: 'category',
					data: this.echartData.typeName,
					axisTick: {
                        show: false,
                    },
                    axisLine: {
                        show: true,
                        lineStyle: {
                            color: "#A6A6A6",
                            width: 1,
                            type: "solid"
                        }
                    },
                    axisLabel: {
                    	// interval: 0,
                    	rotate: 45,
                        show: true,
                        textStyle: {
                            color: "#000",
                        }
                    }
				},
				dataZoom: [
  				{
            type: 'slider',
            show: dataZoomShow,
            yAxisIndex: [0],
            left: '98%',
            start: 0,
            end: dataZoomEnd,
            width: 8,
            textStyle: false
          }
        ],
				series: [{
					name: this.echartData.legendData[0],
					type: 'bar',
					data: this.echartData.avg
				},
				{
					name: this.echartData.legendData[1],
					type: 'bar',
					data: this.echartData.num
				}]
			}
			// 使用刚指定的配置项和数据显示图表。
			this.contrastAnalyze.setOption(option);
		},
		refresh (data) {
			this.echartData = data
			this.initLineBar()
		}
	}
}
</script>

<style lang="less" scoped>
	#contrastAnalyze {
		width: 100%;
		height: 300px;
	}
</style>