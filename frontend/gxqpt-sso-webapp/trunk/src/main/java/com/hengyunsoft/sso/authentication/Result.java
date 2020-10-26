package com.hengyunsoft.sso.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author tyh
 * @createTime 2017-12-13 10:55
 */
public class Result {
    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时，请稍候再试";
    private static final int SUCCESS = 0;
    private static final int FAIL = -1;

    /**
     * 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode]
     */
    private int errcode;

    /**
     * 调用结果
     */
    private UserDTO data;

    /**
     * 结果消息，如果调用成功，消息通常为空T
     */
    private String errmsg = "ok";



    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public UserDTO getData() {
        return data;
    }

    public void setData(UserDTO data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * 逻辑处理是否成功
     *
     * @return 是否成功
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.errcode == SUCCESS;
    }

	@Override
	public String toString() {
		return "Result [errcode=" + errcode + ", data=" + data + ", errmsg=" + errmsg + "]";
	}
}
