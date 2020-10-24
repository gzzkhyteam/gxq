package com.hengyunsoft.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/module")
public class ModuleController {

    /**
     * 所有系统的首页地址统一放在module/index
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/{path}")
    public String index(@PathVariable("path") String path ) {
        return "module/"+path;
    }
    
    @RequestMapping("/v2/{path}")
    public String v2(@PathVariable("path") String path ) {
    	return "v2/module/"+path;
    }
    @RequestMapping("/v3/{path}")
    public String v3(@PathVariable("path") String path ) {
        return "v3/module/"+path;
    }
}
