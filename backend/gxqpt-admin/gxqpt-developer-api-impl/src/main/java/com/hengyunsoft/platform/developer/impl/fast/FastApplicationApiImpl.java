package com.hengyunsoft.platform.developer.impl.fast;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.api.fast.api.FastApplicationApi;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.fast.po.ApplicationRelation;
import com.hengyunsoft.platform.developer.entity.fast.po.FastAppRelation;
import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.fast.example.ApplicationRelationExample;
import com.hengyunsoft.platform.developer.repository.fast.example.FastAppRelationExample;
import com.hengyunsoft.platform.developer.repository.fast.example.FastApplicationExample;
import com.hengyunsoft.platform.developer.repository.fast.service.ApplicationRelationService;
import com.hengyunsoft.platform.developer.repository.fast.service.FastAppRelationService;
import com.hengyunsoft.platform.developer.repository.fast.service.FastMenuService;
import com.hengyunsoft.platform.developer.utils.UUIDUtils;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "API - FastApplicationApiImpl", description = "快速应用服务管理")
@RestController
@RequestMapping("/fastapplication")
@Slf4j
public class FastApplicationApiImpl implements FastApplicationApi {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    IdGenerate<Long> idGenerate;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private FastMenuService fastMenuService;
    @Autowired
    private FastAppRelationService fastAppRelationService;
    @Autowired
    private ApplicationRelationService applicationRelationService;
    @Autowired
    private UserService userService;

    private static final String APPLICATION_TYPE = "application.type";

    /**
     * 描述：快速应用分页Api
     * 参数：[FastApplicationPageDTO：快速应用分页]
     * 返回值：<PageInfo<FastApplicationPageRetDTO>>
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "快速应用分页", notes = "快速应用分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<FastApplicationPageRetDTO>> page(@RequestBody OpenApiReq<FastApplicationPageDTO> openApiReq) {
        //1.获取基础数据
        Date endTime = null;
        Date startTime = null;
        Long userId = null;
        String name = null;
        String type = null;
        if(openApiReq.getData()!=null){
            if(StringUtils.isNotEmpty(openApiReq.getData().getCreateUser())){
                userId = Long.parseLong(openApiReq.getData().getCreateUser());
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getStartTime())){
                startTime = getDate(openApiReq.getData().getStartTime());
            }
            if(StringUtils.isNotEmpty(openApiReq.getData().getEndTime())){
                endTime = getDate(openApiReq.getData().getEndTime());
            }
             name = openApiReq.getData().getName();
             type = openApiReq.getData().getType();
        }
        //2.组装数据
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andTypeEqualTo(type).andCreateUserEqualTo(userId)
        .andIsFastAppEqualTo("Y")
        .andNameLike(FastApplicationExample.fullLike(name))
        .andCreateTimeBetween(startTime,endTime);
        example.setOrderByClause("id asc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询并返回
        return Result.success(new PageInfo<>(dozerUtils.mapPage(applicationService.find(example), FastApplicationPageRetDTO.class)));

    }

    /**
     * 描述：快速应用启用Api
     * 参数：FastApplicationStartUseDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "快速应用启用", notes = "快速应用启用")
    @ApiResponses({
            @ApiResponse(code = 78500, message = "我的快速应用ID不能为空"),
            @ApiResponse(code = 78501, message = "我的快速应用启用状态不能为空"),
    })
    @RequestMapping(value = "/startUse", method = RequestMethod.POST)
    public Result<Boolean> startUse(@RequestBody FastApplicationStartUseDTO dto) {

        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_APPLICATION_ID_NULL, dto.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_APPLICATION_STATUS_NULL, dto.getStatus());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        Application app = dozerUtils.map(dto, Application.class);
        app.setUpdateUser(userId);
        app.setUpdateTime(date);

        //4、修改
        applicationService.updateByIdSelective(app);
        return Result.success(true);
    }

    /**
     * 描述：快速应用更新Api
     * 参数：FastApplicationUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @ApiOperation(value = "快速应用更新", notes = "快速应用更新")
    @ApiResponses({
            @ApiResponse(code = 78500, message = "我的快速应用ID不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody FastApplicationUpdateDTO dto) {

        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_APPLICATION_ID_NULL, dto.getId());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();

        //3、转换并赋初值
        Application app = dozerUtils.map(dto, Application.class);
        app.setUpdateUser(userId);
        app.setUpdateTime(new Date());

        //4、修改
        applicationService.updateByIdSelective(app);

        //删除关联表fastAppRelation
        FastAppRelationExample example = new FastAppRelationExample();
        example.createCriteria().andAppIdEqualTo(dto.getAppId());
        List<FastAppRelation> fastAppRelationList = fastAppRelationService.find(example);
        for(FastAppRelation currObj:fastAppRelationList){
            fastAppRelationService.deleteById(currObj.getId());
        }
        //删除已添加菜单
        fastMenuService.deleteByAppId(dto.getAppId());

        List<String> selectMenuAppId = dto.getSelectMenuAppId();
        List<String> selectAppId = dto.getSelectAppId();
        for(String currAppId:selectMenuAppId){
            addAppSaveOrMenu(currAppId,dto.getAppId(),userId,dto.getBizConfigId(),true);
        }
        for(String currAppId:selectAppId){
            addAppSaveOrMenu(currAppId,dto.getAppId(),userId,dto.getBizConfigId(),false);
        }
        return Result.success(true);
    }

    /**
     * 描述：根据id查询快速应用详情Api
     * 参数：id
     * 返回值：FastApplicationDetailDTO
     * 修改人：wt
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据id查询快速应用详情", notes = "根据id查询快速应用详情")
    @ApiResponses({

    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Result<ResponseApplicationDetailDTO> getById(@RequestParam Long id) {
        Application application = applicationService.getById(id);
        if(application == null){
            return null;
        }
        FastAppRelationExample example = new FastAppRelationExample();
        example.createCriteria().andAppIdEqualTo(application.getAppId());
        List<FastAppRelation> fastAppRelationList = fastAppRelationService.find(example);
        ResponseApplicationDetailDTO resultApplication = dozerUtils.map(application,ResponseApplicationDetailDTO.class);
        User user = userService.getById(application.getCreateUser());
        resultApplication.setUserName(user.getName());

        List<Dictionary> dictionaryList = dictionaryService.findByTypeCode(APPLICATION_TYPE);
        List<ResponseDictionaryDTO> rdList = new ArrayList<ResponseDictionaryDTO>();
        for (Dictionary dictionary:dictionaryList){
            ResponseDictionaryDTO responseDictionaryDTO = new ResponseDictionaryDTO();
            String code = dictionary.getCode();
            responseDictionaryDTO.setCode(code);
            responseDictionaryDTO.setName(dictionary.getName());
            List<ResponseApplicationDetailDTO> list = new ArrayList<ResponseApplicationDetailDTO>();
            for (FastAppRelation fastAppRelation:fastAppRelationList){
                String type = fastAppRelation.getType();
                String fastAppId = fastAppRelation.getFastAppId();
                if(code.equals(type)){
                    ResponseApplicationDetailDTO appRelationObj = dozerUtils.map(fastAppRelation,ResponseApplicationDetailDTO.class);
                    appRelationObj.setName(getApplicationName(fastAppId));
                    list.add(appRelationObj);
                }
            }
            responseDictionaryDTO.setApplication(list);
            rdList.add(responseDictionaryDTO);
        }
        resultApplication.setApplication(rdList);
        return Result.success(resultApplication);
    }
    @ApiOperation(value = "根据id查询快速应用详情", notes = "根据id查询快速应用详情")
    @ApiResponses({

    })
    @RequestMapping(value = "/detailByAppId", method = RequestMethod.GET)
    public Result<ResponseApplicationDetailDTO> detailByAppId(@RequestParam(value = "appId") String appId) {
        ApplicationExample appExample = new ApplicationExample();
        appExample.createCriteria().andAppIdEqualTo(appId);
        Application application = applicationService.getUnique(appExample);
        if(application == null){
            return Result.success(null);
        }
        FastAppRelationExample example = new FastAppRelationExample();
        example.createCriteria().andAppIdEqualTo(application.getAppId());
        List<FastAppRelation> fastAppRelationList = fastAppRelationService.find(example);
        ResponseApplicationDetailDTO resultApplication = dozerUtils.map(application,ResponseApplicationDetailDTO.class);
        User user = userService.getById(application.getCreateUser());
        resultApplication.setUserName(user.getName());

        List<Dictionary> dictionaryList = dictionaryService.findByTypeCode(APPLICATION_TYPE);
        List<ResponseDictionaryDTO> rdList = new ArrayList<ResponseDictionaryDTO>();
        for (Dictionary dictionary:dictionaryList){
            ResponseDictionaryDTO responseDictionaryDTO = new ResponseDictionaryDTO();
            String code = dictionary.getCode();
            responseDictionaryDTO.setCode(code);
            responseDictionaryDTO.setName(dictionary.getName());
            List<ResponseApplicationDetailDTO> list = new ArrayList<ResponseApplicationDetailDTO>();
            for (FastAppRelation fastAppRelation:fastAppRelationList){
                String type = fastAppRelation.getType();
                String fastAppId = fastAppRelation.getFastAppId();
                if(code.equals(type)){
                    ResponseApplicationDetailDTO appRelationObj = dozerUtils.map(fastAppRelation,ResponseApplicationDetailDTO.class);
                    appRelationObj.setName(getApplicationName(fastAppId));
                    list.add(appRelationObj);
                }
            }
            responseDictionaryDTO.setApplication(list);
            rdList.add(responseDictionaryDTO);
        }
        resultApplication.setApplication(rdList);
        return Result.success(resultApplication);
    }

    //获取应用名称
    public String getApplicationName(String fastAppId){
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andIsFastAppEqualTo("N").andAppIdEqualTo(fastAppId);
        Application application = applicationService.getUnique(example);
        return application.getName();
    }

    /**
     * 描述：新增应用服务
     * 参数：RequestApplicationSaveDTO
     * 返回值：Result<Boolean>
     * 修改人：wt
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @Override
    @ApiResponses({ })
    @ApiOperation(value = "新增应用服务", notes = "新增应用服务")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody RequestApplicationSaveDTO dto) {
        //appId
        String appId = UUIDUtils.generateShortUuid();
        if(checkAppId(appId)){
            return Result.fail("AppId错误");
        }
        Long loginUser = BaseContextHandler.getAdminId();
        Application application = new Application();
        application.setId(idGenerate.generate());
        application.setAppId(appId);
        application.setAppSecret(UUIDUtils.generateUuid());
        application.setBizConfigId(dto.getBizConfigId());
        //拼装首页地址/gxqpt-fast/fast/{APP_ID}
        application.setIndexUrl("/gxqpt-fast/fast/"+appId);
        application.setLogoUrl(dto.getLogoUrl());
        application.setHotsCount(dto.getHotsCount());
        application.setName(dto.getName());
        application.setDesc(dto.getDesc());
        //application.setType(dto.getBizConfigId().toString());
        application.setType("jryy");
        application.setAppType((short) 1);
        application.setIsFastApp("Y");
        application.setCreateUser(loginUser);
        application.setCreateTime(new Date());
        application.setReduceTime(0d);
        application.setReduceCost(0);
        application.setOriginalTime(0d);
        application.setOriginalCost(0);
        application.setPublicIs(false);
        applicationService.saveSelective(application);
        List<String> selectMenuAppId = dto.getSelectMenuAppId();
        List<String> selectAppId = dto.getSelectAppId();
        for(String currAppId:selectMenuAppId){
            addAppSaveOrMenu(currAppId,appId,loginUser,dto.getBizConfigId(),true);
        }
        for(String currAppId:selectAppId){
            addAppSaveOrMenu(currAppId,appId,loginUser,dto.getBizConfigId(),false);
        }
        return Result.success(true);
    }

    private void addAppSaveOrMenu(String currAppId,String appId,Long loginUser,Long bizConfigId,Boolean type){
        //查询对应appId类型
        ApplicationExample applicationExample = new ApplicationExample();
        applicationExample.createCriteria().andAppIdEqualTo(currAppId).andIsFastAppEqualTo("N");
        Application curApplistion = applicationService.getUnique(applicationExample);
        //保存关联系统关系
        FastAppRelation fastAppRelation = new FastAppRelation();
        fastAppRelation.setFastAppId(currAppId);
        fastAppRelation.setAppId(appId);
        fastAppRelation.setType(curApplistion.getType());
        fastAppRelation.setCreateUser(loginUser);
        fastAppRelation.setCreateTime(new Date());
        fastAppRelationService.saveSelective(fastAppRelation);
        if(type){
            //保存菜单
            Application appMsg = getMsgByAppId(currAppId);
            FastMenu fastMenu = new FastMenu();
            fastMenu.setAppId(appId);
            fastMenu.setCode(currAppId);//所选子appId
            fastMenu.setbFastBizConfig(bizConfigId);
            fastMenu.setName(appMsg.getName());
            fastMenu.setDesc(appMsg.getDesc());
            fastMenu.setParentId(new Long(1));
            fastMenu.setUrl(appMsg.getIndexUrl());
            fastMenuService.saveSelective(fastMenu);
        }
    }

    /**
     * 描述：查询所有应用、服务、模块、平台信息
     * 参数：
     * 返回值：ResponseApplicationDetailDTO
     * 修改人：wt
     * 修改时间：2018/5/4
     * 修改内容：
     */
    @Override
    @ApiResponses({ })
    @ApiOperation(value = "查询所有应用、服务、模块、平台信息", notes = "查询所有应用、服务、模块、平台信息")
    @RequestMapping(value = "/findAllApp", method = RequestMethod.POST)
    public Result<ResponseApplicationDetailDTO> findAllApplicaton() {
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andAppIdIsNotNull().andIsFastAppEqualTo("N");
        List<Application> applicationList = applicationService.find(example);
        ResponseApplicationDetailDTO resultApplication = new ResponseApplicationDetailDTO();

        List<Dictionary> dictionaryList = dictionaryService.findByTypeCode(APPLICATION_TYPE);
        List<ResponseDictionaryDTO> rdList = new ArrayList<ResponseDictionaryDTO>();
        for (Dictionary dictionary:dictionaryList){
            ResponseDictionaryDTO responseDictionaryDTO = new ResponseDictionaryDTO();
            String code = dictionary.getCode();
            responseDictionaryDTO.setCode(code);
            responseDictionaryDTO.setName(dictionary.getName());
            List<ResponseApplicationDetailDTO> list = new ArrayList<ResponseApplicationDetailDTO>();
            for (Application application:applicationList){
                String type = application.getType();
                if(code.equals(type)){
                    list.add(dozerUtils.map(application,ResponseApplicationDetailDTO.class));
                }
            }
            responseDictionaryDTO.setApplication(list);
            rdList.add(responseDictionaryDTO);
        }
        resultApplication.setApplication(rdList);
        return Result.success(resultApplication);
    }

    /**
     * 描述：根据appid查询关联的服务、模块信息
     * 参数：appId
     * 返回值：ResponseApplicationDetailDTO
     * 修改人：wt
     * 修改时间：2018/5/4
     * 修改内容：
     */
    @Override
    @ApiResponses({ })
    @ApiOperation(value = "根据appid查询关联的服务、模块信息", notes = "根据appid查询关联的服务、模块信息")
    @RequestMapping(value = "/findAppRelation", method = RequestMethod.POST)
    public Result<ResponseApplicationDetailDTO> findApplicationRelation(String appId) {
        ApplicationRelationExample example = new ApplicationRelationExample();
        example.createCriteria().andAppIdEqualTo(appId);
        List<ApplicationRelation> applicationRelationList = applicationRelationService.find(example);
        ResponseApplicationDetailDTO resultApplication = new ResponseApplicationDetailDTO();

        List<Dictionary> dictionaryList = dictionaryService.findByTypeCode(APPLICATION_TYPE);
        List<ResponseDictionaryDTO> rdList = new ArrayList<ResponseDictionaryDTO>();
        for (Dictionary dictionary:dictionaryList){
            ResponseDictionaryDTO responseDictionaryDTO = new ResponseDictionaryDTO();
            String code = dictionary.getCode();
            responseDictionaryDTO.setCode(code);
            responseDictionaryDTO.setName(dictionary.getName());
            List<ResponseApplicationDetailDTO> list = new ArrayList<ResponseApplicationDetailDTO>();
            for (ApplicationRelation applicationRelation:applicationRelationList){
                String type = applicationRelation.getType();
                if(code.equals(type)){
                    list.add(dozerUtils.map(applicationRelation,ResponseApplicationDetailDTO.class));
                }
            }
            responseDictionaryDTO.setApplication(list);
            rdList.add(responseDictionaryDTO);
        }
        resultApplication.setApplication(rdList);
        return Result.success(resultApplication);
    }

    /**
     * 校验生成的AppId是否重复
     * @param appId
     * @return
     */
    private Boolean checkAppId(String appId){
        ApplicationExample example = new ApplicationExample();
        example.createCriteria().andAppIdEqualTo(appId);
        Integer count =  applicationService.count(example);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据appId获取应用信息
     * @param  appId
     *
     */
    private Application getMsgByAppId(String appId){
        return applicationService.getMsgByAppId(appId);
    }

    /**
     * 获取日期
     * @param  dateStr
     *
     */
    private Date getDate(String dateStr){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            log.info("Exception",e);
        }
        return  date;
    }

}
