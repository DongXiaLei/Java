package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/12 16:35
 */
public class LC152 {
    public static void main(String[] args){
        int[] nums = {-2,0,-1,-3};
        System.out.println(maxProduct(nums));
    }
    //dp[i] = max(nums[i] * pre_max, nums[i] * pre_min, nums[i]),
    public static int maxProduct(int[] nums){
        if(nums.length == 0 )return 0;
        int ans = nums[0];
        int pre_min = nums[0];
        int pre_max = nums[0];
        for(int i=1;i<nums.length;i++){
            int cur_min = Math.min(nums[i]*pre_min,Math.min(nums[i]*pre_max,nums[i]));
            int cur_max = Math.max(nums[i]*pre_min,Math.max(nums[i]*pre_max,nums[i]));
            ans = Math.max(cur_max,ans);
            pre_min = cur_min;
            pre_max = cur_max;
        }
        return ans;
    }

}
/*
*
*   //时间复杂度为 n^3
    public static int maxProduct(int[] nums) {
        int n= nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i = n;i>=1 ;i--){
            for(int j=0;j<=n-i;j++){
                int tmp =maxProCore(nums,j,j+i);
                if(ans<tmp) ans = tmp;
            }
        }
        return ans;
    }
    public static int maxProCore(int[] nums ,int begin,int end){
        int ans =1;
        for(int i =begin;i<end;i++){
            ans *= nums[i];
        }
        return ans;
    }
*
* */