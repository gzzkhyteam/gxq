/**
 * 预警系统api文档
 */

const warnList = {
  warnHandleStatistical: { // 单个人员预警产生、处理情况
    url: '/api/warn/warnHandleStatistical',
    method: 'post'
  },
  getWarnMixStatusNum: { // 首页统计数量
    url: '/api/warn/count/getWarnMixStatusNum',
    method: 'get'
  },
  findWarnType: { // 首页top10
    url: '/api/warn/findWarnType',
    method: 'post'
  },
  findLevelCount: { // 首页个人预警级别情况
    url: '/api/warn/findLevelCount',
    method: 'post'
  },
  findWarnList: { // 获取台账列表
    url: '/api/warn/warn/findWarnList',
    method: 'post'
  },
  findWarnTypeTree: { // 获取预警类型树
    url: '/api/warn/warntype/findWarnTypeTree',
    method: 'get'
  },
  findWarnHandleList: { // 获取预警台账处理列表
    url: '/api/warn/warnhandle/findWarnHandleList',
    method: 'post'
  },
  findWarnResultList: { // 获取预警台账处理结果列表
    url: '/api/warn/warnresult/findWarnResultList',
    method: 'post'
  },
  getById: { // 获取分类详情
    url: '/api/warn/warntype/getById',
    method: 'get'
  },
  warnGetById: { // 获取预警台账的详情
    url: '/api/warn/warn/getById',
    method: 'get'
  },
  getConById: { // 获取预警台账确认信息的详情
    url: '/api/warn/warn/getConById',
    method: 'get'
  },
  getHanById: { // 获取预警台账处理信息的详情
    url: '/api/warn/warn/getHanById',
    method: 'get'
  },
  overdueById: { // 禁用预警分类
    url: '/api/warn/warntype/deleteById',
    method: 'get'
  },
  save: { // 新增类型
    url: '/api/warn/warntype/save',
    method: 'post'
  },
  update: { // 更新分类
    url: '/api/warn/warntype/update',
    method: 'post'
  },
  getDutyer: { // 查询指定的责任人
    url: '/api/warn/warn/getDutyer',
    method: 'get'
  },
  getTreeEmpPhoneByUserId: { // 根据登录人的id获取所在单位的人员信息
    url: '/api/admin/p/emp/getTreeEmpPhoneByUserId',
    method: 'get'
  },
  updateModeById: { // 确认预警信息
    url: '/api/warn/warn/updateModeById',
    method: 'post'
  },
  updateHandleById: { // 处理预警信息
    url: '/api/warn/warn/updateHandleById',
    method: 'post'
  }
}
const warnApiList = { ...warnList }

export default warnApiList
