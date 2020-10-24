package com.hengyunsoft.platform.supervise.util;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ANSJ分词工具类
 * @author sxy
 * @date 2018-07-10
 */
public class TokenizerUtil {

    /**
     * 返回关键词数量
     */
    private final static int KEY_WORDS_NUM = 10;

    public static List<Map<String,Object>> getSegWords(String str){
        List<Map<String,Object>> keyWords = new ArrayList<Map<String,Object>>();
        KeyWordComputer kwc = new KeyWordComputer(KEY_WORDS_NUM);
        List<Keyword> result = kwc.computeArticleTfidf(str);
        for (Keyword key:result) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(key.getName(),key.getScore());
            keyWords.add(map);
        }
        return keyWords;
    }
}
