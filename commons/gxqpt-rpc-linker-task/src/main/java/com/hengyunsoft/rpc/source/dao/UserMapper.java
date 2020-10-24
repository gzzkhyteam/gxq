package com.hengyunsoft.rpc.source.dao;

import org.springframework.stereotype.Repository;

import com.hengyunsoft.rpc.data.po.UserPO;
import com.hengyunsoft.sync.source.dao.BaseMapper;



@Repository
public interface UserMapper extends BaseMapper<UserPO> { 
}
