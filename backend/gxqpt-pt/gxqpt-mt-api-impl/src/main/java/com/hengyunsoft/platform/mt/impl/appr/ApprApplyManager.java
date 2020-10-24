package com.hengyunsoft.platform.mt.impl.appr;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.core.dto.org.OrgDeptDutyInfoDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.mt.api.appr.dto.ApprApplyPersonDTO;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprApplyService;
import com.hengyunsoft.platform.mt.repository.appr.service.ApprPersonService;
import com.hengyunsoft.platform.mt.utils.ShareUtil;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 审批业务逻辑
 */
@Service
public class ApprApplyManager {
    @Autowired
    private ApprApplyService apprApplyService;
    @Autowired
    private ApprPersonService apprPersonService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired

    /**
     * 生成申请编码前缀
     */
    private static final String apprApplyCode = "APPR";

    /***
     *创建审批(审批申请)
     * @param createApprApply
     * @return 申请id
     */
    public Long addApprApplyt( Long userId,CreateApprApply createApprApply) {
        String name = BaseContextHandler.getName();
        String unityId = getUnityId(userId);

        ApprApply apply = dozerUtils.map(createApprApply, ApprApply.class);
        String code = ShareUtil.automaticCode(apprApplyCode);
        apply.setApplyUserId(userId);
        apply.setApplyUserName(name);
        apply.setCreateUser(userId);
        apply.setAprCode(code);
        apply.setCurState(1);//状态审批中
        apply.setUnitId(unityId);
        // 保存审批人和抄送人
        List<ApprApplyPersonDTO> apprPersons = createApprApply.getApprPersons();//审批人
        List<ApprApplyPersonDTO> sendPersons = createApprApply.getSendPersons();//抄送人
        //设置当前审批人
        apply.setCurUserIndex(0);//第0个开始审批
        ApprApplyPersonDTO first = apprPersons.get(0);
        apply.setCurAprUserName(first.getApprUserName());
        apply.setCurAprUserId(first.getApprUserId());
        apprApplyService.saveSelective(apply);

        saveApprAndSendPersons(apply.getId(), apprPersons, sendPersons);
        return apply.getId();
    }

    /***
     * 保存审批人和抄送人
     * @param apprPersons
     * @param sendPersons
     */
    public void saveApprAndSendPersons(Long applyId, List<ApprApplyPersonDTO> apprPersons, List<ApprApplyPersonDTO> sendPersons) {
        List<ApprPerson> apprPersonsEntry = dozerUtils.mapList(apprPersons, ApprPerson.class);
        List<ApprPerson> sendPeople = dozerUtils.mapList(sendPersons, ApprPerson.class);

        Long userId = BaseContextHandler.getAdminId();


        for (int i = 0; i < apprPersonsEntry.size(); i++) {
            ApprPerson p = apprPersonsEntry.get(i);
            p.setApprUserIndex(i);
            p.setApplyId(applyId);
            p.setCreateUser(userId);
            p.setUserType(1);
            p.setIsRead(0);
        }
        for (int i = 0; i < sendPeople.size(); i++) {
            ApprPerson p = sendPeople.get(i);
            p.setApplyId(applyId);
            p.setCreateUser(userId);
            p.setUserType(2);
            p.setIsRead(0);
        }

        apprPersonService.save(apprPersonsEntry);
        apprPersonService.save(sendPeople);
    }

    /**
     * 得到单位id
     *
     * @return
     */
    public String getUnityId(Long  userId) {
//        Long userId = BaseContextHandler.getAdminId();
//        Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(userId);
//        return orgDeptDutyInfo.getData().getOrgId();
        return UnityUtil.getUnityId(userId);
    }
}
