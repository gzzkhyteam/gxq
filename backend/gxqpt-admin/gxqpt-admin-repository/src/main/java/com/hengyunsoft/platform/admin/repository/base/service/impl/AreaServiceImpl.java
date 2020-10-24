package com.hengyunsoft.platform.admin.repository.base.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.base.po.Area;
import com.hengyunsoft.platform.admin.repository.base.dao.AreaMapper;
import com.hengyunsoft.platform.admin.repository.base.example.AreaExample;
import com.hengyunsoft.platform.admin.repository.base.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-01-30
 */
@Service
@Slf4j
public class AreaServiceImpl extends BaseServiceImpl<Long, Area, AreaExample> implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    protected BaseNormalDao<Long, Area, AreaExample> getDao() {
        return areaMapper;
    }

    /**
     * 查询区域及子区域ID列表
     * @param parentId  上级区域ID
     */
    @Override
    public List<Area> findByParentId(Long parentId) {
        return areaMapper.findByParentId(parentId);
    }



    /**
     * 查询区域及子区域
     * @param id 主键id
     */
    @Override
    public List<Area> getSubAreaIdList(Long id){
        //区域及子区域ID列表
        List<Area> areaIdList = new ArrayList<>();

        //获取子区域ID
        List<Area> subIdList = findByParentId(id);
        getAreaTreeList(subIdList, areaIdList);

        return areaIdList;
    }

    /**
     * 递归
     */
    private void getAreaTreeList(List<Area> subIdList, List<Area> areaIdList){
        for(Area area : subIdList){
            List<Area> list = findByParentId(area.getId());
            if(list.size() > 0){
                getAreaTreeList(list, areaIdList);
            }

            areaIdList.add(area);
        }
    }

    /**
     * 更新
     *
     * @param entity 区域实体
     * @return 影响行数
     */
    @Override
    public int updateById(Area entity) {
        int row = areaMapper.updateByPrimaryKeySelective(entity);
        return row;
    }
    /**
     * 根据ID物理删除记录
     *
     * @param id 主键id
     */
    @Override
    public int deleteAllById(Long id) {
        return areaMapper.deleteAllById(id);
    }
    /**
     * 根据id查询某个地区
     *
     * @param id 主键id
     */
    @Override
    public Area findById(Long id) {
        AreaExample example = new AreaExample();
        example.createCriteria().andIdEqualTo(id);
        return getUnique(example);
    }

    /**
     * 查询所有地区(带键值)
     * @return
     */
    @Override
    public List findAreaForExcel() {
        return areaMapper.findAreaForExcel();
    }

    @Override
    public boolean check(String code) {
        AreaExample example = new AreaExample();
        example.createCriteria().andCodeEqualTo(code);
        return areaMapper.countByExample(example) > 0 ? true : false;
    }
}
