package com.hengyunsoft.platform.exchange.repository.directory.service;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareCountView;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectoryWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataView;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.DirViewDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirecoryUnitNumDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.ApiTopDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgApiViewDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgScreenDO;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryWareExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDirectoryWareService extends BaseAllService<Long,ShareDataDirectoryWare,ShareDataDirectoryWareExample> {
    /**
     * 查询单位数据集
     * @return
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<ShareCountView> getBusDataByOrg();
    /**
     * 查询主题，行业，服务及数据量
     * @return
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<ShareCountView> getBusDataByBus(String busCode,Integer level);
    /**
     * 根据单位查询元目录
     * @param unitId 单位id
     * @param searchKey 关键字
     * @param indexNo 排序方式 1，更新时间，2，访问量，3，数据量
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<ShareDataView> getBottomDirByUnit(String unitId, String searchKey, Integer indexNo);
    /**
     * 根据主题，领域，服务，行业等查询元目录
     * @param busCode
     * @param searchKey
     * @param indexNo
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<ShareDataView> getBottomDirByBuss(String busCode,String busKey, String searchKey, Integer indexNo);
    /**
     * @todo 根据元目录id查询详情
     * @param  id元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    ShareDataView  getDirViewById(String id);

    /**
     * 根据年月查询元目录数量
     * @param year
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    int getDirCount(String year, String monthKey);

    /**
     * 根据年月查询数据集数量
     * @param year
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    int getSetCount(String year, String monthKey);
    /**
     * 根据年月查询API数量
     * @param year
     * @param monthKey
     * @return
     */
    int getApiCount(String year, String monthKey);

    /**
     * 查询部门的API数量
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<OrgApiViewDO> getOrgApiCount();

    /**
     * 根据单位id查询Api调用次数
     * @param unitId
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    int getOrgApiCallCount(String unitId);
    /**
     *API调用TOP10
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    List<ApiTopDO> getApiCallTopList();
    /**
     *根据年月查询API调用次数
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    int getApiCallCount(String year, String monthKey);
    /**
     *根据年月查询数据交换量
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    int getTransDataCount(String year, String monthKey);

    /**
     *目录审批通过后同步保存数据目录中心表
     * @return
     * @Author tianai
     * @createtime 2018-05-07
     */
    int saveWare(ShareDataDirectoryWare entity);
    /**
     * @todo 更新元目录的查看次数
     * @param  id 元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    void updateSeeCount(String id);

    /**
     * 根据单位查询目录数
     * @param unitId
     * @return
     */
    int getOrgDirCount(String unitId);

    /**
     * 根据单位查询目录
     * @param unitId
     * @return
     */
    List<DirViewDO> getListByUnit(String unitId);

    /**
     * 查询单位数据目录前6位
     * @return
     */
    List<OrgScreenDO> getDirDataList();

    /***
     * 更新数据集id为null
     * @param id
     * @param setId
     */
    void updateSetIdToNull(@Param("id") long id, @Param("setId") long setId);
    /***
     * 更新数据集id为
     * @param id
     * @param setId
     */
    void updateSetId(@Param("id") long id, @Param("setId") long setId);
    /**
     * 批量保存目录信息到发布表
     * @param dataDirectoryList
     */
    void batchSave(List<ShareDataDirectoryWare>  dataDirectoryList);
    /**
     * 批量更新目录信息到发布表
     * @param dataDirectoryList
     */
    void batchUpdate(List<ShareDataDirectoryWare>  dataDirectoryList);

    /**
     * 查询共享交换分析目录数量月度数据
     * @param year
     * @return
     */
    List<ShareDataDirecoryUnitNumDO> queryDirMonthData(String year);

    /**
     * 查询目录占比
     * @return
     */
    ShareDataDirecoryUnitNumDO queryDirTypeNum();

    /**
     * 查询各单位开放与不开放的占比
     * @return
     */
    List<ShareDataDirecoryUnitNumDO> queryUnitDirTypeNum();

}
