package com.hengyunsoft.platform.admin.repository.core.dao;

import com.hengyunsoft.platform.admin.entity.core.po.LoginLogs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoginLogsMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.admin.entity.core.po.LoginLogs, com.hengyunsoft.platform.admin.repository.core.example.LoginLogsExample> {
    /**
     *  查询  访问用户数就是当天的登录次数,停留时间就是退出时间减去登录时间总和
     * @param nowDay
     * @param nextDay
     * @return
     */
    Map <String,String>getLoginAskCount(@Param("nowDay") String nowDay,@Param("nextDay") String nextDay);

    /**
     * 查询 活跃用户数就是当天的登录用户数
     * @param nowDay
     * @param nextDay
     * @return
     */
    int getLoginCount(@Param("nowDay") String nowDay,@Param("nextDay") String nextDay);

    List<LoginLogs> findByAppIdAndLoginDate(@Param("appId")String appId, @Param("beginDate") String beginDate);
}