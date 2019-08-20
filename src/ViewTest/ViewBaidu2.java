package ViewTest;

/*
* DP思路
 *   1，将数组合并为一个数组，对合并的数组最小值进行判断
 *   如果大于0，什么也不做，如果小于0，将所有元素增大同样的数为正数
 *   2，建立三维bool数组， i j k 大小分别为 1<=i<=2n 1<=j<=n 1<=k<=average
 *   3, bool数组含义 前i个物品取了j件总价值之和为k 是否能达到的位置 取值true or false
 *   4，ans = dp[2n][n][s] s<=average 逆序找出最早能到达的位置
 *
 *   注：类似于背包问题的取与不取
 *    时间复杂度和 O(n^2*average) 空间复杂度 n^2 * average
      DP掌握不熟练，给武大丢人了，对不起。
* */

public class ViewBaidu2 {
    public static void main(String[] args){
        int [] array1 = {-2,3,2,1};
        int [] array2 = {-0,6,5,4};
        int n =array1.length;//数组大小

        System.out.print(findMinDiff(array1,array2,n));
    }
    public static int findMinDiff(int[] array1,int[] array2,int n){
        //1合并
        int[] arrays = new int[n*2+1];
        for(int i=0,count =1;i<n;i++){
            arrays[count++] = array1[i];
            arrays[count++] = array2[i];
        }
        //2去除小于0的数 平移
        int minV =0;
        for(int i =1;i<=2*n;i++){
            if(arrays[i]<minV)
                minV = arrays[i];
        }
        if(minV<0){
            for(int i =1;i<=2*n;i++){
                arrays[i] -= minV;
            }
        }
        //3求平均值
        int sum =0 ,average = 0;
        for(int i=1;i<=2*n;i++){
            sum += arrays[i];
        }
        average = sum>>1 ;
        //
        //4 求解最小的 dp[i j k]分别代表第i个数中取 j 个 和等于 k的位置能否到达 100 可以到达 113（可以到达第一个数字为3）
        boolean [][][] dp = new boolean[2*n+1][n+1][average+1];
        dp[1][0][0] = true;dp[0][0][0]=true;
        for(int i =1;i<=2*n ;i++){
            for(int j = 1;j<=Math.min(i,n);j++){
                for(int k = 1;k<=average;k++){
                    if(k>=arrays[i] && dp[i-1][j-1][k-arrays[i]]){//j个数中包含第i个数
                        dp[i][j][k] = dp[i][j][k] || dp[i-1][j-1][k-arrays[i]];
                    }else {//j个数中不包含第i个数
                        dp[i][j][k] = dp[i][j][k] || dp[i-1][j][k];
                    }
                }
            }
        }
        //4 求结果
        int s =average ;
        for(s = average;s>=1 && !dp[2*n][n][s];s--)
            ;
        int ans = sum - 2*s;
        return ans;
    }
}

