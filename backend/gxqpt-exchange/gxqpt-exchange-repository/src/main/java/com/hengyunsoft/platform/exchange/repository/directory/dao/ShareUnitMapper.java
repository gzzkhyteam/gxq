package com.hengyunsoft.platform.exchange.repository.directory.dao;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareUnitMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit, com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample> {
    /**
     * 根据目录id查询共享单位id
     * @param dirId
     * @return
     */
    List<String> getUnitListByDirId(@Param("dirId") Long dirId);
    /**
     * 删除共享单位
     * @param chgId
     */
    void deleteByDirId(@Param("dirId")Long dirId);

    /**
     * 批量更新目录共享单位
     * @param shareUnitList
     */
    void batchUpdate(List<ShareUnit>  shareUnitList);
}