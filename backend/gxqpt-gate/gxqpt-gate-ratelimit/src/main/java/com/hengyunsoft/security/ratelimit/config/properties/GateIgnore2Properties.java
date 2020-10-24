package com.hengyunsoft.security.ratelimit.config.properties;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/03
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(GateIgnore2Properties.PREFIX)
//@Configuration
public class GateIgnore2Properties {
    public static final String PREFIX = "gate.ignore";
    private List<String> startWithList = Lists.newArrayList();
}
