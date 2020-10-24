package com.hengyunsoft.platform.msgs.dto.bbs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 保存主信息
 */
@Data
@ApiModel(value = "BbsAllMainMsgSaveReqDTO", description = "保存主信息")
public class BbsAllMainMsgSaveReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    public final static String PERSON_RECV_TYPE = "personal";
    public final static String ROLE_RECV_TYPE = "role";
    /**
     * 消息主表DTO
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息主表DTO")
    private BbsAllMainMsgDTO bbsAllMainMsgDTO;


    /**
     * 可看人员列表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "可看人员列表")
    private List<Long> lookUsers;


    /**
     * 可处理人员列表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "可处理人员列表")
    private List<Long> handlerUsers;
    /**
     * 接收类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收类型:个人-personal,角色-role")
    private String recvType;

    /**
     * 角色编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    /**
     * 角色相关应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色相关应用ID")
    private String roleAppId;

    /**
     * 角色处理能力
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "角色处理能力：看：false,处理：true")
    private Boolean roleHandIs;

}