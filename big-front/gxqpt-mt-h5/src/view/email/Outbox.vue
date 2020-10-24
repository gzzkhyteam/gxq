<!-- 发件箱 -->
<template>
	<mu-container>
        <top-bar style="z-index:10000" title="发件箱" fixedTrue></top-bar>
        <!-- <div class="searchToolbar">
            <div class="mu-input  has-icon">
                <i class="mu-input-icon mu-icon material-icons" style="user-select: none;">search</i>
                <div class="mu-text-field mu-input-content">
                    <input @focus="goTo('emailSearch')" tabindex="0" placeholder="请输入搜索内容" class="mu-text-field-input">
                    <div>
                        <div class="mu-input-line"></div>
                        <div class="mu-input-focus-line "></div>
                    </div>
                </div>
            </div>
        </div> -->
		<mu-load-more style="padding-top:56px;background:#fff;" v-if="emailAllArr.length!=0" :class="{refH:emailAllArr.length==0}" @refresh="refresh" :refreshing="refreshing" :loading="loading" @load="loadFuc('all')" :loaded-all='emailAllNo'>
			<mu-list textline="three-line" class="notice-list">
                <div v-for="(item, index) in emailAllArr" :key="index" @click="goDetail(item.messageUID)">
                    <mu-list-item avatar :ripple="false" button>
                    <mu-list-item-action>
                        <div class="mu-avatar" style="width:40px;height:40px;font-size:20px;background:#38ADFF;">
                            <div class="email_avatar">{{ item.avatar }}</div>
                        </div>
                    </mu-list-item-action>
                    <mu-list-item-content>
                        <mu-list-item-title>{{ item.subject }}</mu-list-item-title>
                        <mu-list-item-sub-title>
                            <span style="color: rgba(0, 0, 0, .87)"><{{ item.to }}> -</span> {{ item.date }}
                        </mu-list-item-sub-title>
                    </mu-list-item-content>
                    </mu-list-item>
                    <mu-divider></mu-divider>
                </div>
			</mu-list>
		</mu-load-more>
		<nullModal v-if="emailAllArr.length==0"></nullModal>
		<p class="noContent" v-if="emailAllNo">没有数据了</p>
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
    import topBar from '@/components/topBar';
	export default {
		data() {
			return {
                searchText:'',
				tabActive:0,
				emailAllArr:[],
				emailAllPages:1,
				emailAllTotal:0,
				refreshing:false,
				loading:false,
				scrollTops:true,
				dialog:false,
				emailAllNo:false,
                emailAllPages:1,
                mailIdArr:[],
				msg:'',
				apiReq:{
                    data:'SENDED',
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
			},
			zd(){//切换标签置顶
				window.scroll(0, 0)
            },
            search(){//搜索
                let data = {
                    "data": {
                        "folderType": "INBOX",
                        "keyword": this.searchText
                    },
                    "pageNo": 1,
                    "pageSize": 100
                };
                api(ApiList.searchAll,data).then((res)=>{
					console.log(res);
					if(res.data.errcode==0){
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{})
            },
			refresh(type){
				this.apiReq.pageNo = 1;
				this.emailAllArr=[];
				this.getAllInbox();
				this.refreshing = true;
				this.emailAllNo = false;
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
				if(this.apiReq.pageNo < this.emailAllPages){
					this.loading = true;
					this.apiReq.pageNo ++;
					this.getAllInbox();
				}else{
					this.emailAllNo = true;
				}
			},
			getAllInbox(){
				setTimeout(() => {
					api(ApiList.getAllInbox,this.apiReq).then((res)=>{
						console.log(res);
						if(res.data.errcode==0){
							this.emailAllArr = this.emailAllArr.concat(res.data.data.records);
							this.emailAllPages = res.data.data.totalpage;
							this.emailAllTotal = res.data.data.totalrecord;
							this.emailAllArr.forEach(item => {
								this.mailIdArr.push(item.messageUID);
								item.avatar = item.subject.slice(0,2);
							});
						}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
							this.getAllInbox();
						}else{
							this.msg = res.data.errmsg;
							this.dialog = true;
						}
					},(error)=>{})
					this.loading = false;
					this.refreshing = false;
				}, 500)
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
            goDetail(id){
                this.$store.dispatch('openLoading')
				this.$router.push({
					name:'EmailDetail',
					params:{mailId:id,mailIdArr:this.mailIdArr,type:'SENDED'}
				});
            },
		},
		components: {
            nullModal,
            topBar
		}
	}
</script>

<style lang="less" scoped="scoped">
	.container {
		padding: 0;
		background: #fff;
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
    .searchToolbar{
        padding-top:56px;
    }
    .email_avatar{
        font-size: 1rem;
        line-height: 2.5rem;
        font-weight: bold;
    }
    .appbarRight{
		margin-right: 6rem;
	}
</style>