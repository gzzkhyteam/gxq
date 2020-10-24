package com.hengyunsoft.platform.admin.impl.utils.inport;

import com.google.common.base.CharMatcher;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpImportDTO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.utils.BizAssert;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:人员信息导入
 *
 * @author chb
 * @date 2018/3/8 14:55
 * @return
 */
public class PaserImportEmpExcelUtil {
    /**
     * excel解析
     *
     * @param list
     * @param in
     * @return
     * @throws Exception
     */
    public static List<GxqptEmpImportDTO> importEmpExcel(List<GxqptEmpImportDTO> list, InputStream in) throws Exception {
        HSSFWorkbook workbook = null;
        int realRows = 0;
        //总列数
        int t_row = 23;
        // 创建对Excel工作簿文件的引用
        try {
            //异常位置,可能加密解密导致
            workbook = new HSSFWorkbook(in);
        } catch (Exception e) {
            BizAssert.fail(AuthorityExceptionCode.GXQPT_EMPXLS_ERROR);
        }
        HSSFSheet sheet = workbook.getSheetAt(0);
        //设置单元格为文本格式
        HSSFCellStyle cellStyle2 = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat();
        cellStyle2.setDataFormat(format.getFormat("@"));
        //获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();
        //有效数据行，不包括空行和空字符串行
        realRows += rows - 1;
        /*判断表头行是否按模板要求设为10列，否则不允许导入 begin*/
        HSSFRow row0 = sheet.getRow(0);
        int column = row0.getPhysicalNumberOfCells();
        if (column != t_row) {
            BizAssert.fail(AuthorityExceptionCode.GXQPT_EMPXLS_ERROR);
        }
        // 遍历行
        for (int i = 1; i < rows; i++) {
            GxqptEmpImportDTO importDTO = new GxqptEmpImportDTO();
            // 读取左上端单元格­
            HSSFRow row = sheet.getRow(i);
            //如果是空白行跳过
            if (row == null) {
                realRows--;
                continue;
            }
            HSSFCell cardNocell = row.getCell(0);
            if (cardNocell == null) {
                realRows--;
                continue;
            }
            //设置单元格为文本格式
            cardNocell.setCellStyle(cellStyle2);
            //表格中内容全都被设置为文本了
            int type = cardNocell.getCellType();
            // type==0表示是表单内容为数值型
            if (type == 0) {
                // 1：表示把表单内容设置为字符串型
                cardNocell.setCellType(1);
            }
            String cardNoValue = replaceBlank(cardNocell.getStringCellValue());
            if (cardNoValue == null || "".equals(cardNoValue.trim())) {
                realRows--;
                continue;
            }
            // 遍历列
            String cellContent;
            for (int j = 0; j < t_row; j++) {
                try {

                    HSSFCell cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    //设置单元格为文本格式
                    Object cellValue;
                    if (j != 6) {
                        cellValue = setCellTypeString(cell, cellStyle2);
                    } else {
                        cell.setCellType(CellType.NUMERIC);
                        cellValue = cell.getNumericCellValue();
                    }
                    //去掉空格
                    cellContent = replaceBlank(String.valueOf(cellValue));
                    //数据处理
                    cellContent = DealContent(cellContent);
                    switch (j) {
                        //姓名
                        case 0:
                            importDTO.setName(cellContent);
                            break;
                        //账号
                        case 1:
                            importDTO.setNickname(cellContent);
                            break;
                        //密码
                        case 2:
                            importDTO.setPassword(cellContent);
                            break;
                        //职务
                        case 3:
                            importDTO.setDutyname(cellContent);
                            break;
                        //岗位
                        case 4:
                            importDTO.setPostname(cellContent);
                            break;
                        //性别
                        case 5:
                            importDTO.setSex(cellContent);
                            break;
                        //生日
                        case 6:
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            if (cellContent != null && !"".equals(cellContent)
                                    && !"null".equals(cellContent) && !"0.0".equals(cellContent)) {
                                cell.setCellType(CellType.NUMERIC);
                                String birthday = "";
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    birthday = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                                }
                                importDTO.setBirthday(birthday);
                            } else {
//                                importDTO.setBirthday(sdf.format(new Date()));
                            }
                            //民族
                        case 7:
                            importDTO.setNation(cellContent);
                            break;
                        //办公电话
                        case 8:
                            importDTO.setOfficetel(cellContent);
                            break;
                        //手机1
                        case 9:
                            importDTO.setMainmobile(cellContent);
                            break;
                        //手机2
                        case 10:
                            importDTO.setSubmobile(cellContent);
                            break;
                        //是否单位管理员
                        case 11:
                            importDTO.setIsorgadmin(cellContent);
                            break;
                        //启用标记
                        case 12:
                            importDTO.setIsenable(cellContent);
                            break;
                        //状态
                        case 13:
                            importDTO.setStatus(cellContent);
                            break;
                        //个人介绍
                        case 14:
                            importDTO.setDescrption(cellContent);
                            break;
                        //是否政协委员
                        case 15:
                            importDTO.setIscommittee(cellContent);
                            break;
                        //是否人大代表
                        case 16:
                            importDTO.setIsdeputy(cellContent);
                            break;
                        //是否单位一把手
                        case 17:
                            importDTO.setIsheader(cellContent);
                            break;
                        //是否单位领导
                        case 18:
                            importDTO.setIsleader(cellContent);
                            break;
                        //人员职责
                        case 19:
                            importDTO.setUserduty(cellContent);
                            break;
                        //统一编号
                        case 20:
                            importDTO.setEmpNo(cellContent);
                            break;
                        //学历
                        case 21:
                            importDTO.setEducation(cellContent);
                            break;
                        //排序值
                        case 22:
                            if (cellContent == null || "".equals(cellContent)) {
                                cellContent = "100000";
                            }
                            importDTO.setSortvalue(Integer.valueOf(cellContent));
                            break;
                        default:
                            break;
                    }
                    //处理结束
                } catch (Exception e) {
                    BizAssert.fail(AuthorityExceptionCode.GXQPT_EMPXLS_ERROR);
                }
            }
            list.add(importDTO);
        }
        return list;
    }

    /**
     * 处理内容
     *
     * @return
     */
    private static String DealContent(String cellContent) {
        String tmp = "";
        switch (cellContent) {
            case "是":
                tmp = "1";
                break;
            case "否":
                tmp = "0";
                break;
            case "男":
                tmp = "1";
                break;
            case "女":
                tmp = "0";
                break;
            //按电子政务网数据字典处理
            case "在职":
                tmp = "1";
                break;
            case "转职中":
                tmp = "2";
                break;
            case "离职":
                tmp = "3";
                break;
            case "退休":
                tmp = "4";
                break;
            case "驻村":
                tmp = "5";
                break;
            case "休假":
                tmp = "6";
                break;
            case "工勤人员":
                tmp = "7";
                break;
            case "其它人员":
                tmp = "8";
                break;
            //学历
            case "博士后":
                tmp = "1";
                break;
            case "博士研究生":
                tmp = "2";
                break;
            case "硕士研究生":
                tmp = "3";
                break;
            case "大学本科":
                tmp = "4";
                break;
            case "大学专科":
                tmp = "5";
                break;
            case "技工学校":
                tmp = "6";
                break;
            case "中等专业学校":
                tmp = "7";
                break;
            case "职业高中":
                tmp = "8";
                break;
            case "普通高级中学":
                tmp = "9";
                break;
            case "初级中学":
                tmp = "10";
                break;
            case "小学":
                tmp = "11";
                break;
            default:
                break;
        }
        if (!"".equals(tmp)) {
            return tmp;
        } else {
            return cellContent;
        }
    }

    /**
     * 替换特殊字符
     */
    private static Pattern S_PATTERN = Pattern.compile("\\s*|\t|\r|\n");

    private static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            //去掉控制字符(\t,\n,\b...)
            dest = CharMatcher.JAVA_ISO_CONTROL.removeFrom(str);
            if (str != null) {
                Matcher m = S_PATTERN.matcher(str);
                dest = m.replaceAll("");
            }
        }
        return dest;
    }

    /**
     * 设置单元格格式
     *
     * @param cell
     * @param cellStyle2
     * @return
     */
    private static Object setCellTypeString(HSSFCell cell, HSSFCellStyle cellStyle2) {
        if (cell == null) {
            return null;
        }
        //设置单元格为文本格式
        cell.setCellStyle(cellStyle2);
        //表格中内容全都被设置为文本了
        int cellType = cell.getCellType();
        if (cell.getCellType() != 1) {
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        }
        cellType = cell.getCellType();
        Object cellValue = null;
        if (cellType == 0) {
            cellValue = cell.getNumericCellValue();
        } else if (cellType == 1) {
            cellValue = cell.getStringCellValue();
        } else if (cellType == 2) {
            cellValue = cell.getCellFormula();
        } else if (cellType == 4) {
            cellValue = cell.getBooleanCellValue();
        } else {
            cellValue = "";
        }
        return cellValue;
    }


    /**
     * 用户信息导出
     *
     * @param list
     * @param response
     */
    public static void exportEmpList(List<GxqptEmp> list, HttpServletResponse response) throws Exception {
        //创建workbook
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("人员信息");
        sheet.setColumnWidth(0, 5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 9000);
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);

        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 13);
        font.setFontName("宋体");
        style.setFont(font);
        Row row0 = sheet.createRow(0);
        Cell cell0_0 = row0.createCell(0);
        cell0_0.setCellValue("姓名");
        cell0_0.setCellStyle(style);
        Cell cell0_1 = row0.createCell(1);
        cell0_1.setCellValue("性别");
        cell0_1.setCellStyle(style);
        Cell cell0_2 = row0.createCell(2);
        cell0_2.setCellValue("生日");
        cell0_2.setCellStyle(style);
        Cell cell0_3 = row0.createCell(3);
        cell0_3.setCellValue("民族");
        cell0_3.setCellStyle(style);
        Cell cell0_4 = row0.createCell(4);
        cell0_4.setCellValue("办公电话");
        cell0_4.setCellStyle(style);
        Cell cell0_5 = row0.createCell(5);
        cell0_5.setCellValue("手机1");
        cell0_5.setCellStyle(style);
        Cell cell0_6 = row0.createCell(6);
        cell0_6.setCellValue("手机2");
        cell0_6.setCellStyle(style);
        Cell cell0_9 = row0.createCell(7);
        cell0_9.setCellValue("是否单位管理员");
        cell0_9.setCellStyle(style);
        Cell cell0_7 = row0.createCell(8);
        cell0_7.setCellValue("账号是否启用");
        cell0_7.setCellStyle(style);
        Cell cell0_8 = row0.createCell(9);
        cell0_8.setCellValue("在职状态");
        cell0_8.setCellStyle(style);
        Cell cell0_10 = row0.createCell(10);
        cell0_10.setCellValue("个人简介");
        cell0_10.setCellStyle(style);
        Cell cell0_11 = row0.createCell(11);
        cell0_11.setCellValue("是否政协委员");
        cell0_11.setCellStyle(style);
        Cell cell0_12 = row0.createCell(12);
        cell0_12.setCellValue("是否人大代表");
        cell0_12.setCellStyle(style);
        Cell cell0_13 = row0.createCell(13);
        cell0_13.setCellValue("是否单位一把手");
        cell0_13.setCellStyle(style);
        Cell cell0_14 = row0.createCell(14);
        cell0_14.setCellValue("是否单位领导");
        cell0_14.setCellStyle(style);
        Cell cell0_15 = row0.createCell(15);
        cell0_15.setCellValue("人员职责");
        cell0_15.setCellStyle(style);
        Cell cell0_16 = row0.createCell(16);
        cell0_16.setCellValue("排序权重值赿小靠前");
        cell0_16.setCellStyle(style);
        Cell cell0_17 = row0.createCell(17);
        cell0_17.setCellValue("职务级别");
        cell0_17.setCellStyle(style);
        //遍历
        for (int j = 0; j < list.size(); j++) {
            GxqptEmp po = list.get(j);
            Row t_row = sheet.createRow(j + 1);
            //姓名
            Cell t_cell_0 = t_row.createCell(0);
            t_cell_0.setCellValue(po.getName());
            t_cell_0.setCellStyle(style);
            //性别
            Cell t_cell_1 = t_row.createCell(1);
            if ("0".equals(po.getSex())) {
                t_cell_1.setCellValue("女");
            } else {
                t_cell_1.setCellValue("男");
            }
            t_cell_1.setCellStyle(style);
            Cell t_cell_2 = t_row.createCell(2);
            t_cell_2.setCellValue(po.getBirthday());
            t_cell_2.setCellStyle(style);
            Cell t_cell_3 = t_row.createCell(3);
            t_cell_3.setCellValue(po.getNation());
            t_cell_3.setCellStyle(style);
            Cell t_cell_4 = t_row.createCell(4);
            t_cell_4.setCellValue(po.getOfficetel());
            t_cell_4.setCellStyle(style);
            Cell t_cell_5 = t_row.createCell(5);
            t_cell_5.setCellValue(po.getMainmobile());
            t_cell_5.setCellStyle(style);
            Cell t_cell_6 = t_row.createCell(6);
            t_cell_6.setCellValue(po.getSubmobile());
            t_cell_6.setCellStyle(style);
            Cell t_cell_7 = t_row.createCell(7);
            t_cell_7.setCellValue(getISNot(po.getIsorgadmin()));
            t_cell_7.setCellStyle(style);
            Cell t_cell_8 = t_row.createCell(8);
            t_cell_8.setCellValue(getISNot(po.getIsenable()));
            t_cell_8.setCellStyle(style);
            Cell t_cell_9 = t_row.createCell(9);
            t_cell_9.setCellValue(getStateOffice(po.getStatus()));
            t_cell_9.setCellStyle(style);
            Cell t_cell_10 = t_row.createCell(10);
            t_cell_10.setCellValue(po.getDescrption());
            t_cell_10.setCellStyle(style);
            Cell t_cell_11 = t_row.createCell(11);
            t_cell_11.setCellValue(getISNot(po.getIscommittee()));
            t_cell_11.setCellStyle(style);
            Cell t_cell_12 = t_row.createCell(12);
            t_cell_12.setCellValue(getISNot(po.getIsdeputy()));
            t_cell_12.setCellStyle(style);
            Cell t_cell_13 = t_row.createCell(13);
            t_cell_13.setCellValue(getISNot(po.getIsheader()));
            t_cell_13.setCellStyle(style);
            Cell t_cell_14 = t_row.createCell(14);
            t_cell_14.setCellValue(getISNot(po.getIsleader()));
            t_cell_14.setCellStyle(style);
            Cell t_cell_15 = t_row.createCell(15);
            t_cell_15.setCellValue(po.getUserduty());
            t_cell_15.setCellStyle(style);
            Cell t_cell_16 = t_row.createCell(16);
            if (po.getSortvalue() == null) {
                t_cell_16.setCellValue("");
            } else {
                t_cell_16.setCellValue(po.getSortvalue());
            }
            t_cell_16.setCellStyle(style);
            Cell t_cell_17 = t_row.createCell(17);
            t_cell_17.setCellValue(po.getDutylevel());
            t_cell_17.setCellStyle(style);
        }
        String filename = "人员信息导出.xls";
        response.setContentType("application/force-download");
        response.setHeader(
                "Content-disposition",
                "attachment; filename="
                        + URLEncoder.encode(filename, "UTF-8"));
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        wb.close();
    }

    private static String getISNot(String value) {
        if ("0".equals(value)) {
            return "否";
        } else if ("1".equals(value)) {
            return "是";
        } else {
            return "";
        }
    }

    private static String getStateOffice(String value) {
        String tmp = "";
        if (value == null) {
            return tmp;
        }
        switch (value) {
            case "1":
                tmp = "在职";
                break;
            case "2":
                tmp = "转职中";
                break;
            case "3":
                tmp = "离职";
                break;
            case "4":
                tmp = "退休";
                break;
            case "5":
                tmp = "驻村";
                break;
            case "6":
                tmp = "休假";
                break;
            case "7":
                tmp = "工勤人员";
                break;
            case "8":
                tmp = "其它人员";
                break;
            default:
                break;
        }
        return tmp;
    }
}
