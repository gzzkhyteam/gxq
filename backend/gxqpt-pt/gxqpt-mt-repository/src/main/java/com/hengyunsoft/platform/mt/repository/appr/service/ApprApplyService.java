package com.hengyunsoft.platform.mt.repository.appr.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import com.hengyunsoft.platform.mt.repository.appr.example.ApprApplyExample;

import java.util.List;
import java.util.Map;

public interface ApprApplyService extends BaseService<Long, ApprApply, ApprApplyExample> {
    /***
     * 分页查询我发出的审批申请
     * @param param
     * @return
     */
    List<ApprApply> findPageMyApplyList(Map<String, Object> param);

    /***
     *查询我收到的审批
     * @param param
     * @return
     */
    List<ApprApply> findPageSendMeApplyList(Map<String, Object> param);

    /***
     * 查询当前待我审批的申请
     * @param param
     * @return
     */
    List<ApprApply> findPageCurSendMeApplyList(Map<String, Object> param);

    /***
     * 查询我审批过的申请
     * @param param
     * @return
     */
    List<ApprApply> findPagePassSendMeApplyList(Map<String, Object> param);


    /***
     *查找用户最后一次的申请
     * @param userId
     * @param unitId 单位id
     * @param aprType
     * @return
     */
    ApprApply findLastApplyByAprType(Long userId, String unitId, String aprType);

    /***
     * 查询当前带我审批的数量
     * @param userId
     * @param unitId
     * @return
     */
    int getCurSendMeApplyCount(Long userId, String unitId);
}
