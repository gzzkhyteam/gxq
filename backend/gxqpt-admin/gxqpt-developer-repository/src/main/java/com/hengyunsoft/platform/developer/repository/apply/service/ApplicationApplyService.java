package com.hengyunsoft.platform.developer.repository.apply.service;

import java.util.List;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.page.PageRequest;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplyQueryDO;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationApplyExample;

public interface ApplicationApplyService extends BaseService<Long, ApplicationApply, ApplicationApplyExample> {
    /**
     * 添加一个新应用
     * @param app
     * @return
     */
    ApplicationApply saveApp(ApplicationApply app);

    public List<ApplyQueryDO> queryMyTask(String moduleName,String appName,String moduleId, String auditStatus
            , List<String> appIds, String taskType, String taskRole, Boolean auditApp2ModelAdd, Long applyUser,PageRequest page);
}
