package com.hengyunsoft.platform.admin.open.authority;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.AuthorityModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceButtonDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgUserResPageDTO;
import com.hengyunsoft.platform.admin.entity.core.domain.ResourceDO;
import com.hengyunsoft.platform.admin.entity.core.po.Resource;
import com.hengyunsoft.platform.admin.open.authority.api.ResourceOpenApi;
import com.hengyunsoft.platform.admin.repository.authority.service.ResourceService;
import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample;
import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample.Criteria;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.impl.authority
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色管理Api
 * 修改人：zhangbiao
 * 修改时间：2018/3/26
 * 修改内容：新增基础接口
 */
@Api(value = "API - ResourceApiImpl.java", description = "资源管理：  资源=菜单+按钮等等（非菜单）")
@RestController
@RequestMapping("/p/resource")
@Slf4j
@AuthorityModule
public class ResourceOpenApiImpl implements ResourceOpenApi {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    ApplicationService applicationService;


    
	@Override
	@ApiOperation(value = "获取指定用户在指定应用下的所有可用资源" , notes = "获取指定用户在指定应用下的所有可用资源，这里的资源就不分菜单资源   按钮资源等等,全部获取")
	@ApiIgnore
	public Result<List<ResourceDTO>> findAllCanOperateResByAppIdAndUserId(String appId, Long userId) {
		
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL,appId);
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_USER_ID_NULL,userId);
        
		
        List<Resource> resources = resourceService.queryUserRes(appId, userId);
        
		return Result.success(dozerUtils.mapList(resources, ResourceDTO.class));
	}

    /**
     * 描述：通过应用Id获取其所有的资源列表
     * 参数：openApiReq
     * 返回值：List<ResourseDto>  资源集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */
    @Override
    @ApiOperation(value = "查询该应用下资源树" , notes = "根据应用Id获取其所有的资源树")
    @ApiResponses({
            @ApiResponse(code = 52007, message = "角色应用Id[appId]不能为空"),
    })
    @RequestMapping(value = "/findallresourse",method = RequestMethod.POST)
    @ApiIgnore
    public Result<List<ResourceTreeDto>> findAllResByAppId(@RequestParam(value = "appId") String appId) {
        //1、如果传入应用Id为空，则返回null
        if (null == appId) {
            return Result.success(null);
        } else {
            //2、查找该应用下所有资源
            Long rootId = null;
            ResourceExample example = new ResourceExample();
            example.createCriteria().andAppIdEqualTo(appId);
            example.setOrderByClause("parent_id,order_no");
            List<Resource> resourceList = resourceService.find(example);
            if (resourceList != null) {
                List<ResourceTreeDto> rsList = new ArrayList<>();
                List<ResourceTreeDto> treeList = dozerUtils.mapList(resourceList,
                        ResourceTreeDto.class);

                //获取根Id
                for (ResourceTreeDto dto : treeList) {
                    if (dto.getParentId().toString().equals("-1")) {
                        rootId = Long.valueOf(dto.getId().toString());
                        List<ResourceTreeDto> list = new ArrayList<>();
                        list = TreeUtil.queryTree(treeList, rootId);
                        dto.setChildren(list);
                        rsList.add(dto);
                    }
                }
                return Result.success(rsList);
            } else {
                return Result.success(null);
            }
        }
    }
    

//    @Override
//    @ApiOperation(value = "获取其所有的运行中的资源列表（树形）,可以进行分组查询" , notes = "获取其所有的运行中的资源列表（树形）,可以进行分组查询")
//    @RequestMapping(value = "/listRuningResTree",method = RequestMethod.GET)
//	public Result<List<ResourceTreeDto>> findAllRuningResByAppId(String group) {
//
//            //2、查找该应用下所有资源
//            ResourceExample example = new ResourceExample();
//            Criteria c = example.createCriteria().andAppIdEqualTo(BaseContextHandler.getAppId())
//            .andStatusEqualTo((short)EnableStatus.ENABLE.getStatus());
//            if(StringUtils.isNotEmpty(group)) {
//            	c.andGroupEqualTo(group);
//            }
//            example.setOrderByClause("parent_id,order_no");
//            List<Resource> resourceList = resourceService.find(example);
//            if (resourceList != null) {
//                List<ResourceTreeDto> treeList = dozerUtils.mapList(resourceList,
//                        ResourceTreeDto.class);
//                List<ResourceTreeDto> rsList = TreeUtil.builderTreeOrdered(treeList);
//                return Result.success(rsList);
//            } else {
//                return Result.success(null);
//            }
//	}
    
    /**
     * 描述：通过账号Id获取可访问菜单，应用id通过上下午信息获取
     * 参数：GxqptOrgUserResPageDTO
     * 返回值：ResourceTreeDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "获取通过用户Id获取可访问菜单，应用信息通过在token中信息获取" , notes = "通过账号Id获取可访问资源树(只访问菜单)")
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户Id不能为空")
    })
    @RequestMapping(value = "/findcanoperatemenu" , method = RequestMethod.POST)
    public Result<List<ResourceTreeDto>> findCanOperateMenu(@RequestBody GxqptOrgUserResPageDTO dto) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL,dto.getUserId());
        
        ResourceExample resourceExample = new ResourceExample();
        Criteria resourceCriteria = resourceExample.createCriteria()
        		  .andAppIdEqualTo(BaseContextHandler.getAppId()).andTypeEqualTo((short)1).andStatusEqualTo((short) 1);
        if(StringUtils.isNotEmpty(dto.getGroup())) {
        	resourceCriteria.andGroupEqualTo(dto.getGroup());
        }
        resourceExample.setOrderByClause(" order_no asc ");
        List<ResourceDO> userVisibleResource = resourceService.findUserVisibleResource(resourceExample,dto.getUserId());
        List<ResourceTreeDto> userVisibleResourceDTO = dozerUtils.mapList(userVisibleResource, ResourceTreeDto.class);
        List<ResourceTreeDto> userVisibleResourceTree = TreeUtil.builderTreeOrdered(userVisibleResourceDTO);
        return Result.success(userVisibleResourceTree);
    }

    /**
     * 描述：通过账号Id获取可访问按钮，应用id通过上下午信息获取
     * 参数：ResourceButtonDto
     * 返回值： ResourceSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "通过用户Id及resourceId(菜单id)获取此菜单下用户可使用的按钮，应用信息通过在token中信息获取" , notes = "通过账号Id、[分组、菜单Id]获取可访问按钮")
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户Id不能为空"),
//            @ApiResponse(code = 51105, message = "菜单Id不能为空")
    })
    @RequestMapping(value = "/findcanoperatebutton" , method = RequestMethod.POST)
    public Result<List<ResourceSaveDto>> findCanOperateButton(@RequestBody ResourceButtonDto dto) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL,dto.getUserId());
//        BizAssert.assertNotNull(AuthorityExceptionCode.MENU_ID_NULL,dto.getResourceId());

        //3.执行查询
        Map<String,Object> param = new HashMap<>();
        param.put("userId",dto.getUserId());
        param.put("appId",BaseContextHandler.getAppId());
        param.put("group",dto.getGroup());
        param.put("parentId",dto.getResourceId());
        param.put("status",1);

        List<Resource> tree = resourceService.findButtonList(param);
        List<ResourceSaveDto> treeList = dozerUtils.mapList(tree, ResourceSaveDto.class);
        return Result.success(treeList);
    }

    @ApiOperation(value = "获取指定用户在指定应用下的所有可用菜单")
	@Override
    @ApiIgnore
	public Result<List<ResourceTreeDto>> findAllCanOperateMenuByAppIdAndUserId(String appId, Long userId) {
    	
    	BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL,userId);
    	BizAssert.assertNotNull(AuthorityExceptionCode.APPLICATION_ID_NULL,appId);
        
        ResourceExample resourceExample = new ResourceExample();
        Criteria resourceCriteria = resourceExample.createCriteria()
        		  .andAppIdEqualTo(appId).andTypeEqualTo((short)1).andStatusEqualTo((short) 1);

        resourceExample.setOrderByClause(" order_no asc ");
        List<ResourceDO> userVisibleResource = resourceService.findUserVisibleResource(resourceExample,userId);
        List<ResourceTreeDto> userVisibleResourceDTO = dozerUtils.mapList(userVisibleResource, ResourceTreeDto.class);
        List<ResourceTreeDto> userVisibleResourceTree = TreeUtil.builderTreeOrdered(userVisibleResourceDTO);
        return Result.success(userVisibleResourceTree);
	}

}
