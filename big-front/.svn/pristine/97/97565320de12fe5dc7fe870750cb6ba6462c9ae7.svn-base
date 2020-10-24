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
			<div class="mu-appbar-title">
				<div class="mu-appbar-title">邮件详情</div> 
			</div>
            <div class="mu-appbar-right">
				<a @click="lastOne" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
					<div class="mu-button-wrapper">
						<div class="mu-ripple-wrapper"></div> 
						<i class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_up</i>
					</div>
				</a>
                <a @click="nextOne" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
					<div class="mu-button-wrapper">
						<div class="mu-ripple-wrapper"></div> 
						<i class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_down</i>
					</div>
				</a>
			</div> 
		</div>
        <div class="email_detail">
            <div class="email_detail_title">
                <div class="email_subject"><b>{{ detail.subject }}</b></div>
                <div class="email_detail_sender">
					<div class="mu-avatar">
						<div class="email_avatar">{{ detail.avatar }}</div>
					</div>
                    <div class="email_detail-sender_name">
                        <p class="name_title">{{ detail.to | senderName }}</p>
                        <p>{{ detail.date }}</p>
                    </div>
                </div>
            </div>
            <div class="email_detail_content" v-html="detail.content"></div>
        </div>
        <div class="email_files" v-if="detail.file && detail.file.length > 0">
        	<h3>附件</h3>
        	<div>
        		<img class="email_file" :src="file.url" v-for="file in imgFiles" />
        	</div>
        	<div v-for="file in notImgFiles">
        		<span class="email_file_not_img" @click="downloadFile(file.url)">{{file.fileName}}</span>
        	</div>
        </div>
		<div class="mu-bottom-nav">
			<div class="mu-bottom-nav-shift-wrapper">
				<div class="mu-bottom-item" v-for="(item, index) in bottomNav" :key="index">
					<div class="mu-bottom-item-wrapper" @click="goTo(item.type)">
						<div class="mu-ripple-wrapper"></div>
						<i class="mu-icon material-icons mu-bottom-item-icon" style="user-select: none;">{{ item.icon }}</i>
						<span class="mu-bottom-item-text">{{ item.title }}</span>
					</div>
				</div>
			</div>
		</div>
		<mu-dialog title="是否删除" width="360" :open.sync="delDialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="deleteEmail">确定</mu-button>
            <mu-button slot="actions" flat color="primary" @click="closeDelDialog">取消</mu-button>
        </mu-dialog>
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
				bottomNav:[
					{
						icon:'reply',
						title:'转发',
						type:'reply',
					},
					{
						icon:'sync',
						title:'回复',
						type:'sync',
					},
					{
						icon:'delete_forever',
						title:'删除',
						type:'delete',
					},
				],
				emailType:'INBOX',
				clear:false,
				detail: {},
				mailId:'',
				dialog:false,
				delDialog:false,
			}
		},
		filters: {
			senderName (val) {
				return val.length > 90 ? val.substring(0, 90) + '...' : val
			}
		},
		computed: {
			imgFiles () {
				const imgTypes = ['png', 'jpg', 'gif'];
				return this.detail.file.filter(item => {
					const arrs = item.fileName.split('.');
					const type = arrs[arrs.length - 1].toLowerCase();
					return imgTypes.includes(type);
				})
			},
			notImgFiles () {
				const imgTypes = ['png', 'jpg', 'gif'];
				return this.detail.file.filter(item => {
					const arrs = item.fileName.split('.');
					const type = arrs[arrs.length - 1].toLowerCase();
					return !imgTypes.includes(type);
				})
			}
		},
		watch:{
			'$route'(to,from) {
				if(from.name != 'EmailModal'){
					this.clear =true;
				}else{
					this.clear =false;
				}
			},
		},
		mounted(){
			this.$store.dispatch('closeLoading', false);
			this.init();
		},
		activated(){
			this.$store.dispatch('closeLoading', false);
			if(this.clear){
				this.init();
			}
		},
		methods:{
			downloadFile (url) {
				window.open(url)
			},
			init(){
				this.getDetail(this.$route.params.mailId);
				this.emailType = this.$route.params.type;
				if(this.emailType == 'SENDED'){
					this.bottomNav = [
						{
							icon:'delete_forever',
							title:'删除',
							type:'delete',
							show:true
						},
					];
				}else{
					this.bottomNav = [
						{
							icon:'reply',
							title:'转发',
							type:'reply',
						},
						{
							icon:'sync',
							title:'回复',
							type:'sync',
						},
						{
							icon:'delete_forever',
							title:'删除',
							type:'delete',
						},
					];
				}
			},
			zd(){//切换标签置顶
				window.scroll(0, 0)
            },
            lastOne(){
				console.log("上一条");
				let arr = this.$route.params.mailIdArr;
				if(arr){
					for(var i in arr){
						if(arr[i] == this.mailId){
							if(i-1 >= 0){
								this.getDetail(arr[i-1])
							}else{
								this.msg = '没有上一条数据！';
								this.dialog = true;
							}
						}
					}
				}
            },
            nextOne(){
				console.log("下一条");
				let arr = this.$route.params.mailIdArr;
				if(arr){
					for(var i in arr){
						i = parseInt(i);
						if(arr[i] == this.mailId){
							if(i+1 < arr.length){
								this.getDetail(arr[i+1])
							}else{
								this.msg = '没有下一条数据！';
								this.dialog = true;
							}
						}
					}
				}
            },
			getDetail(id){
                let data = {
                    folderType:this.$route.params.type,
                    mailId:id
				}
				api(ApiList.emailDetail,data).then((res)=>{
					if(res.data.errcode==0){
						let reg = new RegExp('\n','g');
						this.detail = res.data.data;
						this.detail.content = this.detail.content.replace(reg,'<br/>');
						this.mailId = res.data.data.messageUID;
						this.detail.avatar = this.detail.subject.slice(0,2);
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{})
			},
			deleteEmail(){//删除
				this.closeDelDialog();
				console.log(this.mailId);
				let data = {
                    folderType:this.$route.params.type,
                    mailId:this.mailId
				}
				api(ApiList.deleteEmail,data).then((res)=>{
					if(res.data.errcode==0){
						this.msg = "删除成功!";
						this.dialog = true;
						this.$router.go(-1);
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{})
			},
			closeDelDialog(){
				this.delDialog = false;
			},
			closeDialog(){
				this.dialog = false;
			},
			goTo(type){
				if(type != 'delete'){
					this.$store.dispatch('openLoading')
					this.$router.push({
						name:'EmailModal',
						params:{content:this.detail,type:type}
					});
				}else{
					this.delDialog = true;
				}
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
    .email_detail{
        text-align: left;
        padding: 56px 10px 0 10px;
        .email_detail_title{
			height:auto;
			border-bottom: 1px solid #ccc;
			display:inline-block !important; 
			display:inline;
            .email_subject{
                margin:10px 0;
				font-size: 1rem;
				height: auto;
				word-break: break-all;
				word-wrap: break-word;
            }
            .email_detail_sender{
                width:100%;
                min-height: 60px;
    			height: auto;
                .mu-avatar{
                    width: 48px;
                    height: 48px;
                    border-radius: 50%;
					float: left;
					font-size:20px;
					background:#38ADFF;
                }
                .email_detail-sender_name{
					float: left;
					margin-left: 10px;
					min-height: 48px;
					max-width: 80%;
					height: auto;
                    p{
                        margin: 0;
						font-size: 0.8rem;
						word-break: break-all;
    					word-wrap: break-word;
                    }
                    .name_title{
                    	max-height: 38px;
                    	overflow: hidden;
                    }
                }
            }
        }
        .email_detail_content{
            // min-height:300px;
			height:auto;
			margin:1rem 0 4rem 0;
			background: #fff;
        }
	}
	.email_files{
		text-align: left;
		border-top: 1px solid #ccc;
		margin: 10px;
		.email_file{
			max-width: 46%;
			max-height: 200px;
			margin: 0 5px;
		}
		.email_file_not_img{
			color: #0A76D1;
		}
	}
	.email_avatar{
        font-size: 1rem;
        line-height: 2.9rem;
        font-weight: bold;
	}
	.mu-bottom-nav{
		width:100%;
		position:fixed;
		bottom:0;
	}
	.mu-bottom-item{
		padding-top: 6px;
		padding-bottom: 5px;
		color: #2196f3;
	}
	// .mu-bottom-item-active{
	// 	padding-top: 0;
	// 	padding-bottom: 0;
	// 	color: rgba(0, 0, 0, 0.54);
	// }
</style>