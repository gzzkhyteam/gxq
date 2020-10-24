package com.hengyunsoft.platform.admin.utils;

import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.ExcelParentDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgExportDTO;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.utils.BizAssert;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFName;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hengyunsoft.platform.admin.utils.ExcelUtil.getArray;
import static com.hengyunsoft.platform.admin.utils.ExcelUtil.getMap;
import static com.hengyunsoft.platform.admin.utils.ExcelUtil.getRange;
import static com.hengyunsoft.platform.admin.utils.ExcelUtil.setDataValidation;
import static com.hengyunsoft.platform.admin.utils.ExcelUtil.writeExcelValue;

public class OrgUtil {
    private static final int startRow = 1;
    private static final int endRow = 101;
    private static final String[] NECESSARY = {"name", "forClass", "forType", "forindustry", "forgk", "fornodetype", "telcode", "isenable", "status"};
    private static final String CITY = "市州";
    private static final String COUNTRY = "地区";
    private static final String TOWN = "乡镇";

    /**
     * 导出模板map
     *
     * @return
     */
    public static LinkedHashMap<String, String> exportOrgMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "单位名称");
        map.put("shortName", "单位简称");
        map.put("elseName", "单位其他名");
        map.put("forType", "所属类型");
        map.put("forClass", "所属级别");
        map.put("forindustry", "所属系统");
        map.put("zipcode", "邮编");
        map.put("telcode", "电话");
        map.put("faxcode", "传真");
        map.put("descrption", "单位介绍");
        map.put("forarea", "所属省份");
        map.put("forcity", "所属市州");
        map.put("forcounty", "所属区县");
        map.put("fortown", "所属乡镇");
        map.put("forgk", "单位归口");
        map.put("fornodetype", "单位节点类型");
        map.put("orgduty", "单位职责");
        map.put("isenable", "启用标记");
        map.put("status", "状态");
        map.put("sortvalue", "排序");
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
        LinkedHashMap<String, String> map = importOrgMap();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell hssfCell = null;

        //记录省市区街的下标
        int area = 0;
        int city = 0;
        int county = 0;
        int town = 0;

        Iterator iterator = map.keySet().iterator();
        int index = 0;
        while (iterator.hasNext()) {
            hssfCell = hssfRow.createCell(index);//列索引从0开始
            Object key = iterator.next();
            hssfCell.setCellValue(map.get(key));//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            hssfCell.setCellType(CellType.STRING);
            if (key.equals("forType")) {
                HSSFDataValidation forTypeDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, dictionaryMap.get("forType").split(","));
                hssfSheet.addValidationData(forTypeDateVa);
            } else if (key.equals("forClass")) {
                HSSFDataValidation forClassDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, dictionaryMap.get("forClass").split(","));
                hssfSheet.addValidationData(forClassDateVa);
            } else if (key.equals("forindustry")) {
                HSSFDataValidation forindustryDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, dictionaryMap.get("forindustry").split(","));
                hssfSheet.addValidationData(forindustryDateVa);
            } else if (key.equals("forgk")) {
                HSSFDataValidation forgkDateVa = ExcelUtil.setBoxs(startRow, endRow, index, index, dictionaryMap.get("forgk").split(","));
                hssfSheet.addValidationData(forgkDateVa);
            } else if (key.equals("fornodetype")) {
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
            } else if (key.equals("forarea")) {
                area = index;
            } else if (key.equals("forcity")) {
                city = index;
            } else if (key.equals("forcounty")) {
                county = index;
            } else if (key.equals("fortown")) {
                town = index;
            }
            index++;
        }

        if (areaList != null && areaList.size() > 0) {
            //得到第一级省名称，放在列表里
            String[] provinceArr = areaList.stream().map(AreaTreeDTO::getName).collect(Collectors.toList())
                    .toArray(new String[areaList.stream().map(AreaTreeDTO::getName).collect(Collectors.toList()).size()]);
            //将有子区域的父区域放到一个数组中
            String[] areaFatherNameArr = getArray(areaList);
            Map<String, String[]> areaMap = getMap(areaList);

            //创建一个专门用来存放地区信息的隐藏sheet页
            //因此也不能在现实页之前创建，否则无法隐藏。
            Sheet hideSheet = workbook.createSheet("area");
            //这一行作用是将此sheet隐藏，功能未完成时注释此行,可以查看隐藏sheet中信息是否正确
            workbook.setSheetHidden(workbook.getSheetIndex(hideSheet), true);

            int rowId = 0;
            // 设置第一行，存省的信息
            Row provinceRow = hideSheet.createRow(rowId++);
            provinceRow.createCell(0).setCellValue("省列表");
            for (int i = 0; i < provinceArr.length; i++) {
                Cell provinceCell = provinceRow.createCell(i + 1);
                provinceCell.setCellValue(provinceArr[i]);
            }
            // 将具体的数据写入到每一行中，行开头为父级区域，后面是子区域。
            for (int i = 0; i < areaFatherNameArr.length; i++) {
                String key = areaFatherNameArr[i];
                String[] son = areaMap.get(key);
                Row row = hideSheet.createRow(rowId++);
                row.createCell(0).setCellValue(key);
                if (son != null) {
                    for (int j = 0; j < son.length; j++) {
                        Cell cell = row.createCell(j + 1);
                        cell.setCellValue(son[j]);
                    }
                }

                // 添加名称管理器
                String range = getRange(1, rowId, son.length);
                HSSFName name = workbook.createName();
                //key不可重复
                name.setNameName(key);
                String formula = "area!" + range;
                name.setRefersToFormula(formula);
            }

            HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper((HSSFSheet) hssfSheet);
            // 省规则
            DataValidationConstraint provConstraint = dvHelper.createExplicitListConstraint(provinceArr);
            // 四个参数分别是：起始行、终止行、起始列、终止列
            CellRangeAddressList provRangeAddressList = new CellRangeAddressList(1, 100, area, area);
            DataValidation provinceDataValidation = dvHelper.createValidation(provConstraint, provRangeAddressList);
            //验证
            provinceDataValidation.createErrorBox("error", "请选择正确的省份");
            provinceDataValidation.setShowErrorBox(true);
            provinceDataValidation.setSuppressDropDownArrow(false);
            hssfSheet.addValidationData(provinceDataValidation);

            //对前20行设置有效性
            for (int cell = 2; cell < 101; cell++) {
                setDataValidation(String.valueOf((char) ('A' + city - 1)), hssfSheet, cell, city + 1);
                setDataValidation(String.valueOf((char) ('A' + county - 1)), hssfSheet, cell, county + 1);
                setDataValidation(String.valueOf((char) ('A' + town - 1)), hssfSheet, cell, town + 1);
            }
        }
        return workbook;
    }

    /**
     * 导出单位
     *
     * @param list
     * @return
     */
    public static <T> HSSFWorkbook setCell(List<T> list) {
        return writeExcelValue(list, exportOrgMap());
    }

    /**
     * 单位导入
     *
     * @param is
     * @param obj
     * @param <T>
     * @return
     */
    public static <T extends ExcelParentDTO> List<T> readExcelValue(InputStream is, T obj) {
        return ExcelUtil.readExcelValue(is, obj, importOrgMap(),
                NECESSARY, AuthorityExceptionCode.GXQPT_XLS_ERROR.getCode());
    }

    /**
     * 导入转换
     *
     * @param list
     * @param dictionarys
     * @param areaTrees
     * @return
     */
    public static List<GxqptOrg> transDictionaryAndArea(List<GxqptOrg> list, List<Dictionary> dictionarys, List<AreaTreeDTO> areaTrees) {
        //先设置一些初始值
        Map<String, String> map = new HashMap<>();
        map.put("正常", "1");
        map.put("待撤销", "2");
        map.put("已撤销", "3");
        map.put("启用", "1");
        map.put("禁用", "0");
        map.put("实体", "0");
        map.put("分类", "1");

        for (GxqptOrg org : list) {
            //遍历字典
            if (dictionarys != null && dictionarys.size() > 0) {
                for (Dictionary dictionary : dictionarys) {
                    if (dictionary.getName() != null) {
                        if (dictionary.getName().equals(org.getForType())) {
                            org.setForType(dictionary.getCode());
                        } else if (dictionary.getName().equals(org.getForClass())) {
                            org.setForClass(dictionary.getCode());
                        } else if (dictionary.getName().equals(org.getForindustry())) {
                            org.setForindustry(dictionary.getCode());
                        } else if (dictionary.getName().equals(org.getForgk())) {
                            org.setForgk(dictionary.getCode());
                        }
                    }
                }
            }
            //遍历地区
            if (areaTrees != null && areaTrees.size() > 0) {
                for (AreaTreeDTO areaTree : areaTrees) {
                    if (org.getForarea() != null && org.getForarea().equals(areaTree.getName())) {
                        org.setForarea(String.valueOf(areaTree.getId()));
                        for (AreaTreeDTO cityTree : areaTree.getChildren()) {
                            if (org.getForcity() != null && org.getForcity().equals(cityTree.getName())) {
                                org.setForcity(String.valueOf(cityTree.getId()));
                                for (AreaTreeDTO countyTree : cityTree.getChildren()) {
                                    if (org.getForcounty() != null && org.getForcounty().equals(countyTree.getName())) {
                                        org.setForcounty(String.valueOf(countyTree.getId()));
                                        for (AreaTreeDTO townTree : countyTree.getChildren()) {
                                            if (org.getFortown() != null && org.getFortown().equals(townTree.getName())) {
                                                org.setFortown(String.valueOf(townTree.getId()));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            org.setIsenable(map.get(org.getIsenable()));
            org.setStatus(map.get(org.getStatus()));
            org.setFornodetype(map.get(org.getFornodetype()));
        }
        return list;
    }

    public static void areaThrow(List<GxqptOrg> list, GxqptOrg org, AreaTreeDTO areaTree, String position) {
        BizAssert.fail(AuthorityExceptionCode.GXQPT_XLS_ERROR.getCode(), "Excel于第" + list.indexOf(org) + "行出现错误,选择了不存在的" + position);
    }

    /**
     * 导出转换
     *
     * @param list
     * @param dictionarys
     * @param areaTrees
     * @return
     */
    public static List<GxqptOrgExportDTO> reTransDictionaryAndArea(List<GxqptOrgExportDTO> list, List<Dictionary> dictionarys, List<AreaTreeDTO> areaTrees) {
        //先设置一些初始值
        Map<String, Map<String, String>> map = new HashMap<>();
        /*状态标记*/
        Map<String, String> status = new HashMap<>();
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

        for (GxqptOrgExportDTO org : list) {
            //遍历字典
            if (dictionarys != null && dictionarys.size() > 0) {
                for (Dictionary dictionary : dictionarys) {
                    if (dictionary.getCode() != null) {
                        if (dictionary.getCode().equals(org.getForType())) {
                            org.setForType(dictionary.getName());
                        } else if (dictionary.getCode().equals(org.getForClass())) {
                            org.setForClass(dictionary.getName());
                        } else if (dictionary.getCode().equals(org.getForindustry())) {
                            org.setForindustry(dictionary.getName());
                        } else if (dictionary.getCode().equals(org.getForgk())) {
                            org.setForgk(dictionary.getName());
                        }
                    }
                }
            }
            //遍历地区
            if (areaTrees != null && areaTrees.size() > 0) {
                for (AreaTreeDTO areaTree : areaTrees) {
                    if (org.getForarea() != null && org.getForarea().equals(areaTree.getId().toString())) {
                        org.setForarea(areaTree.getName());
                        for (AreaTreeDTO cityTree : areaTree.getChildren()) {
                            if (org.getForcity() != null && org.getForcity().equals(cityTree.getId().toString())) {
                                org.setForcity(cityTree.getName());
                                for (AreaTreeDTO countyTree : cityTree.getChildren()) {
                                    if (org.getForcounty() != null && org.getForcounty().equals(countyTree.getId().toString())) {
                                        org.setForcounty(countyTree.getName());
                                        for (AreaTreeDTO townTree : countyTree.getChildren()) {
                                            if (org.getFortown() != null && org.getFortown().equals(townTree.getId().toString())) {
                                                org.setFortown(townTree.getName());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

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
    public static LinkedHashMap<String, String> importOrgMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "单位名称");
        map.put("shortName", "单位简称");
        map.put("elseName", "单位其他名");
        map.put("forType", "所属类型");
        map.put("forClass", "所属级别");
        map.put("forindustry", "所属系统");
        map.put("zipcode", "邮编");
        map.put("telcode", "电话");
        map.put("faxcode", "传真");
        map.put("descrption", "单位介绍");
        map.put("forarea", "所属省份");
        map.put("forcity", "所属市州");
        map.put("forcounty", "所属区县");
        map.put("fortown", "所属乡镇");
        map.put("forgk", "单位归口");
        map.put("fornodetype", "单位节点类型");
        map.put("orgduty", "单位职责");
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
