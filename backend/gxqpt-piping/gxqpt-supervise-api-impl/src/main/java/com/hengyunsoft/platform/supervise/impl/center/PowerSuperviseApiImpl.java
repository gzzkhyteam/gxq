package com.hengyunsoft.platform.supervise.impl.center;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SuperviseExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.supervise.dto.center.*;
import com.hengyunsoft.platform.supervise.entity.po.PowerSupervise;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseType;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseExample;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTypeExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseLinkService;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseService;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseTypeService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：权责监管API
 * 修改人：sxy
 * 修改时间：2018/9/12
 * 修改内容：新增基础接口
 */
@Api(value = "API - PowerSuperviseApiImpl.java", description = "权责监管API")
@RestController
@RequestMapping("powersupervise")
@Slf4j
public class PowerSuperviseApiImpl {


    @Autowired
    DozerUtils dozerUtils;

    @Autowired
    GxqptOrgApi gxqptOrgApi;

    @Autowired
    private PowerSuperviseService powerSuperviseService;

    @Autowired
    private PowerSuperviseTypeService powerSuperviseTypeService;

    @Autowired
    private PowerSuperviseLinkService powerSuperviseLinkService;

    /**
     * 权责监管保存
     * @param dto
     * @return
     */
    @ApiOperation(value = "权责监管保存",notes = "权责监管保存")
    @ApiResponses({
            @ApiResponse(code = 110101 , message = "权责编码不能为空"),
            @ApiResponse(code = 110102 , message = "权责类型不能为空"),
            @ApiResponse(code = 110103 , message = "权责名称不能为空"),
            @ApiResponse(code = 110104 , message = "执行单位不能为空"),
            @ApiResponse(code = 110128 , message = "运行状态不能为空"),
    })
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result<PowerSuperviseSaveRetDTO> save(@RequestBody PowerSuperviseSaveDTO dto){

        //校验
        BizAssert.assertNotEmpty(SuperviseExceptionCode.POWER_SUPERVISE_CODE_NULL,dto.getCode());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_TYPE_NULL,dto.getTypeId());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_NAME_NULL,dto.getName());
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_UNIT_NULL,dto.getUnit());
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_RUN_STATUS_NULL,dto.getRunStatus());

        //转换
        PowerSupervise entity = dozerUtils.map(dto, PowerSupervise.class);
        entity.setCreateUser(BaseContextHandler.getAdminId());
        entity.setCreateTime(new Date());
        entity.setUpdateUser(BaseContextHandler.getAdminId());
        entity.setUpdateTime(new Date());

        //校验重复提交
        PowerSuperviseExample ex = new PowerSuperviseExample();
        ex.createCriteria().andCodeEqualTo(dto.getCode());
        List<PowerSupervise> list = powerSuperviseService.find(ex);
        if(list != null && list.size() > 0){
            return Result.fail("权责编码已存在！");
        }

        //保存并返回
        return Result.success(dozerUtils.map(powerSuperviseService.save(entity),PowerSuperviseSaveRetDTO.class));
    }

    /**
     * 权责监管删除
     * @param id
     * @return
     */
    @ApiOperation(value = "权责监管删除" ,notes = "权责监管删除")
    @ApiResponses({
            @ApiResponse(code = 110100 , message = "权责监管id不能为空"),
    })
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id){

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_ID_NULL,id);

        //删除并返回
        powerSuperviseService.deleteById(id);

        //根据主配置ID删除子环节
        powerSuperviseLinkService.deleteByParentId(id);
        return Result.success(true);
    }

    /**
     * 权责监管更新
     * @param dto
     * @return
     */
    @ApiOperation(value = "权责监管更新",notes = "权责监管更新")
    @ApiResponses({
            @ApiResponse(code = 110100 , message = "权责监管id不能为空"),
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody PowerSuperviseUpdateDTO dto){

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_ID_NULL,dto.getId());

        //更新并返回
        powerSuperviseService.updateByIdSelective(dozerUtils.map(dto,PowerSupervise.class));
        return Result.success(true);
    }


    /**
     * 权责监管分页
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "权责监管分页",notes = "权责监管分页")
    @RequestMapping(value ="/page",method = RequestMethod.POST)
    public Result<PageInfo<PowerSupervisePageResDTO>> page(@RequestBody OpenApiReq<PowerSupervisePageReqDTO> openApiReq){

        //启动分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        if(openApiReq.getData().getUnit() == null){
            return Result.success(null);
        }
        PowerSuperviseExample ex = new PowerSuperviseExample();
        ex.createCriteria()
                .andTypeIdEqualTo(openApiReq.getData().getTypeId())
                .andCodeLike(PowerSuperviseExample.fullLike(openApiReq.getData().getCode()))
                .andNameLike(PowerSuperviseExample.fullLike(openApiReq.getData().getName()))
                .andUnitIn(openApiReq.getData().getUnit())
                .andRunStatusEqualTo(openApiReq.getData().getRunStatus());
        ex.setOrderByClause(" create_time desc");
        List<PowerSupervise> list = powerSuperviseService.find(ex);
        List<PowerSupervisePageResDTO> listDto = dozerUtils.mapList(list,PowerSupervisePageResDTO.class);
        if(listDto==null){
            return Result.success(null);
        }
        for(int i=0;i<listDto.size();i++){
            List ids = new ArrayList();
            ids.add(listDto.get(i).getUnit());
            List<GxqptOrgResDTO> orgList = gxqptOrgApi.findOrgNameByIds(ids).getData();
            PowerSuperviseType ps = powerSuperviseTypeService.getById(listDto.get(i).getTypeId());
            if(orgList==null){
                log.info("根据单位ids[{}]查询单位信息失败！！",ids);
            }else {
                if(ps != null){
                    listDto.get(i).setTypeName(ps.getName());
                }
                listDto.get(i).setUnitName(orgList.get(0).getName());
            }
        }

        //查询并返回
        return Result.success(new PageInfo<>(listDto));
    }


    /**
     * 权责监管详情
     * @param id
     * @return
     */
    @ApiOperation(value = "权责监管详情" ,notes = "权责监管详情")
    @ApiResponses({
            @ApiResponse(code = 110100 , message = "权责监管id不能为空"),
    })
    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public Result<PowerSuperviseDetailDTO> detail(@RequestParam(value = "id") Long id){

        //校验
        BizAssert.assertNotNull(SuperviseExceptionCode.POWER_SUPERVISE_ID_NULL,id);

        //查询并返回
        PowerSupervise powerSupervise = powerSuperviseService.getById(id);
        if(powerSupervise == null){
            return Result.success(null);
        }
        List ids = new ArrayList();
        ids.add(powerSupervise.getUnit());
        List<GxqptOrgResDTO> orgList = gxqptOrgApi.findOrgNameByIds(ids).getData();
        PowerSuperviseType ps = powerSuperviseTypeService.getById(powerSupervise.getTypeId());
        if(orgList==null){
            log.info("根据单位ids[{}]查询单位信息失败！！",ids);
        }
        PowerSuperviseDetailDTO dto = dozerUtils.map(powerSupervise,PowerSuperviseDetailDTO.class);
        dto.setUnitName(orgList.get(0).getName());
        if(ps != null){
            dto.setTypeName(ps.getName());
        }
        return Result.success(dto);
    }
}
