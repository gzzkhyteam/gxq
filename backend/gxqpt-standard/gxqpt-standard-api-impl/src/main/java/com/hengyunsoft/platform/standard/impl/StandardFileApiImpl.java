package com.hengyunsoft.platform.standard.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.StandardExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgPolyResDTO;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.file.api.FileApi;
import com.hengyunsoft.platform.file.dto.FileDTO;
import com.hengyunsoft.platform.file.dto.FileUpdateDTO;
import com.hengyunsoft.platform.standard.dto.CompanyInfoDTO;
import com.hengyunsoft.platform.standard.dto.StandardAnalysisClassifyTreeDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyTreeDTO;
import com.hengyunsoft.platform.standard.dto.StandardFileDTO;
import com.hengyunsoft.platform.standard.dto.StandardFileQueryDTO;
import com.hengyunsoft.platform.standard.dto.StandardFileSaveDTO;
import com.hengyunsoft.platform.standard.dto.StandardFileUpdateDTO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardClassifyDO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFile;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyExample;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileService;
import com.hengyunsoft.platform.standard.utils.ReturnTreeUtills;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@Slf4j
@Api(value = "标准文档管理", description = "标准文档管理")
public class StandardFileApiImpl /*implements StandardFileApi*/ {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private StandardFileService standardFileService;

    @Autowired
    private GxqptOrgOpenApi gxqptOrgOpenApi;

    @Autowired
    private FileApi fileApi;

    @Autowired
    private RoleOpenApi roleOpenApi;

    @Autowired
    private StandardClassifyService standardClassifyService;

    /**
     * 根据id 查看文档详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/file/get", method = RequestMethod.GET)
    public Result<StandardFileDTO> get(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        StandardFileDO file = standardFileService.getStandardFileDO(id);

        return Result.success(dozerUtils.map(file, StandardFileDTO.class));
    }

    /**
     * 标准文档查询列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/file/query", method = RequestMethod.POST)
    public Result<PageInfo<StandardFileDTO>> pageDocument(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq) {
        StandardFileQueryDTO data = openApiReq.getData();
        StandardFileExample example = new StandardFileExample();
        if (data != null) {
            example.createCriteria()
                    .andFClassIdEqualToCId()
                    .andFNameLike(StandardFileExample.fullLike(data.getName()))
                    .andFCodeLike(StandardFileExample.fullLike(data.getCode()))
                    .andFClassifyIdEqueal(data.getClassifyId())
                    .andFCreateTimeGt(data.getCreateTimeStart())
                    .andFCreateTimeLt(data.getCreateTimeEnd())
                    .andFCreateUserNameLike(StandardFileExample.fullLike(data.getCreateUserName()))
                    .andFIsEnableEqueal(true)
                    .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());

            example.setOrderByClause(" create_time desc ");
            //自己拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
            ) {
                example.setOrderByClause(" create_time " + data.getSord());
            } else if ("downloadCount".equals(data.getSidx()) ||
                    "createTime asc, downloadCount".equals(data.getSidx()) ||
                    "createTime desc, downloadCount".equals(data.getSidx())
            ) {
                example.setOrderByClause(" down_count " + data.getSord());
            }
        } else {
            example.createCriteria().andFClassIdEqualToCId()
                    .andFIsEnableEqueal(true)
                    .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            example.setOrderByClause(" create_time desc ");
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardFileDO> lists = standardFileService.pageDocument(example);
        List<StandardFileDTO> pageList = dozerUtils.mapPage(lists, StandardFileDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 标准文档管理查询列表
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/file/manageQuery", method = RequestMethod.POST)
    public Result<PageInfo<StandardFileDTO>> pageManageDocument(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq) {
        StandardFileQueryDTO data = openApiReq.getData();
        StandardFileExample example = new StandardFileExample();
        Long adminId = BaseContextHandler.getAdminId();
        if (data != null) {
            StandardFileExample.Criteria criteria = example.createCriteria();
            UserTokenExtInfo userTokenExtInfo = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
            String currAppId = BaseContextHandler.getAppId();
            boolean isAdmin = userTokenExtInfo.isAppAdmin(currAppId);
            if (isAdmin) {
                criteria.andFClassIdEqualToCId()
                        .andFNameLike(StandardFileExample.fullLike(data.getName()))
                        .andFCodeLike(StandardFileExample.fullLike(data.getCode()))
                        .andFClassifyIdEqueal(data.getClassifyId())
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFCreateUserNameLike(StandardFileExample.fullLike(data.getCreateUserName()))
                        .andFIsEnableEqueal(data.getIsEnable())
                        .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal())
                        .andFromPageEqualTo(data.getFromPage());
            } else {
                criteria.andFClassIdEqualToCId()
                        .andFNameLike(StandardFileExample.fullLike(data.getName()))
                        .andFCodeLike(StandardFileExample.fullLike(data.getCode()))
                        .andFClassifyIdEqueal(data.getClassifyId())
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFCreateUserNameLike(StandardFileExample.fullLike(data.getCreateUserName()))
                        .andFIsEnableEqueal(data.getIsEnable())
                        .andFCreateUserEqualTo(adminId)
                        .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal())
                        .andFromPageEqualTo(data.getFromPage());
            }
            example.setOrderByClause(" create_time desc ");
            //自己拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
            ) {
                example.setOrderByClause(" create_time " + data.getSord());
            } else if ("downloadCount".equals(data.getSidx()) ||
                    "createTime asc, downloadCount".equals(data.getSidx()) ||
                    "createTime desc, downloadCount".equals(data.getSidx())
            ) {
                example.setOrderByClause(" down_count " + data.getSord());
            }
        } else {
            StandardFileExample.Criteria criteria = example.createCriteria();
            UserTokenExtInfo userTokenExtInfo = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
            String currAppId = BaseContextHandler.getAppId();
            boolean isAdmin = userTokenExtInfo.isAppAdmin(currAppId);
            if (isAdmin) {
                criteria.andFClassIdEqualToCId().andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            } else {
                criteria.andFClassIdEqualToCId()
                        .andFCreateUserEqualTo(adminId)
                        .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            }
            example.setOrderByClause(" create_time desc ");
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardFileDO> lists = standardFileService.pageDocument(example);
        List<StandardFileDTO> pageList = dozerUtils.mapPage(lists, StandardFileDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 获取登录人的单位信息
     */
    @RequestMapping(value = "/file/findPoly", method = RequestMethod.GET)
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
     * 上传标准文档
     *
     * @param standardFileSaveDTO
     */
    @RequestMapping(value = "/file/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = StandardFile.class)
            }
    )
    public Result<StandardFileDTO> save(@RequestBody StandardFileSaveDTO standardFileSaveDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.FILE_NULL, standardFileSaveDTO);
        BizAssert.assertNotEmpty(StandardExceptionCode.FILE_NAME_EMPTY, standardFileSaveDTO.getName());
        BizAssert.assertNotNull(StandardExceptionCode.FILE_CLASSIFY_EMPTY, standardFileSaveDTO.getClassifyId());
        BizAssert.assertNotNull(StandardExceptionCode.FILE_COMPANY_EMPTY, standardFileSaveDTO.getCompanyId());
        BizAssert.assertNotNull(StandardExceptionCode.FILE_COMPANY_EMPTY, standardFileSaveDTO.getCompanyName());

        // 上传已存在文档名称的文档时，自动修改文档名称。
        if (isDuplication(standardFileSaveDTO.getName())) {
///            standardFileSaveDTO.setName(FileNameUtil.renameFileName(standardFileSaveDTO.getName()));
            return Result.fail("文档名称重复");
        }

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();
        //3,转换po，并保存
        StandardFile standardFile = dozerUtils.map(standardFileSaveDTO, StandardFile.class);
        standardFile.setIsEnable(true);
        standardFile.setIsDelete(false);
        standardFile.setCreateTime(Calendar.getInstance().getTime());
        standardFile.setCreateUser(BaseContextHandler.getAdminId());
        standardFile.setCreateUserName(userName);
        standardFile.setUpdateUser(adminId);
        standardFile.setUpdateTime(Calendar.getInstance().getTime());
        standardFile.setUpdateUserName(userName);
        //如果传入后台的文档名称与文件列表已经上传的文档提交名称不一致，需调用文件接口修改
        if (standardFileSaveDTO.getDocumentId() != null) {
            Long documentId = Long.parseLong(standardFileSaveDTO.getDocumentId());
            Result<FileDTO> fileDTOResult = fileApi.get(documentId);
            if (fileDTOResult.isSuccess()) {
                String fileName = fileDTOResult.getData().getSubmittedFileName();
                if (fileName.contains(".")) {
                    fileName = fileName.substring(0, fileName.lastIndexOf("."));
                }
                if (!fileName.equals(standardFileSaveDTO.getName())) {
                    FileUpdateDTO fileUpdateDTO = new FileUpdateDTO();
                    fileUpdateDTO.setId(documentId);
                    fileUpdateDTO.setSubmittedFileName(standardFileSaveDTO.getName() + "." + standardFileSaveDTO.getFileType());
                    Result<Boolean> result = fileApi.update(fileUpdateDTO);
                }
            }
        }
        standardFile = standardFileService.save(standardFile);

        //4,返回
        return Result.success(dozerUtils.map(standardFile, StandardFileDTO.class));
    }

    /**
     * 更新标准文档
     */
    @RequestMapping(value = "/file/update", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = StandardFile.class)
            }
    )
    public Result<Boolean> update(@RequestBody StandardFileUpdateDTO standardFileUpdateDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.FILE_NULL, standardFileUpdateDTO);
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, standardFileUpdateDTO.getId());
        BizAssert.assertNotEmpty(StandardExceptionCode.FILE_NAME_EMPTY, standardFileUpdateDTO.getName());
        BizAssert.assertNotNull(StandardExceptionCode.FILE_CLASSIFY_EMPTY, standardFileUpdateDTO.getClassifyId());
        BizAssert.assertNotNull(StandardExceptionCode.FILE_COMPANY_EMPTY, standardFileUpdateDTO.getCompanyId());
        BizAssert.assertNotNull(StandardExceptionCode.FILE_COMPANY_EMPTY, standardFileUpdateDTO.getCompanyName());

//        // 上传已存在文档名称的文档时，自动修改文档名称。
//        if (isDuplication(standardFileUpdateDTO.getName())) {
//            standardFileUpdateDTO.setName(FileNameUtil.renameFileName(standardFileUpdateDTO.getName()));
//        }

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并保存
        StandardFile standardFile = dozerUtils.map(standardFileUpdateDTO, StandardFile.class);
        standardFile.setUpdateUser(adminId);
        standardFile.setUpdateTime(Calendar.getInstance().getTime());
        standardFile.setUpdateUserName(userName);
        StandardFileDO file = standardFileService.getStandardFileDO(standardFileUpdateDTO.getId());
        //如果新上传了文件，删除之前的旧文件
        if (file.getDocumentId() != null) {
            if (!file.getDocumentId().equals(standardFileUpdateDTO.getDocumentId())) {
                Long id = Long.parseLong(file.getDocumentId());
                fileApi.remove(id);
            }
        }
        //如果传入后台的文档名称与文件列表已经上传的文档提交名称不一致，需调用文件接口修改
        Long documentId = Long.parseLong(standardFileUpdateDTO.getDocumentId());
        Result<FileDTO> fileDTOResult = fileApi.get(documentId);
        if (fileDTOResult.isSuccess()) {
            if (null != fileDTOResult.getData()) {
                String fileName = fileDTOResult.getData().getSubmittedFileName();
                if (fileName.contains(".")) {
                    fileName = fileName.substring(0, fileName.lastIndexOf("."));
                }
                if (!fileName.equals(standardFileUpdateDTO.getName())) {
                    FileUpdateDTO fileUpdateDTO = new FileUpdateDTO();
                    fileUpdateDTO.setId(documentId);
                    fileUpdateDTO.setSubmittedFileName(standardFileUpdateDTO.getName() + "." + standardFileUpdateDTO.getFileType());
                    Result<Boolean> result = fileApi.update(fileUpdateDTO);
                }
            }
        }
        int i = standardFileService.updateByIdSelective(standardFile);

        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要更新的数据，id：" + standardFileUpdateDTO.getId());
        }
    }

    /**
     * 根据id 删除文档
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/file/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        StandardFileDO file = standardFileService.getStandardFileDO(id);
        Long documentId = Long.parseLong(file.getDocumentId());
        Result<Boolean> flag = fileApi.remove(documentId);
        int i = standardFileService.deleteById(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }

    /**
     * 批量删除文档，多个id之间用“,”隔开
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/file/batchDelete", method = RequestMethod.GET)
    public Result<Boolean> batchDelete(@RequestParam(value = "ids") String ids) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, ids);

        String[] idArray = ids.split(",");
        List<Long> list = new ArrayList<Long>();
        List<Long> documentIdList = new ArrayList<Long>();
        StandardFileDO file = new StandardFileDO();
        for (int m = 0; m < idArray.length; m++) {
            String id = idArray[m];
            if (id != null && !id.equals("")) {
                file = standardFileService.getStandardFileDO(Long.valueOf(id));
                list.add(Long.valueOf(id));
                documentIdList.add(Long.parseLong(file.getDocumentId()));
            }
        }
        Long[] id = new Long[documentIdList.size()];
        documentIdList.toArray(id);
        int i = standardFileService.deleteByIds(list);
        Result<Boolean> flag = fileApi.removeList(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，ids：" + ids);
        } else {
            return Result.success(true);
        }
    }

    /**
     * 设置指定的文档为过期状态
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/file/updateToDisable", method = RequestMethod.GET)
    public Result<Boolean> updateToDisable(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        StandardFile file = standardFileService.getById(id);
        if (file == null) {
            return Result.fail("未找到数据，id：" + id);
        }

        file.setIsEnable(false);

        int i = standardFileService.updateById(file);
        if (i == 0) {
            return Result.fail("更新失败，id：" + id);
        } else {
            return Result.success(true);
        }
    }

    /**
     * 重新启用文档
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/file/updateToEnable", method = RequestMethod.GET)
    public Result<Boolean> updateToEnable(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        StandardFile file = standardFileService.getById(id);
        if (file == null) {
            return Result.fail("未找到数据，id：" + id);
        }

        file.setIsEnable(true);

        int i = standardFileService.updateById(file);
        if (i == 0) {
            return Result.fail("更新失败，id：" + id);
        } else {
            return Result.success(true);
        }
    }

    /**
     * 根据分类Id查询是否关联文档
     *
     * @param classifyId
     * @return
     */
    @RequestMapping(value = "/file/isRelevanceDocument", method = RequestMethod.GET)
    public Result<Boolean> isRelevanceDocument(@RequestParam(value = "classifyId") String classifyId) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, classifyId);

        StandardFileExample example = new StandardFileExample();
        Boolean flag = false;
        if (classifyId != null) {
            example.createCriteria().andClassifyIdEqualTo(classifyId)
                    .andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
        }
        List<StandardFile> list = standardFileService.findFileListByClassifyId(example);

        if (list != null && list.size() > 0) {
            flag = true;
        }
        return Result.success(flag);
    }

    /**
     * 查询各分类下的文档数量
     *
     * @return
     */
    @RequestMapping(value = "/file/findAllFileCount", method = RequestMethod.POST)
    public Result<List<StandardAnalysisClassifyTreeDTO>> findAllFileCount() {
        Long currentParentClassify = null;//当前父分类
        List<StandardAnalysisClassifyTreeDTO> standardAnalysisClassifyTreeDTOList = new ArrayList<StandardAnalysisClassifyTreeDTO>();//返回的数据
        List<StandardClassifyDO> standardClassifyDOList = standardFileService.findAllFileCount();//查询的数据
        if (standardClassifyDOList == null || standardClassifyDOList.size() == 0) {//查询无结果，返回null
            return null;
        }

        int count = 0;//记录父分类的文档数量
        for (int i = 0; i < standardClassifyDOList.size(); i++) {
            StandardClassifyDO classifyDo = standardClassifyDOList.get(i);
            if (classifyDo.getParentId() != currentParentClassify) {//判断是否新的父分类
                currentParentClassify = classifyDo.getParentId();
                StandardAnalysisClassifyTreeDTO parentNode = new StandardAnalysisClassifyTreeDTO();//创建返回数据的对象并赋值
                parentNode.setId(classifyDo.getParentId());
                parentNode.setParentId(-1l);
                parentNode.setClassifyName(classifyDo.getParentName());
                standardAnalysisClassifyTreeDTOList.add(parentNode);
                count = 0;//对父分类的文档数量清0
            }

            StandardAnalysisClassifyTreeDTO node = new StandardAnalysisClassifyTreeDTO();
            node.setId(classifyDo.getId());
            node.setParentId(classifyDo.getParentId());
            node.setClassifyName(classifyDo.getName());
            node.setFileCount(classifyDo.getFileCount());
            count = count + classifyDo.getFileCount();

            standardAnalysisClassifyTreeDTOList.get(standardAnalysisClassifyTreeDTOList.size() - 1).add(node);//给同一个父分类的childrenList赋值
            standardAnalysisClassifyTreeDTOList.get(standardAnalysisClassifyTreeDTOList.size() - 1).setFileCount(count);//计算父分类的文档数量
        }
        return Result.success(standardAnalysisClassifyTreeDTOList);
    }

    /**
     * 标准文档查询列表(某一分类及子类的文档)
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/file/queryByClassifyId", method = RequestMethod.POST)
    public Result<PageInfo<StandardFileDTO>> pageDocumentByClassifyId(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq) {
        StandardFileQueryDTO data = openApiReq.getData();
        BizAssert.assertNotNull(StandardExceptionCode.FILE_CLASSIFYID_EMPTY, data.getClassifyId());
        Long classifyId = Long.parseLong(data.getClassifyId());
        List<String> allClassifyIds = getClassifyIds(classifyId);
        StandardFileExample example = new StandardFileExample();
        if (data != null) {
            example.createCriteria()
                    .andFClassIdEqualToCId()
                    .andFNameLike(StandardFileExample.fullLike(data.getName()))
                    .andFCodeLike(StandardFileExample.fullLike(data.getCode()))
                    .andFClassifyIdIn(allClassifyIds)
                    .andFCreateTimeGt(data.getCreateTimeStart())
                    .andFCreateTimeLt(data.getCreateTimeEnd())
                    .andFCreateUserNameLike(StandardFileExample.fullLike(data.getCreateUserName()))
                    .andFIsEnableEqueal(true)
                    .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            example.setOrderByClause(" create_time desc ");
            //自己拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
            ) {
                example.setOrderByClause(" create_time " + data.getSord());
            } else if ("downloadCount".equals(data.getSidx()) ||
                    "createTime asc, downloadCount".equals(data.getSidx()) ||
                    "createTime desc, downloadCount".equals(data.getSidx())
            ) {
                example.setOrderByClause(" down_count " + data.getSord());
            }

        } else {
            example.createCriteria().andFClassIdEqualToCId()
                    .andFIsEnableEqueal(true)
                    .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            example.setOrderByClause(" create_time desc ");
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardFileDO> lists = standardFileService.pageDocument(example);
        List<StandardFileDTO> pageList = dozerUtils.mapPage(lists, StandardFileDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 标准文档管理查询列表(某一分类及子类的文档)
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/file/manageQueryByClassifyId", method = RequestMethod.POST)
    public Result<PageInfo<StandardFileDTO>> pageManageDocumentByClassifyId(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq) {
        StandardFileQueryDTO data = openApiReq.getData();
        BizAssert.assertNotNull(StandardExceptionCode.FILE_CLASSIFYID_EMPTY, data.getClassifyId());
        Long classifyId = Long.parseLong(data.getClassifyId());
        List<String> allClassifyIds = getClassifyIds(classifyId);
        StandardFileExample example = new StandardFileExample();
        Long adminId = BaseContextHandler.getAdminId();
        Result<List<RoleDto>> resultRole = roleOpenApi.findAllPtAndCurrentAppRoleById(adminId);
        Result<List<CompanyInfoDTO>> resultOrg = findPolyByUser();
        List<String> companyIdList = new ArrayList<>();
        if (resultOrg.isSuccess()) {
            List<CompanyInfoDTO> orgList = resultOrg.getData();
            if (orgList != null) {
                for (CompanyInfoDTO companyInfoDTO : orgList) {
                    companyIdList.add(companyInfoDTO.getCompanyId());
                }
            }
        }
        if (data != null) {
            Long userId = BaseContextHandler.getAdminId();
            UserTokenExtInfo userTokenExtInfo = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
            String currAppId = BaseContextHandler.getAppId();
            boolean isAdmin = userTokenExtInfo.isAppAdmin(currAppId);
            StandardFileExample.Criteria criteria = example.createCriteria();
            if (isAdmin) {
                criteria.andFClassIdEqualToCId()
                        .andFNameLike(StandardFileExample.fullLike(data.getName()))
                        .andFCodeLike(StandardFileExample.fullLike(data.getCode()))
                        .andFClassifyIdIn(allClassifyIds)
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFCreateUserNameLike(StandardFileExample.fullLike(data.getCreateUserName()))
                        .andFIsEnableEqueal(data.getIsEnable())
                        .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            } else {
                criteria.andFClassIdEqualToCId()
                        .andFNameLike(StandardFileExample.fullLike(data.getName()))
                        .andFCodeLike(StandardFileExample.fullLike(data.getCode()))
                        .andFClassifyIdIn(allClassifyIds)
                        .andFCreateTimeGt(data.getCreateTimeStart())
                        .andFCreateTimeLt(data.getCreateTimeEnd())
                        .andFCreateUserNameLike(StandardFileExample.fullLike(data.getCreateUserName()))
                        .andFIsEnableEqueal(data.getIsEnable())
                        .andFCreateUserEqualTo(userId)
                        .andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            }
            if (resultRole.isSuccess()) {
                List<RoleDto> roleList = resultRole.getData();
                if (roleList != null) {
                    for (RoleDto roleDto : roleList) {
                        if (roleDto.getCode().toLowerCase().equals("app_common")) {
                            criteria.andCreateUserEqualTo(adminId);
                            break;
                        }
                    }
                }
            }
            example.setOrderByClause(" create_time desc ");
            //自己拼接排序条件
            if ("createTime".equals(data.getSidx()) ||
                    "downloadCount asc, createTime".equals(data.getSidx()) ||
                    "downloadCount desc, createTime".equals(data.getSidx())
            ) {
                example.setOrderByClause(" create_time " + data.getSord());
            } else if ("downloadCount".equals(data.getSidx()) ||
                    "createTime asc, downloadCount".equals(data.getSidx()) ||
                    "createTime desc, downloadCount".equals(data.getSidx())
            ) {
                example.setOrderByClause(" down_count " + data.getSord());
            }
        } else {
            StandardFileExample.Criteria criteria = example.createCriteria();
            criteria.andFClassIdEqualToCId().andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
            if (resultRole.isSuccess()) {
                List<RoleDto> roleList = resultRole.getData();
                if (roleList != null) {
                    for (RoleDto roleDto : roleList) {
                        if (roleDto.getCode().toLowerCase().equals("app_common")) {
                            criteria.andCreateUserEqualTo(adminId);
                            break;
                        }
                    }
                }
            }
            example.setOrderByClause(" create_time desc ");
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<StandardFileDO> lists = standardFileService.pageDocument(example);
        List<StandardFileDTO> pageList = dozerUtils.mapPage(lists, StandardFileDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 描述：获取运维文档某一分类及子集的ids
     */
    public List<String> getClassifyIds(Long classifyId) {
        List<String> result = new ArrayList<String>();
        StandardClassifyExample standardClassifyExample = new StandardClassifyExample();
        standardClassifyExample.createCriteria().andIsEnableEqualTo(true);
        standardClassifyExample.setOrderByClause("parent_id,sort_no");
        List<StandardClassify> standardClassifyList = standardClassifyService.find(standardClassifyExample);
        List<StandardClassifyTreeDTO> resultTree = null;
        if (standardClassifyList != null) {
            List<StandardClassifyTreeDTO> treeList = dozerUtils.mapList(standardClassifyList,
                    StandardClassifyTreeDTO.class);
            resultTree = ReturnTreeUtills.useListRecordToTree(treeList, classifyId + "");
        }
        if (resultTree.size() >= 1) {
            ergodicList(resultTree, result);
        } else {
            result.add(classifyId + "");
        }
        return result;
    }

    //前序遍历得到所有的id List
    private List<String> ergodicList(List<StandardClassifyTreeDTO> resultTree, List<String> result) {
        for (StandardClassifyTreeDTO dto : resultTree) {
            result.add(dto.getId().toString());
            if (dto.getChildren() != null) {
                List<StandardClassifyTreeDTO> children = dto.getChildren();
                ergodicList(children, result);
            }
        }
        return result;
    }

    /**
     * 判断文件名称是否已经存在
     */
    private boolean isDuplication(String name) {
        return standardFileService.getCountByName(name) > 0;
    }

}
