package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 软硬件平台
 * 从100000-104999, 每个子模块加500， 每个异常代码+1
 */
public enum  HardWareExceptionCode implements BaseExceptionCode {
    ORGID_NULL(100000, "单位ID不允许为空"),
    ORGNAME_NULL(100001, "单位名称不允许为空"),
    APPLY_USERID_NULL(100002,"申请人id不能为空"),
    APPLY_USERNAME_NULL(100003,"申请人姓名不能为空"),
    APPLY_USEREMAIL_NULL(100004,"申请人邮箱不能为空"),
    APPLY_REASON_NULL(100005,"申请原因不能为空"),
    APPLY_FILE_NULL(100006,"申请附件不能为空"),
    APPLY_SERVER_NULL(100007,"申请服务器数据不能为空"),
    APPLY_SCODE_NULL(100008,"环节编码不能为空"),
    APPLY_MANAGE_ID_NULL(100009,"记录id不能为空"),
    APPLY_APPR_MANAGE_NULL(100010,"该条审批数据不存在"),
    APPLY_APPR_STEPCODE_NULL(100011,"环节编码不能为空"),
    APPLY_STEPCODE_MATCH_NULL(100012,"处理环节不匹配"),
    APPLY_DATA_NULL(100013,"提交数据不能为空"),
    APPLY_SERVER_ID_NULL(100014,"服务器id不能为空"),
    APPLY_SERVER_APPLYKEYID_NULL(100015,"申请单主键不能为空"),

  /**数据字典**/
    DICID_NULL(100500,"字典id不能为空"),
    DICNAME_NULL(100505,"字典名称不能为空"),
    DICORDERNUM(100506,"排序号不能为空"),
    DICTYPEID_NULL(100501,"字典类型id不能为空"),
    DICTYPECODE_NULL(100502,"字典类型编码不能为空"),
    DICTYPENAME_NULL(100503,"字典类型名称不能为空"),
    PARENTID_NULL(100504,"父id不能为空"),

    /**服务分配管理**/
    SERVER_ID_NULL(101000,"服务器id不能为空"),
    SERVER_IP_NULL(101001,"服务器iP不能为空"),
    SERVER_CPU_NULL(101002,"CPU核数不能为空"),
    SERVER_MEMORY_NULL(101003,"内存不能为空"),
    SERVER_SYSTEM_NULL(101004,"操作系统不能为空"),
    SERVER_NET_NULL(101005,"所属网络不能为空"),
    SERVER_WIDE_NULL(101006,"网络带宽不能为空"),
    SERVER_ORG_ID_NULL(101007,"管理单位id不能为空"),
    SERVER_ORG_NAME_NULL(101008,"管理单位名称不能为空"),
    SERVER_ORG_USER_ID_NULL(101009,"管理员id不能为空"),
    SERVER_ORG_USER_NAME_NULL(101010,"管理员名称不能为空"),
    SERVER_OPENTIME_NULL(101011,"开通时间不能为空"),
    SERVER_MANAGE_ID_NULL(101012,"服务分配id不能为空"),
   /**主机管理**/
    MACHINE_IP_NULL(101500,"主机ip不能为空"),
    MACHINE_CLUSTER_NULL(101501,"主机集群不能为空"),
    MACHINE_CPUCOUNT_NULL(101502,"处理器数量不能为空"),
    MACHINE_MEMORY_NULL(101503,"内存大小不能为空"),
    MACHINE_NETCARDCOUNT_NULL(101504,"网卡数量不能为空"),
    MACHINE_DISKSIZE_NULL(101505,"磁盘大小不能为空"),
    MACHINE_ID_NULL(101506,"主机id不能为空"),
    /**数据库管理**/
    DATABASE_INSTANCEDI_NULL(102000,"数据库实例DI不能为空"),
    DATABASE_ADMIN_NULL(102001,"数据库管理员不能为空"),
    DATABASE_ACCOUNT_NULL(102002,"数据库账户不能为空"),
    DATABASE_TYPE_NULL(102003,"数据库类型不能为空"),
    DATABASE_HOSTIPADDRESS_NULL(102004,"主机IP地址不能为空"),
    DATABASE_CHARACTERSET_NULL(102005,"字符集不能为空"),
    DATABASE_PORT_NULL(102006,"端口不能为空"),
    DATABASE_CODE_NULL(102007,"所属网络不能为空"),
    DATABASE_ID_NULL(102008,"数据库主键id不能为空"),
    
    /**设备管理**/
    EQUIPMENTMONITOR_ID_NULL(102500,"IP不能为空"),
	EQUIPMENTMONITOR_ROOMNUMBER_NULL(102501,"机房编号不能为空"),
	EQUIPMENTMONITOR_ROOMADMIN_NULL(102502,"管理员不能为空"),
	EQUIPMENTMONITOR_CONTACTNUMBER_NULL(102503,"联系电话不能为空"),
	EQUIPMENTMONITOR_HOSTNUM_NULL(102504,"主机数量不能为空"),
	EQUIPMENTMONITOR_ROUTERNUM_NULL(102505,"路由器数量不能为空"),
	EQUIPMENTMONITOR_AIRCONNUM_NULL(102506,"空调数量不能为空"),
	EQUIPMENTMONITOR_CABINETNUM_NULL(102507,"机柜数量不能为空"),
    
	/**设备管理>报告**/
    EQUIPMENTMONITORREPORT_ID_NULL(103000,"IP不能为空"),
    EQUIPMENTMONITORREPORT_YEAR_NULL(103001,"年度不能为空"),
    EQUIPMENTMONITORREPORT_MONTH_NULL(103002,"月度不能为空"),
    EQUIPMENTMONITORREPORT_HOSTMGID_NULL(103003,"设备监控id不能为空"),


    /**服务器监控统计模块**/
    STATISTICS_SERVER_ID_NULL(103500, "serverId不能为空"),
    STATISTICS_TIME_NULL(103501, "产生时间不能为空"),
    STATISTICS_TYPE_NULL(103502, "性能类型不能为空"),
    ;
    private int code;
    private String msg;

    HardWareExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
