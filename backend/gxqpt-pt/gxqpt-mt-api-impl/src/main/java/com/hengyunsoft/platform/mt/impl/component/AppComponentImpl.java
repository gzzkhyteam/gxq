package com.hengyunsoft.platform.mt.impl.component;

import java.util.Date;
import java.util.List;

import javax.validation.groups.Default;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.component.dto.AppComponentDTO;
import com.hengyunsoft.platform.mt.entity.component.po.AppComponent;
import com.hengyunsoft.platform.mt.repository.component.example.AppComponentExample;
import com.hengyunsoft.platform.mt.repository.component.service.AppComponentService;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.hengyunsoft.platform.mt.impl.component
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：APP组建管理
 * 修改人：zhaopengfei
 * 修改时间：2018/8/27
 * 修改内容：新增基础接口
 */
@Api(value = "API - ComponentImpl.java", description = "APP组建管理")
@RestController
@RequestMapping("component")
@Slf4j
public class AppComponentImpl /*implements AppComponentApi */{
    @Autowired
    private AppComponentService appComponentService;
    @Autowired
    private DozerUtils dozerUtils;
  /**
   * 描述：用于保存主键
   * 参数：AppComponentDTO
   * 返回值：Result<Boolean>
   * 修改人：zhaopengfei
   * 修改时间：2018/8/27
   * 修改内容：
   */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "用于保存主键", notes = "用于保存主键")
    @ApiResponses({
            @ApiResponse(code = 94000, message = "组件名称不能为空"),
            @ApiResponse(code = 94001, message = "组件内容不能为空"),
            @ApiResponse(code = 94002, message = "组件对象不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = AppComponent.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    
    public Result<Boolean> save(@RequestBody  AppComponentDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_NOT_NULL, dto);
        BizAssert.assertNotEmpty(MtExceptionCode.COMPONENT_NAME_NOT_NULL, dto.getComponentName());
        BizAssert.assertNotEmpty(MtExceptionCode.COMPONENT_CONTENT_NOT_NULL, dto.getComponentDesc());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();

        //保存操作
        try {
            AppComponent appComponent = dozerUtils.map(dto,AppComponent.class);
            appComponent.setCreateUser(userId);
            appComponent.setUpdateUser(userId);
            appComponentService.save(appComponent);
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.success(true);

    }

    /**
     * 描述：删除组件信息
     * 参数：id 主键ID
     * 返回值：  Result<Boolean>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @ApiOperation(value = "删除组件信息", notes = "删除组件信息")
    @ApiResponses({
            @ApiResponse(code = 94003, message = "组件ID不能为空"),
    })
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_ID_NOT_NULL, id);
        try {
            appComponentService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e);
        }
        return Result.success(true);
    }

    /**
     * 描述：修改组件信息
     * 参数：AppComponentDTO
     * 返回值：Result<Boolean>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/27
     * 修改内容：
     */
    
    @ApiOperation(value = "修改组件信息", notes = "修改组件信息")
    @ApiResponses({
            @ApiResponse(code = 94003, message = "组件ID不能为空"),
            @ApiResponse(code = 94000, message = "组件名称不能为空"),
            @ApiResponse(code = 94001, message = "组件内容不能为空"),
            @ApiResponse(code = 94002, message = "组件对象不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = AppComponent.class)
            }
    )
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody AppComponentDTO dto) {
        //数据验证
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_NOT_NULL, dto);
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_NAME_NOT_NULL, dto.getComponentName());
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_CONTENT_NOT_NULL, dto.getComponentDesc());
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_ID_NOT_NULL, dto.getId());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务操作
        try {
            AppComponent component = dozerUtils.map(dto,AppComponent.class);
            component.setUpdateUser(userId);
            component.setUpdateTime(date);
            appComponentService.updateByIdSelective(component);
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.success(true);
    }

    /**
     * 描述：根据id获取组件详细信息
     * 参数：id：主键id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @ApiOperation(value = "根据id获取组件详细信息", notes = "根据id获取组件详细信息")
    @ApiResponses({
            @ApiResponse(code = 94003, message = "组件ID不能为空"),
    })
    
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public Result<AppComponentDTO> getComById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(MtExceptionCode.COMPONENT_ID_NOT_NULL, id);
        AppComponent component = appComponentService.getById(id);
        return Result.success(dozerUtils.map(component,AppComponentDTO.class));
    }
    /**
     * 描述：查询组件分页信息
     * 参数：openApiReq 分页信息；
     * 返回值：PageInfo<AppComponentDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation(value = "查询组件分页信息", notes = "查询组件分页信息")
    
    public Result<PageInfo<AppComponentDTO>> getPage(@RequestBody OpenApiReq<String> openApiReq) {
        AppComponentExample example = new AppComponentExample();
        String likeCondition = openApiReq.getData();
        if (!StringUtils.isEmpty(likeCondition)){
            likeCondition = '%'+likeCondition+'%';
            example.createCriteria().andComponentNameLike(likeCondition);
        }
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<AppComponent> list = appComponentService.find(example);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, AppComponentDTO.class)));
    }


}
