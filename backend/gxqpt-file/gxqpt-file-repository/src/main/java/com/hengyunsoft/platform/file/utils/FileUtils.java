package com.hengyunsoft.platform.file.utils;

import com.hengyunsoft.platform.file.config.FileProperties;
import com.hengyunsoft.platform.file.support.FileModel;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * FileUtils on spring-boot-filemanager
 *
 * @author <a href="mailto:akhuting@hotmail.com">Alex Yang</a>
 * @date 2016年08月25日 10:02
 */
public class FileUtils {

    //private static List<String> ExtsDocument = Arrays.asList
    //        (
    //                ".doc", ".docx", ".docm",
    //                ".dot", ".dotx", ".dotm",
    //                ".odt", ".fodt", ".rtf", ".txt",
    //                ".html", ".htm", ".mht",
    //                ".pdf", ".djvu", ".fb2", ".epub", ".xps"
    //        );

    //private static List<String> ExtsSpreadsheet = Arrays.asList
    //        (
    //                ".xls", ".xlsx", ".xlsm",
    //                ".xlt", ".xltx", ".xltm",
    //                ".ods", ".fods", ".csv"
    //        );

    //private static List<String> ExtsPresentation = Arrays.asList
    //        (
    //                ".pps", ".ppsx", ".ppsm",
    //                ".ppt", ".pptx", ".pptm",
    //                ".pot", ".potx", ".potm",
    //                ".odp", ".fodp"
    //        );


    //public static String getFileName(String header) {
    //    String[] tempArr1 = header.split(";");
    //    String[] tempArr2 = tempArr1[2].split("=");
    //    //获取文件名，兼容各种浏览器的写法
    //    return tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
    //}

    //public static String getPermissions(Path path) throws IOException {
    //    if (path.getFileSystem().getSeparator().equals("/")) {
    //        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
    //        PosixFileAttributes readAttributes = fileAttributeView.readAttributes();
    //        Set<PosixFilePermission> permissions = readAttributes.permissions();
    //        return PosixFilePermissions.toString(permissions);
    //    } else {
    //
    //        return "rwxrwxr-x";
    //    }
    //}

    //public static String setPermissions(File file, String permsCode, boolean recursive) throws IOException {
    //    PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(file.toPath(), PosixFileAttributeView.class);
    //    fileAttributeView.setPermissions(PosixFilePermissions.fromString(permsCode));
    //    if (file.isDirectory() && recursive && file.listFiles() != null) {
    //        for (File f : file.listFiles()) {
    //            setPermissions(f, permsCode, true);
    //        }
    //    }
    //    return permsCode;
    //}

    public static byte[] getFileContent(String url) {
        HttpURLConnection connection = null;
        try {
            URL uri = new URL(url);
            connection = (HttpURLConnection) uri.openConnection();// 打开连接
            connection.connect();// 连接会话
            InputStream in = connection.getInputStream();//
            ByteArrayOutputStream bos = null;
            bos = new ByteArrayOutputStream();

            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public static boolean write(InputStream inputStream, String fileUploadPath, String fileName) {
        boolean ret = false;
        //File dir = new File(fileUploadPath);
        //if (!dir.exists()) {
        //    dir.mkdirs();
        //}
        mkFolder(fileUploadPath);

        File file = new File(fileUploadPath + File.separator + fileName);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            ret = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    /**
     * 创建文件价
     *
     * @param fileName
     */
    public static void mkFolder(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    /**
     * 删除文件
     *
     * @param absoluteFileName 文件的绝对路径
     * @return
     */
    public static boolean deleteFile(String absoluteFileName) {
        File f = new File(absoluteFileName);
        return f.delete();
    }

    /**
     * 删除文件，忽略报错
     */
    public static boolean deleteFileOn(String absoluteFileName) {
        try {
            File f = new File(absoluteFileName);
            return f.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //public static File mkFile(String fileName) {
    //    File f = new File(fileName);
    //    try {
    //        f.createNewFile();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //    return f;
    //}

    //public static void fileProber(File dirFile) {
    //    File parentFile = dirFile.getParentFile();
    //    if (!parentFile.exists()) {
    //
    //        // 递归寻找上级目录
    //        fileProber(parentFile);
    //
    //        parentFile.mkdir();
    //    }
    //}

    //public static FileType getFileType(String fileName) {
    //    String ext = getExtension(fileName).toLowerCase();
    //
    //    if (ExtsDocument.contains(ext)) {
    //        return FileType.Text;
    //    }
    //
    //    if (ExtsSpreadsheet.contains(ext)) {
    //        return FileType.Spreadsheet;
    //    }
    //
    //    if (ExtsPresentation.contains(ext)) {
    //        return FileType.Presentation;
    //    }
    //
    //    return FileType.Text;
    //}

    public static String getExtension(String fileName) {
        if (StringUtils.INDEX_NOT_FOUND == StringUtils.indexOf(fileName, ".")) {
            return StringUtils.EMPTY;
        }
        String ext = StringUtils.substring(fileName,
                StringUtils.lastIndexOf(fileName, "."));
        return StringUtils.trimToEmpty(ext);
    }


    public static String getPicName(String fileName) {
        if (StringUtils.INDEX_NOT_FOUND == StringUtils.indexOf(fileName, ".")) {
            return StringUtils.EMPTY;
        }
        String ext = StringUtils.substringBefore(fileName, ".");
        return StringUtils.trimToEmpty(ext);
    }

    public static String getFileName(String filePath) {
        if (StringUtils.INDEX_NOT_FOUND == StringUtils.indexOf(filePath, ".")) {
            return StringUtils.EMPTY;
        }
        String ext = StringUtils.substringAfterLast(filePath, File.separator);
        return StringUtils.trimToEmpty(ext);
    }

    public static String getAbsolutePath(String filePath) {
        if (StringUtils.INDEX_NOT_FOUND == StringUtils.indexOf(filePath, ".")) {
            return StringUtils.EMPTY;
        }
        String ext = StringUtils.substringBeforeLast(filePath, File.separator);
        return StringUtils.trimToEmpty(ext);
    }


    final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM");

    public static String getUploadPathPrefix(String appId, String uploadPathPrefix) {
        //日期文件夹
        String secDir = LocalDate.now().format(DTF);
        // /home/tyh/APP_ID/YYYY/MM
        String relativePath = Paths.get(appId, secDir).toString();
        // web服务器存放的绝对路径
        String absolutePath = Paths.get(uploadPathPrefix, relativePath).toString();
        return absolutePath;
    }

    /**
     * 获取文件MD5
     *
     * @param is
     * @return
     */
    public static String getMD5(InputStream is) {
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int length;
            while ((length = is.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解压zip文件
     *
     * @param appId
     * @param objectId
     * @param fileProperties
     * @param is
     */
    public static List<FileModel> unZip(String appId, String objectId, FileProperties fileProperties, InputStream is) {
        ZipInputStream zipIn;
        ZipEntry zipEntry;
        List<FileModel> list = new ArrayList<>();
        Charset gbk = Charset.forName("GBK");
        try {
            zipIn = new ZipInputStream(new BufferedInputStream(is), gbk);

            while ((zipEntry = zipIn.getNextEntry()) != null) {
                if (zipEntry.isDirectory()) {
                    continue;
                }
                byte[] data = getByte(zipIn);
                InputStream mis = new ByteArrayInputStream(data);
                String filename = zipEntry.getName();
                list.add(UploadUtil.upload(appId, objectId, fileProperties, mis, filename));
            }
            zipIn.closeEntry();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return list;
    }

    /**
     * 获取条目byte[]字节
     *
     * @param zis
     * @return
     */
    static byte[] getByte(InflaterInputStream zis) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            byte[] buf = null;
            int length = 0;

            while ((length = zis.read(temp, 0, 1024)) != -1) {
                bout.write(temp, 0, length);
            }

            buf = bout.toByteArray();
            bout.close();
            return buf;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
