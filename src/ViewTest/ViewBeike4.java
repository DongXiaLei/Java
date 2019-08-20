package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 12:24
 */
public class ViewBeike4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] S= {0,1,2,5,10,20,50};
        int[][] dp = new int[S.length][n+1];
        for(int i=0;i<S.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=n;j++)
            dp[0][j] = 0;
        dp[1][1] = 1;
        for(int i =1;i<S.length;i++){
            for(int j =1;j<=n;j++){
                if(j-S[i]>=0){
                    dp[i][j] = dp[i][j-S[i]]+1;
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[S.length-1][n]);
    }
}
