package com.hengyunsoft.platform.admin.api.authority.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.hystrix.RoleApiHystrix;
import com.hengyunsoft.platform.admin.api.authority.dto.role.*;
import io.swagger.annotations.ApiOperation;
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
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",

        fallback = RoleApiHystrix.class)

public interface RoleApi {

    /**
     * 描述：新增角色
     * 参数：[roleSaveDto]
     * 返回值：com.hengyunsoft.base.Result<com.hengyunsoft.platform.admin.api.authority.dto.role.RoleSaveDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    Result<RoleSaveDto> save(@RequestBody RoleSaveDto roleSaveDto);

    /**
     * 描述：修改角色
     * 参数：roleUpdatDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody RoleUpdatDto roleUpdatDto);


//    /**
//     * 描述：删除角色
//     * 参数：id 角色Id
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/3/6
//     * 修改内容：
//     */
//    @RequestMapping(value = "/role/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam("id") Long id);
//

    /**
     * 描述：角色授权
     * 参数：roleAuthDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/roleauth", method = RequestMethod.POST)
    Result<Boolean> updateRoleAuth(@RequestBody RoleAuthDto roleAuthDto);


    /**
     * 描述：给角色设置用户
     * 参数：roleUserDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/setroleuser", method = RequestMethod.POST)
    Result<Boolean> updateRoleUser(@RequestBody RoleUserDto roleUserDto);

    /**
     * 描述：根据应用Id查询角色分页信息
     * 参数：openApiReq 分页信息；appId：应用Id
     * 返回值：PageInfo<RoleDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/page", method = RequestMethod.POST)
    Result<PageInfo<RoleDto>> page(@RequestBody OpenApiReq<RoleListConditionDTO> openApiReq);
    
    /**
     * 描述：查询分页平台角色    仅仅平台管理员才可以查看
     * 参数：openApiReq 分页信息；
     * 返回值：PageInfo<RoleDto>
     * 修改人：潘定遥
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/ptRolePage", method = RequestMethod.POST)
    Result<PageInfo<RoleDto>> ptRolePage(@RequestBody OpenApiReq<PtRoleFindLikeDTO> openApiReq);


    /**
     * 描述：根据角色Id查询角色详细信息
     * 参数：id：角色id
     * 返回值：RoleDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/detail", method = RequestMethod.GET)
    Result<RoleDto> getById(@RequestParam("id") Long id);


    /**
     * 描述：角色禁用
     * 参数：id：角色id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/disable", method = RequestMethod.POST)
    Result<Boolean> updateDisable(@RequestParam("id") Long id);

    /**
     * 描述：角色启用
     * 参数：id：角色id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    @RequestMapping(value = "/role/enabled", method = RequestMethod.POST)
    Result<Boolean> updateEnabled(@RequestParam("id") Long id);

    /**
     * 描述：剔除用户角色
     * 参数：id：角色id; userId:用户Id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/deleteuserrole", method = RequestMethod.POST)
    Result<Boolean> deleteuserrole(@RequestParam("id") Long id,@RequestParam("userId") Long userId);

    /**
     * 描述：根据角色Id查询相关联的用户Id
     * 参数：id 角色Id
     * 返回值：List<Long>  用户Id List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/getUser", method = RequestMethod.GET)
    Result<List<Long>> findUser(@RequestParam("id") Long id);

    /**
     * 描述：根据角色信息查询相关联的用户Id
     * 参数：id 角色Id
     * 返回值：List<Long>  用户Id List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/getUsersByRoleInfo", method = RequestMethod.POST)
    Result<List<Long>> findUsers(@RequestBody RoleDto role);

    /**
     * 描述：查询角色所拥有资源
     * 参数：id：角色id;
     * 参数：id：角色id;
     * 返回值：List<Long> 资源Id列表
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/role/getowerresource", method = RequestMethod.GET)
    Result<List<Long>> findowerresource(@RequestParam("id") Long id);


    /**
     * 描述：获取当前登录用户所拥有应用
     * 返回值：List<AppShowDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/8
     * 修改内容：
     */
    //@RequestMapping(value = "/getAppIdList", method = RequestMethod.GET)
    //public Result<List<AppShowDto>>findAppIdList();


    /**
     * 描述：获取指定应用下可用的所有单位基础信息（应用共享的+省电子政务网的）
     * 参数：appId 应用Id
     * 返回值：List<RoleOrgDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    @RequestMapping(value = "/getBaseOrgInfo", method = RequestMethod.GET)
    public Result<List<RoleOrgDto>> findBaseOrgInfo(@RequestParam("appId") String appId );

    /**
     * 描述：根据角色信息查询相关联的用户Id
     * 参数：appId 应用的appId
     * 参数：code  角色的code
     * 返回值：List<Long>  用户Id List
     * 修改人：madengbo
     * 修改时间：2019/3/13
     * 修改内容：
     */
    @RequestMapping(value = "/role/findUsersByAppIdAndCode", method = RequestMethod.POST)
    Result<List<Long>> findUsersByAppIdAndCode(@RequestParam("appId") String  appId, @RequestParam("code") String code);

}