package cn.mesie.logistic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 将文本数据进行处理
 * @author mesie
 * Mar 19, 2017 1:02:48 PM
 */
public class LoadDataSet {

	/**
	 * 打来文件
	 * @param file
	 * @return
	 */
	public static List<Instance> readDataSet(String filePath){
		List<Instance> dataSet = new ArrayList<Instance>();
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String lines = "";
			while ((lines = br.readLine()) != null) {
//				String[] arrs = lines.split("\\s+");
				String[] arrs = lines.split(",");
				double[] data = new double[arrs.length-1];
				for(int i = 0;i<=arrs.length-2;i++){
					data[i] = Double.parseDouble(arrs[i]);
//					System.out.println(i);
				}
//				System.out.println(arrs[1]);
				int label = Integer.parseInt(arrs[arrs.length-1]);
				Instance instance = new Instance(label, data);
				dataSet.add(instance);
				
			}
			
		} catch (IOException e) {
			System.out.println("文件不存在");
		}
		return dataSet;
	}
}
