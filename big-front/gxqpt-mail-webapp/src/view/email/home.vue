<template>
	<Layout>
		<Content>
			<Breadcrumb>
				<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
				<BreadcrumbItem>首页</BreadcrumbItem>
			</Breadcrumb>
			<Card>
				<h3 class="h3_title">欢迎您，{{userInfo.name}}</h3>
				<div id='calendar' style="width: 100%;height: 700px;"></div>
				<div class="clearfix"> </div>
			</Card>
		</Content>
	</Layout>
</template>
<script>
	import $ from 'jquery'
	import calendar from '@static/Simple-Calendar' //使用日历模板
	import { mapState } from 'vuex'
	export default {
		data() {
			return {
				systemNames: [],
				BackupNames: [],
				myCalendar: null,
				formData: {
					yearMonth: '',
				}
			}
		},
		computed: {
			...mapState(['userInfo'])
		},
		mounted() {
			var _this = this;
			_this.myCalendar = new SimpleCalendar('#calendar', {
				showFestival: false,
				showHoliday: false,
				showSolarTerm: false,
				showLunarFestival: false,
				showMark: false,
				height: '560px',
				callBack: function(year, month) {
					_this.formData.yearMonth = year + '-' + month;
				}
			});
		},
	}
</script>
<style lang="less" scoped="scoped">
	#calendar /deep/ .sc-item.sc-backup {
		background: #a3fda3;
	}
	
	#calendar /deep/ .sc-item.sc-backup-err {
		background: #ff968e;
	}
	.h3_title{
		text-align: center;
		margin: 20px 0;
		color: #0592B7;
	}
</style>