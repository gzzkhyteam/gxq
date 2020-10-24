package com.hengyunsoft.platform.supervise.util;

import com.hengyunsoft.platform.supervise.dto.analysis.AppRulesResDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wz -rf
 * 频繁集的挖掘
 */

public class AproriUtil {
	static boolean endTag = false;

	// k-1频繁集的记数表
	static Map<Integer, Integer> subCountMap = new HashMap<Integer, Integer>();
	// k频繁集的记数表
	static Map<Integer, Integer> originalCountMap = new HashMap<Integer, Integer>();
	// 数据记录表
	static List<List<String>> record = new ArrayList<List<String>>();
	// 最小支持度
	final static double MIN_SUPPORT = 0;
	// 最小置信度
	final static double MIN_CONF = 0;
	// 满足支持度的集合
	static List<List<String>> confItemset = new ArrayList<List<String>>();

	/**
	 * @param lists
	 * 原始数据
	 */
	public static List<AppRulesResDTO> findAssociationRules(List<List<String>> lists) {
		record = lists;
		List<List<String>> firstItemset = findFirstCandidate();
		List<List<String>> supportedItem = getSupportedItem(firstItemset);

		// if:只要能继续挖掘1次,1v1关系;while:只要符合最小xx度则无限挖掘
 		if (endTag != true) {
			// 获取第下一次的备选集
			List<List<String>> nextItemset = getNextCandidate(supportedItem);
			List<List<String>> supportedNextItem = getSupportedItem(nextItemset);
			getConfidencedItemset(supportedNextItem, supportedItem, originalCountMap, subCountMap);
		}
        List<AppRulesResDTO> res = printConfItemset(confItemset);
        confItemset.clear();
        subCountMap.clear();
        subCountMap.putAll(originalCountMap);
		return res;
	}

	/**
	 * @param confItemset2
	 */
	private static List<AppRulesResDTO> printConfItemset(List<List<String>> confItemset2) {
		DecimalFormat df = new DecimalFormat("0.00");
		List<AppRulesResDTO> list = new ArrayList<>();
		for (int i = 0; i < confItemset2.size(); i++) {
			int j = 0;
			AppRulesResDTO dto = new AppRulesResDTO();
			for (j = 0; j < confItemset2.get(i).size() - 3; j++)
				dto.setSource(confItemset2.get(i).get(j));
//			System.out.print("-->");
			dto.setTarget(confItemset2.get(i).get(j++));
			dto.setSupportDegree(Float.valueOf(df.format(Double.parseDouble(confItemset2.get(i).get(j++))*100)));
			dto.setConfidenceDegree(Float.valueOf(df.format(Double.parseDouble(confItemset2.get(i).get(j++))*100)));
			list.add(dto);
		}
		return list;
	}

	/**
	 * @param supportedNextItem
	 * @param supportedItem
	 * @param originalCountMap2
	 * @param subCountMap2
	 */
	private static List<List<String>> getConfidencedItemset(
			List<List<String>> supportedNextItem, List<List<String>> supportedItem,
			Map<Integer, Integer> originalCountMap2, Map<Integer, Integer> subCountMap2) {
		for (int i = 0; i < supportedNextItem.size(); i++) {
			getConfItem(supportedNextItem.get(i), supportedItem, originalCountMap2.get(i),
					subCountMap2);

		}
		return null;
	}

	/**
	 * @param list
	 * @param supportedItem
	 * @param count
	 * @param subCountMap2
	 */
	private static List<String> getConfItem(List<String> list,
											List<List<String>> supportedItem, Integer count,
											Map<Integer, Integer> subCountMap2) {
		for (int i = 0; i < list.size(); i++) {
			List<String> testList = new ArrayList<String>();
			for (int j = 0; j < list.size(); j++)
				if (i != j)
					testList.add(list.get(j));
			int index = findConf(testList, supportedItem);
			Double conf = count * 1.0 / subCountMap2.get(index);
			if (conf > MIN_CONF) {
				testList.add(list.get(i));
				Double relativeSupport = count * 1.0 / (record.size() - 1);
				testList.add(relativeSupport.toString());
				testList.add(conf.toString());
				confItemset.add(testList);
			}
		}
		return null;
	}

	/**
	 * @param testList
	 * @param supportedItem
	 */
	private static int findConf(List<String> testList,
								List<List<String>> supportedItem) {
		for (int i = 0; i < supportedItem.size(); i++) {
			boolean notHaveTag = false;
			for (int j = 0; j < testList.size(); j++) {
				if (haveTheItem(testList.get(j), supportedItem.get(i)) == false) {
					notHaveTag = true;
					break;
				}
			}
			if (notHaveTag == false)
				return i;
		}
		return -1;
	}

	/**
	 * @param string
	 * @param list
	 * @return boolean
	 */
	private static boolean haveTheItem(String string, List<String> list) {
		for (int i = 0; i < list.size(); i++)
			if (string.equals(list.get(i)))
				return true;
		return false;
	}

	/**
	 * @param firstItemset
	 */
	private static List<List<String>> getSupportedItem(
			List<List<String>> firstItemset) {
		boolean end = true;
		List<List<String>> supportedItemset = new ArrayList<List<String>>();
		int k = 0;
		for (int i = 0; i < firstItemset.size(); i++) {
			int count = countFrequent(firstItemset.get(i));
			if (count >= MIN_SUPPORT * (record.size() - 1)) {
				if (firstItemset.get(0).size() == 1)
					subCountMap.put(k++, count);
				else
					originalCountMap.put(k++, count);
				supportedItemset.add(firstItemset.get(i));
				end = false;
			}
		}
		endTag = end;
		return supportedItemset;
	}

	/**
	 * @param list
	 */
	private static int countFrequent(List<String> list) {
		int count = 0;
		for (int i = 1; i < record.size(); i++) {
			boolean notHavaThisList = false;
			for (int k = 0; k < list.size(); k++) {
				boolean thisRecordHave = false;
				for (int j = 1; j < record.get(i).size(); j++) {
					if (list.get(k).equals(record.get(i).get(j)))
						thisRecordHave = true;
				}
				if (!thisRecordHave) {
					notHavaThisList = true;
					break;
				}
			}
			if (notHavaThisList == false)
				count++;
		}
		return count;
	}

	/**
	 * @param firstItemset
	 * @return nextItemset
	 */
	private static List<List<String>> getNextCandidate(
			List<List<String>> firstItemset) {
		List<List<String>> nextItemset = new ArrayList<List<String>>();
		for (int i = 0; i < firstItemset.size(); i++) {
			List<String> tempList = new ArrayList<String>();
			for (int k = 0; k < firstItemset.get(i).size(); k++)
				tempList.add(firstItemset.get(i).get(k));
			for (int h = i + 1; h < firstItemset.size(); h++) {
				for (int j = 0; j < firstItemset.get(h).size(); j++) {
					tempList.add(firstItemset.get(h).get(j));
					if (isSubset(tempList, firstItemset)) {
						List<String> copyValueHelpList = new ArrayList<String>();
						for (int p = 0; p < tempList.size(); p++)
							copyValueHelpList.add(tempList.get(p));
						if (isHave(copyValueHelpList, nextItemset))
							nextItemset.add(copyValueHelpList);
					}
					tempList.remove(tempList.size() - 1);
				}
			}
		}

		return nextItemset;
	}

	/**
	 * @param copyValueList
	 * @param nextItemset
	 * @return boolean
	 */
	private static boolean isHave(List<String> copyValueList,
								  List<List<String>> nextItemset) {
		for (int i = 0; i < nextItemset.size(); i++)
			if (copyValueList.equals(nextItemset.get(i)))
				return false;
		return true;
	}

	/**
	 * @param tempList
	 * @param firstItemset
	 * @return
	 */
	private static boolean isSubset(List<String> tempList,
									   List<List<String>> firstItemset) {
		boolean haveTag = false;
		for (int i = 0; i < tempList.size(); i++) {
			List<String> testList = new ArrayList<String>();
			for (int j = 0; j < tempList.size(); j++)
				if (i != j)
					testList.add(tempList.get(j));
			for (int k = 0; k < firstItemset.size(); k++) {
				if (testList.equals(firstItemset.get(k))) {
					haveTag = true;
					break;
				}
			}
			if (haveTag == false)// 其中一个子集不在k-1频繁集中
				return false;
		}

		return haveTag;
	}

	/**
	 * 第一备选集
	 * @return
	 */
	private static List<List<String>> findFirstCandidate() {
		List<List<String>> tableList = new ArrayList<List<String>>();
		List<String> lineList = new ArrayList<String>();

		int size = 0;
		for (int i = 1; i < record.size(); i++) {
			for (int j = 1; j < record.get(i).size(); j++) {
				if (lineList.isEmpty()) {
					lineList.add(record.get(i).get(j));
				} else {
					boolean haveTheItem = false;
					size = lineList.size();
					for (int k = 0; k < size; k++) {
						if (lineList.get(k).equals(record.get(i).get(j))) {
							haveTheItem = true;
							break;
						}
					}
					if (haveTheItem == false)
						lineList.add(record.get(i).get(j));
				}
			}
		}
		for (int i = 0; i < lineList.size(); i++) {
			List<String> helpList = new ArrayList<String>();
			helpList.add(lineList.get(i));
			tableList.add(helpList);
		}
		return tableList;
	}

}