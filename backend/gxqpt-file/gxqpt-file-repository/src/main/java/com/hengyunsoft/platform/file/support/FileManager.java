package com.hengyunsoft.platform.file.support;

import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.utils.JSONUtils;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.csource.fastdht.FastDHTClient;
import org.csource.fastdht.KeyInfo;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ShenHuaJie
 * @version 2016年6月27日 上午9:51:06
 */
@SuppressWarnings("serial")
@Slf4j
public class FileManager implements Config {
    private TrackerServer trackerServer;
    private StorageServer storageServer;
    private StorageClient storageClient;
    private FastDHTClient fastDHTClient;

    private ExecutorService searchService = Executors.newSingleThreadExecutor();

    static { // Initialize Fast DFS Client configurations
        try {
            //注意：jar 包运行时 需要使用这种方式
            String path = FileManager.class.getResource("/").toString();
            //注意：本地启动运行是，需要使用这种方式
            //String path = FileManager.class.getResource("/").toString().replace("file:/", "/");
            log.info("path={}", path);

            ClientGlobal.init(path + "fdfs_client.conf");

            String trackerHttpPort = "6080";
            log.info("path={}, trackerHttpPort={}", path, trackerHttpPort);
            try {
                ClientGlobal.setG_tracker_http_port(Integer.parseInt(trackerHttpPort));
            } catch (Exception e) {
                log.error("", e);
            }
            org.csource.fastdht.ClientGlobal.init(path + "fdht_client.conf");
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public static FileManager getInstance() {
        return new FileManager();
    }

    private FileManager() {
        try {
            TrackerClient trackerClient = new TrackerClient();
            this.trackerServer = trackerClient.getConnection();
            this.storageClient = new StorageClient(trackerServer, storageServer);
            fastDHTClient = new FastDHTClient(true);
        } catch (Exception ex) {
            log.error("", ex);
        }
    }


    public boolean upload(final FileModel file) {
        log.info("File Name: " + file.getFilename() + ". File Length: " + file.getContent().length);

        final NameValuePair[] meta_list = new NameValuePair[]{
                new NameValuePair("mime", file.getMime()),
                new NameValuePair("size", file.getSize()),
                new NameValuePair("filename", file.getFilename())};

        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        try {
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (IOException e) {
            log.error("IO Exception when uploadind the file: " + file.getFilename(), e);
        } catch (Exception e) {
            log.error("Non IO Exception when uploadind the file: " + file.getFilename(), e);
        }

        if (uploadResults == null) {
            log.error("upload file fail, error code: " + storageClient.getErrorCode());
            throw new BizException(-1, "上传文件异常：" + storageClient.getErrorCode());
        } else {

            final String groupName = uploadResults[0];
            final String remoteFileName = uploadResults[1];

            String fileAbsolutePath = file.getRemoteUriPrefix() + groupName + SEPARATOR + remoteFileName;
            file.setRemotePath(fileAbsolutePath);
            file.setGroupName(groupName);
            file.setRemoteFileName(remoteFileName);
            log.info("upload_file time used: " + (System.currentTimeMillis() - startTime) + " ms. group_name: "
                    + groupName + ", remoteFileName:" + " " + remoteFileName);

            log.info("fileAbsolutePath={}, groupName={}, remoteFileName={}", fileAbsolutePath, groupName, remoteFileName);

            searchService.execute(() -> {
                try {
                    KeyInfo keyInfo = new KeyInfo(file.getNamespace(), file.getObjectId(), file.getKey());
                    FastDfsFile fastDfsFile = new FastDfsFile();
                    fastDfsFile.setGroupName(groupName);
                    fastDfsFile.setFileName(remoteFileName);
                    fastDfsFile.setNameValuePairs(meta_list);
                    fastDHTClient.set(keyInfo, JSONUtils.toJsonString(fastDfsFile, true));
                } catch (Exception e) {
                    log.error("", e);
                }
            });

            return true;
        }
    }

    public boolean upload(String oldGroupName, String oldRemoteFileName,
                          final FileModel file ) {
        try {
            byte[] bytes = storageClient.download_file(oldGroupName, oldRemoteFileName);
            if (bytes != null) {
                log.info("File Name: " + file.getFilename() + ". File Length: " + bytes.length);

                final NameValuePair[] meta_list = new NameValuePair[]{
                        new NameValuePair("mime", file.getMime()),
                        new NameValuePair("size", file.getSize()),
                        new NameValuePair("filename", file.getFilename())};

                long startTime = System.currentTimeMillis();
                String[] uploadResults = null;
                try {
                    uploadResults = storageClient.upload_file(bytes, file.getExt(), meta_list);
                } catch (IOException e) {
                    log.error("IO Exception when uploadind the file: " + file.getFilename(), e);
                } catch (Exception e) {
                    log.error("Non IO Exception when uploadind the file: " + file.getFilename(), e);
                }

                if (uploadResults == null) {
                    log.error("upload file fail, error code: " + storageClient.getErrorCode());
                } else {

                    final String groupName = uploadResults[0];
                    final String remoteFileName = uploadResults[1];

                    String fileAbsolutePath = file.getRemoteUriPrefix() + groupName + SEPARATOR + remoteFileName;
                    file.setRemotePath(fileAbsolutePath);
                    file.setGroupName(groupName);
                    file.setRemoteFileName(remoteFileName);
                    log.info("upload_file time used: " + (System.currentTimeMillis() - startTime) + " ms. group_name: "
                            + groupName + ", remoteFileName:" + " " + remoteFileName);

                    log.info("fileAbsolutePath={}, groupName={}, remoteFileName={}", fileAbsolutePath, groupName, remoteFileName);

                    searchService.execute(() -> {
                        try {
                            KeyInfo keyInfo = new KeyInfo(file.getNamespace(), file.getObjectId(), file.getKey());
                            FastDfsFile fastDfsFile = new FastDfsFile();
                            fastDfsFile.setGroupName(groupName);
                            fastDfsFile.setFileName(remoteFileName);
                            fastDfsFile.setNameValuePairs(meta_list);
                            fastDHTClient.set(keyInfo, JSONUtils.toJsonString(fastDfsFile, true));
                        } catch (Exception e) {
                            log.error("", e);
                        }
                    });
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public FileInfo getFile(String namespace, String objectId, String key) {
        try {
            KeyInfo keyInfo = new KeyInfo(namespace, objectId, key);
            String info = fastDHTClient.get(keyInfo);
            FastDfsFile fastDfsFile = JSONUtils.parse(info, true, FastDfsFile.class);
            return storageClient.get_file_info(fastDfsFile.getGroupName(), fastDfsFile.getFileName());
        } catch (IOException e) {
            log.error("IO Exception: Get File from Fast DFS failed", e);
        } catch (Exception e) {
            log.error("Non IO Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    public int downloadFile(String groupName, String remoteFileName, String localFileName) {
        try {
            return storageClient.download_file(groupName, remoteFileName, localFileName);
        } catch (Exception e) {
            log.error("下载错误", e);
        }
        return -1;
    }


    public boolean deleteFile(String groupName, String remoteFileName) {
        try {
            storageClient.delete_file(groupName, remoteFileName);
            return true;
        } catch (Exception e) {
            log.error("删除错误", e);
            return false;
        }
    }
}
