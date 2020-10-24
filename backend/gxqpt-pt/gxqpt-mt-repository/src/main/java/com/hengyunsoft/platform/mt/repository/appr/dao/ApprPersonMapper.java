package com.hengyunsoft.platform.mt.repository.appr.dao;

import com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprPersonMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.appr.po.ApprPerson, com.hengyunsoft.platform.mt.repository.appr.example.ApprPersonExample> {
    /***
     * 查询审批人或者抄送人
      * @param applyId
     * @param userType
     * @param apprUserIndex
     */
    List<ApprPerson> getApprPersons(@Param("applyId") long applyId, @Param("userType") int userType, @Param("apprUserIndex") Integer apprUserIndex);
}