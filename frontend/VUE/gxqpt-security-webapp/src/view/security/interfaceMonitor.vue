<template>
	<Layout>
		<Content>
			<Breadcrumb>
				<BreadcrumbItem>安全保障平台</BreadcrumbItem>
				<BreadcrumbItem>接口监控</BreadcrumbItem>
			</Breadcrumb>
			<Card>
				<Form :model="formData" inline :label-width="40">
					<FormItem label="日期">
						<DatePicker type="date" :value="formData.date" :editable="false" :options="optionsDate" @on-change="dateChange" placeholder="选择日期"></DatePicker>
					</FormItem>
				</Form>
				<div class="left-box">
					<Input class="search" v-model="search" icon="android-search" placeholder="接口名称" @on-click="getNeedFilter"></Input>
					<ul class="form-group">
						<li class="form-item" v-for="(item,index) of interfaceList" @click="getApiAccessStat(item.id,$event)" :class="{'active':formData.id==item.id}" v-show="!search || item.apiName.indexOf(search) >= 0">{{item.apiName}}</li>
					</ul>
				</div>
				<div class="right-box">
					<div id="myCharts"></div>
				</div>
			</Card>
		</Content>
	</Layout>
</template>
<script>
import api from '@/api/axiosApi'
import apiList from '@/api/securityApiList'
export default {
	data() {
		return {
		  optionsDate: {
        disabledDate (date) {
          return date && (date.valueOf() > Date.now() || date.valueOf() < (new Date('2019-01-18 00:00:00')).getTime())
        }
      },
			myCharts: null,
			option: null,
			ruleValidate: {},
			search: '',
			formData: {
				date: '',
				id: ''
			},
			interfaceList: []
		}
	},
	methods: {
		init() {
			let _this = this;
			window.onresize = function() {
				_this.chartsChange();
			}
			function formatDate(num) {
				if(num < 10) {
					return '0' + num;
				} else {
					return num;
				}
			}
			var d = new Date();
			this.formData.date = d.getFullYear() + '-' + formatDate((d.getMonth() + 1)) + '-' + formatDate(d.getDate());
			this.getNeedFilter();
		},
		chartsChange() {
			this.myCharts.resize();
		},
		test() {
			alert()
		},
		getNeedFilter() {
			api(apiList.getInterfaceConfigList,{apiName:this.search}).then((res) => {
				if(res.status == 200) {
					this.interfaceList = res.data.data;
					this.getApiAccessStat(res.data.data[0].id);
				}
			}, (err) => {
				//do something...
			})
		},
		getApiAccessStat(id, $event) {
			this.formData.id = id;
			api(apiList.getApiAccessStat, this.formData).then((res) => {
				if(res.status == 200) {
					this.buildCharts(res.data.data);
				}
			}, (err) => {
				//do something...
			})
		},
		dateChange(fdate, type) {
			this.formData.date = fdate;
		},
		buildCharts(data) {
			let myCharts = this.myCharts = this.$echarts.init(document.getElementById("myCharts"));
			this.option = {
				tooltip: {
					trigger: 'axis'
				},
				grid: {
					top: '10%',
					bottom: '5%',
					left: '8%',
					right: '3%',
					containLabel: true
				},
				xAxis: {
					type: 'category',
					boundaryGap: false,
					data: ['1点', '2点', '3点', '4点', '5点', '6点', '7点', '8点', '9点', '10点', '11点', '12点', '13点', '14点', '15点', '16点', '17点', '18点', '19点', '20点', '21点', '22点', '23点', '24点']
				},
				yAxis: {
					type: 'value',
					name: '次'
				},
				series: [{
					data: data,
					type: 'line'
				}]
			}
			myCharts.setOption(this.option)
		}
	},
	mounted() {
		this.$nextTick(() => {
			this.init();
			//				this.buildCharts();
		})
	}
}
</script>
<style lang="less" scoped="scoped">
	.ivu-card {
		width: 100%;
		display: table;
		padding-bottom: 30px;
		.left-box,
		.right-box {
			float: left;
			min-height: 500px;
		}
		.left-box {
			position: relative;
			border: 1px solid #ccc;
			width: 230px;
			ul.form-group {
				list-style-type: none;
				height: 500px;
				overflow: auto;
				.form-item {
					padding-left: 12px;
					min-height: 35px;
					line-height: 35px;
					cursor: pointer;
					&:hover{
						background-color: #57a3f3;
    					color: #fff !important;
					}
				}
				.form-item.active {
					color: #1094FA;
					border-right: 2px solid #1094FA;
				}
			}
			z-index: 0;
			.search {
				margin: 20px auto;
				width: 90%;
				display: block;
			}
		}
		.right-box {
			margin-left: 30px;
			width: calc(100% - 260px);
			#myCharts {
				float: left;
				width: 100%;
				/*margin-top: 75px;*/
				height: 400px;
				position: relative;
			}
		}
	}
</style>