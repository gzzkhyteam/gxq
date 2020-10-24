package com.hengyunsoft.platform.admin.repository.org.gxqpt.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GxqptDepartmentMapper extends com.hengyunsoft.base.dao.BaseNormalDao<String, com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment, com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDepartmentExample> {
    int updateByChileName(@Param("record") GxqptDepartment record);

    List<? extends SdzzwwDepartment> selectDpmJoinDictionary(@Param("systemCode") String systemCode, @Param("dpm") GxqptDepartment dpm);

    List pageByOrgAndSys(@Param("orgId")String orgId, @Param("systemCode")String systemCode);

    List findDpmByUser(@Param("ownSystem")String ownSystem, @Param("userId")Long userId);

    List findDpmByUserAndOrg(@Param("ownSystem")String ownSystem, @Param("userId")Long userId, @Param("orgId")String orgId);

    List findAllDpmBySystem(@Param("systems")List systems);

    List<GxqptDepartment> findDpmNameByIds(@Param("ids")List ids, @Param("systems")List<String> systemCodes);
}