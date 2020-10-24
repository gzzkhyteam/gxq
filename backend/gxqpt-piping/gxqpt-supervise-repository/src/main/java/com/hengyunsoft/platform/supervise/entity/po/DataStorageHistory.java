package com.hengyunsoft.platform.supervise.entity.po;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "DataStorageHistory", description = "")
public class DataStorageHistory extends com.hengyunsoft.base.entity.BaseEntity<Long> implements Serializable {
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
     * 数据存储配置id
     *
     * @mbggenerated
     */
    @FieldDesc("数据存储配置id")
    @ApiModelProperty(value = "数据存储配置id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long storageId;

    /**
     * 数据库空间数量
     *
     * @mbggenerated
     */
    @FieldDesc("数据库空间数量")
    @ApiModelProperty(value = "数据库空间数量")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Double dbSpaceNum;

    /**
     * 日志空间数量
     *
     * @mbggenerated
     */
    @FieldDesc("日志空间数量")
    @ApiModelProperty(value = "日志空间数量")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Double logSpaceNum;

    /**
     * 文件空间数量
     *
     * @mbggenerated
     */
    @FieldDesc("文件空间数量")
    @ApiModelProperty(value = "文件空间数量")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Double fileSpaceNum;

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
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @ApiModelProperty(value = "更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}