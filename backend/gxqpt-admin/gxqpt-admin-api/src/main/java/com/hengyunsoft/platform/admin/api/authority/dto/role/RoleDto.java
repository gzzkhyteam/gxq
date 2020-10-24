package com.hengyunsoft.platform.admin.api.authority.dto.role;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * com.hengyunsoft.platform.admin.api.role.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class RoleDto extends RoleSaveDto {

    @ApiModelProperty(value = "角色Id")
    private Long id;

    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "状态： 1启用   2禁用")
    private Short status;

    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人id")
    private Long updateUser;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


    @ApiModelProperty(value = "业务标示，比如机构id")
    private String  bizFlag;

}
