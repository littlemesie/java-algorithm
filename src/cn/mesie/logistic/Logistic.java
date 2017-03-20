package cn.mesie.logistic;

import java.util.Arrays;
import java.util.List;

/**
 * logistic �ع�
 * @author mesie
 *
 * Mar 19, 2017 12:25:20 PM
 */
public class Logistic {
	
	/**ѧϰ��*/
	private double rate;
	/**�ع�ϵ��*/
	private double[] weights;
	/**��������*/
	private int ITERATIONS = 3000;
	
	//����ʼֵ
	public Logistic(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }
	
	/**
	 * sigmoid����
	 * @param z
	 * @return
	 */
	private double sigmoid(double z){
		return 1.0 / (1.0 + Math.exp(-z));
	}
	
	/**
	 * ���ຯ��
	 * @param x
	 * @return
	 */
	private double classify(double[] x) {
        double logit = .0;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * x[i];
            
        }
        return sigmoid(logit);
    }
	
	/**
	 * ѵ������
	 * @param instances
	 */
	public void train(List<Instance> instances){
		for(int n=0;n<ITERATIONS;n++){
            double lik = 0.0;
            for (int i = 0; i < instances.size(); i++) {
            	//���ݵ�ǰ����
            	double[] x = instances.get(i).getX();
            	double predicted = classify(x);
                int label = instances.get(i).getLabel();
                for (int j = 0; j < weights.length; j++) {
                    weights[j] = weights[j] - rate * (predicted - label) * x[j];
                }
                lik -= label * Math.log(classify(x)) + (1-label) * Math.log(1- classify(x));
                
            }
            System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
		}
	}
	
	public static void main(String[] args) {
		List<Instance> dataSet = LoadDataSet.readDataSet("data/logisticdataset.txt");
//		for (Instance instance : dataSet) {
//			double[] datas = instance.getX();
//			
////			System.out.println(datas);	
//		}
		Logistic logistic  = new Logistic(4);//�ع�ϵ����ֵ,��ʼֵ��Ϊ0
		logistic.train(dataSet);
//		System.out.println(logistic.weights.length);
		
		double [] x = {5.0,3.3,1.4,0.2};
        System.out.println("prob(1|x) = " + logistic.classify(x));
        if(logistic.classify(x) < 0.5)
        {
        	System.out.println("this kind  is " + "Setosa");
        }
        else
        {
        	System.out.println("this kind  is " + "Versicolor");
        }
        
        double [] x2 = {5.7,2.8,4.1,1.3};
        System.out.println("prob(1|x2) = " + logistic.classify(x2));
        if(logistic.classify(x2) < 0.5)
        {
        	System.out.println("this kind  is " + "Setosa");
        }
        else
        {
        	System.out.println("this kind  is " + "Versicolor");
        }
	}
}
