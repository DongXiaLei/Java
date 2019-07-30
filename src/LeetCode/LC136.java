package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 15:50
 */
public class LC136 {
    public static int singleNumber(int[] nums) {
        if(nums.length==1)return nums[0];
        int ans = nums[0];
        for(int i =1;i<nums.length;i++){
            ans ^= nums[i];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums= {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
