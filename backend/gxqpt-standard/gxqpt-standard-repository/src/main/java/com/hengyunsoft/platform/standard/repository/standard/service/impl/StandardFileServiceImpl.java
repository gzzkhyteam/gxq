package com.hengyunsoft.platform.standard.repository.standard.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardClassifyDO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardTypeDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.UploadCompanyDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardFile;
import com.hengyunsoft.platform.standard.repository.standard.dao.StandardFileLogMapper;
import com.hengyunsoft.platform.standard.repository.standard.dao.StandardFileMapper;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StandardFileServiceImpl extends BaseAllServiceImpl<Long, StandardFile, StandardFileExample> implements StandardFileService {
    @Autowired
    private StandardFileMapper standardFileMapper;
    @Autowired
    private StandardClassifyService standardClassifyService;

    @Override
    protected BaseNormalDao<Long, StandardFile, StandardFileExample> getDao() {
        return standardFileMapper;
    }

    @Override
    public List<StandardFileDO> pageDocument(StandardFileExample example) {
        return standardFileMapper.queryStandardFileByPage(example);
    }

    /**
     * 获取文件DO对象
     *
     * @param id
     * @return
     */
    @Override
    public StandardFileDO getStandardFileDO(Long id) {
        return standardFileMapper.getStandardFileDO(id);
    }

    /**
     * 根据分类Id查询文件列表
     *
     * @param example
     * @return
     */
    @Override
    public List<StandardFile> findFileListByClassifyId(StandardFileExample example) {
        return standardFileMapper.selectByExample(example);
    }

    /**
     * 查询各分类下的文档数量
     *
     * @return
     */
    @Override
    public List<StandardClassifyDO> findAllFileCount() {
        return standardFileMapper.findAllFileCount();
    }

    /**
     * 标准上传单位TOP10
     *
     * @return
     */
    @Override
    public List<UploadCompanyDO> getCompanyTop10() {
        return standardFileMapper.uploadCompanyTop10();
    }

    /**
     * 类别标准数量TOP5（按类型分类）
     *
     * @return
     */
    @Override
    public List<StandardTypeDO> getTypeTop5() {
        return standardFileMapper.getTypeTop5();
    }

    /**
     * XX标准文档上传单位top10
     *
     * @return
     */
    @Override
    public List<UploadCompanyDO> getUploadCompanyTop10(Long typeId) {
    	List<Long> list =  new ArrayList<Long>();
		list.add(typeId);
		List<Long> nodeIds = standardClassifyService.findCurrentChildNodeIds(list);
        return standardFileMapper.getUploadCompanyTop10(nodeIds);
    }

    /**
     * XX标准数量分析
     *
     * @return
     */
    @Override
    public List<StandardMonthDO> getTypeCount(Long typeId, Date date) {
    	
    	List<Long> list =  new ArrayList<Long>();
		list.add(typeId);
		List<Long> nodeIds = standardClassifyService.findCurrentChildNodeIds(list);
        return standardFileMapper.getTypeCount(nodeIds, date);
    }

    /**
     * 获取现有标准数量
     *
     * @return
     */
    @Override
    public Integer getStandardNum() {
        return standardFileMapper.getStandardNum();
    }

    /**
     * 获取本月新增标准数量
     *
     * @return
     */
    @Override
    public Integer getMonthStandardNum(Date date) {
        return standardFileMapper.getMonthStandardNum(date);
    }

    /**
     * 获取现有标准失效数量
     *
     * @return
     */
    @Override
    public Integer getStandardInvalidNum() {
        return standardFileMapper.getStandardInvalidNum();
    }

    /**
     * 获取本月标准失效数量operation
     *
     * @return
     */
    @Override
    public Integer getMonthStandardInvalidNum(Date date) {
        return standardFileMapper.getMonthStandardInvalidNum(date);
    }

    @Override
    public int getCountByName(String name) {
        StandardFileExample example = new StandardFileExample();
        example.or().andNameEqualTo(name);
        return standardFileMapper.countByExample(example);
    }

}
