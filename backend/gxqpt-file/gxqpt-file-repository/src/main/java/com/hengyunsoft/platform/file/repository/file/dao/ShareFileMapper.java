package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.platform.file.entity.file.domain.ShareFileRateDO;
import com.hengyunsoft.platform.file.entity.file.domain.SynFileDataDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.ShareFile;
import com.hengyunsoft.platform.file.repository.file.example.ShareFileExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ShareFileMapper extends BaseAllDao<Long, ShareFile, ShareFileExample> {
    List<File> selectFileByShare(@Param("id") Long id,@Param("name") String name);

    int deleteByShareIds(@Param("appId") String appId, @Param("list") Collection<Long> list);

    List<File> selectFileTree(@Param("id") long id,@Param("name") String name);

    /**
     * 同步文件数据
     * @return
     */
    List<SynFileDataDO> findSynFileData(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    /**
     * 查询个人未分享文件大小
     * @param userId
     * @return
     */
    List<ShareFileRateDO> findFileShareRateN(@Param("userId") Long userId, @Param("appId") String appId);

    /**
     * 查询个人已分享文件大小
     * @param userId
     * @return
     */
    List<ShareFileRateDO> findFileShareRateY(@Param("userId") Long userId, @Param("appId") String appId);
}