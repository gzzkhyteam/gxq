package com.hengyunsoft.platform.warn.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hengyunsoft.platform.warn.entity.domain.GxqptWarnPagingDO;
import com.hengyunsoft.platform.warn.repository.dao.GxqptSendeeMapper;

@Component
public class DNameUtils {

    @Autowired
    private GxqptSendeeMapper gxqptSendeeMapper;

    /**
     * 查询预警责任人名称
     * @param warnId
     * @param recType
     * @return
     */
    public Map<String, Object> getDutyName(Set<Long> warnId, String recType){
        Map<String, Object> map = new HashMap<String, Object>();
        List<GxqptWarnPagingDO> dlist = gxqptSendeeMapper.getDName(warnId, recType);
        for (GxqptWarnPagingDO gxqptWarnPagingDTO : dlist){
            String dName = gxqptWarnPagingDTO.getDName();
            String dId = String.valueOf(gxqptWarnPagingDTO.getWarnId());
            map.put(dId,dName);
        }
        return map;
    }
}
