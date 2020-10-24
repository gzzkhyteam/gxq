package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.platform.file.entity.file.domain.FileUpDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDownloadWaterMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.file.entity.file.po.FileDownloadWater, com.hengyunsoft.platform.file.repository.file.example.FileDownloadWaterExample> {

    List<FileUpDO> fileDown(@Param(value = "userId") Long userId);
}