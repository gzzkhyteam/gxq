<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>查询结果<span v-if="total">(共搜索到{{total}}封)</span></BreadcrumbItem>
					<div class="rt">
						<Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
						<Button type="info" @click="searchfun">搜索</Button>
					</div>
				</Breadcrumb>
				<Card>
					<Form ref="formQueryData" :model="formQueryData" inline :label-width="80">
						<Button type="info" @click="delectEmail('delect')">删除</Button>
						<Button type="info" @click="delectEmail('thorough')">彻底删除</Button>
						<Button type="info" @click="forward">转发</Button>
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
				total:"",//收件箱邮件总数
				mailId: "", //选中项id
				fromVal: [], //选中项
				formQueryData: { //搜索参数
					type: "1",
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
						title: '发件人',
						key: 'from'
					},
					{
						title: '主题',
						key: 'subject',
						render: (h, params) => {
							let mailId = params.row.messageUID;
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
												path: '/emailDetail/'+this.folderType+'/'+mailId
											});
										}
									}
								}, params.row.subject)
							]);
						}
					},
					{
						title: '所在文件夹',
						key: 'folderType',
						render: (h, params) => {
							let _this = this;
							let folderType = params.row.folderType;
							let name = "";
							switch(folderType){
								case 'INBOX':
									name = '收件箱';
									break;
								case 'ABNORMAL':
									name = '异常邮件';
									break;
								case 'VIRUSES':
									name = '病毒邮件';
									break;
								case 'DRAFT':
									name = '草稿箱';
									break;
								case 'SENDED':
									name = '已发送';
									break;
								case 'DELETE':
									name = '回收站';
									break;
								default:
            						for(let i in _this.folderList){
            							if(folderType == _this.folderList[i].fileMark){
            								name = _this.folderList[i].fileName;
            							}
            						}
            						break;
							};
							return h('div', name);
						}
					},
					{
						title: '时间',
						key: 'date'
					}
				],
				data: [], //列表数据
				setRowData:[],
			}
		},
		computed: {
			...mapState(['folderList'])
		},
		mounted() {
			this.formQueryData.search = this.$route.params.keyword;
			this.receivePage(); //获取表格列表
		},
		methods: {
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.mailId = "";
				this.fromVal = [];
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailId = "";
				this.fromVal = [];
			},
			searchfun() {
				if(!this.formQueryData.search){
					this.$Message.error({
						content: "请填写搜索关键字",
						duration: 3
					});
					return false;
				};
				this.receivePage();
			},
			selection(data) { //选中项发生变化时
				let idArray = [],
					fromArray = [],
					objAaary = [];
				if(data.length > 0) {
					for(let i in data) {
						idArray.push(data[i].messageUID);
						let obj = {value:data[i].from};
						fromArray.push(obj);
						let setObj = {mailId:data[i].messageUID,folderType:data[i].folderType};
						objAaary.push(setObj);
					};
					this.mailId = idArray.join(",");
					this.fromVal = fromArray;
					this.setRowData = objAaary;
				}
			},
			receivePage() { //获取表格列表
				let data = {
					"data": {
					    "inFromOrTo": false,
					    "inSubject": false,
					    "keyword": this.formQueryData.search
				    },
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				let _this = this;
				api(emailApi.searchHigh, data).then((res) => {
					if(res.status == 200 && res.data.data) {
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
						}else{
							_this.total = null;
						};
					}else{
						_this.data=[];
						this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
				}, (err) => {})
			},
			delectEmail(type) { //删除事件触发方法
				let _this=this;
				if(!this.mailId) {
				  let deleteText = '请选择需要删除的邮件'
          if (type === 'thorough') {
            deleteText = "请选择需要彻底删除的邮件"
          }
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
	                    	if(type=="delect"){
	                    		let moveFunData = [];
								for(let i in this.setRowData){
									let obj = {
										folderType:this.setRowData[i].folderType,
										mailId:this.setRowData[i].mailId,
										moveType:"DELETE"
									};
									moveFunData.push(obj);
								}
	                    		_this.receiveMove(moveFunData,'delect');
	                    	}else{
	                    		_this.receiveDelete({data:_this.setRowData});
	                    	}
	                    },
	                });
				}
			},
			receiveDelete(data) { //删除选中项
				var _this = this;
				api(emailApi.deleteByForeverList, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.receivePage(); //获取表格列表
						_this.sostomfileFindAll();
						_this.mailId = "";
						_this.fromVal = [];
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
				let moveFunData = [];
				for(let i in this.setRowData){
					let obj = {
						folderType:this.setRowData[i].folderType,
						mailId:this.setRowData[i].mailId,
						moveType:val
					};
					moveFunData.push(obj);
				}
				this.receiveMove(moveFunData,"");
			},
			receiveMove(data,type) { //移动邮件到指定位置
				let _this = this;
				let contentText = "";
				if(type=="delect"){
					contentText="删除成功";
				}else{
					contentText="邮件移动成功";
				};
				api(emailApi.moveMailList, {"data":data}).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.$refs.moveFolderType.clearSingleSelect();
						_this.sostomfileFindAll();
						_this.receivePage(); //获取表格列表
						_this.mailId = "";
						_this.fromVal = [];
						_this.$Message.success({
							content: contentText,
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
					path: '/write/forward/'+this.folderType+this.mailId
				});
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
</style>