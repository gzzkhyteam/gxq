package com.hengyunsoft.platform.admin.repository.authority.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.admin.entity.core.domain.AssignRoleManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.core.dao.AssignRoleMapper;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service.impl
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色-用户关联Service实现
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */
@Service
@Slf4j
public class AssignRoleServiceImpl extends BaseServiceImpl<Long, AssignRole, AssignRoleExample> implements AssignRoleService {
    @Autowired
    AssignRoleMapper assignRoleMapper;

    @Override
    protected BaseNormalDao<Long, AssignRole, AssignRoleExample> getDao() {
        return assignRoleMapper;
    }

    /**
     * 描述：根据属性匹配删除
     * 参数：RolePowerExample 角色资源Example
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    @Override
    public void deleteAssignRoleByEntity(AssignRoleExample example) {
        assignRoleMapper.deleteByExample(example);
    }

    @Override
    public int deleteAssignRoleByAppAndUser(Long userId, String appId) {
        return assignRoleMapper.deleteAssignRoleByAppAndUser(userId, appId);
    }

    @Override
    public int insertAssignRoleByAppAndUser(AssignRoleManagerDO assignRole) {
        return assignRoleMapper.insertAssignRoleByAppAndUser(assignRole);
    }

    /**
     * 保存主机关联
     */
    @Override
    public void saveRelate(Long roleId, Long userId) {
        AssignRole assignRole = new AssignRole();
        assignRole.setId(genId());
        assignRole.setCreateTime(new Date());
        assignRole.setCreateUser(BaseContextHandler.getAdminId());
        assignRole.setUserId(userId);
        assignRole.setRoleId(roleId);
        assignRoleMapper.insertSelective(assignRole);

    }

    /**
     * 单位管理员维护(关联)
     *
     * @param assignRole
     * @return
     */
    @Override
    public int insertAssignRoleByOrgAndUser(AssignRoleManagerDO assignRole) {
        return assignRoleMapper.insertAssignRoleByOrgAndUser(assignRole);
    }

    /**
     * 单位管理员维护(取消关联)
     *
     * @param userId
     * @param orgId
     * @return
     */
    @Override
    public int deleteAssignRoleByOrgAndUser(Long userId, String orgId) {
        return assignRoleMapper.deleteAssignRoleByOrgAndUser(userId, orgId);
    }
}
