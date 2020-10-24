package com.hengyunsoft.platform.mt.api.application.dto;

import com.hengyunsoft.platform.mt.api.component.dto.AppComponentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：应用信息
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：
 */
@Data
@ApiModel(value = "Application", description = "应用信息")
public class ApplicationDTO {
    @ApiModelProperty(value = "应用id")
    private Long id;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "应用类型(1:安卓,2:h5)")
    private Integer appType;

    @ApiModelProperty(value = "应用图标")
    private String iconPath;

    @ApiModelProperty(value = "审核状态(1暂时,2审核中,3通过,4驳回)")
    private Integer state;

    @ApiModelProperty(value = "应用路径")
    private String appPath;

    @ApiModelProperty(value = "应用说明")
    private String appDesc;

    @ApiModelProperty(value = "是否显示(1:不显示 ,2:显示)")
    private Integer isShow;

    @ApiModelProperty(value = "排序")
    private Integer appOrder;

    @ApiModelProperty(value = "创建时间(登记时间)")
    private Date createTime;

    @ApiModelProperty(value = "关联组件信息")
    private List<AppComponentDTO> componentList;
    /**
     * Android的包名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Android的包名")
    private String appPackageName;

    /**
     * Android的启动画面
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Android的启动画面")
    private String appStartAct;
}
