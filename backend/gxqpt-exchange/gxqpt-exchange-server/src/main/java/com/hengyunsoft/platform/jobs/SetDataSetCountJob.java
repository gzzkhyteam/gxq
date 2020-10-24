package com.hengyunsoft.platform.jobs;

import com.github.pagehelper.PageHelper;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.mybatis.annotation.IgnoreTx;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSetWare;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetWareExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetWareService;
import com.hengyunsoft.platform.exchange.utils.DataBaseSql;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/***
 * 设置数据集数据库类型的数据量的JOB
 */
@Component
@Slf4j
@IgnoreTx
public class SetDataSetCountJob {
    @Autowired
    private ShareDataSetWareService shareDataSetWareService;
    @Autowired
    private ShareDataSetService  shareDataSetService;
    @Autowired
    private DozerUtils dozerUtils;

    @Scheduled(cron = "0 0 2 * * ?")//每天晚上凌晨2点执行
    //@Scheduled(initialDelay = 10000, fixedRate = 5000000)
    public void saveRunDataSetCount() {
        log.info("{}开始执行共享交换根据数据集数据集条数JOB", LocalDateTime.now());
        int nowPage = 1;
        int pageSize = 100;
        List<ShareDataSetWare> shareDataSetWares = pageShareDataSetWare(nowPage, pageSize);
        while (shareDataSetWares.size() > 0) {
            Connection connection = DataBaseSql.getConnection();
            try {
                connection.setAutoCommit(false);
                List<ShareDataSetWare>  updates = new ArrayList<>();
                for (ShareDataSetWare sdsw : shareDataSetWares) {
                    try {
                        String formalTableCode = sdsw.getFormalTableCode();
                        if (StringUtils.isEmpty(formalTableCode)) {
                            continue;
                        }
                        String coutSql = "SELECT COUNT(*) FROM  " + formalTableCode;
                        PreparedStatement ps = connection.prepareStatement(coutSql);
                        ResultSet rs = ps.executeQuery();
                        rs.next();
                        int anInt = rs.getInt(1);
                        ps.close();
                        sdsw.setDataCount(new Float(anInt));

                        updates.add(sdsw);
                    } catch (Exception e) {
                        log.error("统计数据集数据量job报错，数据集id：{},数据集名称：{}", sdsw.getId(), sdsw.getSetName());
                    }
                }
                shareDataSetWareService.updateByIdSelective(updates);
                List<ShareDataSet> shareDataSets = dozerUtils.mapList(updates, ShareDataSet.class);
                shareDataSetService.updateByIdSelective(shareDataSets);
                connection.commit();
                nowPage++;
                shareDataSetWares = pageShareDataSetWare(nowPage, pageSize);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }

        }
        log.info("{}执行共享交换根据数据集数据集条数JOB结束", LocalDateTime.now());
    }

    private List<ShareDataSetWare> pageShareDataSetWare(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        ShareDataSetWareExample example = new ShareDataSetWareExample();
        example.createCriteria().andSetTypeEqualTo(4);
        List<ShareDataSetWare> list = shareDataSetWareService.find(example);
        return list;

    }
}
