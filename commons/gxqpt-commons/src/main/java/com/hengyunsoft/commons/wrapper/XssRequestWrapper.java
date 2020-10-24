package com.hengyunsoft.commons.wrapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 跨站攻击请求包装器
 *
 * @author tangyh
 * @date 2019-06-28 17:04
 */
public class XssRequestWrapper extends HttpServletRequestWrapper {

    private static final String ANTISAMY_SLASHDOT_XML = "antisamy-slashdot-1.4.4.xml";
    private static Logger log = LoggerFactory.getLogger(XssRequestWrapper.class);
    private static Policy policy = null;

    static {
        log.info(" start read XSS configfile [" + ANTISAMY_SLASHDOT_XML + "]");
        InputStream inputStream = XssRequestWrapper.class.getClassLoader().getResourceAsStream(ANTISAMY_SLASHDOT_XML);
        try {
            policy = Policy.getInstance(inputStream);
            log.info("read XSS configfile [" + ANTISAMY_SLASHDOT_XML + "] success");
        } catch (PolicyException e) {
            log.error("read XSS configfile [" + ANTISAMY_SLASHDOT_XML + "] fail , reason:", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("close XSS configfile [" + ANTISAMY_SLASHDOT_XML + "] fail , reason:", e);
                }
            }
        }
    }

    private List<String> ignoreParamValueList;

    public XssRequestWrapper(HttpServletRequest request, List<String> ignoreParamValueList) {
        super(request);
        this.ignoreParamValueList = ignoreParamValueList;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> request_map = super.getParameterMap();
        Iterator iterator = request_map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            log.info(me.getKey() + ":");
            String[] values = (String[]) me.getValue();
            for (int i = 0; i < values.length; i++) {
                log.info(values[i]);
                values[i] = xssClean(values[i]);
            }
        }
        return request_map;
    }

    @Override
    public String[] getParameterValues(String paramString) {
        String[] arrayOfString1 = super.getParameterValues(paramString);
        if (arrayOfString1 == null) {
            return null;
        }
        int i = arrayOfString1.length;
        String[] arrayOfString2 = new String[i];
        for (int j = 0; j < i; j++) {
            arrayOfString2[j] = xssClean(arrayOfString1[j]);
        }
        return arrayOfString2;
    }

    @Override
    public String getParameter(String paramString) {
        String str = super.getParameter(paramString);
        if (str == null) {
            return null;
        }
        return xssClean(str);
    }

    @Override
    public String getHeader(String paramString) {
        String str = super.getHeader(paramString);
        if (str == null) {
            return null;
        }
        return xssClean(str);
    }

    private String xssClean(String paramValue) {
        AntiSamy antiSamy = new AntiSamy();
        try {
            log.debug("raw value before xssClean: " + paramValue);
            if (isIgnoreParamValue(paramValue)) {
                log.debug("ignore the xssClean,keep the raw paramValue: " + paramValue);
                return paramValue;
            } else {
                final CleanResults cr = antiSamy.scan(paramValue, policy);
                String str = StringEscapeUtils.escapeHtml(cr.getCleanHTML());
                str = str.replaceAll((antiSamy.scan("&nbsp;", policy)).getCleanHTML(), "");
                str = StringEscapeUtils.unescapeHtml(str);
                str = str.replaceAll("&quot;", "\"");
                str = str.replaceAll("&amp;", "&");
                str = str.replaceAll("'", "'");
                str = str.replaceAll("'", "＇");

                str = str.replaceAll("&lt;", "<");
                str = str.replaceAll("&gt;", ">");
                log.debug("xssfilter value after xssClean" + str);

                return str;
            }
        } catch (ScanException e) {
            log.error("scan failed armter is [" + paramValue + "]", e);
        } catch (PolicyException e) {
            log.error("antisamy convert failed  armter is [" + paramValue + "]", e);
        }
        return paramValue;
    }

    private boolean isIgnoreParamValue(String paramValue) {
        if (StringUtils.isBlank(paramValue)) {
            return true;
        }
        if (CollectionUtils.isEmpty(ignoreParamValueList)) {
            return false;
        } else {
            for (String ignoreParamValue : ignoreParamValueList) {
                if (paramValue.contains(ignoreParamValue)) {
                    return true;
                }
            }
        }
        return false;
    }

}