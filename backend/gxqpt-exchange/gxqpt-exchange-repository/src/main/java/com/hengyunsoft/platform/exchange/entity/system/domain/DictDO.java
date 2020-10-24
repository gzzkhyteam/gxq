package com.hengyunsoft.platform.exchange.entity.system.domain;

import com.hengyunsoft.platform.exchange.entity.system.po.ShareDict;
import lombok.Data;

/**
 *数据字典扩展
 */
@Data
public class DictDO extends ShareDict {
    /**
     * 上级目录名称
     *
     * @mbggenerated
     */
    private String pDictName;

    /**
     * 上级目录编码
     *
     * @mbggenerated
     */
    private String pDictCode;

    /**
     * 当前目录是否存在子目录
     */
    private Boolean isChildren;
}
