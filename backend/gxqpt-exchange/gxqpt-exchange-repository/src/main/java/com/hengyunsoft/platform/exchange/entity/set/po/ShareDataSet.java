package com.hengyunsoft.platform.exchange.entity.set.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "ShareDataSet", description = "")
public class ShareDataSet extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    @FieldDesc("申请编号")
    @Length(max=100)
    private String applyCode;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    @FieldDesc("单位id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String unitId;

    /**
     * 数据集名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集名称")
    @FieldDesc("数据集名称")
    @Length(max=500)
    private String setName;

    /**
     * 数据集标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集标识")
    @FieldDesc("数据集标识")
    @Length(max=200)
    private String setCode;

    /**
     * 数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取")
    @FieldDesc("数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer setType;

    /**
     * 数据集大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集大小")
    @FieldDesc("数据集大小")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Float dataCount;

    /**
     * 更新频率:1,一次性；2，实时；3，天；4，周；5，月；6，年
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新频率:1,一次性；2，实时；3，天；4，周；5，月；6，年")
    @FieldDesc("更新频率:1,一次性；2，实时；3，天；4，周；5，月；6，年")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer updateRate;

    /**
     * API名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API名称")
    @FieldDesc("API名称")
    @Length(max=200)
    private String apiName;

    /**
     * API地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API地址")
    @FieldDesc("API地址")
    @Length(max=2147483647)
    private String apiUrl;

    /**
     * API数据类型:1,jason;2,xml
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API数据类型:1,jason;2,xml")
    @FieldDesc("API数据类型:1,jason;2,xml")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer apiDataType;

    /**
     * 采集时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "采集时间")
    @FieldDesc("采集时间")
    private Date acqTime;

    /**
     * 更新方式:1,全量；2，增量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新方式:1,全量；2，增量")
    @FieldDesc("更新方式:1,全量；2，增量")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer updateType;

    /**
     * 创建数据集方式:1,选择字段;2,sql查询
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建数据集方式:1,选择字段;2,sql查询")
    @FieldDesc("创建数据集方式:1,选择字段;2,sql查询")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer setMode;

    /**
     * 在的本地仓库过度表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "在的本地仓库过度表")
    @FieldDesc("在的本地仓库过度表")
    @Length(max=200)
    private String tableCode;

    /**
     * 在数据源的数据库的表名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "在数据源的数据库的表名")
    @FieldDesc("在数据源的数据库的表名")
    @Length(max=200)
    private String sourceDbCode;

    /**
     * 在本地仓库的正式表名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "在本地仓库的正式表名")
    @FieldDesc("在本地仓库的正式表名")
    @Length(max=200)
    private String formalTableCode;

    /**
     * SQL语句
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "SQL语句")
    @FieldDesc("SQL语句")
    @Length(max=2147483647)
    private String sqlCode;

    /**
     * 数据类型:1,字段选择；2，SQL语句
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据类型:1,字段选择；2，SQL语句")
    @FieldDesc("数据类型:1,字段选择；2，SQL语句")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataType;

    /**
     * 创建理由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建理由")
    @FieldDesc("创建理由")
    @Length(max=2147483647)
    private String reason;

    /**
     * 数据源id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据源id")
    @FieldDesc("数据源id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long dbId;

    /**
     * 状态:1，审批中；2，驳回；3，已上架；4，已下架
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1，审批中；2，驳回；3，已上架；4，已下架")
    @FieldDesc("状态:1，审批中；2，驳回；3，已上架；4，已下架")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer status;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    @FieldDesc("创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}