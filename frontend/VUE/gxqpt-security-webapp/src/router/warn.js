/* 预警管理系统部分页面 */

import store from '@/store'

import home from '@/view/warn/home' // 首页
import departmentWarnAnalyzeView from '@/view/supervise/departmentWarnAnalyzeView'// 部门预警分析详情
import personnelAnalyzeView from '@/view/supervise/personnelAnalyzeView'// 人员预警分析详情
import applicationWarnAnalyze from '@/view/supervise/applicationWarnAnalyze'// 应用预警分析
import applicationWarnAnalyzeView from '@/view/supervise/applicationWarnAnalyzeView'// 应用预警分析详情
import ledgerList from '@/view/warn/ledger/list'// 预警台账
import ledgerDeal from '@/view/warn/ledger/deal'// 预警处理台账
import ledgerResult from '@/view/warn/ledger/result'// 预警处理结果台账
import ledgerMaintenance from '@/view/warn/ledger/maintenance'// 预警类型维护

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    {
      // 首页
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/departmentWarnAnalyzeView',
      name: 'departmentWarnAnalyzeView',
      component: departmentWarnAnalyzeView
    },
    {
      path: '/personnelAnalyzeView',
      name: 'personnelAnalyzeView',
      component: personnelAnalyzeView
    },
    {
      path: '/applicationWarnAnalyze',
      name: 'applicationWarnAnalyze',
      component: applicationWarnAnalyze
    },
    { // 单个应用详情
      // id: 应用id
      path: '/applicationWarnAnalyzeView/:id',
      name: 'applicationWarnAnalyzeView',
      component: applicationWarnAnalyzeView
    },
    { // 预警台账
      path: '/ledgerList',
      name: 'ledgerList',
      component: ledgerList
    },
    { // 预警处理台账
      path: '/ledgerDeal',
      name: 'ledgerDeal',
      component: ledgerDeal
    },
    { // 预警处理结果台账
      path: '/ledgerResult',
      name: 'ledgerResult',
      component: ledgerResult
    },
    { // 预警类型维护
      path: '/ledgerMaintenance',
      name: 'ledgerMaintenance',
      component: ledgerMaintenance
    }
  ]
})

router.beforeEach((to, from, next) => {
  hy_auth_login('supervise') // 登陆验证
  store.commit('GETUSERINFO') // 设置用户信息
  next()
})

export default router
