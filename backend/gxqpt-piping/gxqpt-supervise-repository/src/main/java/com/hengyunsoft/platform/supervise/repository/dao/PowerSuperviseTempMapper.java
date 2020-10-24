package com.hengyunsoft.platform.supervise.repository.dao;



import com.hengyunsoft.platform.supervise.entity.domain.PowerSuperviseTempDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSuperviseTempMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseTemp, com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTempExample> {
    List<PowerSuperviseTempDO> getNotHandleLink();
}