package com.hengyunsoft.platform.warn.open;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.WarnExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.warn.entity.domain.ConfirmTimeDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarn;
import com.hengyunsoft.platform.warn.open.api.GxqptWarnOpenApi;
import com.hengyunsoft.platform.warn.open.dto.UpdateGxqptWarnOpenDTO;
import com.hengyunsoft.platform.warn.repository.dao.GxqptSendeeMapper;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 描述：预警管理系统对外接口
 * @author zjr
 * @date 2018/06/26
 * @return
 */
@Api(value = "API - GxqptWarnOpenApiImpl", description = "预警管理系统对外接口")
@RestController
@RequestMapping("/p/warn")
@Slf4j
@WarnSendModule
public class GxqptWarnOpenApiImpl implements GxqptWarnOpenApi {

    @Autowired
    private GxqptWarnService gxqptWarnService;
    @Autowired
    private GxqptSendeeService gxqptSendeeService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptSendeeMapper gxqptSendeeMapper;
    /**
     * 预警信息更新对外接口
     * @param updateGxqptWarnOpenDTO
     * @return
     */
    @ApiOperation(value = "预警信息更新对外接口", notes = "预警信息更新对外接口")
    @RequestMapping(value = "/updateByIdAndUserId", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 70500, message = "预警信息id为空"),
    })
    @Override
    public Result<Boolean> updateByIdAndUserId(@RequestBody UpdateGxqptWarnOpenDTO updateGxqptWarnOpenDTO){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_ID_NULL, updateGxqptWarnOpenDTO.getId());
        //2.转换
        GxqptWarn gxqptWarn = dozerUtils.map(updateGxqptWarnOpenDTO, GxqptWarn.class);
//        GxqptSendee gxqptSendee = gxqptSendeeMapper.getByUserId(1987609365697l,gxqptWarn.getId());
        GxqptSendee gxqptSendee = gxqptSendeeMapper.getByUserId(BaseContextHandler.getAdminId(),gxqptWarn.getId(),GxqptSendee.RECTYPE3);
        gxqptWarn.setUpdateUser(BaseContextHandler.getAdminId().toString());
//        gxqptWarn.setUpdateUser("1987609365697");
        Date nowDate = new Date();
        gxqptWarn.setHanTime(nowDate);
        gxqptWarn.setUpdateTime(nowDate);
        gxqptWarn.setStatus(GxqptWarn.STATUS4);
        gxqptWarn.setLevel(updateGxqptWarnOpenDTO.getLevel());
        int result = gxqptWarnService.updateByIdSelective(gxqptWarn);
        if (result > 0) {
            //查询抄送人信息
            List<GxqptSendee> csr = gxqptSendeeService.getCsr(gxqptWarn.getId(),GxqptSendee.RECTYPE2);
            gxqptSendee.setResult(updateGxqptWarnOpenDTO.getResult());
            gxqptSendee.setRemarks(updateGxqptWarnOpenDTO.getRemarks());
            gxqptSendee.setStatus(GxqptSendee.STATUS3);
            gxqptSendee.setWhoHandle(GxqptSendee.UNWHOHANDLE);
            gxqptSendee.setUpdateUser(BaseContextHandler.getAdminId().toString());
//            gxqptSendee.setUpdateUser("1987609365697");
            gxqptSendee.setUpdateTime(nowDate);
            gxqptSendeeService.updateById(gxqptSendee);
            //更改抄送人预警状态
            if (csr!=null){
                gxqptSendeeMapper.updateStatusByWarnId(gxqptWarn.getId(),GxqptSendee.RECTYPE2);
            }
            //设置处理时长
            ConfirmTimeDO hantime = gxqptSendeeService.getConfirmti(gxqptWarn.getId(),GxqptSendee.RECTYPE3);
            gxqptWarn.setHandleCostTime(hantime.getHandleTime());
            gxqptWarnService.updateByIdSelective(gxqptWarn);
            return Result.success(true);
        }else {
            return Result.fail("处理失败");
        }
    }
}
