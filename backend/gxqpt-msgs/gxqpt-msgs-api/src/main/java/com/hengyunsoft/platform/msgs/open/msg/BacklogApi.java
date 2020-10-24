//package com.hengyunsoft.platform.msgs.open.msg;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//
////@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
////        fallback= BacklogApiHystrix.class)
//public interface BacklogApi {
//    /**
//     * 获取更多待办事项数据
//     *
//     * @return
//     */
//    @RequestMapping(value = "/p/backlog/page", method = RequestMethod.POST)
//    Result<PageInfo<BacklogDTO>> pageMoreBacklogList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq);
//
//    /**
//     * 新增待办事项数据
//     *
//     * @return
//     */
//    @RequestMapping(value = "/p/backlog/add", method = RequestMethod.POST)
//    Result<BacklogDTO> addBacklog(@RequestBody BacklogSaveDTO backlogSaveDTO);
//
//    /**
//     * 删除待办事项数据
//     *
//     * @return
//     */
//    @RequestMapping(value = "/p/backlog/delete", method = RequestMethod.POST)
//    Result<Boolean> deleteBacklog(@RequestParam(value = "id") Long id);
//
//    /**
//     * 修改待办事项数据
//     *
//     * @return
//     */
//    @RequestMapping(value = "/p/backlog/update", method = RequestMethod.POST)
//    Result<Boolean> updateBacklog(@RequestBody BacklogUpdateDTO backlogUpdateDTO);
//
//    /**
//     * 修改待办事项未读状态
//     *
//     * @return
//     */
//    @RequestMapping(value = "/p/backlog/status", method = RequestMethod.POST)
//    Result<Boolean> updateBacklogStatus(@RequestParam(value = "id") Long id);
//}
