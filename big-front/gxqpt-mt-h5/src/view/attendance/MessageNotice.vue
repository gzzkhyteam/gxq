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
				<div class="mu-appbar-title">系统通知</div> 
			</div>
		</div>
		<mu-tabs @change="zd" :value.sync="tabActive" inverse color="#2196F3" indicator-color="#2196F3" center full-width style="position:fixed;top:50px;">
			<mu-tab>全部</mu-tab>
			<mu-tab>未读</mu-tab>
			<mu-tab>已读</mu-tab>
		</mu-tabs>
		<div class="demo-text" v-if="tabActive === 0">
			<mu-load-more v-if="msgAllArr.length!=0" :class="{refH:msgAllArr.length==0}" @refresh="refresh('all')" :refreshing="refreshing" :loading="loading" @load="loadFuc('all')" :loaded-all='msgAllNo'>
				<mu-list textline="two-line" class="notice-list">
					<div v-for="(item, index) in msgAllArr" :key="index" @click="goTo(item.readIs,item.msgId,item.recId)">
						<mu-list-item button :ripple="false">
							<mu-list-item-content>
								<div class="point" v-if="!item.readIs"></div>
								<mu-list-item-title :class="{gray:item.readIs}">{{item.title}}</mu-list-item-title>
								<mu-list-item-sub-title><span>{{item.updateTime}}&nbsp;</span>{{item.appName}}</mu-list-item-sub-title>
							</mu-list-item-content>
						</mu-list-item>
						<mu-divider></mu-divider>
					</div>
				</mu-list>
			</mu-load-more>
			<nullModal v-if="msgNoContent"></nullModal>
			<p class="noContent" v-if="msgAllNo">没有数据了</p>
		</div>
		<div class="demo-text" v-if="tabActive === 1">
			<mu-load-more v-if="noReadArr.length!=0" :class="{refH:noReadArr.length==0}" @refresh="refresh('noread')" :refreshing="refreshing" :loading="loading" @load="loadFuc('noread')" :loaded-all='noReadNo'>
				<mu-list textline="two-line" class="notice-list">
					<div v-for="(item, index) in noReadArr" :key="index" @click="goTo(item.readIs,item.msgId,item.recId)">
						<mu-list-item button :ripple="false">
							<mu-list-item-content>
								<mu-list-item-title>{{item.title}}</mu-list-item-title>
								<mu-list-item-sub-title><span>{{item.updateTime}}&nbsp;</span>{{item.appName}}</mu-list-item-sub-title>
							</mu-list-item-content>
						</mu-list-item>
						<mu-divider></mu-divider>
					</div>
				</mu-list>
			</mu-load-more>
			<nullModal v-if="noReadNoContent"></nullModal>
			<p class="noContent" v-if="noReadNo">没有数据了</p>
		</div>
		<div class="demo-text" v-if="tabActive === 2">
			<mu-load-more v-if="readArr.length!=0" :class="{refH:readArr.length==0}" @refresh="refresh('read')" :refreshing="refreshing" :loading="loading" @load="loadFuc('read')" :loaded-all='readNo'>
				<mu-list textline="two-line" class="notice-list">
					<div v-for="(item, index) in readArr" :key="index" @click="goTo(item.readIs,item.msgId,item.recId)">
						<mu-list-item button :ripple="false">
							<mu-list-item-content>
								<mu-list-item-title>{{item.title}}</mu-list-item-title>
								<mu-list-item-sub-title><span>{{item.updateTime}}&nbsp;</span>{{item.appName}}</mu-list-item-sub-title>
							</mu-list-item-content>
						</mu-list-item>
						<mu-divider></mu-divider>
					</div>
				</mu-list>
			</mu-load-more>
			<nullModal v-if="readNoContent"></nullModal>
			<p class="noContent" v-if="readNo">没有数据了</p>
		</div>
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
	import { mapMutations } from 'vuex'
	export default {
		data() {
			return {
				tabActive:0,
				msgAllArr:[],
				noReadArr:[],
        readArr:[],
        msgNoContent:false,
        noReadNoContent:false,
        readNoContent:false,
				msgAllPages:1,//总页数
				noReadPages:1,
				readPages:1,
				msgAllPageNum:1,//当前页
				readPageNum:1,
				noReadPageNum:1,
				msgAllTotal:0,
				noReadTotal:0,
				readTotal:0,
				refreshing:false,
				loading:false,
				scrollTops:true,
				dialog:false,
				msgAllNo:false,
				noReadNo:false,
				readNo:false,
				msg:'',
				apiReq:{
					data: {
						conditions: "all",
						userId: this.$store.state.userInfo.userId
					},
					pageNo: 1,
					pageSize: 10
				},
				notices: [{
					title: '关于2018年第三期新员工培训通知',
					date: '2018年5月2日',
					isRead: false,
					desc: '河北中科恒运软件科技有限公司关于第三期新员工培训计划通知。'
				}, {
					title: '欢迎加入我们的大家庭',
					date: '2018年5月1日',
					isRead: true,
					desc: '河北中科恒运软件科技有限公司。'
				}, {
					title: '关于数博会加班通知',
					date: '2018年4月2日',
					isRead: true,
					desc: '河北中科恒运软件科技有限公司。'
				}]
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
		methods:{
			init(){
				this.getAllMsg();
				this.getNotReadMsg();
				this.getReadMsg();
			},
			zd(){//切换标签置顶
				window.scroll(0, 0)
			},
			refresh(type){
				switch (type) {
					case 'all':
						this.msgAllArr=[];
            this.msgAllPageNum = 1;
            this.msgNoContent = false
						this.getAllMsg();
						break;
					case 'noread':
						this.noReadArr=[];
            this.noReadPageNum = 1;
            this.noReadNoContent = false
						this.getNotReadMsg();
						break;
					default:
						this.readArr=[];
            this.readPageNum = 1;
            this.readNoContent = false
						this.getReadMsg();
						break;
				}
				this.refreshing = true;
			},
			loadFuc(type){
					if(document.documentElement.scrollTop == 0){
							if((document.body.scrollTop + document.documentElement.scrollHeight + 100) >= document.body.scrollHeight){
									console.log("进来");
									this.load(type);
							}
					}else{
							this.load(type);
					}
			},
			load (type) {
				this.scrollTops = false;
				this.loading = true;
				switch (type) {
					case 'all':
						if(this.msgAllPageNum < this.msgAllPages){
							this.msgAllPageNum ++;
							this.getAllMsg();
						}else{
							this.msgAllNo = true;
						}
						break;
					case 'noread':
						if(this.noReadPageNum < this.noReadPages){
							this.noReadPageNum ++;
							this.getNotReadMsg();
						}else{
							this.noReadNo = true;
						}
						break;
					default:
						if(this.readPageNum < this.readPages){
							this.readPageNum ++;
							this.getReadMsg();
						}else{
							this.readNo = true;
						}
						break;
				}
			},
			getAllMsg(){
				this.apiReq.data.userId = this.$store.state.userInfo.userId;
				if(this.apiReq.data.userId == ''){
					this.getUserInfo();
					setTimeout(() => {
						this.getAllMsg();
					},500);
					return;
				}
				this.apiReq.pageNo = this.msgAllPageNum;
				setTimeout(() => {
					api(ApiList.getAllMsg,this.apiReq).then((res)=>{
						console.log(res);
						if(res.data.errcode==0){
              this.msgAllArr = this.msgAllArr.concat(res.data.data.list);
              if(this.msgAllArr.length === 0) {
                this.msgNoContent = true
              }
							this.msgAllPages = res.data.data.pages;
							this.msgAllPageNum = res.data.data.pageNum;
						}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
							this.getAllMsg();
						}else{
							this.msg = res.data.errmsg;
							this.dialog = true;
						}
					},(error)=>{
            this.msgNoContent = true
          })
					this.loading = false;
					this.refreshing = false;
				}, 500)
			},
			getNotReadMsg(){
				this.apiReq.data.userId = this.$store.state.userInfo.userId;
				if(this.apiReq.data.userId == ''){
					this.getUserInfo();
					setTimeout(() => {
						this.getNotReadMsg();
					},500);
					return;
				}
				this.apiReq.pageNo = this.noReadPageNum;
				setTimeout(() => {
					api(ApiList.getNotReadMsg,this.apiReq).then((res)=>{
						console.log(res);
						if(res.data.errcode==0){
              this.noReadArr = this.noReadArr.concat(res.data.data.list);
              if(this.noReadArr.length === 0) {
                this.noReadNoContent = true
              }
							this.noReadPages = res.data.data.pages;
							this.noReadPageNum = res.data.data.pageNum;
						}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
							this.getNotReadMsg();
						}else{
							this.msg = res.data.errmsg;
							this.dialog = true;
						}
					},(error)=>{
            this.noReadNoContent = true
          })
					this.loading = false;
					this.refreshing = false;
				}, 500)
			},
			getReadMsg(){
				this.apiReq.data.userId = this.$store.state.userInfo.userId;
				if(this.apiReq.data.userId == ''){
					this.getUserInfo();
					setTimeout(() => {
						this.getReadMsg();
					},500);
					return;
				}
				this.apiReq.pageNo = this.readPageNum;
				setTimeout(() => {
					api(ApiList.getReadMsg,this.apiReq).then((res)=>{
						console.log(res);
						if(res.data.errcode==0){
              this.readArr = this.readArr.concat(res.data.data.list);
              if(this.readArr.length === 0) {
                this.readNoContent = true
              }
							this.readPages = res.data.data.pages;
							this.readPageNum = res.data.data.pageNum;
						}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
							this.getReadMsg();
						}else{
							this.msg = res.data.errmsg;
							this.dialog = true;
						}
					},(error)=>{
            this.readNoContent = true
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
				this.$router.push({
					name:'MessageNoticeView',
					params:{readIs:readIs,msgId:msgId,recId:recId}
				});
			},
			goback () {
				this.$store.dispatch('openLoading')
				Android.closeActivity();//返回安卓上一页
			},
			...mapMutations([
				'getUserInfo'
			])
		},
		components: {
			nullModal
		}
	}
</script>

<style lang="less" scoped="scoped">
	.container {
		padding: 0;
		// background:#e6e6e6;
        .demo-text{
            padding:0;
			padding-top:98px;
			height:100%;
			/deep/ .mu-load-more{
				background: #fff;
			}
		}
		.noContent{
			padding:7px 0;
			background: #fff;
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
	.gray{
		color:#797979;
	}
	.point{
		width:10px;
		height:10px;
		background: #d75050;
		border-radius: 50%;
		position: absolute;
		top: 5px;
		left: -8px;
	}
</style>