package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptDepartmentMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDepartmentExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDpmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhen
 * @createTime 2018-03-06
 */
@Service
@Slf4j
public class GxqptDpmServiceImpl extends BaseServiceImpl<String, GxqptDepartment, GxqptDepartmentExample> implements GxqptDpmService {
    @Autowired
    private GxqptDepartmentMapper mapper;

    @Override
    protected BaseNormalDao<String, GxqptDepartment, GxqptDepartmentExample> getDao() {
        return mapper;
    }

    @Override
    public String genId() {
        return String.valueOf(super.genId());
    }

    @Override
    public GxqptDepartment save(GxqptDepartment entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        String id = genId();
        entity.setId(id);
        entity.setCreateTime(new Date());
        entity.setSortvalue(entity.getSortvalue() == null ? 0 : entity.getSortvalue());
        getDao().insert(entity);
        return entity;
    }

    @Override
    public Collection<GxqptDepartment> save(Collection<GxqptDepartment> list) {
        if (list == null) {
            throw new RuntimeException("list is null");
        }
        for (GxqptDepartment t : list) {
            save(t);
        }
        return list;
    }

    @Override
    public int updateByChileName(GxqptDepartment dpm) {
        return mapper.updateByChileName(dpm);
    }

    @Override
    public List<? extends SdzzwwDepartment> selectDpmJoinDictionary(String systemCode, GxqptDepartment dpm) {
        return mapper.selectDpmJoinDictionary(systemCode, dpm);
    }

    @Override
    public List pageByOrgAndSys(String orgId, String systemCode) {
        return mapper.pageByOrgAndSys(orgId, systemCode);
    }

    @Override
    public List findDpmByUser(String ownSystem, Long userId) {
        return mapper.findDpmByUser(ownSystem, userId);
    }

    @Override
    public List findDpmByUserAndOrg(String ownSystem, Long userId, String orgId) {
        return mapper.findDpmByUserAndOrg(ownSystem, userId, orgId);
    }

    @Override
    public List findAllDpmBySystem(List systems) {
        return mapper.findAllDpmBySystem(systems);
    }

    @Override
    public List<GxqptDepartment> findDpmNameByIds(List ids, List<String> systemCodes) {
        return mapper.findDpmNameByIds(ids, systemCodes);
    }
}
