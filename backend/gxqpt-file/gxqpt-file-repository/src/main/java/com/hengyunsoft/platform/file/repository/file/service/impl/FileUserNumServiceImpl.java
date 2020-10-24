package com.hengyunsoft.platform.file.repository.file.service.impl;

import com.hengyunsoft.base.dao.BaseAllDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.file.entity.file.domain.FileDataTypeDevViewDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileDevViewDO;
import com.hengyunsoft.platform.file.entity.file.po.FileUserNum;
import com.hengyunsoft.platform.file.repository.file.dao.FileUserNumMapper;
import com.hengyunsoft.platform.file.repository.file.example.FileUserNumExample;
import com.hengyunsoft.platform.file.repository.file.service.FileUserNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUserNumServiceImpl extends BaseAllServiceImpl<Long, FileUserNum, FileUserNumExample> implements FileUserNumService {
    @Autowired
    private FileUserNumMapper fileUserNumMapper;

    @Override
    protected BaseAllDao<Long, FileUserNum, FileUserNumExample> getDao() {
        return fileUserNumMapper;
    }

    /**
     * @Author mdengbo
     * */
    @Override
    public FileDevViewDO getYearMonthNum(Long userId, String yearMonth, String appId) {
        return fileUserNumMapper.getYearMonthNum(userId, yearMonth, appId);
    }

    /**
     * @Author mdengbo
     * */
    @Override
    public List<FileDataTypeDevViewDO> getFileDataType(Long userId, String yearMonth, String appId) {
        return fileUserNumMapper.getFileDataType(userId, yearMonth, appId);
    }
}
