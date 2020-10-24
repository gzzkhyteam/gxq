/* 邮件管理系统 */

import Vue from 'vue'
import Router from 'vue-router'
import store from '@/store'

// 首页
import home from '@/view/email/home'
// 写邮件
import write from '@/view/email/write'
// 收件箱
import received from '@/view/email/received'
// 异常邮件
import exception from '@/view/email/exception'
// 垃圾邮件
import dustbin from '@/view/email/dustbin'
// 病毒邮件
import virus from '@/view/email/virus'
// 草稿箱
import drafts from '@/view/email/drafts'
// 已发送
import send from '@/view/email/send'
// 回收站
import trash from '@/view/email/trash'
// 文件夹
import folder from '@/view/email/folder'
// 设置
import setting from '@/view/email/setting'
// 邮件详情
import emailDetail from '@/view/email/emailDetail'
// 搜索结果
import search from '@/view/email/search'
// 过滤器设置
import filterSetting from '@/view/email/filterSetting'
// 用户日志
import userLog from '@/view/email/userLog'


Vue.use(Router)

const router = new Router({
  routes: [
    { // 默认地址
      path: '/',
      name: 'home',
      component: home
    },
    { // 首页
      path: '/home',
      name: 'home',
      component: home
    },
    { // 写邮件
      path: '/write/:pageType/:folderType/:mailId',
      name: 'write',
      component: write
    },
    { // 收件箱
      path: '/received',
      name: 'received',
      component: received
    },
    { // 异常邮件
      path: '/exception',
      name: 'exception',
      component: exception
    },
    { // 垃圾邮件
      path: '/dustbin',
      name: 'dustbin',
      component: dustbin
    },
    { // 病毒邮件
      path: '/virus',
      name: 'virus',
      component: virus
    },
    { // 草稿箱
      path: '/drafts',
      name: 'drafts',
      component: drafts
    },
    { // 已发送
      path: '/send',
      name: 'send',
      component: send
    },
    { // 回收站
      path: '/trash',
      name: 'trash',
      component: trash
    },
    { // 文件夹
      path: '/folder/:folderId/:folderName',
      name: 'folder',
      component: folder
    },
    { // 设置
      path: '/setting',
      name: 'setting',
      component: setting
    },
    { // 邮件详情
      path: '/emailDetail/:folderType/:mailId',
      name: 'emailDetail',
      component: emailDetail
    },
    { // 邮件详情
      path: '/search/:keyword',
      name: 'search',
      component: search
    },
    { // 过滤器设置
      path: '/filterSetting',
      name: 'filterSetting',
      component: filterSetting
    },
    { // 用户日志
      path: '/userLog',
      name: 'userLog',
      component: userLog
    }
  ]
})

router.beforeEach((to, from, next) => {
     hy_auth_login('email') // 登陆验证
     store.commit('GETUSERINFO') // 设置用户信息
  next()
})

export default router
