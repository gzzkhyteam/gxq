package com.hengyunsoft.platform.supervise.util;

import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSelectResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.supervise.constant.ApplicationNode;
import com.hengyunsoft.platform.supervise.impl.constant.SuperviseTypeEnum;
import com.hengyunsoft.utils.BizAssert;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 配置中心转换工具
 * 通常用于将预警库与权限库的id连接起来获得名称，以及时间业务的处理
 */
public class TransUtil {
    /**
     * 将对应的appName查出来
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends ApplicationNode> List<T> transAppName(List<T> list
            , List<ApplicationAllDTO> apps, List<UserSelectResDTO> users) {
        //获取应用列表,用于设置应用名称
        if (apps == null) {
            BizAssert.fail(-1, "应用或用户获取超时");
        }
        List<String> appIds = apps.stream().map(ApplicationAllDTO::getAppId).collect(Collectors.toList());
        List<String> appNames = apps.stream().map(ApplicationAllDTO::getName).collect(Collectors.toList());

        //获取用户,用于设置用户名
        List<Long> userIds = users.stream().map(UserSelectResDTO::getId).collect(Collectors.toList());
        List<String> userNames = users.stream().map(UserSelectResDTO::getName).collect(Collectors.toList());

        //替换
        list.forEach(obj -> {
            if (appIds.contains(obj.getAppId())) {
                obj.setAppName(appNames.get(appIds.indexOf(obj.getAppId())));
                obj.setAppType(apps.get(appIds.indexOf(obj.getAppId())).getAppType());
                obj.setType(apps.get(appIds.indexOf(obj.getAppId())).getType());
            }

            //责任人
            List<String> strs = Arrays.asList(obj.getDutyUser().split(","));
            StringBuffer dutyBuffer = new StringBuffer();
            strs.forEach(str -> {
                if (!StringUtils.isEmpty(str) && userIds.contains(Long.valueOf(str))) {
                    dutyBuffer.append(userNames.get(userIds.indexOf(Long.valueOf(str))));
                } else {
                    dutyBuffer.append("未命名");
                }
                dutyBuffer.append(",");
            });
            obj.setDutyUserName(dutyBuffer.toString().substring(0, dutyBuffer.toString().length() - 1));
            //确认人
            strs = Arrays.asList(obj.getConfirmUser().split(","));
            StringBuffer confirmBuffer = new StringBuffer();
            strs.forEach(str -> {
                if (!StringUtils.isEmpty(str) && userIds.contains(Long.valueOf(str))) {
                    confirmBuffer.append(userNames.get(userIds.indexOf(Long.valueOf(str))));
                } else {
                    confirmBuffer.append("未命名");
                }
                confirmBuffer.append(",");
            });
            obj.setConfirmUserName(confirmBuffer.toString().substring(0, confirmBuffer.toString().length() - 1));
            //抄送人
            strs = StringUtils.isEmpty(obj.getCopyUser()) ? new ArrayList<>()
                    : Arrays.asList(obj.getCopyUser().split(","));
            StringBuffer copyBuffer = new StringBuffer();
            strs.forEach(str -> {
                if (!StringUtils.isEmpty(str) && userIds.contains(Long.valueOf(str))) {
                    copyBuffer.append(userNames.get(userIds.indexOf(Long.valueOf(str))));
                } else {
                    copyBuffer.append("未命名");
                }
                copyBuffer.append(",");
            });
            obj.setCopyUserName(strs.size() == 0 ? null
                    : copyBuffer.toString().substring(0, copyBuffer.toString().length() - 1));
        });

        return list;
    }

    public static <T extends ApplicationNode> T transAppName(T obj
            , List<ApplicationAllDTO> apps, List<UserSelectResDTO> users) {
        //获取应用列表,用于设置应用名称
        if (apps == null) {
            BizAssert.fail(-1, "应用或用户获取超时");
        }
        List<String> appIds = apps.stream().map(ApplicationAllDTO::getAppId).collect(Collectors.toList());
        List<String> appNames = apps.stream().map(ApplicationAllDTO::getName).collect(Collectors.toList());

        //获取用户,用于设置用户名
        List<Long> userIds = users.stream().map(UserSelectResDTO::getId).collect(Collectors.toList());
        List<String> userNames = users.stream().map(UserSelectResDTO::getName).collect(Collectors.toList());

        //替换
        if (appIds.contains(obj.getAppId())) {
            obj.setAppName(appNames.get(appIds.indexOf(obj.getAppId())));
            obj.setAppType(apps.get(appIds.indexOf(obj.getAppId())).getType());
        }

        //责任人
        List<String> strs = Arrays.asList(obj.getDutyUser().split(","));
        StringBuffer dutyBuffer = new StringBuffer();
        strs.forEach(str -> {
            if (!StringUtils.isEmpty(str) && userIds.contains(Long.valueOf(str))) {
                dutyBuffer.append(userNames.get(userIds.indexOf(Long.valueOf(str))));
            } else {
                dutyBuffer.append("未命名");
            }
            dutyBuffer.append(",");
        });
        obj.setDutyUserName(dutyBuffer.toString().substring(0, dutyBuffer.toString().length() - 1));
        //确认人
        strs = Arrays.asList(obj.getConfirmUser().split(","));
        StringBuffer confirmBuffer = new StringBuffer();
        strs.forEach(str -> {
            if (!StringUtils.isEmpty(str) && userIds.contains(Long.valueOf(str))) {
                confirmBuffer.append(userNames.get(userIds.indexOf(Long.valueOf(str))));
            } else {
                confirmBuffer.append("未命名");
            }
            confirmBuffer.append(",");
        });
        obj.setConfirmUserName(confirmBuffer.toString().substring(0, confirmBuffer.toString().length() - 1));
        //抄送人
        strs = StringUtils.isEmpty(obj.getCopyUser()) ? new ArrayList<>()
                : Arrays.asList(obj.getCopyUser().split(","));
        StringBuffer copyBuffer = new StringBuffer();
        strs.forEach(str -> {
            if (!StringUtils.isEmpty(str) && userIds.contains(Long.valueOf(str))) {
                copyBuffer.append(userNames.get(userIds.indexOf(Long.valueOf(str))));
            } else {
                copyBuffer.append("未命名");
            }
            copyBuffer.append(",");
        });
        obj.setCopyUserName(strs.size() == 0 ? null
                : copyBuffer.toString().substring(0, copyBuffer.toString().length() - 1));

        return obj;
    }

    /**
     * 获取一个监管方式转换时间
     *
     * @param date
     * @param typeEnum
     * @param type     1代表取之后的时间，-1表示取之前的时间，默认为1
     * @return
     */
    public static Date getSuperviseTime(Date date, SuperviseTypeEnum typeEnum, int type) {
        type = (type != 1 && type != -1 && type != 0) ? 1 : type;
        Calendar calendar = Calendar.getInstance();
        switch (typeEnum) {
            case HOUR:
                calendar.setTime(getHourFirst(date));
                calendar.add(Calendar.HOUR, type);
                break;
            case DAY:
                calendar.setTime(getDayFirst(date));
                calendar.add(Calendar.DATE, type);
                break;
            case WEEK:
                calendar.setTime(getWeekFirst(date));
                calendar.add(Calendar.DATE, type * 7);
                break;
            case MONTH:
                calendar.setTime(getMonthFirst(date));
                calendar.add(Calendar.MARCH, type);
                break;
        }
        return calendar.getTime();
    }

    /**
     * 获得月首
     *
     * @param date
     * @return
     */
    public static Date getMonthFirst(Date date) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return getDayFirst(cale.getTime());
    }

    /**
     * 获得周首
     *
     * @param date
     * @return
     */
    public static Date getWeekFirst(Date date) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_WEEK, 2);
        return getDayFirst(cale.getTime());
    }

    /**
     * 获得天首
     *
     * @param date
     * @return
     */
    public static Date getDayFirst(Date date) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        return getHourFirst(cale.getTime());
    }

    /**
     * 获得时首
     *
     * @param date
     * @return
     */
    public static Date getHourFirst(Date date) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        return cale.getTime();
    }

    /**
     * 用于消息通知的拼接
     * @param obj
     * @param space
     * @param <T>
     * @return
     */
    public static <T extends ApplicationNode> String splicingWarnMsg(T obj, String space, String reason) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\"" + obj.getAppName() + "\"");
        if (!StringUtils.isEmpty(space)) {
            buffer.append("的" + space.substring(0, space.length() - 1));
        }
        buffer.append("产生预警,");
        if (!StringUtils.isEmpty(reason)){
            buffer.append(reason);
        }
        if (!StringUtils.isEmpty(obj.getDutyUserName())) {
            buffer.append("责任人是" + obj.getDutyUserName() + ",");
        }
        if (!StringUtils.isEmpty(obj.getConfirmUserName())) {
            buffer.append("确认人是" + obj.getConfirmUserName() + ",");
        }
        if (!StringUtils.isEmpty(obj.getCopyUserName())) {
            buffer.append("抄送人是" + obj.getCopyUserName() + ",");
        }
        buffer.append("请及时处理");
        return buffer.toString();
    }
}
