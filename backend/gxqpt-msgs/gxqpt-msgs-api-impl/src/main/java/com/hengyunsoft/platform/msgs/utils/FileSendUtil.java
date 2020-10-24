package com.hengyunsoft.platform.msgs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.hengyunsoft.platform.msgs.constant.MessageConstant;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@Component
public class FileSendUtil {

    public String send(String token, String filePath, String mark) throws ClientProtocolException, IOException {
        InputStream in = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            HttpPost httpPost = null;
            URL fileUrl = new URL(filePath);
            URLConnection conn = fileUrl.openConnection();
            in = conn.getInputStream();
            String prefix = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
            String outputFile = "/home/gxqpt/projects/wechat/image/" + Util.uuid() + "." + prefix;
            String filefloder = "/home/gxqpt/projects/wechat/image/";
            File file1 = new File(filefloder);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            file = new File(outputFile);
            file.createNewFile();
            fos = new FileOutputStream(file);

            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                fos.write(bufferOut, 0, bytes);
            }
            httpPost = new HttpPost(getUrl(token, file, mark));
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            // 上传的文件
            builder.addBinaryBody(file.getName(), file);
            HttpEntity httpEntity = builder.build();
            httpPost.setEntity(httpEntity);
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpPost);
            if (null == response || response.getStatusLine() == null) {
                return null;
            } else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return null;
            }
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            log.error("上传的文件出错" + e);
            return null;
        } finally {
            in.close();
            fos.flush();
            fos.close();
            file.delete();
        }
    }

    /**
     * 获取文件地址
     *
     * @param file
     * @return
     * @throws Exception
     */
    String getUrl(String token, File file, String mark) throws Exception {
        String fileName = file.getName();
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        if (("jpg".equals(prefix) || "png".equals(prefix)) && "imgText".equals(mark)) {
            return MessageConstant.sendFileToWeChat.replace("%s", token).replace("%t", "thumb");
        } else if (("png".equals(prefix) || "jpg".equals(prefix) || "gif".equals(prefix)
                || "jpeg".equals(prefix)) && "file".equals(mark)) {
            return MessageConstant.sendFileToWeChat.replace("%s", token).replace("%t", "image");
        } else if ("amr".equals(prefix) || "mp3".equals(prefix)) {
            return MessageConstant.sendFileToWeChat.replace("%s", token).replace("%t", "voice");
        } else if ("mp4".equals(prefix)) {
            return MessageConstant.sendFileToWeChat.replace("%s", token).replace("%t", "video");
        } else {
            throw new Exception("上传素材格式不符合要求");
        }
    }

    /**
     * 获取文件类型
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static String getPrefix(String filePath) {
        String prefix = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
        if ("png".equals(prefix) || "jpg".equals(prefix)
                || "gif".equals(prefix) || "jpeg".equals(prefix)) {
            return "image";
        } else if ("amr".equals(prefix) || "mp3".equals(prefix)) {
            return "voice";
        } else if ("mp4".equals(prefix)) {
            return "video";
        }
        return null;
    }

    /**
     * 解析html
     *
     * @param filePath
     * @return
     */
    public static String resolveHtml(String imgTextContent, String accessToken) {
        if (Util.isEmptyString(imgTextContent)) {
            return "imgTextError";
        }
        Document doc = Jsoup.parse(imgTextContent);
        Elements imgElements = doc.select("img");
        Elements mediaElements = doc.select("a");
        if (!imgElements.isEmpty() && imgElements.size() != 0) {
            //图片
            for (Element element : imgElements) {
                String src = element.attr("src");
                String imgUrl = MessageConstant.sendImageToWeChat.replace("%s", accessToken);
                Map<String, String> fileMap = new HashMap<String, String>();
                fileMap.put("media", src);
                String result = HttpClientEx.formUpload(imgUrl, null, fileMap);
                if (!Util.isEmptyString(result)) {
                    JSONObject json = JSONObject.fromObject(result);
                    String newUrl = "\"" + json.get("url") + "\"";
                    element.attr("src", newUrl);
                } else {
                    element.attr("src", "");
                }
            }
        }
        if (!mediaElements.isEmpty() && mediaElements.size() != 0) {
            //视频
            for (Element element : mediaElements) {
                String href = element.attr("href");
                if (StringUtils.isEmpty(href)) {
                    continue;
                }
                if (href.contains("v.qq.com")) {
                    //视频
                    String newUrl = href.substring(href.lastIndexOf("/") + 1, href.indexOf(".html"));
                    String newElenment = getVideoString(newUrl);
                    Element parent = element.parent();
                    element.remove();
                    parent.append(newElenment);
                } else {
                    //过滤无效的节点
                    element.remove();
                }
            }
        }
        return doc.toString();
    }
    /**
     * 拼接音频字符串
     * @return
     */
//	private static String getAudioString(String mediaId){
//		StringBuffer buff = new StringBuffer();		
//		buff.append("<mpvoice frameborder=\"0\" class=\"res_iframe js_editor_audio audio_iframe\"")
//			.append("src=\"/cgi-bin/readtemplate?t=tmpl/audio_tmpl&amp;name=%E6%88%91%E7%9A%84&amp;play_length=00:05\"")
//			.append("isaac2=\"1\" low_size=\"8.88\" source_size=\"8.9\" high_size=\"44.48\"")
//			.append("name=\"我的\" play_length=\"5000\" voice_encode_fileid=\"")
//			.append(mediaId).append("\">")
//			.append("</mpvoice>");
//		return buff.toString();		
//	}	

    /**
     * 拼接视频字符串
     *
     * @return
     */
    private static String getVideoString(String url) {
        StringBuffer buff = new StringBuffer();
        buff.append("<iframe class=\"video_iframe wx_video_iframe\" data-vidtype=\"2\" allowfullscreen=\"\"")
                .append("frameborder=\"0\" style=\"z-index: 1; overflow: hidden;\" height=\"314\" width=\"558\"")
                .append("scrolling=\"no\" src=\"https://v.qq.com/iframe/preview.html?vid=")
                .append(url).append("&autoplay=false&full=true&show1080p=false\">")
                .append("</iframe>");
        return buff.toString();
    }
}
