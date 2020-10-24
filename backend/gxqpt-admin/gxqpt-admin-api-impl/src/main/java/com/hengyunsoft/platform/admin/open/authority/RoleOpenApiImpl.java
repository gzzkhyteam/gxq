package com.hengyunsoft.platform.admin.open.authority;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.AuthorityModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgRolePageDTO;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwOrg;
import com.hengyunsoft.platform.admin.impl.core.GxqptOrgApiImpl;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptOrgService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwOrgService;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * com.hengyunsoft.platform.admin.impl.authority
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色管理Api
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：新增基础接口
 */
@Api(value = "API - RoleApiImpl.java", description = "角色管理")
@RestController
@RequestMapping("/p/role")
@Slf4j
@AuthorityModule
public class RoleOpenApiImpl implements RoleOpenApi {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleApi roleApi;

    @Autowired
    private AssignRoleService assignRoleService;


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    private GxqptOrgService orgService;
    @Autowired
    private SdzzwwOrgService sdzzwwOrgService;
    @Autowired
    private UserService userService;

    /**
     * 描述：根据账号Id和应用Id获取其所有的角色
     * 参数：openApiReq
     * 返回值：PageInfo<RoleDto>  角色集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "查询角色", notes = "根据账号Id和应用Id获取其所有的角色")
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户Id不能为空"),
            @ApiResponse(code = 52007, message = "角色应用Id[appId]不能为空"),
    })
    @RequestMapping(value = "/findallrole" , method = RequestMethod.POST)
    public Result<PageInfo<RoleDto>> findAllRoleById(@RequestBody OpenApiReq<GxqptOrgRolePageDTO> openApiReq) {
        //1.验证
        //BizAssert.assertNotNull(AuthorityExceptionCode.USER_NOT_EXIST,account);
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL, openApiReq.getData().getAppId());
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, openApiReq.getData().getUserId());

        //2.设置分页
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.执行查询
		RoleExample example = new RoleExample();
		example.createCriteria().andAppIdEqualTo(openApiReq.getData().getAppId()).andStatusEqualTo(RoleService.ENABLE_ROLE_STATUS);
        List<Role> list = roleService.findUserRole(example,openApiReq.getData().getUserId());
        
        List<RoleDto> pageList = dozerUtils.mapPage(list, RoleDto.class);
        //4.返回结果
        return Result.success(new PageInfo<>(pageList));
    }

	@Override
    @RequestMapping(value = "/findUserPtRole" , method = RequestMethod.GET)
	public Result<List<RoleDto>> findUserPtRole(@RequestParam(value = "userId") Long userId) {
		
		BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
		
		RoleExample example = new RoleExample();
		example.createCriteria().andPtRoleEqualTo(Boolean.TRUE).andStatusEqualTo(RoleService.ENABLE_ROLE_STATUS);
        List<Role> list = roleService.findUserRole(example,userId);
        List<RoleDto> pageList = dozerUtils.mapPage(list, RoleDto.class);
        //4.返回结果
        return Result.success(pageList);
	}

	@Override
    @RequestMapping(value = "/findAllPtOrCurrentAppRoleById" , method = RequestMethod.POST)
	public Result<List<RoleDto>> findAllPtAndCurrentAppRoleById(@RequestParam(value = "userId") Long userId) {
		BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);
		String appId = BaseContextHandler.getAppId();
		RoleExample example = new RoleExample();
		example.createCriteria().andPtRoleEqualTo(Boolean.TRUE).andStatusEqualTo(RoleService.ENABLE_ROLE_STATUS);
		example.or().andAppIdEqualTo(appId).andStatusEqualTo(RoleService.ENABLE_ROLE_STATUS);
        List<Role> list = roleService.findUserRole(example,userId);
        List<RoleDto> pageList = dozerUtils.mapPage(list, RoleDto.class);
        //4.返回结果
        return Result.success(pageList);
	}

    /**
     * 通过userId查询是否單位管理員（根据定遙最新需求新增）
     * auther：tianai
     * 創建时间：2018-5-23
     * @param userId
     * @return
     */
    @Override
    @RequestMapping(value = "/getOrgUnit", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "通过userId查询是否單位管理員", notes = "通过userId查询是否單位管理員")
    public Result<Boolean> getOrgUnit(@RequestParam(value = "userId") Long userId,@RequestParam(value = "unitId") String unitId) {
        Boolean unitAdmin=false;
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL,userId);
        //2.查询
        User user = userService.getById(userId);
        if(unitId==null || unitId==""){
            return Result.fail("单位id不能为空");
        }
        GxqptOrg gxqOrg=orgService.getById(unitId);
        if(gxqOrg!=null){
            if(user.getAccount().equals(gxqOrg.getOrgadmin())){
                unitAdmin=true;
            }
        }
        SdzzwwOrg sdzOrg=sdzzwwOrgService.getById(unitId);
        if(sdzOrg!=null){
            if(user.getAccount().equals(sdzOrg.getOrgadmin())){
                unitAdmin=true;
            }
        }
        return Result.success(unitAdmin);
    }

	@Override
    @RequestMapping(value = "/getUsersByRoleInfo", method = RequestMethod.POST)
    @ApiOperation(value = "根据角色信息查询相关联的用户Id,上下文信息限定在请求应用中。自己应用只能够请求自己应用的角色绑定的用户")
	public Result<List<Long>> findUsers(@RequestBody RoleDto role) {
		
		String curRequestAppId = BaseContextHandler.getAppId();
		role.setAppId(curRequestAppId);
		return roleApi.findUsers(role);
	}

    /**
     * 根据账号Id和应用Id获取其所有的角色 无分页
     * @param rolePageDTO
     * @return
     */
    @Override
    @RequestMapping(value = "/findroleList" , method = RequestMethod.POST)
    @ApiOperation(value = " 根据账号Id和应用Id获取其所有的角色 无分页")
    public List<RoleDto> findroleList(@RequestBody GxqptOrgRolePageDTO rolePageDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL, rolePageDTO.getAppId());
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, rolePageDTO.getUserId());

        //2.执行查询
        RoleExample example = new RoleExample();
        example.createCriteria().andAppIdEqualTo(rolePageDTO.getAppId()).andStatusEqualTo(RoleService.ENABLE_ROLE_STATUS);
        List<Role> list = roleService.findUserRole(example,rolePageDTO.getUserId());

        List<RoleDto> pageList = dozerUtils.mapPage(list, RoleDto.class);
        //3.返回结果
        return pageList;
    }

    @Override
    @RequestMapping(value = "allRoleAble", method = RequestMethod.GET)
    @ApiOperation(value = "查询当前应用的所有可用角色")
	public Result<List<RoleDto>> allRoleAble() {
		
		String appId = BaseContextHandler.getAppId();
		
		//2、执行查询
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);
        criteria.andStatusEqualTo((short) 1);
        example.setOrderByClause("create_time desc");
        
        List<RoleDto> list = dozerUtils.mapPage(roleService.find(example), RoleDto.class);
        //3、返回结果
        return Result.success(list);
        
	}
}
