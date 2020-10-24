package com.hengyunsoft.security.auth.service.impl;

import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.service.AppService;
import com.hengyunsoft.security.auth.util.app.AppTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tyh
 * @createTime 2017-12-13 23:30
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppTokenUtil appTokenUtil;
    @Autowired
    private ApplicationService applicationService;

    @Override
    public TokenVo applyToken(String appId, String appSecret) throws BizException {
        //Application client = getClient(appId, appSecret);
        //return appTokenUtil.generateToken(new JWTInfo("", null, client.getName(), client.getAppId()));
        return null;
    }

    //private Application getClient(String appId, String appSecret) throws BizException {
    //    if (appId == null || appSecret == null
    //            || appId.isEmpty() || appSecret.isEmpty()) {
    //        throw new BizException(ExceptionCode.JWT_APPID_SECRET_INVALID.getCode(),
    //                ExceptionCode.JWT_APPID_SECRET_INVALID.getMsg());
    //    }
    //    Application app = applicationService.getBySecret(appId, appSecret);
    //    if (app == null) {
    //        throw new BizException(ExceptionCode.JWT_APPID_SECRET_INVALID.getCode(),
    //                ExceptionCode.JWT_APPID_SECRET_INVALID.getMsg());
    //    }
    //    //if (!app.getIsEnable()) {
    //    //    throw new BizException(ExceptionCode.JWT_APPID_ENABLED.getCode(),
    //    //            ExceptionCode.JWT_APPID_ENABLED.getMsg());
    //    //}
    //    return app;
    //}

    //TODO 这里差一个registryClient方法: 定时查询注册到eureka中的服务，查询他们的可用client，并用bus推送到各个服务
}
