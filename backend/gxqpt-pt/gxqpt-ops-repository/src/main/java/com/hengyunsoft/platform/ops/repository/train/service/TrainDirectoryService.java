package com.hengyunsoft.platform.ops.repository.train.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainTypePageReqDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainTypePageResDO;
import com.hengyunsoft.platform.ops.entity.train.po.TrainDirectory;
import com.hengyunsoft.platform.ops.repository.train.example.TrainDirectoryExample;

import java.util.List;

public interface TrainDirectoryService extends BaseService<Long, TrainDirectory, TrainDirectoryExample> {

    /**
     * 获取培训课程目录分页列表
     */
    public List<TrainTypePageResDO> getTypeTree(TrainTypePageReqDO trainTypePageReqDO);

    /**
     * 根据父id修改
     */
    public void updateByParentId(TrainDirectory trainDirectory);

    /**
     * 根据id获取所以父节点信息
     *
     * @param id id
     * @return 父节点
     */
    public List<TrainDirectory> selectParentsById(Long id);

    /**
     * 模糊查询培训目录信息
     * @param serviceName
     * @return
     */
    List<TrainDirectory> getPageList(String serviceName);

}