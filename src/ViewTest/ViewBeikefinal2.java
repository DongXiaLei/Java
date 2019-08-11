package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/11 20:30
 */
public class ViewBeikefinal2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=0)return;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(findMaxSubSeq(nums,n));
    }
    public static int findMaxSubSeq(int[] nums,int n){
        int ans =1 ;
        int[] dp = new int[n]; //到第i个最长的自增序列值
        dp[0] = 1;
        for(int i=1;i<n;i++){
            int maxBefore = 1;
            for(int j =0;j<i;j++){
                if(nums[j]<=nums[i] && dp[j]>=maxBefore){
                    maxBefore = dp[j]+1;
                }
            }
            dp[i] = maxBefore;
        }
        for(int i =0;i<n;i++){
            if(dp[i]>ans){
                ans = dp[i];
            }
        }
        return ans;
    }
}
