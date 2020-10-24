package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpTreeBySystemDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpByUserIdsDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.EmpEmailLikeDO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptEmpMapper;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.GxqptEmpAndUserDO;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 高新区一体化平台人员管理
 */
@Service
public class GxqptEmpServiceImpl extends BaseAllServiceImpl<String, GxqptEmp, GxqptEmpExample> implements GxqptEmpService {

    @Autowired
    private GxqptEmpMapper gxqptEmpMapper;

    @Override
    protected BaseNormalDao<String, GxqptEmp, GxqptEmpExample> getDao() {
        return gxqptEmpMapper;
    }

    @Override
    public  String genId() {
        return String.valueOf(super.genId());
    }

    @Override
    public GxqptEmp save(GxqptEmp entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        entity.setId(genId());
        getDao().insert(entity);
        return entity;
    }

    @Override
    public List<GxqptEmpAndUserDO> findEmps(Long id, String ownSystem) {
        return gxqptEmpMapper.findEmps(id,ownSystem);
    }

    /**
     * 根据用户Id,systemCode查询用户
     * @param id
     * @param systemCode
     * @return
     */
    @Override
    public List<GxqptEmpAndUserDO> findEmpListByUserId(String userId, String systemCode) {
        return gxqptEmpMapper.findEmpListByUser(userId,systemCode,null,null);
    }

    /**
     * 根据单位，systemCode查询用户
     * @param orgId
     * @param systemCode
     * @return
     */
    @Override
    public List<GxqptEmpAndUserDO> findEmpListByOrgId(String orgId, String systemCode) {
        return gxqptEmpMapper.findEmpListByUser(null,systemCode,orgId,null);
    }

    /**
     * 根据单位，systemCode查询用户
     * @param orgId
     * @param systemCode
     * @return
     */
    @Override
    public List<GxqptEmpAndUserDO> findEmpListByDeptId(String deptId, String systemCode) {
        return gxqptEmpMapper.findEmpListByUser(null,systemCode,null,deptId);
    }

    /**
     * 查询单位部门下的用户
     * @param emp
     * @return
     */
    @Override
    public List<? extends SdzzwwEmp> findIdentityEmpList(GxqptEmp emp) {
        return gxqptEmpMapper.findIdentityEmpList(emp);
    }

    @Override
    public Object getMainOrg(String systemCode, Long userId) {
        return gxqptEmpMapper.getMainOrg(systemCode,userId);
    }

    /**
     * 移动端接口查询需要，根据name模糊查询用户信息
     * @param emp
     * @return
     */
    @Override
    public List<? extends SdzzwwEmp> findIdentityEmpList2app(GxqptEmp emp) {
        return gxqptEmpMapper.findIdentityEmpList2app(emp);
    }

    /**
     * 根据部门查询身份人员
     * @param dpmId
     * @param systemCode
     * @return
     */
    @Override
    public List findEmpByDpm(String dpmId, String systemCode) {
        return gxqptEmpMapper.findEmpByDpm(dpmId,systemCode);
    }

    /**
     * 根据部门查询身份用户
     * @param dpmId
     * @param systemCode
     * @return
     */
    @Override
    public List findUserByDpm(String dpmId, String systemCode) {
        return gxqptEmpMapper.findUserByDpm(dpmId, systemCode);
    }

    /**
     * 邮件全体系人员模糊查询
     * @param systemCodes
     * @param data
     * @return
     */
    @Override
    public List findAllEmpBySystem(List systemCodes, EmpEmailLikeDO data) {
        return gxqptEmpMapper.findAllEmpBySystem(systemCodes, data);
    }

    /**
     * 全体系根据单位id查询人员(带身份)
     * @param orgIds
     * @param systemCodes
     * @return
     */
    @Override
    public List findEmpByOrgId(List orgIds, List systemCodes) {
        return gxqptEmpMapper.findEmpByOrgId(orgIds, systemCodes);
    }

    /**
     * 全体系根据用户id集合模糊查询人员
     * @param userIds
     * @param systemCodes
     * @return
     */
    @Override
    public List findEmpByUserIds(GxqptEmpByUserIdsDO userIds, List systemCodes) {
        return gxqptEmpMapper.findEmpByUserIds(userIds, systemCodes);
    }

    /**
     * 查询某体系下单位集合下所有人员
     * @param orgIds
     * @param ownSystem
     * @return
     */
    @Override
    public List<GxqptEmp> findEmpsByOrgIds(List<String> orgIds, String ownSystem) {
        return gxqptEmpMapper.findEmpsByOrgIds(orgIds, ownSystem);
    }

    /**
     * 查询全体系人员
     * @param systemCodes
     * @return
     */
    @Override
    public List<EmpTreeBySystemDO> findAllEmpBySystemTree(List<String> systemCodes) {
        return gxqptEmpMapper.findAllEmpBySystemTree(systemCodes);
    }
}

