package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import java.io.Serializable;
import java.util.Date;

import com.hengyunsoft.base.entity.BaseEntity;
/**
 * 第三方短信服务商 配置表
 * @author dxz
 */
public class SmsProvider extends BaseEntity<Long> implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
    /** 名称 */
    private String name;
    /** 描述 */
    private String describe;
    /** 服务商 编号[ProviderCode]:自定义的 */
    private String code;
    private Date createTime;
    /**发送账号安全认证的Access Key ID  */
    private String accessKeyId;
    /** 发送账号安全认证的Secret Access Key */
    private String accessKeySecret;
    /** SMS服务域名 */
    private String url;
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAccessKeyId() {
		return accessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		return accessKeySecret;
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public Date getUpdateTime() {
		return null;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public void setUpdateTime(Date arg0) {
		
	}
}
