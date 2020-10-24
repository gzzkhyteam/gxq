package com.hengyunsoft.platform.logs.repository.logs.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.logs.entity.logs.domain.LogFileDO;
import com.hengyunsoft.platform.logs.entity.logs.po.*;
import com.hengyunsoft.platform.logs.repository.logs.example.*;
import java.util.List;

public interface LogFileService extends BaseAllService<Long, LogFile, LogFileExample> {
    /**
     *分页查询日志系统上传的日志文档查询
     * 查询默认值data_channel=‘UPLOAD’
     * @param example
     * @return
     */
    List<LogFileDO> pageQueryUpload(LogFileExample example);
    /**
     *根据document分页查询应用系统解析后的日志信息
     * @param example
     * @return
     */
    List<LogStructApp> pageQueryAppList(LogStructAppExample example);
    /**
     *根据document分页查询apache解析后的日志信息
     * @param example
     * @return
     */
    List<LogStructApache> pageQueryApacheList(LogStructApacheExample example);
    /**
     *根据document分页查询nginx解析后的日志信息
     * @param example
     * @return
     */
    List<LogStructNginx> pageQueryNginxList(LogStructNginxExample example);
    /**
     *根据document分页查询tomcat解析后的日志信息
     * @param example
     * @return
     */
    List<LogStructTomcat> pageQueryTomcatList(LogStructTomcatExample example);

    /**
     * 物理删除log_file_interface记录
     *
     * @param log_file_id
     * @return 影响行数
     */
    int deleteLogFileInterfaceById(Long log_file_id);

    /**
     * 物理删除log_file_interface记录
     *
     * @param list
     * @return 影响行数
     */
    int deleteLogFileInterfaceByIds(List<Long> list);
    /**
     * 查询要删除的记录信息
     *
     * @param list
     * return
     */
    List<LogFile> queryLogFileByIds(List<Long> list);

    /**
     * 物理删除log_struct_app记录
     *
     * @param list
     * @return 影响行数
     */
    int deleteAppByDocumentId(List<String> list);
    /**
     * 物理删除log_struct_apache记录
     *
     * @param list
     * @return 影响行数
     */
    int deleteApacheByDocumentId(List<String> list);
    /**
     * 物理删除log_struct_tomcat记录
     *
     * @param list
     * @return 影响行数
     */
    int deleteTomcatByDocumentId(List<String> list);
    /**
     * 物理删除log_struct_nginx记录
     *
     * @param list
     * @return 影响行数
     */
    int deleteNginxByDocumentId(List<String> list);
    /**
     * 根据 documentId删除日志
     * @param example
     * @return
     */
    int deleteByDocumentIds (LogFileExample example,String conditions);


}
