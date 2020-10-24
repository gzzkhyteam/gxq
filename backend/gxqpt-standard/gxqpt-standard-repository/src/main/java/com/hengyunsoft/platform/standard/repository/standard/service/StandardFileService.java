package com.hengyunsoft.platform.standard.repository.standard.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardClassifyDO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardTypeDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.UploadCompanyDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFile;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileExample;

import java.util.Date;
import java.util.List;

public interface StandardFileService extends BaseAllService<Long, StandardFile, StandardFileExample> {

    List<StandardFileDO> pageDocument(StandardFileExample example);

    /**
     * 获取文件DO对象
     *
     * @param id
     * @return
     */
    public StandardFileDO getStandardFileDO(Long id);

    /**
     * 根据分类Id查询文件列表
     *
     * @param example
     * @return
     */
    public List<StandardFile> findFileListByClassifyId(StandardFileExample example);

    /**
     * 查询各分类下的文档数量
     *
     * @return
     */
    public List<StandardClassifyDO> findAllFileCount();

    /**
     * 标准上传单位TOP10
     *
     * @return
     */
    List<UploadCompanyDO> getCompanyTop10();

    /**
     * 类别标准数量TOP5（按类型分类）
     *
     * @return
     */
    List<StandardTypeDO> getTypeTop5();

    /**
     * XX标准文档上传单位top10
     *
     * @return
     */
    List<UploadCompanyDO> getUploadCompanyTop10(Long typeId);

    /**
     * XX标准数量分析
     *
     * @return
     */
    List<StandardMonthDO> getTypeCount(Long typeId, Date date);

    /**
     * 获取现有标准数量
     *
     * @return
     */
    Integer getStandardNum();

    /**
     * 获取本月新增标准数量
     *
     * @return
     */
    Integer getMonthStandardNum(Date date);

    /**
     * 获取现有标准失效数量
     *
     * @return
     */
    Integer getStandardInvalidNum();

    /**
     * 获取本月标准失效数量
     *
     * @return
     */
    Integer getMonthStandardInvalidNum(Date date);

    /**
     * 根据名称查询count
     */
    int getCountByName(String name);

}
