package com.hengyunsoft.platform.exchange.repository.directory.service.impl;

import com.github.pagehelper.PageHelper;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareCountView;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectoryWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataView;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.DirViewDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirecoryUnitNumDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.ApiTopDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgApiViewDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgScreenDO;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataDirectoryWareMapper;
import com.hengyunsoft.platform.exchange.repository.directory.dao.ShareDataElementMapper;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryWareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author tianai
 * @createTime 2018-04-22
 */
@Service
@Slf4j
public class DataDirectoryWareServiceImpl extends BaseAllServiceImpl<Long,ShareDataDirectoryWare,ShareDataDirectoryWareExample> implements DataDirectoryWareService {
    @Autowired
    private ShareDataDirectoryWareMapper shareDataDirectoryWareMapper;
    @Override
    protected BaseNormalDao<Long, ShareDataDirectoryWare,ShareDataDirectoryWareExample> getDao() {
        return shareDataDirectoryWareMapper;
    }
    /**
     * 查询单位及数据量
     * @return
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public List<ShareCountView> getBusDataByOrg(){


        return shareDataDirectoryWareMapper.getBusDataByOrg();
    }
    /**
     * 查询主题，行业，服务及数据量
     * @return
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public List<ShareCountView> getBusDataByBus(String busCode,Integer level) {

        return shareDataDirectoryWareMapper.getBusDataByBus(busCode,level);
    }

    /**
     * 根据单位查询元目录
     * @param unitId 单位id
     * @param searchKey 关键字
     * @param indexNo 排序方式 1，更新时间，2，访问量，3，数据量
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public List<ShareDataView> getBottomDirByUnit(String unitId, String searchKey, Integer indexNo) {

        return shareDataDirectoryWareMapper.getBottomDirByUnit(unitId,searchKey,indexNo);
    }
    /**
     * 根据主题，领域，服务，行业等查询元目录
     * @param busCode
     * @param searchKey
     * @param indexNo
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public List<ShareDataView> getBottomDirByBuss(String busCode,String busKey, String searchKey, Integer indexNo) {

        return shareDataDirectoryWareMapper.getBottomDirByBuss(busCode,busKey,searchKey,indexNo);
    }
    /**
     * @todo 根据元目录id查询详情
     * @param  id 元目录id
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    public ShareDataView getDirViewById(String id) {

        return shareDataDirectoryWareMapper.getDirViewById(id);
    }
    /**
     * 根据年月查询元目录数量
     * @param year
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public int getDirCount(String year, String monthKey) {

        return shareDataDirectoryWareMapper.getDirCount(year,monthKey);
    }
    /**
     * 根据年月查询数据集数量
     * @param year
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public int getSetCount(String year, String monthKey) {

        return shareDataDirectoryWareMapper.getSetCount(year,monthKey);
    }
    /**
     * 根据年月查询API数量
     * @param year
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public int getApiCount(String year, String monthKey) {

        return shareDataDirectoryWareMapper.getApiCount(year,monthKey);
    }
    /**
     * 查询部门的API数量
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public List<OrgApiViewDO> getOrgApiCount() {

        return shareDataDirectoryWareMapper.getOrgApiCount();
    }
    /**
     * 根据单位id查询Api调用次数
     * @param unitId
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    @Override
    public int getOrgApiCallCount(String unitId) {

        return shareDataDirectoryWareMapper.getOrgApiCallCount(unitId);
    }
    /**
     *API调用TOP10
     * api数目与调用次数
     * @Author wgj
     * @createtime 2018-05-01
     */
    @Override
    public List<ApiTopDO> getApiCallTopList() {


        return shareDataDirectoryWareMapper.getApiCallTopList();
    }
    /**
     *根据年月查询API调用次数
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @Override
    public int getApiCallCount(String year, String monthKey) {

        return shareDataDirectoryWareMapper.getApiCallCount(year,monthKey);
    }
    /**
     *根据年月查询数据交换量
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @Override
    public int getTransDataCount(String year, String monthKey) {

        return shareDataDirectoryWareMapper.getTransDataCount(year,monthKey);
    }
    /**
     *目录审批通过后同步保存数据目录中心表
     * @return
     * @Author tianai
     * @createtime 2018-05-07
     */
    @Override
    public int saveWare(ShareDataDirectoryWare entity) {
        return shareDataDirectoryWareMapper.insertSelective(entity);
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
        shareDataDirectoryWareMapper.updateSeeCount(id);
    }
    /**
     * 根据单位查询目录数
     * @param unitId
     * @return
     */
    @Override
    public int getOrgDirCount(String unitId) {


        return shareDataDirectoryWareMapper.getOrgDirCount(unitId);
    }
    /**
     * 根据单位查询目录
     * @param unitId
     * @return
     */
    @Override
    public List<DirViewDO> getListByUnit(String unitId) {

        return shareDataDirectoryWareMapper.getListByUnit(unitId);
    }

    /**
     * 数据目录单位前6名
     * @return
     */
    @Override
    public List<OrgScreenDO> getDirDataList() {

        return shareDataDirectoryWareMapper.getDirDataList();
    }
    @Override
    public void updateSetIdToNull(long id, long setId) {
        shareDataDirectoryWareMapper.updateSetIdToNull(id,setId);
    }

    @Override
    public void updateSetId(long id, long setId) {
        shareDataDirectoryWareMapper.updateSetId(id,setId);
    }

    @Override
    public void batchSave(List<ShareDataDirectoryWare> dataDirectoryList) {
        shareDataDirectoryWareMapper.batchInsert(dataDirectoryList);
    }

    @Override
    public void batchUpdate(List<ShareDataDirectoryWare> dataDirectoryList) {
        shareDataDirectoryWareMapper.batchUpdate(dataDirectoryList);
    }
    /**
     * 描述：查询共享交换分析目录数量月度数据
     * 参数：year 年份
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：
     */
    @Override
    public List<ShareDataDirecoryUnitNumDO> queryDirMonthData(String year) {
        return shareDataDirectoryWareMapper.selectDirMonthData(year);
    }
    /**
     * 描述：查询目录占比
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：
     */
    @Override
    public ShareDataDirecoryUnitNumDO queryDirTypeNum() {
        return shareDataDirectoryWareMapper.selectDirTypeNum();
    }
    /**
     * 描述：查询各单位开放与不开放的占比
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：
     */
    @Override
    public List<ShareDataDirecoryUnitNumDO> queryUnitDirTypeNum() {
        return shareDataDirectoryWareMapper.selectUnitDirTypeNum();
    }
}
