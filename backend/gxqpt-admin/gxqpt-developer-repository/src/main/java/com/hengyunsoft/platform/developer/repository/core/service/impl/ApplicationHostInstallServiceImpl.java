package com.hengyunsoft.platform.developer.repository.core.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.developer.entity.core.domain.ApplicationHostInstallDO;
import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;
import com.hengyunsoft.platform.developer.repository.core.dao.ApplicationHostInstallMapper;
import com.hengyunsoft.platform.developer.repository.core.service.ApplicationHostInstallService;
import com.hengyunsoft.platform.developer.repository.core.example.ApplicationHostInstallExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationHostInstallServiceImpl extends BaseServiceImpl<Long, ApplicationHostInstall, ApplicationHostInstallExample> implements ApplicationHostInstallService{
    @Autowired
    private ApplicationHostInstallMapper mapper;
    @Override
    protected BaseNormalDao<Long, ApplicationHostInstall, ApplicationHostInstallExample> getDao() {
        return this.mapper;
    }

    /**
     * 分页模糊查询
     * @param hostInstall
     * @return
     */
    @Override
    public List<ApplicationHostInstallDO> pageHostInstall(String appId, Long hostId, String hostName) {
        return mapper.pageHostInstall(appId, hostId, hostName);
    }

    /**
     * 部署详情
     * @param id
     * @return
     */
    @Override
    public ApplicationHostInstallDO getDetails(Long id) {
        return mapper.getDetails(id);
    }

    /**
     * 查询主机应用部署列表
     * @param hostName
     * @param appId
     * @return
     */
    @Override
    public List<ApplicationHostInstall> findList(String hostName, String appId,Long hostId) {
        List<ApplicationHostInstall> list = mapper.findList(hostName, appId,hostId);
        return list;
    }

    /**
     * 查询主机应用部署详情
     * @param id
     * @return
     */
    @Override
    public ApplicationHostInstall getDetail(Long id) {
        ApplicationHostInstall detail = mapper.getDetail(id);
        return detail;
    }

    /**
     * 查询主机名称列表
     * @return
     */
    @Override
    public List<ApplicationHostInstall> getHostName() {
        Long adminId = BaseContextHandler.getAdminId();
        List<ApplicationHostInstall> list = mapper.getHostName(adminId);
        return list;
    }

    /**
     * 查询应用名称列表
     * @return
     */
    @Override
    public List<ApplicationHostInstall> getApplicationName() {
        List<ApplicationHostInstall> applicationName = mapper.getApplicationName();
        return applicationName;
    }

    /**
     * 获取主机应用信息
     * @param id
     * @return
     */
    @Override
    public ApplicationHostInstall getDetailById(Long id) {
        ApplicationHostInstall map= mapper.getDetailById(id);
        return  map;
    }
}
