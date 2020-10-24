package com.hengyunsoft.platform.hardware.constant;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessData {
    private  Map<String,Process> processMap;

    private ProcessData(){
        processMap = new HashMap<>();

        //草稿
        Process draft = new Process(null,StepConstant.MANAGE_AUTH_DRAFT.getStepCode(),StepConstant.MANAGE_AUTH_DRAFT.getStepCode());
        processMap.put(StepConstant.DRAFT.getStepCode(),draft);

        //管理员
        Process manage = new Process(StepConstant.DRAFT.getStepCode(),StepConstant.YOUYI_HANDLER.getStepCode(),StepConstant.ROBACK.getStepCode());
        processMap.put(StepConstant.MANAGE_AUTH_DRAFT.getStepCode(),manage);

        //国信优易
        Process youyi = new Process(StepConstant.MANAGE_AUTH_DRAFT.getStepCode(),StepConstant.END.getStepCode(),StepConstant.MANAGE_AUTH_EXT.getStepCode());
        processMap.put(StepConstant.YOUYI_HANDLER.getStepCode(),youyi);

        //重申
        Process cs = new Process(StepConstant.MANAGE_AUTH_DRAFT.getStepCode(),StepConstant.END.getStepCode(),StepConstant.DRAFT.getStepCode());
        processMap.put(StepConstant.ROBACK.getStepCode(),cs);

        //管理员扩审
        Process ks = new Process(StepConstant.YOUYI_HANDLER.getStepCode(),StepConstant.YIYUN_HANDLER.getStepCode(),StepConstant.ROBACK.getStepCode());
        processMap.put(StepConstant.MANAGE_AUTH_EXT.getStepCode(),ks);

        //采购处理
        Process yiyun = new Process(StepConstant.MANAGE_AUTH_EXT.getStepCode(),StepConstant.YIYUN_ADD_HOST.getStepCode(),StepConstant.ROBACK.getStepCode());
        processMap.put(StepConstant.YIYUN_HANDLER.getStepCode(),yiyun);

        //新增硬件
        Process ap = new Process(StepConstant.YIYUN_HANDLER.getStepCode(),StepConstant.YOUYI_FINAL.getStepCode(),StepConstant.YOUYI_FINAL.getStepCode());
        processMap.put(StepConstant.YIYUN_ADD_HOST.getStepCode(),ap);

        //分配
        Process fp = new Process(StepConstant.YIYUN_ADD_HOST.getStepCode(),StepConstant.END.getStepCode(),StepConstant.END.getStepCode());
        processMap.put(StepConstant.YOUYI_FINAL.getStepCode(),fp);

    }

    public Map<String,Process> getProcess() {
        return processMap;
    }


    public static class Process{

        private String prior;
        private String next_true;
        private String next_false;

        public Process(String prior,String next_true,String next_false){
            this.prior = prior;
            this.next_true = next_true;
            this.next_false = next_false;
        }

        public String getPrior() {
            return prior;
        }

        public String getNextStep(boolean flag){
            if(flag){
                return next_true;
            }
            return  next_false;
        }

    }
}
