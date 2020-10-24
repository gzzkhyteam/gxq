package com.hengyunsoft.platform.mail.repository.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.platform.mail.entity.core.po.FilterKeyword;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.dao.BWListMapper;
import com.hengyunsoft.platform.mail.repository.example.BWListExample;
import com.hengyunsoft.platform.mail.repository.service.BWListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BWListServiceImpl extends BaseAllServiceImpl<Long, BWList, BWListExample> implements BWListService {

    @Autowired
    private BWListMapper bwListMapper;

    @Override
    protected BaseNormalDao<Long, BWList, BWListExample> getDao() {
        return bwListMapper;
    }

    @Override
    public List<BWList> findBWList(BWList bw){return bwListMapper.findBWList(bw);}

    @Override
    public int insertFilterKeyWord(FilterKeyword fk) {
        return bwListMapper.insertFilterKeyWord(fk);
    }

    @Override
    public int deleteFilterKeyWord(Long id) {
        return bwListMapper.deleteFilterKeyWord(id);
    }

    @Override
    public List<FilterKeyword> getFilterKeywordAll(String filterWord) {
        return bwListMapper.getFilterKeywordAll(filterWord);
    }

    //检查邮件标题及内容是否包含非法关键字
    @Override
    public String checkKeyword(String subject, String content) {
        List<FilterKeyword> filterKeywordList = bwListMapper.getFilterKeywordAll(null);
        String result = "";
        for (FilterKeyword fk : filterKeywordList){
            if(!"".equals(result)) {
                break;
            }else{
                result = subject.contains(fk.getFilterWord()) ? fk.getFilterWord() : "";
            }
        }
        if("".equals(result)){
            for (FilterKeyword fk : filterKeywordList){
                if(!"".equals(result)) {
                    break;
                }else{
                    result = content.contains(fk.getFilterWord()) ? fk.getFilterWord() : "";
                }
            }
        }
        return result;
    }

}
