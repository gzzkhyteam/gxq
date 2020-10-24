package com.hengyunsoft.platform.exchange.entity.directory.po;

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
@ApiModel(value = "ShareDataDirectory", description = "")
public class ShareDataDirectory extends BaseEntity<Long> implements Serializable {
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
     * 目录名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录名称")
    @FieldDesc("目录名称")
    @Length(max=200)
    @NotNull(groups=MustNoneNull.class)
    private String dirName;

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录编码")
    @FieldDesc("目录编码")
    @Length(max=200)
    private String dirCode;

    /**
     * 单位简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位简称")
    @FieldDesc("单位简称")
    @Length(max=200)
    private String unitAbbr;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    @FieldDesc("父id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String parentId;

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
     * 目录描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录描述")
    @FieldDesc("目录描述")
    @Length(max=1000)
    private String desc;

    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录标识:1,单位；2，数据目录")
    @FieldDesc("目录标识:1,单位；2，数据目录")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer dirType;

    /**
     * 数据量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据量")
    @FieldDesc("数据量")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataCount;

    /**
     * 查看次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查看次数")
    @FieldDesc("查看次数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer seeCount;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下载次数")
    @FieldDesc("下载次数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer downCount;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用")
    @FieldDesc("操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer optType;

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态:1,未发布；2，审批中；3，驳回；4，已发布；")
    @FieldDesc("审批状态:1,未发布；2，审批中；3，驳回；4，已发布；")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer status;

    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否元目录:1,否；2，是")
    @FieldDesc("是否元目录:1,否；2，是")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer isBottom;

    /**
     * 专题分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "专题分类")
    @FieldDesc("专题分类")
    @Length(max=128)
    private String specialType;

    /**
     * 领域分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "领域分类")
    @FieldDesc("领域分类")
    @Length(max=128)
    private String domain;

    /**
     * 主题大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题大类")
    @FieldDesc("主题大类")
    @Length(max=128)
    private String themeOne;

    /**
     * 主题中类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题中类")
    @FieldDesc("主题中类")
    @Length(max=128)
    private String themeTwo;

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题小类")
    @FieldDesc("主题小类")
    @Length(max=128)
    private String themeThree;

    /**
     * 行业大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "行业大类")
    @FieldDesc("行业大类")
    @Length(max=128)
    private String industryOne;

    /**
     * 行业中类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "行业中类")
    @FieldDesc("行业中类")
    @Length(max=128)
    private String industryTwo;

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "行业小类")
    @FieldDesc("行业小类")
    @Length(max=128)
    private String industryThree;

    /**
     * 服务大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务大类")
    @FieldDesc("服务大类")
    @Length(max=128)
    private String serviceOne;

    /**
     * 服务中类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务中类")
    @FieldDesc("服务中类")
    @Length(max=128)
    private String serviceTwo;

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务小类")
    @FieldDesc("服务小类")
    @Length(max=128)
    private String serviceThree;

    /**
     * 开放方式:1,开放；2，不开放
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开放方式:1,开放；2，不开放")
    @FieldDesc("开放方式:1,开放；2，不开放")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer openWay;

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "共享方式:1,共享；2，有条件共享；3，不共享")
    @FieldDesc("共享方式:1,共享；2，有条件共享；3，不共享")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer shareWay;

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据类型:1,结构化数据；2，非结构化数据")
    @FieldDesc("数据类型:1,结构化数据；2，非结构化数据")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataType;

    /**
     * 不同享、不开放、有条件共享原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "不同享、不开放、有条件共享原因")
    @FieldDesc("不同享、不开放、有条件共享原因")
    @Length(max=2147483647)
    private String reason;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集id")
    @FieldDesc("数据集id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long setId;

    /**
     * 是否生成数据库表：1已生成
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否生成数据库表：1已生成")
    @FieldDesc("是否生成数据库表：1已生成")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataSheet;

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据状态；1，正常；2，已删除；3，已禁用")
    @FieldDesc("数据状态；1，正常；2，已删除；3，已禁用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataStatus;

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