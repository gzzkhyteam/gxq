<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>异常邮件<span v-if="total">(共{{total}}封)</span></BreadcrumbItem>
					<div class="rt">
						<Input class="queryItem" type="text" v-model="formQueryData.search"> </Input>
						<Button type="info" @click="searchfun">搜索</Button>
					</div>
				</Breadcrumb>
				<Card>
					<Form class="seachForm" ref="formQueryData" :model="formQueryData" inline :label-width="90">
						<Button type="info" @click="forward">重发</Button>
						<Button type="info" @click="delectEmail()">删除</Button>
					</Form>
					<hy-table class="marginTop" ref="selection" :data="data" :columns="columns" :total="pageOption.total" :page-size="pageOption.pageSize" :current="pageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" @on-selection-change="selection" show-total show-sizer show-elevator/>
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
						key: 'read',
						width: 100,
						render: (h, params) => {
							return h('div', "异常邮件");
						}
					},
					{
						title: '收件人',
						key: 'mailTo',
						width: 400,
						render: (h, params) => {
              return h('div', [
                h('Tooltip', {
                  // props: { placement: 'bottom-start' }
                }, [
                  h('span', {
                    style: {
                      display: 'inline-block',
                      width: params.column._width * 0.9 + 'px',
                      maxHeight: '300px',
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
							// let mailId = params.row.messageUID;
							let mailId = params.row.id;
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
                          path: '/write/reloadSend/ABNORMAL/' + mailId
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
						key: 'sendTime'
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
						idArray.push(data[i].id);
					};
					this.mailId=idArray.join(",");
				}else{
				  this.mailId=''
				}
			},
			receivePage() {//获取表格列表
				let data = {
					"data": "yc",
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				let _this = this;
				api(emailApi.timefind, data).then((res) => {
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
			forward(){//转发
				if(!this.mailId){
					this.$Message.error({
						content: "请选择需要重新发送的邮件",
						duration: 3
					});
					return false;
				};
				let idArray=(this.mailId).split(",");
				if(idArray.length>1){
					this.$Message.error({
						content: "只能选择一封邮件进行重新发送！",
						duration: 3
					});
					return false;
				};
				this.$router.push({
					path: '/write/reloadSend/ABNORMAL/'+this.mailId
				});
			},
			delectEmail() { //删除事件触发方法
        if(!this.mailId) {
          this.$Message.error({
            content: "请选择需要删除的邮件",
            duration: 3
          });
          return false;
        } else {
          this.$Modal.confirm({
                      title: '删除确认',
                      content: "您确定删除选中邮件吗？",
                      onOk: () => {
                          this.receiveDelete();
                      },
                  });
        }
      },
      receiveDelete() { //删除选中项
        let data = {
          "data": this.mailId.split(','),
        };
        let _this = this;
        api(emailApi.timedelete, data).then((res) => {
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