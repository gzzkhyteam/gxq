package com.hengyunsoft.platform.hardware.repository.manage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyManageDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.OrgServerCountDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.PanelOrgCpuCountDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.PanelOrgMonthCpuDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.ServerCountDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.ServerManageChangeReqDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.ServerManageResDO;
import com.hengyunsoft.platform.hardware.entity.manage.domian.ServersCountByMonthDO;
import com.hengyunsoft.platform.hardware.entity.manage.po.ServerManage;
import com.hengyunsoft.platform.hardware.repository.manage.dao.ServerManageMapper;
import com.hengyunsoft.platform.hardware.repository.manage.example.ServerManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.ServerManageService;

@Service
public class ServerManageServiceImpl extends BaseServiceImpl<Long, ServerManage,ServerManageExample> implements ServerManageService {

    @Autowired
    ServerManageMapper serverManageMapper;

    @Override
    protected BaseNormalDao<Long, ServerManage,ServerManageExample> getDao() {
        return serverManageMapper;
    }

    @Override
    public ServerManage saveServer(ServerManage server) {
        setSaveTime(server);
        int re = serverManageMapper.insertSelective(server);
        if(re>0){
            return server;
        }
        return null;
    }

    protected void setSaveTime(ServerManage server) {
            Date nowDate = new Date();
            if(server.getCreateTime() == null){
                server.setCreateTime(nowDate);
            }
            if(server.getUpdateTime() == null){
                server.setUpdateTime(nowDate);
            }
    }

    @Override
    public ServerManage saveInit(ServerManage server){
        if (server == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        Long id = genId();
        setSaveTimes(server);
        server.setId(id);
        server.setPid(-1l);
        server.setOriginId(id);
        server.setChangeCount(0);
        server.setChangeFlag(false);
        getDao().insert(server);
        return server;
    }

    /**
     * 查询服务分配管理分页
     * @param obj
     * @return
     */
    @Override
    public List pageNewest(ServerManage obj) {
        return serverManageMapper.pageNewest(obj);
    }

    /**
     * 查找变更历史
     * @param obj
     * @return
     */
    @Override
    public List findServerManageChange(ServerManageChangeReqDO obj) {
        return serverManageMapper.findServerManageChange(obj);
    }

    /**
     * 查询内存总容量
     * @return
     */
    @Override
    public ServerCountDO getAllMemorySize() {
        return serverManageMapper.getAllMemorySize();
    }

    /**
     * 查询磁盘总容量
     * @return
     */
    @Override
    public long getAllDiskSize() {
        return serverManageMapper.getAllDiskSize();
    }

    /**
     * 查询各单位服务器数量统计
     * @return
     */
    @Override
    public List<OrgServerCountDO> getOrgServersCount() {
        return serverManageMapper.getOrgServersCount();
    }

    /**
     * 查询每月服务器数量
     * @param startMonth
     * @param endMonth
     * @return
     */
    @Override
    public List<ServersCountByMonthDO> getServersCountByMonth(String startMonth, String endMonth) {
        return serverManageMapper.getServersCountByMonth(startMonth,endMonth);
    }

    /**
     * 查询存储管理，计算资源管理，带宽管理等数据
     * @param manage
     * @return
     */
    @Override
    public List<ServerManageResDO> getServerManageRes(ServerManageResDO manage) {
        return serverManageMapper.getServerManageRes(manage);
    }
    
    /**
	 * 获取所有的部门
	 * @return
	 */
	@Override
	public List<String> getOrgnamelist() {
		
		return serverManageMapper.getOrgnamelist();
	}
    /**
     * 网络带宽面板
     * 网络带宽面板  本月 统计 
     * thisMonth 本月（2018-01）
     * @return
     */
	@Override
	public List<Map> getThisMonthStatistics(Date thisMonth) {
		
		return serverManageMapper.getThisMonthStatistics(thisMonth);
	}
	 /**
     * 网络带宽面板
     * 网络带宽面板  各部门网络带宽统计 
     * thisMonth 本月（2018-01）
     * @return
     */
	@Override
	public List<Map> getEachOrgNetWorkBandwidthMonthStatistics(Date thisMonth) {

		return serverManageMapper.getEachOrgNetWorkBandwidthMonthStatistics(thisMonth);
	}
	/**
     * 网络带宽面板
     * 网络带宽面板  各部门网络带宽统计 
     * thisMonth 12月
     * @return
     */
	@Override
	public List<Map> getEachOrgNetWorkBandwidthYearStatistics(@Param("thisMonth")Date thisMonth) {

		return serverManageMapper.getEachOrgNetWorkBandwidthYearStatistics(thisMonth);
	}
    /**
     * 查询cpu总和
     * @return
     */
    @Override
    public int getAllSumOfCpu() {
        return serverManageMapper.getAllSumOfCpu();
    }

    /**
     * 查询本月cpu核数统计情况
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public int getMonthAddCpuRes(String startTime, String endTime) {
        return serverManageMapper.getMonthAddCpuRes(startTime,endTime);
    }

    /**
     * 本月cpu回收情况
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public int getMonthSubCpuRes(String startTime, String endTime) {
        return serverManageMapper.getMonthSubCpuRes(startTime,endTime);
    }

    /**
     * 查询各单位cpu资源情况
     * @return
     */
    @Override
    public List<PanelOrgCpuCountDO> getPanelOrgCpuRes() {
        return serverManageMapper.getPanelOrgCpuRes();
    }

    /**
     * 查询各单位每月cpu资源
     * @param startMonth
     * @param endMonth
     * @return
     */
    @Override
    public List<PanelOrgMonthCpuDO> getPanelMonthOrgCpuRes(String startMonth, String endMonth) {
        return serverManageMapper.getPanelMonthOrgCpuRes(startMonth,endMonth);
    }
    /**
     * 获取所有基本的服务器信息
     */
	@Override
	public List<ApplyManageDO> findServerManage() {
		
		return serverManageMapper.findServerManage();
	}
}
