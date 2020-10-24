package com.hengyunsoft.platform.msgs.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.groups.Default;

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
import com.hengyunsoft.platform.msgs.constant.MessageConstant;
import com.hengyunsoft.platform.msgs.constant.MsgConstant;
import com.hengyunsoft.platform.msgs.dto.ChannelMsgDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelChildTreeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTreeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelByTypeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelQueryDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelSaveDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeSelectDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelUpdateDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.channeltype.po.MsgsChannelType;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.channelgroup.service.ChannelGroupRelationService;
import com.hengyunsoft.platform.msgs.repository.channeltype.example.MsgsChannelTypeExample;
import com.hengyunsoft.platform.msgs.repository.channeltype.service.MsgsChannelTypeService;
import com.hengyunsoft.platform.msgs.utils.HttpClientEx;
import com.hengyunsoft.platform.msgs.utils.RedisUtils;
import com.hengyunsoft.platform.msgs.utils.TockenResult;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
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
@Api(value = "渠道管理", description = "渠道管理")
public class MsgsChannelApiImpl {
	
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private MsgsChannelService msgsChannelService;
    @Autowired
    private MsgsChannelTypeService msgsChannelTypeService;
    @Autowired
    private ChannelGroupRelationService channelGroupRelationService;
	@Autowired
	private RedisUtils redisUtil;
    /**
     * 根据类型id查询渠道列表
     *
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/channel/getChannelByType", method = RequestMethod.POST)
    @ApiOperation(value="获取渠道列表",notes = "获取渠道列表")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "类型ID不允许为空"),
    })
    public Result<PageInfo<MsgsChannelByTypeDTO>> getChannelByType(@RequestParam(value = "typeId") Integer typeId) {
        try{
            //1，验证
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, typeId);
            MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            if (typeId != 0) {
                msgsChannelExample.createCriteria().andChannelTypeEqualTo(typeId);
            }
            msgsChannelExample.setOrderByClause(" create_time desc ");
            PageHelper.startPage(0, 100);
            List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
            List<MsgsChannelByTypeDTO> pageList = dozerUtils.mapPage(list, MsgsChannelByTypeDTO.class);
            return Result.success(new PageInfo<>(pageList));
        }catch (Exception e){
            log.error("获取渠道列表出错"+e);
            return Result.fail("获取渠道列表出错");
        }
    }

    /**
     * 渠道分页查询
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/channel/query", method = RequestMethod.POST)
    @ApiOperation(value="获取渠道分页列表",notes = "获取渠道分页列表")
    public Result<PageInfo<MsgsChannelDTO>> query(@RequestBody OpenApiReq<MsgsChannelQueryDTO> openApiReq) {
    	try{
            //1，验证
            Long adminId = BaseContextHandler.getAdminId();
            MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            if (openApiReq != null) {
                MsgsChannelQueryDTO msgsChannelQueryDTO = (MsgsChannelQueryDTO) openApiReq.getData();
                if (msgsChannelQueryDTO != null){
                    msgsChannelExample.createCriteria().andChannelTypeEqualTo(msgsChannelQueryDTO.getChannelType())
                    .andNameLike(MsgsChannelExample.fullLike(msgsChannelQueryDTO.getName()))
                    .andCreateUserEqualTo(adminId).andChannelTypeNotEqualTo(3)
                    .andCreateTimeGreaterThanOrEqualTo(msgsChannelQueryDTO.getCreateTimeStart())
                    .andCreateTimeLessThanOrEqualTo(msgsChannelQueryDTO.getCreateTimeEnd());
                }else{
                	msgsChannelExample.createCriteria().andCreateUserEqualTo(adminId).andChannelTypeNotEqualTo(3);//根据登录人id
                }                    
            }else{
                msgsChannelExample.createCriteria().andCreateUserEqualTo(adminId);//根据登录人id
            }
            msgsChannelExample.setOrderByClause(" create_time desc ");
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
            List<MsgsChannelDTO> pageList = dozerUtils.mapPage(list, MsgsChannelDTO.class);
            return Result.success(new PageInfo<>(pageList));
    	} catch (Exception e){
    		log.error("获取渠道分页列表出错"+e);
    		return Result.fail("获取渠道分页列表出错");
      	}
    }

    /**
     * 查看分类详情
     * @param id
     */
    @RequestMapping(value = "/channel/get", method = RequestMethod.GET)
    @ApiOperation(value="获取渠道分类详情",notes = "获取渠道分类详情")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不允许为空"),
    })
    public Result<MsgsChannelDTO> get(@RequestParam(value = "id") Long id) {
        //1，验证
        try{
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, id);
            MsgsChannel msgsChannel  = msgsChannelService.getById(id);
            return Result.success(dozerUtils.map(msgsChannel, MsgsChannelDTO.class));
        }catch (Exception e){
            log.error("获取渠道分类详情出错"+e);
            return Result.fail("获取渠道分类详情出错");
        }
    }
    /**
     * 删除渠道
     * @param id
     * @return
     */
    @RequestMapping(value = "/channel/delete", method = RequestMethod.GET)
    @ApiOperation(value="删除渠道",notes = "删除渠道")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不允许为空"),
    })
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, id);
        try {        
        	//删除渠道群组关联
        	channelGroupRelationService.deleteByChannelId(id);
        	//删除渠道
        	int i = msgsChannelService.deleteById(id);
	        if (i < 0) {
	            return Result.fail("删除失败");
	        } else {
	            return Result.success(true);
	        }
		} catch (Exception e) {
			log.error("删除渠道出错"+e);
	        return Result.fail("删除渠道出错");
		}
    }

    /**
     * 新增渠道
     */
    @RequestMapping(value = "/channel/save", method = RequestMethod.POST)
    @ApiOperation(value="新增渠道",notes = "新增渠道")
    @ApiResponses({
        @ApiResponse(code = 70501, message = "渠道分类不能为空"),
        @ApiResponse(code = 70502, message = "渠道名称不能为空"),
        @ApiResponse(code = 70504, message = "应用系统ID不能为空"),
        @ApiResponse(code = 70506, message = "密钥不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = MsgsChannel.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<String> save(@RequestBody MsgsChannelSaveDTO msgsChannelSaveDTO) {
        try{
        	//1，验证
            BizAssert.assertNotNull(MsgExceptionCode.CHANNELTYPE_EMPTY, msgsChannelSaveDTO.getChannelType());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNEL_NAME_EMPTY, msgsChannelSaveDTO.getName());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNEL_APPID_EMPTY, msgsChannelSaveDTO.getAppId());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNEL_APPPSECRET_EMPTY, msgsChannelSaveDTO.getAppSecret());
            MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            msgsChannelExample.createCriteria().andNameEqualTo(msgsChannelSaveDTO.getName());
            List<MsgsChannel> ls = msgsChannelService.find(msgsChannelExample);
            if(ls!=null&&ls.size()>0){
                return Result.fail("渠道名称已存在");
            } 
            Long adminId = BaseContextHandler.getAdminId();
            MsgsChannel msgsChannel = dozerUtils.map(msgsChannelSaveDTO, MsgsChannel.class);
            msgsChannel.setMsgCode("1");
            msgsChannel.setCreateTime(new Date());
            msgsChannel.setCreateUser(adminId);
            msgsChannel.setCreateUserName(BaseContextHandler.getName());            
            msgsChannel.setUpdateUser(adminId);
            msgsChannel.setUpdateTime(new Date());
            msgsChannel = msgsChannelService.save(msgsChannel);
            //刷新accesstoken
            getAccessToken(msgsChannel.getId());
            return Result.success("保存成功");
        }catch (Exception e){
            log.error("新增渠道出错"+e);
            return Result.fail("新增渠道出错");
        }
    }

    /**
     * 更新渠道
     */
    @RequestMapping(value = "/channel/update", method = RequestMethod.POST)
    @ApiOperation(value="更新渠道",notes = "更新渠道")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不允许为空"),
        @ApiResponse(code = 70501, message = "渠道分类不能为空"),
        @ApiResponse(code = 70502, message = "渠道名称不能为空"),
        @ApiResponse(code = 70504, message = "应用系统ID不能为空"),
        @ApiResponse(code = 70506, message = "密钥不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = MsgsChannel.class)
            }
    )
    public Result<String> update(@RequestBody MsgsChannelUpdateDTO msgsChannelUpdateDTO) {        
        try{
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, msgsChannelUpdateDTO.getId());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNELTYPE_EMPTY, msgsChannelUpdateDTO.getChannelType());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNEL_NAME_EMPTY, msgsChannelUpdateDTO.getName());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNEL_APPID_EMPTY, msgsChannelUpdateDTO.getAppId());
            BizAssert.assertNotNull(MsgExceptionCode.CHANNEL_APPPSECRET_EMPTY, msgsChannelUpdateDTO.getAppSecret());
            //获取渠道
            MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            msgsChannelExample.createCriteria().andNameEqualTo(msgsChannelUpdateDTO.getName())
            .andIdNotEqualTo(msgsChannelUpdateDTO.getId());
            List<MsgsChannel> ls = msgsChannelService.find(msgsChannelExample);
            if (ls!=null&&ls.size()>0){
                return Result.fail("渠道名称已存在");
            }
            MsgsChannel msgsChannel = new MsgsChannel();
            msgsChannel.setId(msgsChannelUpdateDTO.getId());
            msgsChannel.setName(msgsChannelUpdateDTO.getName());
            msgsChannel.setAppSecret(msgsChannelUpdateDTO.getAppSecret());
            msgsChannel.setDescription(msgsChannelUpdateDTO.getDescription());
            msgsChannel.setUpdateUser(BaseContextHandler.getAdminId());
            msgsChannel.setUpdateTime(new Date());
            int result = msgsChannelService.updateByIdSelective(msgsChannel);
            if (result > 0) {
                //刷新accesstoken
                getAccessToken(msgsChannel.getId());
                return Result.success("修改成功");
            } else {
                return Result.fail("更新渠道失败");
            }
        }catch (Exception e){
            log.error("更新渠道出错"+e);
            return Result.fail("更新渠道出错");
        }
    }
    /**
     * 获取渠道树
     * @param id
     * @return
     */
    @RequestMapping(value = "/channel/tree", method = RequestMethod.GET)
	@ApiOperation(value="获取渠道树",notes = "获取渠道树")
	public Result<List<MsgChannelTreeDTO>> getTree() {
		Long userId = BaseContextHandler.getAdminId();
		try {
			List<MsgChannelTreeDTO> result = new ArrayList<MsgChannelTreeDTO>();
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            msgsChannelExample.createCriteria().andCreateUserEqualTo(userId);            
            List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
            MsgChannelTreeDTO wchat = new MsgChannelTreeDTO();
            wchat.setId(1);
            wchat.setName("微信");
            wchat.setType("1");
            MsgChannelTreeDTO blog = new MsgChannelTreeDTO();
            blog.setId(2);
            blog.setName("微博");
            blog.setType("2");
            MsgChannelTreeDTO publicSys = new MsgChannelTreeDTO();
            publicSys.setId(3);
            publicSys.setName("公示平台");
            publicSys.setType("4");
            MsgChannelTreeDTO mobile = new MsgChannelTreeDTO();
            mobile.setId(4);
            mobile.setName("移动终端");
            mobile.setType("5");     
            List<MsgChannelChildTreeDTO> wechatList = new ArrayList<MsgChannelChildTreeDTO>();
            List<MsgChannelChildTreeDTO> blogList = new ArrayList<MsgChannelChildTreeDTO>();
            List<MsgChannelChildTreeDTO> publicList = new ArrayList<MsgChannelChildTreeDTO>();
            List<MsgChannelChildTreeDTO> mobileList = new ArrayList<MsgChannelChildTreeDTO>();
            for(MsgsChannel msgsChannel:list){
            	Integer type = msgsChannel.getChannelType();
            	String name = msgsChannel.getName();
            	Long id = msgsChannel.getId();
        		MsgChannelChildTreeDTO childTreeDTO = new MsgChannelChildTreeDTO();
        		childTreeDTO.setId(id);
        		childTreeDTO.setName(name);
            	if(type==1){
            		childTreeDTO.setType("1");
            		wechatList.add(childTreeDTO);
            	}
            	if(type==2){
            		childTreeDTO.setType("2");
            		blogList.add(childTreeDTO);
            	}
            	if(type==4){
            		childTreeDTO.setType("4");
            		publicList.add(childTreeDTO);
            	}
            	if(type==5){
            		childTreeDTO.setType("5");
            		mobileList.add(childTreeDTO);
            	}
            } 
            if(!Util.isEmpty(wechatList)){
            	wchat.setChildren(wechatList);
            	result.add(wchat);
            }
            if(!Util.isEmpty(blogList)){
            	blog.setChildren(blogList);
            	result.add(blog);
            }
            if(!Util.isEmpty(publicList)){
            	publicSys.setChildren(publicList);
            	result.add(publicSys);
            }
            if(!Util.isEmpty(mobileList)){
            	mobile.setChildren(mobileList);
            	result.add(mobile);
            }
            return Result.success(result);
		} catch (Exception e) {
            log.error("获取渠道树出错"+e);
            return Result.fail("获取渠道树出错");
		}
	}

    /**
     * 根据名称模糊查询渠道树
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/channel/like", method = RequestMethod.GET)
	@ApiOperation(value="根据名称模糊查询渠道树",notes = "根据名称模糊查询渠道树")
	public Result<List<MsgChannelTreeDTO>> getTreeByNameLike(@RequestParam(value = "name")String name) {
		Long userId = BaseContextHandler.getAdminId();
		try {
			List<MsgChannelTreeDTO> result = new ArrayList<MsgChannelTreeDTO>();
			MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            msgsChannelExample.createCriteria().andNameLike(MsgsChannelExample.fullLike(name)).andCreateUserEqualTo(userId);            
            List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
            MsgChannelTreeDTO wchat = new MsgChannelTreeDTO();
            wchat.setId(1);
            wchat.setName("微信");
            wchat.setType("1");
            MsgChannelTreeDTO blog = new MsgChannelTreeDTO();
            blog.setId(2);
            blog.setName("微博");
            blog.setType("2");
            MsgChannelTreeDTO publicSys = new MsgChannelTreeDTO();
            publicSys.setId(3);
            publicSys.setName("公示平台");
            publicSys.setType("4");
            MsgChannelTreeDTO mobile = new MsgChannelTreeDTO();
            mobile.setId(4);
            mobile.setName("移动终端");
            mobile.setType("5");     
            List<MsgChannelChildTreeDTO> wechatList = new ArrayList<MsgChannelChildTreeDTO>();
            List<MsgChannelChildTreeDTO> blogList = new ArrayList<MsgChannelChildTreeDTO>();
            List<MsgChannelChildTreeDTO> publicList = new ArrayList<MsgChannelChildTreeDTO>();
            List<MsgChannelChildTreeDTO> mobileList = new ArrayList<MsgChannelChildTreeDTO>();
            for(MsgsChannel msgsChannel:list){
            	Integer type = msgsChannel.getChannelType();
            	String channelName = msgsChannel.getName();
            	Long id = msgsChannel.getId();
        		MsgChannelChildTreeDTO childTreeDTO = new MsgChannelChildTreeDTO();
        		childTreeDTO.setId(id);
        		childTreeDTO.setName(channelName);
            	if(type==1){
            		childTreeDTO.setType("1");
            		wechatList.add(childTreeDTO);
            	}
            	if(type==2){
            		childTreeDTO.setType("2");
            		blogList.add(childTreeDTO);
            	}
            	if(type==4){
            		childTreeDTO.setType("4");
            		publicList.add(childTreeDTO);
            	}
            	if(type==5){
            		childTreeDTO.setType("5");
            		mobileList.add(childTreeDTO);
            	}
            } 
            if(!Util.isEmpty(wechatList)){
            	wchat.setChildren(wechatList);
            	result.add(wchat);
            }
            if(!Util.isEmpty(blogList)){
            	blog.setChildren(blogList);
            	result.add(blog);
            }
            if(!Util.isEmpty(publicList)){
            	publicSys.setChildren(publicList);
            	result.add(publicSys);
            }
            if(!Util.isEmpty(mobileList)){
            	mobile.setChildren(mobileList);
            	result.add(mobile);
            }
            return Result.success(result);
		} catch (Exception e) {
            log.error("根据名称模糊查询渠道树出错"+e);
            return Result.fail("根据名称模糊查询渠道树出错");
		}
	}
    /**
     * 根据类型获取渠道
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/channel/type", method = RequestMethod.GET)
    @ApiOperation(value="根据类型获取渠道",notes = "根据类型获取渠道")
    @ApiResponses({
        @ApiResponse(code = 70000, message = "ID不允许为空"),
    })
	public Result<List<MsgsChannelByTypeDTO>> getByType(Integer type) {
		try{
            //1，验证
            BizAssert.assertNotNull(MsgExceptionCode.ID_NULL, type);
            MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
            Long userId = BaseContextHandler.getAdminId();
            if (type != 0) {
                msgsChannelExample.createCriteria().andChannelTypeEqualTo(type).andCreateUserEqualTo(userId);
            }
            msgsChannelExample.setOrderByClause(" create_time desc ");
            List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);            
            List<MsgsChannelByTypeDTO> pageList = dozerUtils.mapPage(list, MsgsChannelByTypeDTO.class);
            return Result.success(pageList);
        }catch (Exception e){
            log.error("根据类型获取渠道出错"+e);
            return Result.fail("根据类型获取渠道出错");
        }
	}
    /**
     * 获取渠道类型
     * @return
     */
    @RequestMapping(value = "/channeltype/list", method = RequestMethod.GET)
    @ApiOperation(value="获取渠道类型",notes = "获取渠道类型")
	public Result<List<MsgsChannelTypeSelectDTO>> querySelect() {
		try{
            MsgsChannelTypeExample msgsChannelTypeExample = new MsgsChannelTypeExample();
            msgsChannelTypeExample.createCriteria();
            List<MsgsChannelType> list = msgsChannelTypeService.find(msgsChannelTypeExample);
            List<MsgsChannelTypeSelectDTO> result = dozerUtils.mapList(list, MsgsChannelTypeSelectDTO.class);
            return Result.success(result);
        }catch (Exception e){
            log.error("获取渠道类型出错"+e);
            return Result.fail("获取渠道类型出错");
        }
	}
    /**
     * 单独刷新一个账号access_token
     */
	private void getAccessToken(Long id) {
		MsgsChannel msgsChannel = msgsChannelService.getById(id);
		if(msgsChannel==null){
			return;
		}
		String appid = msgsChannel.getAppId();
		String appSecret = msgsChannel.getAppSecret();
		if(Util.isEmptyString(appid)||Util.isEmptyString(appSecret)){
			return;
		}
		String url = MessageConstant.wechat_tokenGetUrl.replace("%s", appid).replace("%t", appSecret);
		HttpClientEx ex = new HttpClientEx(url, "utf-8");
		log.info("appid是："+appid);
		TockenResult tres = getTokean(ex, 5);
		if(tres == null || Util.isEmptyString(tres.getAccess_token())){
			return;
		}
		//把access_token缓存到redis、缓存key用appid
		redisUtil.set(appid, tres.getAccess_token(), tres.getExpires_in());
	}
    /**
     * 手动刷新所有access_token
     */
    @RequestMapping(value = "/refresh/accesstoken", method = RequestMethod.GET)
    @ApiOperation(value="手动刷新所有access_token",notes = "手动刷新所有access_token")
	public void getAccessTokens() {
    	//获取所有公众号的appid、appSecret
		List<ChannelMsgDTO> channelList = msgsChannelService.getByChannelType(MsgConstant.WECHAT_CHANNEL_TYPE);
		if(!Util.isEmpty(channelList)){
			for(int i=0;i<channelList.size();i++){
				ChannelMsgDTO weChatChannelDTO = channelList.get(i);
				String appid = weChatChannelDTO.getAppId();
				String appSecret = weChatChannelDTO.getAppSecret();
				if(Util.isEmptyString(appid)||Util.isEmptyString(appSecret)){
					continue;
				}
				String url = MessageConstant.wechat_tokenGetUrl.replace("%s", appid).replace("%t", appSecret);
				HttpClientEx ex = new HttpClientEx(url, "utf-8");
				log.info("appid是："+appid);
				TockenResult tres = getTokean(ex, 5);
				if(tres == null || Util.isEmptyString(tres.getAccess_token())){
					continue;
				}
				//把access_token缓存到redis、缓存key用appid
				redisUtil.set(appid, tres.getAccess_token(), tres.getExpires_in());
			}
		}
	}
    /**
	 * 获取微信access_token
	 * @param ex
	 * @param reryCount
	 * @return
	 */
	private TockenResult getTokean(HttpClientEx ex,int reryCount) {
		if(reryCount < 0){
			return null;
		}
		String result = ex.doGet();
		log.info("AAAAAAAAAAAAAA"+"   "+result+"   "+"AAAAAAAAAAAAA");
		TockenResult tres = JSONUtils.parse(result,TockenResult.class);
		if(Util.isEmptyString(tres.getAccess_token())){
			return getTokean(ex, reryCount-1);
		}
		return tres;
	}
}
