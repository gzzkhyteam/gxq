package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.entity.file.po.File;
import com.hengyunsoft.platform.file.entity.file.po.FileDownloadWater;
import com.hengyunsoft.platform.file.repository.file.dao.FileDownloadWaterMapper;
import com.hengyunsoft.platform.file.repository.file.dao.FileMapper;
import com.hengyunsoft.platform.file.repository.file.example.FileDownloadWaterExample;
import com.hengyunsoft.platform.file.repository.file.service.FileDownWaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class FileDownWaterServiceImpl extends BaseAllServiceImpl<Long, FileDownloadWater, FileDownloadWaterExample> implements FileDownWaterService{

    @Autowired
    private FileDownloadWaterMapper fileDownloadWaterMapper;
    @Override
    protected BaseNormalDao<Long, FileDownloadWater, FileDownloadWaterExample> getDao() {
        return fileDownloadWaterMapper;
    }

}
