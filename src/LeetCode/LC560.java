package LeetCode;

import java.util.HashMap;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/20 15:23
 */
public class LC560 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        subarraySum(nums,5);
    }
    public  static int subarraySum(int[] nums, int k) {
        if(nums.length<=0)return 0;
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=1;i<nums.length+1;i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        int ans =0;
        // n ^2
        for(int i=0;i<sum.length-1;i++){
            for(int j=i+1;j<sum.length;j++){
                if(sum[j]-sum[i] == k){
                    ans  ++;
                }
            }
        }
        // n
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<sum.length;i++){
            if(map.containsKey(sum[i]- k )){
                ans += map.get(sum[i]-k);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);//如果sum[i]对应的值不存在 则置为1 存在则加一
        }

        return ans;
    }
}
