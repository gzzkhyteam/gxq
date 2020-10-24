package com.hengyunsoft.platform.admin.open.authority.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleListConditionDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgRolePageDTO;
import com.hengyunsoft.platform.admin.open.authority.api.hystrix.RoleOpenApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * com.hengyunsoft.platform.admin.api.resource.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色管理Api
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = RoleOpenApiHystrix.class)
public interface RoleOpenApi {

    /**
     * 描述：根据账号Id和应用Id获取其所有的角色
     * 参数：openApiReq
     * 返回值：List<RoleDto>  角色集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/p/role/findallrole" , method = RequestMethod.POST)
    Result<PageInfo<RoleDto>> findAllRoleById(@RequestBody OpenApiReq<GxqptOrgRolePageDTO> openApiReq);

    /**
     * 描述：查询当前应用的所有可用角色
     */
    @RequestMapping(value = "/p/role/allRoleAble", method = RequestMethod.GET)
    Result<List<RoleDto>> allRoleAble();
    
    /**
     * 根据账号Id和应用Id获取其所有的角色 无分页
     * @param rolePageDTO
     * @return
     */
    @RequestMapping(value = "/p/role/findroleList" , method = RequestMethod.POST)
    List<RoleDto> findroleList(@RequestBody GxqptOrgRolePageDTO rolePageDTO);

    /**
     * 查找用户的平台角色列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/role/findUserPtRole" , method = RequestMethod.GET)
    Result<List<RoleDto>> findUserPtRole(@RequestParam(value ="userId") Long userId);
    /**
     * 查找指定人的所有平台角色和在当前应用下的所有角色
     */
    @RequestMapping(value = "/p/role/findAllPtOrCurrentAppRoleById" , method = RequestMethod.POST)
    Result<List<RoleDto>> findAllPtAndCurrentAppRoleById(@RequestParam(value = "userId") Long userId);


    /**
     * 根据userId查詢是否單位管理員
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/role/getOrgUnit", method = RequestMethod.GET)
    Result<Boolean> getOrgUnit(@RequestParam(value = "userId") Long userId,@RequestParam(value = "unitId") String unitId);
    
    /**
     * 描述：根据角色信息查询相关联的用户Id,上下文信息限定在请求应用中。自己应用只能够请求自己应用的角色绑定的用户
     * 参数：id 角色Id
     * 返回值：List<Long>  用户Id List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/p/role/getUsersByRoleInfo", method = RequestMethod.POST)
    Result<List<Long>> findUsers(@RequestBody RoleDto role);
}
