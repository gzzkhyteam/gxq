package com.hengyunsoft.platform.ops.consultdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kevin on 2018/7/16.
 */
@Data
@ApiModel(value = "ConsultApplyUpdateReq", description = "修改咨询")
public class ConsultApplyUpdateReqDTO implements Serializable{

    @ApiModelProperty(value = "ID",required = true)
    private Long id;

    @ApiModelProperty(value = "咨询名称",required = true)
    private String consultName;

    @ApiModelProperty(value = "咨询时间",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date consultTime;

    @ApiModelProperty(value = "咨询内容",required = true)
    private String consultInfo;

    @ApiModelProperty(value = "提交单位",required = true)
    private String subDept;
}
