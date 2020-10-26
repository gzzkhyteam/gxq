package com.hengyunsoft.page;

/**
 * @author tyh
 * @createTime 2017-12-18 14:51
 */
public interface PageRequest {
    /**
     * 默认第一页
     */
    int FIRST_PAGE = 1;
    /**
     * 默认页面大小
     */
    int DEFAULT_LIMIT = 10;

    /**
     * 返回页码   注意 所有的页码从1开始
     *
     * @return
     */
    int getPageNo();

    /**
     * 每页记录条数
     *
     * @return
     */
    int getPageSize();
}
