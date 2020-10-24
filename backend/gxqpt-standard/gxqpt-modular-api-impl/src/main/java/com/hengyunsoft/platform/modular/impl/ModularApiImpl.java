package com.hengyunsoft.platform.modular.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.hengyunsoft.platform.modular.config.NexusConfig;
import com.hengyunsoft.platform.modular.dto.ModularDTO;
import com.hengyunsoft.platform.modular.dto.ModularDiscardedPageDTO;
import com.hengyunsoft.platform.modular.dto.ModularLogDTO;
import com.hengyunsoft.platform.modular.dto.ModularQueryDTO;
import com.hengyunsoft.platform.modular.dto.VersionParamsDTO;
import com.hengyunsoft.platform.modular.entity.modular.domain.GetVersionDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularCategoryAndTagDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.VersionParamsDO;
import com.hengyunsoft.platform.modular.entity.modular.po.Modular;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularCategory;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularLog;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularTag;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularVersion;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularQueryEntity;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularVersionExample;
import com.hengyunsoft.platform.modular.repository.service.ModularCategoryService;
import com.hengyunsoft.platform.modular.repository.service.ModularLogService;
import com.hengyunsoft.platform.modular.repository.service.ModularService;
import com.hengyunsoft.platform.modular.repository.service.ModularTagService;
import com.hengyunsoft.platform.modular.repository.service.ModularVersionService;
import com.hengyunsoft.platform.modular.utils.FileUtil;
import com.hengyunsoft.platform.modular.utils.GxqModularRoleUnits;
import com.hengyunsoft.platform.modular.utils.HttpUtil;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

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
 * @createTime 2018-4-5
 */
@RestController
@Slf4j
@Api(value = "API - ModularApiImpl", description = "模块管理")
public class ModularApiImpl /*implements ModularApi */ {

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private GxqModularRoleUnits gxqModularRoleUnits;

    @Autowired
    private ModularService modularService;
    @Autowired
    private ModularLogService modularLogService;
    @Autowired
    private ModularVersionService modularVersionService;
    @Autowired
    private ModularCategoryService modularCategoryService;
    @Autowired
    private ModularTagService modularTagService;
    @Autowired
    private NexusConfig nexusConfig;
    @Value("${spring.profiles.active}")
    private String profiles;

    /**
     * 通过id查询模块对象信息
     *
     * @param id 模块id
     * @return ModularDTO
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @ApiOperation(value = "根据id查看模块详情", notes = "根据id查看模块详情")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
    })
    @RequestMapping(value = "/modular/get", method = RequestMethod.GET)
    public Result<ModularDTO> getModularById(@RequestParam Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);
        ModularDO modularDO = modularService.getModularById(id);
        if (modularDO == null) {
            return Result.success(null);
        }
        List<ModularCategoryAndTagDO> mclists = modularService.findCatagoryListByModularId(id);
        List<ModularCategoryAndTagDO> mtlists = modularService.findTagListByModularId(id);
        modularDO.setMclist(mclists);
        modularDO.setMtlist(mtlists);
        //获取版本号
        GetVersionDO getVersionDO = new GetVersionDO();
        getVersionDO.setUserId(BaseContextHandler.getAdminId());
        getVersionDO.setGroupId(modularDO.getGroupId());
        getVersionDO.setArtifactId(modularDO.getArtifactId());
        String version = modularVersionService.getVersion(getVersionDO);
//        modularDO.setVersion(version);
        //获取上传各文件的下载地址和id
        getVersionDO.setVersion(modularDO.getVersion());
        List<VersionParamsDO> files = new ArrayList<VersionParamsDO>();
        List<ModularVersion> modularVersionList = modularVersionService.getVersionList(getVersionDO);
        if (modularVersionList != null && modularVersionList.size() != 0) {
            for (ModularVersion modularVersion : modularVersionList) {
                VersionParamsDO versionParamsDO = new VersionParamsDO();
                JSONArray jSONArray = getVersionArray(modularVersion);
                if (jSONArray != null && jSONArray.getJSONObject(0) != null
                    //&&!StringUtils.isEmpty(modularVersion.getClassifier())
                ) {
                    String fileId = jSONArray.getJSONObject(0).getString("id");
                    String downloadUrl = jSONArray.getJSONObject(0).getString("downloadUrl");
                    String serverUrl = nexusConfig.getServerUrl();
                    int i = downloadUrl.indexOf("8081");
                    downloadUrl = downloadUrl.substring(i + 4, downloadUrl.length());
                    downloadUrl = serverUrl + downloadUrl;
                    if ("prod".equals(profiles)) {
                        downloadUrl = downloadUrl.replaceAll("http://192.168.30.151:8081", "http://127.0.0.1:10086");
                    } else if ("demo".equals(profiles)) {
                        downloadUrl = downloadUrl.replaceAll("http://192.168.30.83:8081", "http://127.0.0.1:10087");
                    }
                    versionParamsDO.setFilePath(downloadUrl);
                    versionParamsDO.setClassifier(modularVersion.getClassifier());
                    versionParamsDO.setFileId(fileId);
                    files.add(versionParamsDO);
                }
            }
        }
        ModularDTO modularDTO = dozerUtils.map(modularDO, ModularDTO.class);
        List<VersionParamsDTO> file = dozerUtils.mapList(files, VersionParamsDTO.class);
        modularDTO.setFiles(file);
        return Result.success(modularDTO);
    }

    /**
     * 分页查询模块列表
     *
     * @param openApiReq 分页信息
     * @return PageInfo<ModularDTO>
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @RequestMapping(value = "/modular/page", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询模块列表", notes = "分页查询模块列表")
    public Result<PageInfo<ModularDTO>> page(@RequestBody OpenApiReq<ModularQueryDTO> openApiReq) {
        ModularQueryDTO data = openApiReq.getData();
        ModularQueryEntity entity = null;
        if (data != null) {
            entity = new ModularQueryEntity();
            entity.setGroupId(data.getGroupId());
            entity.setArtifactId(data.getArtifactId());
            entity.setMateParam(data.getMateParam());
            entity.setModularTag(data.getModularTag());
            entity.setModularType(data.getModularType());
            entity.setRepName(data.getRepName());

            Long userId = BaseContextHandler.getAdminId();
            // 非平台管理员
            if (!gxqModularRoleUnits.getGxqModularRole(userId, GxqModularRoleUnits.ADMIN_ROLE_CODE)) {
                entity.setCreateUser(userId);
            }
        }
        //查询出模块列表信息
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ModularDO> lists = modularService.page(entity);
        List<ModularCategoryAndTagDO> mclists;
        List<ModularCategoryAndTagDO> mtlists;
        for (ModularDO md : lists) {
            //查询出分类列表信息放到模块列表中
            mclists = modularService.findCatagoryListByModularId(md.getId());
            //查询出标签列表信息放到模块列表中
            mtlists = modularService.findTagListByModularId(md.getId());
            md.setMclist(mclists);
            md.setMtlist(mtlists);
        }
        List<ModularDTO> pageList = dozerUtils.mapPage(lists, ModularDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 模块更新
     *
     * @return Boolean
     * @createTime 2018-4-5
     * @author zhoukx
     */
    @ApiOperation(value = "模块更新", notes = "模块更新")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
            @ApiResponse(code = 35007, message = "模块名称为空"),
            @ApiResponse(code = 35008, message = "模块类别为空"),
            @ApiResponse(code = 35009, message = "模块标签为空"),
            @ApiResponse(code = 35010, message = "模块描述为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = Modular.class)
            }
    )
    @RequestMapping(value = "/modular/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestParam(value = "file") MultipartFile[] files, HttpServletRequest request) {
        //获取表单提交的数据
        Long id = Long.valueOf(request.getParameter("id"));//模块id
        String modularName = request.getParameter("modularName");//模块名称
        String[] modularCategorys = request.getParameterValues("modularCategory");//模块分类
        String[] modularTags = request.getParameterValues("modularTag");//模块标签
        String description = request.getParameter("description");//模块描述

        String repName = request.getParameter("repName");//仓库名称
        String groupId = request.getParameter("groupId");//groupId
        String artifactId = request.getParameter("artifactId");//artifactId
        String version = request.getParameter("version");//模块版本

        String createCompanyId = request.getParameter("createCompanyId");//单位Id
        String createCompanyName = request.getParameter("createCompanyName");//单位名称
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_NAME_EMPTY, modularName);
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_DESCRIPTION_EMPTY, description);
        BizAssert.assertNotEmpty(StandardExceptionCode.REPOSITORY_NAME_EMPTY, repName);//仓库名称
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_GROUPID_EMPTY, groupId);//groupId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_ARTIFACTID_EMPTY, artifactId);//artifactId
        BizAssert.assertNotEmpty(StandardExceptionCode.MODULAR_VERSION_EMPTY, version);//模块版本
        BizAssert.assertNotNull(StandardExceptionCode.MODULAR_JAR_FILE_EMPTY, files);//模块jar文件

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        //根据id去分类和标签的关联表中删除相应的信息
        modularCategoryService.deleteCategorysByModularId(id);
        modularTagService.deleteTagsByModularId(id);

        //3,转换po，并保存s
        Modular modular = new Modular();
        modular.setId(id);
        modular.setDescription(description);
        modular.setModularName(modularName);//模块名称
        modular.setDescription(description);//模块描述
        modular.setUpdateTime(Calendar.getInstance().getTime());//更新时间
        modular.setUpdateUser(adminId);
        modular.setUpdateUserName(userName);
        modular.setVersion(version);
        int m = modularService.updateByIdSelective(modular);
        //4,返回
        if (m > 0) {
            String[] mdCategorys = null;
            String[] modularTags1 = null;
            if (modularCategorys != null) {
                mdCategorys = modularCategorys;
            }
            if (modularTags != null) {
                modularTags1 = modularTags;
            }
            //将分类数组循环插入到模块和标签的关联表中
            if (mdCategorys != null) {
                for (String mdCategory : mdCategorys) {
                    ModularCategory modCategory = new ModularCategory();
                    modCategory.setModularId(id);
                    modCategory.setCategoryId(Long.parseLong(mdCategory));
                    modCategory.setCreateTime(Calendar.getInstance().getTime());
                    modularCategoryService.save(modCategory);
                }
            }
            //将标签数组循环插入到模块和标签的关联表中
            if (modularTags1 != null) {
                for (String s : modularTags1) {
                    ModularTag modTag = new ModularTag();
                    modTag.setModularId(id);
                    modTag.setTagId(Long.parseLong(s));
                    modTag.setCreateTime(Calendar.getInstance().getTime());
                    modularTagService.save(modTag);
                }
            }

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
                // 如果版本已存在则不能上传
                if (count > 0) {
                    log.error("版本文件已存在：" + files[i].getOriginalFilename());
                    MultipartFile file = files[i];
                    String fileName = file.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    if (!"".equals(classifier)) {
                        return Result.fail("版本文件已存在：" + artifactId + "-" + version + "-" + classifier + suffix);
                    }
                    return Result.fail("版本文件已存在：" + artifactId + "-" + version + ".jar");
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

            ModularVersion modularVersion;
            for (int k = 0; k < files.length; k++) {
                classifier = "";
                modularVersion = new ModularVersion();
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
                Map<String, String> params = new HashMap<>();
                if (StringUtil.isNotEmpty(groupId)) {
                    params.put("maven2.groupId", groupId);
                }
                if (StringUtil.isNotEmpty(artifactId)) {
                    params.put("maven2.artifactId", artifactId);
                }
                if (StringUtil.isNotEmpty(version)) {
                    params.put("maven2.version", version);
                }
                if (StringUtil.isNotEmpty(classifier) && !"jar".equals(classifier)) {
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
                        FileUtil.deleteDirectory(deletePath);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //保存信息到版本
                modularVersion.setRepName(repName);
                modularVersion.setGroupId(groupId);
                modularVersion.setArtifactId(artifactId);
                modularVersion.setVersion(version);

                if (!"jar".equals(classifier)) {
                    modularVersion.setClassifier(classifier);
                } else {
                    modularVersion.setClassifier("");
                }
                modularVersion.setCreateCompanyId(Long.parseLong(createCompanyId));
                modularVersion.setCreateCompanyName(createCompanyName);
                modularVersion.setCreateTime(Calendar.getInstance().getTime());
                modularVersion.setCreateUser(adminId);
                modularVersion.setCreateUserName(userName);
                modularVersionService.save(modularVersion);
            }

            return Result.success(true);
        } else {
            return Result.fail("未找到要处理的数据，id：" + id);
        }

    }

    /**
     * 根据id删除模块
     * 如果模块下存在jar包则不可删除。
     *
     * @param id 模块id
     * @return Boolean
     * @createTime 2018-4-5
     * @author zhoukx
     */

    @ApiOperation(value = "根据id删除模块", notes = "根据id删除模块，如果模块下存在jar包则不可删除")
    @ApiResponses({
            @ApiResponse(code = 35000, message = "ID不允许为空"),
    })
    @RequestMapping(value = "/modular/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);
        Modular modular = modularService.getById(id);
        if (modular == null) {
            return Result.fail("未找到要删除的数据，id：" + id);
        }
        //查询该模块下是否存在jar文件，存在则不可删除。
        ModularVersionExample example = new ModularVersionExample();
        example.createCriteria().andGroupIdEqualTo(modular.getGroupId())
                .andArtifactIdEqualTo(modular.getArtifactId());

        int i = modularVersionService.count(example);
        if (i > 0) {
            return Result.fail("该模块下存在jar文件，不可删除！");
        }
        int j = modularService.deleteById(id);
        if (j == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }

    /**
     * 根据仓库名和groupId和artifactId查询模块对象信息
     *
     * @param modularDTO 仓库名和groupId和artifactId
     * @return ModularDTO
     * @createTime 2018-4-5
     * @author zhoukx
     */

    @ApiOperation(value = "根据仓库名和groupId和artifactId查询模块对象信息", notes = "根据仓库名和groupId和artifactId查询模块对象信息")
    @RequestMapping(value = "/modular/getModularByRepNameAndGidAndAid", method = RequestMethod.POST)
    public Result<ModularDTO> getModularByRepNameAndGidAndAid(@RequestBody ModularDTO modularDTO) {
        Modular modular = dozerUtils.map(modularDTO, Modular.class);
        ModularDO md = modularService.getModularByRepNameAndGidAndAid(modular);
        if (md != null) {
            List<ModularCategoryAndTagDO> mclists = new ArrayList<ModularCategoryAndTagDO>();
            List<ModularCategoryAndTagDO> mtlists = new ArrayList<ModularCategoryAndTagDO>();
            //查询出分类列表信息放到模块列表中
            mclists = modularService.findCatagoryListByModularId(md.getId());
            //查询出标签列表信息放到模块列表中
            mtlists = modularService.findTagListByModularId(md.getId());
            md.setMclist(mclists);
            md.setMtlist(mtlists);
            return Result.success(dozerUtils.map(md, ModularDTO.class));
        } else {
            return Result.fail("模块信息不存在");
        }
    }

    /**
     * 废弃模块分页列表
     *
     * @param openApiReq 分页信息
     * @return PageInfo<ModularDiscardedPageDTO>
     */
    @RequestMapping(value = "/discarded/page", method = RequestMethod.POST)
    @ApiOperation(value = "废弃模块分页列表", notes = "废弃模块分页列表")
    public Result<PageInfo<ModularDTO>> pageDiscarded(@RequestBody OpenApiReq<ModularDiscardedPageDTO> openApiReq) {
        try {
            ModularDiscardedPageDTO data = openApiReq.getData();
            if (data == null) {
                return Result.fail("参数错误");
            }
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            List<ModularDO> lists = modularService.pageDiscarded(data.getParam());
            List<ModularCategoryAndTagDO> mclists = new ArrayList<ModularCategoryAndTagDO>();
            List<ModularCategoryAndTagDO> mtlists = new ArrayList<ModularCategoryAndTagDO>();
            for (ModularDO md : lists) {
                mclists = modularService.findCatagoryListByModularId(md.getId());
                mtlists = modularService.findTagListByModularId(md.getId());
                md.setMclist(mclists);
                md.setMtlist(mtlists);
            }
            List<ModularDTO> pageList = dozerUtils.mapPage(lists, ModularDTO.class);
            return Result.success(new PageInfo<>(pageList));
        } catch (Exception e) {
            log.error("获取废弃模块分页列表出错：" + e);
            return Result.fail("获取废弃模块分页列表出错");
        }
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

    /**
     * 点击下载新增一条下载记录
     *
     * @param openApiReq 分页信息
     * @return PageInfo<ModularDiscardedPageDTO>
     */
    @RequestMapping(value = "/save/downloadRecord", method = RequestMethod.POST)
    @ApiOperation(value = "点击下载新增一条下载记录", notes = "点击下载新增一条下载记录")
    public Result<Boolean> saveDownloadRecord(@RequestBody ModularLogDTO modularLogDTO, HttpServletRequest req) {
        // 原来的添加方法
    	 /*Modular modular = dozerUtils.map(modularLogDTO, Modular.class);
    	 modular.setCreateTime(new Date());
    	 modular.setCreateUser(BaseContextHandler.getAdminId());
    	 modularService.save(modular);*/
        ModularLog modularLog = dozerUtils.map(modularLogDTO, ModularLog.class);
        modularLog.setCreateTime(new Date());
        modularLog.setCreateUser(BaseContextHandler.getAdminId());
        modularLog.setIp(req.getRemoteAddr());
        modularLogService.save(modularLog);
        return Result.success(true);
    }
}
