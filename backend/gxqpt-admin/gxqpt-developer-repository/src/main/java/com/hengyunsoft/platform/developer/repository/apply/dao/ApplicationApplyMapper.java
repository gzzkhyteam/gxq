package com.hengyunsoft.platform.developer.repository.apply.dao;

import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplyQueryDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationApplyMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply, com.hengyunsoft.platform.developer.repository.apply.example.ApplicationApplyExample> {

	/**
	 *
	 * @param moduleId     模块Id   过滤条件     null标示不限制
	 * @param auditStatus  审批状态   过滤条件  1、待审核     2、已通过      3、被拒绝    null标示不限制
	 * @param appIds       查询人管理的应用appid集合     允许null
	 * @param taskType     任务类型：   新增应用申请appApply    新增功能申请 moduleApply   功能调用申请assignApply  null标示不限制
	 * @param taskRole     任务角色 ： 申请类任务apply    审批类任务 audit   其他标示不限制
	 * @param auditApp2ModelAdd     只有服务监控管理员查询时候才可以设置问true   表示他可以查询审批应用新增及模块新增   否则都设置为false
	 * @param applyUser    申请人     这里传入查询人即可
	 * @return
	 */
	public List<ApplyQueryDO> queryMyTask(@Param("moduleName")String moduleName,@Param("appName")String appName,@Param("moduleId") String moduleId,@Param("auditStatus")String auditStatus
			,@Param("appIds")List<String> appIds,@Param("taskType")String taskType,@Param("taskRole")String taskRole,@Param("auditApp2ModelAdd")Boolean auditApp2ModelAdd,@Param("applyUser") Long applyUser);

}