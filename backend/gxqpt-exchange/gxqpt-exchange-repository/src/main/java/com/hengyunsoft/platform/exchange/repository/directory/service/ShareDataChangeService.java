package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChange;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeExample;

import java.util.List;

public interface ShareDataChangeService extends BaseAllService<Long,ShareDataChange,ShareDataChangeExample> {
    /**
     * 更新变动表
     * @param applyCode
     * @param status
     */
    void updateStatusByApplyCode(String applyCode, int status);
    /**
     * 查询目录或者字段是否在发布在中
     * @param id
     * @return
     */
    List<ShareDataChange> getDirOrElement(Long id);
}
