package com.hengyunsoft.validator.web;

import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.hengyunsoft.validator.FieldValidatorDesc;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import com.hengyunsoft.validator.extract.IConstraintExtract;

/**
 * 
 * 统一获取校验规则入口。<br>
 * <br>
 * 加入了一个前端验证接口控制器，专门处理所有的拉取表单验证规则的请求。<br>
 * 在拉取表单验证规则的时候，有两种拉取方式<br>
 * 第一种如下（通过路径变量来传输要拉取的uri路径） ：<br>
 * A表单的保存url为       http://2.8.1.1:3/porjectName/role/save <br>
 * 那么A表单的验证url：http://2.8.1.1:3/porjectName/from<font color="red">/validator/role</font>/save <br>
 * <br>
 * 仅仅追加了<font color="red">/from/validator/</font>而已。<br>
 * <br>
 * 第二种如下是（通过参数传递uri路径的方式来拉取）：<br>
 * 表单保存url ：    <br>
 * http://2.8.1.1:3/porjectName/role/save <br>
 * 那么验证url：<br/>
 * http://2.8.1.1:3/porjectName/from/validator?fromPath=/porjectName/role/save <br>
 *<br>
 * 固定了验证uri地址，而要验证的表单地址作为参数进行传输。当然，可以一次性拿多个表单验证地址。有些界面可能同时存在多个表单需要提交。
 *<br>
 * @author 潘定遥
 *
 */
public class FromValidatorStandard {

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	@Autowired
	private IConstraintExtract constraintExtract;
	
	/**
	 * 支持第二种拉取方式
	 * @param fromPath
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("from/validator")
	public @ResponseBody Collection<FieldValidatorDesc> standardByQueryParam(String fromPath,HttpServletRequest request) throws Exception{
		
		HandlerExecutionChain chains = requestMappingHandlerMapping.getHandler(new HttpServletRequestValidatorWrapper(request, fromPath));
		HandlerMethod method = (HandlerMethod) chains.getHandler();
		ValidatorStandard validatorStandard = method.getMethodAnnotation(ValidatorStandard.class);
		if(validatorStandard == null) {
			return Collections.EMPTY_LIST;
		}
		
		Constraint[] constraints = validatorStandard.value();
		if(constraints == null) {
			return Collections.EMPTY_LIST;
		}
		return constraintExtract.extract(constraints);
	}
	
	/**
	 * 支持第一种拉取方式
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"from/validator/{part1}","from/validator/{part1}/{part2}","from/validator/{part1}/{part2}/{part3}"
		,"from/validator/{part1}/{part2}/{part3}/{part4}","from/validator/{part1}/{part2}/{part3}/{part4}/{part5}","from/validator/{part1}/{part2}/{part3}/{part4}/{part5}/{part6}"
		,"from/validator/{part1}/{part2}/{part3}/{part4}/{part5}/{part6}/{part7}"
		,"from/validator/{part1}/{part2}/{part3}/{part4}/{part5}/{part6}/{part7}/{part8}"
		,"from/validator/{part1}/{part2}/{part3}/{part4}/{part5}/{part6}/{part7}/{part8}/{part9}"
		,"from/validator/{part1}/{part2}/{part3}/{part4}/{part5}/{part6}/{part7}/{part8}/{part9}/{part10}"})
	public @ResponseBody Collection<FieldValidatorDesc> standardByPathVar(HttpServletRequest request) throws Exception{
		
		
		String requestUri = request.getRequestURI();
		String fromPath = requestUri.substring(requestUri.indexOf("from/validator")).substring("from/validator".length());
		HandlerExecutionChain chains = requestMappingHandlerMapping.getHandler(new HttpServletRequestValidatorWrapper(request, fromPath));
		HandlerMethod method = (HandlerMethod) chains.getHandler();
		ValidatorStandard validatorStandard = method.getMethodAnnotation(ValidatorStandard.class);
		if(validatorStandard == null) {
			return Collections.EMPTY_LIST;
		}
		
		Constraint[] constraints = validatorStandard.value();
		if(constraints == null) {
			return Collections.EMPTY_LIST;
		}
		return constraintExtract.extract(constraints);
	}
}
