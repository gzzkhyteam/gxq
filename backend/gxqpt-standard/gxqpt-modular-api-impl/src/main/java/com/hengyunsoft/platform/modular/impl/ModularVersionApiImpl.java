package com.hengyunsoft.platform.modular.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.StandardExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgPolyResDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.modular.config.NexusConfig;
import com.hengyunsoft.platform.modular.dto.CompanyInfoDTO;
import com.hengyunsoft.platform.modular.dto.ModularDTO;
import com.hengyunsoft.platform.modular.dto.ModularVersionDTO;
import com.hengyunsoft.platform.modular.dto.ModularVersionPageDTO;
import com.hengyunsoft.platform.modular.dto.ModularVersionQueryDTO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularVersionDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularVersionPage;
import com.hengyunsoft.platform.modular.entity.modular.po.Modular;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularCategory;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularTag;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularVersion;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularVersionExample;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryService;
import com.hengyunsoft.platform.modular.repository.service.ModularService;
import com.hengyunsoft.platform.modular.repository.service.ModularTagService;
import com.hengyunsoft.platform.modular.repository.service.ModularVersionService;
import com.hengyunsoft.platform.modular.utils.FileUtil;
import com.hengyunsoft.platform.modular.utils.HttpUtil;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.CookieStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhoukx
 * @createTime 2018-3-28
 */
@RestController
@Slf4j
@Api(value = "API - ModularVersionApiImpl", description = "模块版本管理")
public class ModularVersionApiImpl /*implements ModularVersionApi */ {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ModularService modularService;
    @Autowired
    private ModularVersionService modularVersionService;
    @Autowired
    private NexusConfig nexusConfig;
    @Autowired
    private ModularCategoryService modularCategoryService;
    @Autowired
    private ModularTagService modularTagService;
    @Autowired
    private GxqptOrgOpenApi gxqptOrgOpenApi;

    @Value("${spring.profiles.active}")
    private String profiles;

    /**
     * 根据id 查看版本详情
     *
     * @param id 模块版本id
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @RequestMapping(value = "/version/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据id 查看版本详情", notes = "根据id 查看版本详情")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
    })
    public Result<ModularVersionDTO> get(@RequestParam Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        ModularVersion modularVersion = modularVersionService.getById(id);

        if (modularVersion == null) {
            return Result.fail("未找到要处理的数据，id：" + id);
        }
        //根据id获得相应的版本信息
        ModularVersionDO modularVersionDO = modularVersionService.getModularVersionById(id);

        //调用nexus接口查询相应文件的下载路径
        JSONArray jSONArray = getVersionArray(modularVersion);
        if (jSONArray == null) {
            return Result.fail("查询失败");
        }
        //通过调用nexus接口查询出要删除的文件id
        String downloadUrl = jSONArray.getJSONObject(0).getString("downloadUrl");
        //对查询返回的url进行处理
        String serverUrl = nexusConfig.getServerUrl();
        int i = downloadUrl.indexOf("8081");
        downloadUrl = downloadUrl.substring(i + 4, downloadUrl.length());
        downloadUrl = serverUrl + downloadUrl;
        if ("prod".equals(profiles)) {
            downloadUrl = downloadUrl.replaceAll("http://192.168.30.151:8081", "http://127.0.0.1:10086");
        } else if ("demo".equals(profiles)) {
            downloadUrl = downloadUrl.replaceAll("http://192.168.30.83:8081", "http://127.0.0.1:10087");
        }

        modularVersionDO.setDownloadUrl(downloadUrl);
        modularVersionDO.setCreateCompanyName(modularVersion.getCreateCompanyName());
        return Result.success(dozerUtils.map(modularVersionDO, ModularVersionDTO.class));
    }

    /**
     * jar包列表分页查询
     * 分页查询指定模块的jar包
     *
     * @param openApiReq
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @RequestMapping(value = "/version/pageModularJar", method = RequestMethod.POST)
    @ApiOperation(value = "jar包列表分页查询", notes = "分页查询指定模块的jar包")
    public Result<PageInfo<ModularVersionDTO>> pageModularJar(@RequestBody OpenApiReq<ModularVersionQueryDTO> openApiReq) {
        ModularVersionQueryDTO data = openApiReq.getData();
        ModularVersionExample example = new ModularVersionExample();
        if (data != null) {
            example.createCriteria()
                    .andRepNameEqualTo(data.getRepName())
                    .andGroupIdEqualTo(data.getGroupId())
                    .andArtifactIdEqualTo(data.getArtifactId());
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ModularVersionDO> lists = modularVersionService.pageModularJar(example);
        List<ModularVersionDTO> pageList = dozerUtils.mapPage(lists, ModularVersionDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * jar包列表分页查询
     * 分页查询jar包
     *
     * @param openApiReq
     * @createTime 2018-4-16
     * @author zhoukx
     */
    @RequestMapping(value = "/version/pageJar", method = RequestMethod.POST)
    @ApiOperation(value = "版本列表查询", notes = "分页查询jar包")
    public Result<PageInfo<ModularVersionDTO>> pageJar(@RequestBody OpenApiReq<ModularVersionPageDTO> openApiReq) {

        ModularVersionPageDTO data = openApiReq.getData();
        ModularVersionPage modularVersionPage = new ModularVersionPage();
        if (data != null) {
            modularVersionPage.setRepName(data.getRepName());
            modularVersionPage.setModularName(data.getModularName());
            modularVersionPage.setGroupId(data.getGroupId());
            modularVersionPage.setArtifactId(data.getArtifactId());
            modularVersionPage.setVersion(data.getVersion());
            modularVersionPage.setDescription(data.getDescription());

        }

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ModularVersionDO> lists = modularVersionService.pageJar(modularVersionPage);
        List<ModularVersionDTO> pageList = dozerUtils.mapPage(lists, ModularVersionDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 获取登录人的单位信息
     */
    @RequestMapping(value = "/version/findPoly", method = RequestMethod.GET)
    public Result<List<CompanyInfoDTO>> findPolyByUser() {
        Long adminId = BaseContextHandler.getAdminId();
        List<CompanyInfoDTO> companyInfoDTOList = new ArrayList<CompanyInfoDTO>();
        Result<List<GxqptOrgPolyResDTO>> GxqptOrgPolyResDTOResult = gxqptOrgOpenApi.pagePolyByUser(adminId);
        if (GxqptOrgPolyResDTOResult.getData() != null && GxqptOrgPolyResDTOResult.getData().size() > 0) {
            List<GxqptOrgPolyResDTO> polyList = GxqptOrgPolyResDTOResult.getData();
            for (GxqptOrgPolyResDTO gxqptOrgPolyResDTO : polyList) {
                CompanyInfoDTO companyInfoDTO = new CompanyInfoDTO();
                companyInfoDTO.setCompanyId(gxqptOrgPolyResDTO.getId());
                companyInfoDTO.setCompanyName(gxqptOrgPolyResDTO.getName());
                companyInfoDTOList.add(companyInfoDTO);
            }
        } else {
            log.error("未能获取到登录人的单位信息");
        }
        return Result.success(companyInfoDTOList);
    }

    /**
     * jar包版本更新
     *
     * @param file    上传的文件
     * @param request
     * @createTime 2018-4-18
     * @author zhoukx
     */
    @RequestMapping(value = "/version/upload", method = RequestMethod.POST)
    @ApiOperation(value = "jar包版本更新", notes = "jar包版本更新")
    @ApiResponses({
            @ApiResponse(code = 36004, message = "groupId为空"),
            @ApiResponse(code = 36005, message = "artifactId为空"),
            @ApiResponse(code = 36502, message = "jar包版本为空"),
            @ApiResponse(code = 36503, message = "jar文件为空"),
    })
    public Result<ModularDTO> updateVersion(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {

        //获取表单提交的数据
        String repName = request.getParameter("repName");//仓库名称
        String groupId = request.getParameter("groupId");//groupId
        String artifactId = request.getParameter("artifactId");//artifactId
        String version = request.getParameter("version");//模块版本
        String classifier = request.getParameter("classifier");//jar包类型
        String createCompanyId = request.getParameter("createCompanyId");//单位Id
        String createCompanyName = request.getParameter("createCompanyName");//单位名称

        //1，验证
        BizAssert.assertNotEmpty(StandardExceptionCode.REPOSITORY_NAME_EMPTY, repName);//仓库名称
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_GROUPID_EMPTY, groupId);//groupId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_ARTIFACTID_EMPTY, artifactId);//artifactId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_VERSION_EMPTY, version);//模块版本
        BizAssert.assertNotNull(StandardExceptionCode.MODULAR_JAR_FILE_EMPTY, file);//模块jar文件

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        if (classifier.equals("jar")) {
            classifier = "";
        }
        //验证上传的文件否已存在
        ModularVersionExample example = new ModularVersionExample();
        example.createCriteria()
                .andGroupIdEqualTo(groupId)
                .andArtifactIdEqualTo(artifactId)
                .andVersionEqualTo(version)
                .andClassifierEqualTo(classifier);

        int i = modularVersionService.count(example);
        if (i > 0) {//如果版本已存在则不能上传。
            return Result.fail("文件已存在");
        }
        //判断模块在数据库中是否存在，存在的不进行创建操作
        Modular md = new Modular();
        md.setRepName(repName);
        md.setGroupId(groupId);
        md.setArtifactId(artifactId);

        Modular modular = modularService.getModularByRepNameAndGidAndAid(md);
        if (modular == null) {
            return Result.fail("模块不存在,更新jar包失败");
        }
        //MultipartFile类型转为File类型
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        String deletePath = request.getSession().getServletContext().getRealPath("/");
        File tempFile = FileUtil.saveFile(file, filePath);
        //构建往nexus服务器上上传时所需要的参数
        Map<String, String> params = new HashMap<String, String>();
        if (StringUtil.isNotEmpty(groupId)) {
            params.put("maven2.groupId", groupId);//groupId
        }
        if (StringUtil.isNotEmpty(artifactId)) {
            params.put("maven2.artifactId", artifactId);//artifactId
        }
        if (StringUtil.isNotEmpty(version)) {
            params.put("maven2.version", version);//version
        }
        if (StringUtil.isNotEmpty(classifier) && !classifier.equals("jar")) {
            params.put("maven2.asset1.classifier", classifier);
            String fileName = tempFile.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            params.put("maven2.asset1.extension", suffix);
        } else {
            params.put("maven2.asset1.extension", "jar");
        }

        //从配置文件中读取nexus的服务请求地址
        String serverUrl = nexusConfig.getServerUrl();
        String username = nexusConfig.getUsername();
        String password = nexusConfig.getPassword();

        //构建nexus获取认证信息的请求url
        String getCookieStoreUrl = serverUrl + "/service/rapture/session";
        //通过url 用户名 密码 获取认证信息
        CookieStore cookieStore = HttpUtil.getCookieStore(getCookieStoreUrl, username, password);
        String uploadUrl = serverUrl + "/service/rest/beta/components?repository=" + repName;
        try {
            Boolean flag = HttpUtil.uploadToResp(cookieStore, uploadUrl, tempFile, params);
            if (!flag) {
                log.error("jar包上传时出错");
                return Result.fail("jar包上传时出错");
            }
            if (StringUtil.isNotEmpty(deletePath)) {
                FileUtil.deleteDirectory(deletePath);//删除临时文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //保存信息到版本
        ModularVersion modularVersion = new ModularVersion();
        modularVersion.setRepName(repName);
        modularVersion.setGroupId(groupId);
        modularVersion.setArtifactId(artifactId);
        modularVersion.setVersion(version);
        if (!classifier.equals("jar")) {
            modularVersion.setClassifier(classifier);
        }
        modularVersion.setCreateCompanyId(Long.parseLong(createCompanyId));
        modularVersion.setCreateCompanyName(createCompanyName);
        modularVersion.setUpdateTime(Calendar.getInstance().getTime());
        modularVersion.setUpdateUser(adminId);
        modularVersion.setUpdateUserName(userName);
        modularVersion = modularVersionService.save(modularVersion);
        return Result.success(dozerUtils.map(modularVersion, ModularDTO.class));
    }


    /**
     * 发布版本
     *
     * @param file    上传的文件，单文件上传
     * @param request
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @RequestMapping(value = "/version/uploads", method = RequestMethod.POST)
    @ApiOperation(value = "发布版本", notes = "发布版本")
    @ApiResponses({
            @ApiResponse(code = 36501, message = "仓库名称为空"),
            @ApiResponse(code = 36001, message = "模块名称为空"),
            @ApiResponse(code = 36004, message = "groupId为空"),
            @ApiResponse(code = 36005, message = "artifactId为空"),
            @ApiResponse(code = 36504, message = "版本类型为空"),
            @ApiResponse(code = 36502, message = "jar包版本为空"),
            @ApiResponse(code = 36006, message = "模块描述为空"),
            @ApiResponse(code = 36503, message = "jar文件为空"),
    })
    public Result<ModularDTO> upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        //获取表单提交的数据
        String repName = request.getParameter("repName");//仓库名称
        String modularName = request.getParameter("modularName");//模块名称
        String modularCategorys[] = request.getParameterValues("modularCategory");//模块分类
        String modularTags[] = request.getParameterValues("modularTag");//模块标签
        String groupId = request.getParameter("groupId");//groupId
        String artifactId = request.getParameter("artifactId");//artifactId
        String version = request.getParameter("version");//模块版本
        String description = request.getParameter("description");//模块描述
        String classifier = request.getParameter("classifier");//jar包类型
        String createCompanyId = request.getParameter("createCompanyId");//单位Id
        String createCompanyName = request.getParameter("createCompanyName");//单位名称

        //验证表单数据
        BizAssert.assertNotEmpty(StandardExceptionCode.REPOSITORY_NAME_EMPTY, repName);//仓库名称
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_NAME_EMPTY, modularName);//模块名称
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_GROUPID_EMPTY, groupId);//groupId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_ARTIFACTID_EMPTY, artifactId);//artifactId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_VERSION_EMPTY, version);//模块版本
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_CLASSIFIER_EMPTY, classifier);//版本类型
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_DESCRIPTION_EMPTY, description);//模块描述
        BizAssert.assertNotNull(StandardExceptionCode.MODULAR_JAR_FILE_EMPTY, file);//模块jar文件

        if (classifier.equals("jar")) {//jar包类型为jar时，存到数据库为""
            classifier = "";
        }
        //验证上传的文件否已存在
        ModularVersionExample example = new ModularVersionExample();
        example.createCriteria()
                .andGroupIdEqualTo(groupId)
                .andArtifactIdEqualTo(artifactId)
                .andVersionEqualTo(version)
                .andClassifierEqualTo(classifier);

        int i = modularVersionService.count(example);

        if (i > 0) {//如果版本已存在则不能上传。
            return Result.fail("文件已存在");
        }
        //获取登录人信息
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        //MultipartFile类型转为File类型
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        String deletePath = request.getSession().getServletContext().getRealPath("/");
        File tempFile = FileUtil.saveFile(file, filePath);

        //构建往nexus服务器上上传时所需要的参数
        Map<String, String> params = new HashMap<String, String>();
        if (StringUtil.isNotEmpty(groupId)) {
            params.put("maven2.groupId", groupId);//groupId
        }
        if (StringUtil.isNotEmpty(artifactId)) {
            params.put("maven2.artifactId", artifactId);//artifactId
        }
        if (StringUtil.isNotEmpty(version)) {
            params.put("maven2.version", version);//version
        }
        if (StringUtil.isNotEmpty(classifier) && !classifier.equals("jar")) {
            params.put("maven2.asset1.classifier", classifier);
            String fileName = tempFile.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            params.put("maven2.asset1.extension", suffix);
        } else {
            params.put("maven2.asset1.extension", "jar");
        }

        //从配置文件中读取nexus的服务请求地址
        String serverUrl = nexusConfig.getServerUrl();
        String username = nexusConfig.getUsername();
        String password = nexusConfig.getPassword();

        //构建nexus获取认证信息的请求url
        String getCookieStoreUrl = serverUrl + "/service/rapture/session";
        //通过url 用户名 密码 获取认证信息
        CookieStore cookieStore = HttpUtil.getCookieStore(getCookieStoreUrl, username, password);
        String uploadUrl = serverUrl + "/service/rest/beta/components?repository=" + repName;
        try {
            boolean flag = HttpUtil.uploadToResp(cookieStore, uploadUrl, tempFile, params);
            if (!flag) {
                log.error("jar包上传时出错");
                return Result.fail("jar包上传时出错");
            }
            if (StringUtil.isNotEmpty(deletePath)) {
                FileUtil.deleteDirectory(deletePath);//删除临时文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //判断模块在数据库中是否存在，存在的不进行创建操作
        Modular md = new Modular();
        md.setRepName(repName);
        md.setGroupId(groupId);
        md.setArtifactId(artifactId);
        Modular modular = modularService.getModularByRepNameAndGidAndAid(md);
        if (modular == null) {
            //保存信息到模块
            Modular mod = new Modular();
            mod.setRepName(repName);
            mod.setModularName(modularName);
            mod.setGroupId(groupId);
            mod.setArtifactId(artifactId);
            mod.setDescription(description);
            mod.setCreateCompanyId(Long.parseLong(createCompanyId));
            mod.setCreateCompanyName(createCompanyName);
            mod.setCreateTime(Calendar.getInstance().getTime());
            mod.setCreateUser(adminId);
            mod.setCreateUserName(userName);

            mod = modularService.save(mod);

            //将分类数组循环插入到模块和标签的关联表中
            if (modularCategorys != null) {
                for (int j = 0; j < modularCategorys.length; j++) {
                    ModularCategory modCategory = new ModularCategory();
                    modCategory.setModularId(mod.getId());
                    modCategory.setCategoryId(Long.parseLong(modularCategorys[j]));
                    modCategory.setCreateTime(Calendar.getInstance().getTime());
                    modularCategoryService.save(modCategory);
                }
            }
            //将标签数组循环插入到模块和标签的关联表中
            if (modularTags != null) {
                for (int j = 0; j < modularTags.length; j++) {
                    ModularTag modTag = new ModularTag();
                    modTag.setModularId(mod.getId());
                    modTag.setTagId(Long.parseLong(modularTags[j]));
                    modTag.setCreateTime(Calendar.getInstance().getTime());

                    modularTagService.save(modTag);
                }
            }
        }
        //保存信息到版本
        ModularVersion modularVersion = new ModularVersion();
        modularVersion.setRepName(repName);
        modularVersion.setGroupId(groupId);
        modularVersion.setArtifactId(artifactId);
        modularVersion.setVersion(version);
        if (!classifier.equals("jar")) {
            modularVersion.setClassifier(classifier);
        } else {
            modularVersion.setClassifier("");
        }
        modularVersion.setCreateCompanyId(Long.parseLong(createCompanyId));
        modularVersion.setCreateCompanyName(createCompanyName);
        modularVersion.setCreateTime(Calendar.getInstance().getTime());
        modularVersion.setCreateUser(adminId);
        modularVersion.setCreateUserName(userName);
        modularVersion = modularVersionService.save(modularVersion);
        return Result.success(dozerUtils.map(modularVersion, ModularDTO.class));
    }

    /**
     * 发布版本
     *
     * @param files   上传的文件，支持多文件上传
     * @param request
     * @createTime 2018-5-16
     * @author zhoukx
     */
    @RequestMapping(value = "/version/uploads2", method = RequestMethod.POST)
    @ApiOperation(value = "发布版本", notes = "发布版本")
    @ApiResponses({
            @ApiResponse(code = 36501, message = "仓库名称为空"),
            @ApiResponse(code = 36001, message = "模块名称为空"),
            @ApiResponse(code = 36004, message = "groupId为空"),
            @ApiResponse(code = 36005, message = "artifactId为空"),
            @ApiResponse(code = 36502, message = "jar包版本为空"),
            @ApiResponse(code = 36006, message = "模块描述为空"),
            @ApiResponse(code = 36503, message = "jar文件为空"),
    })
    public Result<List<ModularDTO>> saveUploads(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request) {

        //获取表单提交的数据
        String repName = request.getParameter("repName");//仓库名称
        String modularName = request.getParameter("modularName");//模块名称
        String modularCategorys[] = request.getParameterValues("modularCategory");//模块分类
        String modularTags[] = request.getParameterValues("modularTag");//模块标签
        String groupId = request.getParameter("groupId");//groupId
        String artifactId = request.getParameter("artifactId");//artifactId
        String version = request.getParameter("version");//模块版本
        String description = request.getParameter("description");//模块描述
        String createCompanyId = request.getParameter("createCompanyId");//单位Id
        String createCompanyName = request.getParameter("createCompanyName");//单位名称

        //验证表单数据
        BizAssert.assertNotEmpty(StandardExceptionCode.REPOSITORY_NAME_EMPTY, repName);//仓库名称
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_NAME_EMPTY, modularName);//模块名称
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_GROUPID_EMPTY, groupId);//groupId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_ARTIFACTID_EMPTY, artifactId);//artifactId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_VERSION_EMPTY, version);//模块版本
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_DESCRIPTION_EMPTY, description);//模块描述
        BizAssert.assertNotNull(StandardExceptionCode.MODULAR_JAR_FILE_EMPTY, files);//模块jar文件

        //获取登录人信息
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        String classifier;

        //循环判断上传的文件是否已存在
        for (int i = 0; i < files.length; i++) {
            classifier = "";
            if (files[i].isEmpty()) {
                continue;
            }

            if (i == 1) {
                classifier = "sources";
            } else if (i == 2) {
                classifier = "doc";
            } else if (i == 3) {
                classifier = "help";
            }
            //验证上传的文件否已存在
            ModularVersionExample example = new ModularVersionExample();
            example.createCriteria()
                    .andGroupIdEqualTo(groupId)
                    .andArtifactIdEqualTo(artifactId)
                    .andVersionEqualTo(version)
                    .andClassifierEqualTo(classifier);

            int count = modularVersionService.count(example);
            if (count > 0) {//如果版本已存在则不能上传
                log.error("文件已存在：" + files[i].getOriginalFilename());
                MultipartFile file = files[i];
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (!classifier.equals("")) {
                    return Result.fail("文件已存在：" + artifactId + "-" + version + "-" + classifier + suffix);
                }
                return Result.fail("文件已存在：" + artifactId + "-" + version + ".jar");
            }
        }
        List<ModularVersion> versionLists = new ArrayList<ModularVersion>();
        ModularVersion modularVersion = new ModularVersion();

        //判断模块在数据库中是否存在，存在的不进行创建操作
        Modular md = new Modular();
        md.setRepName(repName);
        md.setGroupId(groupId);
        md.setArtifactId(artifactId);
        Modular modular = modularService.getModularByRepNameAndGidAndAid(md);
        if (modular == null) {
            //保存信息到模块
            Modular mod = new Modular();
            mod.setRepName(repName);
            mod.setModularName(modularName);
            mod.setGroupId(groupId);
            mod.setArtifactId(artifactId);
            mod.setDescription(description);
            mod.setCreateCompanyId(Long.parseLong(createCompanyId));
            mod.setCreateCompanyName(createCompanyName);
            mod.setCreateTime(Calendar.getInstance().getTime());
            mod.setCreateUser(adminId);
            mod.setCreateUserName(userName);
            mod.setVersion(version);
            mod = modularService.save(mod);

            //将分类数组循环插入到模块和标签的关联表中
            if (modularCategorys != null) {
                for (int j = 0; j < modularCategorys.length; j++) {
                    ModularCategory modCategory = new ModularCategory();
                    modCategory.setModularId(mod.getId());
                    modCategory.setCategoryId(Long.parseLong(modularCategorys[j]));
                    modCategory.setCreateTime(Calendar.getInstance().getTime());
                    modularCategoryService.save(modCategory);
                }
            }
            //将标签数组循环插入到模块和标签的关联表中
            if (modularTags != null) {
                for (int j = 0; j < modularTags.length; j++) {
                    ModularTag modTag = new ModularTag();
                    modTag.setModularId(mod.getId());
                    modTag.setTagId(Long.parseLong(modularTags[j]));
                    modTag.setCreateTime(Calendar.getInstance().getTime());
                    modularTagService.save(modTag);
                }
            }
        }
        //从配置文件中读取nexus的服务请求地址
        String serverUrl = nexusConfig.getServerUrl();
        String username = nexusConfig.getUsername();
        String password = nexusConfig.getPassword();
        //构建nexus获取认证信息的请求url
        String getCookieStoreUrl = serverUrl + "/service/rapture/session";
        //通过url 用户名 密码 获取认证信息
        CookieStore cookieStore = HttpUtil.getCookieStore(getCookieStoreUrl, username, password);
        String uploadUrl = serverUrl + "/service/rest/beta/components?repository=" + repName;

        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        String deletePath = request.getSession().getServletContext().getRealPath("/");
        for (int k = 0; k < files.length; k++) {
            classifier = "";
            if (files[k].isEmpty()) {
                continue;
            }
            if (k == 1) {
                classifier = "sources";
            } else if (k == 2) {
                classifier = "doc";
            } else if (k == 3) {
                classifier = "help";
            }
            //MultipartFile类型转为File类型
            File tempFile = FileUtil.saveFile(files[k], filePath);
            //构建往nexus服务器上上传时所需要的参数
            Map<String, String> params = new HashMap<String, String>();
            if (StringUtil.isNotEmpty(groupId)) {
                params.put("maven2.groupId", groupId);//groupId
            }
            if (StringUtil.isNotEmpty(artifactId)) {
                params.put("maven2.artifactId", artifactId);//artifactId
            }
            if (StringUtil.isNotEmpty(version)) {
                params.put("maven2.version", version);//version
            }
            if (StringUtil.isNotEmpty(classifier) && !classifier.equals("jar")) {
                params.put("maven2.asset1.classifier", classifier);
                String fileName = tempFile.getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                params.put("maven2.asset1.extension", suffix);
            } else {
                params.put("maven2.asset1.extension", "jar");
            }

            try {
                boolean flag = HttpUtil.uploadToResp(cookieStore, uploadUrl, tempFile, params);
                if (!flag) {
                    log.error("jar包上传时出错");
                    return Result.fail("jar包上传时出错");
                }
                if (StringUtil.isNotEmpty(deletePath)) {
                    FileUtil.deleteDirectory(deletePath);//删除临时文件
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //保存信息到版本
            modularVersion.setRepName(repName);
            modularVersion.setGroupId(groupId);
            modularVersion.setArtifactId(artifactId);
            modularVersion.setVersion(version);

            if (!classifier.equals("jar")) {
                modularVersion.setClassifier(classifier);
            } else {
                modularVersion.setClassifier("");
            }
            modularVersion.setCreateCompanyId(Long.parseLong(createCompanyId));
            modularVersion.setCreateCompanyName(createCompanyName);
            modularVersion.setCreateTime(Calendar.getInstance().getTime());
            modularVersion.setCreateUser(adminId);
            modularVersion.setCreateUserName(userName);
            modularVersion = modularVersionService.save(modularVersion);
            if (modularVersion != null) {
                versionLists.add(modularVersion);
            }
        }
        return Result.success(dozerUtils.mapPage(versionLists, ModularDTO.class));
    }

    /**
     * 根据id 删除版本（同时删除nexus仓库对应的版本文件）
     *
     * @param id 模块版本id
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @RequestMapping(value = "/version/delete", method = RequestMethod.GET)
    @ApiOperation(value = "根据id删除版本", notes = "根据id 删除版本（同时删除nexus仓库对应的版本文件）")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
    })
    public Result<Boolean> delete(@RequestParam Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        ModularVersion modularVersion = modularVersionService.getById(id);

        if (modularVersion == null) {
            return Result.fail("未找到要处理的数据，id：" + id);
        }
        //从配置文件中读取nexus的服务请求地址
        String serverUrl = nexusConfig.getServerUrl();
        String username = nexusConfig.getUsername();
        String password = nexusConfig.getPassword();

        JSONArray jSONArray = getVersionArray(modularVersion);
        //通过调用nexus接口查询出要删除的文件id
        String delId = jSONArray.getJSONObject(0).getString("id");
        //构建nexus获取认证信息的请求url
        String getCookieStoreUrl = serverUrl + "/service/rapture/session";
        //通过url 用户名 密码 获取认证信息
        CookieStore cookieStore = HttpUtil.getCookieStore(getCookieStoreUrl, username, password);
        //构建nexus删除请求的url
        String getResultByDeleteUrl = serverUrl + "/service/rest/beta/assets/" + delId;
        //调用nexus的接口方法DELETE请求进行文件删除
        String respContent = HttpUtil.getResultByDelete(getResultByDeleteUrl, cookieStore);

        if (respContent.equals("fail")) {//如果删除失败返回错误信息
            return Result.fail("未找到要处理的数据，id：" + id);
        }
        // nexus服务器上的文件删除成功后，删除本地数据库中的文件相关信息。
        int i = modularVersionService.deleteById(id);
        if (i < 0) {
            return Result.fail("版本删除失败！");
        }
        return Result.success(true);
    }

    /**
     * 通过版本的信息在nexus服务上查询出对应的jar包信息
     *
     * @param modularVersion 版本对象
     * @createTime 2018-4-5
     * @author zhoukx
     */
    private JSONArray getVersionArray(ModularVersion modularVersion) {
        String serverUrl = nexusConfig.getServerUrl();
        StringBuffer sb = new StringBuffer();
        sb.append(serverUrl + "/service/rest/beta/search/assets?");
        sb.append("repository=" + modularVersion.getRepName());
        sb.append("&maven.groupId=" + modularVersion.getGroupId());
        sb.append("&maven.artifactId=" + modularVersion.getArtifactId());
        sb.append("&maven.baseVersion=" + modularVersion.getVersion());
        if (StringUtils.isNotEmpty(modularVersion.getClassifier())) {
            sb.append("&maven.classifier=" + modularVersion.getClassifier());
        } else {
            sb.append("&maven.classifier=" + "");
        }
        //调用nexus的接口 查询出相应的jar包信息
        String resultJson = HttpUtil.getResultByGet(sb.toString(), "");
        JSONObject JsonObj = JSONObject.parseObject(resultJson);
        JSONArray jsonArray = JsonObj.getJSONArray("items");
        return jsonArray;
    }
}
