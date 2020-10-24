package com.hengyunsoft.platform.ops.repository.service.dao;

import com.hengyunsoft.platform.ops.entity.service.po.ServiceDirectory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDirectoryMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.service.po.ServiceDirectory, com.hengyunsoft.platform.ops.repository.service.example.ServiceDirectoryExample> {

    /**
     * 根据id获取所以父节点信息
     *
     * @param id id
     * @return 父节点
     */
     List<ServiceDirectory> selectParentsById(@Param(value = "id") Long id);

    /**
     * 模糊查询服务目录信息
     * @param serviceName
     * @return
     */
    List<ServiceDirectory> getPageList(@Param(value = "serviceName") String serviceName);

}