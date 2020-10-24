package com.hengyunsoft.platform.exchange.repository.api.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseAllServiceImpl;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.constant.SystemUsers;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiUseSubscriptionDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiSubscription;
import com.hengyunsoft.platform.exchange.repository.api.dao.ShareDataApiSubscriptionMapper;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiSubscriptionExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiSubscriptionService;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请消息订阅通知Service实现
 * 修改人：zhaopengfei
 * 修改时间：2018/9/17
 * 修改内容：
 */
@Service
@Slf4j
public class ShareDataApiSubscriptionServiceImpl extends BaseAllServiceImpl<Long, ShareDataApiSubscription, ShareDataApiSubscriptionExample> implements ShareDataApiSubscriptionService {

    @Autowired
    ShareDataApiSubscriptionMapper mapper;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;

    @Value("${jdbc.ip}")
    private  String ip;
    @Value("${jdbc.userName}")
    private  String userName;
    @Value("${jdbc.pwd}")
    private  String pwd;
    @Value("${jdbc.port}")
    private  String port;
    @Value("${jdbc.dbName}")
    private  String dbName;
    @Value("${app.id}")
    private  String appId;
    @Value("${app.name}")
    private  String appName;
    @Override
    protected BaseNormalDao<Long, ShareDataApiSubscription, ShareDataApiSubscriptionExample> getDao() {
        return mapper;
    }
    /**
     * 描述：API数据更新定时通知已订阅的用户
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/9/17
     * 修改内容：
     */
    @Override
    public void updateSendNotice() throws Exception {
        //查找结构化API 订阅用户关联的数据集及API最新更新时间及相关信息
        Map<String,Object> param = new HashMap<>();
        param.put("setId",null);
        param.put("dataType",1);
        List<ApiUseSubscriptionDO> subscriptionList = mapper.selectSubcriptionInfoList(param);
        //循环API申请用户，用jdbc连接获取数据仓库中最新更新时间进行比对，如果最新时间比API申请要晚，则通知用户更新
        if (!ObjectUtils.isEmpty(subscriptionList) && subscriptionList.size()>0){
            Date nowDate = new Date();
            for (ApiUseSubscriptionDO sub : subscriptionList){
                //通过jdbc查找当前仓库中最大更新时间
                if (StringUtils.isEmpty(sub.getTableName()) || ObjectUtils.isEmpty(sub.getApplyUserId())){
                    continue;
                }
                Date wareUpdateTime =  getLastUpdateTime(sub.getTableName());
                Date lastUpdateTime = sub.getLastUpdateTime();
                List<Long> userIds = new ArrayList<>();
                userIds.add(sub.getApplyUserId());
                //如果存在数据并且更新时间不能为空
                if (!ObjectUtils.isEmpty(wareUpdateTime)){
                    //如果该申请没有通知过
                    if (ObjectUtils.isEmpty(sub.getSubId())){
                        saveSendMsg(sub.getApplyId(),sub.getApiName(),userIds);
                        ShareDataApiSubscription subscription = new ShareDataApiSubscription();
                        subscription.setApplyId(sub.getApplyId());
                        subscription.setCreateTime(nowDate);
                        subscription.setCreateUser(SystemUsers.gxqptSystem.getId());
                        subscription.setLastUpdateTime(nowDate);
                        subscription.setUpdateUser(SystemUsers.gxqptSystem.getId());
                        subscription.setNoticeTime(nowDate);
                        this.save(subscription);
                        continue;
                    }else {
                        //如果该申请通知过，并且更新时间小于数据仓库最新更新时间，则发送通知消息并修改最新更新时间
                        if (lastUpdateTime.getTime()<wareUpdateTime.getTime()){
                            saveSendMsg(sub.getApplyId(),sub.getApiName(),userIds);
                            ShareDataApiSubscription subscription = new ShareDataApiSubscription();
                            subscription.setId(sub.getSubId());
                            subscription.setLastUpdateTime(nowDate);
                            subscription.setUpdateTime(nowDate);
                            mapper.updateByPrimaryKeySelective(subscription);
                        }else {
                            continue;
                        }
                    }
                }
            }
        }

    }
    /**
     * 描述：用于数据集非结构化目录修改文件后发送订阅更新消息
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/9/17
     * 修改内容：
     */
    @Override
    public void saveUnStructNotice(Long setId) {
        if (!ObjectUtils.isEmpty(setId)){
            Map<String,Object> param = new HashMap<>();
            param.put("setId",setId);
            param.put("dataType",2);
            List<ApiUseSubscriptionDO> subscriptionList = mapper.selectSubcriptionInfoList(param);
            if (!ObjectUtils.isEmpty(subscriptionList) && subscriptionList.size()>0){
                for (ApiUseSubscriptionDO sub : subscriptionList){
                    List<Long> userIds = new ArrayList<>();
                    userIds.add(sub.getApplyUserId());
                    saveSendMsg(sub.getApplyId(),sub.getApiName(),userIds);
                }
            }
        }

    }

    public void saveSendMsg(Long applyId,String apiName,List<Long> userIds){
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(appId);
        bbsAllMainMsgDTO.setAppName(appName);
        bbsAllMainMsgDTO.setBizId(applyId.toString());
        bbsAllMainMsgDTO.setBizType("add_module");
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setBriefTpye("work_auth");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setContent("您申请的API"+apiName+"有数据更新，请及时更新!");
        bbsAllMainMsgDTO.setTitle("您申请的API"+apiName+"有数据更新，请及时更新!");
        bbsAllMainMsgDTO.setDetailedType("module_add_apply");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setDetailedTypeDesc("目录申请");
        bbsAllMainMsgDTO.setHandlerUrl("module/index?promUrl=/gxqpt-exchange/module/applyList");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO,userIds , null);
    }

    public Date getLastUpdateTime(String tableName) throws Exception {
        Date lastUpdateTime =null;
        if (StringUtils.isEmpty(tableName)) {
            return lastUpdateTime;
        }
        Connection connection = getConnection();
        if (!exitTable(tableName, connection)) {
            return lastUpdateTime;
        }
        //查询
        try {
            connection.setAutoCommit(false);
            //从正式表更新最近10条数据到过度表，保证后面的修改的争取性
            String selectSql = "SELECT MAX(synctime) lastUpdateTime FROM  " + tableName;
            PreparedStatement stmt = connection.prepareStatement(selectSql);
            ResultSet rs = null;
            rs = stmt.executeQuery();
            while (rs.next()) {
                 lastUpdateTime = rs.getTimestamp("lastUpdateTime");
            }
            rs.close();
            stmt.close();
            connection.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return lastUpdateTime;
    }

    /* 获取数据库连接的函数*/
    public  Connection getConnection() {
        Connection conn = null;  //创建用于连接数据库的Connection对象
        try {
            Class.forName("com.mysql.jdbc.Driver");
            StringBuffer url = new StringBuffer("jdbc:mysql");
            url.append("://");
            url.append(ip);
            url.append(":");
            url.append(port);
            url.append("/");
            url.append(dbName);
            url.append("?useUnicode=true&characterEncoding=utf-8");
            String urls = url.toString();
            conn = DriverManager.getConnection(urls, userName, pwd);
        } catch (Exception e) {
            log.error("数据仓库连接失败", e);
        }
        return conn;  //返回所建立的数据库连接
    }

    /**
     * 判断表是否存在
     *
     * @param tabName
     * @return
     */
    public static boolean exitTable(String tabName, Connection conn) throws Exception {
        boolean flag = false;
        try {
            ResultSet rs = conn.getMetaData().getTables(null, null, tabName, null);
            if (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {

        }
        return flag;
    }
}
