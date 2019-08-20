package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 20:53
 */
public class LC283 {
    public static void main(String[] args){
        int [] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int count =0;
        for(int ele :nums){
            if(ele == 0 ){
                count++;
            }
        }
        int begin =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[begin] =nums[i];
                begin++;
            }
        }
        for(int i=nums.length-count;i<nums.length;i++){
            nums[i] =0;
        }
    }
}
