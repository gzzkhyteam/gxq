package com.hengyunsoft.platform.file.impl.file;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.file.api.FileApi;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.DataType;
import com.hengyunsoft.platform.file.constant.FileType;
import com.hengyunsoft.platform.file.constant.IconType;
import com.hengyunsoft.platform.file.dto.AttachmentSave;
import com.hengyunsoft.platform.file.dto.FileDTO;
import com.hengyunsoft.platform.file.dto.FileListDTO;
import com.hengyunsoft.platform.file.dto.FilePageReqDTO;
import com.hengyunsoft.platform.file.dto.FileTreeDTO;
import com.hengyunsoft.platform.file.dto.FileUpdateDTO;
import com.hengyunsoft.platform.file.dto.FolderDTO;
import com.hengyunsoft.platform.file.dto.FolderSaveDTO;
import com.hengyunsoft.platform.file.dto.ShareSaveDTO;
import com.hengyunsoft.platform.file.entity.file.domain.FileAttrDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.repository.file.example.FileExample;
import com.hengyunsoft.platform.file.repository.file.example.FileRecycleExample;
import com.hengyunsoft.platform.file.repository.file.service.FileRecycleService;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.repository.file.service.ShareService;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.support.FileModel;
import com.hengyunsoft.platform.file.utils.FileDataTypeUtil;
import com.hengyunsoft.platform.file.utils.UploadUtil;
import com.hengyunsoft.platform.file.utils.ZipUtils;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tyh
 * @createTime 2018-01-25 10:49
 */
@RestController
@Slf4j
@RequestMapping("file")
@Api(value = "文件管理", description = "文件管理，用于描述文件详情")
public class FileApiImpl implements FileApi {

    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");
    @Autowired
    private FileProperties fileProperties;
    //@Autowired
    //private FolderService folderService;
    @Autowired
    private FileService fileService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileRecycleService fileRecycleService;
    @Autowired
    private ShareService shareService;

    @Value("${spring.profiles.active:dev}")
    private String profiles;

    /**
     * /file/get
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "获取文件", notes = "获取文件")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<FileDTO> get(@RequestParam(value = "id") Long id) {
        File file = fileService.getById(id);

        if (file != null && file.getIsDelete()) {
            return Result.success(null);
        }
        return Result.success(dozerUtils.map(file, FileDTO.class));
    }

    @Override
    @ApiOperation(value = "获取文件分页", notes = "获取文件分页")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<FileDTO>> page(@RequestBody OpenApiReq<FilePageReqDTO> openApiReq) {

        //查询文件分页数据
        String appId = BaseContextHandler.getAppId();
        Long userId = BaseContextHandler.getAdminId();
        if ((openApiReq.getData().getFolderId() == null || openApiReq.getData().getFolderId() < 0)
                && StringUtils.isEmpty(openApiReq.getData().getDataType())
        ) {
            openApiReq.getData().setFolderId(CommonConstants.PARENT_ID_DEF);
        }
        FileExample example = new FileExample();
        example.createCriteria().andAppIdEqualTo(appId).andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal())
                .andDataTypeEqualTo(openApiReq.getData().getDataType())
                .andFolderIdEqualTo(openApiReq.getData().getFolderId())
                .andSubmittedFileNameLike(FileExample.fullLike(openApiReq.getData().getSubmittedFileName()))
                .andCreateUserEqualTo(userId)
        ;

        example.setOrderByClause(" case when data_type='DIR' THEN 0 else 1 end asc,create_time desc ");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<File> list = fileService.find(example);

        //查询回收站一级删除数据
        Long adminId = BaseContextHandler.getAdminId();
        FileRecycleExample frExample = new FileRecycleExample();
        frExample.createCriteria().andAppIdEqualTo(appId).andAdminIdEqualTo(adminId)
                .andIsOneLevelDeleteEqualTo(true)
                .andFolderIdEqualTo(openApiReq.getData().getFolderId()).andDataTypeEqualTo(openApiReq.getData().getDataType())
                .andSubmittedFileNameLike(FileRecycleExample.fullLike(openApiReq.getData().getSubmittedFileName()));
        frExample.setOrderByClause(" update_time desc ,create_time desc ");
        List<FileRecycle> frList = fileRecycleService.find(frExample);

        //处理文件中包含的一级删除数据
        if (list.size() > 0 && frList.size() > 0) {
            Iterator<File> iterator = list.iterator();
            while (iterator.hasNext()) {
                File file = iterator.next();
                for (FileRecycle frLis : frList) {
                    if (file.getId().equals(frLis.getId())) {
                        iterator.remove();//移除一级删除数据,注意不能用for循环里直接remove,需要用迭代器。
                    }
                }
            }
        }
        List<FileDTO> pageList = dozerUtils.mapPage(list, FileDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }

    //@ApiIgnore
    @ApiOperation(value = "test", notes = "test1")
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

        try {
            Thread.sleep(2500);
        } catch (Exception e) {

        }
        return Result.success(folderSaveDto);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public FilePageReqDTO test2(OpenApiReq openApiReq, FilePageReqDTO filePageReqDTO) {
        System.out.println(JSONUtils.toJsonString(openApiReq));
        System.out.println(JSONUtils.toJsonString(filePageReqDTO));

        try {
            Thread.sleep(4000);
        } catch (Exception e) {

        }
        return filePageReqDTO;
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public FilePageReqDTO test3(OpenApiReq openApiReq, FilePageReqDTO filePageReqDTO) {
        System.out.println(JSONUtils.toJsonString(openApiReq));
        System.out.println(JSONUtils.toJsonString(filePageReqDTO));

        try {
            Thread.sleep(6000);
        } catch (Exception e) {

        }
        return filePageReqDTO;
    }


    /**
     * 保存文件夹
     *
     * @param folderSaveDto 文件夹实体对象
     * @return 文件夹对象
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 60000, message = "文件夹为空"),
            @ApiResponse(code = 60001, message = "文件夹名称为空"),
            @ApiResponse(code = 60002, message = "父文件夹为空"),
    })
    @ApiOperation(value = "保存文件夹", notes = "Response Messages 中的HTTP Status Code 值的是errcode的值")
    @RequestMapping(value = "/saveFolder", method = RequestMethod.POST)
    public Result<FolderDTO> saveFolder(@RequestBody FolderSaveDTO folderSaveDto) {
        //1，验证
        BizAssert.assertNotNull(FileExceptionCode.FOLDER_NULL, folderSaveDto);
        BizAssert.assertNotNull(FileExceptionCode.FOLDER_NAME_EMPTY, folderSaveDto.getSubmittedFileName());

        //2，获取身份
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();

        //3,转换po，并验证
        //判断同名文件
        FileExample example = new FileExample();
        File folder = dozerUtils.map2(folderSaveDto, File.class);
        if (folderSaveDto.getParentId() == null || folderSaveDto.getParentId() <= 0) {
            folderSaveDto.setParentId(CommonConstants.PARENT_ID_DEF);
            folder.setTreePath(",");
        } else {
            File parent = fileService.getByAppIdAndId(appId, folderSaveDto.getParentId());
            BizAssert.assertNotNull(FileExceptionCode.FOLDER_PARENT_NULL, parent);
            BizAssert.assertFalse(FileExceptionCode.FOLDER_PARENT_NULL, parent.getIsDelete());
            BizAssert.assertEquals(FileExceptionCode.FOLDER_PARENT_NULL, DataType.DIR.toString(), parent.getDataType());
            folder.setFolderName(parent.getSubmittedFileName());
            folder.setTreePath(parent.getTreePath() + parent.getId() + ",");
        }
        example.createCriteria().andDataTypeEqualTo(DataType.DIR.toString()).andAppIdEqualTo(appId)
                .andIsDeleteEqualTo(false).andFolderIdEqualTo(folderSaveDto.getParentId())
                .andSubmittedFileNameEqualTo(folderSaveDto.getSubmittedFileName());
        int cont = fileService.count(example);
        if (cont > 0) {
            return Result.fail("该目录下存在同名文件夹，请确认");
        }
        if (folderSaveDto.getOrderNum() == null) {
            folderSaveDto.setOrderNum(0);
        }
        folder.setAppId(appId);
        folder.setAdminId(adminId);
        folder.setCreateUser(adminId);
        folder.setUpdateUser(adminId);
        folder.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        folder.setDataType(DataType.DIR.toString());
        folder.setType(FileType.SYSTEM.toString());
        folder.setIcon(IconType.DIR.getIcon());
        folder = fileService.saveSelective(folder);

        //4,
        return Result.success(dozerUtils.map(folder, FolderDTO.class));
    }


    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public Result<String> del(String groupName, String remoteFileName) throws Exception {
        FileManager.getInstance().deleteFile(groupName, remoteFileName);
        return Result.success("ok");
    }

    @ApiOperation(value = "上传文件", notes = "上传文件 ")
    @ApiResponses({
            @ApiResponse(code = 60102, message = "文件夹为空"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "folderId", value = "文件夹id", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result<FileListDTO> upload(@RequestParam(value = "folderId") Long folderId,
                                      @ApiParam(name = "file", value = "附件1") @RequestParam(value = "file") MultipartFile[] multiFile,
                                      HttpServletRequest request) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folderId);
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        //String treePath = "";
        //String folderName = "";
        //if (folderId != null && folderId > 0) {
        //    File folder = fileService.getByAppIdAndId(appId, folderId);
        //    BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folder);
        //    BizAssert.assertFalse(FileExceptionCode.FILE_FOLDER_NULL, folder.getIsDelete());
        //    BizAssert.assertEquals(FileExceptionCode.FOLDER_PARENT_NULL, DataType.DIR.toString(), folder.getDataType());
        //    folderName = folder.getSubmittedFileName();
        //    treePath = folder.getTreePath() + folder.getId() + ",";
        //} else {
        //    folderId = CommonConstants.PARENT_ID_DEF;
        //    treePath = ",";
        //}
        FileAttrDO fileAttrDO = fileService.getFileAttrDo(appId, folderId);
        String treePath = fileAttrDO.getTreePath();
        String folderName = fileAttrDO.getFolderName();
        folderId = fileAttrDO.getFolderId();

        //1，先将文件存在本地,并且生成文件名
        List<File> fileList = new ArrayList<>();
        for (MultipartFile simpleFile : multiFile) {
            log.info("size={}, contenttype={}, name={} , sfname={}", simpleFile.getSize(), simpleFile.getContentType(), simpleFile.getName(), simpleFile.getOriginalFilename());
            // 忽略路径字段,只处理文件类型
            //if (part.getContentType() != null && !"folderId".equals(part.getName())) {
            if (simpleFile.getContentType() != null && simpleFile.getName().startsWith("file")) {
                //文件名
                String submittedFileName = simpleFile.getOriginalFilename();
                String fileMd5 = request.getParameter(submittedFileName);
                //后缀
                //String suffix = FileUtils.getExtension(submittedFileName);
                //生成文件名
                //String fileName = UUID.randomUUID().toString() + suffix;


                //日期文件夹
                //String secDir = LocalDate.now().format(DTF);
                // /home/tyh/APP_ID/YYYY/MM
                //String relativePath = Paths.get(appId, secDir).toString();
                //String absolutePath = Paths.get(fileProperties.getUploadPathPrefix(), relativePath).toString();

                //存到web服务器
                //FileUtils.write(simpleFile.getInputStream(), absolutePath, fileName);
                //
                ////上传到fastdfs 并且返回 访问 url
                //FileModel fileModel = UploadUtil.remove2DFS(appId, "FILE",
                //        fileProperties, absolutePath, relativePath, fileName);

                FileModel fileModel = UploadUtil.upload(appId, "FILE", fileProperties, simpleFile.getInputStream(), submittedFileName);
                if (fileModel == null || org.apache.commons.lang.StringUtils.isEmpty(fileModel.getRemotePath())) {
                    return Result.fail("上传失败~");
                }
                File file = dozerUtils.map2(fileModel, File.class);
                file.setAppId(appId);
                file.setAdminId(adminId);
                file.setFolderId(folderId);
                file.setFolderName(folderName);
                file.setCreateUser(adminId);
                file.setUpdateUser(adminId);
                file.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                file.setSubmittedFileName(submittedFileName);
                file.setIcon(IconType.getIcon(file.getExt()).getIcon());
                file.setDataType(FileDataTypeUtil.getDataType(file.getMime()).toString());
                file.setContextType(simpleFile.getContentType());
                file.setType(com.hengyunsoft.platform.file.constant.FileType.SYSTEM.toString());
                file.setTreePath(treePath);
                file.setFileMd5(fileMd5);

                fileList.add(file);

            }
        }

        //存储
        if (!fileList.isEmpty()) {
            fileService.save(fileList);
        }

        //4,转换
        List<FileDTO> list = dozerUtils.mapList(fileList, FileDTO.class);
        FileListDTO fileListDTO = new FileListDTO();
        fileListDTO.setList(list);
        return Result.success(fileListDTO);
    }

    @Override
    @ApiOperation(value = "修改文件信息", notes = "修改文件信息")
    @ApiResponses({
            @ApiResponse(code = 60100, message = "文件为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody FileUpdateDTO fileUpdateDTO) {
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, fileUpdateDTO);
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, fileUpdateDTO.getId());
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        // 判断文件名是否有 后缀
        if (StringUtils.isNotEmpty(fileUpdateDTO.getSubmittedFileName())) {
            File oldFile = fileService.getByAppIdAndId(appId, fileUpdateDTO.getId());
            //判断同名文件
            FileExample example = new FileExample();
            example.createCriteria().andDataTypeEqualTo(oldFile.getDataType()).andAppIdEqualTo(oldFile.getAppId())
                    .andIsDeleteEqualTo(oldFile.getIsDelete()).andFolderIdEqualTo(oldFile.getFolderId())
                    .andFolderNameEqualTo(oldFile.getFolderName()).andSubmittedFileNameEqualTo(fileUpdateDTO.getSubmittedFileName());
            int cont = fileService.count(example);
            if (cont > 0) {
                return Result.fail("该目录下存在同名文件，请确认");
            }
            if (oldFile.getExt() != null && !fileUpdateDTO.getSubmittedFileName().endsWith(oldFile.getExt())) {
                fileUpdateDTO.setSubmittedFileName(fileUpdateDTO.getSubmittedFileName() + "." + oldFile.getExt());
            }
        }
        File file = dozerUtils.map2(fileUpdateDTO, File.class);
        //String parentTreePath = CommonConstants.ROOT_PATH_DEF;
        //if (fileUpdateDTO.getFolderId() != null) {
        //    File folder = fileService.getByAppIdAndId(appId, fileUpdateDTO.getFolderId());
        //    BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folder);
        //    BizAssert.assertFalse(FileExceptionCode.FILE_FOLDER_NULL, folder.getIsDelete());
        //    BizAssert.assertEquals(FileExceptionCode.FOLDER_PARENT_NULL, DataType.DIR.toString(), folder.getDataType());
        //    file.setFolderName(folder.getSubmittedFileName());
        //    parentTreePath = folder.getTreePath() + folder.getId() + ",";
        //}

        file.setUpdateUser(adminId);
        int result = fileService.updateByAppIdAndIdSelective(appId, file);
        //if (result > 0) {
        //    List<File> treeList = new ArrayList<>();
        //    List<File> list = fileService.findRecycleFile(appId, adminId, File.UNDELETE, fileUpdateDTO.getId());
        //    for (File fileP : list) {
        //        if (fileP.getId().equals(fileUpdateDTO.getId())) {
        //            treeList.add(fileP);
        //        }
        //        for (File f : list) {
        //            if (f.getFolderId().equals(fileP.getId())) {
        //                if (fileP.getChildFile() == null) {
        //                    fileP.setChildFile(new ArrayList<>());
        //                }
        //                fileP.getChildFile().add(f);
        //            }
        //        }
        //    }
        //    setTreePath(treeList, parentTreePath);
        //}
        return Result.success(true);
    }

    //private List<File> setTreePath(List<File> fileList, String parentTreePath) {
    //    for (File f : fileList) {
    //        f.setTreePath(parentTreePath);
    //        fileService.updateByAppIdAndIdSelective(f.getAppId(), f);
    //        if (f.getChildFile() != null) {
    //            setTreePath(f.getChildFile(), f.getTreePath() + f.getId() + ",");
    //        }
    //    }
    //    return fileList;
    //}

    @Override
    @ApiOperation(value = "删除文件", notes = "删除文件")
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public Result<Boolean> remove(@RequestParam(value = "id") Long id) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        File folder = fileService.getByAppIdAndId(appId, id);
        if (folder != null && DataType.DIR.toString().equals(folder.getDataType())) {
            int result = fileService.removeDirByAppIdAndId(appId, adminId, 1, id);
            File file = fileService.findRecycleDeleteFile(appId, adminId, 1, id);
            FileRecycle refile = dozerUtils.map(file, FileRecycle.class);
            refile.setIsOneLevelDelete(true);//一级删除
            fileRecycleService.saveNoAutoGenId(refile);
            if (result > 0) {
                return Result.success(true);
            } else {
                return Result.fail("fail");
            }
        } else {
            fileService.removeByAppIdAndId(appId, id);
            FileExample example = new FileExample();
            example.createCriteria().andAppIdEqualTo(appId).andIdEqualTo(id);
            File file = fileService.getByAppIdAndId(appId, id);
            FileRecycle refile = dozerUtils.map(file, FileRecycle.class);
            refile.setIsOneLevelDelete(true);//一级删除
            fileRecycleService.saveNoAutoGenId(refile);
        }
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "获取个人文件列表", notes = "获取个人文件列表")
    @RequestMapping(value = "/pagemyfile", method = RequestMethod.GET)
    public Result<PageInfo<FileTreeDTO>> pageMyFile() {
        //获得用户id
        Long adminId = BaseContextHandler.getAdminId();
        if (null == adminId) {
            return null;
        }

        //设置查询条件
        FileExample fileExample = new FileExample();
        //isDelete--1:已删除;0:未删除
        fileExample.createCriteria().andAdminIdEqualTo(adminId).andIsDeleteEqualTo(false).andDataTypeEqualTo(DataType.DIR.toString());
        //查询并转换 对象
        List<File> fileList = fileService.find(fileExample);
        List<FileTreeDTO> fileTreeList = dozerUtils.mapPage(fileList, FileTreeDTO.class);
        List<FileTreeDTO> fileNewTreeList = new ArrayList<>();

        //规划文件树结构
        ergodic(fileTreeList, fileNewTreeList, -1L);
        return Result.success(new PageInfo<>(fileNewTreeList));
    }

    /**
     * 递归文件树结构
     *
     * @param fileList  总文件集合
     * @param noteList  节点集合
     * @param ergodicId 节点文件规划Id
     */
    void ergodic(List<FileTreeDTO> fileList, List<FileTreeDTO> noteList, Long ergodicId) {
        for (FileTreeDTO fileTreeDTO : fileList) {
            if (ergodicId.equals(fileTreeDTO.getFolderId())) {
                fileTreeDTO.setChildFile(new ArrayList<>());
                noteList.add(fileTreeDTO);
                ergodic(fileList, fileTreeDTO.getChildFile(), fileTreeDTO.getId());
            }
        }
    }

    /**
     * 保存文件至本用户
     *
     * @param shareSaveDTO 分享保存实体
     * @return
     */
    @Override
    @ApiOperation(value = "保存分享文件", notes = "保存分享文件")
    @RequestMapping(value = "/shareSave", method = RequestMethod.POST)
    public Result<Boolean> saveTo(@RequestBody ShareSaveDTO shareSaveDTO) {
        //查询出ids对应的对象集合
        for (Long fileid : shareSaveDTO.getFileIds()) {
            List<File> fileList = fileService.findRecycleFileNoAdmin(fileid);
            FileExample fileExample = new FileExample();
            fileExample.createCriteria().andIdEqualTo(shareSaveDTO.getFolderId());
            File parentFile = fileService.getUnique(fileExample);

            //规整treeList
            List<File> treeList = new ArrayList<>();
            for (File fileP : fileList) {
                if (fileP.getId().equals(fileid)) {
                    treeList.add(fileP);
                }
                for (File f : fileList) {
                    if (f.getFolderId().equals(fileP.getId())) {
                        if (fileP.getChildFile() == null) {
                            fileP.setChildFile(new ArrayList<>());
                        }
                        fileP.getChildFile().add(f);
                    }
                }
            }

            //递归调用
            List<File> llist = setTreePaths(treeList, fileService.genId(), parentFile);
        }
        //添加保存次数
        shareService.updateSaveTimesById(shareSaveDTO.getShareId());
        return Result.success(true);
    }

    //递归封装子文件
    private List<File> setTreePaths(List<File> treeList, Long id, File father) {
        for (File f : treeList) {
            f.setId(id);
            f.setAppId(BaseContextHandler.getAppId());
            f.setAdminId(BaseContextHandler.getAdminId());
            f.setFolderId(father.getId());
            f.setTreePath(father.getTreePath() + father.getId() + ",");
            f.setCreateUser(BaseContextHandler.getAdminId());
            f.setUpdateUser(BaseContextHandler.getAdminId());
            //保存到数据库
            fileService.save(f);
            if (f.getChildFile() != null) {
                setTreePaths(f.getChildFile(), fileService.genId(), f);
            }
        }
        return treeList;
    }


    /**
     * 下载指定文件
     *
     * @param url      文件url
     * @param filename 文件名
     * @return
     */
    //@Override
    @ApiOperation(value = "下载文件", notes = "下载文件, 这个接口不需要token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "文件url", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "filename", value = "文件名", dataType = "string", paramType = "query"),
    })
    @IgnoreAppToken
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download_TX(@RequestParam(value = "url") String url, @RequestParam(value = "filename") String filename,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        log.info("name={}, url={}", filename, url);
        if (StringUtils.isEmpty(url)) {
            return;
        }
        if (StringUtils.isEmpty(filename)) {
            try {
                filename = StringUtils.substring(url, url.lastIndexOf("/"));
            } catch (Exception e) {
                filename = "未知文件.txt";
            }
        }

        FileExample example = new FileExample();
        example.createCriteria().andUrlEqualTo(url).andSubmittedFileNameEqualTo(filename);
        File unique = fileService.getUnique(example);
        if (unique != null) {
            fileService.recordWater(unique.getAppId(), unique.getId(), unique.getAdminId());
        }

        /*正式线由于不能通外网， 所以下载需要走内网，该代码仅仅用在高新区项目的正式线环境，
          copy代码时，请自行删除， 是为了解决正式环境的网络问题*/
        log.info("profiles={}", profiles);
        if ("prod".equals(profiles)) {
//            url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
        }

        HttpURLConnection connection = null;
        try {
            URL uri = new URL(url);
            connection = (HttpURLConnection) uri.openConnection();// 打开连接
            connection.connect();// 连接会话

            download(filename, connection.getInputStream(), request, response);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
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
        if (StringUtils.isEmpty(filename)) {
            filename = "未知文件.txt";
        }
        OutputStream os = null;
        try {
            response.setContentType("application/force-download");
            if (!StringUtils.isEmpty(filename)) {
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

    /**
     * 打包下载
     *
     * @param ids
     * @param response
     * @throws Exception
     */
    //@Override
    @ApiOperation(value = "打包下载多个文件", notes = "打包下载多个文件, 这个接口不需要token")
    @IgnoreAppToken
    @RequestMapping(value = "/downloadpackage", method = RequestMethod.GET)
    public void downloadPackage(@RequestParam(value = "ids[]") Long[] ids, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (ids == null || ids.length == 0) {
            return;
        }
        String fileName = "";
        if (ids.length == 1) {
            File file = fileService.getById(ids[0]);
            if (DataType.DIR.equals(file.getDataType())) {
                return;
            }
            String url = file.getUrl();
            /*正式线由于不能通外网， 所以下载需要走内网，该代码仅仅用在高新区项目的正式线环境，
              copy代码时，请自行删除， 是为了解决正式环境的网络问题*/
            log.info("profiles={}", profiles);
            if ("prod".equals(profiles)) {
                //url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
            }

            HttpURLConnection connection = null;
            try {
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
            if (file == null || DataType.DIR.equals(file.getDataType())) {
                return;
            }
            fileName = file.getSubmittedFileName();
            log.info("fileName={}", fileName);
            if (StringUtils.isNotEmpty(file.getSubmittedFileName())) {
                fileName = StringUtils.substring(file.getSubmittedFileName(), 0, file.getSubmittedFileName().lastIndexOf("."));
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
                    fileService.recordWater(f.getAppId(), f.getId(), f.getAdminId());

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
                    String perfix = f.getSubmittedFileName().substring(0, f.getSubmittedFileName().lastIndexOf("."));
                    String end = f.getSubmittedFileName().substring(f.getSubmittedFileName().lastIndexOf("."), f.getSubmittedFileName().length());
                    ZipUtils.zipFilesByInputStream(zipOut, perfix + "-" + (i + 1) + end, connection.getInputStream());
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

    }

    /**
     * 文件秒传
     *
     * @param folderId
     * @param request
     * @return
     * @throws Exception
     */
    //@Override
    @ApiOperation(value = "文件秒传", notes = "文件秒传   ")
    @ApiResponses({
            @ApiResponse(code = 60102, message = "文件夹为空"),
            @ApiResponse(code = 60002, message = "父文件夹为空"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "folderId", value = "文件夹id", dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "file0", value = "附件1", dataType = "file", paramType = "query"),
    })
    @RequestMapping(value = "/uploadspeed", method = RequestMethod.POST)
    public Result<FileListDTO> uploadSpeed(@RequestParam(value = "folderId") Long folderId,
                                           @RequestParam(value = "exsistFileMd5 []") String[] exsistFileMd5,
                                           HttpServletRequest request) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folderId);
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        //String treePath = "";
        //String folderName = "";
        //if (folderId != null && folderId > 0) {
        //    File folder = fileService.getByAppIdAndId(appId, folderId);
        //    folderName = folder.getSubmittedFileName();
        //    BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folder);
        //    BizAssert.assertFalse(FileExceptionCode.FILE_FOLDER_NULL, folder.getIsDelete());
        //    BizAssert.assertEquals(FileExceptionCode.FOLDER_PARENT_NULL, DataType.DIR.toString(), folder.getDataType());
        //    treePath = folder.getTreePath() + folder.getId() + ",";
        //} else {
        //    folderId = CommonConstants.PARENT_ID_DEF;
        //    treePath = ",";
        //}
        FileAttrDO fileAttrDO = fileService.getFileAttrDo(appId, folderId);
        String treePath = fileAttrDO.getTreePath();
        String folderName = fileAttrDO.getFolderName();
        folderId = fileAttrDO.getFolderId();

        //1，先将文件存在本地,并且生成文件名
        List<File> fileList = new ArrayList<>();
        // Servlet3.0方式上传文件
        Collection<Part> parts = request.getParts();
        //处理秒传文件
        for (String md5 : exsistFileMd5) {
            FileExample fileExample = new FileExample();
            fileExample.createCriteria().andFileMd5EqualTo(md5);
            File filet = fileService.getUnique(fileExample);
            if (filet != null && filet.getId() != null) {
                filet.setAppId(appId);
                filet.setAdminId(adminId);
                filet.setFolderId(folderId);
                filet.setCreateUser(adminId);
                filet.setUpdateUser(adminId);
                filet.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                filet.setTreePath(treePath);
                fileService.saveSelective(filet);
                fileList.add(filet);
            }
        }
        for (Part part : parts) {
            log.info("contenttype={}, name={} , sfname={}", part.getContentType(), part.getName(), part.getSubmittedFileName());
            // 忽略路径字段,只处理文件类型
            if (part.getContentType() != null && part.getName().startsWith("file")) {
                //文件名
                String submittedFileName = part.getSubmittedFileName();
                String fileMd5 = request.getParameter(submittedFileName);
                ////后缀
                //String suffix = FileUtils.getExtension(submittedFileName);
                ////生成文件名
                //String fileName = UUID.randomUUID().toString() + suffix;

                try {
                    //日期文件夹
                    //String secDir = LocalDate.now().format(DTF);
                    //// /home/tyh/APP_ID/YYYY/MM
                    //String relativePath = Paths.get(appId, secDir).toString();
                    //String absolutePath = Paths.get(fileProperties.getUploadPathPrefix(), relativePath).toString();
                    //
                    ////存到web服务器
                    //FileUtils.write(part.getInputStream(), absolutePath, fileName);
                    //
                    ////上传到fastdfs 并且返回 访问 url
                    //FileModel fileModel = UploadUtil.remove2DFS(appId, "FILE",
                    //        fileProperties, absolutePath, relativePath, fileName);
                    FileModel fileModel = UploadUtil.upload(appId, "FILE", fileProperties,
                            part.getInputStream(), submittedFileName);

                    File file = dozerUtils.map2(fileModel, File.class);
                    file.setAppId(appId);
                    file.setAdminId(adminId);
                    file.setFolderId(folderId);
                    file.setFolderName(folderName);
                    file.setCreateUser(adminId);
                    file.setUpdateUser(adminId);
                    file.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                    file.setSubmittedFileName(submittedFileName);
                    file.setIcon(IconType.getIcon(file.getExt()).getIcon());
                    file.setDataType(FileDataTypeUtil.getDataType(file.getMime()).toString());
                    file.setContextType(part.getContentType());
                    file.setType(com.hengyunsoft.platform.file.constant.FileType.SYSTEM.toString());
                    file.setTreePath(treePath);
                    file.setFileMd5(fileMd5);
                    fileService.saveSelective(file);
                    fileList.add(file);
                } catch (Exception e) {
                    log.error("保存文件到服务器临时目录失败:", e);
                }
            }
        }

        //4,转换
        List<FileDTO> list = dozerUtils.mapList(fileList, FileDTO.class);
        FileListDTO fileListDTO = new FileListDTO();
        fileListDTO.setList(list);
        return Result.success(fileListDTO);
    }

    /**
     * 秒传MD5校验接口
     *
     * @param md5
     * @return
     * @throws Exception
     */
    @Override
    @ApiOperation(value = "秒传MD5校验接口", notes = "秒传MD5校验接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "md5", value = "文件MD5值", dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/uploadMd5Check", method = RequestMethod.POST)
    public boolean uploadMd5Check(String md5) throws Exception {
        FileExample fileExample = new FileExample();
        fileExample.createCriteria().andFileMd5EqualTo(md5);
        File filet = fileService.getUnique(fileExample);
        if (filet != null && filet.getId() != null) {
            return true;
        }
        return false;
    }

    /**
     * 文件秒传\n
     * 提供改接口的原因是，当对上传的文件进行校验发现都可以进行秒传时，
     * 所有文件将跳过，也就是webuploader不再发起请求，除非只有个别不能秒传时它还会向后端发送请求。
     * 该接口就处理该种情况
     *
     * @param folderId
     * @return
     * @throws Exception
     */
    @Override
    @ApiOperation(value = "所有文件秒传通知接口", notes = "所有文件秒传通知接口  ")
    @ApiResponses({
            @ApiResponse(code = 60102, message = "文件夹为空"),
            @ApiResponse(code = 60002, message = "父文件夹为空"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exsistFileMd5[]", value = "文件MD5值数组", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "folderId", value = "文件夹ID", dataType = "long", paramType = "query"),
    })
    @RequestMapping(value = "/uploadspeedall", method = RequestMethod.POST)
    public Result<FileListDTO> uploadSpeedAll(@RequestParam(value = "folderId") Long folderId,
                                              @RequestParam(value = "exsistFileMd5 []") String[] exsistFileMd5) throws Exception {
        BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folderId);
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();

        FileAttrDO fileAttrDO = fileService.getFileAttrDo(appId, folderId);
        String treePath = fileAttrDO.getTreePath();
        folderId = fileAttrDO.getFolderId();

        //1，先将文件存在本地,并且生成文件名
        List<File> fileList = new ArrayList<>();
        //处理秒传文件
        for (String md5 : exsistFileMd5) {
            FileExample fileExample = new FileExample();
            fileExample.createCriteria().andFileMd5EqualTo(md5);
            File filet = fileService.getUnique(fileExample);
            if (filet != null && filet.getId() != null) {
                filet.setAppId(appId);
                filet.setAdminId(adminId);
                filet.setFolderId(folderId);
                filet.setCreateUser(adminId);
                filet.setUpdateUser(adminId);
                filet.setIsDelete(DeleteStatus.UN_DELETE.getVal());
                filet.setTreePath(treePath);
                fileService.saveSelective(filet);
                fileList.add(filet);
            }
        }
        List<FileDTO> list = dozerUtils.mapList(fileList, FileDTO.class);
        FileListDTO fileListDTO = new FileListDTO();
        fileListDTO.setList(list);
        return Result.success(fileListDTO);
    }

    /**
     * 根据Ids进行文件删除
     *
     * @param ids
     * @return
     */
    @Override
    @ApiOperation(value = "根据Ids进行文件删除", notes = "根据Ids进行文件删除  ")
    @RequestMapping(value = "/removeList", method = RequestMethod.POST)
    public Result<Boolean> removeList(@RequestParam(value = "ids[]") Long[] ids) {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        return Result.success(fileService.removeList(appId, adminId, ids));
    }

    @ApiOperation(value = "清空所有文件", notes = "清空所有文件")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public Result<Boolean> clearAll() {
        String appId = BaseContextHandler.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        return Result.success(fileService.clearAll(appId, adminId));
    }


    @ApiOperation(value = "保存附件", notes = "保存附件")
    @RequestMapping(value = "/saveAttachment", method = RequestMethod.POST)
    public Result<File> saveAttachment(@RequestBody AttachmentSave attachmentSave) {
        log.info("url={}, name={}", attachmentSave.getUrl(), attachmentSave.getFilename());
        FileExample example = new FileExample();
        example.createCriteria().andUrlEqualTo(attachmentSave.getUrl())
                .andSubmittedFileNameEqualTo(attachmentSave.getFilename());
        File file = fileService.getUnique(example);
        log.info("file={}", JSONObject.toJSONString(file));
        if (file == null) {
            return Result.fail("文件不存在，无法保存");
        }

        file.setId(null);
        file.setAppId("45kj6352");
        file.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        file.setType(FileType.SYSTEM.toString());
        file.setCreateTime(new Date());
        file.setCreateUser(BaseContextHandler.getAdminId());
        file.setUpdateUser(BaseContextHandler.getAdminId());
        fileService.saveSelective(file);
        return Result.success(file);
    }

}
