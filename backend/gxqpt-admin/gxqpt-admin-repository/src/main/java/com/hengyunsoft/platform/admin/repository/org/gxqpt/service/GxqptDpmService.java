package com.hengyunsoft.platform.admin.repository.org.gxqpt.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDepartmentExample;

import java.util.List;

/**
 * @author wangzhen
 * @createTime 2018-03-07
 */
public interface GxqptDpmService  extends BaseService<String, GxqptDepartment, GxqptDepartmentExample> {
    int updateByChileName(GxqptDepartment dpm);

    /**
     * 链接字典查询部门的详情信息
     * @param systemCode
     * @param dpm
     * @return
     */
    List<? extends SdzzwwDepartment> selectDpmJoinDictionary(String systemCode, GxqptDepartment dpm);

    /**
     * 通过单位id+体系编码获得所有部门
     * @param orgId
     * @param systemCode
     * @return
     */
    List pageByOrgAndSys(String orgId, String systemCode);

    /**
     * 获得当前人员及身份所在单位下的所有部门
     * @param ownSystem
     * @param userId
     * @return
     */
    List findDpmByUser(String ownSystem, Long userId);

    /**
     * 根据体系，用户id，单位id按身份查询其所在单位的所在部门---均启用
     * @param ownSystem
     * @param userId
     * @param orgId
     * @return
     */
    List findDpmByUserAndOrg(String ownSystem, Long userId, String orgId);

    /**
     * 根据体系结合查询部门
     * @param systems
     * @return
     */
    List findAllDpmBySystem(List systems);

    /**
     * 根据部门ids查询部门名称id信息
     * @param ids
     * @param systemCodes
     * @return
     */
    List<GxqptDepartment> findDpmNameByIds(List ids, List<String> systemCodes);
}
