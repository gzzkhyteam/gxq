package com.hengyunsoft.platform.file.open.file;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.biz.FileObjectId;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.config.SwfProperties;
import com.hengyunsoft.platform.file.converter.pdfConverter.OpenOfficePDFConverter;
import com.hengyunsoft.platform.file.converter.pdfConverter.PDFConverter;
import com.hengyunsoft.platform.file.converter.swfConverter.SWFConverter;
import com.hengyunsoft.platform.file.converter.swfConverter.SWFToolsSWFConverter;
import com.hengyunsoft.platform.file.converter.utils.EncodeFormatTransfer;
import com.hengyunsoft.platform.file.converter.utils.FileUtils;
import com.hengyunsoft.platform.file.dto.FileSwfDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.repository.file.dao.FileMapper;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.Config;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.DocConverter;
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
import springfox.documentation.annotations.ApiIgnore;

import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author tianai
 * @createTime 2018-02-27
 */
@RestController
@Slf4j
@RequestMapping("/p/swf")
@Api(value = "文档转swf", description = "其他文件格式(doc、docx、ppt、pptx、txt、xls、xlsx)转swf")
public class SwfApiImpl  {
    private final static String TRANSFAR = ".transfar";
    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");
    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private SwfProperties swfProperties;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileMapper fileMapper;


    /**
     * 文档转swf 【弃用】
     * @param id
     * @return
     */
    @Deprecated
    @ApiIgnore
    @ApiOperation(value = "文档转swf 【弃用】", notes = "其他文件格式(doc、docx、ppt、pptx、txt、xls、xlsx)转swf")
    @ApiResponses({
            @ApiResponse(code = 60103, message = "文件id为空"),
            @ApiResponse(code = 62000, message = "文件不存在"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/toSwf2", method = RequestMethod.POST)
    public Result<FileSwfDTO> toSwf2(@RequestParam(value = "id") Long id) {

        BizAssert.assertNotNull(FileExceptionCode.FILE_ID_NULL, id);
        String appId = BaseContextHandler.getAppId();
        File file = fileService.getByAppIdAndId(appId, id);
        if (file == null) {
            return Result.fail(FileExceptionCode.FILE_NOT_EXIST);
        }
        String ext = file.getExt();
        String swfUrl = file.getSwf();
        String absolutePath = file.getAbsolutePath();
        String filename = file.getFilename();
        String fileNameUrl = org.apache.commons.lang3.StringUtils.substringBefore(filename, ".");
        if (null != ext && ext.equals("swf")) {
            file.setSwf(file.getUrl());
            return Result.success(dozerUtils.map(file, FileSwfDTO.class));
        }
        if (null != swfUrl && swfUrl != "") {
            return Result.success(dozerUtils.map(file, FileSwfDTO.class));
        } else {
            //String fileString = absolutePath + "\\" + filename;
            String filePath = Paths.get(absolutePath, filename).toString();
            log.info("原始文件路径 filePath={} ", filePath);
            log.info("配置 getOfficeHome={} ", swfProperties.getOfficeHome());
            log.info("配置 getSwfToolsPath={} ", swfProperties.getSwfToolsPath());
            log.info("配置 getXpdfChineseSimplified={} ", swfProperties.getXpdfChineseSimplified());
            DocConverter d = new DocConverter(filePath, swfProperties.getXpdfChineseSimplified(), swfProperties.getEnv(), swfProperties.getSwfToolsPath(),
                    swfProperties.getOfficeHome());
            Boolean conver = d.conver();
            if (conver) {
                //file.setSwf(fileProperties.getRemoteUriPrefix() + file.getRelativePath() + "\\" + fileNameUrl + "_swf.swf");

                String swf = new StringBuilder(fileProperties.getRemoteUriPrefix())
                        .append(file.getRelativePath().replaceAll("\\\\", Config.SEPARATOR))
                        .append(Config.SEPARATOR)
                        .append(fileNameUrl + "_swf.swf").toString();
                file.setSwf(swf);
                //file.setSwf(fileProperties.getRemoteUriPrefix() + Paths.get(file.getRelativePath(),
                //        fileNameUrl + "_swf.swf").toString());
                fileMapper.updateByAppIdAndIdSelective(file);
                return Result.success(dozerUtils.map(file, FileSwfDTO.class));
            } else {
                return Result.fail(FileExceptionCode.CONVER_ERROR);
            }
        }
    }

    /**
     * 文档转swf , 本接口需要服务器安装 openoffice + pdf2swf 2个软件来支持
     * 由于文件上传有2种模式：
     * 模式1: 直接上传到web服务器
     * 模式2：上传到fastDFS服务器
     * <p>
     * 模式1： 路径相对是本地
     * 模式2： 需要将文件先从远程服务器下载到本地，然后在操作,最后将生成的swf文件上传至fastDFS服务器
     *
     * @param id 文件id
     * @return
     */
    @ApiOperation(value = "文档转swf", notes = "其他文件格式(doc、docx、ppt、pptx、txt、xls、xlsx)转swf")
    @ApiResponses({
            @ApiResponse(code = 60103, message = "文件id为空"),
            @ApiResponse(code = 60100, message = "文件为空"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/toSwf", method = RequestMethod.POST)
    public Result<FileSwfDTO> toSwf(@RequestParam(value = "id") Long id) {
        BizAssert.assertNotNull(FileExceptionCode.FILE_ID_NULL, id);
        String appId = BaseContextHandler.getAppId();
        File file = fileService.getByAppIdAndId(appId, id);
        if (file == null) {
            return Result.fail(FileExceptionCode.FILE_NULL);
        }

        //文件后缀就是swf
        String ext = file.getExt();
        if (SWFConverter.SWF_SUFFIX.equalsIgnoreCase("." + ext)) {
            file.setSwf(file.getUrl());
            return Result.success(dozerUtils.map2(file, FileSwfDTO.class));
        }

        //文件上次已经转换过了
        String swfUrl = file.getSwf();
        if (StringUtils.isNotEmpty(swfUrl)) {
            return Result.success(dozerUtils.map2(file, FileSwfDTO.class));
        }

        //获取文件在web服务器的路径。 【模式1】直接获取。 【模式2】先从fastdfs下载到本地
        String absolutePath = file.getAbsolutePath();
        String filename = file.getFilename();
        String filePath = Paths.get(absolutePath, filename).toString(); //文件在web服务器存放的路径

        List<String> deleteFileList = new ArrayList<>();
        if (fileProperties.getFastdfs().isEnabled()) {
            FileManager fileManager = FileManager.getInstance();
            filePath = Paths.get(file.getAbsolutePath(), file.getFilename()).toString();
            fileManager.downloadFile(file.getGroupName(), file.getRemoteFileName(), filePath);
            deleteFileList.add(filePath);
        }

        //由于openoffice 预览时，会出现乱码问题，所以需要根据部署环境进行转码
        if (("txt".equalsIgnoreCase(ext) || "text/plain".equalsIgnoreCase(file.getContextType())) && swfProperties.getEnv() == 2) {
            String transferPath = FileUtils.getFilePrefix(filePath) + TRANSFAR;
            boolean flag = EncodeFormatTransfer.transfer2(filePath, transferPath, swfProperties.getFileEncode());
            if(flag) {
                deleteFileList.add(transferPath);
                filePath = transferPath;
                log.info("transferPath={}", transferPath);
            }
        }

        log.info("原始文件路径 filePath={} ", filePath);
        log.info("配置 getOfficeHome={}, getSwfToolsPath={} ，getXpdfChineseSimplified={}"
                , swfProperties.getOfficeHome()
                , swfProperties.getSwfToolsPath()
                , swfProperties.getXpdfChineseSimplified());

        //filePath转换
        PDFConverter pdfConverter = OpenOfficePDFConverter.getInstance(swfProperties);
        SWFConverter swfConverter = SWFToolsSWFConverter.getInstance(swfProperties);

        // TODO: 2018/6/1  此处报空指针待解决 
        com.hengyunsoft.platform.file.converter.docConverter.DocConverter converter =
                new com.hengyunsoft.platform.file.converter.docConverter.DocConverter(pdfConverter, swfConverter);
        converter.convert(filePath);
        if (!filePath.toLowerCase().endsWith(PDFConverter.PDF_SUFFIX)) {
            deleteFileList.add(FileUtils.getFilePrefix(filePath) + PDFConverter.PDF_SUFFIX); //.pdf
        }

        //window版 中文乱码解决方案为，将jodconverter.jar中DefaultDocumentFormatRegistry.class //txtLoadAndStoreProperties.put("FilterOptions", "utf8"); 注释掉
        //2018年5月10日 21:51:05 by tangyh


        // 拼接
        swfUrl = FileUtils.getFilePrefix(file.getUrl()) + SWFConverter.SWF_SUFFIX;  //swf 的链接
        if (fileProperties.getFastdfs().isEnabled()) {
            //FileModel fileModel = UploadUtil.upload(appId, "FILE", fileProperties,
            //        simpleFile.getInputStream(), submittedFileName);

            //生成的swf的完整路径
            String swfPath = FileUtils.getFilePrefix(filePath) + SWFConverter.SWF_SUFFIX;
            deleteFileList.add(swfPath);
            //生成的swf文件名
            String fileName = FileUtils.getFilePrefix(file.getFilename()) + SWFConverter.SWF_SUFFIX;
            log.info("swfPath={}, fileName={}", swfPath, fileName);

            FileModel fastDFSFile = new FileModel(appId, FileObjectId.FILE.toString(), fileName,
                    absolutePath, file.getRelativePath(), fileProperties.getRemoteUriPrefix(), fileName);

            FileManager.getInstance().upload(fastDFSFile);

            swfUrl = fastDFSFile.getRemotePath();
        }

        log.info("swfUrl={}", swfUrl);
        file.setSwf(swfUrl);
        fileMapper.updateByAppIdAndIdSelective(file);

        if (!deleteFileList.isEmpty()) {
            deleteFileList.forEach((ff) -> {
                try {
                    java.io.File temFile = new java.io.File(ff);
                    log.info("delete file:{}" , ff);
                    if (temFile.exists()) {
                        temFile.delete();
                        log.info("exists delete file:{}" , ff);
                    }
                } catch (Exception e) {
                    log.error("delete error", e);
                }
            });
        }
        return Result.success(dozerUtils.map(file, FileSwfDTO.class));
    }


    @ApiIgnore
    @ApiOperation(value = "文档转swf", notes = "其他文件格式(doc、docx、ppt、pptx、txt、xls、xlsx)转swf")
    @ApiResponses({
            @ApiResponse(code = 60103, message = "文件id为空"),
            @ApiResponse(code = 60100, message = "文件为空"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/toSwf3", method = RequestMethod.POST)
    public Result<FileSwfDTO> toSwf3(@RequestParam(value = "id") Long id) {
        BizAssert.assertNotNull(FileExceptionCode.FILE_ID_NULL, id);
        String appId = BaseContextHandler.getAppId();
        File file = fileService.getByAppIdAndId(appId, id);
        if (file == null) {
            return Result.fail(FileExceptionCode.FILE_NULL);
        }

        //文件后缀就是swf
        String ext = file.getExt();
        if (SWFConverter.SWF_SUFFIX.equalsIgnoreCase("." + ext)) {
            file.setSwf(file.getUrl());
            return Result.success(dozerUtils.map2(file, FileSwfDTO.class));
        }

        //文件上次已经转换过了
        String swfUrl = file.getSwf();
        if (StringUtils.isNotEmpty(swfUrl)) {
            return Result.success(dozerUtils.map2(file, FileSwfDTO.class));
        }

        //获取文件在web服务器的路径。 【模式1】直接获取。 【模式2】先从fastdfs下载到本地
        String absolutePath = file.getAbsolutePath();
        String filename = file.getFilename();
        String filePath = Paths.get(absolutePath, filename).toString(); //文件在web服务器存放的路径

        List<String> deleteFileList = new ArrayList<>();
        if (fileProperties.getFastdfs().isEnabled()) {
            FileManager fileManager = FileManager.getInstance();
            filePath = Paths.get(file.getAbsolutePath(), file.getFilename()).toString();
            fileManager.downloadFile(file.getGroupName(), file.getRemoteFileName(), filePath);
            deleteFileList.add(filePath);
        }

        //由于openoffice 预览时，会出现乱码问题，所以需要根据部署环境进行转码
        if (("txt".equalsIgnoreCase(ext) || "text/plain".equalsIgnoreCase(file.getContextType())) && swfProperties.getEnv() == 2) {
            String transferPath = FileUtils.getFilePrefix(filePath) + TRANSFAR;
            EncodeFormatTransfer.transfer(filePath, transferPath, swfProperties.getFileEncode());
            deleteFileList.add(transferPath);
            filePath = transferPath;
            log.info("transferPath={}", transferPath);
        }

        log.info("原始文件路径 filePath={} ", filePath);
        log.info("配置 getOfficeHome={}, getSwfToolsPath={} ，getXpdfChineseSimplified={}"
                , swfProperties.getOfficeHome()
                , swfProperties.getSwfToolsPath()
                , swfProperties.getXpdfChineseSimplified());

        //filePath转换
        PDFConverter pdfConverter = OpenOfficePDFConverter.getInstance(swfProperties);
        SWFConverter swfConverter = SWFToolsSWFConverter.getInstance(swfProperties);
        com.hengyunsoft.platform.file.converter.docConverter.DocConverter converter =
                new com.hengyunsoft.platform.file.converter.docConverter.DocConverter(pdfConverter, swfConverter);
        converter.convert(filePath);
        deleteFileList.add(FileUtils.getFilePrefix(filePath) + PDFConverter.PDF_SUFFIX); //.pdf

        //window版 中文乱码解决方案为，将jodconverter.jar中DefaultDocumentFormatRegistry.class //txtLoadAndStoreProperties.put("FilterOptions", "utf8"); 注释掉
        //2018年5月10日 21:51:05 by tangyh


        // 拼接
        swfUrl = FileUtils.getFilePrefix(file.getUrl()) + SWFConverter.SWF_SUFFIX;  //swf 的链接
        if (fileProperties.getFastdfs().isEnabled()) {
            //FileModel fileModel = UploadUtil.upload(appId, "FILE", fileProperties,
            //        simpleFile.getInputStream(), submittedFileName);

            //生成的swf的完整路径
            String swfPath = FileUtils.getFilePrefix(filePath) + SWFConverter.SWF_SUFFIX;
            deleteFileList.add(swfPath);
            //生成的swf文件名
            String fileName = FileUtils.getFilePrefix(file.getFilename()) + SWFConverter.SWF_SUFFIX;
            log.info("swfPath={}, fileName={}", swfPath, fileName);

            FileModel fastDFSFile = new FileModel(appId, FileObjectId.FILE.toString(), fileName,
                    absolutePath, file.getRelativePath(), fileProperties.getRemoteUriPrefix(), fileName);

            FileManager.getInstance().upload(fastDFSFile);

            swfUrl = fastDFSFile.getRemotePath();
        }

        log.info("swfUrl={}", swfUrl);
        file.setSwf(swfUrl);
        fileMapper.updateByAppIdAndIdSelective(file);

        if (!deleteFileList.isEmpty()) {
            deleteFileList.forEach((ff) -> {
                try {
                    java.io.File temFile = new java.io.File(ff);
                    log.info("delete file:{}" , ff);
                    if (temFile.exists()) {
                        temFile.delete();
                        log.info("exists delete file:{}" , ff);
                    }
                } catch (Exception e) {
                    log.error("delete error", e);
                }
            });
        }
        return Result.success(dozerUtils.map(file, FileSwfDTO.class));
    }



    ///**
    // * 由于文件上传有2种模式：
    // * 模式1: 直接上传到web服务器
    // * 模式2：上传到fastDFS服务器
    // * <p>
    // * 模式1： 路径相对是本地
    // * 模式2： 需要将文件先从远程服务器下载到本地，然后在操作,最后将生成的swf文件上传至fastDFS服务器
    // *
    // * @param id 文件id
    // * @return
    // */
    //@ApiIgnore
    //@ApiOperation(value = "文档转pdf", notes = "其他文件格式(doc、docx、ppt、pptx、txt、xls、xlsx)转pdf")
    //@ApiResponses({
    //        @ApiResponse(code = 60103, message = "文件id为空"),
    //})
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id", value = "文件id", dataType = "long", paramType = "query"),
    //})
    //@RequestMapping(value = "/toPdf", method = RequestMethod.POST)
    //public Result<FileSwfDTO> toPdf(@RequestParam(value = "id") Long id) {
    //    BizAssert.assertNotNull(FileExceptionCode.FILE_ID_NULL, id);
    //    String appId = BaseContextHandler.getAppId();
    //    File file = fileService.getByAppIdAndId(appId, id);
    //    if (file == null) {
    //        return Result.fail("文件不存在");
    //    }
    //
    //    //文件后缀就是swf
    //    String ext = file.getExt();
    //    if (SWFConverter.SWF_SUFFIX.equalsIgnoreCase("." + ext)) {
    //        file.setSwf(file.getUrl());
    //        return Result.success(dozerUtils.map2(file, FileSwfDTO.class));
    //    }
    //
    //    //文件上次已经转换过了
    //    String swfUrl = file.getSwf();
    //    if (StringUtils.isNotEmpty(swfUrl)) {
    //        return Result.success(dozerUtils.map2(file, FileSwfDTO.class));
    //    }
    //
    //    //获取文件在web服务器的路径。 【模式1】直接获取。 【模式2】先从fastdfs下载到本地
    //    String absolutePath = file.getAbsolutePath();
    //    String filename = file.getFilename();
    //    String filePath = Paths.get(absolutePath, filename).toString(); //文件在web服务器存放的路径
    //
    //    List<String> deleteFileList = new ArrayList<>();
    //    if (fileProperties.getFastdfs().isEnabled()) {
    //        FileManager fileManager = FileManager.getInstance();
    //        filePath = Paths.get(file.getAbsolutePath(), file.getFilename()).toString();
    //        fileManager.downloadFile(file.getGroupName(), file.getRemoteFileName(), filePath);
    //        deleteFileList.add(filePath);
    //    }
    //
    //    //由于openoffice 预览时，会出现乱码问题，所以需要根据部署环境进行转码
    //    if (("txt".equalsIgnoreCase(ext) || "text/plain".equalsIgnoreCase(file.getContextType())) && swfProperties.getEnv() == 2) {
    //        String transferPath = FileUtils.getFilePrefix(filePath) + TRANSFAR;
    //        boolean flag = EncodeFormatTransfer.transfer2(filePath, transferPath, swfProperties.getFileEncode());
    //        if(flag) {
    //            deleteFileList.add(transferPath);
    //            filePath = transferPath;
    //            log.info("transferPath={}", transferPath);
    //        }
    //    }
    //
    //    log.info("原始文件路径 filePath={} ", filePath);
    //    log.info("配置 getOfficeHome={}, getSwfToolsPath={} ，getXpdfChineseSimplified={}"
    //            , swfProperties.getOfficeHome()
    //            , swfProperties.getSwfToolsPath()
    //            , swfProperties.getXpdfChineseSimplified());
    //
    //    //filePath转换
    //    PDFConverter pdfConverter = OpenOfficePDFConverter.getInstance(swfProperties);
    //    pdfConverter.convert2PDF(filePath);
    //
    //    //if (!deleteFileList.isEmpty()) {
    //    //    deleteFileList.forEach((ff) -> {
    //    //        try {
    //    //            java.io.File temFile = new java.io.File(ff);
    //    //            log.info("delete file:{}" , ff);
    //    //            if (temFile.exists()) {
    //    //                temFile.delete();
    //    //                log.info("exists delete file:{}" , ff);
    //    //            }
    //    //        } catch (Exception e) {
    //    //            log.error("delete error", e);
    //    //        }
    //    //    });
    //    //}
    //    return Result.success(dozerUtils.map(file, FileSwfDTO.class));
    //}

}
