package com.hengyunsoft.sso.authentication;


import com.hengyunsoft.sso.exception.CaptchaException;
import com.hengyunsoft.sso.exception.LoginAuthFailException;
import com.hengyunsoft.sso.exception.LoginDisableException;
import org.jasig.cas.authentication.AccountDisabledException;
import org.jasig.cas.web.flow.AuthenticationExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 追加异常类
 * @author sxy
 * @date 2018-06-28
 */
@Component
public class DefaultErrorExtraConfig {
    @Autowired
    private void authenticationExceptionHandler(@Qualifier("authenticationExceptionHandler") AuthenticationExceptionHandler authenticationExceptionHandler){

        List<Class<? extends Exception>> errors =  authenticationExceptionHandler.getErrors();
        List<Class<? extends Exception>>  extErrors = new ArrayList<>(errors.size()+1);
        extErrors.addAll(errors);

        //追加自定义异常类
        extErrors.add(CaptchaException.class);
        extErrors.add(LoginAuthFailException.class);
        extErrors.add(LoginDisableException.class);
        authenticationExceptionHandler.setErrors(extErrors);
    }
}
