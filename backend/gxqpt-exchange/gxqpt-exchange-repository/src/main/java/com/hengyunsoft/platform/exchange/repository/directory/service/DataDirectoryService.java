package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryAuditDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryDictDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryExample;

import java.util.List;
import java.util.Map;

public interface DataDirectoryService extends BaseAllService<Long, ShareDataDirectory, ShareDataDirectoryExample> {


    /**
     * 根据父id查询列表
     *
     * @param parentId 上级ID
     */
    List<ShareDataDirectory> findByParentId(Long parentId);


    /**
     * 查询目录及子目录
     *
     * @param id 主键id
     */
    List<ShareDataDirectory> getDirectoryList(Long id);

    /**
     * 根据id查询目录
     *
     * @param id 主键id
     */
    ShareDataDirectoryDictDO getDictCodeList(Long id);

    /**
     * 根据id查询目录发布表
     *
     * @param id 主键id
     */
    ShareDataDirectoryDictDO getDictCodeWareList(Long id);

    /**
     * 根据数据类型查询目录及子目录
     *
     * @param
     * @param unitId
     */
    List<ShareDataDirectory> getDataTypeList(Integer dataType, String unitId);

    /**
     * 获取本单位外所有数据目录数
     *
     * @param unitId dataType
     */
    List<ShareDataDirectory> getUnitDataTypeList(Long unitId, Integer dataType);

    /**
     * 查询目录及子目录
     *
     * @param
     */
    List<ShareDataDirectory> getAllList();

    /**
     * 查询目录及子目录
     *
     * @param unitId parentId
     */
    List<ShareDataDirectory> getUnitDirectoryList(Long unitId);

    /**
     * 查询数据目录变动记录
     *
     * @param
     */
    List<ShareDataDirectory> getDirectoryChangeList(String applyCode);

    /**
     * 查询申请发布目录变动信息
     *
     * @param
     */
    List<ShareDataDirectory> getDirectoryChangeListApply(String unitId, Integer status);

    /**
     * 查询数据目录变动记录
     *
     * @param
     */
    List<VOrgDO> getOrgList();


    /**
     * 查询待审核目录
     *
     * @param
     */
    List<ShareDataDirectoryAuditDO> getDirectoryTask(Map<String, Object> map);

    /**
     * @param id 元目录id
     * @return boolean
     * @todo 更新元目录的查看次数
     * @Author wgj
     * @createtime 2018-4-22
     */
    void updateSeeCount(String id);

    /**
     * 查询变动表中只有字段而没有该字段的目录id 的目录id
     *
     * @param unitId
     * @param applyCode
     * @return
     */
    List<ShareDataDirectory> getChangeDirListByApplyCode(String unitId, String applyCode);

    /***
     * 更新目录的数据集id为null
     * @param id 目录id
     * @param setId 数据集id
     */
    void updateSetIdToNull(long id, long setId);

    /***
     * 更新数据集id
     * @param id
     * @param setId
     */
    void updateSetId(long id, long setId);

    /**
     * 查询变动字段的目录信息
     * @param unitId
     * @param applyCode
     * @param busType
     * @return
     */
    List<ShareDataDirectory>  findChangeDirList(String unitId, String applyCode,Integer busType);

    List<ShareDataDirectory>  getAllTreeUnUnit(String unitId);

    /**
     * 批量更新目录信息
     * @param dataDirectoryList
     */
    void batchUpdate(List<ShareDataDirectory>  dataDirectoryList);

    /**
     * 批量保存目录信息到发布表
     * @param dataDirectoryList
     */
    void batchSave(List<ShareDataDirectory>  dataDirectoryList);

}
