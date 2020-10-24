package com.hengyunsoft.platform.file.open.file;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.biz.FileObjectId;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.DataType;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.dto.FileDownWaterDTO;
import com.hengyunsoft.platform.file.dto.FileDownWaterPageReqDTO;
import com.hengyunsoft.platform.file.dto.FileStatisDTO;
import com.hengyunsoft.platform.file.dto.UploadFileDTO;
import com.hengyunsoft.platform.file.dto.UploadListDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.FileDownloadWater;
import com.hengyunsoft.platform.file.entity.file.po.FileStatis;
import com.hengyunsoft.platform.file.repository.file.example.FileDownloadWaterExample;
import com.hengyunsoft.platform.file.repository.file.service.FileDownWaterService;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
import com.hengyunsoft.platform.file.utils.UploadUtil;
import com.hengyunsoft.platform.file.utils.ZipUtils;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/p/file")
@Api(value = "文件管理", description = "文件上传，下载")
public class FileOpenApiImpl {

    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");
    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileDownWaterService fileDownWaterService;
    @Autowired
    private DozerUtils dozerUtils;

    @Value("${spring.profiles.active:dev}")
    private String profiles;

    @ApiOperation(value = "文件上传", notes = "只支持单文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个有效文件"),
    })
    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public Result<UploadListDTO> upload(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, file);
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        adminId = adminId == null || adminId <= 0 ? userId : adminId;
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, adminId);

        //1，先将文件存在本地,并且生成文件名
        List<File> fileList = new ArrayList<>();
        // 忽略路径字段,只处理文件类型
        if (file != null && !file.isEmpty()) {
            //文件名
            String submittedFileName = file.getOriginalFilename();


            FileModel fileModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, file.getInputStream(), submittedFileName);

            if (fileModel == null || StringUtils.isEmpty(fileModel.getRemotePath())) {
                return Result.fail("上传失败~");
            }
            File filePo = dozerUtils.map2(fileModel, File.class);
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
            fileList.add(filePo);


            //存储
            if (!fileList.isEmpty()) {
                fileService.save(fileList);
            }

            //4,转换
            List<UploadFileDTO> list = dozerUtils.mapList(fileList, UploadFileDTO.class);
            UploadListDTO uploadListDTO = new UploadListDTO();
            uploadListDTO.setList(list);
            return Result.success(uploadListDTO);
        }
        return Result.fail(FileExceptionCode.REQUIRED_FILE_PARAM_EX);
    }

    @ApiOperation(value = "文件上传", notes = "只支持单文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件", dataType = "file", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个有效文件"),
    })
    @RequestMapping(value = "/simple2", method = RequestMethod.POST)
    public Result<UploadListDTO> upload2(
            @RequestParam(value = "userId", required = false) Long userId,
            HttpServletRequest request) throws Exception {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        adminId = adminId == null || adminId <= 0 ? userId : adminId;
        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, adminId);

        // Servlet3.0方式上传文件
        Collection<Part> parts = request.getParts();

        //1，先将文件存在本地,并且生成文件名
        List<File> fileList = new ArrayList<>();
        // 忽略路径字段,只处理文件类型
        if (parts != null && !parts.isEmpty()) {
            for (Part part : parts) {
                //文件名
                String submittedFileName = part.getSubmittedFileName();

                FileModel fileModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, part.getInputStream(), submittedFileName);

                if (fileModel == null || StringUtils.isEmpty(fileModel.getRemotePath())) {
                    return Result.fail("上传失败~");
                }
                File filePo = dozerUtils.map2(fileModel, File.class);
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
                fileList.add(filePo);


                //存储
                if (!fileList.isEmpty()) {
                    fileService.save(fileList);
                }

                //4,转换
                List<UploadFileDTO> list = dozerUtils.mapList(fileList, UploadFileDTO.class);
                UploadListDTO uploadListDTO = new UploadListDTO();
                uploadListDTO.setList(list);
                return Result.success(uploadListDTO);
            }
        }
        return Result.fail(FileExceptionCode.REQUIRED_FILE_PARAM_EX);
    }

    @ApiOperation(value = "多文件上传", notes = "支持多个文件同时上传  ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file0", value = "附件1", dataType = "file", paramType = "query"),
            @ApiImplicitParam(name = "file1", value = "附件2", dataType = "file", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
    })
    @RequestMapping(value = "/multi", method = RequestMethod.POST)
    public Result<UploadListDTO> multiUpload(@RequestParam(value = "userId", required = false) Long userId, HttpServletRequest request) throws Exception {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        adminId = adminId == null || adminId <= 0 ? userId : adminId;

        BizAssert.assertNotNull(AuthorityExceptionCode.USER_ID_NULL, adminId);

        // Servlet3.0方式上传文件
        Collection<Part> parts = request.getParts();
        //1，先将文件存在本地,并且生成文件名
        List<File> fileList = new ArrayList<>();
        for (Part part : parts) {
            // 忽略路径字段,只处理文件类型
            if (part.getContentType() != null) {
                //文件名
                String submittedFileName = part.getSubmittedFileName();
                try {
                    FileModel fileModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, part.getInputStream(), submittedFileName);

                    if (fileModel != null) {
                        File file = dozerUtils.map(fileModel, File.class);
                        file.setSubmittedFileName(submittedFileName);
                        file.setAppId(appId);
                        file.setAdminId(adminId);
                        file.setFolderId(null);
                        file.setCreateUser(adminId);
                        file.setUpdateUser(adminId);
                        file.setTreePath(CommonConstants.ROOT_PATH_DEF);
                        file.setSubmittedFileName(submittedFileName);
                        file.setIcon(IconType.getIcon(file.getExt()).getIcon());
                        file.setDataType(FileDataTypeUtil.getDataType(file.getMime()).toString());
                        file.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                        file.setType(com.hengyunsoft.platform.file.constant.FileType.API.toString());
                        fileList.add(file);
                    }
                } catch (Exception e) {
                    log.error("保存文件到服务器临时目录失败:", e);
                }
            }
        }

        //存储
        if (!fileList.isEmpty()) {
            fileService.save(fileList);
        }

        //4,转换
        List<UploadFileDTO> list = dozerUtils.mapList(fileList, UploadFileDTO.class);
        UploadListDTO uploadListDTO = new UploadListDTO();
        uploadListDTO.setList(list);
        return Result.success(uploadListDTO);
    }

    @ApiOperation(value = "下载文件", notes = "根据文件id， 下载文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户id， 没有请填 -1", dataType = "long", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = 60100, message = "文件为空"),
            @ApiResponse(code = 60103, message = "文件id为空"),
            @ApiResponse(code = 62500, message = "用户ID不能为空"),
    })
    @RequestMapping(value = "/down", method = RequestMethod.GET)
    public void download(@RequestParam(value = "id", required = false) Long id,
                         @RequestParam(value = "userId", required = false) Long userId,
                         HttpServletRequest request, HttpServletResponse response) throws Exception {

        BizAssert.assertNotNull(FileExceptionCode.COMMON_USER_ID_NULL, userId);
        BizAssert.assertNotNull(FileExceptionCode.FILE_ID_NULL, id);

        String appId = BaseContextHandler.getAppId();
        fileService.download(appId, userId, id, request, response);
    }


    /**
     * 打包下载
     *
     * @param ids
     * @param response
     * @throws Exception
     */
    @ApiOperation(value = "打包下载多个文件", notes = "打包下载多个文件, 这个接口不需要token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id， 没有请填 -1", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/downloadpackage", method = RequestMethod.GET)
    public void downloadPackage(
            @ApiParam(name = "ids[]", value = "文件id 数组")
            @RequestParam(value = "ids[]") Long[] ids,
            @RequestParam(value = "userId", required = false) Long userId,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (ids == null || ids.length == 0) {
            return;
        }
        String fileName = "";
        if (ids.length == 1) {
            File file = fileService.getById(ids[0]);
            BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, file);

            if (DataType.DIR.equals(file.getDataType())) {
                return;
            }
            HttpURLConnection connection = null;
            try {
                String url = file.getUrl();
                /*正式线由于不能通外网， 所以下载需要走内网，该代码仅仅用在高新区项目的正式线环境，
                  copy代码时，请自行删除， 是为了解决正式环境的网络问题*/
                log.info("profiles={}", profiles);
                if ("prod".equals(profiles)) {
                    //url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
                }

                URL uri = new URL(url);
                connection = (HttpURLConnection) uri.openConnection();
                connection.connect();
                download(file.getSubmittedFileName(), connection.getInputStream(), request, response);
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } else {
            File file = fileService.getById(ids[0]);
            BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, file);
            if (file == null || DataType.DIR.equals(file.getDataType())) {
                return;
            }
            fileName = file.getSubmittedFileName();
            log.info("fileName={}", fileName);
            if (org.apache.commons.lang3.StringUtils.isNotEmpty(file.getSubmittedFileName())) {
                fileName = org.apache.commons.lang3.StringUtils.substring(file.getSubmittedFileName(), 0, file.getSubmittedFileName().lastIndexOf("."));
            }
            fileName += "等";
            log.info("fileName={}", fileName);

            response.setContentType("application/octet-stream; charset=utf-8");

            String downFileName = "";
            String agent = request.getHeader("USER-AGENT");
            if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                downFileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64((fileName + ".zip").getBytes("UTF-8")))) + "?=";
            } else {
                downFileName = URLEncoder.encode(fileName + ".zip", "UTF-8");
            }

            //response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".zip", "UTF-8"));
            response.setHeader("Content-Disposition", "attachment; filename=" + downFileName);
            ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream());
            HttpURLConnection connection = null;
            for (int i = 0; i < ids.length; i++) {
                File f = fileService.getById(ids[i]);
                if (f == null) {
                    break;
                }
                if (DataType.DIR.equals(f.getDataType())) {
                    break;
                }
                try {
                    String url = f.getUrl();
                    /*正式线由于不能通外网， 所以下载需要走内网，该代码仅仅用在高新区项目的正式线环境，
                      copy代码时，请自行删除， 是为了解决正式环境的网络问题*/
                    log.info("profiles={}", profiles);
                    if ("prod".equals(profiles)) {
                        //url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
                    }
                    URL uri = new URL(url);
                    connection = (HttpURLConnection) uri.openConnection();
                    connection.connect();
                    ZipUtils.zipFilesByInputStream(zipOut, f.getSubmittedFileName(), connection.getInputStream());
                } catch (Exception e) {
                    log.error("获取文件出错", e);
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
            zipOut.close();
        }


        try {
            String appId = BaseContextHandler.getAppId();
            for (Long id : ids) {
                fileService.recordWater(appId, id, userId);
            }
        } catch (Exception e) {
            log.error("记录流水报错={}", e);
        }
    }

    /**
     * 下载指定输入流的图片
     *
     * @param filename
     * @param inputStream
     * @param response
     * @throws Exception
     */
    private void download(String filename, InputStream inputStream,
                          HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (org.apache.commons.lang3.StringUtils.isEmpty(filename)) {
            filename = "未知文件.txt";
        }
        OutputStream os = null;
        try {
            response.setContentType("application/force-download");
            if (!org.apache.commons.lang3.StringUtils.isEmpty(filename)) {
                String downFileName = "";
                String agent = request.getHeader("USER-AGENT");
                if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                    downFileName = "=?UTF-8?B?" + (new String(Base64.encodeBase64(filename.getBytes("UTF-8")))) + "?=";
                } else {
                    downFileName = URLEncoder.encode(filename, "UTF-8");
                }

                response.setHeader("Content-disposition", "attachment; filename=" + downFileName);
            } else {
                response.setHeader("Content-disposition", "attachment");
            }

            os = response.getOutputStream();

            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        } finally {
            if (os != null) {
                os.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @ApiOperation(value = "文件下载数量统计", notes = "文件下载数量统计")
    @ApiResponses(
            @ApiResponse(code = 63005, message = "文件ids[]不能为空")
    )
    @RequestMapping(value = "/findDownStatis", method = RequestMethod.GET)
    public Result<List<FileStatisDTO>> findDownStatis(
            @ApiParam(name = "ids[]", value = "文件id 数组")
            @RequestParam(value = "ids[]", required = false) Long[] ids) {

        BizAssert.assertNotNull(FileExceptionCode.FILE_IDS_NULL, ids);
        BizAssert.assertTrue(FileExceptionCode.FILE_IDS_NULL, ids.length > 0);
        String appId = BaseContextHandler.getAppId();
        List<FileStatis> list = fileService.findDownStatis(appId, ids);
        return Result.success(dozerUtils.mapList(list, FileStatisDTO.class));
    }

    //appid + fileid + startTime endTime
    //
    @ApiOperation(value = "文件下载数量流水", notes = "文件下载数量流水")
    @RequestMapping(value = "/findDownWater", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 63000, message = "解析日期类型的参数出现异常，请检查日期类型的参数格式是否正确"),
    })
    public Result<List<FileDownWaterDTO>> findDownWater(
            @ApiParam(name = "fileId[]", value = "文件id 数组") @RequestParam(value = "fileId[]", required = false) Long[] fileId,
            @ApiParam(name = "startTime", value = "开始时间 yyyy-MM-dd HH:mm:ss") @RequestParam(value = "startTime", required = false) String startTime,
            @ApiParam(name = "endTime", value = "结束时间 yyyy-MM-dd HH:mm:ss") @RequestParam(value = "endTime", required = false) String endTime) {
        String appId = BaseContextHandler.getAppId();
        List<FileDownloadWater> list = fileService.findDownWater(appId, fileId, startTime, endTime);
        return Result.success(dozerUtils.mapList(list, FileDownWaterDTO.class));
    }


    @ApiOperation(value = "文件下载数量流水信息", notes = "文件下载数量流水信息")
    @ApiResponses(
            @ApiResponse(code = 63000, message = "解析日期类型的参数出现异常，请检查日期类型的参数格式是否正确")
    )
    @RequestMapping(value = "/findDownWaterPage", method = RequestMethod.POST)
    public Result<PageInfo<FileDownWaterDTO>> findDownWaterPage(@RequestBody OpenApiReq<FileDownWaterPageReqDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        FileDownWaterPageReqDTO dto = openApiReq.getData();
        FileDownloadWaterExample example = new FileDownloadWaterExample();

        if (dto != null) {
            Long[] fileId = dto.getFileId();
            String startTime = dto.getStartTime();
            String endTime = dto.getEndTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formatter.setLenient(false);
            Date start = null;
            Date end = null;
            if (StringUtils.isNotEmpty(startTime)) {
                try {
                    start = formatter.parse(startTime);
                } catch (ParseException e) {
                    log.error("解析日期参数出现异常", e);
                    return Result.fail(FileExceptionCode.PARSE_DATE_EX);
                }
            }
            if (StringUtils.isNotEmpty(endTime)) {
                try {
                    end = formatter.parse(endTime);
                } catch (ParseException e) {
                    log.error("解析日期参数出现异常", e);
                    return Result.fail(FileExceptionCode.PARSE_DATE_EX);
                }
            }

            FileDownloadWaterExample.Criteria criteria = example.createCriteria();
            criteria.andAppIdEqualTo(appId).andCreateTimeGreaterThanOrEqualTo(start)
                    .andCreateTimeLessThanOrEqualTo(end);
            if (fileId != null && fileId.length > 0) {
                criteria.andFileIdIn(Arrays.asList(fileId));
            }

        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(fileDownWaterService.find(example), FileDownWaterDTO.class)));
    }


    @ApiOperation(value = "删除文件", notes = "删除文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Result<Boolean> remove(@RequestParam(value = "id") Long id) {
        String appId = BaseContextHandler.getAppId();
        fileService.removeFileByAppIdAndId(appId, id);
        return Result.success(true);
    }
}
