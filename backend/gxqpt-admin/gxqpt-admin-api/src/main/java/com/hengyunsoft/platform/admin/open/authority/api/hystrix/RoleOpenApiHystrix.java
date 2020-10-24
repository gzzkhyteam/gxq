package com.hengyunsoft.platform.admin.open.authority.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgRolePageDTO;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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
public class RoleOpenApiHystrix implements RoleOpenApi {


    /**
     * 描述：新增角色Api
     * 参数：[openApiReg]
     * 返回值：com.hengyunsoft.base.Result<com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto>
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：
     */
    @Override
    public Result<PageInfo<RoleDto>> findAllRoleById(@RequestBody OpenApiReq<GxqptOrgRolePageDTO> openApiReq) { return Result.timeout(); }

	@Override
	public Result<List<RoleDto>> findUserPtRole(Long userId)  { return Result.timeout(); }

	@Override
	public Result<List<RoleDto>> findAllPtAndCurrentAppRoleById(Long userId)  {
    	return Result.timeout(); }

	@Override
	public Result<Boolean> getOrgUnit(Long userId,String unitId) {
		return Result.timeout();
	}

	@Override
	public Result<List<Long>> findUsers(RoleDto role) {
		return Result.timeout();
	}

    @Override
    public List<RoleDto> findroleList(GxqptOrgRolePageDTO rolePageDTO) {
    	return null;
    }

	@Override
	public Result<List<RoleDto>> allRoleAble() {
		return Result.timeout();
	}
}
