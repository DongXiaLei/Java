package LeetCode;

import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/14 21:34
 */
public class LC1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] num = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            num[i] = nums[i];
        }
        Arrays.sort(num);
        int [] ans = new int[2];
        int begin =0;int end = num.length-1;
        while(begin<end){
            if(num[begin]+num[end] == target ){
                ans[0] = begin;ans[1] = end;
                break;
            }
            else if(num[begin]+num[end]<=target){
                begin++;
            }
            else {
                end--;
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]==num[begin]){
                ans[0] = i;
                break;
            }
        }
        for(int j =nums.length-1;j>=0;j--){
            if(nums[j]==num[end]){
                ans[1] = j;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int [] arrays ={3,2,3,4,5};
        System.out.println(Arrays.toString(twoSum(arrays,5)));
    }
}
