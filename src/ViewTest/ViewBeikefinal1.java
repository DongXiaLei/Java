package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/11 20:29
 */
public class ViewBeikefinal1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=1)return;
        long [] nums = new long[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextLong();
        }
        int ansl=0,ansr=1;    // answerleft anwserright
        long sum = Long.MAX_VALUE;
        for(int i=1;i<n;i++){
            long tmp = Math.abs(nums[i]-nums[i-1]);
            if(tmp<sum){
                sum = tmp;
                ansl = i-1;
                ansr = i ;
            }
        }
        System.out.println(nums[ansl]+" "+nums[ansr]);
    }
}
