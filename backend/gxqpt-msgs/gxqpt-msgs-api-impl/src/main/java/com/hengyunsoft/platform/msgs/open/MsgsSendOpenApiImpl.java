package com.hengyunsoft.platform.msgs.open;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.MsgExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.biz.MessageService;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTypeChaildDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTypeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgDetailDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageOpenReqDTO;
import com.hengyunsoft.platform.msgs.dto.msg.OpenChannelDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsListDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.MsgsMessageQueryDO;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessagechannel.po.MsgsMessageChannel;
import com.hengyunsoft.platform.msgs.open.msg.MsgsSendOpenApi;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;
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
@Api(value = "发布管道服务", description = "发布管道服务")
public class MsgsSendOpenApiImpl implements MsgsSendOpenApi{
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private MsgsChannelService msgsChannelService;
    @Autowired
    private MsgsMessageService msgsMessageService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MsgsMessageChannelService msgsMessageChannelService;
    
    /**
     * 获取渠道接口
     */
	@Override
	@ApiOperation(value="获取渠道接口",notes = "获取渠道接口")
    @ApiResponses({
        @ApiResponse(code = 70001, message = "用户id不能为空"),
        @ApiResponse(code = 4, message = "获取渠道失败")
    })
	public Result<List<OpenChannelDTO>> getChannelList(@RequestParam(value = "userId") Long userId) {
		try {
			if(userId==null){
				BizAssert.assertNotNull(MsgExceptionCode.USERID_NULL,userId);
			}
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            msgsChannelExample.createCriteria().andCreateUserEqualTo(userId);            
            List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
            List<OpenChannelDTO> result = dozerUtils.mapList(list, OpenChannelDTO.class);           
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取渠道出错",e);
			return Result.fail(4,"获取渠道失败");
		}		
	}
	/**
	 * 查询已发送信息分页列表
	 * @return
	 */	
	@Override
	@ApiOperation(value="已发送信息分页列表",notes = "已发送信息分页列表")
    @ApiResponses({
        @ApiResponse(code = 3, message = "用户id不能为空"),
        @ApiResponse(code = 4, message = "查询失败")
    })
	public Result<PageInfo<MsgsListBackDTO>> getMsgsPage(@RequestBody OpenApiReq<MsgsMessageOpenReqDTO> openApiReq) {
		try{           
			MsgsMessageOpenReqDTO msgsMessageOpenReqDTO = openApiReq.getData();
        	if(msgsMessageOpenReqDTO==null){
        		return null;
        	}
        	Long adminId = msgsMessageOpenReqDTO.getUserId();
        	if(adminId==null){
        		return Result.fail(3,"用户id不能为空");
        	}
        	msgsMessageOpenReqDTO.setUserId(adminId);
            String name = msgsMessageOpenReqDTO.getName();
            Long type = msgsMessageOpenReqDTO.getChannelType();
            if(!Util.isEmptyString(name)){
            	msgsMessageOpenReqDTO.setName("%"+name+"%");
            }            
            MsgsMessageQueryDO msgsMessageQueryDO = dozerUtils.map(msgsMessageOpenReqDTO, MsgsMessageQueryDO.class);
            msgsMessageQueryDO.setMsgStatus(0L);
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<MsgsListDO> list = msgsMessageService.getMsgsList(msgsMessageQueryDO);            
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
            return Result.success(new PageInfo<>(result));
        }catch (Exception e){
           log.error("获取信息分页列表出错:"+e);
           return Result.fail(4,"查询失败，请稍后重试！");
        }
	}
	
	/**
	 * 获取信息详情
	 * @return
	 */	
	@Override
	@ApiOperation(value="获取信息详情",notes = "获取信息详情")
    @ApiResponses({
        @ApiResponse(code = 2, message = "信息不存在"),
        @ApiResponse(code = 4, message = "查询失败"),
        @ApiResponse(code = 70000, message = "id不能为空")
    })
	public Result<MsgDetailDTO> getMsgDetail(@RequestParam(value = "id")Long msgId) {
		try{
			if(msgId==null){
				BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, msgId);
			}
			MsgsMessage msgsMessage = msgsMessageService.getById(msgId);
			if(msgsMessage==null){
				return Result.fail(2,"信息不存在");
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
			}		
			//信息发送情况
            JSONObject obj = messageService.getErrorInfo(Long.toString(msgId));//根据消息id查询所有类型发送成功、失败的个数
            if(obj!=null){
                msgDetailDTO.setSuccessNum(String.valueOf(obj.get("success")));
                msgDetailDTO.setFailNum(String.valueOf(obj.get("error")));
                List<MsgChannelTypeDTO> list = getSendStatus(obj);
                msgDetailDTO.setStatus(list);
            }
            return Result.success(msgDetailDTO);
        } catch (Exception e){
            log.error("消息根据id查询详情出错:"+e);
            return Result.fail(4,"查询失败，请稍后重试！");
        }
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
			log.error("组装发送情况信息出错"+e);
			return null;
		}			
	}
	 /**
     * 组装数据
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
}
