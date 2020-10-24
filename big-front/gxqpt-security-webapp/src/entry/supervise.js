// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// import Vue from 'vue'
import store from '@/store'
import iview from 'iview'
import echarts from 'echarts'
import 'echarts-gl'
import SuperviseApp from './SuperviseApp'
import router from '@/router/supervise'
import '@/directive'// 使用全局指令
import '@/filter'// 使用全局过滤器
import 'iview/dist/styles/iview.css'// 使用iview样式
import '@/assets/css/iconfont.css'// 使用全局样式
import '!style-loader!css-loader!less-loader!@/assets/css/com.less'// 使用全局样式
// import '@static/ueditor/ueditor.config.js'
// import '@static/ueditor/ueditor.all.min.js'
// import '@static/ueditor/lang/zh-cn/zh-cn.js'
// import '@static/ueditor/ueditor.parse.min.js'
import '@static/echart/echarts-wordcloud.min.js'
import hyTable from '@/components/hengyun/table'

// 手动引入 ECharts 各模块来减小打包体积
import 'echarts/lib/chart/bar'
import 'echarts/lib/component/tooltip'

Vue.use(iview)
Vue.use(hyTable)
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#apps',
  router,
  store,
  components: { SuperviseApp },
  template: '<SuperviseApp />'
})
