package ViewTest;

import java.util.Scanner;

public class ViewBeikeB5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] w = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                w[i][j] = in.nextInt();
            }
        }
        System.out.println(findMaxRoute(w));
    }
    /*
    * 3
1 1 0
0 1 0
0 1 1
    * */
    public static int findMaxRoute(int[][] w){
        int rows = w.length;
        int cols = w[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = w[0][0];
        for(int i =1;i<rows;i++){
            dp[i][0] = w[i][0]+dp[i-1][0];
        }
        for(int j=1;j<cols;j++){
            dp[0][j] = w[0][j] +dp[0][j-1];
        }
        for(int i =1;i<rows;i++){
            for(int j=1;j<cols;j++){
                int up = dp[i-1][j] + w[i][j];
                int left = dp[i][j-1] + w[i][j];
                dp[i][j] = Math.max(up,left);
            }
        }
        return dp[rows-1][cols-1];
    }
}
