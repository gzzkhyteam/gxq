package com.hengyunsoft.platform.admin.impl.utils.inport;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 描述:模板下载文件工具类
 * @author chb
 * @date 2018/3/8 20:10
 * @return
 */
@Slf4j
public class DownloadTempletUtil {
    public static void   DownloadTemple(HttpServletResponse response,String filenames,String resourceFile) throws Exception{
        OutputStream os = null;
        //InputStream inputStream = DownloadTempletUtil.class.getClass().getClassLoader().getResourceAsStream(resourceFile);//?
        Resource resource = new ClassPathResource(resourceFile);
        InputStream inputStream = resource.getInputStream();
        try {
            response.setContentType("application/force-download");
            if (!StringUtils.isEmpty(filenames)) {
                response.setHeader(
                        "Content-disposition",
                        "attachment; filename="
                                + URLEncoder.encode(filenames, "UTF-8"));
            } else {
                response.setHeader("Content-disposition", "attachment");
            }
            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        } finally {
            if (os != null) {
                os.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
