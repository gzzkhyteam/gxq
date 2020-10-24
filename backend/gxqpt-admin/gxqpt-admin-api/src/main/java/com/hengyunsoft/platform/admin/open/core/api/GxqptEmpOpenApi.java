package com.hengyunsoft.platform.admin.open.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.emp.*;
import com.hengyunsoft.platform.admin.open.core.api.hystrix.GxqptEmpOpenApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述:高新区一体化平台对外接口
 *
 * @author chb
 * @date 2018/3/26 14:22
 * @return
 */
/*@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/admin",fallback = GxqptEmpOpenApiHystrix.class)*/
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = GxqptEmpOpenApiHystrix.class)
public interface GxqptEmpOpenApi {

    /**
     * 根据用户id+体系编码查询用户
     *
     * @param userId
     * @param systemCode
     * @return
     */
    @RequestMapping(value = "/p/emp/getEmpByUserId", method = RequestMethod.GET)
    Result<GxqptEmpRetDTO> getEmpByUserId(@RequestParam(value = "userId") String userId, @RequestParam(value = "systemCode") String systemCode);

    /**
     * 根据用户id获取用户列表（user表的id查询所有体系用户+体系编码）
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/emp/getEmpListByUserId", method = RequestMethod.GET)
    Result<List<GxqptEmpOpenRetDTO>> getEmpListByUserId(@RequestParam(value = "userId") String userId);

    /**
     * 根据单位+体系编码获取用户
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/emp/getEmpListByOrgId", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpRetDTO>> getEmpListByOrgId(@RequestBody OpenApiReq<GxqptEmpOpenQueryDTO> req);


    /**
     * 根据部门+体系编码获取用户
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/p/emp/getEmpListByDeptId", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpRetDTO>> getEmpListByDeptId(@RequestBody OpenApiReq<GxqptEmpOpenQueryDTO> req);


    /**
     * 前提:1,登录人
     * 条件:正常单位，部门+人
     * 返回：name+phone
     * 形式:树
     * 2018-5-8新增接口
     * 2018-7-20 filterPhone 为true时过滤手机号码为空的用户，消息系统需要
     * 2018-08-28新增返回登陆名，移动端lgr需要
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/emp/getTreeEmpPhoneByUserId", method = RequestMethod.GET)
    Result<List<GxqptOrgTreeDTO>> getTreeEmpPhoneByUserId(@RequestParam(value = "userId") String userId,
                                                          @RequestParam(value = "unitId", required = false) String unitId,
                                                          @RequestParam(value = "filterPhone", required = false) Boolean filterPhone);

    /**
     * 2018-6-22 因日志接口需要添加 tian ai
     * 根据userId查询其所在单位下的所有人，若有部门ID则查询该单位对应部门下的人
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/p/emp/getUsersByUserId", method = RequestMethod.GET)
    Result<List<GxqptLogEmpInfoDTO>> getUsersByUserId(@RequestParam(value = "userId") String userId,
                                                      @RequestParam(value = "deptId", required = false) String deptId);
}
