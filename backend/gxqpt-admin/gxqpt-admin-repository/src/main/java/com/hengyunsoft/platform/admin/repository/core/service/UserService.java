package com.hengyunsoft.platform.admin.repository.core.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.core.domain.UserManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptUserDO;

import java.util.List;

public interface UserService extends BaseService<Long, User, UserExample> {

    User getLogin(String account, String password);

    /***
     * 根据id查询可用的用户
     * @param userId
     * @return
     */
    User getAvailableById(Long userId);

    int isAdminManager(Long id);

    /**
     * 描述：通過应用Id和角色编码获取绑定的用户账号列表
     * 参数：gxqptUserDT
     * 返回值：List<User>  用户集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/27
     * 修改内容：
     */
    List<User> findUserByAppIdAndCode(GxqptUserDO gxqptUserDT);

    /**
     * 根据emp的id查询所对应user
     *
     * @param id
     * @return
     */
    User findUserByEmp(String id);

    /**
     * 根据appId查询对应应用的管理员user
     *
     * @param appId
     * @return
     */
    List<UserManagerDO> findUserManagerByApp(String account, String name, String appId);

    /**
     * 根据appId查询对应应用的管理员user
     *
     * @param appId
     * @return
     */
    List<User> findUserManagerByApp(String appId);

    /**
     * 查询主机管理员列表
     *
     * @param hostId
     * @return
     */
    List<User> hostAdminList(String hostId, String name, Long userId,String account);

    /**
     * 获取主机创建人
     *
     * @return
     */
    List<User> findHostCreateUser();

    /**
     * 单位管理员绑定查询
     *
     * @param systemCode
     * @param orgId
     * @return
     */
    List pageManagerByOrg(String orgId);

    /**
     * (运维系统使用)根据appId查询对应应用的管理员user
     * @param appId
     * @return
     */
    User findUserManagerByAppId(String appId);
}
