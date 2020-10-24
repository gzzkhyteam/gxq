package com.hengyunsoft.platform.admin.repository.org.gxqpt.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;

import java.util.List;

/**
 * @author zjr
 * @createTime 2018-03-08
 */
public interface GxqptSystemService extends BaseService<String, GxqptSystem, GxqptSystemExample> {



    /**
     * 根据ID删除体系信息
     * @param id
     * @return
     */
    int deleteSystem(String id);

    /**
     * 判断体系是否存在，防止注入
     * @param system
     * @return
     */
    boolean isExistSystem(String system);

    /**
     * 获得体系编码list
     * @return
     */
    List<String> getSystemCode();
}
