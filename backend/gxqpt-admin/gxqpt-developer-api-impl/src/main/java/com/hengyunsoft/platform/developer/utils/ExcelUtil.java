package com.hengyunsoft.platform.developer.utils;

import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisListDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationTypeNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.ReducedCostDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsCostDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsTimeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
public class ExcelUtil {
    private static Sheet sheetForTable = null;
    private static int rowForTable = 0;
    private static String filePath = "excel/datas.xls";
    private static Resource resource = new ClassPathResource(filePath);

    private static Sheet readExcelValue() {

        //初始化一些参数
        Workbook wb = null;
        Sheet sheet = null;
        try {
            wb = new HSSFWorkbook(resource.getInputStream());//得到第一个shell
            sheet = wb.getSheetAt(0);
        } catch (IOException e) {
            log.info("Excel读取错误", e);
        }

//
//        //得到Excel的行数
//        ExcelUtil.removeEmpty(sheet);

        return sheet;
    }

    /**
     * 降本分析
     *
     * @return
     */
    public static ApplicationReduceAnalysisDTO getReduceAnalysis() {
        Sheet sheet = readExcelValue();
        ApplicationReduceAnalysisDTO dto = new ApplicationReduceAnalysisDTO();
        for (int r = 1; r < sheet.getLastRowNum() + 1; r++) {
            if (sheet.getRow(r).getCell(0).getStringCellValue().equals("降低建设成本合计(万元)")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("合计")) {
                        dto.setBuild(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("降低使用成本合计(万元)")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("合计")) {
                        dto.setUse(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("降低维护成本合计(万元)")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("合计")) {
                        dto.setProtect(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            }
        }
        return dto;
    }

    /**
     * 组件降本情况
     *
     * @return
     */
    public static ApplicationTypeNumDTO getAssemblyCost() {
        Sheet sheet = readExcelValue();
        ApplicationTypeNumDTO dto = new ApplicationTypeNumDTO();
        for (int r = 1; r < sheet.getLastRowNum() + 1; r++) {
            if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑平台")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总降本")) {
                        dto.setPlatform(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑应用")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总降本")) {
                        dto.setApp(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑服务")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总降本")) {
                        dto.setService(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑模块")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总降本")) {
                        dto.setModule(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            }
        }
        return dto;
    }

    /**
     * 组件增效情况
     *
     * @return
     */
    public static ApplicationTypeNumDTO getAssemblyTime() {
        Sheet sheet = readExcelValue();
        ApplicationTypeNumDTO dto = new ApplicationTypeNumDTO();
        for (int r = 1; r < sheet.getLastRowNum() + 1; r++) {
            if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑平台")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总增效")) {
                        dto.setPlatform(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑应用")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总增效")) {
                        dto.setApp(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑服务")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总增效")) {
                        dto.setService(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            } else if (sheet.getRow(r).getCell(0).getStringCellValue().equals("支撑模块")) {
                for (int c = 0; c < sheet.getRow(r).getLastCellNum(); c++) {
                    if (sheet.getRow(0).getCell(c) != null && sheet.getRow(0).getCell(c).getStringCellValue().equals("总增效")) {
                        dto.setModule(new Double(sheet.getRow(r).getCell(c).getNumericCellValue()).intValue());
                    }
                }
            }
        }
        return dto;
    }

    /**
     * 降本情况
     *
     * @return
     */
    public static RelationStatisticsCostDTO findApplicationReduceCost() {
        Sheet sheet = readExcelValue();
        sheetForTable = sheet;
        // 初始化各个列下标
        int num = 15;
        int build = 16;
        int use = 17;
        int protect = 18;
        int reducecost = 20;
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            if (sheet.getRow(0).getCell(i).equals("合计")) {
                num = i;
            }
            if (sheet.getRow(0).getCell(i).equals("降低-建设成本（万元）")) {
                build = i;
            }
            if (sheet.getRow(0).getCell(i).equals("降低-使用成本（万元）")) {
                use = i;
            }
            if (sheet.getRow(0).getCell(i).equals("降低-维护成本（万元）")) {
                protect = i;
            }
            if (sheet.getRow(0).getCell(i).equals("单个降本值")) {
                reducecost = i;
            }
        }
        RelationStatisticsCostDTO dto = new RelationStatisticsCostDTO();
        for (int r = 1; r < sheet.getLastRowNum() + 1; r++) {
            rowForTable = r;
            if (sheet.getRow(r).getCell(1) != null && sheet.getRow(r).getCell(1).getStringCellValue() != null
                    && !"".equals(sheet.getRow(r).getCell(1).getStringCellValue())) {
                dto.getAppNameList().add(sheet.getRow(r).getCell(1).getStringCellValue());
                dto.getOriginalCostList().add((getValue(build) * getValue(num)));
                dto.getActualReduceCostList().add(getValue(use) * getValue(num));
                dto.getReduceProtectCost().add(getValue(protect) * getValue(num));
                dto.getReduceCostList().add(getValue(reducecost) * getValue(num));
            }
        }
        return dto;
    }

    /**
     * 增效情况
     *
     * @return
     */
    public static RelationStatisticsTimeDTO findApplicationReduceTime() {
        Sheet sheet = readExcelValue();
        // 初始化各个列下标
        int begin = 2;
        int end = 12;

        int rowBegin = 1;
        int rowEnd = 30;

        int scaletime = 19;

        RelationStatisticsTimeDTO dto = new RelationStatisticsTimeDTO();
        Cell cell = null;
        for (int r = rowBegin; r < rowEnd; r++) {
            for (int i = begin; i < end; i++) {
                cell = sheet.getRow(r).getCell(i);
                if (cell.getNumericCellValue() == 1) {
                    dto.getAppNameList().add(sheet.getRow(0).getCell(i).getStringCellValue());
                    dto.getProducerNameList().add(sheet.getRow(r).getCell(1).getStringCellValue());
                    dto.getReduceTimeList().add(sheet.getRow(r).getCell(scaletime).getNumericCellValue());
                }
            }
        }
        return dto;
    }

    /**
     * 组件预估价值
     *
     * @return
     */
    public static ReducedCostDTO componentEstimatedValue() {
        Sheet sheet = readExcelValue();
        // 初始化各个列下标
        int begin = 2;
        int end = 12;

        int[] rowBegin = {1, 7, 16, 28};
        int rowEnd = 3;

        int name = 1;
        int scaletime = 23;
        int scalecost = 21;

        int costTotal = 25;
        int timeTotal = 26;

        ReducedCostDTO dto = new ReducedCostDTO();
        for (int num : rowBegin) {
            for (int r = num; r < rowEnd + num; r++) {
                dto.getNameList().add(sheet.getRow(r).getCell(name).getStringCellValue());
                dto.getReduceCostNumlist().add(sheet.getRow(r).getCell(scalecost).getNumericCellValue());
                dto.getReduceTimeNumlist().add(sheet.getRow(r).getCell(scaletime).getNumericCellValue());
            }
        }

        dto.setReduceTimeTotal(getFormatInt(sheet.getRow(1).getCell(timeTotal).getNumericCellValue()).toString());
        dto.setReduceCostTotal(getFormatInt(sheet.getRow(1).getCell(costTotal).getNumericCellValue()).toString());
        for (int i = 0; i < dto.getReduceCostNumlist().size() - 1; i++) {
            {
                for (int j = 0; j < dto.getReduceCostNumlist().size() - i - 1; j++) {
                    if ((Double) dto.getReduceCostNumlist().get(j) < (Double) (dto.getReduceCostNumlist().get(j + 1))) {
                        Double temp = getFormat((Double) dto.getReduceCostNumlist().get(j));
                        dto.getReduceCostNumlist().set(j, getFormat((Double) dto.getReduceCostNumlist().get(j + 1)));
                        dto.getReduceCostNumlist().set(j + 1, temp);

                        Double costTemp = getFormat((Double) dto.getReduceTimeNumlist().get(j));
                        dto.getReduceTimeNumlist().set(j, getFormat((Double) dto.getReduceTimeNumlist().get(j + 1)));
                        dto.getReduceTimeNumlist().set(j + 1, costTemp);

                        String nameTemp = (String) dto.getNameList().get(j);
                        dto.getNameList().set(j, dto.getNameList().get(j + 1));
                        dto.getNameList().set(j + 1, nameTemp);
                    }
                }
            }
        }
        return dto;
    }


    private static Double getValue(int c) {
        return new Double(sheetForTable.getRow(rowForTable).getCell(c).getNumericCellValue());
    }

    private static Double getFormat(Double f) {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    private static Integer getFormatInt(Double f) {
        int f1 = f.intValue();
        return f1;
    }

    /**
     * 已有降本案例
     *
     * @return
     */
    public static ApplicationReduceAnalysisListDTO reducedExample() {
        Sheet sheet = readExcelValue();
        ApplicationReduceAnalysisListDTO list = new ApplicationReduceAnalysisListDTO();

        int[] cellNum = {2, 3, 10, 14};
        int[] rowNum = {32, 33, 34};
        String str = "";
        for (int i = 0; i < cellNum.length; i++) {
            str = sheet.getRow(0).getCell(cellNum[i]).getStringCellValue();
            list.getNames().add(str.substring(str.indexOf("大数据") == -1 ? 0 : str.indexOf("大数据") + 3, str.length()));
            list.getBuilds().add(sheet.getRow(rowNum[0]).getCell(cellNum[i]).getNumericCellValue());
            list.getUses().add(sheet.getRow(rowNum[1]).getCell(cellNum[i]).getNumericCellValue());
            list.getProtects().add(sheet.getRow(rowNum[2]).getCell(cellNum[i]).getNumericCellValue());
        }
        return list;
    }
}
