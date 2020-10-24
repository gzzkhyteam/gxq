package com.hengyunsoft.platform.ops.repository.train.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainTypePageReqDO;
import com.hengyunsoft.platform.ops.entity.train.dos.TrainTypePageResDO;
import com.hengyunsoft.platform.ops.entity.train.po.TrainDirectory;
import com.hengyunsoft.platform.ops.repository.train.dao.TrainDirectoryMapper;
import com.hengyunsoft.platform.ops.repository.train.example.TrainDirectoryExample;
import com.hengyunsoft.platform.ops.repository.train.service.TrainDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainDirectoryServiceImpl extends BaseServiceImpl<Long, TrainDirectory, TrainDirectoryExample> implements TrainDirectoryService {

    @Autowired
    private TrainDirectoryMapper trainDirectoryMapper;

    @Override
    protected BaseNormalDao<Long, TrainDirectory, TrainDirectoryExample> getDao() {
        return trainDirectoryMapper;
    }

    /**
     * 获取培训课程目录分页列表
     *
     * @return
     */
    @Override
    public List<TrainTypePageResDO> getTypeTree(TrainTypePageReqDO trainTypePageReqDTO) {
        return trainDirectoryMapper.getTypeTree(trainTypePageReqDTO);
    }

    /**
     * 根据父id修改
     *
     * @param trainDirectory
     */
    @Override
    public void updateByParentId(TrainDirectory trainDirectory) {
        trainDirectoryMapper.updateByParentId(trainDirectory);
    }

    @Override
    public List<TrainDirectory> selectParentsById(Long id) {
        return trainDirectoryMapper.selectParentsById(id);
    }

    @Override
    public List<TrainDirectory> getPageList(String serviceName) {
        return trainDirectoryMapper.getPageList(serviceName);
    }

}
