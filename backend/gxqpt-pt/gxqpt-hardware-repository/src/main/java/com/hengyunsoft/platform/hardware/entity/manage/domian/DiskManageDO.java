package com.hengyunsoft.platform.hardware.entity.manage.domian;

import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;

public class DiskManageDO extends DiskManage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 管理单位id
     *
     * @mbggenerated
     */
    private String orgid;

    /**
     * 管理单位名称
     *
     * @mbggenerated
     */
    private String orgname;

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
    
}
