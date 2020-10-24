package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.AllUserApiDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiRenewalDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiUserListDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDataApiUserMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiUser, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiUserExample> {
    List<ShareDataApiUserListDO> selectList(Map<String, Object> param);

    ShareDataApiRenewalDO selectApiBaseInfo(@Param("id") Long id);

    List<AllUserApiDO> selectAllUserApi();
    /**
     * 描述：
     * 参数：根据单位Id查询可调用的API申请Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/7/23
     * 修改内容：
     * @param unitId
     */
    List<Long> selectApiByUnitId(Map<String, Object> unitId);
}