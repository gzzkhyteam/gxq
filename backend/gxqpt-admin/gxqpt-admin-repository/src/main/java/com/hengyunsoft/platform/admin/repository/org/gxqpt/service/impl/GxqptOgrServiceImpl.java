package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.*;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwOrg;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptOrgMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptOrgExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wangzhen
 * @createTime 2018-03-06
 */
@Service
@Slf4j
public class GxqptOgrServiceImpl extends BaseServiceImpl<String, GxqptOrg, GxqptOrgExample> implements GxqptOrgService {
    @Autowired
    private GxqptOrgMapper mapper;

    @Override
    protected BaseNormalDao<String, GxqptOrg, GxqptOrgExample> getDao() {
        return mapper;
    }

    @Override
    public String genId() {
        return String.valueOf(super.genId());
    }

    /**
     * 禁用单位
     *
     * @param id
     * @return
     */
    @Override
    public int deleteOrg(String id) {
        return mapper.updateIsdelete(id);
    }

    /**
     * 保存并分享给应用
     *
     * @param entity
     * @return
     */
    public GxqptOrg saveAndShare(GxqptOrg entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        String id = genId();
        entity.setId(id);
        entity.setOrgId(id);
        entity.setCreateTime(new Date());
        entity.setSortvalue(entity.getSortvalue() == null ? 0 : entity.getSortvalue());
        save(entity);
        return entity;
    }

    @Override
    public GxqptOrg save(GxqptOrg entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        setSaveTimes(entity);
        getDao().insert(entity);
        return entity;
    }

    /**
     * 保存并分享给应用
     *
     * @param entitys
     * @return
     */
    @Override
    public List<GxqptOrg> saveAndShare(List<GxqptOrg> entitys) {
        if (entitys == null) {
            throw new RuntimeException("list is null");
        }
        for (GxqptOrg t : entitys) {
            saveAndShare(t);
        }
        return entitys;
    }

    /**
     * 根据当前appId查询单位集合
     *
     * @param adminId
     * @param appId
     * @return
     */
    @Override
    public List<GxqptOrg> selectOrgWithShare(Long adminId, String appId) {
        return mapper.selectOrgWithShare(adminId, appId);
    }

    /**
     * 根据当前appId查询单位集合
     *
     * @param morg
     * @param adminId
     * @param appId
     * @return
     */
    @Override
    public List<GxqptOrg> selectLikeAppByShare(GxqptOrg morg, Long adminId, String appId) {
        return mapper.selectLikeAppByShare(morg, adminId, appId);
    }

    /**
     * 根据id连接字典查询子单位
     *
     * @param ids
     * @param morg
     * @param systemCode
     * @return
     */
    public List<GxqptOrg> selectOrgJoinDictionary(String[] ids, GxqptOrg morg, String systemCode) {
        return mapper.selectOrgJoinDictionary(ids, morg, systemCode);
    }

    /**
     * 选择制定用户可以管理的机构
     *
     * @param adminId
     * @return
     */
    @Override
    public List<GxqptOrg> selectOrgWithManager(Long adminId) {

        return mapper.selectOrgWithManager(adminId);
    }

    /**
     * 单位详情
     *
     * @param systemCode
     * @param id
     * @return
     */
    @Override
    public SdzzwwOrg details(String systemCode, String id) {
        return mapper.details(systemCode, id);
    }

    /**
     * 通过应用id+体系编码获得其可见所有单位
     *
     * @param appId
     * @param systemCode
     * @return
     */
    @Override
    public List pageByAppAndSys(String appId, String systemCode) {
        return mapper.pageByAppAndSys(appId, systemCode);
    }

    /**
     * 通过用户id+体系编码获得所有单位
     *
     * @param adminId
     * @param systemCode
     * @return
     */
    @Override
    public List findByAdmAndSys(Long adminId, String systemCode) {
        return mapper.findByAdmAndSys(adminId, systemCode);
    }

    /**
     * 通过体系编码获得所有单位
     *
     * @param systemCode
     * @return
     */
    @Override
    public List pageBySys(String systemCode) {
        return mapper.pageBySys(systemCode);
    }

    /**
     * 分页聚合查询
     *
     * @return
     */
    @Override
    public List pagePoly() {
        return mapper.pagePoly();
    }

    /**
     * 根据appid分页聚合查询
     *
     * @param appId
     * @return
     */
    @Override
    public List pagePolyByApp(String appId) {
        return mapper.pagePolyByApp(appId);
    }

    /**
     * 根据user聚合查询单位
     *
     * @param sysCode
     * @param userId
     * @return
     */
    @Override
    public List findOrgByUser(String sysCode, Long userId) {
        return mapper.findOrgByUser(sysCode, userId);
    }

    /**
     * 根据user聚合查询单位
     *
     * @param sysCode
     * @param userId
     * @return
     */
    @Override
    public List findOrgByUsers(String sysCode, List<Long> userId) {
        return mapper.findOrgByUsers(sysCode, userId);
    }

    @Override
    public List pagePolyByUser(Long adminId) {
        return mapper.pagePolyByUser(adminId);
    }

    /**
     * 根据userId查询相关信息
     * 修改人：chb
     * 修改时间：2018-4-23
     * 修改内容：根据定窑最新需求修改
     *
     * @param userId
     * @return
     * @auth chb
     */
    @Override
    public List<OrgAndEmpInfoDO> getOrgInfoByUserId(Long userId, String systemCode) {
        return mapper.getOrgInfoByUserId(userId, systemCode);
    }

    /**
     * 查找所有单位
     *
     * @param systemList
     * @return
     */
    @Override
    public List findAll(List systemList) {
        return mapper.findAll(systemList);
    }

    /**
     * 查询前7个月没有应用调用量
     * 修改人：madb
     * 修改时间：2018-4-30
     *
     * @return
     */
    @Override
    public List<FindAppNumDO> findNum( List<String> yearMonth) {

        return mapper.findAppNum(yearMonth);
    }


    /**
     * 2018-5-30
     * 根据userId
     * 查询单位、部门、职务、岗位以及体系编码
     *
     * @param userId
     * @return
     */
    @Override
    public OrgDeptDutyInfoDO getOrgDeptDutyByUserId(Long userId, String systemCode) {
        return mapper.getOrgDeptDutyByUserId(userId, systemCode);
    }

    /**
     * 2018-6-26 移动端需要新增
     * 根据userId查询其所在单位，部门，岗位职务信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<OrgInfosDO> getOrgSimpleInfo(Long userId, String systemCode) {
        return mapper.getOrgSimpleInfo(userId, systemCode);
    }

    /**
     * 2018-6-26 移动端需要新增
     * 根据userID,OrgID查询单位、部门、职务、岗位以及体系编码
     *
     * @param userId
     * @return
     */
    @Override
    public List<OrgDeptDutyInfoDO> getOrgDeptDutyinfo(Long userId, String systemCode, String orgId) {
        return mapper.getOrgDeptDutyinfo(userId, systemCode, orgId);
    }

    /**
     * 根据体系集合查询单位
     *
     * @param systems
     * @return
     */
    @Override
    public List findAllOrgBySystem(List systems) {
        return mapper.findAllOrgBySystem(systems);
    }

    /**
     * 查询全体系所有单位
     *
     * @param systems
     * @return
     */
    @Override
    public List findOrgByPtAdminAndSystemCode(List<String> systems) {
        return mapper.findOrgByPtAdminAndSystemCode(systems);
    }

    /**
     * 查询全体系我所管理的单位
     *
     * @param systems
     * @param adminId
     * @return
     */
    @Override
    public List findOrgByAdminAndSystemCode(List<String> systems, Long adminId) {
        return mapper.findOrgByAdminAndSystemCode(systems, adminId);
    }

    /**
     * 根据单位ids查询单位名称id信息
     *
     * @param ids
     * @param systemCodes
     * @return
     */
    @Override
    public List findOrgNameByIds(List ids, List systemCodes) {
        return mapper.findOrgNameByIds(ids, systemCodes);
    }

    /**
     * 共享交换全体系模糊查询单位接口
     * @param systems
     * @param obj
     * @return
     */
    @Override
    public List<GxqptOrg> findOrgByExchange(List<String> systems, GxqptOrgByExchangeReqDO obj) {
        return mapper.findOrgByExchange(systems, obj);
    }
}
