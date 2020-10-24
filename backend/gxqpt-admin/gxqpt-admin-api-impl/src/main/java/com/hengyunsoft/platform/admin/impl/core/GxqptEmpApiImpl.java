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
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.*;
import com.hengyunsoft.platform.admin.api.core.dto.empidentity.GxqptEmpIdentityConstant;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpEmailLikeDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpAndUserDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpByUserIdsDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.*;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmpIdentity;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.domain.EmpIdFroOperationDO;
import com.hengyunsoft.platform.admin.impl.utils.inport.DownloadTempletUtil;
import com.hengyunsoft.platform.admin.impl.utils.inport.PaserImportEmpExcelUtil;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.core.example.UserExample;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptDutiesExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptPostExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.*;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwEmpExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwEmpService;
import com.hengyunsoft.sec.PasswordEncoder;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Api(value = "API - GxqptEmpApiImpl", description = "人员管理")
@RestController
@RequestMapping("emp")
@Slf4j
public class GxqptEmpApiImpl implements GxqptEmpApi {

    /**
     * 已删除
     */
    private static final String DELETE = "1";
    /**
     * 未删除
     */
    private static final String UNDELETE = "0";
    /*运维一般角色code*/
    private static final String YW_ROLE_CODE = "ordinary_user";
    //    /*运维一般人员code*/
//    private static final String YW__CODE = "ordinary_user";
    /*运维应用appid*/
    private static final String YW_APPID = "45aj6317";
    /**
     * 人员Service
     */
    @Autowired
    private GxqptEmpService gxqptEmpService;

    @Autowired
    private GxqptEmpIdentityService empIdentityService;

    @Autowired
    private DictionaryService dictionaryService;
    /**
     * 单位Service
     */
    @Autowired
    private GxqptOrgService gxqptOrgService;
    /**
     * 部门Service
     */
    @Autowired
    private GxqptDpmService gxqptDpmService;

    /**
     * 省电子政务网Service
     */
    @Autowired
    private SdzzwwEmpService sdzzwwEmpService;

    /**
     * DozerUtils
     */
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * userService
     */
    @Autowired
    private UserService userService;

    @Autowired
    private GxqptDutiesService gxqptDutiesService;

    @Autowired
    private GxqptPostService gxqptPostService;

    @Autowired
    private GxqptSystemService gxqptSystemService;

    /**
     * 新建人员信息
     * 更新人：chb
     * 更新时间：2018-4-20
     * 更新内容：根据定窑新业务需求，在创建emp是创建并绑定对应的user以及登陆相关信息
     *
     * @return
     */
    @Override
    @ApiOperation(value = "新建人员信息", notes = "新建人员信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56000, message = "人员为空"),
            @ApiResponse(code = 56031, message = "登陆账号不能为空"),
            @ApiResponse(code = 56002, message = "人员密码不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwEmp.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<GxqptEmpDTO> save(@RequestBody GxqptEmpDTO gxqptEmpDTO) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, gxqptEmpDTO);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ACCOUNT, gxqptEmpDTO.getNickname());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_PASSWORD, gxqptEmpDTO.getPassword());
        if (null != gxqptEmpDTO.getEmpNo() && !"".equals(gxqptEmpDTO.getEmpNo())) {
            GxqptEmpExample tmp = new GxqptEmpExample();
            tmp.createCriteria().andEmpNoEqualTo(gxqptEmpDTO.getEmpNo());
            int count = gxqptEmpService.count(tmp);
            if (count > 0) {
                BizAssert.fail(AuthorityExceptionCode.GXQPT_EMP_EMPNO_REPEAT.getCode(), AuthorityExceptionCode.GXQPT_EMP_EMPNO_REPEAT.getMsg());
            }
        }
        //2.转换
        GxqptEmp emp = dozerUtils.map(gxqptEmpDTO, GxqptEmp.class);
        //3.数据处理
        emp.setIsdelete(UNDELETE);
        emp.setCreateUser(BaseContextHandler.getAdminId().toString());
        emp.setUpdateUser(emp.getCreateUser());
        Date nowDate = new Date();
        emp.setCreateTime(nowDate);
        emp.setUpdateTime(nowDate);
        //4.创建user登陆账号
        Map<String, String> map = createLoginUser(gxqptEmpDTO);
        //账号已存在
        String exists = "exists";
        //保存成功
        String state = "ok";
        //状态
        String keyDate = "result";
        //返回数据
        String date = "date";
        if (map != null) {
            if (exists.equals(map.get(keyDate))) {
                return Result.fail("账号被占用");
            }
            if (state.equals(map.get(keyDate))) {
                //5.保存emp
                emp.setGxqptEmpId(Long.valueOf(map.get(date)));
                GxqptEmp gxqptEmp = gxqptEmpService.save(emp);
                if (gxqptEmp.getId() != null) {
                    return Result.success(gxqptEmpDTO);
                }
            }

        }
        return Result.fail("新增人员出错");
    }

    @ApiOperation(value = "同步部门人员保证一致", notes = "同步部门人员保证一致")
    @RequestMapping(value = "/updateDpmAndEmpSyn", method = RequestMethod.GET)
    public Result<Integer> updateDpmAndEmpSyn() {
        List<GxqptEmp> emps = gxqptEmpService.find(null);
        List<GxqptDepartment> dpms = gxqptDpmService.find(null);
        List<GxqptOrg> orgs = gxqptOrgService.find(null);
        orgs.forEach(org -> {
            dpms.forEach(dpm -> {
                if (dpm.getOrgId().equals(org.getId())) {
                    emps.forEach(emp -> {
                        if (emp.getMaindeptid().equals(dpm.getId())) {
                            emp.setMainorgid(org.getId());
                            emp.setMainorgname(org.getName());
                        }
                    });
                }
            });
        });
        int i = gxqptEmpService.updateByIdSelective(emps);
        return Result.success(i);
    }

    /**
     * 创建登陆账号
     * 更新人：chb
     * 更新时间：2018-4-20
     * 更新内容：根据定窑新业务需求，在创建emp是创建并绑定对应的user以及登陆相关信息
     *
     * @param gxqptEmpDTO
     * @return
     */
    private Map<String, String> createLoginUser(GxqptEmpDTO gxqptEmpDTO) {
        Map<String, String> map = new HashMap<>(2);
        String passwordMd5 = PasswordEncoder.encoder(gxqptEmpDTO.getPassword());
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(gxqptEmpDTO.getNickname());
        if (userService.find(example).size() > 0) {
            map.put("result", "exists");
            map.put("date", "");
            return map;
        }
        User user = new User();
        user.setAccount(gxqptEmpDTO.getNickname());
        user.setPassword(passwordMd5);
        user.setOwnSystem(gxqptEmpDTO.getSystemCode());
        user.setName(gxqptEmpDTO.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            if (gxqptEmpDTO.getBirthday() != null) {
                date = sdf.parse(gxqptEmpDTO.getBirthday());
            }
        } catch (Exception e) {
            log.error("Exception", e);
        }
        user.setBirthday(date);
        user.setNation(gxqptEmpDTO.getNation());
        user.setPhoto(gxqptEmpDTO.getPhoto());
        user.setOfficetel(gxqptEmpDTO.getOfficetel());
        user.setPhone(gxqptEmpDTO.getMainmobile());
        user.setWorkStatus(gxqptEmpDTO.getStatus());
        //启用标记
        String isEnable = "1";
        if (isEnable.equals(gxqptEmpDTO.getIsenable())) {
            user.setLoginable(true);
        } else {
            user.setLoginable(false);
        }
        user.setDescrption(gxqptEmpDTO.getDescrption());
        Long createUser = BaseContextHandler.getAdminId();
        user.setCreateUser(createUser);
        user.setUpdateUser(createUser);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        User reUser = userService.save(user);
        if (reUser != null) {
            map.put("result", "ok");
            map.put("date", String.valueOf(reUser.getId()));
            return map;
        }
        return null;
    }

    /**
     * 根据id获取人员信息
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据id获取人员信息", notes = "根据id获取人员信息")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    public Result<GxqptEmpRetDTO> getById(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode,
                                          @RequestParam(value = "identityId", required = false) String identityId) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ID, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        //2.查询
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptEmpIdentity gxidentity = null;
            if (identityId != null && !"".equals(identityId)) {
                gxidentity = empIdentityService.getById(identityId);
            }
            GxqptEmp gxqptEmp = gxqptEmpService.getById(id);
            if (gxidentity != null) {
                syncIdentityInfo(gxidentity, gxqptEmp);
            }
            return Result.success(dozerUtils.map(gxqptEmp, GxqptEmpRetDTO.class));
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwEmpIdentity dzdentity = null;
            if (identityId != null && !"".equals(identityId)) {
                dzdentity = empIdentityService.getById(identityId);
            }
            SdzzwwEmp sdzzwwEmp = sdzzwwEmpService.getById(id);
            if (dzdentity != null) {
                syncIdentityInfo(dzdentity, sdzzwwEmp);
            }
            return Result.success(dozerUtils.map(sdzzwwEmp, GxqptEmpRetDTO.class));
        } else {
            return null;
        }
    }

    /**
     * 身份信息同步
     *
     * @param dzdentity
     * @param sdzzwwEmp
     */
    private void syncIdentityInfo(SdzzwwEmpIdentity dzdentity, SdzzwwEmp sdzzwwEmp) {
        sdzzwwEmp.setIsheader(dzdentity.getIsheader());
        sdzzwwEmp.setIsleader(dzdentity.getIsleader());
        sdzzwwEmp.setDescrption(dzdentity.getDescription());
        sdzzwwEmp.setUserduty(dzdentity.getUserduty());
    }

    /**
     * 根据ids获取人员信息集合（gxqpt）
     *
     * @param ids
     * @return
     */
    @Override
    @ApiOperation(value = "根据ids获取人员信息集合（gxqpt）", notes = "根据ids获取人员信息集合（gxqpt）")
    @RequestMapping(value = "/findByIdsGxqpt", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空")
    })
    public Result<List<GxqptEmpRetDTO>> findByIdsGxqpt(@RequestParam(value = "ids[]") String ids[]) {
        //校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, ids);

        //查找人员集合
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andIdIn(Arrays.asList(ids));

        List list = gxqptEmpService.find(empExample);
        return Result.success(dozerUtils.mapList(list, GxqptEmpRetDTO.class));
    }

    /**
     * 根据ids获取人员信息集合（gxqpt）运维系统
     *
     * @param ids
     * @return
     */
    @Override
    @ApiOperation(value = "根据ids获取人员信息集合（提供给运维系统）", notes = "根据ids获取人员信息集合（提供给运维系统）")
    @RequestMapping(value = "/findByIdsGxqptYw", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空")
    })
    public Result<List<GxqptEmpRetDTO>> findByIdsGxqptYw(@RequestParam(value = "ids[]") Long ids[]) {
        //校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, ids);

        //查找人员集合
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andGxqptEmpIdIn(Arrays.asList(ids));

        List list = gxqptEmpService.find(empExample);
        return Result.success(dozerUtils.mapList(list, GxqptEmpRetDTO.class));
    }

    @Override
    /**
     * 根据ids获取人员信息集合（gxqpt）运维系统
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "根据ids获取人员信息集合（提供给共享交换系统）", notes = "根据ids获取人员信息集合（提供给共享交换系统）")
    @RequestMapping(value = "/findByIdsGxqptUserName", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空")
    })
    public Result<List<GxqptEmpRetDTO>> findByIdsGxqptUserName(@RequestParam(value = "ids") List<Long> ids) {
        //校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, ids);

        //查找人员集合
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andGxqptEmpIdIn(ids);

        List list = gxqptEmpService.find(empExample);
        return Result.success(dozerUtils.mapList(list, GxqptEmpRetDTO.class));
    }

    /**
     * 描述：根据用户id查询用户
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/28
     * 修改内容：
     */
    @Override
    @RequestMapping(value = "getByUserId", method = RequestMethod.POST)
    @ApiOperation(value = "根据用户id查询用户", notes = "根据用户id查询用户")
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空")
    })
    public Result<GxqptEmpRetDTO> getByUserId(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        //2.查询
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptEmpExample example = new GxqptEmpExample();
            GxqptEmpExample.Criteria criteria = example.createCriteria();
            criteria.andGxqptEmpIdEqualTo(Long.parseLong(id));
            GxqptEmp gxqptEmp = gxqptEmpService.getUnique(example);
            return Result.success(dozerUtils.map(gxqptEmp, GxqptEmpRetDTO.class));
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwEmpExample empExample = new SdzzwwEmpExample();
            SdzzwwEmpExample.Criteria criteria = empExample.createCriteria();
            criteria.andGxqptEmpIdEqualTo(Long.parseLong(id));
            SdzzwwEmp sdzzwwEmp = sdzzwwEmpService.getUnique(empExample);
            return Result.success(dozerUtils.map(sdzzwwEmp, GxqptEmpRetDTO.class));
        } else {
            return null;
        }
    }

    /**
     * 根据id修改人员信息
     *
     * @param gxqptEmpDTO
     * @return
     */
    @Override
    @ApiOperation(value = "根据id修改人员信息", notes = "根据id修改人员信息")
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56000, message = "人员为空")
    })
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwEmp.class)
            }
    )
    public Result<GxqptEmpDTO> updateById(@RequestBody GxqptEmpDTO gxqptEmpDTO) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, gxqptEmpDTO);
        if (null != gxqptEmpDTO.getEmpNo() && !"".equals(gxqptEmpDTO.getEmpNo())) {
            GxqptEmpExample tmp = new GxqptEmpExample();
            tmp.createCriteria().andEmpNoEqualTo(gxqptEmpDTO.getEmpNo()).andIdNotEqualTo(gxqptEmpDTO.getId());
            int count = gxqptEmpService.count(tmp);
            if (count > 0) {
                BizAssert.fail(AuthorityExceptionCode.GXQPT_EMP_EMPNO_REPEAT.getCode(), AuthorityExceptionCode.GXQPT_EMP_EMPNO_REPEAT.getMsg());
            }
        }
        //2.转换
        GxqptEmp emp = dozerUtils.map(gxqptEmpDTO, GxqptEmp.class);
        //3.数据初始化
        if (gxqptEmpDTO.getPassword() != null && !"".equals(gxqptEmpDTO.getPassword())) {
            emp.setPasswordmd5(PasswordEncoder.encoder(gxqptEmpDTO.getPassword()));
            emp.setPasswordsha(PasswordEncoder.encoder(gxqptEmpDTO.getPassword()));
        }
        emp.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        emp.setUpdateTime(nowDate);
        //4.数据操作
        int result = gxqptEmpService.updateByIdSelective(emp);
        if (result > 0) {
            //2018-7-5 app修改信息为user,所以需要进行数据的同步，修改user表进行数据同步  姓名，性别，生日，民族，办公电话，手机
            try {
                GxqptEmp gemp = gxqptEmpService.getById(emp.getId());
                User user = new User();
                user.setId(gemp.getGxqptEmpId());
                user.setName(emp.getName());
                user.setNation(emp.getNation());
                user.setSex(emp.getSex());
                user.setPhoto(emp.getPhoto());
                if (emp.getBirthday() != null && !"".equals(emp.getBirthday())) {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = format.parse(emp.getBirthday());
                    user.setBirthday(date);
                }
                user.setOfficetel(emp.getOfficetel());
                user.setPhone(emp.getMainmobile());
                userService.updateByIdSelective(user);
            } catch (Exception e) {
                log.error("Exception", e);
            }

            return Result.success(gxqptEmpDTO);
        }
        return Result.fail("保存失败！");
    }


    /**
     * 根据ID修改密码
     * 更新人：chb
     * 更新时间：2018-4-20
     * 更新内容：根据定窑新业务需求，在创建emp是创建并绑定对应的user以及登陆相关信息
     * 同时修改密码修改为修改user密码，不再是emp人员密码
     *
     * @param id
     * @param password
     * @return
     */
    @Override
    @ApiOperation(value = "根据id修改人员密码信息", notes = "根据id修改人员密码信息")
    @RequestMapping(value = "/updatePasswordById", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 53001, message = "人员ID不能为空"),
            @ApiResponse(code = 56002, message = "人员密码不能为空")
    })
    public Result<String> updatePasswordById(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_ID_NULL, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_PASSWORD, password);
        //2.数据操作
        User user = new User();
        user.setId(Long.valueOf(id));
        if (!"".equals(password)) {
            user.setPassword(PasswordEncoder.encoder(password));
        }
        user.setUpdateUser(BaseContextHandler.getAdminId());
        user.setUpdateTime(new Date());
        int result = userService.updateByIdSelective(user);
        if (result > 0) {
            return Result.success("修改成功！");
        }
        return Result.fail("修改失败！");
    }

    /**
     * 描述：根据姓名模糊查询用户
     * name[name,手机，nickname]
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/25
     * 修改内容：
     */
    @Override
    @RequestMapping(value = "findEmpListByName", method = RequestMethod.GET)
    @ApiOperation(value = "根据姓名模糊查询用户", notes = "根据姓名模糊查询用户")
    public Result<List<GxqptEmpRetDTO>> findEmpListByName(@RequestParam(value = "mainorgid", required = false) String mainorgid, @RequestParam("name") String name, @RequestParam("systemCode") String systemCode) {
        GxqptEmp emp = new GxqptEmp();
        emp.setName(name);
        emp.setIsdelete(UNDELETE);
        emp.setMainorgid(mainorgid);

        List<? extends SdzzwwEmp> list;
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            list = gxqptEmpService.findIdentityEmpList2app(emp);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {

            SdzzwwEmp sdzzwwEmp = new SdzzwwEmp();
            sdzzwwEmp.setName(name);
            sdzzwwEmp.setIsdelete(UNDELETE);
            sdzzwwEmp.setMainorgid(mainorgid);
            list = sdzzwwEmpService.findIdentityEmpList2app(sdzzwwEmp);
        } else {
            list = new ArrayList<>();
        }

        List<GxqptEmpRetDTO> retDTOS = dozerUtils.mapList(list, GxqptEmpRetDTO.class);
        return Result.success(retDTOS);
    }

    /**
     * 获取分页数据
     * 2018-4-10修改 增加人员身份设置
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "获取人员分页数据", notes = "获取人员分页数据")
    @RequestMapping(value = "/findEmpList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptEmpRetDTO>> findEmpList(@RequestBody OpenApiReq<GxqptEmpDTO> openApiReq) {
        GxqptEmpDTO gxqptEmpDTO = openApiReq.getData();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        if (gxqptEmpDTO.getMainorgid() == null || "".equals(gxqptEmpDTO.getMainorgid())) {
            return Result.success(new PageInfo<>(new ArrayList<>()));
        }

        //2018-4-10修改 增加人员身份设置
        GxqptEmp emp = new GxqptEmp();
        emp.setName(gxqptEmpDTO.getName());
        emp.setIsdelete(UNDELETE);
        emp.setNickname(gxqptEmpDTO.getNickname());
        emp.setMainorgname(gxqptEmpDTO.getMainorgname());
        emp.setIsenable(gxqptEmpDTO.getIsenable());
        emp.setMaindeptid(gxqptEmpDTO.getMaindeptid());
        emp.setMainorgid(gxqptEmpDTO.getMainorgid());
        emp.setMaindutyname(gxqptEmpDTO.getMaindutyname());
        emp.setMainpostname(gxqptEmpDTO.getMainpostname());
        List<? extends SdzzwwEmp> list;
        if (CommonConstants.SYS_GXQPT_CODE.equals(gxqptEmpDTO.getSystemCode())) {
            list = gxqptEmpService.findIdentityEmpList(emp);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(gxqptEmpDTO.getSystemCode())) {
            SdzzwwEmp sdzzwwEmp = new SdzzwwEmp();
            sdzzwwEmp.setName(gxqptEmpDTO.getName());
            sdzzwwEmp.setIsdelete(UNDELETE);
            sdzzwwEmp.setNickname(gxqptEmpDTO.getNickname());
            sdzzwwEmp.setMainorgname(gxqptEmpDTO.getMainorgname());
            sdzzwwEmp.setIsenable(gxqptEmpDTO.getIsenable());
            sdzzwwEmp.setMaindeptid(gxqptEmpDTO.getMaindeptid());
            sdzzwwEmp.setMainorgid(gxqptEmpDTO.getMainorgid());
            list = sdzzwwEmpService.findIdentityEmpList(sdzzwwEmp);
        } else {
            list = new ArrayList<>();
        }
        List<GxqptEmpRetDTO> pageList = dozerUtils.mapPage(list, GxqptEmpRetDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 用户信息导入
     * <p>
     * 创建登陆账号
     * 更新人：chb
     * 更新时间：2018-4-20
     * 更新内容：根据定窑新业务需求，在创建emp是创建并绑定对应的user以及登陆相关信息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    @ApiOperation(value = "用户信息导入", notes = "用户信息导入")
    @RequestMapping(value = "/saveImportEmp", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id不能为空"),
            @ApiResponse(code = 56011, message = "部门id不能为空")
    })
    public Result<String> saveImportEmp(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file,
                                        @RequestParam(value = "orgId") String orgId, @RequestParam(value = "deptId") String deptId,
                                        @RequestParam(value = "systemCode") String systemCode) throws Exception {
        //1.查询校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, deptId);

        GxqptOrg org = gxqptOrgService.getById(orgId);
        GxqptDepartment dpt = gxqptDpmService.getById(deptId);

        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, org);
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_NULL, dpt);
        //2.上传处理，直接获取流不保存服务器了
        //3.模板解析
        List<GxqptEmpImportDTO> list = new ArrayList<>();
        PaserImportEmpExcelUtil.importEmpExcel(list, file.getInputStream());
        //4.数据处理
        String result = "";
        //表头有一行数据
        int count = 1;
        String numResult = "";
        for (GxqptEmpImportDTO importDTO : list) {
            count++;
            importDTO.setMainorgid(org.getId());
            importDTO.setMainorgname(org.getName());
            importDTO.setMaindeptid(dpt.getId());
            importDTO.setMaindeptname(dpt.getName());
            GxqptEmp emp = dozerUtils.map(importDTO, GxqptEmp.class);
            emp.setIsdelete(UNDELETE);
            emp.setCreateUser(BaseContextHandler.getAdminId().toString());
            emp.setUpdateUser(emp.getCreateUser());
            Date nowDate = new Date();
            emp.setCreateTime(nowDate);
            emp.setUpdateTime(nowDate);
            //5.保存数据库
            GxqptEmpDTO gxqptEmpDTO = dozerUtils.map(importDTO, GxqptEmpDTO.class);
            //非空判断
            if ("".equals(gxqptEmpDTO.getName())) {
                BizAssert.fail(AuthorityExceptionCode.GXQPT_EMP_NAME.getCode(), "姓名不能为空！");
            }
            if ("".equals(gxqptEmpDTO.getNickname())) {
                BizAssert.fail(AuthorityExceptionCode.GXQPT_EMP_NIKENAME.getCode(), "登陆账号不能为空！");
            }
            if ("".equals(gxqptEmpDTO.getPassword())) {
                BizAssert.fail(AuthorityExceptionCode.GXQPT_EMP_PASSWORD.getCode(), "人员密码不能为空！");
            }
            if (gxqptEmpDTO.getMainmobile() == null || "".equals(gxqptEmpDTO.getMainmobile())) {
                BizAssert.fail(AuthorityExceptionCode.GXQPT_EMP_MAINMOBILE.getCode(), "手机1不能为空！");
            }
            gxqptEmpDTO.setSystemCode(systemCode);
            try {
                Map<String, String> map = createLoginUser(gxqptEmpDTO);
                //账号已存在
                String exists = "exists";
                //保存成功
                String state = "ok";
                //状态
                String keyDate = "result";
                //返回数据
                String date = "date";
                if (map != null) {
                    if (exists.equals(map.get(keyDate))) {
                        result += gxqptEmpDTO.getNickname() + "，";
                    }
                    if (state.equals(map.get(keyDate))) {
                        //5.处理职务，岗位
                        if ("".equals(importDTO.getDutyname()) || "".equals(importDTO.getPostname())) {
                            throw new RuntimeException("posterror");
                        }
                        //6.办公室电话
                        if (importDTO.getOfficetel() == null || "".equals(importDTO.getOfficetel())) {
                            throw new RuntimeException("officetel_error");
                        }
                        GxqptDutiesExample dutiesExample = new GxqptDutiesExample();
                        dutiesExample.createCriteria().andOrgidEqualTo(emp.getMainorgid())
                                .andNameEqualTo(importDTO.getDutyname());
                        GxqptDuties duties = gxqptDutiesService.getUnique(dutiesExample);

                        GxqptPostExample postExample = new GxqptPostExample();
                        postExample.createCriteria().andOrgidEqualTo(emp.getMainorgid())
                                .andNameEqualTo(importDTO.getPostname());
                        GxqptPost post = gxqptPostService.getUnique(postExample);
                        if (duties != null && post != null) {
                            emp.setDutylevel(duties.getLevel());
                            emp.setMainduty(duties.getId());
                            emp.setMaindutyname(importDTO.getDutyname());
                            emp.setMainpost(post.getId());
                            emp.setMainpostname(importDTO.getPostname());
                        } else {
                            throw new RuntimeException("post");
                        }
                        //7.保存emp
                        emp.setGxqptEmpId(Long.valueOf(map.get(date)));
                        gxqptEmpService.save(emp);
                    }
                }
            } catch (Exception e) {
                String excetionMsg = e.getMessage();
                numResult += "第" + count + "行";
                if ("posterror".equals(excetionMsg)) {
                    numResult += "职务或岗位为空，";
                }
                if ("officetel_error".equals(excetionMsg)) {
                    numResult += "办公电话为空，";
                }
                if ("post".equals(excetionMsg)) {
                    numResult += "系统中该单位职务或岗位不存在，";
                }
                continue;
            }
        }
        if (!"".equals(result)) {
            result = result.substring(0, result.length() - 1);
        }
        if (!"".equals(numResult) || !"".equals(result)) {
            String tips = "共" + list.size() + "条数据，";
            if (!"".equals(numResult)) {
                tips += numResult + "请确认!";
            }
            if (!"".equals(result)) {
                tips += "以下账号已存在【" + result + "】,请注意修改后重新导入。";
            }
            BizAssert.fail(AuthorityExceptionCode.GXQPT_EMPXLS_ERROR.getCode(), tips);
        }
        return Result.success("导入成功！");
    }

    /**
     * 用户信息导入模板下载
     *
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    @IgnoreAppToken
    @ApiOperation(value = "用户信息导入模板下载", notes = "用户信息导入模板下载")
    @RequestMapping(value = "/downloadTemplet", method = RequestMethod.GET)
    public void downloadTemplet(HttpServletResponse response) throws Exception {
        String filename = "用户信息导入模板.xls";
        DownloadTempletUtil.DownloadTemple(response, filename, "templet/emp-templet.xls");
    }

    /**
     * 用户信息导出
     *
     * @param response
     * @param userId
     * @throws Exception
     */
//    @Override
    @IgnoreAppToken
    @ApiOperation(value = "用户信息导出", notes = "用户信息导出")
    @RequestMapping(value = "/downloadEmpList", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id为空"),
            @ApiResponse(code = 56011, message = "部门id为空"),
            @ApiResponse(code = 56001, message = "人员ID为空"),
    })
    public void downloadEmpList(HttpServletResponse response, @RequestParam(value = "userId") String userId/*,
                                @RequestParam(value = "orgId") String orgId, @RequestParam(value = "deptId") String deptId*/) throws Exception {
        //1.查询校验
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, orgId);
//        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, deptId);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ID, userId);

        GxqptEmpExample empExample = new GxqptEmpExample();
        String[] userIds = userId.split(",");
        List<String> idList = Arrays.asList(userIds);
        empExample.createCriteria()
                .andIdIn(idList);
        List<GxqptEmp> emps = gxqptEmpService.find(empExample);
        PaserImportEmpExcelUtil.exportEmpList(emps, response);
    }

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据id删除人员信息", notes = "根据id删除人员信息")
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空")
    })
    @RequestMapping(value = "/removeById", method = RequestMethod.GET)
    public Result<String> removeById(@RequestParam(value = "id") String id) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ID, id);
        //2.数据处理
        GxqptEmp emp = new GxqptEmp();
        emp.setId(id);
        emp.setIsdelete(DELETE);
        Date nowDate = new Date();
        emp.setUpdateTime(nowDate);
        //3.数据操作
        int result = gxqptEmpService.updateByIdSelective(emp);
        if (result > 0) {
            //4.禁用删除用户登陆
            GxqptEmp tmp = gxqptEmpService.getById(id);
            User user = new User();
            user.setId(tmp.getGxqptEmpId());
            user.setLoginable(false);
            userService.updateByIdSelective(user);

            return Result.success("删除成功！");
        }

        return Result.fail("删除失败！");
    }

    /**
     * 查找字典获取民族
     *
     * @param typeCode
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 54000, message = "数据字典类型不能为空")
    })
    @RequestMapping(value = "/findDictionary", method = RequestMethod.GET)
    @ApiOperation(value = "根据typeCode查找字典,7：节点类型;8：单位归口;10：所属系统;11：所属业务系统;12：所属级别;13：所属类型，14：民族", notes = "根据typeCode查找字典")
    public Result<Map<Long, Map<String, String>>> findDictionary(@RequestParam(value = "typeCode[]") Long[] typeCode) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_NULL, typeCode);

        //获取基本信息
        String appId = BaseContextHandler.getAppId();

        //查询字典信息
        List<List<Dictionary>> list = dictionaryService.findByTypeId(appId, typeCode);

        //转换为map
        Map<Long, Map<String, String>> map = new HashMap<>();
        for (List<Dictionary> dictionarys : list) {
            if (dictionarys.size() > 0 && !map.containsKey(dictionarys.get(0).getDictionaryTypeCode())) {
                map.put(dictionarys.get(0).getDictionaryTypeId(), new LinkedHashMap<>());
            }
            for (Dictionary dictionary : dictionarys) {
                map.get(dictionary.getDictionaryTypeId()).put(dictionary.getCode(), dictionary.getName());
            }
        }
        return Result.success(map);
    }

    /**
     * 用户绑定
     *
     * @param empBindUserDTO
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56001, message = "人员ID为空"),
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56025, message = "用户id为空")
    })
    @ApiOperation(value = "用户绑定", notes = "用户绑定")
    @RequestMapping(value = "/saveEmpBindUser", method = RequestMethod.GET)
    public Result<String> saveEmpBindUser(GxqptEmpBindUserDTO empBindUserDTO) {
        Long adminId = BaseContextHandler.getAdminId();
        //1.数据校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_EMP_ID, empBindUserDTO.getId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, empBindUserDTO.getSystemCode());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_EMPBINDUSER, String.valueOf(empBindUserDTO.getUserId()));
        //2.判断
        if (CommonConstants.SYS_SDZZWW_CODE.equals(empBindUserDTO.getSystemCode())) {
            return Result.fail("不允许对电子政务用户进行绑定");
        }
        //3.操作
        GxqptEmp emp = new GxqptEmp();
        emp.setId(empBindUserDTO.getId());
        emp.setGxqptEmpId(empBindUserDTO.getUserId());
        emp.setUpdateTime(new Date());
        emp.setUpdateUser(String.valueOf(adminId));
        int result = gxqptEmpService.updateByIdSelective(emp);
        if (result > 0) {
            return Result.success("绑定成功!");
        }
        return Result.fail("绑定失败!");
    }

    /**
     * 查看用户绑定账号详情
     *
     * @param userId
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 56025, message = "用户id为空")
    })
    @ApiOperation(value = "查看用户绑定账号详情", notes = "查看用户绑定账号详情")
    @RequestMapping(value = "/getEmpBindUser", method = RequestMethod.GET)
    public Result<UserDto> getEmpBindUser(@RequestParam(value = "userId") String userId) {
        //1.校验
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_EMPBINDUSER, String.valueOf(userId));
        User user = userService.getById(Long.valueOf(userId));
        //2.转换
        if (user != null) {
            return Result.success(dozerUtils.map(user, UserDto.class));
        }
        return Result.fail("查询错误");
    }

    /**
     * 获取人员数据列表
     *
     * @param gxqptEmpDTO
     * @return
     */
    @Override
    @ApiOperation(value = "获取人员数据列表", notes = "获取人员数据列表")
    @RequestMapping(value = "/findEmpListBySelect", method = RequestMethod.POST)
    public Result<List<GxqptEmpRetDTO>> findEmpListBySelect(@RequestBody GxqptEmpDTO gxqptEmpDTO) {
        GxqptEmpExample empExample = new GxqptEmpExample();
        empExample.createCriteria().andIsdeleteEqualTo(UNDELETE)
                .andMaindeptidEqualTo(gxqptEmpDTO.getMaindeptid()).andMainorgidEqualTo(gxqptEmpDTO.getMainorgid());
        empExample.setOrderByClause("sortvalue asc");

        List<? extends SdzzwwEmp> list;
        if (CommonConstants.SYS_GXQPT_CODE.equals(gxqptEmpDTO.getSystemCode())) {
            list = gxqptEmpService.find(empExample);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(gxqptEmpDTO.getSystemCode())) {
            SdzzwwEmpExample sdzzwwEmpExample = new SdzzwwEmpExample();
            sdzzwwEmpExample.createCriteria().andIsdeleteEqualTo(UNDELETE)
                    .andMaindeptidEqualTo(gxqptEmpDTO.getMaindeptid()).andMainorgidEqualTo(gxqptEmpDTO.getMainorgid());
            sdzzwwEmpExample.setOrderByClause("sortvalue asc");
            list = sdzzwwEmpService.find(sdzzwwEmpExample);
        } else {
            list = new ArrayList<>();
        }
        List<GxqptEmpRetDTO> pageList = dozerUtils.mapPage(list, GxqptEmpRetDTO.class);
        return Result.success(pageList);
    }


    /**
     * 根据id设置人员身份
     *
     * @param identityDTO
     * @return
     */
    @Override
    @RequestMapping(value = "/settingIdentity", method = RequestMethod.POST)
    @ApiOperation(value = "根据id设置人员身份", notes = "根据id设置人员身份")
    @ApiResponses({
            @ApiResponse(code = 56000, message = "人员为空"),
            @ApiResponse(code = 56008, message = "单位id不能为空"),
            @ApiResponse(code = 56009, message = "单位名称不能为空"),

            @ApiResponse(code = 56011, message = "部门id不能为空"),
            @ApiResponse(code = 56012, message = "部门名称不能为空"),

            @ApiResponse(code = 56006, message = "岗位ID不能为空"),
            @ApiResponse(code = 56029, message = "岗位名称不能为空"),

            @ApiResponse(code = 56004, message = "职务ID不能为空"),
            @ApiResponse(code = 56030, message = "职务名称不能为空"),
    })
    public Result<GxqptEmpSettingIdentityDTO> saveSettingIdentity(@RequestBody GxqptEmpSettingIdentityDTO identityDTO) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, identityDTO);

        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_ID, identityDTO.getMainorgid());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_ORG_NAME, identityDTO.getMainorgname());

        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, identityDTO.getMaindeptid());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_NAME, identityDTO.getMaindeptname());

        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_ID_EMPTY, identityDTO.getMainpost());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_EMPTY_NAME, identityDTO.getMainpostname());

        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_ID_EMPTY, identityDTO.getMainduty());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DUTIES_NAME_EMPTY, identityDTO.getMainduty());

        //2.转换
        GxqptEmp emp = dozerUtils.map(identityDTO, GxqptEmp.class);
        //3.数据初始化
        emp.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        emp.setUpdateTime(nowDate);
        GxqptEmp oEmp = gxqptEmpService.getById(emp.getId());
        GxqptEmpIdentity oldIdentity = empIdentityService.getById(identityDTO.getIdentityId());
        emp.setDescrption(oldIdentity.getDescription());
        emp.setUserduty(oldIdentity.getUserduty());
        emp.setIsleader(oldIdentity.getIsleader());
        emp.setIsheader(oldIdentity.getIsheader());
        //4.数据操作
        int result = gxqptEmpService.updateByIdSelective(emp);
        if (result > 0) {
            //删除身份表数据
            empIdentityService.deleteById(identityDTO.getIdentityId());
            //将原有身份保存到身份表
            GxqptEmpIdentity identityback = new GxqptEmpIdentity();
            identityback.setUserId(oEmp.getId());
            identityback.setOrgId(oEmp.getMainorgid());
            identityback.setDeptId(oEmp.getMaindeptid());
            identityback.setDutyId(oEmp.getMainduty());
            identityback.setPostId(oEmp.getMainpost());
            identityback.setCreateTime(new Date());
            identityback.setUpdateTime(new Date());
            identityback.setUpdateUser(BaseContextHandler.getAdminId().toString());
            identityback.setCreateUser(BaseContextHandler.getAdminId().toString());
            identityback.setIsheader(oEmp.getIsheader());
            identityback.setIsleader(oEmp.getIsleader());
            identityback.setIsdelete(GxqptEmpIdentityConstant.FALSE);
            identityback.setIsenable(GxqptEmpIdentityConstant.FALSE);
            identityback.setDescription(oEmp.getDescrption());
            identityback.setUserduty(oEmp.getUserduty());
            empIdentityService.saveSelective(identityback);
            return Result.success(identityDTO);
        }
        return Result.fail("保存失败！");
    }

    @Override
    @ApiOperation(value = "禁用用户", notes = "禁用用户")
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56000, message = "人员为空")
    })
    public Result<String> updateDisable(@RequestParam(value = "ids[]") String[] ids) {
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, ids);
        int result = 0;
        //2.转换
        for (String id : ids) {
            GxqptEmp emp = new GxqptEmp();
            emp.setId(id);
            emp.setUpdateUser(BaseContextHandler.getAdminId().toString());
            //-1禁用
            emp.setIsenable(UNDELETE);
            Date nowDate = new Date();
            emp.setUpdateTime(nowDate);
            result += gxqptEmpService.updateByIdSelective(emp);
        }
        if (result > 0) {
            //禁用user
            List<User> listu = new ArrayList<>();
            GxqptEmpExample empExample = new GxqptEmpExample();
            empExample.createCriteria().andIdIn(Arrays.asList(ids));
            List<GxqptEmp> list = gxqptEmpService.find(empExample);
            list.forEach(emp -> {
                User user = new User();
                user.setId(emp.getGxqptEmpId());
                user.setLoginable(false);
                listu.add(user);
            });
            userService.updateByIdSelective(listu);
            return Result.success("禁用成功！");
        }
        return Result.fail("禁用失败！");
    }

    @Override
    @ApiOperation(value = "启用用户", notes = "启用用户")
    @RequestMapping(value = "/ennable", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56000, message = "人员为空")
    })
    public Result<String> updateEnnable(@RequestParam(value = "ids[]") String[] ids) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, ids);
        int result = 0;
        //2.转换
        for (String id : ids) {
            GxqptEmp emp = new GxqptEmp();
            emp.setId(id);
            emp.setUpdateUser(BaseContextHandler.getAdminId().toString());
            //1启用
            emp.setIsenable(DELETE);
            Date nowDate = new Date();
            emp.setUpdateTime(nowDate);
            result += gxqptEmpService.updateByIdSelective(emp);
        }
        if (result > 0) {
            //启用user
            List<User> listu = new ArrayList<>();
            GxqptEmpExample empExample = new GxqptEmpExample();
            empExample.createCriteria().andIdIn(Arrays.asList(ids));
            List<GxqptEmp> list = gxqptEmpService.find(empExample);
            list.forEach(emp -> {
                User user = new User();
                user.setId(emp.getGxqptEmpId());
                user.setLoginable(true);
                listu.add(user);
            });
            userService.updateByIdSelective(listu);
            return Result.success("启用用户成功！");
        }
        return Result.fail("启用用户失败！");
    }

    /**
     * 根据部门查询身份人员
     *
     * @param dpmId
     * @return
     */
    @Override
    @ApiOperation(value = "根据部门查询身份人员", notes = "根据部门查询身份人员")
    @RequestMapping(value = "/findEmpByDpm", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56011, message = "部门id不能为空")
    })
    public Result<List<GxqptEmpByDpmDTO>> findEmpByDpm(@RequestParam(value = "dpmId") String dpmId
            , @RequestParam(value = "systemCode") String systemCode) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, dpmId);
        if (!gxqptSystemService.isExistSystem(systemCode)) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.查询
        List res = dozerUtils.mapList(gxqptEmpService.findEmpByDpm(dpmId, systemCode), GxqptEmpByDpmDTO.class);
        return Result.success(res);
    }

    /**
     * 描述：查询gxqpt的所有人员
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/26
     * 修改内容：
     */
    @RequestMapping(value = "/getAllEmpUserGxqpt", method = RequestMethod.GET)
    @ApiOperation(value = "查询gxqpt的所有人员", notes = "查询gxqpt的所有人员")
    @Override
    @IgnoreToken
    public Result<List<SimpEmpDTO>> getAllEmpUserGxqpt() {
        List<GxqptEmpAndUserDO> empList = gxqptEmpService.findEmpListByOrgId(null, CommonConstants.SYS_GXQPT_CODE);
        List<SimpEmpDTO> resList = dozerUtils.mapList(empList, SimpEmpDTO.class);
        return Result.success(resList);
    }

    /**
     * 根据部门查询运维人员
     *
     * @param openApiReq
     * @return
     */
    @Override
    @RequestMapping(value = "/pageEmpListFroOperation", method = RequestMethod.POST)
    @ApiOperation(value = "根据部门查询运维人员", notes = "根据部门查询运维人员")
    public Result<PageInfo<GxqptEmpRetDTO>> pageEmpListFroOperation(@RequestBody OpenApiReq<GxqptEmpDTO> openApiReq) {
        GxqptEmpDTO gxqptEmpDTO = openApiReq.getData();
        //运维appid
        String appId = YW_APPID;
        //一般人员过滤
        String roleCode = YW_ROLE_CODE;
        if (gxqptEmpDTO.getMainorgid() == null || "".equals(gxqptEmpDTO.getMainorgid())) {
            return Result.success(new PageInfo<>(new ArrayList<>()));
        }

        //运维专用过滤
        EmpIdFroOperationDO empDo = dozerUtils.map(gxqptEmpDTO, EmpIdFroOperationDO.class);
        empDo.setIsdelete(UNDELETE);
        empDo.setTheAppId(appId);
        empDo.setTheCode(roleCode);
        //getEmpIdFroOperation
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        PageInfo<GxqptEmpRetDTO> pageList = new PageInfo<>(dozerUtils.mapPage(sdzzwwEmpService.findEmpIdFroOperation(empDo), GxqptEmpRetDTO.class));
        // PageInfo<WorkLogDTO> pageDTO = new PageInfo<>(dozerUtils.mapPage(pageList, WorkLogDTO.class));
        return Result.success(pageList);
    }

    /**
     * 根据部门查询身份用户
     *
     * @param dpmId
     * @return
     */
    @Override
    @ApiOperation(value = "根据部门查询身份用户", notes = "根据部门查询身份用户")
    @RequestMapping(value = "/findUserByDpm", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56011, message = "部门id不能为空")
    })
    public Result<List<GxqptUserByDpmDTO>> findUserByDpm(@RequestParam(value = "dpmId") String dpmId
            , @RequestParam(value = "systemCode") String systemCode) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_DPM_ID, dpmId);
        if (!gxqptSystemService.isExistSystem(systemCode)) {
            return Result.fail(AuthorityExceptionCode.SYSTEMCODE.getMsg());
        }

        //2.查询
        List res = dozerUtils.mapList(gxqptEmpService.findUserByDpm(dpmId, systemCode), GxqptUserByDpmDTO.class);
        return Result.success(res);
    }

    /**
     * 查询运维单位一共多少人
     *
     * @return
     */
    @Override
    @ApiOperation(value = "查询运维单位一共多少人", notes = "查询运维单位一共多少人")
    @RequestMapping(value = "/getOperationEmpNum", method = RequestMethod.GET)
    public Result<Map> getOperationEmpNum(@RequestParam(value = "orgId", required = false) String orgId) {
        //1.查询所有运维单位
//        GxqptOrgExample example = new GxqptOrgExample();
//        example.createCriteria().andForTypeEqualTo("ot_ywdw")
//                .andIsdeleteEqualTo(String.valueOf(DeleteStatus.UN_DELETE.getStatus()))
//                .andIsenableEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()))
//                .andOrgIdEqualTo(orgId);
//        GxqptOrg org = gxqptOrgService.getUnique(example);
//
//        //2.查询所有emp表的数据
//        GxqptEmpExample gxqptEmpExample = new GxqptEmpExample();
//        gxqptEmpExample.createCriteria().andMainorgidEqualTo(org.getId())
//                .andIsdeleteEqualTo(String.valueOf("0"))
//                .andIsenableEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
//        List emps = gxqptEmpService.find(gxqptEmpExample);
//
//        //3.查询所有身份表数据
//        GxqptEmpIdentityExample gxqptEmpIdentityExample = new GxqptEmpIdentityExample();
//        gxqptEmpIdentityExample.createCriteria().andOrgIdEqualTo(org.getId())
//                .andIsdeleteEqualTo(String.valueOf("0"))
//                .andIsenableEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
//        List empIdentitys = empIdentityService.find(gxqptEmpIdentityExample);

        EmpIdFroOperationDO empDo = new EmpIdFroOperationDO();
        empDo.setIsdelete(UNDELETE);
        empDo.setTheAppId(YW_APPID);
        empDo.setTheCode(YW_ROLE_CODE);
        empDo.setMainorgid(orgId);
        empDo.setSystemCode("gxqpt");

        //4.返回map
        Map<String, String> ret = new HashMap<>();
        List<GxqptEmpRetDTO> emps = dozerUtils.mapList(sdzzwwEmpService.findEmpIdFroOperation(empDo), GxqptEmpRetDTO.class);

        //5.查询运维单位
        ret.put("num", String.valueOf(emps.size()));
        return Result.success(ret);
    }

    /**
     * 邮件系统专用人员模糊查询
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "邮件系统专用人员模糊查询", notes = "邮件系统专用人员模糊查询")
    @RequestMapping(value = "/pageEmailEmpByDpm", method = RequestMethod.POST)
    public Result<PageInfo<GxqptEmpEmailLikeResDTO>> pageEmailEmpByDpm(@RequestBody OpenApiReq<GxqptEmpEmailLikeReqDTO> openApiReq) {
        //获取全体系
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = gxqptSystemService.find(systemExample);
        List systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());
        if (systemCodes.size() == 0) {
            return Result.success(new PageInfo(new ArrayList<>()));
        }

        //设置分页
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //获取全体系人员
        List rets = dozerUtils.mapPage(gxqptEmpService.findAllEmpBySystem(systemCodes,
                dozerUtils.map(openApiReq.getData(), EmpEmailLikeDO.class)), GxqptEmpEmailLikeResDTO.class);
        return Result.success(new PageInfo<>(rets));
    }

    /**
     * 全体系根据单位id查询人员
     *
     * @return
     */
    @Override
    @ApiOperation(value = "全体系根据单位id查询人员(带身份)", notes = "全体系根据单位id查询人员(带身份)")
    @RequestMapping(value = "/findEmpByOrgId", method = RequestMethod.POST)
    public Result<List<GxqptEmpRetDTO>> findEmpByOrgId(@RequestBody GxqptEmpfindByOrgIdDTO dto) {
        //获取数据
        List<String> orgIds = dto.getOrgIds();
        if (orgIds.size() == 0) {
            return Result.success(new ArrayList<>());
        }
        //获取全体系
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = gxqptSystemService.find(systemExample);
        List systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());
        if (systemCodes.size() == 0 || orgIds.size() == 0) {
            return Result.success(new ArrayList<>());
        }
        List list = gxqptEmpService.findEmpByOrgId(orgIds, systemCodes);

        return Result.success(dozerUtils.mapList(list, GxqptEmpRetDTO.class));
    }

    /**
     * 全体系根据用户id集合模糊查询人员
     *
     * @param dto
     * @return
     */
    @Override
    @ApiOperation(value = "全体系根据用户id集合模糊查询人员", notes = "全体系根据用户id集合模糊查询人员")
    @RequestMapping(value = "/findEmpByUserIds", method = RequestMethod.POST)
    public Result<PageInfo<GxqptEmpRetDTO>> findEmpByUserIds(@RequestBody GxqptEmpByUserNameDTO dto) {
        //获取全体系
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = gxqptSystemService.find(systemExample);
        List<String> systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());
        if (systemCodes.size() == 0) {
            return Result.success(new PageInfo<>());
        }
        PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        @SuppressWarnings("unchecked")
        List<GxqptEmpByUserIdsDO> list = gxqptEmpService.findEmpByUserIds(dozerUtils.map(dto, GxqptEmpByUserIdsDO.class), systemCodes);
        List<GxqptEmpRetDTO> result = dozerUtils.mapList(list, GxqptEmpRetDTO.class);
        return Result.success(new PageInfo<>(result));
    }

    /**
     * 全体系根据单位id集合查询用户
     *
     * @param dto
     * @return
     */
    @Override
    @ApiOperation(value = "全体系根据单位id集合查询用户", notes = "全体系根据单位id集合查询用户")
    @RequestMapping(value = "/findUserByOrgId", method = RequestMethod.POST)
    public Result<List<UserDto>> findUserByOrgId(@RequestBody GxqptEmpfindByOrgIdDTO dto) {
        //验证
        Result<List<GxqptEmpRetDTO>> empByOrgId = findEmpByOrgId(dto);
        if (empByOrgId.getData().size() == 0) {
            return Result.success(new ArrayList<>());
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(empByOrgId.getData().stream().map(GxqptEmpRetDTO::getGxqptEmpId).collect(Collectors.toList()));
        List<UserDto> res = dozerUtils.mapList(userService.find(userExample), UserDto.class);

        return Result.success(res);
    }

    /**
     * 根据登录user查询所有单位人员二层树
     *
     * @return
     */
    @Override
    @ApiOperation(value = "根据登录user查询所有单位人员二层树", notes = "根据登录user查询所有单位人员二层树")
    @RequestMapping(value = "/findOrgAddEmpByUser", method = RequestMethod.POST)
    public Result<List<GxqptOrgAddEmpResDTO>> findOrgAddEmpByUser() {
        //1.获取到登录用户信息
        Long userId = BaseContextHandler.getAdminId();

        //2.查出所有体系
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(userId);
        User user = userService.getUnique(example);

        //3.查询我所在单位
        List<GxqptOrgAddEmpResDTO> list = dozerUtils.mapList(gxqptOrgService
                .findOrgByUser(user.getOwnSystem(), userId), GxqptOrgAddEmpResDTO.class);
        List<String> orgIds = list.stream().map(GxqptOrgAddEmpResDTO::getId).collect(Collectors.toList());
        if (orgIds.size() == 0) {
            return Result.success(new ArrayList<>());
        }

        //4.查询这些单位的人
        List<GxqptEmpRetDTO> emps = dozerUtils.mapList(gxqptEmpService
                .findEmpsByOrgIds(orgIds, user.getOwnSystem()), GxqptEmpRetDTO.class);

        //5.把人员筛进单位
        list.forEach(org -> {
            org.setEmps(emps.stream()
                    .filter(emp -> emp.getMainorgid() != null && emp.getMainorgid().equals(org.getId()))
                    .collect(Collectors.toList()));
        });

        return Result.success(list);
    }

    /**
     * 全体系根据用户id集合模糊查询人员
     *
     * @param dto
     * @return
     */
    @Override
    @ApiOperation(value = "全体系根据用户id集合模糊查询人员 不需要 token", notes = "全体系根据用户id集合模糊查询人员 不需要 token")
    @RequestMapping(value = "/findEmpByUserIdsNoToken", method = RequestMethod.POST)
    @IgnoreToken
    public Result<PageInfo<GxqptEmpRetDTO>> findEmpByUserIdsNoToken(@RequestBody GxqptEmpByUserNameDTO dto) {
        //获取全体系
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = gxqptSystemService.find(systemExample);
        List<String> systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());
        if (systemCodes.size() == 0) {
            return Result.success(new PageInfo<>());
        }
        PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        @SuppressWarnings("unchecked")
        List<GxqptEmpByUserIdsDO> list = gxqptEmpService.findEmpByUserIds(dozerUtils.map(dto, GxqptEmpByUserIdsDO.class), systemCodes);
        List<GxqptEmpRetDTO> result = dozerUtils.mapList(list, GxqptEmpRetDTO.class);
        return Result.success(new PageInfo<>(result));
    }
}
