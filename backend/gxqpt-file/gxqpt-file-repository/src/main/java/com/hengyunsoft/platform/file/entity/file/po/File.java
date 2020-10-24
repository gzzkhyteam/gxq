package com.hengyunsoft.platform.file.entity.file.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class File extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 组织id
     *
     * @mbggenerated
     */
    private Long orgId;

    /**
     * 人员id
     *
     * @mbggenerated
     */
    private Long adminId;

    /**
     * 是否删除 0:否 1：是
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 文件夹id
     *
     * @mbggenerated
     */
    private Long folderId;

    /**
     * 父文件夹名称
     *
     * @mbggenerated
     */
    private String folderName;

    /**
     * 对象id
     *
     * @mbggenerated
     */
    private String objectId;

    /**
     * 命名空间
     *
     * @mbggenerated
     */
    private String namespace;

    /**
     * 文件的唯一key
     *
     * @mbggenerated
     */
    private String uKey;

    /**
     * fastDFS返回的组
     *
     * @mbggenerated
     */
    private String groupName;

    /**
     * fasfdfs的远程文件名
     *
     * @mbggenerated
     */
    private String remoteFileName;

    /**
     * 文件在服务器的绝对路径
     *
     * @mbggenerated
     */
    private String absolutePath;

    /**
     * 文件在服务器的相对路径 \r\n 
     *
     * @mbggenerated
     */
    private String relativePath;

    /**
     * 链接
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 语音转文字返回数据
     *
     * @mbggenerated
     */
    private String characters;

    /**
     * 视频截图路径url
     *
     * @mbggenerated
     */
    private String screenshot;

    /**
     * swf路径
     *
     * @mbggenerated
     */
    private String swf;

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    private String dataType;

    /**
     * 类型
     *
     * @mbggenerated
     */
    private String mime;

    /**
     * 原始文件名
     *
     * @mbggenerated
     */
    private String submittedFileName;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    private String filename;

    /**
     * 后缀 (没有.)
     *
     * @mbggenerated
     */
    private String ext;

    /**
     * 大小
     *
     * @mbggenerated
     */
    private String size;

    /**
     * 图标
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * 父目录层级关系
     *
     * @mbggenerated
     */


    /**
     * 子文件
     */
    private List<File> childFile;
    private String treePath;

    private Date createTime;

    private Long createUser;

    private Date updateTime;

    private Long updateUser;

    /**
     * 文件md5值
     *
     * @mbggenerated
     */
    private String fileMd5;

    /**
     * 文件上传类型
     *
     * @mbggenerated
     */
    private String contextType;

    /**
     * 文件sha1值
     *
     * @mbggenerated
     */
    private String fileSha1;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

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
     * 组织id
     *
     * @mbggenerated
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 组织id
     *
     * @mbggenerated
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 人员id
     *
     * @mbggenerated
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 是否删除 0:否 1：是
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除 0:否 1：是
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 文件夹id
     *
     * @mbggenerated
     */
    public Long getFolderId() {
        return folderId;
    }

    /**
     * 文件夹id
     *
     * @mbggenerated
     */
    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    /**
     * 父文件夹名称
     *
     * @mbggenerated
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * 父文件夹名称
     *
     * @mbggenerated
     */
    public void setFolderName(String folderName) {
        this.folderName = folderName == null ? null : folderName.trim();
    }

    /**
     * 对象id
     *
     * @mbggenerated
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * 对象id
     *
     * @mbggenerated
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * 命名空间
     *
     * @mbggenerated
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * 命名空间
     *
     * @mbggenerated
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace == null ? null : namespace.trim();
    }

    /**
     * 文件的唯一key
     *
     * @mbggenerated
     */
    public String getuKey() {
        return uKey;
    }

    /**
     * 文件的唯一key
     *
     * @mbggenerated
     */
    public void setuKey(String uKey) {
        this.uKey = uKey == null ? null : uKey.trim();
    }

    /**
     * fastDFS返回的组
     *
     * @mbggenerated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * fastDFS返回的组
     *
     * @mbggenerated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * fasfdfs的远程文件名
     *
     * @mbggenerated
     */
    public String getRemoteFileName() {
        return remoteFileName;
    }

    /**
     * fasfdfs的远程文件名
     *
     * @mbggenerated
     */
    public void setRemoteFileName(String remoteFileName) {
        this.remoteFileName = remoteFileName == null ? null : remoteFileName.trim();
    }

    /**
     * 文件在服务器的绝对路径
     *
     * @mbggenerated
     */
    public String getAbsolutePath() {
        return absolutePath;
    }

    /**
     * 文件在服务器的绝对路径
     *
     * @mbggenerated
     */
    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath == null ? null : absolutePath.trim();
    }

    /**
     * 文件在服务器的相对路径 \r\n 
     *
     * @mbggenerated
     */
    public String getRelativePath() {
        return relativePath;
    }

    /**
     * 文件在服务器的相对路径 \r\n 
     *
     * @mbggenerated
     */
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath == null ? null : relativePath.trim();
    }

    /**
     * 链接
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * 链接
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 语音转文字返回数据
     *
     * @mbggenerated
     */
    public String getCharacters() {
        return characters;
    }

    /**
     * 语音转文字返回数据
     *
     * @mbggenerated
     */
    public void setCharacters(String characters) {
        this.characters = characters == null ? null : characters.trim();
    }

    /**
     * 视频截图路径url
     *
     * @mbggenerated
     */
    public String getScreenshot() {
        return screenshot;
    }

    /**
     * 视频截图路径url
     *
     * @mbggenerated
     */
    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot == null ? null : screenshot.trim();
    }

    /**
     * swf路径
     *
     * @mbggenerated
     */
    public String getSwf() {
        return swf;
    }

    /**
     * swf路径
     *
     * @mbggenerated
     */
    public void setSwf(String swf) {
        this.swf = swf == null ? null : swf.trim();
    }

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 类型
     *
     * @mbggenerated
     */
    public String getMime() {
        return mime;
    }

    /**
     * 类型
     *
     * @mbggenerated
     */
    public void setMime(String mime) {
        this.mime = mime == null ? null : mime.trim();
    }

    /**
     * 原始文件名
     *
     * @mbggenerated
     */
    public String getSubmittedFileName() {
        return submittedFileName;
    }

    /**
     * 原始文件名
     *
     * @mbggenerated
     */
    public void setSubmittedFileName(String submittedFileName) {
        this.submittedFileName = submittedFileName == null ? null : submittedFileName.trim();
    }

    /**
     * 文件名
     *
     * @mbggenerated
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 文件名
     *
     * @mbggenerated
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * 后缀 (没有.)
     *
     * @mbggenerated
     */
    public String getExt() {
        return ext;
    }

    /**
     * 后缀 (没有.)
     *
     * @mbggenerated
     */
    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    /**
     * 大小
     *
     * @mbggenerated
     */
    public String getSize() {
        return size;
    }

    /**
     * 大小
     *
     * @mbggenerated
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 父目录层级关系
     *
     * @mbggenerated
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * 父目录层级关系
     *
     * @mbggenerated
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath == null ? null : treePath.trim();
    }
    public List<File> getChildFile() {
        return childFile;
    }

    public void setChildFile(List<File> childFile) {
        this.childFile = childFile;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 文件md5值
     *
     * @mbggenerated
     */
    public String getFileMd5() {
        return fileMd5;
    }

    /**
     * 文件md5值
     *
     * @mbggenerated
     */
    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5 == null ? null : fileMd5.trim();
    }

    /**
     * 文件上传类型
     *
     * @mbggenerated
     */
    public String getContextType() {
        return contextType;
    }

    /**
     * 文件上传类型
     *
     * @mbggenerated
     */
    public void setContextType(String contextType) {
        this.contextType = contextType == null ? null : contextType.trim();
    }

    /**
     * 文件sha1值
     *
     * @mbggenerated
     */
    public String getFileSha1() {
        return fileSha1;
    }

    /**
     * 文件sha1值
     *
     * @mbggenerated
     */
    public void setFileSha1(String fileSha1) {
        this.fileSha1 = fileSha1 == null ? null : fileSha1.trim();
    }
}