package com.hengyunsoft.platform.developer.impl.apply;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.BaseTest;
import com.hengyunsoft.platform.developer.api.apply.dto.ApplyQueryDTO;
import com.hengyunsoft.utils.JSONUtils;

public class ApplyManagerApiImplTest extends BaseTest {

	@Test
	public void listApply() throws Exception {

		token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxIiwibmFtZSI6IuW8oDMiLCJhcHBJZCI6IjI1a2o2MzU1IiwiZXhwIjoxNTIzNTgxNDUyfQ.d0ez9JVAKRu2lDfTXHrgNUwwtO-sYH2Lta2tc_v9njLP4wqVWY6Tp2z5rYhtzgAR6GjDW9ZQC6-imMr5ABOh6Ik4FaR8cYFhZIUhIQszMjlPxyYUAreEA_p7g2FzcjunigBTOtWrAsZJIHTZinXNNTKor8045TlGK3XoMStm4JA";
		MockHttpServletRequestBuilder mockHsrBuilder = MockMvcRequestBuilders.post("/applyManager/listApply");
		mockHsrBuilder.accept(MediaType.APPLICATION_JSON_VALUE);
		mockHsrBuilder.header("token", token);
		mockHsrBuilder.contentType(MediaType.APPLICATION_JSON);
		OpenApiReq<ApplyQueryDTO> obj = new OpenApiReq<ApplyQueryDTO>();
		obj.setPageNo(1);
		obj.setPageSize(10);
		ApplyQueryDTO data = new ApplyQueryDTO();
		obj.setData(data );
		putObj(mockHsrBuilder,obj);

		// mockMvc.perform执行一个请求；
		// resultAction是用来模拟客户端请求
		ResultActions resultActions = mvc.perform(mockHsrBuilder);
		
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("result = " + result);
		// ResultActions.andExpect添加执行完成后的断言
		resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 断言返回请求是否响应200
		resultActions.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)); // 验证响应contentType
		resultActions.andExpect(jsonPath("$.errcode").value(0)); // 使用Json path验证JSON
																	// 请参考http://goessner.net/articles/JsonPath/
		resultActions.andExpect(jsonPath("$.errmsg").value("ok")); // 使用Json path验证JSON
																	// 请参考http://goessner.net/articles/JsonPath/

		// ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
		resultActions.andDo(MockMvcResultHandlers.print());

//		// ResultActions.andReturn表示执行完成后返回相应的结果。
//		MvcResult mvcResult = resultActions.andReturn();
//		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("result = " + result);
	}

	private void putObj(MockHttpServletRequestBuilder mockHsrBuilder, Object obj) {
		
		if(obj instanceof String) {
			mockHsrBuilder.content((String)obj);
		} else {
			
			mockHsrBuilder.content(JSONUtils.toJsonString(obj));
		}
	}

}
