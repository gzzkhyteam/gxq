package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：企业统计首页
 * 修改人：gbl
 * 修改时间：2019/7/4
 * 修改内容：
 */
@Data
@ApiModel(value = "CompanyStaticsDTO", description = "企业统计首页")
public class CompanyStaticsDTO {
    @ApiModelProperty(value = "企业数量")
    private int companyNum;
    @ApiModelProperty(value = "本月新增")
    private int monthNum;
    @ApiModelProperty(value = "总资产")
    private int property;
    @ApiModelProperty(value = "在职人数")
    private int personNum;

    @ApiModelProperty(value = "申报数量")
    private int projectDeclare;
    @ApiModelProperty(value = "版权登记")
    private int technical;
    @ApiModelProperty(value = "软件著作权")
    private int investment;
    @ApiModelProperty(value = "IDC资质")
    private int cultivate;

    @ApiModelProperty(value = "历年项目申报数量统计 k:年份   v1:值")
    private List<StaticsKVDTO> yearDeclare;
    @ApiModelProperty(value = "项目申报类别统计 k:类别(0:其他 1.CMMI；2，发明专利；3，实用型专利；4，外观设计专利；5，版权登记；6，软件著作权；7，IDC资质) v1:数据")
    private List<StaticsKVDTO> pDeclares;
    @ApiModelProperty(value = "项目补助资金情况统计  k:年份 v1: 贷款贴息  v2:财政拨款")
    private List<StaticsKVDTO> projectSubsidy;
    @ApiModelProperty(value = "本年度企业项目申报排名  k:企业名称 v1:数量")
    private List<StaticsKVDTO> companyDeclare;

}
