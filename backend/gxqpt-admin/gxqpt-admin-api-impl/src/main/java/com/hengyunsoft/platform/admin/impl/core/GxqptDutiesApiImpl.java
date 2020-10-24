package com.hengyunsoft.platform.admin.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDutiesApi;
import com.hengyunsoft.platform.admin.api.core.dto.duties.GxqptDutiesDTO;
import com.hengyunsoft.platform.admin.api.core.dto.duties.SimpDutiesDTO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDuties;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDuties;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDutiesExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDutiesService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwDutiesExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwDutiesService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:职务管理
 *
 * @author chb
 * @date 2018/3/7 13:50
 * @return
 */
@Api(value = "API - GxqptDutiesApiImpl", description = "职务管理")
@RestController
@RequestMapping("duties")
@Slf4j
public class GxqptDutiesApiImpl implements GxqptDutiesApi {


    /**
     * 已删除
     */
    private static final String DELETE = "1";
    /**
     * 未删除
     */
    private static final String UNDELETE = "0";

    @Autowired
    private GxqptDutiesService gxqptDutiesService;
    @Autowired
    private DozerUtils dozerUtils;
    /**
     * 省电子政务网Service
     */
    @Autowired
    private SdzzwwDutiesService sdzzwwDutiesService;

    /**
     * 新增职务
     *
     * @param gxqptDutiesDTO
     * @return
     */
    @Override
    @ApiOperation(value = "新建职务信息", notes = "新建职务信息")
    @ApiResponses({
            @ApiResponse(code = 56003, message = "职务信息为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwDuties.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<GxqptDutiesDTO> save(@RequestBody GxqptDutiesDTO gxqptDutiesDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DUTIES_NULL, gxqptDutiesDTO);
        //2.转换
        GxqptDuties duties = dozerUtils.map(gxqptDutiesDTO, GxqptDuties.class);
        //3.数据初始化
        duties.setIsdelete(UNDELETE);
        duties.setCreateUser(BaseContextHandler.getAdminId().toString());
        duties.setUpdateUser(duties.getCreateUser());
        Date nowDate = new Date();
        duties.setCreateTime(nowDate);
        duties.setUpdateTime(nowDate);
        //4.数据保存
        GxqptDuties duties1 = gxqptDutiesService.save(duties);
        if (duties1.getId() != null) {
            return Result.success(dozerUtils.map(duties1, GxqptDutiesDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     * 描述:根据ID修改数据信息
     *
     * @return
     * @author chb
     * @date 2018/3/7 14:14
     */
    @Override
    @ApiOperation(value = "根据ID修改职务信息", notes = "根据ID修改职务信息")
    @ApiResponses({
            @ApiResponse(code = 56003, message = "职务信息为空"),
            @ApiResponse(code = 56004, message = "职务ID为空")
    })
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwDuties.class)
            }
    )
    public Result<GxqptDutiesDTO> updateById(@RequestBody GxqptDutiesDTO gxqptDutiesDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DUTIES_NULL, gxqptDutiesDTO);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_ID_EMPTY, gxqptDutiesDTO.getId());
        //2.转换
        GxqptDuties duties = dozerUtils.map(gxqptDutiesDTO, GxqptDuties.class);
        //3.数据初始化
        duties.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        duties.setUpdateTime(nowDate);
        //4.数据保存
        int result = gxqptDutiesService.updateByIdSelective(duties);
        if (result > 0) {
            return Result.success(dozerUtils.map(duties, GxqptDutiesDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     * 根据ID获取职务信息
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据ID获取职务信息", notes = "根据ID获取职务信息")
    @ApiResponses({
            @ApiResponse(code = 56004, message = "职务ID为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @RequestMapping(value = "/getDutiesById", method = RequestMethod.GET)
    public Result<GxqptDutiesDTO> getDutiesById(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_ID_EMPTY, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        //2.查询
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptDuties duties = gxqptDutiesService.getById(id);
            return Result.success(dozerUtils.map(duties, GxqptDutiesDTO.class));
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwDuties sdzzwwDuties = sdzzwwDutiesService.getById(id);
            return Result.success(dozerUtils.map(sdzzwwDuties, GxqptDutiesDTO.class));
        } else {
            return null;
        }
    }

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据ID删除职务信息", notes = "根据ID删除职务信息")
    @ApiResponses({
            @ApiResponse(code = 56004, message = "职务ID为空")
    })
    @RequestMapping(value = "/removeById", method = RequestMethod.GET)
    public Result<String> removeById(@RequestParam(value = "id") String id) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_ID_EMPTY, id);
        //2.数据初始化
        GxqptDuties duties = new GxqptDuties();
        duties.setId(id);
        duties.setIsdelete(DELETE);
        duties.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        duties.setUpdateTime(nowDate);
        //3.操作数据
        int result = gxqptDutiesService.updateByIdSelective(duties);

        if (result > 0) {
            return Result.success("删除成功！");
        }
        return Result.fail("删除失败！");
    }

    /**
     * 获取职务列表分页数据
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "获取职务信息分页数据", notes = "获取职务信息分页数据")
    @RequestMapping(value = "/findDutiesList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptDutiesDTO>> findDutiesList(@RequestBody OpenApiReq<GxqptDutiesDTO> openApiReq) {
        GxqptDutiesDTO gxqptEmpDTO = openApiReq.getData();
        String systemCode = gxqptEmpDTO.getSystemCode();
        if (gxqptEmpDTO.getOrgid() == null || "".equals(gxqptEmpDTO.getOrgid())) {
            return Result.success(new PageInfo<>(new ArrayList<>()));
        }
        //1.数据初始化
        String isenable = "";
        if (gxqptEmpDTO.getIsenable() != null && !"".equals(gxqptEmpDTO.getIsenable())) {
            isenable = gxqptEmpDTO.getIsenable();
        }
        GxqptDutiesExample example = new GxqptDutiesExample();
        example.createCriteria().andNameLike(GxqptDutiesExample.fullLike(gxqptEmpDTO.getName()))
                .andIsenableEqualTo(isenable)
                .andOrgidEqualTo(gxqptEmpDTO.getOrgid())
                .andCodeEqualTo(gxqptEmpDTO.getCode()).andIsdeleteEqualTo(UNDELETE);
        example.setOrderByClause("sortvalue asc");

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        List<? extends SdzzwwDuties> list;
        //2.查询
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            list = gxqptDutiesService.find(example);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwDutiesExample sdzzwwDutiesExample = new SdzzwwDutiesExample();
            sdzzwwDutiesExample.createCriteria().andNameLike(GxqptDutiesExample.fullLike(gxqptEmpDTO.getName()))
                    .andOrgnameEqualTo(gxqptEmpDTO.getOrgname()).andOrgidEqualTo(gxqptEmpDTO.getOrgid())
                    .andCodeEqualTo(gxqptEmpDTO.getCode()).andIsdeleteEqualTo(UNDELETE);
            sdzzwwDutiesExample.setOrderByClause("sortvalue asc");
            list = sdzzwwDutiesService.find(sdzzwwDutiesExample);
        } else {
            list = new ArrayList<>();
        }
        //3.转换
        List<GxqptDutiesDTO> pageList = dozerUtils.mapPage(list, GxqptDutiesDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 描述：查询gxqpt所有职务的信息
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/27
     * 修改内容：
     */
    @Override
    @RequestMapping(value = "findSimpDutiesGxqpt", method = RequestMethod.GET)
    @ApiOperation(value = "查询gxqpt所有职务的信息", notes = "查询gxqpt所有职务的信息")
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id不能为空")
    })
    public Result<List<SimpDutiesDTO>> findSimpDutiesGxqpt(String orgid) {
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgid);
        //1.数据初始化
        String isenable = "1";
        GxqptDutiesExample example = new GxqptDutiesExample();
        example.createCriteria()
                .andIsenableEqualTo(isenable)
                .andOrgidEqualTo(orgid)
                .andIsdeleteEqualTo(UNDELETE);
        //andCodeEqualTo(CommonConstants.SYS_GXQPT_CODE)
        example.setOrderByClause("sortvalue asc");
        List<? extends SdzzwwDuties> list = gxqptDutiesService.find(example);
        ;
        List<SimpDutiesDTO> resList = dozerUtils.mapList(list, SimpDutiesDTO.class);
        return Result.success(resList);
    }
}
