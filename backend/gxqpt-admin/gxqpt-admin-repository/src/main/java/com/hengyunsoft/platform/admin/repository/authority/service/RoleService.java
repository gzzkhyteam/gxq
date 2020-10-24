package com.hengyunsoft.platform.admin.repository.authority.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.OrgBaseInfo;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色Service
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
public interface RoleService extends BaseService<Long, Role, RoleExample> {
    @Deprecated
    Short ENABLE_ROLE_STATUS = RoleCode.ENABLE_ROLE_STATUS;
    @Deprecated
    Short DISABLE_ROLE_STATUS = RoleCode.DISABLE_ROLE_STATUS;

    /**
     * 描述：获取当前应用下所有单位基础信息
     * 参数：appId 应用Id
     * 返回值：List<RoleOrgDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    List<OrgBaseInfo> queryBaseOrgInfo(String appId);

    /**
     * 保存角色以及为用户分配此角色
     *
     * @param adminRole
     * @param assignUserIds
     * @return
     */
    Role saveRoleAndAssign(Role role, List<Long> assignUserIds);

    //主机角色编码
    @Deprecated
    String host_admin_code = RoleCode.HOST_ADMIN_CODE;
    //应用角色编码
    @Deprecated
    String application_admin_code = RoleCode.APPLICATION_ADMIN_CODE;
    @Deprecated
    //高新区平台管理员角色
    String gxq_pt_admin_code = RoleCode.GXQ_PT_ADMIN_CODE;
    @Deprecated
    //单位管理员角色
    String org_admin_code = RoleCode.ORG_ADMIN_CODE;

    void saveHostAdmin(Role role);

    Long findRoleIdByBizFlag(Long hostId);

    /**
     * 查询指定用户所拥有的角色
     *
     * @param example 作为过滤条件   null标示查询所有
     * @param userId  查找的用户Id
     * @return 用户拥有的所有角色
     */
    List<Role> findUserRole(RoleExample example, Long userId);

    /**
     * 将指定的用户加入到制定的角色中去。
     *
     * @param code   角色编码    不允许为空
     * @param userId 用户id  不允许为空
     * @param appId  应用id  为空，表示角色类型不限，不为空，就代表需要的角色是哪个应用的
     * @return 保存的授权信息
     */
    AssignRole joinRole(String code, Long userId, String appId);

    /**
     * 查询指定角色集合的用户列表（已去重）
     *
     * @param example 筛选角色
     * @return 满足指定角色集合的用户列表
     */
    List<Long> findUsers(RoleExample example);

    /**
     * 移除用户角色  通过用户id及角色编码
     * @param userId
     * @param roleCode
     * @return
     */
	void removeUserFormRole(Long userId, String roleCode);
}
