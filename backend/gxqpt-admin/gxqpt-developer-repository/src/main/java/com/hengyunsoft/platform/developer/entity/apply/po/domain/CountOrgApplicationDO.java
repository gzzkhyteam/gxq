package com.hengyunsoft.platform.developer.entity.apply.po.domain;

public class CountOrgApplicationDO {


	/**
     * 应用所属单位Id
     *
     * @mbggenerated
     */
    private String orgId;

    /**
     * 单位所属体系编码
     *
     * @mbggenerated
     */
    private String orgSystemCode;

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    private String orgName;
    
    /**
     * 应用数量
     */
    private Integer appNum;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgSystemCode() {
		return orgSystemCode;
	}

	public void setOrgSystemCode(String orgSystemCode) {
		this.orgSystemCode = orgSystemCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getAppNum() {
		return appNum;
	}

	public void setAppNum(Integer appNum) {
		this.appNum = appNum;
	}
    

}
