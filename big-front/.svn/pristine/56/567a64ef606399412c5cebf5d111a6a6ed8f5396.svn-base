<template>
	<Layout>
		<Content>
			<Breadcrumb>
				<!-- <BreadcrumbItem>部门用户</BreadcrumbItem> -->
				<BreadcrumbItem>{{title || '服务器查看'}}</BreadcrumbItem>
			</Breadcrumb>
			<Card>
				<Form ref="formValidate" inline :label-width="100" :model="serverData">
					<FormItem label="CPU：">
						<Select class="queryItem" clearable v-model="serverData.cpuCount">
							<Option value="2">2核</Option>
							<Option value="4">4核</Option>
							<Option value="8">8核</Option>
							<Option value="16">16核</Option>
						</Select>
					</FormItem>
					<FormItem label="内存：">
						<Select class="queryItem" clearable v-model="serverData.memorySize">
							<Option value="2">2GB</Option>
							<Option value="4">4GB</Option>
							<Option value="8">8GB</Option>
							<Option value="16">16GB</Option>
							<Option value="32">32GB</Option>
							<Option value="64">64GB</Option>
						</Select>
					</FormItem>
					<FormItem label="操作系统：">
						<Cascader :data="systemArray" @on-change="handleChange" trigger="hover"></Cascader>
					</FormItem>
					<FormItem label="所属网络：">
						<Select class="queryItem" clearable v-model="serverData.netScope">
							<Option v-for="netsItem in netScopeArray" :key="netsItem.id" :value="netsItem.code">{{netsItem.name}}</Option>
						</Select>
					</FormItem>
					<FormItem :label-width="20">
						<Button type="primary" @click="search">查询</Button>
						<!-- <Button type="primary" v-if="checkButton('hardware_bmyh_fwqgl_sqfwq')" @click="applyServer(0)">申请服务器</Button> -->
					</FormItem>
				</Form>
				<hy-table ref="selection" :data="data" :columns="columns" :current="pageOption.current" :total="pageOption.total" :page-size="pageOption.pageSize" @on-change="pageChange" @on-page-size-change="changePageSize" show-sizer show-elevator/>
			</Card>
		</Content>
		<Modal v-model="editState" title="服务器编辑" width="70%" :mask-closable="false">
			<servermgr-edit ref="servermgrEdit" v-on:saveMgr="editSave" :serverData="serverData"></servermgr-edit>
			<div slot="footer">
				<Button type="primary" @click="editSubmit('servermgrEdit')">确定</Button>
				<Button type="text" @click="editClose">关闭</Button>
			</div>
		</Modal>
		<Modal v-model="delectState" title="销毁确认" width="300" :mask-closable="false">
			<div>您确定销毁吗？</div>
			<div slot="footer">
				<Button type="primary" @click="servermanagerDelete">确定</Button>
				<Button type="text" @click="delectClose">关闭</Button>
			</div>
		</Modal>
	</Layout>
</template>

<script>
	import servermgrEdit from './children/editServer'
	import api from '@/api/axiosApi'
	import softhardApiList from '@/api/softhardApiList'
	import { mapState } from 'vuex'
	export default {
		data() {
			return {
				title:this.$store.state.title,
				columns: [{
						type: 'index',
						title: '序号',
						width: 60,
						fixed: 'left',
						align: 'center'
					},
					{
						title: '服务器ID',
						width: 160,
						fixed: 'left',
						key: 'serverId'
					},
					{
						title: '服务器IP',
						width: 160,
						key: 'ip'
					},
					{
						title: '管理单位',
						width: 270,
						key: 'orgname'
					},
					{
						title: '管理员',
						width: 120,
						key: 'manageUname'
					},
					{
						title: 'CPU核数',
						width: 100,
						key: 'cpuCount'
					},
					{
						title: '内存',
						width: 100,
						key: 'memorySize'
					},
					{
						title: '操作系统',
						width: 180,
						key: 'system'
					},
					{
						title: '所属网络',
						width: 150,
						key: 'netScope'
					},
					{
						title: '开通时间',
						align: 'center',
						width: 180,
						key: 'openTime'
					},
					{
						title: '最近变更时间',
						align: 'center',
						width: 180,
						key: 'updateTime'
					},
					{
						title: '变更次数',
						key: 'changeCount',
						width: 100,
						align: 'center',
						render: (h, params) => {
							const vm = this
							const num = params.row.changeCount
							const change = h('Button', {
								props: {
									type: 'primary',
									size: 'small'
								},
								domProps: {
									innerHTML: num
								},
								on: {
									click: () => {
										let originId = params.row.originId;
										this.$router.push({
											path: '/changeList/'+originId
										});
									}
								}
							});
							if(params.row.changeCount>0){
								return h('div', [change]);
							}else{
								return h('div', params.row.changeCount);
							};
						}
					},
					{
						title: '操作',
						key: 'act',
						width: 320,
						fixed: 'right',
						render: (h, params) => {
							const change = h('Button', {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									display:this.checkButton('hardware_bmyh_fwqgl_pzbg')?'inline-block':'none'
								},
								on: {
									click: () => {
										this.gotoCtrl(2,params.row);
									}
								}
							}, '配置变更');
							const detail = h('Button', {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									display:this.checkButton('hardware_bmyh_fwqgl_xq')?'inline-block':'none'
								},
								on: {
									click: () => {
										let serverId = params.row.id;
										this.$router.push({
											path: '/server/detail/'+serverId
										});
									}
								}
							},"详情");
							const edit = h('Button', {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									display:this.checkButton('hardware_gxyy_server_manage_update')?'inline-block':'none'
								},
								on: {
									click: () => {
										let id = params.row.id;
										this.update(id);
									}
								}
							}, '修改');
							const del = h('Button', {
								props: {
									type: 'error',
									size: 'small'
								},
								style: {
									display:this.checkButton('hardware_gxyy_server_manage_delete')?'inline-block':'none'
								},
								on: {
									click: () => {
										var serverId = params.row.id;
										this.delectMgr(serverId);
									}
								}
							}, '销毁');
							const downLoad = h('Button', {
								props: {
									type: 'primary',
									size: 'small'
								},
								style: {
									display:this.checkButton('hardware_gxyy_server_manage_delete')?'inline-block':'none'
								},
								on: {
									click: () => {
										let id = params.row.id;
										let roots = process.env.API_ROOT;
										let urlDownload = roots+"/api/hardware/serverstatistics/downloadScript?str=" + id + "&token=" + this.$store.state.userInfo.token;
										console.log(urlDownload);
										window.open(urlDownload);
									}
								}
							}, '下载');
							if(params.row.useStatus == 0){
								return h('div', [change, detail, edit, del, downLoad]);
							}else{
								return h('div', [change, detail, edit, downLoad]);
							}
						}
					}
				],
				data: [],
				serverData: { //查询参数
					cpuCount: "",
					memorySize: "",
					system: "",
					netScope: "",
				},
				pageOption: { //分页参数
					current: 1,
					total: 0,
					pageSize: 10
				},
				editState: false,//编辑显示状态
				delectState:false,
				systemArray: this.$store.state.systemArray, //操作系统列表
				sysVal: "",
				netScopeArray: this.$store.state.netScopeArray,//所属网络列表
			}
		},
		components: {
			servermgrEdit,
		},
		mounted() {
			this.servermanagerPage(); //查询服务分配管理分页
			console.log(this.$store.state);
		},
		methods: {
			builderTree(r) {
				let _this = this;
				if(!r || r.length == 0) {
					return;
				};
				let itemArray = [];
				r.forEach(function(value, index) {
					let isChildOrg = true;
					if(!value.dtos || value.dtos.length == 0) {
						isChildOrg = false;
						value.children = [];
					};
					if(isChildOrg) {
						value.children = _this.builderTree(value.dtos);
					};
					let itemRow = {
						value: value.code,
						label: value.name,
						children: value.children,
					};
					itemArray.push(itemRow);
					return;
				});
				return itemArray;
			},
			handleChange(value, selecteddata) {
				if(selecteddata.length>0){
					let val = selecteddata.map(o => o.value).reverse();
					this.serverData.system = val[0];
				}else{
					this.serverData.system = "";
				}
			},
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.servermanagerPage();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.servermanagerPage();
			},
			servermanagerDelete() { //删除服务器数据(修改未销毁数据)
				// let delData = [];
				// delData.push(this.actId);
				// api(softhardApiList.servermanagerDelete, {serverIds:delData}).then((res) => {
				api(softhardApiList.delServer, {id:this.actId}).then((res) => {
					console.log(res);
					if(res.status == 200 && res.data.data=="SUCCESS") {
						this.deleteSuccess();
						this.servermanagerPage();
						this.delectState = false;
						this.actId = null;
					}else{
						this.error(res.data.errmsg);
						this.delectState = false;
						this.actId = null;
					}
				}, (err) => {
					//dong something...
				})
			},
			editSave(param) { //保存服务器数据
				if(param.data){
					this.servermanagerPage();
					this.editClose();
					this.success();
				}else{
					this.error(param.errmsg);
				};
			},
			editClose() { //关闭编辑
				this.editState = false;
				this.actId = null;
			},
			delectMgr(id) { //删除
				this.actId = String(id);
				this.delectState = true;
			},
			delectClose() { //关闭删除
				this.delectState = false;
				this.actId = null;
			},
			success() { //成功提示
				this.$Message.success({
					content: '编辑服务器成功！',
					duration: 3
				});
			},
			deleteSuccess() { //删除成功提示
				console.log("成功销毁");
				this.$Message.success({
					content: '销毁服务器成功！',
					duration: 3
				});
			},
			error(errormsg) { //错误提示
				this.$Message.error({
					content: errormsg,
					duration: 3
				});
			},
			editSubmit(name) {//编辑提交方法
				this.$refs[name].handleSubmit();
			},
			servermanagerPage() { // 查询服务分配管理分页
				this.data = [];
				let netisall = false;
				if(this.serverData.netScope=="-1"){
					this.serverData.netScope="";
					netisall = true;
				};
				var formData = {
					"data": { ...this.serverData
					}, //Object.assign({}, this.searchCondition),
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				api(softhardApiList.servermanagerPage, formData).then((res) => {
					if(res.status == 200 && res.data.data) {
						this.data = res.data.data.list;
						if(this.data.length>0){
							this.pageOption.pageSize = res.data.data.pageSize;
							this.pageOption.total = res.data.data.total;
							this.pageOption.current = res.data.data.pageNum;
							this.data.forEach(item=>{
								item.openTime = item.openTime.replace("-","年");
								item.openTime = item.openTime.replace("-","月");
								item.openTime = item.openTime.replace(" ","日 ");
								item.updateTime = item.updateTime.replace("-","年");
								item.updateTime = item.updateTime.replace("-","月");
								item.updateTime = item.updateTime.replace(" ","日 ");
							})
							if(netisall){
								this.serverData.netScope="-1";
							};
						};
					}
				}, (err) => {
					//dong something...
				})
			},
			search() {
				this.pageOption.current=1;
				console.log(this.serverData);
				if(this.serverData.cpuCount=="-1"){
					this.serverData.cpuCount="";
				};
				if(this.serverData.memorySize=="-1"){
					this.serverData.memorySize="";
				};
				this.servermanagerPage();
			},
			// 操作
			gotoCtrl(idx,data) {
				// 配置变更
				if(idx === 2) {
					this.$router.push({
						name: 'modify',
						params: {id: idx,departData:data}
					})
				} else { // 详情
					this.$router.push({
						path: '/department/detail'
					})
				}
			},
			applyServer(){
				this.$router.push({//申请服务器
					path: '/department/create/1'
				})
			},
			checkButton(code){
				if(this.authButton.indexOf(code) >= 0){
					return true;
				}else{
					return false;
				}
			},
			update(id) {//修改
				this.actId = String(id);
				this.editState = true;
				this.$refs['servermgrEdit'].getUpdate(this.actId);
			},
		},
		computed: {
			...mapState([
				'authButton'
			])
		},
		watch:{
			editState(val){
				if(!val){
					this.$refs['servermgrEdit'].reload();
				}
			}
		}
	}
</script>

<style lang='less' scoped>
	.ivu-btn-small {
		margin: 0 3px;
	}
	.handle{
		color:red;
		cursor: pointer;
	}
	.queryItem {
		width: 200px;
	}
	.access-list {
		span.handle {
			margin: 0 5px;
			display: inline-block;
			cursor: pointer;
			&:hover {
				color: #57a3f3;
			}
		}
	}
</style>
