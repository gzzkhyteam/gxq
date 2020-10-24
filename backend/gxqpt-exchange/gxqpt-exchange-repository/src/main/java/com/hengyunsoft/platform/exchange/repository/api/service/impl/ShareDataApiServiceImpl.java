package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.exchange.entity.api.domain.*;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiUser;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiFilterExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiUserExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiElementService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiFilterService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiUserService;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementService;
import com.hengyunsoft.platform.exchange.util.SearchQueueUtil;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
import com.hengyunsoft.platform.search.queue.dto.IndexItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api管理实现
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataApiServiceImpl extends BaseAllServiceImpl<Long, ShareDataApi, ShareDataApiExample> implements ShareDataApiService {
    @Autowired
    ShareDataApiMapper mapper;
    @Value("http://${gxqpt.hostname.nginx:127.0.0.1}:${gxqpt.port.gate:10003}/api/exchange/p/api/sharedataapiopen")
    String url;


    @Autowired
    private ShareDataApiElementService shareDataApiElementService;
    @Autowired
    private ShareDataApiFilterService shareDataApiFilterService;
    @Autowired
    private ShareDataApiUserService shareDataApiUserService;
    @Autowired
    private DataElementService dataElementService;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    CommonService commonService;

    @Autowired
    private SearchQueueUtil searchQueueUtil;

    @Override
    protected BaseNormalDao<Long, ShareDataApi, ShareDataApiExample> getDao() {
        return mapper;
    }

    /**
     * 描述：查询前端列表查询数据
     * 参数：param
     * 返回值：ShareDataApiListDO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @Override
    public List<ShareDataApiListDO> findList(Map<String, Object> param) {
        return mapper.selectList(param);
    }

    /**
     * 描述：通过ApiId查找所共享单位
     * 参数：openApiReq 分页信息；ApiAuthUnitConditionDTO
     * 返回值：PageInfo<ApiAuthUnitListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */
    @Override
    public List<ApiAuthUnitListDO> findAuthUnit(Map<String, Object> param) {
        return mapper.selectAuthUnit(param);
    }

    /**
     * 描述：查询api未共享的单位
     * 参数：apiId apiId
     * 返回值：  List<VOrgDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */
    @Override
    public List<VOrgDO> findNoAuthUnit(Long apiId) {
        return mapper.selectNoAuthUnit(apiId);

    }

    /**
     * 描述：查询api正常使用情况
     * 参数：param
     * 返回值：List<ApiAuthUnitListDO>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    @Override
    public List<ApiUseDO> findApiUse(Map<String, Object> param) {
        return mapper.selectApiUse(param);
    }

    @Override
    public List<ApiUseExceptionDO> findApiUseException(Map<String, Object> param) {
        return mapper.selectApiUseException(param);
    }

    /**
     * @param id 元目录id
     * @return boolean
     * @todo 根据元目录id查询Api
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    public List<ShareDataApiListDO> getApiList(Long id) {


        return mapper.getApiList(id);
    }

    /**
     * @todo 热门TOP10API
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    public List<ShareDataApiListDO> getHostApi() {


        return mapper.getHostApi();
    }

    /**
     * 描述：根据密钥获取API相关信息
     * 参数：secretKey 密钥
     * 返回值：ApiOpenInfoDO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/9
     * 修改内容：
     */
    @Override
    public ApiOpenInfoDO selectOpenOpiInfo(String secretKey) {
        return mapper.selectOpenOpiInfo(secretKey);
    }

    /**
     * @param param
     * @return boolean
     * @todo根据类型查询api量
     * @Author wgj
     * @createtime 2018-4-22
     */
    @Override
    public int getApiCountByCode(Map<String, Object> param) {

        return mapper.getApiCountByCode(param);
    }

    @Override
    public ApiDetailDO getDetailById(Long id) {
        return mapper.selectDetailById(id);
    }

    @Override
    public boolean queryOwner(String unitId, Long dirId) {
        return mapper.selectUnitOwnerDir(unitId, dirId);
    }

    /**
     * 描述：用于新增目录后新增全量API
     * 参数：dirId 目录Id
     * 参数：dirName 目录名
     * 参数：unitId 单位Id
     * 参数：filedIds 字段Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    @Override
    public void addApiByDirAdd(Long dirId, String dirName, String unitId, List<Long> filedIds, List<String> unitIds) {
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();
        Long apiId = null;
        //首先判断该目录是否已经存在全量API
        ShareDataApiExample example = new ShareDataApiExample();
        example.createCriteria().andDirIdEqualTo(dirId).andApiTypeEqualTo(1);
        List<ShareDataApi> apiList = this.find(example);
        if (!ObjectUtils.isEmpty(apiList) && apiList.size() > 0) { //如果存在，则先删除字段，在添加字段
            apiId = apiList.get(0).getId();
            //删除全量API字段
            ShareDataApiElementExample elementExample = new ShareDataApiElementExample();
            elementExample.createCriteria().andApiIdEqualTo(apiId);
            shareDataApiElementService.deleteByExample(elementExample);

            //查询该目录已经删除的字段，把查询出来的字段并对API的查询字段及过滤条件字段进行删除
            ShareDataElementExample dataElementExample = new ShareDataElementExample();
            dataElementExample.createCriteria().andDirIdEqualTo(dirId).andOptTypeEqualTo(3);
            List<ShareDataElement> shareDataElements = dataElementService.find(dataElementExample);
            if (!ObjectUtils.isEmpty(shareDataElements) && shareDataElements.size() > 0) {
                for (ShareDataElement element : shareDataElements) {
                    //删除API查询字段
                    ShareDataApiElementExample shareDataApiElementExample = new ShareDataApiElementExample();
                    shareDataApiElementExample.createCriteria().andFieldIdEqualTo(element.getId());
                    shareDataApiElementService.deleteByExample(shareDataApiElementExample);

                    //删除API过滤字段
                    ShareDataApiFilterExample shareDataApiFilterExample = new ShareDataApiFilterExample();
                    shareDataApiFilterExample.createCriteria().andFieldIdEqualTo(element.getId());
                    shareDataApiFilterService.deleteByExample(shareDataApiFilterExample);
                }
            }

        } else {  //如果不存在，新建全量API，再增加字段
            //新增API
            //对于不开放不共享或者不开放有条件共享的API，对创建单位生成相应的密钥
            ShareDataDirectory directory = new ShareDataDirectory();
            directory = dataDirectoryService.getById(dirId);
            ShareDataApi api = new ShareDataApi();
            api.setApiName(dirName + "全量API");
            String apiCode = UUID.randomUUID().toString().replace("-", "");
            api.setApiUrl(url + "/" + apiCode);
            api.setDataFmat(1);
            api.setApiCode(apiCode);
            api.setApiDesc("");
            api.setDirId(dirId);
            api.setApiType(1);
            api.setApiStatus(1);
            api.setAuthStatus(3);
            api.setUnitId(unitId);
            api.setCreateUser(directory.getCreateUser());
            api.setCreateTime(date);
            api.setUpdateUser(directory.getCreateUser());
            api.setUpdateTime(date);
            this.save(api);
            apiId = api.getId();

            if (directory.getOpenWay() == 2 && (directory.getShareWay() != 1)) {
                    unitIds.add(directory.getUnitId());
            }

            //保存共享申请
            if (!ObjectUtils.isEmpty(unitIds) && unitIds.size() > 0) {
                for (String shareUnitId : unitIds) {
                    addApiShareUser(shareUnitId, apiId, date);
                }
            }

            //增加门户快速搜索索引
            String content = org.springframework.util.StringUtils.isEmpty(api.getApiDesc())?api.getApiName():api.getApiDesc();
            String indexUrl = "/module/index?promUrl=/gxqpt-exchange/module/generalApiView?id=";
            IndexItemDTO indexItemDTO = searchQueueUtil.covertIndexItemDto(api.getId().toString(),content,api.getApiName(), indexUrl, SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API);
            searchQueueUtil.saveOrUpdateIndex(indexItemDTO);
        }


        //新增API查询字段
        if (!ObjectUtils.isEmpty(filedIds) && filedIds.size() > 0) {
            for (Long filedId : filedIds) {
                ShareDataApiElement element = new ShareDataApiElement();
                element.setApiId(apiId);
                element.setFieldId(filedId);
                element.setCreateTime(date);
                element.setCreateUser(userId);
                element.setUpdateTime(date);
                element.setUpdateUser(userId);
                shareDataApiElementService.save(element);
            }
        }


    }

    private void addApiShareUser(String shareUnitId, Long apiId, Date date) {
        Long userId = BaseContextHandler.getAdminId();
        ShareDataApiUser shareDataApiUser = new ShareDataApiUser();
        shareDataApiUser.setUnitId(shareUnitId);
        shareDataApiUser.setDateTerm(-1);
        shareDataApiUser.setAuthStatus(3);
        shareDataApiUser.setApiId(apiId);
        shareDataApiUser.setIsTake(2);
        shareDataApiUser.setApplyTime(date);
        shareDataApiUser.setApiType(4);
        shareDataApiUser.setReason("目录共享单位新增");
        shareDataApiUser.setSecretKey(UUID.randomUUID().toString().replace("-", ""));
        shareDataApiUser.setCreateTime(date);
        shareDataApiUser.setCreateUser(userId);
        shareDataApiUser.setUpdateTime(date);
        shareDataApiUser.setUpdateUser(userId);
        shareDataApiUserService.save(shareDataApiUser);
    }

    /**
     * 描述：用于目录修改新增字段
     * 参数：dirId 目录Id
     * 参数：filedIds 新增字段Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    @Override
    public void updateApiFiledByDirFiledAdd(Long dirId, Long filedIds) {
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();
        ShareDataApiExample shareDataApiExample = new ShareDataApiExample();
        shareDataApiExample.createCriteria().andDirIdEqualTo(dirId).andApiTypeEqualTo(1);
        ShareDataApi shareDataApi = mapper.selectEntity(shareDataApiExample);
        if (ObjectUtils.isEmpty(shareDataApi)) {
            ShareDataApiElement shareDataApiElement = new ShareDataApiElement();
            shareDataApiElement.setApiId(shareDataApi.getId());
            shareDataApiElement.setFieldId(filedIds);
            shareDataApiElement.setCreateUser(userId);
            shareDataApiElement.setCreateTime(date);
            shareDataApiElement.setUpdateUser(userId);
            shareDataApiElement.setUpdateTime(date);
            shareDataApiElementService.save(shareDataApiElement);
        }

    }

    /**
     * 描述：用于目录修改删除字段
     * 参数：dirId 目录Id
     * 参数：filedIds 新增字段Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    @Override
    public void updateApiFiledByDirFiledDelete(Long dirId, Long filedIds) {
        ShareDataApiElementExample example = new ShareDataApiElementExample();
        example.createCriteria().andFieldIdEqualTo(filedIds);
        List<ShareDataApiElement> list = shareDataApiElementService.find(example);
        if (!ObjectUtils.isEmpty(list) && list.size() > 0) {
            for (ShareDataApiElement element : list) {
                shareDataApiElementService.deleteById(element.getId());
            }
        }
    }

    /**
     * 描述：用于目录禁用修改API相关信息
     * 参数：dirIds 禁用目录Id列表
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    @Override
    public void updateApiByDirForbidden(List<Long> dirIds) {
        if (!ObjectUtils.isEmpty(dirIds) && dirIds.size() > 0) {
            for (Long id : dirIds) {
                ShareDataApiExample example = new ShareDataApiExample();
                example.createCriteria().andDirIdEqualTo(id);
                List<ShareDataApi> apiList = mapper.selectByExample(example);
                if (!ObjectUtils.isEmpty(apiList) && apiList.size() > 0) {
                    for (ShareDataApi api : apiList) {
                        api.setApiStatus(2);
                        mapper.updateByPrimaryKeySelective(api);
                    }
                }
            }
        }
    }

    /**
     * 描述：用于目录删除修改API相关信息
     * 参数：dirId 禁用目录Id
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    @Override
    public void deleteApiByDeleteDir(Long dirId) {
        ShareDataApiExample example = new ShareDataApiExample();
        example.createCriteria().andDirIdEqualTo(dirId);
        List<ShareDataApi> apiList = mapper.selectByExample(example);
        if (!ObjectUtils.isEmpty(apiList) && apiList.size() > 0) {
            for (ShareDataApi api : apiList) {
                mapper.deleteByPrimaryKey(api.getId());
                ShareDataApiUserExample shareDataApiUserExample = new ShareDataApiUserExample();
                shareDataApiUserExample.createCriteria().andApiIdEqualTo(api.getId());
                List<ShareDataApiUser> apiUserList = shareDataApiUserService.find(shareDataApiUserExample);
                if (!ObjectUtils.isEmpty(apiUserList) && apiUserList.size() > 0) {
                    for (ShareDataApiUser apiUser : apiUserList) {
                        shareDataApiUserService.deleteById(apiUser.getId());
                    }
                }
                DeleteIndexDTO indexDTO = new DeleteIndexDTO();
                indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API+"_"+api.getId().toString());
                indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                searchQueueUtil.deleteIndex(indexDTO); //删除索引
            }
        }
    }

    /**
     * 描述：用于目录修改后修改API共享单位
     * 参数：dirId 目录Id
     * 参数：unitDoList 共享单位list
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/10
     * 修改内容：
     */
    @Override
    public void deleteApiByDeleteDir(Long dirId, List<ShareUnit> unitDoList) {
        if (!ObjectUtils.isEmpty(dirId) && !ObjectUtils.isEmpty(unitDoList) && unitDoList.size() > 0) {
            for (ShareUnit unitDO : unitDoList) {
                Integer optType = unitDO.getOptType();
                if (!ObjectUtils.isEmpty(optType)) {
                    Date date = new Date();

                    //查询目录对应的全量API
                    ShareDataApiExample example = new ShareDataApiExample();
                    example.createCriteria().andDirIdEqualTo(dirId)
                            .andApiTypeEqualTo(1);
                    ShareDataApi api = mapper.selectEntity(example);

                    //对操作类型进行判断，如果为新添加的共享单位，则新增用户申请
                    if (optType == 1) {
                        addApiShareUser(unitDO.getUnitId(), api.getId(), date);
                    } else if (optType == 3) {//如果为删除，则删除掉该单位申请下类型为用户授权的用户申请信息
                        ShareDataApiUserExample userExample = new ShareDataApiUserExample();
                        userExample.createCriteria().andApiIdEqualTo(api.getId())
                                .andApiTypeEqualTo(4)
                                .andUnitIdEqualTo(unitDO.getUnitId());
                        List<ShareDataApiUser> apiUserList = shareDataApiUserService.find(userExample);
                        if (!ObjectUtils.isEmpty(apiUserList) && apiUserList.size() > 0) {
                            for (ShareDataApiUser apiUser : apiUserList) {
                                shareDataApiUserService.deleteById(apiUser.getId());
                            }
                        }
                    }
                }

            }
        }
    }

    /**
     * 根据数据集id查询api
     *
     * @param setId
     * @return
     */
    @Override
    public List<ShareDataApi> getApiListBySetId(Long setId) {


        return mapper.getApiListBySetId(setId);
    }

    /**
     * 根据单位id查询api数量
     *
     * @return
     */
    @Override
    public int getApiCountByUnit(String unitId) {

        return mapper.getApiCountByUnit(unitId);
    }

    @Override
    public void batchUpdate(List<ShareDataApi> shareDataApiList) {
        mapper.batchUpdate(shareDataApiList);
    }
    /**
     * 描述：查询单位下正常目录可用API总数，用于概览
     * 参数：unitId 单位Id
     * 返回值：总数
     * 修改人：zhaopengfei
     * 修改时间：2018/10/16
     * 修改内容：
     */
    @Override
    public int queryDirCanUseApiCount(String unitId) {
        return mapper.selectDirCanUserApiCount(unitId);
    }
    /**
     * 描述：获取标签云数据
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/4/11
     * 修改内容：
     */
    @Override
    public List<Map<String, Object>> getTagCloud() {
        return mapper.selectTagCould();
    }


}
