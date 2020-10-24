/**
 * 邮件管理系统接口文档地址
 * author：liuguangrui
 */

const emailList = {
    sostomfileFindAll: {//查询目录及对应邮件数量
        url: '/api/mail/dataapi/sostomfile/findAll',
        method: 'get'
    },
    sostomfileFind: {//查询自定义文件夹
        url: '/api/mail/dataapi/sostomfile/find',
        method: 'get'
    },
    sostomfileSave: {//保存自定义文件夹
        url: '/api/mail/dataapi/sostomfile/save',
        method: 'get'
    },
    sostomfileUpdate: {//修改自定义文件夹
        url: '/api/mail/dataapi/sostomfile/update',
        method: 'post'
    },
    sostomfileDelete: {//删除自定义文件夹
        url: '/api/mail/dataapi/sostomfile/delete',
        method: 'post',
        contentType: 'postparam'
    },
    usersignFind: {//查询用户签名
        url: '/api/mail/dataapi/usersign/find',
        method: 'get',
    },
    usersignSave: {//保存用户签名
        url: '/api/mail/dataapi/usersign/save',
        method: 'post'
    },
    usersignUpdate: {//修改用户签名
        url: '/api/mail/dataapi/usersign/update',
        method: 'post'
    },
    usersignDelete: {//删除用户签名
        url: '/api/mail/dataapi/usersign/delete',
        method: 'post',
        contentType: 'postparam'
    },
    setparamFindById: {//查询用户设置参数
        url: '/api/mail/dataapi/setparam/findById',
        method: 'get',
    },
    setparamSaveandupdate: {//保存设置参数
        url: '/api/mail/dataapi/setparam/saveandupdate',
        method: 'post',
    },
    mailFindBWList: {//查询黑名单分页列表
        url: '/api/mail/mail/findBWList',
        method: 'post',
    },
    mailSave: {//新增黑名单
        url: '/api/mail/mail/save',
        method: 'post',
    },
    mailDetele: {//删除黑名单
        url: '/api/mail/mail/deleteById',
        method: 'get',
    },
    mailWhileSave: {//新增白名单
        url: '/api/mail/mail/saveWhite',
        method: 'post',
    },
    deleteWhiteById: {//删除白名单
        url: '/api/mail/mail/deleteWhiteById',
        method: 'get',
    },
    userPage: {//获取用户列表
        url: '/api/admin/user/page',
        method: 'post',
    },
    sendEmail: {//写信
        url: '/api/mail/send/email',
        method: 'post',
    },
    sendSaveDraft: {//存草稿
        url: '/api/mail/send/saveDraft',
        method: 'post',
    },
    timeSend: {//定时发送
        url: '/api/mail/dataapi/timeSend',
        method: 'post',
    },
    findSystem: {//查询单位部门
        url: '/api/admin/gxqpt/org/getAllOrgAndDpm',
        method: 'get',
    },
    /*findOrg: {//查询单位部门
        url: '/api/admin/gxqpt/org/find',
        method: 'get',
    },*/
    findEmpList: {//查询人员信息
        url: '/api/admin/emp/pageEmailEmpByDpm',
        method: 'post',
    },
    receivePage: {//查询收件箱列表
        url: '/api/mail/receive/page',
        method: 'post',
    },
    receiveDelete: {//收件箱列表删除
        url: '/api/mail/receive/delete',
        method: 'post',
    },
    receiveDeleteByForever: {//彻底删除收件箱列表
        url: '/api/mail/receive/deleteByForever',
        method: 'post',
    },
    receiveMark: {//标记邮件是否已读
        url: '/api/mail/receive/mark',
        method: 'post',
    },
    receiveMove: {//移动邮件到指定文件夹
        url: '/api/mail/receive/move',
        method: 'post',
    },
    receiveSee: {//查看指定类型的邮件（已读、未读）
        url: '/api/mail/receive/see',
        method: 'post',
    },
    receiveView: {//查看指定类型的邮件（已读、未读）
        url: '/api/mail/receive/view',
        method: 'get',
    },
    searchHigh: {//搜索
        url: '/api/mail/search/high',
        method: 'post',
    },
    moveMailList: {//搜索页移动文件到指定文件夹
        url: '/api/mail/receive/saveMoveMailList',
        method: 'post',
    },
    deleteByForeverList: {//搜索页删除文件
        url: '/api/mail/receive/deleteByForeverList',
        method: 'post',
    },
    quickReply: {//快速发送邮件
        url: '/api/mail/send/quickReply',
        method: 'post',
    },
    timefind: {//获取定时邮件列表
        url: '/api/mail/dataapi/timefind',
        method: 'post',
    },
    timedelete: {//删除定时邮件列表
        url: '/api/mail/dataapi/timedelete',
        method: 'post',
    },
    timeget: {//获取定时邮件详情
        url: '/api/mail/dataapi/timeget',
        method: 'get',
    },
    clearDelete: {//清空回收站
        url: '/api/mail/receive/clearDelete',
        method: 'post',
    },
    loginLogPage: {//用户日志
        url: '/api/admin/loginLog/page',
        method: 'post',
    },
    sendGetfilter: {// 查询过滤关键字列表
        url: '/api/mail/send/getfilter',
        method: 'get',
    },
    sendGetfilterPage: {// 查询过滤关键字(分页)
        url: '/api/mail/send/getfilterpage',
        method: 'post',
    },
    sendInsertfilter: {// 新增过滤关键字
        url: '/api/mail/send/insertfilter',
        method: 'get',
    },
    sendDeletefilter: {// 删除过滤关键字
        url: '/api/mail/send/deletefilter',
        method: 'get',
    }
}
const emailApiList = { ...emailList }

export default emailApiList
