package com.hengyunsoft.platform.hardware.constant;

public enum StatisticsEnum {
    CPU("1"),
    MEM("2"),
    DIST("3"),
    WIDEUP("4"),
    WIDEDOWN("5"),
    TIME("time"),
    VAL("val");

    private String msg;

    StatisticsEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static StatisticsEnum getEnum(String msg) {
        for (StatisticsEnum menum : StatisticsEnum.values()) {
//            map.put(legEnum.legNo, legEnum);
            if (msg.equals(menum.getMsg())){
                return menum;
            }
        }
        return null;
    }
}
