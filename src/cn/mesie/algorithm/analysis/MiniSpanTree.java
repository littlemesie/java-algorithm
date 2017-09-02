package cn.mesie.algorithm.analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小生成树算法
 * @author mesie
 *
 * Sep 2, 2017 7:29:07 PM
 */
public class MiniSpanTree {
	static Integer MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int [][] graph ={  
							{ 0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX },  
			                { 10, 0, 18, MAX, MAX, MAX, 16, MAX, 12 },  
			                { MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8 },  
			                { MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21 },  
			                { MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX },  
			                { 11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX },  
			                { MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX },  
			                { MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX },  
			                { MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0 }
                		};  
		MiniSpanTree mst = new MiniSpanTree();
		mst.prim(graph, graph[0].length);
	}
	
	/**
	 * prim算法
	 * @param graph 图
	 * @param n
	 */
	public void prim(int[][] graph,int n){
		char[] c = new char[]{'A','B','C','D','E','F','G','H','I'}; 
		int[] lowcost = new int[n];  //到新集合的最小权   
        int[] mid= new int[n];//存取前驱结点  
        List<Character> list=new ArrayList<Character>();//用来存储加入结点的顺序  
        int i, j, min, minid , sum = 0; 
        //初始化
        for(i=1;i<n;i++){  
            lowcost[i]=graph[0][i];  
//            System.out.print(lowcost[i] + " ");
            mid[i]=0;  
        }  
//        System.exit(0);
        //添加第一个顶点
        list.add(c[0]);  
        //一共需要加入n-1个点  
        for(i=1;i<n;i++){  
             min=MAX;  
             minid=0;  
             //每次找到距离集合最近的点  
             for(j=1;j<n;j++){  
                 if(lowcost[j] != 0 && lowcost[j] < min){  
                     min = lowcost[j];  
                     minid = j;  
                 }  
             }  
               
             if(minid == 0){
            	 return;
             }
             list.add(c[minid]);  
             lowcost[minid]=0;  
             sum += min;  
             System.out.println(c[mid[minid]] + "到" + c[minid] + " 权值：" + min);  
             //加入该点后，更新其它点到集合的距离  
             for(j=1;j<n;j++){  
                 if(lowcost[j] != 0 && lowcost[j] > graph[minid][j]){  
                     lowcost[j] = graph[minid][j];  
                     mid[j] = minid;  
                 }  
             }  
        }  
        System.out.println("sum:" + sum);  
		
	}

}
