package com.hengyunsoft.platform.exchange.repository.directory.dao;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDataChangeMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChange, com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeExample> {
    /**
     * 更新变动表
     * @param applyCode
     * @param status
     */
    void updateStatusByApplyCode(@Param("applyCode") String applyCode, @Param("status")Integer status);

    /**
     * 查询目录或者字段是否在发布在中
     * @param id
     * @return
     */
    List<ShareDataChange> getDirOrElement(Long id);
}