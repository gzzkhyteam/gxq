package com.hengyunsoft.platform.mt.repository.appr.dao;

import com.hengyunsoft.platform.mt.entity.appr.po.ApprApply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApprApplyMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.appr.po.ApprApply, com.hengyunsoft.platform.mt.repository.appr.example.ApprApplyExample> {
    /***
     * 分页查询我发出的申请
     * @param param
     * @return
     */
    List<ApprApply> findPageMyApplyList(Map<String, Object> param);

    /***
     * 分页查询我收到的申请
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
     * 查找用户最后一次的申请
     * @param userId  用户id
     * @param unitId  单位id
     * @param aprType  审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     * @return
     */
    ApprApply findLastApplyByAprType(@Param("applyUserId") Long userId, @Param("unitId") String unitId, @Param("aprType") String aprType);

    /***
     * 查询当前待我审批的数量
     * @param userId
     * @param unitId
     * @return
     */
    int getCurSendMeApplyCount(@Param("userId") Long userId, @Param("unitId") String unitId);
}