package com.hengyunsoft.platform.search.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
@Data
public class ShareDataApiIndex extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * api名称
     *
     * @mbggenerated
     */
    @FieldDesc("api名称")
    @Length(max=200)
    @NotNull(groups=MustNoneNull.class)
    private String apiName;

    /**
     * api描述
     *
     * @mbggenerated
     */
    @FieldDesc("api描述")
    @Length(max=200)
    @NotNull(groups=MustNoneNull.class)
    private String apiDesc;

}