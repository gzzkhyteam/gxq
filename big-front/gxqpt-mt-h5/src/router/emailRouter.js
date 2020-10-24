
// 考勤
import { resolve } from 'path';
// import Vue from 'vue'
// import VueRouter from 'vue-router'

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        {//收件箱
            path: '/',
            name: 'Inbox',
            component: resolve => require(['@/view/email/Inbox'], resolve),
            meta: {
                keepAlive: false
            },
        },
        {//发件箱
            path: '/outbox',
            name: 'Outbox',
            component: resolve => require(['@/view/email/Outbox'], resolve),
            meta: {
                keepAlive: false
            },
        },
        {//搜索列表（顶部搜索栏）
            path: '/emailSearch',
            name: 'EmailSearch',
            component: resolve => require(['@/view/email/EmailSearch'], resolve),
            meta: {
                keepAlive: false
            },
        },
        {//邮件详情
            path: '/emailDetail',
            name: 'EmailDetail',
            component: resolve => require(['@/view/email/EmailDetail'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//写邮件/回复邮件/转发邮件
            path: '/emailModal',
            name: 'EmailModal',
            component: resolve => require(['@/view/email/EmailModal'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//抄送人
            path: '/GetTreeEmpPhoneByUserIdItem',
            name: 'getTreeEmpPhoneByUserIdItem',
            component: resolve => require(['@/view/email/GetTreeEmpPhoneByUserIdItem'], resolve),
        },
    ]
})
