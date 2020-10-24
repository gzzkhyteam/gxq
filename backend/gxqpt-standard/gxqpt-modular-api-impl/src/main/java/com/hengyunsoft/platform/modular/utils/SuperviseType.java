package com.hengyunsoft.platform.modular.utils;

/**
 * com.hengyunsoft.platform.exchange.constant
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：类别和标签类型
 * 修改人：farglory
 * 修改时间：2019/4/23
 * 修改内容：
 */
public enum SuperviseType {
	MODULAR_CODE("MODULAR_CODE","审核","模块监控系统-类别和标签审核"),
    ;
    private String code;
    private String name;
    private String describe;
    SuperviseType(String code,String name, String describe) {
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
