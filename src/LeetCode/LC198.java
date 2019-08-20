package LeetCode;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 14:52
 */
/*
* 7
7 70 100 1 10 50 2*/
public class LC198 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        if(n<=0)return;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        if(n<2)return nums[0];
        if(n<3)return nums[0]>nums[1] ? nums[0]:nums[1];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];
        for(int i =3;i<n;i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
        }
        return dp[n-1]>dp[n-2]? dp[n-1]:dp[n-2];
    }
}
