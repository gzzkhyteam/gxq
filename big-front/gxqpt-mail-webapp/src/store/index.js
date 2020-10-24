/* eslint-disable */
import Vue from 'vue'
import Vuex from 'vuex'
import ApiList from '@/api/comApiList'
import api from '@/api/axiosApi'
import emailApi from '@/api/emailApi'
Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		alertText: '',
		isAlert: false,
		dataDictionary: {
			dbTypes: { //数据库类型（1 mysql，2 oracle，3 sqlserver，4 mongodb，5 hbase）
				1: 'mysql',
				2: 'oracle',
				3: 'sqlserver',
				4: 'mongodb',
				5: 'hbase'
			}
		},
		authButton: [],
		systemArray: [], //操作系统列表
		netScopeArray: [],//所属网络列表
		logoutUrl: '/gxqpt-center/admin/index', //退出登陆链接
		menus:[],//目录列表
		folderList:[],//自定义文件夹列表
	},
	mutations: {
		GETUSERINFO(state) {
			//解析所有的token到此store下面。
			state.userInfo = loginController.getCurProjectLoginUserInfon();
			state.userInfo.userId = state.userInfo.userid;
			if(state.userInfo.account){
			  if(state.userInfo.account.indexOf('@') >= 0){
			    state.userInfo.account = state.userInfo.account.split('@')[0]
			  }
			}
		},
		GETAUTHBUTTON(state,params){
			state.authButton = params;
		},
		CZXTFINDBYCODE(state, params) {
			state.systemArray = params;
		},
		SSWLFINDBYCODE(state, params) { 
			state.netScopeArray = params;
		},
		GETMENUS(state, params) {
			state.menus = params;
		},
		GETFOLDER(state, params) {
			state.folderList = params;
		},
	},
	actions: {
		getAuthButton({ commit, state }, resourceId) {//获取后端权限接口数据
			var arr = [];
			if (!sessionStorage._token) {
				api(ApiList.getOperateButton, {
					resourceId: resourceId,
					// userId: JSON.parse(sessionStorage._token).userid
					userId: state.userInfo.userId//本地测试
				}).then((res) => {
					if (res.data.errcode == 0) {
						res.data.data.forEach(function (item) {
							arr.push(item.code);
						})
						commit("GETAUTHBUTTON", arr);
					} else {
						console.log(res.data.errmsg)
					}
				})
			}
		},
		sostomfileFindAll({ commit }) { //查询目录及对应邮件数量
			let _this = this;
			api(emailApi.sostomfileFindAll).then((res) => {
				if(res.status == 200 && res.data.errmsg == "ok") {
					let data = res.data.data;
					let navArray = [];
					for(let i in _this.state.menus) {//循环用户拥有权限的菜单数组
						let obj = {};
						obj.name = _this.state.menus[i].name;
						obj.icon = _this.state.menus[i].icon?_this.state.menus[i].icon:"icon-default";
						obj.subMenu = _this.state.menus[i].subMenu;
						obj.link = _this.state.menus[i].link;
						for(let j in data){//循环文件夹邮件数量的数组
							if(data[j].fileName==_this.state.menus[i].name){
								obj.countSum = data[j].countSum;
								if(obj.subMenu){//如果用户权限的菜单存在子菜单
									for(let x in obj.subMenu){//循环用户拥有权限的菜单项的子菜单
										for(let y in data[j].costomFIle){//循环文件夹邮件数量数组项中的子菜单
											if(obj.subMenu[x].name==data[j].costomFIle[y].fileName){
												obj.subMenu[x].countSum=data[j].costomFIle[y].countSum;
											}
										}
									}
								}
							}
						};
						navArray.push(obj);
					};
					commit("GETMENUS", navArray);
				}
			}, (err) => {})
		},
		sostomfileFindStore({ commit }) { //查询自定义文件夹
			let _this = this;
			api(emailApi.sostomfileFind).then((res) => {
				if(res.status == 200 && res.data.errmsg == "ok") {
					commit("GETFOLDER", res.data.data);
				}
			}, (err) => {})
		},
	},
	modules: {}
})

export default store