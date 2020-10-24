package com.hengyunsoft.platform.file.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.commons.config.FeignConfiguration;
import com.hengyunsoft.platform.file.api.hystrix.FileApiHystrix;
import com.hengyunsoft.platform.file.dto.FileDTO;
import com.hengyunsoft.platform.file.dto.FileListDTO;
import com.hengyunsoft.platform.file.dto.FilePageReqDTO;
import com.hengyunsoft.platform.file.dto.FileTreeDTO;
import com.hengyunsoft.platform.file.dto.FileUpdateDTO;
import com.hengyunsoft.platform.file.dto.FolderDTO;
import com.hengyunsoft.platform.file.dto.FolderSaveDTO;
import com.hengyunsoft.platform.file.dto.ShareSaveDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * fallback: 实现服务降级处理逻辑。
 * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
 *
 * @author tyh
 * @createTime 2018-01-25 10:52
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-file-server}",
        configuration = FeignConfiguration.class,
        fallback = FileApiHystrix.class)
public interface FileApi {

    @RequestMapping(value = "/file/test1", method = RequestMethod.POST)
    Result<FolderSaveDTO> test1(@RequestBody FolderSaveDTO folderSaveDto);


    /**
     * 根据id + token 查文件夹详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/file/get", method = RequestMethod.GET)
    Result<FileDTO> get(@RequestParam(value = "id") Long id);


    /**
     * 根据父id查询列表
     *
     * @param
     */
    @RequestMapping(value = "/file/page", method = RequestMethod.POST)
    Result<PageInfo<FileDTO>> page(@RequestBody OpenApiReq<FilePageReqDTO> openApiReq);

    /**
     * 上传文件
     *
     * @return
     */
    @RequestMapping(value = "/file/saveFolder", method = RequestMethod.POST)
    Result<FolderDTO> saveFolder(@RequestBody FolderSaveDTO folderSaveDto);

    /**
     * 文件秒传\n
     * 提供改接口的原因是，当对上传的文件进行校验发现都可以进行秒传时，
     * 所有文件将跳过，也就是webuploader不再发起请求，除非只有个别不能秒传时它还会向后端发送请求。
     * 该接口就处理该种情况
     *
     * @param folderId
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/file/uploadspeedall", method = RequestMethod.POST)
    Result<FileListDTO> uploadSpeedAll(@RequestParam(value = "folderId") Long folderId, @RequestParam(value = "exsistFileMd5 []") String[] exsistFileMd5) throws Exception;

    /**
     * 文件MD5值校验
     *
     * @param md5
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/file/uploadMd5Chechk", method = RequestMethod.POST)
    boolean uploadMd5Check(@RequestParam(value = "md5") String md5) throws Exception;

    /**
     * 修改文件
     *
     * @param fileUpdateDTO
     * @return
     */
    @RequestMapping(value = "/file/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody FileUpdateDTO fileUpdateDTO);

    /**
     * 删除文件
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/file/remove", method = RequestMethod.POST)
    Result<Boolean> remove(@RequestParam(value = "id") Long id);

    /**
     * 根据Ids进行文件删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/file/removeList", method = RequestMethod.POST)
    Result<Boolean> removeList(@RequestParam(value = "ids[]") Long[] ids);

    /**
     * 根据adminid 获得文件盘文件列表
     *
     * @param
     */
    @RequestMapping(value = "/file/pagemyfile", method = RequestMethod.GET)
    Result<PageInfo<FileTreeDTO>> pageMyFile();

    /**
     * 根据ids 保存文件
     *
     * @param
     */
    @RequestMapping(value = "/file/shareSave", method = RequestMethod.POST)
    Result<Boolean> saveTo(@RequestBody ShareSaveDTO shareSaveDTO);
}
