package com.hengyunsoft.platform.sms.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.sms.dto.AppointAppDTO;
import com.hengyunsoft.platform.sms.dto.AppsIdNameDTO;
import com.hengyunsoft.platform.sms.dto.ServiceAccountDTO;
import com.hengyunsoft.platform.sms.dto.ServiceAccountMsgDTO;
import com.hengyunsoft.platform.sms.dto.ServiceAccountPageDTO;
import com.hengyunsoft.platform.sms.entity.template.dos.AppointDeleteAppDO;
import com.hengyunsoft.platform.sms.entity.template.dos.AppsDO;
import com.hengyunsoft.platform.sms.entity.template.po.SmsChannelOwner;
import com.hengyunsoft.platform.sms.repository.template.example.SmsChannelOwnerExample;
import com.hengyunsoft.platform.sms.repository.template.service.SmsChannelOwnerService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
/**
 * 短信服务账号管理
 * @author dxz
 */
@RestController
@Slf4j
@Api(value = "短信服务账号管理", description = "短信服务账号管理")
public class ServiceAccountApiImpl {
	
	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
	private MsgsChannelService msgsChannelService;
	@Autowired
	private SmsChannelOwnerService smsChannelOwnerService;
	/**
     * 新增账号
     * @return
     */
	@RequestMapping(value = "/api/smsacount/add", method = RequestMethod.POST)
    @ApiOperation(value="新增账号",notes = "新增账号")
    @ApiResponses({
        @ApiResponse(code = 45120, message = "参数错误"),
//        @ApiResponse(code = 45121, message = "服务账号不能为空"),
        @ApiResponse(code = 45122, message = "短信渠道名称不能为空"),
        @ApiResponse(code = 45123, message = "渠道服务商名称不能为空"),
        @ApiResponse(code = 45124, message = "第三方APPID不能为空"),
        @ApiResponse(code = 45125, message = "第三方申请密钥不能为空"),
    })
	@ValidatorStandard(
			{
					@Constraint(value = MsgsChannel.class)
			}
	)
	public Result<String> addAcount(@RequestBody ServiceAccountDTO serviceAccountDTO) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNTPARAM_ERROR,serviceAccountDTO);
//		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNT_NULL,serviceAccountDTO.getAccount());
		BizAssert.assertNotNull(SmsExceptionCode.SMS_CHANNELNAME_NULL,serviceAccountDTO.getName());
		BizAssert.assertNotNull(SmsExceptionCode.SMS_CHANNELSERVER_NULL,serviceAccountDTO.getChannelServer());
		BizAssert.assertNotNull(SmsExceptionCode.SMS_APPIDSERVER_NULL,serviceAccountDTO.getAppId());		
		BizAssert.assertNotNull(SmsExceptionCode.SMS_APPSECRET_NULL,serviceAccountDTO.getAppSecret());
		try {			
			/*MsgsChannelExample example = new MsgsChannelExample();
			example.createCriteria().andAccountEqualTo(serviceAccountDTO.getAccount()).andChannelTypeEqualTo(3);
			List<MsgsChannel> list = msgsChannelService.find(example);
			if(list!=null&&!list.isEmpty()){
				return Result.fail("该账号已存在!");
			}*/
			MsgsChannel msgsChannel = dozerUtils.map(serviceAccountDTO, MsgsChannel.class);
			msgsChannel.setId(msgsChannelService.genId());
			msgsChannel.setChannelType(3);
			msgsChannel.setCreateTime(new Date());
			msgsChannel.setUsed(0L);
			msgsChannel.setCreateUser(BaseContextHandler.getAdminId());
			msgsChannel.setCreateUserName(BaseContextHandler.getName());
			MsgsChannel result = msgsChannelService.save(msgsChannel);
			if(result!=null){
				result.setAccount(result.getId().toString());
				msgsChannelService.updateByIdSelective(result);
				return Result.success("success");
			}else{
				return Result.fail("fail");
			}		
		} catch (Exception e) {
			log.error("新增短信账号出错",e);
			return Result.fail("新增短信账号出错");
		}
	}
    /**
     * 编辑账号
     * @return
     */
	@RequestMapping(value = "/api/smsacount/update", method = RequestMethod.POST)
    @ApiOperation(value="编辑账号",notes = "编辑账号")
    @ApiResponses({
        @ApiResponse(code = 45120, message = "参数错误"),
//        @ApiResponse(code = 45121, message = "服务账号不能为空"),
        @ApiResponse(code = 45122, message = "短信渠道名称不能为空"),
        @ApiResponse(code = 45123, message = "渠道服务商名称不能为空"),
        @ApiResponse(code = 45124, message = "第三方APPID不能为空"),
        @ApiResponse(code = 45125, message = "第三方申请密钥不能为空"),
    })
	@ValidatorStandard(
			{
					@Constraint(value = MsgsChannel.class)
			}
	)
	public Result<String> updateAcount(@RequestBody ServiceAccountDTO serviceAccountDTO) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNTPARAM_ERROR,serviceAccountDTO);
//		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNT_NULL,serviceAccountDTO.getAccount());
		BizAssert.assertNotNull(SmsExceptionCode.SMS_CHANNELNAME_NULL,serviceAccountDTO.getName());
		BizAssert.assertNotNull(SmsExceptionCode.SMS_CHANNELSERVER_NULL,serviceAccountDTO.getChannelServer());
		BizAssert.assertNotNull(SmsExceptionCode.SMS_APPIDSERVER_NULL,serviceAccountDTO.getAppId());		
		BizAssert.assertNotNull(SmsExceptionCode.SMS_APPSECRET_NULL,serviceAccountDTO.getAppSecret());
		try {
//			MsgsChannelExample example = new MsgsChannelExample();
//			example.createCriteria().andAccountEqualTo(serviceAccountDTO.getAccount())
//					.andIdEqualTo().andChannelTypeEqualTo(3);
//			List<MsgsChannel> list = msgsChannelService.find(example);
//			if(list!=null&&!list.isEmpty()){
//				return Result.fail("该账号已存在!");
//			}
			MsgsChannel msgsChannel = dozerUtils.map(serviceAccountDTO, MsgsChannel.class);
			msgsChannel.setChannelType(3);
			msgsChannel.setUpdateTime(new Date());
			msgsChannel.setUpdateUser(BaseContextHandler.getAdminId());
			int result = msgsChannelService.updateById(msgsChannel);
			if(result>0){
				return Result.success("success");
			}else{
				return Result.success("fail");
			}
		} catch (Exception e) {
			log.error("编辑短信账号出错",e);
			return Result.fail("编辑短信账号出错");
		}
	}
    /**
     * 删除账号
     * @return
     */
	@RequestMapping(value = "/api/smsacount/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除账号", notes = "删除账号")
    @ApiResponses({
            @ApiResponse(code = 45120, message = "操作短信账号参数错误"),
    })
	public Result<String> deleteAcount(@RequestParam(value = "id") Long id) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNTPARAM_ERROR,id);	
		try {
			int result = msgsChannelService.deleteById(id);
			if(result>0){
				return Result.success("success");
			}else{
				return Result.fail("fail");
			}
		} catch (Exception e) {
			log.error("删除短信账号出错",e);
			return Result.fail("删除短信账号出错");
		}
	}
	/**
	 * 通过渠道ID获取应用集合
	 */
	@RequestMapping(value = "/api/smsacount/getAppsIdName", method = RequestMethod.GET)
    @ApiOperation(value="获取分页列表",notes = "获取分页列表")
	public Result<AppsIdNameDTO> getAppsIdName(String msgsChannelId){
		MsgsChannel msgs = msgsChannelService.getById(Long.parseLong(msgsChannelId));
		//获取指定应用集合
		Set<Long> channelIds = new HashSet<Long>();
		channelIds.add(msgs.getId());
		List<AppsDO> appList = new ArrayList<AppsDO>();
		if(channelIds.size()!=0){
			appList = smsChannelOwnerService.getAppList(channelIds);
		}else{
			appList = new ArrayList<AppsDO>();
		}
		AppsIdNameDTO appsIdNameDTO  = new AppsIdNameDTO();
		if(channelIds!=null&&channelIds.size()!=0 && appList !=null && appList.size()>0){
			List<String> appNames = new ArrayList<String>();
			List<String> appIds = new ArrayList<String>();
			for(AppsDO appsDO:appList){					
				if(appsDO.getChannelId().equals(msgs.getId())){
					appNames.add(appsDO.getAppName());
					appIds.add(appsDO.getAppId());
				}					
			}
			appsIdNameDTO.setAppIds(appIds);
			appsIdNameDTO.setAppNames(appNames);
		}
		return Result.success(appsIdNameDTO);
	}
    /**
     * 获取账号列表
     * @return
     */
	@RequestMapping(value = "/api/smsacount/list", method = RequestMethod.POST)
    @ApiOperation(value="获取分页列表",notes = "获取分页列表")
	public Result<PageInfo<ServiceAccountDTO>> pageAcountList(@RequestBody OpenApiReq<ServiceAccountPageDTO> openApiReq) {
		ServiceAccountPageDTO serviceAccountPageDTO = openApiReq.getData();
		try {
			Long createUserId = BaseContextHandler.getAdminId();
			//获取账号列表
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().
					andCreateUserEqualTo(createUserId).
					andNameLike(MsgsChannelExample.fullLike(serviceAccountPageDTO.getName())).
					andChannelServerEqualTo(serviceAccountPageDTO.getServer()).
					andChannelTypeEqualTo(3);
			msgsChannelExample.setOrderByClause("create_time desc");
			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
			List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
			//获取指定应用集合
			Set<Long> channelIds = new HashSet<Long>();
			for(MsgsChannel msgsChannel:list){
				channelIds.add(msgsChannel.getId());
			}
			List<AppsDO> appList = null;
			if(channelIds.size()!=0){
				appList = smsChannelOwnerService.getAppList(channelIds);
			}else{
				appList = new ArrayList<AppsDO>();
			}	
			//组装数据
			List<ServiceAccountDTO> pageDate = dozerUtils.mapPage(list, ServiceAccountDTO.class);
			if(channelIds!=null&&channelIds.size()!=0){
				for(ServiceAccountDTO serviceAccountDTO:pageDate){
					Long channelId = serviceAccountDTO.getId();
					List<String> appNames = new ArrayList<String>();
					List<String> appIds = new ArrayList<String>();
					for(AppsDO appsDO:appList){					
						if(appsDO.getChannelId().equals(channelId)){
							appNames.add(appsDO.getAppName());
							appIds.add(appsDO.getAppId());
						}					
					}
					serviceAccountDTO.setApps(appNames);
					serviceAccountDTO.setAppIds(appIds);
				}
			}
			return Result.success(new PageInfo<>(pageDate));
		} catch (Exception e) {
			log.error("获取分页列表出错",e);
			return Result.fail("获取分页列表出错");
		}
	}
    /**
     * 获取账号详情
     * @return
     */
	@RequestMapping(value = "/api/smsacount/detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取账号详情", notes = "获取账号详情")
    @ApiResponses({
            @ApiResponse(code = 45120, message = "操作短信账号参数错误"),
    })
	public Result<ServiceAccountDTO> getAcountDetali(@RequestParam(value = "id") Long id) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNTPARAM_ERROR,id);
		try {
			MsgsChannel msgsChannel = msgsChannelService.getById(id);
			if(msgsChannel==null){
				return null;
			}
			String account = msgsChannel.getAccount();
			List<String> nameList = new ArrayList<String>();
			if(!StringUtils.isEmpty(account)){
				SmsChannelOwnerExample smsChannelOwnerExample = new SmsChannelOwnerExample();
				smsChannelOwnerExample.createCriteria().andAccountEqualTo(account);
				List<SmsChannelOwner> list = smsChannelOwnerService.find(smsChannelOwnerExample);
				if(list!=null&&list.size()!=0){
					for(SmsChannelOwner smsChannelOwner:list){
						String appName = smsChannelOwner.getAppName();
						nameList.add(appName);
					}
				}
			}												
			ServiceAccountDTO serviceAccountDTO = dozerUtils.map(msgsChannel,ServiceAccountDTO.class);
			serviceAccountDTO.setApps(nameList);
			return Result.success(serviceAccountDTO);
		} catch (Exception e) {
			log.error("获取账号详情出错",e);
			return Result.fail("获取账号详情出错");
		}
	}
    /**
     * 指定应用
     * @return
     */
	@RequestMapping(value = "/api/smsacount/appoint", method = RequestMethod.POST)
    @ApiOperation(value = "指定应用", notes = "指定应用")
	public Result<String> saveAppoint(@RequestBody AppointAppDTO appointAppDTO) {
		BizAssert.assertNotNull(SmsExceptionCode.SMS_ACCOUNTPARAM_ERROR,appointAppDTO);
		try {			
			String appId = appointAppDTO.getAppId();
			if(StringUtils.isEmpty(appId)){
				return Result.fail("所选应用不能为空");
			}			
			String appName = appointAppDTO.getAppName();
			String account = appointAppDTO.getAccount();
			MsgsChannel msgsChannel = msgsChannelService.getByAccount(account);
			if(msgsChannel==null){
				return Result.fail("该账号为无效账号");
			}
			List<String> apps = Arrays.asList(appId.split(","));
			List<String> appNames = Arrays.asList(appName.split(","));
			Date date = new Date();
			Integer tag = appointAppDTO.getTag();
			List<SmsChannelOwner> list = new ArrayList<SmsChannelOwner>();
			if(apps!=null&&apps.size()!=0){	
				if(tag==0){	
					//指定应用
					Long createUserId = BaseContextHandler.getAdminId();
					for(int i=0;i<apps.size();i++){
						SmsChannelOwner smsChannelOwner = new SmsChannelOwner();
						Long id = smsChannelOwnerService.genId();
						String appid = apps.get(i);
						String appname = appNames.get(i);
						smsChannelOwner.setId(id);
						smsChannelOwner.setAppId(appid);
						smsChannelOwner.setAppName(appname);
						smsChannelOwner.setAccount(account);					
						smsChannelOwner.setCreateUser(createUserId);
						smsChannelOwner.setChannelId(msgsChannel.getId());
						smsChannelOwner.setChannelName(msgsChannel.getName());
						smsChannelOwner.setChannelServer(msgsChannel.getChannelServer());
						smsChannelOwner.setCreateTime(date);
						list.add(smsChannelOwner);
					}		
					smsChannelOwnerService.save(list);
				}else if(tag==1){
					AppointDeleteAppDO appointDeleteAppDO = new AppointDeleteAppDO();
					appointDeleteAppDO.setAccount(account);
					appointDeleteAppDO.setApps(apps);
					//取消指定应用
					smsChannelOwnerService.deleteByAccountAndAppids(appointDeleteAppDO);
				}
			}			
			return Result.success("success");
		} catch (Exception e) {
			log.error("指定应用出错",e);
			return Result.fail("指定应用出错");
		}
	}
	
    /**
     * 根据服务商英文名查询短信服务账号
     * @return
     */
	@RequestMapping(value = "/api/smsacount/names", method = RequestMethod.GET)
	@ApiOperation(value = "根据服务商英文名查询短信服务账号", notes = "根据服务商英文名查询短信服务账号")
	public Result<List<ServiceAccountMsgDTO>> getAccountByServer(@RequestParam(value = "server")String server) {
		try {
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(BaseContextHandler.getAdminId())
			.andChannelServerEqualTo(server).andChannelTypeEqualTo(3);
			msgsChannelExample.setOrderByClause("create_time desc");
			List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
			List<ServiceAccountMsgDTO> dtoList = new ArrayList<ServiceAccountMsgDTO>();
			if(list!=null&&list.size()!=0){							
				for(MsgsChannel msgsChannel:list){
					ServiceAccountMsgDTO serviceAccountMsgDTO = new ServiceAccountMsgDTO();
					serviceAccountMsgDTO.setId(msgsChannel.getId());
					serviceAccountMsgDTO.setName(msgsChannel.getName());
					serviceAccountMsgDTO.setAccount(msgsChannel.getAccount());
					dtoList.add(serviceAccountMsgDTO);
				}
			}else{
				return Result.success(null);
			}
			return Result.success(dtoList);
		} catch (Exception e) {
			log.error("根据服务商英文名查询短信服务账号出错",e);
			return Result.fail("根据服务商英文名查询短信服务账号出错");
		}
	}
}
