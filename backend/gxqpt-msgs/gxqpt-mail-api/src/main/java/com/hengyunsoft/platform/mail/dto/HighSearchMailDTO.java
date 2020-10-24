package com.hengyunsoft.platform.mail.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@Data
@ApiModel(value = "HighSearchMail", description = "搜索邮件")
public class HighSearchMailDTO extends SearchMailDTO {

    @ApiModelProperty(value = "是否在主题中搜素", example = "true,false")
    private Boolean inSubject = false;// 是否在主题中搜素

    @ApiModelProperty(value = "是否在收件人，发件人中搜索", example = "true,false")
    private Boolean inFromOrTo = false;// 是否在收件人，发件人中搜索

    @ApiModelProperty(value = "时间范围")
    private int time = 1;// 时间范围

    @ApiModelProperty(value = "时间单位 1：天 2：周 3：月 4：年", example = "1,2,3,4")
    private int timeType = 4;// 时间单位

    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonIgnore
    private Date date = null;// 通过time 和 timeType运算出的日期

    public Date getDate() {
        date = calculateDate(time, timeType);
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date calculateDate(int time, int timeType) {
        Calendar calendar = Calendar.getInstance();
        switch (timeType) {
            case 1:// 天
                calendar.add(Calendar.DAY_OF_MONTH, -time);
                break;
            case 2:// 周
                calendar.add(Calendar.DAY_OF_MONTH, -(time * 7));
                break;
            case 3:// 月
                calendar.add(Calendar.MONTH, -time);
                break;
            case 4:// 年
                calendar.add(Calendar.YEAR, -time);
                break;
        }
        return calendar.getTime();
    }


}
