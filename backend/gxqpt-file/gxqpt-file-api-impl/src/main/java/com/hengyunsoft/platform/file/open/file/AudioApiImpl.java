package com.hengyunsoft.platform.file.open.file;

import com.baidu.aip.speech.AipSpeech;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.constant.biz.FileObjectId;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.FileType;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.dto.AudioDTO;
import com.hengyunsoft.platform.file.dto.FilePageReqDTO;
import com.hengyunsoft.platform.file.dto.FolderSaveDTO;
import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
import com.hengyunsoft.platform.file.utils.FileUtils;
import com.hengyunsoft.platform.file.utils.UploadUtil;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.format.DateTimeFormatter;

;

/**
 * @author tianai
 * @createTime 2018-02-27
 */
@RestController
@Slf4j
@RequestMapping("/p/audio")
@Api(value = "音频上传转写文字管理", description = "音频上传转写文字管理")
public class AudioApiImpl /*implements AudioApi */ {
    //设置APPID/AK/SK
    public static final String APP_ID = "10920197";
    public static final String API_KEY = "5ZIRkHjlFvlgc6KYZoiimFHr";
    public static final String SECRET_KEY = "xZNTAgZhfir9X2gLuC33p0LjnKrokdyM";

    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");
    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;
    @Value("${spring.profiles.active:dev}")
    private String profiles;

    /**
     * http://ai.baidu.com/docs/#/ASR-Online-Java-SDK/top
     *
     * @param multFile
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "语音转文字", notes = " 上传音频文件转写文字,使用标准普通话音频 " +
            "标准版支持语音格式：pcm（不压缩）、wav（不压缩，pcm编码）、amr（压缩格式）；固定16k 采样率. 支持语言种类:普通话 " +
            " 时长不超过60s")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件"),
            @ApiResponse(code = 62500, message = "用户ID不能为空"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "音频", dataType = "file", paramType = "query")
    })
    @RequestMapping(value = "/uploadAudio", method = RequestMethod.POST)
    public Result<AudioDTO> uploadAudio(@RequestParam(value = "userId", required = false) Long userId,
                                        @RequestParam(value = "file", required = false) MultipartFile multFile) throws Exception {
        //String taskId = "5a93be5d";
        BizAssert.assertNotNull(FileExceptionCode.REQUIRED_FILE_PARAM_EX, multFile);

        String appId = BaseContextHandler.getAppId();

        //1，先将文件存在本地,并且生成文件名
        log.info("contenttype={}, name={} , sfname={}", multFile.getContentType(), multFile.getName(), multFile.getOriginalFilename());
        // 忽略路径字段,只处理文件类型

        //文件名
        String submittedFileName = multFile.getOriginalFilename();

        FileModel fileModel = UploadUtil.upload(appId, FileObjectId.UPLOAD.toString(), fileProperties, multFile.getInputStream(), submittedFileName);

        File file = dozerUtils.map(fileModel, File.class);

        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        String url = file.getUrl();
        //正式线由于不能通外网， 所以下载需要走内网
        log.info("profiles={}", profiles);
        if ("prod".equals(profiles)) {
            //url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
        }

        byte[] content = FileUtils.getFileContent(url);
        if (content == null) {
            return Result.fail("文件上传失败");
        }
        // 调用接口
        JSONObject res = client.asr(content, "pcm", 16000, null);
        log.info("res={}", res.toString());
        if (!"0".equals(String.valueOf(res.get("err_no")))) {
            throw new BizException(-2, res.getString("err_msg"));
        }
        String result = res.get("result").toString();

        if (StringUtils.isNotEmpty(result)) {
            file.setCharacters(result);
        }
        file.setAppId(appId);
        file.setAdminId(userId);
        file.setFolderId(CommonConstants.PARENT_ID_DEF);
        file.setCreateUser(userId);
        file.setUpdateUser(userId);

        file.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        file.setSubmittedFileName(submittedFileName);
        file.setDataType(FileDataTypeUtil.getDataType(file.getMime()).toString());
        file.setIcon(IconType.getIcon(file.getExt()).getIcon());
        file.setType(FileType.API.toString());
        file.setTreePath(CommonConstants.ROOT_PATH_DEF);
        fileService.saveSelective(file);

        return Result.success(dozerUtils.map(file, AudioDTO.class));
    }


    @ApiOperation(value = "test", notes = "专门用来测试的接口")
    @ApiResponses({
            @ApiResponse(code = 1, message = "error msg", response = Exception.class, reference = "aa"
                    , responseContainer = "bb", responseHeaders = {
                    @ResponseHeader(name = "name1", description = "desc1", responseContainer = "n1", response = RuntimeException.class),
                    @ResponseHeader(name = "name2", description = "desc2", responseContainer = "n2", response = BizException.class),
            })
    })
    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public Result<FolderSaveDTO> test1(@RequestBody FolderSaveDTO folderSaveDto) {
        if (StringUtils.isEmpty(folderSaveDto.getSubmittedFileName())) {
            return Result.fail("文件夹名称不能为空");
        }
        System.out.println(JSONUtils.toJsonString(folderSaveDto));


        return Result.success(folderSaveDto);
    }

    @ApiOperation(value = "test2", notes = "专门用来测试的接口")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public Result<FilePageReqDTO> test2(OpenApiReq openApiReq, FilePageReqDTO filePageReqDTO) {
        System.out.println(JSONUtils.toJsonString(openApiReq));
        System.out.println(JSONUtils.toJsonString(filePageReqDTO));


        return Result.fail("让你测试预警报错的bug");
    }

    /**
     * 获取传入语音基本信息
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "语音基本信息", notes = "获取语音文件基本信息")
    @ApiResponses({
            @ApiResponse(code = 63001, message = "请求中必须至少包含一个文件")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "音频", dataType = "file", paramType = "form")
    })
    @RequestMapping(value = "/audioBaseMessage", method = RequestMethod.POST)
    public Result<BaseFileDTO> audioBaseMessage(@RequestParam(value = "file") MultipartFile file) {
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
}
