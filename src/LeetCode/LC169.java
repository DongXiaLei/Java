package LeetCode;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 13:02
 */
/*
7
2 2 1 1 1 2 2
* */
public class LC169 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        if(n<=0)return;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int count_a =1,a=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] == a ){
                count_a ++ ;
            }else {
                if(count_a>0){
                    count_a--;
                }else {
                    count_a = 1;
                    a = nums[i];
                }
            }
        }
        return a;
    }
}
