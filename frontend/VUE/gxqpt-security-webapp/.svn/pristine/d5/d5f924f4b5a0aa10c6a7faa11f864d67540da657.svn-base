<!-- 具体需求信息 -->
<template>
    <Card :bordered="false">
        <p slot="title">具体需求信息</p>
        <div style="text-align:center">
        	<table class="tab">
				<tr>
					<th width="130">CPU核数：</th>
					<td>{{applyRes.cpuCount}}</td>
					<th width="150">CPU型号规格：</th>
					<td>{{applyRes.cpuModel}}</td>
				</tr>
				<tr>
					<th>内存大小：</th>
					<td>{{applyRes.memorySize}}</td>
					<th>内存型号规格：</th>
					<td>{{applyRes.memoryModel}}</td>
				</tr>
				<tr>
					<th>磁盘大小：</th>
					<td>{{applyRes.diskSize}}</td>
					<th>磁盘型号规格：</th>
					<td>{{applyRes.diskModel}}</td>
				</tr>
				<tr>
					<th>网卡数量：</th>
					<td>{{applyRes.netcardCount}}</td>
					<th>网卡型号规格：</th>
					<td>{{applyRes.netcardModel}}</td>
				</tr>
				<tr>
					<th>交换机数量：</th>
					<td>{{applyRes.changeMachine}}</td>
					<th>交换机型号规格：</th>
					<td>{{applyRes.changeModel}}</td>
				</tr>
				<tr>
					<th>光模块数量：</th>
					<td>{{applyRes.lightCount}}</td>
					<th>光模块型号规格：</th>
					<td>{{applyRes.lightModel}}</td>
				</tr>
				<tr>
					<th>独显存储机数量：</th>
					<td>{{applyRes.videocardCount}}</td>
					<th>独显型号规格：</th>
					<td>{{applyRes.videocardModel}}</td>
				</tr>
				<tr>
					<th>需求说明：</th>
					<td colspan="3">{{applyRes.remark}}</td>
				</tr>
			</table>
        </div>
    </Card>
</template>

<script>
export default {
	props:["applyResData"],
    data(){
        return{
        	applyRes:{}
        }
    },
    mounted(){
		this.getViewInfo();
	},
	methods:{
		getViewInfo(){
			this.applyRes=this.applyResData;
		},
	},
	watch:{
		applyResData:{
			handler(newValue, oldValue) {
				this.getViewInfo();　　
			},
			deep: true　　
		}
	}
}
</script>
<style lang="less" type="text/css" scoped>
	.tab {
		width: 100%;
		table-layout: fixed;
		border-collapse: collapse;
		border-spacing: 0;
		border-collapse:separate;
  		border-spacing:0 20px;
		th {
			padding: 9px;
			border: 0;
			font-weight: normal;
			text-align: right;
		}
		td {
			padding: 9px;
			border: 1px solid #ddd;
			text-align: left;
			background: #f2f2f2;
		    border-radius: 9px;
		}
	}
</style>

