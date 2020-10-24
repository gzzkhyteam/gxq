/**
 * 接口文档地址
 * author：liuguangrui
 */

const serviceModule = {
    /** 首页数据获取： */
    getResourceCount: { //软硬件面板各资源数量查询
        url: '/api/hardware/servermanager/getResourceCount',
        method: 'get'
    },
    getServersCountByMonth: { //查询当前月及前十一个月的服务器数量
        url: '/api/hardware/servermanager/getServersCountByMonth',
        method: 'get'
    },
    getOrgServersCount: { //查询各单位服务器数量统计
        url: '/api/hardware/servermanager/getOrgServersCount',
        method: 'get'
    },
    getServersResCountByMonth: { //查询当前月及前十一个月的服务器cpu，内存，硬盘等资源数量
        url: '/api/hardware/servermanager/getServersResCountByMonth',
        method: 'get'
    },
    /** 设备监控： */
    emPageList: { //查询设备监控数据列表
        url: '/api/hardware/equipmentMonitor/emPageList',
        method: 'post'
    },
    saveEquipmentMonitor: { //保存设备监控数据
        url: '/api/hardware/equipmentMonitor/saveEquipmentMonitor',
        method: 'post'
    },
    updateEquipmentMonitor: { //编辑设备监控数据
        url: '/api/hardware/equipmentMonitor/updateEquipmentMonitor',
        method: 'post'
    },
    deleteEquipmentMonitor: { //删除设备监控数据
        url: '/api/hardware/equipmentMonitor/deleteEquipmentMonitor',
        method: 'get'
    },
    emrPageList: { //查询设备监控>报告数据列表
        url: '/api/hardware/equipmentMonitor/emrPageList',
        method: 'post'
    },
    saveEquipmentMonitorReport: { //保存设备监控>报告数据
        url: '/api/hardware/equipmentMonitor/saveEquipmentMonitorReport',
        method: 'post'
    },
    updateEquipmentMonitorReport: { //编辑设备监控>报告数据
        url: '/api/hardware/equipmentMonitor/updateEquipmentMonitorReport',
        method: 'post'
    },
    deleteEquipmentMonitorReport: { //删除设备管理>报告数据
        url: '/api/hardware/equipmentMonitor/deleteEquipmentMonitorReport',
        method: 'get'
    },
    /** 服务器分配管理： */
    getMemoryResManage: { //存储管理查询
        url: '/api/hardware/servermanager/getMemoryResManage',
        method: 'post'
    },
    getCpuResManage: { //计算资源管理
        url: '/api/hardware/servermanager/getCpuResManage',
        method: 'post'
    },
    getNetResManage: { //网络宽带管理
        url: '/api/hardware/servermanager/getNetResManage',
        method: 'post'
    },
    findDatabaseList: { //数据库管理
        url: '/api/hardware/databasemanager/findDatabaseList',
        method: 'post'
    },
    releaseDatabase: { //数据管理释放
        url: '/api/hardware/databasemanager/releaseDatabase',
        method: 'post',
        contentType: true
    },
    saveDatabase: { //新建数据库管理
        url: '/api/hardware/databasemanager/saveDatabase',
        method: 'post'
    },
    updateDatabase: { //修改数据库管理
        url: '/api/hardware/databasemanager/updateDatabase',
        method: 'post'
    },
    /** 服务器监控统计模块： */
    findMonitorDetail: { //查找图标数据
        url: '/api/hardware/serverstatistics/findMonitorDetail',
        method: 'post'
    },
    databaseResPanel: { //获取数据库资源面板数据
        url: '/api/hardware/databasemanager/databaseResPanel',
        method: 'get'
    },
    databaseStatistics: { //数据库数量统计
        url: '/api/hardware/databasemanager/databaseStatistics',
        method: 'get'
    },
    databaseTypeRatioStatistics: { //数据库类型占比统计
        url: '/api/hardware/databasemanager/databaseTypeRatioStatistics',
        method: 'get'
    },
    getPanelCpuRes: { //查询计算资源面板cpu增比等情况
        url: '/api/hardware/panel/getPanelCpuRes',
        method: 'get'
    },
    getStorageMemData: { //存储面板内存信息统计
        url: '/api/hardware/panel/getStorageMemData',
        method: 'get'
    },
    getStorageDiskData: { //存储面板磁盘信息统计
        url: '/api/hardware/panel/getStorageDiskData',
        method: 'get'
    },
    releaseServer: { //存储管理-释放服务器数据
        url: '/api/hardware/applymanage/releaseServer',
        method: 'post',
        contentType: true
    },
    findMemByDpmAndLastYare: { //存储面板部门近一年内存统计图
        url: '/api/hardware/panel/findMemByDpmAndLastYare',
        method: 'get'
    },
    findDiskByDpmAndLastYare: { //存储面板部门近一年磁盘统计图
        url: '/api/hardware/panel/findDiskByDpmAndLastYare',
        method: 'get'
    },
    getPanelOrgCpuRes: { //查询各单位计算资源面板cpu等情况
        url: '/api/hardware/panel/getPanelOrgCpuRes',
        method: 'get'
    },
    getPanelMonthOrgCpuRes: { //查询各单位每月计算资源cpu情况
        url: '/api/hardware/panel/getPanelMonthOrgCpuRes',
        method: 'get'
    },
    findMemByDpm: { //存储面板部门内存统计图（柱状图）
        url: '/api/hardware/panel/findMemByDpm',
        method: 'get'
    },
    findDiskByDpm: { //存储面板部门磁盘统计图（柱状图）
        url: '/api/hardware/panel/findDiskByDpm',
        method: 'get'
    },
    getEachOrgNetWorkBandwidthYearStatistics: { //网络带宽面板 各部门网络带宽统计(近一年)
        url: '/api/hardware/servermanager/getEachOrgNetWorkBandwidthYearStatistics',
        method: 'get'
    },
    getEachOrgNetWorkBandwidthMonthStatistics: { //网络带宽面板 各部门网络带宽统计(月份计算)
        url: '/api/hardware/servermanager/getEachOrgNetWorkBandwidthMonthStatistics',
        method: 'get'
    },
    getThisMonthStatistics: { //网络带宽面板 本月统计
        url: '/api/hardware/servermanager/getThisMonthStatistics',
        method: 'get'
    },
    /**其他： */
    findMachineList: { //查询主机列表
        url: '/api/hardware/machine/findMachineList',
        method: 'post'
    },
    saveMachine: { //保存主机数据
        url: '/api/hardware/machine/saveMachine',
        method: 'post'
    },
    yysaveMachines: { //保存主机数据集合
        url: '/api/hardware/machine/saveMachines',
        method: 'post'
    },
    updateMachine: { //修改主机数据
        url: '/api/hardware/machine/updateMachine',
        method: 'post'
    },
    getMachineDetail: { //主机应用详情查询
        url: '/api/hardware/machine/getMachineDetail',
        method: 'get'
    },
    deleteMachine: { //删除主机数据
        url: '/api/hardware/machine/deleteMachine',
        method: 'get'
    },
    findDictionaryTypeList: { //查询字典类型数据列表
        url: '/api/hardware/dictionary/findDictionaryTypeList',
        method: 'get'
    },
    saveDictionaryType: { //保存字典类型数据
        url: '/api/hardware/dictionary/saveDictionaryType',
        method: 'post'
    },
    servermanagerPage: { //查询服务分配管理分页
        url: '/api/hardware/servermanager/page',
        method: 'post'
    },
    servermanagerSave: { //查询服务分配管理新增
        url: '/api/hardware/servermanager/save',
        method: 'post'
    },
    servermanagerUpdate: { //查询服务分配管理修改
        url: '/api/hardware/servermanager/update',
        method: 'post'
    },
    servermanagerDetail: { //查询服务分配详情
        url: '/api/hardware/servermanager/getDetail',
        method: 'get'
    },
    // servermanagerDelete: { //服务分配删除
    //     url: '/api/hardware/servermanager/delete',
    //     method: 'get'
    // },
    delServer: { //服务分配销毁
        url: '/api/hardware/applymanage/delServer',
        method: 'post',
        contentType: true
    },
    updateDictionaryType: { //修改字典类型数据
        url: '/api/hardware/dictionary/updateDictionaryType',
        method: 'post'
    },
    deleteDictionaryType: { //删除字典类型数据
        url: '/api/hardware/dictionary/deleteDictionaryType',
        method: 'get'
    },
    pageDictionaryList: { //查询数据字典分页信息
        url: '/api/hardware/dictionary/pageDictionaryList',
        method: 'post'
    },
    saveDictionary: { //保存字典数据
        url: '/api/hardware/dictionary/saveDictionary',
        method: 'post'
    },
    updateDictionary: { //修改字典数据
        url: '/api/hardware/dictionary/updateDictionary',
        method: 'post'
    },
    deleteDictionary: { //删除字典数据
        url: '/api/hardware/dictionary/deleteDictionary',
        method: 'get'
    },
    orgFindOrgByUser: { //根据user查询所有单位
        url: '/api/admin/gxqpt/org/findOrgByUser',
        method: 'get'
    },
    dictionaryFindByCode: { //通过编码查询数据
        url: '/api/hardware/dictionary/findByCode',
        method: 'get'
    },
    dictionaryFindByTypeCode: { //通过编码查询数据
        url: '/api/hardware/dictionary/findByTypeCode',
        method: 'get'
    },
    getMyApplyList: { //申请列表数据查询
        url: '/api/hardware/applymanage/getMyApplyList',
        method: 'post'
    },
    getApplyManageById: { //根据id查询审批详情
        url: '/api/hardware/applymanage/getApplyManageById',
        method: 'get'
    },
    getApplyServerById: { //根据id查询申请服务器资源
        url: '/api/hardware/applymanage/getApplyServerById',
        method: 'get'
    },
    getApplyResByApplyId: { //根据ApplyId查询申请新增所需资源
        url: '/api/hardware/applymanage/getApplyResByApplyId',
        method: 'get'
    },
    getApplyRecordsByApplyId: { //根据ApplyId查询审批记录
        url: '/api/hardware/applymanage/getApplyRecordsByApplyId',
        method: 'get'
    },
    commApproveSubmit: { //根据id对申请进行审批
        url: '/api/hardware/applymanage/commApproveSubmit',
        method: 'post'
    },
    uYApplyReseSubmit: { //优易资源不足提交审批处理，根据id对申请进行审批
        url: '/api/hardware/applymanage/uYApplyReseSubmit',
        method: 'post'
    },
    uYApproveSubmit: { //优易分配虚拟机
        url: '/api/hardware/applymanage/uYApproveSubmit',
        method: 'post'
    },
    checkIp: {//验证同意服务器下的ip是否冲突
      url: '/api/hardware/servermanager/checkIp',
      method: 'post'
    },
    updateApplyManage: { //修改申请管理
        url: '/api/hardware/applymanage/updateApplyManage',
        method: 'post'
    },
    saveMyApply: { //新建申请管理
        url: '/api/hardware/applymanage/save',
        method: 'post'
    },
    deleteDraft: { //删除申请管理
        url: '/api/hardware/applymanage/deleteDraft',
        method: 'get'
    },
    findDictionaryTree: { //查询数据字典树
        url: '/api/hardware/dictionary/findDictionaryTree',
        method: 'get'
    },
    servermanagerPageChange: { //查询服务分配变更列表
        url: '/api/hardware/servermanager/pageChange',
        method: 'POST'
    },
    getApprApplyList: { //审批列表数据查询
        url: '/api/hardware/applymanage/getApprApplyList',
        method: 'POST'
    },
    getAddHostByApplyId: { //根据ApplyId查询新增主机
        url: '/api/hardware/applymanage/getAddHostByApplyId',
        method: 'get'
    },
    yiYunApproveSubmit: { //高新翼云新增主机提交审批处理
        url: '/api/hardware/applymanage/yiYunApproveSubmit',
        method: 'post'
    },
    commApproveSubmit: { //根据id对申请进行审批
        url: '/api/hardware/applymanage/commApproveSubmit',
        method: 'post'
    },
}
const softhardApiList = { ...serviceModule }

export default softhardApiList