package com.hengyunsoft.platform.file.impl.file;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.constant.DateType;
import com.hengyunsoft.platform.file.dto.SaveShareDTO;
import com.hengyunsoft.platform.file.dto.SaveShareRetDTO;
import com.hengyunsoft.platform.file.dto.ShareDTO;
import com.hengyunsoft.platform.file.dto.ShareFileDTO;
import com.hengyunsoft.platform.file.dto.ShareFileLikeDTO;
import com.hengyunsoft.platform.file.dto.ShareUrlDTO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.Share;
import com.hengyunsoft.platform.file.entity.file.po.ShareFile;
import com.hengyunsoft.platform.file.repository.file.example.ShareExample;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.repository.file.service.ShareFileService;
import com.hengyunsoft.platform.file.repository.file.service.ShareService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.utils.BizAssert;

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

@RestController
@Slf4j
@RequestMapping("share")
@Api(value = "分享管理", description = "分享管理，用于描述分享详情")
public class ShareApiImpl /*implements ShareApi */{
    @Autowired
    private ShareService shareService;
    @Autowired
    private ShareFileService shareFileService;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;
    @Value("${gxqpt.shareFileUrl}")
    private String saveShareUrl;
    private static final String URL_MANYFILE = "等...";
    private static final int DEFAULT_NUM = 0;

    /**
     * 获取分享文件详细列表
     *
     * @param openApiReq 分页器
     * @return
     */
    
    @ApiOperation(value = "获取分享文件详细列表", notes = "获取分享文件详细列表")
    @IgnoreAppToken
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ShareFileDTO>> pageShareFileList(@RequestBody OpenApiReq<ShareFileLikeDTO> openApiReq) {
        //验证
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, openApiReq.getData());

        //设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //获得并转换结果对象
        List<File> shareFiles = shareFileService.selectFileByShare(openApiReq.getData().getId(),openApiReq.getData().getName());
        List<ShareFileDTO> shareFilesDTOS = dozerUtils.mapPage(shareFiles, ShareFileDTO.class);
        shareService.updateBrowsTimesById(openApiReq.getData().getId());
        return Result.success(new PageInfo<>(shareFilesDTOS));
    }

//    
//    @ApiOperation(value = "删除单个分享", notes = "删除单个分享")
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public Result<Boolean> delete(@RequestParam("id") Long id) {
//        String appId = BaseContextHandler.getAppId();
//        shareService.deleteByAppIdAndId(appId,id);
//        return Result.success(true);
//    }

    
    @ApiOperation(value = "删除多个分享", notes = "删除多个分享")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> deleteList(@RequestParam(value = "ids[]") Long[] ids) {
        //验证
        BizAssert.assertNotNull(FileExceptionCode.SHARE_FILES_NULL, ids);

        //获得必要信息
        String appId = BaseContextHandler.getAppId();

        //获得ids集合
        Collection<Long> list = new ArrayList<>();
        for (int idx = 0; idx < ids.length; idx++) {
            list.add(ids[idx]);
        }

        //执行删除操作
        shareFileService.deleteByShareIds(appId, list);
        shareService.deleteByAppIdAndIds(appId, list);
        return Result.success(true);
    }

    /**
     * 创建 分享
     *
     * @param saveShareDTO 分享对象
     * @return
     */
    
    @ApiResponses({
            @ApiResponse(code = 60501, message = "分享文件保存期限标识为空"),
            @ApiResponse(code = 60500, message = "分享文件加密标识为空"),
            @ApiResponse(code = 60502, message = "分享文件列表为空"),


    })
    @ApiOperation(value = "创建分享", notes = "创建分享")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<SaveShareRetDTO> save(@RequestBody SaveShareDTO saveShareDTO) {
        //验证
        BizAssert.assertNotNull(FileExceptionCode.SHARE_VALID_NULL, saveShareDTO.getValid());
        BizAssert.assertNotNull(FileExceptionCode.SHARE_ISPWD_NULL, saveShareDTO.getIsPwd());
        BizAssert.assertNotNull(FileExceptionCode.SHARE_FILES_NULL, saveShareDTO.getIdList());

        //必要信息获取
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        String adminName = BaseContextHandler.getName();
        File firstFile = fileService.getByAppIdAndId(appId, saveShareDTO.getIdList().get(0));

        //转换并封装 分享对象
        Collection<ShareFile> shareFileList = new ArrayList<>();
        Long newId = shareService.genId();
        Share share = new Share();
        share.setId(newId);
        share.setAppId(appId);
        share.setAdminId(adminId);
        share.setAdminName(URLDecoder.decode(adminName));
        share.setSaveTimes(DEFAULT_NUM);
        share.setDownloadTimes(DEFAULT_NUM);
        share.setBrowsTimes(DEFAULT_NUM);
        share.setUpdateUser(BaseContextHandler.getAdminId());
        share.setCreateUser(BaseContextHandler.getAdminId());
        share.setUrl(saveShareUrl + newId);
        String shareName = saveShareDTO.getIdList().size() == 1 ?
                firstFile.getSubmittedFileName() : firstFile.getSubmittedFileName() + URL_MANYFILE;
        share.setShareName(shareName);
        share.setIcon(firstFile.getIcon());
        //是否为分享加密-随机四位密码
        if (saveShareDTO.getIsPwd()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 4; i++) {
                char str = (char) ((Math.random() > 0.5f) ? (int) (Math.random() * 10 + 48) : (int) (Math.random() * 26 + 97));
                sb.append(str);
            }
            share.setSharePassword(sb.toString());
        }
        //有效期判断 无期限 1天 7天
        Calendar calendar = Calendar.getInstance();
        DateType dateType;
        dateType = DateType.valueOf(saveShareDTO.getValid());
        switch (dateType) {
            case NUL:
                break;
            case DAY:
                calendar.add(Calendar.DATE, +DateType.DAY.getKey());
                share.setValid(calendar.getTime());
                break;
            case WEEK:
                calendar.add(Calendar.DATE, +DateType.WEEK.getKey());
                share.setValid(calendar.getTime());
                break;
            default:
                break;
        }
        shareService.saveNoId(share);

        //封装 分享详细对象
        log.info("shareid={}", share.getId());
        for (Long id : saveShareDTO.getIdList()) {
            ShareFile shareFile = new ShareFile();
            shareFile.setAppId(appId);
            shareFile.setAdminId(adminId);
            shareFile.setShareId(share.getId());
            shareFile.setFileId(id);
            shareFileList.add(shareFile);
        }
        shareFileService.save(shareFileList);

        //封装并返回对象
        SaveShareRetDTO saveShareRetDTO = new SaveShareRetDTO();
        saveShareRetDTO.setUrl(share.getUrl());
        saveShareRetDTO.setSharePassword(share.getSharePassword());
        saveShareRetDTO.setValid(saveShareDTO.getValid());
        return Result.success(saveShareRetDTO);
    }

    
    @ApiOperation(value = "判断密码是否正确", notes = "判断密码是否正确")
    @ApiResponses({
            @ApiResponse(code = 60100, message = "文件为空"),
    })
    @IgnoreAppToken
    @RequestMapping(value = "/url/verify", method = RequestMethod.GET)
    public Result<Boolean> shareUrlVerify(@RequestParam(value = "id") Long id, @RequestParam(value = "sharePassword") String sharePassword) {
        //验证
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, id);

        //设置查询条件
        ShareExample shareExample = new ShareExample();
        sharePassword = sharePassword.toLowerCase();
        shareExample.createCriteria().andIdEqualTo(id).andSharePasswordEqualTo(sharePassword);

        //获取查询结果
        Share share = shareService.getUnique(shareExample);
        if (share == null) {
            return Result.success(false);
        }
        //返回值false代表验证错误;true代表验证正确
        return Result.success(true);
    }

    
    @ApiOperation(value = "子文件查询", notes = "子文件查询")
    @ApiResponses({
            @ApiResponse(code = 60102, message = "文件夹为空"),
    })
    @IgnoreAppToken
    @RequestMapping(value = "/findTree", method = RequestMethod.POST)
    public Result<PageInfo<ShareFileDTO>> findTree(@RequestBody OpenApiReq<ShareFileLikeDTO> openApiReq) {
        //验证
        BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, openApiReq.getData());

        //设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //转换查询结果
        List<File> shareFiles = shareFileService.selectFileTree(openApiReq.getData().getId(),openApiReq.getData().getName());
        List<ShareFileDTO> shareFilesDTOS = dozerUtils.mapPage(shareFiles, ShareFileDTO.class);
        return Result.success(new PageInfo<>(shareFilesDTOS));
    }

    
    @ApiOperation(value = "判断分享是否加密", notes = "判断分享是否加密")
    @ApiResponses({
            @ApiResponse(code = 60100, message = "文件为空"),
    })
    @IgnoreAppToken
    @RequestMapping(value = "/url/ispassword", method = RequestMethod.GET)
    public Result<ShareUrlDTO> shareUrlPasswordIsNotNull(@RequestParam(value = "id") Long id) {
        //验证
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, id);

        //设置查询条件
        ShareExample shareExample = new ShareExample();
        shareExample.createCriteria().andIdEqualTo(id);

        //获得查询结果
        Share share = shareService.getUnique(shareExample);
        if (share == null) {
            return Result.fail("fail");
        }
        boolean timeTag = share.getValid() == null ? true : (share.getValid().getTime() > (new Date().getTime()) ? true : false);
        boolean passwordTag = (share.getSharePassword() == null ? false : true);
        ShareUrlDTO shareUrlDTO = dozerUtils.map(share, ShareUrlDTO.class);
        shareUrlDTO.setTimeTag(timeTag);
        shareUrlDTO.setPasswordTag(passwordTag);

        //设置分页器
//        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //获得并转换结果对象
        List<File> shareFiles = shareFileService.selectFileByShare(id,null);
        List<ShareFileDTO> shareFilesDTOS = dozerUtils.mapPage(shareFiles, ShareFileDTO.class);
//        shareService.updateBrowsTimesById(id);
        shareUrlDTO.setShareFiles(shareFilesDTOS);
        return Result.success(shareUrlDTO);
    }

//    
//    @ApiOperation(value = "通过链接获得分享", notes = "通过链接获得分享")
//    @RequestMapping(value = "/url/list", method = RequestMethod.GET)
//    public Result<PageInfo<ShareFileDTO>> shareUrlList(OpenApiReq openApiReq, @RequestParam("id") String id) {
//        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//        List<File> shareFiles = shareFileService.selectFileByShare(Long.parseLong(id));
//        List<ShareFileDTO> shareFilesDTOS = dozerUtils.mapPage(shareFiles,ShareFileDTO.class);
//        return Result.success(new PageInfo<>(shareFilesDTOS));
//    }

    
    @ApiOperation(value = "获取分享列表", notes = "获取分享列表")
    @RequestMapping(value = "/my/page", method = RequestMethod.POST)
    public Result<PageInfo<ShareDTO>> pageShareList(@RequestBody OpenApiReq<Long> openApiReq) {
        //获得用户id
        Long adminId = BaseContextHandler.getAdminId();
        String appId = BaseContextHandler.getAppId();
        //设置查询条件
        ShareExample example = new ShareExample();
        example.createCriteria().andAdminIdEqualTo(adminId).andAppIdEqualTo(appId);
        example.setOrderByClause(" update_time desc ");

        //设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //获得并转换 查询结果
        List<Share> list = shareService.find(example);
        List<ShareDTO> pageList = dozerUtils.mapPage(list, ShareDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }
}
