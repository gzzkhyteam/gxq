<template>
	<Layout>
		<hengyun-header logoClass="logo-email"></hengyun-header>
		<Layout class="ivu-layout-has-sider">
			<hengyun-sidebar :menus="menus" />
			<router-view v-if="isRouterAlive"></router-view>
		</Layout>
	</Layout>
</template>
<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import emailApi from '@/api/emailApi'
	import { mapState,mapActions,mapMutations } from 'vuex'
	// 头部
	import header from '@/components/hengyun/header'
	// 侧边栏
	import siderBar from '@/components/hengyun/sideBar'
	export default {
		components: {
			'hengyun-sidebar': siderBar,
			'hengyun-header': header
		},
		provide() {
			return {
				reload: this.reload
			}
		},
		data() {
			return {
				isRouterAlive: true,
				isCollapsed: false,
			}
		},
		computed: {
			rotateIcon() {
				return [
					'menu-icon',
					this.isCollapsed ? 'rotate-icon' : ''
				]
			},
			menuitemClasses() {
				return [
					'menu-item',
					this.isCollapsed ? 'collapsed-menu' : ''
				]
			},
			...mapState(['userInfo','menus','folderList'])
		},
		mounted() {
			this.sostomfileFindStore();
			this.getEmailMenu();
			this.$Message.config({
				duration: 3,
				top: 100
			})
		},
		methods: {
			reload() {
				this.isRouterAlive = false;
				this.$nextTick(function() {
					this.isRouterAlive = true;
				})
			},
			getEmailMenu() {
				const vm = this

				function buildMenu(data) {
					let arr = []
					data.forEach(function(item, index) {
						var obj = {
							name: item.name,
							link: item.url,
							icon: item.icon,
							subMenu: item.children ? buildMenu(item.children) : null
						}
						arr.push(obj)
					})
					return arr
				}
				api(apiList.getOperateMenu, {
					userId: vm.userInfo.userId,
					group: 'DEFAULT'
				}).then((res) => {
					if(res.status == 200) {
						/*let data = [
						{"id":"1176179314369","parentId":"-1","children":null,"name":"写邮件","url":"/write/send/EMAIL/-1","icon":"icon-write","code":"MAIL_SEND","type":1,"target":"_self","orderNo":1,"group":"DEFAULT","publicIs":"true"},
						{"id":"1307645579009","parentId":"-1","children":null,"name":"收件箱","url":"/received","icon":"icon-email","code":"MAIL_INBOX","type":1,"target":"_self","orderNo":2,"group":"DEFAULT","publicIs":"true"},
						{"id":"1467201097505","parentId":"-1","children":null,"name":"异常邮件","url":"/exception","icon":"icon-exception","code":"MAIL_ABNORMAL","type":1,"target":"_self","orderNo":3,"group":"DEFAULT","publicIs":"true"},
						{"id":"1571534409537","parentId":"-1","children":null,"name":"病毒邮件","url":"/virus","icon":"icon-virus","code":"MAIL_VIRUSES","type":1,"target":"_self","orderNo":4,"group":"DEFAULT","publicIs":"true"},
						{"id":"1571534409538","parentId":"-1","children":null,"name":"垃圾邮件","url":"/dustbin","icon":"icon-dustbin","code":"MAIL_SPAM","type":1,"target":"_self","orderNo":5,"group":"DEFAULT","publicIs":"true"},
						{"id":"1663993646945","parentId":"-1","children":null,"name":"草稿箱","url":"/drafts","icon":"icon-drafts","code":"MAIL_DRAFT","type":1,"target":"_self","orderNo":5,"group":"DEFAULT","publicIs":"true"},
						{"id":"1765361586049","parentId":"-1","children":null,"name":"已发送","url":"/send","icon":"icon-send","code":"MAIL_SENDED","type":1,"target":"_self","orderNo":6,"group":"DEFAULT","publicIs":"true"},
						{"id":"1854402465697","parentId":"-1","children":null,"name":"回收站","url":"/trash","icon":"icon-trash","code":"MAIL_DELETE","type":1,"target":"_self","orderNo":7,"group":"DEFAULT","publicIs":"true"},
						{"id":"1951655792577","parentId":"-1","children":null,"name":"自定义文件夹","url":"","icon":"icon-folder","code":"MAIL_OTHER","type":1,"target":"_self","orderNo":8,"group":"DEFAULT","publicIs":"true"},
						{"id":"2077933703137","parentId":"-1","children":null,"name":"设置","url":"/setting","icon":"icon-setting","code":"MAIL_SETTINGS","type":1,"target":"_self","orderNo":9,"group":"DEFAULT","publicIs":"true"}];
						*/
						let data = res.data.data;
						if(data){
							for(let i in data){
								data[i].link = data[i].url;
								if(data[i].code=="MAIL_OTHER"){
									let subMenu = [];
									for(let n in vm.folderList){
										let subObj = {};
										let folderName = encodeURIComponent(vm.folderList[n].fileName);
										subObj.name = vm.folderList[n].fileName;
										subObj.countSum  = vm.folderList[n].countSum;
										subObj.link = '/folder/'+vm.folderList[n].fileMark+'/'+folderName;
										subMenu.push(subObj);
									};
									data[i].subMenu = subMenu;
								}
							}
						}
						vm.GETMENUS(data);
						vm.sostomfileFindAll();
					}
				})
			},
			collapsedSider() {
				this.$refs.side1.toggleCollapse()
			},
			...mapActions([
		      'sostomfileFindAll',
		      'sostomfileFindStore'
		    ]),
			...mapMutations([
				'GETMENUS'
			])
		},
		watch: {
			folderList: {
				handler: function(val, oldVal) {
					this.getEmailMenu();
				},
				deep: true
			},
		},
	}
</script>

<style  type="text/css">
	html, body, #app, .ivu-layout {
	    height: 100%;
	    min-height: auto;
	}
	::-webkit-scrollbar,body::-webkit-scrollbar{
		width: 5px;
		height: 5px;
	}
	
	/*定义滚动条轨道 内阴影+圆角*/
	::-webkit-scrollbar-track,body::-webkit-scrollbar-track{
		-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
		border-radius: 10px;
		background-color: #eee;
	}
	
	/*定义滑块 内阴影+圆角*/
	::-webkit-scrollbar-thumb,body::-webkit-scrollbar-thumb	{
		border-radius: 10px;
		-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
		background-color: #999;
	}
</style>