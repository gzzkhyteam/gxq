<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>草稿箱<span v-if="total">(共{{total}}封)</span></BreadcrumbItem>
					<div class="rt">
						<Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
						<Button type="info" @click="searchfun">搜索</Button>
					</div>
				</Breadcrumb>
	        	<Card>
					<Tabs value="name1">
				        <TabPane label="草稿邮件" name="name1">
							<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="90">
								<Button type="info" @click="forward">转发</Button>
								<Button type="info" @click="delectEmail()">删除</Button>
							</Form>
							<hy-table ref="selection" :data="data" :columns="columns" :total="pageOption.total" :page-size="pageOption.pageSize" :current="pageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" @on-selection-change="selection" show-total show-sizer show-elevator/>
				        </TabPane>
				        <TabPane label="定时邮件" name="name2">
				        	<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="90">
								<Button type="info" @click="timingForward">编辑</Button>
								<Button type="info" @click="delectTimingEmail()">彻底删除</Button>
							</Form>
							<hy-table ref="timingSelection" :data="timingData" :columns="timingColumns" :total="timingPageOption.total" :page-size="timingPageOption.pageSize" :current="timingPageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" @on-selection-change="timingSelection" show-total show-sizer show-elevator/>
				        </TabPane>
				    </Tabs>
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
	export default {
		data() {
			return {
				mailId:"",//选中项id
				timingMailId:[],//定时邮件选中项id
				total:"",////草稿箱邮件总数
				formQueryData:{//搜索参数
					type:"",
					doc:"",
					search:"",
				},
				pageOption: { //分页参数
					current: 1,
					total: 0,
					pageSize: 20
				},
				columns: [{ //列表设置
						width: 60,
						type: 'selection',
						align: 'center',
					},
					{
						title: '状态',
						width: 100,
						key: 'read',
						render: (h, params) => {
							return h('div', "草稿");
						}
					},
					{
						title: '收件人',
						key: 'to',
						render: (h, params) => {
              return h('div', [
                h('Tooltip', {
                  props: { placement: 'bottom-start' }
                }, [
                  h('span', {
                    style: {
                      display: 'inline-block',
                      width: params.column._width * 0.9 + 'px',
                      overflow: 'hidden',
                      textOverflow: 'ellipsis',
                      whiteSpace: 'nowrap'
                    }
                  }, params.row.to),
                  h('span', {
                    slot: 'content',
                    style: { whiteSpace: 'normal', wordBreak: 'break-all' }
                  }, params.row.to)
                ])
              ])
            }
					},
					{
						title: '主题',
						key: 'subject',
						render: (h, params) => {
              let mailId = params.row.messageUID;
              console.log(params.row)
              return h('div', [
                h('Tooltip', {
                  props: { placement: 'bottom-start' }
                }, [
                  h('span', {
                    style: {
                      display: 'inline-block',
                      width: params.column._width * 0.9 + 'px',
                      maxHeight: '300px',
                      overflow: 'hidden',
                      textOverflow: 'ellipsis',
                      whiteSpace: 'nowrap',
                      cursor: 'pointer',
                      color: '#0098CF'
                    },
                    on: {
                      click: () => {
                        this.$router.push({
                          path: '/write/reloadSend/DRAFT/' + mailId
                        });
                      }
                    }
                  }, params.row.subject),
                  h('span', {
                    slot: 'content',
                    style: { whiteSpace: 'normal', wordBreak: 'break-all' }
                  }, params.row.subject)
                ])
              ])
            }
					},
					{
						title: '时间',
						width: 200,
						key: 'date'
					}
				],
				data:[],//列表数据
				//定时发送列表数据
				timingPageOption: { //分页参数
					current: 1,
					total: 0,
					pageSize: 20
				},
				timingColumns: [{ //列表设置
						width: 60,
						type: 'selection',
						align: 'center',
					},
					{
						title: '状态',
						width: 100,
						key: 'read',
						render: (h, params) => {
							return h('div', "定时发送");
						}
					},
					{
						title: '收件人',
						key: 'mailTo',
						render: (h, params) => {
              return h('div', [
                h('Tooltip', {
                  props: { placement: 'bottom-start' }
                }, [
                  h('span', {
                    style: {
                      display: 'inline-block',
                      width: params.column._width * 0.9 + 'px',
                      overflow: 'hidden',
                      textOverflow: 'ellipsis',
                      whiteSpace: 'nowrap'
                    }
                  }, params.row.mailTo),
                  h('span', {
                    slot: 'content',
                    style: { whiteSpace: 'normal', wordBreak: 'break-all' }
                  }, params.row.mailTo)
                ])
              ])
            }
					},
					{
						title: '主题',
						key: 'subject',
						render: (h, params) => {
							let mailId = params.row.id;
							return h('div', [
								h('div', {
									style: {
										display: 'inline-block',
										cursor: 'pointer',
										color: '#0098CF'
									},
									on: {
										click: () => {
											this.$router.push({
												path: '/write/reloadSend/TIMING/'+mailId
											});
										}
									}
								}, params.row.subject)
							]);
						}
					},
					{
						title: '定时发送时间',
						width: 200,
						key: 'sendTime'
					}
				],
				timingData:[],//列表数据
			}
		},
		computed: {
			...mapState(['folderList'])
		},
		mounted(){
			this.receivePage();//获取表格列表
			this.timefind();//获取定时邮件表格列表
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
			searchfun(){
				if(!this.formQueryData.search){
					this.$Message.error({
						content: "请填写搜索关键字",
						duration: 3
					});
					return false;
				};
				this.$router.push({
					path: '/search/'+this.formQueryData.search
				});
			},
			selection(data){//选中项发生变化时
				let idArray = [];
				if(data.length>0){
					for(let i in data){
						idArray.push(data[i].messageUID);
					};
					this.mailId=idArray.join(",");
				}else{
				  this.mailId=''
				}
			},
			receivePage() {//获取表格列表
				let data = {
					"data": "DRAFT",
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				let _this = this;
				api(emailApi.receivePage, data).then((res) => {
					if(res.status == 200 && res.data.data) {
						if(!res.data.data.records){
							_this.data=[];
						}else{
							_this.data = res.data.data.records;
						};
						if(_this.data.length > 0) {
							_this.pageOption.pageSize = res.data.data.maxresult;
							_this.pageOption.total = Number(res.data.data.totalrecord);
							_this.total = Number(res.data.data.totalrecord);
							_this.pageOption.current = res.data.data.currentpage;
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
			delectEmail(){//删除事件触发方法
				if(!this.mailId){
					this.$Message.error({
						content: "请选择需要删除的内容",
						duration: 3
					});
					return false;
				}else{
					this.$Modal.confirm({
	                    title: '删除确认',
	                    content: "您确定删除选中邮件吗？",
	                    onOk: () => {
	                        this.receiveDelete();
	                    },
	                });
				}
			},
			
			receiveDelete() {//删除选中项
				let data = {
					"folderType": "DRAFT",
					"mailId": this.mailId,
				};
				let _this = this;
				api(emailApi.receiveDelete, data).then((res) => {
					if(res.status == 200 && res.data.errmsg=="ok") {
						_this.receivePage();//获取表格列表
						_this.sostomfileFindAll();
						_this.mailId="";
						_this.$Message.success({
							content: "删除成功",
							duration: 3
						});
					}else{
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					};
				}, (err) => {})
			},
			forward(){//转发
				if(!this.mailId){
					this.$Message.error({
						content: "请选择需要转发的邮件",
						duration: 3
					});
					return false;
				};
				let idArray=(this.mailId).split(",");
				if(idArray.length>1){
					this.$Message.error({
						content: "只能选择一封邮件进行转发！",
						duration: 3
					});
					return false;
				};
				this.$router.push({
					path: '/write/forward/DRAFT/'+this.mailId
				});
			},
			timefind() {//获取定时邮件表格列表
				let data = {
					"data": "ds",
					"pageNo": this.timingPageOption.current,
					"pageSize": this.timingPageOption.pageSize
				};
				let _this = this;
				api(emailApi.timefind, data).then((res) => {
					if(res.status == 200 && res.data.data) {
						if(!res.data.data.list){
							_this.timingData=[];
						}else{
							_this.timingData = res.data.data.list;
						};
						if(_this.timingData.length > 0) {
							_this.timingPageOption.pageSize = res.data.data.pageSize;
							_this.timingPageOption.total = Number(res.data.data.total);
							_this.timingPageOption.current = res.data.data.pageNum;
						};
					}
				}, (err) => {})
			},
			timingSelection(data){//定时邮件列表选中项发生变化时
				let idArray = [];
				if(data.length>0){
					for(let i in data){
						idArray.push(data[i].id);
					};
					this.timingMailId=idArray;
				}else{
				  this.timingMailId = [];
				}
			},
			timingForward(){//定时邮件编辑转发
				if(this.timingMailId.length === 0){
					this.$Message.error({
						content: "请选择需要编辑的邮件",
						duration: 3
					});
					return false;
				};
				if(this.timingMailId.length>1){
					this.$Message.error({
						content: "只能选择一封邮件进行编辑！",
						duration: 3
					});
					return false;
				};
				this.$router.push({
					path: '/write/reloadSend/TIMING/'+this.timingMailId[0]
				});
			},
			delectTimingEmail(){//删除定时邮件事件触发方法
				if(this.timingMailId.length === 0){
					this.$Message.error({
						content: "请选择需要彻底删除的内容",
						duration: 3
					});
					return false;
				}else{
					this.$Modal.confirm({
	                    title: '删除确认',
	                    content: "您确定彻底删除选中邮件吗？",
	                    onOk: () => {
	                        this.timedelete();
	                    },
	                });
				}
			},
			timedelete() {//删除选中定时邮件
				let data = {
					"data": this.timingMailId,
				};
				let _this = this;
				api(emailApi.timedelete, data).then((res) => {
					if(res.status == 200 && res.data.errmsg=="ok") {
						_this.timefind();//获取表格列表
						_this.timingMailId=[];
						_this.$Message.success({
							content: "删除成功",
							duration: 3
						});
					}else{
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
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
	.seachForm{
		margin-bottom: 34px;
	}
	.seachForm:after{
		clear: both;
		content: ".";
		display: block;
		height: 0;
		visibility: hidden;
	}
	/deep/.ivu-tabs{
	  overflow: visible;
	}
</style>