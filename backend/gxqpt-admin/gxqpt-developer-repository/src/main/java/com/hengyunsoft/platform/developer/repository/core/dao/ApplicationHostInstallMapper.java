package com.hengyunsoft.platform.developer.repository.core.dao;

import com.hengyunsoft.platform.developer.entity.core.domain.ApplicationHostInstallDO;
import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationHostInstallMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall, com.hengyunsoft.platform.developer.repository.core.example.ApplicationHostInstallExample> {
    List<ApplicationHostInstallDO> pageHostInstall(@Param("appId") String appId,@Param("hostId") Long hostId,@Param("hostName") String hostName);
    /**
     * 获取主机应用部署列表
     * @param hostName
     * @param appId
     * @return
     */
    List<ApplicationHostInstall> findList(@Param(value = "hostName") String hostName,@Param(value = "appId") String appId,@Param("hostId")Long hostId);

    /**
     * 获取主机应用部署详情
     * @param id
     * @return
     */
    ApplicationHostInstall getDetail(@Param(value = "id") Long id);

    /**
     * 查询主机名称列表
     * @return
     */
    List<ApplicationHostInstall> getHostName(@Param("adminId")Long adminId);

    /**
     * 查询应用名称列表
     * @return
     */
    List<ApplicationHostInstall> getApplicationName();




    ApplicationHostInstallDO getDetails(Long id);

    /**
     * 获取主机应用
     * @param installId
     * @return
     */
    ApplicationHostInstall getDetailById(@Param("installId") Long installId);
}