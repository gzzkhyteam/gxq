package com.hengyunsoft.platform.file;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/**
 * @BeforeClass 全局只会执行一次，而且是第一个运行
 * @Before 在测试方法运行之前运行
 * @Test 测试方法
 * @After 在测试方法运行之后允许
 * @AfterClass 全局只会执行一次，而且是最后一个运行
 * @Ignore 忽略此方法
 * <p>
 * MockMvc讲解
 * https://www.cnblogs.com/xd03122049/p/6001457.html
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoMockMvcTest {

    //Spring提供的测试类
    @Autowired
    private MockMvc mvc;
    String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxIiwiYXBwSWQiOiIxMDAwMCIsImV4cCI6MTUyMTAxNDQwMH0.fsSFoYdZAC5hNm91288A76RoS6AiTR0i-WGE-tSviyyzGKTdafib3xK3DgEaLu0t1FS-Y3INHG64BRipPFsiM0nHAlTlDEwdXDjC5gHqH-UFCWRrhV5cpE2ihdsm3jqBwD-hX0rP1bzYlByahDLuOhF-devzknwbYoBZ4bkcrFM";

    //@Before
    public void setBefore() {
        //RedisTemplate<String, String> REDIS_TEMPLATE = SpringUtil.getBean("redisTemplate", RedisTemplate.class);
        //HashOperations<String, String, String> hashOperations = REDIS_TEMPLATE.opsForHash();
        //hashOperations.get("dev:zuihou-auth-server:app:token:10000", "1");
    }

    /**
     * 接口的参数使用 @RequestBody 的，用这种方式
     *
     * @throws Exception
     */
    @Test
    public void testRequestBody() throws Exception {
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/file/test1");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.contentType(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        JSONObject reqPar = new JSONObject();
        reqPar.put("parentId", "2");
        reqPar.put("submittedFileName", "");
        reqPar.put("orderNum", "4");
        mockHsrBuilder.content(reqPar.toString());

        //mockMvc.perform执行一个请求；
        //resultAction是用来模拟客户端请求
        ResultActions resultActions = mvc.perform(mockHsrBuilder);
        //ResultActions.andExpect添加执行完成后的断言
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); //断言返回请求是否响应200
        resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); //验证响应contentType
        resultActions.andExpect(jsonPath("$.errcode").value(0)); //使用Json path验证JSON 请参考http://goessner.net/articles/JsonPath/
        //ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        //resultActions.andDo();

        //ResultActions.andReturn表示执行完成后返回相应的结果。
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result = " + result);

        //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
    }

    /**
     * 接口的参数使用 @RequestParam 或者 没有注解的 的，用这种方式
     *
     * @throws Exception
     */
    @Test
    public void testRequestParam() throws Exception {
        //MockMvcRequestBuilders.get|post|put|delete:构造一个请求.根据接口定义调用不用的方法
        //根据uri模板和uri变量值得到一个GET请求方式的MockHttpServletRequestBuilder；如get("/user/{id}", 1L)；
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/file/test2");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("pageNo", "1");
        mockHsrBuilder.param("pageSize", "20");
        mockHsrBuilder.param("folderId", "1");
        mockHsrBuilder.param("submittedFileName", "2");
        mockHsrBuilder.param("dataType", "3");

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
