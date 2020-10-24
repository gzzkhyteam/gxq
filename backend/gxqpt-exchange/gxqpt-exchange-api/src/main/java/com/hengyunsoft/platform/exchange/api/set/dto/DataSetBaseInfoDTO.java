package com.hengyunsoft.platform.exchange.api.set.dto;


import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集一般信息
 * 修改人：gbl
 * 修改时间：2018/4/26
 * 修改内容：
 */
@Data
@ApiModel(value = "DataSetBaseInfo", description = "数据集一般信息")
public class DataSetBaseInfoDTO {
    @ApiModelProperty(value = "数据id")
    private Long id;
    @ApiModelProperty(value = "数据集名称")
    protected String setName;

    @ApiModelProperty(value = "数据集标识")
    private String setCode;

    @ApiModelProperty(value = "数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取")
    private Integer setType;

    @ApiModelProperty(value = "更新频率:1,一次性；2，实时；3，天；4，周；5，月；6，年")
    private Integer updateRate;

    @ApiModelProperty(value = "创建理由")
    private String reason;

    @ApiModelProperty(value = "数据集大小(数据量)")
    private Float dataCount;

    @ApiModelProperty(value = "API地址")
    private String apiUrl;

    @ApiModelProperty(value = " API数据类型:1,jason;2,xml")
    private Integer apiDataType;

    @ApiModelProperty(value = " 数据源id")
    private Long dbId;
    @ApiModelProperty(value = "数据源名称")
    private String dbName;

    @ApiModelProperty(value = "更新方式:1,全量；2，增量")
    private Integer updateType;

    @ApiModelProperty(value = "当前关联目录")
    protected List<DataDirectoryDTO> directorys;
    //文件类数据集相关
    @ApiModelProperty(value = "附件信息")
    private List<DataSetFileDTO> files;


    //数据库数据集相关
    @ApiModelProperty(value = "所有的表信息")
    private List<DatabaseTableDTO> allTable = new ArrayList<>();

    @ApiModelProperty(value = "创建数据集方式:1,选择字段;2,sql查询")
    private Integer setMode;

    @ApiModelProperty(value = "表名标识")
    private String tableCode;

    @ApiModelProperty(value = "数据类型:1,字段选择；2，SQL语句")
    private Integer dataType;

    @ApiModelProperty(value = "SQL语句")
    private String sqlCode;
    //API相关
    @ApiModelProperty(value = "所有字段列表")
    private List<DataSetElementDTO> fieldList;
    //API和数据集都有
    @ApiModelProperty(value = "已经选择字段列表")
    private List<DataSetElementDTO> alFieldList;
    @ApiModelProperty(value = "选择的过滤字段列表")
    private List<FieldParamDTO> paramFileds;
    @ApiModelProperty(value = "关联的目录信息")
    private List<RelatedDirectoryDTO> relatedDirectory;

    /**
     * 状态:1，审批中；2，驳回；3，已上架；4，已下架
     *
     * @mbggenerated
     */
    private Integer status;

}
