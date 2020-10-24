package com.hengyunsoft.rpc.data.po;

import java.io.Serializable;

public class DepartmentPO implements Serializable {
    private String id;

    private String parentName;

    private String parentId;

    private String orgId;

    private String name;

    private String shortName;

    private String elseName;

    private String forType;

    private String forClass;

    private String forindustry;

    private String orgadmin;

    private String zipcode;

    private String telcode;

    private String faxcode;

    private String status;

    private Integer sortvalue;

    private String descrption;

    private String fornodetype;

    private String orgduty;

    private String isdelete;

    private String isenable;

    private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getElseName() {
		return elseName;
	}

	public void setElseName(String elseName) {
		this.elseName = elseName;
	}

	public String getForType() {
		return forType;
	}

	public void setForType(String forType) {
		this.forType = forType;
	}

	public String getForClass() {
		return forClass;
	}

	public void setForClass(String forClass) {
		this.forClass = forClass;
	}

	public String getForindustry() {
		return forindustry;
	}

	public void setForindustry(String forindustry) {
		this.forindustry = forindustry;
	}

	public String getOrgadmin() {
		return orgadmin;
	}

	public void setOrgadmin(String orgadmin) {
		this.orgadmin = orgadmin;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelcode() {
		return telcode;
	}

	public void setTelcode(String telcode) {
		this.telcode = telcode;
	}

	public String getFaxcode() {
		return faxcode;
	}

	public void setFaxcode(String faxcode) {
		this.faxcode = faxcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSortvalue() {
		return sortvalue;
	}

	public void setSortvalue(Integer sortvalue) {
		this.sortvalue = sortvalue;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getFornodetype() {
		return fornodetype;
	}

	public void setFornodetype(String fornodetype) {
		this.fornodetype = fornodetype;
	}

	public String getOrgduty() {
		return orgduty;
	}

	public void setOrgduty(String orgduty) {
		this.orgduty = orgduty;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getIsenable() {
		return isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}
}