<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>{{folderName}}<span v-if="total">(共{{total}}封)</span></BreadcrumbItem>
					<div class="rt">
						<Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
						<Button type="info" @click="searchfun">搜索</Button>
					</div>
				</Breadcrumb>
				<Card>
					<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="80">
						<Button type="info" @click="forward">转发</Button>
						<Button type="info" @click="delectEmail('delect')">删除</Button>
						<Button type="info" @click="delectEmail('thorough')">彻底删除</Button>
						<Button type="info" @click="blackTableTip">拒收</Button>
						<FormItem label="状态：">
							<Select v-model="formQueryData.isRead" @on-change="isReadFun">
								<Option value="1">全部</Option>
						
						<Option value="2">未读</Option>
								<Option value="3">已读</Option>
							</Select>
						</FormItem>
						<FormItem label="标记为：">
							<Select ref="maikType" v-model="formQueryData.type" clearable @on-change="signFun">
								<Option value="1">未读</Option>
								<Option value="2">已读</Option>
								<Option value="3">病毒邮件</Option>
								<Option value="4">垃圾邮件</Option>
							</Select>
						</FormItem>
						<FormItem label="移动至：">
							<Select ref="moveFolderType" class="queryItem" v-model="formQueryData.doc" clearable @on-change="moveFun">
								<Option v-for="item in folderList" :key="item.fileMark" :value="item.fileMark">{{item.fileName}}</Option>
							</Select>
						</FormItem>
					</Form>
					<hy-table ref="selection" :data="data" :columns="columns" :total="pageOption.total" :page-size="pageOption.pageSize" :current="pageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" @on-selection-change="selection" show-total show-sizer show-elevator/>
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
				folderId:"",
				folderName:"",
				total:"",//收件箱邮件总数
				mailId: "", //选中项id
				fromVal: "", //选中项
				formQueryData: { //搜索参数
					type: "",
					doc: "",
					search: "",
					isRead: "1",
				},
				pageOption: { //分页参数
					current: 1,
					total: 0,
					pageSize: 10
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
						key: 'from',
						render: (h, params) => {
              return h('div', [
                h('Tooltip', {
//                props: { placement: 'bottom-start' }
                }, [
                  h('span', {
                    style: {
                      display: 'inline-block',
                      width: params.column._width * 0.9 + 'px',
                      overflow: 'hidden',
                      textOverflow: 'ellipsis',
                      whiteSpace: 'nowrap'
                    }
                  }, params.row.from),
                  h('span', {
                    slot: 'content',
                    style: { whiteSpace: 'normal', wordBreak: 'break-all' }
                  }, params.row.from)
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
                          name: 'emailDetail',
                          params: {
                            folderType: this.folderId,
                            mailId
                          }
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
						width: 180,
						key: 'date'
					}
				],
				data: [], //列表数据
			}
		},
		computed: {
			...mapState(['folderList'])
		},
		mounted() {
			this.folderId = this.$route.params.folderId;
			this.folderName = this.$route.params.folderName;
			this.receivePage(); //获取表格列表
		},
		methods: {
			routerObj(){
				this.folderId = this.$route.params.folderId;
				this.folderName = this.$route.params.folderName;
				this.receivePage(); //获取表格列表
			},
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.mailId = "";
				this.fromVal = "";
				this.isReadFun(this.formQueryData.type);
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailId = "";
				this.fromVal = "";
				this.isReadFun(this.formQueryData.type);
			},
			searchfun() {
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
					"data": this.folderId,
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				let _this = this;
				api(emailApi.receivePage, data).then((res) => {
					if(res.status == 200 && res.data.data.records) {
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
						_this.data = [];
					}
				}, (err) => {})
			},
			delectEmail(type) { //删除事件触发方法
			  let deleteText = '请选择需要删除的邮件'
        if (type === 'thorough') {
          deleteText = "请选择需要彻底删除的邮件"
        }
				if(!this.mailId) {
					this.$Message.error({
						content: deleteText,
						duration: 3
					});
					return false;
				} else {
				  let deleteTip = "删除后可通过回收站找回，您确定删除选中邮件吗？"
          if (type === 'thorough') {
            deleteTip = "彻底删除后将不能找回，您确定删除选中邮件吗？"
          }
					this.$Modal.confirm({
	                    title: '删除确认',
	                    content: deleteTip,
	                    onOk: () => {
	                        this.receiveDelete(type);
	                    },
	                });
				}
			},
			receiveDelete(type) { //删除选中项
				let data = {
					"folderType": this.folderId,
					"mailId": this.mailId,
				};
				let _this = this;
				let url = "";
				if(type == "thorough") {
					url = emailApi.receiveDeleteByForever;
				} else {
					url = emailApi.receiveDelete;
				};
				api(url, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.isReadFun(_this.formQueryData.isRead); //获取表格列表
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
			isReadFun(val) { //转态选择
				let isReadData = {
					"data": {
						"folderType": "INBOX",
						"isRead": true
					},
					"pageNo": 1,
					"pageSize": 10
				};
				if(this.formQueryData.type==val){
					isReadData.pageNo=this.pageOption.current;
				}else{
					this.formQueryData.type=val;
					this.pageOption.current=1;
				};
				if(val == "1"){
					this.receivePage();
				} else if(val == "2") {
					isReadData.data.isRead=false;
					this.receiveSee(isReadData);
				} else if(val == "3") {
					isReadData.data.isRead=true;
					this.receiveSee(isReadData);
				};
			},
			signFun(val) { //标记类型选择
				if(!val) {
					return false;
				};
				if(!this.mailId) {
					this.$Message.error({
						content: "请选择需要标记的邮件",
						duration: 3
					});
					this.$refs.maikType.clearSingleSelect();
					return false;
				};
				let markMail = {
					mailId: this.mailId,
					isRead: "",
					folderType: this.folderId
				};
				if(val == "1") {
					markMail.isRead = false;
					this.receiveMark(markMail);
				} else if(val == "2") {
					markMail.isRead = true;
					this.receiveMark(markMail);
				} else if(val == "3") {
					let moveData = {
						folderType: this.folderId,
						mailId: this.mailId,
						moveType: "VIRUSES",
					}
					this.receiveMove(moveData);
				} else if(val == "4") {
					let moveData = {
						folderType: "INBOX",
						mailId: this.mailId,
						moveType: "SPAM",
					}
					this.receiveMove(moveData);
				};
			},
			moveFun(val) { //移动文件夹选择
				if(!val) {
					return false;
				};
				if(!this.mailId) {
					this.$Message.error({
						content: "请选择需要移动的邮件",
						duration: 3
					});
					this.$refs.moveFolderType.clearSingleSelect();
					return false;
				};
				let moveData = {
					folderType: this.folderId,
					mailId: this.mailId,
					moveType: val,
				}
				this.receiveMove(moveData);
			},
			receiveMark(data) { //标记邮件为已读或未读
				let _this = this;
				api(emailApi.receiveMark, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.$refs.maikType.clearSingleSelect();
						_this.sostomfileFindAll();
						_this.isReadFun(_this.formQueryData.isRead); //获取表格列表
						_this.mailId = "";
						_this.fromVal = "";
						_this.$Message.success({
							content: "标记成功",
							duration: 3
						});
					} else {
						_this.$refs.maikType.clearSingleSelect();
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					};
				}, (err) => {})
			},
			receiveMove(data) { //移动邮件到指定位置
				let _this = this;
				api(emailApi.receiveMove, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.$refs.moveFolderType.clearSingleSelect();
						_this.$refs.maikType.clearSingleSelect();
						_this.sostomfileFindAll();
						_this.isReadFun(_this.formQueryData.isRead); //获取表格列表
						_this.mailId = "";
						_this.fromVal = "";
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
						_this.sostomfileFindAll();
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
			receiveSee(data) {
				let _this = this;
				api(emailApi.receiveSee, data).then((res) => {
					if(res.status == 200 && res.data.data.records) {
						_this.data = res.data.data.records;
						if(_this.data.length > 0) {
							_this.pageOption.pageSize = res.data.data.maxresult;
							_this.pageOption.total = Number(res.data.data.totalrecord);
							_this.pageOption.current = res.data.data.currentpage;
						};
					}
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
					path: '/write/forward/INBOX/'+this.mailId
				});
			},
			...mapActions([
				'sostomfileFindAll'
			])
		},
		watch: {
			'$route' (val, oldVal){
	            this.routerObj(); //获取表格列表
	        },
		},
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
		margin-bottom: 10px;
	}
	.seachForm:after{
		clear: both;
		content: ".";
		display: block;
		height: 0;
		visibility: hidden;
	}
</style>