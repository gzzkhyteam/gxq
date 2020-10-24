package com.hengyunsoft.platform.msgs.repository.msgsmessage.example;

import java.io.Serializable;

public class SmsProviderExample extends com.hengyunsoft.db.example.BaseExample<SmsProviderExample.Criteria> implements Serializable {
	private static final long serialVersionUID = 1L;
	public abstract static class GeneratedCriteria extends com.hengyunsoft.db.example.BaseGeneratedCriteria implements Serializable {
		private static final long serialVersionUID = 1L;
        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
	}
	
	public static class Criteria extends GeneratedCriteria implements Serializable {
		private static final long serialVersionUID = 1L;
		public Criteria() {
            super();
        }
    }
}
