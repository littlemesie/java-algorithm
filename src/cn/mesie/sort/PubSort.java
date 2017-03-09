package cn.mesie.sort;

/**
 * 一些公共的方法
 * @author meise
 * 2016年12月8日 下午10:09:39
 */
public class PubSort {
	
	/**
	 * 对两个元素进行比较
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	
	/**
	 * 交换位置
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void exch(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * 输入排序后的结果
	 * @param a
	 */
	public static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			System.out.println();
		}
	}
	
	/**
	 * 验证
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(less(a[i], a[i-1])){
				return false;
			}
		}
		return true;
	}
}
