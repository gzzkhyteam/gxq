package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByExchangeReqDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgDetailsDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgDpmIdentiDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgEditDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgEditRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResPageDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgSaveAndShareDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgStatisticsNumDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemTreeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单位管理
 *
 * @author wangzhen
 * @createTime 2018-03-06
 */
@Component
public class GxqptOrgHystrix implements GxqptOrgApi {
    @Override
    public Result<GxqptOrgResDTO> save(GxqptOrgSaveAndShareDTO gxqptOrgSaveAndShare) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptOrgEditRetDTO> update(GxqptOrgEditDTO gxqptOrgEdit) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateShare(GxqptOrgEditDTO gxqptOrgEdit) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> remove(String[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateEnable(String[] ids, String isenble) {
        return Result.timeout();
    }

    @Override
    public void exportOrg(String[] ids, HttpServletResponse response) {

    }

    @Override
    public Result<List<GxqptOrgResDTO>> find(String systemCode, Long type) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptOrgResDTO> getById(String systemCode, String id) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptOrgDetailsDTO> getDetails(String systemCode, String id) {
        return Result.timeout();
    }


    @Override
    public Result<PageInfo<GxqptOrgResDTO>> pageByIds(@RequestBody OpenApiReq<GxqptOrgResPageDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgByUserDTO>> findOrgByUser() {
        return Result.timeout();
    }

    @Override
    public void downLoadTemplet(HttpServletResponse response) {

    }

    @Override
    public Result<List<GxqptOrgResDTO>> saveOrgs(MultipartFile file, String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveManagerByOrg(String orgId, Long userId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteManagerByOrg(String orgId, Long userId) {
        return Result.timeout();
    }

    @Override
    public Result<List<String>> getShares(String id) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgDpmIdentiDTO>> findOrgDpmIdenti() {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgResDTO>> findOrgAndDpmOperationTree() {
        return Result.timeout();
    }

    @Override
    public Result<GxqptOrgDetailsDTO> getDetailByOrgId(String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptSystemTreeDTO>> getAllOrgAndDpm() {
        return Result.timeout();
    }

    @Override
    public Result<GxqptOrgStatisticsNumDTO> getOrgStatisticsNum() {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgByUserDTO>> findOrgByPower() {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgResDTO>> findOrgNameByIds(List ids) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgResDTO>> findOrgByOrgRole() {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgResDTO>> findOrgByExchange(GxqptOrgByExchangeReqDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgResDTO>> findOrgTreeByUsersInOperation(List<Long> ids) {return Result.timeout(); }

    @Override
    public Result<List<GxqptOrgResDTO>> findOrgTreeByLoginInOperation() {return Result.timeout(); }
}
