package com.hengyunsoft.platform.developer.api.screen.dto.hostruning;

public class HostRuningUpdateDTO extends HostRuningDTO {

	//cup核数
	private Double cpuCoreNum;
	//内存数量
	private Double memNum;
	//磁盘数量
	private Double diskNum;
	//带宽
	private Double bandwidth;
	private String ipAddr;
	public Double getCpuCoreNum() {
		return cpuCoreNum;
	}
	public void setCpuCoreNum(Double cpuCoreNum) {
		this.cpuCoreNum = cpuCoreNum;
	}
	public Double getMemNum() {
		return memNum;
	}
	public void setMemNum(Double memNum) {
		this.memNum = memNum;
	}
	public Double getDiskNum() {
		return diskNum;
	}
	public void setDiskNum(Double diskNum) {
		this.diskNum = diskNum;
	}
	public Double getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(Double bandwidth) {
		this.bandwidth = bandwidth;
	}
	@Override
	public String toString() {
		return "HostRuningUpdateDTO [cpuCoreNum=" + cpuCoreNum + ", memNum=" + memNum + ", diskNum=" + diskNum
				+ ", bandwidth=" + bandwidth + ", ipAddr=" + ipAddr + "]" + super.toString();
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
}
