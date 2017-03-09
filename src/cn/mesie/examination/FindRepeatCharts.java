package cn.mesie.examination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 找出重复次数最多的字符串
 * @author meise
 * 2017年3月8日 下午8:50:16
 */
public class FindRepeatCharts {
	
	/**
	 * 统计字符出现的次数
	 * @param string
	 * @return
	 */
	public Map<String, Integer> countChart(String string) {
		char[] chars = string.toCharArray();
		Map map = new HashMap();
		
		for(int i = 0;i < chars.length;i++){
			char c = chars[i];
			boolean isIn = isInMap(map, c);

			if(isIn){
				break;
			}else{
				int num = 1;
				for(int j = i+1;j<chars.length;j++){
					if(chars[j] == c){
						num ++;
					}
				}
				map.put(String.valueOf(c), num);
			}	
		}
		return map;
//		System.out.println(map);
//		System.out.println(chars);
	}
	
	/**
	 * 首先判断该字符是不是已经在map中了
	 * @param map
	 * @param c
	 * @return
	 */
	public boolean isInMap(Map map,char c){
//		Iterator keys = map.keySet().iterator();
		boolean flag = false;
		if(map.containsKey(String.valueOf(c))){
			flag = true;
		}
//		while (keys.hasNext()) {
//			String key = (String) keys.next();
//			if(String.valueOf(c) == key){
//				System.out.println(11);
//				flag = true;
//			}	
//		}
		return flag;
	}
	
	/**
	 * 排序 
	 * @param map
	 * @return
	 */
	public void descSort(Map<String, Integer> map){

		List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
	
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
		    public int compare(Map.Entry<String, Integer> o1,
		            Map.Entry<String, Integer> o2) {
		        return (o2.getValue() - o1.getValue());
		    }
		});
		
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		String str = "adbufrienefnigrgrtmhgigjhiiinf";
		FindRepeatCharts frc = new FindRepeatCharts();
		Map map = frc.countChart(str);
		frc.descSort(map);
	}
}
