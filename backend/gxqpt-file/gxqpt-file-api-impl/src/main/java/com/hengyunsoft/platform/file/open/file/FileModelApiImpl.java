package com.hengyunsoft.platform.file.open.file;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.dto.FileDTO;
import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.FileUtils;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

;import java.io.IOException;
import java.util.List;

/**
 * @author wz
 * @createTime 2018-08-24
 */
@RestController
@Slf4j
@RequestMapping("/p/filemodel")
@Api(value = "一般文件模块", description = "一般文件模块")
public class FileModelApiImpl /*implements AudioApi */ {
    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;
    @Value("${spring.profiles.active:dev}")
    private String profiles;

    /**
     * 文件类型识别
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件类型识别", notes = "文件类型识别")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/typeIdentification", method = RequestMethod.POST)
    public Result<String> typeIdentifi(@RequestParam(value = "file") MultipartFile file) {
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, file);

        return Result.success(file.getContentType());
    }

    /**
     * 文件基本信息识别
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件基本信息识别", notes = "文件基本信息识别")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/baseMessageIdentifi", method = RequestMethod.POST)
    public Result<BaseFileDTO> baseMessageIdentifi(@RequestParam(value = "file") MultipartFile file) {
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
     * 文件图标识别
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件图标识别", notes = "文件图标识别")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/iconIdentifi", method = RequestMethod.POST)
    public Result<String> iconIdentifi(@RequestParam(value = "file") MultipartFile file) {
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, file);

        String fileOldName = file.getOriginalFilename();

        return Result.success(IconType.getIcon(fileOldName.substring(fileOldName.lastIndexOf(".") + 1)).getIcon());
    }

    /**
     * 文件唯一码识别
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件唯一码识别", notes = "文件唯一码识别")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/md5Identifi", method = RequestMethod.POST)
    public Result<String> md5Identifi(@RequestParam(value = "file") MultipartFile file) {
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, file);

        try {
            return Result.success(FileUtils.getMD5(file.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail("fail");
    }

    /**
     * 文件解压缩
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "文件解压缩", notes = "当前接口只支持ZIP压缩文件解压缩")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/decompression", method = RequestMethod.POST)
    public Result<List<FileModel>> decompression(@RequestParam(value = "file") MultipartFile file) {
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, file);

        try {
            List<FileModel> ret = FileUtils.unZip(BaseContextHandler.getAppId(), "FILE", fileProperties,
                    file.getInputStream());

            return Result.success(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail("fail");
    }

    /**
     * 文件备份
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "文件备份", notes = "传入当前备份文件id,进行文件备份")
    @ApiResponses({
            @ApiResponse(code = 60103, message = "文件id为空")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文件id", dataType = "Long", paramType = "query")
    })
    @RequestMapping(value = "/backups", method = RequestMethod.GET)
    public Result<FileDTO> backups(@RequestParam(value = "id") Long id) {
        BizAssert.assertNotNull(FileExceptionCode.FILE_ID_NULL, id);

        File file = fileService.getById(id);

        if (file != null){
            return Result.success(dozerUtils.map(fileService.save(file), FileDTO.class));
        }
        return Result.fail("fail");
    }
}
