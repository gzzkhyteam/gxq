package com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply;

import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiDetailDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.DemandFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请详情信息
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "ShareApplyDetail", description = "共享申请创建Dto")
public class ShareApplyDetailDTO extends ApiDetailDTO {
    @ApiModelProperty(value = "申请授权截止日期")
    private Date limitTime;

    @ApiModelProperty(value = "申请理由")
    private String reason;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "密钥")
    private String secretKey;



    @ApiModelProperty(value = "申请依据")
    private List<DemandFileDTO> fileList;

}
