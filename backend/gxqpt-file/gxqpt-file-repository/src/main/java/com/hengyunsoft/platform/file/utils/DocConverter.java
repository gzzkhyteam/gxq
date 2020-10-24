package com.hengyunsoft.platform.file.utils;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * doc docx格式转换
 *
 * @author Administrator
 */
public class DocConverter {
    /** 环境 1：windows 2:linux */

    /**
     * (只涉及pdf2swf路径问题)
     */
    private String filePath;
    /**
     * 输入路径 ，如果不设置就输出在默认的位置
     */
    private String outputPath = "";
    /**
     * 完整文件名，不含后缀
     */
    private String fileName;
    private String ext;
    /**
     * pdf临时文件
     */
    private File pdfFile;
    /**
     * swf临时文件
     */
    private File swfFile;
    /**
     * doc临时文件
     */
    private File docFile;
    private final int environment;
    private final String swfToolsPath;
    private final String officeHome;
    private final String languagedir;

    public DocConverter(String filePath, String languagedir, int environment, String swfToolsPath, String officeHome) {
        this.swfToolsPath = swfToolsPath;
        this.environment = environment;
        this.officeHome = officeHome;
        this.filePath = filePath;
        this.languagedir = languagedir;
        fileName = filePath.substring(0, filePath.lastIndexOf("."));
        ext = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
        docFile = new File(filePath);
        pdfFile = new File(fileName + "_pdf.pdf");
        swfFile = new File(fileName + "_swf.swf");
    }


    //public String getSwfToolsPath() {
    //    String osName = System.getProperty("os.name");
    //    if (Pattern.matches("Linux.*", osName)) {
    //        return "/usr/local/swftools/bin/pdf2swf ";
    //    } else if (Pattern.matches("Windows.*", osName)) {
    //        return "G:\\Install\\SWFTools\\pdf2swf.exe ";
    //        //return "C:/Program Files (x86)/OpenOffice 4";
    //    } else if (Pattern.matches("Mac.*", osName)) {
    //        return "/usr/local/swftools/bin/pdf2swf ";
    //    }
    //    return null;
    //}
    //
    //
    ///**
    // * 根据操作系统的名称，获取OpenOffice.org 3的安装目录<br>
    // * 如我的OpenOffice.org 3安装在：C:/Program Files (x86)/OpenOffice.org 3<br>
    // *
    // * @return OpenOffice.org 3的安装目录
    // */
    //public String getOfficeHome() {
    //    String osName = System.getProperty("os.name");
    //    if (Pattern.matches("Linux.*", osName)) {
    //        return "/opt/openoffice4";
    //    } else if (Pattern.matches("Windows.*", osName)) {
    //        return "G:\\Install\\OpenOffice4";
    //        //return "C:/Program Files (x86)/OpenOffice 4";
    //    } else if (Pattern.matches("Mac.*", osName)) {
    //        return "/Application/OpenOffice4/Contents";
    //    }
    //    return null;
    //}

    ///**
    // * 重新设置file
    // *
    // * @param filePath
    // */
    //public void setFile(String filePath) {
    //    init(filePath);
    //}

    //public static void main(String[] args) {
    //    File file = new File("D:\\axure---注册码.txt");
    //    File pdfFile = new File("D:\\axure---注册码.pdf");
    //    //File file = new File("D:\\home\\gxqpt\\uploadfile\\file\\45kj6352\\2018\\05\\606c7dd9-f7c6-43b2-bd08-3771fb374b35.txt");
    //    //File pdfFile = new File("D:\\home\\gxqpt\\uploadfile\\file\\45kj6352\\2018\\05\\606c7dd9-f7c6-43b2-bd08-3771fb374b35_2.pdf");
    //
    //    DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();
    //    config.setOfficeHome("G:\\Install\\OpenOffice4");
    //    config.setPortNumbers(8100);
    //    config.setTaskExecutionTimeout(1000 * 60 * 5L); // 设置任务执行超时为5分钟
    //    // 设置任务队列超时为24小时
    //    config.setTaskQueueTimeout(1000 * 60 * 60 * 24L);
    //    // 启动OpenOffice的服务
    //    OfficeManager officeManager = config.buildOfficeManager();
    //    officeManager.start();
    //    try {
    //        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
    //        converter.convert(file, pdfFile);
    //
    //        System.out.println("****pdf转换成功，PDF输出：" + "****");
    //    } catch (org.artofsolving.jodconverter.office.OfficeException e) {
    //        e.printStackTrace();
    //        System.out.println("****swf转换器异常，读取转换文件失败****");
    //        throw e;
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //        throw e;
    //    } finally {
    //        officeManager.stop();
    //    }
    //}

    /**
     * 转为PDF
     *
     * @param
     */
    private void doc2pdf() throws Exception {
        if (docFile.exists()) {
            if (!pdfFile.exists()) {
                OfficeManager officeManager = getOfficeManager();
                try {
                    OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
                    converter.convert(docFile, pdfFile);

                    System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath() + "****");
                } catch (org.artofsolving.jodconverter.office.OfficeException e) {
                    e.printStackTrace();
                    System.out.println("****swf转换器异常，读取转换文件失败****");
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                } finally {
                    officeManager.stop();
                }
            } else {

                System.out.println("****已经转换为pdf，不需要再进行转化****");
            }
        } else {
            System.out.println("****swf转换器异常，需要转换的文档不存在，无法转换****");
        }
    }


    /**
     * 连接OpenOffice.org 并且启动OpenOffice.org
     *
     * @return
     */
    public OfficeManager getOfficeManager() {
        DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();
        config.setOfficeHome(this.officeHome);
        config.setPortNumbers(8100);
        config.setTaskExecutionTimeout(1000 * 60 * 5L); // 设置任务执行超时为5分钟
        // 设置任务队列超时为24小时
        config.setTaskQueueTimeout(1000 * 60 * 60 * 24L);
        // 启动OpenOffice的服务
        OfficeManager officeManager = config.buildOfficeManager();
        officeManager.start();
        return officeManager;
    }

    /**
     * 转换成 swf
     */
    @SuppressWarnings("unused")
    private void pdf2swf() throws Exception {
        Runtime r = Runtime.getRuntime();
        if (!swfFile.exists()) {
            if (pdfFile.exists()) {
                if (environment == 1) {// windows环境处理
                    try {
                        Process p = r.exec(this.swfToolsPath + " " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -s languagedir=" + languagedir + " -T 9");
                        System.out.print(loadStream(p.getInputStream()));
                        System.out.print(loadStream(p.getErrorStream()));
                        System.out.println("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
                        if (pdfFile.exists()) {
                            //pdfFile.delete();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                        throw e;
                    }
                } else if (environment == 2) {// linux环境处理
                    try {
                        Process p = r.exec(this.swfToolsPath +" " +  pdfFile.getPath() + " -o " + swfFile.getPath() + " -s languagedir=" + languagedir + " -T 9");
                        System.out.print(loadStream(p.getInputStream()));
                        System.out.print(loadStream(p.getErrorStream()));
                        System.out.println("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
                        if (pdfFile.exists()) {
                            //pdfFile.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            } else {
                System.out.println("****pdf不存在,无法转换****");
            }
        } else {
            System.out.println("****swf已经存在不需要转换****");
        }
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

    /**
     * 转换主方法
     */
    public boolean conver() {
        if (swfFile.exists()) {
            System.out.println("****swf转换器开始工作，该文件已经转换为swf****");
            return true;
        }

        if (environment == 1) {
            System.out.println("****swf转换器开始工作，当前设置运行环境windows****");
        } else {
            System.out.println("****swf转换器开始工作，当前设置运行环境linux****");
        }
        try {
            //本身就是pdf的不需要转换
            if(!"pdf".equalsIgnoreCase(ext)){
                doc2pdf();
            } else {
                pdfFile = docFile;
            }

            pdf2swf();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (swfFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    ///**
    // * 返回文件路径
    // *
    // * @param
    // */
    //public String getswfPath() {
    //    if (swfFile.exists()) {
    //        String tempString = swfFile.getPath();
    //        tempString = tempString.replaceAll("\\\\", "/");
    //        return tempString;
    //    } else {
    //        return "";
    //    }
    //
    //}

    ///**
    // * 设置输出路径
    // */
    //public void setOutputPath(String outputPath) {
    //    this.outputPath = outputPath;
    //    if (!outputPath.equals("")) {
    //        String realName = fileName.substring(fileName.lastIndexOf("/"),
    //                fileName.lastIndexOf("."));
    //        if (outputPath.charAt(outputPath.length()) == '/') {
    //            swfFile = new File(outputPath + realName + ".swf");
    //        } else {
    //            swfFile = new File(outputPath + realName + ".swf");
    //        }
    //    }
    //}

}  
