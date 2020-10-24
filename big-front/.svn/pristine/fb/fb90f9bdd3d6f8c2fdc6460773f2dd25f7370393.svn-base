<template>
	<div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box" :style="{position:fixedTrue ? 'fixed' : 'none'}">
		<div class="mu-appbar-left">
			<a @click="goback" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
				<div class="mu-button-wrapper">
					<div class="mu-ripple-wrapper"></div> 
					<i class=" mu-icon  material-icons  " style="user-select: none;">keyboard_arrow_left</i>
					返回
				</div>
			</a>
		</div> 
		<div class="mu-appbar-title" :class="{ appbarRight : !rightAct}">
			<div class="mu-appbar-title">{{title}}</div> 
		</div>
		<mu-button flat slot="right" v-if="!!rightAct" :to="rightActJson.url" style="font-size:1rem">
			<mu-icon v-if="!!rightActJson.icon" :value="rightActJson.icon"></mu-icon>
			{{rightActJson.name}}
		</mu-button>
	</div>
</template>
<script>
	export default {
		data () {
			return {
				backFrom:'-1',
				fromLink:'',
			}
		},
		props:{
			rightAct:String,
			title:String,
			fixedTrue: {
				type: Boolean,
				default: false
			},
		},
		computed:{
			rightActJson(){
				if(!!this.rightAct)return JSON.parse(this.rightAct);
			},
		},
		watch: {
			'$route'(to,from) {
				this.fromLink = from;
			},
		},
		methods:{
			goback () {
				if(this.$route.name=='index' || this.$route.name=='Help'){
					Android.closeActivity();//返回安卓上一页
				}else if(this.$route.name=='logForm' || this.$route.name=='LogDetail'){
					this.$store.dispatch('openLoading')
					this.$router.push('/');
				}else if(this.$route.name=='editForm'){
					this.$store.dispatch('openLoading')
					this.$router.push('logDetail');
				}else {
					this.$store.dispatch('openLoading')
					this.$router.isBack=true;
					this.$router.go(-1);
				}
			},
		}
	}
</script>
<style scoped="scoped">
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
</style>