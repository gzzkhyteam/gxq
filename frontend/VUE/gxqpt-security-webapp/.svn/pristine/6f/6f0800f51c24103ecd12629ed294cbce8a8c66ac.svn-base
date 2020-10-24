<template>
	<div>
		<Form ref="formValidate" :label-width="labelWidth" :model="dealForm" :rules="validForm">
			<FormItem label="服务器：">
				<Input type="text" v-model="dealForm.serverIp" disabled>
				</Input>
			</FormItem>
			<FormItem label="服务名称：">
				<Input type="text" v-model="dealForm.name" disabled>
				</Input>
			</FormItem>
			<FormItem label="用户：">
				<Input type="text" v-model="dealForm.account" disabled>
				</Input>
			</FormItem>
			<FormItem label="预警日期：">
				<DatePicker type="date" v-model="dealForm.warnTime" disabled>
				</DatePicker>
			</FormItem>
			<FormItem label="备注：" prop="remarks">
				<Input v-model="dealForm.remarks" type="textarea" :maxlength="200" :autosize="{minRows: 3,maxRows: 5}" :disabled="isCheck">
				</Input>
			</FormItem>
			<Row v-if="isCheck">
				<Col span="12">
				<FormItem label="处理人：">
					<Input type="text" v-model="dealForm.handleUser" :disabled="true">
					</Input>
				</FormItem>
				</Col>
				<Col span="12">
				<FormItem label="处理日期：" class="pull-right">
					<DatePicker type="date" v-model="dealForm.handleTime" :readonly="true" :disabled="true">
					</DatePicker>
				</FormItem>
				</Col>
				</Row>
				<Row v-if="!isCheck">
					<Col span="24" class="text-right" style="margin-top: 12px;" v-if="!isCheck">
					<Button type="text" @click="$emit('close',0)">取消</Button>
					<Button type="primary" @click="validFormData">确定</Button>
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
				labelWidth: 80,
				dealForm: {},
				validForm: {
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
				this.getServerMonitor()
			},
			getServerMonitor() {
				api(apiList.viewServerMonitor, {
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
				api(apiList.editServerMonitor, {
					id: this.dealForm.id,
					remarks: this.dealForm.remarks
				}).then((res) => {
					if(res.status == 200) {
						this.$emit('close', 1);
					} else {
						this.$Message.error('操作失败！');
					}
				}, (err) => {
					//do something...
				})
			},
			validFormData() {
				this.$refs.formValidate.validate((valid) => {
					if(valid) {
						this.save();
					}
				})
			}
		},
		created() {
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
	
	.footer-line {
		position: absolute;
		left: 0;
		bottom: 60px;
		width: 100%;
		border-bottom: 1px solid #ccc;
	}
</style>