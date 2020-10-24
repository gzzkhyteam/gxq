package com.hengyunsoft.platform.supervise.dto.center.apprunning;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "BizAppSupervisePageLike", description = "应用运行监管分页模糊查询入参实体")
public class BizAppSupervisePageLikeDTO {

    /**
     * 管理应用集合
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "管理应用集合")
    private List<String> appIds;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;


    /**
     * 监管类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "监管类型")
    private Short superviseType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;
}
