<template>
	<Layout>
		<hengyun-header :title="{chinese: '安全保障平台', english: 'Safety Secure Platform'}"></hengyun-header>
		<Layout class="ivu-layout-has-sider"  v-if="menus.length > 0">
			<hengyun-sidebar :menus="menus" />
			<router-view v-if="isRouterAlive"></router-view>
		</Layout>
	</Layout>
</template>
<script>
	import api from '@/api/axiosApi'
	import apiList from '@/api/comApiList'
	import { mapState,mapActions } from 'vuex'
	// 头部
	import header from '@/components/hengyun/header'
	// 侧边栏
	import siderBar from '@/components/hengyun/sideBar'
	// const menus = [{
	// 	name: '接口权限',
	// 	link: '/interfacePermission',
	// }, {
	// 	name: '备份监控',
	// 	subMenu: [{
	// 		name: '备份设置',
	// 		link: '/backupSetting'
	// 	}, {
	// 		name: '备份监控',
	// 		link: '/backupMonitor'
	// 	}]
	// }, {
	// 	name: '服务器监控',
	// 	subMenu: [{
	// 		name: '服务器访问监控',
	// 		link: '/serverAccessMonitor'
	// 	}, {
	// 		name: '进程监控',
	// 		link: '/processMonitor'
	// 	}, {
	// 		name: '服务监控',
	// 		link: '/serverMonitor'
	// 	}]
	// }, {
	// 	name: '程序发布管理',
	// 	link: '/programRelease',
	// }, {
	// 	name: '系统安全评测',
	// 	link: '/systemSafetyEvaluation',
	// }]
	export default {
		components: {
			'hengyun-sidebar': siderBar,
			'hengyun-header': header
		},
		data() {
			return {
				isRouterAlive: true,
				isCollapsed: false,
				menus: []
			}
		},
		provide() {
			return {
				reload: this.reload
			}
		},
		computed: {
			rotateIcon() {
				return [
					'menu-icon',
					this.isCollapsed ? 'rotate-icon' : ''
				];
			},
			menuitemClasses() {
				return [
					'menu-item',
					this.isCollapsed ? 'collapsed-menu' : ''
				]
			},
			...mapState([
				'userInfo',
			])
		},
		mounted() {
    	this.$store.dispatch('getAuthButton')
			this.getOperateMenu();
			this.FindAppVisibleForSelf();
		},
		methods: {
			reload() {
				this.isRouterAlive = false;
				this.$nextTick(function() {
					this.isRouterAlive = true;
				})
			},
			getOperateMenu() {
				function buildMenu(data) {
					var arr = [];
					data.forEach(function(item, index) {
						var obj = {
							name: item.name,
							link: item.url,
							icon: item.icon,
							subMenu: item.children ? buildMenu(item.children) : null
						}
						arr.push(obj);
					})
					return arr;
				}
				api(apiList.getOperateMenu, {
					userId: this.userInfo.userId,
					group: ''
				}).then((res) => {
					if(res.status == 200) {
						this.menus = buildMenu(res.data.data)
						if (this.menus.length > 0) {
							var obj = {}
							if(this.menus[0].subMenu && this.menus[0].subMenu.length) {
								obj = this.menus[0].subMenu[0]
							} else {
								obj = this.menus[0]
							}
							if(this.$route.matched && this.$route.matched.length === 0) {//当登陆调转时自动跳到一级菜单的一级目录
								this.$router.push({
									path: obj.link
								})
							}
						}
					}
				})
			},
			collapsedSider() {
				this.$refs.side1.toggleCollapse();
			},
			...mapActions([
				'FindAppVisibleForSelf',
			])
		},
	}
</script>