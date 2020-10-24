package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.core.dto.emp
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：用户简要要信息dto
 * 修改人：gbl
 * 修改时间：2018/7/26
 * 修改内容：
 */
@Data
@ApiModel(value = "SimpEmoDTO", description = "用户简要要信息dto")
public class SimpEmpDTO {

    /**
     * 用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private Long gxqptEmpId;
    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记")
    private String isenable;
    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位id")
    private String mainorgid;
    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位名称")
    private String mainorgname;

    /***
     * 所属部门名称
     */
    @ApiModelProperty(value = "所属部门名称")
    private String maindeptname;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务名称")
    private String maindutyname;
}
