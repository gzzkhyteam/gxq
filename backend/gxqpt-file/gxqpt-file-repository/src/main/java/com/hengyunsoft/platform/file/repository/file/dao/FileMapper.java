package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.platform.file.entity.file.domain.FileUpDO;
import com.hengyunsoft.platform.file.entity.file.domain.DateTypeNumDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.repository.file.example.FileExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FileMapper extends BaseAllDao<Long, File, FileExample> {
    /**
     * 根据appid 和 tree_path 删除文件夹
     * @return
     */
    Integer removeDirByAppIdAndId(@Param("appId") String appId,  @Param("adminId") Long adminId,@Param("isDelete")int isDelete,@Param("id") Long id);

    /**
     * 根据appid 和 tree_path 查询数据
     * @param appId
     * @param id
     * @return
     */
    File findRecycleDeleteFile(@Param("appId") String appId,  @Param("adminId") Long adminId,@Param("isDelete")int isDelete,@Param("id") Long id);

    List<File> findRecycleFileNoAdmin(@Param("id")Long id);

    /**
     * 还原文件数据
     * @param appId
     * @param adminId
     * @param
     * @param id
     * @param treePath
     * @return
     */
    Integer recycleFile(@Param("appId") String appId,  @Param("adminId") Long adminId,
                        @Param("isDelete")int isDelete,@Param("id") Long id,@Param("treePath")String treePath);

    /**
     * 永久回收
     * @param id
     * @param
     */
    void foreverRecycleFile(@Param("id") Long id);

    List<DateTypeNumDO> findDataTypeNum(@Param("userId") Long userId, @Param("appId") String appId);

    List<FileUpDO> fileUp(@Param(value = "userId") Long userId);
}