package com.hengyunsoft.platform.msgs.biz.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.biz.WeChatMessageService;
import com.hengyunsoft.platform.msgs.constant.MessageConstant;
import com.hengyunsoft.platform.msgs.dto.WeChatImgTextDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.entity.channel.po.MsgsChannel;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsBlacklist;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MsgsMessage;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageCursor;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WeChatMessageRecord;
import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WechatSendStatus;
import com.hengyunsoft.platform.msgs.repository.channel.example.MsgsChannelExample;
import com.hengyunsoft.platform.msgs.repository.channel.service.MsgsChannelService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MsgsBlacklistExample;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsBlacklistService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MsgsMessageService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageCursorService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WeChatMessageRecordService;
import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WechatSendStatusService;
import com.hengyunsoft.platform.msgs.utils.FileSendUtil;
import com.hengyunsoft.platform.msgs.utils.HttpClientEx;
import com.hengyunsoft.platform.msgs.utils.JSONUtils;
import com.hengyunsoft.platform.msgs.utils.RedisUtils;
import com.hengyunsoft.platform.msgs.utils.Util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信消息服务
 *
 * @author dxz
 */
@Component
@Slf4j
public class WeChatMessageServiceImpl implements WeChatMessageService {

    @Value("${weixin.default.img}")
    private String weixinDefaultImg;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private FileSendUtil fileSendUtil;
    @Autowired
    private MsgsChannelService msgsChannelService;
    @Autowired
    private WechatSendStatusService wechatSendStatusService;
    @Autowired
    private WeChatMessageCursorService weChatMessageCursorService;
    @Autowired
    private WeChatMessageRecordService weChatMessageRecordService;
    @Autowired
    private MsgsMessageService msgsMessageService;
    @Autowired
    private MsgsBlacklistService msgsBlacklistService;

    /**
     * 发布消息到微信
     */
    public String sendToWeChat() {
        List<WeChatMessageCursor> recordList = weChatMessageCursorService.getAll();
        if (Util.isEmpty(recordList)) {
            return null;
        }
        log.info("recordList.size()={}", recordList.size());
        for (WeChatMessageCursor weChatMessageCursor : recordList) {
            //定时任务判断
            String date = weChatMessageCursor.getStartTime();
            log.info("weChatMessageCursor={}", JSONObject.toJSONString(weChatMessageCursor));
            log.info("date={}", date);
            if (!Util.isEmptyString(date)) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date date0 = df.parse(date);
                    long time = date0.getTime();
                    long now = System.currentTimeMillis();
                    if (now < time) {
                        continue;
                    }
                    //回写定时发送状态为 ‘发送’
                    if (!Util.isEmptyString(weChatMessageCursor.getMsgId())) {
                        MsgsMessage msgsMessage = new MsgsMessage();
                        msgsMessage.setId(Long.valueOf(weChatMessageCursor.getMsgId()));
                        msgsMessage.setSendJobTime(new Date());
                        msgsMessage.setMsgStatus(0L);
                        msgsMessageService.updateByIdSelective(msgsMessage);
                    }
                    //修改定时发送状态为“发送”
                    WeChatMessageRecord weChatMessageRecord = new WeChatMessageRecord();
                    weChatMessageRecord.setDraft(0);
                    weChatMessageRecord.setId(weChatMessageCursor.getId());

                    log.info("weChatMessageRecord={}", JSONObject.toJSONString(weChatMessageRecord));
                    weChatMessageRecordService.updateByIdSelective(weChatMessageRecord);
                } catch (ParseException e) {
                    log.error("时间格式不正确{}", e);
                    WechatSendStatus wechatSendStatus = new WechatSendStatus();
                    wechatSendStatus.setId(Util.random());
                    wechatSendStatus.setMsgId(weChatMessageCursor.getMsgId());
                    wechatSendStatus.setCreateTime(new Date());
                    wechatSendStatus.setSendStatus(2);
                    wechatSendStatus.setResult("发送时间格式不正确");
                    wechatSendStatusService.save(wechatSendStatus);
                    weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                    continue;
                }
            }
            //开始发送
//			String fileId = weChatMessageCursor.getFileId();
            String channelId = weChatMessageCursor.getChannelId();
            String imgText = weChatMessageCursor.getImgText();
//			String context = "\""+weChatMessageCursor.getContext()+"\"";
//			String filePath = weChatMessageCursor.getFileUrl();
            String topic = weChatMessageCursor.getTopic();

            log.info("channelId={}", channelId);
            List<String> channels = Arrays.asList(channelId.split(","));
            for (String channel : channels) {
                //根据渠道id判断信息发布到哪个公众号
                MsgsChannel msgsChannel = msgsChannelService.getById(Long.valueOf(channel));
                log.info("msgsChannel={}", JSONObject.toJSONString(msgsChannel));
                if (msgsChannel == null) {
                    WechatSendStatus wechatSendStatus = new WechatSendStatus();
                    wechatSendStatus.setId(Util.random());
                    wechatSendStatus.setChannelId(channel);
                    wechatSendStatus.setMsgId(weChatMessageCursor.getMsgId());
                    wechatSendStatus.setCreateTime(new Date());
                    wechatSendStatus.setSendStatus(2);
                    wechatSendStatus.setResult("您所选的渠道不存在，或已经停用，请重新选择渠道");

                    log.info("wechatSendStatus={}", JSONObject.toJSONString(wechatSendStatus));
                    wechatSendStatusService.save(wechatSendStatus);
                    weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                    continue;
                }
                String wechatAppid = msgsChannel.getAppId();
                WechatSendStatus wechatSendStatus = new WechatSendStatus();
                wechatSendStatus.setId(Util.random());
                wechatSendStatus.setChannelId(channel);
                wechatSendStatus.setChannelName(msgsChannel.getName());
                wechatSendStatus.setMsgId(weChatMessageCursor.getMsgId());
                wechatSendStatus.setCreateTime(new Date());
                if (wechatAppid == null) {
                    wechatSendStatus.setSendStatus(2);
                    wechatSendStatus.setResult("您所选的渠道不存在，或已经停用，请重新选择渠道");

                    log.info("wechatSendStatus={}", JSONObject.toJSONString(wechatSendStatus));
                    wechatSendStatusService.save(wechatSendStatus);
                    weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                    continue;
                }
                String accessToken = (String) redisUtils.get(wechatAppid);//获取accessToken
                if (accessToken == null) {
                    wechatSendStatus.setSendStatus(2);
                    wechatSendStatus.setResult("渠道账号故障，请联系账号管理人");
                    log.info("wechatSendStatus={}", JSONObject.toJSONString(wechatSendStatus));
                    wechatSendStatusService.save(wechatSendStatus);
                    weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                    continue;
                }
                String url = MessageConstant.sendToWeChat.replace("%s", accessToken);
                log.info("url={}", url);
                log.info("imgText={}", imgText);
                if (Util.isEmptyString(imgText)) {
                    //文本消息
                    String param = "";
                    //"{\"filter\":{\"group_id\":\"0\",\"is_to_all\":true},\"text\":{\"content\":"+context+"},\"msgtype\":\"text\"}";
                    try {
                        //发送到微信
                        String result = HttpClientEx.doPost(url, param);
                        log.info("result={}", result);
                        JSONObject json = JSONObject.parseObject(result);
                        Integer errcode = (Integer) json.get("errcode");
                        if (errcode == 0) {
                            wechatSendStatus.setSendStatus(1);
                            wechatSendStatus.setResult("信息发布成功");
                            wechatSendStatusService.save(wechatSendStatus);
                            weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                        } else {
                            wechatSendStatus.setSendStatus(2);
                            wechatSendStatus.setResult((String) json.get("errmsg"));
                            wechatSendStatusService.save(wechatSendStatus);
                            weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                        }
                    } catch (Exception e) {
                        wechatSendStatus.setSendStatus(2);
                        wechatSendStatus.setResult("发送异常");
                        wechatSendStatusService.save(wechatSendStatus);
                        weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                        e.printStackTrace();
                        log.error("文本内容发送异常{}", e);
                    } finally {
                        weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                    }
                } else {
                    //文件或素材消息
                    try {
                        String type = "thumb";
                        String mediaId = "";
//						if(Util.isEmptyString(filePath)){
//							type = "thumb";
//						}else{
//							type = FileSendUtil.getPrefix(filePath);
//							String upload = fileSendUtil.send(accessToken,filePath,"file");
//							JSONObject json = JSONObject.fromObject(upload);
//							mediaId = (String) json.get("media_id");	
//						}		
                        String param = "";
                        if ("thumb".equals(type)) {
                            //图文消息
                            if (Util.isEmptyString(imgText)) {
                                wechatSendStatus.setSendStatus(2);
                                wechatSendStatus.setResult("发送图文消息出错");

                                log.info("wechatSendStatus={}", JSONObject.toJSONString(wechatSendStatus));
                                wechatSendStatusService.save(wechatSendStatus);
                                weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                                return "imgTextError";
                            }
                            List<WeChatImgTextDTO> imgTextList = new ArrayList<WeChatImgTextDTO>();
                            List<String> imgTexts = Arrays.asList(imgText.split("#&!"));
                            log.info("imgTexts={}", imgTexts.size());
                            for (int i = 0; i < imgTexts.size(); i++) {
                                String imgTextString = imgTexts.get(i);
                                String html = imgTextString.substring(imgTextString.indexOf("content\":\""), imgTextString.lastIndexOf("\"")).replace("content\":\"", "");
                                String newhtml = html.replaceAll("\"", "\\\\\"");
                                JSONObject imgTextObj = JSONObject.parseObject(imgTextString.replace(html, newhtml));
                                String imgTextFilePath = (String) imgTextObj.get("filepath");
                                String imgTextContent = (String) imgTextObj.get("content");
                                //解析html
                                String docString = FileSendUtil.resolveHtml(imgTextContent, accessToken);
                                log.info("docString={}", docString);
                                String imgTextTitle = (String) imgTextObj.get("topic");
                                String imgTextUpload = fileSendUtil.send(accessToken, imgTextFilePath, "imgText");
                                log.info("imgTextUpload={}", imgTextUpload);
                                if (Util.isEmptyString(imgTextUpload) || "imgTextError".equals(docString)) {
                                    wechatSendStatus.setSendStatus(2);
                                    wechatSendStatus.setResult("发送图文消息格式不正确");
                                    wechatSendStatusService.save(wechatSendStatus);
                                    weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                                    return "imgTextError";
                                }
                                JSONObject imgTextJson = JSONObject.parseObject(imgTextUpload);
                                String imgTextMediaId = (String) imgTextJson.get("thumb_media_id");
                                WeChatImgTextDTO weChatImgTextDTO = new WeChatImgTextDTO();
                                weChatImgTextDTO.setAuthor("");
                                String content = docString.replaceAll("&quot;", "\"").replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&nbsp;", " ").replaceAll("&amp;quot;", "\"").replaceAll("&amp;", "&");
                                weChatImgTextDTO.setContent(content);
                                weChatImgTextDTO.setContent_source_url("");
                                weChatImgTextDTO.setDigest("");
                                weChatImgTextDTO.setThumb_media_id(imgTextMediaId);
                                weChatImgTextDTO.setTitle(imgTextTitle);
                                if (i == 0) {
                                    weChatImgTextDTO.setShow_cover_pic(1);
                                } else {
                                    weChatImgTextDTO.setShow_cover_pic(0);
                                }
                                imgTextList.add(weChatImgTextDTO);
                            }
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("articles", imgTextList);
                            net.sf.json.JSONObject imgTextJson1 = net.sf.json.JSONObject.fromObject(map);
                            String param2 = imgTextJson1.toString();
                            String url2 = MessageConstant.sendSourceToWeChat.replace("%s", accessToken);
                            String result2 = HttpClientEx.doPost(url2, param2);
                            JSONObject json2 = JSONObject.parseObject(result2);
                            if (json2.get("media_id") == null) {
                                wechatSendStatus.setSendStatus(2);
                                wechatSendStatus.setResult((String) json2.get("errmsg"));
                                wechatSendStatusService.save(wechatSendStatus);
                                weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                                return "imgTextError";
                            }
                            String media_Id2 = "\"" + json2.get("media_id") + "\"";
                            String digest = weChatMessageCursor.getDigest();
                            if (imgTexts.size() == 1 && !Util.isEmptyString(digest)) {
                                param = "{\"filter\":{\"group_id\":\"0\",\"is_to_all\":true},\"mpnews\":{\"media_id\":" + media_Id2 + "},\"msgtype\":\"mpnews\",\"digest\":" + digest + ",\"send_ignore_reprint\":1}";
                            } else {
                                param = "{\"filter\":{\"group_id\":\"0\",\"is_to_all\":true},\"mpnews\":{\"media_id\":" + media_Id2 + "},\"msgtype\":\"mpnews\",\"send_ignore_reprint\":1}";
                            }
                        } else if ("image".equals(type)) {
                            //图片消息
                            param = "{\"filter\":{\"group_id\":\"0\",\"is_to_all\":true},\"image\":{\"media_id\":" + mediaId + "},\"msgtype\":\"image\"}";
                        } else if ("voice".equals(type)) {
                            //音频消息
                            param = "{\"filter\":{\"group_id\":\"0\",\"is_to_all\":true},\"voice\":{\"media_id\":" + mediaId + "},\"msgtype\":\"voice\"}";
                        } else if ("video".equals(type)) {
                            //视频消息
                            String videoParam = "{\"media_id\":\"" + mediaId + "\",\"title\":" + topic + "\",\"description\": \"Description\"}";
                            String videoUrl = MessageConstant.sendVideoToWeChat.replace("%s", accessToken);
                            String videoResult = HttpClientEx.doPost(videoUrl, videoParam);
                            JSONObject videoJson = JSONObject.parseObject(videoResult);
                            String media_Id = "\"" + videoJson.get("media_id") + "\"";
                            param = "{\"filter\":{\"group_id\":\"0\",\"is_to_all\":true},\"mpvideo\":{\"media_id\":" + media_Id + "},\"msgtype\":\"mpvideo\"}";
                        } else {
                            wechatSendStatus.setSendStatus(2);
                            wechatSendStatus.setResult("发送的消息不符合要求，请确认消息类型");
                            wechatSendStatusService.save(wechatSendStatus);
                            weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                            return "msgTypeError";
                        }

                        log.info("wechatSendStatus={}", JSONObject.toJSONString(wechatSendStatus));
                        //发送到微信
                        log.info("param={}", param);
                        String result = HttpClientEx.doPost(url, param);
                        log.info("result={}", result);
                        JSONObject json = JSONObject.parseObject(result);
                        Integer errcode = (Integer) json.get("errcode");
                        if (errcode == 0) {
                            wechatSendStatus.setSendStatus(1);
                            wechatSendStatus.setResult("信息发布成功");
                            wechatSendStatusService.save(wechatSendStatus);
                            weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                        } else {
                            wechatSendStatus.setSendStatus(2);
                            wechatSendStatus.setResult((String) json.get("errmsg"));
                            wechatSendStatusService.save(wechatSendStatus);
                            weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                        }
                    } catch (Exception e) {
                        wechatSendStatus.setSendStatus(2);
                        wechatSendStatus.setResult("信息发布异常");
                        wechatSendStatusService.save(wechatSendStatus);
                        weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                        log.error("图文内容发送异常" + e);
                        return "exception";
                    } finally {
                        weChatMessageCursorService.deleteById(weChatMessageCursor.getId());
                    }
                }
            }
        }
        return "success";
    }

    /**
     * 根据渠道id获取微信的appid
     *
     * @param channelId
     * @return
     */
    public MsgsChannel getAppidByChannelId(String channelId) {
        MsgsChannelExample msgsChannelExample = new MsgsChannelExample();
        msgsChannelExample.createCriteria().andIdEqualTo(Long.parseLong(channelId));
        List<MsgsChannel> list = msgsChannelService.find(msgsChannelExample);
        if (!Util.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 保存微信消息
     */
    @Override
    public String saveWechatMessage(String msg) {
        MessageDTO messageDTO = JSONUtils.parseObject(msg, MessageDTO.class);
        //开始拼图文消息
        String topic = messageDTO.getTopic();
        String filepath = messageDTO.getFilePath();
        String imgText = "\"" + messageDTO.getImgText() + "\"";
        String channelId = messageDTO.getChannelId();
        //保存发送状态
        WechatSendStatus wechatSendStatus = new WechatSendStatus();
        wechatSendStatus.setId(Util.random());
        wechatSendStatus.setChannelId(channelId);
        wechatSendStatus.setMsgId(messageDTO.getMsgId());
        wechatSendStatus.setCreateTime(new Date());
        wechatSendStatus.setSendStatus(2);
        //验证黑名单
        String appId = messageDTO.getAppId();
        MsgsBlacklistExample msgsBlacklistExample = new MsgsBlacklistExample();
        msgsBlacklistExample.createCriteria().andAppIdEqualTo(appId).andChannelIdEqualTo(Long.valueOf(channelId));
        List<MsgsBlacklist> list = msgsBlacklistService.find(msgsBlacklistExample);
        if (!Util.isEmpty(list)) {
            wechatSendStatus.setResult("您已被加入黑名单，请联系账号管理员");
            wechatSendStatusService.save(wechatSendStatus);
            return "blacklist";
        }
        if (Util.isEmptyString(filepath)) {
            filepath = "\"" + weixinDefaultImg + "\"";
        } else {
            filepath = "\"" + filepath + "\"";
        }
        topic = "\"" + topic + "\"";
        String tuWen = "{\"filepath\":" + filepath + ",\"topic\":" + topic + ",\"content\":" + imgText + "}";
        messageDTO.setImgText(tuWen);
        //拼图文消息结束
        WeChatMessageRecord weChatMessageRecord = dozerUtils.map(messageDTO, WeChatMessageRecord.class);
        WeChatMessageCursor weChatMessageCursor = dozerUtils.map(messageDTO, WeChatMessageCursor.class);
        try {
            Long id = Util.random();
            if (StringUtils.isEmpty(weChatMessageRecord.getChannelId())) {
                wechatSendStatus.setResult("发送渠道不能为空");
                wechatSendStatusService.save(wechatSendStatus);
                return "dataNull";
            }
            //从redis里面获取access_token，如果没有则账号无效
            String[] channelIds = channelId.split(",");
            for (String channel : channelIds) {
                MsgsChannel msgsChannel = msgsChannelService.getById(Long.valueOf(channel));
                if (msgsChannel == null) {
                    wechatSendStatus.setResult("渠道不正确，请选择正确渠道");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "channelError";
                }
                wechatSendStatus.setChannelName(msgsChannel.getName());
                String appid = msgsChannel.getAppId();
                if (Util.isEmptyString(appid)) {
                    wechatSendStatus.setResult("渠道不正确，请选择正确渠道");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "channelError";
                }
                String accessToken = (String) redisUtils.get(appid);
                if (Util.isEmptyString(accessToken)) {
                    wechatSendStatus.setResult("渠道不正确，请选择正确渠道");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "channelError";
                }
            }
            if (Util.isEmptyString(topic)) {
                wechatSendStatus.setResult("消息主题不能为空");
                wechatSendStatusService.save(wechatSendStatus);
                return "topicError";
            }
            weChatMessageRecord.setCreateTime(new Date());
            if (messageDTO.getDraft() == 0) {
                //正常发送
                weChatMessageRecord.setId(id);
                weChatMessageCursor.setId(id);
                WeChatMessageCursor insertResult = weChatMessageCursorService.save(weChatMessageCursor);
                if (insertResult == null) {
                    wechatSendStatus.setResult("微信发送失败，请稍后重试");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "sendError";
                }
                if (!Util.isEmptyString(weChatMessageRecord.getStartTime())) {
                    weChatMessageRecord.setDraft(1);
                }
                WeChatMessageRecord insertResult1 = weChatMessageRecordService.save(weChatMessageRecord);
                if (insertResult1 == null) {
                    wechatSendStatus.setResult("微信记录保存失败");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "saveError";
                }
            } else if (messageDTO.getDraft() == 2) {
                //草稿编辑发送
                weChatMessageRecord.setDraft(0);
                Long recordId = weChatMessageRecordService.getIdByMsgId(weChatMessageRecord.getMsgId());
                if (recordId == null || recordId == 0) {
                    wechatSendStatus.setResult("草稿不存在");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "draftError";
                }
                weChatMessageRecordService.updateByMsgId(weChatMessageRecord);
                weChatMessageCursor.setId(recordId);
                WeChatMessageCursor insertResult = weChatMessageCursorService.save(weChatMessageCursor);
                if (insertResult == null) {
                    wechatSendStatus.setResult("草稿发送失败");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "sendError";
                }
            } else if (messageDTO.getDraft() == 1) {
                //存草稿
                weChatMessageRecord.setId(id);
                WeChatMessageRecord insertResult = weChatMessageRecordService.save(weChatMessageRecord);
                if (insertResult == null) {
                    wechatSendStatus.setResult("保存草稿失败");
                    wechatSendStatusService.save(wechatSendStatus);
                    return "saveDraftError";
                }
            }
        } catch (Exception e) {
            log.error("保存微信记录失败:" + e);
            wechatSendStatus.setResult("微信发送异常");
            wechatSendStatusService.save(wechatSendStatus);
            return "exception";
        }
        return "success";
    }
}
