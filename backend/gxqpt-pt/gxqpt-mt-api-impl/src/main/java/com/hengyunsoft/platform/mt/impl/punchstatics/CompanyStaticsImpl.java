package com.hengyunsoft.platform.mt.impl.punchstatics;

import com.google.common.collect.Lists;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.CompanyStaticsDTO;
import com.hengyunsoft.platform.mt.api.punchstatics.dto.StaticsKVDTO;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.CompanyStatics;
import com.hengyunsoft.platform.mt.entity.punchstatics.po.TypeAndNum;
import com.hengyunsoft.platform.mt.repository.punchstatics.service.PunchAttendanceStaticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.impl.punchstatics
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：app端企业分析
 * 修改人：gbl
 * 修改时间：2018/7/24
 */
@Api(value = "API - AppPuchAnalyzeApiImpl.java", description = "app端企业分析")
@RestController
@RequestMapping("CompanyStaticsImpl")
@Slf4j
public class CompanyStaticsImpl {
    @Autowired
    private PunchAttendanceStaticsService punchAttendanceStaticsService;
    @Autowired
    private DozerUtils dozerUtils;


    @RequestMapping(value = "companyStatics", method = RequestMethod.GET)
    @ApiOperation(value = "企业申报分析", notes = "企业申报分析")
    @ApiResponses({

    })
    public Result<CompanyStaticsDTO> companyStatics() {
        CompanyStatics company = punchAttendanceStaticsService.company();
        CompanyStaticsDTO res = dozerUtils.map(company, CompanyStaticsDTO.class);
        //历年项目申报数量统计  k:年份   v1:值public String declareNum()
        List<StaticsKVDTO> yearDeclare = Lists.newArrayList();
        List<TypeAndNum> declareNum = punchAttendanceStaticsService.declareNum();
        declareNum.forEach(dn -> {
            StaticsKVDTO kv = new StaticsKVDTO(dn.getK(), dn.getV1().intValue());
            yearDeclare.add(kv);
        });
        res.setYearDeclare(yearDeclare);
        //    @ApiModelProperty(value = "项目申报类别统计 k:类别 v1:数据")
        List<StaticsKVDTO> pDeclares = Lists.newArrayList();
        List<TypeAndNum> declareTypeNum = punchAttendanceStaticsService.getDeclareTypeNum();
        declareTypeNum.forEach(dt -> {
            StaticsKVDTO kv = new StaticsKVDTO(dt.getK(), dt.getV1().intValue());
            pDeclares.add(kv);
        });
        res.setPDeclares(pDeclares);
        //项目补助资金情况统计  k:年份 v1: 贷款贴息  v2:财政拨款
        List<StaticsKVDTO> projectSubsidy = Lists.newArrayList();
        List<TypeAndNum> projectMoneys = punchAttendanceStaticsService.projectMoney();
        projectMoneys.forEach(tn -> {
            StaticsKVDTO kv = new StaticsKVDTO(tn.getK(), tn.getV1().intValue(), tn.getV2().intValue());
            projectSubsidy.add(kv);
        });
        res.setProjectSubsidy(projectSubsidy);
        // @ApiModelProperty(value = "本年度企业项目申报排名  k:企业名称 v1:数量")
        List<StaticsKVDTO> companyDeclare = Lists.newArrayList();
        List<TypeAndNum> projectDecSort = punchAttendanceStaticsService.projectDecSort();
        projectDecSort.forEach(pd -> {
            StaticsKVDTO kv = new StaticsKVDTO(pd.getK(), pd.getV1().intValue());
            companyDeclare.add(kv);
        });
        res.setCompanyDeclare(companyDeclare);
        return Result.success(res);
    }
    @RequestMapping(value = "coyYersProject", method = RequestMethod.GET)
    @ApiOperation(value = "查询企业本年的项目", notes = "查询企业本年的项目")
    @ApiResponses({

    })
    public Result<List<StaticsKVDTO>> coyYersProject(@RequestParam("name") String name) {
        List<StaticsKVDTO> res = Lists.newArrayList();
        List<TypeAndNum> coyYersProject = punchAttendanceStaticsService.coyYersProject(name);
        coyYersProject.forEach(cyo -> {
            StaticsKVDTO kv = new StaticsKVDTO(cyo.getK(), cyo.getV1().intValue());
            res.add(kv);
        });
        return Result.success(res);
    }
}
