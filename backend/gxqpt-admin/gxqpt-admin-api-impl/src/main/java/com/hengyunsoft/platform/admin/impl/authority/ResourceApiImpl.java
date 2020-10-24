package com.hengyunsoft.platform.admin.impl.authority;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.admin.api.authority.api.ResourceApi;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceUpdatDto;
import com.hengyunsoft.platform.admin.entity.core.po.Resource;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.RolePower;
import com.hengyunsoft.platform.admin.repository.authority.service.ResourceService;
import com.hengyunsoft.platform.admin.repository.authority.service.RolePowerService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RolePowerExample;
import com.hengyunsoft.platform.commons.utils.DBBoolean;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.impl.authority
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：资源管理管理Api
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：新增基础接口
 */
@Api(value = "API - ResourceApiImpl.java", description = "资源管理")
@RestController
@RequestMapping("resource")
@Slf4j
public class ResourceApiImpl implements ResourceApi {

    @Autowired
    ResourceService resourceService;
    @Autowired
    RolePowerService rolePowerService;
    @Autowired
    ApplicationService applicationService;
    @Autowired
    RoleService roleService;
    //@Autowired
    //private SearchApi searchApi;
    @Autowired
    private DozerUtils dozerUtils;
    /**
     * 根节点资源的id是-1
     */
    private static final Long ROOT_RESOURCE_ID = -1L;

    /**
     * 描述：根据应用Id获取资源树
     * 参数：appId 应用Id
     * 返回值：ResourceTreeDto 资源树形结构
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "资源树获取", notes = "根据应用Id获取资源树")
    @RequestMapping(value = "/getTree", method = RequestMethod.GET)
    public Result<List<ResourceTreeDto>> findTree(@RequestParam(value = "appId") String appId, @RequestParam(value = "isenable", required = false) Short isenable) {
        log.info("进入getTree方法, appId={}", appId);
        //1、如果传入应用Id为空，则返回null
        if (StringUtils.isEmpty(appId)) {
            return Result.success(null);
        } else {
            //2、查找该应用下所有资源
            Long rootId = null;
            ResourceExample example = new ResourceExample();
            example.createCriteria()
                    .andAppIdEqualTo(appId)
                    .andStatusEqualTo(isenable);
            example.setOrderByClause("parent_id,order_no");
            List<Resource> resourceList = resourceService.find(example);
            if (resourceList != null) {
//                List<ResourceTreeDto> rsList = new ArrayList<>();
                List<ResourceTreeDto> treeList = dozerUtils.mapList(resourceList,
                        ResourceTreeDto.class);

                //获取根Id
//                for (ResourceTreeDto dto : treeList) {
//                    if (dto.getParentId().toString().equals("-1")) {
//                        rootId = Long.valueOf(dto.getId().toString());
//                        List<ResourceTreeDto> list = new ArrayList<>();
//                        list = TreeUtil.queryTree(treeList, rootId);
//                        dto.setChildren(list);
//                        rsList.add(dto);
//                    }
//                }
                List<ResourceTreeDto> rsList = TreeUtil.builderTreeOrdered(treeList);
                return Result.success(rsList);
            } else {
                return Result.success(null);
            }
        }
    }

    /**
     * 描述：新增资源
     * 参数：[resourceSaveDto：资源新增实体]
     * 返回值：RoleSaveDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "新增资源", notes = "新增资源")
    @ApiResponses({
            @ApiResponse(code = 51209, message = "资源应用Id不能为空"),
            @ApiResponse(code = 51200, message = "资源信息不能为空"),
            @ApiResponse(code = 51203, message = "资源类型[type]不能为空"),
            @ApiResponse(code = 51207, message = "资源菜单名称[name]不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = Resource.class, groups = {Default.class, MustNoneNull.class})
            }
    )
    public Result<ResourceUpdatDto> save(@RequestBody ResourceSaveDto resourceSaveDto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_NULL, resourceSaveDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_NAME_NULL, resourceSaveDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_TYPE_NULL, resourceSaveDto.getType());
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_APP_ID_NULL, resourceSaveDto.getAppId());

//        //2、判断资源名称唯一性
//        //判断角色名是否存在
//        boolean nameExist = queryNameIsExist(resourceSaveDto.getAppId(), resourceSaveDto.getName(), null);
//        if (nameExist) {
//            return Result.fail(AuthorityExceptionCode.RESOURCES_NAME_EXIST);
//        }

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        Resource resource = dozerUtils.map(resourceSaveDto, Resource.class);
        resource.setCreateTime(date);
        resource.setUpdateTime(date);
        resource.setCreateUser(userId);
        resource.setUpdateUser(userId);
        if (resource.getParentId() == null) {
            resource.setParentId(-1l);
        }

        //4、保存
        resource = resourceService.save(resource);

        //5、给新增的资源添加层级和序号
        //5.1、自动生成资源层级
        String leave = generateCode(resource);
        //5.2、自动生成序号
        Integer orderNo = generateOrderNo(resource);
        resource.setOrderNo(orderNo);
        resource.setLeve(leave);
        resourceService.updateByIdSelective(resource);

        // by tangyh 添加索引
        //if (resourceSaveDto.getType() == 1) {
        //    ApplicationExample example = new ApplicationExample();
        //    example.createCriteria().andAppIdEqualTo(resource.getAppId());
        //    Application application = applicationService.getUnique(example);
        //    if (application != null) {
        //        IndexItemDTO indexItemDTO = new IndexItemDTO();
        //        indexItemDTO.setCollection(AdminSearchCollections.ADMIN_SEARCH);
        //        indexItemDTO.setType(AdminSearchType.MENU.toString());
        //        indexItemDTO.setId(AdminSearchType.MENU.toString() + "_" + resource.getId());  //AdminSearchType.MENU.toString()_ID
        //        indexItemDTO.setTitle(resource.getName()); // 标题
        //        indexItemDTO.setContent(resource.getDesc()); //内容
        //        String indexUrl = null;
        //        if(StringUtils.isNotEmpty(application.getIndexUrl())){
        //            if(application.getIndexUrl().contains("?")){
        //                indexUrl = application.getIndexUrl() + "&url=" + resource.getUrl();
        //            } else {
        //                indexUrl = application.getIndexUrl() + "?url=" + resource.getUrl();
        //            }
        //        } else {
        //            indexUrl = resource.getUrl();
        //        }
        //        indexItemDTO.setUrl(indexUrl); //url
        //        indexItemDTO.setBizId(String.valueOf(resource.getId()));  //业务 ID
        //        indexItemDTO.setAppId("35kj6350");
        //        searchApi.addOrUpdateIndex(indexItemDTO);
        //    }
        //}

        //6、返回
        return Result.success(dozerUtils.map(resource, ResourceUpdatDto.class));
    }


    /**
     * 描述：自动生成序号
     * 参数：resource
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    private Integer generateOrderNo(Resource resource) {
        Integer orderNo = 1;

        ResourceExample example = new ResourceExample();
        example.createCriteria().andAppIdEqualTo(resource.getAppId())
                .andParentIdEqualTo(resource.getParentId());
        example.setOrderByClause("order_no desc");
        List<Resource> resourceList = resourceService.find(example);
        if (resourceList != null && resourceList.size() > 0) {
            Resource lastResource = resourceList.get(0);
            if (!lastResource.getId().equals(resource.getId())) {
                orderNo = resourceList.get(0).getOrderNo() + 1;
            }
        }

        return orderNo;

    }

    /**
     * 描述：自动生成层级
     * 参数：resource 资源实体
     * 返回值：String 层级值
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    private String generateCode(Resource resource) {
        String leave = "";
        Long parentId = resource.getParentId();
        if (parentId.equals(-1l)) {
            leave = String.valueOf(resource.getId());
        } else {
            Resource parentRs = resourceService.getById(parentId);
            leave = parentRs.getLeve() + "-" + resource.getId();
        }
        return leave;
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
    @ApiOperation(value = "修改资源", notes = "修改资源")
    @ApiResponses({
            @ApiResponse(code = 51205, message = "资源id[id]不能为空"),
            @ApiResponse(code = 51209, message = "资源应用Id不能为空"),
            @ApiResponse(code = 51200, message = "资源信息不能为空"),
            @ApiResponse(code = 51201, message = "资源编码[code]不能为空"),
            @ApiResponse(code = 51203, message = "资源类型[type]不能为空"),
            @ApiResponse(code = 51207, message = "资源菜单名称[name]不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = Resource.class, groups = {Default.class, MustNoneNull.class})
            }
    )
    public Result<Boolean> update(@RequestBody ResourceUpdatDto resourceUpdatDto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_NULL, resourceUpdatDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_ID_NULL, resourceUpdatDto.getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_NAME_NULL, resourceUpdatDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_CODE_EMPTY, resourceUpdatDto.getCode());
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_TYPE_NULL, resourceUpdatDto.getType());
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_APP_ID_NULL, resourceUpdatDto.getAppId());

//        //2、判断资源名称唯一性
//        //判断资源编码是否存在
//        boolean nameExist = queryNameIsExist(resourceUpdatDto.getAppId(), resourceUpdatDto.getName(), resourceUpdatDto.getId());
//        if (nameExist) {
//            return Result.fail(AuthorityExceptionCode.RESOURCES_NAME_EXIST);
//        }

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        Resource resource = dozerUtils.map(resourceUpdatDto, Resource.class);
        resource.setUpdateUser(userId);
        resource.setUpdateTime(date);

        //4、修改
        resourceService.updateByIdSelective(resource);
        return Result.success(true);
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
    @ApiOperation(value = "删除资源", notes = "删除资源")
    @ApiResponses({
            @ApiResponse(code = 51205, message = "资源Id不能为空"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam("id") Long id) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_ID_NULL, id);

        //2.进行该资源后的重新排序
        Resource resource = resourceService.getById(id);
        updateOrderNo(resource, 1, null);

        //3.对资源进行删除
        resourceService.deleteById(id);
        //同时对角色资源关联进行级联删除
        RolePowerExample example = new RolePowerExample();
        example.createCriteria().andBizIdEqualTo(id);
        List<RolePower> list = rolePowerService.find(example);
        if (list != null && list.size() > 0) {
            List<Long> ids = new ArrayList<>();
            for (RolePower rolePower : list) {
                ids.add(rolePower.getId());
            }
            rolePowerService.deleteByIds(ids);
        }

        //by tangyh  删除全文索引
        //searchApi.remove(AdminSearchCollections.ADMIN_SEARCH, AdminSearchType.MENU.toString() + "_" + id);

        //4.返回
        return Result.success(true);
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
    @ApiOperation(value = "拖动资源", notes = "用于随意推动资源目录")
    @ApiResponses({
            @ApiResponse(code = 51210, message = "拖动位置不正确"),
            @ApiResponse(code = 51211, message = "获取当前拖动资源不正确"),
            @ApiResponse(code = 51209, message = "资源应用Id不能为空"),
    })
    @RequestMapping(value = "/drag", method = RequestMethod.GET)
    public Result<Boolean> updateLocation(@RequestParam("currentId") Long currentId, Long locateId, String appId, String type) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_DRAG_EXIST, currentId);
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_DRAG_ID_EXIST, locateId);
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_APP_ID_NULL, appId);

        
        //不允许将资源放置在根节点之上
        if(ROOT_RESOURCE_ID.equals( locateId ) && "prev".equalsIgnoreCase(type)){
        	
        	throw new BizException(-1, "不允许将资源放置在根资源之上！");
        }
        
        
        //2.获取当前资源及当前资源包含的子集
        //当前资源
        Resource currentRs = new Resource();
        currentRs = resourceService.getById(currentId);
        //当前资源所包含子集
        List<Resource> currentChildList = new ArrayList<>();
        ResourceExample example = new ResourceExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andParentIdEqualTo(currentRs.getId());
        currentChildList = resourceService.find(example);

        //4.拖动位置资源
        Resource dragRs = new Resource();
        dragRs = resourceService.getById(locateId);

        

        //如果把子资源放置于最顶层
        if (ROOT_RESOURCE_ID.equals(locateId)) {
            currentRs.setParentId(ROOT_RESOURCE_ID);
            currentRs.setLeve(currentRs.getId() + "");
            ResourceExample parentExample = new ResourceExample();
            parentExample.createCriteria().andAppIdEqualTo(currentRs.getAppId());
            parentExample.setOrderByClause("order_no desc");
            List<Resource> parentChildList = resourceService.find(parentExample);
            if (parentChildList.size() > 0) {
                currentRs.setOrderNo(parentChildList.get(0).getOrderNo() + 1);
            } else {
                currentRs.setOrderNo(1);
            }
            resourceService.updateByIdSelective(currentRs);
        } else {
            //5.拖动位置资源所包含子集
            List<Resource> dragChildList = new ArrayList<>();
            ResourceExample dragExample = new ResourceExample();
            dragExample.createCriteria().andAppIdEqualTo(appId)
                    .andParentIdEqualTo(dragRs.getId());
            dragExample.setOrderByClause("order_no desc");
            dragChildList = resourceService.find(dragExample);
            //6.对拖动资源及拖动位置的资源进行修改
            //6.1如果拖动位置资源存在子资源，则把拖动资源做为拖动后资源的子集
            if (dragChildList != null && dragChildList.size() > 0) {
                switch (type) {
                    case "inner":
                        currentRs.setParentId(dragRs.getId());
                        currentRs.setLeve(dragRs.getLeve() + "-" + currentRs.getId());
                        currentRs.setOrderNo(dragChildList.get(0).getOrderNo() + 1);
                        resourceService.updateByIdSelective(currentRs);
                        break;
                    case "prev":
                        currentRs.setParentId(dragRs.getParentId());
                        currentRs.setLeve(dragRs.getLeve().replace(String.valueOf(dragRs.getId()), "") + currentRs.getId());
                        currentRs.setOrderNo(dragRs.getOrderNo());
                        resourceService.updateByIdSelective(currentRs);
                        updateOrderNo(currentRs, 2, currentRs.getId());
                        break;
                    case "next":
                        currentRs.setParentId(dragRs.getParentId());
                        currentRs.setLeve(dragRs.getLeve().replace(String.valueOf(dragRs.getId()), "") + currentRs.getId());
                        currentRs.setOrderNo(dragRs.getOrderNo() + 1);
                        resourceService.updateByIdSelective(currentRs);
                        updateOrderNo(currentRs, 2, currentRs.getId());
                        break;
                    default:
                        break;
                }
            } else { //6.2如果拖动后资源不存在子资源，则把拖动资源放置与拖动后资源的后面

                if (dragRs.getUrl().equals(null) || dragRs.getUrl().equals("")) {//证明是不含子资源的资源包,则更新拖动资源的praentId、leve、orderNo
                    if (type.equals("next")) {
                        currentRs.setParentId(dragRs.getParentId());
                        currentRs.setLeve(dragRs.getLeve() + "-" + currentRs.getId());
                        currentRs.setOrderNo(dragRs.getOrderNo() + 1);
                        resourceService.updateByIdSelective(currentRs);
                        //更推动位置后面资源的排序号
                        updateOrderNo(dragRs, 2, currentRs.getId());
                    } else if (type.equals("prev")) {
                        currentRs.setParentId(dragRs.getParentId());
                        currentRs.setLeve(dragRs.getLeve() + "-" + currentRs.getId());
                        currentRs.setOrderNo(dragRs.getOrderNo());
                        resourceService.updateByIdSelective(currentRs);
                        updateOrderNo(currentRs, 2, currentRs.getId());

                    } else if (type.equals("inner")) {
                        currentRs.setParentId(dragRs.getId());
                        currentRs.setLeve(dragRs.getLeve() + "-" + currentRs.getId());
                        currentRs.setOrderNo(1);
                        resourceService.updateByIdSelective(currentRs);

                    }
                } else {

                    // 对当前拖动资源的parentId进行修改，以及修改拖动资源的层级
                    currentRs.setOrderNo(dragRs.getOrderNo() + 1);
                    currentRs.setParentId(dragRs.getParentId());
                    currentRs.setLeve(dragRs.getLeve().replace(String.valueOf(dragRs.getId()), "") + currentRs.getId());
                    resourceService.updateByIdSelective(currentRs);

                    //更推动位置后面资源的排序号
                    updateOrderNo(dragRs, 2, currentRs.getId());
                }

            }
        }


        //7.更改子集的层级
        if (currentChildList != null && currentChildList.size() > 0) {
            for (Resource rs : currentChildList) {
                rs.setLeve(currentRs.getLeve() + "-" + rs.getId());
                resourceService.updateByIdSelective(rs);
            }
        }


        //8.返回成功结果
        return Result.success(true);
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
    @ApiOperation(value = "获取资源详情", notes = "根据资源Id查询资源详细信息")
    @ApiResponses({
            @ApiResponse(code = 51205, message = "资源[id]不能为空"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<ResourceUpdatDto> getById(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.RESOURCES_ID_NULL, id);

        Resource resource = resourceService.getById(id);
        if (resource == null) {
            return Result.success(null);
        }
        ResourceUpdatDto dto = dozerUtils.map(resource, ResourceUpdatDto.class);

        //3、返回结果
        return Result.success(dto);
    }

    /**
     * 描述：判断名称是否存在
     * 参数：appId ：应用Id，
     * 参数：name ：角色名称
     * 参数：resId ：资源Id
     * 返回值：boolean 为true 表示存在，false表示不存在
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    public boolean queryNameIsExist(String appId, String name, Long resId) {
        //1、根据角色Id查询角色信息
        boolean exist = false;
        ResourceExample example = new ResourceExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andNameEqualTo(name);
        List<Resource> resourcesList = resourceService.find(example);
        if (resourcesList != null && resourcesList.size() > 0) {
            for (Resource resource : resourcesList) {
                //用于判断修改的时候，如果修改的名称与
                if (resId != null) {
                    if (!resId.equals(resourcesList.get(0).getId())) {
                        exist = true;
                        break;
                    }
                } else {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    /**
     * 描述：根据传入当前资源，修改后面的资源编号
     * 参数：resource 资源属性
     * 参数：type 操作方式1：删除资源，2：新增资源
     * 参数：curentRsId 拖动资源Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/3/8
     * 修改内容：
     */
    public void updateOrderNo(Resource resource, int type, Long curentRsId) {
        //根据传入资源查询该资源同级以后的资源
        ResourceExample example = new ResourceExample();
        example.createCriteria().andAppIdEqualTo(resource.getAppId())
                .andParentIdEqualTo(resource.getParentId())
                .andOrderNoGreaterThanOrEqualTo(resource.getOrderNo());
        List<Resource> resourceList = resourceService.find(example);

        //如果查询的同级以后的资源不为空，针对删除，排序号进行减1操作，针对新增，排序号进行加1操作
        if (resourceList != null && resourceList.size() > 0) {
            for (Resource temp : resourceList) {
                if (resource.getId().equals(temp.getId())) {
                    continue;
                }
                if (curentRsId != null) {
                    if (curentRsId.equals(temp.getId())) {
                        continue;
                    }
                }
                //设置排序号
                if (type == 1) {
                    temp.setOrderNo(temp.getOrderNo() - 1);
                } else if (type == 2) {
                    temp.setOrderNo(temp.getOrderNo() + 1);
                }
                //修改排序号
                resourceService.updateByIdSelective(temp);
            }
        }

    }

    @Override
    @ApiOperation(value = "获取指定应用的非公有的所有存在authUrls的资源列表", notes = "获取指定应用的非公有的所有存在authUrls的资源列表")
    @RequestMapping(value = "/getAppAllNotpublicResourceOfExistAuthUrls", method = RequestMethod.GET)
    @AppToken
    public Result<List<ResourceDTO>> getAppAllNotpublicResourceOfExistAuthUrls(String appId) {

        if (StringUtils.isEmpty(appId)) {
            return Result.success(Collections.EMPTY_LIST);
        }
        ResourceExample example = new ResourceExample();
        example.createCriteria().andAppIdEqualTo(appId).andPublicIsNotEqualTo(DBBoolean.TRUE_STR).andAuthUrlsIsNotNull().andAuthUrlsNotEqualTo("");
        List<Resource> resources = resourceService.find(example);
        List<ResourceDTO> result = dozerUtils.mapList(resources, ResourceDTO.class);
        return Result.success(result);
    }

    @Override
    @ApiOperation(value = "获取近12月资源和角色数量情况", notes = "获取近12月资源和角色数量情况")
    @RequestMapping(value = "/findResourAndRoleLastYear", method = RequestMethod.GET)
    public Result<Map> findResourAndRoleLastYear() {
        //实例化返回参数
        Map res = new HashMap();
        List names = new ArrayList();
        List roleNum = new ArrayList();
        List resourceNum = new ArrayList();
        List dateRes = new ArrayList();
        List series = new ArrayList();

        //获取所有资源
        ResourceExample resourceExample = new ResourceExample();
        resourceExample.createCriteria();
        List<Resource> resourceList = resourceService.find(resourceExample);

        //获取所有角色
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria();
        List<Role> roleList = roleService.find(roleExample);

        //获取近12个月
        List<Date> dates = getLastYearMonth();
        dates.forEach(date -> {
            resourceNum.add(resourceList.stream().filter(obj -> isLagerDate(date, obj.getCreateTime())).count());
            roleNum.add(roleList.stream().filter(obj -> isLagerDate(date, obj.getCreateTime())).count());
            dateRes.add((1900 + date.getYear()) + "年" + (date.getMonth() + 1) + "月");
        });

        //设置资源返回map
        Map resourceMap = new HashMap();
        resourceMap.put("name", "资源");
        resourceMap.put("data", resourceNum);

        //设置角色map
        Map roleMap = new HashMap();
        roleMap.put("name", "角色");
        roleMap.put("data", roleNum);

        //添入统计map
        series.add(resourceMap);
        series.add(roleMap);

        //设置返回实体
        res.put("series", series);
        res.put("xAxis", dateRes);
        return Result.success(res);
    }

    /**
     * 获得过去12个月(包括本月)
     *
     * @return
     */
    private List<Date> getLastYearMonth() {
        List<Date> dates = new ArrayList<>();
        Date date = new Date();
        dates.add(date);
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 11; i++) {
            cal.setTime(date);
            cal.add(cal.MONTH, -1);
            date = cal.getTime();
            dates.add(date);
        }
        Collections.reverse(dates);
        return dates;
    }

    /**
     * 判断data1>data2
     *
     * @param date1
     * @param date2
     * @return
     */
    private boolean isLagerDate(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        if (date2 == null){
            return true;
        }
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);

            boolean isSameYear = cal1.get(Calendar.YEAR) >= cal2
                    .get(Calendar.YEAR);
            boolean isSameMonth = isSameYear
                    && cal1.get(Calendar.MONTH) >= cal2.get(Calendar.MONTH);
//            boolean isSameDate = isSameMonth
//                    && cal1.get(Calendar.DAY_OF_MONTH) == cal2
//                    .get(Calendar.DAY_OF_MONTH);

            return isSameMonth;
        } catch (Exception e) {
            log.error("[RatingEngine] error occurred: ERROR ", e);
        }
        return false;
    }
}
