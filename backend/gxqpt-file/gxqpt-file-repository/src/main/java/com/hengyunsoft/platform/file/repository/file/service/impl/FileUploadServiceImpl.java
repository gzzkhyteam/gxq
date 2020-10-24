package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.platform.file.repository.file.service.FileService;
import com.hengyunsoft.platform.file.repository.file.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件上传下载管理
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileService fileService;

    public void upload(String appId, Long folderId, String treePath, String folderName) {



    }
}
