package com.hengyunsoft.platform.admin.config;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * @author
 * <p>
 * Xss过滤工具
 */

public class XssUtil {

    /**
     * 使用白名单
     */
    private static final Whitelist whitelist = Whitelist.relaxed();

    /**
     * 过滤化参数,不对代码进行格式化
     */
    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);

    static {
        // 富文本编辑器特殊标签处理
        whitelist.addAttributes(":all", "style")
                .addAttributes("span", "class")
                .addAttributes("pre", "style")
                .addAttributes("tr", "class")
                .addAttributes("td", "valign")
                .addAttributes("code", "class")
                .addTags("embed", "object", "param", "span", "div")
                .addAttributes(":all", "style", "class", "id", "name")
                .addAttributes("object", "width", "height", "classid", "codebase")
                .addAttributes("param", "name", "value")
                .addAttributes("embed", "src", "quality", "width", "height", "allowFullScreen", "allowScriptAccess", "flashvars", "name", "type", "pluginspage");
    }

    /**
     * 对请求参数进行xss过滤
     *
     * @param arg
     * @return
     */
    public static Object cleanArg(Object arg) {
        String argJson = JSON.toJSONString(arg);
        argJson = StringEscapeUtils.unescapeJavaScript(argJson);
        String cleanJson = XssUtil.clean(argJson);
        String newJson = XssUtil.jsonConvert(cleanJson);
        return JSON.parseObject(newJson, arg.getClass());
    }

    /**
     * 对字符串进行xss过滤
     *
     * @param content
     * @return
     */
    public static String clean(String content) {
        if (StringUtils.isNotBlank(content)) {
            content = content.trim();
        }
        return Jsoup.clean(content, "", whitelist, outputSettings);
    }

    /**
     * json中处理转义字符
     *
     * @param s
     * @return
     */
    public static String jsonConvert(String s) {
        StringBuilder builder = new StringBuilder();
        char[] temp = s.toCharArray();
        int n = temp.length;
        for (int i = 0; i < n; i++) {
            if (temp[i] == ':' && temp[i + 1] == '"') {
                builder.append(temp[i]);
                builder.append(temp[i + 1]);
                for (int j = i + 2; j < n; j++) {
                    if (temp[j] == '"') {
                        if (temp[j + 1] != ',' && temp[j + 1] != '}') {
                            builder.append("\\");
                        } else if (temp[j + 1] == ',' || temp[j + 1] == '}') {
                            i = j - 1;
                            break;
                        }
                    }
                    builder.append(temp[j]);
                }

            } else {
                builder.append(temp[i]);
            }
        }
        return builder.toString();
    }
}
