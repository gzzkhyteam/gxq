package com.hengyunsoft.platform.security;

import java.util.LinkedHashMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.hengyunsoft.cas.sso.ext.CasConfigure;

@ConfigurationProperties("multiplecas")
@Component
public class MultipleCasConfigure {

	private LinkedHashMap<String,CasConfigure> casConfigure;
	
	public LinkedHashMap<String,CasConfigure> getCasConfigure() {
		return casConfigure;
	}

	public void setCasConfigure(LinkedHashMap<String,CasConfigure> casConfigure) {
		this.casConfigure = casConfigure;
	}
}
