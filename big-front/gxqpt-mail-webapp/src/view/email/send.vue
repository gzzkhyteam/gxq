<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>已发送<span v-if="total">(共{{total}}封)</span></BreadcrumbItem>
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
							return h('div', "已发送");
						}
					},
					{
						title: '收件人',
						key: 'to',
						render: (h, params) => {
              return h('div', {
                style: {
                  width: params.column._width * 0.9 + 'px',
                }
              }, [
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
                          name: 'emailDetail',
                          params: {
                            folderType: 'SENDED',
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
			...mapState(['folderList'])
		},
		mounted() {
			this.receivePage(); //获取表格列表
		},
		methods: {
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
					"data": "SENDED",
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
			delectEmail(type) { //删除事件触发方法
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
	                        this.receiveDelete(type);
	                    },
	                });
				}
			},
			receiveDelete(type) { //删除选中项
				let data = {
					"folderType": "SENDED",
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
					path: '/write/forward/SENDED/'+this.mailId
				});
			},
			...mapActions([
				'sostomfileFindAll'
			])
		}
	}
</script>

<style type="text/css">
  .ivu-tooltip-inner{
    max-width: 80%;
    min-width: 200px;
  }
</style>

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