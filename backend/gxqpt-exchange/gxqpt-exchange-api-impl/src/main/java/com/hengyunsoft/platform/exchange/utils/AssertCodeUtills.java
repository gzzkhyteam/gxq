package com.hengyunsoft.platform.exchange.utils;

import com.hengyunsoft.platform.exchange.api.set.dto.SelectDirectoryReqDTO;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.util.List;

public class AssertCodeUtills {
    /***
     * 得到定义的exceptcode名称:api方法名_参数名_字段名
     * @param apiMethodName
     * @param dtoClass
     * @param f
     * @return
     */
    private static String getFiledExceptionName(String apiMethodName, Class<?> dtoClass, Field f) {
        apiMethodName = apiMethodName.toUpperCase();
        f.setAccessible(true);
        StringBuffer sb = new StringBuffer(apiMethodName);
        sb.append("_");
        sb.append(dtoClass.getSimpleName().toUpperCase());
        sb.append("_");
        String fieldName = f.getName().toUpperCase();
        sb.append(fieldName);
        return sb.toString();

    }

    /***
     * 打印出exceptcode的名称,宝包含在exceptcode的定义，和在api实现里面的方法注解
     * @param apiMethodName  方法名
     * @param dtoClass dto类
     * @param startCodeNum  开始编码好
     */
    public static void printExceptionCodename(String apiMethodName, Class<?> dtoClass, int startCodeNum) {
        {
            apiMethodName = apiMethodName.toUpperCase();
            Field[] fields = dtoClass.getDeclaredFields();
            int enumStar = startCodeNum;
            int apiApiResponsesStart = startCodeNum;

            for (Field f : fields) {
                f.setAccessible(true);
                ApiModelProperty annotation = f.getAnnotation(ApiModelProperty.class);
                if (annotation == null) {
                    continue;
                }
                // DATA_SET_CREATE_DATASETPARAM_NULL(85500, "创建数据集参数不能为空"),
                String filedExceptionName = getFiledExceptionName(apiMethodName, dtoClass, f);
                StringBuffer sb = new StringBuffer(filedExceptionName);
                sb.append("(");
                sb.append(enumStar);//错误码
                sb.append(",");
                sb.append("\"");
                String msg = annotation.value() + ",不能为空";//提示消息
                sb.append(msg);
                sb.append("\"");
                sb.append("),");
                System.out.println(sb.toString());
                enumStar++;
            }

            System.out.println("--------------------------我是华丽丽的分隔线------------------");

            for (Field f : fields) {
                ApiModelProperty annotation = f.getAnnotation(ApiModelProperty.class);
                if (annotation == null) {
                    continue;
                }
                //  @ApiResponse(code = 80000, message = "创建索引数据不能为空"),
                String filedExceptionName = getFiledExceptionName(apiMethodName, dtoClass, f);
                StringBuffer sb = new StringBuffer("@ApiResponse");
                sb.append("(");
                sb.append("code = ");
                sb.append(apiApiResponsesStart);//错误码
                sb.append(",");
                sb.append("message = ");
                sb.append("\"");
                String msg = annotation.value() + "，不能为空";//提示消息
                sb.append(msg);
                sb.append("\"),");
                System.out.println(sb.toString());
                apiApiResponsesStart++;
            }
            System.out.println("--------------------------我是华丽丽的分隔线------------------");
            for (Field f : fields) {
                ApiModelProperty annotation = f.getAnnotation(ApiModelProperty.class);
                if (annotation == null) {
                    continue;
                }
                //  BizAssert.assertNotNull(ExchangeExceptionCode.DEMAND_NULL, dto);
                //  BizAssert.assertNotNull(ExchangeExceptionCode.HDDEPT_NULL, dto.getOrgId());

                String filedExceptionName = getFiledExceptionName(apiMethodName, dtoClass, f);
                StringBuffer sb = new StringBuffer("BizAssert");
                sb.append(".");
                if (f.getType() == String.class || f.getType().isAssignableFrom(List.class)) {
                    sb.append("assertNotEmpty");
                } else {
                    sb.append("assertNotNull");
                }
                sb.append("(");
                sb.append("ExchangeExceptionCode");
                sb.append(".");
                sb.append(filedExceptionName);
                sb.append(",");
                sb.append("dto." + "get");
                sb.append(f.getName().substring(0, 1).toUpperCase());
                sb.append(f.getName().substring(1));
                sb.append("()");
                sb.append(");");
                System.out.println(sb.toString());
                apiApiResponsesStart++;
            }

        }

        System.out.println("-------完成了，直接复制过去使用吧----------");

    }

    public static void main(String[] args) {
        printExceptionCodename("selectDic", SelectDirectoryReqDTO.class, 85547);
        //        Long  a= 1231213123123L;
        //        Long b=1231213123123L;
        //        System.out.println(a == b);
    }

}
