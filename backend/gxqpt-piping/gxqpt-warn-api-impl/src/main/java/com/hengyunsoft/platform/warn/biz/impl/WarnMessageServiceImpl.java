package com.hengyunsoft.platform.warn.biz.impl;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.warn.api.warn.dto.*;
import com.hengyunsoft.platform.warn.biz.WarnMessageService;
import com.hengyunsoft.platform.warn.entity.po.*;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnCurMapper;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptDutyService;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendStatusService;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;
import com.hengyunsoft.platform.warn.utils.JSONUtils;
import com.hengyunsoft.platform.warn.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信消息服务
 * @author dxz
 */
@Slf4j
@Component
public class WarnMessageServiceImpl extends BaseServiceImpl<Long, GxqptWarn, GxqptWarnExample> implements WarnMessageService {

	@Autowired
    private DozerUtils dozerUtils;
	@Autowired
    private GxqptWarnCurMapper gxqptWarnCurMapper;
	@Autowired
	private BbbMsgQueueProducer msgQueueProducer;
	@Autowired
    private GxqptWarnMapper gxqptWarnMapper;
	@Autowired
	private GxqptSendeeService gxqptSendeeService;
	@Autowired
	private GxqptSendStatusService gxqptSendStatusService;
	@Autowired
	private GxqptDutyService gxqptDutyService;
	@Autowired
	private GxqptEmpApi gxqptEmpApi;
	/**
	 * 发送预警信息
	 * @return
	 */
	public String sendToSendee() {
		List<GxqptWarnCur> recordList = gxqptWarnCurMapper.getAll();
		if (Util.isEmpty(recordList)) {
			return null;
		}
		for (GxqptWarnCur gxqptWarnCur : recordList) {
			//定时任务判断
			String date = gxqptWarnCur.getSendtime();
			if (!Util.isEmptyString(date)) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					Date date0 = df.parse(date);
					long time = date0.getTime();
					long now = System.currentTimeMillis();
					if (now < time) {
						continue;
					}
				} catch (ParseException e) {
					log.info("预警信息错误",e);
//					e.printStackTrace();
//					return "预警信息错误";

				}
			}
			try {
				GxqptSendStatus gxqptSendStatus = new GxqptSendStatus();
				gxqptSendStatus.setCreateTime(new Date());
				gxqptSendStatus.setSendStatus(1);
				gxqptSendStatus.setWarnId(gxqptWarnCur.getId());
				gxqptSendStatus.setResult("预警信息发布成功");
				gxqptSendStatusService.save(gxqptSendStatus);
				gxqptWarnCurMapper.deleteByPrimaryKey(gxqptWarnCur.getId());
			}catch (Exception e){
				GxqptSendStatus gxqptSendStatus = new GxqptSendStatus();
				gxqptSendStatus.setCreateTime(new Date());
				gxqptSendStatus.setWarnId(gxqptWarnCur.getId());
				gxqptSendStatus.setSendStatus(2);
				gxqptSendStatus.setResult("预警信息发布异常");
				gxqptSendStatusService.save(gxqptSendStatus);
				gxqptWarnCurMapper.deleteByPrimaryKey(gxqptWarnCur.getId());
				throw e;
			}
		}

		return "发送成功";
	}

	/**
	 * 保存预警信息
	 */
	@Override
	public String saveWarnMessage(String warn) {
		log.info("warn: {}",warn);
		WarnMessageDTO warnMessageDto = JSONUtils.parseObject(warn, WarnMessageDTO.class);
		log.info("warn -> {}",warn);
		GxqptWarn gxqptWarn = dozerUtils.map(warnMessageDto, GxqptWarn.class);
		GxqptWarnCur gxqptWarnCur = dozerUtils.map(warnMessageDto, GxqptWarnCur.class);
		try {
			Long id = genId();
			gxqptWarn.setCreateTime(new Date());
			gxqptWarn.setWarntime(new Date());
			gxqptWarn.setStatus(GxqptWarn.STATUS1);
			//正常发送
			gxqptWarn.setId(id);
			gxqptWarnCur.setId(id);
			int insertResult = gxqptWarnCurMapper.insert(gxqptWarnCur);
			if(insertResult<=0){
				return "发送失败";
			}
			int insertResult1 = gxqptWarnMapper.insert(gxqptWarn);
			if(insertResult1<=0){
				return "保存失败";
			}

			List handler = warnMessageDto.getHandler();
			if(StringUtils.isEmpty(handler.toString())){
				return "确认人不能为空！";
			}
			List<HandlerDTO> handlerList = warnMessageDto.getHandler();
			List<CsrDTO> csrlist = warnMessageDto.getCsr();
			log.info("warn -》 csrlist：{}", csrlist);
			DutyNameDTO dutyNameList = warnMessageDto.getDutyName();
			List<Long> lookUserIds = new ArrayList<>();
			BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
			List<GxqptSendee> senders = new ArrayList<GxqptSendee>();
			for(HandlerDTO sendObj:handlerList){
				GxqptSendee gxqptSendee = dozerUtils.map(sendObj,GxqptSendee.class);
				gxqptSendee.setWarnId(id);
				gxqptSendee.setRecType(GxqptSendee.RECTYPE1);
				gxqptSendee.setStatus(GxqptSendee.STATUS1);
				gxqptSendee.setRecTime(new Date());
				gxqptSendee.setCreateTime(new Date());
				if (gxqptSendee.getHandlerLeve()==1){
					gxqptSendee.setWhoHandle(true);
				}else {
					gxqptSendee.setWhoHandle(false);
				}
				senders.add(gxqptSendee);

			}
			if (csrlist!=null){
				for (CsrDTO csrObj:csrlist){
					GxqptSendee gxqptSendee = dozerUtils.map(csrObj,GxqptSendee.class);
					gxqptSendee.setWarnId(id);
					gxqptSendee.setStatus(GxqptSendee.STATUS1);
					gxqptSendee.setRecType(GxqptSendee.RECTYPE2);
					gxqptSendee.setRecTime(new Date());
					gxqptSendee.setCreateTime(new Date());
					senders.add(gxqptSendee);

				}
			}
			if (dutyNameList!=null){
				GxqptSendee gxqptSendee = dozerUtils.map(dutyNameList,GxqptSendee.class);
				gxqptSendee.setWarnId(id);
				gxqptSendee.setRecType(GxqptSendee.RECTYPE3);
				gxqptSendee.setStatus(GxqptSendee.STATUS1);
				gxqptSendee.setRecTime(new Date());
				gxqptSendee.setCreateTime(new Date());
				senders.add(gxqptSendee);

			}
			log.info("senders.size:{}",senders.size());
			//2019-4-25 对预警人员 添加 部门应用信息
            List<GxqptSendee> gxqptSendees = sendeeDeal(senders);
            gxqptSendeeService.save(gxqptSendees);

			List duty = Arrays.asList(warnMessageDto.getDuty());

			if (StringUtils.isEmpty(duty.toString())){
				return "预警责任列表不能为空！";
			}
			List<DutyDTO> dutyList = warnMessageDto.getDuty();
            List<GxqptDuty> gxqptDuty = dozerUtils.mapList(dutyList,GxqptDuty.class);
            //madengbo 2019-4-23 增加相关人员部门信息
            List<GxqptDuty> duties = dealDutys(gxqptDuty, id);
			gxqptDutyService.save(duties);

		} catch (Exception e) {
			log.info("保存预警信息记录失败",e);

		}		
		return "success";
	}

//	private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(Long id,String content,String title) {
//
//		BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
//		bbsAllMainMsgDTO.setAppId("35kj6310");
//		bbsAllMainMsgDTO.setAppName("预警管理系统");
//		bbsAllMainMsgDTO.setBizId(id.toString());
//		bbsAllMainMsgDTO.setBizType("send_warn");
//		bbsAllMainMsgDTO.setBriefTpye("send_warn");
//		bbsAllMainMsgDTO.setClientFlag("gxqpt");
//		bbsAllMainMsgDTO.setContent("您有一条新的预警信息："+content+".");
//		bbsAllMainMsgDTO.setSingleHandleIs(false);
//		bbsAllMainMsgDTO.setTitle("预警信息："+title);
//		bbsAllMainMsgDTO.setDetailedType("WARN_SEND");
//		bbsAllMainMsgDTO.setDetailedTypeDesc("发送预警");
//		bbsAllMainMsgDTO.setHandlerNeedIs(false);
//		bbsAllMainMsgDTO.setHandlerUrl("/#/ledgerList");
//		bbsAllMainMsgDTO.setSenderName("系统自动通知");
//		return bbsAllMainMsgDTO;
//	}

	@Override
	protected BaseNormalDao<Long, GxqptWarn, GxqptWarnExample> getDao() {
		return getDao();
	}
	/**
	 * @method
	 * @description 处理预警抄送人、确认人、责任人的部门信息
	 * @date: 2019/4/23 0023 17:12
	 * @author: mdengb
	 * @param dutyList  抄送人、确认人、责任人结合
	 * @return
	 */
	protected List<GxqptDuty> dealDutys(List<GxqptDuty> dutyList, Long warnId){
	    log.info("预警人员列表 saveWarnMessage -> dealDutys -> dutyList:{}",dutyList.toString());
	    log.info("预警id saveWarnMessage -> dealDutys -> warnId:{}",warnId);
		List<String> useIds = new ArrayList<>();
		GxqptEmpByUserNameDTO gxqptEmpByUserNameDTO = new GxqptEmpByUserNameDTO();
		for(GxqptDuty gxqptDuty:dutyList){
			gxqptDuty.setWarnId(warnId);
			useIds.add(gxqptDuty.getUserId().toString());
		}
		if(!useIds.isEmpty()){
			gxqptEmpByUserNameDTO.setUserIds(useIds);
		}
		//设置那边调用的接口的分页返回数量  ！！！后期考虑优化
		gxqptEmpByUserNameDTO.setPageNo(1);
		gxqptEmpByUserNameDTO.setPageSize(useIds.size());
		//设置人员部门信息，及应用信息
        log.info("预警人员ids saveWarnMessage -> dealDutys -> useIds:{}",useIds.toString());
        Result<PageInfo<GxqptEmpRetDTO>> ret = gxqptEmpApi.findEmpByUserIdsNoToken(gxqptEmpByUserNameDTO);
        log.info("人员信息查询返回  ret.getData:{},  ret.getErrcode: {}, ret.getErrmsg: {},  ret.toString:{}",ret.getData(),ret.getErrcode(),ret.getErrmsg(),ret.toString());
        if(ret.isSuccess()){
            List<GxqptEmpRetDTO> list = ret.getData().getList();
            if(!list.isEmpty()){
                for(GxqptDuty duty : dutyList){
					log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys01 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duty.getUserId(),duty.getDepartmentId(),duty.getOrgId());
                    for(GxqptEmpRetDTO user : list){
                        if(duty.getUserId().equals(user.getGxqptEmpId())){
                            //部门相关的信息
                            duty.setDepartmentId(user.getMaindeptid());
                            duty.setDepartmentName(user.getMaindeptname());
                            //应用相关信息
                            duty.setOrgId(user.getMainorgid());
                            duty.setOrgName(user.getMainorgname());
							log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys02 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duty.getUserId(),duty.getDepartmentId(),duty.getOrgId());
                            break;
                        }
                    }
                }
            }
        }
		return dutyList;
	}

	/**
	 * 对预警人员添加 部门 信息
	* */
	private List<GxqptSendee> sendeeDeal(List<GxqptSendee> senders){
		List<String> useIds = new ArrayList<>();
		senders.forEach(obj ->{
					useIds.add(obj.getUserId().toString());
				}
		);
		GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
		dto.setUserIds(useIds);
		dto.setPageNo(1);
		dto.setPageSize(useIds.size());
		List<GxqptEmpRetDTO> empDate = gxqptEmpApi.findEmpByUserIdsNoToken(dto).getData().getList();
		log.info("预警人员信息查询返回 empDate.toString:{}",empDate.toString());
		for(GxqptSendee duty : senders){
			log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys01 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duty.getUserId(),duty.getDepartmentId(),duty.getOrgId());
			for(GxqptEmpRetDTO user : empDate){
				if(duty.getUserId().equals(user.getGxqptEmpId())){
					//部门相关的信息
					duty.setDepartmentId(user.getMaindeptid());
					duty.setDepartmentName(user.getMaindeptname());
					//应用相关信息
					duty.setOrgId(user.getMainorgid());
					duty.setOrgName(user.getMainorgname());
					log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys02 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duty.getUserId(),duty.getDepartmentId(),duty.getOrgId());
					break;
				}
			}
		}
		return senders;
	}
}
