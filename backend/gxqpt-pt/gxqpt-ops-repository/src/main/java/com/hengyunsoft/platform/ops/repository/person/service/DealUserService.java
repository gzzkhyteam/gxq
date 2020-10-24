package com.hengyunsoft.platform.ops.repository.person.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DealUserService extends BaseService<Long,DealUser,DealUserExample> {
    /**
     * 根据业务id查询处理人、协助人、咨询人
     * @return
     * @Author kevin
     * @createtime 2018-07-17
     */
    List<DealUser> getByBussId(Long bussId);

}
