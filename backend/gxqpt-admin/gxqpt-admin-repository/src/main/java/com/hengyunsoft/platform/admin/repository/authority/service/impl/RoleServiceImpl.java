package com.hengyunsoft.platform.admin.repository.authority.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.OrgBaseInfo;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.dao.RoleMapper;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample.Criteria;
import com.hengyunsoft.utils.BizAssert;

import lombok.extern.slf4j.Slf4j;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service.impl
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色Service实现
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Service
@Slf4j
public class RoleServiceImpl extends BaseServiceImpl<Long, Role, RoleExample> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AssignRoleService assignRoleService;

    @Override
    protected BaseNormalDao<Long, Role, RoleExample> getDao() {
        return roleMapper;
    }

    /**
     * 描述：获取当前应用下所有单位基础信息
     * 参数：appId 应用Id
     * 返回值：List<RoleOrgDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    @Override
    public List<OrgBaseInfo> queryBaseOrgInfo(String appId) {
        return roleMapper.selectBaseOrgInfo(appId);
    }

	@Override
	public Role saveRoleAndAssign(Role role, List<Long> assignUserIds) {
		
		role = super.save(role);
		if(assignUserIds == null || assignUserIds.size() ==0) {
			return role;
		}
		if(assignUserIds.size() == 1) {
			AssignRole entity = builderAssignRole(role, assignUserIds.get(0));
			assignRoleService.save(entity);
			return role;
		}
		ArrayList<AssignRole> allAssignRole = new ArrayList<>();
		for (Long assignUserId : assignUserIds) {
			
			allAssignRole.add(builderAssignRole(role, assignUserId));
		}
		assignRoleService.save(allAssignRole);
		return role;
	}

	/**
	 * 新增主机管理员角色
	 * @param role
	 */
	@Override
	public void saveHostAdmin(Role role) {
    	role.setId(genId());
    	role.setCreateTime(new Date());
    	role.setCreateUser(BaseContextHandler.getAdminId());
    	role.setDesc("新增主机管理员");
    	role.setCode("host");
    	role.setStatus((short) 1);
		roleMapper.insertSelective(role);
	}

	/**
	 * 根据主机id查询角色id
	 * @param hostId
	 * @return
	 */
	@Override
	public Long findRoleIdByBizFlag(Long hostId) {
		Role role = roleMapper.findRoleIdByBizFlag(hostId);
		Long id = role.getId();
		return  id;
	}

	private AssignRole builderAssignRole(Role role, Long assignUserId) {
		AssignRole entity  = new AssignRole();
		entity.setCreateTime(role.getCreateTime());
		entity.setCreateUser(role.getCreateUser());
		entity.setRoleId(role.getId());
		entity.setUserId(assignUserId);
		return entity;
	}

	@Override
	public List<Role> findUserRole(RoleExample example, Long userId) {
		
		BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
		return roleMapper.selectUserRole(example, userId);
	}

	@Override
	public AssignRole joinRole(String roleCode, Long userId, String appId) {
		
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria().andCodeEqualTo(roleCode);
		if(appId == null) {
			criteria.andPtRoleEqualTo(true);
		} else {
			criteria.andAppIdEqualTo(appId);
		}
		Role role = roleMapper.selectEntity(example);
		if(role == null) {
			return null;
		}
		AssignRole assignRole = builderAssignRole(role, userId);
		return assignRoleService.save(assignRole);
	}

	@Override
	public List<Long> findUsers(RoleExample example) {
		
		
		return roleMapper.findUsers(example);
	}

	@Override
	public void removeUserFormRole(Long userId, String roleCode) {
		
		RoleExample example = new RoleExample();
		example.createCriteria().andCodeEqualTo(roleCode);
		Role role = getUnique(example );
		if(role == null) {
			return ;
		}
		AssignRoleExample assignRoleExample = new AssignRoleExample();
		
		assignRoleExample.createCriteria().andUserIdEqualTo(userId).andRoleIdEqualTo(role.getId());
		
		assignRoleService.deleteAssignRoleByEntity(assignRoleExample);
	}
}
