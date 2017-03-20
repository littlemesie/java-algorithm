package cn.mesie.logistic;

/**
 * 定义类:数据和标签
 * 
 * @author mesie
 *
 * Mar 19, 2017 1:39:16 PM
 */
public class Instance {

	// 数据
	public double[] X;
	// 标签
	public int label;

	public Instance(int label, double[] data) {
		this.label = label;
		this.X = data;
	}

	public int getLabel() {
		return label;
	}

	public double[] getX() {
		return X;
	}
}
