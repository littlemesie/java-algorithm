package cn.mesie.logistic;

import java.util.Arrays;
import java.util.List;

/**
 * logistic 回归
 * @author mesie
 *
 * Mar 19, 2017 12:25:20 PM
 */
public class Logistic {
	
	/**学习率*/
	private double rate;
	/**回归系数*/
	private double[] weights;
	/**迭代次数*/
	private int ITERATIONS = 3000;
	
	//给初始值
	public Logistic(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }
	
	/**
	 * sigmoid函数
	 * @param z
	 * @return
	 */
	private double sigmoid(double z){
		return 1.0 / (1.0 + Math.exp(-z));
	}
	
	/**
	 * 分类函数
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
	 * 训练函数
	 * @param instances
	 */
	public void train(List<Instance> instances){
		for(int n=0;n<ITERATIONS;n++){
            double lik = 0.0;
            for (int i = 0; i < instances.size(); i++) {
            	//数据的前两列
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
		Logistic logistic  = new Logistic(4);//回归系数赋值,初始值都为0
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
