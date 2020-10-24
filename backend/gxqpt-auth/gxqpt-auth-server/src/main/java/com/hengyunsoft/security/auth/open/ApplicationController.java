package com.hengyunsoft.security.auth.open;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第三方应用通过API获取token
 * Created by ace on 2017/9/10.
 */
@RestController
@RequestMapping("app")
@Api(value = "API - ApplicationController", description = "token管理")
public class ApplicationController {
    @Autowired
    private AuthService authService;

    @ApiOperation(value = "刷新并获取token", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "token", method = RequestMethod.POST)
    public Result<TokenVo> token(@RequestParam(value = "appId") String appId,
                                 @RequestParam(value = "appSecret") String appSecret) throws BizException {
        return Result.success(authService.token(appId, appSecret));
    }

    /** 刷新token */
    /** 验证token */
}
