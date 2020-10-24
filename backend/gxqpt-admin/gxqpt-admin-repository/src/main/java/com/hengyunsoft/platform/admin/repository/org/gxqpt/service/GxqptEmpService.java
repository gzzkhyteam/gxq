package com.hengyunsoft.platform.admin.repository.org.gxqpt.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpEmailLikeDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpTreeBySystemDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpAndUserDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpByUserIdsDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;

import java.util.List;

/**
 * 人员管理service 接口
 */
public interface GxqptEmpService extends BaseService<String, GxqptEmp, GxqptEmpExample> {
    List<GxqptEmpAndUserDO> findEmps(Long id, String ownSystem);

    /**
     * 根据用户Id,systemCode查询用户
     * @param userId
     * @param systemCode
     * @return
     */
    List<GxqptEmpAndUserDO> findEmpListByUserId(String userId, String systemCode);

    /**
     * 根据单位，systemCode查询用户
     * @param orgId
     * @param systemCode
     * @return
     */
    List<GxqptEmpAndUserDO> findEmpListByOrgId(String orgId, String systemCode);

    /**
     * 根据单位，systemCode查询用户
     * @param orgId
     * @param systemCode
     * @return
     */
    List<GxqptEmpAndUserDO> findEmpListByDeptId(String deptId, String systemCode);

    /**
     * 查询单位、部门下的用户
     * 2018-4-11 业务逻辑修改 不在使用
     * @param emp
     * @return
     */
    List<? extends SdzzwwEmp> findIdentityEmpList(GxqptEmp emp);

    Object getMainOrg(String ownSystem, Long userId);

    /**
     * 移动端接口查询需要，根据name模糊查询用户信息
     * @param emp
     * @return
     */
    List<? extends SdzzwwEmp> findIdentityEmpList2app(GxqptEmp emp);

    /**
     * 根据部门查询身份人员
     * @param dpmId
     * @param systemCode
     * @return
     */
    List findEmpByDpm(String dpmId, String systemCode);

    /**
     * 根据部门查询身份用户
     * @param dpmId
     * @param systemCode
     * @return
     */
    List findUserByDpm(String dpmId, String systemCode);

    /**
     * 邮件全体系人员模糊查询
     * @param systemCodes
     * @param data
     * @return
     */
    List findAllEmpBySystem(List systemCodes, EmpEmailLikeDO data);

    /**
     * 全体系根据单位id查询人员
     * @param orgIds
     * @param systemCodes
     * @return
     */
    List findEmpByOrgId(List orgIds, List systemCodes);

    /**
     * 全体系根据用户id集合模糊查询人员
     * @param userIds
     * @param systemCodes
     * @return
     */
    List findEmpByUserIds(GxqptEmpByUserIdsDO userIds, List systemCodes);

    /**
     * 查询某体系下单位集合下所有人员
     * @param orgIds
     * @param ownSystem
     * @return
     */
    List<GxqptEmp> findEmpsByOrgIds(List<String> orgIds, String ownSystem);

    /**
     * 查询全体系人员
     * @param systemCodes
     * @return
     */
    List<EmpTreeBySystemDO> findAllEmpBySystemTree(List<String> systemCodes);
}
