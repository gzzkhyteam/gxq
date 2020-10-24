package com.hengyunsoft.platform.exchange.repository.api.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.exchange.entity.api.domain.FiledSelectDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElement;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;

import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api 选择字段service
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */

public interface ShareDataApiElementService extends BaseAllService<Long, ShareDataApiElement, ShareDataApiElementExample> {
    /**
     * 描述：根据apiId查询查询字段详细信息
     * 参数：apiId
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/23
     * 修改内容：
     */
    List<ShareDataElement> findElementInfoByApiId(Long apiId);
    /**
     * 描述：
     * 参数：根据API id查询API查询字段
     * 返回值：FiledSelectDO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/8
     * 修改内容：
     */
    List<FiledSelectDO> querySelectFiled(Long id);
    /**
     * 描述：根据定义不同的属性删除
     * 参数：example
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */
    int deleteByExample(ShareDataApiElementExample example);

    void saveBatch(List<ShareDataApiElement> elements);
}
