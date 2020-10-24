package com.hengyunsoft.platform.ops.repository.person.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.repository.person.dao.PersonManageMapper;
import com.hengyunsoft.platform.ops.repository.person.example.PersonManageExample;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonServiceImpl extends BaseServiceImpl<Long, PersonManage, PersonManageExample> implements PersonService {
    @Autowired
    private PersonManageMapper personManageMapper;

    @Override
    protected BaseNormalDao<Long, PersonManage, PersonManageExample> getDao() {
        return personManageMapper;
    }

    @Override
    public int insertSelective(PersonManage entity) {
        return personManageMapper.insertSelective(entity);
    }
}
