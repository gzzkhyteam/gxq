
// 考勤
import { resolve } from 'path';
// import Vue from 'vue'
// import VueRouter from 'vue-router'

Vue.use(VueRouter);

export default new VueRouter({
    routes: [
        {//我的考勤
            path: '/',
            name: 'MyAttendance',
            component: resolve => require(['@/view/attendance/MyAttendance'], resolve),
            meta: {
                keepAlive: false
            },
        },
        {//签到打卡
            path: '/sign',
            name: 'Sign',
            component: resolve => require(['@/view/attendance/Sign'], resolve),
        },
        {//外勤打卡
            path: '/fieldSign',
            name: 'FieldSign',
            component: resolve => require(['@/view/attendance/FieldSign'], resolve),
        },
        {//打卡记录
            path: '/clockInlist',
            name: 'ClockInList',
            component: resolve => require(['@/view/attendance/ClockInList'], resolve),
        },
        {//申请记录
            path: '/applyList',
            name: 'ApplyList',
            component: resolve => require(['@/view/attendance/ApplyList'], resolve),
            meta: {
                keepAlive: false
            },
        },
        {//记录详情
            path: '/applyDetail',
            name: 'ApplyDetail',
            component: resolve => require(['@/view/attendance/ApplyDetail'], resolve),
        },
        {//加班申请
            path: '/overtimeForm',
            name: 'OvertimeForm',
            component: resolve => require(['@/view/attendance/OvertimeForm'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//请假申请
            path: '/askLeave',
            name: 'AskLeave',
            component: resolve => require(['@/view/attendance/AskLeave'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//外勤申报
            path: '/fieldForm',
            name: 'FieldForm',
            component: resolve => require(['@/view/attendance/FieldForm'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//补签申请
            path: '/supplementSign',
            name: 'SupplementSign',
            component: resolve => require(['@/view/attendance/SupplementSign'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//我的审批
            path: '/myReview',
            name: 'MyReview',
            component: resolve => require(['@/view/attendance/MyReview'], resolve),
        },
        {//出差申请
            path: '/businessApply',
            name: 'businessApply',
            component: resolve => require(['@/view/attendance/BusinessApply'], resolve),
            meta: {
                keepAlive: true
            },
        },
        {//审批详情
            path: '/reviewDetail',
            name: 'ReviewDetail',
            component: resolve => require(['@/view/attendance/ReviewDetail'], resolve),
        },
        {//审批详情
            path: '/logRead',
            name: 'LogRead',
            component: resolve => require(['@/view/log/LogRead'], resolve),
        },
        {//消息公告
            path: '/MessageNotice',
            name: 'MessageNotice',
            component: resolve => require(['@/view/attendance/MessageNotice'], resolve),
        },
        {//消息公告详情
            path: '/MessageNoticeView',
            name: 'MessageNoticeView',
            component: resolve => require(['@/view/attendance/MessageNoticeView'], resolve),
        },
        {//通知公告
            path: '/Notice',
            name: 'Notice',
            component: resolve => require(['@/view/attendance/Notice'], resolve),
        },
        {//通知公告详情
            path: '/NoticeView',
            name: 'NoticeView',
            component: resolve => require(['@/view/attendance/NoticeView'], resolve),
        },
        // {//部门
        //     path: '/getTreeEmpPhoneByUserId',
        //     name: 'getTreeEmpPhoneByUserId',
        //     component: resolve => require(['@/view/attendance/GetTreeEmpPhoneByUserId'], resolve),
        // },
        {//抄送人
            path: '/GetTreeEmpPhoneByUserIdItem',
            name: 'getTreeEmpPhoneByUserIdItem',
            component: resolve => require(['@/view/attendance/GetTreeEmpPhoneByUserIdItem'], resolve),
        },
    ]
})



// // 考勤
// import MyAttendance from '@/view/attendance/MyAttendance'
// import Sign from '@/view/attendance/Sign'
// import FieldSign from '@/view/attendance/FieldSign'
// import ClockInList from '@/view/attendance/ClockInList'
// import ApplyList from '@/view/attendance/ApplyList'
// import ApplyDetail from '@/view/attendance/ApplyDetail'
// import OvertimeForm from '@/view/attendance/OvertimeForm'
// import AskLeave from '@/view/attendance/AskLeave'
// import FieldForm from '@/view/attendance/FieldForm'
// import SupplementSign from '@/view/attendance/SupplementSign'
// import MyReview from '@/view/attendance/MyReview'
// import BusinessApply from '@/view/attendance/BusinessApply'
// import ReviewDetail from '@/view/attendance/ReviewDetail'
// import LogRead from '@/view/log/LogRead'
// import MessageNotice from '@/view/attendance/MessageNotice'
// import MessageNoticeView from '@/view/attendance/MessageNoticeView'
// import GetTreeEmpPhoneByUserId from '@/view/attendance/GetTreeEmpPhoneByUserId'
// import GetTreeEmpPhoneByUserIdItem from '@/view/attendance/GetTreeEmpPhoneByUserIdItem'

// Vue.use(VueRouter);

// export default new VueRouter({
//     routes: [
//         {//我的考勤
//             path: '/',
//             name: 'MyAttendance',
//             component: MyAttendance,
//             meta: {
//                 keepAlive: false
//             },
//         },
//         {//签到打卡
//             path: '/sign',
//             name: 'Sign',
//             component: Sign
//         },
//         {//外勤打卡
//             path: '/fieldSign',
//             name: 'FieldSign',
//             component: FieldSign
//         },
//         {//打卡记录
//             path: '/clockInlist',
//             name: 'ClockInList',
//             component: ClockInList
//         },
//         {//申请记录
//             path: '/applyList',
//             name: 'ApplyList',
//             component: ApplyList
//         },
//         {//记录详情
//             path: '/applyDetail',
//             name: 'ApplyDetail',
//             component: ApplyDetail
//         },
//         {//加班申请
//             path: '/overtimeForm',
//             name: 'OvertimeForm',
//             component: OvertimeForm,
//             meta: {
//                 keepAlive: true
//             },
//         },
//         {//请假申请
//             path: '/askLeave',
//             name: 'AskLeave',
//             component: AskLeave,
//             meta: {
//                 keepAlive: true
//             },
//         },
//         {//外勤申报
//             path: '/fieldForm',
//             name: 'FieldForm',
//             component: FieldForm,
//             meta: {
//                 keepAlive: true
//             },
//         },
//         {//补签申请
//             path: '/supplementSign',
//             name: 'SupplementSign',
//             component: SupplementSign,
//             meta: {
//                 keepAlive: true
//             },
//         },
//         {//我的审批
//             path: '/myReview',
//             name: 'MyReview',
//             component: MyReview
//         },
//         {//出差申请
//             path: '/businessApply',
//             name: 'businessApply',
//             component: BusinessApply,
//             meta: {
//                 keepAlive: true
//             },
//         },
//         {//审批详情
//             path: '/reviewDetail',
//             name: 'ReviewDetail',
//             component: ReviewDetail
//         },
//         {//审批详情
//             path: '/logRead',
//             name: 'LogRead',
//             component: LogRead
//         },
//         {//消息公告
//             path: '/MessageNotice',
//             name: 'MessageNotice',
//             component: MessageNotice
//         },
//         {//消息公告详情
//             path: '/MessageNoticeView',
//             name: 'MessageNoticeView',
//             component: MessageNoticeView
//         },
//         {//部门
//             path: '/getTreeEmpPhoneByUserId',
//             name: 'getTreeEmpPhoneByUserId',
//             component: GetTreeEmpPhoneByUserId
//         },
//         {//抄送人
//             path: '/GetTreeEmpPhoneByUserIdItem',
//             name: 'getTreeEmpPhoneByUserIdItem',
//             component: GetTreeEmpPhoneByUserIdItem
//         },
//     ]
// })
