//package com.hengyunsoft.platform.developer.repository.service.service.impl;
//
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.hengyunsoft.base.dao.BaseNormalDao;
//import com.hengyunsoft.base.service.impl.BaseServiceImpl;
//import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;
//import com.hengyunsoft.platform.developer.repository.core.dao.ApplicationHostInstallMapper;
//import com.hengyunsoft.platform.developer.repository.core.example.ApplicationHostInstallExample;
//import com.hengyunsoft.platform.developer.repository.service.service.ApplicationHostInstallService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author luchanghong
// * @create 2018-04-04 10:48
// * @desc 主机应用部署业务实现层
// **/
//@Service
//public class ApplicationHostInstallServiceImpl extends BaseServiceImpl<Long,ApplicationHostInstall,ApplicationHostInstallExample> implements ApplicationHostInstallService {
//    @Autowired
//    private ApplicationHostInstallMapper applicationHostInstallMapper;
//    @Override
//    protected BaseNormalDao<Long, ApplicationHostInstall, ApplicationHostInstallExample> getDao() {
//        return applicationHostInstallMapper;
//
//    }
//
////    /**
////     * 查询主机应用部署列表
////     * @param hostName
////     * @param appId
////     * @return
////     */
////    @Override
////    public List<ApplicationHostInstall> findList(String hostName, String appId, Page page) {
////        PageHelper.startPage(page.getPageNum(),page.getPageSize());
////        List<ApplicationHostInstall> list = applicationHostInstallMapper.findList(hostName, appId);
////        return list;
////    }
////
////    /**
////     * 查询主机应用部署详情
////     * @param id
////     * @return
////     */
////    @Override
////    public ApplicationHostInstall getDetail(Long id) {
////        ApplicationHostInstall detail = applicationHostInstallMapper.getDetail(id);
////        return detail;
////    }
////
////    /**
////     * 查询主机名称列表
////     * @return
////     */
////    @Override
////    public List<ApplicationHostInstall> getHostName() {
////        List<ApplicationHostInstall> list = applicationHostInstallMapper.getHostName();
////        return list;
////    }
////
////    /**
////     * 查询应用名称列表
////     * @return
////     */
////    @Override
////    public List<ApplicationHostInstall> getApplicationName() {
////        List<ApplicationHostInstall> applicationName = applicationHostInstallMapper.getApplicationName();
////        return applicationName;
////    }
//}