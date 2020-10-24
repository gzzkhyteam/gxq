package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.platform.file.entity.file.domain.FileDownLoadDO;
import com.hengyunsoft.platform.file.entity.file.po.FileStatis;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStatisMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.file.entity.file.po.FileStatis, com.hengyunsoft.platform.file.repository.file.example.FileStatisExample> {
    int downCountIncrease(FileStatis record);
    int uploadCountIncrease(FileStatis record);
    List<FileDownLoadDO> findDown(@Param(value = "userId") Long userId);
}