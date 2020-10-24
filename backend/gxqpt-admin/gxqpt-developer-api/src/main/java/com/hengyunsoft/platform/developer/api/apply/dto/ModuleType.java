package com.hengyunsoft.platform.developer.api.apply.dto;
import lombok.Data;

/**
 * @author madb
 * @create 2018/04/18
 * @desc moduleType:id   name
 **/
@Data
public class ModuleType {

    private String moduleId;

    private String moduleTypeName;
    /**
     * 字典功能了类型编码code
     * */
    private String moduleType;
}
