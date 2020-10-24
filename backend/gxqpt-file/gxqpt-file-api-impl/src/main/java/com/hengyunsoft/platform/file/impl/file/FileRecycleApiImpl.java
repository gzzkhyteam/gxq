package com.hengyunsoft.platform.file.impl.file;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.dto.FileRecycleDTO;
import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.repository.file.example.FileRecycleExample;
import com.hengyunsoft.platform.file.repository.file.service.FileRecycleService;
import com.hengyunsoft.platform.file.repository.file.service.FileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 回收站数据查询
 */
@RestController
@Slf4j
@RequestMapping("filerecycle")
@Api(value = "文件回收站管理", description = "文件回收站管理，用于文件回收站相关操作")
public class FileRecycleApiImpl /*implements FileRecycleApi*/ {
    @Autowired
    private FileRecycleService fileRecycleService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileService fileService;

    
    @ApiOperation(value = "获取回收站文件分页", notes = "获取回收站文件分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<FileRecycleDTO>> page(@RequestBody OpenApiReq<FileRecycleDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        FileRecycleExample example = new FileRecycleExample();
        example.createCriteria().andAppIdEqualTo(appId).andAdminIdEqualTo(adminId)
                .andIsOneLevelDeleteEqualTo(openApiReq.getData().getIsOneLevelDelete())
                .andFolderIdEqualTo(openApiReq.getData().getFolderId()).andDataTypeEqualTo(openApiReq.getData().getDataType())
                .andSubmittedFileNameLike(FileRecycleExample.fullLike(openApiReq.getData().getSubmittedFileName()));
        example.setOrderByClause(" update_time desc ,create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FileRecycle> list = fileRecycleService.find(example);
        List<FileRecycleDTO> pageList = dozerUtils.mapPage(list, FileRecycleDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    /**
     * 删除一个或者多个文件或者资源
     * @param ids
     * @return
     */
    
    @ApiOperation(value = "删除回收站数据", notes = "删除回收站数据")
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Result<Boolean> remove(@RequestParam(value = "ids[]") Long[] ids) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        //int result = fileRecycleService.removeFileRecycleByAppIdAndIds(appId, adminId,ids,true);
        int result = fileRecycleService.removeFileRecycleByAppIdAndIds(appId, adminId, ids);
        if (result > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 还原一个或者多个文件或者资源
     * @param ids
     * @return
     */
    
    @ApiOperation(value = "还原回收站数据", notes = "还原回收站数据")
    @RequestMapping(value = "/recycle", method = RequestMethod.POST)
    public Result<Boolean> recycleFile(@RequestParam(value = "ids[]") Long[] ids) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        //int result = fileRecycleService.removeFileRecycleByAppIdAndIds(appId, adminId,ids,false);
        int result = fileRecycleService.updateRecycle(appId, adminId, ids);
        if (result > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 获取永久回收数据
     *
     * @param
     * @return
     */
    
    @ApiOperation(value = "获取永久回收数据", notes = "获取永久回收数据")
    @RequestMapping(value = "/getForeverRecycle", method = RequestMethod.GET)
    public List<FileRecycleDTO> getForeverRecycle() {
        List<FileRecycle> list = fileRecycleService.getForeverRecycle();
        if (list.size() < 1) {
            return null;
        }
        return dozerUtils.mapList(list, FileRecycleDTO.class);
    }

    @ApiOperation(value = "清空回收站", notes = "清空回收站")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public Result<Boolean> clearAll() {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        return Result.success(fileRecycleService.clearAll(appId, adminId));
    }

    /**
     * 永久回收数据
     *
     * @param
     * @return
     */
    
    public void foreverRecycle(Long id) {
        fileRecycleService.updateForeverRecycle(id);
    }
}