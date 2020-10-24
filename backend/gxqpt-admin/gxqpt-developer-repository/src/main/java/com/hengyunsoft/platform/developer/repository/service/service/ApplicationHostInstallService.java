//package com.hengyunsoft.platform.developer.repository.service.service;
//
//import com.github.pagehelper.Page;
//import com.hengyunsoft.base.service.normal.BaseService;
//import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;
//import com.hengyunsoft.platform.developer.repository.core.example.ApplicationHostInstallExample;
//
//import java.util.List;
//
///**
// * @author luchanghong
// * @create 2018-04-04 10:45
// * @desc 主机应用部署业务层
// **/
//public interface ApplicationHostInstallService extends BaseService<Long,ApplicationHostInstall,ApplicationHostInstallExample> {
//    /**
//     *
//     * 主机应用部署列表查询
//     * @param hostName
//     * @param appId
//     * @return
//     */
//    List<ApplicationHostInstall> findList(String hostName, String appId, Page page);
//
//    /**
//     * 查询主机应用部署详情
//     * @param id
//     * @return
//     */
//    ApplicationHostInstall getDetail(Long id);
//
//    /**
//     * 获取主机名称列表
//     * @return
//     */
//    List<ApplicationHostInstall> getHostName();
//
//    /**
//     * 获取应用名称列表
//     * @return
//     */
//    List<ApplicationHostInstall> getApplicationName();
//}