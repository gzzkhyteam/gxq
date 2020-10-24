package com.hengyunsoft.platform.exchange.entity.system.po;

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
@ApiModel(value = "ShareSystem", description = "")
public class ShareSystem extends BaseEntity<Long> implements Serializable {
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
     * 机构ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "机构ID")
    @FieldDesc("机构ID")
    @Length(max=64)
    private String orgId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    @FieldDesc("系统名称")
    @Length(max=200)
    private String sysName;

    /**
     * 系统承建商
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统承建商")
    @FieldDesc("系统承建商")
    @Length(max=200)
    private String contractor;

    /**
     * 承建商联系人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "承建商联系人")
    @FieldDesc("承建商联系人")
    @Length(max=32)
    private String contName;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "联系电话")
    @FieldDesc("联系电话")
    @Length(max=32)
    private String contTel;

    /**
     * 系统使用状态:1,在用；2，停用；3，整改中；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统使用状态:1,在用；2，停用；3，整改中；")
    @FieldDesc("系统使用状态:1,在用；2，停用；3，整改中；")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer status;

    /**
     * 访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "访问地址")
    @FieldDesc("访问地址")
    @Length(max=200)
    private String url;

    /**
     * 用户体系:1,电子政务网；2，自建
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户体系:1,电子政务网；2，自建")
    @FieldDesc("用户体系:1,电子政务网；2，自建")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer userReft;

    /**
     * 网络环境:1,互联网；2，电子政务外网；3，电子政务内网；4，电子政务专网
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "网络环境:1,互联网；2，电子政务外网；3，电子政务内网；4，电子政务专网")
    @FieldDesc("网络环境:1,互联网；2，电子政务外网；3，电子政务内网；4，电子政务专网")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer network;

    /**
     * 是否需要key:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要key:1,是；2，否")
    @FieldDesc("是否需要key:1,是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer hasKey;

    /**
     * 是否需要VPN:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要VPN:1,是；2，否")
    @FieldDesc("是否需要VPN:1,是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer hasVpn;

    /**
     * 系统架构:1，BS; 2,CS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统架构:1，BS; 2,CS")
    @FieldDesc("系统架构:1，BS; 2,CS")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer sysArch;

    /**
     * 账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "账号")
    @FieldDesc("账号")
    @Length(max=50)
    private String account;

    /**
     * 密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "密码")
    @FieldDesc("密码")
    @Length(max=50)
    private String password;

    /**
     * 开发语言及框架
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开发语言及框架")
    @FieldDesc("开发语言及框架")
    @Length(max=200)
    private String langeFrwork;

    /**
     * 是否有系统说明书:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否有系统说明书:1,是；2，否")
    @FieldDesc("是否有系统说明书:1,是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer hasInstruction;

    /**
     * 系统运行环境
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统运行环境")
    @FieldDesc("系统运行环境")
    @Length(max=200)
    private String sysRunEnvent;

    /**
     * 数据存储地
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据存储地")
    @FieldDesc("数据存储地")
    @Length(max=200)
    private String dataAddress;

    /**
     * 数据库类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型")
    @FieldDesc("数据库类型")
    @Length(max=100)
    private String dbType;

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
     * 是否有数据字典:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否有数据字典:1,是；2，否")
    @FieldDesc("是否有数据字典:1,是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer hasDict;

    /**
     * 是否对外提供数据共享接:1,是；2，否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否对外提供数据共享接:1,是；2，否")
    @FieldDesc("是否对外提供数据共享接:1,是；2，否")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer shareChain;

    /**
     * 对其他单位的数据需求
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "对其他单位的数据需求")
    @FieldDesc("对其他单位的数据需求")
    @Length(max=2000)
    private String dataDemand;

    /**
     * 系统包含主要数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统包含主要数据")
    @FieldDesc("系统包含主要数据")
    @Length(max=2000)
    private String majorData;

    /**
     * 系统主要用途
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统主要用途")
    @FieldDesc("系统主要用途")
    @Length(max=2000)
    private String sysPurpose;

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