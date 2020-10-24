package com.hengyunsoft.platform.mt.entity.app.po;

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
@ApiModel(value = "ApplicationTemp", description = "应用程序临时表")
public class ApplicationTemp extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @ApiModelProperty(value = "主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @FieldDesc("应用名称")
    @ApiModelProperty(value = "应用名称")
    @Length(max=10)
    private String appName;

    /**
     * 应用类型(0:安卓,1:h5)
     *
     * @mbggenerated
     */
    @FieldDesc("应用类型(0:安卓,1:h5)")
    @ApiModelProperty(value = "应用类型(0:安卓,1:h5)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer appType;

    /**
     * 功能的话属于某一个应用，大于-1标识功能，-1表明该数据是应用
     *
     * @mbggenerated
     */
    @FieldDesc("功能的话属于某一个应用，大于-1标识功能，-1表明该数据是应用")
    @ApiModelProperty(value = "功能的话属于某一个应用，大于-1标识功能，-1表明该数据是应用")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long parentId;

    /**
     * 显示该功能的名称和提示的数量数据的接口
     *
     * @mbggenerated
     */
    @FieldDesc("显示该功能的名称和提示的数量数据的接口")
    @ApiModelProperty(value = "显示该功能的名称和提示的数量数据的接口")
    @Length(max=100)
    private String showUrl;

    /**
     * 应用图标
     *
     * @mbggenerated
     */
    @FieldDesc("应用图标")
    @ApiModelProperty(value = "应用图标")
    @Length(max=100)
    private String iconPath;

    /**
     * 审核状态(1暂存,2审核中,3通过,4驳回)
     *
     * @mbggenerated
     */
    @FieldDesc("审核状态(1暂存,2审核中,3通过,4驳回)")
    @ApiModelProperty(value = "审核状态(1暂存,2审核中,3通过,4驳回)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer state;

    /**
     * 应用路径
     *
     * @mbggenerated
     */
    @FieldDesc("应用路径")
    @ApiModelProperty(value = "应用路径")
    @Length(max=100)
    private String appPath;

    /**
     * 应用说明
     *
     * @mbggenerated
     */
    @FieldDesc("应用说明")
    @ApiModelProperty(value = "应用说明")
    @Length(max=65535)
    private String appDesc;

    /**
     * Android的包名
     *
     * @mbggenerated
     */
    @FieldDesc("Android的包名")
    @ApiModelProperty(value = "Android的包名")
    @Length(max=255)
    private String appPackageName;

    /**
     * Android的启动画面
     *
     * @mbggenerated
     */
    @FieldDesc("Android的启动画面")
    @ApiModelProperty(value = "Android的启动画面")
    @Length(max=255)
    private String appStartAct;

    /**
     * 是否显示(1:不显示 ,2:显示)
     *
     * @mbggenerated
     */
    @FieldDesc("是否显示(1:不显示 ,2:显示)")
    @ApiModelProperty(value = "是否显示(1:不显示 ,2:显示)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer isShow;

    /**
     * 排序
     *
     * @mbggenerated
     */
    @FieldDesc("排序")
    @ApiModelProperty(value = "排序")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer appOrder;

    /**
     * 创建类型(0:内部1:外部)
     *
     * @mbggenerated
     */
    @FieldDesc("创建类型(0:内部1:外部)")
    @ApiModelProperty(value = "创建类型(0:内部1:外部)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer createType;

    /**
     * 创建单位
     *
     * @mbggenerated
     */
    @FieldDesc("创建单位")
    @ApiModelProperty(value = "创建单位")
    @Length(max=64)
    private String createEmp;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    @FieldDesc("审批人")
    @ApiModelProperty(value = "审批人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long auditUser;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    @FieldDesc("审批时间")
    @ApiModelProperty(value = "审批时间")
    private Date auditTime;

    /**
     * 审批内容
     *
     * @mbggenerated
     */
    @FieldDesc("审批内容")
    @ApiModelProperty(value = "审批内容")
    @Length(max=150)
    private String auditContent;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @ApiModelProperty(value = "创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @ApiModelProperty(value = "更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}