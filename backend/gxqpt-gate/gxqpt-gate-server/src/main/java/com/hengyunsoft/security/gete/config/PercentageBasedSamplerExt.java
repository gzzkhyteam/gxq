package com.hengyunsoft.security.gete.config;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.sampler.PercentageBasedSampler;
import org.springframework.cloud.sleuth.sampler.SamplerProperties;

public class PercentageBasedSamplerExt extends PercentageBasedSampler implements Sampler {


	public PercentageBasedSamplerExt(SamplerProperties configuration) {
		super(configuration);
	}
	
	@Override
	public boolean isSampled(Span currentSpan) {
		
		if(currentSpan.getTraceId()==currentSpan.getSpanId()) {
			//只有跟节点加入appid   调用端标志
			currentSpan.tag("app_id", "25748995");
			currentSpan.setBaggageItem("app_id", "25748995");
		}
		return super.isSampled(currentSpan) && doIsSampled(currentSpan);
	}

	private boolean doIsSampled(Span currentSpan) {
//		System.out.println("----------------------------------------------------------------");
//		System.out.println(currentSpan.toString());
//		System.out.println(currentSpan.getBaggage());
//		System.out.println(currentSpan.tags());
//		System.out.println("---------------------------------"+currentSpan.getTraceId()+"-------------------------------");
		//可以通过tags或Baggage来判断是否需要将此数据记录到zikpin中   这里暂时先允许全部记录
		return true;
	}
}
