package com.hengyunsoft.platform.mt.impl.version;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mt.api.version.dto.ClientVersionDTO;
import com.hengyunsoft.platform.mt.api.version.dto.CreateVersionParamDTO;
import com.hengyunsoft.platform.mt.api.version.dto.QueryClientVersionParamDTO;
import com.hengyunsoft.platform.mt.entity.version.po.ClientVersion;
import com.hengyunsoft.platform.mt.repository.version.service.ClientVersionService;
import com.hengyunsoft.platform.mt.utils.QRCodeUtil;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.UploadFileUtil;
import com.hengyunsoft.utils.UploadResult;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.hengyunsoft.platform.mt.impl.clientVersion
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：客户端版本API
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：新增基础接口
 */
@Api(value = "API - ClientVersionApiImpl.java", description = "客户端版本API")
@RestController
@RequestMapping("clientVersion")
@Slf4j
public class ClientVersionApiImpl /*implements ClientVersionApi*/ {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ClientVersionService clientVersionService;
    @Value("${fileServerUrl}")
    private String fileServerUrl;

    private String fileUpUrl = "/p/file/simple";

    @Value("${apkDownUrl}")
    private String apkDownUrl;

    /**
     * 描述：创建版本
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/29
     * 修改内容：
     */
    @RequestMapping(value = "createVersion", method = RequestMethod.POST)
    @ApiOperation(value = "创建版本", notes = "创建版本")
    @ApiResponses({
            @ApiResponse(code = 90500, message = "创建版本请求参数，不能为空"),
            //@ApiResponse(code = 90501,message = "版本id，编辑有id，新增无id，不能为空"),
            @ApiResponse(code = 90502, message = "版本名称，不能为空"),
            @ApiResponse(code = 90503, message = "版本号，不能为空"),
            @ApiResponse(code = 90504, message = "升级内容，不能为空"),
            @ApiResponse(code = 90505, message = "文件id，不能为空"),
            @ApiResponse(code = 90506, message = "文件名称，不能为空"),
            @ApiResponse(code = 90507, message = "文件路径，不能为空"),
            @ApiResponse(code = 90508, message = "是否强制更新(1不强制,2强制)，不能为空"),
            @ApiResponse(code = 90509, message = "没有发布版本权限"),
            @ApiResponse(code = 90513, message = "文件大小不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = ClientVersion.class)
            }
    )

    public Result<Boolean> saveCreateVersion(@RequestBody CreateVersionParamDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO, dto);
        //BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_ID,dto.getId());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_CNAME, dto.getVerName());
        BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_NUMBER, dto.getVerNumber());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_UPDATECONTENT, dto.getUpdateContent());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_APKFILEID, dto.getApkFileId());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_APKFILENAME, dto.getApkFileName());
        BizAssert.assertNotEmpty(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_APKFILEPATH, dto.getApkFilePath());
        BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_PWUPDATE, dto.getPwUpdate());
        BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_SIZE, dto.getApkFileSize());

        //TODO 是否能够发布版本
        Long adminId = BaseContextHandler.getAdminId();
        boolean canPublish = true;
        if (!canPublish) {
            return Result.fail(MtExceptionCode.CAN_NOT_PUBLISH);
        }
        ClientVersion version = dozerUtils.map(dto, ClientVersion.class);
        version.setState(1);//未发布状态
        version.setUpdateNum(0);
        version.setUpdateUser(adminId);
        if (dto.getId() != null) {//编辑
            clientVersionService.updateByIdSelective(version);
        } else {
            version.setCreateUser(adminId);
            clientVersionService.saveSelective(version);
        }
        return Result.success(true);
    }

    /**
     * 描述：发布版本
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/29
     * 修改内容：
     */
    @RequestMapping(value = "publishVersion", method = RequestMethod.POST)
    @ApiOperation(value = "发布版本", notes = "发布版本")
    @ApiResponses({
            @ApiResponse(code = 90509, message = "没有发布版本权限"),
            @ApiResponse(code = 90510, message = "版本不存在"),
            @ApiResponse(code = 90511, message = "改版本已经发布"),
    })


    public Result<Boolean> savePublishVersion(@RequestParam Long id) throws Exception {
        boolean canPublish = true;
        if (!canPublish) {
            return Result.fail(MtExceptionCode.CAN_NOT_PUBLISH);
        }
        ClientVersion version = clientVersionService.getById(id);
        if (version == null) {
            return Result.fail(MtExceptionCode.VERSION_HAS_NOT);
        }
        int state = version.getState();
        if (state >= 2) {
            return Result.fail(MtExceptionCode.VERSION_HAS_NOT);
        }
        version.setState(2);
        version.setPublishTime(new Date());

        //生成二维码，并上传到文件服务器

        byte[] bytes = QRCodeUtil.qRCodeCreate(apkDownUrl, "codeimage.jpg", 9, null);
        String fileId = uploadCode2Server(bytes);
        version.setDownQrCode(fileId);

        clientVersionService.updateByIdSelective(version);
        return Result.success(true);
    }

    /**
     * 描述：查询版本列表
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/29
     * 修改内容：
     */
    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ApiOperation(value = "查询版本列表", notes = "查询版本列表")
    @ApiResponses({
            @ApiResponse(code = 90512, message = "查询版本类别参数不能为空"),
    })

    public Result<PageInfo<ClientVersionDTO>> getFind(@RequestBody OpenApiReq<QueryClientVersionParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.VERSION_FIND_PARAM_NULL, openApiReq);

        Map<String, Object> param = new HashMap<>();
        if (openApiReq.getData() != null) {
            param.put("verName", openApiReq.getData().getVerName());
            param.put("verNumber", openApiReq.getData().getVerNumber());
            param.put("startPublishTime", openApiReq.getData().getStartPublishTime());
            param.put("endPublishTime", openApiReq.getData().getEndPublishTime());
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ClientVersion> list = clientVersionService.findClientVersion(param);

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ClientVersionDTO.class)));
    }

    /**
     * 描述：查询已经发布的版本
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/29
     * 修改内容：
     */

    @RequestMapping(value = "findPubishVersion", method = RequestMethod.POST)
    @ApiOperation(value = "查询已经发布的版本", notes = "查询已经发布的版本")
    @ApiResponses({
            @ApiResponse(code = 90512, message = "查询版本类参数不能为空"),
    })
    public Result<PageInfo<ClientVersionDTO>> getFindPubishVersion(@RequestBody OpenApiReq<QueryClientVersionParamDTO> openApiReq) {
        BizAssert.assertNotNull(MtExceptionCode.VERSION_FIND_PARAM_NULL, openApiReq);

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ClientVersion> list = clientVersionService.findPubishVersion();

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ClientVersionDTO.class)));
    }

    /**
     * 描述：根据版本id查询版本详情
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/29
     * 修改内容：
     */
    @RequestMapping(value = "getBaseInfo", method = RequestMethod.POST)
    @ApiOperation(value = "根据版本id查询版本详情", notes = "根据版本id查询版本详情")
    @ApiResponses({
            @ApiResponse(code = 90501, message = "版本id，编辑有id，新增无id，不能为空"),
            @ApiResponse(code = 90510, message = "版本不存在"),
    })

    public Result<ClientVersionDTO> getBaseInfo(@RequestParam("id") Long id) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_ID, id);

        ClientVersion version = clientVersionService.getById(id);
        if (version == null) {
            return Result.fail(MtExceptionCode.VERSION_HAS_NOT);
        }

        return Result.success(dozerUtils.map(version, ClientVersionDTO.class));
    }

    /**
     * 描述：得到最新的版本信息
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/19
     * 修改内容：
     */

    @RequestMapping(value = "getLastVersionInfo", method = RequestMethod.GET)
    @ApiOperation(value = "得到最新的版本信息", notes = "得到最新的版本信息")
    public Result<ClientVersionDTO> getLastVersionInfo() {
        ClientVersion version = clientVersionService.getLastVersionInfo();
        if (version == null) {
            return Result.fail(MtExceptionCode.VERSION_HAS_NOT);
        }

        return Result.success(dozerUtils.map(version, ClientVersionDTO.class));
    }

    @RequestMapping(value = "addUpdataOne", method = RequestMethod.POST)
    @ApiOperation(value = "增加版本更新数量", notes = "增加版本更新数量")
    @ApiResponses({
            @ApiResponse(code = 90501, message = "版本id，不能为空"),
            @ApiResponse(code = 90510, message = "版本不存在"),
    })

    public Result<Boolean> saveUpdataOne(@RequestParam("id") Long id) {
        BizAssert.assertNotNull(MtExceptionCode.CREATEVERSION_CREATEVERSIONPARAMDTO_ID, id);
        ClientVersion version = clientVersionService.getById(id);
        if (version == null) {
            return Result.fail(MtExceptionCode.VERSION_HAS_NOT);
        }
        clientVersionService.addUpdateNum(id);
        return Result.success(true);
    }

    /***
     * 生成二维码上传到文件服务器,
     * @param bytes
     * @return 返回文件路径
     * @throws Exception
     */
    private String uploadCode2Server(byte[] bytes) throws Exception {
        String token = BaseContextHandler.getToken();
        Long usertId = BaseContextHandler.getAdminId();
        log.info("url={}", fileServerUrl + fileUpUrl);
        com.hengyunsoft.utils.Result result = UploadFileUtil.uploadFile(fileServerUrl + fileUpUrl, token,
                usertId, "codeimage.jpg", bytes);
        if (!result.isSuccess()) {
            throw new Exception("上传二维码到文件服务器失败");
        }
        UploadResult data = result.getData();
        UploadResult.UploadFileResult uploadFileResult = data.getList().get(0);
        String url = uploadFileResult.getUrl();
        //Long id = uploadFileResult.getId();
        return url;
    }

    @RequestMapping(value = "downloadapp", method = RequestMethod.GET)
    @ApiOperation(value = "下载最新版本app", notes = "下载最新版本app")
    @IgnoreToken
    public void downloadapp(HttpServletResponse resp) throws IOException {
        log.info("进来了吗");
        ClientVersion version = clientVersionService.getLastVersionInfo();
        log.info("version={}", version);
        if (version != null) {
            log.info("version={}, {}", version.getApkFilePath(), version.getApkFileName());
            //http://127.0.0.1:6080/group1/M00/00/12/wKgep1y5Q8uAUiMHAAADwBWH_WM592.txt?attname=文件名.txt
            String encodeName = URLEncoder.encode(version.getApkFileName(), "utf-8");
            String dUrl = version.getApkFilePath() + "?attname=" + encodeName;
            resp.sendRedirect(dUrl);
            log.info("version={}", dUrl);
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除版本", notes = "删除版本")
    @ApiResponses({
    })
    public Result<Boolean> delete(@RequestParam("id") Long id) {
        ClientVersion version = clientVersionService.getById(id);
        if (version == null) {
            return Result.fail(MtExceptionCode.VERSION_HAS_NOT);
        }
        if (version.getState() == 2) {
            return Result.fail("已经发布版本不能删除");
        }
        clientVersionService.deleteById(id);

        return Result.success(true);
    }
}
