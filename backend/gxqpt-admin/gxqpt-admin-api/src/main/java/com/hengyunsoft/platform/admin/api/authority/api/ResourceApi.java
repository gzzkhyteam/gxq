package com.hengyunsoft.platform.admin.api.authority.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.api.hystrix.ResourceApiHystrix;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceUpdatDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.api.authority.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：资源管理Api
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.admin.feign.server:gxqpt-gate-server}",
        path = "/api/admin", fallback = ResourceApiHystrix.class)
public interface ResourceApi {


    /**
     * 描述：根据应用Id获取资源树
     * 参数：appId 应用Id
     * 返回值：ResourceTreeDto 资源树形结构
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    @RequestMapping(value = "/resource/getTree", method = RequestMethod.GET)
    Result<List<ResourceTreeDto>>  findTree(@RequestParam(value = "appId") String appId, @RequestParam(value = "isenable", required = false) Short isenable);

    
    /**
     * 描述：新增资源Api
     * 参数：[resourceSaveDto：资源新增实体]
     * 返回值：RoleSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/resource/save", method = RequestMethod.POST)
    Result<ResourceUpdatDto> save(@RequestBody ResourceSaveDto resourceSaveDto);

    /**
     * 描述：修改资源
     * 参数：resourceUpdatDto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @RequestMapping(value = "/resource/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody ResourceUpdatDto resourceUpdatDto);


    /**
     * 描述：删除资源
     * 参数：id 角色Id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    @RequestMapping(value = "/resouce/delete", method = RequestMethod.POST)
    Result<Boolean> delete(@RequestParam("id") Long id);
    
    
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
    @RequestMapping(value = "/resouce/drag", method = RequestMethod.GET)
    Result<Boolean> updateLocation(@RequestParam("currentId") Long currentId,@RequestParam("locateId") Long locateId,@RequestParam("appId") String appId,@RequestParam("type") String type);

    /**
     * 描述：根据资源Id查询资源详细信息
     * 参数：id：资源id
     * 返回值：ResourceUpdatDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/12
     * 修改内容：
     */
    @RequestMapping(value = "/resource/detail", method = RequestMethod.GET)
    Result<ResourceUpdatDto> getById(@RequestParam("id") Long id);

    /**
     * 获取指定应用的非公有的所有存在authUrls的资源列表。
     * 仅仅只获取需要后端验证的那些资源列表
     * 网关需要使用
     * @param appId
     * @return
     */
    @RequestMapping(value = "/resource/getAppAllNotpublicResourceOfExistAuthUrls", method = RequestMethod.GET)
	Result<List<ResourceDTO>> getAppAllNotpublicResourceOfExistAuthUrls(@RequestParam("appId") String appId);

    /**
     * 获取近12月资源和角色数量情况
     * @return
     */
    @RequestMapping(value = "/resource/findResourAndRoleLastYear", method = RequestMethod.GET)
    Result<Map> findResourAndRoleLastYear();

}
