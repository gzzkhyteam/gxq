<template>
	<Form class="writeForm" ref="signatureData" :model="signatureData" :rules="signatureValidate" inline :label-width="60">
		<Row>
			<Col span="24">
			<FormItem label="名称：" prop="signTitle">
				<Input class="queryItem" type="text" v-model="signatureData.signTitle" :maxlength="20"> </Input>
				<p class="fontColor">签名名称长度限制20字符内</p>
			</FormItem>
			</Col>
			<Col span="24">
			<FormItem label="内容：" prop="signContent">
				<UE v-on:editorUpdate="editorUpdate" :defaultMsg="defaultMsg" :config="config" :id="ue1" ref="ue"></UE>
			</FormItem>
			</Col>
		</Row>
	</Form>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import UE from '@/components/ue/ue'
	export default {
		data() {
		  const vm = this
			return {
				submitNum: 0,
				signatureId:"",
				signatureData: { //表单参数
					signTitle: "",
					signContent: "",
					signContentText: "",
				},
				defaultMsg: '',
				ue1: "uesignature", // 不同编辑器必须不同的id
				config: {
					initialFrameWidth: "auto",
					initialFrameHeight: 240,
					scaleEnabled:true//设置不自动调整高度
				},
				signatureValidate: { //文件夹表单校验
					signTitle: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'blur'
					}],
					signContent: [{
						required: true,
						message: '该项为必填项，请填写相应数据！',
						trigger: 'change'
					}, {
						validator: (rule, value, cb) => {
              if (vm.signatureData.signContentText.length > 300) {
                cb(new Error('签名内容长度超出最大值300，请重新输入'))
                return
              }
              cb()
            }
					}],
				},
			}
		},
		components: {
			UE
		},
		methods: {
			editorUpdate(dataString, dataText) {
				this.signatureData.signContent = dataString;
				this.signatureData.signContentText = dataText;
				if(!this.signatureData.signTitle && this.submitNum == 0) {
					this.signatureData.signTitle = "1";
					this.$refs['signatureData'].validate((valid) => {
						this.signatureData.signTitle = "";
					});
				} else {
					this.$refs['signatureData'].validate((valid) => {});
				};
			},
			closeAll(){//清空页面
				this.signatureData = {
					signTitle: "",
					signContent: "",
				};
				this.defaultMsg="";
				this.$refs['ue'].setContent("");
			},
			getDetail(data){//获取详情
				this.signatureData.signTitle=data.signTitle;
				this.signatureData.signContent=data.signContent;
				this.signatureId=data.id;
				this.defaultMsg=data.signContent;
			},
			handleSubmit() {
				this.submitNum = 1;
				this.$refs['signatureData'].validate((valid) => {
					if(valid) {
						if(this.signatureId){
							//修改用户签名
							let data={
								id:this.signatureId,
								signTitle: this.signatureData.signTitle,
								signContent: this.signatureData.signContent,
							};
							api(emailApi.usersignUpdate, data).then((res) => {
								if(res.status == 200 && res.data.errmsg == "ok") {
									this.signatureData = {
										signTitle: "",
										signContent: "",
									};
									this.defaultMsg="";
									this.$emit('saveSuccess');
								}
								else {
									this.$Message.error({
										content: res.data.errmsg,
										duration: 3
									});
								}
							}, (err) => {})
						}else{
							//保存用户签名
							api(emailApi.usersignSave, this.signatureData).then((res) => {
								if(res.status == 200 && res.data.errmsg == "ok") {
									this.signatureData = {
										signTitle: "",
										signContent: "",
									};
									this.defaultMsg="";
									this.$emit('saveSuccess');
								}
								else {
									this.$Message.error({
										content: res.data.errmsg,
										duration: 3
									});
								}
							}, (err) => {})
						}
					};
				})
			}
		},
		watch:{
			defaultMsg(val){
				if(val){
					this.$refs['ue'].setContent(val);
				}else{
					this.$refs['ue'].setContent("");
				}
			}
		}
	}
</script>

<style type="text/css" scoped="scoped">
	.queryItem {
		width: 200px;
	}
	.fontColor{
    font-size: 12px;
    color: #bbb;
  }
</style>