package com.hengyunsoft.platform.exchange.repository.api.dao;

import com.hengyunsoft.platform.exchange.entity.api.domain.*;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgScreenDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShareDataApiMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi, com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample> {
    List<ShareDataApiListDO> selectList(Map<String, Object> param);
    /**
     * 描述：通过ApiId查找所共享单位
     * 参数：openApiReq 分页信息；ApiAuthUnitConditionDTO
     * 返回值：PageInfo<ApiAuthUnitListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */
    List<ApiAuthUnitListDO> selectAuthUnit(Map<String, Object> param);

    /**
     * 描述：查询api未共享的单位
     * 参数：apiId apiId
     * 返回值：  List<VOrgDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */
    List<VOrgDO> selectNoAuthUnit(@Param("apiId") Long apiId);
    /**
     * 描述：查询api正常使用情况
     * 参数：param
     * 返回值：List<ApiAuthUnitListDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    List<ApiUseDO> selectApiUse(Map<String, Object> param);
    /**
     * 描述：查询api异常使用情况
     * 参数：param
     * 返回值：List<ApiUseExceptionDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    List<ApiUseExceptionDO> selectApiUseException(Map<String, Object> param);
    /**
     * @todo 根据元目录id查询Api
     * @param  dirId 元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    List<ShareDataApiListDO> getApiList(@Param("dirId")Long dirId);
    /**
     * @todo 热门TOP10API
     * @Author wgj
     * @createtime 2018-4-22
     */
    List<ShareDataApiListDO> getHostApi();
    /**
     * @todo根据类型查询api量
     * @param param
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    int getApiCountByCode( Map<String, Object> param);

    ApiOpenInfoDO selectOpenOpiInfo(@Param("secretKey") String secretKey);

    ApiDetailDO selectDetailById(@Param("id") Long id);

    boolean selectUnitOwnerDir(@Param("unitId") String unitId,@Param("dirId") Long dirId);
    /**
     * 根据数据集id查询api
     * @param setId
     * @return
     */
    List<ShareDataApi> getApiListBySetId(@Param("setId")Long setId);
    /**
     *  根据单位id查询api数量
     * @return
     */
    int  getApiCountByUnit(String unitId);

    /**
     * 批量更新api信息
     * @param shareDataApiList
     */
    void batchUpdate(List<ShareDataApi>  shareDataApiList);
    /**
     * 描述：查询单位下正常目录可用API总数，用于概览
     * 参数：unitId 单位Id
     * 返回值：总数
     * 修改人：zhaopengfei
     * 修改时间：2018/10/16
     * 修改内容：
     */
    int selectDirCanUserApiCount(@Param("unitId") String unitId);
    /**
     * 描述：获取标签云数据
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/4/11
     * 修改内容：
     */
    List<Map<String, Object>> selectTagCould();

}