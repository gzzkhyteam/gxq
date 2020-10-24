<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>用户日志</BreadcrumbItem>
				</Breadcrumb>
				<Card>
                    <Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="80">
						<FormItem label="登录账号：">
							<Input v-model="formQueryData.account" type="text" />
						</FormItem>
                        <FormItem label="用户名：">
							<Input v-model="formQueryData.userName" type="text" />
						</FormItem>
						<FormItem label="登录时间：">
							<DatePicker type="date" v-model="formQueryData.startLginTime" placeholder="请选择登录开始时间"></DatePicker> -
							<DatePicker type="date" v-model="formQueryData.endLginTime" placeholder="请选择登录结束时间"></DatePicker>
						</FormItem>
						<FormItem label="退出时间：">
							<DatePicker type="date" v-model="formQueryData.startLogoutTime" placeholder="请选择退出开始时间"></DatePicker> -
							<DatePicker type="date" v-model="formQueryData.endLogoutTime" placeholder="请选择退出结束时间"></DatePicker>
						</FormItem>
                        <Button type="info" @click="receivePage">查询</Button>
					</Form>
					<hy-table class="marginTop" ref="selection" :data="data" :columns="columns" :total="pageOption.total" :page-size="pageOption.pageSize" @on-change="pageChange" @on-page-size-change="changePageSize" :current="pageOption.current" show-total show-sizer show-elevator/>
				</Card>
			</Content>
		</Layout>

	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	// import { mapState,mapActions } from 'vuex'

	export default {
		components: {
		},
		data() {
			return {
				mailId:"",//选中项id
				total:"",////草稿箱邮件总数
				pageOption: { //分页参数
					current: 1,
					total: 0,
					pageSize: 10
				},
                formQueryData: {
                    account: '',
					userName: '',
					startLginTime: '',
					endLginTime: '',
                    endLogoutTime: '',
					startLogoutTime: '',
					appId: '35kj6357'
                },
				columns: [{//列表设置
						title: '登录账号',
						key: 'account',
						width: 270
					},
                    {
						title: '登录人名称',
						key: 'userName',
						width: 180
					},
					{
						title: '登录平台',
						key: 'appName'
					},
                    {
						title: '登录时间',
						key: 'loginTime',
						width: 200
					},
					{
						title: '退出时间 ',
						key: 'logoutTime',
						width: 200
					}
                    // {
					// 	title: '退出时间结束时间',
					// 	key: 'endLogoutTime',
					// },
                    // {
					// 	title: '退出时间开始时间',
					// 	key: 'startLogoutTime',
					// }
				],
				data:[],//列表数据
			}
		},
		computed: {
			// ...mapState(['folderList'])
		},
		mounted(){
			this.receivePage();//获取表格列表
		},
		methods:{
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.mailId="";
				this.receivePage();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailId="";
				this.receivePage();
			},
			add(){//新增 
				this.$refs.addModal.init(null, '新增')
			},
			receivePage() {//获取表格列表
			let _this = this;
			_this.formQueryData.startLginTime = _this.fmaterTime(_this.formQueryData.startLginTime)
			_this.formQueryData.endLginTime = _this.fmaterTime(_this.formQueryData.endLginTime)
			_this.formQueryData.startLogoutTime = _this.fmaterTime(_this.formQueryData.startLogoutTime)
			_this.formQueryData.endLogoutTime = _this.fmaterTime(_this.formQueryData.endLogoutTime)
				let data = {
					data: {
                        ..._this.formQueryData
                    },
					pageNo: this.pageOption.current,
					pageSize: this.pageOption.pageSize
				};
				api(emailApi.loginLogPage, data).then((res) => {
					if(res.status == 200 && res.data.data) {
						if(!res.data.data.list){
							_this.data=[];
						}else{
							_this.data = res.data.data.list;
						};
						if(_this.data.length > 0) {
							_this.pageOption.pageSize = res.data.data.pageSize;
							_this.pageOption.total = Number(res.data.data.total);
							_this.pageOption.current = res.data.data.pageNum;
						};
					}else{
						this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
						_this.data=[];
					}
				}, (err) => {})
			},
			// 时间格式化
			fmaterTime (val) {
				if (val) {
					const dateVal = new Date(val)
					const y = dateVal.getFullYear()
					const mouth = (dateVal.getMonth() + 1).toString().padStart(2, '0')
					const d = (dateVal.getDate()).toString().padStart(2, '0')
					const h = (dateVal.getHours()).toString().padStart(2, '0')
					const m = (dateVal.getMinutes()).toString().padStart(2, '0')
					const s = (dateVal.getSeconds()).toString().padStart(2, '0')
					return `${y}-${mouth}-${d} ${h}:${m}:${s}`
				} else {
					return ''
				}
			},
            // search () {
            // }
			// ...mapActions([
			// 	'sostomfileFindAll'
			// ])
		}
	}
</script>

<style type="text/css" scoped>
	.wAuto {
		width: 100%;
	}
	.queryItem {
		width: 160px;
	}
	.rt{
		float: right;
	}
	.seachForm{
		margin-bottom: 25px;
	}
	.seachForm:after{
		clear: both;
		content: ".";
		display: block;
		height: 0;
		visibility: hidden;
	}
</style>