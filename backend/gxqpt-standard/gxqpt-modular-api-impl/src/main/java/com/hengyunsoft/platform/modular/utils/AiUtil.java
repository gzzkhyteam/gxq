package com.hengyunsoft.platform.modular.utils;

import java.util.List;

import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNumDO;

public class AiUtil {

	public static Integer getNum(String month,List<ModularNumDO> list,List<String> dates){
		try {
			String year = month.substring(0, 4);
			Integer month_ = DateUtil.getMonthDeleteZero(month.substring(5));
			int newYear = Integer.parseInt(year);
			String markDate = "";
			for(int i=1;i<12;i++){
				Integer newMonth = month_+i;
				if(newMonth>12){
					newYear = Integer.parseInt(year)+1;
					month_ = 1;
				}
				String newDate = newYear+"-"+DateUtil.getMonthAddZero(newMonth.toString());
				if(dates.contains(newDate)){
					markDate = newDate;
					break;
				}
			}
			if(markDate == ""){
				return 0;
			}
			String year1 = markDate.substring(0, 4);
			String month1 = markDate.substring(5).toString();
			for(ModularNumDO modularNumDO:list){
				String year2 = modularNumDO.getYear();
				String month2 = modularNumDO.getMonth();
				if((year2==year1||year2.equals(year1))&&(month2==month1||month2.equals(month1))){					
					return modularNumDO.getModularNum();
				}				
			}
			return 1;
		} catch (Exception e) {
			return null;
		}		
	}
}
