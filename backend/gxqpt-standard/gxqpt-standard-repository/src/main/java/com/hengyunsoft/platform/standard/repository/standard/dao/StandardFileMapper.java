package com.hengyunsoft.platform.standard.repository.standard.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardClassifyDO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardTypeDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.UploadCompanyDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFile;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileExample;
@Repository
public interface StandardFileMapper extends BaseNormalDao<Long, StandardFile, StandardFileExample> {

    public List<StandardFileDO> queryStandardFileByPage(StandardFileExample example);

    /**
     * 获取文件DO对象
     * @param id
     * @return
     */
    public StandardFileDO getStandardFileDO(Long id);
    /**
     * 根据分类Id查询文件列表
     * @param example
     * @return
     */
    public List<StandardFile> selectByExample(StandardFileExample example);
    /**
     * 查询各分类下的文档数量
     * @return
     */
    public List<StandardClassifyDO> findAllFileCount();
    
    
    
    /**
     * 标准上传单位TOP10
     * @return
     */
    List<UploadCompanyDO> uploadCompanyTop10();
    /**
     * 类别标准数量TOP5（按类型分类）
     * @return
     */
    List<StandardTypeDO> getTypeTop5();
    /**
     * XX标准文档上传单位top10
     * @return
     */
    List<UploadCompanyDO> getUploadCompanyTop10(@Param(value="nodeIds") List<Long> nodeIds);
    /**
     * XX标准数量分析
     * @return
     */
    List<StandardMonthDO> getTypeCount(@Param(value="nodeIds")List<Long> nodeIds,@Param(value="date")Date date);
    /**
     * 获取现有标准数量
     * @return
     */
    Integer getStandardNum();
    /**
     * 获取本月新增标准数量
     * @return
     */
    Integer getMonthStandardNum(@Param(value="date")Date date);
    /**
     * 获取现有标准失效数量
     * @return
     */
    Integer getStandardInvalidNum();
    /**
     * 获取本月标准失效数量
     * @return
     */
    Integer getMonthStandardInvalidNum(@Param(value="date")Date date);
}