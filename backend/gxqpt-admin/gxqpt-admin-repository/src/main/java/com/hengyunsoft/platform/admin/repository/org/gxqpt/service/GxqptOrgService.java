package com.hengyunsoft.platform.admin.repository.org.gxqpt.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.*;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwOrg;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptOrgExample;

import java.util.List;

/**
 * @author wangzhen
 * @createTime 2018-03-07
 */
public interface GxqptOrgService extends BaseService<String, GxqptOrg, GxqptOrgExample> {
    /**
     * 禁用单位
     *
     * @param id
     * @return
     */
    int deleteOrg(String id);

    /**
     * 保存并分享给应用
     *
     * @param entity
     * @return
     */
    GxqptOrg saveAndShare(GxqptOrg entity);

    /**
     * 保存并分享给应用（）集合
     *
     * @param entitys
     * @return
     */
    List<GxqptOrg> saveAndShare(List<GxqptOrg> entitys);

    /**
     * 根据当前appId查询单位集合
     *
     * @param adminId
     * @param appId
     * @return
     */
    List<GxqptOrg> selectOrgWithShare(Long adminId, String appId);

    /**
     * 根据当前appId查询单位集合
     *
     * @param morg
     * @param adminId
     * @param appId
     * @return
     */
    List<GxqptOrg> selectLikeAppByShare(GxqptOrg morg, Long adminId, String appId);

    /**
     * 根据id连接字典查询子单位
     *
     * @param ids
     * @param morg
     * @param systemCode
     * @return
     */
    List<GxqptOrg> selectOrgJoinDictionary(String[] ids, GxqptOrg morg, String systemCode);

    /**
     * 选择制定用户可以管理的机构
     *
     * @param adminId
     * @return
     */
    List<GxqptOrg> selectOrgWithManager(Long adminId);

    /**
     * 单位详情
     *
     * @param systemCode
     * @param id
     * @return
     */
    SdzzwwOrg details(String systemCode, String id);

    /**
     * 通过应用id+体系编码获得其可见所有单位
     *
     * @param appId
     * @param systemCode
     * @return
     */
    List pageByAppAndSys(String appId, String systemCode);

    /**
     * 通过用户id+体系编码获得所有单位
     *
     * @param adminId
     * @param systemCode
     * @return
     */
    List findByAdmAndSys(Long adminId, String systemCode);

    /**
     * 通过体系编码获得所有单位
     *
     * @param systemCode
     * @return
     */
    List pageBySys(String systemCode);

    /**
     * 分页聚合查询
     *
     * @return
     */
    List pagePoly();

    /**
     * 根据appid分页聚合查询
     *
     * @param appId
     * @return
     */
    List pagePolyByApp(String appId);

    /**
     * 根据user聚合查询单位
     *
     * @param systemList
     * @param userId
     * @return
     */
    List findOrgByUser(String sysCode, Long userId);

    /* *
     * @Author wz
     * @Description //查询集合
     * @Date 15:52 2019/4/23
     * @Param []
     * @return java.util.List
     **/
    List findOrgByUsers(String sysCode, List<Long> userId);

    /**
     * 获取用户的体系聚合单位
     * @param adminId
     * @return
     */
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
    List<OrgAndEmpInfoDO> getOrgInfoByUserId(Long userId, String systemCode);

    List findAll(List systemList);

    /**
     * 查询每月调用的应用数量
     * 修改人：madb
     * 修改时间：2018-4-30
     * @return
     */
    List<FindAppNumDO> findNum(List<String> yearMonth);

    /**
     * 2018-5-30
     * 根据userId,查询单位、部门、职务、岗位以及体系编码
     * @param userId
     * @return
     */
    OrgDeptDutyInfoDO getOrgDeptDutyByUserId(Long userId, String systemCode);

    /**
     * 2018-6-26 移动端需要新增
     * 根据userId查询其所在单位，部门，岗位职务信息
     * @param userId
     * @return
     */
    List<OrgInfosDO> getOrgSimpleInfo(Long userId, String systemCode);

    /**
     * 2018-6-26 移动端需要新增
     * 根据userID,OrgID查询单位、部门、职务、岗位以及体系编码
     * @param userId
     * @return
     */
    List<OrgDeptDutyInfoDO> getOrgDeptDutyinfo(Long userId, String systemCode, String orgId);

    /**
     * 根据体系集合查询单位
     * @param systems
     * @return
     */
    List findAllOrgBySystem(List systems);

    /**
     * 查询全体系所有单位
     * @param systems
     * @return
     */
    List findOrgByPtAdminAndSystemCode(List<String> systems);

    /**
     * 查询全体系我所管理的单位
     * @param systems
     * @param adminId
     * @return
     */
    List findOrgByAdminAndSystemCode(List<String> systems, Long adminId);

    /**
     * 根据单位ids查询单位名称id信息
     * @param ids
     * @param systemCodes
     * @return
     */
    List findOrgNameByIds(List ids, List systemCodes);
    /**
     * 共享交换全体系模糊查询单位接口
     * @param systems
     * @param obj
     * @return
     */
    List<GxqptOrg> findOrgByExchange(List<String> systems, GxqptOrgByExchangeReqDO obj);
}
