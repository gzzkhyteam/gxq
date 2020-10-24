package com.hengyunsoft.platform.mt.application;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.BaseTest;
import com.hengyunsoft.platform.mt.api.application.dto.AuditAppReqDTO;
import com.hengyunsoft.platform.mt.api.application.dto.CreateAppFirstReqDTO;
import com.hengyunsoft.platform.mt.api.application.dto.QueryApplicationParamDTO;
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

public class ApplicationApiImplTest extends BaseTest {

    @Test
    public void testCreateAppFirst() throws Exception {
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/appmanager/createAppFirst");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", this.token);
        mockHsrBuilder.header("_user_id", 1);

        //设置请求参数
        CreateAppFirstReqDTO dto = new CreateAppFirstReqDTO();
        dto.setAppDesc("这是一个测试");
        dto.setAppName("测试的");
        dto.setAppPath("/test/test");
        dto.setIconPath("test.jpg");
        dto.setIsShow(1);
        dto.setState(1);
        dto.setAppType(2);
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
    public void createAppSecond() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        //OpenApiReq<QueryApplicationParamDTO> openApiReq
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/appmanager/find");
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
    public void getAppBaseInfo() throws Exception {
        //Long id
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/appmanager/getAppBaseInfo");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("id", "1938783469601");

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
    public void testAuditApp() throws Exception {
        //AuditAppReqDTO dto
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/appmanager/auditApp");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", this.token);
        mockHsrBuilder.header("_user_id", 1);

        //设置请求参数
        AuditAppReqDTO dto = new AuditAppReqDTO();
       dto.setAuditContent("好的不错");
       dto.setId(1938783469601L);
        dto.setState(3);
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
}
