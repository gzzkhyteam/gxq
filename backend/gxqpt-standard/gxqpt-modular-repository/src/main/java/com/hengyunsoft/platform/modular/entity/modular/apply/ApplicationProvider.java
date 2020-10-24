package com.hengyunsoft.platform.modular.entity.modular.apply;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ApplicationProvider", description = "")
public class ApplicationProvider extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups= MustNoneNull.class)
    private Long id;

    /**
     * 公司名称
     *
     * @mbggenerated
     */
    @FieldDesc("公司名称")
    @ApiModelProperty(value = "公司名称")
    @Length(max=64)
    private String name;

    /**
     * 所在地址
     *
     * @mbggenerated
     */
    @FieldDesc("所在地址")
    @ApiModelProperty(value = "所在地址")
    @Length(max=200)
    private String address;

    /**
     * 公司规模
     *
     * @mbggenerated
     */
    @FieldDesc("公司规模")
    @ApiModelProperty(value = "公司规模")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer empNum;

    /**
     * 统一社会信用代码
     *
     * @mbggenerated
     */
    @FieldDesc("统一社会信用代码")
    @ApiModelProperty(value = "统一社会信用代码")
    @Length(max=60)
    private String code;

    /**
     * 法人
     *
     * @mbggenerated
     */
    @FieldDesc("法人")
    @ApiModelProperty(value = "法人")
    @Length(max=20)
    private String leader;

    /**
     * 联系邮箱
     *
     * @mbggenerated
     */
    @FieldDesc("联系邮箱")
    @ApiModelProperty(value = "联系邮箱")
    @Length(max=64)
    private String email;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @FieldDesc("联系电话")
    @ApiModelProperty(value = "联系电话")
    @Length(max=20)
    private String phone;

    private Date createTime;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    private Date updateTime;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @FieldDesc("是否启用")
    @ApiModelProperty(value = "是否启用")
    private Boolean enableIs;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    @FieldDesc("是否删除")
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteIs;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;


}