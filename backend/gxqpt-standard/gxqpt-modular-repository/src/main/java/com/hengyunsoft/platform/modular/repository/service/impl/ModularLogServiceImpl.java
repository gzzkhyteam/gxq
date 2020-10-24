package com.hengyunsoft.platform.modular.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularAnalysisCategoryTopDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDownloadNumDO;
import com.hengyunsoft.platform.modular.entity.modular.po.ModularLog;
import com.hengyunsoft.platform.modular.repository.modular.dao.ModularLogMapper;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularLogExample;
import com.hengyunsoft.platform.modular.repository.service.ModularLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author wangs
 * @createTime 2018-4-03
 */
@Service
@Slf4j
public class ModularLogServiceImpl extends BaseAllServiceImpl<Long, ModularLog, ModularLogExample> implements ModularLogService {

    @Autowired
    private ModularLogMapper modularLogMapper;

    @Override
    protected BaseNormalDao<Long, ModularLog, ModularLogExample> getDao() {
        return modularLogMapper;
    }

    /**
     * 解析日志文件并入库
     *
     * @param fileName：文件路径
     * @author zx
     */
    @SuppressWarnings("unchecked")
    public void parseLogFile(String fileName) {
        if (fileName == null) {
            log.warn("fileName为空，不做解析操作");
            return;
        }
        File f = new File(fileName);
        if (!f.exists()) {
            log.warn("文件不存在，请检查：" + fileName);
            return;
        }
        if (!f.isFile()) {
            log.warn(fileName + "不是一个文件，请检查");
            return;
        }
        @SuppressWarnings("rawtypes")
        ArrayList<ModularLog> fileContent = new ArrayList();
        int count = 0;
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(f), "utf8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] x = line.split(" ");
                if (x.length < 8) {
                    log.debug("行数据格式不符合要求：" + line);
                    continue;
                }
                //127.0.0.1 - - [19/四月/2018:13:48:19 +0800] "GET /repository/zkx/qqqqq/qqqqq/1.0/qqqqq-1.0-doc.jar HTTP/1.1" 200 41733 3530 "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0"
                //[02/八月/2018:17:42:28 +0800] "GET /repository/maven-releases/LMSGroupId002x/LMSArtifactId002/1.8/LMSArtifactId002-1.8.jar HTTP/1.0" 200 423560 7 "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36"
                if (!x[5].equals("\"GET")) {
                    continue;
                }
                if (!x[6].endsWith(".jar")) {
                    continue;
                }
                if (!x[8].equals("200") && !x[8].equals("304")) {
                    continue;
                }
                String repName = "";
                String artifactId = "";
                String groupId = "";
                String classify = "";
                String version = "";
                Date time = new Date();
                time = parseLogTime(x[3]);//解析日志时间
                log.debug("解析的日志下载时的时间:" + time);
                String[] process = x[6].split("/");
                //获取版本号
                version = process[process.length - 2];
                //获取文件中的仓库名
                repName = process[2];
                //获取classify
                String[] processSub = process[process.length - 1].split("-");
                if (processSub.length > 2) {
                    classify = processSub[processSub.length - 1].substring(0, processSub[processSub.length - 1].length() - 4);
                    classify = getClassify(classify);
                }
                //获取artifactid
                artifactId = process[process.length - 3];
                //获取groupid
                for (int i = 3; i < process.length - 3; i++) {
                    groupId += process[i] + ".";
                }
                if (groupId.equals("")) {
                    log.info("数据无效，未解析出groupId:" + line);
                    continue;
                }
                groupId = groupId.substring(0, groupId.length() - 1).trim();
                ModularLog modularLog = new ModularLog();
                modularLog.setRepName(repName);
                modularLog.setGroupId(groupId);
                modularLog.setArtifactId(artifactId);
                modularLog.setVersion(version);
                modularLog.setIp(x[0]);
                modularLog.setFileSize(Integer.parseInt(x[9]));
                modularLog.setTimeConsume(Integer.parseInt(x[10]));
                if (!classify.equals("")) {
                    modularLog.setClassifier(classify);
                }
                modularLog.setCreateTime(time);///取日志中的时间
                fileContent.add(modularLog);
                //每1000条数据一提交
                if (fileContent.size() > 1000) {
                    log.info("已解析1000条，保存日志数据");
                    save(fileContent);
                    fileContent.clear();
                }
                count = count + 1;
            }
            //封装对象
            read.close();
            save(fileContent);
            log.info("nexus日志解析：" + fileName + "解析完成:" + count);
            modularLogMapper.updateModularId();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析并提取日志时间windows
     *
     * @param strtime 时间
     * @throws ParseException
     * @author zx
     */
    @SuppressWarnings("unused")
    private Date parseLogTimeWindows(String strtime) throws ParseException {
        String month = "";
        String[] x = strtime.split("/");
        String day = x[0].substring(1, x[0].length());
        switch (x[1]) {
            case "一月":
                month = "1月";
                break;
            case "二月":
                month = "2月";
                break;
            case "三月":
                month = "3月";
                break;
            case "四月":
                month = "4月";
                break;
            case "五月":
                month = "5月";
                break;
            case "六月":
                month = "6月";
                break;
            case "七月":
                month = "7月";
                break;
            case "八月":
                month = "8月";
                break;
            case "九月":
                month = "9月";
                break;
            case "十月":
                month = "10月";
                break;
            case "十一月":
                month = "11月";
                break;
            case "十二月":
                month = "12月";
                break;
            default:
                break;
        }
        strtime = day + "/" + month + "/" + x[2];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M月/yyyy:HH:mm:ss");
        Date date = sdf.parse(strtime);
        return date;
    }

    /**
     * 解析并提取日志时间linux系统
     *
     * @param strtime 时间
     * @throws ParseException
     * @author zx
     */
    @SuppressWarnings("unused")
    private Date parseLogTimeLinux(String strtime) throws ParseException {
        strtime = strtime.substring(1, strtime.length());
        SimpleDateFormat sdfl = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
        Date datel = sdfl.parse(strtime);
        return datel;
    }

    /**
     * 解析并提取日志时间
     *
     * @param strtime 时间
     * @throws ParseException
     * @author zx
     */
    private Date parseLogTime(String strtime) throws ParseException {
        strtime = strtime.substring(1, strtime.length());
        SimpleDateFormat sdfl = new SimpleDateFormat("yyyy/MM/dd:HH:mm:ss", Locale.ENGLISH);
        Date datel = sdfl.parse(strtime);
        return datel;
    }

    /**
     * 获取classify的值
     */
    private String getClassify(String classify) {
        if (!classify.equals("sources") && !classify.equals("help") && !classify.equals("doc")) {
            classify = "";
        }
        return classify;
    }

    /**
     * 下载量最多的CategoryTop10
     */
    @Override
    public List<ModularAnalysisCategoryTopDO> findCategoryDownTop10() {
        return modularLogMapper.findCategoryDownTop10();
    }

    /**
     * 使用量最多的模块Top10
     */
    @Override
    public List<ModularDO> findModularDownTop10() {
        return modularLogMapper.findModularDownTop10();
    }

    /**
     * 模块下载top20
     */
    @Override
    public List<ModularDownloadNumDO> getModularDownloadTop20() {
        return modularLogMapper.getModularDownloadTop20();
    }

    /**
     * 模块使用量
     *
     * @return
     */
    @Override
    public Integer getModularUsedNum() {
        return modularLogMapper.getModularUsedNum();
    }

    /**
     * 本月模块使用量
     *
     * @return
     */
    @Override
    public Integer getMonthModularUsedNum(Date date) {
        return modularLogMapper.getMonthModularUsedNum(date);
    }

    /**
     * 模块使用率
     *
     * @return
     */
    @Override
    public Integer getModularUsedRate() {
        return modularLogMapper.getModularUsedRate();
    }

    /**
     * 本月模块使用率
     *
     * @return
     */
    @Override
    public Integer getMonthModularUsedRate(Date date) {
        return modularLogMapper.getMonthModularUsedRate(date);
    }

    @Override
    public Integer getModularRatioSum(List<Long> idList, Date startDate, Date endDate) {
//        Long[] longs = new Long[idList.size()];
        Map<String, Object> map = new HashMap<>();
//        map.put("idLists",idList.toArray(longs));
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        return modularLogMapper.getModularRatioSum(map);
    }

}
