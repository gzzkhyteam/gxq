package com.hengyunsoft.platform.file.open.file;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.biz.FileObjectId;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.CompressType;
import com.hengyunsoft.platform.file.constant.DataType;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.constant.PictureType;
import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.BaseFileModel;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.CommonContants;
import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
import com.hengyunsoft.platform.file.utils.FileUtils;
import com.hengyunsoft.platform.file.utils.ImageDistinguishUtil;
import com.hengyunsoft.platform.file.utils.UploadUtil;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@Slf4j
@Api(value = "图片操作", description = "用于图片转换等")
public class Image2ApiImpl {

    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileService fileService;

    //128m, 单位字节
    private final static long MAX_SIZE = 128 * 1024 * 1024L;

    @Value("${gxqpt.baiduImageDistinguish.api}")
    private String api;
    @Value("${gxqpt.baiduImageDistinguish.clientId}")
    private String clientId;
    @Value("${gxqpt.baiduImageDistinguish.clientSecret}")
    private String clientSecret;
    @Value("${gxqpt.baiduImageDistinguish.tokenHost}")
    private String tokenHost;

    /**
     * 图片旋转
     *
     * @param file
     * @param rotate
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "图片旋转", notes = "用于自定尺寸旋转角度上传图片 ", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id 若没有则填写 -1", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "rotate", value = "旋转角度(顺时针0 ~ 360)", dataType = "float", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 62503, message = "旋转角度不能为空"),
            @ApiResponse(code = 60100, message = "文件为空"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
            @ApiResponse(code = 62504, message = "旋转角度不在0 ~ 360范围之内"),
            @ApiResponse(code = 63006, message = "文件大小不能超过128M"),
    })
    @RequestMapping(value = "/p/image/rotate", method = RequestMethod.POST)
    public Result<BaseFileDTO> imageRotate(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "rotate", required = false) Float rotate)
            throws Exception {
        //校验
        BizAssert.assertNotNull(FileExceptionCode.RORATE_ANGLE_NULL, rotate);
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, file);
        BizAssert.assertTrue(FileExceptionCode.RORATE_BETWEEN, rotate < 360 && rotate > 0);
        BizAssert.assertFalse(FileExceptionCode.IMAGE_SIZE_BIG_128, file.getSize() > MAX_SIZE);
        String appId = BaseContextHandler.getAppId();
        String submittedFileName = file.getOriginalFilename();

//        rotate = rotate < 360 && rotate > 0 ? rotate : 0;
//        if (rotate == 0) {
//            return Result.fail("旋转角度不在0 ~ 360范围之内");
//        }

        // 获得文件后缀名
        String fName = file.getOriginalFilename();
        String fileSuffix = fName.substring(fName.lastIndexOf(".") + 1, fName.length());
        if (!CommonContants.IMAGE_MANAGER_ALLOW_TYPE.contains(fileSuffix)) {
            return Result.fail(FileExceptionCode.IMAGE_DATA_TYPE_ERROR);
        }

        //上传原始文件
        //FileModel fileModel = UploadUtil.uploadNotDelete(appId, FileObjectId.UPLOAD.toString(), fileProperties, file.getInputStream(), submittedFileName);
        //if (fileModel == null || StringUtils.isEmpty(fileModel.getRemotePath())) {
        //    return Result.fail("上传文件失败");
        //}

        BaseFileModel bfm = UploadUtil.getBaseFileModel(appId, fileProperties.getUploadPathPrefix(), submittedFileName);
        String absolutePath = bfm.getAbsolutePath();
        String fileName = bfm.getFilename();
        //新文件本地路径
        StringBuilder newFilePath = new StringBuilder();
        newFilePath.append(absolutePath)
                .append(java.io.File.separator)
                .append(FileUtils.getPicName(fileName))
                .append(CompressType.CUSTOM.getType())
                .append(FileUtils.getExtension(fileName));

        //通过工具类转换图片
        Thumbnails.of(file.getInputStream()).scale(1).rotate(rotate).toFile(newFilePath.toString());

        //上传图片
        FileModel newImageModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, newFilePath.toString());

        //File orFile = file(appId, userId, fileModel);
        //orFile.setContextType(file.getContentType());
        File nFile = file(appId, userId, newImageModel);
        nFile.setContextType(file.getContentType());
        nFile.setSubmittedFileName(submittedFileName);
        //fileService.saveSelective(orFile);
        fileService.saveSelective(nFile);

        //BaseFileDTO originalFile = dozerUtils.map2(fileModel, BaseFileDTO.class);
        //originalFile.setId(orFile.getId());
        BaseFileDTO newFile = dozerUtils.map2(newImageModel, BaseFileDTO.class);
        newFile.setId(nFile.getId());

        //if(fileProperties.getFastdfs().isEnabled()){
        //    String toBeDeleted = Paths.get(fileModel.getAbsolutePath(), fileModel.getFilename()).toString();
        //    FileUtils.deleteFileOn(toBeDeleted);
        //}
        return Result.success(newFile);
    }

    //}

    /**
     * 图片自定义压缩
     *
     * @param file
     * @param width
     * @param height
     * @param keepRatio
     * @return
     */
    @ApiOperation(value = "图片基础信息", notes = "用于自定尺寸缩放上传图片。 keepRatio参数成true后，缩略图将保持原始图像的宽高比, 并返回图片基础信息", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "width", value = "压缩后的宽度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "height", value = "压缩后的高度", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "keepRatio", value = "是否保持比例（优先级高于宽/高）", dataType = "boolean", paramType = "query", example = "true,false"),
            @ApiImplicitParam(name = "userId", value = "用户id 若没有则填写 -1", dataType = "long", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
            @ApiResponse(code = 61000, message = "图片宽度不能小于或等于0"),
            @ApiResponse(code = 61001, message = "图片高度不能小于或等于0"),
    })
    @RequestMapping(value = "/p/image/compress", method = RequestMethod.POST)
    public Result<BaseFileDTO> imageCompress(
            @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "width", defaultValue = "0") Integer width,
            @RequestParam(value = "height", defaultValue = "0") Integer height, @RequestParam(value = "keepRatio", defaultValue = "false") Boolean keepRatio,
            @RequestParam(value = "userId", required = false) Long userId
    ) throws IOException {
        BizAssert.assertTrue(FileExceptionCode.IMAGE_WIDTH_TOO_SMALL, width > 0);
        BizAssert.assertTrue(FileExceptionCode.IMAGE_HEIGHT_TOO_SMALL, height > 0);
        String appId = BaseContextHandler.getAppId();
        String submittedFileName = file.getOriginalFilename();

        BaseFileModel bfm = UploadUtil.getBaseFileModel(appId, fileProperties.getUploadPathPrefix(), submittedFileName);
        String absolutePath = bfm.getAbsolutePath();
        String fileName = bfm.getFilename();

        //新文件本地路径
        StringBuilder newFilePath = new StringBuilder();
        newFilePath.append(absolutePath)
                .append(java.io.File.separator)
                .append(FileUtils.getPicName(fileName))
                .append(CompressType.CUSTOM.getType())
                .append(FileUtils.getExtension(fileName));

        //通过工具类转换图片
        Thumbnails.of(file.getInputStream()).size(width, height).keepAspectRatio(keepRatio).toFile(newFilePath.toString());

        //上传图片
        FileModel newImageModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, newFilePath.toString());

        File nFile = file(appId, userId, newImageModel);
        nFile.setContextType(file.getContentType());
        nFile.setSubmittedFileName(submittedFileName);
        fileService.saveSelective(nFile);

        BaseFileDTO newFile = dozerUtils.map2(newImageModel, BaseFileDTO.class);
        newFile.setId(nFile.getId());

        return Result.success(newFile);
    }

    private File file(String appId, Long userId, FileModel fileModel) {
        File filePo = dozerUtils.map2(fileModel, File.class);
        filePo.setAppId(appId);
        filePo.setAdminId(userId);
        filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
        filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
        filePo.setCreateUser(userId);
        filePo.setUpdateUser(userId);
        filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        filePo.setIcon(IconType.getIcon(filePo.getExt()).getIcon());
        filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getMime()).toString());
        filePo.setType(com.hengyunsoft.platform.file.constant.FileType.API.toString());
        return filePo;
    }


    /**
     * 图片自适应压缩
     *
     * @param file
     * @return id，图片基本信息，图片的访问url，缩略图等
     * @throws Exception
     */
    @ApiOperation(value = "缩略图", notes = "用于自动比例缩放上传图片", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id 若没有则填写 -1", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
    })
    @RequestMapping(value = "/p/image/autocompress", method = RequestMethod.POST)
    public Result<BaseFileDTO> imageCompressAuto(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "file") MultipartFile file) throws IOException {
        String appId = BaseContextHandler.getAppId();
        String submittedFileName = file.getOriginalFilename();
        //上传原始文件
        BaseFileModel bfm = UploadUtil.getBaseFileModel(appId, fileProperties.getUploadPathPrefix(), submittedFileName);
        String absolutePath = bfm.getAbsolutePath();
        String fileName = bfm.getFilename();
        //新文件本地路径
        StringBuilder newFilePath = new StringBuilder();
        newFilePath.append(absolutePath)
                .append(java.io.File.separator)
                .append(FileUtils.getPicName(fileName))
                .append(CompressType.CUSTOM.getType())
                .append(FileUtils.getExtension(fileName));

        //通过工具类转换图片
        Thumbnails.of(file.getInputStream()).scale(CompressType.SMALL.getValue()).toFile(newFilePath.toString());

        //上传图片
        FileModel newImageModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, newFilePath.toString());

        File nFile = file(appId, userId, newImageModel);
        nFile.setContextType(file.getContentType());
        nFile.setSubmittedFileName(submittedFileName);
        fileService.saveSelective(nFile);

        BaseFileDTO newFile = dozerUtils.map2(newImageModel, BaseFileDTO.class);
        newFile.setId(nFile.getId());

        return Result.success(newFile);
    }


    /**
     * 图片品质压缩
     *
     * @param file
     * @param quality
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "图片品质压缩", notes = "用于原尺寸压缩品质(品质超过0.9可能会超出原尺寸)   ", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id 若没有则填写 -1", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "quality", value = "压缩品质(0 ~ 1)", dataType = "float", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 60100, message = "文件为空"),
            @ApiResponse(code = 62502, message = "压缩品质不能为空"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
            @ApiResponse(code = 63004, message = "图片类型错误或者图片的尺寸过小无法识别"),
            @ApiResponse(code = 62505, message = "压缩品质不在0 ~ 1范围之内"),
            @ApiResponse(code = 62506, message = "图片格式不支持或非图片传入"),
    })
    @RequestMapping(value = "/p/image/qulity", method = RequestMethod.POST)
    public Result<BaseFileDTO> imageQulity(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "quality", required = false) Float quality) throws IOException {

        //校验
        BizAssert.assertNotNull(FileExceptionCode.IMAGE_QUALITY_NULL, quality);
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, file);
        BizAssert.assertTrue(FileExceptionCode.IMAGE_QUALITY_BETWEEN, quality < 1 && quality > 0);

        // 获得文件后缀名
        String fName = file.getOriginalFilename();
        String fileSuffix = fName.substring(fName.lastIndexOf(".") + 1, fName.length());
        if (!CommonContants.IMAGE_MANAGER_ALLOW_TYPE.contains(fileSuffix)) {
            return Result.fail(FileExceptionCode.IMAGE_TYPE_NOT_MATCH);
        }

        String appId = BaseContextHandler.getAppId();
        String submittedFileName = file.getOriginalFilename();
        BaseFileModel bfm = UploadUtil.getBaseFileModel(appId, fileProperties.getUploadPathPrefix(), submittedFileName);
        String absolutePath = bfm.getAbsolutePath();
        String fileName = bfm.getFilename();


        //新文件本地路径
        StringBuilder newFilePath = new StringBuilder();
        newFilePath.append(absolutePath)
                .append(java.io.File.separator)
                .append(FileUtils.getPicName(fileName))
                .append(CompressType.CUSTOM.getType())
                .append(FileUtils.getExtension(fileName));

        //通过工具类转换图片
        int[] result = getImgWidth(file);
        Thumbnails.of(file.getInputStream()).size(result[0], result[1]).outputQuality(quality).toFile(newFilePath.toString());

        //上传图片
        FileModel newImageModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, newFilePath.toString());

        File nFile = file(appId, userId, newImageModel);
        nFile.setContextType(file.getContentType());
        nFile.setSubmittedFileName(submittedFileName);
        fileService.saveSelective(nFile);

        BaseFileDTO newFile = dozerUtils.map2(newImageModel, BaseFileDTO.class);
        newFile.setId(nFile.getId());

        return Result.success(newFile);
    }


    /**
     * 获取图片宽度
     *
     * @param file 图片文件
     * @return 宽度
     */
    public static int[] getImgWidth(MultipartFile file) {
//        InputStream is = null;
        BufferedImage src;
        int result[] = {0, 0};
        try (InputStream is = file.getInputStream()) {

            src = javax.imageio.ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图宽
            result[1] = src.getHeight(null); // 得到源图高

            if (result[0] <= 0 && result[1] <= 0) {
                throw new BizException(FileExceptionCode.IMAGE_MINE_TYPE_SIZE_ERROR.getCode(), FileExceptionCode.IMAGE_MINE_TYPE_SIZE_ERROR.getMsg());
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(FileExceptionCode.IMAGE_MINE_TYPE_SIZE_ERROR.getCode(), FileExceptionCode.IMAGE_MINE_TYPE_SIZE_ERROR.getMsg());
        }
        return result;
    }


    /**
     * 图片格式修改
     *
     * @param file
     * @param format
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "图片格式修改", notes = "用于修改图片格式  ", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id 若没有则填写 -1", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "format", value = "类型转换(jpg,png,gif)", dataType = "string", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
            @ApiResponse(code = 63003, message = "转换的图片类型只能为(jpg,png,gif)"),
            @ApiResponse(code = 63004, message = "图片类型错误或者图片的尺寸过小无法识别"),
    })
    @RequestMapping(value = "/p/image/format", method = RequestMethod.POST)
    public Result<BaseFileDTO> imageFormat(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "format") String format) throws IOException {
        //保存新类型图
        PictureType pt = PictureType.JPG;
        if (format != null) {
            boolean flag = Arrays.asList(PictureType.values()).stream().anyMatch((val) -> val.toString().equalsIgnoreCase(format));
            BizAssert.assertTrue(FileExceptionCode.IMAGE_MIME_TYPE_ERROR, flag);
            String format2 = format.toUpperCase();
            pt = PictureType.valueOf(format2);
        }

        String appId = BaseContextHandler.getAppId();
        String submittedFileName = file.getOriginalFilename();
        //生成文件名
        BaseFileModel bfm = UploadUtil.getBaseFileModel(appId, fileProperties.getUploadPathPrefix(), submittedFileName);
        String absolutePath = bfm.getAbsolutePath();
        String fileName = bfm.getFilename();

        //新文件本地路径
        StringBuilder newFilePath = new StringBuilder();
        newFilePath.append(absolutePath)
                .append(java.io.File.separator)
                .append(FileUtils.getPicName(fileName))
                .append(CompressType.CUSTOM.getType())
                .append(pt.getType());

        //通过工具类转换图片
        int[] result = getImgWidth(file);
        Thumbnails.of(file.getInputStream()).size(result[0], result[1]).outputFormat(pt.toString().toLowerCase()).toFile(newFilePath.toString());

        //上传图片
        FileModel newImageModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, newFilePath.toString());

        File nFile = file(appId, userId, newImageModel);
        nFile.setContextType(file.getContentType());
        nFile.setSubmittedFileName(submittedFileName);
        fileService.saveSelective(nFile);

        BaseFileDTO newFile = dozerUtils.map2(newImageModel, BaseFileDTO.class);
        newFile.setId(nFile.getId());
        return Result.success(newFile);
    }


    /**
     * 图片识别(百度接口)
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "图片识别", notes = "用于识别图中文字， 大小不超过4M", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "form"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
            @ApiResponse(code = 63006, message = "文件大小不能超过4M"),
    })
    @RequestMapping(value = "/p/image/distinguish", method = RequestMethod.POST)
    public Result<String> imageDistinguish(@RequestParam(value = "file") MultipartFile file) {
        BizAssert.assertFalse(FileExceptionCode.IMAGE_SIZE_BIG_4, file.getSize() > 4 * 1024 * 1024L);
        BizAssert.assertEquals(FileExceptionCode.IMAGE_DATA_TYPE_ERROR, DataType.IMAGE.toString(), FileDataTypeUtil.getDataType(file.getContentType()).toString());
        //调用方法类获取返回值
        String json = ImageDistinguishUtil.general(file, api, clientId, clientSecret, tokenHost);


        //判断非空
        if (json == null) {
            return Result.fail("上传失败");
        }
        return Result.success(json);
    }

    /**
     * 图片文字介绍信息读取
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "图片文字介绍信息读取", notes = "读取图片的文字介绍等信息", tags = "image-edit-distinguish")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "form"),
            @ApiImplicitParam(name = "desc", value = "描述", dataType = "String", paramType = "form"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 63002, message = "图片类型错误"),
            @ApiResponse(code = 63006, message = "文件大小不能超过4M"),
    })
    @RequestMapping(value = "/p/image/introduction", method = RequestMethod.POST)
    public Result<String> imageIntroduction(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "desc", required = false) String desc) {
        BizAssert.assertFalse(FileExceptionCode.IMAGE_SIZE_BIG_4, file.getSize() > 4 * 1024 * 1024L);
        BizAssert.assertEquals(FileExceptionCode.IMAGE_DATA_TYPE_ERROR, DataType.IMAGE.toString(), FileDataTypeUtil.getDataType(file.getContentType()).toString());
        //调用方法类获取返回值
//        Map map = null;
//        try {
//            map = ExifUtil.getPicDetail(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        //判断非空
//        if (map == null) {
//            return Result.fail("读取失败");
//        }
        String ret = file.getOriginalFilename() + (desc == null ? "" : ":" + desc);
        return Result.success(ret);
    }

}
