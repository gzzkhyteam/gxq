package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/***
 * 搜索服务（gxqpt-search项目）相关的异常代码
 * 搜索服务异常编码 范围：80000-84999
 */
public enum SearchException implements BaseExceptionCode {
    SEARCH_CREATE_INDEX_DATA(80000, "创建索引数据不能为空"),
    SEARCH_CREATE_APPID(80001, "appid不能为空"),
    SEARCH_CREATE_INDEX_ID(80002, "索引id不能为空"),
    SEARCH_CREATE_INDEX_TITLE(80003, "索引标题不能为空"),
    SEARCH_CREATE_INDEX_CONTENT(80004, "索引内容不能为空"),
    SEARCH_CREATE_INDEX_URL(80005, "索引URL不能为空"),
    SEARCH_CREATE_INDEX_COLLS(80006, "操作集合不能为空"),
    SEARCH_CREATE_INDEX_HAS_NOT_WRITE(80007, "操作包含没有写权限的集合"),
    SEARCH_CREATE_INDEX_SOLR_OFFLINE(80008, "SOLR不可用"),

    SEARCH_CREATE_CLOOECTION_DATA(80009, "创建集合数据不能为空"),
    SEARCH_CREATE_CLOOECTION_CODE(80010, "集合编码不能为空"),
    SEARCH_CREATE_CLOOECTION_NAME(80011, "集合名称不能为空"),
    SEARCH_CREATE_CLOOECTION_NAME_DUB(80012, "集合编码重合了"),
    SEARCH_CREATE_CLOOECTION_HSA_NOT_OPT(80013, "没有为该app创建集合的权限"),

    SEARCH_SEARCH_DATA(80014, "搜索数据不能为空"),
    SEARCH_SEARCH_COLL_HAS_EMPTY(80015, "搜索数据集合不能为空"),
    SEARCH_SEARCH_KEY_WORLDS_HAS_EMPTY(80016, "搜索数据关键字不能为空"),
    SEARCH_SEARCH_PAGE_NOW_HAS_EMPTY(80017, "搜索数据当前页不能为空"),
    SEARCH_SEARCH_PAGE_SIZE_HAS_EMPTY(80018, "搜索数据每页大小不能为空"),
    SEARCH_SEARCH_OPT_READ_HAS_EMPTY(80019, "搜索数据包括没有读权限的集合"),
    SEARCH_SEARCH_IS_HIG_HAS_EMPTY(80020, "搜索数据是否高亮不能为空"),

    SEARCH_ADMIN_APPOINT_HAS_NOT_OPT(80021, "分配集合权限没有操作该集合的权限"),
    SEARCH_ADMIN_APPOINT_OPT_HST_NOT(80022, "分配集合权限权限参数为空"),
    SEARCH_ADMIN_APPOINT_APP_HAS_BOT(80023, "分配集合权限该APP不存在"),
    SEARCH_ADMIN_APPOINT_DATA(80024, "分配集合权限参数不能为空"),
    SEARCH_ADMIN_APPOINT_COLL_HAS_NOT(80025, "分配集合集合ID参数不能为空"),
    SEARCH_ADMIN_APPOINT_OPT_ONT_RIGHT(80026, "分配集合权限权限参数错误"),

    SEARCH_ADMIN_COLLECTION_ID_NULL(80027, "集合id不能为空"),

    SEARCH_ANALYSIS_KEYWORLD_NULL(80028, "关键字分析关键字不能为空"),
    SEARCH_ANALYSIS_COLLECTION_NULL(80029, "关键字分析集合不能为空"),
    SEARCH_ANALYSIS_FIELD_NULL(80030, "关键字分析选择字段不能为空"),

    SEARCH_DELETE_ERROR(80031, "索引删除失败"),
    ;

    private int code;
    public String msg;

    SearchException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
