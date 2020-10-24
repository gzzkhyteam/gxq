package com.hengyunsoft.platform.developer.utils;

import java.math.BigDecimal;

/**
 * 击中算法
 * @author sxy
 *
 */
public class PlatformUtil {
	
	private BigDecimal weight;

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public  boolean isHit(double random) {
		double probability = this.weight == null ? 100d : ((BigDecimal) this.weight)
				.doubleValue() * 100;
		if (Double.compare(0.0d, probability) != 0) {
			if (Double.compare(Math.floor(random * (100d / probability)), 0.0d) == 0) {
				return true;
			}
		}
		return false;
	}
}
