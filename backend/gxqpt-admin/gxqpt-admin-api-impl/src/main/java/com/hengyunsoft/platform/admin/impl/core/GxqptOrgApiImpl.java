package com.hengyunsoft.platform.admin.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.commons.constant.RoleCode;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.base.dto.DictionaryOrgFindDTO;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptDpmTreeBySystemDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptEmpTreeBySystemDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByExchangeReqDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgDetailsDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgDpmIdentiDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgEditDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgEditRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgExportDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgImportDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResPageDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgSaveAndShareDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgStatisticsNumDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgTreeBySystemDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemTreeDTO;
import com.hengyunsoft.platform.admin.entity.core.domain.AssignRoleManagerDO;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.DataShareToApp;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpTreeBySystemDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptOrgByExchangeReqDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptShareAndAppInServiceDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwOrg;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import com.hengyunsoft.platform.admin.repository.base.service.AreaService;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.core.example.RoleExample;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.DataShareToAppService;
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
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwOrgExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwDpmService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwOrgService;
import com.hengyunsoft.platform.admin.utils.OrgUtil;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
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
import org.apache.commons.beanutils.ConvertUtils;
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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 单位管理
 *
 * @author wangzhen
 * @createTime 2018-03-06
 */
@Api(value = "API - GxqptOrgApiImpl", description = "单位管理")
@RestController
@RequestMapping("/gxqpt/org")
@Slf4j
public class GxqptOrgApiImpl implements GxqptOrgApi {
    @Autowired
    private GxqptOrgService orgService;
    @Autowired
    private GxqptDpmService dpmService;
    @Autowired
    private DataShareToAppService toAppService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AssignRoleService assignRoleService;
    @Autowired
    private SdzzwwOrgService sdzzwwOrgService;
    @Autowired
    private SdzzwwDpmService sdzzwwDpmService;
    @Autowired
    private GxqptEmpService gxqptEmpService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private UserService userService;
    @Autowired
    private GxqptSystemService systemService;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private DozerUtils dozerUtils;

    /*未删除标识*/
    private static final String NOT_DELETE = "0";
    /*删除标识*/
    private static final String IS_DELETE = "1";
    /*导出名*/
    private static final String EXPORT_HEAD = "单位导出";
    /*单位导入模板名*/
    private static final String IMPORT_HEAD = "单位导入模板";
    /*角色名*/
    private static final String ROLE_NAME = "数据维护管理员";
    /*角色诠释*/
    private static final String ROLE_DESC = "管理员";
    /*单位管理角色Code后缀*/
    public static final String ROLE_CODE_SUFFIX = "data_org";
    /*单位启用标识*/
    private static final String ORG_ISENBLE = "1";
    /*单位未启用标识*/
    private static final String ORG_NOENBLE = "0";
    /*单位表标识*/
    private static final String ORG_TABLE_TAG = "ORG";
    /*父根节点*/
    private static final Long PARENT_ID = -1l;
    /*运维单位类型编码*/
    private static final String OPT_TYPE_CODE = "ot_ywdw";
    /*运维平台appId*/
    private static final String OPT_APPID = "45aj6317";
    /*应用管理员code*/
    private static final String APP_ADMIN_CODE = "app_admin";

    /**
     * 新增单位
     *
     * @param gxqptOrgSaveAndShare
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位为空"),
            @ApiResponse(code = 56009, message = "单位名称为空"),
            @ApiResponse(code = 56018, message = "所属级别不能为空"),
            @ApiResponse(code = 56017, message = "所属类型不能为空"),
            @ApiResponse(code = 56019, message = "所属系统不能为空"),
            @ApiResponse(code = 56020, message = "单位归口不能为空"),
            @ApiResponse(code = 56022, message = "节点不能为空"),
    })
    @ApiOperation(value = "新增单位", notes = "根据实体信息新增单位信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwOrg.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<GxqptOrgResDTO> save(@RequestBody GxqptOrgSaveAndShareDTO gxqptOrgSaveAndShare) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, gxqptOrgSaveAndShare);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_NAME, gxqptOrgSaveAndShare.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORCLASS, gxqptOrgSaveAndShare.getClass());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORTYPE, gxqptOrgSaveAndShare.getForType());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORINDUSTRY, gxqptOrgSaveAndShare.getForindustry());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORGK, gxqptOrgSaveAndShare.getForgk());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORNODETYPE, gxqptOrgSaveAndShare.getFornodetype());
//        User user = userService.findUserByEmp(gxqptOrgSaveAndShare.getOrgadmin());
//        if (user == null) {
//            return Result.fail("当前人员未绑定账户,请先执行绑定操作!");
//        }

        //2.获取一些必要信息
        Long adminId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        String createName = BaseContextHandler.getAdminId().toString();
        Date date = new Date();

        //3.转换并添加条目
        String[] appIds = gxqptOrgSaveAndShare.getShareIds();
        GxqptOrg org = dozerUtils.map(gxqptOrgSaveAndShare, GxqptOrg.class);
        org.setIsdelete(NOT_DELETE);
        org.setCreateUser(createName);
        org = orgService.saveAndShare(org);

        //4.添加角色
        saveRole(org, appId, adminId, date);
        joinOrgAminRole(org);
//        //5.添加应用分享权限
//        if (appIds != null && appIds.length > 0) {
//            List<DataShareToApp> list = new ArrayList<>();
//            for (String id : appIds) {
//                DataShareToApp toApp = new DataShareToApp();
//                toApp.setBizId(org.getId());
//                toApp.setBizType(ORG_TABLE_TAG);
//                toApp.setAppId(id);
//                toApp.setCreateTime(date);
//                toApp.setCreateUser(Long.valueOf(createName));
//                list.add(toApp);
//            }
//            toAppService.save(list);
//        }
        return Result.success(dozerUtils.map(org, GxqptOrgResDTO.class));
    }

    /**
     * 编辑单位
     *
     * @param gxqptOrgEdit
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位为空"),
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 56018, message = "所属级别不能为空"),
            @ApiResponse(code = 56017, message = "所属类型不能为空"),
            @ApiResponse(code = 56019, message = "所属系统不能为空"),
            @ApiResponse(code = 56020, message = "单位归口不能为空"),
            @ApiResponse(code = 56022, message = "节点不能为空"),
    })
    @ApiOperation(value = "编辑单位", notes = "根据实体信息修改单位信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwOrg.class)
            }
    )
    public Result<GxqptOrgEditRetDTO> update(@RequestBody GxqptOrgEditDTO gxqptOrgEdit) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, gxqptOrgEdit);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, gxqptOrgEdit.getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORCLASS, gxqptOrgEdit.getClass());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORTYPE, gxqptOrgEdit.getForType());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORINDUSTRY, gxqptOrgEdit.getForindustry());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORGK, gxqptOrgEdit.getForgk());
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_FORNODETYPE, gxqptOrgEdit.getFornodetype());

        //2.修改实体并转换对象
        GxqptOrg org = dozerUtils.map(gxqptOrgEdit, GxqptOrg.class);
        org.setUpdateTime(new Date());
        org.setUpdateUser(String.valueOf(BaseContextHandler.getAdminId()));
        GxqptOrg oldOrg = orgService.getById(org.getId());
        if (orgService.updateByIdSelective(org) > 0) {
            if (org.getOrgadmin() != null) {
                if (!org.getOrgadmin().equals(oldOrg.getOrgadmin())) {
                    joinOrgAminRole(org);
                    if (oldOrg.getOrgadmin() != null) {
                        removeOrgAminRoleIfNeed(oldOrg.getOrgadmin());
                    }
                }
            }
            return Result.success(dozerUtils.map(org, GxqptOrgEditRetDTO.class));
        }
        return Result.fail("fail");
    }

    private void removeOrgAminRoleIfNeed(String orgAdmin) {

        GxqptOrgExample example = new GxqptOrgExample();
        example.createCriteria().andOrgadminEqualTo(orgAdmin);
        int adminOrgCount = orgService.count(example);
        if (adminOrgCount > 0) {
            //任然是其他单位的管理员  禁止移除
            return;
        }
        GxqptEmpExample empEx = new GxqptEmpExample();
        empEx.createCriteria().andNicknameEqualTo(orgAdmin);
        GxqptEmp emp = gxqptEmpService.getUnique(empEx);
        if (emp == null) {
            return;
        }
        roleService.removeUserFormRole(emp.getGxqptEmpId(), RoleCode.ORG_ADMIN_CODE);
    }

    /**
     * 删除单位
     *
     * @param ids
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位为空"),
    })
    @ApiOperation(value = "删除单位", notes = "根据id进行逻辑删除")
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Result<Boolean> remove(@RequestParam(value = "ids[]") String[] ids) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, ids);
        if (ids.length == 0) {
            return Result.success(true);
        }

        //2.查找所有部门
        GxqptDepartmentExample departmentExample = new GxqptDepartmentExample();
        departmentExample.createCriteria().andIsdeleteEqualTo(NOT_DELETE);
        List<GxqptDepartment> dpms = dpmService.find(departmentExample);

        //3.查询单位树
        GxqptOrgExample orgExample = new GxqptOrgExample();
        orgExample.createCriteria().andIsdeleteEqualTo(NOT_DELETE);
        List<GxqptOrgResDTO> orgs = dozerUtils.mapList(orgService.find(orgExample), GxqptOrgResDTO.class);

        //3.执行禁用
        List<GxqptOrg> list = new ArrayList<>();
        for (String id : ids) {
            if (TreeUtil.findChildren(id, orgs).getChildren().size() != 0) {
                return Result.fail("当前单位下存在你不可见的子单位，请先联系管理者删除其子单位！");
            } else if (dpms.stream().map(GxqptDepartment::getOrgId).collect(Collectors.toList()).contains(id)) {
                return Result.fail("当前单位下存在子部门，请先删除其子部门！");
            } else {
                GxqptOrg org = new GxqptOrg();
                org.setId(id);
                org.setIsdelete(IS_DELETE);
                list.add(org);
            }
        }
        if (orgService.updateByIdSelective(list) == ids.length) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位为空")
    })
    @ApiOperation(value = "禁用单位(1:启用---0:禁用)", notes = "根据id进行禁用")
    @RequestMapping(value = "/updateEnable", method = RequestMethod.POST)
    public Result<Boolean> updateEnable(@RequestParam(value = "ids[]") String[] ids, @RequestParam(value = "isenble") String isenble) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, ids);
        if (ids.length == 0) {
            return Result.success(true);
        }

        //2.执行禁用
        List<GxqptOrg> list = new ArrayList<>();
        for (String id : ids) {
            GxqptOrg org = new GxqptOrg();
            org.setId(id);
            org.setIsenable(isenble);
            list.add(org);
        }
        if (orgService.updateByIdSelective(list) == ids.length) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 编辑单位分析应用
     *
     * @param gxqptOrgEdit
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位为空"),
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "编辑分享", notes = "根据实体信息修改单位信息")
    @RequestMapping(value = "/updateShare", method = RequestMethod.POST)
    public Result<Boolean> updateShare(@RequestBody GxqptOrgEditDTO gxqptOrgEdit) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, gxqptOrgEdit);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, gxqptOrgEdit.getId());

        boolean shareTag = shareManager(gxqptOrgEdit);
        if (shareTag) {
            return Result.success(true);
        }
        return Result.fail("false");
    }

    /**
     * 导出单位
     *
     * @param ids
     * @param response
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "导出单位", notes = "根据实体进行导出")
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportOrg(@RequestParam(value = "ids[]") String[] ids, HttpServletResponse response) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, ids);
        if (ids.length > 0) {

            //2.根据前端传来的id进行单位集合查询
            GxqptOrgExample orgExample = new GxqptOrgExample();
            orgExample.createCriteria().andIdIn(Arrays.asList(ids));

            GxqptOrgExample allOrgExample = new GxqptOrgExample();
            orgExample.createCriteria().andIdIn(Arrays.asList(ids));

            List<GxqptOrg> allOrgList = orgService.find(allOrgExample);
            List<GxqptOrg> orgList = orgService.find(orgExample);
            List<GxqptOrgExportDTO> orgRets = dozerUtils.mapList(orgList, GxqptOrgExportDTO.class);
            List<GxqptOrgExportDTO> allOrgRets = dozerUtils.mapList(allOrgList, GxqptOrgExportDTO.class);

            for (GxqptOrgExportDTO orgExpor : orgRets) {
                if (orgExpor.getParentId() != null && !"".equals(orgExpor) && orgExpor.getParentId() != "-1") {
                    for (GxqptOrgExportDTO mExpor : allOrgRets) {
                        if (mExpor.getId().equals(orgExpor.getParentId())) {
                            orgExpor.setParentName(mExpor.getName());
                        }
                    }
                }
            }

            //3.获取字典以及地区信息
            DictionaryExample dictionaryExample = new DictionaryExample();
            List dictionarys = dictionaryService.find(dictionaryExample);
            List<AreaTreeDTO> treeList = TreeUtil.queryTree(dozerUtils.mapList(areaService.findAreaForExcel(), AreaTreeDTO.class), PARENT_ID);

            //4.获得Excel文档工具类的workbook
            OrgUtil.reTransDictionaryAndArea(orgRets, dictionarys, treeList);
            HSSFWorkbook workbook = OrgUtil.setCell(orgRets);

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
                //e.printStackTrace();
                log.error("Exception", e);
            }

            //6.向外部写出
            try {
                out = response.getOutputStream();
                workbook.write(out);
                out.flush();
                out.close();
                workbook.close();
            } catch (IOException e) {
                //e.printStackTrace();
                log.error("Exception", e);
            }
        }
    }

    /**
     * 查询单位列表
     *
     * @param systemCode
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @ApiOperation(value = "查询单位列表", notes = "查询单位的列表")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> find(@RequestParam(value = "systemCode") String systemCode,
                                             @RequestParam(value = "type", required = false) Long type) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        if (!systemService.isExistSystem(systemCode)) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }
        type = type == null ? 0 : type;

        //获取应用基本信息
        Long adminId = BaseContextHandler.getAdminId();

        List<? extends SdzzwwOrg> orgs = null;
        List<GxqptOrgResDTO> list = null;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            //按条件查询单位集合(高新区平台)
//            orgs = orgService.selectOrgWithShare(adminId, appId);
            //获取指定人可以管理的机构列表
            //type==1:部门界面;type==2:人员界面
            orgs = orgService.selectOrgWithManager(adminId);
            if (orgs.isEmpty()) {
                return Result.success(new ArrayList<>());
            }
            list = dozerUtils.mapList(orgs, GxqptOrgResDTO.class);
            List<String> orgIds = list.stream().map(GxqptOrgResDTO::getId).collect(Collectors.toList());

            //查出对应单位下的部门
            GxqptDepartmentExample dmpExample = new GxqptDepartmentExample();
            if (type == 2) {
                dmpExample.createCriteria()
                        .andOrgIdIn(orgIds)
                        .andIsdeleteEqualTo(NOT_DELETE)
                        .andIsenableEqualTo(ORG_ISENBLE);
            } else {
                dmpExample.createCriteria()
                        .andOrgIdIn(orgIds)
                        .andIsdeleteEqualTo(NOT_DELETE);
            }
            dmpExample.setOrderByClause("sortvalue asc");
            List<GxqptDepartment> dpms = dpmService.find(dmpExample);
            List<GxqptDpmResDTO> dpmList = dozerUtils.mapList(dpms, GxqptDpmResDTO.class);
            List<GxqptDpmResDTO> mlist;
            for (GxqptOrgResDTO org : list) {
                mlist = dpmList.stream().filter(dpm -> org.getId().equals(dpm.getOrgId())).collect(Collectors.toList());
//                mlist = TreeUtil.buildByRecursive(mlist, CommonConstants.PARENT_ID_DEF);
                org.setDpms(mlist);
            }
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            //查询单位集合(省电子政务网)
            SdzzwwOrgExample example = new SdzzwwOrgExample();
            example.createCriteria().andIsdeleteEqualTo(NOT_DELETE);
            example.setOrderByClause("sortvalue asc");
            orgs = sdzzwwOrgService.find(example);
            //查出对应单位下的部门
            SdzzwwDepartmentExample sdzzwwDepartmentExample = new SdzzwwDepartmentExample();
            sdzzwwDepartmentExample.createCriteria().andIsdeleteEqualTo(NOT_DELETE);
            sdzzwwDepartmentExample.setOrderByClause("sortvalue asc");
            List<SdzzwwDepartment> dpms = sdzzwwDpmService.find(sdzzwwDepartmentExample);
            List<GxqptDpmResDTO> dpmList = dozerUtils.mapList(dpms, GxqptDpmResDTO.class);
            list = dozerUtils.mapList(orgs, GxqptOrgResDTO.class);
            List mlist;
            for (GxqptOrgResDTO org : list) {
                mlist = dpmList.stream().filter(dpm -> org.getId().equals(dpm.getOrgId())).collect(Collectors.toList());
//                mlist = TreeUtil.buildByRecursive(mlist, CommonConstants.PARENT_ID_DEF);
                org.setDpms(mlist);
            }

        } else {
            return Result.success(new ArrayList<>());
        }

        //如果在部门界面和人员界面下,需要剔除禁用单位
        list = TreeUtil.buildByRecursives(list);
        list = (type == 1 || type == 2) ? removeEnableByOrg(list) : list;
        return Result.success(list);
    }

    public List<GxqptOrgResDTO> removeEnableByOrg(List<GxqptOrgResDTO> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getIsenable() != null && list.get(i).getIsenable().equals(ORG_ISENBLE)) {
                list.get(i).setChildren(removeEnableByOrg(list.get(i).getChildren()));
            } else {
                list.remove(list.get(i));
            }
        }
        return list;
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id查询单位", notes = "根据Id查询单位")
    public Result<GxqptOrgResDTO> getById(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        if (!systemService.isExistSystem(systemCode)) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //查询部门
        SdzzwwOrg org = findOrgAndNameById(systemCode, id);
        return Result.success(dozerUtils.map(org, GxqptOrgResDTO.class));
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @RequestMapping(value = "/pageByIds", method = RequestMethod.POST)
    @ApiOperation(value = "根据Id[]查询单位列表", notes = "根据Id[]查询单位列表")
    public Result<PageInfo<GxqptOrgResDTO>> pageByIds(@RequestBody OpenApiReq<GxqptOrgResPageDTO> openApiReq) {
        //验证
        if (openApiReq.getData().getIds() == null || openApiReq.getData().getIds().length == 0) {
            return Result.success(new PageInfo<>());
        }
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, openApiReq.getData().getSystemCode());
        if (!systemService.isExistSystem(openApiReq.getData().getSystemCode())) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }
        //设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //查询部门
        List<? extends SdzzwwOrg> list = null;
        GxqptOrg org = new GxqptOrg();
        org.setName(openApiReq.getData().getName());
        org.setForClass(openApiReq.getData().getForClass());
        org.setForType(openApiReq.getData().getForType());
        org.setIsenable(openApiReq.getData().getIsenable());
//        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
////            GxqptOrgExample example = new GxqptOrgExample();
////            example.createCriteria().andIdIn(Arrays.asList(ids)).andIsdeleteEqualTo(NOT_DELETE);
////            list = orgService.find(example);
//            list = orgService.selectOrgJoinDictionary(ids,org);
//        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
//            SdzzwwOrgExample example = new SdzzwwOrgExample();
//            example.createCriteria().andIdIn(Arrays.asList(ids)).andIsdeleteEqualTo(NOT_DELETE);
//            list = sdzzwwOrgService.find(example);
//        }
        list = orgService.selectOrgJoinDictionary(openApiReq.getData().getIds(), org, openApiReq.getData().getSystemCode());
        PageInfo p = new PageInfo<>(dozerUtils.mapPage(list, GxqptOrgResDTO.class));
        return Result.success(p);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id查询单位", notes = "根据Id查询单位")
    public Result<GxqptOrgDetailsDTO> getDetails(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        if (!systemService.isExistSystem(systemCode)) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //查询单位
//        SdzzwwOrg orgTemp = findOrgAndNameById(systemCode, id);
        SdzzwwOrg orgTemp = orgService.details(systemCode, id);
        List<GxqptShareAndAppInServiceDO> shares = toAppService.selectAppByShare(String.valueOf(orgTemp.getId()));
        GxqptOrgDetailsDTO org = dozerUtils.map(orgTemp, GxqptOrgDetailsDTO.class);
        StringBuffer buffer = new StringBuffer();
        for (GxqptShareAndAppInServiceDO share : shares) {
            buffer.append(share.getAppName() + CommonConstants.ROOT_PATH_DEF);
        }
        String shareStr = buffer.toString();
        if (shareStr.toString() == null || "".equals(shareStr.toString())) {
            org.setShareApp("");
        } else {
            org.setShareApp(shareStr.substring(0, shareStr.length() - 1));
        }
        return Result.success(org);
    }

    /**
     * 查询分享应用
     *
     * @param id
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @RequestMapping(value = "/getShares", method = RequestMethod.GET)
    @ApiOperation(value = "根据Id查询单位", notes = "根据Id查询单位")
    public Result<List<String>> getShares(@RequestParam(value = "id") String id) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, id);

        //查询
        List<GxqptShareAndAppInServiceDO> shares = toAppService.selectAppByShare(id);

        return Result.success(shares.stream().map(GxqptShareAndAppInServiceDO::getAppId).collect(Collectors.toList()));
    }

    @Override
    @ApiOperation(value = "根据user查询所有单位", notes = "根据user查询所有单位")
    @RequestMapping(value = "/findOrgByUser", method = RequestMethod.GET)
    public Result<List<GxqptOrgByUserDTO>> findOrgByUser() {
        //1.获取到登录用户信息
        Long userId = BaseContextHandler.getAdminId();

        //2.查出所有体系
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(userId);
        User user = userService.getUnique(example);

        //3.查询
        List list = orgService.findOrgByUser(user.getOwnSystem(), userId);
        return Result.success(dozerUtils.mapList(list, GxqptOrgByUserDTO.class));
    }

    @Override
    @IgnoreAppToken
    @ApiOperation(value = "单位导入模板下载", notes = "单位导入模板下载")
    @RequestMapping(value = "/downLoadTemplet", method = RequestMethod.GET)
    public void downLoadTemplet(HttpServletResponse response) {
        //1.获取字典集合
        List<DictionaryOrgFindDTO> dictionarys = dozerUtils
                .mapList(dictionaryService.findOrgDictionary(), DictionaryOrgFindDTO.class);
        List<AreaTreeDTO> treeList = TreeUtil.queryTree(dozerUtils.mapList(areaService.findAreaForExcel(), AreaTreeDTO.class), PARENT_ID);

        //2.规划单位的字典map
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionarys.forEach(dictionaryOrgFindDTO -> dictionaryMap
                .put(dictionaryOrgFindDTO.getDictionaryTypeCode(), dictionaryOrgFindDTO.getCode()));

        //3.获得Excel文档工具类的workbook
        HSSFWorkbook workbook = OrgUtil.templetExcel(treeList, dictionaryMap);

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
            //e.printStackTrace();
            log.error("Exception", e);
        }

        //5.向外部写出
        try {
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
            workbook.close();
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("Exception", e);
        }
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
    })
    @ApiOperation(value = "导入单位", notes = "根据Excel导入单位信息")
    @RequestMapping(value = "/saveOrgs", method = RequestMethod.POST)
    public Result<List<GxqptOrgResDTO>> saveOrgs(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "orgId") String orgId) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);

        //2.获取appid必要信息
        Long createUser = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        Date date = new Date();

        //3.获取字典以及地区信息
        DictionaryExample dictionaryExample = new DictionaryExample();
        List dictionarys = dictionaryService.find(dictionaryExample);
        List<AreaTreeDTO> treeList = TreeUtil.queryTree(dozerUtils.mapList(areaService.findAreaForExcel(), AreaTreeDTO.class), PARENT_ID);

        //4.转换并执行导入操作
        try {
            GxqptOrgImportDTO orgImport = new GxqptOrgImportDTO();
            orgImport.setParentId(orgId);
            orgImport.setCreateUser(String.valueOf(createUser));
            orgImport.setIsdelete(NOT_DELETE);
            List<GxqptOrg> orgs = dozerUtils.mapList(OrgUtil.readExcelValue(file.getInputStream(), orgImport), GxqptOrg.class);
            OrgUtil.transDictionaryAndArea(orgs, dictionarys, treeList);
            orgs = orgService.saveAndShare(orgs);
            if (orgs != null && orgs.size() > 0) {
                for (GxqptOrg org : orgs) {
                    saveRole(org, appId, createUser, date);
//                    joinOrgAminRole(org);
                }
            }
            return Result.success(dozerUtils.mapList(orgs, GxqptOrgResDTO.class));
        } catch (IOException e) {
//            e.printStackTrace();
            log.error("Exception", e);
        }
        return Result.fail("fail");
    }

    /**
     * 单位管理员绑定
     *
     * @param orgId
     * @param userId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 53001, message = "用户id不能为空"),
    })
    @ApiOperation(value = "单位管理员绑定", notes = "单位管理员绑定")
    @RequestMapping(value = "/saveManagerByOrg", method = RequestMethod.POST)
    public Result<Boolean> saveManagerByOrg(@RequestParam(value = "orgId") String orgId
            , @RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);

        //2.执行绑定业务
        AssignRoleManagerDO role = new AssignRoleManagerDO();
        role.setId(assignRoleService.genId());
        role.setAppId(orgId);
        role.setUserId(userId);
        role.setCreateTime(new Date());
        role.setCreateUser(BaseContextHandler.getAdminId());
        if (assignRoleService.insertAssignRoleByOrgAndUser(role) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 单位管理员删除绑定
     *
     * @param orgId
     * @param userId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 53001, message = "用户id不能为空"),
    })
    @ApiOperation(value = "单位管理员删除绑定", notes = "单位管理员删除绑定")
    @RequestMapping(value = "/deleteManagerByOrg", method = RequestMethod.POST)
    public Result<Boolean> deleteManagerByOrg(@RequestParam(value = "orgId") String orgId
            , @RequestParam(value = "userId") Long userId) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, userId);

        //2.执行绑定业务

        if (assignRoleService.deleteAssignRoleByOrgAndUser(userId, orgId) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    @Override
    @ApiOperation(value = "所在单位部门集合", notes = "所在单位部门集合")
    @RequestMapping(value = "/findOrgDpmIdenti", method = RequestMethod.GET)
    public Result<List<GxqptOrgDpmIdentiDTO>> findOrgDpmIdenti() {
        //1.获取到登录用户信息
        Long userId = BaseContextHandler.getAdminId();

        //2.查出所有体系
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(userId);
        User user = userService.getUnique(example);

        //3.查询
        List<GxqptOrgDpmIdentiDTO> orgList = dozerUtils.mapList(orgService.findOrgByUser(user.getOwnSystem(), userId), GxqptOrgDpmIdentiDTO.class);
        List<GxqptDpmByUserDTO> dpmlist = dozerUtils.mapList(dpmService.findDpmByUserAndOrg(user.getOwnSystem(), userId, null), GxqptDpmByUserDTO.class);
        orgList.forEach(org -> {
            org.setDpms(dpmlist.stream().filter(dpm -> org.getId().equals(dpm.getOrgId())).collect(Collectors.toList()));
        });
        return Result.success(orgList);
    }

    @Override
    @ApiOperation(value = "查询运维单位树", notes = "查询运维单位树")
    @RequestMapping(value = "/findOrgAndDpmOperationTree", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findOrgAndDpmOperationTree() {
        //1.查询所有运维单位
        GxqptOrgExample example = new GxqptOrgExample();
        example.createCriteria().
                andForTypeEqualTo(OPT_TYPE_CODE).
                andIsdeleteEqualTo(NOT_DELETE).
                andIsenableEqualTo(ORG_ISENBLE);

        List orgs = orgService.find(example);
        if (orgs == null || orgs.size() < 1) {
            return Result.success(new ArrayList<>());
        }
        List<GxqptOrgResDTO> list = dozerUtils.mapList(orgs, GxqptOrgResDTO.class);

        //2.查出所有运维下的部门
        GxqptDepartmentExample dmpExample = new GxqptDepartmentExample();
        dmpExample.createCriteria().
                andIsdeleteEqualTo(NOT_DELETE).
                andIsenableEqualTo(ORG_ISENBLE).
                andOrgIdIn(list.stream().map(GxqptOrgResDTO::getId).collect(Collectors.toList()));
        dmpExample.setOrderByClause("sortvalue asc");
        List<GxqptDepartment> dpms = dpmService.find(dmpExample);
        List<GxqptDpmResDTO> dpmList = dozerUtils.mapList(dpms, GxqptDpmResDTO.class);
        dpmList.forEach(obj -> obj.setSystemCode("gxqpt"));
        List<GxqptDpmResDTO> mlist;
        for (GxqptOrgResDTO org : list) {
            mlist = dpmList.stream().filter(dpm -> org.getId().equals(dpm.getOrgId())).collect(Collectors.toList());
            org.setDpms(mlist);
        }

        //3.构建树并返回
        list = TreeUtil.buildByRecursives(list);
        return Result.success(list);
    }

    /**
     * @Author wz
     * @Description //根据用户集合查询总单位部门人员树
     * @Date 11:19 2019/4/22
     * @Param [ids]
     * @return com.hengyunsoft.base.Result<java.util.List<com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO>>
     **/
    @Override
    @ApiOperation(value = "根据用户集合查询总运维单位部门人员树", notes = "根据用户集合查询总运维单位部门人员树")
    @RequestMapping(value = "/findOrgTreeByUsersInOperation", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findOrgTreeByUsersInOperation(@RequestParam(value = "ids") List<Long> ids) {
        // 验证
        if (ids.isEmpty()) {
            return Result.success(Collections.EMPTY_LIST);
        }
        // 查询用户集合所处单位

        List<GxqptOrgResDTO> orgs = dozerUtils.mapList(orgService.findOrgByUsers("gxqpt", ids), GxqptOrgResDTO.class);
        // 查询用户对应单位
        orgs = orgs.stream().filter(obj -> OPT_TYPE_CODE.equals(obj.getForType())).collect(Collectors.toList());
        if (orgs.isEmpty()) {
            return Result.success(Collections.EMPTY_LIST);
        }
        List<String> orgIds = orgs.stream().map(GxqptOrgResDTO::getId).collect(Collectors.toList());

        //查询对应所有部门
        GxqptDepartmentExample departmentExample = new GxqptDepartmentExample();
        departmentExample.createCriteria().
                andOrgIdIn(orgIds).
                andIsdeleteEqualTo(NOT_DELETE).
                andIsenableEqualTo(ORG_ISENBLE);
        List<GxqptDepartment> departments = dpmService.find(departmentExample);

        //组装数据
        List<GxqptOrgResDTO> res = getOrgTree(orgs, dozerUtils.mapList(departments, GxqptDpmResDTO.class));
        return Result.success(TreeUtil.buildByRecursives(res));
    }

    /**
     * @Author wz
     * @Description //根据登录用户查询运维总单位部门树
     * @Date 11:19 2019/4/22
     * @Param [ids]
     * @return com.hengyunsoft.base.Result<java.util.List<com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO>>
     **/
    @Override
    @ApiOperation(value = "根据登录用户查询运维总单位部门树", notes = "根据登录用户查询运维总单位部门树")
    @RequestMapping(value = "/findOrgTreeByLoginInOperation", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findOrgTreeByLoginInOperation() {
        // 验证
        Long userId = BaseContextHandler.getAdminId();
        if (userId == null) {
            return Result.success(Collections.EMPTY_LIST);
        }

        // 查询用户集合所处单位
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andGxqptEmpIdEqualTo(userId);
        GxqptEmp emp = gxqptEmpService.getUnique(empExample);
        if (emp == null) {
            return Result.success(Collections.EMPTY_LIST);
        }

        // 查询该用户的角色
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().
                andCodeEqualTo(APP_ADMIN_CODE).
                andAppIdEqualTo(OPT_APPID).
                andStatusEqualTo((short)1);

        // 查询用户对应单位
        GxqptOrgExample orgExample = new GxqptOrgExample();
        GxqptOrgExample.Criteria criteria = orgExample.createCriteria();
        criteria.andForTypeEqualTo(OPT_TYPE_CODE).
                andIsdeleteEqualTo(NOT_DELETE).
                andIsenableEqualTo(ORG_ISENBLE);
        List<GxqptOrg> org;
        if (roleService.findUserRole(roleExample, userId).size() == 0){
            org = dozerUtils.mapList(orgService.findOrgByUser("gxqpt", userId), GxqptOrg.class);
            org = org.stream().filter(obj -> OPT_TYPE_CODE.equals(obj.getForType())).collect(Collectors.toList());
        } else {
            org = orgService.find(orgExample);
        }
        if (org == null) {
            return Result.success(Collections.EMPTY_LIST);
        }

        //查询对应所有部门
        GxqptDepartmentExample departmentExample = new GxqptDepartmentExample();
        departmentExample.createCriteria().
                andOrgIdIn(org.stream().map(GxqptOrg::getId).collect(Collectors.toList())).
                andIsdeleteEqualTo(NOT_DELETE).
                andIsenableEqualTo(ORG_ISENBLE);
        List<GxqptDepartment> departments = dpmService.find(departmentExample);

        //组装数据
        List<GxqptOrgResDTO> res = getOrgTree(
                dozerUtils.mapList(org, GxqptOrgResDTO.class),
                dozerUtils.mapList(departments, GxqptDpmResDTO.class));

        return Result.success(TreeUtil.buildByRecursives(res));
    }

    /**
     * @param orgId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "根据单位id和上下文用户体系编码查询单位详情", notes = "根据单位id和上下文用户体系编码查询单位详情")
    @RequestMapping(value = "/getDetailByOrgId", method = RequestMethod.GET)
    public Result<GxqptOrgDetailsDTO> getDetailByOrgId(@RequestParam(value = "orgId") String orgId) {
        //验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);
        Long userId = BaseContextHandler.getAdminId();
        User user = userService.getById(userId);

        //查询单位
        SdzzwwOrg orgTemp = orgService.details(user.getOwnSystem(), orgId);
        GxqptOrgDetailsDTO org = dozerUtils.map(orgTemp, GxqptOrgDetailsDTO.class);
        return Result.success(org);
    }

    /**
     * 创建单位同时创建角色和默认权限人
     *
     * @param org
     * @param appId
     * @param adminId
     * @param date
     */
    private void saveRole(GxqptOrg org, String appId, Long adminId, Date date) {
        //1.添加角色
        Role role = new Role();
        role.setCode(ROLE_CODE_SUFFIX);
        role.setName(ROLE_NAME);
        role.setDesc(org.getName() + ROLE_DESC);
        role.setStatus((short) 1);
        role.setPtRole(true);
        role.setReadonly(true);
        role.setAppId(appId);
//        role.setAppId(appId);
        role.setBizFlag(org.getId());
        role.setAuthManageIs(false);
        role.setCreateUser(adminId);
        role.setUpdateTime(date);
        role.setCreateTime(date);
        role = roleService.saveSelective(role);

        //2.添加角色的默认人员
        AssignRole assignRole = new AssignRole();
        assignRole.setRoleId(role.getId());
        assignRole.setUserId(adminId);
        assignRole.setCreateUser(adminId);
        assignRole.setCreateTime(date);
        assignRoleService.save(assignRole);
    }

    private void joinOrgAminRole(GxqptOrg org) {
        //3.将单位管理员加入到单位管理员角色
        if (org == null || org.getOrgadmin() == null) {
            return;
        }
        GxqptEmpExample example = new GxqptEmpExample();

        example.createCriteria().andNicknameEqualTo(org.getOrgadmin());

        GxqptEmp emp = gxqptEmpService.getUnique(example);
        if (emp == null) {
            return;
        }
        roleService.joinRole(RoleCode.ORG_ADMIN_CODE, emp.getGxqptEmpId(), null);
    }

    private SdzzwwOrg findOrgAndNameById(String systemCode, String id) {
        SdzzwwOrg orgTemp = null;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptOrgExample example = new GxqptOrgExample();
            example.createCriteria().andIdEqualTo(id).andIsdeleteEqualTo(NOT_DELETE);
            example.setOrderByClause("sortvalue asc");
            orgTemp = orgService.getUnique(example);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwOrgExample example = new SdzzwwOrgExample();
            example.createCriteria().andIdEqualTo(id).andIsdeleteEqualTo(NOT_DELETE);
            example.setOrderByClause("sortvalue asc");
            orgTemp = sdzzwwOrgService.getUnique(example);
        }
        return orgTemp;
    }

//    /**
//     * 添加分享应用信息
//     *
//     * @param list
//     * @return
//     */
//    private List<GxqptOrgResDTO> filterShare(List<GxqptOrgResDTO> list) {
//        for (GxqptOrgResDTO res : list) {
//            List<GxqptShareAndAppInServiceDO> shares = toAppService.selectAppByShare(String.valueOf(res.getId()));
//            if (shares != null && shares.size() > 0) {
//                List<GxqptShareAndAppDTO> newShares = dozerUtils.mapList(shares, GxqptShareAndAppDTO.class);
//                res.setShareApps(newShares);
//            }
//        }
//        return list;
//    }
//
//    private GxqptOrgResDTO filterShare(GxqptOrgResDTO dto) {
//        List<GxqptShareAndAppInServiceDO> shares = toAppService.selectAppByShare(String.valueOf(dto.getId()));
//        if (shares != null && shares.size() > 0) {
//            List<GxqptShareAndAppDTO> newShares = dozerUtils.mapList(shares, GxqptShareAndAppDTO.class);
//            dto.setShareApps(newShares);
//        }
//        return dto;
//    }

    private Boolean shareManager(GxqptOrgEditDTO gxqptOrgEdit) {
        //1.获取一些必要信息
        Long createUser = BaseContextHandler.getAdminId();

        //2.修改分享应用
        String[] insertAppIds = gxqptOrgEdit.getInsertId();
        String[] deleteArray = (String[]) ConvertUtils.convert(gxqptOrgEdit.getDeleteId(), String.class);
        List<String> deleteIds = Arrays.asList(deleteArray);

        //3.添加分享应用
        if (insertAppIds != null && insertAppIds.length > 0) {
            List<DataShareToApp> list = new ArrayList<>();
            for (String id : insertAppIds) {
                DataShareToApp toApp = new DataShareToApp();
                toApp.setBizId(gxqptOrgEdit.getId());
                toApp.setBizType("ORG");
                toApp.setAppId(id);
                toApp.setCreateUser(createUser);
                toApp.setCreateTime(new Date());
                list.add(toApp);
            }
            if (toAppService.save(list).size() == 0) {
                return false;
            }
        }

        //5.删除分享应用
        if (insertAppIds != null && deleteIds.size() > 0) {
            if (toAppService.deleteShare(deleteIds, gxqptOrgEdit.getId()) <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 查询体系，单位，部门树---已启用的
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    @ApiOperation(value = "查询体系，单位，部门树---已启用的", notes = "查询体系，单位，部门树---已启用的")
    @RequestMapping(value = "/getAllOrgAndDpm", method = RequestMethod.GET)
    public Result<List<GxqptSystemTreeDTO>> getAllOrgAndDpm() {
        //获取全体系
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = systemService.find(systemExample);
        List systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());
        if (systemCodes.size() == 0) {
            return Result.success(new ArrayList<>());
        }

        //根据体系查询单位
        List<GxqptOrgTreeBySystemDTO> orgs = dozerUtils.mapList(orgService
                .findAllOrgBySystem(systemCodes), GxqptOrgTreeBySystemDTO.class);

        //根据体系查询部门
        List<GxqptDpmTreeBySystemDTO> dpms = dozerUtils.mapList(dpmService
                .findAllDpmBySystem(systemCodes), GxqptDpmTreeBySystemDTO.class);


        //根据体系查询人员
        List<EmpTreeBySystemDO> empsDO = gxqptEmpService.findAllEmpBySystemTree(systemCodes);

        List<GxqptEmpTreeBySystemDTO> emps = dozerUtils.mapList(empsDO, GxqptEmpTreeBySystemDTO.class);

        //部门关联人员集合
        dpms.forEach(dpm -> dpm.setList(emps.stream().filter(
                emp -> emp.getMaindeptid().equals(dpm.getId())).collect(Collectors.toList())));

        //单位关联部门集合
        orgs.forEach(org -> org.setList(dpms.stream().filter(
                dpm -> dpm.getOrgId().equals(org.getId())).collect(Collectors.toList())));

        //单位构树
        List<GxqptOrgTreeBySystemDTO> orgTree = TreeUtil.buildByRecursives(orgs);

        //单位归体系
        List<GxqptSystemTreeDTO> rets = dozerUtils.mapList(systems, GxqptSystemTreeDTO.class);
        rets.forEach(ret -> ret.setList(orgTree.stream().filter(org -> org.getSystemCode().equals(ret.getCode())).collect(Collectors.toList())));

        //返回树
        return Result.success(rets);
    }

    /**
     * 获取权限系统统计首页数据概况
     *
     * @return
     */
    @Override
    @ApiOperation(value = "获取权限系统统计首页数据概况", notes = "获取权限系统统计首页数据概况")
    @RequestMapping(value = "/getOrgStatisticsNum", method = RequestMethod.GET)
    public Result<GxqptOrgStatisticsNumDTO> getOrgStatisticsNum() {
        //实例化返回参数
        GxqptOrgStatisticsNumDTO res = new GxqptOrgStatisticsNumDTO();

        //获取单位个数
        GxqptOrgExample orgExample = new GxqptOrgExample();
        orgExample.createCriteria().andIsdeleteEqualTo(String.valueOf(DeleteStatus.UN_DELETE.getStatus()));
        res.setOrgNum(orgService.find(orgExample).size());

        //获取部门个数
        GxqptDepartmentExample departmentExample = new GxqptDepartmentExample();
        departmentExample.createCriteria().andIsdeleteEqualTo(String.valueOf(DeleteStatus.UN_DELETE.getStatus()));
        res.setDpmNum(dpmService.find(departmentExample).size());

        //获取应用个数
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria();
        res.setAppNum(applicationService.find(applicationExample).size());

        //获取人员个数
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andIsdeleteEqualTo(String.valueOf(DeleteStatus.UN_DELETE.getStatus()));
        res.setEmpNum(gxqptEmpService.find(empExample).size());

        return Result.success(res);
    }

    /**
     * 根据是否平台管理员查询管理单位
     *
     * @return
     */
    @Override
    @ApiOperation(value = "根据是否平台管理员查询管理单位", notes = "根据是否平台管理员查询管理单位")
    @RequestMapping(value = "/findOrgByPower", method = RequestMethod.GET)
    public Result<List<GxqptOrgByUserDTO>> findOrgByPower() {
        //初始化返回参数
        List<GxqptOrgByUserDTO> res = null;

        //获取全体系
        List<String> systemCodes = getSystemCode();

        //验证是否平台管理员
        UserTokenExtInfo token = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        if (token.ptAdminIs()) {
            res = dozerUtils.mapList(orgService
                    .findOrgByPtAdminAndSystemCode(systemCodes), GxqptOrgByUserDTO.class);
        } else {
            res = dozerUtils.mapList(orgService
                    .findOrgByAdminAndSystemCode(systemCodes, BaseContextHandler.getAdminId()), GxqptOrgByUserDTO.class);
        }
        return Result.success(res);
    }

    /**
     * 根据单位ids查询单位名称id信息
     *
     * @param ids
     * @return
     */
    @Override
    @ApiOperation(value = "根据单位ids查询单位名称id信息", notes = "根据单位ids查询单位名称id信息")
    @RequestMapping(value = "/findOrgNameByIds", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findOrgNameByIds(@RequestParam(value = "ids") List ids) {
        //获取全体系
        List<String> systemCodes = getSystemCode();
        if (systemCodes.size() == 0 || ids.size() == 0) {
            return Result.success(new ArrayList<>());
        }
        List<GxqptOrgResDTO> list = dozerUtils
                .mapList(orgService.findOrgNameByIds(ids, systemCodes), GxqptOrgResDTO.class);

        return Result.success(list);
    }

    /**
     * 查询我单位管理员所管理的单位
     *
     * @return
     */
    @Override
    @ApiOperation(value = "查询我所管理的单位", notes = "查询我所管理的单位")
    @RequestMapping(value = "/findOrgByOrgRole", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findOrgByOrgRole() {
        Long userId = BaseContextHandler.getAdminId();

        List systemCodes = getSystemCode();

        List<GxqptOrgResDTO> dto = dozerUtils.mapList(
                orgService.findOrgByAdminAndSystemCode(systemCodes, userId), GxqptOrgResDTO.class);

        return Result.success(dto);
    }

    @Override
    @ApiOperation(value = "共享交换单位查询", notes = "共享交换单位查询")
    @RequestMapping(value = "/findOrgByExchange", method = RequestMethod.POST)
    public Result<List<GxqptOrgResDTO>> findOrgByExchange(@RequestBody GxqptOrgByExchangeReqDTO dto) {
        //设置查询条件
        GxqptOrgByExchangeReqDO domain = dozerUtils.map(dto, GxqptOrgByExchangeReqDO.class);

        //获取全体系
        List<String> systems = systemService.getSystemCode();

        List<GxqptOrgResDTO> res = dozerUtils.mapList(orgService.findOrgByExchange(systems, domain), GxqptOrgResDTO.class);
        return Result.success(res);
    }

    /**
     * 获得体系编码list
     *
     * @return
     */
    private List<String> getSystemCode() {
        //设置查询条件
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = systemService.find(systemExample);
        //过滤空处理
        List systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());

        return systemCodes;
    }

    /**
     * @return java.util.List<com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO>
     * @Author wz
     * @Description //单位部门构树
     * @Date 10:46 2019/4/22
     * @Param [orgs, dpms]
     **/
    private List<GxqptOrgResDTO> getOrgTree(List<GxqptOrgResDTO> orgs, List<GxqptDpmResDTO> dpms) {

        orgs.forEach(org -> dpms.forEach(dpm -> {
            if (org.getId().equals(dpm.getOrgId())) {
                org.getDpms().add(dpm);
            }
        }));
        return orgs;
    }

    /**
     * @return java.util.List<com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO>
     * @Author wz
     * @Description //单位部门人员构树
     * @Date 10:46 2019/4/22
     * @Param [orgs, dpms]
     **/
    private List<GxqptOrgResDTO> getOrgTree(List<GxqptOrgResDTO> orgs, List<GxqptDpmResDTO> dpms, List<GxqptEmpRetDTO> emps) {
        dpms.forEach(dpm -> emps.forEach(emp -> {
            if (dpm.getId().equals(emp.getMaindeptid())) {
                dpm.getEmps().add(emp);
            }
        }));
        orgs = getOrgTree(orgs, dpms);
        return orgs;
    }
}
