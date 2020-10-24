<template>
	<Layout>
		<Content>
			<Breadcrumb class="pageTitle">
				<BreadcrumbItem>统一监管平台</BreadcrumbItem>
				<BreadcrumbItem>首页</BreadcrumbItem>
			</Breadcrumb>
			<div class="analyItem">
			<div class="item">
					<h3>未确认</h3>
					<p>
						<span class="numStyle" v-for="dealItem in unConfirmedNum" :key="dealItem">{{dealItem || 0}}</span>
						<sub class="item_sub">个</sub>
					</p>
				</div>
				<div class="item">
					<h3>已确认</h3>
					<p>
						<span class="numStyle" v-for="dealItem in confirmedNum" :key="dealItem">{{dealItem || 0}}</span>
						<sub class="item_sub">个</sub>
					</p>
				</div>
				<div class="item">
					<h3>已处理</h3>
					<p>
						<span class="numStyle" v-for="dealItem in handledNum" :key="dealItem">{{dealItem || 0}}</span>
						<sub class="item_sub">个</sub>
					</p>
				</div>
				<div class="item">
					<h3>预警平均处理时间</h3>
					<p>
						<span class="numStyle" v-for="dealItem in avgHandleTimeNum" :key="dealItem">{{dealItem || 0}}</span>
						<sub class="item_sub">小时</sub>
					</p>
				</div>
			</div>
			<Row class="marginBottom" type="flex" justify="space-between">
				<Col class="bgWhite" style="width: 56%;">
					<h3 class="echartsTle">部门预警情况分析</h3>
					<div class="warning-analysis">
						<warning-analysis ref="warningAnalysis"></warning-analysis>
					</div>
				</Col>
				<Col class="bgWhite" style="width: 42%;">
					<h3 class="echartsTle">应用预警情况</h3>
					<p class="secondTle">
						<span class="lt">内部应用预警情况</span>
						<span class="rt">接入应用预警情况</span>
					</p>
					<div class="app-warning">
						<app-warning ref="appWarning"></app-warning>
					</div>
				</Col>
			</Row>
			<Row class="marginBottom" type="flex" justify="space-between">
				<Col class="bgWhite" style="width: 27%;">
					<h3 class="echartsTle">平台预警级别情况</h3>
					<div class="warning-level">
						<warning-level ref="levelWarning"></warning-level>
					</div>
				</Col>
				<Col class="bgWhite" style="width: 27%;">
					<h3 class="echartsTle">应用预警情况分析</h3>
					<div class="app-warning-analysis">
						<app-warning-analysis ref="typeWarning"></app-warning-analysis>
					</div>
				</Col>
				<Col class="bgWhite" style="width: 42%;">
					<h3 class="echartsTle">预警产生处理情况</h3>
					<div class="warning-occur-handle">
						<warning-occur-handle ref="monthsWarning"></warning-occur-handle>
					</div>
				</Col>
			</Row>
		</Content>
	</Layout>
</template>

<script>
	import {mapState} from 'vuex'
	import bar3D from './echarts/bar3D'
	import doubleBar from './echarts/doubleBar'
	import pieCharts from './echarts/pieCharts'
	import radarCharts from './echarts/radarCharts'
	import barCharts from './echarts/barCharts'
	import api from '@/api/axiosApi'
	import superviseApiList from '@/api/superviseApiList'

	export default {
		data() {
			return {
				unConfirmedNum: 0,
				confirmedNum: 0,
				handledNum: 0,
				avgHandleTimeNum: 0,
				atatusObj: { //领导驾驶舱统计各状态预警数量
					dealNum: [],
					noDealNum: [],
					time: ''
				},
			}
		},
		components: {
			'warningAnalysis': bar3D,
			'appWarning': doubleBar,
			'warningLevel': pieCharts,
			'appWarningAnalysis': radarCharts,
			'warningOccurHandle': barCharts
		},
		computed: {
			...mapState(['userInfo'])
		},
		mounted() {
			this.fairwarnAtatus(); // 领导驾驶舱统计各状态预警数量
			this.fairwarnRelationship(""); // 数博会部门、预警、应用关系
			this.fairwarnApps(""); // 各应用预警数量
			this.fairwarnLevel(""); //统计各级别预警数量
			this.fairwarnType(""); // 统计各类型预警数量
			this.fairwarnMonths(""); // 统计各月份预警数量
		},
		methods: {
			fairwarnAtatus() { // 领导驾驶舱统计各状态预警数量
				const vm = this
				api(superviseApiList.getWarnMixStatusNum, {
					userId: vm.userInfo.userId
				}).then(res => {
					if (res.data.errcode === 0) {
					const data = res.data.data
					let dealString = data.unConfirmedNum
					if(dealString.length < 2) {
						dealString = "0" + dealString;
					}
					let confirmedString = data.confirmedNum
					if(confirmedString.length < 2) {
						confirmedString = "0" + confirmedString;
					}
					let handledString = data.handledNum
					if(handledString.length < 2) {
						handledString = "0" + handledString;
					}
					let avgHandleTimeString = data.avgHandleTimeNum
					if(avgHandleTimeString.length < 2) {
						avgHandleTimeString = "0" + avgHandleTimeString;
					}
					vm.unConfirmedNum = dealString.toString().split('')
					vm.confirmedNum = confirmedString.toString().split('')
					vm.handledNum = handledString.toString().split('')
					vm.avgHandleTimeNum = avgHandleTimeString.toString().split('')
					} else {
					vm.$Message.info(res.data.errmsg)
					}
				}, err => {console.log(err)})
			},
			fairwarnRelationship(id) { // 数博会部门、预警、应用关系
				/*api(superviseApiList.fairwarnRelationship).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						let xAxis3D = [];
						let yAxis3D = [];
						let optionData = [];
						let tempDate = {};
						for(let i in data) {
							xAxis3D.push(data[i].appName);
							yAxis3D.push(data[i].department);
							tempDate[data[i].appName + "--" + data[i].department] = data[i].count;
						};
						xAxis3D = this.toHeavy(xAxis3D);
						yAxis3D = this.toHeavy(yAxis3D);
						for(let i = 0; i < xAxis3D.length; i++) {
							let xAxis = xAxis3D[i]
							for(let j = 0; j < yAxis3D.length; j++) {
							  if (tempDate[xAxis3D[i] + "--" + yAxis3D[j]]) {
							    optionData.push([i, j, tempDate[xAxis3D[i] + "--" + yAxis3D[j]]]);
							  }
							}
						};
						let echartsData = {
							xAxis3D: xAxis3D,
							yAxis3D: yAxis3D,
							optionData: optionData
						};
						this.$refs.warningAnalysis.refresh(echartsData);
					};
				}, (err) => {
					//dong something...
				})*/
				api(superviseApiList.fairwarnRelationship, {type: 'sup'}).then((res) => {
          if(res.status == 200 && res.data.data) {
            let data = res.data.data;
            if (data) {
              let xzData = []
              let yzLevelOneData = []
              let yzLevelTwoData = []
              let yzLevelThreeData = []
              let yzLevelFourData = []
              data.map(item => {
                xzData.push(item.department)
                item.levelNums.map(res => {
                  switch (res.level){
                    case 1:
                      yzLevelOneData.push(res.count)
                      break
                    case 2:
                      yzLevelTwoData.push(res.count)
                      break
                    case 3:
                      yzLevelThreeData.push(res.count)
                      break
                    case 4:
                      yzLevelFourData.push(res.count)
                      break
                    default:
                      break
                  }
                })
              })
              let echartsData = {
                xzData,
                yzLevelOneData,
                yzLevelTwoData,
                yzLevelThreeData,
                yzLevelFourData
              }
              this.$refs.warningAnalysis.refresh(echartsData);
            }
          };
        }, (err) => {
          //dong something...
        })
			},
			fairwarnApps(id) { // 各应用预警数量
				api(superviseApiList.fairwarnApps).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						if(data != null) {
							let inner = data.inner;
							let outer = data.outer;
							let myData = [];
							let databeast = [];
							let myData1 = [];
							let databeast1 = [];
							if(inner != null && inner.length > 0) {
								for(let i = 0; i < inner.length; i++) {
									myData.push(inner[i].appName);
									databeast.push(inner[i].count);
								};
							};
							if(outer != null && outer.length > 0) {
								for(let i = 0; i < outer.length; i++) {
									myData1.push(outer[i].appName);
									databeast1.push(outer[i].count);
								};
							};
							let echartsData = {
								myData: myData,
								myData1: myData1,
								databeast: databeast,
								databeast1: databeast1,
							};
							this.$refs.appWarning.refresh(echartsData);
						};
					}
				}, (err) => {
					//dong something...
				})
			},
			fairwarnLevel(id) { // 统计各级别预警数量
				api(superviseApiList.fairwarnLevel, {
					appid: id
				}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						var echartsData = [];
						var echartsDataDefault = [{
								value: 0,
								name: '较大预警',
								itemStyle: {
									color: '#fc6400'
								}
							}, {
								value: 0,
								name: '一般预警',
								itemStyle: {
									color: '#da9d3d'
								}
							},
							{
								value: 0,
								name: '低风险预警',
								itemStyle: {
									color: '#0067ff'
								}
							}, {
								value: 0,
								name: '重大预警',
								itemStyle: {
									color: '#d90b0d'
								}
							}
						];
						if(data != null && data.length > 0) {
							for(let i = 0; i < data.length; i++) {
								let entity = {};
								entity.value = data[i].count;
								let itemStyles = {};
								let normals = {};
								itemStyles.normal = normals;
								entity.itemStyle = itemStyles;
								if(data[i].level == 1) {
									normals.color = "#0067ff";
									entity.name = "一般";
								} else if(data[i].level == 2) {
									normals.color = "#da9d3d";
									entity.name = "较重";
								} else if(data[i].level == 3) {
									normals.color = "#fc6400";
									entity.name = "严重";
								} else if(data[i].level == 4) {
									normals.color = "#d90b0d";
									entity.name = "特别严重";
								}
								echartsData.push(entity);
							}
							this.$refs.levelWarning.refresh(echartsData, '预警级别');
						} else {
							this.$refs.levelWarning.refresh(echartsDataDefault, '预警级别');
						};
					}
				}, (err) => {
					//dong something...
				})
			},
			fairwarnType(id) { // 统计各类型预警数量
				api(superviseApiList.fairwarnType, {
					appid: id
				}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						let indicatorList = [];
						let dataList = [];
						if(data != null && data.appNames) {
							let appNames = data.appNames;
							let types = data.types;
							let counts = data.counts;
							let maxNum = Math.max(...counts);
							for(let i = 0; i < appNames.length; i++) {
								let dataEntity = {};
								dataEntity.name = appNames[i];
								dataEntity.value = counts[i];
								dataList.push(dataEntity);
								let names = {};
								names.name = appNames[i]
								names.max = maxNum + 5;
								indicatorList.push(names);
							}
						} else {
							indicatorList = [{
									name: '工作超时',
									max: 6500
								}, {
									name: '流程异常',
									max: 16000
								},
								{
									name: '考核异常',
									max: 30000
								}, {
									name: '系统对接',
									max: 38000
								}, {
									name: '人员变动',
									max: 52000
								}
							];
							dataList = [];
						};
						this.$refs.typeWarning.refresh(indicatorList, dataList);
					}
				}, (err) => {
					//dong something...
				})
			},
			fairwarnMonths(id) { // 统计各月份预警数量
				api(superviseApiList.fairwarnMonths, {
					appid: id
				}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						let pendingList = [];
						let newComeList = [];
						let handledList = [];
						let monthList = [];
						if(data != null && data.length > 0) {
							for(let i = data.length - 1; i < data.length; i--) {
								pendingList.push(data[i].pending);
								newComeList.push(data[i].newCome);
								handledList.push(data[i].handled);
								monthList.push(data[i].month);
								if(i == 0) {
									break;
								}
							};
							const echartData={
								monthList:monthList,
								pendingList:pendingList,
								newComeList:newComeList,
								handledList:handledList,
							};
							this.$refs.monthsWarning.refresh(echartData);
						}
					}
				}, (err) => {
					//dong something...
				})
			},
			toHeavy(list) { //数组去重
				let res = [];
				let json = {};
				for(let i = 0; i < list.length; i++) {
					if(!json[list[i]]) {
						res.push(list[i]);
						json[list[i]] = 1;
					}
				}
				return res;
			}
		}
	}
</script>
<style lang="less" scoped="scoped">
	.secondTle {
		position: relative;
		margin-top: 16px;
		color: #0090B6;
	}
	
	.secondTle .lt {
		float: left;
		display: inline-block;
		width: 45%;
		text-align: right;
	}
	
	.secondTle .rt {
		float: right;
		display: inline-block;
		width: 45%;
		text-align: left;
	}
	
	.echartsTle {
		line-height: 36px;
		width: 98%;
		margin: auto;
		border-bottom: 1px solid #ddd;
		font-size: 14px;
	}
	
	.marginBottom {
		margin-bottom: 30px;
	}
	
	.bgWhite {
		background: white;
	}
	
	.pageTitle {
		border-bottom: 1px solid #DDDDDD;
		padding-bottom: 6px;
	}
	
	.warning-analysis,
	.app-warning {
		height: 500px;
	}
	
	.warning-level,
	.app-warning-analysis,
	.warning-occur-handle {
		height: 300px;
	}
	
	.analyItem {
		text-align: center;
		margin-bottom: 20px;
		.item {
			display: inline-block;
			margin: 10px 20px;
			h3 {
				color: #0099CC;
				font-size: 16px;
				margin-bottom: 20px;
			}
			.numStyle {
				border: 1px solid #0099CC;
				display: inline-block;
				width: 36px;
				line-height: 36px;
				font-size: 24px;
				color: #333;
				border-radius: 5px;
				margin: 0 3px;
			}
			.item_sub {
				font-size: 18px;
				color: #333;
			}
		}
	}
</style>