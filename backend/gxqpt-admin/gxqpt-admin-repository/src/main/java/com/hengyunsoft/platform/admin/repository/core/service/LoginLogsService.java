package com.hengyunsoft.platform.admin.repository.core.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.core.po.LoginLogs;
import com.hengyunsoft.platform.admin.repository.core.example.LoginLogsExample;

import java.util.List;
import java.util.Map;

public interface LoginLogsService extends BaseService<Long, LoginLogs, LoginLogsExample> {
    /**
     *  查询  访问用户数就是当天的登录次数,停留时间就是退出时间减去登录时间总和
     * @param nowDay
     * @param nextDay
     * @return
     */
    Map <String,String>getLoginAskCount(String nowDay, String nextDay);

    /**
     * 查询 活跃用户数就是当天的登录用户数
     * @param nowDay
     * @param nextDay
     * @return
     */
    int getLoginCount(String nowDay, String nextDay);

    /**
     *  通过主登录日志id去选择性更新数据，除了主键
     * @param entity
     */
	int updateByMasterLoginIdSelective(LoginLogs entity);

	LoginLogs saveLogSetMasterLogId(LoginLogs loginLog);

    List<LoginLogs> findByAppIdAndLoginDate(String appId, String beginDate);
}