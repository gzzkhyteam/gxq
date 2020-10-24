package com.hengyunsoft.platform.admin.repository.core.dao;


import com.hengyunsoft.platform.admin.entity.core.domain.UserManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptUserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.admin.entity.core.po.User, com.hengyunsoft.platform.admin.repository.core.example.UserExample> {
    int isAdminManager(@Param("id") Long id);

    List<User> seleteUserByAppIdAndCode(GxqptUserDO gxqptUserDO);

    User findUserByEmp(String id);

    List<UserManagerDO> findUserManagerByApp(@Param("account") String account,
                                             @Param("name") String name,
                                             @Param("appId") String appId);

    List<User> findUserOnlyManagerByApp(@Param("appId")String appId);

    /**
     * 查询主机管理员列表
     * @param hostId
     * @return
     */
    List<User> hostAdminList(@Param("hostId") String hostId,@Param("name") String name,@Param("userId") Long userId,@Param("account") String account);

    /**
     * 获取主机创建人
     * @return
     */
    List<User> findHostCreateUser();

    /**
     * 单位管理员绑定查询
     * @param orgId
     * @return
     */
    List pageManagerByOrg(@Param("orgId") String orgId);

    /**
     * (运维系统使用)根据appId查询对应应用的管理员user
     * @param appId
     * @return
     */
    User findUserManagerByAppId(@Param("appId") String appId);

    /**
     * 交集标记位，就是和andBit去交集（&）
     * @param andBit  交集
     * @param date 
     * @return 影响行数
     */
	int andSyncFlag(@Param("andBit") long andBit,@Param("minUpdateTime") Date minUpdateTime);

	
	int orSyncFlag(@Param("userIds") List<Long> userIds,@Param("orBit") long orBit);

	/**
	 * 查询同步数据
	 * @param syncFlag
	 * @param limit
	 * @param date
	 * @return
	 */
	List<User> selectSyncList(@Param("syncFlag") Long syncFlag,@Param("minUpdateTime") Date minUpdateTime,@Param("limit") Integer limit);

	String getIdsAbstract();

	/**
	 * 找出存在于数据库中的id集合
	 * @param ids
	 * @return
	 */
	List<Long> getExistIds(@Param("userIds") List<Long> userIds);
}