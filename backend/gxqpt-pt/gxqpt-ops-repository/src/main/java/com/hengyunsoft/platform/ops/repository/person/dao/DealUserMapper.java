package com.hengyunsoft.platform.ops.repository.person.dao;

import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealUserMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.person.po.DealUser, com.hengyunsoft.platform.ops.repository.person.example.DealUserExample> {

    //根据业务id获取处理人咨询人和协助人
    List<DealUser> getByBussId(@Param("bussId")Long bussId);
}