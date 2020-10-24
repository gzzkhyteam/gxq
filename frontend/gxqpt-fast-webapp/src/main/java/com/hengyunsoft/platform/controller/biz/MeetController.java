package com.hengyunsoft.platform.controller.biz;/**
 * Created by Administrator on 2018/5/9.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author madb
 * @create 2018/05/09
 * @desc 会议管理controller
 **/

@Controller
@RequestMapping("/fast/{appId}/meet")
public class MeetController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@PathVariable String appId, ModelMap map) {
        map.put("createMeet", 1);
        map.put("approveMeet", 1);
        map.put("appId", appId);
        return "fast/meet/list";
    }

    /**
     * 新增
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@PathVariable String appId, ModelMap map) {
        map.put("appId", appId);
        return "fast/meet/create";
    }

    /**
     * 取消会议
     * */
    @RequestMapping(value = "cancel", method = RequestMethod.GET)
    public String cancel(@PathVariable String appId, Long id, ModelMap map) {
        map.put("appId", appId);
        map.put("id_", String.valueOf(id));
        return "fast/meet/cancel";
    }

    /**
     * 参会处理
     */
    @RequestMapping("deal")
    public String deal(@PathVariable String appId, Long id, ModelMap map) {
        map.put("appId", appId);
        map.put("id_", String.valueOf(id));
        return "fast/meet/deal";
    }

    /**
     * 阅览
     */
    @RequestMapping("view")
    public String view(@PathVariable String appId, Long id, ModelMap map) {
        map.put("appId", appId);
        map.put("id_", String.valueOf(id));
        return "fast/meet/view";
    }


}
