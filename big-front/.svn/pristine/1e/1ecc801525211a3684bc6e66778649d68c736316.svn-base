// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// import Vue from 'vue'
import store from '@/store'
import iview from 'iview'
import echarts from 'echarts'
import WarnApp from './WarnApp'
import router from '@/router/warn'
import 'echarts-gl'
import 'iview/dist/styles/iview.css'// 使用iview样式
import '@/assets/css/iconfont.css'// 使用全局样式
import '!style-loader!css-loader!less-loader!@/assets/css/com.less'// 使用全局样式

import '@static/login/login.js'// 引入登陆模块
import '@static/echart/echarts-wordcloud.min.js'
import hyTable from '@/components/hengyun/table'

Vue.use(iview)
Vue.use(hyTable)
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#warn',
  router,
  store,
  components: { WarnApp },
  template: '<WarnApp />'
})
