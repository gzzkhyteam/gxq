package com.hengyunsoft.platform.security.entity.backups.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Backups extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 备份名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    private String applicationName;

    /**
     * 备份路径
     *
     * @mbggenerated
     */
    private String path;

    /**
     * 文件后缀
     *
     * @mbggenerated
     */
    private String fileExt;

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    private String serverIp;

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    private String serverAccount;

    /**
     * 服务器密码
     *
     * @mbggenerated
     */
    private String serverPasswd;

    /**
     * 数据库类型 mysql oracle sqlserver mongodb hbase
     *
     * @mbggenerated
     */
    private Integer dbType;

    /**
     * 备份频率(定时表达式) 直接填
     *
     * @mbggenerated
     */
    private String backupFrequency;

    /**
     * 检查标示
     *
     * @mbggenerated
     */
    private Boolean checkMark;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 最后修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 最后修改人
     *
     * @mbggenerated
     */
    private Long updateUser;

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
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 备份名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 备份名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * 备份路径
     *
     * @mbggenerated
     */
    public String getPath() {
        return path;
    }

    /**
     * 备份路径
     *
     * @mbggenerated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 文件后缀
     *
     * @mbggenerated
     */
    public String getFileExt() {
        return fileExt;
    }

    /**
     * 文件后缀
     *
     * @mbggenerated
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt == null ? null : fileExt.trim();
    }

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    public String getServerAccount() {
        return serverAccount;
    }

    /**
     * 服务器账号
     *
     * @mbggenerated
     */
    public void setServerAccount(String serverAccount) {
        this.serverAccount = serverAccount == null ? null : serverAccount.trim();
    }

    /**
     * 服务器密码
     *
     * @mbggenerated
     */
    public String getServerPasswd() {
        return serverPasswd;
    }

    /**
     * 服务器密码
     *
     * @mbggenerated
     */
    public void setServerPasswd(String serverPasswd) {
        this.serverPasswd = serverPasswd == null ? null : serverPasswd.trim();
    }

    /**
     * 数据库类型 mysql oracle sqlserver mongodb hbase
     *
     * @mbggenerated
     */
    public Integer getDbType() {
        return dbType;
    }

    /**
     * 数据库类型 mysql oracle sqlserver mongodb hbase
     *
     * @mbggenerated
     */
    public void setDbType(Integer dbType) {
        this.dbType = dbType;
    }

    /**
     * 备份频率(定时表达式) 直接填
     *
     * @mbggenerated
     */
    public String getBackupFrequency() {
        return backupFrequency;
    }

    /**
     * 备份频率(定时表达式) 直接填
     *
     * @mbggenerated
     */
    public void setBackupFrequency(String backupFrequency) {
        this.backupFrequency = backupFrequency == null ? null : backupFrequency.trim();
    }

    /**
     * 检查标示
     *
     * @mbggenerated
     */
    public Boolean getCheckMark() {
        return checkMark;
    }

    /**
     * 检查标示
     *
     * @mbggenerated
     */
    public void setCheckMark(Boolean checkMark) {
        this.checkMark = checkMark;
    }

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 最后修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最后修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 最后修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 最后修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}