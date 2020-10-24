package com.hengyunsoft.platform.admin.repository.org.gxqpt.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.*;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwOrg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptOrgMapper extends com.hengyunsoft.base.dao.BaseNormalDao<String, com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg, com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptOrgExample> {
    int updateIsdelete(@Param("id") String id);

    List<GxqptOrg> selectOrgWithShare(@Param("adminId")Long adminId, @Param("appId")String appId);

    List<GxqptOrg> selectLikeAppByShare(@Param("morg")GxqptOrg org, @Param("adminId")Long adminId, @Param("appId")String appId);

    List<GxqptOrg> selectOrgJoinDictionary(@Param("ids") String[] ids, @Param("morg") GxqptOrg morg, @Param("systemCode")String systemCode);

    List<GxqptOrg> selectOrgWithManager(Long adminId);

    SdzzwwOrg details(@Param("systemCode")String systemCode, @Param("id")String id);

    List pageByAppAndSys(@Param("appId")String appId, @Param("systemCode")String systemCode);

    List findByAdmAndSys(@Param("adminId")Long adminId, @Param("systemCode")String systemCode);

    List pageBySys(@Param("systemCode")String systemCode);

    List pagePoly();

    List pagePolyByApp(@Param("appId")String appId);

    List findOrgByUser(@Param("sysCode") String sysCode, @Param("userId") Long userId);

    List findOrgByUsers(@Param("sysCode") String sysCode, @Param("ids") List<Long> userIds);

    List pagePolyByUser(Long adminId);

    /**
     * 根据userId查询相关信息
     * 修改人：chb
     * 修改时间：2018-4-23
     * 修改内容：根据定窑最新需求修改
     * @param userId
     * @auth chb
     * @return
     */
    List<OrgAndEmpInfoDO> getOrgInfoByUserId(@Param("userId")Long userId, @Param("systemCode")String systemCode);

    List findAll(@Param("systemList") List systemList);

    /**
     * 查询每月调用的应用数量
     * 修改人：madb
     * 修改时间：2018-4-30
     * @return
     */
    List<FindAppNumDO> findAppNum(@Param("yearMonth") List<String> yearMonth);

    /**
     * 2018-5-30
     * 根据userId 查询主单位、部门、职务、岗位以及体系编码
     * @param userId
     * @return
     */
    OrgDeptDutyInfoDO getOrgDeptDutyByUserId(@Param("userId") Long userId, @Param("systemCode") String systemCode);

    /**
     * 2018-6-26 移动端需要新增
     * 根据userId查询其所在单位，部门，岗位职务信息
     * @param userId
     * @return
     */
    List<OrgInfosDO> getOrgSimpleInfo(@Param("userId") Long userId, @Param("systemCode")String systemCode);

    /**
     * 2018-6-26 移动端需要新增
     * 根据userID,OrgID查询单位、部门、职务、岗位以及体系编码
     * @param userId
     * @return
     */
    List<OrgDeptDutyInfoDO> getOrgDeptDutyinfo(@Param("userId") Long userId, @Param("systemCode")String systemCode,@Param("orgId")String orgId);

    /**
     * 根据体系集合查询单位
     * @param systems
     * @return
     */
    List findAllOrgBySystem(@Param("systems") List systems);

    /**
     * 查询全体系所有单位
     * @param systems
     * @return
     */
    List findOrgByPtAdminAndSystemCode(@Param("systems") List<String> systems);

    /**
     * 查询全体系我所管理的单位
     * @param systems
     * @param adminId
     * @return
     */
    List findOrgByAdminAndSystemCode(@Param("systems")List<String> systems, @Param("adminId")Long adminId);

    /**
     * 根据单位ids查询单位名称id信息
     * @param ids
     * @param systemCodes
     * @return
     */
    List findOrgNameByIds(@Param("ids")List ids, @Param("systems")List systemCodes);

    /**
     * 共享交换全体系模糊查询单位接口
     * @param systems
     * @param obj
     * @return
     */
    List<GxqptOrg> findOrgByExchange(@Param("systems")List<String> systems, @Param("obj")GxqptOrgByExchangeReqDO obj);
}