<!-- 人员预警处理对比分析图 -->
<template>
	<div id="pieCharts"></div>
</template>

<script>
	export default {
		data() {
			return {
				data:[],
				name: ''
			}
		},
		methods: {
			refresh(data, name) {
				this.data = data;
				this.name = name;
				this.initLineBar();
			},
			initLineBar() {
				// 基于准备好的dom，初始化echarts实例
				var lineBar = this.$echarts.init(document.getElementById('pieCharts'))
				const option = {
					title: {
						text: '',
						subtext: '',
						x: 'center'
					},
					tooltip: {
						trigger: 'item',
						formatter: "{a} <br/>{b} : {c} ({d}%)"
					},
					legend: {
						data: []
					},
					series: [{
						name: this.name || '',
						type: 'pie',
						radius: '55%',
						center: ['50%', '60%'],
						data: this.data,
						itemStyle: {
							emphasis: {
								shadowBlur: 10,
								shadowOffsetX: 0,
								shadowColor: 'rgba(0, 0, 0, 0.5)'
							}
						}
					}]
				};

				// 使用刚指定的配置项和数据显示图表。
				lineBar.setOption(option);
			}
		}
	}
</script>

<style lang="less" scoped>
	#pieCharts {
		width: 100%;
		height: 100%;
	}
</style>