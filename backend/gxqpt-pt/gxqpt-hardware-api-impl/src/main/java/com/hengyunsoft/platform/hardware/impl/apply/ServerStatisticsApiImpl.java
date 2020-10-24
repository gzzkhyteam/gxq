package com.hengyunsoft.platform.hardware.impl.apply;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.hardware.constant.ScriptEnum;
import com.hengyunsoft.platform.hardware.constant.StatisticsEnum;
import com.hengyunsoft.platform.hardware.dto.apply.ServerStatisticsMonitorDTO;
import com.hengyunsoft.platform.hardware.dto.apply.ServerStatisticsResDTO;
import com.hengyunsoft.platform.hardware.dto.apply.ServerStatisticsSaveDTO;
import com.hengyunsoft.platform.hardware.entity.apply.po.ServerStatistics;
import com.hengyunsoft.platform.hardware.entity.manage.po.ServerManage;
import com.hengyunsoft.platform.hardware.repository.apply.example.ServerStatisticsExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ServerStatisticsService;
import com.hengyunsoft.platform.hardware.repository.manage.service.ServerManageService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(value = "API - ServerStatisticsApi", description = "服务器监控统计模块")
@RestController
@RequestMapping("serverstatistics")
@Slf4j
public class ServerStatisticsApiImpl {
    @Autowired
    ServerStatisticsService statisticsService;
    @Autowired
    ServerManageService manageService;
    @Autowired
    DozerUtils dozerUtils;

    @Value("${gxqpt.hostname.gate}")
    private String hostname;
    @Value("${gxqpt.port.gate}")
    private String port;

    @IgnoreToken
    @ApiResponses({
            @ApiResponse(code = 103500, message = "serverId不能为空"),
            @ApiResponse(code = 103501, message = "产生时间不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Result<ServerStatisticsResDTO> save(ServerStatisticsSaveDTO saveDTO) {
        //验证
        BizAssert.assertNotNull(HardWareExceptionCode.STATISTICS_SERVER_ID_NULL, saveDTO.getServerId());
        BizAssert.assertNotNull(HardWareExceptionCode.STATISTICS_TIME_NULL, saveDTO.getTime());

        //查找并初始化实体
        ServerManage serverManage = new ServerManage();
        serverManage.setId(saveDTO.getServerId());
        serverManage.setCpuPercent((byte) saveDTO.getCpu());
        serverManage.setMemoryPercent((byte) saveDTO.getMem());
        serverManage.setDiskPercent((byte) saveDTO.getDisk());
        serverManage.setWideUp(saveDTO.getWideUp());
        serverManage.setWideDown(saveDTO.getWideDown());
        ServerStatistics serverStatistics = dozerUtils.map(saveDTO, ServerStatistics.class);

        //持久化
        manageService.updateByIdSelective(serverManage);
        serverStatistics = statisticsService.save(serverStatistics);
        ServerStatisticsResDTO ret = dozerUtils.map(serverStatistics, ServerStatisticsResDTO.class);

        //返回实体
        return Result.success(ret);
    }

    /**
     * 脚本模板下载
     *
     * @param str
     * @param response
     * @throws IOException
     */

    @ApiResponses({
            @ApiResponse(code = 103500, message = "serverId不能为空")
    })
    @RequestMapping(value = "/downloadScript", method = RequestMethod.GET)
    public void downloadScript(String str, HttpServletResponse response) throws IOException {
        //验证
        BizAssert.assertNotEmpty(HardWareExceptionCode.STATISTICS_SERVER_ID_NULL, str);

        //设置替换信息
        Map<String, String> mapstring = new HashMap<>();
        mapstring.put(ScriptEnum.SERVERID.getMsg(), str);
        mapstring.put(ScriptEnum.IP.getMsg(), hostname + ":" + port);

        //设置返回头
        response.setContentType("text/plain");
        String fileName = "demoscript";
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".sh");
        BufferedReader reader = null;
        BufferedOutputStream buff = null;
        StringBuffer write = new StringBuffer();
        String enter = "\n\r";
        ServletOutputStream outSTr = null;
        outSTr = response.getOutputStream();
        buff = new BufferedOutputStream(outSTr);
        //读取内容并写入返回内容
        try {
            ClassPathResource resource = new ClassPathResource("/demoscript/demoscript.sh");
            InputStream inputStream = resource.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            if (inputStream != null) {
                String temp = null;
                while ((temp = reader.readLine()) != null) {
                    for (Map.Entry<String, String> entry : mapstring.entrySet()) {
                        if (temp.indexOf("{" + entry.getKey() + "}") != -1) {
                            temp = temp.replace("{" + entry.getKey() + "}", entry.getValue());
                        }
                    }
                    write.append(temp);
                    write.append(enter);
                }
                buff.write(write.toString().getBytes("UTF-8"));
                buff.flush();
                buff.close();
            }
        } finally {
            outSTr.close();
        }
    }

    /**
     * 查看服务器各个指标监控详情
     * @param dto
     * @return
     */
    @ApiResponses({
            @ApiResponse(code = 103500, message = "serverId不能为空"),
            @ApiResponse(code = 103501, message = "产生时间不能为空"),
            @ApiResponse(code = 103502, message = "性能类型不能为空"),
    })
    @RequestMapping(value = "/findMonitorDetail", method = RequestMethod.POST)
    public Result<Map<String, List>> findMonitorDetail(@RequestBody ServerStatisticsMonitorDTO dto) {
        //验证
        BizAssert.assertNotNull(HardWareExceptionCode.STATISTICS_SERVER_ID_NULL, dto.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.STATISTICS_TIME_NULL, dto.getTime());
        BizAssert.assertNotNull(HardWareExceptionCode.STATISTICS_TYPE_NULL, dto.getType());

        //查询服务器信息
        ServerStatisticsExample example = new ServerStatisticsExample();
        example.createCriteria().andServerIdEqualTo(dto.getId()).andTimeBetween(dto.getTime(),new Date());
        example.setOrderByClause(" time ");
        List<ServerStatistics> list = statisticsService.find(example);

        //实例返回map
        Map<String, List> res = new HashMap<>();
        List times = list.stream().map(ServerStatistics::getTime).collect(Collectors.toList());

        switch (StatisticsEnum.getEnum(dto.getType())){
            case CPU:
                //获取cpu的map
                res.put(StatisticsEnum.VAL.getMsg(), list.stream().map(ServerStatistics::getCpu).collect(Collectors.toList()));
                break;
            case MEM:
                //获取mem的map
                res.put(StatisticsEnum.VAL.getMsg(), list.stream().map(ServerStatistics::getMem).collect(Collectors.toList()));
                break;
            case DIST:
                //获取dist的map
                res.put(StatisticsEnum.VAL.getMsg(), list.stream().map(ServerStatistics::getDisk).collect(Collectors.toList()));
                break;
            case WIDEUP:
                //获取wideUp的map
                res.put(StatisticsEnum.VAL.getMsg(), list.stream().map(ServerStatistics::getWideUp).collect(Collectors.toList()));
                break;
            case WIDEDOWN:
                //获取wideDown的map
                res.put(StatisticsEnum.VAL.getMsg(), list.stream().map(ServerStatistics::getWideDown).collect(Collectors.toList()));
                break;
        }
        res.put(StatisticsEnum.TIME.getMsg(), times);
        return Result.success(res);
    }
}
