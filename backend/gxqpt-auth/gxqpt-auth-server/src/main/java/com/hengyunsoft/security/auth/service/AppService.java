package com.hengyunsoft.security.auth.service;

import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.security.auth.dto.TokenVo;

/**
 * @author tyh
 * @createTime 2017-12-13 23:04
 */
public interface AppService {
    TokenVo applyToken(String appId, String appSecret) throws BizException;
}
