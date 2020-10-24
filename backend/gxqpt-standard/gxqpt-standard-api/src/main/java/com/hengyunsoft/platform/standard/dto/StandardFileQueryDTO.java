package com.hengyunsoft.platform.standard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "StandardFileQuery", description = "标准文档查询参数对象")
public class StandardFileQueryDTO {

    /**
     * 文档名称
     */
    @ApiModelProperty(value = "文档名称")
    private String name;

    /**
     *文档编码
     */
    @ApiModelProperty(value = "文档编码")
    private String code;

    /**
     *文档分类
     */
    @ApiModelProperty(value = "文档分类")
    private String classifyId;

    /**
     *上传开始时间
     */
    @ApiModelProperty(value = "上传开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;

    /**
     *上传截止时间
     */
    @ApiModelProperty(value = "上传截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;

    /**
     *上传人
     */
    @ApiModelProperty(value = "上传人")
    private String createUserName;

    /**
     *是否有效，1：有效；0：无效
     */
    @ApiModelProperty(value = "是否有效，1：有效；0：无效")
    private Boolean isEnable;

    /**
     *排序字段
     */
    @ApiModelProperty(value = "排序字段")
    private String sidx;

    /**
     *排序方式，可选值：asc、desc
     */
    @ApiModelProperty(value = "排序方式，可选值：asc、desc")
    private String sord;
    /**
     * 来自哪个页面
     */
    @ApiModelProperty(value = "来自哪个页面 1:安全保障体系 2移动应用接口规范体系 3:数据统一标准规范体系")
    private Integer fromPage;
}
