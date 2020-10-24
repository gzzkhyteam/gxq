package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.FileExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.constant.DataType;
import com.hengyunsoft.platform.file.entity.file.domain.DateTypeNumDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileAttrDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.FileDownloadWater;
import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.entity.file.po.FileStatis;
import com.hengyunsoft.platform.file.repository.file.dao.FileDownloadWaterMapper;
import com.hengyunsoft.platform.file.repository.file.dao.FileMapper;
import com.hengyunsoft.platform.file.repository.file.dao.FileStatisMapper;
import com.hengyunsoft.platform.file.repository.file.example.FileDownloadWaterExample;
import com.hengyunsoft.platform.file.repository.file.example.FileExample;
import com.hengyunsoft.platform.file.repository.file.example.FileRecycleExample;
import com.hengyunsoft.platform.file.repository.file.example.FileStatisExample;
import com.hengyunsoft.platform.file.repository.file.service.FileRecycleService;
import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.utils.FileUtils;
import com.hengyunsoft.utils.BizAssert;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 文件 - 业务方法
 *
 * @author tyh
 * @createTime 2018-01-25 10:45
 */
@Service
@Slf4j
public class FileServiceImpl extends BaseAllServiceImpl<Long, File, FileExample> implements
        FileService {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileProperties fileProperties;
    @Autowired
    private FileRecycleService fileRecycleService;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private FileStatisMapper fileStatisMapper;
    @Autowired
    private FileDownloadWaterMapper fileDownloadWaterMapper;
    @Value("${spring.profiles.active:dev}")
    private String profiles;

    @Override
    protected BaseAllDao<Long, File, FileExample> getDao() {
        return fileMapper;
    }

    @Override
    public FileAttrDO getFileAttrDo(String appId, Long folderId) {
        String treePath = "";
        String folderName = "";
        if (folderId != null && folderId > 0) {
            File folder = this.getByAppIdAndId(appId, folderId);
            BizAssert.assertNotNull(FileExceptionCode.FILE_FOLDER_NULL, folder);
            BizAssert.assertFalse(FileExceptionCode.FILE_FOLDER_NULL, folder.getIsDelete());
            BizAssert.assertEquals(FileExceptionCode.FOLDER_PARENT_NULL, DataType.DIR.toString(), folder.getDataType());
            folderName = folder.getSubmittedFileName();
            treePath = folder.getTreePath() + folder.getId() + CommonConstants.ROOT_PATH_DEF;
        } else {
            folderId = CommonConstants.PARENT_ID_DEF;
            treePath = CommonConstants.ROOT_PATH_DEF;
        }
        return new FileAttrDO(treePath, folderName, folderId);
    }

    @Override
    public Integer removeDirByAppIdAndId(String appId, Long adminId, int isDelete, Long id) {
        return fileMapper.removeDirByAppIdAndId(appId, adminId, isDelete, id);
    }

    @Override
    public File findRecycleDeleteFile(String appId, Long adminId, int isDelete, Long id) {
        return fileMapper.findRecycleDeleteFile(appId, adminId, isDelete, id);
    }

    @Override
    public Integer updateRecycleFile(String appId, Long adminId, Long id, String treePath) {
        return fileMapper.recycleFile(appId, adminId, 0, id, treePath);
    }

    @Override
    public List<File> findRecycleFileNoAdmin(Long fileId) {
        return fileMapper.findRecycleFileNoAdmin(fileId);
    }

    @Override
    public void download(String appId, Long userId, Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = this.getById(id);
        BizAssert.assertNotNull(FileExceptionCode.FILE_NULL, file);
        BizAssert.assertFalse(FileExceptionCode.FILE_NULL, file.getIsDelete());

        String url = file.getUrl();
        String filename = file.getSubmittedFileName();
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
        HttpURLConnection connection = null;
        try {

            //正式线由于不能通外网， 所以下载需要走内网
            log.info("profiles={}", profiles);
            if ("prod".equals(profiles)) {
                //url = url.replaceAll("http://127.0.0.1", "http://192.168.30.151");
            }
            URL uri = new URL(url);
            connection = (HttpURLConnection) uri.openConnection();// 打开连接
            connection.connect();// 连接会话

            download(filename, connection.getInputStream(), request, response);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        //下载统计
//        FileDownloadWater fileDownload = new FileDownloadWater();
//        FileStatis fileStatis = fileStatisMapper.selectByAppIdAndId(appId, id);
//        if (fileStatis != null) {
//            Integer downCount = fileStatis.getDownCount();
//            fileStatis.setDownCount(downCount + 1);
//            fileStatisMapper.updateByPrimaryKey(fileStatis);
//
//        } else {
//            fileStatis = new FileStatis();
//            fileStatis.setAppId(appId);
//            fileStatis.setFileId(id);
//            fileStatisMapper.downCountIncrease(fileStatis);
//        }
//        fileDownload.setAppId(appId);
//        fileDownload.setFileId(id);
//        fileDownload.setCreateUser(userId);
//        fileDownload.setCreateTime(new Date());
//        fileDownload.setUpdateTime(new Date());
//        fileDownloadWaterMapper.insert(fileDownload);
        this.recordWater(appId, id, userId);
    }

    public void recordWater(String appId, Long id, Long userId) {
        //下载统计
        FileDownloadWater fileDownload = new FileDownloadWater();
        FileStatis fileStatis = fileStatisMapper.selectByAppIdAndId(appId, id);
        if (fileStatis != null) {
            Integer downCount = fileStatis.getDownCount();
            fileStatis.setDownCount(downCount + 1);
            fileStatisMapper.updateByPrimaryKey(fileStatis);

        } else {
            fileStatis = new FileStatis();
            fileStatis.setAppId(appId);
            fileStatis.setFileId(id);
            fileStatisMapper.downCountIncrease(fileStatis);
        }
        fileDownload.setAppId(appId);
        fileDownload.setFileId(id);
        fileDownload.setCreateUser(userId);
        fileDownload.setCreateTime(new Date());
        fileDownload.setUpdateTime(new Date());
        fileDownloadWaterMapper.insert(fileDownload);
    }

    /**
     * 下载指定输入流的图片
     *
     * @param filename
     * @param inputStream
     * @param response
     * @throws Exception
     */
    private void download(String filename, InputStream inputStream, HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
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


    @Override
    public List<FileStatis> findDownStatis(String appId, Long[] ids) {
        FileStatisExample example = new FileStatisExample();
        example.createCriteria().andAppIdEqualTo(appId).andFileIdIn(Arrays.asList(ids));
        return fileStatisMapper.selectByExample(example);
    }

    @Override
    public List<FileDownloadWater> findDownWater(String appId, Long[] fileId, String startTime, String endTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setLenient(false);

        FileDownloadWaterExample example = new FileDownloadWaterExample();
        Date start = null;
        Date end = null;
        if (StringUtils.isNotEmpty(startTime)) {
            try {
                start = formatter.parse(startTime);
            } catch (ParseException e) {
                log.error("解析日期参数出现异常", e);
                BizAssert.fail(FileExceptionCode.PARSE_DATE_EX);
            }
        }
        if (StringUtils.isNotEmpty(endTime)) {
            try {
                end = formatter.parse(endTime);
            } catch (ParseException e) {
                log.error("解析日期参数出现异常", e);
                BizAssert.fail(FileExceptionCode.PARSE_DATE_EX);
            }
        }

        FileDownloadWaterExample.Criteria criteria = example.createCriteria();
        criteria.andCreateTimeGreaterThanOrEqualTo(start)
                .andCreateTimeLessThanOrEqualTo(end);
        if (fileId != null && fileId.length > 0) {
            criteria.andFileIdIn(Arrays.asList(fileId));
        }

        return fileDownloadWaterMapper.selectByExample(example);
    }

    //处理文件夹
    public int fileRecursion(Long id, String appId, Long adminId, int result, boolean isOneLevelDelete) {

        removeDirByAppIdAndId(appId, adminId, 1, id);
        File file = findRecycleDeleteFile(appId, adminId, 1, id);
        if (file == null) {
            log.info("文件夹为空！！,id[{}]", id);
            return result;//删除失败，并结束递归
        }
        FileRecycle refile = dozerUtils.map(file, FileRecycle.class);

        FileRecycleExample fileRecycleExample = new FileRecycleExample();
        fileRecycleExample.createCriteria().andFolderIdEqualTo(file.getId());
        int count = fileRecycleService.count(fileRecycleExample);
        refile.setIsOneLevelDelete(isOneLevelDelete);
        fileRecycleService.saveNoAutoGenId(refile);
        result++;//成功返回

        //如果 count > 0 存在子文件夹已经被删除,保存当前文件夹信息,终止递归。
        if (count <= 0) {
            FileExample example = new FileExample();
            example.createCriteria().andFolderIdEqualTo(file.getId());

            //根据父文件夹Id查询子文件列表
            log.info("根据父文件夹Id[{}]查询子文件列表开始", id);

            List<File> list = fileService.find(example);
            if (list == null || list.size() <= 0) {
                log.info("无子文件夹！！,结束递归,父id[{}]", file.getId());
                return result;//无子节点，跳出递归
            }
            for (File ele : list) {
                //处理非文件夹,子目录不存在新生成的父目录情况
                if (ele != null && !DataType.DIR.toString().equals(ele.getDataType()) && ele.getFolderId() != -1) {
                    removeDirByAppIdAndId(appId, adminId, 1, ele.getId());
                }
                //处理文件夹,子目录不存在新生成的父目录情况
                if (ele != null && DataType.DIR.toString().equals(ele.getDataType()) && ele.getFolderId() != -1) {
                    log.info("进入递归处理文件夹[{}]", ele.getId());
                    result = fileRecursion(ele.getId(), appId, adminId, result, false);//递归子文件夹
                }
            }
        }
        return result;
    }

    /**
     * 删除一个或者多个文件
     * 1.不存在文件夹直接遍历删除
     * 2.存在文件夹需要递归删除,递归寻找子节点
     * 3.逻辑删除原始记录表,同时将数据放入回收站
     * 4.一级资源直接放入回收站，存在文件夹只放文件目录数据
     * 5.父节点均为一级删除，子节点相反
     * 6.存在文件夹继续递归删除文件夹及资源
     *
     * @param appId
     * @param adminId
     * @param ids
     * @return
     */
    public boolean removeList(String appId, Long adminId, Long[] ids) {
        int result = 0;
        for (Long id : ids) {
            //赋值为true:一级删除
            boolean isOneLevelDelete = true;
            File folder = getByAppIdAndId(appId, id);
            //处理文件夹情况，可能存在子文件夹
            if (folder != null && DataType.DIR.toString().equals(folder.getDataType())) {
                result = fileRecursion(id, appId, adminId, result, isOneLevelDelete);//递归子文件夹
                //处理非文件夹情况
            } else {
                removeByAppIdAndId(appId, id);
                File file = getByAppIdAndId(appId, id);
                if (file != null && file.getIsDelete()) {
                    FileRecycle refile = dozerUtils.map(file, FileRecycle.class);
                    refile.setIsOneLevelDelete(true);//一级删除
                    fileRecycleService.saveNoAutoGenId(refile);
                }
                result++;
            }
        }
        if (result > 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据ID删除
     *
     * @param appId
     * @param id
     */
    @Override
    public void removeFileByAppIdAndId(String appId, Long id) {
        File file = this.getByAppIdAndId(appId, id);
        BizAssert.assertFalse(FileExceptionCode.FILE_NOT_EXIST, file == null || file.getIsDelete()); //文件不存在
        BizAssert.assertNotEquals(FileExceptionCode.FILE_DELETE_TYPE, DataType.DIR.toString(), file.getDataType());

        //删除文件
        if (fileProperties.getFastdfs().isEnabled()) {
            FileManager.getInstance().deleteFile(file.getGroupName(), file.getRemoteFileName());
        } else {
            FileUtils.deleteFileOn(Paths.get(file.getAbsolutePath(), file.getFilename()).toString());
        }
        super.deleteById(id);
    }

    /**
     * 根据ID删除
     *
     * @param id
     */
    @Override
    public void removeFileById(Long id) {
        super.deleteById(id);
    }

    /**
     * 永久回收
     *
     * @param id
     * @param
     */
    @Override
    public void updateForeverRecycle(Long id) {
        fileMapper.foreverRecycleFile(id);
    }

    /**
     * 查询个人文件种类数量
     *
     * @param userId
     * @param
     */

    @Override
    public List<DateTypeNumDO> findByUserIdDataTypeNum(Long userId, String appId) {
        return fileMapper.findDataTypeNum(userId, appId);
    }


    @Override
    public Boolean clearAll(String appId, Long adminId) {
        FileExample example = new FileExample();
        example.createCriteria().andAppIdEqualTo(appId).andCreateUserEqualTo(adminId);
        fileMapper.deleteByExample(example);
        return true;
    }
}