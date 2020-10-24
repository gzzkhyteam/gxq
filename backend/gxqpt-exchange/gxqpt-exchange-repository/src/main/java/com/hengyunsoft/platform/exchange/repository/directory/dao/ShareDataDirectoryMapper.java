package com.hengyunsoft.platform.exchange.repository.directory.dao;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryAuditDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryDictDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDataDirectoryMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, ShareDataDirectory, com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryExample> {
    /**
     * 根据父id查询列表
     * @param parentId  上级ID
     */
    List<ShareDataDirectory> findByParentId(Long parentId);

    /**
     * 查询所有数据目录列表
     * @param
     */
    List<ShareDataDirectory> getAllList();

    /**
     * 根据单位id查询所有数据目录列表
     * @param
     */
    List<ShareDataDirectory> findByParentIdAndUnitId(Long unitId);
    /**
     * 查询数据目录变动记录
     * @param
     */
    List<ShareDataDirectory> getDirectoryChangeList(@Param("applyCode") String applyCode);
    /**
     * 查询申请发布目录变动信息
     * @param
     */
    List<ShareDataDirectory> getDirectoryChangeListApply(@Param("unitId") String unitId, @Param("status") Integer status);
    /**
     * 查询共享单位
     * @param
     */
    List<VOrgDO> getOrgList();
    /**
     * 根据id查询目录
     * @param id 主键id
     */
    ShareDataDirectoryDictDO getDictCodeList(Long id);
    /**
     * 根据id查询目录发布表
     * @param id 主键id
     */
    ShareDataDirectoryDictDO getDictCodeWareList(Long id);
    /**
     * 查询待审核目录
     * @param
     */
    List<ShareDataDirectoryAuditDO> getDirectoryTask(Map map);
    /**
     * @todo 更新元目录的查看次数
     * @param  id 元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    void updateSeeCount(@Param("id") String id);

    /**
     * 获取本单位外所有数据目录
     * @param dataType
     * @param unitId
     */
    List<ShareDataDirectory> getDataTypeList(@Param("dataType") Integer dataType, @Param("unitId") String unitId);

    /**
     *  根据数据类型查询目录及子目录
     * @param unitId dataType
     */
    List<ShareDataDirectory> getUnitDataTypeList(@Param("unitId") Long unitId, @Param("dataType") Integer dataType);
    /**
     * 查询变动表中只有字段而没有该字段的目录id 的目录id
     * @param unitId
     * @param applyCode
     * @return
     */
    List<ShareDataDirectory> getChangeDirListByApplyCode(@Param("unitId") String unitId, @Param("applyCode") String applyCode);

    /***
     * 更新数据集id为null
     * @param id
     * @param setId
     */
    void updateSetIdToNull(@Param("id") long id, @Param("setId") long setId);
    /***
     * 更新数据集id为
     * @param id
     * @param setId
     */
    void updateSetId(@Param("id") long id, @Param("setId") long setId);

    /**
     * 查询变动字段的目录信息
     * @param unitId
     * @param applyCode
     * @param busType
     * @return
     */
    List<ShareDataDirectory>  findChangeDirList(@Param("unitId") String unitId, @Param("applyCode") String applyCode, @Param("busType") Integer busType);

    List<ShareDataDirectory> getAllTreeUnUnit(@Param("unitId") String unitId);

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