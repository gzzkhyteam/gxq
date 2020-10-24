package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpIdentityDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmpIdentity;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptEmpIdentityMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpIdentityExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptEmpIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:人员身份Service实现类
 * @author chb
 * @date 2018/4/10 10:26 
 */
@Service
public class GxqptEmpIdentityServiceImpl extends BaseAllServiceImpl<String, GxqptEmpIdentity, GxqptEmpIdentityExample> implements GxqptEmpIdentityService {

    @Autowired
    private GxqptEmpIdentityMapper empIdentityMapper;

    @Override
    protected BaseNormalDao<String, GxqptEmpIdentity, GxqptEmpIdentityExample> getDao() {
        return empIdentityMapper;
    }

    @Override
    public  String genId() {
        return String.valueOf(super.genId());
    }

    @Override
    public GxqptEmpIdentity save(GxqptEmpIdentity entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        entity.setId(genId());
        getDao().insert(entity);
        return entity;
    }

    /**
     * 查询身份列表数据
     * @param identity
     * @return
     */
    @Override
    public List<GxqptEmpIdentityDO> findPage(GxqptEmpIdentity identity) {
        return empIdentityMapper.getEmpIdentity(identity);
    }

    /**
     * 根据ID查询人员信息
     * @param id
     * @return
     */
    @Override
    public GxqptEmpIdentityDO getEmpIdentityById(String id) {
        return empIdentityMapper.getEmpIdentityById(id);
    }
}
