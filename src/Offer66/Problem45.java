package Offer66;

import java.util.Arrays;

public class Problem45 {
    public static void main(String[] args){
        System.out.println("Problem 45");
        int [] arrays = {3,32,321,3210};
        System.out.println(PrintMinNumber(arrays));
    }
    public static String PrintMinNumber(int [] numbers){
        String[] nums = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));//排序，s1+s2与s2+s1两个字符串比较，谁小谁放前面 jdk 8

        String ans = "";
        for(String str:nums){
            ans += str;
        }
        return ans;
    }
}
