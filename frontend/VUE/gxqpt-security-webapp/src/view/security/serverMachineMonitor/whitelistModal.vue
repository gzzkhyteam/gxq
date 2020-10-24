<template>
	<div>
		<Form inline :label-width="80" :model="searchFormData">
			<FormItem label="服务器地址">
				<Input type="text" v-model="searchFormData.serverIp" @on-keypress.enter="getProcessWhite" placeholder="回车搜索">
				</Input>
			</FormItem>
		</Form>
		<hy-table border ref="safetyEvalTable" :data="data" :columns="columns" :current="pageOption.current" :total="pageOption.total" :page-size="pageOption.pageSize" @on-change="pageChange" @on-page-size-change="changePageSize" show-sizer show-elevator/>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/securityApiList'
	export default {
		data() {
			return {
				addList: false,
				searchFormData: {},
				pageOption: {
					current: 1,
					total: 0,
					pageSize: 10
				},
				columns: [{
						type: 'index',
						title: '序号',
						width: 60,
						align: 'center'
					},
					{
						title: '服务器地址',
						key: 'serverIp'
					},
					{
						title: '进程名称',
						key: 'processName'
					},
					{
						title: '进程创建日期',
						key: 'createTime'
					},
					{
						title: '备注',
						key: 'remarks'
					}
				],
				data: []
			}
		},
		methods: {
			init() {
				this.getProcessWhite();
      },
      search() {
				this.pageOption.current=1;
				this.getProcessWhite();
      },
			getProcessWhite(){
				let params = {
					data: this.searchFormData,
					pageNo: this.pageOption.current,
					pageSize: this.pageOption.pageSize
				}
				api(apiList.getProcessWhite,params).then((res)=>{
					if(res.status == 200){
						this.data = res.data.data.list;
						this.pageOption.total = res.data.data.total;
					}
				},(err)=>{
					//do something...
				})
			},
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.getProgram();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.getProgram();
			}
		},
		created() {
			this.init();
		}
	}
</script>

<style lang="less" scoped="scoped">
	.pull-right {
		float: right;
		margin-right: 0;
	}
</style>

<style lang="less">
	span.whitelist-delete {
		color: #238BE6;
		cursor: pointer;
	}
</style>