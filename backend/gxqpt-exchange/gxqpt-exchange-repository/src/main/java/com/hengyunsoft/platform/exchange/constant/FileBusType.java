package com.hengyunsoft.platform.exchange.constant;

/**
 * com.hengyunsoft.platform.exchange.constant
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：文件业务类型
 * 修改人：zhaopengfei
 * 修改时间：2018/4/23
 * 修改内容：
 */
public enum FileBusType {
    DEMAND_APPLY_ACCORD("DEMAND_APPLY_ACCORD","需求申请依据"),
    API_APPLY_ACCORD("API_APPLY_ACCORD","共享申请依据"),
    ;
    private String val;
    private String describe;
    FileBusType(String val, String describe) {
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
