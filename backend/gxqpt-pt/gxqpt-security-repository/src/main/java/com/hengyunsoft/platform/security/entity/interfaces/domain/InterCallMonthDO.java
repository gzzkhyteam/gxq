package com.hengyunsoft.platform.security.entity.interfaces.domain;

import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-09-04 14:47
 * @desc 前十二月接口调用数
 **/
@Data
public class InterCallMonthDO {
    private Integer year;
    private  Integer month;
    private Integer count;
    private String logType;
}