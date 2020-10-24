package com.hengyunsoft.platform.ops.consultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kevin on 2018/7/17.
 */
@Data
@ApiModel(value = "ConsultDealReq", description = "处理咨询")
public class ConsultDealReqDTO implements Serializable{


    @ApiModelProperty(value = "id" ,required = true)
    private Long id;

    @ApiModelProperty(value = "处理结果（同意true，驳回false）" ,required = true)
    private String dealResult;

    @ApiModelProperty(value = "处理意见",required = false)
    private String dealOpinion;

    @ApiModelProperty(value = "处理人员信息" ,required = false)
    private List<DealUserDTO> dealUser;
}
