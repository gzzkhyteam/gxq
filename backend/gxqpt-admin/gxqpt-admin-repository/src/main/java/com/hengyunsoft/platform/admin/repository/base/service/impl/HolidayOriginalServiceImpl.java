package com.hengyunsoft.platform.admin.repository.base.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.base.po.HolidayOriginalData;
import com.hengyunsoft.platform.admin.repository.base.dao.HolidayOriginalDataMapper;
import com.hengyunsoft.platform.admin.repository.base.example.HolidayOriginalDataExample;
import com.hengyunsoft.platform.admin.repository.base.service.HolidayOriginalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Service
@Slf4j
public class HolidayOriginalServiceImpl extends BaseServiceImpl<Long, HolidayOriginalData, HolidayOriginalDataExample> implements HolidayOriginalService {


    @Autowired
    private HolidayOriginalDataMapper holidayOriginalDataMapper;



    @Override
    protected BaseNormalDao<Long, HolidayOriginalData, HolidayOriginalDataExample> getDao() {
        return holidayOriginalDataMapper;
    }
    /**
     * 查詢节假日元数据
     * @return list
     */
    @Override
    public List<HolidayOriginalData> findByTypeId(HolidayOriginalDataExample example) {
        List<HolidayOriginalData> holidayList = holidayOriginalDataMapper.selectByExample(example);
        return holidayList;
    }
    /**
     * 更新
     *
     * @param entity 节假日元数据实体
     * @return 影响行数
     */
    @Override
    public int updateHolidayOriginalById(HolidayOriginalData entity) {
        int row = holidayOriginalDataMapper.updateByPrimaryKeySelective(entity);
        return row;
    }
    /**
     * 根据ID物理删除记录
     *
     * @param id 主键id
     */
    @Override
    public int deleteHolidayOriginalById(Long id) {
        HolidayOriginalDataExample example =new HolidayOriginalDataExample();
        example.createCriteria().andIdEqualTo(id);
        int row = holidayOriginalDataMapper.deleteByExample(example);
        return row;
    }

    /**
     * 判断编码是否重复
     * @param number
     * @return
     */
    @Override
    public boolean checkNumber(String number) {
        HolidayOriginalDataExample example =new HolidayOriginalDataExample();
        example.createCriteria().andNumberEqualTo(number);
        return holidayOriginalDataMapper.countByExample(example) > 0 ? true : false;
    }
}
