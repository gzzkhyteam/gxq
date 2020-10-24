<template>
	<div class="ivu-layout wAuto">
		<div>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件主题-<span v-if="data.subject">{{data.subject}}</span></BreadcrumbItem>
				</Breadcrumb>
				<Card>
					<Form class="writeForm" ref="formQueryData" :model="data" inline :label-width="90">
						<Row>
							<Col span="24">
							<Row>
								<Col span="24">
								<FormItem label="发件人：">
									<div class="viewDiv">{{data.from}}</div>
								</FormItem>
								</Col>
							</Row>
							<Row>
								<Col span="24">
								<FormItem label="时间：">
									<div class="viewDiv">{{data.date}}</div>
								</FormItem>
								</Col>
							</Row>
							<Row>
								<Col span="24">
								<FormItem label="收件人：">
									<div class="viewDiv">{{data.to}}</div>
								</FormItem>
								</Col>
							</Row>
							<Row>
								<Col span="24">
								<FormItem label="抄送人：">
									<div class="viewDiv">{{data.cc}}</div>
								</FormItem>
								</Col>
							</Row>
							<Row>
								<Col span="24">
								<FormItem label="正文：">
									<div class="viewDiv contentContainer"><span v-html="data.content"></span></div>
								</FormItem>
								</Col>
							</Row>
							</Col>
						</Row>
					</Form>
				</Card>
			</Content>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>附件</BreadcrumbItem>
				</Breadcrumb>
				<Card>
					<div class="fileDownload" v-for="(item,index) in data.file"  v-if="data.file.length>0">
						<a class="left marginValue" :href="`/api/file/file/download?url=${item.url}&filename=${item.fileName}`" target="_blank">
							<span class="left">{{index+1}}、{{item.fileName}} </span>
							<Icon class="left" type="android-download" />
						</a>
						<Button v-if="isAudioFun(item.fileName)" size="small" type="primary" @click="openAudio(item.fileName, item.url)">在线播放</Button>
						<Button v-if="isVideoFun(item.fileName)" size="small" type="primary" @click="openVideo(index, item.url)">在线播放</Button>
						<Button size="small" type="primary" @click="saveAttachment(item.fileName, item.url)">储存到云盘</Button>
					</div>
					<span v-if="data.file.length==0">无</span>
				</Card>
			</Content>
			<Content>
				<Card>
					<Form class="bottomBtn" ref="formQueryData" :model="data" inline :label-width="90">
						<Button type="info" @click="goback">返回</Button>
						<Button type="info" @click="reply('reply')" v-if="!isSend">回复</Button>
						<Button type="info" @click="reply('replyAll')" v-if="!isSend">回复全部</Button>
						<Button type="info" @click="forward">转发</Button>
						<Button type="info" @click="openRemove('delect')" v-if="!isDelete">删除</Button>
						<Button type="info" @click="openRemove('thorough')">彻底删除</Button>
						<Button type="info" @click="openblack" v-if="!blackTable">拒收</Button>
						<FormItem label="标记为：" v-if="!isSend">
							<Select ref="maikType" v-model="data.type" clearable @on-change="signFun">
								<Option value="1">未读</Option>
								<Option value="2">已读</Option>
								<Option value="3">病毒文件</Option>
								<Option value="4">垃圾文件</Option>
							</Select>
						</FormItem>
						<FormItem label="移动至：" v-if="!isSend">
							<Select ref="moveFolderType" class="queryItem" v-model="data.doc" clearable @on-change="moveFun">
								<Option v-for="item in folderList" :key="item.fileMark" :value="item.fileMark">{{item.fileName}}</Option>
							</Select>
						</FormItem>
					</Form>
				</Card>
			</Content>
		</div>
		<audioPlayer ref="audioPlayer"/>
		<videoPlayer ref="videoPlayer"/>
		<Modal v-model="removeModel" title="删除邮件" @on-ok="receiveDelete" @on-cancel="cancelRemove" width="320" :mask-closable="false">
			<p v-if="this.removeType === 'delect'">您确定要删除吗？</p>
			<p v-else>彻底删除后将不能找回，您确定要删除吗？</p>
		</Modal>
		<Modal v-model="blackModel" title="拒收发件人邮件" @on-ok="blackTableFun" @on-cancel="cancelblack" width="320" :mask-closable="false">
			<p>您确定拒收<{{data.from}}>的邮件吗？</p>
		</Modal>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import { mapState, mapActions } from 'vuex'
	import videoPlayer from './../common/videoPlayer'
	import audioPlayer from './../common/audioPlayer'
	export default {
	  components: {
	    audioPlayer,
      videoPlayer
    },
		data() {
			return {
				removeModel:false,
				blackModel:false,
				removeType:"",
				data: {//表单参数
					type: "",
					doc: "",
					file:[],
				},
				folderType:"",//文件夹类型
				mailId:"",//邮件id
				gataUrl:"",
				isSend:false,//是否已发送文件详情
				isDelete:false,//是否回收站文件详情
				blackTable:false,//是否显示拒收按钮
			}
		},
		beforeRouteLeave(to, from, next){
	        next(sessionStorage.setItem("isSendReplySign",false))
	    },
		computed: {
			...mapState(['folderList','userInfo'])
		},
		mounted(){
			this.gataUrl=process.env.API_ROOT;
			this.folderType = this.$route.params.folderType;
			this.mailId = this.$route.params.mailId;
			let markMail = {
				mailId: this.mailId,
				isRead: true,
				folderType: this.folderType
			};
			if(this.folderType=="INBOX"){
				this.receiveMark(markMail,"detail"); //标记邮件为已读
			};
			if(this.folderType=="SENDED" || this.folderType=="DELETE"){
				this.isSend=true;
				this.blackTable=true;
			};
			if(this.folderType=="DELETE"){
				this.isDelete= true;
				this.blackTable= true;
			};
			this.receiveView();//获取详情
		},
		methods: {
		  openAudio (fileName, data) {
		    const vm = this
		    vm.$refs.audioPlayer.open(fileName, data);
		  },
		  openVideo (videoOrder, data) {
		    const vm = this
		    vm.$refs.videoPlayer.open(videoOrder, data);
		  },
			quickReply(dataFrom,dataTo){//快速回复
				let _this = this;
				let content = `${this.userInfo.name}已阅读您的邮件。`;
				let data = {
					from : dataFrom,
					to : dataTo,
					subject : "邮件回执",
					content : content,
					sended : false,
					time : false,
					isReplySign : 0
				}
				api(emailApi.sendEmail, data).then((res) => {
					if(res.status == 200 && res.data.data) {
						_this.sostomfileFindAll();
					}
				}, (err) => {})
			},
			receiveView(){//获取详情
				api(emailApi.receiveView, {folderType:this.folderType,mailId:this.mailId}).then((res) => {
					if(res.status == 200 && res.data.data) {
						this.data=res.data.data;
						let sendReplySign = sessionStorage.getItem("isSendReplySign");
						if(sendReplySign && sendReplySign=="true"){
							return false;
						};
						sessionStorage.setItem("isSendReplySign",true);
						let read = this.$route.query.read;
						if(read!=undefined){
							if(!read && res.data.data.isReplySign){
								let dataFromArray = res.data.data.to.split("<");
								let dataFromInfo = `"${dataFromArray[0]}"<${dataFromArray[1]}`;
								let dataToArray = res.data.data.from.split("<");
								let dataToInfo = `"${dataToArray[0]}"<${dataToArray[1]}`;
								this.quickReply(dataFromInfo,dataToInfo);
							}
						}
					}
				}, (err) => {})
			},
			cancelRemove(){
				this.removeModel=false;
			},
			cancelblack(){
				this.blackModel=false;
			},
			openRemove(data){
			  this.removeType = data
				this.removeModel = true;
			},
			openblack(type){
				this.removeType=type;
				this.blackModel=true;
			},
			searchfun(){
				
			},
			goback(){//返回上一页
				this.$router.history.go(-1);
			},
			receiveDelete() { //删除选中项
				let data = {
					"folderType": this.folderType,
					"mailId": this.mailId,
				};
				let _this = this;
				let url = "";
				if(this.removeType == "thorough") {
					url = emailApi.receiveDeleteByForever;
				} else {
					url = emailApi.receiveDelete;
				};
				api(url, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						_this.$Message.success({
							content: "删除成功",
							duration: 3
						});
						this.goback();
					} else {
						_this.$Message.error({
							content: res.data.errmsg,
							duration: 3
						});
					};
				}, (err) => {})
			},
			blackTableFun() { //拒收
				let data = {
					value: [{value:this.data.from}]
				};
				let _this = this;
				api(emailApi.mailSave, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						_this.$Message.success({
							content: "设置成功",
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
			signFun(val) { //标记类型选择
				if(!val) {
					return false;
				};
				let markMail = {
					mailId: this.mailId,
					isRead: "",
					folderType: this.folderType
				};
				if(val == "1") {
					markMail.isRead = false;
					this.receiveMark(markMail,"");
				} else if(val == "2") {
					markMail.isRead = true;
					this.receiveMark(markMail,"");
				} else if(val == "3") {
					let moveData = {
						folderType: "INBOX",
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
				let moveData = {
					folderType: this.folderType,
					mailId: this.mailId,
					moveType: val,
				}
				this.receiveMove(moveData);
			},
			receiveMark(data,type) { //标记邮件为已读或未读
				let _this = this;
				api(emailApi.receiveMark, data).then((res) => {
					if(res.status == 200 && res.data.errmsg == "ok") {
						_this.sostomfileFindAll();
						if(!type){
							_this.$Message.success({
								content: "标记成功",
								duration: 3
							});
						};
					} else {
						if(!type){
							_this.$Message.error({
								content: res.data.errmsg,
								duration: 3
							});
						};
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
			forward(){//转发
				this.$router.push({
					path: '/write/forward/'+this.folderType+'/'+this.mailId
				});
			},
			reply(type){//回复
				this.$router.push({
					name: 'write',
					params: {
						pageType: type,
						folderType: this.folderType,
						mailId: this.mailId
					},
				});
			},
			saveAttachment (filename, url) { // 保存附件
			console.log('保存附件')
			console.log(filename + ':' + url)
			let _this = this;
			let data = {
				url: url,
				filename: filename,
			};
			// for (item in data.file)
				api(apiList.saveAttachment, data).then((res) => {
					if(res.data.errcode === 0 && res.data.errmsg == "ok") {
						_this.$Message.success({
							content: "保存成功！",
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
			isAudioFun (fileName) {
			  if (fileName) {
			    let ary = fileName.split('.')
			    let length = ary.length - 1
			    let audioBooleanVal = false
			    switch (ary[length]){
			    	case 'ogg':
			    	  audioBooleanVal = true
			    		break;
			    	case 'wav':
			    	  audioBooleanVal = true
			    		break;
			    	case 'mp3':
			    	  audioBooleanVal = true
			    		break;
			    	default:
			    		break;
			    }
			    return audioBooleanVal
			  }
			},
			isVideoFun (fileName) {
			  if (fileName) {
			    let ary = fileName.split('.')
			    let length = ary.length - 1
			    let booleanVal = false
			    switch (ary[length].toLowerCase()){
			    	case 'ogg':
			    	  booleanVal = true
			    		break;
			    	case 'webm':
			    	  booleanVal = true
			    		break;
			    	case 'mp4':
			    	  booleanVal = true
			    		break;
			    	/*case 'avi':
			    	  booleanVal = true
			    		break;
			    	case 'mov':
			    	  booleanVal = true
			    		break;*/
			    	default:
			    		break;
			    }
			    return booleanVal
			  }
			},
			...mapActions([
				'sostomfileFindAll'
			])
		}
	}
</script>

<style type="text/css">
	.ivu-form-item-content{
		height: auto;
	}
	.wAuto{
		width: 100%;
	}
	.writeForm .ivu-form-item {
	    width: 100%;
	}
	.viewDiv{
		border:1px solid #ddd; 
		width: 100%; 
		min-height: 34px;
    max-height: 160px;
    overflow-y: auto;
		padding: 0 12px;
		background: #f5f7f9;
	}
	.viewDiv img{
		max-width: 100%;
	}
	.contentContainer{
	  max-height: auto;
	}
	.ml {
		margin-left: 20px;
	}
	
	.pl {
		padding-left: 1.8em;
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
	}
	.bottomBtn .ivu-form-item{
		margin-bottom: 0;
	}
	.fileDownload{
	  display: inline-block;
	  width: 100%;
	  
	}
	.fileDownload i{
	  margin: 4px 10px;
	}
	.marginValue {
		margin: 0;
	}
</style>