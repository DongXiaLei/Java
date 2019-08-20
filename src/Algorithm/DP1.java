package Algorithm;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 11:05
 */
/**
 *
 * 5
 1 -3 -2 -3 -4
 2 3 4 -1 -3
 3 -2 3 -1 5
 2 3 -4 5 6
 2 3 -4 1 3
 */
public class DP1 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=0)return;
        int [][] matrixs = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrixs[i][j] = in.nextInt();
            }
        }
        System.out.println(findMaxSubmatrix(matrixs,n));
        System.out.println(maxSubchuan2(matrixs[2],n));
    }
    public static int findMaxSubmatrix(int[][] matrix,int n){
        int ans =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int [] b = new int[n]; // b[k]记录第i-j行 第k列的和
            for(int j =i;j<n;j++){
                int sum =0; // 对数组b求最大子段和
                for(int k=0;k<n;k++){
                    b[k] += matrix[j][k];
                    sum += b[k];
                    if(sum<b[k]) sum = b[k];
                    if(ans<sum) ans = sum;
                }
            }
        }
        return ans;
    }
    public static int maxSubchuan1(int [] nums,int n){ // 最大子串和
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = nums[0],sum=0;
        for(int i=1;i<n;i++){
            dp[i] += nums[i];
            sum += dp[i];
            if(sum<dp[i])sum = dp[i];
            if(ans<sum) ans = sum;
        }
        return ans;
    }
    public static int maxSubchuan2(int [] nums,int n){ // 最大子串和
        int sum = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++){
            if(sum<0) sum = nums[i];
            else sum += nums[i];
            if(ans<sum) ans = sum;
        }
        return ans;
    }
}
