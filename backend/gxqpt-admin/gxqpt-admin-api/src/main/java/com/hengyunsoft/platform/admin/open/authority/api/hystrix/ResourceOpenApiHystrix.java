package com.hengyunsoft.platform.admin.open.authority.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceButtonDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgUserResPageDTO;
import com.hengyunsoft.platform.admin.open.authority.api.ResourceOpenApi;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ResourceOpenApiHystrix implements ResourceOpenApi {

    /**
     * 描述：通过应用Id获取其所有的资源列表
     * 参数：appId 应用Id
     * 返回值：List<ResourseDto>  资源集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */
    @Override
    public Result<List<ResourceTreeDto>> findAllResByAppId(String appId) {
        return Result.timeout();
    }

    /**
     * 描述：通过账号Id和应用Id获取可访问资源
     * 参数：ResourceButtonDto
     * 返回值： ResourceSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @Override
    public Result<List<ResourceTreeDto>> findCanOperateMenu(GxqptOrgUserResPageDTO dto) {
        return Result.timeout();
    }
    /**
     * 描述：通过账号Id和应用Id获取可访问按钮
     * 参数：ResourceButtonDto
     * 返回值： ResourceSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @Override
    public Result<List<ResourceSaveDto>> findCanOperateButton(ResourceButtonDto dto) {
        return Result.timeout();
    }

	@Override
	public Result<List<ResourceDTO>> findAllCanOperateResByAppIdAndUserId(String appId, Long userId) {
		 return Result.timeout();
	}

	@Override
	public Result<List<ResourceTreeDto>> findAllCanOperateMenuByAppIdAndUserId(String appId, Long userId) {
		return Result.timeout();
	}

//	@Override
//	public Result<List<ResourceTreeDto>> findAllRuningResByAppId(String group) {
//		return Result.timeout();
//	}


}
