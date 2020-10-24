// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import store from '@/store'
import iview from 'iview'
import echarts from 'echarts'
import EmailApp from './EmailApp'
import router from '@/router/email'
// import '@/directive'//使用全局指令
// import '@/filter'//使用全局过滤器
import 'iview/dist/styles/iview.css' // 使用iview样式
import '@/assets/css/iconfont.css' // 使用全局样式
import '!style-loader!css-loader!less-loader!@/assets/css/com.less' // 使用全局样式
import '@static/ueditor/ueditor.config.js'
import '@static/ueditor/ueditor.all.min.js'
import '@static/ueditor/lang/zh-cn/zh-cn.js'
import '@static/ueditor/ueditor.parse.min.js'
import '@static/Simple-Calendar'
// 表格
import hyTable from '@/components/hengyun/table'
// 评分
// import hyRate from '@/components/hengyun/rate'

import '@static/login/login.js' // 引入登陆模块

import VideoPlayer from 'vue-video-player'
require('video.js/dist/video-js.css')
require('vue-video-player/src/custom-theme.css')
Vue.use(VideoPlayer)

Vue.use(iview)
Vue.use(hyTable)
// Vue.use(hyRate)
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#email',
  router,
  store,
  components: { EmailApp },
  template: '<EmailApp />'
})
