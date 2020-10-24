package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tianai
 * @createTime 2018-07-10
 */
@Data
public class ShareUnitDTO  implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 目录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录id")
    private Long dirId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String unitId;




}