package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.po.LogFileInterface;
import com.hengyunsoft.platform.logs.repository.logs.example.LogFileInterfaceExample;

import java.util.List;

public interface LogFileInterfaceService extends BaseAllService<Long, LogFileInterface, LogFileInterfaceExample> {
    /**
     * 保存interface
     * @param entity
     * @return
     */
    LogFileInterface saveInterface(LogFileInterface entity);
    /**
     * 根据 log_file_id查询一条记录
     */
    LogFileInterface queryLogFileInterfaceByLogFileId(Long id);

    /**
     * 根据doucemntId更新is_delete_struct
     * @param documentIdList
     * @return
     */
    int updateLogFileInterfaceStatus(List<String> documentIdList);

    /**
     * 查询要删除的文件信息
     * @param logFileInterfaceExample
     * @return
     */
    List<LogFileInterface> queryLogFileInterfaceByTime(LogFileInterfaceExample logFileInterfaceExample);


}
