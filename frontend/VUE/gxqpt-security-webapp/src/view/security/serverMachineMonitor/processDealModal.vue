<template>
	<div>
		<Form ref="formValidate" :rules="ruleValidate" :label-width="80" :model="dealForm">
			<FormItem label="服务器：">
				<Input type="text" v-model="dealForm.serverIp" disabled>
				</Input>
			</FormItem>
			<FormItem label="进程名称：">
				<Input type="text" v-model="dealForm.processName" disabled>
				</Input>
			</FormItem>
			<FormItem label="用户：">
				<Input type="text" v-model="dealForm.account" disabled>
				</Input>
			</FormItem>
			<FormItem label="预警日期：">
				<DatePicker type="date" v-model="dealForm.warnTime" disabled readonly>
				</DatePicker>
			</FormItem>
			<FormItem label="备注：" prop="remarks">
				<Input v-model="dealForm.remarks" type="textarea" :maxlength="255" :autosize="{minRows: 3,maxRows: 5}" :disabled="isCheck">
				</Input>
				<sub class="fontColor">内容长度限制255字符内</sub>
			</FormItem>
			<Row v-if="isCheck">
				<Col span="12">
				<FormItem label="处理时间：">
					<DatePicker type="date" v-model="dealForm.handleTime" :disabled="true" :readonly="true">
					</DatePicker>
				</FormItem>
				</Col>
				<Col span="12">
				<FormItem label="处理人：" class="pull-right">
					<Input type="text" v-model="dealForm.handleUser" :disabled="true"> </Input>
				</FormItem>
				</Col>
			</Row>
			<Row>
				<Col span="24" class="text-right" style="margin-top: 12px;" v-if="!isCheck">
					<Button type="text" @click="$emit('close',0)">取消</Button>
					<Button type="primary" @click="validForm">确定</Button>
				</Col>
			</Row>
		</Form>
		<div class="footer-line" v-if="!isCheck"> </div>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/securityApiList'
	export default {
		props: ['id', 'isCheck'],
		data() {
			return {
				dealForm: {},
				ruleValidate: {
					remarks: [{
						required: true, 
						message: '备注不可以为空',
						trigger: 'blur'
					}]
				}
			}
		},
		methods: {
			init() {
				this.getProcess();
			},
			getProcess() {
				console.log(this.id);
				api(apiList.viewProcess, {
					id: this.id
				}).then((res) => {
					if(res.status == 200) {
						this.dealForm = res.data.data;
					}
				}, (err) => {
					//do something...
				})
			},
			save() {
				api(apiList.handleProcess,{remarks:this.dealForm.remarks,id:this.dealForm.id}).then((res)=>{
					if(res.status == 200){
						this.$emit('close',1);
					} else {
					  this.$Message.error(res.data.errmsg);
					}
				},(err)=>{
					//do something...
				})
			},
			validForm(){
				this.$refs.formValidate.validate((valid)=>{
					if(valid){
						this.save();
					}
				})
			}
		},
		mounted() {
			this.init();
		}
	}
</script>

<style lang="less" scoped="scoped">
	.form-deal {
		margin-top: 48px;
	}
	
	.pull-right {
		float: right;
		margin-right: 0;
	}
	.footer-line{
		position: absolute;
		left: 0;
		bottom: 60px;
		width: 100%;
		border-bottom: 1px solid #ccc;
	}
	.fontColor{
	  color: #bbb;
	}
</style>