package com.hengyunsoft.platform.admin.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.emp.GxqptEmpOrgResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserEditDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserManagerReqDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSaveDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSelectResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpAndUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpAndUserPageDTO;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.example.AssignRoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptEmpService;
import com.hengyunsoft.platform.admin.utils.SystemUtil;
import com.hengyunsoft.sec.PasswordEncoder;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@Slf4j
//@RequestMapping("/user")
public class UserApiImpl implements UserApi {

    @Autowired
    private UserService userService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptEmpService empService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AssignRoleService assignRoleService;

    private static final String NOT_ISDELETE = "0";
    private static final String ISENABLE = "1";

    //该方法移动到auth-server
    @Override
    @ApiIgnore
    @IgnoreToken
    //@RequestMapping(value = "/getById")
    public Result<UserDto> getById(@RequestParam(value = "id") Long id) {
        User user = userService.getById(id);
        UserDto dto = dozerUtils.map(user, UserDto.class);
        return Result.success(dto);
    }

    //该方法移动到auth-server
//    @Override
//    @ApiIgnore
//    @IgnoreAppToken
//    public Result<UserDto> getByAccount(@RequestParam(value = "account") String account) {
//        UserExample example = new UserExample();
//        example.createCriteria().andAccountEqualTo(account);
//        User user = userService.getUnique(example);
//        UserDto dto = dozerUtils.map(user, UserDto.class);
//        return Result.success(dto);
//    }

    @Override
    public Result<Boolean> isAdminManager() {
        Long id = BaseContextHandler.getAdminId();
        if (userService.isAdminManager(id) > 0) {
            return Result.success(true);
        }
        return Result.success(false);
    }

    @Override
    @ApiOperation(value = "查询所有平台用户", notes = "查询所有平台用户")
    public Result<PageInfo<UserResDTO>> page(@RequestBody OpenApiReq<UserResDTO> openApiReq) {
        Long id = BaseContextHandler.getAdminId();
        if (userService.isAdminManager(id) > 0) {
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

            UserExample example = new UserExample();
            if (openApiReq.getData() != null) {
                example.createCriteria().andAccountLike(UserExample.fullLike(openApiReq.getData().getAccount()))
                        .andLoginableEqualTo(openApiReq.getData().getLoginable())
                        .andNameLike(UserExample.fullLike(openApiReq.getData().getName()));
            } else {
                example.createCriteria();
            }
            example.setOrderByClause("sort_value asc");
            List<User> list = userService.find(example);
            List<UserResDTO> dtos = dozerUtils.mapPage(list, UserResDTO.class);
            for (UserResDTO dto : dtos) {
                if (dto.getOwnSystem() != null) {
                    dto.setOwnSystem(SystemUtil.findSystem(dto.getOwnSystem()));
                }
            }
            return Result.success(new PageInfo<>(dtos));
        }
        return Result.success(new PageInfo<>());
    }

    @Override
    @ApiOperation(value = "修改用户", notes = "修改用户")
    public Result<Boolean> update(@RequestBody UserEditDTO userEdit) {
        //1.验证并匹配手机格式
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userEdit.getId());
        if (userEdit.getPhone() != null
                && !Pattern.matches("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", userEdit.getPhone())) {
            BizAssert.fail(ExceptionCode.REGEX_PHONE_INVALID);
        }

        //2.修改
        User user = dozerUtils.map(userEdit, User.class);
        if (user.getPassword() != null && !"".equals(user.getPassword())) {
            user.setPassword(PasswordEncoder.encoder(user.getPassword()));
        } else {
            user.setPassword(null);
        }
        user.setUpdateUser(BaseContextHandler.getAdminId());
        user.setUpdateTime(new Date());
        userService.updateByIdSelective(user);
        if (userService.updateByIdSelective(user) > 0) {
            //获取user对应的emp的id
            GxqptEmpExample empExample = new GxqptEmpExample();
            empExample.createCriteria().andGxqptEmpIdEqualTo(user.getId());
            GxqptEmp emp = empService.getUnique(empExample);
            //修改user对应的emp
            GxqptEmp updateEmp = new GxqptEmp();
            updateEmp = updateWithObject(user, updateEmp);
            updateEmp.setId(emp.getId());
            if (user.getBirthday() != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                updateEmp.setBirthday(formatter.format(user.getBirthday()));
                updateEmp.setMainmobile(user.getPhone());
            }
            if (empService.updateByIdSelective(updateEmp) > 0) {
                return Result.success(true);
            }
        }
        return Result.fail("fail");
    }

    @Override
    @ApiOperation(value = "禁用用户(暂未使用)", notes = "禁用用户(暂未使用)")
    public Result<Boolean> updateBan(@RequestParam(value = "ids") Long[] ids, @RequestParam(value = "tag") Boolean tag) {
        if (ids != null && ids.length > 0) {
            List<User> list = new ArrayList<>();
            for (Long id : ids) {
                User user = new User();
                user.setId(id);
                user.setLoginable(tag);
                list.add(user);
            }
            if (userService.updateByIdSelective(list) > 0) {
                return Result.success(true);
            }
        }
        return Result.fail("fail");
    }

    @Override
    @ApiOperation(value = "查询人员关联", notes = "查询人员关联")
    public Result<PageInfo<GxqptEmpAndUserDTO>> pageEmpAndUser(@RequestBody OpenApiReq<GxqptEmpAndUserPageDTO> openApiReq) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, openApiReq.getData().getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.SYSTEMCODE, openApiReq.getData().getSystemCode());

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        String systemCode = SystemUtil.findSysCode(openApiReq.getData().getSystemCode());

        List<GxqptEmpAndUserDTO> list = dozerUtils.mapPage(empService.findEmps(openApiReq.getData().getId(), systemCode), GxqptEmpAndUserDTO.class);
        list.forEach(obj -> obj.setSystemCode(SystemUtil.findSystem(obj.getSystemCode())));
        PageInfo<GxqptEmpAndUserDTO> a = new PageInfo<>(list);
        return Result.success(a);
    }

    /**
     * 根据appId查询对应应用的管理员user
     *
     * @param appId
     * @return
     */
    @Override
    @ApiOperation(value = "应用管理员查询", notes = "根据appId查询对应应用的管理员user")
    @ApiResponses({
            @ApiResponse(code = 57501, message = "应用id不能为空")
    })
    public Result<List<UserSelectResDTO>> findManagerByApp(@RequestParam(value = "appId") String appId) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLICATION_ID_NULL, appId);

        //2.查询结果并转换
        List<UserSelectResDTO> list = dozerUtils.mapList(userService.findUserManagerByApp(appId), UserSelectResDTO.class);
        return Result.success(list);
    }


    @Override
    @ApiOperation(value = "用户新增", notes = "用户新增")
    @ApiResponses({
            @ApiResponse(code = 53002, message = "登录名username不能为空"),
            @ApiResponse(code = 53003, message = "密码不能为空"),
            @ApiResponse(code = 53006, message = "用户姓名不能为空"),
            @ApiResponse(code = 53007, message = "手机不能为空"),
            @ApiResponse(code = 53008, message = "登录状态不能为空"),
            @ApiResponse(code = 53009, message = "工作描述不能为空"),
    })
    public Result<Boolean> save(@RequestBody UserSaveDTO userSave) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_EMPTY, userSave.getAccount());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_PWD_EMPTY, userSave.getPassword());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_NULL, userSave.getName());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_PHONE_NULL, userSave.getPhone());
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_LOGINABLE_NULL, userSave.getLoginable());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_WORK_DESC_NULL, userSave.getWorkDesc());

        //2.验证账号唯一
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(userSave.getAccount());
        if (userService.find(example).size() > 0) {
            return Result.fail("账号被占用");
        }

        //3.添加用户
        User user = dozerUtils.map(userSave, User.class);
        Long createUser = BaseContextHandler.getAdminId();
        Date data = new Date();
        user.setPassword(PasswordEncoder.encoder(user.getPassword()));

        user.setCreateUser(createUser);
        user.setUpdateUser(createUser);
        user.setCreateTime(data);
        user.setUpdateTime(data);
        if (userService.save(user) != null) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 单位管理员绑定查询
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "单位管理员绑定查询", notes = "单位管理员绑定查询")
    public Result<PageInfo<UserManagerReqDTO>> pageManagerByOrg(@RequestBody OpenApiReq<String> openApiReq) {
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List list = userService.pageManagerByOrg(openApiReq.getData());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, UserManagerReqDTO.class)));
    }

    /**
     * 查询用户主单位
     *
     * @param userId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 57501, message = "应用id不能为空")
    })
    @ApiOperation(value = "单位管理员绑定查询", notes = "单位管理员绑定查询")
    public Result<GxqptEmpOrgResDTO> getMainOrg(@RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);

        //2.查询对应user信息
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        User user = userService.getUnique(userExample);

        //3.根据user体系查询对应emp
        if (user != null) {
            GxqptEmpExample empExample = new GxqptEmpExample();
            GxqptEmpOrgResDTO res = dozerUtils.map(empService.getMainOrg(user.getOwnSystem(), userId), GxqptEmpOrgResDTO.class);
            if (res != null) {
                return Result.success(res);
            }
            return Result.fail("没有绑定人员");
        }
        return Result.fail("没有该用户");
    }

    /**
     * 根据BaseHander获取人员
     *
     * @return
     */
    @Override
    @ApiOperation(value = "根据BaseHander获取人员", notes = "根据BaseHander获取人员")
    public Result<UserDto> get() {
        //验证
        if (BaseContextHandler.getAdminId() != null){
            Long userId = BaseContextHandler.getAdminId();

            //查询
            User user = userService.getById(userId);
            return Result.success(dozerUtils.map(user,UserDto.class));
        }
        return Result.fail("请重新登录!");
    }

    /**
     * 根据账号集合查询对应用户id集合
     *
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 53013, message = "账号不能为空")
    })
    @IgnoreToken
    @ApiOperation(value = "根据账号集合查询对应用户id集合", notes = "根据账号集合查询对应用户id集合")
    public Result<List<Long>> findIdByAccount(@RequestParam(value = "accounts") List<String> accounts) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ACCOUNT_NULL,accounts);

        //设置查询条件并查询结果
        UserExample example = new UserExample();
        example.createCriteria().andAccountIn(accounts);
        List<User> list = userService.find(example);

        //返回id集合
        return Result.success(list.stream().map(User::getId).collect(Collectors.toList()));
    }

    /**
     * 获取所有用户id和名称
     * @return
     */
    @Override
    @ApiOperation(value = "获取所有用户id和名称", notes = "获取所有用户id和名称")
    @IgnoreToken
    public Result<List<UserSelectResDTO>> findAllList() {
        //设置查询条件并查询结果
        UserExample example = new UserExample();
        example.createCriteria();
        List<User> list = userService.find(example);

        //返回集合
        return Result.success(dozerUtils.mapList(list, UserSelectResDTO.class));
    }

    @Override
    @ApiOperation(value = "根据角色code和appId获取角色的所有用户", notes = "根据角色code和appId获取角色")
    @RequestMapping(value = "/findUserByCodeAndAppId", method = RequestMethod.GET)
    public Result<List<UserResDTO>> findUserByCodeAndAppId(@RequestParam(value = "code") String code,
                                                           @RequestParam(value = "appId") String appId) {
        //1、验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.ROLE_APP_ID_NULL, appId);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.ROLE_CODE_EMPTY, code);

        //查询该角色所绑定的所有用户
        RoleExample example = new RoleExample();
        example.createCriteria().andAppIdEqualTo(appId).andCodeEqualTo(code);
        List<Role> list = roleService.find(example);
        if (list.isEmpty()){
            BizAssert.fail(AuthorityExceptionCode.ROLE_NOT_EXIST);
        }
        if (list.size() > 1) {
            BizAssert.fail(AuthorityExceptionCode.ROLE_NOT_UNIQUE);
        }

        //查询该角色绑定关系
        AssignRoleExample assignRoleExample = new AssignRoleExample();
        assignRoleExample.createCriteria().andRoleIdEqualTo(list.get(0).getId());
        List<AssignRole> assignRoles = assignRoleService.find(assignRoleExample);
        if (assignRoles.isEmpty()){
            return Result.success(Collections.EMPTY_LIST);
        }

        //查询该关系的所有用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(assignRoles.stream().map(AssignRole::getUserId).collect(Collectors.toList()));
        List<User> users = userService.find(userExample);

        return Result.success(dozerUtils.mapList(users, UserResDTO.class));
    }
    /**
     * 这是用于同步修改用户和人员
     * @param obj
     * @param res
     * @param <I> user
     * @param <T> emp
     * @return
     */
    private <I, T> T updateWithObject(I obj, T res) {
        //获取I的所有属性
        Class clazzObj = null;
        List<Field> fieldListObj = new ArrayList<>();
        clazzObj = obj.getClass();
        while (clazzObj != null) {
            fieldListObj.addAll(Arrays.asList(clazzObj.getDeclaredFields()));
            clazzObj = clazzObj.getSuperclass();
        }
        //获取T的所有属性
        Class clazzRes = null;
        List<Field> fieldListRes = new ArrayList<>();
        clazzRes = res.getClass();
        Class resTemp = clazzRes;

        while (clazzRes != null) {
            Field[] fields = clazzRes.getDeclaredFields();
            List<Field> fieldList = new ArrayList<>();
            for (Field s : fields) {
                //匹配是否为静态常量
                if (Modifier.isStatic(s.getModifiers())) {
                    continue;
                }
                fieldList.add(s);
            }
            fieldListRes.addAll(fieldList);
            clazzRes = clazzRes.getSuperclass();
        }
        List<String> objFielNames = fieldListObj.stream().map(Field::getName).collect(Collectors.toList());
        for (Field f : fieldListRes) {
            if (objFielNames.contains(f.getName())) {
                PropertyDescriptor pdObj = null;
                PropertyDescriptor pdRes = null;
                try {
                    pdObj = new PropertyDescriptor(f.getName(), obj.getClass());
                    pdRes = new PropertyDescriptor(f.getName(), res.getClass());
                    Method rM = pdObj.getReadMethod();//获得读方法
                    Method wM = pdRes.getWriteMethod();//获得写方法
                    Object readValue = rM.invoke(obj);
                    if (readValue != null) {
                        if (f.getType() == Integer.class) {
                            wM.invoke(res, Integer.valueOf(readValue.toString()));
                        } else if (f.getType() == String.class) {
                            wM.invoke(res, String.valueOf(readValue));
                        } else if (f.getType() == Boolean.class) {
                            wM.invoke(res, Boolean.valueOf(readValue.toString()));
                        } else if (f.getType() == Long.class) {
                            wM.invoke(res, Long.valueOf(readValue.toString()));
                        } else if (f.getType() == Date.class) {
                            Type[] types = wM.getGenericParameterTypes();
                            if (f.getType() == types[0]) {
                                wM.invoke(res, readValue);
                            }
                        }
                    }
                } catch (IntrospectionException e) {
                    //e.printStackTrace();
                    log.error("Exception",e);
                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
                    log.error("Exception",e);
                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
                    log.error("Exception",e);
                }
            }
        }
        return res;
    }
}
