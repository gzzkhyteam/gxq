package com.hengyunsoft.platform.developer.entity.service.po.domain;

import com.hengyunsoft.platform.developer.entity.service.po.ServiceModule;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceModuleDo extends ServiceModule implements Serializable {
    /**
     * 模块类型名称
     * @mbggenerated
     */
    private String moduleTypeName;
}