package com.hengyunsoft.platform.security.repository.backups.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BackupsMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.security.entity.backups.po.Backups, com.hengyunsoft.platform.security.repository.backups.example.BackupsExample> {
}