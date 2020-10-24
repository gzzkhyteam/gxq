package com.hengyunsoft.platform.mail.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mail.dto.JamesUserDTO;
import com.hengyunsoft.platform.mail.entity.po.JamesUser;
import com.hengyunsoft.platform.mail.repository.service.user.UserRegisterService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.hengyunsoft.commons.exception.core.MailExceptionCode.ACCOUNT_EXIST;
import static com.hengyunsoft.commons.exception.core.MailExceptionCode.ACCOUNT_NOT_NULL;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@RestController
@Slf4j
@RequestMapping("/register")
@Api(value = "用户注册", description = "邮箱注册")
public class UserRegisterController {
    @Resource
    private UserRegisterService userRegisterService;
    @Resource
    private DozerUtils dozerUtils;


    @ApiOperation(value = "注册邮箱", notes = "注册邮箱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户账号 c_user表", dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<JamesUserDTO> saveRegister(@RequestParam(value = "account") String account) {
        BizAssert.assertNotNull(ACCOUNT_NOT_NULL, account);
        BizAssert.assertFalse(ACCOUNT_EXIST, userRegisterService.check(account));

        JamesUser jamesUser = userRegisterService.saveUser(account);
        return Result.success(dozerUtils.map(jamesUser, JamesUserDTO.class));
    }

    @ApiOperation(value = "手动同步用户表信息", notes = "手动同步用户表信息")
    @RequestMapping(value = "/synManual", method = RequestMethod.GET)
    public Result<Boolean> updateUserInfo() {
       userRegisterService.synUserData();
        return Result.success(true);
    }

}
