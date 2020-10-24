package com.hengyunsoft.commons.converter;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hengyunsoft.commons.utils.XssUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于xss的JsonSerializer
 * 只做序列化，不做反序列化， 数据库存的还是有问题的值， 但返回给前端是解析过的。
 *
 * @author tangyh
 * @date 2019/06/28
 */
public class XssStringJsonSerializer extends JsonSerializer<String> {
    private final static Logger log = LoggerFactory.getLogger(XssStringJsonSerializer.class);

    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            try {
                String encodedValue = XssUtils.xssClean(value, Arrays.asList("@gygxq.com"));
                jsonGenerator.writeString(encodedValue);
            } catch (Exception e) {
                log.error("序列化失败:[{}]", value, e);
            }
        }
    }
}
