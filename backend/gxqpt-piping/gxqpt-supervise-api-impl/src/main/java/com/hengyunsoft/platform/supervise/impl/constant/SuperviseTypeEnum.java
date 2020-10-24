package com.hengyunsoft.platform.supervise.impl.constant;

/**
 * 监控方式枚举
 */
public enum SuperviseTypeEnum {
    HOUR((short)1),
    DAY((short)2),
    WEEK((short)3),
    MONTH((short)4);

    private Short value;

    public Short getValue() {
        return value;
    }

    SuperviseTypeEnum(Short value) {
        this.value = value;
    }
    public static SuperviseTypeEnum getEnum(Short value){
        for (SuperviseTypeEnum menum : SuperviseTypeEnum.values()){
            if (value.equals(menum.getValue())){
                return menum;
            }
        }
        return null;
    }

}
