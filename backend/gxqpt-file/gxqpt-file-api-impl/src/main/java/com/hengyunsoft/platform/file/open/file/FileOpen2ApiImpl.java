package com.hengyunsoft.platform.file.open.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.biz.FileObjectId;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.dto.open.FileChunkCheckDTO;
import com.hengyunsoft.platform.file.dto.open.FileChunksMergeDTO;
import com.hengyunsoft.platform.file.dto.open.FileUploadDTO;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
import com.hengyunsoft.platform.file.utils.FileUtils;
import com.hengyunsoft.platform.file.utils.UploadUtil;
import com.hengyunsoft.platform.file.utils.WebUploader;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 注意：该类下的所有方法均需要webuploder.js插件进行配合使用。
 * md5
 *
 * @auth tangyh
 * @date 2018/08/24
 */
@RestController
@Slf4j
@RequestMapping("/p/file")
@Api(value = "文件续传+秒传", description = "文件续传+秒传功能，所有方法均需要webuploder.js插件进行配合使用， 且4个方法需要配合使用，单核接口没有意义")
public class FileOpen2ApiImpl {
    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private WebUploader wu;


    /**
     * 采用md5 上传前的验证
     *
     * @param md5 文件md5
     * @return
     */
    @ApiOperation(value = "秒传接口，上传文件前先验证， 存在则启动秒传", notes = "前端通过webUploader获取文件md5，上传前的验证")
    @RequestMapping(value = "/md5Check", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> saveMd5Check(@RequestParam(name = "md5") String md5, @RequestParam(name = "userId", required = false) Long userId) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        adminId = adminId == null || adminId <= 0 ? userId : adminId;
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, adminId);

        com.hengyunsoft.platform.file.entity.file.po.File file = wu.md5Check(md5);
        log.info("md5={}, path={}", md5, file);
        if (file == null) {
            return Result.success(0);
        } else {
            //分片存在，不需上传， 复制一条数据，重新插入
            file.setId(null);
            file.setCreateUser(adminId);
            file.setUpdateUser(adminId);
            file.setAppId(appId);
            file.setAdminId(adminId);
            file.setCreateTime(new Date());
            file.setUpdateTime(new Date());
            if (fileProperties.getFastdfs().isEnabled()) {
                FileModel fileModel = new FileModel(file.getNamespace(), file.getObjectId(),
                        file.getAbsolutePath(), file.getRelativePath(), fileProperties.getRemoteUriPrefix(),
                        file.getFilename(), file.getSize(), file.getSubmittedFileName());
                FileManager.getInstance().upload(file.getGroupName(), file.getRemoteFileName(), fileModel);
                file.setUrl(fileModel.getRemotePath());
                file.setGroupName(fileModel.getGroupName());
                file.setRemoteFileName(fileModel.getRemoteFileName());
                file.setuKey(fileModel.getKey());
            }
            fileService.save(file);
            return Result.success(1);
        }
    }

    /**
     * 检查分片存不存在
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "续传接口，检查每个分片存不存在", notes = "断点续传功能检查分片是否存在， 已存在的分片无需重复上传， 达到续传效果")
    @RequestMapping(value = "/chunkCheck", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> chunkCheck(@RequestBody FileChunkCheckDTO info) {
        String appId = BaseContextHandler.getAppId();
        String uploadFolder = FileUtils.getUploadPathPrefix(appId, fileProperties.getUploadPathPrefix());
        //检查目标分片是否存在且完整
        if (wu.chunkCheck(uploadFolder + "/" + info.getName() + "/" + info.getChunkIndex(), info.getSize())) {
            return Result.success(1);
        } else {
            return Result.success(0);
        }

    }

    /**
     * 分片通过nio合并， 合并成功后，将文件上传至fastdfs
     * nio合并优点： 有效防止大文件的内存溢出
     *
     * @param info
     * @return
     */
    @ApiOperation(value = "分片合并", notes = "所有分片上传成功后，调用该接口对分片进行合并")
    @RequestMapping(value = "/chunksMerge", method = RequestMethod.POST)
    @ResponseBody
    public Result<com.hengyunsoft.platform.file.entity.file.po.File> saveChunksMerge(@RequestBody FileChunksMergeDTO info) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        adminId = adminId == null || adminId <= 0 ? info.getUserId() : adminId;
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, adminId);

        String uploadFolder = FileUtils.getUploadPathPrefix(appId, fileProperties.getUploadPathPrefix());

        String path = wu.chunksMerge(info.getName(), info.getName() + "." + info.getExt(), info.getChunks(), info.getMd5(), uploadFolder);

        if(path != null){
            //文件名
            FileModel fileModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, path);

            if (fileModel != null) {
                com.hengyunsoft.platform.file.entity.file.po.File filePo = dozerUtils.map2(fileModel, com.hengyunsoft.platform.file.entity.file.po.File.class);
                filePo.setSubmittedFileName(info.getSubmittedFileName());
                filePo.setAppId(appId);
                filePo.setAdminId(adminId);
                filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
                filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
                filePo.setCreateUser(adminId);
                filePo.setUpdateUser(adminId);
                filePo.setIcon(IconType.getIcon(filePo.getExt()).getIcon());
                filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getMime()).toString());
                filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                filePo.setFileMd5(info.getMd5());
                filePo.setContextType(fileModel.getMime());
                filePo.setType(com.hengyunsoft.platform.file.constant.FileType.API.toString());
                fileService.save(filePo);
                return Result.success(filePo);
            }
        }


        return Result.fail("合并失败");
    }

    /**
     * 分片上传
     * 该接口不能用作 单文件上传！
     *
     * @param info
     * @param file
     * @return
     */
    @ApiOperation(value = "分片上传", notes = "前端通过webUploader获取截取分片， 然后逐个上传")
    @RequestMapping(value = "/chunkUpload", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> uploadFile(FileUploadDTO info, @RequestParam(value = "file", required = false) MultipartFile file) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        adminId = adminId == null || adminId <= 0 ? info.getUserId() : adminId;
        String uploadFolder = FileUtils.getUploadPathPrefix(appId, fileProperties.getUploadPathPrefix());

        if (file != null && !file.isEmpty()) {    //验证请求不会包含数据上传，所以避免NullPoint这里要检查一下file变量是否为null
            try {

                //将MD5签名和合并后的文件path存入持久层，注意这里这个需求导致需要修改webuploader.js源码3170行
                //因为原始webuploader.js不支持为formData设置函数类型参数，这将导致不能在控件初始化后修改该参数
                if (info.getChunks() <= 0) {   //大小小于单个分片的不会触发 合并操作
//                    if (!wu.saveMd52FileMap(info.getMd5(), target.getName())) {
//                        log.error("文件[" + info.getMd5() + "=>" + target.getName() + "]保存关系到持久成失败，但并不影响文件上传，只会导致日后该文件可能被重复上传而已");
//                    }
                    //文件名
                    String submittedFileName = file.getOriginalFilename();

                    FileModel fileModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, file.getInputStream(), submittedFileName);

                    if (fileModel != null) {
                        com.hengyunsoft.platform.file.entity.file.po.File filePo = dozerUtils.map2(fileModel, com.hengyunsoft.platform.file.entity.file.po.File.class);
                        filePo.setAppId(appId);
                        filePo.setAdminId(adminId);
                        filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
                        filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
                        filePo.setCreateUser(adminId);
                        filePo.setUpdateUser(adminId);
                        filePo.setIcon(IconType.getIcon(filePo.getExt()).getIcon());
                        filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getMime()).toString());
                        filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                        filePo.setType(com.hengyunsoft.platform.file.constant.FileType.API.toString());
                        filePo.setFileMd5(info.getMd5());
                        filePo.setContextType(file.getContentType());
                        fileService.save(filePo);
                    }

                    return Result.success(submittedFileName);
                } else {

                    File target = wu.getReadySpace(info, uploadFolder);    //为上传的文件准备好对应的位置

                    if (target == null) {
                        return Result.fail(wu.getErrorMsg());
                    }
                    file.transferTo(target);    //保存上传文件
                    return Result.success(target.getName());
                }

            } catch (IOException ex) {
                log.error("数据上传失败", ex);
                return Result.fail("数据上传失败");
            }
        }

        log.error("请求参数不完整");
        return Result.fail("请求参数不完整");
    }
}
