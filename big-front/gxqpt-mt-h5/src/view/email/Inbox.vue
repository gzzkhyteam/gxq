<template>
	<mu-container>
		<div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box" style="position:fixed">
			<div class="mu-appbar-left">
				<a @click="goback" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
					<div class="mu-button-wrapper">
						<div class="mu-ripple-wrapper"></div> 
						<i class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_left</i>
						返回
					</div>
				</a>
			</div> 
			<div class="mu-appbar-title">
				<div class="mu-appbar-title">收件箱</div> 
			</div>
            <mu-menu slot="right">
                <mu-button flat>
                    <mu-icon value="menu"></mu-icon>
                </mu-button>
                <mu-list slot="content">
					<mu-list-item v-for="(item,index) in menus" :key="index" button @click="goTo(item.url)">
						<mu-list-item-content>
							<div class="mu-item-action" style="min-width: 0;float:left;padding-right: 8px;">
								<i class="mu-icon material-icons" style="user-select: none;">{{ item.icon }}</i>
							</div>
							<div class="mu-item-title" style="float: left;width:auto">{{ item.name }}</div>
						</mu-list-item-content>
					</mu-list-item>
                </mu-list>
            </mu-menu>
		</div>
		<mu-tabs @change="zd" :value.sync="tabActive" inverse color="#2196F3" indicator-color="#2196F3" center full-width style="position:fixed;top:50px;">
			<mu-tab>全部</mu-tab>
			<mu-tab>未读</mu-tab>
			<mu-tab>已读</mu-tab>
		</mu-tabs>
		<div class="demo-text" v-if="tabActive === 0">
			<mu-load-more v-if="emailAllArr.length!=0" :class="{refH:emailAllArr.length==0}" @refresh="refresh('all')" :refreshing="refreshing" :loading="loading" @load="loadFuc('all')" :loaded-all='emailAllNo'>
				<mu-list textline="three-line" class="notice-list">
					<div v-for="(item, index) in emailAllArr" :key="index" @click="goDetail('all',item.messageUID)">
						<mu-list-item avatar :ripple="false" button>
						<mu-list-item-action>
							<div class="mu-avatar" style="width:40px;height:40px;font-size:20px;background:#38ADFF;">
								<div class="email_avatar">{{ item.avatar }}</div>
							</div>
						</mu-list-item-action>
						<mu-list-item-content>
							<mu-list-item-title>{{ item.subject }}</mu-list-item-title>
							<mu-list-item-sub-title>
								<span style="color: rgba(0, 0, 0, .87)">{{ item.from }}</span> {{ item.date }}
							</mu-list-item-sub-title>
						</mu-list-item-content>
						</mu-list-item>
						<mu-divider></mu-divider>
					</div>
				</mu-list>
			</mu-load-more>
			<nullModal v-if="noContent"></nullModal>
			<p class="noContent" v-if="emailAllNo">没有数据了</p>
		</div>
		<div class="demo-text" v-if="tabActive === 1">
			<mu-load-more v-if="noReadArr.length!=0" :class="{refH:noReadArr.length==0}" @refresh="refresh('noread')" :refreshing="refreshing" :loading="loading" @load="loadFuc('noread')" :loaded-all='noReadNo'>
				<mu-list textline="three-line" class="notice-list">
					<div v-for="(item, index) in noReadArr" :key="index" @click="goDetail('noread',item.messageUID)">
						<mu-list-item avatar :ripple="false" button>
						<mu-list-item-action>
							<div class="mu-avatar" style="width:40px;height:40px;font-size:20px;background:#38ADFF;">
								<div class="email_avatar">{{ item.avatar }}</div>
							</div>
						</mu-list-item-action>
						<mu-list-item-content>
							<mu-list-item-title>{{ item.subject }}</mu-list-item-title>
							<mu-list-item-sub-title>
								<span style="color: rgba(0, 0, 0, .87)">{{ item.from }}</span> {{ item.date }}
							</mu-list-item-sub-title>
						</mu-list-item-content>
						</mu-list-item>
						<mu-divider></mu-divider>
					</div>
				</mu-list>
			</mu-load-more>
			<nullModal v-if="noReadNoContent"></nullModal>
			<p class="noContent" v-if="readNo">没有数据了</p>
		</div>
		<div class="demo-text" v-if="tabActive === 2">
			<mu-load-more v-if="readArr.length!=0" :class="{refH:readArr.length==0}" @refresh="refresh('read')" :refreshing="refreshing" :loading="loading" @load="loadFuc('read')" :loaded-all='readNo'>
				<mu-list textline="three-line" class="notice-list">
					<div v-for="(item, index) in readArr" :key="index" @click="goDetail('read',item.messageUID)">
						<mu-list-item avatar :ripple="false" button>
						<mu-list-item-action>
							<div class="mu-avatar" style="width:40px;height:40px;font-size:20px;background:#38ADFF;">
								<div class="email_avatar">{{ item.avatar }}</div>
							</div>
						</mu-list-item-action>
						<mu-list-item-content>
							<mu-list-item-title>{{ item.subject }}</mu-list-item-title>
							<mu-list-item-sub-title>
								<span style="color: rgba(0, 0, 0, .87)">{{ item.from }}</span> {{ item.date }}
							</mu-list-item-sub-title>
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
	export default {
		data() {
			return {
				searchText:'',
				menus:[
					{
						name:'写邮件',
						icon:'edit',
						url:'emailModal'
					},
					{
						name:'发件箱',
						icon:'email',
						url:'outbox'
					},
					{
						name:'搜索',
						icon:'search',
						url:'emailSearch'
					},
				],
				tabActive:0,
				emailAllArr:[],
				noReadArr:[],
		        readArr:[],
		        noContent:false,
		        noReadNoContent:false,
		        readNoContent:false,
				mailIdArr:[],
				noReadIdArr:[],
				readIdArr:[],
				emailAllPages:1,//总页数
				noReadPages:1,
				readPages:1,
				AllPageNum:1,//当前页
				readPageNum:1,
				noReadPageNum:1,
				emailAllTotal:0,
				noReadTotal:0,
				readTotal:0,
				refreshing:false,
				loading:false,
				scrollTops:true,
				dialog:false,
				emailAllNo:false,
				noReadNo:false,
				readNo:false,
				msg:'',
				apiReq:{
                    data:'INBOX',
					pageNo: 1,
					pageSize: 10
				},
				seeApiReq:{
                    "data": {
						"folderType": "INBOX",
						"isRead": false
					},
					pageNo: 1,
					pageSize: 10
				},
			}
		},
		// activated(){//缓存回来数据
		// 	this.$store.dispatch('closeLoading', false);
		// },
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
				this.getAllInbox();
				this.getEmailSee(true);
				setTimeout(() => {
					this.getEmailSee(false);
				}, 500)
			},
			zd(){//切换标签置顶
				window.scroll(0, 0)
            },
			refresh(type){
				switch (type) {
					case 'all':
						this.apiReq.pageNo = 1;
						this.emailAllArr=[];
						this.mailIdArr = [];
						this.emailAllNo = false;
						this.noContent = false;
						this.getAllInbox();
						break;
					case 'noread':
						this.noReadPageNum = 1;
						this.noReadArr=[];
						this.noReadIdArr=[];
						this.noReadNo=false;
						this.noReadNoContent=false;
						this.getEmailSee(false);
						break;
					default:
						this.readPageNum = 1;
						this.readArr=[];
						this.readIdArr=[];
						this.readNo=false;
						this.readNoContent=false;
						this.getEmailSee(true);
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
				switch (type) {
					case 'all':
						if(this.apiReq.pageNo < this.emailAllPages){
							this.loading = true;
							this.apiReq.pageNo ++;
							this.getAllInbox();
						}else{
							this.emailAllNo = true;
						}
						break;
					case 'noread':
						if(this.noReadPageNum < this.noReadPages){
							this.loading = true;
							this.noReadPageNum ++;
							this.getEmailSee(false);
						}else{
							this.noReadNo = true;
						}
						break;
					default:
						if(this.readPageNum < this.readPages){
							this.loading = true;
							this.readPageNum ++;
							this.getEmailSee(true);
						}else{
							this.readNo = true;
						}
						break;
				}
			},
			getAllInbox(){
				setTimeout(() => {
					api(ApiList.getAllInbox,this.apiReq).then((res)=>{
						console.log(res);
						if(res.data.errcode==0){
							if(res.data.data.records){
                this.emailAllArr = this.emailAllArr.concat(res.data.data.records);
                if(this.emailAllArr.length === 0){
                  this.noContent = true
                }
								this.emailAllPages = res.data.data.totalpage;
								this.AllPageNum = res.data.data.currentpage;
								this.emailAllTotal = res.data.data.totalrecord;
								this.emailAllArr.forEach(item => {
									this.mailIdArr.push(item.messageUID);
									item.avatar = item.subject.slice(0,2);
								});
							}
							console.log(this.emailAllArr);
						}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
							this.getAllInbox();
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
			getEmailSee(isRead){
				this.seeApiReq.pageNo = isRead ? this.readPageNum : this.noReadPageNum;
				this.seeApiReq.data.isRead = isRead;
				console.log('---------参数!!-------------')
				console.log(isRead)
				console.log(JSON.stringify(this.seeApiReq))
				api(ApiList.getEmailSee,this.seeApiReq).then((res)=>{
					console.log('---------列表-------' + isRead)
					console.log(res);
					if(res.data.errcode==0){
						if(isRead){
							if(res.data.data.records){
			                  	this.readArr = this.readArr.concat(res.data.data.records);
			                  	if(this.readArr.length === 0){
			                    	this.readNoContent = true
			                  	}
								this.readPages = res.data.data.totalpage;
								this.readPageNum = res.data.data.currentpage;
								this.readTotal = res.data.data.totalrecord;
								this.readArr.forEach(item => {
									this.readIdArr.push(item.messageUID);
									item.avatar = item.subject.slice(0,2);
								});
							}
						}else{
							if(res.data.data.records){
			                  	this.noReadArr = this.noReadArr.concat(res.data.data.records);
			                  	if(this.noReadArr.length === 0){
			                    	this.noReadNoContent = true
			                  	}
								this.noReadPages = res.data.data.totalpage;
								this.noReadPageNum = res.data.data.currentpage;
								this.noReadTotal = res.data.data.totalrecord;
								this.noReadArr.forEach(item => {
									this.noReadIdArr.push(item.messageUID);
									item.avatar = item.subject.slice(0,2);
								});
							}
						} 
					}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
						this.getEmailSee(isRead);
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{
		            if(isRead){
		              	this.readNoContent = true
		            }else{
		              	this.noReadNoContent = true
		            }
	          	})
				this.loading = false;
				this.refreshing = false;
			},
			closeDialog(){
				this.dialog = false;
			},
			goTo(name){//跳转
				this.$store.dispatch('openLoading')
				this.$router.push({
					path:name
				});
            },
            goDetail(type,id){
				let idArr = [];
				if(type=='all'){
					idArr = this.mailIdArr;
				}else if(type=='read'){
					idArr = this.readIdArr;
				}else{
					idArr = this.noReadIdArr;
				}
                this.$store.dispatch('openLoading')
				this.$router.push({
					name:'EmailDetail',
					params:{mailId:id,mailIdArr:idArr,type:'INBOX'}
				});
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
		background: #fff;
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
    .searchToolbar{
        padding-top:56px;
    }
    .email_avatar{
        font-size: 1rem;
        line-height: 2.5rem;
        font-weight: bold;
    }
</style>