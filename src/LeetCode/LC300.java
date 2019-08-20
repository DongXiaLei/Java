package LeetCode;

import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 21:39
 */
public class LC300 {
    public static void main(String[] args){
        int [] nums = {0, 8, 10, 12, 22,45,78};
        System.out.println(Arrays.binarySearch(nums,0,2,46));
        System.out.println(lengthOfLIS2(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums.length<=0)return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && max<dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int ans =0;
        for(int i=0;i<dp.length;i++){
            if(ans<dp[i]){
                ans =dp[i];
            }
        }
        return ans;
    }
    public static int lengthOfLIS2(int[] nums) {
        //  nlogn
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // Arrays.binarySearch() 方法返回搜索键的索引。
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
