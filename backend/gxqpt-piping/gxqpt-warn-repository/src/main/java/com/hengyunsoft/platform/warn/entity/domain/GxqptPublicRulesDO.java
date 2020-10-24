package com.hengyunsoft.platform.warn.entity.domain;

import lombok.Data;

@Data
public class GxqptPublicRulesDO {
    private String source;
    private String target;
    private Float confirmed;
    private Float processed;
}
