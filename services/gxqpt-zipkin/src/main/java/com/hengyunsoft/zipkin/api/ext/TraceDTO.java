package com.hengyunsoft.zipkin.api.ext;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TraceDTO {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String traceId;
	private String name;
	private Long start;
	private String duration;
	private String appId;
	private String endpointServiceName;
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		if(start == null) {
			return null;
		}
		return dateFormat.format(new Date(start/1000));
	}
	
	public void setStart(Long start) {
		this.start = start;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getEndpointServiceName() {
		return endpointServiceName;
	}
	public void setEndpointServiceName(String endpointServiceName) {
		this.endpointServiceName = endpointServiceName;
	}
	
	
}
