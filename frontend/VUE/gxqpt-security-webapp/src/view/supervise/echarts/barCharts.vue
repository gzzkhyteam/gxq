<!-- 人员预警处理对比分析图 -->
<template>
	<div id="barCharts"></div>
</template>

<script>
	export default {
		data() {
			return {
				monthList: [],
				pendingList: [],
				newComeList: [],
				handledList: [],
			}
		},
		methods: {
			refresh(data) {
				this.monthList = data.monthList;
				this.pendingList = data.pendingList;
				this.newComeList = data.newComeList;
				this.handledList = data.handledList;
				this.initLineBar();
			},
			initLineBar() {
				let pendingListMax = Math.max.apply(null, this.pendingList);
				let newComeListMax = Math.max.apply(null, this.newComeList);
				let handledListMax = Math.max.apply(null, this.handledList);
				let maxYAxis = Math.max.apply(null, [pendingListMax, newComeListMax, handledListMax]) + 10;
				// 基于准备好的dom，初始化echarts实例
				var lineBar = this.$echarts.init(document.getElementById('barCharts'))
				const option = {
					color: ['#3398DB'],
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					legend: {
						data: ['未确认', '已确认', '已处理'],
						textStyle: {
							fontSize: 12,
							color: '#333'
						}
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: this.monthList,
						axisLabel: {
							interval: 0,
							rotate: 40
						},
						axisTick: {
							alignWithLabel: true
						}
					}],
					yAxis: [{
						type: 'value',
						splitLine: {
							show: false
						},
						axisLine: {
							lineStyle: {
								color: '#fff',
								fontSize: '12'
							}
						},
						max: maxYAxis
					}],
					series: [{
							name: '未确认',
							type: 'bar',
							data: this.pendingList,
							barWidth: 8,
							itemStyle: {
								color: '#f84242',
								fontSize: '12',
								emphasis: {
									barBorderRadius: 8
								},
								normal: {
									barBorderRadius: 8,
									color: new this.$echarts.graphic.LinearGradient(
										0, 0, 1, 0, [{
												offset: 0,
												color: '#f84242'
											},
											{
												offset: 1,
												color: '#f84242'
											}

										]
									)
								}
							}
						},

						{
							name: '已确认',
							type: 'bar',
							stack: '已确认',
							data: this.newComeList,
							barWidth: 8,
							itemStyle: {
								color: '#f8d442',
								fontSize: '12',
								emphasis: {
									barBorderRadius: 8
								},
								normal: {
									barBorderRadius: 8,
									color: new this.$echarts.graphic.LinearGradient(
										0, 0, 1, 0, [{
												offset: 0,
												color: '#f8d442'
											},
											{
												offset: 1,
												color: '#f8d442'
											}

										]
									)
								}
							}
						},
						{
							name: '已处理',
							type: 'bar',
							data: this.handledList,
							barWidth: 8,
							itemStyle: {
								color: '#42f842',
								fontSize: '12',
								emphasis: {
									barBorderRadius: 8
								},
								normal: {
									barBorderRadius: 8,
									color: new this.$echarts.graphic.LinearGradient(
										0, 0, 1, 0, [{
												offset: 0,
												color: '#42f842'
											},
											{
												offset: 1,
												color: '#42f842'
											}

										]
									)
								}

							}

						}
					]
				};

				// 使用刚指定的配置项和数据显示图表。
				lineBar.setOption(option);
			}
		}
	}
</script>

<style lang="less" scoped>
	#barCharts {
		width: 100%;
		height: 100%;
	}
</style>