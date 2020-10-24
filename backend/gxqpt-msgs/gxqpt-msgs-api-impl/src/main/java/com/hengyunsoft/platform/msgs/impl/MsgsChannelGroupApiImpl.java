package com.hengyunsoft.platform.msgs.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MsgExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupDTO;
import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupDetailBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupSaveDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelChildDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelChildTreeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelGroupQueryDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelGroupSelectDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.ChannelGroup;
import com.hengyunsoft.platform.msgs.entity.channelgroup.po.ChannelGroupRelation;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.dos.ChannelNamesDO;
import com.hengyunsoft.platform.msgs.repository.channelgroup.example.ChannelGroupExample;
import com.hengyunsoft.platform.msgs.repository.channelgroup.service.ChannelGroupRelationService;
import com.hengyunsoft.platform.msgs.repository.channelgroup.service.ChannelGroupService;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "渠道群组管理", description = "渠道群组管理")
public class MsgsChannelGroupApiImpl {
    @Autowired
    private ChannelGroupService channelGroupService;
    @Autowired
    private ChannelGroupRelationService channelGroupRelationService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 获取渠道群组分页列表
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/channelgroup/query", method = RequestMethod.POST)
    @ApiOperation(value="获取渠道群组分页列表",notes = "获取渠道群组分页列表")
    public Result<PageInfo<ChannelGroupDTO>> pageQuery(@RequestBody OpenApiReq<MsgsChannelGroupQueryDTO> openApiReq) {
        try{                    	
            MsgsChannelGroupQueryDTO msgsChannelGroupQueryDTO = openApiReq.getData();
            if(msgsChannelGroupQueryDTO==null){
            	return Result.fail("参数错误");
            }
            //获取渠道群组信息
            Long userId = BaseContextHandler.getAdminId();
            ChannelGroupExample channelGroupExample = new ChannelGroupExample();           
            ChannelGroupExample.Criteria criteria = channelGroupExample.createCriteria();
            criteria.andCreateUserEqualTo(userId);
            String name = msgsChannelGroupQueryDTO.getName();
            if(!Util.isEmptyString(name)){
            	criteria.andNameLike(ChannelGroupExample.fullLike(name));            	
            }
            if(msgsChannelGroupQueryDTO.getCreateTimeStart()!=null){
            	criteria.andCreateTimeGreaterThan(msgsChannelGroupQueryDTO.getCreateTimeStart());            	
            }
            if(msgsChannelGroupQueryDTO.getCreateTimeEnd()!=null){
            	criteria.andCreateTimeLessThan(msgsChannelGroupQueryDTO.getCreateTimeEnd());            	
            }
            List<ChannelGroup> list = channelGroupService.find(channelGroupExample);
            if(Util.isEmpty(list)){
            	return Result.success(null);
            }
            //获取群组包含渠道id
            Set<Long> groupSet = new HashSet<Long>();
            for(ChannelGroup channelGroup:list){
            	Long id = channelGroup.getId();
            	groupSet.add(id);
            }
            List<ChannelNamesDO> names = channelGroupRelationService.getChannelNames(groupSet);
            //组装渠道数据
            List<ChannelGroupDTO> result = getGroupList(list,names);
            return Result.success(new PageInfo<>(result));
        }catch (Exception e){
            log.error("获取渠道群组分页列表出错"+e);
            return Result.fail("获取渠道群组分页列表出错");
        }
    }
    
    /**
     * 获取所有渠道群组列表
     * @param
     * @return
     */
    @RequestMapping(value = "/channelgroup/all", method = RequestMethod.GET)
    @ApiOperation(value="获取所有渠道群组列表",notes = "获取所有渠道群组列表")
    public Result<List<MsgsChannelGroupSelectDTO>> allQuery(@RequestParam String name) {
        try{
        	Long userId = BaseContextHandler.getAdminId();
        	ChannelGroupExample channelGroupExample = new ChannelGroupExample();
            if(StringUtil.isNotEmpty(name)){
            	channelGroupExample.createCriteria().andNameLike(ChannelGroupExample.fullLike(name)).andCreateUserEqualTo(userId);
            }else{
            	channelGroupExample.createCriteria().andCreateUserEqualTo(userId);
            }
            channelGroupExample.setOrderByClause(" create_time desc ");
            List<ChannelGroup> list = channelGroupService.find(channelGroupExample);
            List<MsgsChannelGroupSelectDTO> result = dozerUtils.mapPage(list, MsgsChannelGroupSelectDTO.class);
            return Result.success(result);
        }catch (Exception e){
            log.error("获取所有渠道群组列表出错:"+e);
            return Result.fail("获取所有渠道群组列表出错");
        }
    }   
    /**
     * 删除渠道群组
     * @param id
     * @return
     */
    @RequestMapping(value = "/channelgroup/delete", method = RequestMethod.POST)
    @ApiOperation(value="删除渠道群组",notes = "删除渠道群组")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不允许为空"),
    })
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        try{
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL,id);
            int result = channelGroupService.deleteById(id);
            if(result<0){
            	return Result.success(false);
            }
            channelGroupRelationService.deleteByGroupId(id);
            return Result.success(true);
        }catch (Exception e){
            log.error("删除渠道群组出错"+e);
            return Result.fail("删除渠道群组出错");
        }
    }
    /**
     * 新增渠道群组
     * @param msgsChannelGroupSaveDTO
     * @return
     */
    @RequestMapping(value = "/channelgroup/save", method = RequestMethod.POST)
    @ApiOperation(value="新增渠道群组",notes = "新增渠道群组")
    @ApiResponses({
        @ApiResponse(code = 71002, message = "渠道群组名称不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = ChannelGroup.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<String> save(@RequestBody ChannelGroupSaveDTO channelGroupSaveDTO) {
        try{
            BizAssert.assertNotNull(MsgExceptionCode.CHANNELGROUP_NAME_EMPTY, channelGroupSaveDTO.getName());
            List<Long> channelIds = channelGroupSaveDTO.getChannelIds();
            if(Util.isEmpty(channelIds)){
            	return Result.fail("群组包含渠道不能为空");
            }
            Long adminId = BaseContextHandler.getAdminId();
            ChannelGroupExample channelGroupExample = new ChannelGroupExample();
            channelGroupExample.createCriteria().andNameEqualTo(channelGroupSaveDTO.getName());
            List<ChannelGroup> ls = channelGroupService.find(channelGroupExample);
            if (ls!=null&&ls.size()>0){
                return Result.fail("渠道组名称不能重复");
            }
            //保存群组表
            ChannelGroup channelGroup = new ChannelGroup();
            channelGroup.setId(channelGroupService.genId());
            channelGroup.setName(channelGroupSaveDTO.getName());
            channelGroup.setChannelExplain(channelGroupSaveDTO.getExplain());
            channelGroup.setCreateTime(new Date());
            channelGroup.setCreateUser(adminId);
            channelGroup.setCreateUserName(BaseContextHandler.getName());
            ChannelGroup result = channelGroupService.save(channelGroup);
            Long groupId = result.getId();
            //保存关系表
            List<ChannelGroupRelation> list = new ArrayList<ChannelGroupRelation>();          
            for(Long id:channelIds){
            	ChannelGroupRelation channelGroupRelation = new ChannelGroupRelation();
            	channelGroupRelation.setId(channelGroupRelationService.genId());
            	channelGroupRelation.setChannelId(id);
            	channelGroupRelation.setChannelGroupId(groupId);
            	channelGroupRelation.setCreateTime(new Date());
            	list.add(channelGroupRelation);
            }
            channelGroupRelationService.save(list);
            return Result.success("保存成功");
        }catch (Exception e){
            log.error("新增渠道群组出错"+e);
            return Result.fail("新增渠道群组出错");
        }
    }
    /**
     * 更新渠道群组
     * @param msgsChannelGroupSaveDTO
     * @return
     */
    @RequestMapping(value = "/channelgroup/update", method = RequestMethod.POST)
    @ApiOperation(value="更新渠道群组",notes = "更新渠道群组")
    @ApiResponses({
        @ApiResponse(code = 71002, message = "渠道群组名称不能为空"),
        @ApiResponse(code = 70000, message = "ID不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = ChannelGroup.class)
            }
    )
    public Result<String> update(@RequestBody ChannelGroupSaveDTO channelGroupSaveDTO) {
        try{
            BizAssert.assertNotNull(MsgExceptionCode.CHANNELGROUP_NAME_EMPTY, channelGroupSaveDTO.getName());
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL,  channelGroupSaveDTO.getId());
            List<Long> channelIds = channelGroupSaveDTO.getChannelIds();
            if(Util.isEmpty(channelIds)){
            	return Result.fail("群组包含渠道不能为空");
            }
            //校验重名
            ChannelGroupExample channelGroupExample = new ChannelGroupExample();
            channelGroupExample.createCriteria().andNameEqualTo(channelGroupSaveDTO.getName())
            .andIdNotEqualTo(channelGroupSaveDTO.getId());
            List<ChannelGroup> ls = channelGroupService.find(channelGroupExample);
            if (ls!=null&&ls.size()>0){
                return Result.fail("渠道组名称不能重复");
            }
            //删除关系表
            Long groupId = channelGroupSaveDTO.getId();
            channelGroupRelationService.deleteByGroupId(groupId);
            //更新关系表
            List<ChannelGroupRelation> list = new ArrayList<ChannelGroupRelation>();          
            for(Long id:channelIds){
            	ChannelGroupRelation channelGroupRelation = new ChannelGroupRelation();
            	channelGroupRelation.setId(channelGroupRelationService.genId());
            	channelGroupRelation.setChannelId(id);
            	channelGroupRelation.setChannelGroupId(groupId);
            	channelGroupRelation.setCreateTime(new Date());
            	list.add(channelGroupRelation);
            }
            channelGroupRelationService.save(list);
            //更新群组表
            ChannelGroup channelGroup = new ChannelGroup();
            channelGroup.setId(groupId);
            channelGroup.setName(channelGroupSaveDTO.getName());
            channelGroup.setChannelExplain(channelGroupSaveDTO.getExplain());
            channelGroup.setUpdateTime(new Date());
            channelGroup.setUpdateUser(BaseContextHandler.getAdminId());
            int result = channelGroupService.updateByIdSelective(channelGroup);
            if(result<0){
            	return Result.fail("更新失败");
            }else{
            	return Result.success("更新成功");
            }           
        }catch (Exception e){
            log.error("更新渠道群组出错"+e);
            return Result.fail("更新渠道群组出错");
        }
    }     
    /**
     * 获取群组包含子渠道
     * @param id
     * @return
     */
    @RequestMapping(value = "/channelgroup/detail", method = RequestMethod.GET)
	@ApiOperation(value="获取群组包含子渠道",notes = "获取群组包含子渠道")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不能为空"),
    })
	public Result<List<MsgChannelChildTreeDTO>> getGroupDetail(Long id) {
		try{
			BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, id);
			List<MsgChannelChildTreeDTO> list = new ArrayList<MsgChannelChildTreeDTO>();            
            List<MsgsChannel> channels = channelGroupRelationService.getByGroupId(id);
            if(Util.isEmpty(channels)){
            	return Result.success(null);
            }         
            for(MsgsChannel msgsChannel:channels){
            	MsgChannelChildTreeDTO msgChannelChildTreeDTO = new MsgChannelChildTreeDTO();
            	msgChannelChildTreeDTO.setId(msgsChannel.getId());
            	msgChannelChildTreeDTO.setName(msgsChannel.getName());
            	msgChannelChildTreeDTO.setType(String.valueOf(msgsChannel.getChannelType()));
            	list.add(msgChannelChildTreeDTO);           	
            }
            return Result.success(list);
        }catch (Exception e){
            log.error("获取群组包含子渠道异常:"+e);
            return Result.fail("获取群组包含子渠道出错");
        }
	}
    /**
     * 获取群组详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/channelgroup/get", method = RequestMethod.GET)
	@ApiOperation(value="获取群组详情",notes = "获取群组详情")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不能为空"),
    })
	public Result<ChannelGroupDetailBackDTO> selectGroupDetail(Long id) {
		try {
			BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, id);
			ChannelGroupDetailBackDTO channelGroupDetailBackDTO = new ChannelGroupDetailBackDTO();
			//获取群组信息
			ChannelGroup channelGroup = channelGroupService.getById(id);
			if(channelGroup==null){
				return Result.fail("渠道群组不存在");
			}
			channelGroupDetailBackDTO.setName(channelGroup.getName());
			channelGroupDetailBackDTO.setExplain(channelGroup.getChannelExplain());
			//获取包含渠道信息			           
            List<MsgsChannel> channels = channelGroupRelationService.getByGroupId(id);
            if(Util.isEmpty(channels)){
            	channelGroupDetailBackDTO.setChannels(null);
            }else{
                List<MsgChannelChildDTO> list = getChannelMsg(channels); 
                channelGroupDetailBackDTO.setChannels(list);
            }         
			return Result.success(channelGroupDetailBackDTO);
		} catch (Exception e) {
            log.error("获取群组详情异常:"+e);
            return Result.fail("获取群组详情出错");
		}
	}
    /**
     * 获取渠道关系
     * @return
     */
    @RequestMapping(value = "/channel/relation", method = RequestMethod.GET)
	@ApiOperation(value="获取渠道关系",notes = "获取渠道关系")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不能为空"),
    })
	public Result<List<Long>> queryGroupRelation(Long id) {
		BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, id);
		try {
			List<Long> result = new ArrayList<Long>();
			List<MsgsChannel> list = channelGroupRelationService.getByGroupId(id);
			if(Util.isEmpty(list)){
				return Result.success(null);
			}
			for(MsgsChannel msgsChannel:list){
				Long channelId = msgsChannel.getId();
				result.add(channelId);
			}			
			return Result.success(result);
		} catch (Exception e) {
			 log.error("获取渠道关系异常:"+e);
	         return Result.fail("获取渠道关系出错");
		}				
	}
	
	/**
     * 组装渠道数据
     */
    private List<ChannelGroupDTO> getGroupList(List<ChannelGroup> list,List<ChannelNamesDO> names){
    	List<ChannelGroupDTO> result = new ArrayList<ChannelGroupDTO>();
    	for(ChannelGroup channelGroup:list){
    		ChannelGroupDTO channelGroupDTO = new ChannelGroupDTO();
    		Long id = channelGroup.getId();
    		String name = "";
    		for(ChannelNamesDO channelNamesDO:names){
    			Long naId = channelNamesDO.getId();
    			if(naId.equals(id)||naId==id){
    				name += channelNamesDO.getName()+",";
    			}    			
    		}
    		if(!Util.isEmptyString(name)){
    			name = name.substring(0, name.length()-1);
    		}
    		channelGroupDTO.setChannelNames(name);
    		channelGroupDTO.setCreateTime(channelGroup.getCreateTime());
    		channelGroupDTO.setExplain(channelGroup.getChannelExplain());
    		channelGroupDTO.setId(id);
    		channelGroupDTO.setName(channelGroup.getName());
    		result.add(channelGroupDTO);
    	}
    	return result;
    }
	/**
	 * 组装渠道信息
	 */
	private List<MsgChannelChildDTO> getChannelMsg(List<MsgsChannel> channels){	
		List<MsgChannelChildDTO> list = new ArrayList<MsgChannelChildDTO>();
		String weChat = "";
        String blog = "";
        String publicSys = "";
        String mobile = "";
        for(MsgsChannel msgsChannel:channels){        	
        	Integer type = msgsChannel.getChannelType();
        	String name = msgsChannel.getName();
        	if(type==1){
        		weChat += name+";";
        	}
        	if(type==2){
        		blog += name+";";
        	}
        	if(type==4){
        		publicSys += name+";";
        	}
        	if(type==5){
        		mobile += name+";";
        	}
        }
		if(!Util.isEmptyString(weChat)){
			weChat = weChat.substring(0, weChat.length()-1);
			MsgChannelChildDTO msgChannelChildDTO = new MsgChannelChildDTO();			
			msgChannelChildDTO.setType("微信");
			msgChannelChildDTO.setName(weChat);
			list.add(msgChannelChildDTO);
		}
		if(!Util.isEmptyString(blog)){
			blog = blog.substring(0, blog.length()-1);
			MsgChannelChildDTO msgChannelChildDTO = new MsgChannelChildDTO();			
			msgChannelChildDTO.setType("微博");
			msgChannelChildDTO.setName(blog);
			list.add(msgChannelChildDTO);
		}
		if(!Util.isEmptyString(publicSys)){
			publicSys = publicSys.substring(0, publicSys.length()-1);
			MsgChannelChildDTO msgChannelChildDTO = new MsgChannelChildDTO();			
			msgChannelChildDTO.setType("公示平台");
			msgChannelChildDTO.setName(publicSys);
			list.add(msgChannelChildDTO);
		}
		if(!Util.isEmptyString(mobile)){
			mobile = mobile.substring(0, mobile.length()-1);
			MsgChannelChildDTO msgChannelChildDTO = new MsgChannelChildDTO();			
			msgChannelChildDTO.setType("移动终端");
			msgChannelChildDTO.setName(mobile);
			list.add(msgChannelChildDTO);
		}
		return list;
	}
}
