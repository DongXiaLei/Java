package ViewTest;

import java.util.Arrays;
import java.util.Scanner;

public class ViewWY2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = in.nextInt();
        }
        while ((t--)!=0){
            isCircle(nums);
        }

    }
    public static void isCircle(int[] nums){
        Arrays.sort(nums);
        /*
        * 排序后只需考虑后三个和第一个数比较即可
        *
        * */
        int n = nums.length; // n>=3
        if((nums[0]+nums[n-2])>nums[n-1]){
            System.out.println("YES");
        }
        else {
            if(n==3){
                System.out.println("NO");
            }
            else if(n>3){
                if((nums[n-2]+nums[n-3])>nums[n-1]){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
}
