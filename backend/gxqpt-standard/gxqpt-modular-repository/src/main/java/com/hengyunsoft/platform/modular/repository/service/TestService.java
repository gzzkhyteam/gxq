package com.hengyunsoft.platform.modular.repository.service;

import com.hengyunsoft.platform.modular.repository.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;


    public void test() {
        testMapper.get();
        System.out.println("---");
    }
    public void insert() {
        testMapper.insert();
        System.out.println("11111");
    }
    public void insert2() {
        testMapper.insert2();
        System.out.println("222222");
    }
}
