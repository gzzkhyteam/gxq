package com.hengyunsoft.platform.hardware.dto.apply;

import lombok.Data;

import java.util.Date;
@Data
public class StatisticsMemTransDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 管理单位id
     *
     * @mbggenerated
     */
    private String orgid;

    /**
     * 管理单位名称
     *
     * @mbggenerated
     */
    private String orgname;

    /**
     * 管理员id
     *
     * @mbggenerated
     */
    private String manageUid;

    /**
     * 管理员名称
     *
     * @mbggenerated
     */
    private String manageUname;
    /**
     * 内存大小
     *
     * @mbggenerated
     */
    private int memorySize;
    /**
     * 0未使用（已释放），1使用中，2已归还
     *
     * @mbggenerated
     */
    private Integer useStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 归还日期
     *
     * @mbggenerated
     */
    private Date revertTime;
}
