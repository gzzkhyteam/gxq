package com.hengyunsoft.utils;

public class Result {
    private static final int SUCCESS = 0;
    private int errcode;

    /**
     * 调用结果
     */
    private UploadResult data;

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

    public UploadResult getData() {
        return data;
    }

    public void setData(UploadResult data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccess() {
        return this.errcode == SUCCESS;
    }

    @Override
    public String toString() {
        return "Result [errcode=" + errcode + ", data=" + data + ", errmsg=" + errmsg + "]";
    }

}
