package com.hengyunsoft.platform.admin.utils;

import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.ExcelParentDTO;
import com.hengyunsoft.utils.BizAssert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFDataValidationHelper;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Excel工具
 *
 * @author wangzhen
 * @createTime 2018-4-25
 */
@Slf4j
public class ExcelUtil {
    public static final String ASTERISK = "*";
    /**
     * 获得地区总名称数组(数组)
     *
     * @param areaTreeList
     * @return
     */
    public static String[] getArray(List<AreaTreeDTO> areaTreeList) {
        StringBuffer buffer = new StringBuffer();
        areaTreeList.forEach(areaTree -> getChiled(areaTree, buffer));
        String str = buffer.toString();
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str.split(",");
    }

    /**
     * 遍历子节点（数组）
     *
     * @param areaTree
     * @param buffer
     */
    private static void getChiled(AreaTreeDTO areaTree, StringBuffer buffer) {
        if (areaTree.getChildren() != null && areaTree.getChildren().size() > 0) {
            buffer.append(areaTree.getName() + ",");
            areaTree.getChildren().forEach(area -> getChiled(area, buffer));
        }
    }

    /**
     * 获得地区总名称数组(map)
     *
     * @param areaTreeList
     * @return
     */
    public static Map<String, String[]> getMap(List<AreaTreeDTO> areaTreeList) {
        Map<String, String[]> map = new HashMap();
        areaTreeList.forEach(areaTree -> getChiled(areaTree, map));
        return map;
    }

    /**
     * 递归遍历子节点（map）
     *
     * @param areaTree
     * @param map
     */
    private static void getChiled(AreaTreeDTO areaTree, Map<String, String[]> map) {
        if (areaTree.getChildren() != null && areaTree.getChildren().size() > 0) {
            List<String> list = areaTree.getChildren().stream().map(AreaTreeDTO::getName).collect(Collectors.toList());
            map.put(areaTree.getName(), list.toArray(new String[list.size()]));
            areaTree.getChildren().forEach(area -> getChiled(area, map));
        }
    }


    /**
     * 设置有效性
     *
     * @param offset 主影响单元格所在列，即此单元格由哪个单元格影响联动
     * @param sheet
     * @param rowNum 行数
     * @param colNum 列数
     */
    public static void setDataValidation(String offset, HSSFSheet sheet, int rowNum, int colNum) {
        HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper(sheet);
        DataValidation data_validation_list;
        data_validation_list = getDataValidationByFormula(
                "INDIRECT(INDIRECT(\"" + offset + "\"&ROW()" + "))", rowNum, colNum, dvHelper);
        sheet.addValidationData(data_validation_list);
    }

    /**
     * 加载下拉列表内容
     *
     * @param formulaString
     * @param naturalRowIndex
     * @param naturalColumnIndex
     * @param dvHelper
     * @return
     */
    private static DataValidation getDataValidationByFormula(
            String formulaString, int naturalRowIndex, int naturalColumnIndex, HSSFDataValidationHelper dvHelper) {
        // 加载下拉列表内容
        DataValidationConstraint dvConstraint = (DataValidationConstraint) dvHelper.createFormulaListConstraint(formulaString);
        // 设置数据有效性加载在哪个单元格上。
        // 四个参数分别是：起始行、终止行、起始列、终止列
        int firstRow = naturalRowIndex - 1;
        int lastRow = naturalRowIndex - 1;
        int firstCol = naturalColumnIndex - 1;
        int lastCol = naturalColumnIndex - 1;
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
                lastRow, firstCol, lastCol);
        // 数据有效性对象
        // 绑定
        HSSFDataValidation data_validation_list = (HSSFDataValidation) dvHelper.createValidation(dvConstraint, regions);
        data_validation_list.setEmptyCellAllowed(false);
        if (data_validation_list instanceof HSSFDataValidation) {
            data_validation_list.setSuppressDropDownArrow(false);
            data_validation_list.setShowErrorBox(true);
        } else {
            data_validation_list.setSuppressDropDownArrow(false);
        }
        // 设置输入信息提示信息
        data_validation_list.createPromptBox("输入提示", "请从下拉列表中选择");
        // 设置输入错误提示信息
        data_validation_list.createErrorBox("选择错误提示", "你输入的值未在备选列表中，请下拉选择合适的值！");
        return data_validation_list;
    }

    /**
     * 计算formula
     *
     * @param offset   偏移量，如果给0，表示从A列开始，1，就是从B列
     * @param rowId    第几行
     * @param colCount 一共多少列
     * @return 如果给入参 1,1,10. 表示从B1-K1。最终返回 $B$1:$K$1
     */
    public static String getRange(int offset, int rowId, int colCount) {
        char start = (char) ('A' + offset);
        if (colCount <= 25) {
            char end = (char) (start + colCount - 1);
            return "$" + start + "$" + rowId + ":$" + end + "$" + rowId;
        } else {
            char endPrefix = 'A';
            char endSuffix = 'A';
            if ((colCount - 25) / 26 == 0 || colCount == 51) {// 26-51之间，包括边界（仅两次字母表计算）
                if ((colCount - 25) % 26 == 0) {// 边界值
                    endSuffix = (char) ('A' + 25);
                } else {
                    endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
                }
            } else {// 51以上
                if ((colCount - 25) % 26 == 0) {
                    endSuffix = (char) ('A' + 25);
                    endPrefix = (char) (endPrefix + (colCount - 25) / 26 - 1);
                } else {
                    endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
                    endPrefix = (char) (endPrefix + (colCount - 25) / 26);
                }
            }
            return "$" + start + "$" + rowId + ":$" + endPrefix + endSuffix + "$" + rowId;
        }
    }

    /**
     * 数字大小控制：设置单元格只能在1-20之间
     *
     * @param firstRow 起始行
     * @param lastRow  终止行
     * @param firstCol 起始列
     * @param lastCol  终止列
     * @return
     */
    public static HSSFDataValidation setValidate(short firstRow, short lastRow, short firstCol, short lastCol) {
        // 创建一个规则：1-100的数字
        DVConstraint constraint = DVConstraint.createNumericConstraint(DVConstraint.ValidationType.INTEGER,
                DVConstraint.OperatorType.BETWEEN, "1", "20");
        // 设定在哪个单元格生效
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        // 创建规则对象
        HSSFDataValidation ret = new HSSFDataValidation(regions, constraint);
        return ret;
    }

    /**
     * 下拉框限制
     *
     * @param startRow   起始行
     * @param endRow     终止行
     * @param startCell  起始列
     * @param endCell    终止列
     * @param dictionary 下拉集合
     * @return
     */
    public static HSSFDataValidation setBoxs(int startRow, int endRow, int startCell, int endCell, String[] dictionary) {
        CellRangeAddressList addressList = new CellRangeAddressList(startRow, endRow, startCell, endCell);
        DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(dictionary);

        HSSFDataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
        dataValidation.setSuppressDropDownArrow(false);
        dataValidation.createPromptBox("输入提示", "请从下拉列表中选择");
        dataValidation.setShowPromptBox(true);

        return dataValidation;
    }

    /**
     * 整数限制(大于等于0)
     *
     * @param startRow  起始行
     * @param endRow    终止行
     * @param startCell 起始列
     * @param endCell   终止列
     * @return
     */
    public static HSSFDataValidation setNum(int startRow, int endRow, int startCell, int endCell) {
        CellRangeAddressList addressList = new CellRangeAddressList(startRow, endRow, startCell, endCell);
        DVConstraint dvConstraint = DVConstraint.createNumericConstraint(DVConstraint.ValidationType.INTEGER,
                DVConstraint.OperatorType.GREATER_OR_EQUAL, "0", "0");

        HSSFDataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
        dataValidation.setSuppressDropDownArrow(false);
        dataValidation.createPromptBox("输入提示", "请输入一个正整数");
        dataValidation.setShowPromptBox(true);

        return dataValidation;
    }

    /**
     * 文本长度限制
     *
     * @param startRow  起始行
     * @param endRow    终止行
     * @param startCell 起始列
     * @param endCell   终止列
     * @param length    文本长度
     * @return
     */
    public static HSSFDataValidation setTextLength(int startRow, int endRow, int startCell, int endCell, int length) {
        CellRangeAddressList addressList = new CellRangeAddressList(startRow, endRow, startCell, endCell);
        DVConstraint dvConstraint = DVConstraint.createNumericConstraint(DVConstraint.ValidationType.TEXT_LENGTH,
                DVConstraint.OperatorType.LESS_OR_EQUAL, Integer.toString(length), Integer.toString(length));

        HSSFDataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
        dataValidation.setSuppressDropDownArrow(false);
        dataValidation.createErrorBox("文本长度错误提示", "你输入文本长度大于" + length + ",请重新输入！");
        dataValidation.setShowPromptBox(true);

        return dataValidation;
    }

    /**
     * 日期格式限制
     *
     * @return
     */
    public static HSSFDataValidation setDate() {
        CellRangeAddressList addressList = new CellRangeAddressList(0, 1, 0, 2);
        DVConstraint dvConstraint = DVConstraint.createDateConstraint(DVConstraint.OperatorType.BETWEEN, "1900-01-01",
                "5000-01-01", "yyyy-mm-dd");

        HSSFDataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
        dataValidation.setSuppressDropDownArrow(false);
        dataValidation.createPromptBox("输入提示", "请填写日期格式");
        // 设置输入错误提示信息
        dataValidation.createErrorBox("日期格式错误提示", "你输入的日期格式不符合'yyyy-mm-dd'格式规范，请重新输入！");
        dataValidation.setShowPromptBox(true);

        return dataValidation;
    }

    /**
     * 对应导入Map的key为Object对应的字段set值
     *
     * @param property 属性
     * @param obj      set对象
     * @param value    值
     */
    public static void setObjectByKey(String property, Object obj, String value) {
        Class clazz = null;
        List<Field> fieldList = new ArrayList<>();
        clazz = obj.getClass();
        while (clazz != null) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        for (Field f : fieldList) {
            if (f.getName().equals(property)) {
                PropertyDescriptor pd = null;
                try {
                    pd = new PropertyDescriptor(f.getName(), obj.getClass());
                    Method wM = pd.getWriteMethod();//获得写方法
                    if (f.getType() == Integer.class) {
                        wM.invoke(obj, Integer.valueOf(value));
                    } else if (f.getType() == String.class) {
                        wM.invoke(obj, String.valueOf(value));
                    }
                } catch (IntrospectionException e) {
                    log.info("Exception",e);
                } catch (IllegalAccessException e) {
                    log.info("Exception",e);
                } catch (InvocationTargetException e) {
                    log.info("Exception",e);
                }
            }
        }
    }

    /**
     * 获取map里value对应的key
     *
     * @param map
     * @param value
     * @return
     */
    public static Object getKey(Map map, Object value) {
        for (Object key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }
        return null;
    }

    /**
     * 必填字段判断
     *
     * @param key       属性
     * @param value     当前列
     * @param necessary 必填字段数组
     * @return
     */
    public static Boolean isNecessary(String key, Cell value, String[] necessary) {
        if (ArrayUtils.indexOf(necessary, key) > -1) {
            if (value != null) {
                value.setCellType(CellType.STRING);
                return !"".equals(value.getStringCellValue());
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 去除excel空行数据
     *
     * @param sheet 当前工作表格
     */
    public static void removeEmpty(Sheet sheet) {
        boolean tag;
        for (int i = sheet.getLastRowNum(); i > 0; i--) {
            tag = false;
            if (sheet.getRow(i) != null) {
                for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
                    if (sheet.getRow(i).getCell(j) != null) {
                        sheet.getRow(i).getCell(j).setCellType(CellType.STRING);
                        if (!"".equals(sheet.getRow(i).getCell(j).getStringCellValue())) {
                            tag = true;
                            continue;
                        }
                    }
                }
                if (!tag) {
                    sheet.removeRow(sheet.getRow(i));
                }
            }
        }
    }

    /**
     * 对象初始属性set
     *
     * @param original 外部附带初始属性的Object
     * @param newborn  当前所需Object
     */
    public static <T, I extends T> void setObjectByOriginal(I original, T newborn) {
        Class clazz = null;
        List<Field> fieldList = new ArrayList<>();
        clazz = newborn.getClass();
        while (clazz != null) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        fieldList.forEach(field -> setData(field, original, newborn));
    }

    /**
     * 属性set方法
     *
     * @param f        当前属性
     * @param original 外部附带初始属性的Object
     * @param newborn  当前所需Object
     * @param <T>
     * @param <I>
     */
    public static <T, I extends T> void setData(Field f, I original, T newborn) {
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor(f.getName(), original.getClass());
            Method wM = pd.getWriteMethod();//获得写方法
            Method wR = pd.getReadMethod();//获得读方法
            Object reader = wR.invoke(newborn);
            if (reader != null) {
                if (f.getType() == Integer.class) {
                    wM.invoke(original, Integer.valueOf(reader.toString()));
                } else if (f.getType() == String.class) {
                    wM.invoke(original, String.valueOf(reader.toString()));
                } else if (f.getType() == Boolean.class) {
                    wM.invoke(original, Boolean.valueOf(reader.toString()));
                }
            }
        } catch (IntrospectionException e) {
            log.info("Exception",e);
        } catch (IllegalAccessException e) {
            log.info("Exception",e);
        } catch (InvocationTargetException e) {
            log.info("Exception",e);
        }
    }

    /**
     * ""转null
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T extends Object> T method(T obj) {
        Class clazz = obj.getClass();
        List<Field> fieldList = new ArrayList<>();
        clazz = obj.getClass();
        while (clazz != null) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        for (Field field : fieldList) {
            PropertyDescriptor pd = null;
            try {
                pd = new PropertyDescriptor(field.getName(),
                        obj.getClass());
            } catch (IntrospectionException e) {
                log.info("Exception",e);
            }
            Method getMethod = pd.getReadMethod();//获得get方法
            try {
                Object o = getMethod.invoke(obj);//执行get方法返回一个Object
                if (o != null && "".equals(o.toString())) {
                    Method setMethod = pd.getWriteMethod();
                    setMethod.invoke(obj, (Object) null);
                }
            } catch (IllegalAccessException e) {
                log.info("Exception",e);
            } catch (InvocationTargetException e) {
                log.info("Exception",e);
            }
        }
        return obj;
    }

    /**
     * Excel读取-导入
     *
     * @param is        文件流
     * @param obj       属性初始化Object
     * @param map       头map(有序)
     * @param NECESSARY 必要字段
     * @param <T>
     * @return
     */
    public static <T extends ExcelParentDTO> List<T> readExcelValue(InputStream is, T obj, LinkedHashMap<String, String> map, String[] NECESSARY, int throwCode) {
        //初始化一些参数
        Workbook wb = null;
        try {
            wb = new HSSFWorkbook(is);
        } catch (IOException e) {
            BizAssert.fail(throwCode,
                    "无法识别你所导入的文件,请依照模板导入正确文件");
            log.info("Exception",e);
        }
        //得到第一个shell
        Sheet sheet = wb.getSheetAt(0);

        //得到Excel的行数
        ExcelUtil.removeEmpty(sheet);

        List<T> objList = new ArrayList<T>();
        T mobj = null;
        //循环Excel行数,从第二行开始。标题不入库
        if (sheet.getLastRowNum() == 0) {
            BizAssert.fail(throwCode,
                    "你导入的文件无任何数据,请检查导入文件！");
        }
        for (int r = 1; r < sheet.getLastRowNum() + 1; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            try {
                mobj = (T) obj.getClass().newInstance();
            } catch (InstantiationException e) {
                log.info("Exception",e);
            } catch (IllegalAccessException e) {
                log.info("Exception",e);
            }

            //循环Excel的列
            Object key;
            for (int c = 0; c < sheet.getRow(0).getLastCellNum(); c++) {
                Cell cell = row.getCell(c);
                key = getKey(map, sheet.getRow(0).getCell(c).getStringCellValue());
                if (key == null) {
                    BizAssert.fail(throwCode,
                            "导入excel于第" + (r + 1) + "行,第" + (char) ('A' + c) + "列出现未识别字段<" + sheet.getRow(0).getCell(c).getStringCellValue() + ">错误,请检查导入文件！");
                }
                if (!isNecessary(key.toString(),
                        cell,
                        NECESSARY)) {
                    BizAssert.fail(throwCode,
                            "导入excel于第" + (r + 1) + "行,第" + (char) ('A' + c) + "列出现错误," + sheet.getRow(0).getCell(c).getStringCellValue() +
                                    "可能是必填项！");
                }
                if (cell != null) {
                    cell.setCellType(CellType.STRING);
                    if (sheet.getRow(0).getCell(c) != null && map.containsValue(sheet.getRow(0).getCell(c).getStringCellValue())) {
                        ExcelUtil.setObjectByKey(ExcelUtil.getKey(map, sheet.getRow(0).getCell(c).getStringCellValue()).toString(),
                                mobj, cell.getStringCellValue());
                    } else {
                        BizAssert.fail(throwCode, "导入excel于第" + (r + 1) + "行,第" + (char) ('A' + c) + "列出现错误,请检查导入文件！");
                    }
                }
            }
            //添加基本信息
            setObjectByOriginal(mobj, obj);
            objList.add(mobj);
        }
        return objList;
    }

    /**
     * Excel写入-导出
     *
     * @param list
     * @return
     */
    public static <T> HSSFWorkbook writeExcelValue(List<T> list, LinkedHashMap<String, String> map) {
        String[] titles = map.values().toArray(new String[map.values().size()]);
        String[] keys = map.keySet().toArray(new String[map.keySet().size()]);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet("sheet");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell hssfCell = null;

        PropertyDescriptor pd = null;
        List<Field> fieldList = new ArrayList();
        Class clazz = null;

        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);//列索引从0开始
            hssfCell.setCellValue(titles[i]);//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            hssfCell.setCellType(CellType.STRING);
        }

        if (list != null && list.size() > 0) {
            clazz = list.get(0).getClass();
            while (clazz != null) {
                fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
                clazz = clazz.getSuperclass();
            }
            for (int i = 0; i < list.size(); i++) {
                hssfRow = hssfSheet.createRow(i + 1);
                for (int j = 0; j < keys.length; j++) {
                    for (Field f : fieldList) {
                        if (f.getName().equals(keys[j])) {
                            try {
                                pd = new PropertyDescriptor(f.getName(), list.get(0).getClass());
                                Method wR = pd.getReadMethod();
                                hssfRow.createCell(j).setCellValue(wR.invoke(list.get(i)) == null ? "" : wR.invoke(list.get(i)).toString());
                            } catch (IntrospectionException e) {
                                log.info("Exception",e);
                            } catch (IllegalAccessException e) {
                                log.info("Exception",e);
                            } catch (InvocationTargetException e) {
                                log.info("Exception",e);
                            }
                        }
                    }
                }
            }
        }
        return workbook;
    }
}
