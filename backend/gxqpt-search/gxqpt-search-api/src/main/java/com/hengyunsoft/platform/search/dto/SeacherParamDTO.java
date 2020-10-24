package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：新增
 */
@Data
@ApiModel(value = "SeacherParam", description = "搜索参数")
public class SeacherParamDTO {
    @ApiModelProperty(value = "搜索内容")
    private String keyWords;
    @ApiModelProperty(value = "追加的动态条件")
    private String appendCondition;
    @ApiModelProperty(value = "替换动态条件")
    private String replaceCondition;

    @ApiModelProperty(value = "指定搜索的集合,逗号分割(如:coll1,coll2,coll3)")
    private String collections;
    //分页参数
    @ApiModelProperty(value = "当前查询第几页")
    private int pageNo;

    @ApiModelProperty(value = "每页大小")
    private int pageSize;

    @ApiModelProperty(value = "是否要求结果高亮显示")
    private boolean isHighlighter;

}
