/* 统一监管平台 */
// import Vue from 'vue'
// import Router from 'vue-router'
import store from '@/store'
// import unitWarnAnalyze from '@/view/supervise/unitWarnAnalyze'// 单位预警分析
// import unitWarnAnalyzeView from '@/view/supervise/unitWarnAnalyzeView'// 单位预警分析详情
// import departmentWarnAnalyzeView from '@/view/supervise/departmentWarnAnalyzeView'// 部门预警分析详情
// import departmentWarnAnalyze from '@/view/supervise/departmentWarnAnalyze'// 部门预警分析
// import personnelAnalyze from '@/view/supervise/personnelAnalyze'// 人员预警分析
// import departmentPersonAnalyze from '@/view/supervise/departmentPersonAnalyze'// 自己部门人员预警分析
// import departPersonnelAnalyze from '@/view/supervise/departPersonnelAnalyze'// 部门人员预警分析
// import personnelAnalyzeView from '@/view/supervise/personnelAnalyzeView'// 人员预警分析详情
// import earlyWarning from '@/view/supervise/earlyWarning'// 预警台账
// import earlyWarningDeal from '@/view/supervise/earlyWarningDeal'// 预警处理台账
// import earlyWarningResult from '@/view/supervise/earlyWarningResult'// 预警处理结果台账
// import leaderCockpit from '@/view/supervise/leaderCockpit'// 领导驾驶舱
// import applicationWarnAnalyze from '@/view/supervise/applicationWarnAnalyze'// 应用预警分析
// import applicationWarnAnalyzeView from '@/view/supervise/applicationWarnAnalyzeView'// 应用预警分析详情

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    {
      path: '/unitWarnAnalyze',
      name: 'unitWarnAnalyze',
      component: resolve => require(['@/view/supervise/unitWarnAnalyze'], resolve),
    },
    {
      path: '/unitWarnAnalyzeView/:id',
      name: 'unitWarnAnalyzeView',
      component: resolve => require(['@/view/supervise/unitWarnAnalyzeView'], resolve),
    },
    {
      path: '/departmentWarnAnalyzeView/:id',
      name: 'departmentWarnAnalyzeView',
      component: resolve => require(['@/view/supervise/departmentWarnAnalyzeView'], resolve),
    },
    {
      path: '/personnelAnalyze',
      name: 'personnelAnalyze',
      component: resolve => require(['@/view/supervise/personnelAnalyze'], resolve),
    },
    {
      path: '/departmentPersonAnalyze',
      name: 'departmentPersonAnalyze',
      component: resolve => require(['@/view/supervise/departmentPersonAnalyze'], resolve),
    },
    {
      path: '/departPersonnelAnalyze',
      name: 'departPersonnelAnalyze',
      component: resolve => require(['@/view/supervise/departPersonnelAnalyze'], resolve),
    },
    {
      path: '/personnelAnalyzeView/:id/:dpmId',
      name: 'personnelAnalyzeView',
      component: resolve => require(['@/view/supervise/personnelAnalyzeView'], resolve),
    },
    {
      path: '/earlyWarning',
      name: 'earlyWarning',
      component: resolve => require(['@/view/supervise/earlyWarning'], resolve),
    },
    {
      path: '/earlyWarningDeal',
      name: 'earlyWarningDeal',
      component: resolve => require(['@/view/supervise/earlyWarningDeal'], resolve),
    },
    {
      path: '/earlyWarningResult',
      name: 'earlyWarningResult',
      component: resolve => require(['@/view/supervise/earlyWarningResult'], resolve),
    },
    {
      path: '/leaderCockpit',
      name: 'leaderCockpit',
      component: resolve => require(['@/view/supervise/leaderCockpit'], resolve),
    },
    {
      path: '/applicationWarnAnalyze',
      name: 'applicationWarnAnalyze',
      component: resolve => require(['@/view/supervise/applicationWarnAnalyze'], resolve),
    },
    { // 单个应用详情
      path: '/applicationWarnAnalyzeView/:id',
      name: 'applicationWarnAnalyzeView',
      component: resolve => require(['@/view/supervise/applicationWarnAnalyzeView'], resolve),
    },
    {
      path: '/departmentWarnAnalyze',
      name: 'departmentWarnAnalyze',
      component: resolve => require(['@/view/supervise/departmentWarnAnalyze'], resolve),
    },
    {//权责运行监管配置中心
      path: '/accrualAllocation',
      name: 'accrualAllocation',
      component: resolve => require(['@/view/supervise/accrualAllocation'], resolve),
    },
    {//环节配置
      path: '/linkConfiguration',
      name: 'linkConfiguration',
      component: resolve => require(['@/view/supervise/linkConfiguration'], resolve),
    },
    {//服务运行监管配置中心
      path: '/serverAllocation',
      name: 'serverAllocation',
      component: resolve => require(['@/view/supervise/serverAllocation'], resolve),
    },
    {//服务运行数据采集
      path: '/serverDataCollection',
      name: 'serverDataCollection',
      component: resolve => require(['@/view/supervise/serverDataCollection'], resolve),
    },
    {//业务应用运行监管配置中心
      path: '/businessApplication',
      name: 'businessApplication',
      component: resolve => require(['@/view/supervise/businessApplication'], resolve),
    },
    {// 业务应用运行数据采集
      path: '/appDataCollection',
      name: 'appDataCollection',
      component: resolve => require(['@/view/supervise/appDataCollection'], resolve),
    },
    {// 业务应用运行数据采集&服务运行数据采集-操作日志
      path: '/optLogs/:id/:type',
      name: 'optLogs',
      component: resolve => require(['@/view/supervise/optLogs'], resolve),
    },
    {//数据存储监管配置中心
      path: '/databaseStorageApplication',
      name: 'databaseStorageApplication',
      component: resolve => require(['@/view/supervise/databaseStorageApplication'], resolve),
    },
    {//数据存储监管配置中心历史数据
      path: '/databaseHistory/:id',
      name: 'databaseHistory',
      component: resolve => require(['@/view/supervise/databaseHistory'], resolve),
    },
    {//权责类型维护
      path: '/accrualTypeMaintain',
      name: 'accrualTypeMaintain',
      component: resolve => require(['@/view/supervise/accrualTypeMaintain'], resolve),
    },
    {//默认首页
      path: '',
      redirect: '/leaderCockpit'
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.matched.length === 0) {
    router.replace('/earlyWarning')
    next(false)
  }
  hy_auth_login('supervise') // 登陆验证
  store.commit('GETUSERINFO') // 设置用户信息
  // store.dispatch('getAuthButton', to.query.resourceId);//获取权限按钮
  next()
})

export default router
