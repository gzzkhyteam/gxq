package com.hengyunsoft.platform.exchange.repository.system.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.system.domain.JoinOrgDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareJoinOrg;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareJoinOrgMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareJoinOrgExample;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareJoinOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 数据共享交换接入部门接口实现
 * @author wgj
 * @createtime 2018-5-01
 */
@Service
public class ShareJoinOrgServiceImpl extends BaseAllServiceImpl<Long,ShareJoinOrg,ShareJoinOrgExample> implements ShareJoinOrgService{
    @Autowired
    ShareJoinOrgMapper shareJoinOrgMapper;
    @Autowired
    IdGenerate<Long> idGenerate;
    @Override
    protected BaseNormalDao<Long, ShareJoinOrg, ShareJoinOrgExample> getDao() {
        return shareJoinOrgMapper;
    }
    /**
     * 插入接入部门
     * @param unitId 单位id
     * @param unitId 用户id
     * @author wgj
     * @createtime 2018-5-01
     */
    @Override
    public void insertJoinOrg(String unitId,Long userId) {
        if(StringUtils.isEmpty(unitId)){
            return;
        }
        ShareJoinOrgExample example = new ShareJoinOrgExample();
        example.createCriteria().andUnitIdEqualTo(unitId);
        List<ShareJoinOrg> list=shareJoinOrgMapper.selectByExample(example);
        if (list!=null && list.size() > 0 ){
            return;
        }
        //插入接入表
        ShareJoinOrg joinOrg = new ShareJoinOrg();
        joinOrg.setId(idGenerate.generate());
        joinOrg.setUnitId(unitId);
        joinOrg.setCreateTime(new Date());
        joinOrg.setUpdateTime(new Date());
        joinOrg.setCreateUser(userId);
        joinOrg.setUpdateUser(userId);
        shareJoinOrgMapper.insertSelective(joinOrg);
    }
    /**
     * 查询接入单位
     * @return
     */
    @Override
    public List<JoinOrgDO> getJoinUnitList() {

        return shareJoinOrgMapper.getJoinUnitList();
    }
    /**
     * 查询单位的目录数量
     * @return
     */
    @Override
    public List<JoinOrgDO> getUnitDirList() {


        return shareJoinOrgMapper.getUnitDirList();
    }
}
