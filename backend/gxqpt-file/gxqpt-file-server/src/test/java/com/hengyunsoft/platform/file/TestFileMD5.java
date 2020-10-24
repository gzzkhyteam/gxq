package com.hengyunsoft.platform.file;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class TestFileMD5 {
    /**
     * 获取一个文件的md5值(可处理大文件)
     * @return md5 value
     */
    public static String getMD5(File file) {
        FileInputStream fileInputStream = null;
        try {
            //MessageDigest MD5 = MessageDigest.getInstance("SHA-1");
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[Integer.valueOf(String.valueOf(file.length()))];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /**
         *
         * 12.mp4
         * webuploader js: 1428aac4ca6c6b566f59362a9b392395
         * java md5：      1428aac4ca6c6b566f59362a9b392395
         * js-spark-md5：  15e8d1c2e0713ec1fde1b7854d2b8f93
         *
         * AnsyHttpClient-1.0-AnsyHttpClient.jar
         * webuploader js: 2f5ef0c1ef5087f875ef0d8e9a3ab451
         * java md5：      2f5ef0c1ef5087f875ef0d8e9a3ab451
         * js-spark-md5：  70a4b39de0852f2c8ea1a9d88f4268b6
         *
         * 大规模分布式系统架构与设计实战-光盘.rar
         * webuploader js: 9998d0295fac78faee16cffb298f9b81
         * java md5：      9998d0295fac78faee16cffb298f9b81
         * js-spark-md5：  4f8f2653dd695d958de10e6a7d77cb86
         *
         * cloudDisk.rar
         * webuploader js:   e76c29f85fd689a90de7c66fd18efd02
         * java md5：        4f8f2653dd695d958de10e6a7d77cb86
         * js-spark-md5：    97ef6f24331389eae09b881b5362324a
         * SHA-1:            44a8b09a2bc0a4ec28ebfceb4f3ee144d2f76675
         *
         *  mv.mpg
         * webuploader js:   64a57025d64645e69eee88f1d309c88f
         * java md5：        4b7918e1b4c2e8795cebdef5a411e385
         * java2 md5：       4b7918e1b4c2e8795cebdef5a411e385
         */
        //0.//File file = new File("F:\\BaiduNetdiskDownload\\微软模拟飞行\\微软模拟飞行10豪华版.part01.rar");// 15e8d1c2e0713ec1fde1b7854d2b8f93
        //1.//File file = new File("C:\\Users\\chb\\Desktop\\timg.jpg");
        //2.//File file = new File("C:\\Users\\chb\\Desktop\\cloudDisk.rar");
        File file = new File("F:\\testImg\\mv.mpg");
        long startTime=System.currentTimeMillis();
        String md5 = getMD5(file);
        long endTime=System.currentTimeMillis();
        System.out.println(md5+"---计算时间："+(endTime-startTime));
    }


}
