package com.hengyunsoft.security.auth.service.impl;

import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.auth.common.util.jwt.JWTInfo;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.service.AuthService;
import com.hengyunsoft.security.auth.util.client.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author tyh
 * @createTime 2017-12-15 13:42
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationService applicationService;
    @Value("${client.pri-expire}")
    private int expire;
    //@Override
    //public TokenVo token(String userName, String passWord) throws BizException {
    //    if (userName == null || passWord == null
    //            || userName.isEmpty() || passWord.isEmpty()) {
    //        throw new BizException(FileExceptionCode.USER_NAME_PWD_ERROR.getCode(), FileExceptionCode.USER_NAME_PWD_ERROR.getMsg());
    //    }
    //    //Admin admin = userService.get(userName, passWord);
    //    //if (admin == null) {
    //    //    throw new BizException(FileExceptionCode.USER_NAME_PWD_ERROR.getCode(), FileExceptionCode.USER_NAME_PWD_ERROR.getMsg());
    //    //}
    //    //return jwtTokenUtil.generateToken(new JWTInfo(admin.getUsername(), admin.getId(), admin.getName(), admin.getAppId()));
    //    return null;
    //}

    @Override
    public TokenVo publicToken(String appId, String appSecret) throws BizException {
        return genToken(appId, appSecret, null);
    }
    @Override
    public TokenVo token(String appId, String appSecret) throws BizException {
        return genToken(appId, appSecret, expire);
    }

    private TokenVo genToken(String appId, String appSecret, Integer expire) throws BizException {
        Application application = applicationService.getAppIdAndAppSecret(appId, appSecret);
        if (application == null) {
            log.error("appId={}, appSecret={}", appId, appSecret);
            throw new BizException(ExceptionCode.JWT_APPID_SECRET_INVALID.getCode(), ExceptionCode.JWT_APPID_SECRET_INVALID.getMsg());
        }

        TokenVo tokenVo = jwtTokenUtil.generateToken(new JWTInfo(application.getAppId(), application.getName()), expire);
        log.info("tokenVo={}",tokenVo.getToken());
        if (tokenVo != null && StringUtils.isNotEmpty(tokenVo.getToken())) {
            TokenCache.of(appId, appSecret).set(tokenVo.getToken());
        }
        return tokenVo;
    }

    //@Override
    //public TokenVo login(String appId, String appSecret, String userName) throws BizException {
    //    if (userName == null || "".equals(userName)) {
    //        throw new BizException(AuthorityExceptionCode.USER_NAME_PWD_ERROR.getCode(), AuthorityExceptionCode.USER_NAME_PWD_ERROR.getMsg());
    //    }
    //    UserExample example = new UserExample();
    //    example.createCriteria().andAccountEqualTo(userName);
    //    User account = userService.getUnique(example);
    //    if (account == null) {
    //        throw new BizException(AuthorityExceptionCode.USER_NAME_PWD_ERROR.getCode(), AuthorityExceptionCode.USER_NAME_PWD_ERROR.getMsg());
    //    }
    //    Application application = applicationService.getAppIdAndAppSecret(appId, appSecret);
    //    if (application == null) {
    //        throw new BizException(ExceptionCode.JWT_APPID_SECRET_INVALID.getCode(), ExceptionCode.JWT_APPID_SECRET_INVALID.getMsg());
    //    }
    //    TokenVo tokenVo = jwtTokenUtil.generateToken(new JWTInfo(account.getId(), account.getName(), appId));
    //    if (tokenVo != null && StringUtils.isNotEmpty(tokenVo.getToken())) {
    //        TokenCache.of(appId, account.getId()).set(tokenVo.getToken());
    //    }
    //    return tokenVo;
    //}

    @Override
    public IJWTInfo validate(String token) throws BizException {
        return jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public void invalid(String token) throws BizException {

    }
}
