package com.hengyunsoft.platform.file.repository.file.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.file.entity.file.domain.ShareFileRateDO;
import com.hengyunsoft.platform.file.entity.file.domain.SynFileDataDO;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.ShareFile;
import com.hengyunsoft.platform.file.repository.file.example.ShareFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ShareFileService extends BaseAllService<Long, ShareFile, ShareFileExample> {
    List<File> selectFileByShare(Long id,String name);

    int deleteByShareIds(String appId, Collection<Long> list);

    int deleteByShareIds(Collection<Long> list);

    List<File> selectFileTree(long id,String name);

    /**
     * 同步文件数据
     * @return
     */
    List<SynFileDataDO> findSynFileData(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /**
     * 查询个人未分享文件大小
     * @param userId
     * @return
     */
    List<ShareFileRateDO> findFileShareRateN(Long userId, String appId);

    /**
     * 查询个人已分享文件大小
     * @param userId
     * @return
     */
    List<ShareFileRateDO> findFileShareRateY(Long userId, String appId);
}
