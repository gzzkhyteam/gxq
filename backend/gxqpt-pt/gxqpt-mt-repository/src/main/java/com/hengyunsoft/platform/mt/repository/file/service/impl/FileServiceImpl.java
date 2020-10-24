package com.hengyunsoft.platform.mt.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.file.po.File;
import com.hengyunsoft.platform.mt.repository.file.dao.FileMapper;
import com.hengyunsoft.platform.mt.repository.file.example.FileExample;
import com.hengyunsoft.platform.mt.repository.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends BaseServiceImpl<Long, File, FileExample> implements FileService {
    @Autowired
    private FileMapper fileMapper;

    @Override
    protected BaseNormalDao<Long, File, FileExample> getDao() {
        return fileMapper;
    }
}
