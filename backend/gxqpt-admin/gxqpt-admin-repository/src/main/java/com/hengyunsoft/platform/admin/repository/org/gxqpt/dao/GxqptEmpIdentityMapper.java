package com.hengyunsoft.platform.admin.repository.org.gxqpt.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpIdentityDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmpIdentity;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpIdentityExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptEmpIdentityMapper extends com.hengyunsoft.base.dao.BaseNormalDao<String, GxqptEmpIdentity,GxqptEmpIdentityExample> {
    /**
     * 查询人员身份列表数据
     * @param identity
     * @return
     */
    List<GxqptEmpIdentityDO> getEmpIdentity(GxqptEmpIdentity identity);

    /**
     * 根据id查询人员身份信息
     * @param id
     * @return
     */
    GxqptEmpIdentityDO getEmpIdentityById(@Param("id") String id);
}