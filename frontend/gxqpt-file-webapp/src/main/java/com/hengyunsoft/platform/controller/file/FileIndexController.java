package com.hengyunsoft.platform.controller.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/file")
public class FileIndexController {
    //@Autowired
    //private SwfApi swfApi;

    @RequestMapping("/swf")
    public String swf(Long id,ModelMap model) {
        //Result<FileSwfDTO> result = swfApi.toSwf(id);
        //FileSwfDTO fileSwf = result.getData();
        //String swf=fileSwf.getSwf();
        //model.addAttribute("swf", swf);
        model.put("id", id);
        return "file/swf/flexpaper";
    }

    @RequestMapping("/all")
    public String all(ModelMap model) {
        return "file/all/list";
    }
    @RequestMapping("/doc")
    public String doc(ModelMap model) {
        return "file/doc/list";
    }
    @RequestMapping("/image")
    public String image(ModelMap model) {
        return "file/image/list";
    }
    @RequestMapping("/video")
    public String video(ModelMap model) {
        return "file/video/list";
    }
    @RequestMapping("/audio")
    public String audio(ModelMap model) {
        return "file/audio/list";
    }
    @RequestMapping("/other")
    public String other(ModelMap model) {
        return "file/other/list";
    }
    @RequestMapping("/recycle")
    public String recycle(ModelMap model) {
        return "file/recycle/list";
    }
    @RequestMapping("/createFile")
    public String createFile(String parentId, ModelMap model) {
        model.addAttribute("parentId", parentId);
        return "file/all/createFile";
    }
    @RequestMapping("/subdirectory")
    public String subdirectory(String folderId, String folderName, ModelMap model) {
        model.addAttribute("folderId", folderId);
        model.addAttribute("folderName", folderName);
        return "file/all/subdirectory";
    }
    @RequestMapping("/rename")
    public String rename(String id, String folderId, String folderName, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("folderId", folderId);
        model.addAttribute("folderName", folderName);
        return "file/all/rename";
    }
    @RequestMapping("/uploadFile")
    public String uploadFile(String folderId,String dataType, ModelMap model) {
        model.addAttribute("folderId", folderId);
        model.addAttribute("dataType", dataType);
        return "file/all/uploadFile";
    }
    @RequestMapping("/otherUploadFile")
    public String otherUploadFile(String folderId,String dataType, ModelMap model) {
        model.addAttribute("folderId", folderId);
        model.addAttribute("dataType", dataType);
        return "file/other/uploadFile";
    }
    @RequestMapping("/share")
    public String share(String id, String folderName,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("folderName", folderName);
        return "file/module/share";
    }
    @RequestMapping("/shareList")
    public String shareList(String id, String folderName,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("folderName", folderName);
        return "file/shareList/list";
    }
    @RequestMapping("/shareView")
    public String shareView(String id, String folderName, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("folderName", folderName);
        return "file/shareList/index";
    }
    @RequestMapping("/shareSubdirectory")
    public String shareSubdirectory(String id, String folderId, String folderName,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("folderId", folderId);
        model.addAttribute("folderName", folderName);
        return "file/shareList/subdirectory";
    }
}
