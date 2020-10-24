package com.hengyunsoft.security.auth.util.client;


import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.auth.common.util.jwt.JWTHelper;
import com.hengyunsoft.security.auth.common.util.jwt.Token;
import com.hengyunsoft.security.auth.dto.TokenVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tangyh on 2017/9/10.
 */
@Component
public class JwtTokenUtil {

    @Value("${client.expire}")
    private int expire;
    @Value("${client.pri-key.path}")
    private String priKeyPath;
    @Value("${client.pub-key.path}")
    private String pubKeyPath;

    /**
     * 生成token
     * @param jwtInfo
     * @param expire 过期时间， 传null 或者小于等于0的数字，表示使用系统默认的过期时间
     * @return
     * @throws BizException
     */
    public TokenVo generateToken(IJWTInfo jwtInfo, Integer expire) throws BizException {
        if(expire == null || expire <= 0){
            expire = this.expire;
        }
        Token token = JWTHelper.generateToken(jwtInfo, priKeyPath, expire);
        return new TokenVo(token.getToken(), token.getExpire());
    }

    public IJWTInfo getInfoFromToken(String token) throws BizException {
        return JWTHelper.getInfoFromToken(token, pubKeyPath);
    }


}
