package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建索引参数
 * 修改人：gbl
 * 修改时间：2018/4/8
 * 修改内容：新建
 */
@Data
@ApiModel(value = "IndexItem", description = "创建索引参数")
public class IndexItemDTO {
    @Field
    @ApiModelProperty(value = "索引主键id")
    private String id;

    @Field
    @ApiModelProperty(value = "应用id")
    private String appId;

    @Field
    @ApiModelProperty(value = "标题")
    private String title;

    @Field
    @ApiModelProperty(value = "内容")
    private String content;

    @Field
    @ApiModelProperty(value = "业务id")
    private String bizId;

    @Field
    @ApiModelProperty(value = "自定义数据类型")
    private String type;
    @Field
    @ApiModelProperty(value = "打开地址")
    private String url;
    @Field
    @ApiModelProperty(value = "自定义扩展数据")
    private String ext;

    @Field
    @ApiModelProperty(value = "保留字段1")
    private String retainField1;
    @Field
    @ApiModelProperty(value = "保留字段2")
    private String retainField2;

    @Field
    @ApiModelProperty(value = "保留中文分词字段3")
    private String retainIkField3;

    @Field
    @ApiModelProperty(value = "保留中文分词字段4")
    private String retainIkField4;

    @ApiModelProperty(value = "操作的集合")
    private String collection;

}

