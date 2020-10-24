package com.hengyunsoft.platform.admin.impl.authority;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.dto.role.PtRoleFindLikeDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleAuthDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleListConditionDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleOrgDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleSaveDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleUpdatDto;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleUserDto;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.RolePower;
import com.hengyunsoft.platform.admin.impl.core.GxqptOrgApiImpl;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RolePowerService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample.Criteria;
import com.hengyunsoft.platform.admin.repository.core.example.RolePowerExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("role")
@Slf4j
public class RoleApiImpl implements RoleApi {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePowerService rolePowerService;

    @Autowired
    private AssignRoleService assignRoleService;

    @Autowired
    private UserService userService;

    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    ApplicationService applicationService;

    /**
     * 描述：新增角色
     * 参数：[roleSaveDto]
     * 返回值：com.hengyunsoft.base.Result<com.hengyunsoft.platform.admin.api.authority.dto.role.RoleSaveDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "新增角色", notes = "用于角色新增")
    @ApiResponses({
            @ApiResponse(code = 52000, message = "角色信息不能为空"),
            @ApiResponse(code = 52004, message = "角色名不能为空"),
            @ApiResponse(code = 52007, message = "应用Id不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = Role.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<RoleSaveDto> save(@RequestBody RoleSaveDto roleSaveDto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_NULL, roleSaveDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_NAME_NULL, roleSaveDto.getName());
//        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL, roleSaveDto.getAppId());

        //判断角色名是否存在
        boolean nameExist = queryNameIsExist(null, roleSaveDto.getAppId(), roleSaveDto.getName(), roleSaveDto.getPtRole());
        if (nameExist) {
            return Result.fail(AuthorityExceptionCode.ROLE_NAME_EXIST);
        }

        //判断角色code+appId是否重复
        RoleExample example = new RoleExample();
        example.createCriteria().andCodeEqualTo(roleSaveDto.getCode()).andAppIdEqualTo(roleSaveDto.getAppId());
        List<Role> unique = roleService.find(example);
        if (unique.size() > 0) {
            BizAssert.fail(AuthorityExceptionCode.ROLE_CODE_EXIST);
        }

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        Role role = dozerUtils.map(roleSaveDto, Role.class);
        role.setStatus((short) 1);
        role.setCreateTime(date);
        role.setUpdateTime(date);
        role.setCreateUser(userId);
        role.setUpdateUser(userId);
        role.setAuthManageIs(true);

        //4、保存
        role = roleService.save(role);

        //5、返回
        return Result.success(dozerUtils.map(role, RoleSaveDto.class));
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
    @ApiOperation(value = "修改角色", notes = "根据角色Id对角色信息进行修改")
    @ApiResponses({
            @ApiResponse(code = 52000, message = "角色信息不能为空"),
            @ApiResponse(code = 52004, message = "角色名不能为空"),
            @ApiResponse(code = 52003, message = "角色[id]不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody RoleUpdatDto roleUpdatDto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_NULL, roleUpdatDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_NAME_NULL, roleUpdatDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, roleUpdatDto.getId());

        //判断是否存在相同名称
        boolean nameExist = queryNameIsExist(roleUpdatDto.getId(), roleUpdatDto.getAppId(), roleUpdatDto.getName(), roleUpdatDto.getPtRole());
        if (nameExist) {
            return Result.fail(AuthorityExceptionCode.ROLE_NAME_EXIST);
        }

        //2、判断是否可以修改
        boolean isReadOnly = isReadOnly(roleUpdatDto.getId());
        if (!isReadOnly) {
            //3、基础数据获取
            Long userId = BaseContextHandler.getAdminId();
            Date date = new Date();

            //4、转换并赋值
            Role role = dozerUtils.map(roleUpdatDto, Role.class);
            role.setUpdateUser(userId);
            role.setUpdateTime(date);
            role.setAuthManageIs(true);

            //5、提交
            roleService.updateByIdSelective(role);

            //6、返回
            return Result.success(true);
        } else {
            //6、返回
            return Result.fail(AuthorityExceptionCode.ROLE_READONLY);
        }


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
//    @ApiOperation(value = "删除角色", notes = "根据父id-parentid查询地区名称信息List")
//    @RequestMapping(value = "/findAreaTree", method = RequestMethod.GET)
//    public Result<Boolean> delete(Long id) {
//        return null;
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
    @ApiOperation(value = "角色授权", notes = "给角色授予资源权限")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[roleId]不能为空"),
    })
    @RequestMapping(value = "/roleauth", method = RequestMethod.POST)
    public Result<Boolean> updateRoleAuth(@RequestBody RoleAuthDto roleAuthDto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, roleAuthDto.getRoleId());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、循环资源Id，并做保存操作
        Long roleId = roleAuthDto.getRoleId();
        if (roleAuthDto.getResourceAddIdList() != null && roleAuthDto.getResourceAddIdList().size() > 0) {
            for (Long resourceId : roleAuthDto.getResourceAddIdList()) {
                RolePower rolePower = new RolePower();
                rolePower.setBizId(resourceId);
                rolePower.setBizType((short) 1);
                rolePower.setRoleId(roleId);
                rolePower.setCreateTime(date);
                rolePower.setCreateUser(userId);
                rolePowerService.save(rolePower);
            }
        }

        if (roleAuthDto.getResourceRemoveIdList() != null && roleAuthDto.getResourceRemoveIdList().size() > 0) {
            for (Long resourceId : roleAuthDto.getResourceRemoveIdList()) {
                RolePowerExample example = new RolePowerExample();
                example.createCriteria().andBizIdEqualTo(resourceId)
                        .andRoleIdEqualTo(roleId);
                rolePowerService.deleteByEntity(example);
            }
        }


        //4、返回
        return Result.success(true);
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
    @ApiOperation(value = "给角色设置用户", notes = "给角色分配用户")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[roleId]不能为空"),
    })
    @RequestMapping(value = "/setroleuser", method = RequestMethod.POST)
    public Result<Boolean> updateRoleUser(@RequestBody RoleUserDto roleUserDto) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, roleUserDto.getRoleId());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、循环用户Id，并做保存操作
        Long roleId = roleUserDto.getRoleId();
        if (roleUserDto.getAddUserIdList() != null && roleUserDto.getAddUserIdList().size() > 0) {
            for (Long id : roleUserDto.getAddUserIdList()) {
                AssignRole assignRole = new AssignRole();
                assignRole.setUserId(id);
                assignRole.setRoleId(roleId);
                assignRole.setCreateTime(date);
                assignRole.setCreateUser(userId);
                assignRoleService.save(assignRole);
            }
        }
        if (roleUserDto.getRemoveUserIdList() != null && roleUserDto.getRemoveUserIdList().size() > 0) {
            for (Long id : roleUserDto.getRemoveUserIdList()) {
                AssignRoleExample example = new AssignRoleExample();
                example.createCriteria().andUserIdEqualTo(id)
                        .andRoleIdEqualTo(roleId);
                assignRoleService.deleteAssignRoleByEntity(example);
            }
        }


        //4、返回
        return Result.success(true);
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
    @ApiOperation(value = "获取应用拥有角色", notes = "根据应用Id查询角色分页信息List")
    @ApiResponses({
            @ApiResponse(code = 52007, message = "角色应用ID[appId]不能为空"),
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<RoleDto>> page(@RequestBody OpenApiReq<RoleListConditionDTO> openApiReq) {

        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL, openApiReq.getData());
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL, openApiReq.getData().getAppId());

        //2、执行查询
        RoleExample example = new RoleExample();
        String roleName = openApiReq.getData().getRoleName();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(RoleExample.fullLike(roleName));
        criteria.andDescLike(RoleExample.fullLike(openApiReq.getData().getRoleDesc()));
        criteria.andAppIdEqualTo(openApiReq.getData().getAppId()).andCodeNotEqualTo(GxqptOrgApiImpl.ROLE_CODE_SUFFIX);
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<RoleDto> list = dozerUtils.mapPage(roleService.find(example), RoleDto.class);

        //3、返回结果
        return Result.success(new PageInfo<>(list));
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
    @ApiOperation(value = "获取角色详情", notes = "根据角色Id查询角色详细信息")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[id]不能为空"),
    })
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result<RoleDto> getById(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, id);

        RoleExample example = new RoleExample();
        example.createCriteria().andIdEqualTo(id);
        Role role = roleService.getUnique(example);
        if (role == null) {
            return Result.success(null);
        }
        RoleDto dto = dozerUtils.map(role, RoleDto.class);

        //3、返回结果
        return Result.success(dto);
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
    @ApiOperation(value = "角色禁用", notes = "禁用角色")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[id]不能为空"),
    })
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public Result<Boolean> updateDisable(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, id);

        //2、判断是否可以修改
        boolean isReadOnly = isReadOnly(id);

        //3、如果不能修改，返回信息，否则进行禁用操作
        if (isReadOnly) {
            //3.1、返回失败信息
            return Result.fail(AuthorityExceptionCode.ROLE_READONLY);
        } else {
            // 3.2、赋予修改的值，并调用方法进行修改
            Role role = new Role();
            role.setId(id);
            role.setStatus((short) 2);
            roleService.updateByIdSelective(role);

            //3.3、返回成功
            return Result.success(true);
        }
    }

    /**
     * 描述：角色启用
     * 参数：id：角色id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "角色启用", notes = "启用角色")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[id]不能为空"),
    })
    @RequestMapping(value = "/enabled", method = RequestMethod.POST)
    public Result<Boolean> updateEnabled(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, id);

        //2、判断是否可以修改
        boolean isReadOnly = isReadOnly(id);

        //3、如果不能修改，返回信息，否则进行禁用操作
        if (isReadOnly) {
            //3.1、返回失败信息
            return Result.fail(AuthorityExceptionCode.ROLE_READONLY);
        } else {
            // 3.2、赋予修改的值，并调用方法进行修改
            Role role = new Role();
            role.setId(id);
            role.setStatus((short) 1);
            roleService.updateByIdSelective(role);

            //3.3、返回成功
            return Result.success(true);
        }
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
    @ApiOperation(value = "剔除用户角色", notes = "删除与角色关联的用户")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[id]不能为空"),
            @ApiResponse(code = 53001, message = "用户Id不能为空"),
    })
    @RequestMapping(value = "/deleteuserrole", method = RequestMethod.POST)
    public Result<Boolean> deleteuserrole(@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, id);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, id);

        //2、查询该角色-用户数据
        AssignRoleExample example = new AssignRoleExample();
        example.createCriteria().andRoleIdEqualTo(id)
                .andUserIdEqualTo(userId);
        List<AssignRole> assignRoleList = assignRoleService.find(example);

        //3、如果存在该条数据，则进行删除，否则返回失败
        if (assignRoleList != null) {
            assignRoleService.deleteById(assignRoleList.get(0).getId());
            return Result.success(true);
        } else {
            return Result.fail(AuthorityExceptionCode.DEPART_USER_NOT_EXIST);
        }
    }

    /**
     * 描述：根据角色Id查询相关联的用户Id
     * 参数：id 角色Id
     * 参数：appId 应用Id
     * 返回值：List<Long> 用户Id List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "获取角色用户", notes = "根据角色Id查询相关联的用户Id")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public Result<List<Long>> findUser(@RequestParam("id") Long id) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, id);

        AssignRoleExample example = new AssignRoleExample();
        example.createCriteria().andRoleIdEqualTo(id);
        List<AssignRole> userList = assignRoleService.find(example);

        //3、如果列表不为空，则循环遍历出资源Id返回，否则返回null
        if (userList != null) {
            List<Long> userIdList = new ArrayList<>();
            for (AssignRole assignRole : userList) {
                userIdList.add(assignRole.getUserId());
            }
            return Result.success(userIdList);
        } else {
            return Result.success(null);
        }
    }


    /**
     * 描述：查询角色所拥有资源
     * 参数：id：角色id;
     * 返回值：List<Long> 资源Id列表
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "获取角色资源", notes = "查询角色所拥有资源")
    @ApiResponses({
            @ApiResponse(code = 52003, message = "角色[id]不能为空"),
    })
    @RequestMapping(value = "/getowerresource", method = RequestMethod.GET)
    public Result<List<Long>> findowerresource(@RequestParam("id") Long id/*, @RequestParam(value = "appId",required = false) String appId*/) {
        //1、验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_ID_NULL, id);

        //2、查询该角色拥有的资源
        RolePowerExample example = new RolePowerExample();
        example.createCriteria().andRoleIdEqualTo(id);
        List<RolePower> powerList = rolePowerService.find(example);

        //3、如果列表不为空，则循环遍历出资源Id返回，否则返回null
        if (powerList != null) {
            List<Long> resIdList = new ArrayList<>();
            for (RolePower rolePower : powerList) {
                resIdList.add(rolePower.getBizId());
            }
            return Result.success(resIdList);
        } else {
            return Result.success(null);
        }
    }

    /**
     * 描述：判断角色是否只读
     * 参数：id 角色Id
     * 返回值：boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     */
    public boolean isReadOnly(Long id) {
        //1、根据角色Id查询角色信息
        RoleExample example = new RoleExample();
        example.createCriteria().andIdEqualTo(id);
        Role role = roleService.getUnique(example);

        //2、返回只读属性
        if (!ObjectUtils.isEmpty(role.getReadonly())) {
            return role.getReadonly();
        } else {
            return false;
        }
    }

    /**
     * 描述：判断名称是否存在
     * 参数：角色Id ：应用Id，
     * 参数：appId ：应用Id，
     * 参数：name ：角色名称
     * 返回值：boolean 为true 表示存在，false表示不存在
     * 修改人：zhaopengfei
     * 修改时间：2018/3/7
     * 修改内容：
     *
     * @param ptRole
     */
    public boolean queryNameIsExist(Long roleId, String appId, String name, Boolean ptRole) {
        //1、根据角色Id查询角色信息
        RoleExample example = new RoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        if (!StringUtils.isEmpty(appId)) {

            ptRole = null; //为什么将ptRole设置为null   因为只要指定了应用，那么就不用限制是否平台角色。
            criteria.andAppIdEqualTo(appId);
        }
        if (ptRole != null) {
            criteria.andPtRoleEqualTo(ptRole);
        }
        if (roleId != null) {
            criteria.andIdNotEqualTo(roleId);
        }
        return roleService.count(example) != 0;
    }


    /**
     * 描述：获取当前登录用户所拥有应用
     * 参数：id：角色id;
     * 返回值：ResourceTreeDto
     * 修改人：zhaopengfei
     * 修改时间：2018/3/6
     * 修改内容：
     */
    //@Override
    //@ApiOperation(value = "获取登录用户拥有应用", notes = "获取当前登录用户所用于用户")
    //@RequestMapping(value = "/getAppIdList", method = RequestMethod.GET)
    //public Result<List<AppShowDto>> findAppIdList() {
    //    //1、获取基础信息
    //    Long userId = BaseContextHandler.getAdminId();
    //
    //    //2、查询该角色拥有的资源
    //    List<AppShowDto> appShowDtos = dozerUtils.mapList(applicationService.queryAppByUserId(userId), AppShowDto.class);
    //
    //    //3、返回
    //    return Result.success(appShowDtos);
    //}

    /**
     * 描述：获取当前应用下所有单位基础信息
     * 参数：appId 应用Id
     * 返回值：List<RoleOrgDto> 应用展示信息List
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "获取当前应用下所有单位基础信息", notes = "获取当前应用下所有单位基础信息")
    @RequestMapping(value = "/getBaseOrgInfo", method = RequestMethod.GET)
    public Result<List<RoleOrgDto>> findBaseOrgInfo(@RequestParam("appId") String appId) {
        List<RoleOrgDto> roleOrgDtoList = dozerUtils.mapList(roleService.queryBaseOrgInfo(appId), RoleOrgDto.class);
        return Result.success(roleOrgDtoList);
    }

    @Override
    @ApiOperation(value = "根据appId 和 角色code 获取用户列表", notes = "根据appId 或者 角色code 获取用户列表")
    @RequestMapping(value = "/findUsersByAppIdAndCode", method = RequestMethod.POST)
    public Result<List<Long>> findUsersByAppIdAndCode(@RequestParam("appId") String appId, @RequestParam("code") String code) {
        RoleDto role = new RoleDto();
        if(null != appId && !appId.isEmpty() ){
            role.setAppId(appId);
        }
        if(null != code && !code.isEmpty()){
            role.setCode(code);
        }
        RoleExample example = builderRoleExample(role);
        List<Long> userList = roleService.findUsers(example);
        return Result.success(userList);
    }

    @Override
    @ApiOperation(value = "查询分页平台角色    仅仅平台管理员才可以查看", notes = "查询分页平台角色    仅仅平台管理员才可以查看")
    @RequestMapping(value = "/ptRolePage", method = RequestMethod.POST)
    public Result<PageInfo<RoleDto>> ptRolePage(@RequestBody OpenApiReq<PtRoleFindLikeDTO> openApiReq) {

        Long userId = BaseContextHandler.getAdminId();
        RoleExample example = new RoleExample();
        example.createCriteria().andPtRoleEqualTo(Boolean.TRUE)
                .andStatusEqualTo(RoleService.ENABLE_ROLE_STATUS)
                .andCodeEqualTo(RoleService.gxq_pt_admin_code);
        List<Role> roles = roleService.findUserRole(example, userId);
        if (CollectionUtils.isEmpty(roles)) {
            return Result.fail("不允许非平台管理员查看");
        }

        RoleExample ptQuery = new RoleExample();
        ptQuery.createCriteria().andPtRoleEqualTo(Boolean.TRUE)
                .andCodeLike(openApiReq.getData() != null && !StringUtils.isEmpty(openApiReq.getData().getCode())
                        ? RoleExample.fullLike(openApiReq.getData().getCode()) : null)
                .andNameLike(openApiReq.getData() != null && !StringUtils.isEmpty(openApiReq.getData().getName())
                        ? RoleExample.fullLike(openApiReq.getData().getName()) : null)
                .andAuthManageIsEqualTo(true);
        ptQuery.setOrderByClause(" create_time desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<RoleDto> list = dozerUtils.mapPage(roleService.find(ptQuery), RoleDto.class);

        //3、返回tianxie结果
        return Result.success(new PageInfo<>(list));
    }

    @Override
    @IgnoreToken
    @ApiOperation(value = "根据角色信息查询相关联的用户Id", notes = "根据角色信息查询相关联的用户Id")
    @RequestMapping(value = "/getUsersByRoleInfo", method = RequestMethod.POST)
    public Result<List<Long>> findUsers(@RequestBody RoleDto role) {
        //1、验证
        RoleExample example = builderRoleExample(role);
        List<Long> userList = roleService.findUsers(example);
        return Result.success(userList);
    }

    private RoleExample builderRoleExample(RoleDto role) {

        RoleExample roleExl = new RoleExample();
        RoleExample.Criteria criteria = roleExl.createCriteria();
        if (role.getId() != null) {
            criteria.andIdEqualTo(role.getId());
        }
        if (role.getPtRole() != null) {
            criteria.andPtRoleEqualTo(role.getPtRole());
        }
        if (role.getReadonly() != null) {
            criteria.andReadonlyEqualTo(role.getReadonly());
        }
        if (role.getAppId() != null) {
            criteria.andAppIdEqualTo(role.getAppId());
        }
        if (role.getBizFlag() != null) {
            criteria.andBizFlagEqualTo(role.getBizFlag());
        }
        if (role.getCode() != null) {
            criteria.andCodeEqualTo(role.getCode());
        }
        if (role.getCreateTime() != null) {
            criteria.andCreateTimeEqualTo(role.getCreateTime());
        }
        if (role.getCreateUser() != null) {
            criteria.andCreateUserEqualTo(role.getCreateUser());
        }
        if (role.getDesc() != null) {
            criteria.andDescEqualTo(role.getDesc());
        }
        if (role.getName() != null) {
            criteria.andNameEqualTo(role.getName());
        }
        if (role.getStatus() != null) {
            criteria.andStatusEqualTo(role.getStatus());
        }
        if (role.getUpdateTime() != null) {
            criteria.andUpdateTimeEqualTo(role.getUpdateTime());
        }
        if (role.getUpdateUser() != null) {
            criteria.andUpdateUserEqualTo(role.getUpdateUser());
        }
        return roleExl;
    }
}
