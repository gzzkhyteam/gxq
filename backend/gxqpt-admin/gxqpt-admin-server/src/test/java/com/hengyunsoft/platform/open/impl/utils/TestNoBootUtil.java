package com.hengyunsoft.platform.open.impl.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author tyh
 * @createTime 2017-12-09 17:54
 */
@Slf4j
public class TestNoBootUtil {
    @Test
    public void testLog(){
        log.error("-------------------------error");
        log.warn("-------------------------warn");
        log.info("-------------------------info");
        log.debug("-------------------------debug");
        log.trace("-------------------------trace");

        System.out.println("----------end---------");
    }
}
