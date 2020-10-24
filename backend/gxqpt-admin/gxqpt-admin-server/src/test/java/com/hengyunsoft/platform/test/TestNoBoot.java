package com.hengyunsoft.platform.test;

import com.alibaba.druid.filter.config.ConfigTools;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author tyh
 * @createTime 2017-12-09 17:54
 */
@Slf4j
public class TestNoBoot {
    /**
     WARN level表明会出现潜在错误的情形。
     ERROR level指出虽然发生错误事件，但仍然不影响系统的继续运行。
     FATAL level指出每个严重的错误事件将会导致应用程序的退出。

     日志信息的优先级从高到低有ERROR、WARN、INFO、DEBUG, TRACE，分别用来指定这条日志信息的重要程度；
     */
    @Test
    public void testLog() throws Exception {
        System.out.println("name=" + log.getName());

        log.error("-------------------------error");
        log.warn("-------------------------warn");
        log.info("-------------------------info");
        log.debug("-------------------------debug");
        log.trace("-------------------------trace");


        String encrypt = ConfigTools.encrypt("Zkhy@8888gxqpt");
        System.out.println(encrypt);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(ConfigTools.encrypt("r!o@o#t$>?.123"));
    }
}
