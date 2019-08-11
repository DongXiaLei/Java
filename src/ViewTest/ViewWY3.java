package ViewTest;

import java.util.Scanner;

public class ViewWY3 {
    public  static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<1)return;
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = in.nextInt();
        }
        String[] strings = new String[n];
        for(int i =0;i<n;i++){
            strings[i] = String.valueOf(nums[i]);
        }
        findMinSort(strings,nums);
    }
    public static void findMinSort(String[] strings,int [] nums){
        int n = strings.length;
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                if(compare(strings[i],strings[j]) && (nums[i]+nums[j])%2 == 1){
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;

                    int t = nums[i];
                    nums[i] =nums[j];
                    nums[j] = t;
                }
            }
        }
        for(int ele:nums){
            System.out.print(ele+" ");
        }
    }
    public static boolean compare(String s1,String s2){
        int flag = s1.compareTo(s2);
        if(flag>0)return true;

        else return false;
    }
}

/*
* 10
53941 38641 31525 75864 29026 12199 83522 58200 64784 80987
*
* 12199 29026 31525 38641 53941 58200 64784 75864 80987 83522
*
* 4
7 3 5 1
*
* 7 3 5 1
* */