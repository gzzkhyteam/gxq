package com.hengyunsoft.platform.exchange.repository.directory.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryAuditDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryDictDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataDirectoryMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Service
@Slf4j
public class DataDirectoryServiceImpl extends BaseAllServiceImpl<Long, ShareDataDirectory, ShareDataDirectoryExample> implements DataDirectoryService {

    @Autowired
    private ShareDataDirectoryMapper shareDataDirectoryMapper;

    @Override
    protected BaseNormalDao<Long, ShareDataDirectory, ShareDataDirectoryExample> getDao() {
        return shareDataDirectoryMapper;
    }

    @Override
    public List<ShareDataDirectory> findByParentId(Long parentId) {
        return shareDataDirectoryMapper.findByParentId(parentId);
    }

    /**
     * 查询目录及子目录
     * @param id 主键id
     */
    @Override
    public List<ShareDataDirectory> getDirectoryList(Long id){
        //查询目录及子目录ID列表
        List<ShareDataDirectory> dataDirectoryIdList = new ArrayList<>();

        //获取子目录ID
        List<ShareDataDirectory> subIdList = findByParentId(id);
        getTreeList(subIdList, dataDirectoryIdList);
        return dataDirectoryIdList;
    }
    /**
     * 根据id查询目录
     * @param id 主键id
     */
    @Override
    public ShareDataDirectoryDictDO getDictCodeList(Long id) {
        return shareDataDirectoryMapper.getDictCodeList(id);
    }
    /**
     * 根据id查询目录发布表
     * @param id 主键id
     */
    @Override
    public ShareDataDirectoryDictDO getDictCodeWareList(Long id) {
        return shareDataDirectoryMapper.getDictCodeWareList(id);
    }
    /**
     * 根据数据类型查询目录及子目录
     * @param  dataType
     * @param unitId
     */
    @Override
    public List<ShareDataDirectory> getDataTypeList(Integer dataType, String unitId) {
        return shareDataDirectoryMapper.getDataTypeList(dataType,unitId);
    }
    /**
     * 获取本单位外所有数据目录
     * @param unitId dataType
     */
    @Override
    public List<ShareDataDirectory> getUnitDataTypeList(Long unitId, Integer dataType) {
        return shareDataDirectoryMapper.getUnitDataTypeList(unitId,dataType);
    }
    /**
     * 平台管理员查询目录及子目录
     * @param
     */
    @Override
    public List<ShareDataDirectory> getAllList() {
        return shareDataDirectoryMapper.getAllList();
    }
    /**
     * 单位管理员查询目录及子目录
     * @param
     */
    @Override
    public List<ShareDataDirectory> getUnitDirectoryList(Long unitId) {
        return shareDataDirectoryMapper.findByParentIdAndUnitId(unitId);
    }
    /**
     * 查询共享单位
     * @param
     */
    @Override
    public List<VOrgDO> getOrgList() {
        return shareDataDirectoryMapper.getOrgList();
    }

    /**
     * 查询目录待审批任务
     * @param
     */
    @Override
    public List<ShareDataDirectoryAuditDO> getDirectoryTask(Map<String, Object> map) {
        return shareDataDirectoryMapper.getDirectoryTask(map);
    }
    /**
     * @todo 更新元目录的查看次数
     * @param  id 元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    public void updateSeeCount(String id) {
        shareDataDirectoryMapper.updateSeeCount(id);
    }
    /**
     * 查询变动表中只有字段而没有该字段的目录id 的目录id
     * @param unitId
     * @param applyCode
     * @return
     */
    @Override
    public List<ShareDataDirectory> getChangeDirListByApplyCode(String unitId, String applyCode) {

        return shareDataDirectoryMapper.getChangeDirListByApplyCode(unitId,applyCode);
    }

    /**
     * 查询发生变动的目录
     * @param
     */
    @Override
    public List<ShareDataDirectory> getDirectoryChangeList(String applyCode) {
        return shareDataDirectoryMapper.getDirectoryChangeList(applyCode);
    }

    /**
     * 查询申请发布目录变动信息
     * @param
     */
    @Override
    public List<ShareDataDirectory> getDirectoryChangeListApply(String unitId, Integer status) {
        return shareDataDirectoryMapper.getDirectoryChangeListApply(unitId,status);
    }
    /**
     * 递归
     */
    private void getTreeList(List<ShareDataDirectory> subIdList, List<ShareDataDirectory> dataDirectoryIdList){
        for(ShareDataDirectory dataDirectory : subIdList){
            List<ShareDataDirectory> list = findByParentId(dataDirectory.getId());
            if(list.size() > 0){
                getTreeList(list, dataDirectoryIdList);
            }
            dataDirectoryIdList.add(dataDirectory);
        }
    }

    @Override
    public void updateSetIdToNull(long id, long setId) {
        shareDataDirectoryMapper.updateSetIdToNull(id,setId);
    }

    @Override
    public void updateSetId(long id, long setId) {
        shareDataDirectoryMapper.updateSetId(id,setId);
    }

    @Override
    public List<ShareDataDirectory> findChangeDirList(String unitId, String applyCode, Integer busType) {
        return shareDataDirectoryMapper.findChangeDirList(unitId,applyCode,busType);
    }

    @Override
    public List<ShareDataDirectory> getAllTreeUnUnit(String unitId) {
        return shareDataDirectoryMapper.getAllTreeUnUnit(unitId);
    }

    @Override
    public void batchUpdate(List<ShareDataDirectory> dataDirectoryList) {
        shareDataDirectoryMapper.batchUpdate(dataDirectoryList);
    }

    @Override
    public void batchSave(List<ShareDataDirectory> dataDirectoryList) {
        shareDataDirectoryMapper.batchInsert(dataDirectoryList);
    }


}
