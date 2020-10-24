package com.hengyunsoft.platform.mt.repository.file.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.mt.entity.file.po.File, com.hengyunsoft.platform.mt.repository.file.example.FileExample> {
}