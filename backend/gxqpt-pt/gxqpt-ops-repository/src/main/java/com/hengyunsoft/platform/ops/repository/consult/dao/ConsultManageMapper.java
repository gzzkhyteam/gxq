package com.hengyunsoft.platform.ops.repository.consult.dao;

import com.hengyunsoft.platform.ops.entity.consult.domain.ConsultManageDO;
import com.hengyunsoft.platform.ops.entity.consult.po.ConsultManage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ConsultManageMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, ConsultManage, com.hengyunsoft.platform.ops.repository.consult.example.ConsultManageExample> {

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