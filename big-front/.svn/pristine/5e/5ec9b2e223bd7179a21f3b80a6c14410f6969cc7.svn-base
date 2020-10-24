<template>
	<Card>
		<Form class="writeForm" ref="formQueryData" :model="formQueryData" :rules="formValidate" inline :label-width="110">
			<Row>
				<Col span="16">
				<Row>
					<Col span="24">
					<FormItem label="收件人：" prop="to">
						<div class="ivu-form-item-content">
							<div class="ivu-select ivu-select-multiple">
								<div id="toPerson" @click="divChange('toPerson')" class="divChange ivu-select-selection" :class="{'active': divType === 'toPerson'}">
									<input type="hidden">
									<div style="float:left" v-for="(recipient,index) in toPerson" :key="index">
										<div class="ivu-tag ivu-tag-checked">
											<span class="ivu-tag-text">{{recipient}}</span>
											<i class="ivu-icon ivu-icon-ios-close-empty" @click="deleteRecipient(index)"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="24">
					<FormItem label="抄送：">
						<div class="ivu-form-item-content">
							<div class="ivu-select ivu-select-multiple">
								<div id="ccPerson" @click="divChange('ccPerson')" class="divChange ivu-select-selection" :class="{'active': divType === 'ccPerson'}">
									<input type="hidden">
									<div style="float:left" v-for="(recipient,index) in ccPerson" :key="index">
										<div class="ivu-tag ivu-tag-checked">
											<span class="ivu-tag-text">{{recipient}}</span>
											<i class="ivu-icon ivu-icon-ios-close-empty" @click="deleteccRecipient(index)"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="24">
					<FormItem label="主题：" prop="subject">
						<Input class="wauto" :maxlength="200" type="text" v-model="formQueryData.subject" @on-focus="inpFocus"> </Input>
						<sub>内容限制200字内</sub>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="24">
					<FormItem label="附件：">
						<!--<hyUpload action="/api/file/p/file/simple" :onSuccess="fileUploadSuccess" multiple/>-->
						<hyUpload :default-file-list="defaultFile" :onSuccess="fileUploadSuccess" :onError="fileUploadError" :before-upload="beforeUpload" :on-remove="fileRemove" multiple/>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="24">
					<FormItem label="正文：">
						<UE v-on:getEditor="usersignFind" v-on:editorUpdate="editorUpdate" v-on:editorInput="editorInput" :defaultMsg="defaultMsg" :config="config" :id="ue1" ref="ue"></UE>
					</FormItem>
					</Col>
				</Row>
				<Row>
					<Col span="24">
					<FormItem label="是否需要回执：">
						<RadioGroup v-model="formQueryData.isReplySign">
							<Radio :label="1">是</Radio>
							<Radio :label="0">否</Radio>
						</RadioGroup>
					</FormItem>
					<FormItem label="发件人：">
						<Input v-model="fromPerson" readonly="readonly"></Input>
					</FormItem>
					<FormItem label="签名栏：">
						<Select @on-change="setSignTitle" v-model="formQueryData.currSign">
							<Option value="-1">不使用签名栏</Option>
							<Option v-for="item in usersign" :key="item.id" :value="item.id">{{item.signTitle}}</Option>
						</Select>
					</FormItem>
					</Col>
				</Row>
				</Col>
				<Col span="7" offset="1">
				<template>
					<h4 class="title-right">联系人</h4>
					<div class="treeMain">
						<Spin fix v-if="showSpin">
			                <Icon type="ios-loading" size=18 class="ivu-icon-load-c"></Icon>
			                <div>Loading</div>
			            </Spin>
						<Input icon="ios-search" placeholder="查找联系人" v-model="searchInfo" @on-click="searchPerson" @on-change="searchPersonChange"/>
						<Tree ref="tree"
							:data="treeData"
							@on-check-change="setClassificationInAll"
							show-checkbox
							@on-select-change="selectChange"></Tree>
					</div>
				</template>
				</Col>
				<Col span="24">
				<Row>
					<Col class="text-center" span="24">
					<Button type="info" @click="save" :disabled="uploadIng">发送</Button>
					<Button type="info" @click="saveTime" :disabled="uploadIng">定时发送</Button>
					<Button type="default" @click="saveDrafts" :disabled="uploadIng">存草稿</Button>
					</Col>
				</Row>
				</Col>
			</Row>
		</Form>
		<Modal v-model="saveTimeModel" title="发送时间" class-name="vertical-center-modal" width="390" :mask-closable="false">
			<Form ref="saveTimeForm" :model="formQueryData" :rules="saveTimeValidate" inline :label-width="100">
				<FormItem label="发送时间：" prop="date">
					<DatePicker ref="dataPicker" class="queryItem" @on-change="changeTime" @on-open-change="openChangeTime" format="yyyy-MM-dd HH:mm:ss " type="datetime" placement="bottom-end" placeholder="请选择日期"></DatePicker>
				</FormItem>
			</Form>
			<div slot="footer">
				<Button type="info" @click="saveTimeSubmit('saveTimeForm')">确定</Button>
				<Button type="text" @click="closeSaveTime">关闭</Button>
			</div>
		</Modal>
	</Card>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import UE from '@/components/ue/ue'
	import hyUpload from '@/components/hengyun/hyUpload'
	import { mapState,mapActions } from 'vuex'
	export default {
		props:['writeType'],
		data() {
			return {
				selectedArray: [],
				saveIsTrue: false,
				saveTimeModel: false,
				usersign: [],
				currentNode: {}, // 当前点击文字时操作的节点
				allTreeInfo: [], // 整棵树的信息
				firstGetTree: true, // 是否是第一次获取所有的人员信息
				personMap: new Map(), // 所有的人员信息，key为人员的`${value.title}<${value.nickname}@gygxq.com>`
				searchPersons: new Set(), // 搜索时的所有人员的集合，值为楼上的map的key
				searchTreeData: [], // 搜索时的树结构
				showSpin:false,//是否显示人员加载遮罩
				searchInfo:"",//联系人搜索
				isTiming:false,//是否定时邮件
				timing:"",//初始定时发送邮件时间
				divType: "toPerson", //判断当前选中是收件人还是抄送人
				"toPerson": [], //收件人
				"ccPerson": [], //抄送人
				"toIdArray": [], //收件人id
				"ccIdArray": [], //抄送人id
				"fromPerson": "", //发送人
				formQueryData: { //表单参数
					"bcc": "",
					"cc": "",
					"content": "",
					"exigence": false,
					"from": "",
					"sended": false,
					"subject": "",
					"text": false,
					"time": false,
					"to": "",
					"currSign": "-1",
					"isReplySign": 0,
					"attachment": [],
				},
				defaultFile:[],//默认已上传文件
				cityList: [{
						value: 'New York',
						label: 'New York'
					},
					{
						value: 'London',
						label: 'London'
					},
					{
						value: 'Sydney',
						label: 'Sydney'
					},
					{
						value: 'Ottawa',
						label: 'Ottawa'
					},
					{
						value: 'Paris',
						label: 'Paris'
					},
					{
						value: 'Canberra',
						label: 'Canberra'
					}
				],
				treeData: [],
				defaultMsg: '',
				ue1: "ue1", // 不同编辑器必须不同的id
				config: {
					initialFrameWidth: "auto",
					initialFrameHeight: 350,
					scaleEnabled:true//设置不自动调整高度
				},
				formValidate: { //文件夹表单校验
					subject: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'blur'
					}],
					to: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'change'
					}],
				},
				saveTimeValidate: {
					date: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'change'
					}],
				},
				ueditorHtml:"",
				uploadIng: false // 附件是否正在上传 
			}
		},
		components: {
			UE,
			hyUpload
		},
		methods: {
		  	editorInput(){//初始化
		    	this.usersignFind(); //查询用户签名
	        this.findSystem(); //查询体系
	        this.formQueryData.from = this.userInfo.account + '@gygxq.com';
	        this.fromPerson = this.userInfo.name + " <" + this.userInfo.account + '@gygxq.com>';
	        if(this.writeType.mailId && this.writeType.mailId!="-1"){
	          	if(this.writeType.folderType=="TIMING"||this.writeType.folderType=="ABNORMAL"){//判断是否为定时邮件编辑
	            	this.isTiming=true;
	            	this.timeget();//获取定时邮件详情
	          	} else {
		            if (this.writeType.pageType=="forward") {
		              this.receiveView();
		            } else if (this.writeType.pageType=="reloadSend"){
		              this.reloadSendView();
		            } else {
		              this.replyView();
		            }
	          	}
	        };
		  	},
			goback(){//返回上一页
				this.$router.history.go(-1);
			},
			pageChange(num) { //页码改变的回调
				this.pageOption.current = num;
			},
			changePageSize(num) { //切换每页条数时的回调
				this.pageOption.pageSize = num;
			},
			editorUpdate(dataString) {
				this.formQueryData.content = dataString;
			},
			// 点击节点的文字
			selectChange (select) {
				if (select.length > 0) {
					this.$set(select[0], 'expand', !select[0].expand)
					this.currentNode = select[0]
				} else {
					this.$set(this.currentNode, 'expand', !this.currentNode.expand)
				}
			},
			setClassificationInAll(selectedArray) { //选择收件人或抄送人
				let vm = this
				// 人员列表
				let infoArr = new Set()
				// 选中的人员的id
				let idArray = new Set()
				vm.selectedArray = selectedArray
				if(vm.divType) {
					if (vm.searchTreeData === vm.treeData) {
						infoArr = new Set(vm[vm.divType].filter(item => !vm.searchPersonsDisplay.has(item)))
						if(vm.divType === "toPerson") {
							idArray = new Set(vm.toIdArray.filter(item => !vm.searchPersons.has(item)))
						} else {
							idArray = new Set(vm.ccIdArray.filter(item => !vm.searchPersons.has(item)))
						}
					}
					selectedArray.map(item => {
						// 没有子节点且是人员
						if(!item.children && (item.maindeptid || item.nickname)) {
							infoArr.add(`${item.name} <${item.nickname}@gygxq.com>`) // 添加收件人或抄送人
							idArray.add(`"${item.name}"<${item.nickname}@gygxq.com>`)
							if(vm.divType == "toPerson") {
								vm.formQueryData.to = "1"
								if(vm.saveIsTrue){
									vm.$refs['formQueryData'].validate((valid) => {})
								}else{
									vm.formQueryData.subject = "&nbsp;";
									vm.$refs['formQueryData'].validate((valid) => {})
									vm.formQueryData.subject = ""
								}
							} else {
								vm.formQueryData.cc = "1"
							};
						}
					});
					vm[vm.divType] = [...infoArr]
					if(vm.divType == "toPerson") {
						vm.toIdArray = [...idArray]
					} else {
						vm.ccIdArray = [...idArray]
					}
				}
			},
			deleteRecipient(idx) { //删除收件人
				const vm = this
				if (vm.divType === 'ccPerson') {
					return
				}
        let obj = vm.toPerson[idx].replace(/(^\s*)|(\s*$)/g,"")
        let starNum = obj.indexOf('↵')
        if (starNum >= 0) {
          obj = obj.split(starNum, obj.length).replace(/(^\s*)|(\s*$)/g,"")
        }
				const node = vm.personMap.get(obj)
				vm.$refs.tree.handleCheck({
					checked: false,
					nodeKey: node.nodeKey
				})
				if(vm.toIdArray.length == 0) {
					vm.formQueryData.to = "";
					if(vm.saveIsTrue){
						vm.$refs['formQueryData'].validate((valid) => {});
					}else{
						vm.formQueryData.subject = "&nbsp;";
						vm.$refs['formQueryData'].validate((valid) => {});
						vm.formQueryData.subject = "";
					}
				}
			},
			deleteccRecipient(idx) { //删除抄送人
				const vm = this
				if (vm.divType === 'toPerson') {
					return
				}
				let obj = vm.ccPerson[idx].replace(/(^\s*)|(\s*$)/g,"")
        let starNum = obj.indexOf('↵')
        if (starNum >= 0) {
          obj = obj.split(starNum, obj.length).replace(/(^\s*)|(\s*$)/g,"")
        }
				const node = vm.personMap.get(obj)
				vm.$refs.tree.handleCheck({
					checked: false,
					nodeKey: node.nodeKey
				})
				if(vm.ccIdArray.length == 0) {
					vm.formQueryData.cc = ""
					if (vm.saveIsTrue) {
						vm.$refs['formQueryData'].validate((valid) => {})
					} else {
						vm.formQueryData.subject = "&nbsp;"
						vm.$refs['formQueryData'].validate((valid) => {})
						vm.formQueryData.subject = ""
					}
				}
			},
			divChange (type) {
				if (this.divType === type) return
				this.divType = type
				this.searchInfo = ''
				this.findSystem()
			},
			usersignFind() { //查询用户签名
				let _this = this;
				api(emailApi.usersignFind).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.usersign = res.data.data;
						_this.setparamFindById();
					}
				}, (err) => {})
			},
			setparamFindById() { //查询默认用户签名
				if(this.writeType.folderType!="EMAIL"){
					return false;
				};
				let _this = this;
				api(emailApi.setparamFindById).then((res) => {
					if(res.status == 200 && res.data.data) {
						_this.formQueryData.currSign = res.data.data.currSign;
					}
				}, (err) => {})
			},
			findSystem() { //查询体系
				let vm = this
				if (vm.firstGetTree) {
					vm.showSpin = true
					api(emailApi.findSystem).then(res => {
						if (res.status == 200 && res.data.data) {
							// 将整棵树缓存起来
							vm.allTreeInfo = JSON.parse(JSON.stringify(res.data.data))
							vm.getTree(res.data.data)
						}
						vm.showSpin = false
					}, (err) => {})
				} else {
					vm.getTree(JSON.parse(JSON.stringify(vm.allTreeInfo)))
				}
			},
			// 根据返回的数据构建树
			getTree (data) {
				const vm = this
				const arr = []
				for (let item of data) {
					item.title = item.name
					item.children = []
					if (item.list.length > 0) {
						let treeData = vm.builderTree(item.list)
						if (!treeData) {
							treeData = [{}]
						}
						item.children = treeData
					}
					if (item.children.length === 0) {
						item.disableCheckbox = true
					}
					arr.push(item)
				}
				vm.treeData = arr
				if(vm.personMap.length > 0){
				  vm.firstGetTree = false
				}
			},
			searchPerson(val){//搜索人员
				const vm = this
				vm.showSpin = true
				let data = {
					"data": {
				    	"dpmId": "",
				    	"keyWord": vm.searchInfo
				    },
				    "pageNo": 1,
				    "pageSize": 5000
				};
				api(emailApi.findEmpList, data).then(res => {
					if(res.status == 200 && res.data.data) {
						let peopleData = res.data.data.list
						const searchPersons = new Set()
						const searchPersonsDisplay = new Set()
						let peopleZtreeData = []
						peopleData.forEach(function(item, index){
						  if (item.nickname.indexOf('@') === -1) {
  							item.id = item.id
  							if (item.nickname) {
                  item.title = `${item.name}[${item.nickname}]`
                } else {
                  item.title = item.name
                }
  							item.checked = vm[vm.divType] && vm[vm.divType].includes(`${item.name}<${item.nickname}@gygxq.com>`)
  							searchPersons.add(`"${item.name}"<${item.nickname}@gygxq.com>`)
  							searchPersonsDisplay.add(`${item.name}<${item.nickname}@gygxq.com>`)
  							peopleZtreeData.push(item)
						  }
						})
						vm.searchPersons = searchPersons
						vm.searchPersonsDisplay = searchPersonsDisplay
						vm.searchTreeData = [{
							title: '人员',
							expand: true,
							children: peopleZtreeData
						}]
						vm.treeData = vm.searchTreeData
					}
					vm.showSpin = false
				}, (err) => {})
			},
			// 搜索包含所有人的树结构
			searchPersonChange(){
				if (!this.searchInfo) {
					this.findSystem()
				}
			},
			builderTree(r) {
				let vm = this
				if(!r || r.length == 0) {
					return
				}
				let itemArray = []
				r.map((value, index) => {
					let isChildOrg = true
					if(!value.list || value.list.length == 0) {
						isChildOrg = false
						value.children = null
					};
					if(isChildOrg) {
						value.children = vm.builderTree(value.list)
					}
					if (value.nickname) {
					  let emailUrl = `${value.nickname.split('@')[0]}@gygxq.com`
            value.title = `${value.name}[${emailUrl}]`
          } else {
            value.title = value.name
          }
          let newArray = []
          vm[vm.divType].map(item => {
            let obj = item.replace(/(^\s*)|(\s*$)/g,"")
            let starNum = obj.indexOf('↵')
            if (starNum >= 0) {
              obj = obj.split(starNum, obj.length).replace(/(^\s*)|(\s*$)/g,"")
            }
            newArray.push(obj)
          })
					value.checked = vm[vm.divType] && newArray.includes(`${value.name} <${value.nickname}@gygxq.com>`)
					if (!value.children && !value.maindeptid) { // 不是人员,并且没有人员,没有children
						value.disableCheckbox = true
					} else if (vm.firstGetTree) { // 第一次调用总树
						// 人员信息map表
						vm.personMap.set(`${value.name} <${value.nickname}@gygxq.com>`, value)
					}
					if (value.nickname) {
					  /* if (value.nickname.indexOf('@') === -1) {
					    itemArray.push(value)
					  } */
					  value.nickname = `${value.nickname.split('@')[0]}`
					  itemArray.push(value)
					} else{
					  itemArray.push(value)
					}
				})
				return itemArray
			},
			setSignTitle(val) {
				if(val=="-1"){
					let setSignHtml = this.$refs['ue'].getUEContent();
					if(this.ueditorHtml){
						let ret = setSignHtml.indexOf(this.ueditorHtml);
						if(ret && ret>=0){
							setSignHtml = setSignHtml.replace(this.ueditorHtml,"")
						}
					}
					this.$refs['ue'].setContent(setSignHtml);
					this.ueditorHtml = "";
					return false;
				};
				for(let i in this.usersign) {
					if(this.usersign[i].id == val) {
						let setSignHtml = this.$refs['ue'].getUEContent();
						if(this.ueditorHtml){
							let ret = setSignHtml.indexOf(this.ueditorHtml);
							if(ret && ret>=0){
								setSignHtml = setSignHtml.replace(this.ueditorHtml,this.usersign[i].signContent)
							}else{
								setSignHtml +=`<br/><br/><br/><br/>${this.usersign[i].signContent}`;
							}
						}else{
							setSignHtml +=`<br/><br/><br/><br/>${this.usersign[i].signContent}`;
						};
						this.$refs['ue'].setContent(setSignHtml);
						this.ueditorHtml = this.usersign[i].signContent;
					}
				};
			},
			save() {//发送邮件
				let _this = this;
				_this.saveIsTrue = true;
				this.$refs['formQueryData'].validate((valid) => {
					if(valid) {
						let folderType = this.writeType.folderType;
						let pageType = this.writeType.pageType;
						if(this.writeType.mailId && this.writeType.mailId!="-1"){
							if(folderType!="TIMING" && pageType!="forward" && pageType!="reloadSend"){
								_this.formQueryData.isReplyAll = false;
							};
						};
						_this.formQueryData.sended = true;
						_this.formQueryData.to = this.toIdArray.join(",");
						_this.formQueryData.cc = this.ccIdArray.join(",");
						_this.formQueryData.content = this.$refs['ue'].getUEContent();
						_this.formQueryData.from = `"${this.userInfo.name}"<${this.userInfo.account}@gygxq.com>`;
						api(emailApi.sendEmail, this.formQueryData).then((res) => {
							if(res.status == 200 && res.data.errcode === 0) {
								_this.sostomfileFindAll();
								_this.$router.push({
									path: '/home/'
								});
								_this.$Message.success({
									content: "发送成功",
									duration: 3
								});
								_this.receiveDelete();
							} else {
								_this.$Message.error({
									content: res.data.errmsg,
									duration: 3
								});
								if (!res.data.errmsg.includes('关键字，请修改后发送')) {
								  _this.$router.push({
								  	path: '/exception/'
								  });
								}
							}
						}, (err) => {})
					};
				});
			},
			saveDrafts(){//存草稿
				let _this = this;
				_this.saveIsTrue = true;
				this.$refs['formQueryData'].validate((valid) => {
					if(valid) {
						_this.formQueryData.sended = true;
						_this.formQueryData.to = this.toIdArray.join(",");
						_this.formQueryData.cc = this.ccIdArray.join(",");
						_this.formQueryData.content = this.$refs['ue'].getUEContent();
						_this.formQueryData.from = `"${this.userInfo.name}"<${this.userInfo.account}@gygxq.com>`;
						api(emailApi.sendSaveDraft, this.formQueryData).then((res) => {
							if(res.status == 200 && res.data.errmsg == "ok") {
								_this.sostomfileFindAll();
								_this.$router.push({
									path: '/home'
								});
								_this.$Message.success({
									content: "已存入草稿箱",
									duration: 3
								});
								_this.receiveDelete();
							} else {
								_this.$Message.error({
									content: res.data.errmsg,
									duration: 3
								});
							}
						}, (err) => {})
					}
				})
			},
			saveTime() { //打开定时发送弹框
				let _this = this;
				_this.saveIsTrue = true;
				this.$refs['formQueryData'].validate((valid) => {
					if(valid) {
						this.saveTimeModel = true;
					};
				});
			},
			closeSaveTime() { //关闭定时发送弹框
				this.saveTimeModel = false;
			},
			saveTimeSubmit(name) { //定时发送保存方法
				let _this = this;
				this.$refs[name].validate((valid) => {
					if(valid) {
						let data = {
							"attachement": _this.formQueryData.attachement?_this.formQueryData.attachement:[],
							"cc": this.ccIdArray.join(","),
							"content": this.$refs['ue'].getUEContent(),
							"from": `"${this.userInfo.name}"<${this.userInfo.account}@gygxq.com>`,
							"isReplySign": _this.formQueryData.isReplySign,
							"mailType":"ds",
							"sendTime": _this.formQueryData.date,
							"subject": _this.formQueryData.subject,
							"to": this.toIdArray.join(",")
						};
						let folderType = this.writeType.folderType;
						let pageType = this.writeType.pageType;
						if(this.writeType.mailId && this.writeType.mailId!="-1"){
							if(folderType!="TIMING" && pageType!="forward" && pageType!="reloadSend"){
								data.isReplyAll = false;
							};
						};
						api(emailApi.timeSend, data).then((res) => {
							if(res.status == 200 && res.data.errcode == 0) {
								_this.sostomfileFindAll();
								_this.$router.push({
									path: '/home/'
								});
								_this.$Message.success({
									content: `邮件将于${_this.formQueryData.date}发送`,
									duration: 3
								});
								_this.receiveDelete();
							} else {
								_this.$Message.error({
									content: res.data.errmsg,
									duration: 3
								});
							}
						}, (err) => {})
					};
				});
			},
			receiveDelete() {//草稿邮件编辑发送或保存成功后删除该邮件
				if(this.writeType.folderType=="DRAFT" && this.writeType.mailId){
					let data = {
						"folderType": "DRAFT",
						"mailId": this.writeType.mailId,
					};
					let _this = this;
					api(emailApi.receiveDelete, data).then((res) => {}, (err) => {})
				};
				if(this.writeType.folderType=="TIMING" && this.writeType.mailId){
					let data = {
						"data": [this.writeType.mailId],
					};
					let _this = this;
					api(emailApi.timedelete, data).then((res) => {}, (err) => {})
				}
			},
			inpFocus(){
				this.saveIsTrue = true;
			},
			beforeUpload(file){
				let sizeNumber = 50*1024*1024;
				if(file.size>sizeNumber){
					this.$Message.error({
						content: "上传文件限50MB以内！",
						duration: 3
					});
					return false;
				}
				this.uploadIng = true
			},
			fileUploadSuccess(resp, file, fileList) {
				if(resp.errmsg=="ok"){
					// this.formQueryData.attachment = [];
					let row = file.response.data.list;
					let data = {
						fileName: row[0].submittedFileName,
						url: row[0].url,
					};
					this.formQueryData.attachment.push(data);
				}else{
					fileList.forEach(function(val,index){
						if(val.uid==file.uid){
							fileList.splice(index,1);
						}
					});
					if(resp.errmsg=="请求中必须至少包含一个文件"){
						resp.errmsg="文件大小不能为0kb！";
					}
					this.$Message.error({
						content: resp.errmsg,
						duration: 3
					});
				}
				this.uploadIng = false
			},
			fileUploadError(resp, file, fileList) {
				this.$Message.error({
					content: resp.message,
					duration: 3
				});
				this.uploadIng = false
			},
			// 文件上传删除时的钩子
	    	fileRemove(file, fileList) {
  		  		this.formQueryData.attachment = [];
    			fileList.forEach(item => {
    				let row = item.response.data.list;
	    			let data = {
	    				fileName: row[0].submittedFileName,
	    				url: row[0].url,
	    			};
    				this.formQueryData.attachment.push(data);
    			})
    		},
    		changeTime(val) {//日期发生变化时触发
				this.formQueryData.date = val;
				this.$refs['saveTimeForm'].validate((valid) => {});
			},
			openChangeTime(val) {//弹出日历和关闭日历时触发
				if(!val && this.formQueryData.date){
					if(new Date(this.formQueryData.date).valueOf() < new Date().valueOf() + 10 * 60 * 1000){
	    				this.$Message.error({
							content: "定时发送时间应晚于当前时间10分钟之后，请重新选择时间！",
							duration: 3
						});
	    				this.$refs.dataPicker.handleClear();
	    			}
				}
			},
			receiveView(){//获取详情
				let _this = this;
				api(emailApi.receiveView, {folderType:this.writeType.folderType,mailId:this.writeType.mailId}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						_this.formQueryData.subject=data.subject;
						for(let i in data.file){
							let fileObj ={
								url:data.file[i].url,
								name:data.file[i].fileName,
							}
							_this.defaultFile.push(fileObj);
							_this.formQueryData.attachment.push(data.file[i]);
						};
						let fromPerson = _this.userInfo.name + "&lt;" + _this.userInfo.account + '@gygxq.com&gt;'
						if(data.from){
							data.from = data.from.replace(/</g, "&lt;");
						};
						if(data.to){
							data.to = data.to.replace(/</g, "&lt;");
						};
						if(data.cc){
							data.cc = data.cc.replace(/</g, "&lt;");
						};
						let timeTitle = '发送时间'
            if(this.writeType.folderType === 'DRAFT'){
              timeTitle = '上次编辑时间'
            }
						let html=`
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<h4>------------------ 原始邮件 ------------------</h4>
						<div style="background:#ddd;padding:9px;">
							<p>发件人: ${data.from};</p>
							<p>${timeTitle}: ${data.date}</p>
							<p>收件人: ${data.to};</p>
							<p>抄送人: ${data.cc};</p>
							<p>主题: ${data.subject}</p>
						</div>
						${data.content}
						`;
						_this.defaultMsg=html;
						_this.getTree(_this.treeData)
					}
				}, (err) => {})
			},
			replyView(){//回复获取详情
				let _this = this;
				api(emailApi.receiveView, {folderType:this.writeType.folderType,mailId:this.writeType.mailId}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						/*for(let i in data.file){
							let fileObj ={
								url:data.file[i].url,
								name:data.file[i].fileName,
							}
							_this.defaultFile.push(fileObj);
							_this.formQueryData.attachment.push(data.file[i]);
						};*/
						let fromPerson = _this.userInfo.name + "&lt;" + _this.userInfo.account + '@gygxq.com&gt;'
						_this.formQueryData.subject=`回复:${data.subject}`;
						let personArray = data.from.split("<");
						let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
						let personInfo = `"${personInfoName}"<${personArray[1]}`;
						_this.toIdArray.push(personInfo);
						_this.toPerson.push(data.from);
						_this.formQueryData.to = "1";
						if(data.to){
						  	let arrayCcIdone = [];
						  	let arrayCcPersonone = [];
						  	let arrayCcIdTwo = [];
						  	let arrayCcPersonTwo = [];
							if(this.writeType.pageType=="replyAll"){
							  	let replyAllto = data.to.split(",");
							  	if(replyAllto.length>0){
								    for(let i in replyAllto){
								      	if(replyAllto[i]!=this.fromPerson){
									        let personArray = replyAllto[i].split("<");
											let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
											let personIdInfo = `"${personInfoName}"<${personArray[1]}`;
											let personInfo = `${personInfoName}<${personArray[1]}`;
		  							      	arrayCcIdone.push(personIdInfo);
		                      				arrayCcPersonone.push(personInfo);
								      	}
								    }
							  	}
							  if(data.cc){
  								let mailCcArray = data.cc.split(",");
  								if(mailCcArray.length>0){
  									for(let i in mailCcArray){
  									  if(mailCcArray[i]!=this.fromPerson){
    										let personArray = mailCcArray[i].split("<");
    										let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
    										let personIdInfo = `"${personInfoName}"<${personArray[1]}`;
    										let personInfo = `${personInfoName}<${personArray[1]}`;
    										arrayCcIdTwo.push(personIdInfo);
    										arrayCcPersonTwo.push(personInfo);
  										}
  									};
  									_this.ccIdArray=Array.from(new Set([...arrayCcIdone,...arrayCcIdTwo]));
          					_this.ccPerson=Array.from(new Set([...arrayCcPersonone,...arrayCcPersonTwo]));
  									_this.formQueryData.cc = "1";
  								};
							  }else{
							    _this.ccIdArray=Array.from(new Set([...arrayCcIdone]));
                  _this.ccPerson=Array.from(new Set([...arrayCcPersonone]));
                  if(arrayCcIdone.length>0){
                    _this.formQueryData.cc = "1";
                  }
							  }
							}
							data.cc = data.cc.replace(/</g, "&lt;");
						};
						if(data.from){
							data.from = data.from.replace(/</g, "&lt;");
						};
						if(data.to){
							data.to = data.to.replace(/</g, "&lt;");
						};
						let html=`
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<h4>------------------ 原始邮件 ------------------</h4>
						<div style="background:#ddd;padding:9px;">
							<p>发件人: ${data.from};</p>
							<p>发送时间: ${data.date}</p>
							<p>收件人: ${data.to};</p>
							<p>抄送人: ${data.cc};</p>
							<p>主题: ${data.subject}</p>
						</div>
						${data.content}
						`;
						_this.defaultMsg=html;
						_this.getTree(_this.treeData)
					}
				}, (err) => {})
			},
			reloadSendView(){//重新发送获取详情
				
				let _this = this;
				api(emailApi.receiveView, {folderType:this.writeType.folderType,mailId:this.writeType.mailId}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						for(let i in data.file){
							let fileObj ={
								url:data.file[i].url,
								name:data.file[i].fileName,
							}
							_this.defaultFile.push(fileObj);
							_this.formQueryData.attachment.push(data.file[i]);
						};
						let fromPerson = _this.userInfo.name + "&lt;" + _this.userInfo.account + '@gygxq.com&gt;'
						_this.formQueryData.subject=data.subject;
						let mailToArray = data.to.split(",");
						if(mailToArray.length>0){
							for(let i in mailToArray){
								let personArray = mailToArray[i].split("<");
								let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
								let personInfo = `"${personInfoName}"<${personArray[1]}`;
								_this.toIdArray.push(personInfo);
								_this.toPerson.push(mailToArray[i]);
							};
							_this.formQueryData.to = "1";
						};
						if(data.cc){
							let mailCcArray = data.cc.split(",");
							if(mailCcArray.length>0){
								for(let i in mailCcArray){
									let personArray = mailCcArray[i].split("<");
									let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
									let personInfo = `"${personInfoName}"<${personArray[1]}`;
									_this.ccIdArray.push(personInfo);
									_this.ccPerson.push(mailCcArray[i]);
								};
								_this.formQueryData.cc = "1";
							};
						};
						_this.defaultMsg=data.content;
						_this.getTree(_this.treeData)
					}
				}, (err) => {})
			},
			timeget(){//获取定时邮件详情
				let _this = this;
				api(emailApi.timeget, {id:this.writeType.mailId}).then((res) => {
					if(res.status == 200 && res.data.data) {
						let data = res.data.data;
						_this.formQueryData.id = data.id;
						_this.formQueryData.date = data.sendTime;
						if(!data.attachement){
							data.attachement=[];
						};
						if(data.attachement.length==0){
							_this.formQueryData.attachment = [];
						}else{
							for(let i in data.attachement){
								let fileObj ={
									url:data.attachement[i].url,
									name:data.attachement[i].fileName,
									id:data.attachement[i].id,
								}
								_this.defaultFile.push(fileObj);
								_this.formQueryData.attachment.push(data.attachement[i]);
							};
						};
						let fromPerson = _this.userInfo.name + "&lt;" + _this.userInfo.account + '@gygxq.com&gt;'
						_this.formQueryData.subject=data.subject;
						let mailToArray = data.mailTo.split(",");
						if(mailToArray.length>0){
							for(let i in mailToArray){
								let personArray = mailToArray[i].split("<");
								let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
								let personInfoNameNew = personInfoName.replace(/\"/g, "");
								let personInfo = `"${personInfoName}"<${personArray[1]}`;
								_this.toIdArray.push(personInfo);
								_this.toPerson.push(`${personInfoNameNew} <${personArray[1]}`);
							};
							_this.formQueryData.to = "1";
						};
						_this.formQueryData.subject=data.subject;
						if(data.mailCc){
							let mailCcArray = data.mailCc.split(",");
							if(mailCcArray.length>0){
								for(let i in mailCcArray){
									let personArray = mailCcArray[i].split("<");
									let personInfoName = personArray[0].replace(/(^\s*)|(\s*$)/g, "");
									let personInfo = `"${personInfoName}"<${personArray[1]}`;
									_this.ccIdArray.push(personInfo);
									_this.ccPerson.push(`${personInfoName} <${personArray[1]}`);
								};
								_this.formQueryData.cc = "1";
							};
						};
						_this.defaultMsg=data.content;
						_this.getViewSignText(data.content);
						_this.getTree(_this.treeData)
					}
				}, (err) => {})
			},
			getViewSignText(data){//获取详情中的签名
				for(let i in this.usersign) {
					if(data.indexOf(this.usersign[i].signContent)>=0) {
						this.ueditorHtml = this.usersign[i].signContent;
					}
				};
			},
			...mapActions([
				'sostomfileFindAll'
			])
		},
		watch: {
			defaultMsg: function(val, oldval) {
				if(val) {
					this.$refs['ue'].setContent(val);
				} else {
					this.$refs['ue'].setContent("");
				}
			},
			"writeType.mailId": function(val, oldval) {
				if(val) {
					if(this.writeType.mailId && this.writeType.mailId=="-1"){
						this.formQueryData = { //表单参数
							"bcc": "",
							"cc": "",
							"content": "",
							"exigence": false,
							"from": "",
							"sended": false,
							"subject": "",
							"text": false,
							"time": false,
							"to": "",
							"currSign": "-1",
							"isReplySign": 0,
							"attachment":[],
						};
						this.toIdArray=[];
						this.toPerson=[];
						this.ccIdArray=[];
						this.ccPerson=[];
						this.defaultMsg ="";
						this.setparamFindById();
						this.defaultFile=[];
					}
				}
			},
			"formQueryData.currSign": function(val, oldval) {
				if(val) {
					this.setSignTitle(val);
				}
			},
			'$route' (val, oldVal){
        this.editorInput()
      }
		},
		computed: {
			...mapState([
				'userInfo'
			])
		}
	}
</script>

<style type="text/css">
	.ml {
		margin-left: 20px;
	}
	
	.pl {
		padding-left: 1.8em;
	}
	
	.writeForm .ivu-form-item {
		width: 100%;
	}
	
	.title-right {
		border-left: 2px solid #0091D0;
		padding-left: 6px;
		line-height: 12px;
	}
	
	.treeMain {
		margin: 10px 0;
		padding: 10px;
		border: 1px solid #ddd;
		min-height: 600px;
		height: 650px;
		overflow: auto;
		position: relative;
	}
	.ivu-select-dropdown{
		z-index: 9000;
	}
	.ivu-input-icon{
		cursor: pointer;
	}
	.divChange{
		min-height:30px;
		height:auto;
		float: left;
		width: 100%;
		border: 1px solid #ddd;
	}
	.divChange.active{
		border: 1px solid #57a3f3;
	}
	.ivu-form-item-content{
		height: auto;
	}
	.ivu-icon-load-c{
		color: #fff;
        animation: ani-demo-spin 1s linear infinite;
    }
    @keyframes ani-demo-spin {
        from { transform: rotate(0deg);}
        50%  { transform: rotate(180deg);}
        to   { transform: rotate(360deg);}
    }
    .demo-spin-col{
        height: 100px;
        position: relative;
        border: 1px solid #eee;
    }
    .ivu-spin-fix{
    	background: rgba(0,0,0,.2);
    }
    .ivu-spin{
    	color: #fff;
    }
    #toPerson, #ccPerson{
    	max-height: 92px;
    	overflow: auto;
    }
</style>