package com.hengyunsoft.platform.modular.open;

import com.hengyunsoft.platform.modular.repository.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

/**
 * * 成功测试事务，  开发时可以删掉
 */
@RestController
public class TestController2 {
    @Autowired
    private TestService testService;
    @RequestMapping("/t1")
    public String save3(){
        testService.insert();

        testService.insert2();

        return "测试初始化项目";
    }
    @RequestMapping("/t2")
    public String save1(){
        testService.insert();

        int a = 1/0;

        testService.insert2();

        return "RuntimeException";
    }
    @RequestMapping("/t3")
    public String save2() throws Exception{
        testService.insert();

        new FileInputStream(new File(""));

        testService.insert2();

        return "Exception";
    }

}
