<template>
	<mu-container>
		<div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box" style="position:fixed">
			<div class="mu-appbar-left">
				<a @click="goback" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
					<div class="mu-button-wrapper">
						<div class="mu-ripple-wrapper"></div> 
						<i class=" mu-icon  material-icons  " style="user-select: none;">keyboard_arrow_left</i>
						返回
					</div>
				</a>
			</div> 
			<div class="mu-appbar-title appbarRight">
				<div class="mu-appbar-title">系统公告</div> 
			</div>
		</div>
		<mu-load-more id="notice" v-if="msgAllArr.length!=0" style="padding-top:54px;" :class="{refH:msgAllArr.length==0}" @refresh="refresh" :refreshing="refreshing" :loading="loading" @load="load" :loaded-all='msgAllNo'>
			<mu-list textline="two-line" class="notice-list">
				<div class="msgItem" v-for="(item, index) in msgAllArr" :key="index" @click="goTo(item.readIs,item.msgId,item.recId)">
					<span>{{ item.createTime }}</span>
					<div class="txtImgItem">
						<i v-if="!item.isRead"></i>
						<img :src="item.filePath">
						<h3>{{ item.topic }}</h3>
						<p>{{ item.imgText }}</p>
					</div>
					<!-- <mu-list-item button :ripple="false">
						<mu-list-item-content>
							<mu-list-item-title>{{item.topic}}</mu-list-item-title>
							<mu-list-item-sub-title><span>{{item.createTime}}&nbsp;</span></mu-list-item-sub-title>
						</mu-list-item-content>
					</mu-list-item>
					<mu-divider></mu-divider> -->
				</div>
			</mu-list>
		</mu-load-more>
		<nullModal v-if="noContent"></nullModal>
		<p class="noContent" v-if="msgAllNo">没有数据了</p>
		<mu-dialog title="消息" width="360" :open.sync="dialog">
				{{msg}}
				<mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
		</mu-dialog>
	</mu-container>
</template>

<script>
	import ApiList from '@/api/apiList'
	import api from '@/api/axiosApi'
	import nullModal from '@/components/nullModal';
	import defaultNoticeImg from "@/assets/defaultNoticeImg.jpg";
	export default {
		data() {
			return {
				tabActive:0,
				msgAllArr:[],
				msgAllPages:1,
				msgAllTotal:0,
				refreshing:false,
				loading:false,
				scrollTops:true,
				dialog:false,
        msgAllNo:false,
        noContent:false,
				msgAllPages:1,
				top:document.documentElement.scrollTop,
				msg:'',
				apiReq:{
					pageNo: 1,
					pageSize: 6
				},
			}
		},
		updated () {
			if(this.scrollTops){
				this.$nextTick(function(){
					let position = this.$store.state.positionY //返回页面取出来
					window.scroll(0, position)
				}) 
			}
		},
		beforeRouteLeave (to, from, next) {
			let position = document.documentElement.scrollTop;
  			this.$store.commit('save', position) 
			// 设置列表缓存
			next();
		},
		mounted(){
			this.$store.dispatch('closeLoading', false);
			this.init();
		},
		watch: {
			top:function (val, oldVal) {
				console.log(val)
				console.log(oldVal)
			},
		},
		methods:{
			init(){
				this.getAllMsg();
			},
			zd(){//切换标签置顶
				window.scroll(0, 0)
			},
			refresh(){
				this.apiReq.pageNo = 1;
				this.msgAllArr=[];
        this.getAllMsg();
        this.noContent = false;
				this.refreshing = true;
				this.msgAllNo = false;
			},
			load () {
				if(document.documentElement.scrollTop == 0){
					if((document.body.scrollTop + document.documentElement.scrollHeight + 100) >= document.body.scrollHeight){
						console.log("进来");
						this.loadFuc();
					}
				}else{
					this.loadFuc();
				}
			},
			loadFuc () {
					this.scrollTops = false;
					if(this.apiReq.pageNo < this.msgAllPages){
						this.loading = true;
						this.apiReq.pageNo ++;
						this.getAllMsg();
					}else{
						this.msgAllNo = true;
					}
			},
			getIsread(msgId){
				api(ApiList.getIsread,{msgId:msgId}).then((res)=>{
					console.log(res);
					if(res.data.errcode==0){
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{})
				this.$router.push({
					name:'NoticeView',
					params:{msgId:msgId}
				});
			},
			getAllMsg(){
				setTimeout(() => {
					api(ApiList.getAllNotice,this.apiReq).then((res)=>{
						console.log(res);
						if(res.data.errcode==0){
              this.msgAllArr = this.msgAllArr.concat(res.data.data.list);
              if(this.msgAllArr.length === 0) {
                this.noContent = true
              }
							this.msgAllArr.forEach(item => {
								if(!item.filePath){//判断图片不存在时候，加载本地默认图片
									item.filePath = defaultNoticeImg;
								}
							});
							this.msgAllPages = res.data.data.pages;
						}else{
							this.msg = res.data.errmsg;
              this.dialog = true;
						}
					},(error)=>{
            this.noContent = true
          })
					this.loading = false;
					this.refreshing = false;
				}, 500)
			},
			closeDialog(){
				this.dialog = false;
			},
			goTo(readIs,msgId,recId){
				this.$store.dispatch('openLoading')
				this.getIsread(msgId);
			},
			goback () {
				this.$store.dispatch('openLoading')
				Android.closeActivity();//返回安卓上一页
			},
		},
		components: {
			nullModal
		}
	}
</script>

<style lang="less" scoped="scoped">
	.container {
		padding: 0;
		background: #f5f5f5;
        .demo-text{
            padding:0;
			padding-top:104px;
		}
		.noContent{
			padding:7px 0;
			color:#797979;
			margin-top:0;
		}
		.demoList li{
			background: #fff;
			padding:8px 0;
		}
        .mu-item-content{
			position: relative;
			padding-left: 5px;
            .mu-item-action{
                position: absolute;
                right: 0;
				top: -40%;
            }
        }
        .reviewTrue{
            color:#1ad517;
        }
		.refH{
			height:350px;
		}
	}
	.mu-appbar{
		/* position: fixed; */
		top: -2px;
		left: 0;
		z-index: 1000;
		width:100%;
	}
	.mu-primary-color{
		background-color: #38ADFF;
	}
	.mu-appbar-title{
		width: 100%;
		font-size: 1rem;
    	text-align: center;
	}
	.mu-button-wrapper{
		font-size: 1rem;
		color: #fff;
	}
	.mu-icon-button{
		/*padding:0;
		width: 80px;*/
	}
	.appbarRight{
		margin-right: 6rem;
	}
	.msgItem{
		margin-bottom:2rem;
		span{
			padding:5px 10px;
			background: #797979;
			color:#fff;
			border-radius: 2rem;
			font-size:0.5rem;
		}
	}
	.txtImgItem{
		width:90%;
		height:200px;
		margin:1rem 5% 5%;
		background: #fff;
		border-radius:1rem;
		overflow: hidden;
		text-align: left;
		position: relative;
		i{
			padding: 5px;
			border-radius: 50%;
			background:#c99090;
			position: absolute;
			left: 10px;
			top:10px;
		}
		img{
			width:100%;
			height:8rem;
		}
		h3{
			margin:0 1rem;
			font-size:1rem;
			white-space:nowrap; 
			text-overflow:ellipsis; 
			overflow:hidden;
		}
		p{
			margin:5px 1rem 0 1rem;
			color:#797979;
			font-size:0.8rem;
			white-space:nowrap; 
			text-overflow:ellipsis; 
			overflow:hidden;
		}
	}
</style>