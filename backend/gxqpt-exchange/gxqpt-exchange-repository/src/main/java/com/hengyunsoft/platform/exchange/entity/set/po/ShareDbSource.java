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
@ApiModel(value = "ShareDbSource", description = "")
public class ShareDbSource extends BaseEntity<Long> implements Serializable {
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
     * 关联系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "关联系统id")
    @FieldDesc("关联系统id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String unitId;

    /**
     * 机构ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构ID")
    @FieldDesc("机构ID")
    @Length(max=64)
    private String orgId;

    /**
     * 数据源名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据源名称")
    @FieldDesc("数据源名称")
    @Length(max=100)
    private String sourceName;

    /**
     * 数据库名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库名")
    @FieldDesc("数据库名")
    @Length(max=100)
    private String dbName;

    /**
     * 数据库端口
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库端口")
    @FieldDesc("数据库端口")
    @Length(max=32)
    private String dbPort;

    /**
     * 数据库地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库地址")
    @FieldDesc("数据库地址")
    @Length(max=300)
    private String dbAddress;

    /**
     * 连接类型：1，Basic;2,TNS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "连接类型：1，Basic;2,TNS")
    @FieldDesc("连接类型：1，Basic;2,TNS")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer contType;

    /**
     * 数据库类型:1,orcale;2,mysql;3,sqlserver;
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型:1,orcale;2,mysql;3,sqlserver;")
    @FieldDesc("数据库类型:1,orcale;2,mysql;3,sqlserver;")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dbType;

    /**
     * 服务类型：1，服务名；2，SID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务类型：1，服务名；2，SID")
    @FieldDesc("服务类型：1，服务名；2，SID")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer serverType;

    /**
     * 数据库账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库账号")
    @FieldDesc("数据库账号")
    @Length(max=100)
    private String dbAccount;

    /**
     * 数据库密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库密码")
    @FieldDesc("数据库密码")
    @Length(max=200)
    private String dbPassword;

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