package com.hengyunsoft.platform.exchange.entity.api.po;

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
@ApiModel(value = "ShareDataApi", description = "")
public class ShareDataApi extends BaseEntity<Long> implements Serializable {
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
     * 单位id（申请人单位）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id（申请人单位）")
    @FieldDesc("单位id（申请人单位）")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String unitId;

    /**
     * 目录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录id")
    @FieldDesc("目录id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long dirId;

    /**
     * API类型（1：全量API-目录创建自动新增，2：新建API）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API类型（1：全量API-目录创建自动新增，2：新建API）")
    @FieldDesc("API类型（1：全量API-目录创建自动新增，2：新建API）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer apiType;

    /**
     * API名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API名称")
    @FieldDesc("API名称")
    @Length(max=500)
    private String apiName;

    /**
     * API编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API编号")
    @FieldDesc("API编号")
    @Length(max=300)
    private String apiCode;

    /**
     * API访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API访问地址")
    @FieldDesc("API访问地址")
    @Length(max=1000)
    private String apiUrl;

    /**
     * 支持格式:1,json;2,xml
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "支持格式:1,json;2,xml")
    @FieldDesc("支持格式:1,json;2,xml")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataFmat;

    /**
     * API描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API描述")
    @FieldDesc("API描述")
    @Length(max=10000)
    private String apiDesc;

    /**
     * API状态:1,启用；2，禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "API状态:1,启用；2，禁用")
    @FieldDesc("API状态:1,启用；2，禁用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer apiStatus;

    /**
     * 被调用次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "被调用次数")
    @FieldDesc("被调用次数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer callCount;

    /**
     * 状态:1,待审批；2，已驳回；3，审批通过；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态:1,待审批；2，已驳回；3，审批通过；")
    @FieldDesc("状态:1,待审批；2，已驳回；3，审批通过；")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer authStatus;

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