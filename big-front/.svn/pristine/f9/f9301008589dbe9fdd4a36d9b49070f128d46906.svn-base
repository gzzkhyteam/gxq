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
				<div class="searchToolbar">
                    <mu-text-field v-model="searchText" placeholder="请输入搜索内容"></mu-text-field>
                    <mu-button flat color="primary" @click="search">搜索</mu-button>
                </div>
			</div>
            <mu-button flat slot="right" color="primary" @click="search">搜索</mu-button>
		</div>
		<mu-list v-if="searchAllArr.length!=0" textline="three-line" style="padding-top:56px;">
			<div v-for="(item, index) in searchAllArr" :key="index" @click="goDetail(item.messageUID, item.folderType)">
				<mu-list-item avatar :ripple="false" button>
				<mu-list-item-action>
					<div class="mu-avatar" style="width:40px;height:40px;font-size:20px;background:#38ADFF;">
						<div class="email_avatar">{{ item.subject.slice(0,2) }}</div>
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
		<nullModal v-if="searchAllArr.length==0"></nullModal>
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
				tabActive:0,
				searchAllArr:[],
				dialog:false,
				msg:'',
				apiReq:{
                    data:'INBOX',
					pageNo: 1,
					pageSize: 10
				},
			}
		},
		updated () {
			this.$nextTick(function(){
				let position = this.$store.state.positionY //返回页面取出来
				window.scroll(0, position)
			}) 
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
                this.searchText='';
                this.searchAllArr = [];
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
						this.searchAllArr = res.data.data.records
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{})
            },
			closeDialog(){
				this.dialog = false;
			},
			goDetail(id, type){
                this.$store.dispatch('openLoading')
				this.$router.push({
					name:'EmailDetail',
					params: {
						mailId: id,
						type: type
					}
				});
            },
			goback () {
				this.$store.dispatch('openLoading')
                this.$router.go(-1);
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
    .searchToolbar{
        padding-top:1rem;
    }
    .searchToolbar /deep/ .mu-input{
        color:#fff;
    }
    .searchToolbar /deep/ .mu-text-field-input{
        color:#fff;
	}
	.email_avatar{
        font-size: 1rem;
        line-height: 2.5rem;
        font-weight: bold;
    }
</style>