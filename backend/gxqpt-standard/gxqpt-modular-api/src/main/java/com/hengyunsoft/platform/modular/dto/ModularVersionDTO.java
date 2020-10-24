package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ModularVersion", description = "模块版本展示对象")
public class ModularVersionDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String repName;

    /**
     * groupId
     */
    @ApiModelProperty(value = "groupId")
    private String groupId;

    /**
     * artifactId
     */
    @ApiModelProperty(value = "artifactId")
    private String artifactId;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String version;

    /**
     * jar包类型
     */
    @ApiModelProperty(value = "jar包类型")
    private String classifier;

    /**
     *上传时间
     */
    @ApiModelProperty(value = "上传时间")
    private Date createTime;

    /**
     *下载次数
     */
    @ApiModelProperty(value = "下载次数")
    private Integer downloadCount;

    /**
     *下载地址
     */
    @ApiModelProperty(value = "下载地址")
    private String downloadUrl;

    /**
     *发布人
     */
    @ApiModelProperty(value = "发布人")
    private String createUserName;

    /**
     *公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String createCompanyName;

}
