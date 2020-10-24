package com.hengyunsoft.platform.developer.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleCountDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationDO;
import com.hengyunsoft.platform.developer.entity.service.po.domain.ModuleRelationLinksDO;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceModuleExample;

import java.util.List;
import java.util.Map;

public interface ServiceModuleService extends BaseService<Long, ServiceModule, ServiceModuleExample>{

    /**
     * 描述：根据用户Id查找所有我的功能列表
     * 参数：userId 用户Id
     * 返回值：List<ServiceModuleApply> 应用list
     * 修改人：sunxiaoya
     * 修改时间：2018/4/2
     * 修改内容：
     */
    List<ServiceModule> selectListByUserId(Long userId);

    /**
     * 描述：根据Id更新所有我的功能
     * 参数：Id
     * 返回值：void
     * 修改人：sunxiaoya
     * 修改时间：2018/4/8
     * 修改内容：
     */
    void update(ServiceModule serviceModule);

    /**
     * 描述：根据appId查询我的功能列表Api
     * 参数：appId
     * 返回值：ServiceModuleDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/12
     * 修改内容：
     */
    List<ServiceModule> getByAppId(String appId);


    /**
     * 查询功能按类型的统计数量
     * @param top
     * @return
     */
    List<ModuleCountDO> getModuleCount(Integer top);


    List<ServiceModule> findModuleName(Integer pageSize);

    /**
     * 查询功能应用关系-力引导布局数据
     * @return
     */
    List<ModuleRelationDO> getNodesDate();

    /**
     * 查询功能应用关系-力引导布局数据links
     * @return
     */
    List<ModuleRelationLinksDO> getLinksDate();
    /**
     * farglory
     * 降本提质-获取功能模块数
     * @return
     */
	List<Map<String, Object>> findComponentEstimatedValue();

	/**
	 * farglory
     * 降本提质-总数统计
     * @return
     */
	List<Map<String, Object>> findTotalStatistics();

    /**
     * 查询热门功能
     * @param top
     * @param isLogin 是否登录用户调用此接口，根据业务，只有登录用户才可以获取所有的功能模块，而非登录用户仅仅查看公开可见模块
     * @return
     */
    List<ServiceModule> hotModule(Integer top, boolean isLogin);

    /**
     * 2018-5-30增加返回模块类型名称
     * @param serviceModule
     * @param isLogin 是否登录用户调用此接口，根据业务，只有登录用户才可以获取所有的功能模块，而非登录用户仅仅查看公开可见模块
     * @return
     */
    List<ServiceModule> findAllServiceModule(ServiceModule serviceModule, boolean isLogin);

    /**
     * 根据服务查询对外接口使用top10
     * @return
     */
    List<Map<String,Object>> getServerUseTop();

    /**
     * 查询对外接口使用top5
     * @return
     */
    List<Map<String,Object>> getMonthInvokingTop();

    /**
     * 根据应用查询对外接口使用top5
     * @return
     */
    List<Map<String,Object>> getMonthAppTop();
}
