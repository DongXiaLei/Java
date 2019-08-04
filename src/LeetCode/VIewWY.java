package LeetCode;

import java.util.Scanner;

public class VIewWY {
    public static void main(String[] args){
        int n ,q;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if(n<=0)return;
        int[] a = new int[n];
        for(int i =0;i<n;i++){
            a[i] = in.nextInt();
        }
        double[] ans  = new double[n];
        for(int i =0;i<n;i++){
            int tmp  =0;
            for(int j =0;j<n;j++){
                if(a[j]<=a[i]){
                    tmp ++;
                }
            }
            ans[i] = ( (double) tmp -1.0)/ (double) n;
        }


        q = in.nextInt();
        while ((q--)!=0){
            int index =in.nextInt();
            if(index>n)return;
            //ans[index-1] += 0.0000005 ;
            ans[index-1] *= 100;
            System.out.printf("%6f",ans[index-1]);
            System.out.println();
        }
    }
}
