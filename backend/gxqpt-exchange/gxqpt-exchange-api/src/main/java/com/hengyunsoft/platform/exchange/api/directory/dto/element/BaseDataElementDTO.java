package com.hengyunsoft.platform.exchange.api.directory.dto.element;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
public abstract class BaseDataElementDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作类型")
    private Integer optType;

}
