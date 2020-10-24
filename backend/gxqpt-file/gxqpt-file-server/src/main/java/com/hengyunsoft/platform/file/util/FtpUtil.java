package com.hengyunsoft.platform.file.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * @author weiya
 * @date 2018-4-28
 */
@Slf4j
public class FtpUtil {
    /**
     * 获得连接-FTP方式
     *
     * @param host     FTP服务器地址
     * @param port     FTP服务器端口
     * @param userName FTP登录用户名
     * @param passWord FTP登录密码
     * @return FTPClient
     */
    public FTPClient getConnectionFTP(String host, int port, String userName, String passWord) throws Exception {
        //创建FTPClient对象
        FTPClient ftp = new FTPClient();
        ftp.setConnectTimeout(3 * 1000);//设置连接ftp超时时间3秒
        try {
            log.info("host={}, port={},userName={}, passWord={}", host, port, userName, passWord);
            if (port != 0) {
                ftp.connect(host, port);
            } else {
                ftp.connect(host);
            }
            ftp.login(userName, passWord);
            ftp.setControlEncoding("UTF-8");
            ftp.enterLocalPassiveMode();
            ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            //获取状态码，判断是否连接成功

            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                throw new RuntimeException("FTP服务器拒绝连接");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ftp;
    }

    /**
     * 删除文件-FTP方式
     *
     * @param ftp         FTPClient对象
     * @param ftpPath     FTP服务器上传地址
     * @param ftpFileName FTP服务器上要删除的文件名
     * @return
     */
    public boolean deleteFile(FTPClient ftp, String ftpPath, String ftpFileName) throws Exception {
        boolean success = false;
        try {
            log.info("ftpPath={}, ftpFileName={}", ftpPath, ftpFileName);
            ftp.changeWorkingDirectory(ftpPath);//转移到指定FTP服务器目录
            ftpFileName = new String(ftpFileName.getBytes("UTF-8"), "UTF-8");
            ftpPath = new String(ftpPath.getBytes("UTF-8"), "UTF-8");
            ftp.deleteFile(ftpFileName);
            //ftp.logout();
            success = true;
        } catch (Exception e) {
            log.error("删除ftp文件失败", e);
            throw e;
        }
        return success;
    }


    /**
     * 关闭连接-FTP方式
     *
     * @param ftp FTPClient对象
     * @return boolean
     */
    public boolean closeFTP(FTPClient ftp) {
        if (ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
                //System.out.println("Ftp connection closed.");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
