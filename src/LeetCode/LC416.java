package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/16 15:09
 */
public class LC416 {
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,5,5,5,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        if(nums.length<=1)return false;
        int  sum =0;
        for(int ele:nums){
            sum+= ele;
        }
        boolean[] dp = new boolean[sum];
        if(sum%2 == 1)return false;
        else {
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<dp.length;j++){
                    if(dp[j]==true && (j+nums[i])<dp.length && !set.contains(j)){
                        if(dp[j+nums[i]] != true){
                            set.add(j+nums[i]);
                        }
                        dp[j+nums[i]] = true;

                    }
                }
                dp[nums[i]]=true;
                set.clear();
            }
        }
        return dp[sum/2];
    }
}
