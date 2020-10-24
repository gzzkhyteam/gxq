package com.hengyunsoft.platform.mail.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class DeliveryService extends BaseEntity<Long> implements Serializable {
    /**
     * 主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 设定最大投递线程数
     *
     * @mbggenerated
     */
    private String maxThreadSum;

    /**
     * 设定投递尝试间隔时间
     *
     * @mbggenerated
     */
    private String timeInterval;

    /**
     * 设定最大尝试投递次数
     *
     * @mbggenerated
     */
    private String maxThreadSecond;

    /**
     * 设定投递间隔增加率
     *
     * @mbggenerated
     */
    private String intervalIncreaseRate;

    /**
     * 设定外发绑定IP
     *
     * @mbggenerated
     */
    private String outBindingIp;

    /**
     * 设定网络连接超时值
     *
     * @mbggenerated
     */
    private String connectionTimeout;

    /**
     * 选择投递失败是否转入用户Exception文件夹
     *
     * @mbggenerated
     */
    private String isExceptionFile;

    /**
     * 选择对中转邮件是否执行过滤规则
     *
     * @mbggenerated
     */
    private String isFilteringRules;

    /**
     * 选择是否记录发件会话明细
     *
     * @mbggenerated
     */
    private String isConverDetail;

    /**
     * 编辑正常发送失败判断条件列表
     *
     * @mbggenerated
     */
    private String errorTermList;

    /**
     * 设定中继最大投递尝试次数
     *
     * @mbggenerated
     */
    private String maxAttemptsSum;

    /**
     * 设定中继最大同时投递数
     *
     * @mbggenerated
     */
    private String maxMoreoverSencod;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设定最大投递线程数
     *
     * @mbggenerated
     */
    public String getMaxThreadSum() {
        return maxThreadSum;
    }

    /**
     * 设定最大投递线程数
     *
     * @mbggenerated
     */
    public void setMaxThreadSum(String maxThreadSum) {
        this.maxThreadSum = maxThreadSum == null ? null : maxThreadSum.trim();
    }

    /**
     * 设定投递尝试间隔时间
     *
     * @mbggenerated
     */
    public String getTimeInterval() {
        return timeInterval;
    }

    /**
     * 设定投递尝试间隔时间
     *
     * @mbggenerated
     */
    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval == null ? null : timeInterval.trim();
    }

    /**
     * 设定最大尝试投递次数
     *
     * @mbggenerated
     */
    public String getMaxThreadSecond() {
        return maxThreadSecond;
    }

    /**
     * 设定最大尝试投递次数
     *
     * @mbggenerated
     */
    public void setMaxThreadSecond(String maxThreadSecond) {
        this.maxThreadSecond = maxThreadSecond == null ? null : maxThreadSecond.trim();
    }

    /**
     * 设定投递间隔增加率
     *
     * @mbggenerated
     */
    public String getIntervalIncreaseRate() {
        return intervalIncreaseRate;
    }

    /**
     * 设定投递间隔增加率
     *
     * @mbggenerated
     */
    public void setIntervalIncreaseRate(String intervalIncreaseRate) {
        this.intervalIncreaseRate = intervalIncreaseRate == null ? null : intervalIncreaseRate.trim();
    }

    /**
     * 设定外发绑定IP
     *
     * @mbggenerated
     */
    public String getOutBindingIp() {
        return outBindingIp;
    }

    /**
     * 设定外发绑定IP
     *
     * @mbggenerated
     */
    public void setOutBindingIp(String outBindingIp) {
        this.outBindingIp = outBindingIp == null ? null : outBindingIp.trim();
    }

    /**
     * 设定网络连接超时值
     *
     * @mbggenerated
     */
    public String getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * 设定网络连接超时值
     *
     * @mbggenerated
     */
    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout == null ? null : connectionTimeout.trim();
    }

    /**
     * 选择投递失败是否转入用户Exception文件夹
     *
     * @mbggenerated
     */
    public String getIsExceptionFile() {
        return isExceptionFile;
    }

    /**
     * 选择投递失败是否转入用户Exception文件夹
     *
     * @mbggenerated
     */
    public void setIsExceptionFile(String isExceptionFile) {
        this.isExceptionFile = isExceptionFile == null ? null : isExceptionFile.trim();
    }

    /**
     * 选择对中转邮件是否执行过滤规则
     *
     * @mbggenerated
     */
    public String getIsFilteringRules() {
        return isFilteringRules;
    }

    /**
     * 选择对中转邮件是否执行过滤规则
     *
     * @mbggenerated
     */
    public void setIsFilteringRules(String isFilteringRules) {
        this.isFilteringRules = isFilteringRules == null ? null : isFilteringRules.trim();
    }

    /**
     * 选择是否记录发件会话明细
     *
     * @mbggenerated
     */
    public String getIsConverDetail() {
        return isConverDetail;
    }

    /**
     * 选择是否记录发件会话明细
     *
     * @mbggenerated
     */
    public void setIsConverDetail(String isConverDetail) {
        this.isConverDetail = isConverDetail == null ? null : isConverDetail.trim();
    }

    /**
     * 编辑正常发送失败判断条件列表
     *
     * @mbggenerated
     */
    public String getErrorTermList() {
        return errorTermList;
    }

    /**
     * 编辑正常发送失败判断条件列表
     *
     * @mbggenerated
     */
    public void setErrorTermList(String errorTermList) {
        this.errorTermList = errorTermList == null ? null : errorTermList.trim();
    }

    /**
     * 设定中继最大投递尝试次数
     *
     * @mbggenerated
     */
    public String getMaxAttemptsSum() {
        return maxAttemptsSum;
    }

    /**
     * 设定中继最大投递尝试次数
     *
     * @mbggenerated
     */
    public void setMaxAttemptsSum(String maxAttemptsSum) {
        this.maxAttemptsSum = maxAttemptsSum == null ? null : maxAttemptsSum.trim();
    }

    /**
     * 设定中继最大同时投递数
     *
     * @mbggenerated
     */
    public String getMaxMoreoverSencod() {
        return maxMoreoverSencod;
    }

    /**
     * 设定中继最大同时投递数
     *
     * @mbggenerated
     */
    public void setMaxMoreoverSencod(String maxMoreoverSencod) {
        this.maxMoreoverSencod = maxMoreoverSencod == null ? null : maxMoreoverSencod.trim();
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}