package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.api.domain.AllUserApiDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiRenewalDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiUserListDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiUser;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiUserMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiUserExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请实现
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataApiUserServiceImpl extends BaseAllServiceImpl<Long, ShareDataApiUser, ShareDataApiUserExample> implements ShareDataApiUserService {
    @Autowired
    ShareDataApiUserMapper mapper;

    @Override
    protected BaseNormalDao<Long, ShareDataApiUser, ShareDataApiUserExample> getDao() {
        return mapper;
    }

    /**
     * 描述：查询共享申请列表
     * 参数：param
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @Override
    public List<ShareDataApiUserListDO> findList(Map<String, Object> param) {
        return mapper.selectList(param);
    }

    @Override
    public ShareDataApiRenewalDO queryApiBaseInfo(Long id) {
        return mapper.selectApiBaseInfo(id);
    }

    @Override
    public List<AllUserApiDO> queryAllUserApi() {
        return mapper.selectAllUserApi();
    }
    /**
     * 描述：
     * 参数：根据用户Id查询可调用的API申请Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/7/23
     * 修改内容：
     * @param map
     */
    @Override
    public List<Long> getApiByUserId(Map<String, Object> map) {
        return mapper.selectApiByUnitId(map);
    }

    @Override
    public void saveBatch(List<ShareDataApiUser> shareDataApiUsers) {
        mapper.batchInsert(shareDataApiUsers);
    }
}
