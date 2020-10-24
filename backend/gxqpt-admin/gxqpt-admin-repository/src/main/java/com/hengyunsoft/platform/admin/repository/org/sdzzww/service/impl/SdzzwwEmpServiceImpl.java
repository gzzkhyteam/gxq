package com.hengyunsoft.platform.admin.repository.org.sdzzww.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.domain.EmpIdFroOperationDO;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.dao.SdzzwwEmpMapper;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwEmpExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SdzzwwEmpServiceImpl extends BaseServiceImpl<String, SdzzwwEmp, SdzzwwEmpExample> implements SdzzwwEmpService{
    @Autowired
    private SdzzwwEmpMapper sdzzwwEmpMapper;

    @Override
    protected BaseNormalDao<String, SdzzwwEmp, SdzzwwEmpExample> getDao() {
        return sdzzwwEmpMapper;
    }

    /**
     * 查询单位和部门下的任务
     * @param sdzzwwEmp
     * @return
     */
    @Override
    public List<? extends SdzzwwEmp> findIdentityEmpList(SdzzwwEmp sdzzwwEmp) {
        return sdzzwwEmpMapper.findIdentityEmpList(sdzzwwEmp);
    }

    /**
     * 移动端接口查询需要，根据name模糊查询用户信息
     * @param emp
     * @return
     */
    @Override
    public List<? extends SdzzwwEmp> findIdentityEmpList2app(SdzzwwEmp sdzzwwEmp) {
        return sdzzwwEmpMapper.findIdentityEmpList2app(sdzzwwEmp);
    }

    /**
     * 运维查询部门人员角色过滤
     * @param obj
     * @return
     */
    @Override
    public List<String> findEmpIdFroOperation(EmpIdFroOperationDO obj) {
        return sdzzwwEmpMapper.findEmpIdFroOperation(obj);
    }
}
