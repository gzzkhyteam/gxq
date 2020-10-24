package com.hengyunsoft.platform.supervise.impl.constant;

/**
 * 预警监控配置中心常量
 * 用于一些容易随着需求更改的常量配置，尽可能减轻内存使用
 */
public class WarnConstat {
    //应用的bizType
    public static final String BIZ_TYPE = "application";
    //最高级别预警
    public static final Integer TOP_LEVEL = 4;
    //数据存储预警对应名称
    public static final String STRING_DB_SIZE = "数据库空间,";
    //数据存储预警对应名称
    public static final String STRING_FILE_SIZE = "文件空间,";
    //数据存储预警对应名称
    public static final String STRING_LOG_SIZE = "日志空间,";
    //业务应用预警原因
    public static final String APP_LOGIN_REASON = "同时登录人数超过设置上限";
    //数据存储预警原因
    public static final String STORAGE_SIZE_REASON = "磁盘占用空间超过设置阀值，";
    //短信发送渠道id
    public static final String CHANNEL_ID = "888";
    //短信模板id
    public static final String TEMPLATE_ID = "531871031396241697";
    //主题
    public static final String WARN_TOPIC = "统一监管预警";

    /**
     * 监管环节预警id
     */
    public static final Long supervise_link_warn_id = 1805480099905l;

    /**
     * 监管环节预警名字
     */
    public static final String supervise_link_warn_name = "监管环节预警";

    /**
     *服务监管预警id
     */
    public static final Long server_supervise_warn_id = 2103447650401l;

    /**
     * 服务监管预警名字
     */
    public static final String server_supervise_warn_name = "服务监管预警";
}
