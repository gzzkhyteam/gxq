package com.hengyunsoft.platform.security.repository.interfaces.dao;

import java.util.List;

import com.hengyunsoft.platform.security.entity.interfaces.domain.ServiceResource;

import org.springframework.stereotype.Repository;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/16
 */
@Repository
public interface CopyCoreServiceResourceMapper {
    /**
     * 根据example拼接的条件，查询记录集
     *
     */
    List<ServiceResource> findAll();
}
