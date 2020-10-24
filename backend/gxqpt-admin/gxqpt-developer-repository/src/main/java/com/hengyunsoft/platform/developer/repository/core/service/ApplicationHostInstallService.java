package com.hengyunsoft.platform.developer.repository.core.service;

import com.github.pagehelper.Page;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.core.domain.ApplicationHostInstallDO;
import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;
import com.hengyunsoft.platform.developer.repository.core.example.ApplicationHostInstallExample;

import java.util.List;

public interface ApplicationHostInstallService extends BaseService<Long, ApplicationHostInstall, ApplicationHostInstallExample> {
    /**
     * 获取部署分页
     * @param hostInstall
     * @return
     */
    List<ApplicationHostInstallDO> pageHostInstall(String appId, Long hostId, String hostName);

    /**
     * 获取部署详情
     * @param id
     * @return
     */
    ApplicationHostInstallDO getDetails(Long id);
    /**
     *
     * 主机应用部署列表查询
     * @param hostName
     * @param appId
     * @return
     */
    List<ApplicationHostInstall> findList(String hostName, String appId,Long hostId);

    /**
     * 查询主机应用部署详情
     * @param id
     * @return
     */
    ApplicationHostInstall getDetail(Long id);

    /**
     * 获取主机名称列表
     * @return
     */
    List<ApplicationHostInstall> getHostName();

    /**
     * 获取应用名称列表
     * @return
     */
    List<ApplicationHostInstall> getApplicationName();

    /**
     * 获取主机应用信息
     * @param id
     * @return
     */
    ApplicationHostInstall getDetailById(Long id);

}
