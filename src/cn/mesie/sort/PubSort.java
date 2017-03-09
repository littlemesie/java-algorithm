package cn.mesie.sort;

/**
 * һЩ�����ķ���
 * @author meise
 * 2016��12��8�� ����10:09:39
 */
public class PubSort {
	
	/**
	 * ������Ԫ�ؽ��бȽ�
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	
	/**
	 * ����λ��
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
	 * ���������Ľ��
	 * @param a
	 */
	public static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			System.out.println();
		}
	}
	
	/**
	 * ��֤
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
