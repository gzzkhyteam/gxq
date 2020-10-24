package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "StandardFile", description = "标准文档展示对象")
public class StandardFileDTO extends StandardFileBaseDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     *上传时间
     */
    @ApiModelProperty(value = "上传时间")
    private Date createTime;

    /**
     *上传人
     */
    @ApiModelProperty(value = "上传人")
    private String createUser;

    /**
     *下载次数
     */
    @ApiModelProperty(value = "下载次数")
    private Integer downloadCount;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String classifyName;

    /**
     *文档类型
     */
    @ApiModelProperty(value = "文档类型")
    private String fileType;

    /**
     *是否有效，1：有效；0：无效
     */
    @ApiModelProperty(value = "是否有效，1：有效；0：无效")
    private String isEnable;

    /**
     *上传人姓名
     */
    @ApiModelProperty(value = "上传人姓名")
    private String createUserName;

    /**
     * 上传单位ID
     *
     * @mbggenerated
     */
    private String companyId;

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    private String companyName;
}
