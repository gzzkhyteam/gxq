package com.hengyunsoft.platform.exchange.entity.set.domain;

/***
 * 集合流程信息
 */
public class DSFlowTaskInfoDO {

    /***
     * 数据集id
     */
    private Long dataSetId;
    /***
     * 申请编号
     */
    private String applyCode;
    /***
     * 数据集名称
     */
    private String setName;
    /***
     * 申请人名称
     */
    private String userName;
    /***
     * 原因
     */
    private String reason;

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getDataSetId() {
        return dataSetId;
    }

    public void setDataSetId(Long dataSetId) {
        this.dataSetId = dataSetId;
    }
}
