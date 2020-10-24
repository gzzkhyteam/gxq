package com.hengyunsoft.platform.exchange.constant;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 共享交换常量
 * @author zhaopengfei
 * @createTime 2018-04-25
 */

public class ExchangeConstants {
    /**
     * 流程相关
     */
    /*目录发布*/
    public static final String FLOW_DIR_CODE = "DIR_RELEASE";
    /*数据集上架*/
    public static final String FLOW_SET_CODE = "SET_PUT";
    /*发布需求*/
    public static final String FLOW_DEMAND_CODE = "REQT_RELEASE";
    /*API申请*/
    public static final String FLOW_API_CODE = "API_APPLY";
    /*API续期申请*/
    public static final String FLOW_API_RENEWAL_CODE = "API_RENEWAL";

    public static final String DIR_PARENT_ID = "-1";

    /*不是元目录*/
    public static final Integer IS_BOTTOM_NO = 1;
    /*是元目录*/
    public static final Integer IS_BOTTOM_YES = 2;

    /*数据集状态 已上架*/
    public static final Integer DATA_SET_ON_SHELF = 3;


    /*数据目录数据状态 正常*/
    public static final Integer DATA_STATUS_YES = 1;



    /*数API审批状态 审批通过*/
    public static final Integer API_AUTH_STATUS_PASS = 3;
    /*API状态 启用*/
    public static final Integer API_STATUS_YES = 1;

    public static Map<String,String> monthmap = new LinkedHashMap<String,String>();
    static{
        monthmap.put("01", "一月");
        monthmap.put("02", "二月");
        monthmap.put("03", "三月");
        monthmap.put("04", "四月");
        monthmap.put("05", "五月");
        monthmap.put("06", "六月");
        monthmap.put("07", "七月");
        monthmap.put("08", "八月");
        monthmap.put("09", "九月");
        monthmap.put("10", "十月");
        monthmap.put("11", "十一月");
        monthmap.put("12", "十二月");
    }

    public static final  String SELECT_UNIT_TYPE_CODE = "unit_type";


}
