package com.hengyunsoft.platform.supervise.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SuperviseExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.supervise.dto.center.*;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseLink;
import com.hengyunsoft.platform.supervise.impl.manager.BizCommon;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseLinkExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseLinkService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：权责监管环节API
 * 修改人：sxy
 * 修改时间：2018/9/12
 * 修改内容：新增基础接口
 */
@Api(value = "API - PowerSuperviseLinkApiImpl.java", description = "权责监管环节API")
@RestController
@RequestMapping("powersuperviselink")
@Slf4j
public class PowerSuperviseLinkApiImpl {


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    BizCommon bizCommon;

    @Autowired
    private PowerSuperviseLinkService powerSuperviseLinkService;

    /**
     * 权责监管环节保存
     * @param dto
     * @return
     */
    @ApiOperation(value = "权责监管环节保存",notes = "权责监管环节保存")
    @ApiResponses({
            @ApiResponse(code = 110121 , message = "环节编码不能为空"),
            @ApiResponse(code = 110122 , message = "环节名称不能为空"),
            @ApiResponse(code = 110123 , message = "时长阀值不能为空"),
            @ApiResponse(code = 110124 , message = "责任人不能为空"),
            @ApiResponse(code = 110125 , message = "确认人不能为空"),
            @ApiResponse(code = 110126 , message = "提醒方式不能为空"),
    })
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result<PowerSuperviseLinkSaveRetDTO> save(@RequestBody PowerSuperviseLinkSaveDTO dto){

        //校验
        BizAssert.assertNotEmpty(SuperviseExceptionCode.POWER_SUPERVISE_LINK_CODE_NULL,dto.getCode());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.POWER_SUPERVISE_LINK_NAME_NULL,dto.getName());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_TIME_LIMIT_NULL,dto.getTimeLimit());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SUPERVISE_DUTY_USER_NULL,dto.getDutyUser());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SUPERVISE_CONFIRM_USER_NULL,dto.getConfirmUser());
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_REMIND_TYPE_NULL,dto.getRemindType());

        //转换
        PowerSuperviseLink entity = dozerUtils.map(dto, PowerSuperviseLink.class);
        entity.setCreateUser(BaseContextHandler.getAdminId());
        entity.setCreateTime(new Date());
        entity.setUpdateUser(BaseContextHandler.getAdminId());
        entity.setUpdateTime(new Date());

        //校验重复提交
        String result = checkCodeRepeat(dto.getCode());
        if(StringUtil.isNotEmpty(result)){
            return Result.fail(result);
        }

        //保存并返回
        return Result.success(dozerUtils.map(powerSuperviseLinkService.save(entity),PowerSuperviseLinkSaveRetDTO.class));
    }

    /**
     * 校验重复提交
     * @param code
     * @return
     */
    public String checkCodeRepeat(String code){
        PowerSuperviseLinkExample ex = new PowerSuperviseLinkExample();
        ex.createCriteria().andCodeEqualTo(code);
        List<PowerSuperviseLink>  list = powerSuperviseLinkService.find(ex);
        if(list != null && list.size() > 0){
            return "环节编码不能重复!!";
        }
        return null;
    }

    /**
     * 校验重复提交是否可执行更新操作
     * @param code
     * @return
     */
    public Boolean checkCodeRepeat(Long id,String code){
        PowerSuperviseLinkExample ex = new PowerSuperviseLinkExample();
        ex.createCriteria().andCodeEqualTo(code);
        List<PowerSuperviseLink>  list = powerSuperviseLinkService.find(ex);
        if(list != null && list.size() > 0){
            for (PowerSuperviseLink li : list) {
                if(li.getCode().equals(code) && li.getId().equals(id)){
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * 权责监管环节删除
     * @param id
     * @return
     */
    @ApiOperation(value = "权责监管环节删除" ,notes = "权责监管环节删除")
    @ApiResponses({
            @ApiResponse(code = 110120 , message = "权责监管环节ID不能为空"),
    })
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id){

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_ID_NULL,id);

        //删除并返回
        powerSuperviseLinkService.deleteById(id);
        return Result.success(true);
    }

    /**
     * 权责监管环节更新
     * @param dto
     * @return
     */
    @ApiOperation(value = "权责监管环节更新",notes = "权责监管环节更新")
    @ApiResponses({
            @ApiResponse(code = 110120 , message = "权责监管环节ID不能为空"),
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody PowerSuperviseLinkUpdateDTO dto){

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_ID_NULL,dto.getId());

        //校验重复提交
        if(!checkCodeRepeat(dto.getId(),dto.getCode())){
            return Result.fail("环节编码不能重复!!");
        }

        //更新并返回
        powerSuperviseLinkService.updateByIdSelective(dozerUtils.map(dto,PowerSuperviseLink.class));
        return Result.success(true);
    }

    /**
     * 权责监管环节更新排序
     * @param dto
     * @return
     */
    @ApiOperation(value = "权责监管环节更新排序",notes = "权责监管环节更新排序")
    @ApiResponses({
            @ApiResponse(code = 110120 , message = "权责监管环节ID不能为空"),
    })
    @RequestMapping(value = "/updateSort",method = RequestMethod.POST)
    public Result<Boolean> updateSort(@RequestBody PowerSuperviseLinkUpdateSortDTO dto){
        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_ID_NULL,dto.getFirstId());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_ID_NULL,dto.getSecondId());

        //更新并返回
        PowerSuperviseLink firstPowerSuperviseLink = new PowerSuperviseLink();
        firstPowerSuperviseLink.setId(dto.getFirstId());
        firstPowerSuperviseLink.setSortNum(dto.getFirstSortNum());

        PowerSuperviseLink secondPowerSuperviseLink = new PowerSuperviseLink();
        secondPowerSuperviseLink.setId(dto.getSecondId());
        secondPowerSuperviseLink.setSortNum(dto.getSecondSortNum());

        powerSuperviseLinkService.updateByIdSelective(firstPowerSuperviseLink);
        powerSuperviseLinkService.updateByIdSelective(secondPowerSuperviseLink);
        return Result.success(true);
    }

    /**
     * 权责监管环节分页
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "权责监管环节分页",notes = "权责监管环节分页")
    @RequestMapping(value ="/page",method = RequestMethod.POST)
    public Result<PageInfo<PowerSuperviseLinkPageResDTO>> page(@RequestBody OpenApiReq<PowerSuperviseLinkPageReqDTO> openApiReq){

        //启动分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        PowerSuperviseLinkExample ex = new PowerSuperviseLinkExample();
        ex.createCriteria()
                .andPowerSuperviseIdEqualTo(openApiReq.getData().getPowerSuperviseId())
                .andCodeLike(PowerSuperviseLinkExample.fullLike(openApiReq.getData().getCode()))
                .andNameLike(PowerSuperviseLinkExample.fullLike(openApiReq.getData().getName()));
        ex.setOrderByClause(" sort_num ");

        //查询并返回
        List<PowerSuperviseLinkPageResDTO> dtoList = dozerUtils.mapList(powerSuperviseLinkService.find(ex),PowerSuperviseLinkPageResDTO.class);
        dtoList.forEach((dto) ->{
            Map<String,String> map = bizCommon.getUserInfo(dto.getConfirmUser(),dto.getDutyUser(),dto.getCopyUser());
            if(map != null){
                dto.setConfirmUserName(map.get("confirmUserNames"));
                dto.setDutyUserName(map.get("dutyUserName"));
                dto.setCopyUserName(map.get("copyUserNames"));
            }
        });
        return Result.success(new PageInfo<>(dtoList));
    }

    /**
     * 权责监管环节详情
     * @param id
     * @return
     */
    @ApiOperation(value = "权责监管环节详情" ,notes = "权责监管环节详情")
    @ApiResponses({
            @ApiResponse(code = 110120 , message = "权责监管环节ID不能为空"),
    })
    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public Result<PowerSuperviseLinkDetailDTO> detail(@RequestParam(value = "id") Long id){

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_LINK_ID_NULL,id);

        //查询并返回
        PowerSuperviseLinkDetailDTO dto = dozerUtils.map(powerSuperviseLinkService.getById(id),PowerSuperviseLinkDetailDTO.class);
        Map<String,String> map = bizCommon.getUserInfo(dto.getConfirmUser(),dto.getDutyUser(),dto.getCopyUser());
        if(map != null){
            dto.setConfirmUserName(map.get("confirmUserNames"));
            dto.setDutyUserName(map.get("dutyUserName"));
            dto.setCopyUserName(map.get("copyUserNames"));
        }
        return Result.success(dto);
    }
}
