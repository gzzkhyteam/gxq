package com.hengyunsoft.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/collection")
public class CollectionController {
    //体系管理页面
    @RequestMapping("/colleactionList")
    public String systemList(ModelMap model) {
        return "collection_manager/list";
    }

    //体系管理页面
    @RequestMapping("/query")
    public String query(ModelMap model) {
        return "collection_manager/query";
    }
    //关键字分析
    @RequestMapping("/analysis")
    public String analysis(ModelMap model) {
        return "collection_manager/analysis";
    }
}
