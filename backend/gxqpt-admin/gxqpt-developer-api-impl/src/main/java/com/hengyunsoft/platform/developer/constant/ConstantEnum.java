package com.hengyunsoft.platform.developer.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum ConstantEnum {
    /*分别代表支撑应用,支撑平台，支撑服务，支撑模块，接入应用*/
    FIVE_APP_ZCYY ("zcyy"),
    FIVE_APP_ZCPT ("zcpt"),
    FIVE_APP_ZCFW ("zcfw"),
    FIVE_APP_ZCFWMK ("zcfwmk"),
    FIVE_APP_JRYY ("jryy"),
    /*应用查询app分类,1:查应用,2:查服务,3查所有启用*/
    APP_TYPE_1("1"),
    APP_TYPE_2("2"),
    APP_TYPE_3("3"),

    /*异常null*/
    NULL("null"),;
    private String value;

    public static List<String> findResourcesType() {
        return Arrays.asList(FIVE_APP_ZCYY.getValue(),FIVE_APP_ZCPT.getValue()
                        ,FIVE_APP_ZCFW.getValue(),FIVE_APP_ZCFWMK.getValue(),FIVE_APP_JRYY.getValue());
    }

    /*
     * 匹配操作码
     * */
    public static ConstantEnum matchConsCode(String ConsCodeStr) {
        for (ConstantEnum cCode : ConstantEnum.values()) {
            if (cCode.getValue().equalsIgnoreCase(ConsCodeStr)) {
                return cCode;
            }
        }
        return ConstantEnum.NULL;
    }
}
