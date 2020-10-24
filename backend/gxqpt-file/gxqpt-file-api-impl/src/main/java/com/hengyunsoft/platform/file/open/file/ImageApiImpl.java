//package com.hengyunsoft.platform.file.open.file;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.commons.constant.DeleteStatus;
//import com.hengyunsoft.commons.constant.biz.FileObjectId;
//import com.hengyunsoft.commons.context.BaseContextHandler;
//import com.hengyunsoft.commons.context.CommonConstants;
//import com.hengyunsoft.commons.utils.context.DozerUtils;
//import com.hengyunsoft.platform.file.config.FileProperties;
//import com.hengyunsoft.platform.file.constant.CompressType;
//import com.hengyunsoft.platform.file.constant.IconType;
//import com.hengyunsoft.platform.file.constant.PictureType;
//import com.hengyunsoft.platform.file.constant.ThumMethodType;
//import com.hengyunsoft.platform.file.dto.CustomCompressDTO;
//import com.hengyunsoft.platform.file.dto.UploadCompressDTO;
//import com.hengyunsoft.platform.file.dto.UploadCompressPlusDTO;
//import com.hengyunsoft.platform.file.entity.file.po.File;
//import com.hengyunsoft.platform.file.repository.file.service.FileService;
//import com.hengyunsoft.platform.file.support.FileModel;
//import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
//import com.hengyunsoft.platform.file.utils.FileUtils;
//import com.hengyunsoft.platform.file.utils.ImageCompressUtil;
//import com.hengyunsoft.platform.file.utils.ImageDistinguishUtil;
//import com.hengyunsoft.platform.file.utils.UploadUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/2")
//@Slf4j
//@Api(value = "图片操作", description = "用于图片转换等")
//public class ImageApiImpl {
//
//    @Autowired
//    private FileProperties fileProperties;
//    @Autowired
//    private DozerUtils dozerUtils;
//    @Autowired
//    private FileService fileService;
//
//    @Value("${gxqpt.baiduImageDistinguish.api}")
//    private String api;
//    @Value("${gxqpt.baiduImageDistinguish.clientId}")
//    private String clientId;
//    @Value("${gxqpt.baiduImageDistinguish.clientSecret}")
//    private String clientSecret;
//    @Value("${gxqpt.baiduImageDistinguish.tokenHost}")
//    private String tokenHost;
//
//    /**
//     * 图片自定义压缩
//     *
//     * @param file
//     * @param width
//     * @param height
//     * @param keepRatio
//     * @return
//     */
//    @ApiOperation(value = "图片自定义尺寸缩放", notes = "用于自定尺寸缩放上传图片", tags = "image-edit-distinguish")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
//            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
//            @ApiImplicitParam(name = "width", value = "压缩后的宽度", dataType = "int", paramType = "query"),
//            @ApiImplicitParam(name = "height", value = "压缩后的高度", dataType = "int", paramType = "query"),
//            @ApiImplicitParam(name = "keepRatio", value = "是否保持比例", dataType = "boolean", paramType = "query"),
//    })
//    @RequestMapping(value = "/p/image/compress", method = RequestMethod.POST)
//    public Result<UploadCompressDTO> imageCompress(
//            @RequestParam(value = "userId", required = false) Long userId,
//            @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "width") Integer width,
//            @RequestParam(value = "height") Integer height, @RequestParam(value = "keepRatio") Boolean keepRatio) {
//        //保存原始图
//        CustomCompressDTO customCompressDTO = new CustomCompressDTO();
//        customCompressDTO.setWidth(width);
//        customCompressDTO.setHeight(height);
//        customCompressDTO.setKeepRatio(keepRatio);
//        File baseFile = picBaseMethod(userId, file, customCompressDTO);
//        //保存缩略图
//        customCompressDTO.setThumMethodType(ThumMethodType.THUM_COMPRESS_FOR_SIZE);
//        File compressFile = picBaseMethod(userId, file, customCompressDTO);
//        //转换
//        return Result.success(transFlieDto(baseFile, compressFile));
//    }
//
//    /**
//     * 图片自适应压缩
//     *
//     * @param file
//     * @return id，图片基本信息，图片的访问url，缩略图等
//     * @throws Exception
//     */
//    @ApiOperation(value = "图片自适应比例缩放", notes = "用于自动比例缩放上传图片", tags = "image-edit-distinguish")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
//            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
//    })
//    @RequestMapping(value = "/p/image/compress/auto", method = RequestMethod.POST)
//    public Result<UploadCompressPlusDTO> imageCompressAuto(
//            @RequestParam(value = "userId", required = false) Long userId,
//            @RequestParam(value = "file") MultipartFile file) {
//        CustomCompressDTO customCompressDTO = new CustomCompressDTO();
//        File baseFile = picBaseMethod(userId, file, customCompressDTO);
//        //小号压缩图
//        customCompressDTO.setCompressType(CompressType.SMALL);
//        customCompressDTO.setRate(CompressType.SMALL.getValue());
//        customCompressDTO.setThumMethodType(ThumMethodType.THUM_COMPRESS_FOR_RATIO);
//        File smaFile = picBaseMethod(userId, file, customCompressDTO);
//        //中号压缩图
//        customCompressDTO.setCompressType(CompressType.MIDDLE);
//        customCompressDTO.setRate(CompressType.MIDDLE.getValue());
//        File midFile = picBaseMethod(userId, file, customCompressDTO);
//        //转换
//        return Result.success(transFlieDto(baseFile, smaFile, midFile));
//    }
//
//    /**
//     * 图片旋转
//     *
//     * @param file
//     * @param rotate
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "图片旋转", notes = "用于自定尺寸旋转角度上传图片 ", tags = "image-edit-distinguish")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
//            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
//            @ApiImplicitParam(name = "rotate", value = "旋转角度(顺时针0 ~ 360)", dataType = "float", paramType = "query"),
//    })
//    @RequestMapping(value = "/p/image/rotate", method = RequestMethod.POST)
//    public Result<UploadCompressDTO> imageRotate(
//            @RequestParam(value = "userId", required = false) Long userId,
//            @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "rotate") Float rotate) throws Exception {
//        //保存原始图
//        CustomCompressDTO customCompressDTO = new CustomCompressDTO();
//        File baseFile = picBaseMethod(userId, file, customCompressDTO);
//        //保存旋转图
//        customCompressDTO.setRotate(rotate);
//        customCompressDTO.setThumMethodType(ThumMethodType.THUM_COMPRESSFOR_ROTATE);
//        File compressFile = picBaseMethod(userId, file, customCompressDTO);
//        //转换
//        return Result.success(transFlieDto(baseFile, compressFile));
//    }
//
//    /**
//     * 图片品质压缩
//     *
//     * @param file
//     * @param quality
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "图片品质压缩", notes = "用于原尺寸压缩品质(品质超过0.9可能会超出原尺寸)   ", tags = "image-edit-distinguish")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
//            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
//            @ApiImplicitParam(name = "quality", value = "压缩品质(0 ~ 1)", dataType = "float", paramType = "query"),
//    })
//    @RequestMapping(value = "/p/image/qulity", method = RequestMethod.POST)
//    public Result<UploadCompressDTO> imageQulity(
//            @RequestParam(value = "userId", required = false) Long userId,
//            @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "quality") Float quality) throws Exception {
//        //保存原始图
//        CustomCompressDTO customCompressDTO = new CustomCompressDTO();
//        File baseFile = picBaseMethod(userId, file, customCompressDTO);
//        //保存旋转图
//        quality = quality > 1 ? 1 : quality;
//        customCompressDTO.setQuality(quality);
//        customCompressDTO.setThumMethodType(ThumMethodType.THUM_COMPRESS_QUALITY);
//        File compressFile = picBaseMethod(userId, file, customCompressDTO);
//        //转换
//        return Result.success(transFlieDto(baseFile, compressFile));
//    }
//
//    /**
//     * 图片格式修改
//     *
//     * @param file
//     * @param format
//     * @return
//     * @throws Exception
//     */
//    @ApiOperation(value = "图片格式修改", notes = "用于修改图片格式  ", tags = "image-edit-distinguish")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
//            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
//            @ApiImplicitParam(name = "format", value = "类型转换(jpg,png,gif)", dataType = "string", paramType = "query"),
//    })
//    @RequestMapping(value = "/p/image/format", method = RequestMethod.POST)
//    public Result<UploadCompressDTO> imageFormat(
//            @RequestParam(value = "userId", required = false) Long userId,
//            @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "format") String format) throws Exception {
//        //保存原始图
//        CustomCompressDTO customCompressDTO = new CustomCompressDTO();
//        File baseFile = picBaseMethod(userId, file, customCompressDTO);
//        //保存新类型图
//        if (format != null) {
//            format = format.toUpperCase();
//            customCompressDTO.setPictureType(PictureType.valueOf(format));
//        }
//        customCompressDTO.setThumMethodType(ThumMethodType.THUM_FORMAT);
//        File compressFile = picBaseMethod(userId, file, customCompressDTO);
//        //转换
//        return Result.success(transFlieDto(baseFile, compressFile));
//    }
//
////    /**
////     * 图片水印
////     *
////     * @param file
////     * @param waterfile
////     * @param alpha
////     * @return
////     * @throws Exception
////     */
////    @RequestMapping(value = "/image/waterpic", method = RequestMethod.POST)
////    public Result<UploadCompressListDTO> imageWaterpic(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "waterfile") MultipartFile waterfile, @RequestParam(value = "alpha") Float alpha) throws Exception {
////        //保存原始图
////        CustomCompressDTO customCompressDTO = new CustomCompressDTO();
////        File baseFile = picBaseMethod(file, customCompressDTO);
////        //保存水印图
////        customCompressDTO.setWaterFile(waterfile);
////        customCompressDTO.setAlpha(alpha);
////        customCompressDTO.setThumMethodType(ThumMethodType.THUM_WATERMARK);
////        customCompressDTO.setWaterFile(waterfile);
////        File compressFile = picBaseMethod(file, customCompressDTO);
////        //转换
////        UploadCompressDTO baseUploadCompressDTO = dozerUtils.map(baseFile, UploadCompressDTO.class);
////        UploadCompressDTO compressUploadCompressDTO = dozerUtils.map(compressFile, UploadCompressDTO.class);
////        List<UploadCompressDTO> list = new ArrayList<>();
////        list.add(baseUploadCompressDTO);
////        list.add(compressUploadCompressDTO);
////        UploadCompressListDTO uploadCompressListDTO = new UploadCompressListDTO();
////        if (list.size() > 0) {
////            uploadCompressListDTO.setList(list);
////            return Result.success(uploadCompressListDTO);
////        }
////        return Result.success(null);
////    }
//
//    /**
//     * 图片处理接口工具
//     *
//     * @param file
//     * @param customCompressDTO
//     * @return
//     */
//    private File picBaseMethod(Long userId, MultipartFile file, CustomCompressDTO customCompressDTO) {
//        //1，先将文件存在本地,并且生成文件名
//        List<File> fileList = new ArrayList<>();
//        String appId = BaseContextHandler.getAppId();
//
//        // 忽略路径字段,只处理文件类型
//        if (file != null && !file.isEmpty()) {
//            //文件名
//            String submittedFileName = file.getOriginalFilename();
//            //后缀
//            String suffix = FileUtils.getExtension(submittedFileName);
//            //生成文件名
//            StringBuffer stringBuffer = new StringBuffer();
//            stringBuffer.append(UUID.randomUUID().toString());
//            //匹配自适应缩放等级的后缀
//            if (customCompressDTO.getCompressType() != null) {
//                stringBuffer.append(customCompressDTO.getCompressType().getType());
//            }
//            //匹配格式转换的类型后缀
//            if (customCompressDTO.getPictureType() != null) {
//                stringBuffer.append(customCompressDTO.getPictureType().getType());
//                submittedFileName = FileUtils.getPicName(submittedFileName) + customCompressDTO.getPictureType().getType();
//            } else {
//                stringBuffer.append(suffix);
//            }
//            String fileName = stringBuffer.toString();
//
//            try {
//                //日期文件夹
//                String secDir = LocalDate.now().format(FileOpenApiImpl.DTF);
//                // /home/tyh/APP_ID/YYYY/MM
//                String relativePath = Paths.get(appId, secDir).toString();
//                String absolutePath = Paths.get(fileProperties.getUploadPathPrefix(), relativePath).toString();
//
//                //存到web服务器
//                if (customCompressDTO.getThumMethodType() == null) {
//                    //原文件直接存
//                    FileUtils.write(file.getInputStream(), absolutePath, fileName);
//                } else {
//                    //非原文件则进行图片编辑操作选择
//                    switch (customCompressDTO.getThumMethodType()) {
//                        case THUM_FORMAT:
//                            ImageCompressUtil.thumFormat(file, absolutePath, fileName, customCompressDTO.getPictureType().getType());
//                            break;
//                        case THUM_WATERMARK:
//                            ImageCompressUtil.thumWatermark(file, customCompressDTO.getWaterFile(), absolutePath, customCompressDTO.getAlpha(), fileName);
//                            break;
//                        case THUM_COMBINATION:
//                            ImageCompressUtil.thumCombination(file, absolutePath, fileName, customCompressDTO.getWidth(),
//                                    customCompressDTO.getHeight(), customCompressDTO.isKeepRatio(), customCompressDTO.getRotate(),
//                                    customCompressDTO.getQuality(), customCompressDTO.getPictureType().getType());
//                            break;
//                        case THUM_COMPRESS_QUALITY:
//                            ImageCompressUtil.thumCompressQuality(file, absolutePath, fileName, customCompressDTO.getQuality());
//                            break;
//                        case THUM_COMPRESS_FOR_SIZE:
//                            ImageCompressUtil.thumCompressForSize(file, absolutePath, fileName, customCompressDTO.getWidth(), customCompressDTO.getHeight(), customCompressDTO.isKeepRatio());
//                            break;
//                        case THUM_COMPRESS_FOR_RATIO:
//                            ImageCompressUtil.thumCompressForRatio(file, absolutePath, fileName, customCompressDTO.getRate());
//                            break;
//                        case THUM_COMPRESSFOR_ROTATE:
//                            ImageCompressUtil.thumCompressForRotate(file, absolutePath, fileName, customCompressDTO.getRotate());
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                //上传到fastdfs 并且返回 访问 url
//                FileModel fileModel = UploadUtil.remove2DFS(appId, FileObjectId.UPLOAD.toString(),
//                        fileProperties, absolutePath, relativePath, fileName);
//
//                if (fileModel != null) {
//                    File filePo = dozerUtils.map(fileModel, File.class);
//                    filePo.setSubmittedFileName(submittedFileName);
//                    filePo.setAppId(appId);
//                    filePo.setAdminId(userId);
//                    filePo.setFolderId(CommonConstants.PARENT_ID_DEF);
//                    filePo.setCreateUser(userId);
//                    filePo.setUpdateUser(userId);
//                    filePo.setTreePath(CommonConstants.ROOT_PATH_DEF);
//                    filePo.setIcon(IconType.getIcon(filePo.getMime()).getIcon());
//                    filePo.setDataType(FileDataTypeUtil.getDataType(filePo.getExt()).toString());
//                    filePo.setIsDelete(DeleteStatus.UN_DELETE.getVal());
//                    filePo.setType(com.hengyunsoft.platform.file.constant.FileType.API.toString());
//                    fileList.add(filePo);
//                }
//            } catch (Exception e) {
//                log.error("保存文件到服务器临时目录失败:", e);
//            }
//
//            //存储
//            if (!fileList.isEmpty()) {
//                fileService.save(fileList);
//            }
//        }
//        return fileList.get(0);
//    }
//
//    /**
//     * 返回实体合并
//     *
//     * @param baseFile     基础图像
//     * @param compressFile 转换图像
//     * @return
//     */
//    private UploadCompressDTO transFlieDto(File baseFile, File compressFile) {
//        //获取转换DTO
//        UploadCompressDTO baseUploadCompressDTO = dozerUtils.map(baseFile, UploadCompressDTO.class);
//        UploadCompressDTO compressUploadCompressDTO = dozerUtils.map(compressFile, UploadCompressDTO.class);
//
//        //合并
//        baseUploadCompressDTO.setTransSize(compressUploadCompressDTO.getSize());
//        baseUploadCompressDTO.setTransUrl(compressUploadCompressDTO.getUrl());
//        return baseUploadCompressDTO;
//    }
//
//    /**
//     * 返回实体合并(自适应缩放比例)
//     *
//     * @param baseFile 基础图像
//     * @param smaFile  转换小图像
//     * @param midFile  转换大图像
//     * @return
//     */
//    private UploadCompressPlusDTO transFlieDto(File baseFile, File smaFile, File midFile) {
//        //获取转换DTO
//        UploadCompressPlusDTO baseUploadCompressPlusDTO = dozerUtils.map(baseFile, UploadCompressPlusDTO.class);
//        UploadCompressDTO smallUploadCompressDTO = dozerUtils.map(smaFile, UploadCompressDTO.class);
//        UploadCompressDTO middleUploadCompressDTO = dozerUtils.map(midFile, UploadCompressDTO.class);
//
//        //合并
//        baseUploadCompressPlusDTO.setSmallSize(smallUploadCompressDTO.getSize());
//        baseUploadCompressPlusDTO.setSmallUrl(smallUploadCompressDTO.getUrl());
//        baseUploadCompressPlusDTO.setMidSize(middleUploadCompressDTO.getSize());
//        baseUploadCompressPlusDTO.setMidUrl(middleUploadCompressDTO.getUrl());
//        return baseUploadCompressPlusDTO;
//    }
//
//    /**
//     * 图片识别(百度接口)
//     *
//     * @param file
//     * @return
//     */
//    @ApiOperation(value = "图片识别", notes = "用于识别图中文字", tags = "image-edit-distinguish")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "form"),
//    })
//    @RequestMapping(value = "/p/image/distinguish", method = RequestMethod.POST)
//    public Result<String> imageDistinguish(@RequestParam(value = "file") MultipartFile file) {
//        //调用方法类获取返回值
//        String json = ImageDistinguishUtil.general(file, api, clientId, clientSecret, tokenHost);
//        //判断非空
//        if (json == null) {
//            return Result.fail("fail");
//        }
//        return Result.success(json);
//    }
//
//
//}
