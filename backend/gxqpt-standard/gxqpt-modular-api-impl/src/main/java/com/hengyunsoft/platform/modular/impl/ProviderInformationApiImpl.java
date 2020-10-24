package com.hengyunsoft.platform.modular.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.StandardExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.modular.dto.ProviderInfomationPageQueryDTO;
import com.hengyunsoft.platform.modular.dto.ProviderInfomationSaveDTO;
import com.hengyunsoft.platform.modular.entity.modular.po.ProviderInformation;
import com.hengyunsoft.platform.modular.repository.modular.example.ProviderInformationExample;
import com.hengyunsoft.platform.modular.repository.service.ProviderInformationService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tianai
 * @createTime 2019-2-20
 */
@RestController
@Slf4j
@Api(value = "API - ProviderInformationApiImpl", description = "提供商信息")
public class ProviderInformationApiImpl {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ProviderInformationService providerInformationService;




    /**
     * 分页查询提供商
     * @param openApiReq
     */
    @RequestMapping(value = "/provider/pageProviderInformation", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询提供商", notes = "分页查询提供商")
    public Result<PageInfo<ProviderInformation>> pageProviderInformation(@RequestBody OpenApiReq<ProviderInfomationPageQueryDTO> openApiReq) {

        ProviderInformationExample example = new ProviderInformationExample();
        if(openApiReq.getData()!=null){
            example.createCriteria().andNameLike(openApiReq.getData().getName());
        }
        //查询
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ProviderInformation> pageList = dozerUtils.
                mapPage(providerInformationService.find(example), ProviderInformation.class);
        return Result.success(new PageInfo<>(pageList));
    }
    /**
     * 根据id查询提供商
     * @param id
     */
    @RequestMapping(value = "/provider/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询提供商", notes = "根据id查询提供商")
    public Result<ProviderInformation> get(@RequestParam Long id) {

        if(id==null && id.equals("")){
        return Result.fail("提供商id不能为空！");
        }
        //查询
        ProviderInformation providerInformation = providerInformationService.getById(id);
        return Result.success(providerInformation);
    }


    /**
     * 查询所有提供商
     * @param
     */
    @RequestMapping(value = "/provider/getAllProvider", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有提供商", notes = "查询所有提供商")
    public Result<List<ProviderInformation>> getAllProvider() {
        ProviderInformationExample example = new ProviderInformationExample();
        //查询
        List<ProviderInformation> list = dozerUtils.mapList(providerInformationService.find(example), ProviderInformation.class);
        return Result.success(list);
    }
    /**
     * 新增提供商信息
     * @param saveDTO
     */
    @ApiOperation(value = "新增提供商信息", notes = "新增提供商信息")
    @ApiResponses({
            @ApiResponse(code = 37101, message = "提供商名称不能为空"),
            @ApiResponse(code = 37102, message = "提供商联系电话不能为空"),
            @ApiResponse(code = 37103, message = "提供商地址不能为空"),
            @ApiResponse(code = 37104, message = "提供商简介不能为空"),
    })
    @RequestMapping(value = "/provider/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody ProviderInfomationSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_NAME, saveDTO.getName());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_PHONE, saveDTO.getPhone());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_ADDRESS, saveDTO.getAddress());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_DESCRIBLE, saveDTO.getDescrible());
         ProviderInformation providerInformation=dozerUtils.map(saveDTO,ProviderInformation.class);
        providerInformationService.saveSelective(providerInformation);
        return Result.success(true);
    }

    /**
     * 更新提供商信息
     * @param saveDTO
     */
    @ApiOperation(value = "修改提供商信息", notes = "更新提供商信息")
    @ApiResponses({
            @ApiResponse(code = 37100, message = "提供商ID不能为空"),
            @ApiResponse(code = 37101, message = "提供商名称不能为空"),
            @ApiResponse(code = 37102, message = "提供商联系电话不能为空"),
            @ApiResponse(code = 37103, message = "提供商地址不能为空"),
            @ApiResponse(code = 37104, message = "提供商简介不能为空"),
    })
    @RequestMapping(value = "/provider/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody ProviderInfomationSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_ID, saveDTO.getId());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_NAME, saveDTO.getName());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_PHONE, saveDTO.getPhone());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_ADDRESS, saveDTO.getAddress());
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_DESCRIBLE, saveDTO.getDescrible());
        ProviderInformation providerInformation=dozerUtils.map(saveDTO,ProviderInformation.class);
        providerInformationService.updateByIdSelective(providerInformation);
        return Result.success(true);
    }

    /**
     * 根据id 删除提供商信息
     * @param id
     */
    @RequestMapping(value = "/provider/delete", method = RequestMethod.GET)
    @ApiOperation(value = "根据id 删除提供商信息", notes = "根据id 删除提供商信息")
    @ApiResponses({
            @ApiResponse(code = 37100, message = "提供商ID不能为空")
    })
    public Result<Boolean> delete(@RequestParam Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.PROVIDER_INFOMATION_ID, id);
        providerInformationService.deleteById(id);
        return Result.success(true);
    }


}
