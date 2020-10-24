package com.hengyunsoft.platform.msgs.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.GlobalExceptionCode;
import com.hengyunsoft.commons.exception.core.MsgExceptionCode;
import com.hengyunsoft.commons.utils.WebUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.msgs.api.bbs.BbsMessageApi;
import com.hengyunsoft.platform.msgs.dto.bbs.*;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllMainMsg;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsAllReceiveMsg;
import com.hengyunsoft.platform.msgs.entity.bbsmsg.po.BbsIncrementReceiveMsg;
import com.hengyunsoft.platform.msgs.manager.BbsBizCommon;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.example.BbsIncrementReceiveMsgExample;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsAllMainMsgService;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsAllReceiveMsgService;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsIncrementMainMsgService;
import com.hengyunsoft.platform.msgs.repository.bbsmsg.service.BbsIncrementReceiveMsgService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 站内信息API
 * @author sxy
 * @date 2018-07-25
 *
 */
@RestController
@Slf4j
@RequestMapping("/bbs/msg")
@Api(value = "站内信息API", description = "站内信息API")
public class BbsMessageApiImpl implements BbsMessageApi {

    @Autowired
    private BbsAllMainMsgService bbsAllMainMsgService;

    @Autowired
    private BbsAllReceiveMsgService bbsAllReceiveMsgService;

    @Autowired
    private BbsIncrementMainMsgService bbsIncrementMainMsgService;

    @Autowired
    private BbsIncrementReceiveMsgService bbsIncrementReceiveMsgService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    BbsBizCommon bbsBizCommon;

    @Autowired
    private ApplicationApi  applicationApi;

    /**
     * 查询全部消息
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "查询全部消息", notes = "查询全部消息")
    @ApiResponses({
            @ApiResponse(code = 75521, message = "用户ID不为空"),
            @ApiResponse(code = 75522, message = "筛选条件不为空"),
    })
    @RequestMapping(value = "/getAllMsg", method = RequestMethod.POST)
    public Result<PageInfo<BbsAllMsgResDTO>> getAllMsg(@RequestBody OpenApiReq<BbsAllMsgReqDTO> openApiReq) {

        //1.校验
        if(openApiReq.getData()==null){
            return Result.fail("入参实体DTO不为空！！");
        }
        log.info("查询全部消息,dto[{}] ", JSONUtils.toJsonString(openApiReq.getData()));
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_USER_ID_EMPTY, openApiReq.getData().getUserId());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_CONDITIONS_EMPTY, openApiReq.getData().getConditions());

        Long userId = openApiReq.getData().getUserId();
        String conditions = openApiReq.getData().getConditions();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<BbsAllMsgResDTO> list = null;

        //2.查询
        log.info("根据userId[{}],查询全部消息分页,",userId);
        if("all".equals(conditions)){
            list = dozerUtils.mapList(bbsAllMainMsgService.getAllMsg(userId), BbsAllMsgResDTO.class);
        }
        if("noHandle".equals(conditions)){
            list = dozerUtils.mapList(bbsAllMainMsgService.getAllNotHandleMsg(userId), BbsAllMsgResDTO.class);
        }

        //3.转换
        List<BbsAllMsgResDTO> pageList = dozerUtils.mapPage(list,BbsAllMsgResDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }



    /**
     * 查询已读消息
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "查询已读消息", notes = "查询已读消息")
    @ApiResponses({
            @ApiResponse(code = 75521, message = "用户ID不为空"),
            @ApiResponse(code = 75522, message = "筛选条件不为空"),
    })
    @RequestMapping(value = "/getReadMsg", method = RequestMethod.POST)
    public Result<PageInfo<BbsAllMsgResDTO>> getReadMsg(@RequestBody OpenApiReq<BbsAllMsgReqDTO> openApiReq) {

        //1.校验
        if(openApiReq.getData()==null){
            return Result.fail("入参实体DTO不为空！！");
        }
        log.info("查询已读消息,dto[{}] ", JSONUtils.toJsonString(openApiReq.getData()));
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_USER_ID_EMPTY, openApiReq.getData().getUserId());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_CONDITIONS_EMPTY, openApiReq.getData().getConditions());

        Long userId = openApiReq.getData().getUserId();
        String conditions = openApiReq.getData().getConditions();
        List<BbsAllMsgResDTO> list = null;
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询
        log.info("根据userId[{}],查询已读消息分页,",userId);

        if("all".equals(conditions)){
            list = dozerUtils.mapList(bbsAllMainMsgService.getReadMsg(userId), BbsAllMsgResDTO.class);
        }
        if("noHandle".equals(conditions)){
            list = dozerUtils.mapList(bbsAllMainMsgService.getAllNotHandleMsg(userId), BbsAllMsgResDTO.class);
        }

        //3.转换
        List<BbsAllMsgResDTO> pageList = dozerUtils.mapPage(list,BbsAllMsgResDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }


    /**
     * 根据条件查询未读消息
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "根据条件查询未读消息", notes = "根据条件查询未读消息")
    @ApiResponses({
            @ApiResponse(code = 75521, message = "用户ID不为空"),
            @ApiResponse(code = 75522, message = "筛选条件不为空"),
    })
    @RequestMapping(value = "/getNotReadMsg", method = RequestMethod.POST)
    public Result<PageInfo<BbsNotReadMsgResDTO>> getNotReadMsg(@RequestBody OpenApiReq<BbsNotReadMsgReqDTO> openApiReq) {

        //1.校验
        if(openApiReq.getData()==null){
            return Result.fail("入参实体DTO不为空！！");
        }
        log.info("根据条件查询未读消息,dto[{}] ", JSONUtils.toJsonString(openApiReq.getData()));
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_USER_ID_EMPTY, openApiReq.getData().getUserId());
        BizAssert.assertNotEmpty(MsgExceptionCode.BBS_MESSAGE_CONDITIONS_EMPTY, openApiReq.getData().getConditions());

        Long userId = openApiReq.getData().getUserId();
        String conditions = openApiReq.getData().getConditions();
        List<BbsNotReadMsgResDTO> list = null;
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //2.查询
        log.info("根据userId[{}],查询未读消息分页,",userId);
        if("all".equals(conditions)){
            //获取全部未读消息
            list = dozerUtils.mapList(bbsIncrementMainMsgService.getAllNotReadMsg(userId), BbsNotReadMsgResDTO.class);
        }
        if("needHandle".equals(conditions)){
            //获取需要处理消息
            list = dozerUtils.mapList(bbsIncrementMainMsgService.getNeedHandleNotReadMsg(userId), BbsNotReadMsgResDTO.class);
        }
        if("message".equals(conditions)){
            //获取普通消息
            list = dozerUtils.mapList(bbsIncrementMainMsgService.getCommonNotReadMsg(userId), BbsNotReadMsgResDTO.class);
        }

        //3.转换
        List<BbsNotReadMsgResDTO> pageList = dozerUtils.mapPage(list,BbsNotReadMsgResDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 读消息
     * @param ids id为接收表的主键
     * @return
     */
    @Override
    @ApiOperation(value = "读消息", notes = "读消息")
    @ApiResponses({
            @ApiResponse(code = 75520, message = "id集合不为空"),
    })
    @RequestMapping(value = "/updateMsgsReaded", method = RequestMethod.POST)
    public Result<Boolean> updateMsgsReaded(@RequestParam(value = "ids[]") Long[] ids) {

        return bbsBizCommon.updateMsgsReadedCommon(ids);
    }

    /**
     * 根据消息ID获取消息详情
     * @param msgId
     * @return
     */
    @Override
    @ApiOperation(value = "根据消息ID获取消息详情", notes = "根据消息ID获取消息详情")
    @ApiResponses({
            @ApiResponse(code = 75518, message = "消息id不能为空"),
    })
    @RequestMapping(value = "/getDetailById", method = RequestMethod.GET)
    public Result<BbsMsgDetailResDTO> getDetailById(@RequestParam(value = "msgId") Long msgId) {

        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_MSG_ID_EMPTY, msgId);
        BbsMsgDetailResDTO dto = dozerUtils.map(bbsAllMainMsgService.getDetailById(msgId), BbsMsgDetailResDTO.class);
        if(dto==null){
            return Result.success(null);
        }
        return Result.success(dozerUtils.map(dto,BbsMsgDetailResDTO.class));
    }

    /**
     * 根据用户ID获取最近消息及未读数量
     * @param userId
     * @return
     */
    @Override
    @ApiOperation(value = "根据用户ID获取最近消息及未读数量", notes = "根据用户ID获取最近消息及未读数量")
    @ApiResponses({
            @ApiResponse(code = 75521, message = "用户ID不为空"),
    })
    @RequestMapping(value = "/getRecentMsgAndNotReadNum", method = RequestMethod.GET)
    public Result<BbsMsgDetailResDTO> getRecentMsgAndNotReadNum(@RequestParam(value = "userId") Long userId) {

        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_USER_ID_EMPTY, userId);
        BbsMsgDetailResDTO dto = dozerUtils.map(bbsAllMainMsgService.getRecentMsgAndNotReadNum(userId), BbsMsgDetailResDTO.class);
        if(dto==null){
            return Result.success(null);
        }
        return Result.success(dozerUtils.map(dto,BbsMsgDetailResDTO.class));
    }

    /**
     * 删除消息
     * @param ids id为接收表的主键
     * @return
     */
    @Override
    @ApiOperation(value = "删除消息", notes = "删除消息")
    @ApiResponses({
            @ApiResponse(code = 75520, message = "id集合不为空"),
    })
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Result<Boolean> deleteById(@RequestParam(value = "ids[]") Long[] ids) {

        //校验
        BizAssert.assertNotNull(MsgExceptionCode.BBS_MESSAGE_IDS_EMPTY, ids);

        try {
            for(Long id:ids){
                log.info("根据id[{}]删除消息,",id);
                //处理正式库
                BbsIncrementReceiveMsg  birm = null;
                birm = bbsIncrementReceiveMsgService.getById(id);
                if(birm != null){
                    Long msgId = birm.getMsgId();

                    //已读即可删除
                    bbsIncrementReceiveMsgService.deleteById(id);
                    BbsIncrementReceiveMsgExample example = new BbsIncrementReceiveMsgExample();
                    BbsIncrementReceiveMsgExample.Criteria criteria = example.createCriteria();
                    criteria.andMsgIdEqualTo(msgId);
                    criteria.andReadIsEqualTo(false);

                    List<BbsIncrementReceiveMsg> list = bbsIncrementReceiveMsgService.find(example);
                    if(list!=null&&list.size()==0){//最后一条消息已读，删除主表消息
                        bbsIncrementMainMsgService.deleteById(msgId);
                    }
                }
                BbsAllReceiveMsg barm = new BbsAllReceiveMsg();
                barm.setId(id);
                barm.setReadIs(true);
                barm.setDeleteIs(true);
                //更新历史库
                bbsAllReceiveMsgService.updateByIdSelective(barm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(true);
    }

    /**
     * 待办更新状态
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "待办更新状态", notes = "待办更新状态")
    @ApiResponses({
            //@ApiResponse(code = 75516, message = "接收人id不为空"),
            @ApiResponse(code = 75518, message = "消息id不为空"),
            @ApiResponse(code = 75519, message = "是否处理完成标识不为空"),
    })
    @RequestMapping(value = "/updateBacklog", method = RequestMethod.POST)
    public Result<Boolean> updateBacklog(@RequestBody UpdateBacklogReqDTO dto) {
        return bbsBizCommon.updateBacklogCommon(dto);
    }


    /**
     * 保存消息
     * @param bammDTO
     * @return
     */
    @Override
    @ApiOperation(value = "保存消息", notes = "保存消息")
    @ApiResponses({
            @ApiResponse(code = 75501, message = "业务id不为空"),
            @ApiResponse(code = 75502, message = "业务类型不为空"),
            @ApiResponse(code = 75503, message = "客户端标识不为空"),
            @ApiResponse(code = 75504, message = "简要类型，粗粒度的类型不为空"),
            @ApiResponse(code = 75505, message = "详细类型不为空"),
            //@ApiResponse(code = 75506, message = "详细类型描述不为空"),
            @ApiResponse(code = 75507, message = "标题不为空"),
            @ApiResponse(code = 75508, message = "内容不为空"),
            @ApiResponse(code = 75509, message = "作者名称不为空"),
            @ApiResponse(code = 75510, message = "处理地址不为空"),
            //@ApiResponse(code = 75511, message = "处理参数不为空"),
            @ApiResponse(code = 75512, message = "是否单人处理不为空"),
            @ApiResponse(code = 75513, message = "主信息是否需要操作不为空"),
            @ApiResponse(code = 75514, message = "应用id不为空"),
            @ApiResponse(code = 75515, message = "应用名称不为空"),

            @ApiResponse(code = 75516, message = "接收人id不为空"),
            @ApiResponse(code = 75517, message = "接收人是否需要处理不为空"),
            @ApiResponse(code = 75523, message = "用户类型不为空"),
    })
    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public Result<BbsAllMainMsgSaveResDTO> saveMsg(@RequestBody BbsAllMainMsgSaveReqDTO bammDTO) {
        return bbsBizCommon.saveMsgCommon(bammDTO);
    }

    /**
     * 读消息并获取跳转地址
     * @param recvMsgId
     * @return
     */
	@Override
    @ApiOperation(value = "读消息并获取跳转地址", notes = "读消息并获取跳转地址")
    @RequestMapping(value = "/flagReadedAndGetUrl", method = RequestMethod.GET)
	public Result<String> updateToReadedAndGetUrl(Long recvMsgId) {
		Long[] ids = {recvMsgId};
        updateMsgsReaded(ids);
		return builderHandlerUrl(recvMsgId);
	}

    /**
     * 构建处理URL
     * @param recvMsgId
     * @return
     */
	private Result<String> builderHandlerUrl(Long recvMsgId) {
		
		BbsAllReceiveMsg bbsAllReceiveMsg = bbsAllReceiveMsgService.getById(recvMsgId);
		if(bbsAllReceiveMsg==null){
            return Result.success(null);
        }
		BbsAllMainMsg bbsAllMainMsg = bbsAllMainMsgService.getById(bbsAllReceiveMsg.getMsgId());
        if(bbsAllMainMsg==null){
            return Result.success(null);
        }
		String url = bbsAllMainMsg.getHandlerUrl();
        if(StringUtils.isEmpty(url)){
            return Result.success(null);
        }
		if(!(url.indexOf("http://") == 0 || url.indexOf("https://") == 0 )) {
			
			Result<ApplicationAllDTO> application = applicationApi.getAppInforByAppId(bbsAllMainMsg.getAppId());
			BizAssert.assertTrue(GlobalExceptionCode.SERVER_BUSY, application.isSuccess());
            if(application !=null && application.getData() != null){
                String fullRootPath = application.getData().getFullRootPath();
                url = WebUtils.linkUri2Uri(fullRootPath, url);
            }
		}
		if(bbsAllMainMsg.getHandlerParams() != null) {
			url = WebUtils.linkUrl2Params(url, bbsAllMainMsg.getHandlerParams());
		}
        if(url.contains("&")&&url.length()==url.lastIndexOf("&")+1){
            url = url.substring(0,url.length()-1);
        }
		return Result.success(url);
	}

}
