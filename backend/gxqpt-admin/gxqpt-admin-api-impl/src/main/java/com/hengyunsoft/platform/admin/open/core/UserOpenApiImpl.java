package com.hengyunsoft.platform.admin.open.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserUpdatePswDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgUserPageDTO;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.open.core.api.UserOpenApi;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptUserDO;
import com.hengyunsoft.sec.PasswordEncoder;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 账户管理-open
 *
 * @author wangzhen
 * @createTime 2018-03-26
 */
@Api(value = "API - UserApiImpl", description = "账号管理对外接口")
@RestController
@RequestMapping("/p/user")
@Slf4j
public class UserOpenApiImpl implements UserOpenApi {
    @Autowired
    private UserService userService;
    @Autowired
    private DozerUtils dozerUtils;

    @Override
    /**
     * 根据ids查询账号列表
     * @param ids
     * @return
     */
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "查询用户列表", notes = "根据ids查询用户列表")
    @RequestMapping(value = "/findUserByIds", method = RequestMethod.GET)
    public Result<List<UserResDTO>> findUserByIds(@RequestParam(value = "ids[]") Long[] ids) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, ids);
        //2.查询结果并返回
        if (ids.length == 0) {
            return Result.success(new ArrayList<>());
        }
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(Arrays.asList(ids));
        example.setOrderByClause("sort_value asc");
        List list = userService.find(example);
        return Result.success(dozerUtils.mapPage(list, UserResDTO.class));
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空")
    })
    @ApiOperation(value = "查询用户键值列表", notes = "根据ids查询用户列表,以id为键的map")
    @RequestMapping(value = "/findUserByIdList", method = RequestMethod.POST)
    public Result<Map<Long,UserResDTO>> findUserByIdList(@RequestBody ArrayList<Long> ids){
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, ids);
        //2.查询结果并返回
        Map<Long, UserResDTO> map = new HashMap<>();
        if (ids.size() == 0) {
            return Result.success(map);
        }
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        example.setOrderByClause("sort_value asc");
        List<User> list = userService.find(example);
        List<UserResDTO> users = dozerUtils.mapPage(list, UserResDTO.class);
        for (UserResDTO u : users) {
            map.put(u.getId(),u);
        }
        return Result.success(map);
    }


    /**
     * 描述：通過应用Id和角色编码获取绑定的用户账号列表
     * 参数：openApiReq
     * 返回值：List<UserDto>  用户集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */

    @Override
    @ApiOperation(value = "分页查询角色的用户列表", notes = "通过应用Id和角色编码分页获取绑定的用户账号列表")
    @ApiResponses({
            @ApiResponse(code = 52007, message = "角色应用Id[appId]不能为空"),
            @ApiResponse(code = 52001, message = "角色编码不能为空"),
    })
    @RequestMapping(value = "/p/user/finduser", method = RequestMethod.POST)
    public Result<PageInfo<UserDto>> findUserByAppIdAndCode(@RequestBody OpenApiReq<GxqptOrgUserPageDTO> openApiReq) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_APP_ID_NULL, openApiReq.getData().getAppId());
        BizAssert.assertNotNull(AuthorityExceptionCode.ROLE_CODE_EMPTY, openApiReq.getData().getCode());

        //2.设置分页
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.执行查询
        GxqptUserDO gxqptUserDO = new GxqptUserDO();
        gxqptUserDO.setAppId(openApiReq.getData().getAppId());
        gxqptUserDO.setCode(openApiReq.getData().getCode());
        List<User> list = userService.findUserByAppIdAndCode(gxqptUserDO);
        List<UserDto> pageList = dozerUtils.mapPage(list, UserDto.class);
        //4.返回结果
        return Result.success(new PageInfo<>(pageList));
    }

    @Override
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiResponses({
            @ApiResponse(code = 53001, message = "用户id不能为空"),
            @ApiResponse(code = 53010, message = "原始密码不能为空"),
            @ApiResponse(code = 53011, message = "新密码不能为空"),
            @ApiResponse(code = 53012, message = "确认密码不能为空"),
    })
    @RequestMapping(value = "/updatePsw", method = RequestMethod.POST)
    public Result<Boolean> updatePsw(@RequestBody UserUpdatePswDTO userUpdatePswDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userUpdatePswDTO.getId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_OLDPSW_NULL, userUpdatePswDTO.getOldPassword());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NEWPSW_NULL, userUpdatePswDTO.getNewPassword());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_TRUEPSW_NULL, userUpdatePswDTO.getTruePassword());

        if (!userUpdatePswDTO.getNewPassword().equals(userUpdatePswDTO.getTruePassword())) {
            return Result.fail("两次密码输入不一致！");
        }
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(userUpdatePswDTO.getId())
                .andPasswordEqualTo(PasswordEncoder.encoder(userUpdatePswDTO.getOldPassword()));
        if (userService.getUnique(example) != null) {
            User user = new User();
            user.setId(userUpdatePswDTO.getId());
            user.setPassword(PasswordEncoder.encoder(userUpdatePswDTO.getNewPassword()));
            if (userService.updateByIdSelective(user) > 0) {
                return Result.success(true);
            }
            return Result.fail("修改失败！");
        }
        return Result.fail("密码错误，请重新输入！");
    }
}
