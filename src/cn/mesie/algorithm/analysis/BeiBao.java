package cn.mesie.algorithm.analysis;
/**
 * 0-1��������
 * �ö�̬�滮ʵ��
 * @author mesie
 *
 * Sep 2, 2017 9:53:24 AM
 */
public class BeiBao {
		
	/**
	 * ������м�ֵP(i,j)����� 
	 * @param n ��Ʒ����
	 * @param C ��������
	 * @param w ��������
	 * @param v ��ֵ����
	 * @param D
	 * @return
	 */
	public int[][] fillD(int n,int C,int[] w, int[] v){
		int[][] D = new int[n][C];
		for(int i = 1;i<n;i++){
			for(int j= 1;j<C;j++){
				if(j < w[i]){
					D[i][j] = D[i-1][j];
				}else {
					if(D[i-1][j] > (D[i-1][j-w[i]]+v[i])){
						D[i][j] = D[i-1][j];
					}else {
						D[i][j] = D[i-1][j-w[i]]+v[i];
					}
					
				}
			}
		}
		return D;
	}
	
	/**
	 * ���װ�ط���
	 * @param n
	 * @param C
	 * @param w
	 * @param v
	 * @param X �������
	 * @param D
	 * @return �������м�ֵ
	 */
	public int load(int n,int C,int[] w, int[] v,int[] X,int[][] D){
		int i = n-1;
		int j = C-1;
		while(i>0){
			if(D[i][j] == D[i-1][j]){
				X[i] = 0;
				i--;
			}else{
				X[i] = 1;
				j -= w[i];
				i--;
			}
			
		}
		return D[n][C];
	}
	public static void main(String[] args) {
		int n = 3;
		int C = 10;
		int[] w = {3, 4, 5};
        int[] v  = {4, 5, 6};
        int[] X = new int[3];
        
        BeiBao bb = new BeiBao();
        int[][] D = bb.fillD(n, C, w, v);
        int load = bb.load(n, C, w, v, X, D);
        System.out.println(load);
	}
}
