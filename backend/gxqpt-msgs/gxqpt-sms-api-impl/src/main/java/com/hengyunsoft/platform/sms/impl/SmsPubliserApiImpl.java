package com.hengyunsoft.platform.sms.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.msgs.utils.Util;
import com.hengyunsoft.platform.sms.dto.BlackListRequestDTO;
import com.hengyunsoft.platform.sms.dto.BlackListResponseDTO;
import com.hengyunsoft.platform.sms.dto.PublisherPullblackDTO;
import com.hengyunsoft.platform.sms.entity.publisher.po.SmsBlacklist;
import com.hengyunsoft.platform.sms.entity.template.dos.PublisherPullblackDO;
import com.hengyunsoft.platform.sms.repository.publisher.example.SmsBlacklistExample;
import com.hengyunsoft.platform.sms.repository.publisher.example.SmsBlacklistExample.Criteria;
import com.hengyunsoft.platform.sms.repository.publisher.service.SmsBlacklistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/*
 * 发布人管理
 */
@RestController
@Slf4j
@Api(value = "发布人管理", description = "发布人管理")
public class SmsPubliserApiImpl{
	@Autowired
	private SmsBlacklistService smsBlacklistService;
	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
	private GxqptEmpApi gxqptEmpApi;
	/**
	 * 发布人拉黑/取消拉黑
	 * @param serviceAccountDTO
	 * @return
	 */
	@RequestMapping(value = "/publisher/pullblack", method = RequestMethod.POST)
	@ApiOperation(value="发布人拉黑/取消拉黑",notes = "发布人拉黑/取消拉黑")
	public Result<Boolean> savePublisherPullblack(@RequestBody PublisherPullblackDTO publisherPullblackDTO) {
		try {
			if(publisherPullblackDTO==null){
				return Result.fail("参数错误");
			}
			Long userId = BaseContextHandler.getAdminId();
			Integer mark = publisherPullblackDTO.getCancel();
			if(mark==0){
				//拉黑
				SmsBlacklist smsBlacklist = new SmsBlacklist();
				smsBlacklist.setGxqptEmpId(publisherPullblackDTO.getUserId());
				smsBlacklist.setCreateTime(new Date());
				smsBlacklist.setAppId(publisherPullblackDTO.getAppId());
				smsBlacklist.setMaindeptname(publisherPullblackDTO.getDepatment());
				smsBlacklist.setNickname(publisherPullblackDTO.getUserAccount());
				smsBlacklist.setName(publisherPullblackDTO.getUserName());
				smsBlacklist.setCreateUser(userId);
				smsBlacklistService.save(smsBlacklist);
			}else if(mark==1){
				//取消拉黑
				PublisherPullblackDO publisherPullblackDO = dozerUtils.map(publisherPullblackDTO, PublisherPullblackDO.class);
				publisherPullblackDO.setCreateUser(userId);
				smsBlacklistService.deleteByAppidAndUserId(publisherPullblackDO);				
			}else{
				return Result.success(false);
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
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	@RequestMapping(value = "/publisher/list", method = RequestMethod.POST)
	@ApiOperation(value="获取拉黑列表",notes = "获取拉黑列表")
	public Result<PageInfo<BlackListResponseDTO>> getPublisherList(@RequestBody OpenApiReq<BlackListRequestDTO> openApiReq) {
		try {
			BlackListRequestDTO blackListRequestDTO = openApiReq.getData();
			if(blackListRequestDTO==null||StringUtils.isEmpty(blackListRequestDTO.getAppId())){
				return Result.fail("参数错误");
			}			
			//判断状态
			if("0".equals(blackListRequestDTO.getStatus())||blackListRequestDTO.getStatus()=="0"){				
				//获取黑名单
				SmsBlacklistExample smsBlacklistExample = new SmsBlacklistExample();
				smsBlacklistExample.createCriteria().andAppIdEqualTo(blackListRequestDTO.getAppId());
				List<SmsBlacklist> list = smsBlacklistService.find(smsBlacklistExample);
				List<Long> blackList = new ArrayList<Long>();
				if(!Util.isEmpty(list)){
					for(SmsBlacklist smsBlacklist:list){
						blackList.add(smsBlacklist.getGxqptEmpId());
					}
				}
				//获取所有人员
				GxqptEmpByUserNameDTO empByUserIdsDTO = new GxqptEmpByUserNameDTO();
				empByUserIdsDTO.setName(blackListRequestDTO.getName());
				empByUserIdsDTO.setMaindeptname(blackListRequestDTO.getDemp());
				empByUserIdsDTO.setPageNo(openApiReq.getPageNo());
				empByUserIdsDTO.setPageSize(openApiReq.getPageSize());
				PageInfo empPage = gxqptEmpApi.findEmpByUserIds(empByUserIdsDTO).getData();
				if(empPage==null){
					return Result.success(new PageInfo<>(new ArrayList<>()));
				}
				List<GxqptEmpRetDTO> emps = empPage.getList();
				if(Util.isEmpty(emps)){
					return Result.success(new PageInfo<>(new ArrayList<>()));
				}
				List<BlackListResponseDTO> result = dozerUtils.mapList(emps, BlackListResponseDTO.class);
				for(BlackListResponseDTO blackListResponseDTO:result){
					if(blackListResponseDTO==null){
						continue;
					}
					if(blackList.contains(blackListResponseDTO.getGxqptEmpId())){
						blackListResponseDTO.setStatus("已拉黑");
					}else{
						blackListResponseDTO.setStatus("正常");
					}
				}		
				empPage.setList(result);
				return Result.success(empPage);
			}else if("1".equals(blackListRequestDTO.getStatus())||blackListRequestDTO.getStatus()=="1"){
				//获取黑名单
				SmsBlacklistExample smsBlacklistExample = new SmsBlacklistExample();
				Criteria criteria = smsBlacklistExample.createCriteria();				
				criteria.andAppIdEqualTo(blackListRequestDTO.getAppId());
				if(!StringUtils.isEmpty(blackListRequestDTO.getName())){
					criteria.andNameLike(SmsBlacklistExample.fullLike(blackListRequestDTO.getName()));
				}
				if(!StringUtils.isEmpty(blackListRequestDTO.getDemp())){
					criteria.andMaindeptnameLike(SmsBlacklistExample.fullLike(blackListRequestDTO.getDemp()));
				}
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<SmsBlacklist> list = smsBlacklistService.find(smsBlacklistExample);
				List<BlackListResponseDTO> result = dozerUtils.mapList(list, BlackListResponseDTO.class);
				if(list!=null&&list.size()!=0){
					for(BlackListResponseDTO blackListResponseDTO:result){
						blackListResponseDTO.setStatus("已拉黑");
					}
				}				
				return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("参数错误");				
			}
		} catch (Exception e) {
			log.error("获取拉黑列表出错：", e);
			return Result.fail("获取拉黑列表出错");
		}
	}

}
