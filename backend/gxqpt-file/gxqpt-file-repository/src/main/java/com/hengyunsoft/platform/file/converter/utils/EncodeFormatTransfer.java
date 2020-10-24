package com.hengyunsoft.platform.file.converter.utils;

import info.monitorenter.cpdetector.CharsetPrinter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

@Slf4j
public class EncodeFormatTransfer {


    public static String DefaultSrcEncodeFormat = "GBK";

    public static String DefaultDestEncodeFormat = "UTF-8";


    public static String UnsupportedEncodingExceptionError = "编码格式错误！";

    public static String FileNotFoundExceptionError = "文件不存在！";

    public static String IOExceptionError = "文件读写错误！";

    public static String IsUtf8File = "文件是UTF-8编码格式！";

    public static String IsNotUtf8File = "文件不是UTF-8编码格式！";


    public static String readFile(String path, String encodeFormat) {
        if ((encodeFormat == null || encodeFormat.equals(""))) {
            if (isUTF8File(path))
                encodeFormat = DefaultDestEncodeFormat;
            else
                encodeFormat = DefaultSrcEncodeFormat;
        }
        try {
            String context = "";
            InputStreamReader isr;
            isr = new InputStreamReader(new FileInputStream(path), encodeFormat);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                context += line + "\r\n";
                //log.error(line);
            }
            br.close();

            return context;
        } catch (UnsupportedEncodingException e) {
            log.error(UnsupportedEncodingExceptionError);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            log.error(FileNotFoundExceptionError);
            e.printStackTrace();
        } catch (IOException e) {
            log.error(IOExceptionError);
            e.printStackTrace();
        }

        return "";
    }


    public static String guessEncoding(String path) {
        try {
            File file = new File(path);
            CharsetPrinter detector = new CharsetPrinter();
            return detector.guessEncoding(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error(FileNotFoundExceptionError);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(IOExceptionError);
        }
        return null;
    }

    public static boolean isUTF8File(String path) {
        String charset = guessEncoding(path);
        if (DefaultDestEncodeFormat.equalsIgnoreCase(charset)) {
            log.info(IsUtf8File);
            return true;
        }

        log.info(IsNotUtf8File);
        return false;

    }


    public static String transfer(String context, String encodeFormat) {
        if (encodeFormat == null || encodeFormat.equals(""))
            encodeFormat = DefaultDestEncodeFormat;
        try {
            byte[] content = context.getBytes();
            String result = new String(content, encodeFormat);
            return result;
        } catch (UnsupportedEncodingException e) {
            log.error(UnsupportedEncodingExceptionError);
            e.printStackTrace();
        }
        return "";

    }


    public static void writeFile(String context, String path, String destEncode) {
        File file = new File(path);
        if (file.exists())
            file.delete();
        BufferedWriter writer;
        try {
            FileOutputStream fos = new FileOutputStream(path, true);
            writer = new BufferedWriter(new OutputStreamWriter(fos, destEncode));
            writer.append(context);
            writer.close();
        } catch (IOException e) {
            log.error(IOExceptionError);
            e.printStackTrace();
        }

    }


    public static void writeFile(String context, String path) {
        File file = new File(path);
        if (file.exists())
            file.delete();
        Writer writer;
        try {
            writer = new FileWriter(file, true);
            writer.append(context);
            writer.close();
        } catch (IOException e) {
            log.error(IOExceptionError);
            e.printStackTrace();
        }

    }


    public static void transfer(String srcPath, String destPath, String srcEncode, String destEncode) {
        if (destPath == null || destPath.equals(""))
            destPath = srcPath;
        String context = readFile(srcPath, srcEncode);
        context = transfer(context, destEncode);
        writeFile(context, destPath, destEncode);

    }


    public static void transfer(String srcPath, String destPath, String destEncode) {
        if (isUTF8File(srcPath)) {
            transfer(srcPath, destPath, DefaultDestEncodeFormat, destEncode);
        } else {
            transfer(srcPath, destPath, DefaultSrcEncodeFormat, destEncode);
        }
    }

    public static boolean transfer2(String srcPath, String destPath, String destEncode) {
        String srcEncoding = guessEncoding(srcPath);
        log.info("srcEncoding={}", srcEncoding);
        if (!DefaultDestEncodeFormat.equalsIgnoreCase(srcEncoding)) {
            try {
                //String command = "iconv -f gbk -t utf8 " + srcPath + " > " + destPath;
                String command = "iconv " + srcPath + " -f gbk -t utf8  -o " + destPath;

                log.info("command={}", command);

                Process p = Runtime.getRuntime().exec(command);
                p.waitFor();

                loadStream(p.getInputStream());//执行这个文件才能刷新到磁盘？
                log.info(loadStream(p.getErrorStream()));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                log.info("转换文档为UTF8格式失败！");
                return false;
            }
        }
        return false;
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


    //public static void main(String args[]) {
    //    String path1 = "D:\\axure---注册码.txt";
    //    String path2 = "D:\\axure---注册码_trun.txt";
    //    //String path1 = "D:\\home\\gxqpt\\uploadfile\\file\\45kj6352\\2018\\05\\f2f0bec0-9cf4-49ab-8aa1-6f4eac447c51.txt2";
    //    //String path2 = "D:\\home\\gxqpt\\uploadfile\\file\\45kj6352\\2018\\05\\f2f0bec0-9cf4-49ab-8aa1-6f4eac447c51.txt3";
    //    //String path1 = "D:\\home\\gxqpt\\uploadfile\\file\\45kj6352\\2018\\05\\9ab56a3a-0316-43e0-83ea-ae26dd76c3de.docx";
    //    //String path2 = "D:\\home\\gxqpt\\uploadfile\\file\\45kj6352\\2018\\05\\9ab56a3a-0316-43e0-83ea-ae26dd76c3de.txt";
    //    transfer(path1, path2, "UTF-8");
    //    //transfer(path1, path2, "UTF-8", "UTF-8");
    //}
}