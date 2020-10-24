<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>垃圾邮件<span v-if="total">(共{{total}}封)</span></BreadcrumbItem>
					<div class="rt">
						<Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
						<Button type="info" @click="searchfun">搜索</Button>
					</div>
				</Breadcrumb>
				<Card>
					<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="80">
						<Button type="info" @click="delectEmail()">彻底删除</Button>
						<Button type="info" @click="blackTableTip">拒收</Button>
						<Button type="info" @click="moveFun">移入收件箱</Button>
					</Form>
					<hy-table class="mt" ref="selection" :data="data" :columns="columns" :total="pageOption.total" :page-size="pageOption.pageSize" :current="pageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" @on-selection-change="selection" show-total show-sizer show-elevator/>
				</Card>
			</Content>
		</Layout>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import { mapState, mapActions } from 'vuex'
	export default {
		data() {
			return {
				total:"",//收件箱邮件总数
				mailId: "", //选中项id
				fromVal: "", //选中项邮件地址
				formQueryData:{//搜索参数
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
						key: 'read',
						render: (h, params) => {
							let read = params.row.read;
							if(read) {
								return h('div', "已读");
							} else {
								return h('div', "未读");
							}
						}
					},
					{
						title: '发件人',
						key: 'from'
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
                          path: '/emailDetail/SPAM/'+mailId
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
						key: 'date'
					}
				],
				data: [], //列表数据
			}
		},
		mounted() {
			this.receivePage(); //获取表格列表
		},
		methods:{
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.mailId = "";
				this.fromVal = "";
				this.receivePage();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailId = "";
				this.fromVal = "";
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
			selection(data) { //选中项发生变化时
				let idArray = [],
					fromArray = [];
				if(data.length > 0) {
					for(let i in data) {
						idArray.push(data[i].messageUID);
						let obj = {value:data[i].from};
						fromArray.push(obj);
					};
					this.mailId = idArray.join(",");
					this.fromVal = fromArray;
				}else{
				  this.mailId = '';
          this.fromVal = []
				}
			},
			receivePage() { //获取表格列表
				let data = {
					"data": "SPAM",
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				let _this = this;
				api(emailApi.receivePage, data).then((res) => {
					if(res.status == 200 && res.data.errmsg=="ok") {
						if(!res.data.data.records){
							_this.data=[];
						}else{
							_this.data = res.data.data.records;
						};
						if(_this.data.length > 0) {
							_this.pageOption.pageSize = res.data.data.maxresult;
							_this.pageOption.total = Number(res.data.data.totalrecord);
							_this.pageOption.current = res.data.data.currentpage;
							_this.total = Number(res.data.data.totalrecord);
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
			delectEmail() { //删除事件触发方法
				if(!this.mailId) {
					this.$Message.error({
						content: "请选择需要彻底删除的邮件",
						duration: 3
					});
					return false;
				} else {
					this.$Modal.confirm({
	                    title: '删除确认',
	                    content: "您确定彻底删除选中邮件吗？",
	                    onOk: () => {
	                        this.receiveDelete();
	                    },
	                });
				}
			},
			receiveDelete() { //删除选中项
				let data = {
					"folderType": "SPAM",
					"mailId": this.mailId,
				};
				let _this = this;
				api(emailApi.receiveDeleteByForever, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.receivePage(); //获取表格列表
						_this.sostomfileFindAll();
						_this.mailId = "";
						_this.fromVal = "";
						_this.$Message.success({
							content: "删除成功",
							duration: 3
						});
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					};
				}, (err) => {})
			},
			blackTableTip() {//拒收提示
				if(!this.mailId) {
					this.$Message.error({
						content: "请选择需要拒收的邮件地址",
						duration: 3
					});
					return false;
				};
				//let emailVal = this.fromVal[0].value;
				let html="拒收后将不再收到已选中邮件发件人所发送的邮件，确认拒收吗？";
                this.$Modal.confirm({
                    title: '拒收确认',
                    content: html,
                    onOk: () => {
                        this.blackTable();
                    },
                });
            },
			blackTable() { //拒收
				let data = {
					value: this.fromVal
				};
				let _this = this;
				api(emailApi.mailSave, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.mailId = "";
						_this.fromVal = "";
						_this.$Message.success({
							content: "拒收设置成功",
							duration: 3
						});
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
				}, (err) => {})

			},
			moveFun() { //移动文件夹选择
				if(!this.mailId) {
					this.$Message.error({
						content: "请选择需要移入收件箱的邮件",
						duration: 3
					});
					return false;
				};
				let moveData = {
					folderType: "SPAM",
					mailId: this.mailId,
					moveType: "INBOX",
				}
				this.receiveMove(moveData);
			},
			receiveMove(data) { //移动邮件到指定位置
				let _this = this;
				api(emailApi.receiveMove, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						_this.receivePage(); //获取表格列表
						_this.mailId = "";
						_this.fromVal = [];
						_this.$Message.success({
							content: "成功",
							duration: 3
						});
					} else {
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
	.mt{
		margin-top: 10px;
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
</style>