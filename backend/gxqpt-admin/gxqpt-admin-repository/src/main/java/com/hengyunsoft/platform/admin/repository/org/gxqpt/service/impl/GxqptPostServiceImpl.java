package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDuties;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptPost;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptDutiesMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptPostMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDutiesExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptPostExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDutiesService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:职务管理接口实现
 * @author chb
 * @date 2018/3/7 13:59
 * @return
 */
@Service
public class GxqptPostServiceImpl extends BaseAllServiceImpl<String, GxqptPost, GxqptPostExample> implements GxqptPostService {

    @Autowired
    private GxqptPostMapper gxqptPostMapper;

    @Override
    protected BaseNormalDao<String, GxqptPost, GxqptPostExample> getDao() {
        return gxqptPostMapper;
    }

    @Override
    public  String genId() {
        return String.valueOf(super.genId());
    }

    @Override
    public GxqptPost save(GxqptPost entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        entity.setId(genId());
        getDao().insert(entity);
        return entity;
    }

}

