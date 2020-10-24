package com.hengyunsoft.platform.admin.utils;

import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.ExcelParentDTO;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptDepartment;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.hengyunsoft.platform.admin.utils.ExcelUtil.writeExcelValue;

public class DpmUtil {
    private static final int startRow = 1;
    private static final int endRow = 101;
    private static final String[] NECESSARY = {"name", "fornodetype", "isenable", "status"};


    /**
     * 导出模板map
     *
     * @return
     */
    public static LinkedHashMap<String, String> exportDpmMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "部门名称");
        map.put("shortName", "部门简称");
        map.put("elseName", "部门其他名");
        map.put("zipcode", "邮编");
        map.put("telcode", "电话");
        map.put("faxcode", "传真");
        map.put("status", "状态");
        map.put("sortvalue", "排序");
        map.put("descrption", "部门介绍");
        map.put("fornodetype", "部门节点类型");
        map.put("orgduty", "部门职责");
        map.put("isenable", "启用标记");
        return map;
    }

    /**
     * Excel模板下载
     *
     * @param areaList
     * @param dictionaryMap
     * @return
     */
    public static HSSFWorkbook templetExcel(List<AreaTreeDTO> areaList, Map<String, String> dictionaryMap) {
        LinkedHashMap<String, String> map = importDpmMap();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell hssfCell = null;

        Iterator iterator = map.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            hssfCell = hssfRow.createCell(index);//列索引从0开始
            Object key = iterator.next();
            hssfCell.setCellValue(map.get(key));//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            hssfCell.setCellType(CellType.STRING);
            if (key.equals("fornodetype")) {
                HSSFDataValidation fornodetypeDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, new String[]{"实体", "分类"});
                hssfSheet.addValidationData(fornodetypeDateVa);
            } else if (key.equals("status")) {
                HSSFDataValidation statusDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, new String[]{"正常", "待撤销", "已撤销"});
                hssfSheet.addValidationData(statusDateVa);
            } else if (key.equals("isenable")) {
                HSSFDataValidation isenableDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, new String[]{"启用", "禁用"});
                hssfSheet.addValidationData(isenableDateVa);
            } else if (key.equals("sortvalue")) {
                HSSFDataValidation sortvalueDateVa = ExcelUtil.setNum(startRow, endRow, index, index);
                hssfSheet.addValidationData(sortvalueDateVa);
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 11);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("descrption")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 800);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("orgduty")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 800);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("name")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 64);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("shortName")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 64);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("elseName")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 64);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("zipcode")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 64);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("telcode")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 64);
                hssfSheet.addValidationData(lengthDV);
            } else if (key.equals("faxcode")) {
                HSSFDataValidation lengthDV = ExcelUtil.setTextLength(startRow, endRow, index, index, 64);
                hssfSheet.addValidationData(lengthDV);
            }
            index++;
        }
        return workbook;
    }

    /**
     * 部门导入
     *
     * @param is
     * @param obj
     * @param <T>
     * @return
     */
    public static <T extends ExcelParentDTO> List<T> readExcelValue(InputStream is, T obj) {
        return ExcelUtil.readExcelValue(is, obj, importDpmMap(),
                NECESSARY, AuthorityExceptionCode.GXQPT_XLS_ERROR.getCode());
    }

    /**
     * 导出部门
     *
     * @param list
     * @return
     */
    public static <T> HSSFWorkbook setCell(List<T> list) {
        return writeExcelValue(list, exportDpmMap());
    }

    /**
     * 导入转换
     *
     * @param list
     * @param dictionarys
     * @return
     */
    public static List<GxqptDepartment> transDictionaryAndArea(List<GxqptDepartment> list, List<Dictionary> dictionarys) {
        //先设置一些初始值
        Map<String, String> map = new HashMap<>();
        map.put("正常", "1");
        map.put("待撤销", "2");
        map.put("已撤销", "3");
        map.put("启用", "1");
        map.put("禁用", "0");
        map.put("实体", "0");
        map.put("分类", "1");

        for (GxqptDepartment org : list) {
            org.setStatus(map.get(org.getStatus()));
            org.setIsenable(map.get(org.getIsenable()));
            org.setFornodetype(map.get(org.getFornodetype()));
        }
        return list;
    }

    /**
     * 导出转换
     *
     * @param list
     * @param dictionarys
     * @return
     */
    public static List<GxqptDepartment> reTransDictionaryAndArea(List<GxqptDepartment> list, List<Dictionary> dictionarys) {
        //先设置一些初始值
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> status = new HashMap<>();
        /*状态标记*/
        status.put("1", "正常");
        status.put("2", "待撤销");
        status.put("3", "已撤销");
        map.put("status", status);
        /*启用标记*/
        Map<String, String> isenable = new HashMap<>();
        isenable.put("1", "启用");
        isenable.put("0", "禁用");
        map.put("isenable", isenable);
        /*节点类型*/
        Map<String, String> nodetype = new HashMap<>();
        nodetype.put("0", "实体");
        nodetype.put("1", "分类");
        map.put("nodetype", nodetype);

        for (GxqptDepartment org : list) {
            org.setStatus(map.get("status").get(org.getStatus()));
            org.setIsenable(map.get("isenable").get(org.getIsenable()));
            org.setFornodetype(map.get("nodetype").get(org.getFornodetype()));
        }
        return list;
    }

    /**
     * 导入模板map
     *
     * @return
     */
    public static LinkedHashMap<String, String> importDpmMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "部门名称");
        map.put("shortName", "部门简称");
        map.put("elseName", "部门其他名");
        map.put("zipcode", "邮编");
        map.put("telcode", "电话");
        map.put("faxcode", "传真");
        map.put("descrption", "部门介绍");
        map.put("fornodetype", "部门节点类型");
        map.put("orgduty", "部门职责");
        map.put("isenable", "启用标记");
        map.put("status", "状态");
        map.put("sortvalue", "排序");
        map.forEach((key, value) -> {
            if (Arrays.asList(NECESSARY).contains(key)) {
                map.put(key, ExcelUtil.ASTERISK + value);
            }
        });
        return map;
    }
}
