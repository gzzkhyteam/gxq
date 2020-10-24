package com.hengyunsoft.platform.ops.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceDirectory;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceDirectoryExample;

import java.util.List;

public interface ServiceDirectoryService extends BaseService<Long, ServiceDirectory, ServiceDirectoryExample> {

    /**
     * 根据id获取所以父节点信息
     *
     * @param id id
     * @return 父节点
     */
     List<ServiceDirectory> selectParentsById(Long id);

    /**
     * 模糊查询服务目录信息
     * @param serviceName
     * @return
     */
    List<ServiceDirectory> getPageList(String serviceName);

}
