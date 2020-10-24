package com.hengyunsoft.platform.developer.api.screen.dto.hostruning;


public class  HostRuningDTO implements Comparable<HostRuningDTO>{
	
	private String hostName;
	//cup利用率
	private Double cpuUseRate;
	//内存利用率
	private Double memUseRate;
	//磁盘利用率
	private Double diskUseRate;
	//带宽利用率
	private Double bandwidthUseRate;
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Double getCpuUseRate() {
		return cpuUseRate;
	}
	public void setCpuUseRate(Double cpuUseRate) {
		this.cpuUseRate = cpuUseRate;
	}
	public Double getMemUseRate() {
		return memUseRate;
	}
	public void setMemUseRate(Double memUseRate) {
		this.memUseRate = memUseRate;
	}
	public Double getDiskUseRate() {
		return diskUseRate;
	}
	public void setDiskUseRate(Double diskUseRate) {
		this.diskUseRate = diskUseRate;
	}
	public Double getBandwidthUseRate() {
		return bandwidthUseRate;
	}
	public void setBandwidthUseRate(Double bandwidthUseRate) {
		this.bandwidthUseRate = bandwidthUseRate;
	}
	public int compare(HostRuningDTO obj1, HostRuningDTO obj2) {
		
		int compare = Double.compare(obj1.getCpuUseRate(), obj2.getCpuUseRate());
		if(compare == 0) {
			compare = Double.compare(obj1.getMemUseRate(), obj2.getMemUseRate());
			if(compare == 0) {
				compare = Double.compare(obj1.getBandwidthUseRate(), obj2.getBandwidthUseRate());
			}
			if(compare == 0) {
				return Double.compare(obj1.getDiskUseRate(), obj2.getDiskUseRate());
			}
		}
		return compare;
	}
	@Override
	public int compareTo(HostRuningDTO o) {
		
		return compare(o,this);
	}
	@Override
	public String toString() {
		return "HostRuningDTO [hostName=" + hostName + ", cpuUseRate=" + cpuUseRate + ", memUseRate=" + memUseRate
				+ ", diskUseRate=" + diskUseRate + ", bandwidthUseRate=" + bandwidthUseRate + "]";
	}
}