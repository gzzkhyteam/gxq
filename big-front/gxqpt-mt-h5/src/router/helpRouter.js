// import Vue from 'vue'
// import VueRouter from 'vue-router'
// 帮助
import Help from '@/view/help/Help'
import HelpView from '@/view/help/HelpView'

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        {//帮助
            path: '/',
            name: 'Help',
            component: Help
        },
        {//帮助详情
            path: '/helpView',
            name: 'HelpView',
            component: HelpView
        },
    ]
})
