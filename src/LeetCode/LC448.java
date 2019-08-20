package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/19 16:44
 */
public class LC448 {
    public static void main(String[] args){
        int[] nums ={4,3,2,7,7,2,3,1};
        findDisappearedNumbers(nums);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer > ans=  new ArrayList<>();
        if(nums.length<=0) return ans;
        for(int i=0;i<nums.length;i++){
            int index = (nums[i]-1) % nums.length;
            nums[index] += nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=nums.length){
                ans.add(i+1);
            }
        }
        return ans;
    }

}
