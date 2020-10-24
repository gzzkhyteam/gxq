package com.hengyunsoft.platform.admin.repository.base.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.base.po.HolidayOriginalData;
import com.hengyunsoft.platform.admin.repository.base.example.HolidayOriginalDataExample;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-02-2
 */
public interface HolidayOriginalService extends BaseService<Long, HolidayOriginalData, HolidayOriginalDataExample> {


    /**
     * 查詢节假日元数据
     * @return list
     */
    List<HolidayOriginalData> findByTypeId(HolidayOriginalDataExample example);
    /**
     * 更新
     *
     * @param entity
     * @return 影响行数
     */
    int updateHolidayOriginalById(HolidayOriginalData entity);

    /**
     * 根据ID物理删除记录
     *
     * @param id 主键id
     */
    int deleteHolidayOriginalById(Long id);

    /**
     * 判断编码是否重复
     * @param number
     * @return
     */
    boolean checkNumber(String number);
}
