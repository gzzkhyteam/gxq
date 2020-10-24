package com.hengyunsoft.platform.mt.entity.work.po.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WorkLogLookDO implements Serializable{

    @ApiModelProperty(value = "  主键")
    private Long id;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "userId")
    private Long userId;

    /**
     * 照片/头像
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片/头像")
    private String photo;

    @ApiModelProperty(value = "用户姓名")
    private String userName;


}
