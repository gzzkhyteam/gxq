package com.hengyunsoft.platform.admin.repository.authority.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.core.domain.AssignRoleManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色-用户Service
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
public interface AssignRoleService extends BaseService<Long, AssignRole, AssignRoleExample> {
    /**
     * 描述：根据属性匹配删除
     * 参数：RolePowerExample 角色资源Example
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    void deleteAssignRoleByEntity(AssignRoleExample example);

    /**
     * 维护应用管理员(取消关联)
     *
     * @param userId
     * @param appId
     * @return
     */
    int deleteAssignRoleByAppAndUser(Long userId, String appId);

    /**
     * 维护应用管理员(关联)
     *
     * @param assignRole
     * @return
     */
    int insertAssignRoleByAppAndUser(AssignRoleManagerDO assignRole);

    /**
     * 保存主机关联
     *
     * @param roleId
     */
    void saveRelate(Long roleId, Long userId);

    /**
     * 单位管理员维护(关联)
     *
     * @param assignRole
     * @return
     */
    int insertAssignRoleByOrgAndUser(AssignRoleManagerDO assignRole);

    /**
     * 单位管理员维护(取消关联)
     *
     * @param userId
     * @param orgId
     * @return
     */
    int deleteAssignRoleByOrgAndUser(Long userId, String orgId);
}
