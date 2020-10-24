package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

/**
 * 描述:模块申请审批状态
 * @author chb
 * @date 2018/4/3 14:43 
 */
public class AssignModuleApplyConstant {

    /**
     * 起草
     */
    //public static Short STATUS_DRAFT    = 1;

    //2018-4-11 审核状态： 1  待审核     2 审核通过    3 审核不通过,之前为1234包含草稿箱功能
    /**
     * 待审核
     */
    public static final Short STATUS_PROCESS  = 1;

    /**
     * 审核通过
     */
    public static final Short STATUS_PASS     = 2;

    /**
     * 审核不通过
     */
    public static final Short STATUS_NOT_PASS = 3;

    /**
     * 启用
     */
    public static final Boolean ENABLE   = true;

    /**
     * 禁用
     */
    public static final Boolean DISABLE  = false;

    /**
     * 状态： 1、正常使用中
     */
    public static final Short USEING   = 1;

    /**
     * 状态： 10、已过时（有新版本取代）
     *
     */
    public static final Short OLD   = 10;

    /**
     * 状态： 20、停止使用
     *
     */
    public static final Short STOP  = 20;
}
