package com.hengyunsoft.platform.search.impl;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.platform.search.BaseTest;
import com.hengyunsoft.platform.search.dto.CollectionDTO;
import com.hengyunsoft.platform.search.dto.OptCollection2AppDTO;
import org.junit.After;
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

public class AdminApiImplTest extends BaseTest {
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

    @Test
    public void showMyCollection() throws Exception {
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/adminModule/showMyCollection");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);

        //设置请求参数
        // CollectionDTO dto = new CollectionDTO();
        // mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSONObject.toJSONString(dto));

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
    public void appointCollection2App() throws Exception {
        //url和header
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/adminModule/appointCollection2App");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        //设置请求参数
        String param = "";
        OptCollection2AppDTO dto = new OptCollection2AppDTO();
        dto.setCollectionId(1L);
        dto.setAppId(appId);
        dto.setOpt(3);
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

    /***
     * 接口的参数使用 @RequestParam 或者 没有注解的 的，用这种方式
     * @throws Exception
     */
    @Test
    public void showCollectionApp() throws Exception {
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/adminModule/showCollectionApp");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("collectionId", "1");

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

        //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
    }

    @Test
    public void getColleAppIpOpt() throws Exception {
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/adminModule/getColleAppIpOpt");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("collectionId", "1");
        mockHsrBuilder.param("appId", appId);
       /* mockHsrBuilder.param("pageSize", "20");
        mockHsrBuilder.param("folderId", "1");
        mockHsrBuilder.param("submittedFileName", "2");
        mockHsrBuilder.param("dataType", "3");*/

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

        //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
    }
}
