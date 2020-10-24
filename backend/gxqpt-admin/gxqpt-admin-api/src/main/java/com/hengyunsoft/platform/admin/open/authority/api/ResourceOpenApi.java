package com.hengyunsoft.platform.admin.open.authority.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceButtonDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgUserResPageDTO;
import com.hengyunsoft.platform.admin.open.authority.api.hystrix.ResourceOpenApiHystrix;
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
 * 修改人：zhangbiao
 * 修改时间：2018/3/26
 * 修改内容：新增基础接口
 */
@FeignClient(name = "${gxqpt.admin.feign.server:gxqpt-gate-server}", 
        path = "/api/admin/p/resource", fallback = ResourceOpenApiHystrix.class)

public interface ResourceOpenApi {
    
    /**
     * 获取指定用户在指定应用下的所有可用资源
     * 这里的资源就不分菜单资源   按钮资源等等
     * @param appId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findresource" , method = RequestMethod.GET)
    Result<List<ResourceDTO>> findAllCanOperateResByAppIdAndUserId(@RequestParam(value = "appId") String appId,@RequestParam(value = "userId")  Long userId);
    /**
     * 获取指定用户在指定应用下的所有可用菜单
     * @param appId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findAllCanOperateMenuByAidUid" , method = RequestMethod.GET)
    Result<List<ResourceTreeDto>> findAllCanOperateMenuByAppIdAndUserId(@RequestParam(value = "appId") String appId,@RequestParam(value = "userId")  Long userId);

    /**
     * 描述：通过应用Id获取其所有的资源列表（树形）
     * 参数：appId 应用Id
     * 返回值：List<ResourseDto>  资源集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/findallresourse",method = RequestMethod.POST)
    Result<List<ResourceTreeDto>> findAllResByAppId(@RequestParam(value = "appId") String appId);
    
//    /**
//     * 描述：获取其所有的运行中的资源列表（树形）
//     * 参数：group 可以查询分组
//     * 返回值：List<ResourseDto>  资源集合
//     * 修改人：潘定遥
//     * 修改时间：2018/3/26
//     * 修改内容：新增基础接口
//     */
//    @RequestMapping(value = "/listRuningResTree",method = RequestMethod.GET)
//    Result<List<ResourceTreeDto>> findAllRuningResByAppId(@RequestParam("group") String group);

    /**
     * 描述：通过账号Id获取可访问菜单，应用id通过上下午信息获取
     * 参数：GxqptOrgUserResPageDTO
     * 返回值：ResourceTreeDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @RequestMapping(value = "/findcanoperatemenu" , method = RequestMethod.POST)
    Result<List<ResourceTreeDto>> findCanOperateMenu(@RequestBody GxqptOrgUserResPageDTO dto );

    /**
     * 描述：通过账号Id获取可访问按钮，应用id通过上下午信息获取
     * 参数：ResourceButtonDto
     * 返回值： ResourceSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */

    @RequestMapping(value = "/findcanoperatebutton" , method = RequestMethod.POST)
    Result<List<ResourceSaveDto>> findCanOperateButton(@RequestBody ResourceButtonDto dto );
}
