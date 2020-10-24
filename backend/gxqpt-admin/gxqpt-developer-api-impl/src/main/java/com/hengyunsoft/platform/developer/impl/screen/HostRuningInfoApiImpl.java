package com.hengyunsoft.platform.developer.impl.screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.HostRuningInfoApi;
import com.hengyunsoft.platform.developer.api.screen.dto.hostruning.HostRuningDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.hostruning.HostRuningUpdateDTO;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;

@RestController
@RequestMapping("hostRuning")
public class HostRuningInfoApiImpl implements HostRuningInfoApi,Runnable {

	List<HostRuningInfo> hostRuningInfos = new ArrayList<>();
	
	ReentrantReadWriteLock hostRuningInfosReadWriteLock = new ReentrantReadWriteLock();
	WriteLock wLock = hostRuningInfosReadWriteLock.writeLock();
	ReadLock rLock = hostRuningInfosReadWriteLock.readLock();
	
	ExecutorService executorService ;
	Random random = new Random();
	//最大的记录历史记录数（最多记录多少历史数据  cpu  内存等等）
	final int maxHistoryNum = 20;
	public HostRuningInfoApiImpl() {
		
		initHostRuningInfo();
		executorService = Executors.newSingleThreadExecutor();
		executorService.submit(this);
	}

	private void initHostRuningInfo() {
		for (HostRuningInfo hostRuningInfo : hostRuningInfos) {
			for(int i=0;i<maxHistoryNum;i++) {
				hostRuningInfo.getBandwidthUseNum().push(0.0);
				hostRuningInfo.getDiskUseNum().push(0.0);
				hostRuningInfo.getCpuUseNum().push(0.0);
				hostRuningInfo.getMemUseNum().push(0.0);
			}
		}
	}

	@Override
	@GetMapping("info")
	@ApiOperation(value = "获取主机运行时信息", notes = "获取主机运行时信息")
	public Result<Map<String, List<Double>>> getHostRuningInfo() {
		
		List<Double> disk = new ArrayList<>();
		List<Double> cpu = new ArrayList<>();
		List<Double> mem = new ArrayList<>();
		List<Double> bandwidth = new ArrayList<>();
		List<Double> total = new ArrayList<>();
		
		double diskTotal = 0;
		double cpuTotal = 0;
		double memTotal = 0;
		double bandwidthkTotal = 0;
		for (int i = 0; i < 4; i++) {
			total.add(0.0);
		}
		rLock.lock();
		try {
			for (int i = 0; i < hostRuningInfos.get(0).getBandwidthUseNum().size(); i++) {
				diskTotal = 0;
				cpuTotal = 0;
				memTotal = 0;
				bandwidthkTotal = 0;
				for (HostRuningInfo runingInfo : hostRuningInfos) {
					diskTotal += runingInfo.getDiskUseNum().get(i);
					cpuTotal += runingInfo.getCpuUseNum().get(i);
					memTotal += runingInfo.getMemUseNum().get(i);
					bandwidthkTotal += runingInfo.getBandwidthUseNum().get(i);
				}
				disk.add(diskTotal);
				cpu.add(cpuTotal);
				mem.add(memTotal);
				bandwidth.add(bandwidthkTotal);
			}
			for (HostRuningInfo runingInfo : hostRuningInfos) {
				//1 cpu
				total.set(0, total.get(0) + runingInfo.getCpuCoreNum());
				//2.磁盘
				total.set(1, total.get(1) + runingInfo.getDiskNum());
				//3.内存
				total.set(2, total.get(2) + runingInfo.getMemNum());
				//4.带宽
				total.set(3, total.get(3) + runingInfo.getBandwidth());
			}
			
		} finally {
			rLock.unlock();
		}
		Map<String, List<Double>> result = new HashMap<>();
		
		result.put("cpu",cpu);
		result.put("disk",disk);
		result.put("mem",mem);
		result.put("bandwidth",bandwidth);
		result.put("total",total);
		return Result.success(result);
	}

	@Override
	public void run() {
		//模拟采集数据
		int hostNum = 10;
		
		for(int i=0;i<hostNum;i++) {
			
			HostRuningInfo hostRuningInfo = new HostRuningInfo();
			hostRuningInfo.setHostName("gxqpt-00"+i);
			hostRuningInfo.setCpuCoreNum(8);
			hostRuningInfo.setDiskNum(500.0);
			hostRuningInfo.setMemNum(8.0);
			hostRuningInfo.setBandwidth(10.0);
			hostRuningInfos.add(hostRuningInfo );
		}
		
		while(true) {
			
			wLock.lock();
			try {
				for (HostRuningInfo hostRuningInfo : hostRuningInfos) {
					if(hostRuningInfo.getBandwidthUseNum().size() > maxHistoryNum) {
						//移除最老的数据   就是队列的头
						hostRuningInfo.getBandwidthUseNum().poll();
						hostRuningInfo.getDiskUseNum().poll();
						hostRuningInfo.getCpuUseNum().poll();
						hostRuningInfo.getMemUseNum().poll();
					}
					//加入最新数据    就是像队列的尾部追加数据
					hostRuningInfo.getBandwidthUseNum().addLast(Math.abs(0.5 - random.nextDouble())*hostRuningInfo.getBandwidth());
					hostRuningInfo.getDiskUseNum().addLast(((Math.abs(0.5 - random.nextDouble())/4)+0.55)*hostRuningInfo.getDiskNum());
					hostRuningInfo.getCpuUseNum().addLast(Math.abs(0.5 - random.nextDouble())*hostRuningInfo.getCpuCoreNum());
					hostRuningInfo.getMemUseNum().addLast(Math.abs(0.6 - random.nextDouble())*hostRuningInfo.getMemNum());
					
				}
			} finally {
				wLock.unlock();
			}
			try {
				
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				return ;
			}catch (Exception e) {
				
			}
		}
	}

	@Override
	@GetMapping("getHostLoadTop")
	@ApiOperation(value = "获取主机负载排名", notes = "获取主机负载排名")
	public Result<List<HostRuningDTO>> getHostLoadTop() {
		
		List<HostRuningDTO> result = new ArrayList<>();
		rLock.lock();
		try {

			for (HostRuningInfo runingInfo : hostRuningInfos) {
				HostRuningDTO host = new HostRuningDTO();
				host.setHostName(runingInfo.getHostName());
				host.setCpuUseRate(runingInfo.getCpuUseNum().peekLast()/runingInfo.getCpuCoreNum());
				host.setMemUseRate(runingInfo.getMemUseNum().peekLast()/runingInfo.getMemNum());
				host.setDiskUseRate(runingInfo.getDiskUseNum().peekLast()/runingInfo.getDiskNum());
				host.setBandwidthUseRate(runingInfo.getBandwidthUseNum().peekLast()/runingInfo.getBandwidth());
				result.add(host);
			}
		} finally {
			rLock.unlock();
		}
		Collections.sort(result);
		return Result.success(result);
	}
	
	
	@GetMapping("upload")
	@IgnoreAppToken
	@ApiOperation(value = "下载主机运行信息", notes = "下载主机运行信息")
	public String uploadHostRunInfo(HostRuningUpdateDTO hostRuningInfo) {
		
		System.out.println(hostRuningInfo);
		return "success";
	}
}

class  HostRuningInfo{
	
	private String hostName;
	//cup核数
	private Integer cpuCoreNum;
	//内存数量
	private Double memNum;
	//磁盘数量
	private Double diskNum;
	//带宽
	private Double bandwidth;
	/**
	 * cpu使用量=cpu利用率*cpu核数
	 */
	private LinkedList<Double> cpuUseNum = new LinkedList<>();
	/**
	 * 使用内存数量
	 */
	private LinkedList<Double> memUseNum = new LinkedList<>();
	/**
	 * 使用磁盘数量
	 */
	private LinkedList<Double> diskUseNum = new LinkedList<>();
	
	/**
	 * 使用带宽数量=使用率*带宽
	 */
	private LinkedList<Double> bandwidthUseNum = new LinkedList<>();

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Integer getCpuCoreNum() {
		return cpuCoreNum;
	}

	public void setCpuCoreNum(Integer cpuCoreNum) {
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

	public LinkedList<Double> getCpuUseNum() {
		return cpuUseNum;
	}

	public void setCpuUseNum(LinkedList<Double> cpuUseNum) {
		this.cpuUseNum = cpuUseNum;
	}

	public LinkedList<Double> getMemUseNum() {
		return memUseNum;
	}

	public void setMemUseNum(LinkedList<Double> memUseNum) {
		this.memUseNum = memUseNum;
	}

	public LinkedList<Double> getDiskUseNum() {
		return diskUseNum;
	}

	public void setDiskUseNum(LinkedList<Double> diskUseNum) {
		this.diskUseNum = diskUseNum;
	}

	public LinkedList<Double> getBandwidthUseNum() {
		return bandwidthUseNum;
	}

	public void setBandwidthUseNum(LinkedList<Double> bandwidthUseNum) {
		this.bandwidthUseNum = bandwidthUseNum;
	}

	@Override
	public String toString() {
		return "HostRuningInfo [hostName=" + hostName + ", cpuCoreNum=" + cpuCoreNum + ", memNum=" + memNum
				+ ", diskNum=" + diskNum + ", bandwidth=" + bandwidth + ", cpuUseNum=" + cpuUseNum + ", memUseNum="
				+ memUseNum + ", diskUseNum=" + diskUseNum + ", bandwidthUseNum=" + bandwidthUseNum + "]";
	}
}
