/**
 * 接口文档地址
 * author：liuguangrui
 */
const serviceModule = {
    /**
     * 日志
     */
    fileUpload: {//图片上传
        // url: '/file/file/upload',
        url: '/file/p/file/simple',
    	method: 'post'
    },
    logSave: {//新增日志
        url: '/mt/work/save',
        method: 'post'
    },
    logEdit: {//编辑日志
        url: '/mt/work/updateDetail',
        method: 'post'
    },
    saveAns: {//新增回复
        url: '/mt/work/saveAnswer',
        method: 'post'
    },
    getAns: {//获取日志详情的回答列表
        url: '/mt/work/getAnswerList',
        method: 'get'
    },
    receiptLog: {//我收到的日志列表
        url: '/mt/work/lookPage',
        method: 'post',
        loadHide:true,
    },
    emitLog: {//我发出的日志列表
        url: '/mt/work/pageApp',
        method: 'post',
        loadHide: true,
    },
    getTreeEmpPhoneByUserId: {
        url: '/admin/p/emp/getTreeEmpPhoneByUserId',
        method: 'get'
    },
    getLookUser: {//获取查看人信息
        url: '/mt/work/getLookUser',
        method: 'get'
    },
    getAuthorityList: {//获取历史查看人信息
        url: '/mt/work/getAuthorityList',
        method: 'get'
    },
    workLogLook: {//点击查看
        url: '/mt/work/workLogLook',
        method: 'post'
    },
    /**
     * 帮助
     */
    helpList: {//帮助列表
        url: '/mt/help/page',
        method: 'post'
    },
    /**
     * 考勤接口列表
     */
    h5GetMyStatics: {//h5查询我的考勤统计
        url:'/mt/punchAttendanceStatics/h5GetMyStatics',
        method:'get'
    },
    h5GetMyStaticsByType: {//h5查询统计查询具体的条目信息
        url: '/mt/punchAttendanceStatics/h5GetMyStaticsByType',
        method: 'get'
    },
    findPageCurSendMeApplyList: {//我的考勤列表
        url: '/mt/apprApply/findPageCurSendMeApplyList',
        method: 'post'
    },
    getApprApplyInfo: {//查看审批详情
        url: '/mt/apprApply/getApprApplyInfo',
        method: 'get'
    },
    dealApprApply: {//处理审批
        url: '/mt/apprApply/dealApprApply',
        method: 'get',
        // ContenType: 'application/x-www-form-urlencoded'
    },
    createApprApply: {//申请审批（不同类型传参不同）
        url: '/mt/apprApply/createApprApply',
        method: 'post'
    },
    getDefaultPerson: {//获取默认审批/抄送人列表
        url: '/mt/apprApply/getDefaultPerson',
        method: 'get'
    },
    getFindPunchclockPage: {//获取打卡记录列表
        url: '/mt/punchClock/findPunchclockPage',
        method: 'post'
    },
    getFindApprApplyPage: {//获取申请记录列表
        url: '/mt/apprApply/findApprApplyPage',
        method: 'post'
    },
    getMyUnityPunchClockRule: {//获取用户单位的考勤配置
        url: '/mt/punchClock/getMyUnityPunchClockRule',
        method: 'get'
    },
    getTodayPunchClock: {//获取用户今天的打卡记录
        url: '/mt/punchClock/getTodayPunchClock',
        method: 'get'
    },
    createPunchClock: {//创建打卡
        url: '/mt/punchClock/createPunchClock',
        method: 'post'
    },
    cancellApprApply: {//撤销申请
        url: '/mt/apprApply/cancellApprApply',
        method: 'post'
    },
    getAddrList:{
        url: '/admin/area/findAreaTree',
        method: 'get'
    },
    // 公告消息
    getAllMsg: {
        url: '/msgs/bbs/msg/getAllMsg',
        method: 'post'
    },
    getNotReadMsg: {
        url: '/msgs/bbs/msg/getNotReadMsg',
        method: 'post'
    },
    getReadMsg: {
        url: '/msgs/bbs/msg/getReadMsg',
        method: 'post'
    },
    getMsgDetail: {//获取公告详情
        url: '/msgs/bbs/msg/getDetailById',
        method: 'get'
    },
    updateMsgsReaded: {//读消息
        url: '/msgs/bbs/msg/updateMsgsReaded',
        method: 'post',
        type: true
    },
    // 通知消息
    getAllNotice:{
        url: '/msgs/message/mobile',
        method: 'post',
    },
    getIsread: {
        url: '/msgs/mobile/isread',
        method: 'post',
        type: true
    },
    getNoticeDetail: {//获取通知详情
        url: '/msgs/message/detail',
        method: 'get'
    },
    // 邮件系统
    getAllInbox:{//获取收件箱，发件箱
        url: '/mail/receive/page',
        method: 'post',
    },
    getEmailSee: {//获取已读未读邮件
        url: '/mail/receive/see',
        method: 'post',
    },
    searchAll: {//搜索查询
        url: '/mail/search',
        method: 'post',
    },
    emailDetail: {//邮件详情
        url: '/mail/receive/view',
        method: 'get',
    },
    deleteEmail: {//删除邮件
        url: '/mail/receive/delete',
        method: 'post',
    },
    sendEmail: {//发送邮件
        url: '/mail/send/email',
        method: 'post',
    }
}
const ApiList = { ...serviceModule }

export default ApiList  