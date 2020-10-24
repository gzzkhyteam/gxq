package com.hengyunsoft.platform.developer.impl.core;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.BaseTest;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationUpdateDTO;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplyAuditDTO;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplySaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserManagerReqDTO;
import org.junit.After;
import org.junit.Before;
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

/**
 * 描述:应用/服务管理单元测试
 *
 * @author wz
 * @date 2018/4/9 17:55
 */
public class ApplicationApiImplTest extends BaseTest {
    @Before
    public void before() throws Exception {
        /*
         * 测试方法 6部曲
         * 1，针对每一个具体Controller层类，创建一个测试类，继承BaseTest
         * 2，对Controller层中每个public方法，增加一个测试方法（testXxx）
         * 3，构造模拟uri，并且 配置好参数，请求头等信息
         * 4，模拟执行请求
         * 5，对执行结果进行断言
         * 6，打印一些返回值 [可选]
         * */
    }

    @After
    public void after() throws Exception {
    }

    private String appId = "1234567";

    /**
     * 应用列表查询
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testFind() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/application/find");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 应用管理员查询
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testPageAppManager() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/application/pageAppManager");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        OpenApiReq<UserManagerReqDTO> openApiReq = new OpenApiReq<>();
        openApiReq.setPageNo(1);
        openApiReq.setPageSize(5);
        openApiReq.setData(new UserManagerReqDTO());
        openApiReq.getData().setAppId(appId);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(openApiReq));
        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 应用管理员维护(关联)
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testSaveAppManager() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/application/saveAppManager");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("userId", "1");
        mockHsrBuilder.param("appId", "1234567");
        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 应用管理员维护(取消关联)
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testDeleteAppManager() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.delete("/application/deleteAppManager");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("userId", "1");
        mockHsrBuilder.param("appId", "zkhyXpQXsFjF");
        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 添加应用(申请栈)
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testSaveApply() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/application/saveApply");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        ApplicationApplySaveDTO saveDTO = new ApplicationApplySaveDTO();
        saveDTO.setName("测试应用bug");
        saveDTO.setAppType((short) 1);
        saveDTO.setType("gxyy");
        saveDTO.setStatus(false);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(saveDTO));
        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }
    /**
     * 添加应用(审核栈)
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testSave() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/application/saveApp");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        ApplicationApplyAuditDTO saveDTO = new ApplicationApplyAuditDTO();
        saveDTO.setId(1483856674881l);
        saveDTO.setApplyStatus((short)2);
        saveDTO.setAuditDesc("通过");
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(saveDTO));
        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 应用详情查询
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testGetDetails() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/application/getDetails");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("id", "14");

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    /**
     * 应用信息修改
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testUpdateApp() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.put("/application/updateApp");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        ApplicationUpdateDTO updateDTO = new ApplicationUpdateDTO();
        updateDTO.setId(14l);
        updateDTO.setName("修改一个新应用");
        updateDTO.setAppType((short) 0);
        updateDTO.setStatus(false);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(updateDTO));
        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);

        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.errmsg").value("ok")); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        resultActions.andExpect(jsonPath("$.data").value(true)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/

        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        resultActions.andDo(MockMvcResultHandlers.print());

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);
    }
}
