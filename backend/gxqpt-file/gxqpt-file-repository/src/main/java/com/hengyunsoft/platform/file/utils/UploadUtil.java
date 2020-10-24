package com.hengyunsoft.platform.file.utils;

import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.support.BaseFileModel;
import com.hengyunsoft.platform.file.support.Config;
import com.hengyunsoft.platform.file.support.FileManager;
import com.hengyunsoft.platform.file.support.FileModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author tyh
 * @createTime 2018-01-23 22:14
 */
@Slf4j
public class UploadUtil {

    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");

    private static final String LINUX_PATH = "/";
    private static final String WIN_PATH = "\\";

    /**
     * 获取上传文件临时目录
     */
    //public static String getUploadDir(String uploadPath) {
    //    if (!uploadPath.endsWith(LINUX_PATH) && !uploadPath.endsWith(WIN_PATH)) {
    //        uploadPath += File.separator;
    //    }
    //    return uploadPath;
    //}

    /**
     * @param inputStream       文件输入流
     * @param submittedFileName 文件真实名
     */
    public static FileModel uploadNotDelete(String appId, String objectId,
                                            FileProperties fileProperties,
                                            InputStream inputStream, String submittedFileName) {
        return upload(appId, objectId, fileProperties, inputStream, submittedFileName, false);
    }

    /**
     * 删除文件 某个路径的某个文件
     * @param absolutePath
     * @param fileName
     */
    public static void deleteTempFile(String absolutePath, String fileName) {
        FileUtils.deleteFile(Paths.get(absolutePath, fileName).toString());
    }


    /**
     * @param inputStream       文件输入流
     * @param submittedFileName 文件真实名
     */
    public static FileModel upload(String appId, String objectId, FileProperties fileProperties, InputStream inputStream, String submittedFileName) {

        return upload(appId, objectId, fileProperties, inputStream, submittedFileName, true);
    }
    /**
     *
     * @param appId
     * @param objectId
     * @param fileProperties
     * @param filePath
     * @return
     */
    public static FileModel upload(String appId, String objectId, FileProperties fileProperties, String filePath) {
        String absolutePath = FileUtils.getAbsolutePath(filePath);
        String relativePath = StringUtils.remove(absolutePath, fileProperties.getUploadPathPrefix() + File.separator);
        String fileName = FileUtils.getFileName(filePath);

        FileModel fastDFSFile = new FileModel(appId, objectId, fileName, absolutePath, relativePath,
                fileProperties.getRemoteUriPrefix(), fileName);
        if(fileProperties.getFastdfs().isEnabled()){
            boolean flag = FileManager.getInstance().upload(fastDFSFile);
            if (flag) {//删除文件服务器上的文件
                deleteTempFile(absolutePath, fileName);
            }
        } else {
            // 将 \ 替换成成 /
            String url = new StringBuilder(fileProperties.getRemoteUriPrefix())
                    .append(relativePath.replaceAll("\\\\", Config.SEPARATOR))
                    .append(Config.SEPARATOR)
                    .append(fileName).toString();
            fastDFSFile.setRemotePath(url);
        }
        return fastDFSFile;
    }

    public static BaseFileModel getBaseFileModel(String appId, String uploadPathPrefix,  String submittedFileName){
        //后缀
        String suffix = FileUtils.getExtension(submittedFileName);
        //生成文件名
        String fileName = UUID.randomUUID().toString() + suffix;
        //日期文件夹
        String secDir = LocalDate.now().format(DTF);
        // /home/tyh/APP_ID/YYYY/MM
        String relativePath = Paths.get(appId, secDir).toString();
        // web服务器存放的绝对路径
        String absolutePath = Paths.get(uploadPathPrefix, relativePath).toString();
        return new BaseFileModel(relativePath, absolutePath, fileName, suffix);
    }



    private static FileModel upload(String appId, String objectId, FileProperties fileProperties,
                                    InputStream inputStream, String submittedFileName, boolean isDel) {
        ////后缀
        //String suffix = FileUtils.getExtension(submittedFileName);
        ////生成文件名
        //String fileName = UUID.randomUUID().toString() + suffix;
        ////日期文件夹
        //String secDir = LocalDate.now().format(DTF);
        //// /home/tyh/APP_ID/YYYY/MM
        //String relativePath = Paths.get(appId, secDir).toString();
        //// web服务器存放的绝对路径
        //String absolutePath = Paths.get(fileProperties.getUploadPathPrefix(), relativePath).toString();

        BaseFileModel bfm = getBaseFileModel(appId, fileProperties.getUploadPathPrefix(), submittedFileName);
        String absolutePath = bfm.getAbsolutePath();
        String relativePath = bfm.getRelativePath();
        String fileName = bfm.getFilename();

                //存到web服务器
        FileUtils.write(inputStream, absolutePath, fileName);

        //启用了fastdfs上传
        FileModel fastDFSFile = new FileModel(appId, objectId, submittedFileName, absolutePath, relativePath,
                fileProperties.getRemoteUriPrefix(), fileName);
        if (fileProperties.getFastdfs().isEnabled()) {
            boolean flag = FileManager.getInstance().upload(fastDFSFile);
            if (flag && isDel) {//删除文件服务器上的文件
                //FileUtils.deleteFile(Paths.get(absolutePath , fileName).toString());
                deleteTempFile(absolutePath, fileName);
            }
        } else {
            // 将 \ 替换成成 /
            String url = new StringBuilder(fileProperties.getRemoteUriPrefix())
                    .append(relativePath.replaceAll("\\\\", Config.SEPARATOR))
                    .append(Config.SEPARATOR)
                    .append(fileName).toString();
            fastDFSFile.setRemotePath(url);
        }
        return fastDFSFile;
    }


    /**
     * 移动文件到fastDFS
     */
    public static FileModel remove2DFS(String namespace, String objectId,
                                       FileProperties fileProperties, String absolutePath,
                                       String relativePath, String
                                               fileName) {
        FileModel fastDFSFile = new FileModel(namespace, objectId, absolutePath, relativePath, fileProperties.getRemoteUriPrefix(), fileName);
        if (fileProperties.getFastdfs().isEnabled() && fastDFSFile.getKey() != null) {
            FileManager.getInstance().upload(fastDFSFile);
        } else {
            // 将 \ 替换成成 /
            String url = new StringBuilder(fileProperties.getRemoteUriPrefix())
                    .append(relativePath.replaceAll("\\\\", Config.SEPARATOR))
                    .append(Config.SEPARATOR)
                    .append(fileName).toString();
            fastDFSFile.setRemotePath(url);
        }
        return fastDFSFile;
    }


}
