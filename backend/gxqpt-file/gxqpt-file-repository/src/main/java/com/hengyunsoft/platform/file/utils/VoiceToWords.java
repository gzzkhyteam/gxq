//package com.hengyunsoft.platform.file.utils;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.iflytek.msp.cpdb.lfasr.client.LfasrClientImp;
//import com.iflytek.msp.cpdb.lfasr.exception.LfasrException;
//import com.iflytek.msp.cpdb.lfasr.model.LfasrType;
//import com.iflytek.msp.cpdb.lfasr.model.Message;
//import com.iflytek.msp.cpdb.lfasr.model.ProgressStatus;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.HashMap;
//
//
//@Slf4j
//public class VoiceToWords {
//    // 原始音频存放地址
//    private static final String local_file = "F:\\KuGou\\0703.mp3";
//    /*
//     *转写类型选择：标准版和电话版分别为：
//     *LfasrType.LFASR_STANDARD_RECORDED_AUDIO 和 LfasrType.LFASR_TELEPHONY_RECORDED_AUDIO
//     */
//
//    //public static final LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
//    // 等待时长（秒）
//    private static int sleepSecond = 20;
//
//
//    public static String voiceToWords(String taskId, String url) {
//        // 加载配置文件
//        //PropertyConfigurator.configure("log4j.properties");
//
//        // 初始化LFASR实例
//        LfasrClientImp lc = null;
//        try {
//            lc = LfasrClientImp.initLfasrClient();
//        } catch (LfasrException e) {
//            // 初始化异常，解析异常描述信息
//            Message initMsg = JSON.parseObject(e.getMessage(), Message.class);
//            log.info("ecode=" + initMsg.getErr_no());
//            log.info("failed=" + initMsg.getFailed());
//        }
//
//        // 获取上传任务ID
//        // String task_id = "gxqpt_android";
//        HashMap<String, String> params = new HashMap<>();
//        params.put("has_participle", "true");
//        try {
//            LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
//            // 上传音频文件
//            Message uploadMsg = lc.lfasrUpload(url, type, params);
//
//            // 判断返回值
//            int ok = uploadMsg.getOk();
//            if (ok == 0) {
//                // 创建任务成功
//                taskId = uploadMsg.getData();
//                log.info("task_id=" + taskId);
//            } else {
//                // 创建任务失败-服务端异常
//                log.info("ecode=" + uploadMsg.getErr_no());
//                log.info("failed=" + uploadMsg.getFailed());
//            }
//        } catch (LfasrException e) {
//            // 上传异常，解析异常描述信息
//            Message uploadMsg = JSON.parseObject(e.getMessage(), Message.class);
//            log.info("ecode=" + uploadMsg.getErr_no());
//            log.info("failed=" + uploadMsg.getFailed());
//        }
//
//        // 循环等待音频处理结果
//        while (true) {
//            try {
//                // 睡眠1min。另外一个方案是让用户尝试多次获取，第一次假设等1分钟，获取成功后break；失败的话增加到2分钟再获取，获取成功后break；再失败的话加到4分钟；8分钟；……
//                Thread.sleep(sleepSecond * 1000);
//                log.info("waiting ...");
//            } catch (InterruptedException e) {
//            }
//            try {
//                // 获取处理进度
//                Message progressMsg = lc.lfasrGetProgress(taskId);
//
//                // 如果返回状态不等于0，则任务失败
//                if (progressMsg.getOk() != 0) {
//                    log.info("task was fail. task_id:" + taskId);
//                    log.info("ecode=" + progressMsg.getErr_no());
//                    log.info("failed=" + progressMsg.getFailed());
//
//                    // 服务端处理异常-服务端内部有重试机制（不排查极端无法恢复的任务）
//                    // 客户端可根据实际情况选择：
//                    // 1. 客户端循环重试获取进度
//                    // 2. 退出程序，反馈问题
//                    continue;
//                } else {
//                    ProgressStatus progressStatus = JSON.parseObject(progressMsg.getData(), ProgressStatus.class);
//                    if (progressStatus.getStatus() == 9) {
//                        // 处理完成
//                        log.info("task was completed. task_id:" + taskId);
//                        break;
//                    } else {
//                        // 未处理完成
//                        log.info("task was incomplete. task_id:" + taskId + ", status:" + progressStatus.getDesc());
//                        continue;
//                    }
//                }
//            } catch (LfasrException e) {
//                // 获取进度异常处理，根据返回信息排查问题后，再次进行获取
//                Message progressMsg = JSON.parseObject(e.getMessage(), Message.class);
//                log.info("ecode=" + progressMsg.getErr_no());
//                log.info("failed=" + progressMsg.getFailed());
//            }
//        }
//
//        // 获取任务结果
//        String dataOneBast = "";
//        String oneBast = "";
//        try {
//            Message resultMsg = lc.lfasrGetResult(taskId);
//            log.info(resultMsg.getData());
//            // 如果返回状态等于0，则任务处理成功
//            if (resultMsg.getOk() == 0) {
//                // 打印转写结果
//                String data = resultMsg.getData();
//                JSONArray jsonArray = JSONArray.parseArray(data);
//
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    dataOneBast = jsonObject.getString("onebest");
//                    oneBast += dataOneBast;
//                }
//                log.info(oneBast);
//                log.info(resultMsg.getData());
//            } else {
//                // 转写失败，根据失败信息进行处理
//                log.info("ecode=" + resultMsg.getErr_no());
//                log.info("failed=" + resultMsg.getFailed());
//            }
//        } catch (LfasrException e) {
//            // 获取结果异常处理，解析异常描述信息
//            Message resultMsg = JSON.parseObject(e.getMessage(), Message.class);
//            log.info("ecode=" + resultMsg.getErr_no());
//            log.info("failed=" + resultMsg.getFailed());
//        }
//        return oneBast;
//        //return null;
//    }
//    //public static void main(String[] args) {
//    //    String task_id="gxqpt_android";
//    //    voiceToWords(task_id,local_file);
//    //}
//
//
//}
