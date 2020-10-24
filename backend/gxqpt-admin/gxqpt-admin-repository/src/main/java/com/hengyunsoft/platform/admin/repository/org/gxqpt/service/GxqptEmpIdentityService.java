package com.hengyunsoft.platform.admin.repository.org.gxqpt.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpIdentityDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmpIdentity;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpIdentityExample;

import java.util.List;

/**
 * 描述:人员身份Service
 * @author chb
 * @date 2018/4/10 10:26 
 */
public interface GxqptEmpIdentityService extends BaseService<String, GxqptEmpIdentity, GxqptEmpIdentityExample> {
    /**
     * 查询人员身份分页列表数据
     * @param identity
     * @return
     */
    List<GxqptEmpIdentityDO> findPage(GxqptEmpIdentity identity);

    /**
     * 根据Id查询人员身份信息
     * @param id
     * @return
     */
    GxqptEmpIdentityDO getEmpIdentityById(String id);
}
