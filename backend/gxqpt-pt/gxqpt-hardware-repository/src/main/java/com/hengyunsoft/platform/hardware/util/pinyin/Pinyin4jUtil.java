package com.hengyunsoft.platform.hardware.util.pinyin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin4jUtil {
	/**
	 * 提取每个汉字的首字母（处理了多音字）
	 * 
	 * @param str
	 * @return String
	 * @author wgj
	 */
	public static String getPinYinHeadChar(String str) {
		if(str == null){
			return "";
		}
		StringBuffer pinyinName = new StringBuffer();
		char[] nameChar = str.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					// 取得当前汉字的所有全拼
					String[] strs = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
					if (strs != null) {
						for (int j = 0; j < strs.length; j++) {
							// 取首字母
							pinyinName.append(strs[j].charAt(0));
							if (j != strs.length - 1) {
								pinyinName.append(";");
							}
						}
					}
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName.append(nameChar[i]);
			}
			pinyinName.append(" ");
		}
		String convert = parseThePinYin(discountTheTongPinYin(pinyinName.toString()));
		return convert;
	}
	
	/**
	 * 返回没有处理多音字的拼音首字母
	 * @param str
	 * @return
	 */
	public static String getSimplePinyinHeadChar(String str){
		if(str == null){
			return "";
		}
		StringBuffer pinyinName = new StringBuffer();
		char[] nameChar = str.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					// 取得当前汉字的所有全拼
					String[] strs = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
					pinyinName.append(strs[0].charAt(0));
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName.append(nameChar[i]);
			}
		}
		return pinyinName.toString();
	}

	/**
	 * 去掉重复的多音字数据
	 * 
	 * @param str
	 * @return list
	 */
	private static List<Map<String, Integer>> discountTheTongPinYin(
			String theStr) {
		List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();// 去除重复拼音后的拼音list
		Map<String, Integer> onlyOne = null;// 用于处理每个字的多音字，去掉重复
		String[] firsts = theStr.split(" ");
		for (String str : firsts) {// 读出每个汉字的拼音
			onlyOne = new HashMap<String, Integer>();
			String[] china = str.split(";");
			// 多音字处理
			for (String s : china) {
				Integer count = onlyOne.get(s);
				if (count == null) {
					onlyOne.put(s, new Integer(1));
				} else {
					onlyOne.remove(s);
					count++;
					onlyOne.put(s, count);
				}
			}
			mapList.add(onlyOne);
		}
		return mapList;
	}

	/**
	 * 解析并组合拼音
	 */
	private static String parseThePinYin(List<Map<String, Integer>> list) {
		Map<String, Integer> first = null; // 用于统计每一次,集合组合数据
		// 遍历每一组集合
		for (int i = 0; i < list.size(); i++) {
			// 每一组集合与上一次组合的Map
			Map<String, Integer> temp = new Hashtable<String, Integer>();
			// 第一次循环，first为空
			if (first != null) {
				for (String s : first.keySet()) { // 取出上次组合与此次集合的字符，并保存
					for (String s1 : list.get(i).keySet()) {
						String str = s + s1;
						temp.put(str, 1);
					}
				}
				// 清理上一次组合数据
				if (temp != null && temp.size() > 0) {
					first.clear();
				}
			} else {
				for (String s : list.get(i).keySet()) {
					String str = s;
					temp.put(str, 1);
				}
			}
			// 保存组合数据以便下次循环使用
			if (temp != null && temp.size() > 0) {
				first = temp;
			}
		}
		String returnStr = "";
		if (first != null) {
			// 遍历取出组合字符串
			for (String str : first.keySet()) {
				returnStr += (str + ";");
			}
		}
		if (returnStr.length() > 0) {
			returnStr = returnStr.substring(0, returnStr.length() - 1);
		}
		return returnStr;
	}

	public static void main(String[] args) {
		String cnStr = "重庆";
		System.out.println("getPinYinHeadChar=" + getPinYinHeadChar(cnStr));
		System.out.println("getPinYinHeadChar=" + (getPinYinHeadChar(cnStr)).split(";").length);
		System.out.println("getPinYinHeadChar=" + getPinYinHeadChar("单"));
		
		cnStr = "重庆";
		System.out.println("getSimplePinyin=" + getSimplePinyinHeadChar(cnStr));
		System.out.println("getSimplePinyin=" + (getSimplePinyinHeadChar(cnStr)).split(";").length);
		System.out.println("getSimplePinyin=" + getSimplePinyinHeadChar("单"));
	}
}
