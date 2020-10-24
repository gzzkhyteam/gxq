package com.hengyunsoft.platform.test2;

import com.alibaba.druid.filter.config.ConfigTools;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tyh
 * @createTime 2017-12-09 17:54
 */
@Slf4j
public class TestNoBoot2 {

    public static void main(String[] args) throws Exception{
        System.out.println(ConfigTools.encrypt("oracle"));
    }
}
