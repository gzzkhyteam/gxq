<template>
	<div class="serviceDetail">
		<editServerCard ref="servermgrEdit" v-on:examine="save" :detailDate="evalData"></editServerCard>
	</div>
</template>

<script>
	import editServerCard from './../../common/editServerCard'
	import api from '@/api/axiosApi'
	import softhardApiList from '@/api/softhardApiList'
	export default {
		props:['serverData'],
		data() {
			return {
				mgrId:"",
				evalData: {
					"cpuCount": null,
					"dtos": [{
						"diskId": "",
						"diskName": "",
						"diskPath": "",
						"diskSize": "",
						"diskType": "",
					}],
					"id": null,
					"ip": "",
					"memorySize": null,
					"netScope": "",
					"netWide": "",
					"serverId": "",
					"system": ""
				},
			}
		},
		components: {
			editServerCard
		},
		methods: {
			handleSubmit() {
				this.$refs["servermgrEdit"].handleSubmit("evalData");
			},
			save(param) { //查询服务分配管理新增
				if(!this.mgrId){
					api(softhardApiList.servermanagerSave, param).then((res) => {
						this.$emit('saveMgr', res.data);
					}, (err) => {
						//dong something...
					})
				}else{
					api(softhardApiList.servermanagerUpdate, param).then((res) => {
						this.$emit('saveMgr', res.data);
					}, (err) => {
						//dong something...
					})
				}
				
			},
			reload(){
				this.$refs["servermgrEdit"].reloadPage();
			},
			getUpdate(id){
				let _this = this;
				this.mgrId = id;
				api(softhardApiList.servermanagerDetail, {
					serverId: id
				}).then((res) => {
					if(res.status == 200 && res.data.data) {
						_this.evalData = res.data.data;
						console.log(_this.evalData);
						this.$refs["servermgrEdit"].getDetail();
					}
				}, (err) => {
					//dong something...
				})
			},
		}
	}
</script>

<style lang='less' scoped>
	/*.serviceDetail{
    background:#eee;
    padding: 20px;
    width:80%;
    height:auto;
}*/
</style>