package com.hengyunsoft.sso.exception;

/**
 * 自定义登录认证异常类
 * @author sxy
 * @date 2018-07-13
 */
public class LoginDisableException extends java.security.GeneralSecurityException {

    private static final long serialVersionUID = 8025456443216286L;

    /**
     * Constructs a LoginAuthFailException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public LoginDisableException() {
        super();
    }

    /**
     * Constructs a LoginAuthFailException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public LoginDisableException(String msg) {
        super(msg);
    }

}
