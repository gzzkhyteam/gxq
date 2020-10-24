package com.hengyunsoft.platform.ops.repository.train.dao;

import com.hengyunsoft.platform.ops.entity.train.dos.TrainTypePageReqDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainTypePageResDO;
import com.hengyunsoft.platform.ops.entity.train.po.TrainDirectory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDirectoryMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.ops.entity.train.po.TrainDirectory, com.hengyunsoft.platform.ops.repository.train.example.TrainDirectoryExample> {

    /**
     * 获取培训课程目录分页列表
     */
    public List<TrainTypePageResDO> getTypeTree(@Param(value = "trainTypePageReqDTO") TrainTypePageReqDO trainTypePageReqDTO);

    /**
     * 根据父id修改
     */
    public void updateByParentId(@Param(value = "trainDirectory") TrainDirectory trainDirectory);

    /**
     * 根据id获取所以父节点信息
     *
     * @param id id
     * @return 父节点
     */
    public List<TrainDirectory> selectParentsById(@Param(value = "id") Long id);

    /**
     * 模糊查询培训目录信息
     * @param serviceName
     * @return
     */
    List<TrainDirectory> getPageList(@Param(value = "serviceName") String serviceName);

}