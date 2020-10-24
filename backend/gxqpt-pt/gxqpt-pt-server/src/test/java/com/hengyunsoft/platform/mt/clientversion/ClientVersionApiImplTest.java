package com.hengyunsoft.platform.mt.clientversion;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.BaseTest;
import com.hengyunsoft.platform.mt.api.application.dto.QueryApplicationParamDTO;
import com.hengyunsoft.platform.mt.api.version.dto.CreateVersionParamDTO;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ClientVersionApiImplTest extends BaseTest {
    @Test
    public void createVersion() throws Exception {
        //CreateVersionParamDTO dto
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/clientVersion/createVersion");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", this.token);

        //设置请求参数
        CreateVersionParamDTO dto = new CreateVersionParamDTO();
        dto.setApkFileId("adfafasdfa");
        dto.setApkFileName("adsdfa.apk");
        dto.setApkFilePath("/test/adsdfa.apk");
        dto.setPwUpdate(1);
        dto.setUpdateContent("测试的");
        dto.setVerName("测试的1.1.1");
        dto.setVerNumber(1);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(dto));

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        // resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    @Test
    public void testFind() throws Exception {
        //OpenApiReq<QueryClientVersionParamDTO> openApiReq
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/clientVersion/find");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", this.token);

        //设置请求参数
        OpenApiReq<QueryApplicationParamDTO> dto = new OpenApiReq();
        dto.setPageNo(1);
        dto.setPageSize(10);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(dto));

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        // resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    @Test
    public void testPublishVersion() throws Exception {
        //Long id
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/clientVersion/publishVersion");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("id", "990371643425");

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);
        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        //resultActions.andDo();

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);

    }

    @Test
    public void testGetBaseInfo() throws Exception {
        //Long id
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/clientVersion/getBaseInfo");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("id", "990371643425");

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);
        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        //resultActions.andDo();

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }
}
