package com.hengyunsoft.platform.controller.biz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fast/attence")
public class AttenceController {


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create( ModelMap map) {

        return "fast/attence/create";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap map) {

        return "fast/attence/list";
    }

    @RequestMapping(value = "myattence", method = RequestMethod.GET)
    public String myattence(ModelMap map) {

        return "fast/attence/myattence";
    }
    /**
     * 打卡记录
     */
    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String history(ModelMap map) {

        return "fast/attence/history";
    }
    /**
     * 打卡记录详情
     */
    @RequestMapping(value = "historyDetail", method = RequestMethod.GET)
    public String historyDetail(String id,ModelMap map) {
        map.addAttribute("id",id);
        return "fast/attence/historyDetail";
    }
}
