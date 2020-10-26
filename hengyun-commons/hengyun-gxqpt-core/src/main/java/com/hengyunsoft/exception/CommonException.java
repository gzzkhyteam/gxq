package com.hengyunsoft.exception;

/**
 * 非业务异常
 * 用于在处理非业务逻辑时，进行抛出的异常。
 *
 * @author loujingying@hengyunsoft.com
 * @version 1.0.4, 2016-03-30
 * @see Exception
 * @since 1.0.4
 */
public class CommonException extends BaseCheckedException {


    public CommonException(int code, String message) {
        super(code, message);
    }

    public CommonException(int code, String format, Object... args) {
        super(code, String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    public CommonException wrap(int code, String format, Object... args) {
        return new CommonException(code, format, args);
    }

    @Override
    public String toString() {
        return "BizException [message=" + message + ", code=" + code + "]";
    }
}
