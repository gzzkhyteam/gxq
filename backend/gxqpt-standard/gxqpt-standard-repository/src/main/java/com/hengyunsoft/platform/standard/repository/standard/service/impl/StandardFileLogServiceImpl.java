package com.hengyunsoft.platform.standard.repository.standard.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileLogDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardDownloadDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFileLog;
import com.hengyunsoft.platform.standard.repository.standard.dao.StandardFileLogMapper;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileLogExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileLogService;

@Service
public class StandardFileLogServiceImpl extends BaseAllServiceImpl<Long, StandardFileLog, StandardFileLogExample> implements StandardFileLogService {
    @Autowired
    private StandardFileLogMapper standardFileLogMapper;
    @Autowired
    private StandardClassifyService standardClassifyService;

    @Override
    protected BaseNormalDao<Long, StandardFileLog, StandardFileLogExample> getDao() {
        return standardFileLogMapper;
    }

    /**
     * 统计文档下载TOP10
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<StandardFileLogDO> statDownloadTop10(Date startDate, Date endDate) {
        PageHelper.startPage(1,10);
        List<StandardFileLogDO> list = standardFileLogMapper.statDownloadTop10(startDate,endDate);
        return list;
    }
    /**
     * 统计各类文档下载次数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<StandardFileLogDO> statByClassify(Date startDate, Date endDate,String parentId) {
        return standardFileLogMapper.statByClassify(startDate,endDate,parentId);
    }

    /**
     * 标准文档下载数量TOP20
     * @return
     */
	@Override
	public List<StandardDownloadDO> getDownloadTop20() {
		return standardFileLogMapper.getDownloadTop20();
	}
    /**
     * 标准分类分析
     * @return
     */
	@Override
	public List<StandardDownloadDO> getDownloadType() {
		return standardFileLogMapper.getDownloadType();
	}
	
    /**
     * XX标准文档下载数量TOP10
     * @return
     */
	@Override
	public List<StandardDownloadDO> getDownloadTop10(Long typeId) {
		List<Long> list =  new ArrayList<Long>();
		list.add(typeId);
		List<Long> nodeIds = standardClassifyService.findCurrentChildNodeIds(list);
		
		return standardFileLogMapper.getDownloadTop10(nodeIds);
	}
	
    /**
     * XX标准文档下载趋势
     * @return
     */
	@Override
	public List<StandardMonthDO> getDownloadTrend(Long typeId, Date date) {
		List<Long> list =  new ArrayList<Long>();
		list.add(typeId);
		List<Long> nodeIds = standardClassifyService.findCurrentChildNodeIds(list);
		
		return standardFileLogMapper.getDownloadTrend(nodeIds,date);
	}
    /**
     * 标准下载数量
     * @return
     */
	@Override
	public Integer getStandardDownloadNum() {
		return standardFileLogMapper.getStandardDownloadNum();
	}
    /**
     * 本月标准下载数量
     * @return
     */
	@Override
	public Integer getMonthStandardDownloadNum(Date date) {
		return standardFileLogMapper.getMonthStandardDownloadNum(date);
	}
	/**
     *  获取标准分类一级目录的所有资源
     */ 
	@Override
	public List<Map<String,Object>> getStandardClassifyFirstLevelDirectory() {
		
		return standardFileLogMapper.getStandardClassifyFirstLevelDirectory();
	}
	/**
	 * 标准分类
     * 递归统计
     */ 
	@Override
	public Integer getRecursionCount(Long id) {
		// 初始化本身数据
		int num = standardFileLogMapper.getAtandardClassifyByIdCount(id);
		return getChildNum(id)+num;
	}
	
	private int getChildNum(Long pId) {
		List<Long> list = standardFileLogMapper.getParentIdChildId(pId);
		int num = 0;
		if(list!=null && list.size()>0) {
			List<Map<String,Object>> fileLog = standardFileLogMapper.getALLCount(list);
			num += fileLog.size();
			for(Long fl: list){
				num +=  getChildNum(fl);
			}
		}
		return num;
	}
	
}
