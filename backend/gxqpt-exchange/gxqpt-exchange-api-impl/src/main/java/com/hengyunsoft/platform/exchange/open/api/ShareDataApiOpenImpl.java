package com.hengyunsoft.platform.exchange.open.api;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiCallDto;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiOpenDto;
import com.hengyunsoft.platform.exchange.api.dataapi.open.ShareDataApiOpen;
import com.hengyunsoft.platform.exchange.api.set.dto.ApiQueryDataDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.entity.api.domain.AllUserApiDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiOpenInfoDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.FiledFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.FiledSelectDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiCall;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.entity.screen.po.BusInfoDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.BusInfoDetailDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetElementWare;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetWare;
import com.hengyunsoft.platform.exchange.impl.set.dataread.api.ApiDataDescManager;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.DataBaseDescManager;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import com.hengyunsoft.platform.exchange.repository.api.service.*;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementWareService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetElementWareService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetWareService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * com.hengyunsoft.platform.exchange.controller.dataapi
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：Api管理api
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：新增基础接口
 */
@Api(value = "API - ShareDataApiOpen.java", description = "API对外接口")
@RestController
@RequestMapping("p/api")
@Slf4j
public class ShareDataApiOpenImpl implements ShareDataApiOpen {
    @Autowired
    private ShareDataApiService shareDataApiService;
    @Autowired
    private ShareDataApiElementService shareDataApiElementService;
    @Autowired
    private ShareDataApiFilterService shareDataApiFilterService;
    @Autowired
    private ShareDataApiCallService shareDataApiCallService;
    @Autowired
    private DataBaseDescManager dataBaseDescManager;
    @Autowired
    private ApiDataDescManager apiDataDescManager;
    @Autowired
    private ShareDataSetWareService shareDataSetWareService;
    @Autowired
    private ShareDataApiUserService shareDataApiUserService;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private CommonService commonService;
    @Autowired
    private DataElementWareService dataElementWareService;
    @Autowired
    private ShareDataSetElementWareService shareDataSetElementWareService;


    /**
     * 描述：根据密钥获取API数据
     * 参数：secretKey
     * 返回值：List<Map<String,Object>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/8
     * 修改内容：
     */
//    @Override
    @ApiOperation(value = "根据密钥获取API数据", notes = "根据密钥获取API数据")
    @ApiResponses({
            @ApiResponse(code = 86024, message = "API密钥不能为空"),
            @ApiResponse(code = 86025, message = "该API申请已经过期，请重新申请"),
            @ApiResponse(code = 86026, message = "没有匹配的API信息，请检查密钥"),
            @ApiResponse(code = 86032, message = "输入API 目录编码不能为空"),
            @ApiResponse(code = 86027, message = "找不到对应的API"),
            @ApiResponse(code = 86028, message = "找不到对应的目录"),
            @ApiResponse(code = 86029, message = "找不到对应的查询字段"),
            @ApiResponse(code = 86030, message = "数据集表配置错误"),
            @ApiResponse(code = 85010, message = "元目录不可用"),
            @ApiResponse(code = 86033, message = "API 已被禁用"),
            @ApiResponse(code = 85513, message = "当前数据集没有审批通过不能查询数据"),
            @ApiResponse(code = 86028, message = "找不到对应的数据集"),
            @ApiResponse(code = 85011, message = "该API所在目录没有关联数据集，不可调用"),
            @ApiResponse(code = 86035, message = "请传入正确的日期格式，标准格式为yyyy-MM-dd hh24:mi:ss(例：2018-2-10 10:00:00)"),
    })
    @IgnoreAppToken
    @RequestMapping(value = {"/sharedataapiopen/{apiCode}/{secretKey}", "/sharedataapiopen/{apiCode}"}, method = RequestMethod.GET)
    public Result<Object> findData_TX(HttpServletRequest request, HttpServletResponse response,
                                   @PathVariable(value = "apiCode") String apiCode,
                                   @PathVariable(value = "secretKey", required = false) String secretKey,
                                   @RequestParam(value = "updateTime",required = false) String updateTime,
                                   @RequestParam(value = "pageNo",required = false)Integer pageNo,
                                   @RequestParam(value = "pageSize",required = false)Integer pageSize) {
        Date acceDate = new Date();
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_API_CODE_NULL, apiCode);
        String ipAddr = getIpAddr(request);

        String exceptionLog;
        ApiOpenInfoDO info = new ApiOpenInfoDO();
        Long apiId;
        String callUnitId = "";
        Boolean isAccess = false; //是否可以访问
        //根据apiCode查找Api相关信息
        ShareDataApiExample shareDataApiExample = new ShareDataApiExample();
        shareDataApiExample.createCriteria().andApiCodeEqualTo(apiCode);
        ShareDataApi api = shareDataApiService.getUnique(shareDataApiExample);
        if (ObjectUtils.isEmpty(api)) {
            exceptionLog = ExchangeExceptionCode.SHARE_API_NOT_EXIST.getMsg();
            return Result.fail(exceptionLog);
        }
        apiId = api.getId();
        //判断API是否被禁用
        if (api.getApiStatus() == 2) {
            exceptionLog = ExchangeExceptionCode.API_IS_FORBIDDEN.getMsg();
            return Result.fail(exceptionLog);
        }
        //查找目录信息
        ShareDataDirectory directory = dataDirectoryService.getById(api.getDirId());
        if (ObjectUtils.isEmpty(directory)){
            exceptionLog = ExchangeExceptionCode.DIRECTORY_NOT_USE.getMsg();
            return Result.fail(exceptionLog);
        }
        Integer openWay = directory.getOpenWay();
        Integer shareWay = directory.getShareWay();
        if (ObjectUtils.isEmpty(directory.getSetId())) {
            exceptionLog = ExchangeExceptionCode.DIRECTORY_NOT_UNION_SET.getMsg();
            saveCallInfo(apiId, callUnitId, 0, exceptionLog, 2, ipAddr, acceDate, null, 2);
            return Result.fail(exceptionLog);
        }
        //判断目录是否可用
        if (directory.getOptType() != 5) {
            exceptionLog = ExchangeExceptionCode.DIRECTORY_NOT_USE.getMsg();
            return Result.fail(exceptionLog);
        }
        ShareDataSetWare set = shareDataSetWareService.getById(directory.getSetId());
        if (ObjectUtils.isEmpty(set)) {
            exceptionLog = ExchangeExceptionCode.SHARE_SET_NOT_EXIST.getMsg();
            return Result.fail(exceptionLog);
        }
        //判断数据集是否已经审核通过
        if (set.getStatus() != 3) {
            exceptionLog = ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS.getMsg();
            return Result.fail(exceptionLog);
        }
        //如果密钥为空，需要验证是否为结构化目录开放的目录或者为不开发无条件共享
        if (StringUtils.isEmpty(secretKey)) {
            if (openWay == 1) {//开放
                isAccess = true;
                info.setSetId(directory.getSetId());
                info.setApiId(api.getId());
                info.setTableName(set.getTableCode());
                info.setDataFmat(2);
            } else {//不开放
                if (shareWay == 1) {//无条件共享
                    isAccess = true;
                    info.setSetId(directory.getSetId());
                    info.setApiId(api.getId());
                    info.setTableName(set.getTableCode());
                    info.setDataFmat(2);
                }
            }
        } else {
            //查询申请API的相关信息
            info = shareDataApiService.selectOpenOpiInfo(secretKey);
            if (ObjectUtils.isEmpty(info)) {
                exceptionLog = ExchangeExceptionCode.SHARE_API_SECRET_NOT_EXIST.getMsg();
                return Result.fail(exceptionLog);
            }
            callUnitId = info.getCallUnitId();
            ;
            apiId = info.getApiId();

            //验证是否过期
            Integer dateTerm = info.getDataTerm();
            if (dateTerm >= 0) {
                Date limitTime = info.getLimitTime();
                int distDay = DateUtils.compareDate(limitTime, new Date());
                //如果小于0,表示已经失效
                if (distDay < 0) {
                    exceptionLog = ExchangeExceptionCode.SHARE_API_APPLY_OVERDUE.getMsg();
                    saveCallInfo(apiId, callUnitId, 0, exceptionLog, 2, ipAddr, acceDate, null, 2);
                    return Result.fail(exceptionLog);
                }
            }

            if (ObjectUtils.isEmpty(info.getApiId())) {
                exceptionLog = ExchangeExceptionCode.SHARE_API_NOT_EXIST.getMsg();
                saveCallInfo(apiId, callUnitId, 0, exceptionLog, 2, ipAddr, acceDate, null, 2);
                return Result.fail(exceptionLog);
            }

            if (ObjectUtils.isEmpty(info.getSetId())) {
                exceptionLog = ExchangeExceptionCode.SHARE_SET_NOT_EXIST.getMsg();
                saveCallInfo(apiId, callUnitId, 0, exceptionLog, 2, ipAddr, acceDate, null, 2);
                return Result.fail(exceptionLog);
            }
            isAccess = true;
        }

        try {
            if (!isAccess) {
                exceptionLog = ExchangeExceptionCode.API_NO_AUTH.getMsg();
                return Result.fail(exceptionLog);
            }
            ShareDataSetWare ds = shareDataSetWareService.getById(info.getSetId());
            if (ds.getSetType() == 3) {
                return Result.success(apiDataDescManager.queryDataByAPIId(apiId).getData());
            }

            if (ObjectUtils.isEmpty(info.getTableName())) {
                exceptionLog = ExchangeExceptionCode.SELECT_TABLE_NOT_EXIST.getMsg();
                saveCallInfo(apiId, callUnitId, 0, exceptionLog, 2, ipAddr, acceDate, null, 2);
                return Result.fail(exceptionLog);
            }
            //查询API查询字段
            List<FiledSelectDO> selectList = shareDataApiElementService.querySelectFiled(info.getApiId());
            if (ObjectUtils.isEmpty(selectList)) {
                exceptionLog = ExchangeExceptionCode.SHARE_SET_NOT_EXIST.getMsg();
                saveCallInfo(apiId, callUnitId, 0, exceptionLog, 2, ipAddr, acceDate, null, 2);
                return Result.fail(exceptionLog);
            }

            //查找API过滤字段
            List<FiledFilterDO> filterList = shareDataApiFilterService.queryFilterFiled(info.getApiId());
            String andSql = " AND 1=1 ";
            if (!filterList.isEmpty()) {
                for (FiledFilterDO filterFiled : filterList) {
                    Integer rule = filterFiled.getScrRule();
                    String value = filterFiled.getScrValue();
                    if (!ObjectUtils.isEmpty(rule) && !StringUtils.isEmpty(value)) {
                        String operator = "";
                        switch (rule) {
                            case 1:
                                operator = " > '" + value + "'";
                                break;
                            case 2:
                                operator = " < '" + value + "'";
                                break;
                            case 3:
                                operator = " = '" + value + "'";
                                break;
                            case 4:
                                operator = " LIKE '%" + value + "%'";
                                break;
                            default:
                                operator = " = '" + value + "'";

                        }
                        andSql += " AND " + filterFiled.getSelectName() + " " + operator;
                    }
                }
            }
            //找到数据集
            ShareDataSetWare shareDataSet = shareDataSetWareService.getById(ds.getId());
            if (ObjectUtils.isEmpty(shareDataSet)) {
                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
            }else {
                if (shareDataSet.getSetType() != 4) {
                    BizAssert.fail(ExchangeExceptionCode.DATA_SET_IS_NOT_DATABASE);
                }
                //状态:1，审批中；2，驳回；3，已上架；4，已下架,只有已经上架的才能查询数据
                if (shareDataSet.getStatus() != 3) {
                    BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS);
                }
            }


            //找到对应的目录字段
            Map<String, ShareDataSetElementWare> shareDataSetElements = shareDataSetElementWareService.getShareDataSetElementBySetId(shareDataSet.getId());
            ArrayList<ShareDataSetElementWare> shareDataSetElementWaresList = new ArrayList<>();

            ShareDataApiElementExample sdaExample = new ShareDataApiElementExample();
            ShareDataApiElementExample.Criteria sdaExampleCriteria = sdaExample.createCriteria();
            sdaExampleCriteria.andApiIdEqualTo(apiId);
            List<ShareDataApiElement> shareDataApiElements = shareDataApiElementService.find(sdaExample);
            List<ShareDataElementWare> shareDataElements = new ArrayList<>();
            for (ShareDataApiElement sda : shareDataApiElements) {
                ShareDataElementWare dataElement = dataElementWareService.getById(sda.getFieldId());
                if (dataElement != null && !StringUtils.isEmpty(dataElement.getSetField())) {
                    shareDataElements.add(dataElement);
                    ShareDataSetElementWare shareDataSetElementWare = shareDataSetElements.get(dataElement.getSetField());
                    if (!ObjectUtils.isEmpty(shareDataSetElementWare)) {
                        shareDataSetElementWaresList.add(shareDataSetElementWare);
                    }
                }
            }


            //获取查询sql
            String querySql = getQuerySQL(shareDataSet, shareDataElements) + andSql;
            if (!ObjectUtils.isEmpty(updateTime)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                  String updateTime1 = sdf.format(DateUtils.getDate(updateTime));
                  querySql += "AND synctime>='"+updateTime1+"'";
                }catch (RuntimeException e){
                    return Result.fail(ExchangeExceptionCode.DATE_FORMAT_ERROR.getMsg());
                }

            }
            querySql += " ORDER BY key_id DESC";

            //获取查询数据
            List<Object> objectList = dataBaseDescManager.executeLocalQuery(querySql, pageNo, pageSize);
            ApiQueryDataDTO dataResDTO = new ApiQueryDataDTO();
            dataResDTO.setRowData(objectList);
            dataResDTO.setFileds(dozerUtils.mapList(shareDataSetElementWaresList, DataSetElementDTO.class));
            //保存调用记录
            Integer size = 0;
            String objStr = "";
            if (!ObjectUtils.isEmpty(objectList)){
                size =objectList.size();
                objStr = objectList.toString();
            }
            saveCallInfo(apiId, callUnitId, size, objStr, null, ipAddr, acceDate, null, 1);
            //返回结果
            return Result.success(dataResDTO);
        } catch (Exception e) {
            saveCallInfo(apiId, callUnitId, 0, e.getMessage(), 1, ipAddr, acceDate, null, 2);
            log.error(e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }




    private String getQuerySQL(ShareDataSetWare
                                       shareDataSet, List<ShareDataElementWare> setElements) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        for (int i = 0; i < setElements.size(); i++) {
            ShareDataElementWare sd = setElements.get(i);
            String setField = sd.getSetField();
            sb.append(" " + setField + " ");
            if (i < setElements.size() - 1) {
                sb.append(",");
            }
        }
        sb.append(" FROM ");
        sb.append(shareDataSet.getFormalTableCode());

        sb.append(" WHERE 1=1 ");
        return sb.toString();
    }


    public static Document getDocument(Object b) {
        Document document = DocumentHelper.createDocument();
        try {
            // 创建根节点元素
            Element root = document.addElement(b.getClass().getSimpleName());
            Field[] field = b.getClass().getDeclaredFields(); // 获取实体类b的所有属性，返回Field数组
            for (int j = 0; j < field.length; j++) { // 遍历所有有属性
                String name = field[j].getName(); // 获取属属性的名字
                if (!"serialVersionUID".equals(name)) {//去除串行化序列属性
                    String methodName = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    Method m = b.getClass().getMethod("get" + methodName);
                    String propertievalue = (String) m.invoke(b);// 获取属性值
                    Element propertie = root.addElement(name);
                    if (propertievalue == null) {
                        propertie.setText("");
                    } else {
                        propertie.setText(propertievalue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return document;
    }


    /**
     * 描述：获取外部调用所有API
     * 参数：secretKey
     * 返回值： PageInfo<ApiOpenDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/7/4
     * 修改内容：
     */
    @ApiOperation(value = "获取外部调用所有API", notes = "获取外部调用所有API")
    @RequestMapping(value = "/getAllUserApi", method = RequestMethod.POST)
    @Override
    @IgnoreToken
    public Result<PageInfo<ApiOpenDto>> getAllUserApi(@RequestBody OpenApiReq openApiReq) {

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<AllUserApiDO> list = shareDataApiUserService.queryAllUserApi();
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ApiOpenDto.class)));
    }

    /**
     * 描述：根据用户Id查询可调用的API
     * 参数：secretKey
     * 返回值： PageInfo<ApiOpenDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/7/4
     * 修改内容：
     */
    @ApiOperation(value = "根据用户Id查询可调用的API", notes = "根据用户Id查询可调用的API")
    @RequestMapping(value = "/getApiByUserId", method = RequestMethod.POST)
    @Override
    @IgnoreToken
    public Result<PageInfo<Long>> getApiByUserId(@RequestBody OpenApiReq<ApiCallDto> openApiReq) {
        List<Long> ids = new ArrayList<>();
        String unitId;
        Long userId = openApiReq.getData().getUserId();
        Map<String, Object> map = new HashMap<>();
        if (userId != null) {
            unitId = commonService.getOrgIdByUserId(userId);
            map.put("unitId", unitId);
            map.put("apiName", openApiReq.getData().getApiName());
            ids = shareDataApiUserService.getApiByUserId(map);
        }
        return Result.success(new PageInfo<>(ids));
    }


    private Connection getConnection(Long setId) throws Exception {
        return dataBaseDescManager.getConnection(setId);
    }


    /**
     * 描述：保存调用信息
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/5/9
     * 修改内容：
     */
    public void saveCallInfo(Long apiId, String unitId, Integer dataCount, String failLog,
                             Integer failType, String ipAddr, Date accesDate, String resutl,
                             Integer isSuccess) {
        Date respDate = new Date();
        ShareDataApiCall shareDataApiCall = new ShareDataApiCall();
        shareDataApiCall.setApiId(apiId);
        shareDataApiCall.setDataCount(dataCount);
        shareDataApiCall.setFailLog(failLog);
        shareDataApiCall.setFailType(failType);
        Float distMesc = DateUtils.getFloatDistMsec(accesDate, respDate);
        shareDataApiCall.setRsponseTime(distMesc);
        shareDataApiCall.setResult(resutl);
        shareDataApiCall.setIpAddress(ipAddr);
        shareDataApiCall.setUnitId(unitId);
        if (isSuccess == 2) {
            shareDataApiCall.setHdleState(2);
        }
        shareDataApiCall.setIsSuccess(isSuccess);
        shareDataApiCall.setVisitTime(accesDate);
        shareDataApiCallService.saveSelective(shareDataApiCall);
    }

    public String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.contains(",")) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


    /**
     * 描述：查询企业组织数据，用于演示
     * 参数：secretKey
     * 返回值：List<Map<String,Object>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @ApiOperation(value = "查询企业组织数据，用于演示", notes = "查询企业组织数据，用于演示")
    @ApiResponses({
    })
    @CrossOrigin("*")
    @IgnoreAppToken
    @RequestMapping(value = {"/findbusinfo/list"}, method = RequestMethod.GET)
    public Result<PageInfo<BusInfoDO>> findBusInfo( HttpServletRequest request, @RequestParam(value = "unitName",required = false) String unitName,
                                                     @RequestParam(value = "creditCode",required = false) String creditCode,
                                                     @RequestParam(value = "legalRepresentative",required = false) String legalRepresentative,
                                                     @RequestParam(value = "pageNo",required = false)Integer pageNo,
                                                     @RequestParam(value = "pageSize",required = false)Integer pageSize
                                     ) {
        Map<String,Object> param = new HashMap<>();
        param.put("unitName",unitName);
        param.put("creditCode",creditCode);
        param.put("legalRepresentative",legalRepresentative);
        PageHelper.startPage(pageNo, pageSize);
        List list =  commonService.selectBusInfoList(param);
        String ipAddr = getIpAddr(request);
        //保存调用记录
        Integer size = 0;
        String objStr = "";
        if (!ObjectUtils.isEmpty(list)){
            size =list.size();
            objStr = list.toString();
        }
        saveCallInfo(640991348937204833L,"280821267521",size,"",null,ipAddr,new Date(),objStr,1);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list,BusInfoDO.class)));
    }


    /**
     * 描述：查询企业组织数据详细信息，用于演示
     * 参数：secretKey
     * 返回值：List<Map<String,Object>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @ApiOperation(value = "查询企业组织数据详细信息，用于演示", notes = "查询企业组织数据详细信息，用于演示")
    @ApiResponses({
    })
    @CrossOrigin("*")
    @IgnoreAppToken
    @RequestMapping(value = {"/findbusinfo/detail"}, method = RequestMethod.GET)
    public Result<BusInfoDetailDO> detail(
                                                    @RequestParam(value = "id",required = true) String id
    ) {
        BusInfoDetailDO detail = commonService.selectBusInfoDetail(id);
        return Result.success(detail);
    }
}
