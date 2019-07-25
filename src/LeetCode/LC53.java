package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 15:53
 */
public class LC53 {
    public static int maxSubArray(int[] nums) {
        if(nums.length<=0)return 0;
        int ans =nums[0],tmp=nums[0];
        for(int i =1 ;i<nums.length;i++){
            if(tmp<0){
                tmp = nums[i];
            }else {
                tmp += nums[i];
            }
            if(ans<tmp){
                ans =tmp;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums ={-2,-1,-2};
        maxSubArray(nums);
    }
}
