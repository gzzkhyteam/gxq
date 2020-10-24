package com.hengyunsoft.platform.mt.repository.apprwork.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.apprwork.po.ApprAttenceSupply;
import com.hengyunsoft.platform.mt.repository.apprwork.example.ApprAttenceSupplyExample;

import java.util.Date;
import java.util.List;

public interface ApprAttenceSupplyService extends BaseService<Long, ApprAttenceSupply, ApprAttenceSupplyExample> {
    /***
     * 根据日期查询当天的补签
     * @param userId
     * @param date
     * @return
     */
    List<ApprAttenceSupply> getApprAttenceSupplysByDate(Long userId, Date date);

    /***
     * 根据申请id查询补签
     * @param applyId
     * @return
     */
    ApprAttenceSupply getApprAttenceSupplyByApplyId(long applyId);

    /***
     * 根据日期和类型查询当天的补签
     * @param userId
     * @param date
     * @param supplyType  补签类型(1:签到、2:签退)
     * @return
     */
    List<ApprAttenceSupply>  getApprAttenceSupplysByDateAndType(Long userId, Date date, Integer supplyType);
}
