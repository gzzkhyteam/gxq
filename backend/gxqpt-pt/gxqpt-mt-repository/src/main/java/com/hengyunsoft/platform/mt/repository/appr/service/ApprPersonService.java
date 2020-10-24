package com.hengyunsoft.platform.mt.repository.appr.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson;
import com.hengyunsoft.platform.mt.repository.appr.example.ApprPersonExample;

import java.util.List;

public interface ApprPersonService extends BaseService<Long, ApprPerson, ApprPersonExample> {
    /***
     * 查询审批人或者抄送人
     * @param applyId  申请id
     * @param userType   人员类型(1:审批人，2:抄送人)
     * @param apprUserIndex  审批人顺序
     * @return
     */
    ApprPerson getApprApply(long applyId, int userType, int apprUserIndex);

    /**
     * 查询审批人或者抄送人
     *
     * @param applyId  申请id
     * @param userType 人员类型(1:审批人，2:抄送人)
     * @return
     */
    List<ApprPerson> getApprPersons(long applyId, int userType);
}
