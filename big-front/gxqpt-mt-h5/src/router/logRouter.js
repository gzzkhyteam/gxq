// import Vue from 'vue'
// import VueRouter from 'vue-router'
// 日志
import Index from '@/view/log/index'
import LogForm from '@/view/log/LogForm'
import EditForm from '@/view/log/EditForm'
import LogDetail from '@/view/log/LogDetail'
import LogRead from '@/view/log/LogRead'
import GetTreeEmpPhoneByUserId from '@/view/log/GetTreeEmpPhoneByUserId'
import GetTreeEmpPhoneByUserIdItem from '@/view/log/GetTreeEmpPhoneByUserIdItem'

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        {//主页-我的日志
            path: '/',
            name: 'index',
            component: Index,
            meta: {
                keepAlive: false
            },
            children: [
                {//主页-我的日志
                    path: '/logList',
                    name: 'logList',
                    component: Index,
                    meta: {
                        keepAlive: true
                    }
                },
            ]
        },
        {//写日志
            path: '/logForm',
            name: 'logForm',
            component: LogForm,
            meta: {
                keepAlive: true
            }
        },
        {//编辑日志
            path: '/editForm',
            name: 'editForm',
            component: EditForm,
            meta: {
                keepAlive: true
            }
        },
        {//日志详情
            path: '/logDetail',
            name: 'LogDetail',
            component: LogDetail,
            meta: {
                keepAlive: true
            }
        },
        {//审批详情
            path: '/logRead',
            name: 'LogRead',
            component: LogRead
        },
        {//部门
            path: '/getTreeEmpPhoneByUserId',
            name: 'getTreeEmpPhoneByUserId',
            component: GetTreeEmpPhoneByUserId
        },
        {//抄送人
            path: '/getTreeEmpPhoneByUserIdItem',
            name: 'getTreeEmpPhoneByUserIdItem',
            component: GetTreeEmpPhoneByUserIdItem
        },
    ]
})
