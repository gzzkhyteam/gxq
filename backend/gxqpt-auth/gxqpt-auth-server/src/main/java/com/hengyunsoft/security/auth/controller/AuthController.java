package com.hengyunsoft.security.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.service.AuthService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 客户端获取token
 * jwt token管理
 */
@RestController
@RequestMapping("/client")
@Api(value = "API - AuthController", description = "用户登录的token管理")
public class AuthController {

    @Autowired
    private AuthService authService;

    private IUserToken userToken = new BitEncryptUserToken(new ObjectMapper());

    /**
     * 获取token
     *
     * @param jwtAuthRequest
     * @return
     * @throws Exception
     */
    //@ApiIgnore
    //@RequestMapping(value = "token2", method = RequestMethod.POST)
    //public Result<TokenVo> token2(@RequestBody JwtAuthRequest jwtAuthRequest) throws BizException {
    //    //return Result.success(authService.token(jwtAuthRequest.getUserName(), jwtAuthRequest.getPassWord()));
    //    return Result.success(null);
    //}

    /**
     * 获取token
     *
     * @param appId     应用id
     * @param appSecret 应用密码
     * @param userId    用户id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "刷新并获取token", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "token", method = RequestMethod.POST)
    public Result<TokenVo> token(@RequestParam(value = "appId") String appId,
                                 @RequestParam(value = "appSecret") String appSecret) throws BizException {
        return Result.success(authService.token(appId, appSecret));
    }

    /**
     * 测试时获取应用token
     *
     * @param appId  应用id
     * @param userId 登录id
     * @return
     * @throws BizException
     */

    @ApiOperation(value = "测试时获取应用token", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "testGet", method = RequestMethod.POST)
    public Result<String> testGet(
            @ApiParam(defaultValue = "45kj6352")
            @RequestParam(value = "appId") String appId,
            @ApiParam(defaultValue = "file45kj6352")
            @RequestParam(value = "appSecret") String appSecret) throws BizException {
        return Result.success(TokenCache.of(appId, appSecret).get().get());
    }

    /**
     * 测试时获取用户级token    正式上线请删除
     *
     * @param appId  应用id
     * @param userId 登录id
     * @return
     * @throws BizException
     * @throws UnsupportedEncodingException
     */

    @ApiOperation(value = "测试时获取用户级token", notes = "测试时获取用户级token    正式上线请删除")
    @RequestMapping(value = "testGetUser", method = RequestMethod.GET)
    public Result<String> testGetUser(
            @ApiParam(defaultValue = "45kj6352")
            @RequestParam(value = "appId") String appId,
            @ApiParam(defaultValue = "file45kj6352")
            @RequestParam(value = "appSecret") String appSecret, String userId, String userName, UserTokenExtInfo userTokenExtInfo) throws Exception {

        String token = authService.token(appId, appSecret).getToken();


        token = userToken.encoder(token, userId, userName, userTokenExtInfo);

        return Result.success(URLEncoder.encode(token, "utf-8"));
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "验证token", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public Result<IJWTInfo> verify(@RequestParam(value = "token") String token) throws BizException {
        return Result.success(authService.validate(token));
    }

    /**
     * 前端登录专用
     *
     * @return
     */
    //@ApiIgnore
    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    //public Result<TokenVo> login(@RequestParam(value = "appId") String appId,
    //                             @RequestParam(value = "userName") String userName) throws BizException {
    //    return Result.success(authService.login(appId, userName));
    //}

    /**
     * 注销token
     *
     * @param token
     * @return
     */
    //@ApiIgnore
    //@RequestMapping(value = "invalid", method = RequestMethod.POST)
    //public Result<Boolean> invalid(@RequestParam(value = "token") String token) throws BizException {
    //    authService.invalid(token);
    //    return Result.success(true);
    //}
}
