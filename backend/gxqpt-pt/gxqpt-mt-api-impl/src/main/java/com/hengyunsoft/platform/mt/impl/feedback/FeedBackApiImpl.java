package com.hengyunsoft.platform.mt.impl.feedback;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.feedback.dto.*;
import com.hengyunsoft.platform.mt.api.file.dto.CreateFileDTO;
import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import com.hengyunsoft.platform.mt.entity.app.po.Application;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBack;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBackBase;
import com.hengyunsoft.platform.mt.entity.feedback.po.FeedBackMsg;
import com.hengyunsoft.platform.mt.entity.file.po.File;
import com.hengyunsoft.platform.mt.repository.app.service.ApplicationService;
import com.hengyunsoft.platform.mt.repository.feedback.example.FeedBackMsgExample;
import com.hengyunsoft.platform.mt.repository.feedback.service.FeedBackMsgService;
import com.hengyunsoft.platform.mt.repository.feedback.service.FeedBackService;
import com.hengyunsoft.platform.mt.repository.file.example.FileExample;
import com.hengyunsoft.platform.mt.repository.file.service.FileService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * com.hengyunsoft.platform.mt.impl.feedback
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：意见反馈
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：新增基础接口
 */
@Api(value = "API - FeedBackApiImlp.java", description = "意见反馈")
@RestController
@RequestMapping("feedback")
@Slf4j
public class FeedBackApiImpl /*implements FeedBackApi*/ {
    @Autowired
    private FeedBackService feedBackService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FeedBackMsgService feedBackMsgService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ApplicationService applicationService;

    /**
     * 描述：创建意见反馈
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/22
     * 修改内容：
     */

    @RequestMapping(value = "createFeedBack", method = RequestMethod.POST)
    @ApiOperation(value = "创建意见反馈", notes = "创建意见反馈")
    @ApiResponses({
            @ApiResponse(code = 92000, message = "创建意见反馈请求参数，不能为空"),
            @ApiResponse(code = 92002, message = "反馈标题，不能为空"),
            @ApiResponse(code = 92003, message = "反馈内容，不能为空"),
            @ApiResponse(code = 92004, message = "紧急程度(1普通，2紧急，3非常紧急)，不能为空"),
            @ApiResponse(code = 92005, message = "应用id,不能为空"),
    })
    public Result<Boolean> saveCreateFeedBack(@RequestBody CreateFeedBackDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO, dto);
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_FBTITLE, dto.getFbTitle());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_FBCONTENT, dto.getFbContent());
        BizAssert.assertNotNull(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_FBEMERGENCY, dto.getFbEmergency());
        BizAssert.assertNotNull(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_IMAGES, dto.getAppliId());
        //意见反馈一般信息
        Long adminId = BaseContextHandler.getAdminId();
        String name = BaseContextHandler.getName();
        FeedBack feedBack = dozerUtils.map(dto, FeedBack.class);
        feedBack.setCreateUser(adminId);
        feedBack.setCreateUserName(name);
        feedBack.setFbState(1);
        feedBackService.saveSelective(feedBack);
        //保存图片
        List<CreateFileDTO> images = dto.getImages();
        if (images != null && images.size() > 0) {
            List<File> files = dozerUtils.mapList(images, File.class);
            for (File f : files) {
                f.setCreateUser(adminId);
                f.setTableId(feedBack.getId());
            }
            fileService.save(files);
        }

        return Result.success(true);
    }

    /**
     * 描述：分页查询意见反馈列表
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/22
     * 修改内容：
     */

    @RequestMapping(value = "findList", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询意见反馈列表", notes = "分页查询意见反馈列表")
    @ApiResponses({
            @ApiResponse(code = 92006, message = "分页参数,不能为空"),
    })
    public Result<PageInfo<FeedBackBaseDTO>> getFindList(@RequestBody OpenApiReq<QueryFeedBackParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.FINDLIST_OPENAPIREQ, openApiReq);
        Map<String, Object> param = new HashMap<>();

        if (openApiReq.getData() != null) {
            param.put("fbTitle", openApiReq.getData().getFbTitle());
            param.put("fbContent", openApiReq.getData().getFbContent());
            param.put("fbState", openApiReq.getData().getFbState());
            param.put("fbEmergency", openApiReq.getData().getFbEmergency());
            param.put("startCreateTime", openApiReq.getData().getStartCreateTime());
            param.put("endCreateTime", openApiReq.getData().getEndCreateTime());
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FeedBackBase> list = feedBackService.findFeedBackList(param);

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, FeedBackBaseDTO.class)));
    }

    /**
     * 描述：查询自己提交的意见反馈
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/23
     * 修改内容：
     */

    @RequestMapping(value = "findMyList", method = RequestMethod.POST)
    @ApiOperation(value = "查询自己提交的意见反馈", notes = "查询自己提交的意见反馈")
    @ApiResponses({
            @ApiResponse(code = 92006, message = "分页参数,不能为空"),
    })
    public Result<PageInfo<FeedBackBaseDTO>> getFindMyList(@RequestBody OpenApiReq<QueryFeedBackParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.FINDLIST_OPENAPIREQ, openApiReq);
        Map<String, Object> param = new HashMap<>();

        Long adminId = BaseContextHandler.getAdminId();

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FeedBackBase> list = feedBackService.appFindFeedBackList(adminId);

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, FeedBackBaseDTO.class)));
    }

    /**
     * 描述：查询意见详情
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/22
     * 修改内容：
     */

    @RequestMapping(value = "getFeedBackInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询意见详情", notes = "查询意见详情")
    @ApiResponses({
            @ApiResponse(code = 92001, message = "主键id,不能为空"),
            @ApiResponse(code = 92007, message = "意见反馈不存在"),

    })
    public Result<FeedBackInfoDTO> saveGetFeedBackInfo(@RequestParam("id") Long id, @RequestParam("isWeb") Boolean isWeb) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_ID, id);
        Long userId = BaseContextHandler.getAdminId();
        FeedBack feedBack = feedBackService.getById(id);
        if (feedBack == null) {
            return Result.fail(MtExceptionCode.FEEDBACK_HAS_NOT);
        }

        FeedBackInfoDTO feedBackInfoDTO = dozerUtils.map(feedBack, FeedBackInfoDTO.class);
        Application app = applicationService.getById(feedBack.getAppliId());
        if (app != null) {
            feedBackInfoDTO.setAppName(app.getAppName());
        }
        if (feedBackInfoDTO.getAppName() == null) {
            feedBackInfoDTO.setAppName("其他");
        }
        //图片
        FileExample fileExample = new FileExample();
        FileExample.Criteria fileCriteria = fileExample.createCriteria();
        fileCriteria.andTableIdEqualTo(feedBack.getId());
        List<File> files = fileService.find(fileExample);
        List<FileDTO> images = dozerUtils.mapList(files, FileDTO.class);
        feedBackInfoDTO.setImageList(images);
        //消息
        FeedBackMsgExample feedBackMsgExample = new FeedBackMsgExample();
        FeedBackMsgExample.Criteria msgCriteria1 = feedBackMsgExample.createCriteria();
        msgCriteria1.andFbIdEqualTo(feedBack.getId());
        List<FeedBackMsg> feedBackMsgs = feedBackMsgService.find(feedBackMsgExample);
        Collections.sort(feedBackMsgs);
        List<FeedBackMsgDTO> feedBackMsgDTOS = dozerUtils.mapList(feedBackMsgs, FeedBackMsgDTO.class);
        feedBackInfoDTO.setMsgList(feedBackMsgDTOS);
        //更新所有不是自己回复的消息为已经读
        for (FeedBackMsg msg : feedBackMsgs) {
            if (!msg.getCreateUser().equals(userId)) {
                msg.setIsread(2);
            }
        }
        feedBackMsgService.updateByIdSelective(feedBackMsgs);
        return Result.success(feedBackInfoDTO);
    }

    /**
     * 描述：回复意见反馈
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/22
     * 修改内容：
     */

    @RequestMapping(value = "replyFeedback", method = RequestMethod.POST)
    @ApiOperation(value = "回复意见反馈", notes = "回复意见反馈")
    @ApiResponses({
            @ApiResponse(code = 92001, message = "主键id,不能为空"),
            @ApiResponse(code = 92007, message = "意见反馈不存在"),
            @ApiResponse(code = 92008, message = "回复内容不能为空"),
            @ApiResponse(code = 92009, message = "意见反馈已经关闭"),
    })
    public Result<Boolean> saveReplyFeedback(@RequestParam("id") Long id, @RequestParam("isWeb") Boolean isWeb, @RequestParam("context") String context) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_ID, id);
        BizAssert.assertNotEmpty(MtExceptionCode.REPLYFEEDBACK_CONTEXT, context);

        FeedBack feedBack = feedBackService.getById(id);
        if (feedBack == null) {
            return Result.fail(MtExceptionCode.FEEDBACK_HAS_NOT);
        }
        if (feedBack.getFbState() >= 3) {
            return Result.fail(MtExceptionCode.REPLYFEEDBACK_CLOSE);
        }
        if (isWeb) {
            feedBack.setFbState(2);
            feedBackService.updateByIdSelective(feedBack);
        }

        Long adminId = BaseContextHandler.getAdminId();
        String name = BaseContextHandler.getName();
        FeedBackMsg msg = new FeedBackMsg();
        msg.setFbId(id);
        msg.setMsgContent(context);
        msg.setCreateUser(adminId);
        msg.setCreateUserName(name);
        msg.setIsread(1);
        feedBackMsgService.saveSelective(msg);

        return Result.success(true);
    }

    /**
     * 描述：关闭意见反馈
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/22
     * 修改内容：
     */

    @RequestMapping(value = "closeFeedBack", method = RequestMethod.POST)
    @ApiOperation(value = "关闭意见反馈", notes = "关闭意见反馈")
    @ApiResponses({
            @ApiResponse(code = 92001, message = "主键id,不能为空"),
            @ApiResponse(code = 92007, message = "意见反馈不存在"),
    })
    public Result<Boolean> saveCloseFeedBack(@RequestParam("id") Long id) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEFEEDBACK_CREATEFEEDBACKDTO_ID, id);

        FeedBack feedBack = feedBackService.getById(id);
        if (feedBack == null) {
            return Result.fail(MtExceptionCode.FEEDBACK_HAS_NOT);
        }
        feedBack.setFbState(3);

        Long adminId = BaseContextHandler.getAdminId();
        String name = BaseContextHandler.getName();
        feedBack.setFbCloseId(adminId);
        feedBack.setFbCloseName(name);
        feedBack.setFbCloseTime(new Date());

        feedBackService.updateByIdSelective(feedBack);
        return Result.success(true);
    }

    /**
     * 描述：查询未读消息的数量
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/8/7
     * 修改内容：
     */

    @RequestMapping(value = "getMyMsgNotReadCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询未读消息的数量", notes = "查询未读消息的数量")
    public Result<Integer> getMyMsgNotReadCount() {
        Long adminId = BaseContextHandler.getAdminId();
        Integer notReadCount = feedBackService.getNotReadCount(adminId);
        return Result.success(notReadCount);
    }
}
