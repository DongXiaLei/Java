package LeetCode;

import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/20 15:53
 */
public class LC581 {
    public static void main(String[] args){
        int[] nums = {2,6,4,8,10,9,13};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length<=0)return 0;
        int[] nums2 = nums.clone();
        int ans =0;
        Arrays.sort(nums2);
        for(int i =0;i<nums.length;i++){
            if(nums[i] == nums2[i]){
                ans++;
            }else {
                break;
            }
        }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j] == nums2[j]){
                ans ++ ;
            }else {
                break;
            }
        }
        return ans>nums.length ? 0:nums.length-ans;

    }
}
