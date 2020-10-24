package com.hengyunsoft.platform.security;

import com.hengyunsoft.cas.sso.ext.CasConfigure;
import com.hengyunsoft.cas.sso.ext.MultipleCasConfigureManager;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tyh
 * @createTime 2017-11-17 14:59
 */
public class MultipleCasConfigureManagerExt extends MultipleCasConfigureManager {
    private String otherSystemRequestParameterName = "casFlag";

    public final static String cas_Flag_Key_In_Session = "_cas_Flag_Key_";
    public final static String cas_Flag_Value__In_Session = "_cas_Flag_Value_";
    @Override
    public CasConfigure getCasConfigureByKey(String key, HttpServletRequest httpRequest) {
        httpRequest.getSession().setAttribute(cas_Flag_Value__In_Session , key);
        httpRequest.getSession().setAttribute(cas_Flag_Key_In_Session, otherSystemRequestParameterName);
        return super.getCasConfigureByKey(key, httpRequest);
    }

    public void setCasConfigureKey(String casConfigureKey) {
        otherSystemRequestParameterName = casConfigureKey;
    }
}