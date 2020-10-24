package com.hengyunsoft.platform.file.repository.file.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.file.entity.file.domain.DateTypeNumDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileAttrDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.FileDownloadWater;
import com.hengyunsoft.platform.file.entity.file.po.FileStatis;
import com.hengyunsoft.platform.file.repository.file.example.FileExample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author tyh
 * @createTime 2018-01-25 10:44
 */
public interface FileService extends BaseAllService<Long, File, FileExample> {
    FileAttrDO getFileAttrDo(String appId, Long folderId);

    /**
     * 根据appId和 tree_path 删除文件夹
     *
     * @param appId
     * @param id
     */
    Integer removeDirByAppIdAndId(String appId, Long adminId, int isDelete, Long id);

    /**
     * 根据appid 和 tree_path 查询数据
     *
     * @param
     * @return
     */
    File findRecycleDeleteFile(String appId, Long adminId, int isDelete, Long id);


    Integer updateRecycleFile(String appId, Long adminId, Long id, String treePath);

    List<File> findRecycleFileNoAdmin(Long fileId);

    /**
     * 下载文件
     *
     * @param id
     * @param response
     */
    void download(String appId, Long userId, Long id, HttpServletRequest request, HttpServletResponse response) throws Exception;
    void recordWater(String appId, Long id, Long userId);
    List<FileStatis> findDownStatis(String appId, Long[] ids);
    /**
     * 查询下载文件流水
     *
     * @param appId，ids
     */
    List<FileDownloadWater> findDownWater(String appId, Long[] fileId, String startTime, String endTime);

    /**
     * 删除一个或者多个文件
     * @param appId
     * @param adminId
     * @param ids
     * @return
     */
    boolean removeList(String appId, Long adminId, Long[] ids);

    /**
     * 根据id删除
     * @param appId
     * @param id
     */
    void removeFileByAppIdAndId(String appId, Long id);

    /**
     * 根据id删除
     * @param id
     */
    void removeFileById(Long id);

    /**
     * 永久回收
     * @param id
     * @param
     */
    void updateForeverRecycle(Long id);

    List<DateTypeNumDO> findByUserIdDataTypeNum(Long userId, String appId);

    Boolean clearAll(String appId, Long adminId);
}
