//package com.hengyunsoft.security.gete.utils;
//
//import com.hengyunsoft.platform.developer.api.service.api.ModuleUseJnlApi;
//import com.hengyunsoft.platform.developer.api.service.dto.module.ModuleUseJnlSaveDTO;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
///**
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：记录接口调用日志流水
// * 修改人：sunxiaoya
// * 修改时间：2018/4/23
// * 修改内容：
// */
//@Slf4j
//public class DeveloperJnlUtil extends Thread {
//    private static DeveloperJnlUtil developerJnl = null;
//    private static BlockingQueue<ModuleUseJnlSaveDTO> developQueue = new LinkedBlockingQueue<ModuleUseJnlSaveDTO>(1024);
//
//    private ModuleUseJnlApi moduleUseJnlApi;
//
//    public ModuleUseJnlApi getLogService() {
//        return moduleUseJnlApi;
//    }
//
//    public DeveloperJnlUtil setLogService(ModuleUseJnlApi moduleUseJnlApi) {
//        if(this.moduleUseJnlApi==null) {
//            this.moduleUseJnlApi = moduleUseJnlApi;
//        }
//       return this;
//    }
//
//    public static synchronized DeveloperJnlUtil getInstance() {
//        if (developerJnl == null) {
//            developerJnl = new DeveloperJnlUtil();
//        }
//        return developerJnl;
//    }
//
//    private DeveloperJnlUtil() {
//        super("CLogOracleWriterThread");
//    }
//
//    public void offerQueue(ModuleUseJnlSaveDTO dto) {
//        try {
//            developQueue.offer(dto);
//        } catch (Exception e) {
//            log.error("日志写入失败", e);
//        }
//    }
//
//    @Override
//    public void run() {
//        List<ModuleUseJnlSaveDTO> bufferedLogList = new ArrayList<ModuleUseJnlSaveDTO>(); // 缓冲队列
//        while (true) {
//            try {
//                bufferedLogList.add(developQueue.take());
//                developQueue.drainTo(bufferedLogList);
//                if (bufferedLogList != null && bufferedLogList.size() > 0) {
//                    // 写入日志
//                    for(ModuleUseJnlSaveDTO log:bufferedLogList){
//                        moduleUseJnlApi.save(log);
//                }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                // 防止缓冲队列填充数据出现异常时不断刷屏
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception eee) {
//                }
//            } finally {
//                if (bufferedLogList != null && bufferedLogList.size() > 0) {
//                    try {
//                        bufferedLogList.clear();
//                    } catch (Exception e) {
//                    }
//                }
//            }
//        }
//    }
//}