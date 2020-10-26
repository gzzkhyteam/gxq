package com.hengyunsoft.exception;

/**
 * 运行期异常基类
 *
 * @author loujingying@hengyunsoft.com
 * @version 1.1.1, 2016-04-01
 * @see    java.lang.Exception
 * @since 1.1.1
 */
public abstract class BaseCheckedException extends Exception implements BaseException {

    private static final long serialVersionUID = 2706069899924648586L;

    /**
     * 异常信息
     */
    protected String message;

    /**
     * 具体异常码
     */
    protected int code;

    public BaseCheckedException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseCheckedException(int code, String format, Object... args) {
        super(String.format(format, args));
        this.code = code;
        this.message = String.format(format, args);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
