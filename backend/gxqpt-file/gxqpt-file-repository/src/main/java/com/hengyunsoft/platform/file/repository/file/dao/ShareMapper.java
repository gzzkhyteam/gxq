package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareNumDO;
import com.hengyunsoft.platform.file.entity.file.domain.QueryFileShareDO;
import com.hengyunsoft.platform.file.entity.file.po.Share;
import com.hengyunsoft.platform.file.repository.file.example.ShareExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareMapper extends BaseAllDao<Long, Share, ShareExample> {
    int updateBrowsTimesById(Long id);

    int updateDownloadTimesById(Long id);

    int updateSaveTimesById(Long id);

    List<FileShareDO> findShareN(@Param(value = "userId") Long userId);

    List<FileShareDO> findShare(@Param("queryFileShareDo") QueryFileShareDO queryFileShareDo);

    List<FileShareNumDO> getMyShare(@Param("userId") Long userId, @Param("appId") String appId);
}
