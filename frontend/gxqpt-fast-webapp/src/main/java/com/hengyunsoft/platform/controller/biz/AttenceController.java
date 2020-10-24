package com.hengyunsoft.platform.controller.biz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/fast/{appId}/attence")
public class AttenceController {


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "fast/attence/create";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "fast/attence/list";
    }

    @RequestMapping(value = "myattence", method = RequestMethod.GET)
    public String myattence(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "fast/attence/myattence";
    }
}
