package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.domain.*;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api管理Service
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */

public interface ShareDataApiService extends BaseAllService<Long, ShareDataApi, ShareDataApiExample> {
    /**
     * 描述：查询前端列表查询数据
     * 参数：param
     * 返回值：ShareDataApiListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    List<ShareDataApiListDO> findList(Map<String, Object> param);

    /**
     * 描述：通过ApiId查找所共享单位
     * 参数：openApiReq 分页信息；ApiAuthUnitConditionDTO
     * 返回值：PageInfo<ApiAuthUnitListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */
    List<ApiAuthUnitListDO> findAuthUnit(Map<String, Object> param);

    /**
     * 描述：查询api未共享的单位
     * 参数：apiId apiId
     * 返回值：  List<VOrgDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */
    List<VOrgDO> findNoAuthUnit(Long apiId);
    /**
     * 描述：查询api正常使用情况
     * 参数：param
     * 返回值：List<ApiAuthUnitListDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    List<ApiUseDO> findApiUse(Map<String, Object> param);

    /**
     * 描述：查询api异常使用情况
     * 参数：param
     * 返回值：List<ApiUseExceptionDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    List<ApiUseExceptionDO> findApiUseException(Map<String, Object> param);
    /**
     * @todo 根据元目录id查询Api
     * @param  dirId 元目录id
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    List<ShareDataApiListDO> getApiList(Long dirId);
    /**
     * @todo 热门TOP10API
     * @Author wgj
     * @createtime 2018-4-22
     */
    List<ShareDataApiListDO> getHostApi();

    /**
     * 描述：根据密钥获取API相关信息
     * 参数：secretKey 密钥
     * 返回值：ApiOpenInfoDO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/9
     * 修改内容：
     */
    ApiOpenInfoDO selectOpenOpiInfo(@Param("secretKey") String secretKey);
    /**
     * @todo根据类型查询api量
     * @param param
     * @return boolean
     * @Author wgj
     * @createtime 2018-4-22
     */
    int getApiCountByCode(Map<String, Object> param);

    ApiDetailDO getDetailById(Long id);

    boolean queryOwner(String unitId, Long id);
    /**
     * 描述：用于新增目录后新增全量API
     * 参数：dirId 目录Id
     * 参数：dirName 目录名
     * 参数：unitId 单位Id
     * 参数：filedIds 字段Id列表
     * 参数：unitIds 共享单位Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    void addApiByDirAdd(Long dirId,String dirName,String unitId,List<Long> filedIds,List<String> unitIds);
    /**
     * 描述：用于目录修改新增字段
     * 参数：dirId 目录Id
     * 参数：filedIds 新增字段Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    void updateApiFiledByDirFiledAdd(Long dirId,Long filedIds);
    /**
     * 描述：用于目录修改删除字段
     * 参数：dirId 目录Id
     * 参数：filedIds 新增字段Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    void updateApiFiledByDirFiledDelete(Long dirId,Long filedIds);
    /**
     * 描述：用于目录禁用修改API相关信息
     * 参数：dirIds 禁用目录Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    void updateApiByDirForbidden(List<Long> dirIds);

    /**
     * 描述：用于目录删除修改API相关信息
     * 参数：dirId 禁用目录Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    void deleteApiByDeleteDir(Long dirId);


    /**
     * 描述：用于目录修改后修改API共享单位
     * 参数：dirId 目录Id
     * 参数：unitIds 共享单位list
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    void deleteApiByDeleteDir(Long dirId,List<ShareUnit> unitIds);

    /**
     * 根据数据集id查询api
     * @param setId
     * @return
     */
    List<ShareDataApi> getApiListBySetId(Long setId);
    /**
     *  根据单位id查询api数量
     * @return
     */
    int getApiCountByUnit(String unitId);

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
    int queryDirCanUseApiCount(String unitId);
    /**
     * 描述：获取标签云数据
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/4/11
     * 修改内容：
     */
    List<Map<String, Object>> getTagCloud();

}
