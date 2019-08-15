package LeetCode;

import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 21:19
 */
public class LC287 {
    public static void main(String[] args){
        int[] nums ={1,3,4,2,2};
        findDuplicate(nums);
    }
    public static int findDuplicate(int[] nums) {
        if(nums.length<=0)return 0;
        int p1 = nums[0];
        int p2 = nums[0];
        do{
            p1 = nums[p1];
            p2 = nums[ nums[p2] ];
        }while (p1!=p2);
        p1 = nums[0];
        while (p1!=p2){
            p1 = nums[ p1];
            p2 = nums[ p2];
        }
        return p2;
    }
}
