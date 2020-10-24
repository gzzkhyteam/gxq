package com.hengyunsoft.platform.developer.impl.apply;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.apply.dto.ApplicationProviderConditionDTO;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationProvider;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationProviderExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationProviderService;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luchanghong
 * @create 2019-02-15 10:45
 * @desc 应用提供商
 **/
@Api(value = "API - ApplicationProviderApiImpl", description = "应用提供商")
@Slf4j
@RestController
@RequestMapping("applicationProvider")
public class ApplicationProviderApiImpl {
    @Autowired
    private ApplicationProviderService applicationProviderService;
    @Autowired
    private DozerUtils dozerUtils;

    @ApiOperation(value = "查询", notes = "根据id查询")
    @ApiResponses({})
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Result<ApplicationProvider> get(@RequestParam Long id) {
        return Result.success(applicationProviderService.getById(id));
    }

    @ApiOperation(value = "查询所有启用未删除数据", notes = "查询所有启用未删除数据")
    @ApiResponses({})
    @RequestMapping(value = "findConditonAll", method = RequestMethod.GET)
    public Result<List<ApplicationProviderConditionDTO>> findConditonAll() {
        ApplicationProviderExample ae=new ApplicationProviderExample();
        ae.createCriteria().andEnableIsEqualTo(true).andDeleteIsEqualTo(false);
        List<ApplicationProvider> providers = applicationProviderService.find(ae);
        List<ApplicationProviderConditionDTO> as = dozerUtils.mapList(providers, ApplicationProviderConditionDTO.class);
        return Result.success(as);
    }

    @ApiOperation(value = "查询", notes = "查询所有")
    @ApiResponses({})
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result<List<ApplicationProvider>> find() {
        return Result.success(applicationProviderService.find(null));
    }
    @ApiOperation(value = "查询", notes = "查询分页")
    @ApiResponses({})
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ApplicationProvider>> page(@RequestBody OpenApiReq<ApplicationProvider> openApiReq) {
        ApplicationProviderExample example = new ApplicationProviderExample();
        ApplicationProviderExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");
        if(openApiReq.getData()!=null){
            criteria.andNameLike(ApplicationProviderExample.fullLike(openApiReq.getData().getName()));
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(applicationProviderService.find(example)));
    }

    @ApiOperation(value = "保存", notes = "保存不为空的字段")
    @ApiResponses({})
    @ValidatorStandard(
        {
            @Constraint(value = ApplicationProvider.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
        }
    )
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public Result<ApplicationProvider> save(@RequestBody ApplicationProvider negativeListStatistics) {
        //1，验证必要参数
        //2，尽可能多的设置默认值
        applicationProviderService.saveSelective(negativeListStatistics);
        return Result.success(negativeListStatistics);
    }

    @ApiOperation(value = "修改", notes = "修改不为空的字段")
    @ApiResponses({})
    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    public Result<ApplicationProvider> update(@RequestBody ApplicationProvider negativeListStatistics) {
        //1，验证必要参数
        //2，尽可能多的设置默认值
        applicationProviderService.updateByIdSelective(negativeListStatistics);
        return Result.success(negativeListStatistics);
    }

    @ApiOperation(value = "删除", notes = "根据id物理删除")
    @ApiResponses({})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@PathVariable Long id) {
        applicationProviderService.deleteById(id);
        return Result.success(true);
    }
}