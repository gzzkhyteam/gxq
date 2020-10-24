package com.hengyunsoft.platform.admin.repository.org.sdzzww.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.domain.EmpIdFroOperationDO;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwEmpExample;

import java.util.List;

public interface SdzzwwEmpService extends BaseService<String, SdzzwwEmp, SdzzwwEmpExample> {
    /**
     * 查询单位和部门下的任务
     * @param sdzzwwEmp
     * @return
     */
    List<? extends SdzzwwEmp> findIdentityEmpList(SdzzwwEmp sdzzwwEmp);


    /**
     * 移动端接口查询需要，根据name模糊查询用户信息
     * @param emp
     * @return
     */
    List<? extends SdzzwwEmp> findIdentityEmpList2app(SdzzwwEmp sdzzwwEmp);

    /**
     * 运维查询部门人员角色过滤
     * @param obj
     * @return
     */
    List<String> findEmpIdFroOperation(EmpIdFroOperationDO obj);
}
