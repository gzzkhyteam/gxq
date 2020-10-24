package com.hengyunsoft.platform.supervise.util;

import com.hengyunsoft.platform.supervise.dto.analysis.PublicSurveyListReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.PublicSurveyReqDTO;
import com.hengyunsoft.platform.supervise.impl.constant.OrgPublicEnum;
import com.hengyunsoft.utils.BizAssert;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.hengyunsoft.commons.exception.core.WarnExceptionCode.ANALYSIS_PUBLIC_ID_NULL;

/**
 * 公用查询转化工具
 *
 * @author wz
 */
public class OrgUtil {
    public static final String PARAM_PROPERTY_NAME = "propertyName";
    private static final String PARAM_PROPERTY = "property";
    private static final String PARAM_PROPERTY_EMP_DPM = "empDpmId";
    private static final String PARAM_IDS = "ids";
    private static final String PARAM_ID = "id";

    /**
     * 组织机构集合查询
     * @param dto
     * @return
     */
    public static Map<String, Object> OrgChooseNotNull(PublicSurveyListReqDTO dto) {
        Map<String, Object> map = new HashMap<>();
        if (dto.getDate() != null) {
            map.put("date", dto.getDate());
        } else {
            map.put("date", new Date());
        }
        if (dto.getOrgIds() != null) {
            //单位相关查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.ORG.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.ORG.getMsg());
            map.put(PARAM_IDS, dto.getOrgIds());
            return map;
        } else if (dto.getDpmIds() != null) {
            //部门相关查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.DPM.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.DPM.getMsg());
            map.put(PARAM_IDS, dto.getDpmIds());
            return map;
        } else if (dto.getEmpIds() != null) {
            //不同单位部门下部门相关查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.USER.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.EMP.getMsg());
            map.put(PARAM_IDS, dto.getEmpIds());
            map.put(PARAM_PROPERTY_EMP_DPM, dto.getEmpDpmId());
            return map;
        } else if (dto.getAppIds() != null) {
            //应用查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.APP.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.APP.getMsg());
            map.put(PARAM_IDS, dto.getAppIds());
            return map;
        }
        BizAssert.fail(ANALYSIS_PUBLIC_ID_NULL.getCode(), ANALYSIS_PUBLIC_ID_NULL.getMsg());
        return null;
    }

    /**
     * 组织机构单项查询
     * @param dto
     * @return
     */
    public static Map<String, Object> OrgChooseNotNull(PublicSurveyReqDTO dto) {
        Map<String, Object> map = new HashMap<>();
        if (dto.getDate() != null) {
            map.put("date", dto.getDate());
        } else {
            map.put("date", new Date());
        }
        if (dto.getOrgId() != null) {
            //单位相关查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.ORG.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.ORG.getMsg());
            map.put(PARAM_ID, dto.getOrgId());
            return map;
        } else if (dto.getDpmId() != null) {
            //部门相关查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.DPM.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.DPM.getMsg());
            map.put(PARAM_ID, dto.getDpmId());
            return map;
        } else if (dto.getEmpId() != null) {
            //不同单位部门下部门相关查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.USER.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.EMP.getMsg());
            map.put(PARAM_ID, dto.getEmpId());
            map.put(PARAM_PROPERTY_EMP_DPM, dto.getEmpDpmId());
            return map;
        } else if (dto.getAppId() != null) {
            //应用查询
            map.put(PARAM_PROPERTY, OrgPublicEnum.APP.getMsg());
            map.put(PARAM_PROPERTY_NAME, OrgPublicEnum.APP.getMsg());
            map.put(PARAM_ID, dto.getAppId());
            return map;
        }
        BizAssert.fail(ANALYSIS_PUBLIC_ID_NULL.getCode(), ANALYSIS_PUBLIC_ID_NULL.getMsg());
        return null;
    }
}
