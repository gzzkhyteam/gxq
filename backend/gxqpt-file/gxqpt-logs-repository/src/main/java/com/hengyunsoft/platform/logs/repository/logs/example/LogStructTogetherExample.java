package com.hengyunsoft.platform.logs.repository.logs.example;

import java.io.Serializable;
import java.util.Date;

public class LogStructTogetherExample extends com.hengyunsoft.db.example.BaseExample<LogStructTogetherExample.Criteria> implements Serializable {
    private static final long serialVersionUID = 1L;
    public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {

        public GeneratedCriteria() {
            super();
        }
    }

    /**
     *日志聚合 自定义查询
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {
        public Criteria() {
            super();
        }
        public Criteria andFAppIdIn(java.util.List<String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion(" app_id in ", values, "appId");
            return (Criteria) this;
        }
        public Criteria andFLogTypeIn(java.util.List<String> values) {
            if(values.size()==1 && (null==values.get(0)|| values.get(0).equals(""))){
                return (Criteria) this;
            }
            addCriterion("log_type in ", values, "logType");
            return (Criteria) this;
        }
        public Criteria andFLogTimeGt(Date value) {
            addCriterion(" log_time > ", value, "localTimeStart");
            return (Criteria) this;
        }

        public Criteria andFLogTimeLt(Date value) {
            addCriterion(" log_time < ", value, "localTimeEnd");
            return (Criteria) this;
        }
    }

}
