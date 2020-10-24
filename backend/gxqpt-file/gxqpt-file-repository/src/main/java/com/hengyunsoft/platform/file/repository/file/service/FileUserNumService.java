package com.hengyunsoft.platform.file.repository.file.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.file.entity.file.domain.FileDataTypeDevViewDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileDevViewDO;
import com.hengyunsoft.platform.file.entity.file.po.FileUserNum;
import com.hengyunsoft.platform.file.repository.file.example.FileUserNumExample;

import java.util.List;

/**
 * @author wt
 * @createTime 2018-9-6
 */
public interface FileUserNumService extends BaseAllService<Long, FileUserNum, FileUserNumExample> {

    FileDevViewDO getYearMonthNum(Long userId, String yearMonth, String appId);

    List<FileDataTypeDevViewDO> getFileDataType(Long userId, String yearMonth, String appId);
}
