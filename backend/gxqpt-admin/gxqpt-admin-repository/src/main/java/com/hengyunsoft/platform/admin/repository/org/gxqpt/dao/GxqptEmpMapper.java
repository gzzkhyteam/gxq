package com.hengyunsoft.platform.admin.repository.org.gxqpt.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpTreeBySystemDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpByUserIdsDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpEmailLikeDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpAndUserDO;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptEmpMapper extends com.hengyunsoft.base.dao.BaseNormalDao<String, GxqptEmp, GxqptEmpExample> {

    /**
     * 根据Id查询
     * @param id
     * @param ownSystem
     * @return
     */
    List<GxqptEmpAndUserDO> findEmps(@Param("id") Long id, @Param("ownSystem")String ownSystem);

    /**
     * 描述:根据用户Id,systemCode查询用户
     * @param userId
     * @param systemCode
     * @param orgId
     * @param deptId
     * @return
     */
    List<GxqptEmpAndUserDO> findEmpListByUser(@Param("userId")String userId, @Param("systemCode") String systemCode
            , @Param("orgId")String orgId, @Param("deptId") String deptId);

    /**
     * 查询单位部门下的用户
     * @param emp
     * @return
     */
    List<? extends SdzzwwEmp> findIdentityEmpList(GxqptEmp emp);

    Object getMainOrg(@Param("systemCode")String systemCode, @Param("userId")Long userId);

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
    List findEmpByDpm(@Param("dpmId")String dpmId, @Param("systemCode")String systemCode);

    /**
     * 根据部门查询身份用户
     * @param dpmId
     * @param systemCode
     * @return
     */
    List findUserByDpm(@Param("dpmId")String dpmId, @Param("systemCode")String systemCode);

    /**
     * 邮件全体系人员模糊查询
     * @param systemCodes
     * @param data
     * @return
     */
    List findAllEmpBySystem(@Param("systems")List systemCodes, @Param("data")EmpEmailLikeDO data);

    /**
     * 全体系根据单位id查询人员(带身份)
     * @param orgIds
     * @param systemCodes
     * @return
     */
    List findEmpByOrgId(@Param("ids")List orgIds, @Param("systems")List systemCodes);

    /**
     * 全体系根据用户id集合模糊查询人员
     * @param user
     * @param systemCodes
     * @return
     */
    List findEmpByUserIds(@Param("user")GxqptEmpByUserIdsDO user, @Param("systems")List systemCodes);

    /**
     * 查询某体系下单位集合下所有人员
     * @param orgIds
     * @param ownSystem
     * @return
     */
    List<GxqptEmp> findEmpsByOrgIds(@Param("orgIds")List<String> orgIds, @Param("systemCode")String ownSystem);

    /**
     * 查询全体系人员
     * @param systemCodes
     * @return
     */
    List<EmpTreeBySystemDO> findAllEmpBySystemTree(@Param("systems") List<String> systemCodes);
}