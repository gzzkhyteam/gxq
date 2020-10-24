package com.hengyunsoft.platform.admin.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.dto.DictionaryOrgFindDTO;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDpmApi;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmDetailsDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmEditDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmEditRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmImportDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResPageDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmSaveDTO;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDepartmentExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptOrgExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDpmService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptEmpService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptOrgService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwDepartmentExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwDpmService;
import com.hengyunsoft.platform.admin.utils.DpmUtil;
import com.hengyunsoft.platform.admin.utils.ExcelUtil;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hengyunsoft.commons.exception.core.AuthorityExceptionCode.GXQPT_ORG_ID;

/**
 * 部门管理
 *
 * @author wangzhen
 * @createTime 2018-03-06
 */
@Api(value = "API - GxqptDpmApiImpl", description = "部门管理")
@RestController
@RequestMapping("/gxqpt/dpm")
@Slf4j
public class GxqptDpmApiImpl implements GxqptDpmApi {
    @Autowired
    private GxqptDpmService dpmService;
    @Autowired
    private GxqptOrgService orgService;
    @Autowired
    private SdzzwwDpmService sdzzwwDpmService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private GxqptEmpService empService;
    @Autowired
    private UserService userService;
    @Autowired
    private GxqptSystemService systemService;
    @Autowired
    private DozerUtils dozerUtils;

    /*删除标识*/
    private static final String DPM_ISDELETE = "1";
    /*未删除标识*/
    private static final String DPM_NODELETE = "0";
    /*启用标识*/
    private static final String DPM_ISENBLE = "1";
    /*未启用标识*/
    private static final String DPM_NOENBLE = "0";
    /*部门导入模板*/
    private static final String IMPORT_HEAD = "部门导入模板";
    /*部门导出名称*/
    private static final String EXPORT_HEAD = "部门导出名";
    /*默认父id*/
    private static final String DPM_DEFAULT_PARENT = "-1";

    /**
     * 新增部门
     *
     * @param dpmSave
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 56010, message = "部门为空"),
            @ApiResponse(code = 56012, message = "部门名称为空"),
            @ApiResponse(code = 56022, message = "节点不能为空")
    })
    @ApiOperation(value = "新增部门", notes = "根据实体信息新增部门信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwDepartment.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<GxqptDpmResDTO> save(@RequestBody GxqptDpmSaveDTO dpmSave) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_NULL, dpmSave);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_NAME, dpmSave.getName());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, dpmSave.getOrgId());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_PARENT, dpmSave.getParentId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_FORNODETYPE, dpmSave.getFornodetype());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_STATUS, dpmSave.getStatus());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ISENABLE, dpmSave.getIsenable());
        dpmSave.setParentId(dpmSave.getParentId() == null || "".equals(dpmSave.getParentId()) ? DPM_DEFAULT_PARENT : dpmSave.getParentId());

        //2.转换对象并新增条目
        GxqptDepartment dpm = dozerUtils.map(dpmSave, GxqptDepartment.class);
        String createUser = BaseContextHandler.getAdminId().toString();
        dpm.setIsdelete(DPM_NODELETE);
        dpm.setCreateUser(createUser);
        return Result.success(dozerUtils.map(dpmService.save(dpm), GxqptDpmResDTO.class));
    }

    /**
     * 编辑部门
     *
     * @param dpmEdit
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56011, message = "部门id为空"),
            @ApiResponse(code = 56010, message = "部门为空"),
            @ApiResponse(code = 56012, message = "部门名称为空"),
            @ApiResponse(code = 56022, message = "节点不能为空")
    })
    @ApiOperation(value = "编辑部门", notes = "根据实体信息修改部门信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwDepartment.class)
            }
    )
    public Result<GxqptDpmEditRetDTO> update(@RequestBody GxqptDpmEditDTO dpmEdit) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_NULL, dpmEdit);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, dpmEdit.getId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_NAME, dpmEdit.getName());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, dpmEdit.getOrgId());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_PARENT, dpmEdit.getParentId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_FORNODETYPE, dpmEdit.getFornodetype());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_STATUS, dpmEdit.getStatus());
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ISENABLE, dpmEdit.getIsenable());

        //2.修改实体并转换对象
        GxqptDepartment dpm = dozerUtils.map(dpmEdit, GxqptDepartment.class);
        if (dpmService.updateByIdSelective(dpm) > 0) {
            dpmService.updateByChileName(dpm);
            return Result.success(dozerUtils.map(dpm, GxqptDpmEditRetDTO.class));
        }
        return Result.fail("fail");
    }

    /**
     * 导入部门
     *
     * @param file
     * @param orgId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
    })
    @ApiOperation(value = "导入部门", notes = "根据Excel导入部门信息")
    @RequestMapping(value = "/saveDpms", method = RequestMethod.POST)
    public Result<List<GxqptDpmResDTO>> saveDpms(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "orgId") String orgId) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);

        //2.获取appid必要信息
        Long createUser = BaseContextHandler.getAdminId();

        //3.获取字典以及地区信息
        DictionaryExample dictionaryExample = new DictionaryExample();
        List dictionarys = dictionaryService.find(dictionaryExample);

        //4.获取需要导入单位下
        GxqptOrgExample example = new GxqptOrgExample();
        example.createCriteria().andIdEqualTo(orgId);
        GxqptOrg org = orgService.getUnique(example);

        //5.转换并执行导入操作
        if (org != null) {
            try {
                GxqptDpmImportDTO dpmImport = new GxqptDpmImportDTO();
                dpmImport.setOrgId(org.getId());
                dpmImport.setIsdelete(DPM_NODELETE);
                dpmImport.setForClass(org.getForClass());
                dpmImport.setForType(org.getForType());
                dpmImport.setForindustry(org.getForindustry());
                dpmImport.setParentId(DPM_DEFAULT_PARENT);
                dpmImport.setCreateUser(String.valueOf(createUser));
                List<GxqptDepartment> dpms = dozerUtils.mapList(DpmUtil.readExcelValue(file.getInputStream(), dpmImport), GxqptDepartment.class);
                DpmUtil.transDictionaryAndArea(dpms, dictionarys);
                return Result.success(dozerUtils.mapList(dpmService.save(dpms), GxqptDpmResDTO.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.fail("fail");
    }

    /**
     * 导出部门
     *
     * @param ids
     * @param response
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56011, message = "部门id为空")
    })
    @ApiOperation(value = "导出部门", notes = "根据实体进行导出")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportOrg(@RequestParam(value = "ids[]") String[] ids, HttpServletResponse response) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, ids);
        if (ids.length > 0) {

            //2.根据前端传来的id进行单位集合查询
            GxqptDepartmentExample dpmExample = new GxqptDepartmentExample();
            dpmExample.createCriteria().andIdIn(Arrays.asList(ids));

            GxqptDepartmentExample allDpmExample = new GxqptDepartmentExample();
            dpmExample.createCriteria().andIdIn(Arrays.asList(ids));

            List<GxqptDepartment> allDpmList = dpmService.find(allDpmExample);
            List<GxqptDepartment> dpmList = dpmService.find(dpmExample);

            for (GxqptDepartment dpmExpor : dpmList) {
                if (dpmExpor.getParentId() != null && !"".equals(dpmExpor) && dpmExpor.getParentId() != "-1" ) {
                    for (GxqptDepartment mExpor : allDpmList) {
                        if (mExpor.getId().equals(dpmExpor.getParentId())) {
                            dpmExpor.setParentName(mExpor.getName());
                        }
                    }
                }
            }

            //3.获取字典以及地区信息
            DictionaryExample dictionaryExample = new DictionaryExample();
            List dictionarys = dictionaryService.find(dictionaryExample);

            //4.获得Excel文档工具类的workbook
            DpmUtil.reTransDictionaryAndArea(dpmList, dictionarys);
            HSSFWorkbook workbook = DpmUtil.setCell(dpmList);

            //5.设置response的头
            String fileName = null;
            OutputStream out = null;
            try {
                response.setCharacterEncoding("UTF-8");
                fileName = EXPORT_HEAD + new SimpleDateFormat("yyyy-mm-dd").format(new Date()) + ".xls";
                response.setContentType("application/force-download");
                response.setHeader(
                        "Content-disposition",
                        "attachment; filename="
                                + URLEncoder.encode(fileName, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //6.向外部写出
            try {
                out = response.getOutputStream();
                workbook.write(out);
                out.flush();
                out.close();
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除部门
     *
     * @param ids
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56011, message = "部门id为空")
    })
    @ApiOperation(value = "删除部门", notes = "根据id进行逻辑删除")
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Result<Boolean> remove(@RequestParam(value = "ids[]") String[] ids) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, ids);
        if (ids.length == 0) {
            return Result.success(true);
        }

        //2.查询所有人员
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andIsdeleteEqualTo("0");
        List depId = empService.find(empExample).stream().map(GxqptEmp::getMaindeptid).collect(Collectors.toList());

        //3.执行删除
        List<GxqptDepartment> list = new ArrayList<>();
        for (String id : ids) {
            if (!depId.contains(id)) {
                GxqptDepartment dpm = new GxqptDepartment();
                dpm.setId(id);
                dpm.setIsdelete(DPM_ISDELETE);
                list.add(dpm);
            } else {
                return Result.fail("部门下仍存在人员,请先删除该人员");
            }
        }
        if (dpmService.updateByIdSelective(list) == ids.length) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 禁用部门
     *
     * @param ids
     * @param isenble
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56011, message = "部门id为空")
    })
    @ApiOperation(value = "禁用部门(1:启用---0:禁用)", notes = "根据id进行禁用")
    @RequestMapping(value = "/updateEnable", method = RequestMethod.POST)
    public Result<Boolean> updateEnable(@RequestParam(value = "ids[]") String[] ids, @RequestParam(value = "isenble") String isenble) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, ids);
        if (ids.length == 0) {
            return Result.success(true);
        }

        //2.执行禁用
        List<GxqptDepartment> list = new ArrayList<>();
        for (String id : ids) {
            GxqptDepartment dpm = new GxqptDepartment();
            dpm.setId(id);
            dpm.setIsenable(isenble);
            list.add(dpm);
        }
        if (dpmService.updateByIdSelective(list) == ids.length) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }
//    @Override
//    public Result<Boolean> removeDpm(String id) {
//        return null;
//    }

    /**
     * 查询部门列表
     *
     * @param orgId
     * @param systemCode
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "查询部门列表", notes = "根据单位id查询部门的列表")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Result<List<GxqptDpmResDTO>> find(@RequestParam(value = "orgId") String orgId, @RequestParam(value = "systemCode") String systemCode) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(GXQPT_ORG_ID, orgId);
        if (!systemService.isExistSystem(systemCode)){
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.按体系条件查询集合
        List<? extends SdzzwwDepartment> dpms = null;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptDepartmentExample dmpExample = new GxqptDepartmentExample();
            dmpExample.createCriteria().andIsdeleteEqualTo(DPM_NODELETE).andOrgIdEqualTo(orgId);
            dmpExample.setOrderByClause("sortvalue asc");
            dpms = dpmService.find(dmpExample);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwDepartmentExample dmpExample = new SdzzwwDepartmentExample();
            dmpExample.createCriteria().andIsdeleteEqualTo(DPM_NODELETE).andOrgIdEqualTo(orgId);
            dmpExample.setOrderByClause("sortvalue asc");
            dpms = sdzzwwDpmService.find(dmpExample);
        }

        //3.转换并返回体系Code
        List<GxqptDpmResDTO> list = dozerUtils.mapList(dpms, GxqptDpmResDTO.class);
        for (GxqptDpmResDTO dto : list) {
            dto.setSystemCode(systemCode);
        }
//        list = TreeUtil.buildByRecursive(list, CommonConstants.PARENT_ID_DEF);
        return Result.success(list);
    }

    /**
     * 模糊查询部门列表
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @ApiOperation(value = "模糊查询部门列表", notes = "模糊查询部门列表")
    @RequestMapping(value = "/pageLike", method = RequestMethod.POST)
    public Result<PageInfo<GxqptDpmResDTO>> pageLike(@RequestBody OpenApiReq<GxqptDpmResPageDTO> openApiReq) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, openApiReq.getData().getSystemCode());
        if (StringUtils.isEmpty(openApiReq.getData().getOrgId())) {
            return Result.success(new PageInfo<>());
        }
        if (!systemService.isExistSystem(openApiReq.getData().getSystemCode())){
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        GxqptDpmResPageDTO vo = ExcelUtil.method(openApiReq.getData());

        //2.设置信息
        GxqptDepartment dpm = new GxqptDepartment();
        openApiReq.getData().setParentId(openApiReq.getData().getParentId() == null || "".equals(openApiReq.getData().getParentId())
                ? DPM_DEFAULT_PARENT : openApiReq.getData().getParentId());
        dpm.setForClass(openApiReq.getData().getForClass());
        dpm.setForType(openApiReq.getData().getForType());
        dpm.setName(openApiReq.getData().getName());
        dpm.setOrgId(openApiReq.getData().getOrgId());
        dpm.setIsenable(openApiReq.getData().getIsenable());
        dpm.setIsdelete(DPM_NODELETE);

        //3.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //4.按体系条件查询集合

        List<? extends SdzzwwDepartment> list = null;
        list = dpmService.selectDpmJoinDictionary(openApiReq.getData().getSystemCode(), dpm);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, GxqptDpmResDTO.class)));
    }

    /**
     * 查询某个部门根据id
     *
     * @param systemCode
     * @param id
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56011, message = "部门id为空")
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "查询某个部门根据id", notes = "查询某个部门根据id")
    public Result<GxqptDpmResDTO> get(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, id);
        if (!systemService.isExistSystem(systemCode)){
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.按体系条件查询集合
        SdzzwwDepartment dpmTemp = findOrgAndNameById(systemCode, id);
        return Result.success(dozerUtils.map(dpmTemp, GxqptDpmResDTO.class));
    }

    /**
     * 查询某个部门根据id(详情)
     *
     * @param systemCode
     * @param id
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56011, message = "部门id为空")
    })
    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ApiOperation(value = "查询某个部门根据id(详情)", notes = "查询某个部门根据id(详情)")
    public Result<GxqptDpmDetailsDTO> getDetails(String systemCode, String id) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, id);
        if (!systemService.isExistSystem(systemCode)){
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.按体系条件查询集合
        SdzzwwDepartment dpmTemp = findOrgAndNameById(systemCode, id);
        return Result.success(dozerUtils.map(dpmTemp, GxqptDpmDetailsDTO.class));
    }

    /**
     * 部门Excel模板下载
     *
     * @param response
     */
    @Override
    @ApiOperation(value = "部门Excel模板下载", notes = "部门Excel模板下载")
    @IgnoreAppToken
    @RequestMapping(value = "/downloadTemplet", method = RequestMethod.GET)
    public void downloadTemplet(HttpServletResponse response) {
        //1.获取字典集合
        List<DictionaryOrgFindDTO> dictionarys = dozerUtils
                .mapList(dictionaryService.findOrgDictionary(), DictionaryOrgFindDTO.class);

        //2.规划单位的字典map
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionarys.forEach(dictionaryOrgFindDTO -> dictionaryMap
                .put(dictionaryOrgFindDTO.getDictionaryTypeCode(), dictionaryOrgFindDTO.getCode()));

        //3.获得Excel文档工具类的workbook
        HSSFWorkbook workbook = DpmUtil.templetExcel(null, dictionaryMap);

        //4.设置response的头
        String fileName = null;
        OutputStream out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            fileName = IMPORT_HEAD + new SimpleDateFormat("yyyy-mm-dd").format(new Date()) + ".xls";
            response.setContentType("application/force-download");
            response.setHeader(
                    "Content-disposition",
                    "attachment; filename="
                            + URLEncoder.encode(fileName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //5.向外部写出
        try {
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @ApiOperation(value = "根据user查询所有部门", notes = "根据user查询所有部门")
    @RequestMapping(value = "/findDpmByUser", method = RequestMethod.GET)
    public Result<List<GxqptDpmByUserDTO>> findDpmByUser() {
        //1.获取到登录用户信息
        Long userId = BaseContextHandler.getAdminId();
        //2.查出所有体系
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        User user = userService.getUnique(userExample);

        //3.查询
        List list = dpmService.findDpmByUser(user.getOwnSystem(), userId);
        return Result.success(dozerUtils.mapList(list, GxqptDpmByUserDTO.class));
    }

    /**
     * 根据user和单位查询所在部门
     *
     * @param orgId
     * @return
     */
    @Override
    @ApiOperation(value = "根据user和单位查询所在部门", notes = "根据user查询所根据user和单位查询所在部门")
    @RequestMapping(value = "/findDpmByUserAndOrg", method = RequestMethod.GET)
    public Result<List<GxqptDpmByUserDTO>> findDpmByUserAndOrg(@RequestParam(value = "orgId",required = false) String orgId) {
        //1.获取到登录用户信息
        Long userId = BaseContextHandler.getAdminId();

        //2.查出所有体系
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(userId);
        User user = userService.getUnique(userExample);

        //3.查询
        List<GxqptDpmByUserDTO> list = dozerUtils.mapList(dpmService.findDpmByUserAndOrg(user.getOwnSystem(), userId, orgId), GxqptDpmByUserDTO.class);
        list.forEach(obj ->obj.setSystemCode(user.getOwnSystem()));
        return Result.success(list);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "根据单位查询可用部门(GXQPT)", notes = "根据单位查询可用部门(GXQPT)")
    @RequestMapping(value = "/findDpmByOrgEnable", method = RequestMethod.GET)
    public Result<List<GxqptDpmByUserDTO>> findDpmByOrgEnable(@RequestParam(value = "orgId") String orgId) {
        //1.验证
        BizAssert.assertNotEmpty(GXQPT_ORG_ID, orgId);

        //2.按体系条件查询集合
        GxqptDepartmentExample dmpExample = new GxqptDepartmentExample();
        dmpExample.createCriteria()
                .andOrgIdEqualTo(orgId)
                .andIsdeleteEqualTo(DPM_NODELETE)
                .andIsenableEqualTo(DPM_ISENBLE);
        dmpExample.setOrderByClause("sortvalue asc");
        List dpms = dpmService.find(dmpExample);

        //3.转换并返回体系Code
        List<GxqptDpmByUserDTO> list = dozerUtils.mapList(dpms, GxqptDpmByUserDTO.class);
        return Result.success(list);
    }
//    @Override
//    @ApiResponses({
//            @ApiResponse(code = 56014, message = "体系结构代码为空")
//    })
//    @RequestMapping(value = "/queryIds", method = RequestMethod.GET)
//    @ApiOperation(value = "根据Id[]查询部门列表", notes = "根据Id[]查询部门列表")
//    public Result<PageInfo<GxqptDpmResDTO>> findByIds(@RequestParam(value = "ids[]") String[] ids, @RequestParam(value = "systemCode") String systemCode, OpenApiReq openApiReq) {
//        //验证
//        if (ids == null || ids.length == 0) {
//            return Result.success(new PageInfo<>());
//        }
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
//
//        //2.设置分页器
//        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//
//        //3.按体系条件查询集合
//        List<? extends SdzzwwDepartment> list = null;
//        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
//            GxqptDepartmentExample example = new GxqptDepartmentExample();
//            example.createCriteria().andIdIn(Arrays.asList(ids)).andIsdeleteEqualTo(DPM_NODELETE);
//            example.setOrderByClause("sortvalue asc");
//            list = dpmService.find(example);
//        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
//            SdzzwwDepartmentExample example = new SdzzwwDepartmentExample();
//            example.createCriteria().andIdIn(Arrays.asList(ids)).andIsdeleteEqualTo(DPM_NODELETE);
//            example.setOrderByClause("sortvalue asc");
//            list = sdzzwwDpmService.find(example);
//        }
//        PageInfo p = new PageInfo<>(list);
//        p.setList(dozerUtils.mapList(list, GxqptDpmResDTO.class));
//        return Result.success(p);
//    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "根据单位和体系查询可用部门", notes = "根据单位和体系查询可用部门")
    @RequestMapping(value = "/findDpmByOrg", method = RequestMethod.GET)
    public Result<List<GxqptDpmByUserDTO>> findDpmByOrg(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "orgId") String orgId) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(GXQPT_ORG_ID, orgId);
        if (!systemService.isExistSystem(systemCode)){
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        List<GxqptDpmByUserDTO> dpms = null;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptDepartmentExample example = new GxqptDepartmentExample();
            example.createCriteria().andOrgIdEqualTo(orgId).andIsdeleteEqualTo(DPM_NODELETE)
                    .andIsenableEqualTo(DPM_ISENBLE);
            dpms = dozerUtils.mapList(dpmService.find(example),GxqptDpmByUserDTO.class);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwDepartmentExample example = new SdzzwwDepartmentExample();
            example.createCriteria().andOrgIdEqualTo(orgId).andIsdeleteEqualTo(DPM_NODELETE)
                    .andIsenableEqualTo(DPM_ISENBLE);
            dpms = dozerUtils.mapList(sdzzwwDpmService.find(example),GxqptDpmByUserDTO.class);
        }
        dpms.forEach(obj -> {obj.setSystemCode(systemCode);});
        return Result.success(dpms);
    }
    /**
     * 根据部门ids查询部门名称id信息
     * @param ids
     * @return
     */
    @Override
    @ApiOperation(value = "根据部门ids查询部门名称id信息", notes = "根据部门ids查询部门名称id信息")
    @RequestMapping(value = "/findDpmNameByIds", method = RequestMethod.GET)
    public Result<List<GxqptDpmResDTO>> findDpmNameByIds(@RequestParam(value = "ids") List ids) {
        //获取全体系
        List<String> systemCodes = getSystemCode();
        if (systemCodes.size() == 0 || ids.size() == 0) {
            return Result.success(new ArrayList<>());
        }
        List<GxqptDpmResDTO> list = dozerUtils
                .mapList(dpmService.findDpmNameByIds(ids, systemCodes), GxqptDpmResDTO.class);

        return Result.success(list);
    }
    private SdzzwwDepartment findOrgAndNameById(String systemCode, String id) {
        SdzzwwDepartment dpm = null;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptDepartmentExample example = new GxqptDepartmentExample();
            example.createCriteria().andIdEqualTo(id).andIsdeleteEqualTo(DPM_NODELETE);
            dpm = dpmService.getUnique(example);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwDepartmentExample example = new SdzzwwDepartmentExample();
            example.createCriteria().andIdEqualTo(id).andIsdeleteEqualTo(DPM_NODELETE);
            dpm = sdzzwwDpmService.getUnique(example);
        }
        return dpm;
    }

    /**
     * 获得体系编码list
     * @return
     */
    private List<String> getSystemCode(){
        //设置查询条件
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = systemService.find(systemExample);
        //过滤空处理
        List systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());

        return systemCodes;
    }
}
