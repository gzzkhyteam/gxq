<template>
	<div class="main">
		<top-bar style="z-index:10000" title="帮助"></top-bar>
		<mu-container ref="container">
			<mu-load-more v-if="helps.length!=0" @refresh="refresh()" :loaded-all="loadedAll" :refreshing="refreshing" loading-text="正在加载" :loading="loading" @load="loadFuc">
				<mu-list>
					<mu-list-item v-if="help.status!=1" button v-for="(help,index) of helps" :key='index' @click="goHelpView(help)">
						<mu-list-item-title>{{help.title}}</mu-list-item-title>
						<mu-list-item-action>
							<mu-icon value="keyboard_arrow_right"></mu-icon>
						</mu-list-item-action>
					</mu-list-item>
				</mu-list>
			</mu-load-more>
			<nullModal v-if="onContent"></nullModal>
			<p class="noContent" v-if="loadedAll">没有数据了</p>
		</mu-container>
	</div>
</template>

<script>
	import topBar from '@/components/topBar'
	import ApiList from '@/api/apiList'
	import api from '@/api/axiosApi'
	import { mapMutations } from 'vuex'
	import nullModal from '@/components/nullModal';
	export default {
		data() {
			return {
				refreshing: false,
				loading: false,
				loadedAll:false,
				pages:0,
				openApiReq: {
					data: {
						userId: 1
					},
					pageNo: 1,
					pageSize: 100
				},
        helps: [],
        onContent:false
			}
		},
		mounted(){
			this.$store.dispatch('closeLoading', false);
		},
		methods: {
			goHelpView(help) {
				this.$store.dispatch('openLoading')
				this.$router.push({
					name: 'HelpView',
					params: {
						help: help
					}
				})
			},
			getHelps(status) {
				var _self = this;
				this.loadedAll = false;
				api(ApiList.helpList, this.openApiReq).then((res) => {
					if(res.data["errcode"] == 0) {
						if(!!res.data.data.list){
							if(status == 1){
								this.helps = res.data.data.list;
							}else if(status == 2){
								this.helps = this.helps.concat(res.data.data.list);
              }
              if(this.helps.length === 0){
                this.onContent = true
              }
							this.pages = res.data.data.pages;
						}
					}else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
						this.getHelps(1);
					}
					this.loading = false;
					this.refreshing = false;
				}, (error) => {
          this.onContent = true
        });
			},
			refresh() {//下拉刷新
        this.refreshing = true;
        this.onContent = false;
				this.openApiReq.pageNo = 1;
				this.$refs.container.scrollTop = 0;
				setTimeout(() => {
					this.getHelps(1);
				}, 1000)
			},
			loadFuc(){
					if(document.documentElement.scrollTop == 0){
							if((document.body.scrollTop + document.documentElement.scrollHeight + 100) >= document.body.scrollHeight){
									console.log("进来");
									this.load();
							}
					}else{
							this.load();
					}
			},
			load() {//滚动无限加载
				if(this.openApiReq.pageNo < this.pages){
					this.openApiReq.pageNo++;
				}else{
					this.loadedAll = true;
					return ;
				}
				this.loading = true;
				setTimeout(() => {
					this.getHelps(2);
				}, 1000)
			},
			...mapMutations([
				'setMsg'
			])
		},
		components: {
			topBar,
			nullModal
		},
		created() {
			this.getHelps(1);
		}
	}
</script>

<style lang="less" scoped="scoped">
	.mu-list {
		li {
			background: #fff;
		}
		li:not(:first-child) {
			margin-top: 22px;
		}
	}
</style>