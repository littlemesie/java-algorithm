package cn.mesie.logistic;

/**
 * ������:���ݺͱ�ǩ
 * 
 * @author mesie
 *
 * Mar 19, 2017 1:39:16 PM
 */
public class Instance {

	// ����
	public double[] X;
	// ��ǩ
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
