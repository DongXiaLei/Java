package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/12 9:43
 */

/*
拓扑排序
* 给定n m
* n为n个任务 分别命名为 1-n
w[n] 是每个任务完成所需要时间
* m为m个关系 a b 意为 a必须在b之前完成
* 问完成所有任务的最小时间
* 5 4
* 1 2
* 1 3
* 2 3
* 4 5
* */
public class ViewpinDuo3 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int m =in.nextInt();
        if(n<=1)return;
        int[] w = new int[n]; // weight[n]
        int[][] r = new int[m][2];  // relations[m][2]
        for(int i =0;i<n;i++){
            w[i] = in.nextInt();
        }
        for(int i=0;i<m;i++){
            r[i][0] = in.nextInt();
            r[i][1] = in.nextInt();
        }

    }
    public static int findMinRoute(int[] w,int )
}
