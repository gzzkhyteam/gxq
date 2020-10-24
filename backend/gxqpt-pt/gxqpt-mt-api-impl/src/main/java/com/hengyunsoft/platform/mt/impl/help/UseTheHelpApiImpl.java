package com.hengyunsoft.platform.mt.impl.help;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.groups.Default;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.help.dto.UseTheHelpDTO;
import com.hengyunsoft.platform.mt.api.help.dto.UseTheHelpPageReqDTO;
import com.hengyunsoft.platform.mt.api.help.dto.UseTheHelpSaveDTO;
import com.hengyunsoft.platform.mt.api.help.dto.UseTheHelpUpdateDTO;
import com.hengyunsoft.platform.mt.entity.help.po.UseTheHelp;
import com.hengyunsoft.platform.mt.repository.help.service.UseTheHelpService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：使用帮助文档管理
 * author：tianai
 * @createTime：2018/5/29
 */
@RestController
@Slf4j
@RequestMapping("/help")
@Api(value = "使用帮助文档管理", description = "使用帮助文档管理")
public class UseTheHelpApiImpl /*implements UseTheHelpApi*/{

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private UseTheHelpService  useTheHelpService;



    
    @ApiOperation(value = "查询使用帮助文档分页信息", notes = "查询使用帮助文档分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<UseTheHelpDTO>> getPage(@RequestBody OpenApiReq<UseTheHelpPageReqDTO> openApiReq) {
        Date start = null;
        Date end = null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = openApiReq.getData().getStartTime();
        String endTime = openApiReq.getData().getEndTime();
        String title = openApiReq.getData().getTitle();
        Long modularId= openApiReq.getData().getModularId();

        ParsePosition pos = new ParsePosition(0);
        ParsePosition poss = new ParsePosition(0);
        if (startTime != null && startTime != "") {
            start = formatter.parse(startTime, pos);
        }
        if (endTime != null && endTime != "") {
            end = formatter.parse(endTime, poss);
        }
        Map map = new HashMap<>();
        map.put("title", title);
        map.put("startTime", start);
        map.put("endTime", end);
        map.put("modularId", modularId);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(useTheHelpService.getPageList(map), UseTheHelpDTO.class)));
    }

    
    @ApiOperation(value = "保存使用帮助文档信息", notes = "保存使用帮助文档信息")
    @ApiResponses({
            @ApiResponse(code = 91000, message = "标题不允许为空"),
            @ApiResponse(code = 91001, message = "内容不允许为空")
    })
    @ValidatorStandard(
            {
                    @Constraint(value = UseTheHelp.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<UseTheHelpSaveDTO> save(@RequestBody UseTheHelpSaveDTO saveDTO) {

        //1.校验
        BizAssert.assertNotNull(MtExceptionCode.HELP_TITLE_NULL, saveDTO.getTitle());
        BizAssert.assertNotNull(MtExceptionCode.HELP_CONTENT_NULL, saveDTO.getContent());
        Long userId = BaseContextHandler.getAdminId();
        //转换
        UseTheHelp  useTheHelp=dozerUtils.map(saveDTO,UseTheHelp.class);

        useTheHelp.setStatus(1);
        //useTheHelp.setCommonlyMark(1);
        useTheHelp.setCreateUser(userId);
        useTheHelp.setUpdateUser(userId);
        //保存
        useTheHelpService.saveSelective(useTheHelp);
        return Result.success(dozerUtils.map(useTheHelp, UseTheHelpSaveDTO.class));
    }

    
    @ApiOperation(value = "修改使用帮助文档信息", notes = "修改使用帮助文档信息")
    @ApiResponses({
            @ApiResponse(code = 91000, message = "标题不允许为空"),
            @ApiResponse(code = 91001, message = "内容不允许为空")
    })
    @ValidatorStandard(
            {
                    @Constraint(value = UseTheHelp.class)
            }
    )
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<UseTheHelpUpdateDTO> update(@RequestBody UseTheHelpUpdateDTO updateDTO) {
        //1.校验
        BizAssert.assertNotNull(MtExceptionCode.HELP_TITLE_NULL, updateDTO.getTitle());
        BizAssert.assertNotNull(MtExceptionCode.HELP_CONTENT_NULL, updateDTO.getContent());
        Long userId = BaseContextHandler.getAdminId();
        //转换
        UseTheHelp  useTheHelp=dozerUtils.map(updateDTO,UseTheHelp.class);

        useTheHelp.setStatus(1);
        useTheHelp.setUpdateUser(userId);
        //保存
        useTheHelpService.updateByIdSelective(useTheHelp);
        return Result.success(dozerUtils.map(useTheHelp, UseTheHelpUpdateDTO.class));
    }

    
    @ApiOperation(value = "审核使用帮助文档信息", notes = "审核使用帮助文档信息")
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public Result<UseTheHelpUpdateDTO> saveAudit(@RequestBody UseTheHelpUpdateDTO updateDTO) {

        Long userId = BaseContextHandler.getAdminId();
        //转换
        UseTheHelp  useTheHelp=useTheHelpService.getById(updateDTO.getId());
        useTheHelp.setStatus(2);
        useTheHelp.setAuditor(userId);
        useTheHelp.setAuditorTime(new Date());
        useTheHelp.setUpdateUser(userId);
        //保存
        useTheHelpService.updateByIdSelective(useTheHelp);
        return Result.success(dozerUtils.map(useTheHelp, UseTheHelpUpdateDTO.class));
    }

    
    @ApiOperation(value = "弃审核使用帮助文档信息", notes = "弃审核使用帮助文档信息")
    @RequestMapping(value = "/discardAudit", method = RequestMethod.POST)
    public Result<UseTheHelpUpdateDTO> saveDiscardAudit(@RequestBody UseTheHelpUpdateDTO updateDTO) {
        Long userId = BaseContextHandler.getAdminId();
        //转换
        UseTheHelp  useTheHelp=useTheHelpService.getById(updateDTO.getId());
        useTheHelp.setStatus(1);
        useTheHelp.setAuditor(userId);
        useTheHelp.setAuditorTime(new Date());
        useTheHelp.setUpdateUser(userId);
        //保存
        useTheHelpService.updateByIdSelective(useTheHelp);
        return Result.success(dozerUtils.map(useTheHelp, UseTheHelpUpdateDTO.class));
    }

    
    @ApiOperation(value = "根据id查询使用帮助文档信息",notes="根据id查询使用帮助文档信息")
    @RequestMapping(value = "/get" ,method =RequestMethod.GET)
    public Result<UseTheHelpDTO> get(@RequestParam (value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        UseTheHelp help=useTheHelpService.getById(id);
        UseTheHelpDTO dto = dozerUtils.map(help, UseTheHelpDTO.class);
        return Result.success(dto);
    }

    
    @ApiOperation(value = "根据id删除使用帮助文档信息",notes="根据id删除使用帮助文档信息")
    @RequestMapping(value = "/delete" ,method =RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam (value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        useTheHelpService.deleteById(id);
        return Result.success(true);
    }
}
