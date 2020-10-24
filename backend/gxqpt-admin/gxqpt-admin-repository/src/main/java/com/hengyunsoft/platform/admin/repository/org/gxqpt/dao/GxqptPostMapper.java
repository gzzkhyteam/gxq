package com.hengyunsoft.platform.admin.repository.org.gxqpt.dao;

import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptPost;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptPostExample;
import org.springframework.stereotype.Repository;

@Repository
public interface GxqptPostMapper extends com.hengyunsoft.base.dao.BaseNormalDao<String, GxqptPost, GxqptPostExample> {
}