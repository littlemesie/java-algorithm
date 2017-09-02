package cn.mesie.algorithm.analysis;
/**
 *  
 * @author mesie
 *
 * Mar 9, 2017 8:27:02 PM
 */
public class Fibonacci {
	public long fibonacci(int m){
		long sum = 0;
		if(m == 1){
			sum = 1;
		}else if(m == 2) {
			sum = 2;
		}else {
			sum = fibonacci(m-1) + fibonacci(m -2);;
		}
		return sum;
	}
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		long s = f.fibonacci(10);
		System.out.println(s);
	}
}
