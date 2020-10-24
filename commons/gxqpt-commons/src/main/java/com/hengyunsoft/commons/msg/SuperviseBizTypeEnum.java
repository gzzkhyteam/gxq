package com.hengyunsoft.commons.msg;

public enum SuperviseBizTypeEnum {
    /**
     * 业务应用运行监管
     */
    APP_RUNNING_RES_MSG("application", "业务应用运行监管",811664933153L,"业务应用监管预警","warning_remind_app_msg", "app_running_warn", "/#/businessApplication"),

    /**
     * 数据存储监管
     */
    DATA_STORAGE_RES_MSG("application", "数据存储监管",993018249537L,"数据存储监管预警","warning_remind_data_msg", "data_storage_warn", "/#/databaseStorageApplication");

    /**
     * 预警表biz类型编码
     */
    private String code;
    /**
     * biz类型描述
     */
    private String msg;
    /**
     * 预警类型id
     */
    private Long typeId;
    /**
     * 预警类型名称同详细描述
     */
    private String typeName;
    /**
     * 详细类型描述编码
     */
    private String detailedType;

    /**
     * 消息通知biz类型编码
     */
    private String bizTypeCode;

    /**
     * 消息通知biz类型编码
     */
    private String url;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDetailedType() {
        return detailedType;
    }

    public String getBizTypeCode() {
        return bizTypeCode;
    }

    public String getUrl() {
        return url;
    }

    SuperviseBizTypeEnum(String code, String msg, Long typeId, String typeName, String detailedType, String bizTypeCode, String url) {
        this.code = code;
        this.msg = msg;
        this.typeId = typeId;
        this.typeName = typeName;
        this.detailedType = detailedType;
        this.bizTypeCode = bizTypeCode;
        this.url = url;
    }
}
