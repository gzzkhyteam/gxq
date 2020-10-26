package com.hengyunsoft.page.plugins.openapi;

import com.hengyunsoft.page.AbstractPageRequest;
import com.hengyunsoft.page.PageRequest;

import java.io.Serializable;

/**
 * @author tyh
 * @createTime 2017-12-18 14:53
 */
public class OpenApiReq<T> extends AbstractPageRequest implements PageRequest, Serializable {
    /**
     * 第几页   页码从1开始
     */
    private int pageNo;

    /**
     * 分页大小
     */
    private int pageSize;

    private T data;

    @Override
    public int getPageNo() {
        if (pageNo <= 0) {
            pageNo = FIRST_PAGE;
        }
        return pageNo;
    }

    @Override
    public int getPageSize() {
        if (this.pageSize <= 0) {
            pageSize = DEFAULT_LIMIT;
        }
        return pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
