package com.hengyunsoft.security.auth.client.jwt;


import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.security.auth.client.config.AppAuthConfig;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.auth.common.util.jwt.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 第三方
 * Created by tangyh on 2017/9/15.
 */
@Configuration
public class AppAuthUtil {
    @Autowired
    private AppAuthConfig appAuthConfig;

    /**
     * 根据token， 公钥 解析 JWT 信息
     *
     * @param token
     * @return
     * @throws Exception
     */
    public IJWTInfo getInfoFromToken(String token) throws BizException {
        return JWTHelper.getInfoFromToken(token, appAuthConfig.getPubKeyPath());
    }
}
