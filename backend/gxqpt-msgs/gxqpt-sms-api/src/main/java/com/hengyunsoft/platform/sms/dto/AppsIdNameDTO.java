package com.hengyunsoft.platform.sms.dto;

import java.util.List;

import lombok.Data;

@Data
public class AppsIdNameDTO {
	private List<String> appIds;
	private List<String> appNames;
}
