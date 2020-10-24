package com.hengyunsoft.platform.modular.repository.dao;

import com.hengyunsoft.platform.modular.entity.test.po.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
    Test get();

    void insert();
    void insert2();
}
