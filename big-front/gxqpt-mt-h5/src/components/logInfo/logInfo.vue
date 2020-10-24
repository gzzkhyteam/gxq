<template>
	<div class="log-info-box" @click="_click">
		<div class="top-bar">
			<div :class="{readed:dataLog.status==2,'read-flag':dataLog.status==1 || dataLog.status==2}"> </div>
			<img class="photo" :src="dataLog.photo" />
			<div class="right-box">
				<div class="name">
					{{dataLog.userName}}
				</div>
				<div class="date-tiem">
					{{dataLog.createDate}}
				</div>
			</div>
		</div>
		<div class="category-list">
			<div class="category-item text-left" @click="editLog(log,dataLog.type)" v-if="!!dataLog.workLogDetailDTOS" v-for="(log,index) of dataLog.workLogDetailDTOS" :key="index">
				<span class="text-label">{{index+1}}、&nbsp;{{log.description}}</span>
			</div>
			<div class="category-item text-left" v-if="!dataLog.workLogDetailDTOS">
				<span class="text-label">无日志内容</span>
			</div>
		</div>
	</div>
</template>
<script>
	export default {
		props:{
			dataLog:Object
		},
		data(){
			return{
				logImg:[]
			}
		},
		created(){
			console.log(this.dataLog);
			console.log(typeof(this.dataLog));
		},
		methods:{
			_click: function () {
				this.$emit('click', function () {
				})
			},
			editLog(log,type){
				if(type==0){//我收到的日志不允许查看详情
					return;
				}
				log.type = type;
				if(this.$route.name=='LogDetail'){
					log.urlName = 'editForm';
					this.$store.dispatch('openLoading')
					this.$router.push({
						name:'editForm',
						params:{log:JSON.stringify(log)}
					});
				}
			}
		}
	}
</script>
<style>
	.log-info-box {
		margin: 0 0 5px 0;
		padding: 12px 18px;
		width: 100%;
		background: #fff;
		display: table;
	}
	.read-flag:before{
		position: absolute;
		content: '';
		width: 8px;
		height: 8px;
		top: 5px;
		right: 5px;
		border-radius: 5px;
		background: #ff4848;
	}
	.read-flag.readed:before{
		position: absolute;
		content: '已读';
		font-size: 0.5rem;
		width: auto;
		height: auto;
		color: #999;
		padding: 2px 6px;
		top: 5px;
		right: 5px;
		border-radius: 10px;
		background: #E6E6E6;
	}
	.top-bar{
		position: relative;
	}
	.top-bar .photo,
	.top-bar .right-box {
		height: 45px;
	}
	
	.top-bar .photo {
		float: left;
		width: 45px;
		border-radius: 25px;
		display: block;
		background: #D4E0ED;
	}
	
	.right-box {
		padding: 3px 10px;
		text-align: left;
		width: calc(100% - 45px);
		float: left;
	}
	
	.right-box .name,
	.right-box .data-tiem {
		height: 50%;
	}
	
	.right-box .name {
		font-size: 1.1rem;
	}
	
	.right-box .date-tiem {
		color: #999;
	}
	.category-list{
		float: left;
		margin-top: 12px;
	}
	.category-item{
		text-align: justify;
		line-height: 25px;
		letter-spacing: 1px;
	}
	.category-item .text-label {
		font-size: 1.1rem;
		color: #999;
	}
</style>