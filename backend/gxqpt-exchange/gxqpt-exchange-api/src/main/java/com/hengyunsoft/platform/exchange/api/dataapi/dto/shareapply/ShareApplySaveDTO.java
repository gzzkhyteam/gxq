package com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.DemandFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请创建Dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "ShareApplySave", description = "共享申请创建Dto")
public class ShareApplySaveDTO {
    @ApiModelProperty(value = "申请Id")
    private Long id;
    @ApiModelProperty(value = "api目录", required = true)
    private Long dirId;

    @ApiModelProperty(value = "API id")
    private Long apiId;

    @ApiModelProperty(value = "API名称")
    private String apiName;

    @ApiModelProperty(value = "支持格式（1,json;2,xml）")
    private Integer dataFmat;

    @ApiModelProperty(value = "申请授权截止日期", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date limtTime;

    @ApiModelProperty(value = "申请理由")
    private String reason;

    @ApiModelProperty(value = "申请类型：1、已有Api申请，2：目录新增Api申请，3:非结构化文件申请", required = true)
    private Integer applyType;

    @ApiModelProperty(value = "申请依据")
    private List<DemandFileDTO> fileList;
}
