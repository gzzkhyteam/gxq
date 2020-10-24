package com.hengyunsoft.platform.file.entity.file.domain;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 10:10
 * @desc 文件类型数量、
 * @Version 1.0
 **/
@Data
public class DateTypeNumDO {
    /**
     * 文件类型
     * */
    private String dataType;
   /**
    * 文件数量
    * */
    private String num;
    /**
     * 文件大小
     * */
    private long size;
}
