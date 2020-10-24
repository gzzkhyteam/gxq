package com.hengyunsoft.platform.hardware.entity.database.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class DatabaseManagement extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 数据库实例DI
     *
     * @mbggenerated
     */
    private String instanceDi;

    /**
     * 数据库管理员
     *
     * @mbggenerated
     */
    private String admin;

    /**
     * 数据库账户
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 数据库类型：1、MYSQL；2、ORACLE；3、SQLSERVER；4、ACCESS、5、SYBASE
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * 主机IP地址
     *
     * @mbggenerated
     */
    private String hostIpAddress;

    /**
     * 字符集
     *
     * @mbggenerated
     */
    private String characterSet;

    /**
     * 端口
     *
     * @mbggenerated
     */
    private String port;

    /**
     * 所属网络：1、政务外网；2、互联网；3、内网
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 关联业务系统
     *
     * @mbggenerated
     */
    private String associatedServiceSystem;

    /**
     * 是否释放:0、否，1是
     *
     * @mbggenerated
     */
    private Integer isRelease;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String orgid;

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    private String orgname;

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
     * 修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据库实例DI
     *
     * @mbggenerated
     */
    public String getInstanceDi() {
        return instanceDi;
    }

    /**
     * 数据库实例DI
     *
     * @mbggenerated
     */
    public void setInstanceDi(String instanceDi) {
        this.instanceDi = instanceDi == null ? null : instanceDi.trim();
    }

    /**
     * 数据库管理员
     *
     * @mbggenerated
     */
    public String getAdmin() {
        return admin;
    }

    /**
     * 数据库管理员
     *
     * @mbggenerated
     */
    public void setAdmin(String admin) {
        this.admin = admin == null ? null : admin.trim();
    }

    /**
     * 数据库账户
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 数据库账户
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 数据库类型：1、MYSQL；2、ORACLE；3、SQLSERVER；4、ACCESS、5、SYBASE
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * 数据库类型：1、MYSQL；2、ORACLE；3、SQLSERVER；4、ACCESS、5、SYBASE
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 主机IP地址
     *
     * @mbggenerated
     */
    public String getHostIpAddress() {
        return hostIpAddress;
    }

    /**
     * 主机IP地址
     *
     * @mbggenerated
     */
    public void setHostIpAddress(String hostIpAddress) {
        this.hostIpAddress = hostIpAddress == null ? null : hostIpAddress.trim();
    }

    /**
     * 字符集
     *
     * @mbggenerated
     */
    public String getCharacterSet() {
        return characterSet;
    }

    /**
     * 字符集
     *
     * @mbggenerated
     */
    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet == null ? null : characterSet.trim();
    }

    /**
     * 端口
     *
     * @mbggenerated
     */
    public String getPort() {
        return port;
    }

    /**
     * 端口
     *
     * @mbggenerated
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 所属网络：1、政务外网；2、互联网；3、内网
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 所属网络：1、政务外网；2、互联网；3、内网
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 关联业务系统
     *
     * @mbggenerated
     */
    public String getAssociatedServiceSystem() {
        return associatedServiceSystem;
    }

    /**
     * 关联业务系统
     *
     * @mbggenerated
     */
    public void setAssociatedServiceSystem(String associatedServiceSystem) {
        this.associatedServiceSystem = associatedServiceSystem == null ? null : associatedServiceSystem.trim();
    }

    /**
     * 是否释放:0、否，1是
     *
     * @mbggenerated
     */
    public Integer getIsRelease() {
        return isRelease;
    }

    /**
     * 是否释放:0、否，1是
     *
     * @mbggenerated
     */
    public void setIsRelease(Integer isRelease) {
        this.isRelease = isRelease;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 单位名称
     *
     * @mbggenerated
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
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
     * 修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}