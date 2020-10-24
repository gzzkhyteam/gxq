package com.hengyunsoft.platform.developer.impl.core;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.BaseTest;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallLikeResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallSaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallUpdateDTO;
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
 * 描述:应用/服务部署单元测试
 *
 * @author wz
 * @date 2018/4/9 17:55
 */
public class ApplicationHostInstallApiImplTest extends BaseTest {
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

    private String appId = "zkhyXpQXsFjF";

    /**
     * 应用部署分页查询
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testPage() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/hostInstall/page");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        OpenApiReq<HostInstallLikeResDTO> openApiReq = new OpenApiReq<>();
        openApiReq.setPageNo(1);
        openApiReq.setPageSize(5);
        openApiReq.setData(new HostInstallLikeResDTO());
        appId = "1234567l";
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
     * 删除部署
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testDelete() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.delete("/hostInstall/delete");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        //设置一些预置信息
        Long id = 866211856417l;
        mockHsrBuilder.param("id", id.toString());
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
     * 新增部署
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testSave() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/hostInstall/save");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);

        //一些实体预置信息
        Long hostId = 1234567l;

        HostInstallSaveDTO saveDTO = new HostInstallSaveDTO();
        saveDTO.setAppId(appId);
        saveDTO.setHostId(hostId);
        saveDTO.setMem(1);
        saveDTO.setHarddisk(1);
        saveDTO.setIndexUrl("192.168.0.1");
        saveDTO.setInstallPath("c://");
        saveDTO.setVersion("1.1.1");
        saveDTO.setRemark("备注1");
        saveDTO.setStatus(0);
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
     * 部署详情查询
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testGet() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.get("/hostInstall/get");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
        mockHsrBuilder.param("id", "866211856417");

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
     * 部署信息修改
     *
     * @return
     * @auther:wz
     */
    @Test
    public void testUpdate() throws Exception {
        MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.put("/hostInstall/update");
        mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
        mockHsrBuilder.header("token", token);
//      设置一些预置信息
        Long hostInstallId = 866211856417l;
        Long hostId = 1040858480705l;
        Integer mem = 20;
        Integer harddisk = 5;
        String installPath = "d://";
        String indexUrl = "192.168.1.1";
        String remark = "备注2";

        HostInstallUpdateDTO updateDTO = new HostInstallUpdateDTO();
        updateDTO.setId(hostInstallId);
        updateDTO.setHostId(hostId);
        updateDTO.setMem(mem);
        updateDTO.setHarddisk(harddisk);
        updateDTO.setInstallPath(installPath);
        updateDTO.setIndexUrl(indexUrl);
        updateDTO.setRemark(remark);

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
