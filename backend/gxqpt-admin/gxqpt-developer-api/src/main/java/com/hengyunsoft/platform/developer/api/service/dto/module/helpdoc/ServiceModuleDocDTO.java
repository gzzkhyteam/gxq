package com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "ServiceModuleDocDTO", description = "帮助文档实体")
public class ServiceModuleDocDTO implements Serializable{
    /**
     * id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块id")
    private Long moduleId;

    /**
     * 序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "序号")
    private Integer order;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 搜索标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "搜索标题")
    private String searchTitle;

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布状态： 未发布、已发表")
    private Boolean publishStatus;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 搜索内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "搜索内容")
    private String searchContent;

    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否公有资源（是否需要登陆方可查看）")
    private Boolean publicIs;


    private static final long serialVersionUID = 1L;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * 模块id
     *
     * @mbggenerated
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 序号
     *
     * @mbggenerated
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    public Boolean getPublishStatus() {
        return publishStatus;
    }

    /**
     * 发布状态： 未发布、已发表
     *
     * @mbggenerated
     */
    public void setPublishStatus(Boolean publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    public Boolean getPublicIs() {
        return publicIs;
    }

    /**
     * 是否公有资源（是否需要登陆方可查看）
     *
     * @mbggenerated
     */
    public void setPublicIs(Boolean publicIs) {
        this.publicIs = publicIs;
    }

}
