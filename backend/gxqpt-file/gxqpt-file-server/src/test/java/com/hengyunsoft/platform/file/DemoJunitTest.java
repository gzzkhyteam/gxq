package com.hengyunsoft.platform.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @BeforeClass 全局只会执行一次，而且是第一个运行
 * @Before 在测试方法运行之前运行
 * @Test 测试方法
 * @After 在测试方法运行之后允许
 * @AfterClass 全局只会执行一次，而且是最后一个运行
 * @Ignore 忽略此方法
 */
@RunWith(Parameterized.class)
public class DemoJunitTest {
    private String name;
    private int age;

    //构造函数，对变量进行初始化
    public DemoJunitTest(String name) {
        this.name = name;
    }
    //public DemoJunitTest(int age, String name) {
    //    this.age = age;
    //    this.name = name;
    //}

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"2"},
                {"lizi"},
                {"wf"},
        });
    }

    @Test
    public void test() {
        System.out.println(name);
    }
    @Test
    public void test2() {
        System.out.println(name);
    }
}
