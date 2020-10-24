package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDuties;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptDutiesMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDutiesExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDutiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:职务管理接口实现
 * @author chb
 * @date 2018/3/7 13:59
 * @return
 */
@Service
public class GxqptDutiesServiceImpl extends BaseAllServiceImpl<String, GxqptDuties, GxqptDutiesExample> implements GxqptDutiesService {

    @Autowired
    private GxqptDutiesMapper gxqptDutiesMapper;

    @Override
    protected BaseNormalDao<String, GxqptDuties, GxqptDutiesExample> getDao() {
        return gxqptDutiesMapper;
    }

    @Override
    public  String genId() {
        return String.valueOf(super.genId());
    }

    @Override
    public GxqptDuties save(GxqptDuties entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        entity.setId(genId());
        getDao().insert(entity);
        return entity;
    }

}

