package com.hengyunsoft.platform.logs.repository.logs.dao;

import com.hengyunsoft.platform.logs.entity.logs.domain.LogFileDO;
import com.hengyunsoft.platform.logs.entity.logs.po.*;
import com.hengyunsoft.platform.logs.repository.logs.example.*;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface LogFileMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.logs.entity.logs.po.LogFile, com.hengyunsoft.platform.logs.repository.logs.example.LogFileExample> {

    List<LogFileDO> pageQueryUpload(LogFileExample example);

    List<LogStructApp> pageQueryAppList(LogStructAppExample example);

    List<LogStructApache> pageQueryApacheList(LogStructApacheExample example);

    List<LogStructNginx> pageQueryNginxList(LogStructNginxExample example);

    List<LogStructTomcat> pageQueryTomcatList(LogStructTomcatExample example);

    int deleteLogFileInterfaceById(@Param("logFileId") Long log_file_id);

    int deleteLogFileInterfaceByIds(@Param("list") Collection<Long> list);

    List<LogFile> queryLogFileByIds(List<Long> list);

    int deleteAppByDocumentId(List<String> list);

    int deleteApacheByDocumentId(List<String> list);

    int deleteTomcatByDocumentId(List<String> list);

    int deleteNginxByDocumentId(List<String> list);

    int deleteByDocumentIds(LogFileExample example);

}