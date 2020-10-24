package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.domain.AllUserApiDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiRenewalDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiUserListDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiUser;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiUserExample;

import java.util.List;
import java.util.Map;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请Service
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */

public interface ShareDataApiUserService extends BaseAllService<Long, ShareDataApiUser, ShareDataApiUserExample> {
    /**
     * 描述：查询共享申请列表
     * 参数：param
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    List<ShareDataApiUserListDO> findList(Map<String, Object> param);
    /**
     * 描述：根据共享申请Id查询api续期基础信息
     * 参数：id：共享申请id
     * 返回值：ApiRenewalInfoDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    ShareDataApiRenewalDO queryApiBaseInfo(Long id);

    List<AllUserApiDO> queryAllUserApi();
    /**
     * 描述：
     * 参数：根据单位Id查询可调用的API申请Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/7/23
     * 修改内容：
     * @param map
     */
    List<Long> getApiByUserId(Map<String, Object> map);

    void saveBatch(List<ShareDataApiUser> shareDataApiUsers);
}
