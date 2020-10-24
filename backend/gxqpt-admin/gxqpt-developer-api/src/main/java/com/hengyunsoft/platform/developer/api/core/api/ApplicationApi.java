package com.hengyunsoft.platform.developer.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.hystrix.ApplicationApiHystrix;
import com.hengyunsoft.platform.developer.api.core.dto.application.*;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplyAuditDTO;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplySaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserManagerReqDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserResDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 应用服务管理
 *
 * @author wz
 * @createTime 2018-04-03
 */
/*@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer", fallback = ApplicationApiHystrix.class)*/
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = ApplicationApiHystrix.class)
public interface ApplicationApi {
    /**
     * 根据name查询application数据
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/application/findAppListByName", method = RequestMethod.GET)
    Result<List<AppQueryDTO>> findAppListByName(@RequestParam(value = "name") String name);
    /**
     * 获取应用信息通过应用appId
     * @param appId
     * @return
     */
    @RequestMapping(value = "/application/getAppInforByAppId", method = RequestMethod.GET)
    Result<ApplicationAllDTO> getAppInforByAppId(@RequestParam(value = "appId") String appId);

    @RequestMapping(value = "/application/findList", method = RequestMethod.GET)
    Result<List<AppShowDto>> findAppIdList(@RequestParam(value = "type",required = false)Long type);

    /**
     * 应用列表查询(所有)
     *
     * @return
     */
    @RequestMapping(value = "/application/findAll", method = RequestMethod.POST)
    Result<PageInfo<ApplicationAllDTO>> findAll(@RequestBody OpenApiReq<ApplicationAllReqDTO> openApiReq);

    /**
     * 应用列表查询(所有非分页)
     *
     * @return
     */
    @RequestMapping(value = "/application/findAllList", method = RequestMethod.GET)
    Result<List<ApplicationAllDTO>> findAllList();

    /**
     * 应用列表查询
     *
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/find", method = RequestMethod.GET)
    Result<List<ApplicationResDTO>> find();

    /**
     * 获取应用根路径
     * @param appId
     * @return
     */
    @RequestMapping(value = "/getAppFullRootUrl", method = RequestMethod.GET)
    Result<String> getAppFullRootUrl(@RequestParam(value = "appId") String appId);

    /**
     * 应用列表查询
     *
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/findByType", method = RequestMethod.GET)
    Result<List<ApplicationSelectDTO>> findByType(@RequestParam(value = "type") Short type);

    /**
     * 根据应用类型查询
     *
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/findAppTypeAll", method = RequestMethod.GET)
    Result<List<ApplicationSelectDTO>> findAppTypeAll(@RequestParam(value = "type") String type);

    /**
     * 应用管理员查询
     *
     * @param openApiReq
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/pageAppManager", method = RequestMethod.POST)
    Result<PageInfo<UserResDTO>> pageAppManager(@RequestBody OpenApiReq<UserManagerReqDTO> openApiReq);

    /**
     * 应用管理员关联维护(取消关联)
     *
     * @param userId
     * @param appId
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/deleteAppManager", method = RequestMethod.DELETE)
    Result<Boolean> deleteAppManager(@RequestParam(value = "userId") Long userId,
                                     @RequestParam(value = "appId") String appId);

    /**
     * 应用管理员关联维护(关联)
     *
     * @param userId
     * @param appId
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/saveAppManager", method = RequestMethod.POST)
    Result<Boolean> saveAppManager(@RequestParam(value = "userId") Long userId,
                                   @RequestParam(value = "appId") String appId);

    /**
     * 应用详情查询
     *
     * @param id
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/getDetails", method = RequestMethod.GET)
    Result<ApplicationDetailsDTO> getDetails(@RequestParam(value = "id") Long id);

    /**
     * 应用信息修改
     *
     * @param applicationUpdate
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/updateApp", method = RequestMethod.PUT)
    Result<Boolean> updateApp(@RequestBody ApplicationUpdateDTO applicationUpdate);

    /**
     * 添加应用(申请栈)
     *
     * @param applicationApplySave
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/saveApply", method = RequestMethod.POST)
    Result<Boolean> saveApply(@RequestBody ApplicationApplySaveDTO applicationApplySave);

    /**
     * 添加应(审核栈)
     *
     * @param applicationApplyAudit
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/application/saveApp", method = RequestMethod.POST)
    Result<Boolean> saveApp(@RequestBody ApplicationApplyAuditDTO applicationApplyAudit);

    /**
     * 查询指定应用之间依赖关系接口  包含未依赖的应用
     * @param openApiReq  date id
     * @return
     */
    @RequestMapping(value = "/application/getApplicationRelation", method = RequestMethod.POST)
    Result<PageInfo<AppRelationRetDTO>> getApplicationRelation(@RequestBody OpenApiReq<AppQueryDTO> openApiReq);

    /**
     * 给应用添加依赖关系
     * @param appRelationDTO
     * @return
     */
    @RequestMapping(value = "/application/saveApplicationRelation", method = RequestMethod.POST)
    Result<String> saveApplicationRelation(AppRelationDTO appRelationDTO);

    /**
     * 删除app依赖关系
     * @param id
     * @return
     */
    @RequestMapping(value = "/application/deleteAppRelation", method = RequestMethod.DELETE)
    Result<String> deleteAppRelation(@RequestParam(value = "id") Long id);

    /**
     * 应用模糊查询
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/application/findLike", method = RequestMethod.POST)
    Result<PageInfo<ApplicationResDTO>> findLike(@RequestBody  OpenApiReq<ApplicationLikeDTO> openApiReq);
    
    /**
     * 查询自己可见的应用列表
     */
    @RequestMapping(value = "/application/findAppVisibleForSelf", method = RequestMethod.GET)
    Result<List<ApplicationResDTO>> findAppVisibleForSelf(@RequestParam(name = "type" ,required = false) Integer type);

    @RequestMapping(value = "/application/pageAppVisibleForSelf", method = RequestMethod.POST)
    Result<PageInfo<ApplicationResDTO>> pageAppVisibleForSelf(@RequestBody OpenApiReq<Integer>  openApiReq);

    @RequestMapping(value = "/application/pageAppVisibleForSelfName", method = RequestMethod.POST)
    Result<PageInfo<ApplicationResDTO>> pageAppVisibleForSelfName(@RequestBody OpenApiReq<RequestAppNameDTO>  openApiReq);

    /**
     * 统计查单位应用数量
     * @param status 查询是否启用的应用    null表示查询所有
     * @author 潘定遥
     * @return  
     */
    @RequestMapping(value = "/application/countOrgApplication", method = RequestMethod.GET)
    Result<List<CountOrgApplicationDTO>> countOrgApplication(@RequestParam(value = "status") Boolean status);
    
    /**
     * 获取所有的正在使用的接入appid
     * @return 接入应用的appid集合
     */
    @RequestMapping(value = "/application/getAllUseableJryy", method = RequestMethod.GET)
    Result<List<String>> getAllUseableJryy();

    /**
     * @todo 运维系统根据appid集合查询应用列表
     * @param OpenApiReq<RequestApplicationDTO>
     * @return PageInfo<ResponseApplicationDTO>
     * @Author wt
     * @createtime 2018-7-19
     */
    @RequestMapping(value = "/application/findByAppIdList", method = RequestMethod.POST)
    Result<PageInfo<ResponseApplicationDTO>> findByAppIdList(@RequestBody OpenApiReq<RequestApplicationDTO> openApiReq);

    /**
     * 门户查询五大支持应用类型
     * @return
     */
    @RequestMapping(value = "/application/findFiveSupport", method = RequestMethod.GET)
    Result<Map<String,List<ApplicationFiveSupportResDTO>>> findFiveSupport();
    
    /**
     *  获取指定应用的appSecret
     *  由于安全性问题，在获取的时候会检查登录人是否是应用的管理员
     */
    @RequestMapping(value = "/application/getAppSecret", method = RequestMethod.GET)
    Result<String> getAppSecret(String appId);

    /**
     * 查询我所管理的所有启用的应用或服务(1：应用；2：服务)
     * @param type
     * @return
     */
    @RequestMapping(value = "/application/findAppByAdminWithEnable", method = RequestMethod.GET)
    Result<List<AppShowDto>> findAppByAdminWithEnable(@RequestParam(value = "type", required = false) Long type);

    /**
     * 根据是否平台管理员查询管理应用或服务
     * @param type
     * @return
     */
    @RequestMapping(value = "/application/findAppByPower", method = RequestMethod.GET)
    Result<List<ApplicationResDTO>> findAppByPower(@RequestParam(value = "type", required = false) Long type);

    /**
     * 应用列表查询(模糊)
     *
     * @return
     */
    @RequestMapping(value = "/application/findAllLike", method = RequestMethod.POST)
    Result<List<ApplicationAllDTO>> findAllLike(@RequestBody ApplicationAllReqDTO dto);
    /**
     * 应用列表查询(模糊)
     *
     * @return
     */
    @RequestMapping(value = "/application/findAllLike/page", method = RequestMethod.POST)
    Result<PageInfo<ApplicationAllDTO>> PageAllLike(@RequestBody ApplicationAllReqDTO dto);

    /**
     * 根据是否pt管理员查询应用权限
     * @param type
     * @return
     */
    @RequestMapping(value = "/application/findAppIdListByPt", method = RequestMethod.GET)
    Result<List<AppShowDto>> findAppIdListByPt(@RequestParam(value = "type",required = false)Long type);

}
