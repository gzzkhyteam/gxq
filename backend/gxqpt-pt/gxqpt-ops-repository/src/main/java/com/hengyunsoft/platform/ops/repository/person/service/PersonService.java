package com.hengyunsoft.platform.ops.repository.person.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.repository.person.example.PersonManageExample;

public interface PersonService extends BaseService<Long,PersonManage,PersonManageExample> {
    /**
     *保存运维人员表
     * @return
     * @Author tianai
     * @createtime 2018-07-13
     */
    int insertSelective(PersonManage entity);
}
