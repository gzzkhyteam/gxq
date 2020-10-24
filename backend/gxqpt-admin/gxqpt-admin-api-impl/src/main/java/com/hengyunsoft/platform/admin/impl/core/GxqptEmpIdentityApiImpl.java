package com.hengyunsoft.platform.admin.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpIdentityApi;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.*;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpIdentityDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmpIdentity;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptEmpIdentityService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(value = "API - GxqptEmpIdentityApiImpl", description = "人员身份管理")
@RestController
@RequestMapping("empIdentity")
@Slf4j
public class GxqptEmpIdentityApiImpl implements GxqptEmpIdentityApi {


    /**
     *DozerUtils
     */
    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private GxqptEmpIdentityService empIdentityService;

    /**
     * 新建人员身份
     * @param GxqptEmpDTO
     * @return
     */
    @Override
    @ApiOperation(value = "新建人员身份", notes = "新建人员身份")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56026, message = "人员身份不能为空"),
            @ApiResponse(code = 56001, message = "人员ID不能为空"),
            @ApiResponse(code = 56008, message = "单位id不能为空"),
            @ApiResponse(code = 56011, message = "部门id不能为空"),
            @ApiResponse(code = 56006, message = "岗位ID不能为空"),
            @ApiResponse(code = 56004, message = "职务ID不能为空"),
            @ApiResponse(code = 56028, message = "人员身份是否启用不能为空"),
    })
    public Result<GxqptEmpIdentityRetDTO> save(@RequestBody GxqptEmpIdentitySaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_NULL, saveDTO);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ID, saveDTO.getUserId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, saveDTO.getOrgId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, saveDTO.getDeptId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_ID_EMPTY, saveDTO.getPostId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_ID_EMPTY, saveDTO.getDutyId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_ISENABLE, saveDTO.getIsenable());

        //2.转换
        GxqptEmpIdentity identity = dozerUtils.map(saveDTO,GxqptEmpIdentity.class);
        //3.数据处理
        identity.setIsdelete(GxqptEmpIdentityConstant.FALSE);
        identity.setCreateUser(BaseContextHandler.getAdminId().toString());
        identity.setUpdateUser(identity.getCreateUser());
        Date nowDate = new Date();
        identity.setCreateTime(nowDate);
        identity.setUpdateTime(nowDate);
        //4.保存
        GxqptEmpIdentity ridentity =  empIdentityService.save(identity);
        if(ridentity.getId()!=null){
            return Result.success(dozerUtils.map(ridentity,GxqptEmpIdentityRetDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     *获取人员身份
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "获取人员身份", notes = "获取人员身份")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56027, message = "人员身份ID为空")
    })
    public Result<GxqptEmpIdentityRetDTO> getById(@RequestParam(value = "id") String id) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_ID, id);
        //2.查询
        GxqptEmpIdentityDO ridentity = empIdentityService.getEmpIdentityById(id);
        return Result.success(dozerUtils.map(ridentity,GxqptEmpIdentityRetDTO.class));
    }

    @Override
    @ApiOperation(value = "删除人员身份", notes = "删除人员身份")
    @RequestMapping(value = "/removeById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56027, message = "人员身份ID为空")
    })
    public Result<String> removeById(@RequestParam(value = "id") String id) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_ID, id);
        //2.数据处理
        GxqptEmpIdentity identity = new GxqptEmpIdentity();
        identity.setId(id);
        identity.setIsdelete(GxqptEmpIdentityConstant.TRUE);
        Date nowDate = new Date();
        identity.setUpdateTime(nowDate);
        //3.数据操作
        int result = empIdentityService.updateByIdSelective(identity);
        if(result>0){
            return Result.success("删除成功！");
        }

        return Result.fail("删除失败！");
    }


    /**
     *更新人员身份
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "更新人员身份", notes = "更新人员身份")
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56026, message = "人员身份不能为空"),
            @ApiResponse(code = 56027, message = "人员身份ID为空"),
            @ApiResponse(code = 56001, message = "人员ID不能为空"),
            @ApiResponse(code = 56008, message = "单位id不能为空"),
            @ApiResponse(code = 56011, message = "部门id不能为空"),
            @ApiResponse(code = 56006, message = "岗位ID不能为空"),
            @ApiResponse(code = 56004, message = "职务ID不能为空"),
            @ApiResponse(code = 56028, message = "人员身份是否启用不能为空")
    })
    public Result<GxqptEmpIdentityRetDTO> updateById(@RequestBody GxqptEmpIdentityUpdateDTO updateDTO) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_NULL, updateDTO);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_ID, updateDTO.getId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ID, updateDTO.getUserId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, updateDTO.getOrgId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, updateDTO.getDeptId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_ID_EMPTY, updateDTO.getPostId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_ID_EMPTY, updateDTO.getDutyId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_IDENTITY_ISENABLE, updateDTO.getIsenable());
        //2.转换
        GxqptEmpIdentity identity = dozerUtils.map(updateDTO,GxqptEmpIdentity.class);
        //3.数据初始化
        identity.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        identity.setUpdateTime(nowDate);
        //4.数据操作
        int  result =  empIdentityService.updateByIdSelective(identity);
        if(result>0){
            return Result.success(dozerUtils.map(identity,GxqptEmpIdentityRetDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     *获取人员身份分页
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "获取人员身份分页", notes = "获取人员身份分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiResponses({
            //@ApiResponse(code = 56000, message = "人员为空")
    })
    public Result<PageInfo<GxqptEmpIdentityRetDTO>> page(@RequestBody OpenApiReq<GxqptEmpIdentityQueryDTO> openApiReq) {
        GxqptEmpIdentityQueryDTO dto = openApiReq.getData();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        GxqptEmpIdentity identity = new GxqptEmpIdentity();
        identity.setUserId(dto.getUserId());
        identity.setOrgId(dto.getOrgId());
        identity.setDeptId(dto.getDeptId());
        identity.setDutyId(dto.getDutyId());
        identity.setPostId(dto.getPostId());
        identity.setIsenable(dto.getIsenable());
        identity.setIsdelete(GxqptEmpIdentityConstant.FALSE);

        List<GxqptEmpIdentityDO> list = empIdentityService.findPage(identity);
        List<GxqptEmpIdentityRetDTO> retDTOList = dozerUtils.mapPage(list,GxqptEmpIdentityRetDTO.class);
        return Result.success(new PageInfo<>(retDTOList));
    }
}
