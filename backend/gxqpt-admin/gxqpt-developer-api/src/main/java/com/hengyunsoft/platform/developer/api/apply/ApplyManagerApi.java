package com.hengyunsoft.platform.developer.api.apply;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.apply.dto.*;
import com.hengyunsoft.platform.developer.api.core.api.hystrix.ApplicationApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
		path = "/api/admin", fallback = ApplicationApiHystrix.class)
public interface ApplyManagerApi {
     
	/**
	 * 获取我的任务列表
	 * 包含：  新增应用申请    新增功能申请    调用功能申请
	 *      新增应用审批    新增功能审批    调用功能审批
	 * @param openApiReq
	 * @return
	 */
	@RequestMapping(value="/applyManager/listApply",method=RequestMethod.POST)
	Result<PageInfo<ApplyDTO>> pageListApply(@RequestBody  OpenApiReq<ApplyQueryDTO> openApiReq);

	/**
	 * 获取我的任务中对应的详情
	 * */
	@RequestMapping(value="/applyManager/getApplyDetail",method=RequestMethod.POST)
	Result<ApplyQueryDetailDTO> getApplyDetail(@RequestBody ApplyDetailDTO applyDetailDTO);

	/**
	 * 获取审批内容
	 * */
	@RequestMapping(value="/applyManager/updateByAudit",method=RequestMethod.POST)
	Result<String> updateByAudit(@RequestBody ApplyUpdateDTO applyUpdateDTO);

}
