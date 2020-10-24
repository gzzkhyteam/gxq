<template>
	<mu-container>
		<top-bar style="z-index:10000" title="公告详情"></top-bar>
		<mu-card style="width: 100%;margin: 0 auto;">
			<mu-card-title :title="notice.title" :sub-title="notice.sendTime"></mu-card-title>
			<!-- <div class="read-person text-left">
				<span>{{notice.readedNum}}人已读</span>
				&nbsp; &nbsp;
				<span>{{notice.notReadNum}}人未读</span>
			</div> -->
			<mu-card-text v-html="notice.content"></mu-card-text>
		</mu-card>
		<mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
	</mu-container>
</template>

<script>
	import ApiList from '@/api/apiList'
	import api from '@/api/axiosApi'
	import topBar from '@/components/topBar';
	export default {
		data(){
			return {
				notice:{},
				dialog:false,
				msg:'',
			}
		},
		mounted(){
			this.$store.dispatch('closeLoading', false);
			this.getMsgDetail();
		},
		methods:{
			getMsgDetail(){
				api(ApiList.getNoticeDetail,{msgId:this.$route.params.msgId})
				.then((res)=>{
					console.log(res);
					if(res.data.errcode==0){
						this.notice = res.data.data;
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{})
			},
			// updateMsgsReaded(){
			// 	api(ApiList.updateMsgsReaded,{'ids[]':this.$route.params.recId})
			// 	.then((res)=>{
			// 		console.log(res);
			// 		if(res.data.errcode==0){
			// 		}else{
			// 			this.msg = res.data.errmsg;
			// 			this.dialog = true;
			// 		}
			// 	},(error)=>{})
			// },
		},
		components: {
			topBar
		}
	}
</script>

<style lang="less" scoped="scoped">
.container{
	height: calc(100% - 50px);
	margin: 0;
	box-sizing: content-box;
	.mu-card{
		min-height: 100%;
		.mu-card-title,
		.mu-card-sub-title{
			text-align: left;
		}
		.mu-card-title{
			font-size: 1.5rem;
			font-weight: bold;
		}
		.mu-card-sub-title{
			width: 100%;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}
		.read-person{
			padding-left: 4%;
			color: #aaa;
			font-size: 0.9rem;
		}
		.mu-card-text{
			font-size: 0.95rem;
			text-align: justify;
        }
		.mu-card-text /deep/ img{
			max-width:80%;
		}
	}
}
</style>