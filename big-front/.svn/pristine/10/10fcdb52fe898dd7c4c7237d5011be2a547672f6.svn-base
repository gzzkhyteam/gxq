<template>
	<div class="ivu-layout serviceDetail">
		<serverDetail :evalData="evalData"></serverDetail>
	</div>
</template>

<script>
	import serverDetail from './../../common/serverDetail'
	import api from '@/api/axiosApi'
	import softhardApiList from '@/api/softhardApiList'
	export default {
		data() {
			return {
				evalData: {
					"cpuCount": null,
					"dtos": [{
						"createTime": "",
						"diskId": "",
						"diskName": "",
						"diskPath": "",
						"diskSize": "",
						"diskType": "",
						"id": null,
						"serverId": null
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
			serverDetail
		},
		mounted() {
			this.servermanagerDetail();
		},
		methods: {
			servermanagerDetail() {
				let serverId = this.$route.params.serverId;
				api(softhardApiList.servermanagerDetail, {
					serverId: serverId
				}).then((res) => {
					if(res.status == 200 && res.data.data) {
						this.evalData = res.data.data;
						console.log(this.evalData);
					}
				}, (err) => {
					//dong something...
				})
			}
		},
	}
</script>

<style lang='less' scoped>
	.serviceDetail {
		background: #eee;
		padding: 20px;
		width:80%;
		height: auto;
	}
</style>