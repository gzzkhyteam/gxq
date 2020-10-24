package com.hengyunsoft.platform.mail.dto.open;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 投递服务
 *
 * @auth wt
 * @date 2018/08/27
 */
@Data
@ApiModel(value = "RequestDelivery", description = "投递服务")
public class RequestDeliveryDTO {

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID(保存时非必填，修改时必填)")
    private Long id;
    /**
     * 设定最大投递线程数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定最大投递线程数")
    private String maxThreadSum;

    /**
     * 设定投递尝试间隔时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定投递尝试间隔时间")
    private String timeInterval;

    /**
     * 设定最大尝试投递次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定最大尝试投递次数")
    private String maxThreadSecond;

    /**
     * 设定投递间隔增加率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定投递间隔增加率")
    private String intervalIncreaseRate;

    /**
     * 设定外发绑定IP
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定外发绑定IP")
    private String outBindingIp;

    /**
     * 设定网络连接超时值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定网络连接超时值")
    private String connectionTimeout;

    /**
     * 选择投递失败是否转入用户Exception文件夹
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "选择投递失败是否转入用户Exception文件夹")
    private String isExceptionFile;

    /**
     * 选择对中转邮件是否执行过滤规则
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "选择对中转邮件是否执行过滤规则")
    private String isFilteringRules;

    /**
     * 选择是否记录发件会话明细
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "选择是否记录发件会话明细")
    private String isConverDetail;

    /**
     * 编辑正常发送失败判断条件列表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编辑正常发送失败判断条件列表")
    private String errorTermList;

    /**
     * 设定中继最大投递尝试次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定中继最大投递尝试次数")
    private String maxAttemptsSum;

    /**
     * 设定中继最大同时投递数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "设定中继最大同时投递数")
    private String maxMoreoverSencod;

    /**
     * 邮箱用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱用户名")
    private String userName;
}
