package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsMessageSave", description = "消息添加对象")
public class MsgsMessageSaveDTO extends MsgsMessageBaseDTO{
    /**
     * 消息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息")
    private Long id;
    //接收页面微信类型-文本编辑器的内容中第一个图片路径，进行图文json的拼接filepath值
    //{"filepath":"http://127.0.0.1:6080/file/35kj6353/2018/04/b75ff680-ca5b-4ea0-9b88-27657471126f.png","topic":"想念","content":"<p><img src="http://127.0.0.1:6080/file/35kj6353/2018/04/b75ff680-ca5b-4ea0-9b88-27657471126f.png"/></p>“}
    private  String  weChatImg;//微信图片
    private  String  weBlogFile;//微博图片

}
