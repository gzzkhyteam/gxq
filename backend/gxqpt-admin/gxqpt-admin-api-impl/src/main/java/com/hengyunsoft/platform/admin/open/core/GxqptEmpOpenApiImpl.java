package com.hengyunsoft.platform.admin.open.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.OrgSystemModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.emp.*;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpAndUserDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.OrgAndEmpInfoDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwDepartment;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.open.core.api.GxqptEmpOpenApi;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDepartmentExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptDpmService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptEmpService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptOrgService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwDepartmentExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwEmpExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwDpmService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwEmpService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述:权限管理用户对外接口
 *
 * @author chb
 * @date 2018/3/26 14:31
 * @return
 */
@Api(value = "API - GxqptEmpApiImpl", description = "查询用户对外接口")
@RestController
@RequestMapping("/p/emp")
@Slf4j
@OrgSystemModule
public class GxqptEmpOpenApiImpl implements GxqptEmpOpenApi {

    /**
     * 已删除
     */
    private static final String DELETE = "1";
    /**
     * 未删除
     */
    private static final String UNDELETE = "0";
    /**
     * 人员Service
     */
    @Autowired
    private GxqptEmpService gxqptEmpService;

    /**
     * 体系编码service
     */
    @Autowired
    private GxqptSystemService gxqptSystemService;

    /**
     * DozerUtils
     */
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * UserService
     */
    @Autowired
    private UserService userService;

    @Autowired
    private GxqptOrgService orgService;

    @Autowired
    private GxqptDpmService dpmService;

    @Autowired
    private SdzzwwDpmService sdzzwwDpmService;

    /**
     * 省电子政务网Service
     */
    @Autowired
    private SdzzwwEmpService sdzzwwEmpService;

    /*未删除标识*/
    private static final String NOT_DELETE = "0";

    /**
     * 根据用户id+体系编码查询用户
     *
     * @param userId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56025, message = "用户id为空")
    })
    @ApiOperation(value = "查询用户", notes = "根据用户id+体系编码查询用户")
    @RequestMapping(value = "/getEmpByUserId", method = RequestMethod.GET)
    public Result<GxqptEmpRetDTO> getEmpByUserId(@RequestParam(value = "userId") String userId, @RequestParam(value = "systemCode") String systemCode) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_EMPBINDUSER, userId);
        //2.数据处理
        List<GxqptEmpRetDTO> list;
        GxqptSystemExample example = new GxqptSystemExample();
        example.createCriteria().andCodeEqualTo(systemCode);
        GxqptSystem gxqptSystem = gxqptSystemService.getUnique(example);
        //3.判断是否存在该体系代码
        if (gxqptSystem != null && systemCode.equals(gxqptSystem.getCode())) {
            List<GxqptEmpAndUserDO> emp = gxqptEmpService.findEmpListByUserId(userId, gxqptSystem.getCode());
            if (emp != null && emp.size() > 0) {
                list = dozerUtils.mapList(emp, GxqptEmpRetDTO.class);
                return Result.success(list.get(0));
            }
        }
        return Result.success(new GxqptEmpRetDTO());
    }

    /**
     * 根据用户id获取用户列表（user表的id查询所有体系用户+体系编码）
     *
     * @param userId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56025, message = "用户id为空")
    })
    @ApiOperation(value = "获取用户列表"
            , notes = "根据用户id获取用户列表（user表的id查询所有体系用户+体系编码）")
    @RequestMapping(value = "/getEmpListByUserId", method = RequestMethod.GET)
    public Result<List<GxqptEmpOpenRetDTO>> getEmpListByUserId(@RequestParam(value = "userId") String userId) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_EMPBINDUSER, String.valueOf(userId));
        //2.数据处理
        GxqptSystemExample example = new GxqptSystemExample();
        List<GxqptEmpOpenRetDTO> empList = new ArrayList<>();
        List<GxqptSystem> list = gxqptSystemService.find(example);
        if (list != null && list.size() > 0) {
            for (GxqptSystem system : list) {
                String systemCode = system.getCode();
                if (systemCode == null || "".equals(systemCode)) {
                    continue;
                }
                List<GxqptEmpAndUserDO> emps = gxqptEmpService.findEmpListByUserId(userId, systemCode);
                empList.addAll(dozerUtils.mapList(emps, GxqptEmpOpenRetDTO.class));
            }
        }
        return Result.success(empList);
    }


    /**
     * 根据单位+体系编码获取用户
     *
     * @param req
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56008, message = "单位id为空")
    })
    @ApiOperation(value = "分页获取单位用户", notes = "根据单位id+体系编码分页获取用户")
    @RequestMapping(value = "/getEmpListByOrgId", method = RequestMethod.POST)
    public Result<PageInfo<GxqptEmpRetDTO>> getEmpListByOrgId(@RequestBody OpenApiReq<GxqptEmpOpenQueryDTO> req) {
        //1.校验
        String systemCode = req.getData().getSystemCode();
        String id = req.getData().getId();
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, id);
        //2.数据处理
        List<GxqptEmpRetDTO> list = new ArrayList<>();
        GxqptSystemExample example = new GxqptSystemExample();
        example.createCriteria().andCodeEqualTo(systemCode);
        GxqptSystem gxqptSystem = gxqptSystemService.getUnique(example);
        //3.判断是否存在该体系代码
        if (gxqptSystem != null && systemCode.equals(gxqptSystem.getCode())) {
            PageHelper.startPage(req.getPageNo(), req.getPageSize());
            List<GxqptEmpAndUserDO> emp = gxqptEmpService.findEmpListByOrgId(id, gxqptSystem.getCode());
            if (emp != null && emp.size() > 0) {
                list = dozerUtils.mapList(emp, GxqptEmpRetDTO.class);
            }
        }
        return Result.success(new PageInfo<>(list));
    }

    /**
     * 根据部门+体系编码获取用户
     *
     * @param req
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56011, message = "部门id为空")
    })
    @ApiOperation(value = "分页获取部门用户", notes = "根据部门id+体系编码获取用户")
    @RequestMapping(value = "/getEmpListByDeptId", method = RequestMethod.POST)
    public Result<PageInfo<GxqptEmpRetDTO>> getEmpListByDeptId(@RequestBody OpenApiReq<GxqptEmpOpenQueryDTO> req) {
        //1.校验
        String systemCode = req.getData().getSystemCode();
        String id = req.getData().getId();
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, id);
        //2.数据处理
        List<GxqptEmpRetDTO> list = new ArrayList<>();
        GxqptSystemExample example = new GxqptSystemExample();
        example.createCriteria().andCodeEqualTo(systemCode);
        GxqptSystem gxqptSystem = gxqptSystemService.getUnique(example);
        //3.判断是否存在该体系代码
        if (gxqptSystem != null && systemCode.equals(gxqptSystem.getCode())) {
            PageHelper.startPage(req.getPageNo(), req.getPageSize());
            List<GxqptEmpAndUserDO> emp = gxqptEmpService.findEmpListByDeptId(id, gxqptSystem.getCode());
            if (emp != null && emp.size() > 0) {
                list = dozerUtils.mapList(emp, GxqptEmpRetDTO.class);
            }
        }
        return Result.success(new PageInfo<>(list));
    }

    /**
     * 前提:1,登录人
     * 条件:正常单位，部门+人
     * 返回：name+phone
     * 形式:树
     * 不查询单位下的子单位
     * 2018-7-20 filterPhone 为true过滤手机号码为空的用户，消息系统需要
     * 2018-08-28新增返回登陆名，移动端lgr需要
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56025, message = "用户id为空")
    })
    @ApiOperation(value = "查询组织架构树"
            , notes = "根据用户id查询其所在单位下所有部门对应的所有人的姓名及电话，并以树形方式返回,若有单位id就只查本单位的")
    @RequestMapping(value = "/getTreeEmpPhoneByUserId", method = RequestMethod.GET)
    public Result<List<GxqptOrgTreeDTO>> getTreeEmpPhoneByUserId(@RequestParam(value = "userId") String userId,
                                                                 @RequestParam(value = "unitId", required = false) String unitId,
                                                                 @RequestParam(value = "filterPhone", required = false) Boolean filterPhone) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_EMPBINDUSER, String.valueOf(userId));
        User user = userService.getById(Long.valueOf(userId));
        if (user == null) {
            return Result.success(new ArrayList<>());
        }
        String systemCode = user.getOwnSystem();
        GxqptEmp emp = new GxqptEmp();
        emp.setGxqptEmpId(Long.valueOf(userId));
        //2.根据体系结构进行查询
        List<OrgAndEmpInfoDO> orgList;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            orgList = orgService.getOrgInfoByUserId(Long.valueOf(userId), systemCode);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            orgList = orgService.getOrgInfoByUserId(Long.valueOf(userId), systemCode);
        } else {
            return Result.success(new ArrayList<>());
        }
        //如果参数unitId不为空那么，只要unitId的单位
        if (StringUtils.isNotBlank(unitId)) {
            orgList = orgList.stream().filter(org -> org.getId().equals(unitId)).collect(Collectors.toList());
        }

        List<GxqptOrgTreeDTO> treeList = dozerUtils.mapList(orgList, GxqptOrgTreeDTO.class);

        //查询除系统中所有单位
        List<? extends SdzzwwDepartment> dpms;
        List<? extends SdzzwwEmp> list = null;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptDepartmentExample dmpExample = new GxqptDepartmentExample();
            dmpExample.createCriteria().andIsdeleteEqualTo(NOT_DELETE)
                    .andIsenableEqualTo("1");
            dpms = dpmService.find(dmpExample);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwDepartmentExample dmpExample = new SdzzwwDepartmentExample();
            dmpExample.createCriteria().andIsdeleteEqualTo(NOT_DELETE)
                    .andIsenableEqualTo("1");
            dpms = sdzzwwDpmService.find(dmpExample);
        } else {
            return Result.success(new ArrayList<>());
        }
        //查询系统中所有人员
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptEmp emp1 = new GxqptEmp();
            emp1.setIsdelete(UNDELETE);
            emp1.setIsenable("1");
            if (filterPhone != null && filterPhone) {
                emp1.setMainmobile("1");
            }
            list = gxqptEmpService.findIdentityEmpList(emp1);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwEmp sdzzwwEmp = new SdzzwwEmp();
            sdzzwwEmp.setIsdelete(UNDELETE);
            sdzzwwEmp.setIsenable("1");
            if (filterPhone != null && filterPhone) {
                sdzzwwEmp.setMainmobile("1");
            }
            list = sdzzwwEmpService.findIdentityEmpList(sdzzwwEmp);
        }
        List<? extends SdzzwwEmp> empList = list;
        treeList.forEach(org -> {
            List<? extends SdzzwwDepartment> dpmList = dpms.stream().filter(dpm -> dpm.getOrgId().equals(String.valueOf(org.getId())))
                    .sorted(Comparator.comparing(dpm -> dpm.getSortvalue())).collect(Collectors.toList());

            List<GxqptDeptEmpInfoDTO> dpmLs = dozerUtils.mapList(dpmList, GxqptDeptEmpInfoDTO.class);
            dpmLs.forEach(dpm -> {
                List<? extends SdzzwwEmp> empNList = empList.stream().filter(e -> e.getMainorgid().equals(org.getId()) && e.getMaindeptid().equals(dpm.getId())).collect(Collectors.toList());
                List<GxqptEmpPhoneDTO> ems = dozerUtils.mapList(empNList, GxqptEmpPhoneDTO.class);
                dpm.setEmpList(ems);
            });
            org.setDeptList(dpmLs);
        });
        return Result.success(treeList);
    }

    /**
     * 根据userId查询其所在单位下的所有人，若有部门ID则查询该单位对应部门下的人
     *
     * @param userId
     * @param deptId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56025, message = "用户id为空")
    })
    @ApiOperation(value = "查询用户单位下所有人"
            , notes = "根据userId查询其所在单位下的所有人，若有部门ID则查询该单位对应部门下的人")
    @RequestMapping(value = "/getUsersByUserId", method = RequestMethod.GET)
    public Result<List<GxqptLogEmpInfoDTO>> getUsersByUserId(@RequestParam(value = "userId") String userId,
                                                             @RequestParam(value = "deptId", required = false) String deptId) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_EMPBINDUSER, String.valueOf(userId));
        User user = userService.getById(Long.valueOf(userId));
        String systemCode = user.getOwnSystem();
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andGxqptEmpIdEqualTo(Long.valueOf(userId));
        GxqptEmp emp = gxqptEmpService.getUnique(empExample);
        List<? extends SdzzwwEmp> list = new ArrayList<>();
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptEmpExample emp1 = new GxqptEmpExample();
            emp1.createCriteria().andIsdeleteEqualTo(UNDELETE)
                    .andMainorgidEqualTo(emp.getMainorgid()).andMaindeptidEqualTo(deptId);
            list = gxqptEmpService.find(emp1);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwEmpExample sdzzwwEmp = new SdzzwwEmpExample();
            sdzzwwEmp.createCriteria().andIsdeleteEqualTo(UNDELETE)
                    .andMainorgidEqualTo(emp.getMainorgid()).andMaindeptidEqualTo(deptId);
            list = sdzzwwEmpService.find(sdzzwwEmp);
        }
        return Result.success(dozerUtils.mapList(list, GxqptLogEmpInfoDTO.class));
    }
}