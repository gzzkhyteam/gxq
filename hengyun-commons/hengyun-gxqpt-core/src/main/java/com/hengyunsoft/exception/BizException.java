package com.hengyunsoft.exception;

/**
 * 业务异常
 * 用于在处理业务逻辑时，进行抛出的异常。
 *
 * @author loujingying@hengyunsoft.com
 * @version 1.0.4, 2016-03-30
 * @see Exception
 * @since 1.0.4
 */
public class BizException extends BaseUncheckedException {

    private static final long serialVersionUID = -3843907364558373817L;

    public BizException(int code, String message) {
        super(code, message);
    }

    public BizException(int code, String format, Object... args) {
        super(code, String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    /**
     * 实例化异常
     *
     * @param format
     * @param args
     * @return
     */
    public static BizException wrap(int code, String message, Object... args) {
        return new BizException(code, message, args);
    }

    @Override
    public String toString() {
        return "BizException [message=" + message + ", code=" + code + "]";
    }

}
