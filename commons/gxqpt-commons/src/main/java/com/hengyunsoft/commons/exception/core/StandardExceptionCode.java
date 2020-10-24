package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 标准管理异常代码
 * 35000~39999, 每个子模块加500， 每个异常代码+1
 */
public enum StandardExceptionCode implements BaseExceptionCode {
    ID_NULL(35000, "ID不允许为空"),
    // 标准分类 start
    CLASSIFY_NULL(35001, "标准分类为空"),
    CLASSIFY_NAME_EMPTY(35002, "标准分类名称为空"),

    CLASSIFY_APPLY_NULL(35003, "标准分类申请信息为空"),
    CLASSIFY_APPLY_NAME_EMPTY(35004, "标准分类申请名称为空"),
    CLASSIFY_APPLY_PARENT_EMPTY(35005, "标准分类申请父类别为空"),

    CLASSIFY_APPLY_DEAL_NULL(35006, "处理申请信息为空"),
    // 标准分类 end

    //标准文档 start
    FILE_NULL(35501, "标准文档为空"),
    FILE_NAME_EMPTY(35502, "文档名称为空"),
    FILE_CLASSIFY_EMPTY(35503, "文档分类为空"),
    FILE_CLASSIFYID_EMPTY(35504, "文档分类id为空"),
    FILE_COMPANY_EMPTY(35505, "单位为空"),
    //标准文档 end

    //模块 start
    MODULAR_NAME_EMPTY(36001, "模块名称为空"),
    MODULAR_TYPE_EMPTY(36002, "模块类别为空"),
    MODULAR_TAG_EMPTY(36003, "模块标签为空"),
    MODULAR_GROUPID_EMPTY(36004, "groupId为空"),
    MODULAR_ARTIFACTID_EMPTY(36005, "artifactId为空"),
    MODULAR_DESCRIPTION_EMPTY(36006, "模块描述为空"),
    //模块 end

    //模块版本 start
    REPOSITORY_NAME_EMPTY(36501, "仓库名称为空"),
    MODULAR_VERSION_EMPTY(36502, "模块版本为空"),
    MODULAR_JAR_FILE_EMPTY(36503, "JAR文件为空"),
    MODULAR_CLASSIFIER_EMPTY(36504, "版本类型为空"),
    //模块版本 end
	
	//模块申请 start
    MODULAR_APPLY_NULL(37001, "模块申请信息为空"),
    MODULAR_APPLY_TYPE_EMPTY(37002, "模块申请类型为空"),
    MODULAR_APPLY_NAME_EMPTY(37003, "模块申请名称为空"),
    MODULAR_APPLY_DESCRIPTION_EMPTY(37004, "模块申请描述为空"),
    MODULAR_APPLY_REASON_EMPTY(37005, "模块申请原因为空"),
    MODULAR_APPLY_DEAL_SUGGESTION_EMPTY(37006, "处理意见为空"),
    //模块申请 end

    //提供商 start
    PROVIDER_INFOMATION_NAME(37101, "提供商名称不能为空"),
    PROVIDER_INFOMATION_ID(37100, "提供商ID不能为空"),
    PROVIDER_INFOMATION_PHONE(37102, "提供商联系电话不能为空"),
    PROVIDER_INFOMATION_ADDRESS(37103, "提供商地址不能为空"),
    PROVIDER_INFOMATION_DESCRIBLE(37104, "提供商简介不能为空"),

    //提供商 end
    ;
    private int code;

    private String msg;

    StandardExceptionCode(int code, String msg) {
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
