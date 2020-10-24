package com.hengyunsoft.platform.warn.constant;

import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author madengbo
 * @create 2019-05-06 14:56
 * @desc 获取人员 部门 单位信息
 * @Version 1.0
 **/
@Slf4j
public class GetUserInfo {

    @Autowired
    private GxqptEmpApi gxqptEmpApi;

    public GxqptSendee sendeeSingleDeal(GxqptSendee duList){
        List<String> useIds = new ArrayList<>();
        useIds.add(duList.getUserId().toString());
        GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
        dto.setUserIds(useIds);
        dto.setPageNo(1);
        dto.setPageSize(useIds.size());
        List<GxqptEmpRetDTO> empDate = gxqptEmpApi.findEmpByUserIdsNoToken(dto).getData().getList();
        log.info("预警人员信息查询返回 empDate.toString:{}",empDate.toString());
        if(!empDate.isEmpty()){
            for(GxqptEmpRetDTO user : empDate){
                if(duList.getUserId().equals(user.getGxqptEmpId())){
                    //部门相关的信息
                    duList.setDepartmentId(user.getMaindeptid());
                    duList.setDepartmentName(user.getMaindeptname());
                    //应用相关信息
                    duList.setOrgId(user.getMainorgid());
                    duList.setOrgName(user.getMainorgname());
                    log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys02 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duList.getUserId(),duList.getDepartmentId(),duList.getOrgId());
                    break;
                }
            }
        }
        return duList;
    }

}
