package com.hengyunsoft.platform.modular.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件操作工具类
 *
 * @author zx
 */
@Slf4j
public class FileUtil {

    /**
     * 判断是否是一个目录
     *
     * @param dir
     * @return
     */
    public static boolean isDir(String dir) {
        if (StringUtils.isEmpty(dir)) {
            return false;
        }
        File file = new File(dir);
        if (file.isDirectory()) {
            return true;
        }
        return false;
    }

    /**
     * 移动文件到指定目录
     *
     * @param fileName：源文件（路径+名称）
     * @param targetDir：目标目录
     * @return
     */
    public static boolean moveFile(String fileName, String targetDir) {
        if (StringUtils.isEmpty(fileName)) {
            log.info("fileName为空");
            return false;
        }

        File file = new File(fileName);
        return moveFile(file, targetDir);
    }

    /**
     * 移动文件到指定目录
     *
     * @param file：源文件
     * @param targetDir：目标目录
     * @return
     */
    public static boolean moveFile(File file, String targetDir) {
        if (!file.exists()) {
            log.info("文件不存在：" + file.getName());
            return false;
        }

        if (!file.isFile()) {
            log.info(file.getName() + "不是文件");
            return false;
        }

        if (StringUtils.isEmpty(targetDir)) {
            log.info("targetDir为空");
            return false;
        }

        File dir = new File(targetDir);
        if (!dir.exists()) {
            boolean b = dir.mkdirs();
            if (!b) {
                log.error(targetDir + "创建文件夹失败！");
            }
        }
        if (!targetDir.endsWith("/")) {
            targetDir = targetDir + "/";
        }

        boolean b = file.renameTo(new File(targetDir + file.getName()));
        log.debug(file.getName() + "移动到" + targetDir + ":" + b);
        return b;
    }

    /**
     * 创建目录
     *
     * @param dir
     */
    public static boolean mkDir(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    /**
     * 删除单个文件
     *
     * @param sPath 被删除文件path
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 删除目录以及目录下的文件
     *
     * @param sPath 被删除目录的路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = delFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 保存文件
     *
     * @param file     MultipartFile
     * @param fileName 保存文件名称(文件路径+文件名称，示例：F:\src\com\FileUtil.java)
     * @return
     */
    public static File saveFile(MultipartFile file, String fileName) {

        if (file.isEmpty()) {
            return null;
        }

        try {
            return saveFile(file.getInputStream(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存文件
     *
     * @param in       输入流
     * @param fileName 保存文件名称(文件路径+文件名称，示例：F:\src\com\FileUtil.java)
     * @return
     */
    public static File saveFile(InputStream in, String fileName) {

        if (in == null) {
            return null;
        }
        File tempFile = new File(fileName);
        try {
            FileUtils.copyInputStreamToFile(in, tempFile);
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}



