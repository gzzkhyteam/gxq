package com.hengyunsoft.platform.admin.api.core.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "GxqptPost", description = "岗位信息")
public class GxqptPostQueryDTO implements Serializable {

    @ApiModelProperty(value = "系统编码")
    private String systemCode;

    /**
     * 岗位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位名称")
    private String name;

    /**
     * 岗位编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位编码")
    private String code;

    /**
     * 岗位所属单位 id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位所属单位 id")
    private String orgid;

    /**
     * 岗位所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位所属单位名称")
    private String orgname;

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序（值小排前）")
    private Integer sortvalue;


    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记")
    private String isenable;

    /**
     * 岗位级别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位级别")
    private String level;

    /**
     * 岗位描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "岗位描述")
    private String description;

    /**
     * 同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用")
    private String logid;

    private static final long serialVersionUID = 1L;

    /**
     * 岗位名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 岗位名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 岗位编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 岗位编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 岗位所属单位 id
     *
     * @mbggenerated
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     * 岗位所属单位 id
     *
     * @mbggenerated
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     * 岗位所属单位名称
     *
     * @mbggenerated
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 岗位所属单位名称
     *
     * @mbggenerated
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    public Integer getSortvalue() {
        return sortvalue;
    }

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    public void setSortvalue(Integer sortvalue) {
        this.sortvalue = sortvalue;
    }

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    public String getIsenable() {
        return isenable;
    }

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    /**
     * 岗位级别
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * 岗位级别
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 岗位描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 岗位描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public String getLogid() {
        return logid;
    }

    /**
     * 同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

}
