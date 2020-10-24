package com.hengyunsoft.platform.supervise.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseType;
import com.hengyunsoft.platform.supervise.repository.dao.PowerSuperviseTypeMapper;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTypeExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PowerSuperviseTypeServiceImpl extends BaseAllServiceImpl<Long, PowerSuperviseType, PowerSuperviseTypeExample> implements PowerSuperviseTypeService {

    @Autowired
    private PowerSuperviseTypeMapper powerSuperviseTypeMapper;

    /**
     * 根据父id查询id
     * @param parentId
     * @return
     */
    @Override
    public Long getIdByParentId(Long parentId){
        return powerSuperviseTypeMapper.getIdByParentId(parentId);
    }

    /**
     * 查询全责类型编码
     * @param code
     * @return
     */
    @Override
    public List<String> getCode(String code){
        return powerSuperviseTypeMapper.getCode(code);
    }

    @Override
    protected BaseNormalDao<Long, PowerSuperviseType, PowerSuperviseTypeExample> getDao() {
        return powerSuperviseTypeMapper;
    }
}
