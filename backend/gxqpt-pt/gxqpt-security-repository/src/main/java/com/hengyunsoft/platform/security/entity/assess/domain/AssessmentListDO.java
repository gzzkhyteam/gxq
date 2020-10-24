package com.hengyunsoft.platform.security.entity.assess.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *数据字典扩展
 */
@Data
public class AssessmentListDO implements Serializable {

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    private String applicationName;

    /**
     * 建设单位
     *
     * @mbggenerated
     */
    private String company;

    /**
     * 承建商
     *
     * @mbggenerated
     */
    private String contractor;

    /**
     * 安全等级 0低 1中 2高
     *
     * @mbggenerated
     */
    private String level;

    /**
     * 评估时间
     *
     * @mbggenerated
     */
    private Date assessmentTime;

    /**
     * 评估文件名
     *
     * @mbggenerated
     */
    private String assessmentFileName;

    /**
     * 整改文件名
     *
     * @mbggenerated
     */
    private String rectificationFileName;
}
