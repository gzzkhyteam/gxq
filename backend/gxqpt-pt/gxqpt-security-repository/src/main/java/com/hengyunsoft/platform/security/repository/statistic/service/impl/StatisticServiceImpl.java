package com.hengyunsoft.platform.security.repository.statistic.service.impl;

import com.hengyunsoft.platform.security.entity.statistic.po.StatisticResultDTO;
import com.hengyunsoft.platform.security.repository.statistic.dao.StatisticMapper;
import com.hengyunsoft.platform.security.repository.statistic.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticMapper statisticMapper;
    @Override
    public Map<String, String> statisticInterfaceConfig() {
        return statisticMapper.statisticInterfaceConfig();
    }

    @Override
    public Map<String, String> statisticExceptionProcess() {
        return statisticMapper.statisticExceptionProcess();
    }

    @Override
    public Map<String, String> statisticExceptionServer() {
        return statisticMapper.statisticExceptionServer();
    }

    @Override
    public List<Map<String, String>> statisticInterfaceExecuteTop10() {
        return statisticMapper.statisticInterfaceExecuteTop10();
    }

    @Override
    public List<StatisticResultDTO> statisticExceptionServerIn7days() {
        List<StatisticResultDTO> result = new ArrayList<>(7);
        StatisticResultDTO item = null;
        for(int i = 7;i > 0;i--){
            item = statisticMapper.statisticExceptionServerIntervalToToday(i);
            result.add(item);
        }
        return result;
    }

    @Override
    public List<StatisticResultDTO> statisticExceptionProcessIn7days() {
        List<StatisticResultDTO> result = new ArrayList<>(7);
        StatisticResultDTO item = null;
        for(int i = 7;i > 0;i--){
            item = statisticMapper.statisticExceptionProcessIntervalToToday(i);
            result.add(item);
        }
        return result;
    }

    @Override
    public Map<String, String> statisticAllBackupsAndYesterday() {
        return statisticMapper.statisticAllBackupsAndYesterday();
    }

}
