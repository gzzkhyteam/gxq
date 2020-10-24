package com.hengyunsoft.platform.developer.impl.fast.meet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.dto.MeetDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.MeetNoticeDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.MeetPageReqDTO;
import com.hengyunsoft.platform.developer.entity.fast.meet.domain.MeetNoticeDO;
import com.hengyunsoft.platform.developer.entity.fast.meet.po.Meet;
import com.hengyunsoft.platform.developer.repository.service.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(value = "API - MeetApiImpl", description = "会议管理")
@RestController
@RequestMapping("/meet")
@Slf4j
public class MeetApiImpl {
    @Autowired
    MeetService meetService;

    @Autowired
    private MeetNoticeService meetNoticeService;

    @Autowired
    private DozerUtils dozerUtils;


    /**
     * 描述：根据id操作会议
     * @param id 会议通知ID
     * @param opType 操作类型 1：确认参加会议，2：拒绝参加会议，3：取消会议
     * @param remark 操作描述
     * 返回值：Boolean
     * 修改人：chxy
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @ApiOperation(value = "根据id操作会议", notes = "根据id操作会议")
    @ApiResponses({

    })
    @RequestMapping(value = "/operateMeetById", method = RequestMethod.GET)
    public Result<Boolean> operateMeetById(@RequestParam String id, @RequestParam int opType, @RequestParam String remark) {
        meetNoticeService.operateMeetById(Long.parseLong(id), opType, remark);
        return Result.success(true);
    }

    /**
     * 描述：根据id查看会议详情
     * @param id 数据ID
     * 返回值：Boolean
     * 修改人：chxy
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @ApiOperation(value = "根据id查看会议详情", notes = "根据id查看会议详情")
    @ApiResponses({

    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Result<MeetNoticeDTO> getById(@RequestParam String id) {
        MeetNoticeDO meetNoticeDO = meetNoticeService.findMeetById(Long.parseLong(id));
        MeetNoticeDTO dto = dozerUtils.map(meetNoticeDO, MeetNoticeDTO.class);
        return Result.success(dto);
    }

    /**
     * 描述：新增会议
     * 参数：MeetDTO
     * 返回值：Result<Boolean>
     * 修改人：chxy
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @ApiResponses({ })
    @ApiOperation(value = "新增会议", notes = "新增会议")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody MeetDTO dto) {
        //保存会议
        Meet meet = dozerUtils.map(dto, Meet.class);
        meetService.saveMeetAndNotice(meet, dto.getJoinerIds());
        return Result.success(true);
    }

    /**
     * 获取会议列表
     * @param
     * @return
     * @author chxy
     * @version 1.0.0,
     */
    @ApiOperation(value = "获取会议列表", notes = "获取会议列表")
    @RequestMapping(value = "/findMeetList", method = RequestMethod.POST)
    public Result<PageInfo<MeetNoticeDTO>> page(@RequestBody OpenApiReq<MeetPageReqDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();
        MeetPageReqDTO data = openApiReq.getData();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<MeetNoticeDO> list = meetNoticeService.findMeetList(data.getAppId(), userId, data.getName(), data.getMeetStatus(), data.getJoinStatus());
        List<MeetNoticeDTO> pageList = dozerUtils.mapPage(list, MeetNoticeDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

}
