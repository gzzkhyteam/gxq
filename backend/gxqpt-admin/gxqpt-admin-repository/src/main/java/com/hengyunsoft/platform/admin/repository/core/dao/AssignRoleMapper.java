package com.hengyunsoft.platform.admin.repository.core.dao;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.platform.admin.entity.core.domain.AssignRoleManagerDO;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignRoleMapper extends BaseNormalDao<Long, com.hengyunsoft.platform.admin.entity.core.po.AssignRole, AssignRoleExample> {
    int deleteAssignRoleByAppAndUser(@Param(value = "userId") Long userId, @Param(value = "appId")String appId);

    int insertAssignRoleByAppAndUser(AssignRoleManagerDO assignRole);

    int insertAssignRoleByOrgAndUser(AssignRoleManagerDO assignRole);

    int deleteAssignRoleByOrgAndUser(@Param(value = "userId") Long userId, @Param(value = "orgId")String orgId);
}