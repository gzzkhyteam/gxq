package com.hengyunsoft.platform.file.repository.file.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.file.entity.file.domain.FileShareNumDO;
import com.hengyunsoft.platform.file.entity.file.po.Share;
import com.hengyunsoft.platform.file.repository.file.example.ShareExample;

import java.util.List;

public interface ShareService extends BaseAllService<Long, Share, ShareExample> {
    Share saveNoId(Share entity);

    int updateBrowsTimesById(Long id);

    int updateDownloadTimesById(Long id);

    int updateSaveTimesById(Long id);

    List<FileShareNumDO> getMyShare(Long userId, String appId);
}
