package com.hengyunsoft.platform.mt.repository.userconfig.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.repository.userconfig.example.UserConfigExample;

public interface UserConfigService extends BaseService<Long, UserConfig, UserConfigExample> {
    /***
     * 根据用户id和类型得到用户配置
     * @param userId
     * @param type
     * @return
     */
    UserConfig getUserConfigByidAndType(Long userId, Long type);

}
