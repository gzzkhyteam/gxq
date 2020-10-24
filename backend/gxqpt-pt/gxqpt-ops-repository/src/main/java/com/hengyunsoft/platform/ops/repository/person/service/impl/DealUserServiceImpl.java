package com.hengyunsoft.platform.ops.repository.person.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.repository.person.dao.DealUserMapper;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import com.hengyunsoft.platform.ops.repository.person.service.DealUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kevin on 2018/7/17.
 */
@Service
@Slf4j
public class DealUserServiceImpl extends BaseServiceImpl<Long,DealUser,DealUserExample> implements DealUserService {


    @Autowired
    private DealUserMapper dealUserMapper;

    @Override
    protected BaseNormalDao<Long, DealUser, DealUserExample> getDao() {
        return dealUserMapper;
    }

    @Override
    public List<DealUser> getByBussId(Long bussId) {
        return dealUserMapper.getByBussId(bussId);
    }


}
