<template>
	<div class="main" :class="{hiddex:this.$store.getters.isLoading}">
		<top-bar style="z-index:10000;position:fixed" right-act='{"name":"写日志","url":"logForm"}' :title="title"></top-bar>
		<mu-container ref="container">
			<mu-tabs :value.sync="tabActive" inverse color="#2196F3" indicator-color="#2196F3" text-color="red" center full-width>
				<mu-tab>我收到的({{receiptLogsTotal}})</mu-tab>
				<mu-tab>我发出的({{emitLogsTotal}})</mu-tab>
			</mu-tabs>
			<div class="demo-text" v-if="tabActive === 0">
				<mu-load-more v-if="receiptLogs.length!=0" :class="{refH:receiptLogs.length==0}" @refresh="refreshReceiptLogs" :refreshing="receiptLogsrefreshing" :loading="receiptLogsloading" @load="infiniteReceiptLogs">
					<log-info @click="GoTo_Detalis(log,0)" v-for="(log,index) of receiptLogs" :data-log=log :key="index"></log-info>
				</mu-load-more>
				<nullModal v-if="receiptNoContent"></nullModal>
			</div>
			<div class="demo-text" v-if="tabActive === 1">
				<mu-load-more v-if="emitLogs.length!=0" :class="{refH:emitLogs.length==0}" @refresh="refreshEmitLogs" :refreshing="emitLogsrefreshing" :loading="emitLogsloading" @load="infiniteEmitLogs">
					<log-info @click="GoTo_Detalis(log,1)" v-for="(log,index) of emitLogs" :data-log=log :key="index"></log-info>
				</mu-load-more>
				<nullModal v-if="emitNoContent"></nullModal>
			</div>
		</mu-container>
	</div>
</template>
<script>
	import topBar from '@/components/topBar';
	import logInfo from '@/components/logInfo';
	import imgObj from '../../assets/logo.png'
	import ApiList from '@/api/apiList'
	import api from '@/api/axiosApi'
	import nullModal from '@/components/nullModal';
	export default {
		name: 'index',
		data(){
			return {
				tabActive:this.$store.state.tabActive,
				title:"我的日志",
				showBack:false,
				receiptLogsrefreshing: false,
				emitLogsrefreshing: false,
				receiptLogsloading: false,
				emitLogsloading: false,
				receiptLogsPagesTotal:0,
				emitLogsPagesTotal:0,
				receiptLogsPages:1,
				emitLogsPages:1,
				openApiReq:{
					pageNo: 1,
					pageSize: 10
				},
				receiptLogsTotal:0,
				emitLogsTotal:0,
				receiptLogs:[],
        emitLogs:[],
        receiptNoContent:false,
        emitNoContent:false,
				scrollTops:true,
			}
		},
		updated () {
			if(this.scrollTops){
				this.$nextTick(function(){
					console.log("进来");
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
			this.getlookPage();
			this.getPageApp();
		},
		created(){
			console.log("测试是否为最新代码");
			console.log(this.$store.state.userInfo.token);
		},
		methods:{
			getlookPage(){
				api(ApiList.receiptLog,this.openApiReq)
				.then((res)=>{
					if(!!res.data.data){
						let r = res.data.data;
						this.receiptLogsTotal = r.total;
						this.receiptLogsPagesTotal = r.pages;
            this.receiptLogs = this.receiptLogs.concat(r.list);
            if(this.receiptLogs.length === 0){
              this.receiptNoContent = true
            }
					}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
						console.log("token错误，重新请求1");
						this.getlookPage();
					}
				},(error)=>{
          this.receiptNoContent = true
        })
				this.receiptLogsloading = false;
				this.receiptLogsrefreshing = false;
			},
			getPageApp(){
				api(ApiList.emitLog,this.openApiReq)
				.then((res)=>{
					if(!!res.data.data){
						let r = res.data.data;
						this.emitLogsTotal = r.total;
						this.emitLogsPagesTotal = r.pages;
            this.emitLogs = this.emitLogs.concat(r.list);
            if(this.emitLogs.length === 0){
              this.emitNoContent = true
            }
					}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
						console.log("token错误，重新请求2");
						this.getPageApp();
					}
				},(error)=>{
          this.emitNoContent = true
				})
				this.emitLogsrefreshing = false;
				this.emitLogsloading = false;
			},
			refreshEmitLogs() {//下拉刷新
        this.emitLogsrefreshing = true;
        this.emitNoContent = false;
				this.emitLogsPages=1;
				this.openApiReq.pageNo=1;
				this.$refs.container.scrollTop = 0;
				setTimeout(() => {
					this.getPageApp();
					this.emitLogs=[];
				}, 1000);
			},
			refreshReceiptLogs() {//下拉刷新
        this.receiptLogsrefreshing = true;
        this.receiptNoContent = false
				this.receiptLogsPages=1;
				this.openApiReq.pageNo=1;
				this.$refs.container.scrollTop = 0;
				setTimeout(() => {
					this.getlookPage();
					this.receiptLogs=[];
				}, 1000);
			},
			infiniteEmitLogs() {//上拉加载
				this.scrollTops = false;
				if(this.emitLogsPages<this.emitLogsPagesTotal){
					this.emitLogsPages++;
					this.openApiReq.pageNo = this.emitLogsPages;
				}else{
					return
				}
				this.emitLogsloading = true;
				setTimeout(() => {
					this.getPageApp();
				}, 1000);
			},
			infiniteReceiptLogs() {//上拉加载
				this.scrollTops = false;
				if(this.receiptLogsPages<this.receiptLogsPagesTotal){
					this.receiptLogsPages++;
					this.openApiReq.pageNo = this.receiptLogsPages;
				}else{
					return
				}
				this.receiptLogsloading = true;
				setTimeout(() => {
					this.getlookPage()
				}, 1000);
			},
			GoTo_Detalis(log,type){
				log.type = type;
				this.$store.dispatch('openLoading')
				this.$router.push({
					name:'LogDetail',
					params:{log:JSON.stringify(log)}
				});
			}
		},
		components: {
			topBar,
			nullModal,
			logInfo
		},
	}
</script>
<style lang="less" scoped>
	.container {
		padding: 0;
		margin-top:56px;
	}
	.demo-text{
		min-height:100%;
		height:auto;
		overflow: hidden;
		.refH{
			height:350px;
		}
	}
	.hiddex{
		overflow: hidden;
	}
</style>