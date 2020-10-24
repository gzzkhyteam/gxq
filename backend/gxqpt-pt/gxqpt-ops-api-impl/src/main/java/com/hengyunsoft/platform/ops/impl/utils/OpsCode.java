package com.hengyunsoft.platform.ops.impl.utils;

/**
 * com.hengyunsoft.platform.exchange.constant
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：文件业务类型
 * 修改人：tianai
 * 修改时间：2019/4/19
 * 修改内容：
 */
public enum OpsCode {
    /**
     * 运维审批推送到统一监管
     * @auther :tianai
     * @date 2019-04-29
     */
    SERVER_CODE("SERVER_APPLY","申请","运维管理平台-服务申请"),
    SERVER_DEAL_APPLY_CODE("SERVER_DEAL","服务申请处理","运维管理平台-服务申请处理"),
    TRAIN_CODE("TRAIN_APPLY","申请","运维管理平台-培训申请"),
    TRAIN_DEAL_APPLY_CODE("TRAIN_DEAL","培训申请处理","运维管理平台-培训申请处理"),
    CONSUIT_CODE("CONSUIT_APPLY","申请","运维管理平台-咨询申请"),
    CONSUIT_DEAL_APPLY_CODE("CONSUIT_DEAL","咨询申请处理","运维管理平台-咨询申请处理"),


    ;
    private String code;
    private String name;
    private String describe;
    OpsCode(String code,String name, String describe) {
        this.code = code;
        this.name = name;
        this.describe = describe;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescribe() {
        return describe;
    }
}
