package com.hengyunsoft.platform.developer.repository.fast.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import com.hengyunsoft.platform.developer.repository.fast.dao.FastMenuMapper;
import com.hengyunsoft.platform.developer.repository.fast.example.FastMenuExample;
import com.hengyunsoft.platform.developer.repository.fast.service.FastMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FastMenuServiceImpl extends BaseAllServiceImpl<Long, FastMenu, FastMenuExample>
        implements FastMenuService {
    @Autowired
    private FastMenuMapper fastMenuMapper;

    @Override
    protected BaseNormalDao<Long, FastMenu, FastMenuExample> getDao() {
        return fastMenuMapper;
    }

    @Override
    public List<FastMenu> getMenu(Long parentId, String appId) {
        return fastMenuMapper.getMenu(parentId,appId);
    }

    @Override
    public void deleteByAppId(String appId) {
        fastMenuMapper.deleteByAppId(appId);
    }

}
