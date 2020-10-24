package com.hengyunsoft.platform.logs.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LogIdDTO implements Serializable{
        private Long id;

    private Date logTime;
    /**
     * 统计IP的时候用，其他不用
     */
    private String ip;

}
