package com.hengyunsoft.platform.security.repository.backups.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BackupsLogMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.security.entity.backups.po.BackupsLog, com.hengyunsoft.platform.security.repository.backups.example.BackupsLogExample> {
}