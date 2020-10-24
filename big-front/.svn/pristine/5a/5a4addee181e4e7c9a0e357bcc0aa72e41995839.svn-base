<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>邮箱设置</BreadcrumbItem>
				</Breadcrumb>
				<Card>
					<Form ref="formQueryData" :rules="formValidate" :model="formQueryData" inline :label-width="120">
						<Row>
							<Col span="24">
							<h4 class="title-h4">文件夹设置</h4>
							</Col>
							<Col span="24">
							<FormItem label="文件夹：">
								<Select class="queryItem" v-model="formQueryData.folderId">
									<Option v-for="item in folder" :key="item.id" :value="item.id">{{item.fileName}}</Option>
								</Select>
							</FormItem>
							<Button type="default" @click="folderAdd">新增文件夹</Button>
							<Button type="default" @click="folderEdit">修改</Button>
							<Button type="default" @click="folderRemove">删除</Button>
							</Col>
						</Row>
						<Row>
							<Col span="24">
							<h4 class="title-h4">签名栏设置</h4>
							</Col>
							<Col span="24">
							<FormItem label="使用个性签名：">
								<Select class="queryItem" v-model="formQueryData.usersignId">
									<Option value="-1">不使用签名</Option>
									<Option v-for="item in usersign" :key="item.id" :value="item.id">{{item.signTitle}}</Option>
								</Select>
							</FormItem>
							<Button type="default" @click="signatureAdd">添加签名栏</Button>
							<Button type="default" @click="signatureEdit('signatureEdit')">修改</Button>
							<Button type="default" @click="signatureRemove">删除</Button>
							</Col>
						</Row>
						<Row>
							<Col span="24">
							<h4 class="title-h4">邮件自动转发</h4>
							</Col>
							<Col span="24">
							<FormItem label="自动转发到：" v-if="formQueryData.autoForward=='0'" key="autoForwardf">
								<Input class="queryItem" type="text" disabled="disabled"> </Input>
							</FormItem>
							<FormItem label="自动转发到：" prop="forwardAddress" v-if="formQueryData.autoForward=='1'" key="autoForwardt">
								<Input ref="forwardAddressInp" class="queryItem" type="text" v-model="formQueryData.forwardAddress" @on-blur="validAutoForward()"> </Input>
							</FormItem>
							<FormItem>
								<RadioGroup v-model="formQueryData.autoForward">
									<Radio :label="1">启用</Radio>
									<Radio :label="0">关闭</Radio>
								</RadioGroup>
							</FormItem>
							</Col>
						</Row>
						<Row>
							<Col span="24">
							<h4 class="title-h4">日志记录设置</h4>
							</Col>
							<Col span="24">
							<FormItem label="是否记录日志：">
								<RadioGroup v-model="formQueryData.isLogged">
									<Radio :label="1">是</Radio>
									<Radio :label="0">否</Radio>
								</RadioGroup>
							</FormItem>
							</Col>
						</Row>
						<Row>
							<Col span="24">
							<h4 class="title-h4">自动回复</h4>
							</Col>
							<Col span="24">
							<FormItem label="自动回复内容：">
								<UE v-on:getEditor="setparamFindById" v-on:editorUpdate="editorUpdate" v-on:editorInput="editorInput" :defaultMsg="defaultMsg" :config="config" :id="ue1" ref="ue"></UE>
							</FormItem>
							<FormItem>
								<RadioGroup v-model="formQueryData.autoReply" @on-change="autoReplyChange">
									<Radio :label="1">启用</Radio>
									<Radio :label="0">关闭</Radio>
								</RadioGroup>
							</FormItem>
							</Col>
						</Row>
						<Row>
							<Col span="24">
							<h4 class="title-h4">黑名单设置</h4>
							</Col>
							<Col span="24">
							<h5 class="title-h5">设置邮件地址黑名单</h5>
							</Col>
							<Col span="12">
							<Col span="10">
							<Input class="pl" type="text" v-model="blackListVal" @on-blur="validBlack('blackListVal')"> </Input>
							</Col>
							<Button class="ml" type="default" @click="mailSave">添加到黑名单</Button>
							</Col>
						</Row>
						<div class="blackTable">
							<hy-table ref="selection" :data="data" :columns="columns" :total="pageOption.total" :page-size="pageOption.pageSize" :current="pageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" show-total show-sizer show-elevator/>
						</div>
						<Row>
							<Col span="24">
							<h4 class="title-h4">白名单设置</h4>
							</Col>
							<Col span="24">
							<h5 class="title-h5">设置邮件地址白名单</h5>
							</Col>
							<Col span="12">
							<Col span="10">
							<Input class="pl" type="text" v-model="whiteListVal" @on-blur="validBlack('whiteListVal')"> </Input>
							</Col>
							<Button class="ml" type="default" @click="mailWhileSave">添加到白名单</Button>
							</Col>
						</Row>
						<div class="blackTable">
							<hy-table ref="selection" :data="whiteData" :columns="whiteColumns" :total="whitePageOption.total" :page-size="whitePageOption.pageSize" :current="whitePageOption.current" @on-change="pageChange" @on-page-size-change="changePageSize" show-total show-sizer show-elevator/>
						</div>
						<Row>
							<Col class="text-center" span="24">
							<Button type="info" @click="setparamSaveandupdate('formQueryData')">确认</Button>
							<Button type="default">取消</Button>
							</Col>
						</Row>
					</Form>
				</Card>
			</Content>
			<Modal v-model="signature" title="签名编辑" width="60%" :mask-closable="false">
				<signature ref="signatureEdit" :dataView="dataView" v-on:saveSuccess="signatureSave"></signature>
				<div slot="footer">
					<Button type="info" @click="editSignature('signatureEdit')">确定</Button>
					<Button type="text" @click="closeSignature('signatureEdit')">关闭</Button>
				</div>
			</Modal>
			<Modal v-model="folderModel" title="文件夹编辑" width="390" :mask-closable="false">
				<Form ref="folderForm" :model="folderData" :rules="folderValidate" inline :label-width="100">
					<FormItem label="文件夹名称：" prop="fileName">
						<Input class="queryItem" type="text" v-model="folderData.fileName" :maxlength="10"> </Input>
						<p class="fontColor">文件夹名称长度限制10字符内</p>
					</FormItem>
				</Form>
				<div slot="footer">
					<Button type="info" @click="saveFolder('folderForm')">确定</Button>
					<Button type="text" @click="closeFolder">关闭</Button>
				</div>
			</Modal>
			<Modal v-model="folderRemoveModel" title="删除确认" @on-ok="sostomfileDelete" @on-cancel="cancelFolderRemove" width="320" :mask-closable="false">
				<p>{{removeFolderTelet}}</p>
			</Modal>
			<Modal v-model="signatureRemoveModel" title="删除签名" @on-ok="usersignDelete" @on-cancel="cancelSignatureRemove" width="320" :mask-closable="false">
				<p>您确定要删除吗？</p>
			</Modal>
		</Layout>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import UE from '@/components/ue/ue'
	import signature from './signature'
	import { mapState,mapActions} from 'vuex'
	export default {
		data() {
			return {
				signature: false,
				folderModel: false,
				folderRemoveModel: false,
				signatureRemoveModel: false,
				blackListVal:"",//黑名单
				whiteListVal:"",//白名单
				folderEditId: "",
				removeFolderTelet: "您确定要删除吗？",//文件夹删除提示
				dataView: {},
				folder: [], //文件夹列表集合
				usersign: [], //用户签名列表集合
				folderData: { //文件夹参数
					fileName: ""
				},
				formValidate: { //文件夹表单校验
					forwardAddress: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'blur'
					}],
				},
				formQueryData: { //表单参数
					folderId: "",
					usersignId: "-1",
					forwardAddress: "",
					autoForward: 0,
					autoReply: 0,
					replyContent: "",
					isLogged: 0
				},
				pageOption: { //分页参数
					current: 1,
					total: 0,
					pageSize: 6
				},
				whitePageOption: { //白名单分页参数
					current: 1,
					total: 0,
					pageSize: 6
				},
				columns: [{ //列表设置
						title: '序号',
						width: 60,
						align: 'center',
						type: 'index'
					},
					{
						title: '邮件地址',
						key: 'value',
					},
					{
						title: '操作',
						key: 'act',
						width: 100,
						align: 'center',
						render: (h, params) => {
							return h('div', [
								h('Button', {
									props: {
										type: 'primary',
										size: 'small'
									},
									style: {
										display: 'inline-block'
									},
									on: {
										click: () => {
											var warnId = params.row.id;
											this.blackListModelFun(warnId);
										}
									}
								}, '删除')
							]);
						}
					},
				],
				data: [], //列表数据
				whiteColumns: [{ //白名单列表设置
						title: '序号',
						width: 60,
						align: 'center',
						type: 'index'
					},
					{
						title: '邮件地址',
						key: 'value',
					},
					{
						title: '操作',
						key: 'act',
						width: 100,
						align: 'center',
						render: (h, params) => {
							return h('div', [
								h('Button', {
									props: {
										type: 'primary',
										size: 'small'
									},
									style: {
										display: 'inline-block'
									},
									on: {
										click: () => {
											var warnId = params.row.id;
											this.whiteListModelFun(warnId);
										}
									}
								}, '删除')
							]);
						}
					},
				],
				whiteData: [], //列表数据
				defaultMsg: '',
				ue1: "ue1", // 不同编辑器必须不同的id
				config: {
					initialFrameWidth: 910,
					initialFrameHeight: 270
				},
				folderValidate: { //文件夹表单校验
					fileName: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'blur'
					}],
				},
			}
		},
		components: {
			UE,
			signature
		},
		mounted() {
			
		},
		methods: {
		  editorInput(){
		    this.sostomfileFind(""); //查询自定义文件夹
        this.usersignFind(); //查询用户签名
        this.setparamFindById(); //查询用户设置参数
        this.mailFindBWList(); //查询黑名单分页列表
        this.mailFindWhiteBWList(); //查询白名单分页列表
		  },
			signatureAdd() { //打开签名栏
				this.signature = true;
			},
			signatureEdit(name) { //修改签名
				if(!this.formQueryData.usersignId || this.formQueryData.usersignId=="-1") {
					this.$Message.error({
						content: "请选择签名",
						duration: 2
					});
					return false;
				};
				this.signature = true;
				for(let i in this.usersign) {
					if(this.usersign[i].id == this.formQueryData.usersignId) {
						this.$refs[name].getDetail(this.usersign[i]);
					}
				};
			},
			signatureRemove() { //删除签名确认
				if(!this.formQueryData.usersignId || this.formQueryData.usersignId=="-1") {
					this.$Message.error({
						content: "请选择签名",
						duration: 2
					});
					return false;
				};
				this.signatureRemoveModel = true;

			},
			cancelSignatureRemove() { //取消签名删除
				this.signatureRemoveModel = false;
			},
			closeSignature(name) { //关闭签名栏
				this.$refs[name].closeAll();
				this.signature = false;
			},
			editSignature(name) { //签名栏编辑确定按钮点击事件
				this.$refs[name].handleSubmit();
			},
			folderAdd() { //新增文件夹
				this.folderEditId = "";
				this.folderModel = true;
			},
			folderEdit() { //编辑文件夹
				if(!this.formQueryData.folderId) {
					this.$Message.error({
						content: "请选择文件夹",
						duration: 2
					});
					return false;
				};
				this.folderEditId = this.formQueryData.folderId;
				for(let i in this.folder) {
					if(this.folder[i].id == this.formQueryData.folderId) {
						this.folderData.fileName = this.folder[i].fileName;
					}
				};
				this.folderModel = true;
			},
			closeFolder() { //关闭文件夹编辑
				this.folderModel = false;
			},
			folderRemove() { //删除文件夹
				if(!this.formQueryData.folderId) {
					this.$Message.error({
						content: "请选择文件夹",
						duration: 2
					});
					return false;
				};
				this.folderEditId = this.formQueryData.folderId;
				this.receivePage();
			},
			cancelFolderRemove() { //取消文件夹删除
				this.folderModel = false;
			},
			sostomfileFind(id) { //查询自定义文件夹
				let _this = this;
				api(emailApi.sostomfileFind).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.folder = res.data.data;
						_this.formQueryData.folderId = id;
					}
				}, (err) => {})
			},
			saveFolder(name) { //文件夹编辑确定按钮点击事件
				var _this = this;
				_this.$refs[name].validate((valid) => {
					if(valid) {
						if(this.folderEditId) {
							_this.sostomfileUpdate();
						} else {
							_this.sostomfileSave();
						};
					};
				})
			},
			sostomfileSave() { //保存自定义文件夹
				let _this = this;
				api(emailApi.sostomfileSave, {
					fileName: _this.folderData.fileName
				}).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindStore();
						_this.sostomfileFindAll();
						_this.sostomfileFind(res.data.data.id); //查询自定义文件夹
						_this.closeFolder(); //关闭文件夹编辑
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
				}, (err) => {})
			},
			sostomfileUpdate() { //修改自定义文件夹
				let _this = this;
				let data = {
					id: this.formQueryData.folderId,
					fileName: this.folderData.fileName
				};
				api(emailApi.sostomfileUpdate, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						_this.sostomfileFindStore();
						_this.sostomfileFind(data.id); //查询自定义文件夹
						_this.closeFolder(); //关闭文件夹编辑
						_this.formQueryData.folderId = "";
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
				}, (err) => {})
			},
			sostomfileDelete() { //删除自定义文件夹
				let _this = this;
				let data = {
					id: this.formQueryData.folderId,
				};
				api(emailApi.sostomfileDelete, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						_this.sostomfileFindStore();
						_this.sostomfileFind(""); //查询自定义文件夹
						_this.closeFolder(); //关闭文件夹编辑
						_this.formQueryData.folderId = "";
						_this.folderEditId = "";
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
				}, (err) => {})
			},
			receivePage() { //获取文件夹下是否存在文件
				this.removeFolderTelet="您确定要删除吗？";
				let folderCode = "";
				for(let i in this.folder) {
					if(this.folder[i].id == this.formQueryData.folderId) {
						folderCode = this.folder[i].fileMark;
					}
				};
				let data = {
					"data": folderCode,
					"pageNo": 1,
					"pageSize": 20
				};
				let _this = this;
				api(emailApi.receivePage, data).then((res) => {
					if(res.status == 200 && res.data.data) {
						if(res.data.data.records){
							if(res.data.data.records.length > 0) {
								_this.removeFolderTelet="该文件夹下存在邮件，您确定要删除吗？";
							}
						};
						this.folderRemoveModel = true;
					}else{
						this.folderRemoveModel = true;
					}
				}, (err) => {})
			},
			usersignFind() { //查询用户签名
			  
				let _this = this;
				api(emailApi.usersignFind).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.usersign = res.data.data;
					}
				}, (err) => {})
			},
			signatureSave() { //用户签名保存成功
				this.usersignFind();
				this.closeSignature('signatureEdit');
			},
			usersignDelete() { //删除签名
				let _this = this;
				let data = {
					id: this.formQueryData.usersignId,
				};
				api(emailApi.usersignDelete, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.usersignFind();
						_this.formQueryData.usersignId = "";
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					}
				}, (err) => {})
			},
			setparamFindById() { //查询用户设置参数
			  
				let _this = this;
				api(emailApi.setparamFindById).then((res) => {
					if(res.status == 200 && res.data.data) {
						_this.formQueryData.forwardAddress = res.data.data.forwardAddress;
						_this.formQueryData.autoForward = res.data.data.autoForward;
						_this.formQueryData.autoReply = res.data.data.autoReply;
						_this.formQueryData.replyContent = res.data.data.replyContent;
						_this.formQueryData.usersignId = res.data.data.currSign;
						_this.formQueryData.isLogged = res.data.data.isLogged?1:0;
						_this.$refs['ue'].enabledOrDisabled(res.data.data.autoReply);
						_this.$refs['ue'].setContent(res.data.data.replyContent);
					}
				}, (err) => {})
			},
			setparamSaveandupdate(name) { //保存设置参数
				let _this = this;
				let isAutoForward = _this.formQueryData.autoForward;
				if(isAutoForward=="1"){
					_this.$refs[name].validate((valid) => {
						if(valid) {
							_this.saveSettingData();
						}else{
							_this.$refs['forwardAddressInp'].focus();
						}
					})
				}else{
					_this.saveSettingData();
				}
			},
			saveSettingData(){
				let _this = this;
				if (_this.formQueryData.replyContent.length > 800) {
				  _this.$Message.error({
            content: '自动回复内容过长，请精简后再次保存',
            duration: 3
          })
				  return false
				}
				let data = {
					forwardAddress: _this.formQueryData.forwardAddress,
					autoForward: _this.formQueryData.autoForward,
					autoReply: _this.formQueryData.autoReply,
					replyContent: _this.formQueryData.replyContent,
					currSign: _this.formQueryData.usersignId,
					isLogged: _this.formQueryData.isLogged==1?true:false
				};
				api(emailApi.setparamSaveandupdate, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.setparamFindById();
						_this.$Message.success({
							content: "保存成功",
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
			mailFindBWList() {//查询黑名单列表
				let _this = this;
				let data = {
					"data": {
						"bwType": "black",
						"locateType": "email",
					},
					"pageNo": this.pageOption.current,
					"pageSize": this.pageOption.pageSize
				};
				api(emailApi.mailFindBWList,data).then((res) => {
					if(res.status == 200 && res.data.data) {
						_this.data = res.data.data.list;
						if(_this.data.length > 0) {
							_this.pageOption.pageSize = res.data.data.pageSize;
							_this.pageOption.total = Number(res.data.data.total);
							_this.pageOption.current = res.data.data.pageNum;
						};
					}
				}, (err) => {})
			},
			mailFindWhiteBWList() {//查询白名单列表
				let _this = this;
				let data = {
					"data": {
						"bwType": "white",
						"locateType": "email",
					},
					"pageNo": this.whitePageOption.current,
					"pageSize": this.whitePageOption.pageSize
				};
				api(emailApi.mailFindBWList,data).then((res) => {
					if(res.status == 200 && res.data.data) {
						_this.whiteData = res.data.data.list;
						if(_this.data.length > 0) {
							_this.whitePageOption.pageSize = res.data.data.pageSize;
							_this.whitePageOption.total = Number(res.data.data.total);
							_this.whitePageOption.current = res.data.data.pageNum;
						};
					}
				}, (err) => {})
			},
			mailSave(){//新增黑名单
				if(!this.blackListVal){
					this.$Message.error({
						content: "请填写要添加到黑名单的地址",
						duration: 3
					});
					return false;
				};
				let data={
					value:[{value:this.blackListVal}],
				};
				let _this = this;
				api(emailApi.mailSave, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						_this.mailFindBWList();
						_this.$Message.success({
							content: "保存成功",
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
			mailWhileSave(){//新增白名单
				if(!this.whiteListVal){
					this.$Message.error({
						content: "请填写要添加到白名单的地址",
						duration: 3
					});
					return false;
				};
				let data={
					value:[{value:this.whiteListVal}],
				};
				let _this = this;
				api(emailApi.mailWhileSave, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.mailFindWhiteBWList();
						_this.$Message.success({
							content: "保存成功",
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
			blackListModelFun(id){
				this.$Modal.confirm({
                    title: '删除确认',
                    content: "您确定删除选中黑名单吗？",
                    onOk: () => {
                        this.mailDetele(id,"black");
                    },
                });
			},
			whiteListModelFun(id){
				this.$Modal.confirm({
                    title: '删除确认',
                    content: "您确定删除选中白名单吗？",
                    onOk: () => {
                        this.mailDetele(id,"white");
                    },
                });
			},
			mailDetele(id,type){
				let _this = this;
				let url = "";
				if(type=="black"){
					url = emailApi.mailDetele;
				}else{
					url = emailApi.deleteWhiteById;
				};
				api(url, {id:id}).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						if(type=="black"){
							_this.mailFindBWList();
						}else{
							_this.mailFindWhiteBWList();
						};
						_this.blackId="";
						_this.$Message.success({
							content: "删除成功",
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
			validBlack(type){//验证邮件地址格式
				if(!this[type]){
					return false;
				};
				let endStr = "@gygxq.com";
				var d=this[type].length-endStr.length;
      			if(!(d>=0&&this[type].lastIndexOf(endStr)==d)){
      				this[type]="";
      				this.$Message.error({
						content: "邮件地址必须以@gygxq.com结尾",
						duration: 3
					});
      			};
      			if((this[type]).split("@").length>2){
      				this[type]="";
      				this.$Message.error({
						content: "邮件地址错误，请输入正确的地址！",
						duration: 3
					});
      			}
			},
			validAutoForward(){//验证邮件地址格式
				if(!this.formQueryData.forwardAddress){
					return false;
				};
				let endStr = "@gygxq.com";
				var d=this.formQueryData.forwardAddress.length-endStr.length;
      			if(!(d>=0&&this.formQueryData.forwardAddress.lastIndexOf(endStr)==d)){
      				this.formQueryData.forwardAddress="";
      				this.$Message.error({
						content: "邮件地址必须以@gygxq.com结尾",
						duration: 3
					});
      			};
      			if((this.formQueryData.forwardAddress).split("@").length>2){
      				this.formQueryData.forwardAddress="";
      				this.$Message.error({
						content: "邮件地址错误，请输入正确的地址！",
						duration: 3
					});
      			}
			},
			editorUpdate(dataString) {
				this.formQueryData.replyContent = dataString;
			},
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
				this.mailFindBWList();
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
				this.mailFindBWList();
			},
			autoReplyChange(val){//自动回复选择改变时触发方法
				if(val || val==0){
					if(val==1){
						this.$refs['ue'].setEnabled();
					}else if(val==0){
						this.$refs['ue'].execCommand();
						this.$refs['ue'].setDisabled();
					};
				}
			},
			...mapActions([
		      'sostomfileFindAll',
		      'sostomfileFindStore'
		    ])
		},
		watch: {
			'formQueryData.replyContent': function(val, oldval) {
				if(val) {
					this.$refs['ue'].setContent(val);
				} else {
					this.$refs['ue'].setContent("");
				}
			},
			'formQueryData.autoForward': function(val, oldval) {
				if(val=="0") {
					this.formQueryData.forwardAddress="";
				}
			}
		},
		computed: {
			...mapState([
				'userInfo'
			])
		}
	}
</script>

<style type="text/css" scoped="scoped">
	.ml {
		margin-left: 20px;
	}
	
	.pl {
		padding-left: 1.8em;
	}
	
	.wAuto {
		width: 100%;
	}
	
	.queryItem {
		width: 180px;
	}
	
	.title-h4 {
		margin: 0 0 20px;
		padding: 6px 12px;
		background: #F2F2F2;
		color: #333333;
	}
	
	.title-h5 {
		margin: 0 0 10px;
		font-size: 12px;
		text-indent: 2em;
		color: #999999;
	}
	
	.blackTable {
		margin-top: 20px;
		padding-left: 1.8em;
	}
	.fontColor{
	  font-size: 12px;
	  color: #bbb;
	}
</style>