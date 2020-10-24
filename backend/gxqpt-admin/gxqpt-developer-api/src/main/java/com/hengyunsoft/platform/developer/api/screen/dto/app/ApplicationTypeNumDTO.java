package com.hengyunsoft.platform.developer.api.screen.dto.app;

import lombok.Data;

@Data
public class ApplicationTypeNumDTO {
    private Integer app;
    private Integer service;
    private Integer module;
    private Integer platform;

    public ApplicationTypeNumDTO() {
        app = 0;
        service = 0;
        module = 0;
        platform = 0;
    }
}
