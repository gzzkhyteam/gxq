/*
* 运维管理api接口文档
*/
const serviceModule = {
  // 获取首页的数据
  getHomePageCount: {
    url: '/api/ops/fault/getHomePageCount',
    method: 'get'
  },
  // 获取运维单位树
  findOrgAndDpmOperationTree: {
    url: '/api/admin/gxqpt/org/findOrgAndDpmOperationTree',
    method: 'get'
  },
  // 获取运维单位树(新版)
  findOrgTreeByLoginInOperation: {
    url: '/api/admin/gxqpt/org/findOrgTreeByLoginInOperation',
    method: 'get'
  },
  // 获取运维单位树(过滤后新版)
  findOrgTreeByUsersInOperation: {
    url: '/api/ops/service/findOrgTreeByUsersInOperation',
    method: 'get'
  },
  // 根据单位id部门id获取人员列表
  getDeptPerson: {
    url: '/api/ops/person/getDeptPerson',
    method: 'post'
  },
  // 获取系统列表
  findAppByAdminWithEnable: {
    url: '/api/developer/application/findAppByAdminWithEnable',
    method: 'get'
  },
  // 保存人员信息
  savePersonInfo: {
    url: '/api/ops/person/save',
    method: 'post'
  },
  // 更新人员信息
  updatePersonInfo: {
    url: '/api/ops/person/update',
    method: 'post'
  },
  // 获取运维文档查询的列表
  queryByClassifyId: {
    url: '/api/standard/file/queryByClassifyId',
    method: 'post'
  },
  // 获取文档类型的树结构
  getTypeTree: {
    url: '/api/standard/classify/getAllTreeById',
    method: 'get'
  },
  // 获取运维文档管理列表
  manageQueryByClassifyId: {
    url: '/api/standard/file/manageQueryByClassifyId',
    method: 'post'
  },
  // 获取文档分类管理树结构
  getClassifyTree: {
    url: '/api/standard/classify/getAllTreeById',
    method: 'get'
  },
  // 文档分类保存（新增）
  classifySave: {
    url: '/api/standard/classify/save',
    method: 'post'
  },
  // 文档分类更新
  classifyUpdate: {
    url: '/api/standard/classify/update',
    method: 'post'
  },
  // 获取文档分类的详细信息
  getClassifyDetail: {
    url: '/api/standard/classify/get',
    method: 'get'
  },
  // 检测文档是否可以删除
  isRelevanceDocument: {
    url: '/api/standard/file/isRelevanceDocument',
    method: 'get'
  },
  // 删除文档分类
  classifyDelete: {
    url: '/api/standard/classify/delete',
    method: 'get'
  },
  // 删除文档
  fileDelete: {
    url: '/api/standard/file/delete',
    method: 'get'
  },
  // 新增文档
  fileSave: {
    url: '/api/standard/file/save',
    method: 'post'
  },
  // 更新文档
  fileUpdate: {
    url: '/api/standard/file/update',
    method: 'post'
  },
  // 根据appidlist获取应用信息
  findByAppIdList: {
    url: '/api/developer/application/findByAppIdList',
    method: 'post'
  },
  // 应用分析
  faultFindAnalyse: {
    url: '/api/ops/fault/findAnalyse',
    method: 'post'
  },
  // 共性模块监控
  getDataAnalysis: {
    url: '/api/modular/getDataAnalysis',
    method: 'get'
  },
  // 共性服务-服务故障处理分析
  serviceAnalysis: {
    url: '/api/ops/fault/fault/serviceAnalysis',
    method: 'get'
  },
  // 共性服务-数量分析、top10、使用率
  dataAnalysis: {
    url: '/api/developer/module/dataAnalysis',
    method: 'get'
  },
  // 网站监控
  webMonitor: {
    url: '/api/developer/module/webMonitor',
    method: 'get'
  },
  // 共性应用-访问量
  loginAmount: {
    url: '/api/developer/module/loginAmount',
    method: 'get'
  },
  // 共性应用-故障平均处理时长、故障处理分析、故障率
  appAnalysis: {
    url: '/api/ops/fault/fault/appAnalysis',
    method: 'get'
  },
  // 查询告警列表
  alarmInformationPage: {
    // url: '/api/ops/AlarmInformation/page',
    url: '/api/ops/AlarmInformation/pageInfo',
    method: 'post'
  },
  // 告警规则保存
  alarmSave: {
    url: '/api/ops/Alarm/save',
    method: 'post'
  },
  // 告警规则更新
  alarmUpdate: {
    url: '/api/ops/Alarm/update',
    method: 'post'
  },
  // 删除告警规则
  alarmDelete: {
    url: '/api/ops/Alarm/delete',
    method: 'post',
    contentType: 'postparam'
  },
  // 告警规则列表
  rulePage: {
    url: '/api/ops/Alarm/page',
    method: 'post'
  },
  // 获取规则详情
  alarmGet: {
    url: '/api/ops/Alarm/get',
    method: 'get'
  },
  // 查询所有主机信息
  getHostName: {
    url: '/api/developer/hostInstall/getHostName',
    method: 'post'
  },
  // 获取部署信息的列表
  hostInstallPage: {
    url: '/api/developer/hostInstall/page',
    method: 'post'
  },
  // 查询部署主机的详细信息
  hostInstallGetDetail: {
    url: '/api/developer/hostInstall/get',
    method: 'get'
  },
  // 应用升级列表
  appUpgradePage: {
    url: '/api/ops/application/page',
    method: 'post'
  },
  // 获取版本信息详情
  getApplition: {
    url: '/api/ops/application/getApplition',
    method: 'get'
  },
  // 启用和禁用应用
  appUpdate: {
    url: '/api/ops/application/update',
    method: 'post',
    contentType: 'postparam'
  },
  // 发布新版本
  appSave: {
    url: '/api/ops/application/save',
    method: 'post'
  },
  // 版本编辑
  updateApplication: {
    url: '/api/ops/application/updateApplication',
    method: 'post'
  },
  // 培训-培训课程目录列表
  trainPage: {
    url: '/api/ops/train/typePage',
    method: 'post'
  },
  // 培训-培训申请
  trainApply: {
    url: '/api/ops/train/apply',
    method: 'post'
  },
  // 培训-培训类型列表
  trainTypeList: {
    url: '/api/ops/train/type/list',
    method: 'get'
  },
  // 新增培训课程
  courseSave: {
    url: '/api/ops/train/course/save',
    method: 'post'
  },
  // 修改培训课程
  courseUpdate: {
    url: '/api/ops/train/course/update',
    method: 'post'
  },
  // 培训列表
  trainList: {
    url: '/api/ops/train/page',
    method: 'post'
  },
  // 修改培训内容
  trainUpdate: {
    url: '/api/ops/train/context/update',
    method: 'post'
  },
  // 培训评分
  trainEvaluate: {
    url: '/api/ops/train/evaluate',
    method: 'post'
  },
  // 培训详情-处理详情
  trainDetail: {
    url: '/api/ops/train/detail',
    method: 'get'
  },
  // 培训审核列表
  trainAuditorPage: {
    url: '/api/ops/train/auditor/page',
    method: 'post'
  },
  // 培训审批
  trainHandleApply: {
    url: '/api/ops/train/handle/apply',
    method: 'post'
  },
  // 培训完结
  trainEndUpdate: {
    url: '/api/ops/train/end/update',
    method: 'post',
    contentType: 'postparam'
  },
  // 保存文件上传信息
  trainFileSave: {
    url: '/api/ops/train/file/save',
    method: 'post'
  },
  // 获取课程管理树
  trainCourseTree: {
    url: '/api/ops/train/course/tree',
    method: 'get'
  },
  // 获取咨询列表
  consultPage: {
    url: '/api/ops/consult/page',
    method: 'post'
  },
  // 删除培训课程
  courseDelete: {
    url: '/api/ops/train/course/delete',
    method: 'post',
    contentType: 'postparam'
  },
  // 服务目录列表
  servicePage: {
    url: '/api/ops/service/page',
    method: 'post'
  },
  // 服务处理列表
  pageDealList: {
    url: '/api/ops/service/pageDealList',
    method: 'post'
  },
  // 获取可选的人员的id
  findOperationPerson: {
    url: '/api/ops/service/findOperationPerson',
    method: 'get'
  },
  // 新增咨询
  consultSave: {
    url: '/api/ops/consult/save',
    method: 'post'
  },
  // 编辑咨询
  consultUpdate: {
    url: '/api/ops/consult/update',
    method: 'post'
  },
  // 查询咨询审批列表
  consultDealPage: {
    url: '/api/ops/consult/dealPage',
    method: 'post'
  },
  // 更新评价信息
  consultEval: {
    url: '/api/ops/consult/updateEval',
    method: 'post'
  },
  // 处理咨询申请
  consultDeal: {
    url: '/api/ops/consult/deal',
    method: 'post'
  },
  // 查询咨询处理列表
  consultHandlePage: {
    url: '/api/ops/consult/handlePage',
    method: 'post'
  },
  // 完结咨询
  consultOver: {
    url: '/api/ops/consult/over',
    method: 'get'
  },
  // 获取咨询的详情
  consultGet: {
    url: '/api/ops/consult/get',
    method: 'get'
  },
  // 故障管理-故障台账列表
  faultPage: {
    url: '/api/ops/fault/page',
    method: 'post'
  },
  // 故障管理-故障台账详情
  faultGetById: {
    url: '/api/ops/fault/getById',
    method: 'get'
  },
  // 故障管理-故障知识库列表
  pageKnowledgeBase: {
    url: '/api/ops/fault/pageKnowledgeBase',
    method: 'post'
  },
  // 故障管理-故障知识库删除列表
  faultDelete: {
    url: '/api/ops/fault/delete',
    method: 'post',
    contentType: 'postparam'
  },
  // 故障管理-我的任务故障信息
  pageMyFaultList: {
    url: '/api/ops/fault/pageMyFaultList',
    method: 'post'
  },
  // 故障管理-我的任务保存处理故障信息是否属实
  updateIsTrue: {
    url: '/api/ops/fault/updateIsTrue',
    method: 'post'
  },
  // 查询故障分析数据
  getFaultMonitoring: {
    url: '/api/ops/fault/getFaultMonitoring',
    method: 'get'
  },
  // 运维分析
  getOperationAnalysis: {
    url: '/api/ops/person/getOperationAnalysis',
    method: 'get'
  },
  // 新建服务申请
  serviceSaveMange: {
    url: '/api/ops/service/saveMange',
    method: 'post'
  },
  // 更新服务申请
  serviceUpdateMange: {
    url: '/api/ops/service/updateMange',
    method: 'post'
  },
  // 获取服务分类等等
  getServiceType: {
    url: '/api/ops/service/getType',
    method: 'get'
  },
  // 根据用户id用户负责的应用
  getSystemList: {
    url: '/api/ops/person/getSystemList',
    method: 'get'
  },
  // 故障管理-我的任务保存处理故障信息
  updateFaultManage: {
    url: '/api/ops/fault/updateFaultManage',
    method: 'post'
  },
  // 运维服务管理-服务审核-查询服务审核分页信息
  pageAuditList: {
    url: '/api/ops/service/pageAuditList',
    method: 'post'
  },
  // 运维服务管理-服务审核-审核处理服务申请信息
  updateAudit: {
    url: '/api/ops/service/updateAudit',
    method: 'post'
  },
  // 服务详情
  getServiceDetailById: {
    url: '/api/ops/service/getById',
    method: 'get'
  },
  // 服务评价
  updateServiceEvaluation: {
    url: '/api/ops/service/updateServiceEvaluation',
    method: 'post'
  },
  // 运维服务管理-服务处理-处理
  updateServiceReport: {
    url: '/api/ops/service/updateServiceReport',
    method: 'post'
  },
  // 查询目录树
  serviceTree: {
    url: '/api/ops/service/getTree',
    method: 'get'
  },
  // 更新树信息
  serviceUpdate: {
    url: '/api/ops/service/update',
    method: 'post'
  },
  // 新增树信息
  serviceSave: {
    url: '/api/ops/service/save',
    method: 'post'
  },
  // 删除树节点
  serviceDelete: {
    url: '/api/ops/service/delete',
    method: 'post',
    contentType: 'postparam'
  },
  // 根据id 删除日志管理信息
  logDelete: {
    url: '/api/ops/Log/delete',
    method: 'get'
  },
  // 根据id查询日志管理信息
  logGet: {
    url: '/api/ops/Log/get',
    method: 'get'
  },
  // 分页查询日志管理信息
  logPageProviderInformation: {
    url: '/api/ops/Log/pageProviderInformation',
    method: 'post'
  },
  // 新增日志管理
  logSave: {
    url: '/api/ops/Log/save',
    method: 'post'
  },
  // 修改日志管理信息
  logUpdate: {
    url: '/api/ops/Log/update',
    method: 'post'
  }
}
const ApiList = { ...serviceModule }

export default ApiList
