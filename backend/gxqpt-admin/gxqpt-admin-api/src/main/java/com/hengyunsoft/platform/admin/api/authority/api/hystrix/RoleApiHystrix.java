package com.hengyunsoft.platform.admin.api.authority.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.dto.role.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *com.hengyunsoft.platform.admin.api.resource.api.hystrix
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：熔断机制的实现， 默认返回超时响应
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：新增熔断机制
 */
@Component
public class RoleApiHystrix implements RoleApi{

    /**
     * 描述：新增角色Api
     * 参数：[roleSaveDto]
     * 返回值：com.hengyunsoft.base.Result<com.hengyunsoft.platform.admin.api.authority.dto.role.RoleSaveDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<RoleSaveDto> save(RoleSaveDto roleSaveDto) {
        return Result.timeout();
    }
    /**
     * 描述：修改角色
     * 参数：roleUpdatDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> update(RoleUpdatDto roleUpdatDto) {
        return Result.timeout();
    }
//    /**
//     * 描述：删除角色
//     * 参数：id 角色Id
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/3/6
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
    /**
     * 描述：角色授权
     * 参数：roleAuthDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> updateRoleAuth(@RequestBody RoleAuthDto roleAuthDto) {
        return Result.timeout();
    }
    /**
     * 描述：给角色设置用户
     * 参数：roleUserDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> updateRoleUser(@RequestBody RoleUserDto roleUserDto) {
        return Result.timeout();
    }
    /**
     * 描述：根据应用Id查询角色分页信息
     * 参数：openApiReq 分页信息；appId：应用Id
     * 返回值：PageInfo<RoleDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<PageInfo<RoleDto>> page(@RequestBody OpenApiReq<RoleListConditionDTO> openApiReq) {
        return Result.timeout();
    }
    /**
     * 描述：根据角色Id查询角色详细信息
     * 参数：id：角色id
     * 返回值：RoleDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<RoleDto> getById(Long id) {
        return Result.timeout();
    }
    /**
     * 描述：角色禁用
     * 参数：id：角色id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> updateDisable(Long id) {
        return Result.timeout();
    }

    /**
     * 描述：角色禁用
     * 参数：id：角色id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> updateEnabled(Long id) {
        return Result.timeout();
    }

    /**
     * 描述：剔除用户角色
     * 参数：id：角色id; userId:用户Id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> deleteuserrole(Long id, Long userId) {
        return Result.timeout();
    }
    /**
     * 描述：根据角色Id查询相关联的用户Id
     * 参数：id 角色Id
     * 参数：appId 应用Id
     * 返回值：List<Long>  用户Id List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<List<Long>> findUser(Long id) {
        return Result.timeout();
    }



    /**
     * 描述：查询角色所拥有资源
     * 参数：id：角色id;
     * 参数：appId：应用id;
     * 返回值：List<Long> 资源Id List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<List<Long>> findowerresource(Long id) {
        return Result.timeout();
    }

//    /**
//     * 描述：获取当前登录用户所拥有应用
//     * 返回值：List<AppShowDto> 应用展示信息List
//     * 修改人：zhaopengfei
//     * 修改时间：2018/3/8
//     * 修改内容：
//     */
//    @Override
//    public Result<List<AppShowDto>> findAppIdList() {
//        return  Result.timeout();
//    }

    /**
     * 描述：获取当前应用下所有单位基础信息
     * 参数：appId 应用Id
     * 返回值：List<RoleOrgDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    @Override
    public Result<List<RoleOrgDto>> findBaseOrgInfo(@RequestParam("appId") String appId) {
        return  Result.timeout();
    }

    @Override
    public Result<List<Long>> findUsersByAppIdAndCode(String appId, String code) {
        return  Result.timeout();
    }

    @Override
	public Result<PageInfo<RoleDto>> ptRolePage(OpenApiReq<PtRoleFindLikeDTO> openApiReq) {
	    return  Result.timeout();
	}
	@Override
	public Result<List<Long>> findUsers(RoleDto role) {
	    return  Result.timeout();
	}
}
