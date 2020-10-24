package com.hengyunsoft.platform.file.converter.pdfConverter;

import com.hengyunsoft.platform.file.config.SwfProperties;
import com.hengyunsoft.platform.file.converter.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import java.io.File;


@Slf4j
public class OpenOfficePDFConverter implements PDFConverter {
    private SwfProperties swfProperties;
    private static OfficeManager officeManager;
    private static int port[] = {8100};

    private static PDFConverter CONVERTER = null;

    //private OpenOfficePDFConverter() {
    //    super();
    //}

    private OpenOfficePDFConverter(SwfProperties swfProperties) {
        super();
        this.swfProperties = swfProperties;
    }

    public static PDFConverter getInstance(SwfProperties swfProperties) {
        if (CONVERTER == null) {
            synchronized (OpenOfficePDFConverter.class) {
                if (CONVERTER == null)
                    CONVERTER = new OpenOfficePDFConverter(swfProperties);
            }
        }
        return CONVERTER;
    }


    public void convert2PDF(String inputFile, String pdfFile) {
        //if (inputFile.endsWith(".txt")) {
        //    String odtFile = FileUtils.getFilePrefix(inputFile) + ".odt";
        //    if (new File(odtFile).exists()) {
        //        log.info("odt文件已存在！");
        //        inputFile = odtFile;
        //    } else {
        //        try {
        //            FileUtils.copyFile(inputFile, odtFile);
        //            inputFile = odtFile;
        //        } catch (FileNotFoundException e) {
        //            log.info("文档不存在！");
        //            e.printStackTrace();
        //        }
        //    }
        //}

        startService();
        log.info("进行文档转换转换:" + inputFile + " --> " + pdfFile);
        try {
            OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
            File pdf = new File(pdfFile);
            converter.convert(new File(inputFile), pdf);

            if (pdf != null && pdf.exists()) {
                log.info(pdfFile + "存在" + pdf.getPath());
            }
        } finally {
            stopService();
        }
    }


    public void convert2PDF(String inputFile) {
        String pdfFile = FileUtils.getFilePrefix(inputFile) + PDF_SUFFIX;
        convert2PDF(inputFile, pdfFile);
    }

    public void startService() {
        DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
        try {
            log.info("准备启动服务....");
            configuration.setOfficeHome(swfProperties.getOfficeHome());//设置OpenOffice.org安装目录
            configuration.setPortNumbers(port); //设置转换端口，默认为8100
            configuration.setTaskExecutionTimeout(1000 * 60 * 5L);//设置任务执行超时为5分钟
            configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);//设置任务队列超时为24小时

            officeManager = configuration.buildOfficeManager();
            log.info("officeManager.isRunning()" + officeManager.isRunning());
            if (!officeManager.isRunning()) {
                officeManager.start();    //启动服务
            }
            log.info("officeManager.isRunning()" + officeManager.isRunning());
            log.info("office转换服务启动成功!");
        } catch (Exception ce) {
            ce.printStackTrace();
            log.info("office转换服务启动失败!详细信息:" + ce);
            stopService();
        }
    }

    public void stopService() {
        log.info("关闭office转换服务....");
        if (officeManager != null && officeManager.isRunning()) {
            officeManager.stop();
        }
        log.info("关闭office转换成功!");
    }
}
