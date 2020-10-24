package com.hengyunsoft.platform.exchange.constant;

/**
 * com.hengyunsoft.platform.exchange.constant
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：申请编号类型
 * 修改人：zhaopengfei
 * 修改时间：2018/4/23
 * 修改内容：
 */
public enum  ApplyType {
    API_APPLY("API","已封装API申请"),
    API_NOT_EXIST_APPLY("CA","目录新增API"),
    API_RENEVAL_APPLY("XQ","API续期"),
    API_DEMAND_APPLY("DM","需求申请"),
    DIRC_APPLY("MU","目录申请"),
    SET_APPLY("SET","数据集申请"),;
    private String val;
    private String describe;
    ApplyType(String val, String describe) {
        this.val = val;
        this.describe = describe;
    }
    public String getVal() {
        return val;
    }

    public String getDescribe() {
        return describe;
    }
}
