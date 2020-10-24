import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/view/index'
import LogForm from '@/view/LogForm'
import EditForm from '@/view/EditForm'
import LogDetail from '@/view/LogDetail'
import MyAttendance from '@/view/MyAttendance'
import Sign from '@/view/Sign'
import FieldSign from '@/view/FieldSign'
import ClockInList from '@/view/ClockInList'
import OvertimeForm from '@/view/OvertimeForm'
import AskLeave from '@/view/AskLeave'
import FieldForm from '@/view/FieldForm'
import SupplementSign from '@/view/SupplementSign'
import MyReview from '@/view/MyReview'
import BusinessApply from '@/view/BusinessApply'
import ReviewDetail from '@/view/ReviewDetail'
import LogRead from '@/view/LogRead'
import MessageNotice from '@/view/MessageNotice'
import MessageNoticeView from '@/view/MessageNoticeView'
import Help from '@/view/Help'
import HelpView from '@/view/HelpView'
import GetTreeEmpPhoneByUserId from '@/view/GetTreeEmpPhoneByUserId'
import GetTreeEmpPhoneByUserIdItem from '@/view/GetTreeEmpPhoneByUserIdItem'

Vue.use(Router);

export default new Router({
  routes: [
    {//主页-我的日志
      path: '/',
      name: 'index',
      component: Index,
      meta:{
        keepAlive: false
      },
      children:[
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
    {//我的考勤
      path: '/myAttendance',
      name: 'MyAttendance',
      component: MyAttendance
    },
    {//签到打卡
      path: '/sign',
      name: 'Sign',
      component: Sign
    },
    {//外勤打卡
      path: '/fieldSign',
      name: 'FieldSign',
      component: FieldSign
    },
    {//打卡记录
      path: '/clockInlist',
      name: 'ClockInList',
      component: ClockInList
    },
    {//加班申请
      path: '/overtimeForm',
      name: 'OvertimeForm',
      component: OvertimeForm
    },
    {//请假申请
      path: '/askLeave',
      name: 'AskLeave',
      component: AskLeave
    },
    {//外勤申报
      path: '/fieldForm',
      name: 'FieldForm',
      component: FieldForm
    },
    {//补签申请
      path: '/supplementSign',
      name: 'SupplementSign',
      component: SupplementSign
    },
    {//我的审批
      path: '/myReview',
      name: 'MyReview',
      component: MyReview
    },
    {//出差申请
      path: '/businessApply',
      name: 'businessApply',
      component: BusinessApply
    },
    {//审批详情
      path: '/reviewDetail',
      name: 'ReviewDetail',
      component: ReviewDetail
    },
    {//审批详情
      path: '/logRead',
      name: 'LogRead',
      component: LogRead
    },
    {//消息公告
      path: '/MessageNotice',
      name: 'MessageNotice',
      component: MessageNotice
    },
    {//消息公告详情
      path: '/MessageNoticeView',
      name: 'MessageNoticeView',
      component: MessageNoticeView
    },
    {//帮助
      path: '/help',
      name: 'Help',
      component: Help
    },
    {//帮助详情
      path: '/helpView',
      name: 'HelpView',
      component: HelpView
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
