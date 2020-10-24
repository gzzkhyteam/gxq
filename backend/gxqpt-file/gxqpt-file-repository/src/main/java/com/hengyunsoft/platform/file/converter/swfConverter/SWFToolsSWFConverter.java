package com.hengyunsoft.platform.file.converter.swfConverter;

import com.hengyunsoft.platform.file.config.SwfProperties;
import com.hengyunsoft.platform.file.converter.pdfConverter.PDFConverter;
import com.hengyunsoft.platform.file.converter.utils.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SWFToolsSWFConverter implements SWFConverter {

    private SwfProperties swfProperties;
    private static SWFConverter CONVERTER;

    private SWFToolsSWFConverter(SwfProperties swfProperties) {
        super();
        this.swfProperties = swfProperties;
    }

    public static SWFConverter getInstance(SwfProperties swfProperties) {
        if (CONVERTER == null) {
            synchronized (SWFConverter.class) {
                if (CONVERTER == null)
                    CONVERTER = new SWFToolsSWFConverter(swfProperties);
            }
        }
        return CONVERTER;
    }

    @Override
    public String convert2SWF(String inputFile, String swfFile) {
        File pdfFile = new File(inputFile);
        File outFile = new File(swfFile);
        log.info("inputFile=" + inputFile);
        log.info("swfFile=" + swfFile);
        if (!inputFile.endsWith(PDFConverter.PDF_SUFFIX)) {
            log.info("文件格式非PDF！");
            return swfFile;
        }
        if (!pdfFile.exists()) {
            log.info("PDF文件不存在！");
            return swfFile;
        }
        if (outFile.exists()) {
            log.info("SWF文件已存在！");
            return swfFile;
        }
        //String command = swfProperties.getSwfToolsPath() + " " + inputFile + " -o " + swfFile + " -s languagedir=" + swfProperties.getXpdfChineseSimplified() + " -T 9 -f";
        String command = swfProperties.getSwfToolsPath() + " " + inputFile + " -o " + swfFile + " -s languagedir=" + swfProperties.getXpdfChineseSimplified() + " -T 9 ";
        try {
            log.info("开始转换文档: " + inputFile);
            log.info("command: " + command);
            // /usr/local/swftools/bin/pdf2swf "/home/gxqpt/uploadfile/file/45kj6352/2018/05/dc5bf21b-9407-4b58-b26a-ff2ca31926c4.pdf" -o "/home/gxqpt/uploadfile/file/45kj6352/2018/05/dc5bf21b-9407-4b58-b26a-ff2ca31926c4.swf" -s languagedir=/usr/local/xpdf-chinese-simplified -T 9 -f

            Process p = Runtime.getRuntime().exec(command);
            p.waitFor(5, TimeUnit.SECONDS);

            loadStream(p.getInputStream());//执行这个文件才能刷新到磁盘？
            System.out.print(loadStream(p.getErrorStream()));
            log.info("成功转换为SWF文件！" + outFile.getPath() + ",是否生成成功:" +  outFile.exists());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("转换文档为swf文件失败！");
        }
        return swfFile;
    }

    static String loadStream(InputStream in) throws IOException {
        int ptr = 0;
        in = new BufferedInputStream(in);
        StringBuffer buffer = new StringBuffer();

        while ((ptr = in.read()) != -1) {
            buffer.append((char) ptr);
        }

        return buffer.toString();
    }

    @Override
    public String convert2SWF(String inputFile) {
        String swfFile = FileUtils.getFilePrefix(inputFile) + SWF_SUFFIX;
        return convert2SWF(inputFile, swfFile);
    }

}
