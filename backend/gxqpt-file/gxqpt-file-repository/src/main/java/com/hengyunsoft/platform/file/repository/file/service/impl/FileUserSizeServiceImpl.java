package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.entity.file.po.FileUserSize;
import com.hengyunsoft.platform.file.repository.file.dao.FileUserSizeMapper;
import com.hengyunsoft.platform.file.repository.file.example.FileUserSizeExample;
import com.hengyunsoft.platform.file.repository.file.service.FileUserSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUserSizeServiceImpl extends BaseAllServiceImpl<Long, FileUserSize, FileUserSizeExample> implements FileUserSizeService {
    @Autowired
    private FileUserSizeMapper fileUserSizeMapper;

    @Override
    protected BaseAllDao<Long, FileUserSize, FileUserSizeExample> getDao() {
        return fileUserSizeMapper;
    }

}
