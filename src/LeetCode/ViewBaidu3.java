package LeetCode;

import java.util.Scanner;

public class ViewBaidu3 {
    static int[] nums = new int[26];
    static int[][] charOfnums = new int[26][2];//分别表示每个字母在开头的数量和结尾的数量
    public static void main(String[] args){
        for(int i =0;i<nums.length;i++){
            nums[i] = -1;
            charOfnums[i][0] = 0;
            charOfnums[i][1] = 0;
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String [] strings = new String[n];
        for(int i=0;i<n;i++){
            strings[i] = in.next();
        }
        System.out.println(isCircle(strings));

    }
    public static boolean isCircle(String[] strings){
        for(String string :strings){
            int begin = string.charAt(0)-'a';
            int end = string.charAt(string.length()-1)-'a';
            charOfnums[begin][0]++;
            charOfnums[end][1]++;
            union(begin,end);
        }
        int root = find(0);
        for(int i=0;i<nums.length;i++){
            int nums =charOfnums[i][0]+charOfnums[i][1];
            if(nums %2 == 1 || charOfnums[i][0]!=charOfnums[i][1])return false;
            else if(nums>=2){
                if( root != find(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean union(int k1,int k2 ){
        int root1 = find(k1);
        int root2 = find(k2);
        if(root1!= root2){
            nums[root1] = root2;
            return true;
        }else return false;
    }
    public static int find(int k){
        int i =k;
        while (nums[i]!=-1 && i != nums[i]) i = nums[i];
        return i;
    }

}
