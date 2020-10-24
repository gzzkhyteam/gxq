package com.hengyunsoft.platform.file.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.api.FileApi;
import com.hengyunsoft.platform.file.dto.FileDTO;
import com.hengyunsoft.platform.file.dto.FileListDTO;
import com.hengyunsoft.platform.file.dto.FilePageReqDTO;
import com.hengyunsoft.platform.file.dto.FileTreeDTO;
import com.hengyunsoft.platform.file.dto.FileUpdateDTO;
import com.hengyunsoft.platform.file.dto.FolderDTO;
import com.hengyunsoft.platform.file.dto.FolderSaveDTO;
import com.hengyunsoft.platform.file.dto.ShareSaveDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tyh
 * @createTime 2018-01-25 10:53
 * feign 熔断机制的实现， 默认返回超时响应
 */

@Component
public class FileApiHystrix implements FileApi {
    @Override
    public Result<FolderSaveDTO> test1(FolderSaveDTO folderSaveDto) {
        return Result.timeout();
    }

    @Override
    public Result<FileDTO> get(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<FileDTO>> page(@RequestBody OpenApiReq<FilePageReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<FolderDTO> saveFolder(FolderSaveDTO folderSaveDto) {
        return Result.timeout();
    }

    //@Override
    //public Result<FileListDTO> upload(Long folderId,  MultipartFile[] file, HttpServletRequest request) throws Exception{
    //    return Result.timeout();
    //}

    @Override
    public Result<Boolean> update(FileUpdateDTO fileUpdateDTO) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> remove(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<FileTreeDTO>> pageMyFile() { return  Result.timeout(); }

    @Override
    public Result<Boolean> saveTo(ShareSaveDTO shareSaveDTO) { return Result.timeout(); }

    //@Override
    //public void download(String url, String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //
    //}

    //@Override
    //public void downloadPackage(Long[] ids, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //
    //}

    /**
     * 秒传接口
     * @param folderId
     * @param request
     * @return
     * @throws Exception
     */
    //@Override
    //public Result<FileListDTO> uploadSpeed(Long folderId, String [] exsistFileMd5, HttpServletRequest request) throws Exception {
    //    return Result.timeout();
    //}

    /**
     * 文件秒传\n
     * 提供改接口的原因是，当对上传的文件进行校验发现都可以进行秒传时，
     * 所有文件将跳过，也就是webuploader不再发起请求，除非只有个别不能秒传时它还会向后端发送请求。
     * 该接口就处理该种情况
     * @param folderId
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Result<FileListDTO> uploadSpeedAll(Long folderId, String[] exsistFileMd5) throws Exception {
        return Result.timeout();
    }

    /**
     *文件MD5值校验
     * @param md5
     * @return
     * @throws Exception
     */
    @Override
    public boolean uploadMd5Check(String md5) throws Exception {
        return false;
    }

    @Override
    public Result<Boolean> removeList(Long[] ids) {
        return Result.timeout();
    }
}
