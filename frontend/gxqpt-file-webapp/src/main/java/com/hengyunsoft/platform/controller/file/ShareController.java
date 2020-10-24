package com.hengyunsoft.platform.controller.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping
public class ShareController {
    /** token超时时间 */
    private final static int EXPIRE_SECONDS = 24 * 3600;

    @RequestMapping(value = "/no/sharefile/{id}")
    public String list(@PathVariable String id, String ticket, ModelMap modelMap,HttpServletResponse response) {
        modelMap.put("id", id);
        modelMap.put("ticket", ticket);
        return "file/sharefile/index";
    }

    @RequestMapping("/no/sharefile/subdirectory")
    public String shareSubdirectory(String id, String folderName,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("folderName", folderName);
        return "file/sharefile/subdirectory";
    }
    @RequestMapping("/no/sharefile/passwordTag")
    public String passwordTag(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "file/sharefile/passwordTag";
    }
    @RequestMapping("/sharefile/saveShare")
    public String saveShare(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "file/sharefile/subdirectory";
    }
}
