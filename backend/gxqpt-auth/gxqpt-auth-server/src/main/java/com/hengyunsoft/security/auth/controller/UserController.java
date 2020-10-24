package com.hengyunsoft.security.auth.controller;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.commons.sec.ISecurityStrategy;
import com.hengyunsoft.sec.PasswordEncoder;
import com.hengyunsoft.security.auth.dto.UserDTO;
import com.hengyunsoft.security.auth.jobs.TokenRefreshActuator;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Slf4j
@Api(value = "API - UserController", description = "用户登录账号密码验证管理")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DozerUtils dozerUtils;

    @Value("${gxqpt.randomstr}")
    private String randomstr;
    @Autowired
    private ISecurityStrategy securityStrategy;
    private final long HOURSE = 1 * 60 * 60 * 1000;


    //    @ApiIgnore
    @ApiOperation(value = "登录验证", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "/p/login", method = RequestMethod.POST)
    public Result<UserDTO> login(String account, String password) {
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, account);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, password);
        String enCoderPassword = PasswordEncoder.encoder(password);

        User user = userService.getLogin(account, enCoderPassword);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_NAME_PWD_ERROR, user);
        BizAssert.assertTrue(AuthorityExceptionCode.USER_LOGIN_DISABLE, user.getLoginable());
        return Result.success(dozerUtils.map(user, UserDTO.class));
    }
    
    @ApiOperation(value = "安全登录验证", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "/p/safeLogin", method = RequestMethod.POST)
    public Result<UserDTO> safeLogin(final String account,final String password,final String salt) {
    	BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, account);
    	BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, password);
    	UserExample queryByAccount = new UserExample();
    	queryByAccount.createCriteria().andAccountEqualTo(account);
		User user = userService.getUnique(queryByAccount);
    	BizAssert.assertNotNull(AuthorityExceptionCode.USER_NAME_PWD_ERROR, user);
    	
    	final String enCoderPassword = PasswordEncoder.encoder(user.getPassword().toUpperCase()+salt);
    	
        BizAssert.assertTrue(AuthorityExceptionCode.USER_NAME_PWD_ERROR, enCoderPassword.equals(password));
    	BizAssert.assertTrue(AuthorityExceptionCode.USER_LOGIN_DISABLE, user.getLoginable());
    	return Result.success(dozerUtils.map(user, UserDTO.class));
    }

//    @ApiIgnore
    @RequestMapping(value = "/user/getById", method = RequestMethod.GET)
    public Result<UserDTO> getById(@RequestParam(value = "id") Long id) {
        User user = userService.getById(id);
        System.out.println("id=" + id + "user=" + user);
        UserDTO dto = dozerUtils.map(user, UserDTO.class);
        return Result.success(dto);
    }

    @ApiIgnore
    @RequestMapping(value = "/user/getByAccount", method = RequestMethod.GET)
    public Result<UserDTO> getByAccount(@RequestParam(value = "account") String account) {
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account);
        User user = userService.getUnique(example);
        UserDTO dto = dozerUtils.map(user, UserDTO.class);
        return Result.success(dto);
    }

    @Autowired
    TokenRefreshActuator tokenRefreshActuator;
    @ApiIgnore


    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public Result<String> refresh() {
        tokenRefreshActuator.batchAppTokenRefresh();
        return Result.success("成功");
    }


}
