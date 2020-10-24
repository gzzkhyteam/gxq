package com.hengyunsoft.platform.file.support;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.activation.MimetypesFileTypeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author ShenHuaJie
 * @version 2016年6月27日 上午9:50:51
 */
@Data
public class FileModel implements Serializable {
    /**
     * 命名空间
     */
    private String namespace;
    /**
     * 对象id
     */
    private String objectId;
    /**
     * key
     */
    private String key;

    /**
     * 文件内容字节
     */
    private byte[] content;
    /**
     * 后缀
     */
    private String ext;
    /**
     * 文件类型
     */
    private String mime;
    /**
     * 文件在服务器的相对路径
     * 文件的完整路径=absolutePath + filename
     * linux eg: 2015/01/01
     * win eg: 2015\\01\\01
     */
    private String relativePath;
    /**
     * 文件在服务器的绝对路径
     * 文件的完整路径=absolutePath + filename
     * linux eg: /home/tyh/file/RELATIVEPATH
     * win eg: d:\\file
     */
    private String absolutePath;
    /**
     * 文件大小
     */
    private String size;
    /**
     * 新文件名
     */
    private String filename;
    /**
     * 原始文件名
     */
    private String submittedFileName;
    /**
     * 文件远程访问前缀
     */
    private String remoteUriPrefix = "";

    /**
     * FastDFS 文件全路径
     */
    private String remotePath;
    /**
     * 返回的组id
     */
    private String groupName;
    /**
     * 远程文件名
     */
    private String remoteFileName;


    /**
     * @param namespace 名称空间
     * @param objectId  文件标识
     * @param filePath  文件在web服务器的临时路径
     */
    public FileModel(String namespace, String objectId,
                     String submittedFileName,
                     String absolutePath, String relativePath,
                     String remoteUriPrefix, String fileName) {
        this(namespace, objectId, absolutePath, relativePath, remoteUriPrefix, fileName);
        this.submittedFileName = submittedFileName;
    }

    public FileModel(String namespace, String objectId,
                     String absolutePath, String relativePath,
                     String remoteUriPrefix, String fileName) {
        this.namespace = namespace;
        this.objectId = objectId;
        this.absolutePath = absolutePath;
        this.relativePath = relativePath;
        this.remoteUriPrefix = remoteUriPrefix;
        String localFilePath = Paths.get(absolutePath, fileName).toString();
        if (localFilePath == null || "".equals(localFilePath.trim())) {
            return;
        }
        this.ext = StringUtils.substring(fileName, StringUtils.lastIndexOf(fileName, ".") + 1);
        InputStream is = null;
        byte[] fileBuff = null;
        FileInputStream fileInputStream = null;
        try {
            File file = new File(localFilePath);
            this.size = String.valueOf(file.length());
            this.filename = file.getName();

            fileInputStream = new FileInputStream(file);
            if (fileInputStream != null) {
                int len = fileInputStream.available();
                fileBuff = new byte[len];
                fileInputStream.read(fileBuff);
            }
            this.content = fileBuff;
            //读取服务器支持的文件类型列表
            is = getClass().getResourceAsStream("/mime.types");
            MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap(is);
            this.mime = mimetypesFileTypeMap.getContentType(filename);
            this.key = UUID.randomUUID().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }


    public FileModel(String namespace, String objectId,
                     String absolutePath, String relativePath,
                     String remoteUriPrefix, String fileName, String size,
                     String submittedFileName) {
        this.namespace = namespace;
        this.objectId = objectId;
        this.absolutePath = absolutePath;
        this.relativePath = relativePath;
        this.remoteUriPrefix = remoteUriPrefix;
        this.submittedFileName = submittedFileName;
//        String localFilePath = Paths.get(absolutePath, fileName).toString();
//        if (localFilePath == null || "".equals(localFilePath.trim())) {
//            return;
//        }
        this.ext = StringUtils.substring(fileName, StringUtils.lastIndexOf(fileName, ".") + 1);
        InputStream is = null;
        try {
            this.size = size;
            this.filename = fileName;

            //读取服务器支持的文件类型列表
            is = getClass().getResourceAsStream("/mime.types");
            MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap(is);
            this.mime = mimetypesFileTypeMap.getContentType(filename);
            this.key = UUID.randomUUID().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }

        }

    }

}
