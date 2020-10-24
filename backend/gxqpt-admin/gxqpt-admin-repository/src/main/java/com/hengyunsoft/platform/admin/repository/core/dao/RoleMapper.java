package com.hengyunsoft.platform.admin.repository.core.dao;

import com.hengyunsoft.platform.admin.entity.core.po.OrgBaseInfo;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;

import java.util.List;

@Repository
public interface RoleMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.admin.entity.core.po.Role, RoleExample> {
    /**
     * 描述：获取当前应用下所有单位基础信息
     * 参数：appId 应用Id
     * 返回值：List<RoleOrgDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
   List<OrgBaseInfo> selectBaseOrgInfo(@Param("appId") String appId);

    /**
     * 根据主机id查询角色id
     * @param hostId
     * @return
     */
   Role findRoleIdByBizFlag(@Param("hostId") Long hostId);

   List<Role> selectUserRole(@Param("roleExample") RoleExample example,@Param("userId") Long userId);

   
   List<Long> findUsers(RoleExample example);
}