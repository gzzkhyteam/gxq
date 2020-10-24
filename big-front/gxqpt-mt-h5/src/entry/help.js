// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// import Vue from 'vue'
// import VueRouter from 'vue-router'
import helpApp from './helpApp'
import store from '@/store'
import router from '@/router/helpRouter'
import Toast from 'muse-ui-toast';

import VueScroller from 'vue-scroller'
import '@/assets/css/com.css';
// import '@/assets/util/vconsole.js'; //移动端调试debug工具

import 'muse-ui/lib/styles/base.less';
import {
    Alert,
    AppBar,
    Avatar,
    Button,
    Dialog,
    Form,
    Grid,
    Icon,
    List,
    LoadMore,
    Paper,
    Progress,
    Snackbar,
    TextField,

    theme
} from 'muse-ui';
import 'muse-ui/lib/styles/theme.less';

Vue.use(Alert);
Vue.use(AppBar);
Vue.use(Avatar);
Vue.use(Button);
Vue.use(Dialog);
Vue.use(Form);
Vue.use(Grid);
Vue.use(Icon);
Vue.use(List);
Vue.use(LoadMore);
Vue.use(Paper);
Vue.use(Progress);
Vue.use(Snackbar);
Vue.use(TextField);

import Loading from '@/components/loading/Loading.vue'
import Alerts from '@/components/Alert/Alerts.vue'
// 加载状态
import 'muse-ui-loading/dist/muse-ui-loading.css'; // load css
Vue.component('Loading', Loading)
Vue.component('Alerts', Alerts)
Vue.use(Toast);

import VueTextareaAutosize from 'vue-textarea-autosize'
Vue.use(VueTextareaAutosize)


Vue.use(VueRouter);
Vue.use(VueScroller);
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
    el: '#help',
    router,
    store,
    components: { helpApp },
    template: '<helpApp/>'
})
router.afterEach((to, from, next) => {//切换前默认置顶
    window.scrollTo(0, 0);
});
// 全局路由守卫
router.beforeEach((to, from, next) => {
    // to: Route: 即将要进入的目标 路由对象
    // from: Route: 当前导航正要离开的路由
    // next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
    // A跳转到B，B页面停留在A页面的滚动位置；解决方法：将scrollTop设置为0
    next();
});
