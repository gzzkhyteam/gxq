package com.hengyunsoft.platform.search.queue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建索引参数
 * 修改人：sxy
 * 修改时间：2018/8/9
 * 修改内容：新建
 */
@Data
@ApiModel(value = "IndexItem", description = "创建索引参数")
public class IndexItemDTO {

    @ApiModelProperty(value = "索引主键id")
    private String id;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "业务id")
    private String bizId;

    @ApiModelProperty(value = "自定义数据类型")
    private String type;

    @ApiModelProperty(value = "打开地址")
    private String url;

    @ApiModelProperty(value = "自定义扩展数据")
    private String ext;

    @ApiModelProperty(value = "操作的集合")
    private String collection;

}

