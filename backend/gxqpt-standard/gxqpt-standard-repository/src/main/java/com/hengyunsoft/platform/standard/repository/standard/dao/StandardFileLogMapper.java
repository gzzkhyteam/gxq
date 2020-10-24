package com.hengyunsoft.platform.standard.repository.standard.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileLogDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardDownloadDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;

@Repository
public interface StandardFileLogMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.standard.entity.standard.po.StandardFileLog, com.hengyunsoft.platform.standard.repository.standard.example.StandardFileLogExample> {
    /**
     * 统计文档下载TOP10
     * @param startDate
     * @param endDate
     * @return
     */
    public List<StandardFileLogDO> statDownloadTop10(@Param("startDate")Date startDate, @Param("endDate")Date endDate);

    /**
     * 统计各类文档下载次数
     * @param startDate
     * @param endDate
     * @return
     */
    public List<StandardFileLogDO> statByClassify(@Param("startDate")Date startDate, @Param("endDate")Date endDate,@Param("parentId")String parentId);
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
    List<StandardDownloadDO> getDownloadTop10(@Param(value="nodeIds") List<Long> nodeIds);
    /**
     * XX标准文档下载趋势
     * @return
     */
    List<StandardMonthDO> getDownloadTrend(@Param(value="nodeIds")List<Long> nodeIds,@Param(value="date") Date date);
    /**
     * 标准下载数量
     * @return
     */
    Integer getStandardDownloadNum();
    /**
     * 本月标准下载数量
     * @return
     */
    Integer getMonthStandardDownloadNum(@Param(value="date")Date date);
    /**
     *  获取标准分类一级目录的所有资源
     */ 
    List<Map<String,Object>> getStandardClassifyFirstLevelDirectory();
    /**
     * 统计所有的数据
     * @return
     */
    List<Map<String,Object>>  getALLCount(List<Long> list);
    /**
     * 根据ID获取统计数据
     * @param id
     * @return
     */
	int getAtandardClassifyByIdCount(@Param(value="id")Long id);
	/**
     * 根据pId获取统计数据
     * @param pId
     * @return
     */
	List<Long> getParentIdChildId(Long pId);
	/**
     * 根据父级ID集合获取子级ID集合
     * @param childs
     * @return
     */
	public List<Long> findCurrentChildNodeId(@Param(value="childs")List<Long> childs);
}