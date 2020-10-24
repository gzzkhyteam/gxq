// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router'
import router from '@/router/attendanceRouter'
import attendanceApp from './attendanceApp'
import store from '@/store'
import '@/assets/css/com.css';
// import '@/assets/util/vconsole.js'; //移动端调试debug工具

// import MuseUI from 'muse-ui';
// import 'muse-ui/dist/muse-ui.css';
// Vue.use(MuseUI);

import 'muse-ui/lib/styles/base.less';
import {
    Alert,
    AppBar,
    // AutoComplete,
    Avatar,
    // Badge,
    // BottomNav,
    BottomSheet,
    // Breadcrumbs,
    Button,
    Card,
    Checkbox,
    // Chip,
    DateInput,
    DataTable,
    Dialog,
    Divider,
    // Drawer,
    // ExpansionPanel,
    Form,
    Grid,
    // GridList,
    Helpers,
    Icon,
    List,
    LoadMore,
    Menu,
    Pagination,
    Paper,
    // Picker,
    // Popover,
    Progress,
    // Radio,
    // Select,
    SlidePicker,
    // Slider,
    Snackbar,
    // Stepper,
    SubHeader,
    Switch,
    Tabs,
    TextField,
    // Tooltip,
    theme
} from 'muse-ui';
import 'muse-ui/lib/styles/theme.less';

Vue.use(Alert);
Vue.use(AppBar);
// Vue.use(AutoComplete);
Vue.use(Avatar);
// Vue.use(Badge);
// Vue.use(BottomNav);
Vue.use(BottomSheet);
// Vue.use(Breadcrumbs);
Vue.use(Button);
Vue.use(Card);
Vue.use(Checkbox);
// Vue.use(Chip);
Vue.use(DateInput);
Vue.use(DataTable);
Vue.use(Dialog);
Vue.use(Divider);
// Vue.use(Drawer);
// Vue.use(ExpansionPanel);
Vue.use(Form);
Vue.use(Grid);
// Vue.use(GridList);
Vue.use(Helpers);
Vue.use(Icon);
Vue.use(List);
Vue.use(LoadMore);
Vue.use(Menu);
Vue.use(Pagination);
Vue.use(Paper);
// Vue.use(Picker);
// Vue.use(Popover);
Vue.use(Progress);
// Vue.use(Radio);
// Vue.use(Select);
Vue.use(SlidePicker);
// Vue.use(Slider);
Vue.use(Snackbar);
// Vue.use(Stepper);
Vue.use(SubHeader);
Vue.use(Switch);
Vue.use(Tabs);
Vue.use(TextField);
// Vue.use(Tooltip);

// import Mint from 'mint-ui';
// Vue.use(Mint);
import { Picker, Popup } from 'mint-ui'; //单独引入mint的部分组件
import 'mint-ui/lib/picker/style.css';
import 'mint-ui/lib/popup/style.css';
Vue.component(Picker.name, Picker);
Vue.component(Popup.name, Popup);

// import Loading from 'muse-ui-loading';
// Vue.use(Loading);

import Loading from '@/components/loading/Loading.vue'
import Alerts from '@/components/Alert/Alerts.vue'
// 加载状态
import 'muse-ui-loading/dist/muse-ui-loading.css'; // load css
Vue.component('Loading', Loading)
Vue.component('Alerts', Alerts)

import VueTextareaAutosize from 'vue-textarea-autosize'
Vue.use(VueTextareaAutosize)

Vue.use(VueRouter);
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
    el: '#attendance',
    router,
    store,
    components: { attendanceApp },
    template: '<attendanceApp/>'
})
router.afterEach((to, from, next) => {//切换前默认置顶
    var overlay = document.getElementsByClassName("mu-overlay");
    var bottomSheet = document.getElementsByClassName("mu-bottom-sheet");
    if (overlay.length != 0) overlay[0].className += " mu-fade-transition-leave-active mu-fade-transition-leave-to";
    if (bottomSheet.length != 0) bottomSheet[0].className += " mu-fade-transition-leave-active mu-fade-transition-leave-to";
    if (to.name != 'getTreeEmpPhoneByUserIdItem'){
        console.log("置顶");
        window.scrollTo(0, 0);
    }
});
// 全局路由守卫
router.beforeEach((to, from, next) => {
    // to: Route: 即将要进入的目标 路由对象
    // from: Route: 当前导航正要离开的路由
    // next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
    // A跳转到B，B页面停留在A页面的滚动位置；解决方法：将scrollTop设置为0
    next();
});
