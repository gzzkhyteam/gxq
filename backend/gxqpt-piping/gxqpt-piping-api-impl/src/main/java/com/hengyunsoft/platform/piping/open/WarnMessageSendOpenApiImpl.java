package com.hengyunsoft.platform.piping.open;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.platform.piping.api.msgs.dto.*;
import com.hengyunsoft.platform.piping.constant.MessageConstant;
import com.hengyunsoft.platform.piping.repository.service.GxqptPingpingWarnTypeService;
import com.hengyunsoft.platform.piping.utils.JSONUtils;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/p/warnmsg")
@Slf4j
@Api(value = "API - WarnMessageSendApiImpl", description = "预警管道服务")
@WarnSendModule
public class WarnMessageSendOpenApiImpl implements WarnMessageSendOpenApi {
	@Autowired 
    private RabbitTemplate rabbitTemplate;
	@Autowired
	private GxqptPingpingWarnTypeService gxqptPingpingWarnTypeService;

	@Value("${spring.redis.key-prefix:dev}")
	private String keyPrefix;

	/**
	 * 发送预警信息到消息队列（rabbitMq）
	 * @param warnMessageDto
	 * @return
	 */
	@Override
	@ApiOperation(value="发送预警信息到消息队列（rabbitMq）",notes = "发送预警信息到消息队列（rabbitMq）")
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public Result<String> send(@RequestBody WarnMessageDTO warnMessageDto){

		String type = warnMessageDto.getType();
		Long typeId = warnMessageDto.getTypeId();
		String title = warnMessageDto.getTitle();
		String callbackUrl = warnMessageDto.getCallbackUrl();
		Integer level = warnMessageDto.getLevel();
		Boolean isHandle = warnMessageDto.getIsHandle();
		String content = warnMessageDto.getContent();
		List<HandlerDTO> handler = warnMessageDto.getHandler();
		List<DutyDTO> duty = warnMessageDto.getDuty();
		List<CsrDTO> csr = warnMessageDto.getCsr();
		DutyNameDTO dutyName = warnMessageDto.getDutyName();
		if(StringUtils.isEmpty(title)){
			return Result.fail("预警标题不能为空");
		}
		if(StringUtils.isEmpty(content)){
			return Result.fail("预警内容不能为空");
		}
//		if (StringUtils.isEmpty(callbackUrl)){
//			return Result.fail("应用地址不能为空");
//		}
		if (typeId == null){
			return Result.fail("预警类型id不能为空");
		}
		if (StringUtils.isEmpty(type)){
			return Result.fail("预警类型不能为空");
		}
		if (level == null){
			return Result.fail("预警级别不能为空");
		}else if (level != 1&&level != 2&&level != 3&&level != 4){
			return Result.fail("预警级别传入参数错误（预警级别的值只能为1、2、3、4）");
		}
		if (isHandle == null){
			return Result.fail("平台是否可处理不能为空");
		}
		//判断确认人是否为空
		if(handler == null){
			return Result.fail("确认人不能为空");
		}
		for (int i=0;i<handler.size();i++){
			if (handler.get(i).getHandlerLeve() == null||handler.get(i).getHandlerLeve() == 0 ){
				return Result.fail("确认人级别handlerLeve不能为空");
			}else if (handler.get(i).getRecName() == null||handler.get(i).getRecName() == ""){
				return Result.fail("确认人名称recName不能为空");
			}else if (handler.get(i).getUserId() == null||handler.get(i).getUserId() == 0){
				return Result.fail("确认人userId不能为空");
			}
		}
		//判断责任信息列表是否为空
		if(duty == null){
			return Result.fail("预警责任列表不能为空");
		}
		for (int i=0;i<duty.size();i++){
			if (duty.get(i).getBizId() == null||duty.get(i).getBizId() == ""){
				return Result.fail("bizId不能为空");
			}else if (duty.get(i).getBizType() == null||duty.get(i).getBizType() == ""){
				return Result.fail("bizType不能为空");
			}else if (duty.get(i).getName()==null||duty.get(i).getName()==""){
				return Result.fail("name不能为空");
			}else if (duty.get(i).getAppId()==null||duty.get(i).getAppId()==""){
				return Result.fail("appId不能为空");
			}else if (duty.get(i).getAppName()==null||duty.get(i).getAppName()==""){
				return Result.fail("appName不能为空");
			}else if ("personnel".equals(duty.get(i).getBizType())&&(duty.get(i).getUserId()==null)){
				return Result.fail("userID不能为空");
			}else if ("personnel".equals(duty.get(i).getBizType())&&(duty.get(i).getEmpName()==null||duty.get(i).getEmpName()=="")){
				return Result.fail("empName不能为空");
			}else if (("personnel".equals(duty.get(i).getBizType())||"department".equals(duty.get(i).getBizType()))&&(duty.get(i).getDepartmentId()==null||duty.get(i).getDepartmentId()=="")){
				return Result.fail("departmentId不能为空");
			}else if (("personnel".equals(duty.get(i).getBizType())||"department".equals(duty.get(i).getBizType()))&&(duty.get(i).getDepartmentName()==null||duty.get(i).getDepartmentName()=="")){
				return Result.fail("departmentName不能为空");
			}else if (("personnel".equals(duty.get(i).getBizType())||"department".equals(duty.get(i).getBizType())||"company".equals(duty.get(i).getBizType()))&&(duty.get(i).getOrgId()==null||duty.get(i).getOrgId()=="")){
				return Result.fail("orgId不能为空");
			}else if (("personnel".equals(duty.get(i).getBizType())||"department".equals(duty.get(i).getBizType())||"company".equals(duty.get(i).getBizType()))&&(duty.get(i).getOrgName()==null||duty.get(i).getOrgName()=="")) {
				return Result.fail("orgName不能为空");
			}else if (!duty.get(i).getBizType().equals("personnel")&&!duty.get(i).getBizType().equals("department")&&!duty.get(i).getBizType().equals("company")&&!duty.get(i).getBizType().equals("application")){
				return Result.fail("所传参数错误！bizType的值只能是personnel、department、company、application");
			}
		}

		//判断抄送人是否为空
		if (csr!=null){
			for (int i=0;i<csr.size();i++){
				if (csr.get(i).getUserId()==null||csr.get(i).getUserId()==0){
					return Result.fail("抄送人userId不能为空");
				}else if (csr.get(i).getRecName()==null||csr.get(i).getRecName()==""){
					return Result.fail("抄送人名称recName不能为空");
				}
			}
		}

		//判断责任人是否为空
		if (dutyName!=null){
			if (dutyName.getUserId()==null||dutyName.getUserId()==0){
				return Result.fail("责任人userId不能为空");
			}else if (dutyName.getRecName()==null||dutyName.getRecName()==""){
				return Result.fail("责任人名称recName不能为空");
			}
		}

		//判断预警类型id是否存在
		List<Long> typeid = gxqptPingpingWarnTypeService.getTypeId();
		if (!typeid.contains(typeId)){
			return Result.fail("预警类型id不存在");
		}

		String message = JSONUtils.toJSON(warnMessageDto);
		rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.WARN_MESSAGE_CHANNEL, message);

		return Result.success("发送成功");
	}

	/**
	 * 内部发送预警信息到消息队列（rabbitMq）
	 * @param warnMessageDto
	 * @return
	 */
	@Override
	@ApiOperation(value="内部发送预警信息到消息队列（rabbitMq）",notes = "内部发送预警信息到消息队列（rabbitMq）")
	@IgnoreToken
	@RequestMapping(value = "/saveInsideSend", method = RequestMethod.POST)
	public Result<String> saveInsideSend(@RequestBody WarnMessageDTO warnMessageDto){

		// TODO: 2019/4/18 暂时打日志后面需要注释掉
		log.info("warnMessageDto--start-->[{}]",JSONUtils.toJSON(warnMessageDto));
		String type = warnMessageDto.getType();
		Long typeId = warnMessageDto.getTypeId();
		String title = warnMessageDto.getTitle();
		String callbackUrl = warnMessageDto.getCallbackUrl();
		Integer level = warnMessageDto.getLevel();
		if (null == warnMessageDto.getIsHandle() || warnMessageDto.getIsHandle()){
			warnMessageDto.setIsHandle(true);
		}
		String content = warnMessageDto.getContent();
		List<HandlerDTO> handler = warnMessageDto.getHandler();
		List<DutyDTO> duty = warnMessageDto.getDuty();
		List<CsrDTO> csr = warnMessageDto.getCsr();
		DutyNameDTO dutyName = warnMessageDto.getDutyName();
		if(StringUtils.isEmpty(title)){
			return Result.fail("预警标题不能为空");
		}
		if(StringUtils.isEmpty(content)){
			return Result.fail("预警内容不能为空");
		}
		if (typeId == null){
			return Result.fail("预警类型id不能为空");
		}
		if (StringUtils.isEmpty(type)){
			return Result.fail("预警类型不能为空");
		}
		if (level == null){
			return Result.fail("预警级别不能为空");
		}else if (level != 1&&level != 2&&level != 3&&level != 4){
			return Result.fail("预警级别传入参数错误（预警级别的值只能为1、2、3、4）");
		}

		//判断确认人是否为空
		if(handler == null){
			return Result.fail("确认人不能为空");
		}
		for (int i=0;i<handler.size();i++){
			if (handler.get(i).getHandlerLeve() == null||handler.get(i).getHandlerLeve() == 0 ){
				return Result.fail("确认人级别handlerLeve不能为空");
			}else if (handler.get(i).getRecName() == null||handler.get(i).getRecName() == ""){
				return Result.fail("确认人名称recName不能为空");
			}else if (handler.get(i).getUserId() == null||handler.get(i).getUserId() == 0){
				return Result.fail("确认人userId不能为空");
			}
		}
		//判断责任信息列表是否为空
		if(duty == null){
			return Result.fail("预警责任列表不能为空");
		}
		for (int i=0;i<duty.size();i++){
			if (duty.get(i).getBizId() == null|| "".equals(duty.get(i).getBizId())){
				return Result.fail("bizId不能为空");
			}else if (duty.get(i).getBizType() == null||duty.get(i).getBizType() == ""){
				return Result.fail("bizType不能为空");
			}else if (duty.get(i).getName()==null||duty.get(i).getName()==""){
				return Result.fail("name不能为空");
			}else if (duty.get(i).getAppId()==null||duty.get(i).getAppId()==""){
				return Result.fail("appId不能为空");
			}else if (duty.get(i).getAppName()==null||duty.get(i).getAppName()==""){
				return Result.fail("appName不能为空");
			}else if (!duty.get(i).getBizType().equals("personnel")&&!duty.get(i).getBizType().equals("department")&&!duty.get(i).getBizType().equals("company")&&!duty.get(i).getBizType().equals("application")){
				return Result.fail("所传参数错误！bizType的值只能是personnel、department、company、application");
			}
		}

//		//判断抄送人是否为空
//		if (csr!=null){
//			for (int i=0;i<csr.size();i++){
//				if (csr.get(i).getUserId()==null||csr.get(i).getUserId()==0){
//					return Result.fail("抄送人userId不能为空");
//				}else if (csr.get(i).getRecName()==null||csr.get(i).getRecName()==""){
//					return Result.fail("抄送人名称recName不能为空");
//				}
//			}
//		}

//		//判断责任人是否为空
//		if (dutyName!=null){
//			if (dutyName.getUserId()==null||dutyName.getUserId()==0){
//				return Result.fail("责任人userId不能为空");
//			}else if (dutyName.getRecName()==null||dutyName.getRecName()==""){
//				return Result.fail("责任人名称recName不能为空");
//			}
//		}

		//判断预警类型id是否存在
//		List<Long> typeid = gxqptPingpingWarnTypeService.getTypeId();
//		if (!typeid.contains(typeId)){
//			return Result.fail("预警类型id不存在");
//		}

		String message = JSONUtils.toJSON(warnMessageDto);
		// TODO: 2019/4/18 暂时打日志后面需要注释掉
		log.info("warnMessageDto--end-->[{}]",message);
		rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.WARN_MESSAGE_CHANNEL, message);

		return Result.success("发送成功");
	}
}
