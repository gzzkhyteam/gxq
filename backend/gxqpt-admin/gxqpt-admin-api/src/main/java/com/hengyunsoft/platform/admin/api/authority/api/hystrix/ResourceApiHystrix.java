package com.hengyunsoft.platform.admin.api.authority.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.api.ResourceApi;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceUpdatDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.api.authority.api.hystrix
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：熔断机制的实现， 默认返回超时响应
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：新增熔断机制
 */
@Component
public class ResourceApiHystrix implements ResourceApi {

    /**
     * 描述：根据应用Id获取资源树
     * 参数：appId 应用Id
     * 返回值：List<ResourceTreeDto> 资源树形结构
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    @Override
    public  Result<List<ResourceTreeDto>>  findTree(String appId, Short isenable) {
        return Result.timeout();
    }

    /**
     * 描述：新增资源Api
     * 参数：[resourceSaveDto：资源新增实体]
     * 返回值：RoleSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<ResourceUpdatDto> save(ResourceSaveDto resourceSaveDto) {
        return Result.timeout();
    }

    /**
     * 描述：修改资源
     * 参数：resourceUpdatDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> update(ResourceUpdatDto resourceUpdatDto) {
        return Result.timeout();
    }

    /**
     * 描述：删除资源
     * 参数：id 角色Id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    @Override
    public Result<Boolean> delete(Long id) {
        return Result.timeout();
    }


    /**
     * 描述：拖动资源
     * 参数：currentId:拖动当前资源Id，
     * 参数：locateId：1、如果拖动到非叶子节点下，则是非叶子节点Id，2、如果是拖动到叶子节点下，则是拖动到该位置的前一叶子节点Id
     * 参数：appId 应用Id
     * 参数：type 拖动类型，用于拖动到文件夹下面最后位置或者拖动到文件夹下面的第一位置
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    public Result<Boolean> updateLocation(Long currentId, Long locateId,String appId,String type) {
        return Result.timeout();
    }
    /**
     * 描述：根据资源Id查询资源详细信息
     * 参数：id：资源id
     * 返回值：ResourceUpdatDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/12
     * 修改内容：
     */
    @Override
    public Result<ResourceUpdatDto> getById(Long id) {
        return Result.timeout();
    }

	@Override
	public Result<List<ResourceDTO>> getAppAllNotpublicResourceOfExistAuthUrls(String appId) {
		return Result.timeout();
	}

    @Override
    public Result<Map> findResourAndRoleLastYear() {
        return Result.timeout();
    }
}
