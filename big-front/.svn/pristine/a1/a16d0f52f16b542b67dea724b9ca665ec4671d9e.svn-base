/* 安全保障平台 */

// import Vue from 'vue'
// import Router from 'vue-router'
import store from '@/store'
// import interfacePermission from '@/view/security/interfacePermission'// 接口权限
// import interfaceMonitor from '@/view/security/interfaceMonitor'// 接口监控
// import backupSetting from '@/view/security/backupSetting'// 备份设置
// import backupMonitor from '@/view/security/backupMonitor'// 备份监控
// import serverAccessMonitor from '@/view/security/serverAccessMonitor'// 服务器访问监控
// import processMonitor from '@/view/security/processMonitor'// 进程监控
// import serverMonitor from '@/view/security/serverMonitor'// 服务监控
// import programRelease from '@/view/security/programRelease/list'// 程序发布
// import programReleaseCreate from '@/view/security/programRelease/create'// 程序发布新增
// import programReleaseView from '@/view/security/programRelease/view'// 程序发布详情
// import systemSafetyEvaluation from '@/view/security/systemSafetyEvaluation'// 系统安全评测

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    { // 首页
      path: '/home',
      name: 'home',
      component: resolve => require(['@/view/security/home'], resolve)
    },
    { // 安全保障体系-文档查询 以及 运维文档管理,manage为1时是管理
      path: '/docQuery/:manage',
      name: 'docQuery',
      component: resolve => require(['@/view/security/docManager/docQuery'], resolve)
    },
    {
      path: '/interfacePermission',
      name: 'interfacePermission',
      component: resolve => require(['@/view/security/interfacePermission'], resolve),
    },
    {
      path: '/interfaceMonitor',
      name: 'interfaceMonitor',
      component: resolve => require(['@/view/security/interfaceMonitor'], resolve),
    },
    {
      path: '/backupSetting',
      name: 'backupSetting',
      component: resolve => require(['@/view/security/backupSetting'], resolve),
    },
    {
      path: '/backupMonitor',
      name: 'backupMonitor',
      component: resolve => require(['@/view/security/backupMonitor'], resolve),
    },
    {
      path: '/serverAccessMonitor',
      name: 'serverAccessMonitor',
      component: resolve => require(['@/view/security/serverAccessMonitor'], resolve),
    },
    {
      path: '/processMonitor',
      name: 'processMonitor',
      component: resolve => require(['@/view/security/processMonitor'], resolve),
    },
    {
      path: '/serverMonitor',
      name: 'serverMonitor',
      component: resolve => require(['@/view/security/serverMonitor'], resolve),
    },
    {
      path: '/programRelease',
      name: 'programRelease',
      component: resolve => require(['@/view/security/programRelease/list'], resolve),
    },
    {
      path: '/programRelease/create',
      name: 'programReleaseCreate',
      component: resolve => require(['@/view/security/programRelease/create'], resolve),
    },
    {
      path: '/programRelease/:id',
      name: 'programReleaseView',
      component: resolve => require(['@/view/security/programRelease/view'], resolve),
    },
    {
      path: '/systemSafetyEvaluation',
      name: 'systemSafetyEvaluation',
      component: resolve => require(['@/view/security/systemSafetyEvaluation'], resolve),
    },
    {
      path: '',
      redirect: '/home'
    }
  ]
})

router.beforeEach((to,from,next) =>{
	hy_auth_login('security')//登陆验证
  store.commit('GETUSERINFO');//设置用户信息
  // store.dispatch('getAuthButton',to.query.resourceId);//获取权限按钮
	next();
})


export default router;