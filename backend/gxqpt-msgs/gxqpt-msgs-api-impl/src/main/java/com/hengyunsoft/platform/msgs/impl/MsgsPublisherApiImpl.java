package com.hengyunsoft.platform.msgs.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllReqDTO;
import com.hengyunsoft.platform.msgs.dto.msg.BlackListDeleteDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsBackListDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsBackListRequestDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessagePublisherDTO;
import com.hengyunsoft.platform.msgs.dto.msg.PublisherBlackListDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.BlackListDeleteDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListBackDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessagePublisherDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsBlacklistService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageRecordService;
import com.hengyunsoft.platform.msgs.utils.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "发布商管理", description = "发布商管理")
public class MsgsPublisherApiImpl {
	
    @Autowired
    private DozerUtils dozerUtils;	
	@Autowired
	private MsgsBlacklistService msgsBlacklistService;
    @Autowired
    private MsgsChannelService msgsChannelService;
	@Autowired
    private WeChatMessageRecordService weChatMessageRecordService;
	@Autowired
	private ApplicationApi applicationApi;
	/**
	 * 发布人拉黑/取消拉黑
	 * @param publisherBlackListDTO
	 * @return
	 */
	@RequestMapping(value = "/publisher/msg/pullblack", method = RequestMethod.POST)
	@ApiOperation(value="发布人拉黑/取消拉黑",notes = "发布人拉黑/取消拉黑")
	public Result<Boolean> savePublisherPullblack(@RequestBody PublisherBlackListDTO publisherBlackListDTO) {
		try {
			Long userId = BaseContextHandler.getAdminId();
			if(publisherBlackListDTO==null||Util.isEmptyString(publisherBlackListDTO.getAppId())){
				return Result.fail("参数错误");
			}
			Integer mark = publisherBlackListDTO.getCancel();
			if(mark==0){
				//拉黑
				MsgsBlacklist msgsBlacklist = new MsgsBlacklist();
				msgsBlacklist.setCreateUser(userId);
				msgsBlacklist.setChannelId(publisherBlackListDTO.getChannelId());
				msgsBlacklist.setAppId(publisherBlackListDTO.getAppId());
				msgsBlacklist.setCreateTime(new Date());
				msgsBlacklistService.save(msgsBlacklist);
			}else if(mark==1){
				//取消拉黑
				BlackListDeleteDTO blackListDeleteDTO = new BlackListDeleteDTO();
				blackListDeleteDTO.setAppId(publisherBlackListDTO.getAppId());
				blackListDeleteDTO.setChannelId(publisherBlackListDTO.getChannelId());
				blackListDeleteDTO.setUserId(userId);
				BlackListDeleteDO blackListDeleteDO = dozerUtils.map(blackListDeleteDTO, BlackListDeleteDO.class);
				msgsBlacklistService.deleteByAppId(blackListDeleteDO);		
			}else{
				return Result.fail("参数错误");
			}		
			return Result.success(true);
		} catch (Exception e) {
			log.error("发布人拉黑/取消拉黑出错："+e);
			return Result.fail("发布人拉黑/取消拉黑出错");
		}
	}
	/**
	 * 获取拉黑列表
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/publisher/msg/list", method = RequestMethod.POST)
	@ApiOperation(value="获取拉黑列表",notes = "获取拉黑列表")
	public Result<PageInfo<MsgsBackListDTO>> getPublisherList(@RequestBody OpenApiReq<MsgsBackListRequestDTO> openApiReq) {
		try {
			MsgsBackListRequestDTO msgsBackListRequestDTO = openApiReq.getData();
			if(msgsBackListRequestDTO==null||msgsBackListRequestDTO.getChannelId()==null||msgsBackListRequestDTO.getChannelId()==0){
				return Result.fail("参数错误");
			}
			//获取所有应用
			ApplicationAllReqDTO applicationAllReqDTO = new ApplicationAllReqDTO();
			if(!Util.isEmptyString(msgsBackListRequestDTO.getName())){
				applicationAllReqDTO.setName(msgsBackListRequestDTO.getName());
			}
			if(!Util.isEmptyString(msgsBackListRequestDTO.getCompany())){
				applicationAllReqDTO.setOrgName(msgsBackListRequestDTO.getCompany());
			}
			applicationAllReqDTO.setPageNo(openApiReq.getPageNo());
			applicationAllReqDTO.setPageSize(openApiReq.getPageSize());
			Long userId = BaseContextHandler.getAdminId();
			//判断状态
			if(Util.isEmptyString(msgsBackListRequestDTO.getStatus())||"0".equals(msgsBackListRequestDTO.getStatus())
					||msgsBackListRequestDTO.getStatus()=="0"){
				//获取黑名单
				MsgsBlacklistExample msgsBlacklistExample = new MsgsBlacklistExample();
				msgsBlacklistExample.createCriteria().andChannelIdEqualTo(msgsBackListRequestDTO.getChannelId()).andCreateUserEqualTo(userId);
				List<MsgsBlacklist> list = msgsBlacklistService.find(msgsBlacklistExample);
				List<String> blackList = new ArrayList<String>();
				if(!Util.isEmpty(list)){
					for(MsgsBlacklist msgsBlacklist:list){
						blackList.add(msgsBlacklist.getAppId());
					}
				}
				//获取所有应用
				PageInfo appPage = applicationApi.PageAllLike(applicationAllReqDTO).getData();
				if(appPage==null){
					return Result.success(new PageInfo<>(new ArrayList<>()));
				}
				List<ApplicationAllDTO> appList = appPage.getList();
				if(Util.isEmpty(appList)){
					return Result.success(new PageInfo<>(new ArrayList<>()));
				}
				List<MsgsBackListDTO> result = dozerUtils.mapList(appList, MsgsBackListDTO.class);
				for(MsgsBackListDTO msgsBackListDTO:result){
					if(msgsBackListDTO==null){
						continue;
					}
					if(blackList.contains(msgsBackListDTO.getAppId())){
						msgsBackListDTO.setStatus("已拉黑");
					}else{
						msgsBackListDTO.setStatus("正常");
					}
				}
				appPage.setList(result);				
				return Result.success(appPage);
			}else if("1".equals(msgsBackListRequestDTO.getStatus())
					||msgsBackListRequestDTO.getStatus()=="1"){
				//获取黑名单
				MsgsBlacklistExample msgsBlacklistExample = new MsgsBlacklistExample();
				msgsBlacklistExample.createCriteria().andChannelIdEqualTo(msgsBackListRequestDTO.getChannelId()).andCreateUserEqualTo(userId);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<MsgsBlacklist> list = msgsBlacklistService.find(msgsBlacklistExample);
				if(Util.isEmpty(list)){
					return Result.success(new PageInfo<>(new ArrayList<>()));
				}
				PageInfo appPage = new PageInfo<>(list);
				List<String> blackList = new ArrayList<String>();
				for(MsgsBlacklist msgsBlacklist:list){
					blackList.add(msgsBlacklist.getAppId());
				}
				//获取所有应用
				List<ApplicationAllDTO> appList = applicationApi.findAllLike(applicationAllReqDTO).getData();
				if(appList==null){
					return Result.success(new PageInfo<>(new ArrayList<>()));
				}
				List<MsgsBackListDTO> result = dozerUtils.mapList(appList, MsgsBackListDTO.class);
				List<MsgsBackListDTO> delete = new ArrayList<MsgsBackListDTO>();
				for(MsgsBackListDTO msgsBackListDTO:result){
					if(msgsBackListDTO==null){
						continue;
					}
					if(blackList.contains(msgsBackListDTO.getAppId())){
						msgsBackListDTO.setStatus("已拉黑");
					}else{
						delete.add(msgsBackListDTO);
					}
				}
				result.removeAll(delete);
				appPage.setList(result);
				return Result.success(appPage);	
			}else{
				return Result.fail("参数错误");
			}
		} catch (Exception e) {
			log.error("获取拉黑列表出错："+e);
			return Result.fail("获取拉黑列表出错");
		}
	}
    /**
     * 发布商消息记录分页列表
     *
     * @param openApiReq
     * @return
     */
	@RequestMapping(value = "/publisher/msg/page", method = RequestMethod.POST)
	@ApiOperation(value="发布商消息记录分页列表",notes = "发布商消息记录分页列表")
	public Result<PageInfo<MsgsListBackDTO>> getMsgPage(@RequestBody OpenApiReq<MsgsMessagePublisherDTO> openApiReq) {
		try {
			MsgsMessagePublisherDTO msgsMessagePublisherDTO = openApiReq.getData();
			if(msgsMessagePublisherDTO==null){
				return Result.fail("参数错误");
			}			
			//获取本人创建的渠道
			Long userId = BaseContextHandler.getAdminId();
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
			msgsChannelExample.createCriteria().andCreateUserEqualTo(userId).andChannelTypeNotEqualTo(3);
			List<MsgsChannel> channelNum = msgsChannelService.find(msgsChannelExample);
			if(Util.isEmpty(channelNum)){
				return Result.success(null);
			}
			List<String> list = new ArrayList<String>();
			for(MsgsChannel msgsChannel:channelNum){
				list.add(String.valueOf(msgsChannel.getId()));
			}
			//整理参数
			msgsMessagePublisherDTO.setChannelIds(list);
			msgsMessagePublisherDTO.setUserId(userId);
            String name = msgsMessagePublisherDTO.getName();
            if(!Util.isEmptyString(name)){
            	msgsMessagePublisherDTO.setName("%"+name+"%");
            }
            MsgsMessagePublisherDO msgsMessagePublisherDO = dozerUtils.map(msgsMessagePublisherDTO, MsgsMessagePublisherDO.class);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<MsgsListBackDO> result = weChatMessageRecordService.getMsgsList(msgsMessagePublisherDO); 
            List<MsgsListBackDTO> resultList = dozerUtils.mapList(result, MsgsListBackDTO.class);
            return Result.success(new PageInfo<>(resultList));
		} catch (Exception e) {
			log.error("获取发布商消息记录分页列表出错："+e);
			return Result.fail("获取发布商消息记录分页列表出错");
		}
	}

}
