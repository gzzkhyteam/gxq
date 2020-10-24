package com.hengyunsoft.platform.msgs.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.hengyunsoft.commons.exception.core.MsgExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.api.msg.MsgsMessageApi;
import com.hengyunsoft.platform.msgs.biz.MessageService;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MessageSendDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MobileMsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MobileNewReadDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MobileReadCheckDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelChildTreeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTypeChaildDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTypeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgDetailDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelThreeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageMobileDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageQueryDTO;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageIsread;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.MobileMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MobileReadCheckDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessageQueryDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po.MsgsMessageChannel;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BlogMessageCursorService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageIsreadService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MobileMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageCursorService;
import com.hengyunsoft.platform.msgs.repository.msgsmessagechannel.service.MsgsMessageChannelService;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@RestController
@Slf4j
@Api(value = "消息发布管理", description = "消息发布管理")
public class MsgsMessageApiImpl implements MsgsMessageApi {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MsgsMessageService msgsMessageService;
    @Autowired
    private MsgsMessageChannelService msgsMessageChannelService;
    @Autowired
    private WeChatMessageCursorService weChatMessageCursorService;
    @Autowired
    private BlogMessageCursorService blogMessageCursorService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private MobileMessageRecordService mobileMessageRecordService;
	@Autowired
    private MobileMessageIsreadService mobileMessageIsreadService;

    /**
     * 消息发送
     * @param msgsMessageSaveDTO
     * @return
     */
	@RequestMapping(value = "/message/save", method = RequestMethod.POST)
    @ApiOperation(value="消息发送",notes = "消息发送")
    public Result<String> save(@RequestBody MessageSendDTO messageSendDTO) {
        try{          
        	if(messageSendDTO==null){
        		return Result.fail("请求参数不能为空！");
        	}
            String content = messageSendDTO.getImgText();
            if(Util.isEmptyString(content)){
            	return Result.fail("消息内容不能为空！");
            }            
            List<MsgsChannelThreeDTO> list = messageSendDTO.getChannelIds();
            if(Util.isEmpty(list)){
            	return Result.fail("发送渠道不能为空！");
            }
            String appId = messageSendDTO.getAppId();
            MsgsMessage msgsMessage = new MsgsMessage();
            int draft = messageSendDTO.getDraft();
            msgsMessage.setMsgStatus((long)draft);
            msgsMessage.setMsgTxt(content);
            msgsMessage.setTitle(messageSendDTO.getTopic());
            msgsMessage.setCreateTime(new Date());
            msgsMessage.setCreateUser(BaseContextHandler.getAdminId()); 
            msgsMessage.setSendJobTime(new Date());
            String startTime = messageSendDTO.getStartTime();
            String fileUrl = messageSendDTO.getFileUrl();
            if(!Util.isEmptyString(startTime)){
            	msgsMessage.setMsgStatus(1L);
            }            
            if(!Util.isEmptyString(fileUrl)){
            	msgsMessage.setAttachmentUrl(fileUrl);
            	msgsMessage.setAttachmentId(messageSendDTO.getFileId());
            	msgsMessage.setAttachmentName(messageSendDTO.getFileName());
            }
            if(Util.isEmptyString(appId)){
            	msgsMessage.setAppId(BaseContextHandler.getAppId());
            }else{
            	msgsMessage.setAppId(appId);
            }
            //发送信息校验
            List<MsgsChannelThreeDTO> channelIds = messageSendDTO.getChannelIds();
            for(MsgsChannelThreeDTO msgsChannelThreeDTO:channelIds){
            	String type = msgsChannelThreeDTO.getChannelType();
            	if("2".equals(type)){
  				    Boolean containURL = Util.containURL(content);
  				    if(!containURL){
  					   return Result.fail("消息内容必须包含一个网址！");
  				    }
            	}
            }
            //保存消息
            msgsMessage = msgsMessageService.save(msgsMessage);
            //保存发送渠道
            List<MsgsMessageChannel> channels = new ArrayList<MsgsMessageChannel>();
            Long id = msgsMessage.getId();
            for(MsgsChannelThreeDTO msgsChannelThreeDTO:list){           	
            	MsgsMessageChannel msgsMessageChannel = new MsgsMessageChannel();
                msgsMessageChannel.setChannel(msgsChannelThreeDTO.getName());
                msgsMessageChannel.setChannelId(msgsChannelThreeDTO.getId());
                msgsMessageChannel.setMessageId(id);
                msgsMessageChannel.setTypeId(Long.valueOf(msgsChannelThreeDTO.getChannelType()));
                msgsMessageChannel.setCreateTime(Calendar.getInstance().getTime());
                msgsMessageChannel.setCreateUser(BaseContextHandler.getAdminId());   
                channels.add(msgsMessageChannel);
            }
            msgsMessageChannelService.save(channels);
            //发送消息
            String msg = "";
            if(draft==0){
            	MessageDTO messageDTO = dozerUtils.map(messageSendDTO, MessageDTO.class);
            	messageDTO.setMsgId(String.valueOf(id));
            	msg = messageService.saveMessage(messageDTO);
            }else if (draft==1){
            	msg = "保存草稿成功";
            }
            return Result.success(msg);
        } catch(Exception  e){
            log.error("消息保存异常:"+e);
            return Result.fail("消息发送出错");
        }
    }
    /**
     * 更新信息
     */
	@RequestMapping(value = "/message/update", method = RequestMethod.POST)
    @ApiOperation(value="更新信息",notes = "更新信息")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "类型ID不允许为空"),
        @ApiResponse(code = 71505, message = "消息文本内容不能为空"),
    })
    public Result<String> update(@RequestBody MessageSendDTO messageSendDTO) {
    	try{
        	if(messageSendDTO==null){
        		return Result.fail("请求参数不能为空！");
        	}
    		Long msgId = messageSendDTO.getId();            
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL,msgId);
            BizAssert.assertNotNull(MsgExceptionCode.MESSAGE_MSGTXT_EMPTY, messageSendDTO.getImgText());
            //删除关联的数据
            msgsMessageChannelService.deleteByMsgId(msgId);
            //更新关联数据            
            List<MsgsMessageChannel> channels = new ArrayList<MsgsMessageChannel>();
            List<MsgsChannelThreeDTO> list = messageSendDTO.getChannelIds();
            for(MsgsChannelThreeDTO msgsChannelThreeDTO:list){           	
            	MsgsMessageChannel msgsMessageChannel = new MsgsMessageChannel();
                msgsMessageChannel.setChannel(msgsChannelThreeDTO.getName());
                msgsMessageChannel.setChannelId(msgsChannelThreeDTO.getId());
                msgsMessageChannel.setMessageId(msgId);
                msgsMessageChannel.setTypeId(Long.valueOf(msgsChannelThreeDTO.getChannelType()));
                msgsMessageChannel.setCreateTime(Calendar.getInstance().getTime());
                msgsMessageChannel.setCreateUser(BaseContextHandler.getAdminId());   
                channels.add(msgsMessageChannel);
            }
            msgsMessageChannelService.save(channels);  
            //更新消息        
            MsgsMessage msgsMessage = new MsgsMessage();
            int draft = messageSendDTO.getDraft();
            msgsMessage.setId(msgId);
            msgsMessage.setMsgStatus((long)draft);
            msgsMessage.setMsgTxt(messageSendDTO.getImgText());
            msgsMessage.setTitle(messageSendDTO.getTopic());
            msgsMessage.setUpdateUser(BaseContextHandler.getAdminId());
            msgsMessage.setUpdateTime(Calendar.getInstance().getTime());
            String startTime = messageSendDTO.getStartTime();
            String fileUrl = messageSendDTO.getFileUrl();
            if(!Util.isEmptyString(startTime)){
            	msgsMessage.setSendJobTime(Util.stringToDate(startTime));
            }
            if(!Util.isEmptyString(fileUrl)){
            	msgsMessage.setAttachmentUrl(fileUrl);
            }           
            int result = msgsMessageService.updateByIdSelective(msgsMessage);
            if (result <= 0) {
                return Result.fail("更新失败");
            } else {
                return Result.success("更新成功");
            }
       	} catch(Exception e){
            log.error("更新消息出错:"+e);
            return Result.fail("更新消息出错");
       	}
    }
    /**
     * 删除信息
     */
	@RequestMapping(value = "/message/delete", method = RequestMethod.GET)
    @ApiOperation(value="删除信息",notes = "删除信息")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "类型ID不允许为空"),
    })
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, id);
        try {
        	int result = msgsMessageService.deleteById(id);
            //删除关联的数据
            msgsMessageChannelService.deleteByMsgId(id);
            //删除临时表发送的数据
            weChatMessageCursorService.deleteByMsgId(String.valueOf(id));
            blogMessageCursorService.deleteByMsgId(String.valueOf(id));
            if (result < 0) {
                return Result.fail("删除失败");
            } else {
                return Result.success(true);
            }
		} catch (Exception e) {
			log.error("删除信息出错"+e);
			return Result.fail("删除信息出错");
		}       
    }
    /**
     * 获取信息分页列表
     *
     * @param openApiReq@return
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/message/query", method = RequestMethod.POST)
    @ApiOperation(value="获取信息分页列表",notes = "获取信息分页列表")
    public Result<PageInfo<MsgsListBackDTO>> query(@RequestBody OpenApiReq<MsgsMessageQueryDTO> openApiReq) {
        try{
            Long adminId = BaseContextHandler.getAdminId();
            MsgsMessageQueryDTO msgsMessageQueryDTO = (MsgsMessageQueryDTO) openApiReq.getData();
        	if(msgsMessageQueryDTO==null){
        		return null;
        	}
            msgsMessageQueryDTO.setUserId(adminId);
            String name = msgsMessageQueryDTO.getName();
            Long type = msgsMessageQueryDTO.getChannelType();
            if(!Util.isEmptyString(name)){
            	msgsMessageQueryDTO.setName("%"+name+"%");
            }
            MsgsMessageQueryDO messageQueryDO = dozerUtils.map(msgsMessageQueryDTO, MsgsMessageQueryDO.class);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<MsgsListDO> list = msgsMessageService.getMsgsList(messageQueryDO);     
            PageInfo appPage = dozerUtils.map(list,PageInfo.class);
            List<MsgsListBackDTO> result = new ArrayList<MsgsListBackDTO>();
            if(!Util.isEmpty(list)&&(!Util.isEmptyString(name)||(type!=null&&type!=0))){            	 
            	Set<Long> ids = new HashSet<Long>();
            	for(MsgsListDO msgsListDO:list){
            		ids.add(msgsListDO.getId());
            	}
            	List<MsgsMessageChannel> channels = msgsMessageChannelService.getChannelsByIds(ids);            	
            	result = getMsgsList(channels,list);
            }else{
            	result = getMsgsList(null,list);
            }
            
            Collections.sort(result, new Comparator<MsgsListBackDTO>() {            	 
    			@Override
    			public int compare(MsgsListBackDTO o1, MsgsListBackDTO o2) {    				
    				if(o1.getSendTime() == null){
    					if(o2.getSendTime() == null){
    						return 0;
    					} else {
    						return 1;
    					}
    				}
    				if(o2.getSendTime() == null){
    					if(o1.getSendTime() == null){
    						return 1;
    					} else {
    						return 0;
    					}
    				}
    				return -o1.getSendTime().compareTo(o2.getSendTime());
    			}
    		});
            appPage.setList(result);
            return Result.success(appPage);
        }catch (Exception e){
           log.error("获取信息分页列表出错:"+e);
           return Result.fail("获取信息分页列表出错");
        }
    }    
    
    /**
     * 获取信息详情
     * @param id
     * @return
     */
	@RequestMapping(value = "/message/detail", method = RequestMethod.GET)
	@ApiOperation(value="获取信息详情",notes = "获取信息详情")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "类型ID不允许为空"),
    })
	public Result<MsgDetailDTO> getMsgDetail(Long msgId) {
		try{
			BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, msgId);
			MsgsMessage msgsMessage = msgsMessageService.getById(msgId);
			if(msgsMessage==null){
				return Result.fail("信息不存在");
			}
			MsgDetailDTO msgDetailDTO = new MsgDetailDTO();
			msgDetailDTO.setMsgId(msgId);
			msgDetailDTO.setTitle(msgsMessage.getTitle());
			msgDetailDTO.setContent(msgsMessage.getMsgTxt());
			if(msgsMessage.getSendJobTime()!=null){
				msgDetailDTO.setSendTime(Util.dateToStr(msgsMessage.getSendJobTime()));
			}else{
				msgDetailDTO.setSendTime(Util.dateToStr(msgsMessage.getCreateTime()));
			}
			String fileUrl = msgsMessage.getAttachmentUrl();
			if(!Util.isEmptyString(fileUrl)){
				msgDetailDTO.setFileUrl(fileUrl);
            	msgDetailDTO.setFileId(msgsMessage.getAttachmentId());
            	msgDetailDTO.setFileName(msgsMessage.getAttachmentName());
			}		
			//信息发送情况
            JSONObject obj = messageService.getErrorInfo(Long.toString(msgId));
            if(obj!=null){
                msgDetailDTO.setSuccessNum(String.valueOf(obj.get("success")));
                msgDetailDTO.setFailNum(String.valueOf(obj.get("error")));
                List<MsgChannelTypeDTO> list = getSendStatus(obj);
                msgDetailDTO.setStatus(list);
            }
            return Result.success(msgDetailDTO);
        } catch (Exception e){
            log.error("获取信息详情出错:"+e);
            return Result.fail("获取信息详情出错");
        }
	}
	
    /**
     * 获取草稿箱信息详情
     * @param id
     * @return
     */
	@RequestMapping(value = "/drafts/detail", method = RequestMethod.GET)
	@ApiOperation(value="获取草稿箱信息详情",notes = "获取草稿箱信息详情")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "类型ID不允许为空"),
    })
	public Result<MsgDetailDTO> getDraftsDetail(Long msgId) {
		try{
			if(msgId==null){
				BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, msgId);
			}
			MsgsMessage msgsMessage = msgsMessageService.getById(msgId);
			if(msgsMessage==null){
				return Result.fail("信息不存在");
			}
			MsgDetailDTO msgDetailDTO = new MsgDetailDTO();
			msgDetailDTO.setMsgId(msgId);
			msgDetailDTO.setTitle(msgsMessage.getTitle());
			msgDetailDTO.setContent(msgsMessage.getMsgTxt());
			if(msgsMessage.getSendJobTime()!=null){
				msgDetailDTO.setSendTime(String.valueOf(msgsMessage.getSendJobTime()));
			}else{
				msgDetailDTO.setSendTime(String.valueOf(msgsMessage.getCreateTime()));
			}
			String fileUrl = msgsMessage.getAttachmentUrl();
			if(!Util.isEmptyString(fileUrl)){
				msgDetailDTO.setFileUrl(fileUrl);
				msgDetailDTO.setFileName(msgsMessage.getAttachmentName());
            	msgDetailDTO.setFileId(msgsMessage.getAttachmentId());
			}			
            //获取渠道信息 
            List<MsgsMessageChannel> channelList = msgsMessageChannelService.getByMsgId(msgId);
            List<MsgChannelChildTreeDTO> list = new ArrayList<MsgChannelChildTreeDTO>();
            if(Util.isEmpty(channelList)){
            	msgDetailDTO.setChannels(null);
            }else{
            	for(MsgsMessageChannel msgsMessageChannel:channelList){
            		MsgChannelChildTreeDTO msgChannelChildTreeDTO = new MsgChannelChildTreeDTO();
            		msgChannelChildTreeDTO.setId(msgsMessageChannel.getChannelId());
            		msgChannelChildTreeDTO.setName(msgsMessageChannel.getChannel());
            		msgChannelChildTreeDTO.setType(String.valueOf(msgsMessageChannel.getTypeId()));
            		list.add(msgChannelChildTreeDTO);
            	}   
            	msgDetailDTO.setChannels(list);
            }           
            return Result.success(msgDetailDTO);
        } catch (Exception e){
            log.error("获取草稿箱信息详情出错:"+e);
            return Result.fail("获取草稿箱信息详情出错");
        }
	}
    /**
     * 获取移动终端消息列表
     *
     * @param openApiReq
     * @return
     */
	@RequestMapping(value = "/message/mobile", method = RequestMethod.POST)
	@ApiOperation(value="获取移动终端消息列表",notes = "获取移动终端消息列表")
	public Result<PageInfo<MobileMsgsListBackDTO>> queryMobile(@RequestBody OpenApiReq<MsgsMessageMobileDTO> openApiReq) {
		try {
			MsgsMessageMobileDTO msgsMessageMobileDTO = openApiReq.getData();
			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
			List<MobileMessageRecord> list = mobileMessageRecordService.getAll();
			if(Util.isEmpty(list)){
				return Result.success(new PageInfo<>(null));
			}
			List<MobileMsgsListBackDTO> result = dozerUtils.mapList(list, MobileMsgsListBackDTO.class);
			//摘要处理
			Set<Long> ids = new HashSet<Long>();
			for(MobileMsgsListBackDTO mobileMsgsListBackDTO:result){				
				String context = Util.slovtHtml(mobileMsgsListBackDTO.getImgText());
				String digest = "";
				if(!"".equals(context)&&context.length()>32){
					digest = context.substring(0, 33);
				}else{
					digest = context;
				}				
				mobileMsgsListBackDTO.setImgText(digest);
				ids.add(Long.valueOf(mobileMsgsListBackDTO.getMsgId()));
			}
			//处理是否已读
			Long userId = msgsMessageMobileDTO.getUserId();
			MobileReadCheckDTO mobileReadCheckDTO = new MobileReadCheckDTO();
			mobileReadCheckDTO.setUserId(userId);
			mobileReadCheckDTO.setIds(ids);
			MobileReadCheckDO mobileReadCheckDO = dozerUtils.map(mobileReadCheckDTO, MobileReadCheckDO.class);
			List<MobileMessageIsread> readList = mobileMessageIsreadService.getByUserIdAndMsgId(mobileReadCheckDO);
			if(!Util.isEmpty(readList)){
				for(MobileMsgsListBackDTO mobileMsgsListBackDTO:result){
					String msgId = mobileMsgsListBackDTO.getMsgId();
					for(MobileMessageIsread mobileMessageIsread:readList){
						String msgid = String.valueOf(mobileMessageIsread.getMsgId());
						if(msgid.equals(msgId)){
							mobileMsgsListBackDTO.setIsRead(true);
						}
					}
				}
			}
			//排序
			Collections.sort(result, new Comparator<MobileMsgsListBackDTO>() {            	 
    			@Override
    			public int compare(MobileMsgsListBackDTO o1, MobileMsgsListBackDTO o2) {    			
    				return -o1.getCreateTime().compareTo(o2.getCreateTime());
    			}
    		});
			return Result.success(new PageInfo<>(result));
		} catch (Exception e) {
            log.error("获取移动终端消息列表出错:"+e);
            return Result.fail("获取移动终端消息列表出错");
		}
	}
	/**
     * 获取移动终端消息未读数量
     *
     * @param openApiReq
     * @return
     */
	@RequestMapping(value = "/mobile/readnum", method = RequestMethod.GET)
	@ApiOperation(value="获取移动终端消息未读数量",notes = "获取移动终端消息未读数量")
	public Result<MobileNewReadDTO> queryMobileIsRead(Long userId) {
		if(userId==null||userId==0){
			return Result.fail("参数错误");
		}
		try {
			//获取最新一条数据
			MobileMessageRecord mobileMessageRecord = mobileMessageRecordService.getNewest();
			if(mobileMessageRecord==null){
				return Result.fail("暂无消息");
			}
			MobileNewReadDTO mobileNewReadDTO = dozerUtils.map(mobileMessageRecord, MobileNewReadDTO.class);
			//获取消息总数
			int total = mobileMessageRecordService.getTotalNum();
			//获取已读数量
			int readNum = mobileMessageIsreadService.getReadNumByUserId(userId);
			int unread = 0;
			if(total!=0){
				unread = total - readNum;
			}
			mobileNewReadDTO.setReadNum(unread);					
			return Result.success(mobileNewReadDTO);
		} catch (Exception e) {
            log.error("获取移动终端消息未读数量出错:"+e);
            return Result.fail("获取移动终端消息未读数量出错");
		}
	}
    /**
     * 移动终端消息未读转已读
     * @param openApiReq
     * @return
     */
	@RequestMapping(value = "/mobile/isread", method = RequestMethod.POST)
	@ApiOperation(value="移动终端消息未读转已读",notes = "移动终端消息未读转已读")
	public Result<Boolean> saveMobileIsRead(Long userId, Long msgId) {
		if(userId==null||msgId==null||userId==0||msgId==0){
			return Result.fail("参数错误");
		}
		try {
			MobileMessageIsread mobileMessageIsread = new MobileMessageIsread();
			mobileMessageIsread.setMsgId(msgId);
			mobileMessageIsread.setUserId(userId);
			mobileMessageIsread.setCreateTime(new Date());
			mobileMessageIsreadService.save(mobileMessageIsread);
			return Result.success(true);
		} catch (Exception e) {
            log.error("移动终端消息未读转已读出错:"+e);
            return Result.fail("移动终端消息未读转已读出错");
		}
	}
    /**
     * 组装分页列表数据
     * @return
     */
    private List<MsgsListBackDTO> getMsgsList(List<MsgsMessageChannel> channels,List<MsgsListDO> list){
    	List<MsgsListBackDTO> result = new ArrayList<MsgsListBackDTO>();
    	if(!Util.isEmpty(channels)){
    		for(MsgsListDO msgsListDO:list){
    			MsgsListBackDTO msgsListBackDTO = new MsgsListBackDTO();
    			Long msgId = msgsListDO.getId();
    			String channelName = "";
    			for(MsgsMessageChannel msgsMessageChannel:channels){
    				Long msgid = msgsMessageChannel.getMessageId();
    				if(msgId==msgid||msgId.equals(msgid)){
    					channelName += msgsMessageChannel.getChannel()+",";
    				}
    			}
    			if(!Util.isEmptyString(channelName)){
    				channelName = channelName.substring(0, channelName.length()-1);
    			}
    			msgsListBackDTO.setId(msgId);
    			msgsListBackDTO.setChannelName(channelName);
    			msgsListBackDTO.setSendTime(Util.dateToStr(msgsListDO.getSendTime()));
    			msgsListBackDTO.setTitle(msgsListDO.getTitle());
    			result.add(msgsListBackDTO);
    		}    		
    	}else{
        	Set<Long> ids = new HashSet<Long>();
        	for(MsgsListDO msgsListDO:list){
        		ids.add(msgsListDO.getId());
        	}
        	for(Long id:ids){
        		String name = "";
        		String title = "";
        		Date sendTime = null;
        		MsgsListBackDTO msgsListBackDTO = new MsgsListBackDTO();
        		for(MsgsListDO msgsListDO:list){
        			String channelName = msgsListDO.getChannelName();
        			Long msgId = msgsListDO.getId();
        			if(msgId==id||msgId.equals(id)){
        				name += channelName+",";
        				title = msgsListDO.getTitle();
        				sendTime = msgsListDO.getSendTime();
        			}	
        		} 
    			if(!Util.isEmptyString(name)){
    				name = name.substring(0, name.length()-1);
    			}
    			msgsListBackDTO.setId(id);
    			msgsListBackDTO.setTitle(title);
    			if(sendTime!=null){
    				msgsListBackDTO.setSendTime(Util.dateToStr(sendTime));
    			}   			
    			msgsListBackDTO.setChannelName(name);
    			result.add(msgsListBackDTO);
        	}   		
    	}
		return result;    	
    }
    /**
	 * 组装发送情况信息
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<MsgChannelTypeDTO> getSendStatus(JSONObject obj){
		List<MsgChannelTypeDTO> list = new ArrayList<MsgChannelTypeDTO>();
		try {
	        if(obj.get("Wechat")!=null){
	        	MsgChannelTypeDTO msgChannelTypeDTO = new MsgChannelTypeDTO();
				msgChannelTypeDTO.setName("微信");
	        	String weChat = String.valueOf(obj.get("Wechat"));
	        	JSONObject json = JSONObject.fromObject(weChat);	        	
	        	List<MsgChannelTypeChaildDTO> chaildList = new ArrayList<MsgChannelTypeChaildDTO>();
	        	if(json.get("success")!=null){
	        		List<String> success = (List<String>) json.get("success");	        		
	        		for(String name:success){	
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("success");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}	        		
	        	}
	        	if(json.get("error")!=null){
	        		List<String> error = (List<String>) json.get("error");
	        		for(String name:error){
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("error");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}
	        	}
	        	if(!Util.isEmpty(chaildList)){
	        		msgChannelTypeDTO.setChaild(chaildList);
	        	}else{
	        		msgChannelTypeDTO.setChaild(null);
	        	}	
	        	list.add(msgChannelTypeDTO);
	        }
	        
			if(obj.get("Blog")!=null){
				MsgChannelTypeDTO msgChannelTypeDTO = new MsgChannelTypeDTO();
				msgChannelTypeDTO.setName("微博");
	        	String blog = String.valueOf(obj.get("Blog"));
	        	JSONObject json = JSONObject.fromObject(blog);	        	
	        	List<MsgChannelTypeChaildDTO> chaildList = new ArrayList<MsgChannelTypeChaildDTO>();
	        	if(json.get("success")!=null){
	        		List<String> success = (List<String>) json.get("success");	        		
	        		for(String name:success){	
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("success");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}	        		
	        	}
	        	if(json.get("error")!=null){
	        		List<String> error = (List<String>) json.get("error");
	        		for(String name:error){
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("error");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}
	        	}
	        	if(!Util.isEmpty(chaildList)){
	        		msgChannelTypeDTO.setChaild(chaildList);
	        	}else{
	        		msgChannelTypeDTO.setChaild(null);
	        	}	
	        	list.add(msgChannelTypeDTO);
	        }	        
	        if(obj.get("Public")!=null){	        		        	 
	        	MsgChannelTypeDTO msgChannelTypeDTO = new MsgChannelTypeDTO();
				msgChannelTypeDTO.setName("公示平台");
				String publicSys = String.valueOf(obj.get("Public"));
	        	JSONObject json = JSONObject.fromObject(publicSys);	        	
	        	List<MsgChannelTypeChaildDTO> chaildList = new ArrayList<MsgChannelTypeChaildDTO>();
	        	if(json.get("success")!=null){
	        		List<String> success = (List<String>) json.get("success");	        		
	        		for(String name:success){	
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("success");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}	        		
	        	}
	        	if(json.get("error")!=null){
	        		List<String> error = (List<String>) json.get("error");
	        		for(String name:error){
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("error");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}
	        	}
	        	if(!Util.isEmpty(chaildList)){
	        		msgChannelTypeDTO.setChaild(chaildList);
	        	}else{
	        		msgChannelTypeDTO.setChaild(null);
	        	}	
	        	list.add(msgChannelTypeDTO);
	        }	        
	        if(obj.get("Mobile")!=null){	        		        	 
	        	MsgChannelTypeDTO msgChannelTypeDTO = new MsgChannelTypeDTO();
				msgChannelTypeDTO.setName("移动终端");
				String mobile = String.valueOf(obj.get("Mobile"));
	        	JSONObject json = JSONObject.fromObject(mobile);	        	
	        	List<MsgChannelTypeChaildDTO> chaildList = new ArrayList<MsgChannelTypeChaildDTO>();
	        	if(json.get("success")!=null){
	        		List<String> success = (List<String>) json.get("success");	        		
	        		for(String name:success){	
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("success");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}	        		
	        	}
	        	if(json.get("error")!=null){
	        		List<String> error = (List<String>) json.get("error");
	        		for(String name:error){
	        			MsgChannelTypeChaildDTO msgChannelTypeChaildDTO = new MsgChannelTypeChaildDTO();
	        			msgChannelTypeChaildDTO.setName(name);
	        			msgChannelTypeChaildDTO.setStatus("error");
	        			chaildList.add(msgChannelTypeChaildDTO);
	        		}
	        	}
	        	if(!Util.isEmpty(chaildList)){
	        		msgChannelTypeDTO.setChaild(chaildList);
	        	}else{
	        		msgChannelTypeDTO.setChaild(null);
	        	}	
	        	list.add(msgChannelTypeDTO);
	        }
	        return list;
		} catch (Exception e) {
			return null;
		}			
	}
}
