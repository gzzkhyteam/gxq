package com.hengyunsoft.platform.supervise.dto.center.storage;

import com.hengyunsoft.platform.supervise.constant.ApplicationNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DataStorageSupervisePageDetail", description = "数据存储配置详情实体")
public class DataStorageSupervisePageDetailDTO extends ApplicationNode{
    /**
     * 数据库空间阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库空间阀值")
    private Double dbSpaceLimit;

    /**
     * 日志空间阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志空间阀值")
    private Double logSpaceLimit;

    /**
     * 文件空间阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件空间阀值")
    private Double fileSpaceLimit;

    /**
     * 监管类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "监管类型")
    private Short superviseType;

    /**
     * 提醒方式 消息:1,短信:2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提醒方式 消息:1,短信:2")
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String desc;

    @ApiModelProperty(value = "级别")
    private Integer level;
}
