package com.hengyunsoft.platform.hardware.constant;

/**
 * 软硬件平台step枚举类型
 */
public enum  StepConstant {

    /*DRAFT("DRAFT","草稿箱","SQ","申请"),
    MANAGE_AUTH_DRAFT("MANAGE_AUTH_DRAFT","管理员审批申请","GL","管理员"),
    YOUYI_HANDLER("YOUYI_HANDLER","优易分配处理","UY","国信优易"),
    ROBACK("ROBACK","重新申请","SQ","重申"),
    MANAGE_AUTH_EXT("MANAGE_AUTH_EXT","管理员扩展审批","GL","管理员"),
    YIYUN_HANDLER("YIYUN_HANDLER","高新翼云采购","YY","高新翼云"),
    YIYUN_ADD_HOST("YIYUN_ADD_HOST","新增硬件","YY","高新翼云"),
    YOUYI_FINAL("YOUYI_FINAL","高新翼云采购完结，优易分配","UY","国信优易"),
    END("END","流程结束","END","流程结束");*/

    //按需求原型进行修改-2019-05-07根据测试黎圆y、需求王诗l商量更改为通用名词避免硬编码问题
    /*管理员 改成 大数据办
    国信优易 改成 虚拟化服务商
    高新翼云 改成  硬件供应商*/
    DRAFT("DRAFT","","SQ","待提交"),
    MANAGE_AUTH_DRAFT("MANAGE_AUTH_DRAFT","大数据办","GL","流程中"),
    YOUYI_HANDLER("YOUYI_HANDLER","虚拟化服务商","UY","流程中"),
    ROBACK("ROBACK","","SQ","已驳回"),
    MANAGE_AUTH_EXT("MANAGE_AUTH_EXT","大数据办","GL","流程中"),
    YIYUN_HANDLER("YIYUN_HANDLER","硬件供应商","YY","流程中"),
    YIYUN_ADD_HOST("YIYUN_ADD_HOST","硬件供应商","YY","流程中"),
    YOUYI_FINAL("YOUYI_FINAL","虚拟化服务商","UY","流程中"),
    END("END","","END","已完成");

    private String stepCode;
    private String stepName;
    private String sCode;
    private String sName;

    StepConstant(String stepCode, String stepName,String sCode,String sName) {
        this.stepCode = stepCode;
        this.stepName = stepName;
        this.sCode = sCode;
        this.sName = sName;
    }


    public String getStepCode() {
        return stepCode;
    }

    public String getStepName() {
        return stepName;
    }

    public String getsCode() {
        return sCode;
    }

    public String getsName() {
        return sName;
    }

    public static String getprocessName(String stepCode) {
        if(stepCode==null){
            return null;
        }
        for (StepConstant c : StepConstant.values()) {
            if (stepCode.equals(c.getStepCode())) {
                return c.getStepName();
            }
        }
        return null;
    }

    public static String getName(String stepCode) {
        if(stepCode==null){
            return null;
        }
        for (StepConstant c : StepConstant.values()) {
            if (stepCode.equals(c.getStepCode())) {
                return c.getsName();
            }
        }
        return null;
    }

    public static String getCode(String stepCode) {
        if(stepCode==null){
            return null;
        }
        for (StepConstant c : StepConstant.values()) {
            if (stepCode.equals(c.getStepCode())) {
                return c.getsCode();
            }
        }
        return null;
    }
}
