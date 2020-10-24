package com.hengyunsoft.platform.ops.repository.consult.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.consult.domain.ConsultManageDO;
import com.hengyunsoft.platform.ops.entity.consult.po.ConsultManage;
import com.hengyunsoft.platform.ops.repository.consult.example.ConsultManageExample;

import java.util.List;
import java.util.Map;

/**
 * Created by kevin on 2018/7/11.
 */
public interface ConsultManageService extends BaseService<Long,ConsultManage,ConsultManageExample> {

    /**
     * 查询登陆人咨询列表
     * @param
     */
    List<ConsultManageDO> getApplyPageList(Map<String, Object> param);


    /**
     * 查询咨询审批列表
     * @param
     */
    List<ConsultManageDO> getDealPageList(Map<String, Object> param);

    /**
     * 查询咨询处理列表
     * @param
     */
    List<ConsultManageDO> getHandlePageList(Map<String, Object> param);
}
