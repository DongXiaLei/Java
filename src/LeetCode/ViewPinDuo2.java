package LeetCode;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/2 16:27
 */
public class ViewPinDuo2 {
    public static void main(String[] agrs){
        Scanner in   = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String [] strings = new String[n];
        for(int i= 0;i<n;i++){
            strings[i] = in.next();
        }

        return;
    }
    public static boolean makeCircle(String[] strings){
        return false;
    }
    public static boolean Union(int a, int b) {
        int ancesterA = Find(a), ancesterB = Find(b);
        if (ancesterA == ancesterB) return false; // need not to union.
        else {
            nums[ancesterB] = ancesterA;
            return true;
        }
    }
    public static int Find(int k) {
        int i = k;
        while (i != nums[i]) i = nums[i]; //Here i is the root.
        return i;
    }
    static int[] nums = new int[100];
}
