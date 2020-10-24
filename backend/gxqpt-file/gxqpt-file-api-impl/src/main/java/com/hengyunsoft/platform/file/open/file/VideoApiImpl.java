package com.hengyunsoft.platform.file.open.file;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.biz.FileObjectId;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.WrapsClassUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.DataType;
import com.hengyunsoft.platform.file.constant.FileType;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.dto.AudioExtractionDTO;
import com.hengyunsoft.platform.file.dto.VideoDTO;
import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
import com.hengyunsoft.platform.file.utils.FileUtils;
import com.hengyunsoft.platform.file.utils.UploadUtil;
import com.hengyunsoft.platform.file.utils.VideoUploadUtil;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.regex.Pattern;


/**
 * @author tianai
 * @createTime 2018-02-27
 */
@RestController
@Slf4j
@RequestMapping("/p/video")
@Api(value = "视频上传管理", description = "视频上传管理，用于视频上传,视频截图")
public class VideoApiImpl {

    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 上传视频文件,并获取视频截图
     *
     * @param userId 用户id
     * @param time   截图时间(秒) 默认值：2
     * @param size   截图尺寸(长x宽) 默认值：500x450
     * @param file   视频文件
     * @return 视频对象
     * @throws Exception
     * @author tangyh
     */
    @ApiOperation(value = "视频截图", notes = "上传视频文件， 截图时间默认是第2秒，截图尺寸默认是500x450")
    @ApiResponses({
            @ApiResponse(code = 60104, message = "文件不能为空"),
            @ApiResponse(code = 61500, message = "文件格式必须是视频"),
            @ApiResponse(code = 61501, message = "视频截图的参数不合理"),
            @ApiResponse(code = 61502, message = "视频截图时长参数不合理，请输入0-3600的任意数字"),
            @ApiResponse(code = 61503, message = "视频大小参数不合理，请参考正确格式:500x300"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "视频", dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "time", value = "截图时间(秒) 默认值：2", dataType = "string", paramType = "query", defaultValue = "2"),
            @ApiImplicitParam(name = "size", value = "截图尺寸(长x宽) 默认值：500x450", dataType = "string", paramType = "query", defaultValue = "500x450")
    })
    @RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
    public Result<VideoDTO> uploadVideo(@RequestParam(required = false, value = "userId") Long userId,
                                        @RequestParam(required = false, value = "time", defaultValue = "2") String time,
                                        @RequestParam(required = false, value = "size", defaultValue = "500x450") String size,
                                        @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.FILE_CANT_NULL, file);

        String appId = BaseContextHandler.getAppId();
        // Servlet3.0方式上传文件
        //1，先将文件存在本地,并且生成文件名
        if (file == null || file.isEmpty()) {
            return Result.fail("文件不能空");
        }

        if (StringUtils.isEmpty(time)) {
            time = "2";
        }
        if (StringUtils.isEmpty(size)) {
            size = "500x450";
        }
        //时长参数不合理
        Integer t = WrapsClassUtils.intValueOf(time);
        BizAssert.assertFalse(FileExceptionCode.VIDEO_FORMAT_TIME_PARAM_ERROR, t <= 0 || t >= 60 * 60);
        //尺寸参数不合理
        String pattern = "(\\d+)x(\\d+)";
        BizAssert.assertTrue(FileExceptionCode.VIDEO_FORMAT_SIZE_PARAM_ERROR, Pattern.matches(pattern, size));

        //判断视频类型
        DataType type = FileDataTypeUtil.getDataType(file.getContentType());
        BizAssert.assertEquals(FileExceptionCode.VIDEO_FORMAT, type.toString(), DataType.VIDEO.toString());

        //文件名
        String submittedFileName = file.getOriginalFilename();

        FileModel fileModel = UploadUtil.uploadNotDelete(appId, FileObjectId.FILE.toString(), fileProperties, file.getInputStream(), submittedFileName);
        File filePo = dozerUtils.map(fileModel, File.class);

        //ffmpeg_path插件存放位置可更改，插件在doc目录-视频截图执行插件下
        String imagePath = VideoUploadUtil.processImage(fileProperties.getFfmpegPath(),
                Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString(),
                time, size);
        //String imagePath = VideoUploadUtil.processImg(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString(),
        //        fileProperties.getFfmpegPath());
        if (StringUtils.isEmpty(imagePath) || !new java.io.File(imagePath).exists()) {
            FileUtils.deleteFileOn(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
            if (fileProperties.getFastdfs().isEnabled()) {
                FileManager.getInstance().deleteFile(fileModel.getGroupName(), fileModel.getRemoteFileName());
            }
            return Result.fail(FileExceptionCode.VIDEO_FORMAT_PARAM_ERROR);
        }

        //上传截图
        FileModel imageModel = UploadUtil.upload(appId, FileObjectId.FILE.toString(), fileProperties, imagePath);

        filePo.setScreenshot(imageModel.getRemotePath());
        filePo.setAppId(appId);
        filePo.setAdminId(userId);
        filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
        filePo.setCreateUser(userId);
        filePo.setUpdateUser(userId);
        filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        filePo.setSubmittedFileName(submittedFileName);
        filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getMime()).toString());
        filePo.setIcon(IconType.getIcon(filePo.getExt()).getIcon());
        filePo.setType(FileType.API.toString());
        filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
        filePo.setContextType(file.getContentType());
        fileService.saveSelective(filePo);

        //删除临时文件
        if (fileProperties.getFastdfs().isEnabled()) {
            FileUtils.deleteFileOn(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
            FileUtils.deleteFileOn(Paths.get(imageModel.getAbsolutePath(), imageModel.getFilename()).toString());
        }
        //4,转换
        return Result.success(dozerUtils.map(filePo, VideoDTO.class));
    }

    /**
     * 获取传入视频基本信息
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "视频基本信息", notes = "获取视频文件基本信息")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "视频", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/videoBaseMessage", method = RequestMethod.POST)
    public Result<BaseFileDTO> videoBaseMessage(@RequestParam(value = "file") MultipartFile file) {
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, file);

        String fileOldName = file.getOriginalFilename();


        BaseFileDTO baseFileDTO = new BaseFileDTO(
                null,
                file.getOriginalFilename(),
                null,
                String.valueOf(file.getSize()),
                fileOldName.substring(fileOldName.lastIndexOf('.') + 1),
                null,
                file.getContentType());

        return Result.success(baseFileDTO);
    }

    /**
     * 上传视频文件,并抽取音频
     *
     * @param userId 用户id
     * @param file   视频文件
     * @return 视频对象
     * @throws Exception
     * @author tangyh
     */
    @ApiOperation(value = "视频音频抽取", notes = "上传视频文件,并抽取音频")
    @ApiResponses({
            @ApiResponse(code = 60104, message = "文件不能为空"),
            @ApiResponse(code = 61500, message = "文件格式必须是视频")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "form"),
            @ApiImplicitParam(name = "file", value = "视频", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/audioExtraction", method = RequestMethod.POST)
    public Result<AudioExtractionDTO> audioExtraction(@RequestParam(required = false, value = "userId") Long userId,
                                                      @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.FILE_CANT_NULL, file);

        String appId = BaseContextHandler.getAppId();
        // Servlet3.0方式上传文件
        //1，先将文件存在本地,并且生成文件名
        if (file == null || file.isEmpty()) {
            return Result.fail("文件不能空");
        }

        //判断视频类型
        DataType type = FileDataTypeUtil.getDataType(file.getContentType());
        BizAssert.assertEquals(FileExceptionCode.VIDEO_FORMAT, type.toString(), DataType.VIDEO.toString());

        //文件名
        String submittedFileName = file.getOriginalFilename();

        FileModel fileModel = UploadUtil.uploadNotDelete(appId, FileObjectId.FILE.toString(), fileProperties, file.getInputStream(), submittedFileName);
        File filePo = dozerUtils.map(fileModel, File.class);

        //ffmpeg_path插件存放位置可更改，插件在doc目录-视频截图执行插件下
        String imagePath = VideoUploadUtil.processAudioPath(fileProperties.getFfmpegPath(),
                Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
        //String imagePath = VideoUploadUtil.processImg(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString(),
        //        fileProperties.getFfmpegPath());
        if (StringUtils.isEmpty(imagePath) || !new java.io.File(imagePath).exists()) {
            FileUtils.deleteFileOn(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
            if (fileProperties.getFastdfs().isEnabled()) {
                FileManager.getInstance().deleteFile(fileModel.getGroupName(), fileModel.getRemoteFileName());
            }
            return Result.fail(FileExceptionCode.VIDEO_FORMAT_PARAM_ERROR);
        }

        //上传
        FileModel imageModel = UploadUtil.upload(appId, FileObjectId.FILE.toString(), fileProperties, imagePath);

        filePo.setScreenshot(imageModel.getRemotePath());
        filePo.setAppId(appId);
        filePo.setAdminId(userId);
        filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
        filePo.setCreateUser(userId);
        filePo.setUpdateUser(userId);
        filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        filePo.setSubmittedFileName(submittedFileName);
        filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getMime()).toString());
        filePo.setIcon(IconType.getIcon(filePo.getExt()).getIcon());
        filePo.setType(FileType.API.toString());
        filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
        filePo.setContextType(file.getContentType());
        fileService.saveSelective(filePo);

        //删除临时文件
        if (fileProperties.getFastdfs().isEnabled()) {
            FileUtils.deleteFileOn(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
            FileUtils.deleteFileOn(Paths.get(imageModel.getAbsolutePath(), imageModel.getFilename()).toString());
        }
        //4,转换
        return Result.success(dozerUtils.map(filePo, AudioExtractionDTO.class));
    }

    /**
     * 上传视频文件,并截取片段
     *
     * @param userId 用户id
     * @param file   视频文件
     * @return 视频对象
     * @throws Exception
     * @author tangyh
     */
    @ApiOperation(value = "视频音频抽取", notes = "上传视频文件,并抽取音频")
    @ApiResponses({
            @ApiResponse(code = 60104, message = "文件不能为空"),
            @ApiResponse(code = 61500, message = "文件格式必须是视频")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "form"),
            @ApiImplicitParam(name = "file", value = "视频", dataType = "file", paramType = "form"),
            @ApiImplicitParam(name = "startTime", value = "截图时间(秒) 默认值：2", dataType = "string", paramType = "form", defaultValue = "0"),
            @ApiImplicitParam(name = "endTime", value = "截图时间(秒) 默认值：2", dataType = "string", paramType = "form", defaultValue = "2")
    })
    @RequestMapping(value = "/videoConverter", method = RequestMethod.POST)
    public Result<AudioExtractionDTO> videoConverter(@RequestParam(required = false, value = "userId") Long userId,
                                                     @RequestParam(value = "file", required = false) MultipartFile file,
                                                     @RequestParam(required = false, value = "startTime") String startTime,
                                                     @RequestParam(required = false, value = "endTime") String endTime) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.FILE_CANT_NULL, file);

        String appId = BaseContextHandler.getAppId();
        // Servlet3.0方式上传文件
        //1，先将文件存在本地,并且生成文件名
        if (file == null || file.isEmpty()) {
            return Result.fail("文件不能空");
        }

        if (StringUtils.isEmpty(startTime)) {
            startTime = "0";
        }

        if (StringUtils.isEmpty(endTime)) {
            endTime = "2";
        }

        //判断视频类型
        DataType type = FileDataTypeUtil.getDataType(file.getContentType());
        BizAssert.assertEquals(FileExceptionCode.VIDEO_FORMAT, type.toString(), DataType.VIDEO.toString());

        //文件名
        String submittedFileName = file.getOriginalFilename();

        FileModel fileModel = UploadUtil.uploadNotDelete(appId, FileObjectId.FILE.toString(), fileProperties, file.getInputStream(), submittedFileName);
        File filePo = dozerUtils.map(fileModel, File.class);

        //ffmpeg_path插件存放位置可更改，插件在doc目录-视频截图执行插件下
        String imagePath = VideoUploadUtil.videoConverter(fileProperties.getFfmpegPath(),
                Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString(), startTime, endTime);
        //String imagePath = VideoUploadUtil.processImg(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString(),
        //        fileProperties.getFfmpegPath());
        if (StringUtils.isEmpty(imagePath) || !new java.io.File(imagePath).exists()) {
            FileUtils.deleteFileOn(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
            if (fileProperties.getFastdfs().isEnabled()) {
                FileManager.getInstance().deleteFile(fileModel.getGroupName(), fileModel.getRemoteFileName());
            }
            return Result.fail(FileExceptionCode.VIDEO_FORMAT_PARAM_ERROR);
        }

        //上传
        FileModel imageModel = UploadUtil.upload(appId, FileObjectId.FILE.toString(), fileProperties, imagePath);

        filePo.setScreenshot(imageModel.getRemotePath());
        filePo.setAppId(appId);
        filePo.setAdminId(userId);
        filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
        filePo.setCreateUser(userId);
        filePo.setUpdateUser(userId);
        filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        filePo.setSubmittedFileName(submittedFileName);
        filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getMime()).toString());
        filePo.setIcon(IconType.getIcon(filePo.getExt()).getIcon());
        filePo.setType(FileType.API.toString());
        filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
        filePo.setContextType(file.getContentType());
        fileService.saveSelective(filePo);

        //删除临时文件
        if (fileProperties.getFastdfs().isEnabled()) {
            FileUtils.deleteFileOn(Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString());
            FileUtils.deleteFileOn(Paths.get(imageModel.getAbsolutePath(), imageModel.getFilename()).toString());
        }
        //4,转换
        return Result.success(dozerUtils.map(filePo, AudioExtractionDTO.class));
    }
}
