package com.hengyunsoft.platform.piping.open;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.servicemodule.annotation.WeiboSendModule;
import com.hengyunsoft.platform.piping.api.msgs.dto.BlogSendDTO;
import com.hengyunsoft.platform.piping.api.msgs.dto.BlogSendToPipingDTO;
import com.hengyunsoft.platform.piping.constant.MessageConstant;
import com.hengyunsoft.platform.piping.utils.JSONUtils;
import com.hengyunsoft.platform.piping.utils.LongUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "微博消息发送服务", description = "微博消息发送服务")
@WeiboSendModule
public class BlogSendApiImpl implements BlogSendApi {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    @ApiOperation(value = "微博消息发送服务", notes = "微博消息发送服务")
    @ApiResponses({
            @ApiResponse(code = 2, message = "应用程序id不能为空"),
            @ApiResponse(code = 3, message = "应用程序名称不能为空"),
            @ApiResponse(code = 4, message = "发送渠道不能为空"),
            @ApiResponse(code = 5, message = "发布内容不能为空"),
            @ApiResponse(code = 6, message = "发布内容字数超限"),
            @ApiResponse(code = 7, message = "发布内容必须含有一个网址"),
            @ApiResponse(code = 8, message = "发送失败"),
            @ApiResponse(code = 13, message = "发送时间格式不正确")
    })
    public Result<String> send(BlogSendDTO blogSendDTO) {
        try {
            String appid = blogSendDTO.getAppId();
            String appName = blogSendDTO.getAppName();
            String channelid = blogSendDTO.getChannelId();
            String context = blogSendDTO.getImgText();
            if (StringUtils.isEmpty(appid)) {
                return Result.fail(2, "应用程序id不能为空");
            }
            if (StringUtils.isEmpty(appName)) {
                return Result.fail(3, "应用程序名称不能为空");
            }
            if (StringUtils.isEmpty(channelid)) {
                return Result.fail(4, "发送渠道不能为空");
            }
            if (StringUtils.isEmpty(context)) {
                return Result.fail(5, "发布内容不能为空");
            }
            if (context.length() > 140) {
                return Result.fail(6, "发布内容字数超限");
            }
            String http_reg = "(?i)(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&amp;%\\$\\-]+)*@)*"
                    + "((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]"
                    + "|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}"
                    + "|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost"
                    + "|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum"
                    + "|[a-zA-Z]{2}))(\\:[0-9]+)*(/($|[a-zA-Z0-9\\.\\,\\?\\'\\\\\\+&amp;%\\$#\\=~_\\-]+))(?i)";
            Matcher m = Pattern.compile(http_reg).matcher(context);
            List<String> urlList = new ArrayList<String>();
            while (m.find()) {
                urlList.add(m.group());
            }
            if (urlList.size() == 0) {
                return Result.fail(7, "发布内容必须含有一个网址");
            }
            if (!StringUtils.isEmpty(blogSendDTO.getStartTime())) {
                String reg = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|"
                        + "((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|"
                        + "((0[48]|[2468][048]|[3579][26])00))-02-29))\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
                boolean isMatch = Pattern.matches(reg, blogSendDTO.getStartTime());
                if (!isMatch) {
                    return Result.fail(13, "发送时间格式不正确");
                }
            }
            long num = LongUtil.random();
            String msgid = String.valueOf(num);
            BlogSendToPipingDTO blogSendToPipingDTO = new BlogSendToPipingDTO();
            blogSendToPipingDTO.setAppId(appid);
            blogSendToPipingDTO.setAppName(appName);
            blogSendToPipingDTO.setChannelId(channelid);
            blogSendToPipingDTO.setDraft(0);
            blogSendToPipingDTO.setFileUrl(blogSendDTO.getFileUrl());
            blogSendToPipingDTO.setImgText(context);
            blogSendToPipingDTO.setMsgId(msgid);
            blogSendToPipingDTO.setSender("123456");
            blogSendToPipingDTO.setSenderName("其他系统");
            blogSendToPipingDTO.setStartTime(blogSendDTO.getStartTime());
            String message = JSONUtils.toJSON(blogSendToPipingDTO);
            rabbitTemplate.convertAndSend(keyPrefix + MessageConstant.BLOG_MESSAGE_CHANNEL, message);
            return Result.success(msgid);
        } catch (Exception e) {
            return Result.fail(8, "发送失败");
        }
    }

}
