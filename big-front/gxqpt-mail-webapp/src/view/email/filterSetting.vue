<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>过滤器设置</BreadcrumbItem>
				</Breadcrumb>
				<Card>
					<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="90">
					  <FormItem label="关键字：">
              <Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
            </FormItem>
            <Button type="info" @click="searchfun">搜索</Button>
						<Button type="info" @click="add">新增</Button>
					</Form>
					<hy-table class="marginTop" ref="selection" :data="data" :columns="columns" @on-change="pageChange" @on-page-size-change="changePageSize" :total="pageOption.total" :page-size="pageOption.pageSize" show-total show-sizer show-elevator/>
					<addModal ref="addModal" @on-ok="receivePage" />
				</Card>
			</Content>
		</Layout>

	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import { mapState,mapActions } from 'vuex'
	import addModal from './addModal'

	export default {
		components: {
			addModal
		},
		data() {
			return {
				mailId:"",//选中项id
				total:"",////草稿箱邮件总数
				formQueryData:{//搜索参数
					type:"",
					doc:"",
					search:"",
				},
				isNeedPage: false,
				pageOption: { //分页参数
					pageNo: 1,
					total: 0,
					pageSize: 10
				},
				columns: [{
						title: '关键字',
						key: 'filterWord',
					},
					{
						title: '创建时间',
						width: 200,
						key: 'createTime'
					},
					{
						title: '操作',
						align: 'center',
						width: 130,
						render: (h, params) => {
						// const editBtn = h('Button', {
						// 	props: {
						// 	type: 'primary',
						// 	size: 'small'
						// 	},
						// 	on: {
						// 	click: () => {
						// 		console.log('修改')
						// 		this.$refs.addModal.init(this.params.row, '修改')
						// 	}
						// 	}
						// }, '修改')
						const delBtn = h('Button', {
							props: {
								type: 'info',
								size: 'small'
							},
							on: {
								click: () => {
									console.log('删除')
									this.receiveDelete(params.row.id)
								}
							}
						}, '删除')
						return h('div', [delBtn])
						}
					}
				],
				data:[],//列表数据
			}
		},
		computed: {
			...mapState(['folderList'])
		},
		mounted(){
			this.receivePage();//获取表格列表
		},
		methods:{
			pageChange(num) { //页码改变的回调
				this.pageOption.pageNo = num;
				this.mailId="";
				this.receivePage();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailId="";
				this.receivePage();
			},
			searchfun () {// 搜索
			  this.pageOption.pageNo = 1
			  this.receivePage()
			},
			add(){//新增 
				this.$refs.addModal.init(null, '新增')
			},
			receivePage() {//获取表格列表
			  let _this = this;
			  let searchData = null
			  if (_this.formQueryData.search) {
			    searchData = _this.formQueryData.search
			  }
				let data = {
				  data: searchData,
				  ..._this.pageOption
				};
				api(emailApi.sendGetfilterPage, data).then((res) => {
					if(res.data.errcode === 0 && res.data.data) {
						if(!res.data.data){
							_this.data=[];
						}else{
							_this.data = res.data.data.list;
						};
						if(_this.data.length > 0) {
							_this.pageOption.pageSize = res.data.data.pageSize;
							_this.pageOption.total = Number(res.data.data.total);
							_this.pageOption.pageNo = res.data.data.pageNum;
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
			receiveDelete(id) { //删除
			  this.$Modal.confirm({
          title: '删除确认',
          content: "您确定删除选中项吗？",
          onOk: () => {
            this.deleteFilterFun(id);
          },
        });
			},
			deleteFilterFun (id) {
			  let data = {
			  	id: id,
			  };
			  let _this = this;
			  api(emailApi.sendDeletefilter, data).then((res) => {
			  	if(res.status == 200 && res.data.errmsg == "ok") {
			  		_this.receivePage(); // 刷新列表
			  		_this.$Message.success({
			  			content: "删除成功",
			  			duration: 1
			  		});
			  	} else {
			  		_this.$Message.error({
			  			content: res.data.errmsg,
			  			duration: 1
			  		});
			  	};
			  }, (err) => {})
			},
			...mapActions([
				'sostomfileFindAll'
			])
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
	.seachForm:after{
		clear: both;
		content: ".";
		display: block;
		height: 0;
		visibility: hidden;
	}
</style>