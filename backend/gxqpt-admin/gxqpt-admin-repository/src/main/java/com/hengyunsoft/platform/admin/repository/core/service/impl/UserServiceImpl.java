package com.hengyunsoft.platform.admin.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.constant.BooleanStatus;
import com.hengyunsoft.data.sync.server.IIncrementDataSync;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.admin.entity.core.domain.UserManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.core.dao.UserMapper;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseServiceImpl<Long, User, UserExample> implements UserService,IIncrementDataSync<Long> {

	@Autowired
	private UserMapper userMapper;
	@Override
	protected BaseNormalDao<Long, User,UserExample> getDao() {
		return userMapper;
	}
	@Override
	public User getLogin(String account, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
		return userMapper.selectEntity(example );
	}

    @Override
    public User getAvailableById(Long userId) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(userId).andLoginableEqualTo(BooleanStatus.TRUE.getVal());
        return userMapper.selectEntity(example);
    }

    @Override
    public int isAdminManager(Long id) {
        return userMapper.isAdminManager(id);
    }

	@Override
	public List<User> findUserByAppIdAndCode(GxqptUserDO gxqptUserDT) {
		return userMapper.seleteUserByAppIdAndCode(gxqptUserDT);
	}

	@Override
	public User findUserByEmp(String id) {
		return userMapper.findUserByEmp(id);
	}

	@Override
	public List<UserManagerDO> findUserManagerByApp(String account, String name, String appId) {
		return userMapper.findUserManagerByApp(account,name,appId);
	}

	@Override
	public List<User> findUserManagerByApp(String appId) {
		return userMapper.findUserOnlyManagerByApp(appId);
	}

	/**
	 * 查询主机管理员列表
	 * @param hostId
	 * @return
	 */
	@Override
	public List<User> hostAdminList(String hostId,String name,Long userId,String account) {
		List<User> users = userMapper.hostAdminList(hostId, name, userId,account);
		return users;
	}

	/**
	 * 获取主机创建人
	 * @return
	 */
	@Override
	public List<User> findHostCreateUser() {
		List<User> user=userMapper.findHostCreateUser();
		return  user;
	}

	@Override
	public List pageManagerByOrg(String orgId) {
		return userMapper.pageManagerByOrg(orgId);
	}

	@Override
	public User findUserManagerByAppId(String appId) {
		return userMapper.findUserManagerByAppId(appId);
	}
	@Override
	public List<User> sync(int syncFlag, Integer limit, long minUpdateTime) {
		

		long syncFlagBit = getSyncFlagBit(syncFlag);
		List<User> users = userMapper.selectSyncList(syncFlagBit,new Date(minUpdateTime),limit);
		if(CollectionUtils.isEmpty(users)) {
			return Collections.EMPTY_LIST ;
		}
		List<Long> userIds = users.stream().map(user -> user.getId()).collect(Collectors.toList());
		long bitIndex = getSyncFlagBit(syncFlag);
		userMapper.orSyncFlag(userIds,bitIndex);
		return users;
	}
	
	@Override
	public int updateCleanSyncFlag(int syncFlag, long minUpdateTime) {
		
		long bitIndex = getSyncFlagBit(syncFlag);
		//除了指定位为0外，其他位都为1，
		return userMapper.andSyncFlag(~bitIndex,new Date(minUpdateTime));
	}
	private long getSyncFlagBit(int syncFlag) {
		if(syncFlag < 1 || syncFlag > 64) {
			throw new BizException(-1, "同步标记必须在区间[1,64]");
		}
		
		return 1L << (syncFlag-1);
	}
	@Override
	public boolean idsAbstractAndRowCountMach(String idAbstract, Integer idCount) {
		
		Integer rows = userMapper.countByExample(null);
		if(!rows.equals(idCount)) {
			return false;
		}
		
		String abstractDB = userMapper.getIdsAbstract();
		
		return abstractDB == null ? abstractDB == idAbstract : abstractDB.equals(idAbstract);
	}
	@Override
	public List<Long> getNotExistIds(List<Long> ids) {
		
		
		List<Long> existIds = userMapper.getExistIds(ids);
		if(CollectionUtils.isEmpty(existIds)) {
			return ids;
		}
		return ids.stream().filter(id->!existIds.contains(id)).collect(Collectors.toList());
	}
}
