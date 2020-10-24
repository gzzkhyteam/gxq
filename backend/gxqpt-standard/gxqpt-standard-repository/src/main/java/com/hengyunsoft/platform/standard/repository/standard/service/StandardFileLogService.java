package com.hengyunsoft.platform.standard.repository.standard.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileLogDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardDownloadDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFileLog;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileLogExample;

public interface StandardFileLogService extends BaseAllService<Long, StandardFileLog, StandardFileLogExample> {
    /**
     * 统计文档下载TOP10
     * @param startDate
     * @param endDate
     * @return
     */
    public List<StandardFileLogDO> statDownloadTop10(Date startDate, Date endDate);

    /**
     * 统计各类文档下载次数
     * @param startDate
     * @param endDate
     * @return
     */
    public List<StandardFileLogDO> statByClassify(Date startDate, Date endDate,String parentId);
    /**
     * 标准文档下载数量TOP20
     * @return
     */
    List<StandardDownloadDO> getDownloadTop20();
    /**
     * 标准分类分析
     * @return
     */
    List<StandardDownloadDO> getDownloadType();
    /**
     * XX标准文档下载数量TOP10
     * @return
     */
    List<StandardDownloadDO> getDownloadTop10(Long typeId);
    /**
     * XX标准文档下载趋势
     * @return
     */
    List<StandardMonthDO> getDownloadTrend(Long typeId,Date date);
    /**
     * 标准下载数量
     * @return
     */
    Integer getStandardDownloadNum();
    /**
     * 本月标准下载数量
     * @return
     */
    Integer getMonthStandardDownloadNum(Date date);
    /**
     *  获取标准分类一级目录的所有资源
     */ 
	List<Map<String,Object>> getStandardClassifyFirstLevelDirectory();
	/**
	 * 标准分类
     * 递归统计
     */ 
	public Integer getRecursionCount(Long id);
	
	
}
