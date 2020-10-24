//package com.hengyunsoft.platform.file.repository.file.service.impl;
//
//import com.hengyunsoft.base.dao.BaseAllDao;
//import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
//import com.hengyunsoft.platform.file.entity.file.po.Folder;
//import com.hengyunsoft.platform.file.repository.file.dao.FolderMapper;
//import com.hengyunsoft.platform.file.repository.file.example.FolderExample;
//import com.hengyunsoft.platform.file.repository.file.service.FolderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * 文件夹 - 业务方法
// * @author tyh
// * @createTime 2018-01-25 10:44
// */
//@Service
//public class FolderServiceImpl extends BaseAllServiceImpl<Long, Folder, FolderExample>
//        implements FolderService {
//    @Autowired
//    private FolderMapper folderMapper;
//    @Override
//    protected BaseAllDao<Long, Folder, FolderExample> getDao() {
//        return folderMapper;
//    }
//
//
//}
