package com.hengyunsoft.platform.mail.open;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.dto.open.RequestExamineDTO;
import com.hengyunsoft.platform.mail.entity.core.po.ExamineRule;
import com.hengyunsoft.platform.mail.repository.core.example.ExamineRuleExample;
import com.hengyunsoft.platform.mail.repository.core.service.ExamineRuleApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：邮件审核规则API
 * 修改人：wt
 * 修改时间：2018/8/27
 * 修改内容：
 */
@Api(value = "API - ExamineRuleApiImpl.java", description = "邮件审核规则API")
@RestController
@RequestMapping("dataapi/open/examine/")
@Slf4j
public class ExamineRuleApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ExamineRuleApiService examineRuleApiService;

    /**
     * 描述：查询列表
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiResponses({
    })
    public Result<PageInfo<RequestExamineDTO>> findExamine(@RequestBody OpenApiReq<String> openApiReq) {

        ExamineRuleExample example = new ExamineRuleExample();
        example.createCriteria().andCreateTimeIsNotNull();
        List<ExamineRule> list = examineRuleApiService.find(example);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, RequestExamineDTO.class)));
    }

    /**
     * 描述：根据ID查询
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询", notes = "根据ID查询")
    @ApiResponses({
    })
    public Result<RequestExamineDTO> getExamine(@RequestParam("id") Long id) {
        ExamineRuleExample example = new ExamineRuleExample();
        example.createCriteria().andIdEqualTo(id);
        ExamineRule examineRule = examineRuleApiService.getUnique(example);
        return Result.success(dozerUtils.map(examineRule,RequestExamineDTO.class));
    }

    /**
     * 描述：保存
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存", notes = "保存")
    @ApiResponses({
    })
    public Result<RequestExamineDTO> saveExamine(@RequestBody RequestExamineDTO dto) {
        ExamineRule examineRule = dozerUtils.map(dto,ExamineRule.class);
        examineRule.setCreateTime(Calendar.getInstance().getTime());
        examineRule.setCreateUser(dto.getUserName());
        ExamineRule result = examineRuleApiService.saveSelective(examineRule);
        return Result.success(dozerUtils.map(result,RequestExamineDTO.class));
    }

    /**
     * 描述：更新
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "更新")
    @ApiResponses({
    })
    public Result<Integer> updateExamine(@RequestBody RequestExamineDTO dto) {
        ExamineRule examineRule = dozerUtils.map(dto,ExamineRule.class);
        examineRule.setUpdateTime(Calendar.getInstance().getTime());
        examineRule.setUpdateUser(dto.getUserName());
        Integer result = examineRuleApiService.updateByIdSelective(examineRule);
        return Result.success(result);
    }

    /**
     * 描述：删除
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除", notes = "删除")
    @ApiResponses({
    })
    public Result<Integer> deleteExamine(@RequestParam("id") Long id) {
        Integer result = examineRuleApiService.deleteById(id);
        return Result.success(result);
    }


}
