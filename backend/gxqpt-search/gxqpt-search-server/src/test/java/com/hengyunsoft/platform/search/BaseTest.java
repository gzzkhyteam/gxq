package com.hengyunsoft.platform.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.platform.GxqptSearchApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(value = SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GxqptSearchApplication.class)
@AutoConfigureMockMvc
public class BaseTest {
    protected String appId = "25kj6355";
    protected String collectionCode = "test";
    protected String collectionName = "这是一个测试";

    @Autowired
    protected MockMvc mvc;
    protected String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxIiwiYXBwSWQiOiIxMDAwMCIsImV4cCI6MTUyMTAxNDQwMH0.fsSFoYdZAC5hNm91288A76RoS6AiTR0i-WGE-tSviyyzGKTdafib3xK3DgEaLu0t1FS-Y3INHG64BRipPFsiM0nHAlTlDEwdXDjC5gHqH-UFCWRrhV5cpE2ihdsm3jqBwD-hX0rP1bzYlByahDLuOhF-devzknwbYoBZ4bkcrFM";
    @Autowired
    RedisTemplate redisTemplate;

    @Before
    public void setBefore() {
        //RedisTemplate<String, String> REDIS_TEMPLATE = SpringUtil.getBean("redisTemplate", RedisTemplate.class);
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        token = hashOperations.get("dev:gxqpt-auth-server:app:token:35kj6351", "1");
        System.out.println("token=" + token);
    }


    protected MockHttpServletRequestBuilder builderRequestParamMock(String uri, Object... uriVars) {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get(uri, uriVars);
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        return mockHsrBuilder.header("token", this.token);
    }

    protected MockHttpServletRequestBuilder builderRequestBodyMock(String uri, Object... uriVars) {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get(uri, uriVars);
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON);
        return mockHsrBuilder.header("token", this.token);
    }

    protected ResultActions andExpect(MockHttpServletRequestBuilder mockHsrBuilder) throws Exception {
        //ResultActions.andExpect添加执行完成后的断言
        return mvc.perform(mockHsrBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.errcode").value(0));
    }

    protected MvcResult mvcResult(ResultActions resultActions) throws Exception {
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        JSONObject res = JSON.parseObject(result);
        System.out.println("result = " + result);
        return mvcResult;
    }
}
