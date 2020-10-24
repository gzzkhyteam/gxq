package com.hengyunsoft.platform.file.entity.file.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SynFileDataDO {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    private String dataType;

    /**
     * 大小
     *
     * @mbggenerated
     */
    private String size;

    private String num;
    private String yMonth;


    private Date createTime;

    private Long createUser;
}
