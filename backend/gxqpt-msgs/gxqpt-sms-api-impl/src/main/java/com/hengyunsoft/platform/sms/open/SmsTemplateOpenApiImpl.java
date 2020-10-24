package com.hengyunsoft.platform.sms.open;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.SmsExceptionCode;
import com.hengyunsoft.platform.sms.repository.template.service.SmsTemplateService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * 短信模板服务
 * @author dxz
 */
@RestController
@Slf4j
@Api(value = "短信模板服务", description = "短信模板服务")
public class SmsTemplateOpenApiImpl implements SmsTemplateOpenApi{
	@Autowired
	private SmsTemplateService smsTemplateService;
	
    /**
     * 获取某个渠道下的模板列表
     * @return
     */
	@Override
    @ApiOperation(value = "获取某个渠道下的模板列表", notes = "获取某个渠道下的模板列表")
    @ApiResponses({
            @ApiResponse(code = 45100, message = "操作短信模板参数错误"),
    })
	public Result<List<Map<String,Object>>> getSmsTemplateChannelList(@RequestParam(value = "channelid") String channelid) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_PARAM_ERROR,channelid);
		try {
			List<Map<String, Object>> list = smsTemplateService.getTemplateByChannelId(Long.parseLong(channelid));
			if(list!=null&&list.size()!=0){
				return Result.success(list);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取某个渠道下的模板列表出错",e);
			return Result.fail("获取某个渠道下的模板列表出错");
		}
	}
}
