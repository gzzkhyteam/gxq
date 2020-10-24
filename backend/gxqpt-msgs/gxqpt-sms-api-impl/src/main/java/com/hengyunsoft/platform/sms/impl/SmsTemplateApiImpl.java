package com.hengyunsoft.platform.sms.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SmsExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.sms.dto.QuerySmsTemplateDTO;
import com.hengyunsoft.platform.sms.dto.SmsTemplateDTO;
import com.hengyunsoft.platform.sms.dto.SmsTemplateListDTO;
import com.hengyunsoft.platform.sms.entity.template.dos.QuerySmsTemplateDO;
import com.hengyunsoft.platform.sms.entity.template.dos.SmsTemplateListDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsTemplate;
import com.hengyunsoft.platform.sms.repository.template.example.TemplateExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsTemplateService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

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
public class SmsTemplateApiImpl{
	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
	private MsgsChannelService msgsChannelService;
	@Autowired
	private SmsTemplateService smsTemplateService;
	/**
	 * 新增短信模板
	 */
	@RequestMapping(value = "/api/smstemplate/add", method = RequestMethod.POST)
    @ApiOperation(value="新增短信模板",notes = "新增短信模板")
    @ApiResponses({
        @ApiResponse(code = 45100, message = "操作短信模板参数错误"),
        @ApiResponse(code = 45101, message = "短信模板渠道ID不能为空"),
        @ApiResponse(code = 45102, message = "短信模板内容不能为空"),
        @ApiResponse(code = 45103, message = "短信模板参数不能为空"),
        @ApiResponse(code = 45104, message = "短信模板编码不能为空"),
        @ApiResponse(code = 45105, message = "短信模板签名不能为空"),
        @ApiResponse(code = 45106, message = "短信模板名称不能为空"),
    })
	@ValidatorStandard(
			{
					@Constraint(value = SmsTemplate.class)
			}
	)
	public Result<String> addSmsTemplate(@RequestBody SmsTemplateDTO smsTemplateDTO) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_PARAM_ERROR,smsTemplateDTO);
        BizAssert.assertNotNull(SmsExceptionCode.SMS_CHANNELID_NULL,smsTemplateDTO.getChannelId());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_CONTENT_NULL,smsTemplateDTO.getContent());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATEPARAM_NULL,smsTemplateDTO.getTemplateParam());        
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATECODE_NULL,smsTemplateDTO.getTemplateCode());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_SIGNNAME_NULL,smsTemplateDTO.getSignName());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_NAME_NULL,smsTemplateDTO.getName());
        try {
        	SmsTemplate smsTemplate = dozerUtils.map(smsTemplateDTO, SmsTemplate.class);
            smsTemplate.setAppId(BaseContextHandler.getAppId());
            smsTemplate.setAppName(BaseContextHandler.getAppName());
            smsTemplate.setCreateTime(new Date());  
            smsTemplate.setCreateUser(BaseContextHandler.getAdminId());   
            smsTemplate.setCreateUserName(BaseContextHandler.getName());
            SmsTemplate result = smsTemplateService.save(smsTemplate);
            if(result!=null){
            	return Result.success("success");
            }    		
		} catch (Exception e) {
			log.error("新增短信模板出错",e);
			return Result.fail("新增短信模板出错");
		}
        return Result.fail("fail");
	}
	/**
	 * 新建发布短信模板
	 */
	@RequestMapping(value = "/api/smstemplate/listcreate", method = RequestMethod.POST)
    @ApiOperation(value="新建发布短信模板",notes = "新建发布短信模板")
	public Result<PageInfo<SmsTemplateDTO>> getSmsTemplateCreate(@RequestParam(value = "channelId") String channelId){
		try {
			Long userId = BaseContextHandler.getAdminId();
			TemplateExample smsTemplateExample = new TemplateExample();
			smsTemplateExample.createCriteria().andChannelIdEqualTo(channelId).andCreateUserEqualTo(userId);
			List<SmsTemplate> list = smsTemplateService.find(smsTemplateExample);
			List<SmsTemplateDTO> pageDate = dozerUtils.mapPage(list, SmsTemplateDTO.class);
			return Result.success(new PageInfo<>(pageDate));
		} catch (Exception e) {
			log.error("新建发布短信模板出错",e);
			return Result.fail("新建发布短信模板出错");
		}
	}
	/**
	 * 更新短信模板
	 */
    @RequestMapping(value = "/api/smstemplate/update", method = RequestMethod.POST)
    @ApiOperation(value="更新短信模板",notes = "更新短信模板")
    @ApiResponses({
        @ApiResponse(code = 45100, message = "操作短信模板参数错误"),
        @ApiResponse(code = 45101, message = "短信模板渠道ID不能为空"),
        @ApiResponse(code = 45102, message = "短信模板内容不能为空"),
        @ApiResponse(code = 45103, message = "短信模板参数不能为空"),
        @ApiResponse(code = 45104, message = "短信模板编码不能为空"),
        @ApiResponse(code = 45105, message = "短信模板签名不能为空"),
        @ApiResponse(code = 45106, message = "短信模板名称不能为空"),
        @ApiResponse(code = 45108, message = "短信模板ID不能为空"),
    })
	@ValidatorStandard(
			{
					@Constraint(value = SmsTemplate.class)
			}
	)
	public Result<String> updateSmsTemplate(@RequestBody SmsTemplateDTO smsTemplateDTO) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_PARAM_ERROR,smsTemplateDTO);
        BizAssert.assertNotNull(SmsExceptionCode.SMS_CHANNELID_NULL,smsTemplateDTO.getChannelId());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_CONTENT_NULL,smsTemplateDTO.getContent());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATEPARAM_NULL,smsTemplateDTO.getTemplateParam());        
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATECODE_NULL,smsTemplateDTO.getTemplateCode());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_SIGNNAME_NULL,smsTemplateDTO.getSignName());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_NAME_NULL,smsTemplateDTO.getName());
        BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATEID_NULL,smsTemplateDTO.getId());
        try {
        	SmsTemplate smsTemplate = dozerUtils.map(smsTemplateDTO, SmsTemplate.class);
            smsTemplate.setUpdateTime(new Date());   
            smsTemplate.setUpdateUser(BaseContextHandler.getAdminId().toString());
            int result = smsTemplateService.updateById(smsTemplate);
            if(result>0){
            	return Result.success("success");
            }
		} catch (Exception e) {
			log.error("更新短信模板出错",e);
			return Result.fail("更新短信模板出错");
		}       
		return Result.fail("fail");
	}
	/**
	 * 删除短信模板
	 */
    @RequestMapping(value = "/api/smstemplate/delete", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除短信模板", notes = "根据id删除短信模板")
    @ApiResponses({
            @ApiResponse(code = 45108, message = "短信模板ID为空"),
    })
	public Result<String> deleteSmsTemplate(@RequestParam(value = "id") Long id) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATEID_NULL,id);
		try {
			int result = smsTemplateService.deleteById(id);
	        if(result>0){
	        	return Result.success("success");
	        }
		} catch (Exception e) {
			log.error("删除短信模板出错",e);
			return Result.fail("删除短信模板出错");
		}
		return Result.fail("fail");
	}
	/**
	 * 获取短信模板信息列表
	 */
    @RequestMapping(value = "/api/smstemplate/list", method = RequestMethod.POST)
    @ApiOperation(value="获取分页列表",notes = "获取分页列表")
    @ApiResponses({
        @ApiResponse(code = 45100, message = "操作短信模板参数错误"),
    })
	public Result<PageInfo<SmsTemplateListDTO>> pageSmsTemplate(@RequestBody OpenApiReq<QuerySmsTemplateDTO> openApiReq) {
    	QuerySmsTemplateDTO querySmsTemplateDTO = openApiReq.getData();
		BizAssert.assertNotNull(SmsExceptionCode.SMS_PARAM_ERROR,querySmsTemplateDTO);
    	try {
    		String userId = BaseContextHandler.getAdminId().toString();
    		querySmsTemplateDTO.setUserId(userId);
    		String name = querySmsTemplateDTO.getName();
    		String code = querySmsTemplateDTO.getTemplateCode();
    		/*if(!StringUtils.isEmpty(name)){
    			querySmsTemplateDTO.setName("%"+name.trim()+"%");
    		}
    		if(!StringUtils.isEmpty(code)){
    			querySmsTemplateDTO.setTemplateCode("%"+code.trim()+"%");
    		}*/
    		QuerySmsTemplateDO querySmsTemplateDO = dozerUtils.map(querySmsTemplateDTO, QuerySmsTemplateDO.class);
    		PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
    		List<SmsTemplateListDO> list = smsTemplateService.getSmsTemplateList(querySmsTemplateDO);
    		List<SmsTemplateListDTO> result = dozerUtils.mapList(list, SmsTemplateListDTO.class);
    		return Result.success(new PageInfo<>(result));
		} catch (Exception e) {
			log.error("获取短信模板信息列表出错",e);
			return Result.fail("获取短信模板信息列表出错");
		}		
	}
	/**
	 * 获取短信模板信息详情
	 */
    @RequestMapping(value = "/api/smstemplate/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取短信模板信息详情", notes = "获取短信模板信息详情")
    @ApiResponses({
            @ApiResponse(code = 45108, message = "短信模板ID为空"),
    })
	public Result<SmsTemplateDTO> getSmsTemplateDetail(@RequestParam(value = "id") Long id) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_TEMPLATEID_NULL,id);
		try {
			SmsTemplate smsTemplate = smsTemplateService.getById(id);
			if(smsTemplate == null){
				return null;
			}
			String channelId = smsTemplate.getChannelId();
			MsgsChannel msgsChannel = null;
			if(!StringUtils.isEmpty(channelId)){
				msgsChannel = msgsChannelService.getById(Long.parseLong(channelId));
			}
			SmsTemplateDTO smsTemplateDTO = dozerUtils.map(smsTemplate,SmsTemplateDTO.class);
			if(msgsChannel!=null){
				smsTemplateDTO.setChannelName(msgsChannel.getName());
			}
			return Result.success(smsTemplateDTO);
		} catch (Exception e) {
			log.error("获取短信模板信息详情出错",e);
			return Result.fail("获取短信模板信息详情出错");
		}		
	}
    /**
     * 获取某个渠道下的模板列表
     * @return
     */
    @RequestMapping(value = "/api/smstemplate/channellist", method = RequestMethod.GET)
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
