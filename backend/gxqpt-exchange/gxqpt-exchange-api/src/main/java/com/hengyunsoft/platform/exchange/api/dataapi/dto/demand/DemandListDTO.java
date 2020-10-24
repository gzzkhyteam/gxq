package com.hengyunsoft.platform.exchange.api.dataapi.dto.demand;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：需求新增dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "DemandList", description = "需求列表")
public class DemandListDTO extends DemandSaveDTO {
    @ApiModelProperty(value = "申请编码")
    private String applyCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "申请时间")
    private Date createTime;

    @ApiModelProperty(value = "处理状态(1,待审批；2，已驳回；3，通过，待封装API；4，已封装API)")
    private Integer status;

    @ApiModelProperty(value = "处理意见")
    private String hdContent;

    @ApiModelProperty(value = "处理单位名称")
    private String hdOrgName;

    @ApiModelProperty(value = "申请Id")
    private Long id;

    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;

    @ApiModelProperty(value = "apiId")
    private Long apiId;

}
