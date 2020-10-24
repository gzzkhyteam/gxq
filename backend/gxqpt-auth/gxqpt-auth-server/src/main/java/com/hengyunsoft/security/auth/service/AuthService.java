package com.hengyunsoft.security.auth.service;

import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.auth.dto.TokenVo;

/**
 * @author tyh
 * @createTime 2017-12-15 13:41
 */
public interface AuthService {

    IJWTInfo validate(String token) throws BizException;

    void invalid(String token) throws BizException;

    /***
     * 生成用户指定应用的token【对外提供】
     * 区别在于有效期不同
     * @param appId
     * @param userId
     * @return
     * @throws BizException
     */
    TokenVo publicToken(String appId, String appSecret) throws BizException;
    /***
     * 生成用户指定应用的token【对内提供】
     * 区别在于有效期不同
     * @param appId
     * @param userId
     * @return
     * @throws BizException
     */
    TokenVo token(String appId, String appSecret) throws BizException;

    //TokenVo login(String appId, String appSecret, String userName);
}
