package com.hengyunsoft.platform.mt.repository.userconfig.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.repository.userconfig.dao.UserConfigMapper;
import com.hengyunsoft.platform.mt.repository.userconfig.example.UserConfigExample;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserConfigServiceImpl extends BaseServiceImpl<Long, UserConfig, UserConfigExample> implements UserConfigService {
    @Autowired
    private UserConfigMapper userConfigMapper;

    @Override
    protected BaseNormalDao<Long, UserConfig, UserConfigExample> getDao() {
        return userConfigMapper;
    }

    /***
     * 根据用户id和类型得到用户配置
     * @param userId
     * @param type
     * @return
     */
    public UserConfig getUserConfigByidAndType(Long userId, Long type) {
        //查询设置的单位id
        UserConfigExample example = new UserConfigExample();
        UserConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andJobIdEqualTo(type);
        UserConfig uConfig = getUnique(example);
        return uConfig;
    }
}
