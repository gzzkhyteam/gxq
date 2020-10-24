package com.hengyunsoft.platform.exchange.repository.directory.dao;

import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectoryWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirecoryUnitNumDO;
import org.springframework.stereotype.Repository;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareCountView;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataView;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.DirViewDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.ApiTopDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgApiViewDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgScreenDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Repository
public interface ShareDataDirectoryWareMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectoryWare, com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryWareExample> {
    /**
     * @todo 根据元目录id查询详情
     * @param  id 元目录id
     * @Author wgj
     * @createtime 2018-4-22
     */
    ShareDataView getDirViewById(@Param("id") String id);
    /**
     * 根据主题，领域，服务，行业等查询元目录
     * @param busCode
     * @param searchKey
     * @param indexNo
     * @return
     */
    List<ShareDataView> getBottomDirByBuss(@Param("busCode") String busCode, @Param("busKey") String busKey, @Param("searchKey") String searchKey, @Param("indexNo") Integer indexNo);
    /**
     * 根据单位查询元目录
     * @param unitId 单位id
     * @param searchKey 关键字
     * @param indexNo 排序方式 1，更新时间，2，访问量，3，数据量
     * @return
     */
    List<ShareDataView> getBottomDirByUnit(@Param("unitId") String unitId, @Param("searchKey") String searchKey, @Param("indexNo") Integer indexNo);
    /**
     * 查询主题，行业，服务及数据量
     * @return
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<ShareCountView> getBusDataByBus(@Param("busCode") String busCode, @Param("level") Integer level);
    /**
     * 查询单位及数据量
     * @return
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    List<ShareCountView> getBusDataByOrg();
    /**
     * 根据年月查询元目录数量
     * @param yearKey
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    int getDirCount(@Param("yearKey") String yearKey, @Param("monthKey") String monthKey);

    /**
     * 根据年月查询数据集数量
     * @param yearKey
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    int getSetCount(@Param("yearKey") String yearKey, @Param("monthKey") String monthKey);
    /**
     * 根据年月查询API数量
     * @param yearKey
     * @param monthKey
     * @Auuthor wgj
     * @createtime 2018-4-25
     */
    int getApiCount(@Param("yearKey") String yearKey, @Param("monthKey") String monthKey);
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
    int getOrgApiCallCount(@Param("unitId") String unitId);
    /**
     *API调用TOP10
     * api数目与调用次数
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
    int getApiCallCount(@Param("yearKey") String yearKey, @Param("monthKey") String monthKey);
    /**
     *根据年月查询数据交换量
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    int getTransDataCount(@Param("yearKey") String yearKey, @Param("monthKey") String monthKey);

    /**
     *查询已接入部门
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    int getOrgcount();
    /**
     * @todo 更新元目录的查看次数
     * @param  id 元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    void updateSeeCount(@Param("id") String id);
    /**
     * 根据单位查询目录数
     * @param unitId
     * @return
     */
    int getOrgDirCount(@Param("unitId") String unitId);
    /**
     * 根据单位查询目录
     * @param unitId
     * @return
     */
    List<DirViewDO> getListByUnit(@Param("unitId") String unitId);
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
     * 批量更新目录信息到发布表
     * @param dataDirectoryList
     */
    void batchUpdate(List<ShareDataDirectoryWare>  dataDirectoryList);

    /**
     * 查询共享交换分析目录数量月度数据
     * @param year
     * @return
     */
    List<ShareDataDirecoryUnitNumDO> selectDirMonthData(String year);

    /**
     * 查询目录占比
     * @return
     */
    ShareDataDirecoryUnitNumDO selectDirTypeNum();

    /**
     * 查询各单位开放与不开放的占比
     * @return
     */
    List<ShareDataDirecoryUnitNumDO> selectUnitDirTypeNum();
}