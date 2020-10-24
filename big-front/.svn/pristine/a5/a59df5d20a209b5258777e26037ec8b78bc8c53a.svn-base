<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>回收站<span v-if="total">(共{{total}}封)</span></BreadcrumbItem>
					<div class="rt">
						<Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
						<Button type="info" @click="searchfun">搜索</Button>
					</div>
				</Breadcrumb>
				<Card>
					<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="80">
						<Button type="info" @click="forward">转发</Button>
						<Button type="info" @click="delectEmail()">彻底删除</Button>
						<Button type="info" @click="closeAll">清空回收站</Button>
						<!--<Button type="info" @click="moveFun('INBOX')">移入收件箱</Button>
						<Button type="info" @click="moveFun('SENDED')">移入发件箱</Button>-->
						<FormItem label="移动至：">
              <Select ref="moveFolderType" class="queryItem" v-model="moveTypeName" clearable>
                <Option v-for="item in menusArray" :key="item.fileMark" :value="item.fileMark">{{item.fileName}}</Option>
              </Select>
            </FormItem>
						<FormItem label="" :label-width="10">
              <Button type="info" @click="moveFun(moveTypeName)">确定</Button>
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
			  folderArray: [{
			    fileName: '收件箱',
			    fileMark: 'INBOX'
			  }, {
			    fileName: '已发送',
			    fileMark: 'SENDED'
			  }, {
			    fileName: '草稿箱',
			    fileMark: 'DRAFT'
			  }, {
			    fileName: '垃圾邮件',
			    fileMark: 'SPAM'
			  }, {
			    fileName: '异常邮件',
			    fileMark: 'ABNORMAL'
			  }, {
			    fileName: '病毒邮件',
			    fileMark: 'VIRUSES'
			  }],//文件夹列表
			  moveTypeName: '',//移动至文件夹
				total:"",//收件箱邮件总数
				mailId: "", //选中项id
				fromVal: "", //选中项
				formQueryData: { //搜索参数
					type: "",
					doc: "",
					search: "",
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
							return h('div', "已删除");
						}
					},
					{
						title: '发件人',
						key: 'from',
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
                            folderType: 'DELETE',
                            mailId
                          },
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
		  menusArray: function () {
		    const vm = this
		    let newArray = vm.folderArray.filter(item => vm.menus.some(res => res.name===item.fileName))
		    return [...newArray, ...vm.folderList]
		  },
			...mapState(['folderList', 'menus'])
		},
		mounted() {
			this.receivePage(); //获取表格列表
		},
		methods: {
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.mailId = "";
				this.receivePage();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailId = "";
				this.receivePage();
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
				let idArray = [];
				if(data.length > 0) {
					for(let i in data) {
						idArray.push(data[i].messageUID);
					};
					this.mailId = idArray.join(",");
				}else{
				  this.mailId = '';
				}
			},
			receivePage() { //获取表格列表
				let data = {
					"data": "DELETE",
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
							_this.pageOption.current = res.data.data.currentpage;
							_this.total = Number(res.data.data.totalrecord);
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
					"folderType": "DELETE",
					"mailId": this.mailId,
				};
				let _this = this;
				api(emailApi.receiveDeleteByForever, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.receivePage(); //获取表格列表
						_this.sostomfileFindAll();
						_this.mailId = "";
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
			moveFun(moveTypeVal) { //移动文件夹选择
				if(!this.mailId) {
					this.$Message.error({
						content: "请选择需要移入收件箱的邮件",
						duration: 3
					});
					return false;
				};
				let moveData = {
					folderType: "DELETE",
					mailId: this.mailId,
					moveType: moveTypeVal,
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
					path: '/write/forward/DELETE/'+this.mailId
				});
			},
			closeAll(){//清空
				this.$Modal.confirm({
                    title: '回收站清空确认',
                    content: "您确定要清空回收站内的邮件吗？",
                    onOk: () => {
                        this.clearDelete();
                    },
                });
			},
			clearDelete(){
				let _this = this;
				api(emailApi.clearDelete).then((res) => {
					if(res.status == 200 && res.data.errmsg=="ok") {
						_this.receivePage();
					}else{
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
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