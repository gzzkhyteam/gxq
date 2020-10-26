package com.hengyunsoft.sso.exception;

/**
 * 自定义验证码异常类
 * @author sxy
 * @date 2018-06-28
 */
public class CaptchaException extends java.security.GeneralSecurityException {

    private static final long serialVersionUID = 8025456443216286L;

    /**
     * Constructs a CaptchaException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public CaptchaException() {
        super();
    }

    /**
     * Constructs a CaptchaException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public CaptchaException(String msg) {
        super(msg);
    }

}
